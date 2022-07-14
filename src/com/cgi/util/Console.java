package com.cgi.util;

import java.math.BigDecimal;

public class Console {
    String name;
    String category;
    BigDecimal msrp;

    public Console(String name, String category, BigDecimal msrp) {
        this.name = name;
        this.category = category;
        this.msrp = msrp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getMsrp() {
        return msrp;
    }

    public void setMsrp(BigDecimal msrp) {
        this.msrp = msrp;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-20s$%.2f", category, name, msrp);
    }
}

