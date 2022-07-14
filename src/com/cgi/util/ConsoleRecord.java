package com.cgi.util;

import java.math.BigDecimal;

public record ConsoleRecord(String name, String category, BigDecimal msrp) {
    @Override
    public String toString() {
        return String.format("%-15s%-20s$%.2f", category, name, msrp);
    }
}
