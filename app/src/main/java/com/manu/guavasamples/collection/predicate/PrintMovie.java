package com.manu.guavasamples.collection.predicate;

import java.util.function.Consumer;

/**
 * Created by manu on 3/27/2018.
 */

public class PrintMovie implements Consumer {
    public void accept(Movie movie) {
        System.out.println(movie);
    }

    @Override
    public void accept(Object o) {

    }
}