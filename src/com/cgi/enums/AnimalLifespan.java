package com.cgi.enums;

public enum AnimalLifespan {
    CAT(20), DOG(15), TURTLE(120), CHICKEN(3);

    private final int lifeSpan;

    AnimalLifespan(int lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public int getLifeSpan() {
        return lifeSpan;
    }
}
