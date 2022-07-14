package com.cgi.streams.parallel;

import java.util.List;
import java.util.stream.Stream;

public class ParallelMain {
    public static void main(String[] args) {
        List<Long> numbers = Stream.iterate(0L, n -> n < 111111111, n -> n + 1).toList();

        System.out.println("Reduction using normal stream");
        long start = System.currentTimeMillis();
        long total = numbers.stream().reduce(0L, (sum, next) -> sum += next);
        long stop = System.currentTimeMillis();
        System.out.println("\tTotal Normal: " + total);
        System.out.println("\tTime Normal: " + (stop - start) / 1000f + "s");

        System.out.println("\nReduction using parallel stream");
        long start1 = System.currentTimeMillis();
        long total1 = numbers.parallelStream().reduce(0L, (sum, next) -> sum += next);
        long stop1 = System.currentTimeMillis();
        System.out.println("\tTotal Parallel: " + total1);
        System.out.println("\tTime Parallel: " + (stop1 - start1) / 1000f + "s");

        System.out.println("\nReduction using stream.parallel");
        long start2 = System.currentTimeMillis();
        long total2 = numbers.stream().parallel().reduce(0L, (sum, next) -> sum += next, Long::sum);
        long stop2 = System.currentTimeMillis();
        System.out.println("\tTotal Parallel: " + total2);
        System.out.println("\tTime Parallel: " + (stop2 - start2) / 1000f + "s");
    }
}
