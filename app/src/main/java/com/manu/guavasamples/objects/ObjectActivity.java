package com.manu.guavasamples.objects;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.manu.guavasamples.R;

/**
 * Created by manu on 3/27/2018.
 */

public class ObjectActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);
        example1();
        objects_equals();
        first_non_null();

    }

    private void example1(){
        Student s1 = new Student("Mahesh", "Parashar", 1, "VI");
        Student s2 = new Student("Suresh", null, 3, null);

        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(
                MoreObjects.toStringHelper(s1)
                        .add("Name",s1.getFirstName()+" " + s1.getLastName())
                        .add("Class", s1.getClassName())
                        .add("Roll No", s1.getRollNo())
                        .toString());

        System.out.println(
                MoreObjects.toStringHelper(s2)
                        .add("Name",s1.getFirstName()+" " + s1.getLastName())
                        .add("Class", s1.getClassName())
                        .add("Roll No", s1.getRollNo())
                        .toString());
    }

    public void objects_equals () {

        String value1 = "Ice cold beer fest";
        String value2 = "Ice cold beer fest 2013";

        boolean objectEqual = Objects.equal(value1, value2);
        System.out.println(objectEqual);
    }

    public void first_non_null () {

        String first = null;
        String second = "What's shakin' bacon?";

        String firstNullObject = MoreObjects.firstNonNull(first, second);

        System.out.println(firstNullObject);
    }
}
