package com.cgi.streams.grouping;

import com.cgi.util.Console;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.cgi.util.Data.consolesMsrp;

public class GroupingMain {
    public static void main(String[] args) {
        // GROUPING
        Map<String, List<Console>> consolesByCategory = consolesMsrp.stream()
                .collect(Collectors.groupingBy(Console::getCategory));

        System.out.println("Group Consoles by category");
        consolesByCategory.forEach((category, consoles) -> {
            System.out.println("\t" + category.toUpperCase() + ": ");
            for (Console console : consoles) {
                System.out.println("\t\t" + console);
            }
        });

        Map<String, List<String>> consoleNameByCategory = consolesMsrp.stream()
                .collect(Collectors.groupingBy(Console::getCategory, Collectors.mapping(Console::getName, Collectors.toList())));

        System.out.println("\nGroup Consoles names by category");
        consoleNameByCategory.forEach((category, list) -> System.out.println("\t" + category.toUpperCase() + ": " + list));

        // PARTITIONING
        BigDecimal priceLimit = new BigDecimal("150");
        Map<Boolean, List<Console>> partitionedConsoles = consolesMsrp.stream()
                .collect(Collectors.partitioningBy(consoles -> consoles.getMsrp().compareTo(priceLimit) < 0));

        System.out.println("\nPartition consoles under 150$");
        partitionedConsoles.get(true).forEach(System.out::println);

        System.out.println("\nPartition consoles over 150$");
        partitionedConsoles.get(false).forEach(System.out::println);
    }
}
