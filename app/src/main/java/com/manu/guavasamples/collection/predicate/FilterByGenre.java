package com.manu.guavasamples.collection.predicate;

import com.google.common.base.Predicate;

/**
 * Created by manu on 3/27/2018.
 */

public enum FilterByGenre implements Predicate {

    DRAMA(Genre.DRAMA),
    THRILLER(Genre.THRILLER),
    ROMANTIC(Genre.ROMANTIC),
    ACTION(Genre.ACTION),
    HORROR(Genre.HORROR);

    FilterByGenre(Genre genre) {
        this.genre = genre;
    }
    @Override
    public boolean apply(Object input) {
        return false;
    }
    private Genre genre;
}