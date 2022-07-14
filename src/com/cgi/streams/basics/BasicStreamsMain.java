package com.cgi.streams.basics;

import java.math.BigInteger;
import java.util.UUID;
import java.util.stream.Stream;

import static com.cgi.util.Data.consoles;

public class BasicStreamsMain {

    public static void main(String[] args) {
        // Generate infinite stream of UUID
        Stream<UUID> uuids = Stream.generate(UUID::randomUUID);
        System.out.println("Random UUID");
        uuids.limit(10).forEach(System.out::println);

        // Generate stream of characters *these 3 parameters read like a for loop (start, condition, increment)
        Stream<Character>  alphabet = Stream.iterate('A', letter -> letter <= 'Z', letter -> (char) (letter + 1));
        System.out.println("\nAlphabet");
        alphabet.forEach(System.out::println);

        // Generate stream of powers of two
        Stream<BigInteger> powersOfTwo = Stream.iterate(BigInteger.ONE, n -> n.multiply(BigInteger.TWO));
        System.out.println("\nPowers of Two");
        powersOfTwo.limit(5).forEach(System.out::println);

        // Generate nintendo stream
        Stream<String> nintendos = consoles.stream().filter(c -> c.contains("Nintendo"));
        System.out.println("\nNintendos");
        nintendos.forEach(System.out::println);
    }
}
