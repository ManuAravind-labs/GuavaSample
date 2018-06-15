package com.manu.guavasamples.model;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by manu on 3/27/2018.
 */

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        checkNotNull(name, "name cannot be null");
        checkArgument(age > 0, "age should be positive number");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        checkNotNull(name, "name cannot be null");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        checkArgument(age > 0, "age should be positive number");
        this.age = age;
    }

}
