package com.cgi.functionalinterface;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> consoles = List.of("Super Nintendo", "Playstation", "Nintendo", "Nintendo 64", "Playstation 2", "Xbox", "Neo Geo", "Playstation 3", "Nintendo Switch");

        /// using lambda expression and stream
        Predicate<String> findNintendos = (String val) -> val.contains("Nintendo");

        System.out.println("Find Nintendos");
        consoles.stream()
                .filter(findNintendos)
                .forEach(System.out::println);


        /// using @FunctionalInterface
        // define the getPlaystation method
        Playstation p = (String val) -> val.contains("Playstation");

        System.out.println("\nFind Playstations");
        for (String console : consoles)
            if (p.findConsoles(console))
                System.out.println(console);


        // redefine the method
        p = (String val) -> val.startsWith("Neo");

        System.out.println("\nFind Neo Geo");
        for (String console : consoles)
            if (p.findConsoles(console))
                System.out.println(console);

    }

    // FunctionalInterface can only have one abstract method
    @FunctionalInterface
    public interface Playstation {
        boolean findConsoles(String val);
    }
}

