package com.cgi.enums;

import java.util.List;

import static com.cgi.enums.AnimalLifespan.*;
import static java.util.List.of;

public class EnumMain {
    public static void main(String[] args) {
        List<Animal> animals = of(
                new Animal("Cat", CAT.getLifeSpan()),
                new Animal("Dog", DOG.getLifeSpan()),
                new Animal("Chicken", CHICKEN.getLifeSpan()),
                new Animal("Turtle", TURTLE.getLifeSpan())
        );

        for (Animal animal: animals) {
            System.out.println(animal);
        }
    }
}
