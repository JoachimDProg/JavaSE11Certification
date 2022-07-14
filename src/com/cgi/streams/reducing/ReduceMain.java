package com.cgi.streams.reducing;

import com.cgi.util.Console;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

import static com.cgi.util.Data.consolesMsrp;
import static com.cgi.util.Data.consolesMsrpR;

public class ReduceMain {
    public static void main(String[] args) {
        // Generate stream of powers of two with reduction and mapping
        Stream<BigInteger> powersOfTwo = Stream.iterate(BigInteger.ONE, n -> n.multiply(BigInteger.TWO));
        System.out.println("Powers of Two");
        powersOfTwo.limit(5)
                .map(n -> n.toString().concat(" "))
                .reduce(String::concat)
                .ifPresentOrElse(System.out::println, () -> System.out.println("No powers"));

        // Get consoles total price using an optional with a reduce operation which
        // maps the prices first then add the elements
        Optional<BigDecimal> consolePrices = consolesMsrp.stream()
                .map(Console::getMsrp)
                .reduce(BigDecimal::add);
        consolePrices.ifPresent(
                total -> System.out.printf("\nTotal Value of Consoles: $%.2f", total)
        );

        // Get consoles total prices using reduce which maps the prices first then accumulates
        // the prices into a value which has the initial value of the identity
        BigDecimal total2 = consolesMsrp.stream()
                .map(Console::getMsrp)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.printf("\nTotal Value of Consoles: $%.2f", total2);

        // Get consoles total price using reduce which accumulates the prices
        // into a value which has the initial value of the identity
        // The combiner function serves to merge the accumulators results together
        BigDecimal total3 = consolesMsrp.stream()
                .reduce(BigDecimal.ZERO, (result, console) -> result.add(console.getMsrp()), BigDecimal::add);
        System.out.printf("\nTotal Value of Consoles: $%.2f", total3);


        // Example to show that collecting elements to a mutable container using a reduce operation is not really efficient
        // A new list is created, and we need to create a new list at each step for not mutating the previous one
        // All the elements are copied into a new list each time which is not efficient for this case
        // The best practice would be to use the collect methods instead
        ArrayList<String> consoleNames = consolesMsrp.stream().reduce(
                new ArrayList<>(),
                (list, console) -> {
                    ArrayList<String> newList = new ArrayList<>(list);
                    newList.add(console.getName());
                    return newList;
                },
                (list1, list2) -> {
                    ArrayList<String> newList = new ArrayList<>(list1);
                    newList.addAll(list2);
                    return newList;
                }
        );
        System.out.println("\nCONSOLE NAME LIST: " + consoleNames);

        // Example to show that when using a mutable container, it is best to use collect()
        // A new list is created, then the accumulator takes the list and add all elements are added to it
        // Then the combiner merges all the intermediate list from the accumulator
        ArrayList<String> consoleNames2 = consolesMsrpR.stream().collect( // use of the record list
                ArrayList::new,
                (list, console) -> list.add(console.name()),
                ArrayList::addAll
        );
        System.out.println("CONSOLE NAME LIST 2: " + consoleNames2);
    }
}
