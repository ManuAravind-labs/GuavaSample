package com.manu.guavasamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.common.base.Preconditions;
import com.manu.guavasamples.model.Person;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkElementIndex;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkPositionIndex;
import static com.google.common.base.Preconditions.checkState;

/**
 * Created by manu on 3/27/2018.
 */

public class PreConditionaClassActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precondition);
        Log.e("Example1 --","--------------");
        example1();
        Log.e("Example2 --","--------------");
        example2();
        Log.e("Example3 --","--------------");
        example3();
    }

    private void example1(){
        try {
            System.out.println(sqrt(-3.0));
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(sum(null,3));
        } catch(NullPointerException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(getValue(6));
        } catch(IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public double sqrt(double input) throws IllegalArgumentException {
        checkArgument(input > 0.0,
                "Illegal Argument passed: Negative value %s.", input);
        return Math.sqrt(input);
    }

    public int sum(Integer a, Integer b) {
        a = checkNotNull(a, "Illegal Argument passed: First parameter is Null.");
        b = checkNotNull(b, "Illegal Argument passed: Second parameter is Null.");

        return a+b;
    }

    public int getValue(int input) {
        int[] data = {1,2,3,4,5};
        checkElementIndex(input,data.length, "Illegal Argument passed: Invalid index.");
        return 0;
    }



    private final boolean initialized = false;

    private void example2(){

        System.out.println("Preconditions.checkNotNull");
        try
        {
            testForNonNullArgument(null);
        }
        catch (NullPointerException npe)
        {
            npe.printStackTrace();
        }

        System.out.println("Preconditions.checkArgument");
        try
        {
            testDivisorNotZero(0);
        }
        catch (IllegalArgumentException illArgEx)
        {
            illArgEx.printStackTrace();
        }

        System.out.println("Preconditions.checkElementIndex");
        try
        {
            testArrayElement(new String[]{"Dustin", "Java"}, 3);
        }
        catch (IndexOutOfBoundsException ioobEx)
        {
            ioobEx.printStackTrace();
        }

        System.out.println("Preconditions.checkPositionIndex");
        try
        {
            testArrayPosition(new String[]{"Dustin", "Java"}, 3);
        }
        catch (IndexOutOfBoundsException ioobEx)
        {
            ioobEx.printStackTrace();
        }

        System.out.println("Preconditions.checkState");
        try
        {
            testState();
        }
        catch (IllegalStateException illStateEx)
        {
            illStateEx.printStackTrace();
        }
    }

    public void testForNonNullArgument(final String parameter)
    {
        final String localParameter = checkNotNull(parameter, "Provided parameter is unacceptably null.");
    }

    public void testDivisorNotZero(final int divisor)
    {
        checkArgument(divisor != 0, "Zero divisor not allowed.");
    }

    public void testArrayElement(final String[] strArray, final int indexNumber)
    {
        final int index = checkElementIndex(indexNumber, strArray.length, "String array index number");
    }

    public void testArrayPosition(final String[] strArray, final int indexNumber)
    {
        final int index = checkPositionIndex(indexNumber, strArray.length, "String array index number");
    }

    public void testState()
    {
        checkState(this.initialized, "Cannot perform action because not initialized.");
    }


    private void example3(){
        Person person = new Person("Greg", -2);
    }

}
