package com.manu.guavasamples.collection.predicate;

/**
 * Created by manu on 3/27/2018.
 */

public class Country {

    private String name;
    private int population;
    private int rank;

    public Country(String name, int population, int rank) {
        this.name = name;
        this.population = population;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getRank() {
        return rank;
    }
}
