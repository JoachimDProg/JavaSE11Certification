package com.cgi.functionalinterface;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.cgi.util.Data.consoles;

public class FunctionalMain {
    public static void main(String[] args) {
        /// using lambda expression and stream
        // using a Predicate
        Predicate<String> findNintendos = val -> val.contains("Nintendo");

        System.out.println("Find Nintendos using a Stream and a Predicate");
        consoles.stream()
                .filter(findNintendos)
                .forEach(System.out::println);


        /// using @FunctionalInterface
        System.out.println("\nFind Playstations using a Functional Interface");
        // define the findConsoles method
        Consoles c = val -> val.contains("Playstation");
        for (String console : consoles)
            if (c.findConsoles(console))
                System.out.println(console);

        // redefine the findConsoles method
        c = val -> val.startsWith("Neo");
        System.out.println("\nFind Neo Geo with redefined Functional Interface");
        for (String console : consoles)
            if (c.findConsoles(console))
                System.out.println(console);


        /// Find Game Boy using a stream and predicates, capitalize the
        /// String and split it into a char[] using functional composition
        Predicate<String> containsBoy = val -> val.contains("Boy");
        System.out.println("\nFind Game Boy using a stream and predicates, capitalize " +
                "the String and split it into a char[] using functional composition");
        consoles.stream()
                .filter(containsBoy)
                .map(capitalizeToCharArray)
                .forEach(System.out::println);


        /// use an Optional with functional style with a Predicate
        System.out.println("\nFind a Sega with an Optional and functional methods");
        findConsoles(consoles, console -> console.contains("Sega"))
                .map(s -> s.substring(5)) // map takes a Function<T, U> (will transform a type into another or similar type
                .ifPresentOrElse(
                        sega -> System.out.println("This Sega is a " + sega),
                        () -> System.out.println("No Sega")
                );


        /// categorise all consoles using
        System.out.println("\nFind Consoles and categorise them");
        Map<String, List<String>> consoleByCategory = new HashMap<>();
        // computeIfAbsent will check is a key already exists for the map, if yes add the value to the key
        // if is does not exist, will create the key and return the new List and add the item to it
        // hence compute if absent, if the value is absent, will compute it and return the result
        for (String console : consoles) {
            if (console.contains("Playstation"))
                consoleByCategory.computeIfAbsent("Playstation", playstation -> new ArrayList<>()).add(console);
            else if (console.contains("Nintendo"))
                consoleByCategory.computeIfAbsent("Nintendo", nintendo -> new ArrayList<>()).add(console);
            else if (console.contains("Boy"))
                consoleByCategory.computeIfAbsent("Game Boy", gameBoy -> new ArrayList<>()).add(console);
            else
                consoleByCategory.computeIfAbsent("Other consoles", other -> new ArrayList<>()).add(console);
        }

        // ** try to order the list in the map by alphabetical order

        // forEach needs a BiConsumer, the category lambda will consume the keys and the list lambda will consume the lists
        consoleByCategory.forEach((category, list) -> {
            System.out.println(category.toUpperCase());
            list.forEach(console -> System.out.println("- " + console));
        });
    }

    // FunctionalInterface can only have one abstract method
    @FunctionalInterface
    public interface Consoles {
        boolean findConsoles(String val);
    }

    // return a single result using an optional
    static Optional<String> findConsoles(List<String> consoles, Predicate<String> predicate) {
        for (String console : consoles)
            if (predicate.test(console))
                return Optional.of(console);
        return Optional.empty();
    }

    // functional composition using multiple Function and merge it into one
    static Function<String, String> toCapital = String::toUpperCase;
    static Function<String, char[]> toCharArray = String::toCharArray;
    static Function<String, char[]> capitalizeToCharArray = toCapital.andThen(toCharArray);
}
