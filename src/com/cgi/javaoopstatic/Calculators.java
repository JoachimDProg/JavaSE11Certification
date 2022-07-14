package com.cgi.javaoopstatic;

public class Calculators {
    // a record replace a DTO or a POJO(Plain Old Java Object) which is in reality just a normal class with
    // a constructor, getter and setters, and override methods
    public record Distance(int x1, int y1, int x2, int y2) {
        public double calculate() {
            return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        }
    }

    public static double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}
