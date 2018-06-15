package com.manu.guavasamples.collection.predicate;

import com.google.common.base.Predicate;

/**
 * Created by manu on 3/27/2018.
 */

public class FilterByRating implements Predicate {

    public static final FilterByRating _8 = new FilterByRating(8);
    private double grade;
    FilterByRating(double grade) {
        this.grade = grade;
    }
    @Override
    public boolean apply(Object input) {
        return false;
    }
}
