package com.manu.guavasamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.common.base.Optional;
import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Strings.emptyToNull;

/**
 * Created by manu on 3/27/2018.
 */

public class OptionalClassActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optional);
        Log.e("Example 1 == >","------------------");
        example1();
        Log.e("Example 2 == >","------------------");
        example2();
        Log.e("Example 3 == >","------------------");
        example3();
        Log.e("Example 4 == >","------------------");
        example4();
        Log.e("Example 5 == >","------------------");
        example5();
        Log.e("Example 6 == >","------------------");
        example6();
    }

    private void example1(){
        Integer value1 =  null;
        Integer value2 =  new Integer(10);

        //Optional.fromNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.fromNullable(value1);

        //Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);

        System.out.println(sum(a,b));
        Log.e("TESTER === > ", ""+sum(a,b));
    }

    private Integer sum(Optional<Integer> a, Optional<Integer> b) {
        //Optional.isPresent - checks the value is present or not
        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Second parameter is present: " + b.isPresent());

        //Optional.or - returns the value if present otherwise returns
        //the default value passed.
        Integer value1 = a.or(new Integer(0));

        //Optional.get - gets the value, value should be present
        Integer value2 = b.get();

        return value1 + value2;
    }

    private void example2(){
        // GOOD
        Optional<List<String>> fromNull = Optional.fromNullable(getList());
        if (fromNull.isPresent()) {
            // do something
            System.out.println("not null");
        } else {
            System.out.println("null");
        }

        // BAD
        if (getList() != null) {
            // do something
        }
    }

    private List<String> getList() {
        return null;
    }


    private void example3(){
        List<String> myList = new ArrayList<>();
        myList.add("Amaury");
        myList.add("Christy");
        myList.add("John");
        myList.add(null);
        myList.add("Bill");
        myList.add("");
        myList.add("Stacy");
        displayValuesUsingJavaNulls(myList);
        displayValuesUsingGuavaOptional(myList);

    }

    private void displayValuesUsingJavaNulls(List<String> myList) {
        System.out.println("-------[ displayValuesUsingJavaNulls ]-------");
        for (String name: myList) {
            if (name == null || name.isEmpty()) {
                System.out.println("Name: Value is empty or not available...");
            } else {
                System.out.println("Name: " + name);
            }
        }
    }

    private void displayValuesUsingGuavaOptional(List<String> myList) {
        System.out.println("-------[ displayValuesUsingGuavaOptional ]-------");
        for (String name: myList) {
            Optional<String> optionalName = Optional.fromNullable(emptyToNull(name));
            System.out.println("Name: " +
                    optionalName.or("Name: Value is empty or not available..."));
        }
    }

    private void example4(){
        HashMap<String, String> myMap = new HashMap<>();

        myMap.put("Amaury", "Valdes");
        myMap.put("Christy", "Smith");
        myMap.put("", "Jackson");
        myMap.put("John", "Angeline");
        myMap.put(null, null);
        myMap.put("Bill", "Stanley");
        myMap.put("Hailey", null);
        myMap.put("Stacy", "Newmann");
        myMap.put("Kimmie", "");

        displayValuesUsingJavaNullsMap(myMap);
        displayValuesUsingGuavaOptionalMap(myMap);
    }

    private void displayValuesUsingJavaNullsMap(HashMap<String, String> myMap) {
        System.out.println("-------[ displayValuesUsingJavaNulls ]-------");
        for (String name : myMap.keySet()) {
            String value = myMap.get(name);
            if (name == null || name.isEmpty()) {
                System.out.print("Key: is empty or not available...");
            } else {
                System.out.print("Key: " + name);
            }
            if (value == null || value.isEmpty()) {
                System.out.println(", Value: is empty or not available...");
            } else {
                System.out.println(", Value: " + value);
            }
        }
    }

    private void displayValuesUsingGuavaOptionalMap(HashMap<String, String> myMap) {
        System.out.println("-------[ displayValuesUsingGuavaOptional ]-------");
        for (String name : myMap.keySet()) {
            Optional<String> optionalKey = Optional.fromNullable(emptyToNull(name));
            Optional<String> optionalValue = Optional.fromNullable(emptyToNull(myMap.get(name)));
            System.out.println("Key: " + optionalKey.or("is empty or not available...")
                    + ", Value: " + optionalValue.or("is empty or not available..."));
        }
    }
    Map<String, String> stateCapitals;
    private void example5(){
        Map<String, String> tempStatesToCapitals = Maps.newHashMap();
        tempStatesToCapitals.put("Alaska", "Juneau");
        tempStatesToCapitals.put("Arkansas", "Little Rock");
        tempStatesToCapitals.put("Colorado", "Denver");
        tempStatesToCapitals.put("Idaho", "Boise");
        tempStatesToCapitals.put("Utah", "Salt Lake City");
        tempStatesToCapitals.put("Wyoming", "Cheyenne");
        stateCapitals = Collections.unmodifiableMap(tempStatesToCapitals);
        display();
    }

    private Optional<String> getStateCapital(final String stateName)
    {
        return Optional.fromNullable(stateCapitals.get(stateName));
    }

    private void display() {
        final String wyoming = "Wyoming";
        final Optional<String> wyomingCapitalWrapper = getStateCapital(wyoming);
        if (wyomingCapitalWrapper.isPresent()) {
            System.out.println("Capital of " + wyoming + " is " + wyomingCapitalWrapper.get());
        }
        System.out.println("Capital of " + wyoming + " is " + wyomingCapitalWrapper.orNull());

        final String northDakota = "North Dakota";
        final Optional<String> northDakotaCapitalWrapper = getStateCapital(northDakota);
        System.out.println("Capital of " + northDakota + " is " + northDakotaCapitalWrapper);
        System.out.println("Capital of " + northDakota + " is " + northDakotaCapitalWrapper.or("Unspecified"));
        System.out.println("Capital of " + northDakota + " is " + northDakotaCapitalWrapper.orNull());

        final Optional<String> nullOptional = getStateCapital(null);
        System.out.println("Capital of null is " + nullOptional);
    }

    private void example6(){

        final BigDecimal dividend = new BigDecimal("5.0");
        final BigDecimal divisor = new BigDecimal("0.0");
        final Optional<BigDecimal> quotientWrapper =getQuotient(dividend, divisor);
        System.out.println(  "Quotient of " + dividend + " / " + divisor + " is "
                + quotientWrapper);
    }

    public Optional<BigDecimal> getQuotient(final BigDecimal dividend, final BigDecimal divisor)
    {
        BigDecimal quotient;
        try
        {
            quotient = dividend.divide(divisor);
        }
        catch (Exception ex)
        {
            quotient = null;
        }
        return Optional.fromNullable(quotient);
    }

    //https://javahowtodoit.wordpress.com/2014/09/12/guava-optional-how-to-use-it/
    //https://idodevjobs.wordpress.com/2014/02/08/google-guava-optional-example/
    //https://avaldes.com/guava-optional-class-example/
    //https://dzone.com/articles/guavas-new-optional-class
    //https://www.tutorialspoint.com/guava/guava_optional_class.htm
    //https://github.com/google/guava/wiki/UsingAndAvoidingNullExplained

}
