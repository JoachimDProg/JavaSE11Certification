package com.cgi.enums;

import com.cgi.functionalinterface.Animal;

import java.util.List;

import static com.cgi.functionalinterface.AnimalLifespan.*;
import static java.util.List.of;

public class Main {
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
