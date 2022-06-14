package com.cgi.functionalinterface;

public class Animal {

    String name;
    int lifeSpan;

    public Animal(String name, int lifeSpan) {
        this.name = name;
        this.lifeSpan = lifeSpan;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", lifeSpan=" + lifeSpan +
                '}';
    }
}
