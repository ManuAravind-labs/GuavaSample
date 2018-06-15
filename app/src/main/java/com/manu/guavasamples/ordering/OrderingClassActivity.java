package com.manu.guavasamples.ordering;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import com.manu.guavasamples.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by manu on 3/27/2018.
 */

public class OrderingClassActivity extends AppCompatActivity {

    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering);
        Log.e("Example1 --","--------------");
        example1();
        Log.e("order_list_of_integer_greatest_to_least --","--------------");
        order_list_of_integer_greatest_to_least();
        Log.e("order_list_of_integer_least_to_greatest --","--------------");
        order_list_of_integer_least_to_greatest();
        Log.e("is_list_of_numbers_sorted_in_java_with_guava --","--------------");
        is_list_of_numbers_sorted_in_java_with_guava();
        Log.e("naturalSorting --","--------------");
        naturalSorting();
        Log.e("reverseSorting --","--------------");
        reverseSorting();
        Log.e("chainingToOrder --","--------------");
        chainingToOrder();
        Log.e("isStrictlyOrdered --","--------------");
        isStrictlyOrdered();

        Log.e("order_list_of_strings_alphabetically_case_insensitive --","--------------");
        order_list_of_strings_alphabetically_case_insensitive();


        example2();

        order_elements_based_on_length();

        reverse_elements_in_list();


        is_list_of_strings_sorted_in_java_with_guava();

        is_list_of_strings_sorted_case_insensitive_in_java_with_guava();

        order_by_object_field();

        customOrderStringsbylength();
        checkingExplicitOrder();
        secondaryOrdering();
        complexCustomOrderingwithChaining();

        sortUsingToString();
        binarySearchImpl();
        findMinWithoutSort();
        creatingSortedCopy();
        creatingSortedPartialCopy();
        orderingViaIntermediaryFunction();
    }

    private void example1(){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(new Integer(5));
        numbers.add(new Integer(2));
        numbers.add(new Integer(15));
        numbers.add(new Integer(51));
        numbers.add(new Integer(53));
        numbers.add(new Integer(35));
        numbers.add(new Integer(45));
        numbers.add(new Integer(32));
        numbers.add(new Integer(43));
        numbers.add(new Integer(16));

        Ordering ordering = Ordering.natural();
        System.out.println("Input List: ");
        System.out.println(numbers);

        Collections.sort(numbers,ordering );
        System.out.println("Sorted List: ");
        System.out.println(numbers);


        System.out.println("======================");
        System.out.println("List is sorted: " + ordering.isOrdered(numbers));
        System.out.println("Minimum: " + ordering.min(numbers));
        System.out.println("Maximum: " + ordering.max(numbers));

        Collections.sort(numbers,ordering.reverse());
        System.out.println("Reverse: " + numbers);

        numbers.add(null);
        System.out.println("Null added to Sorted List: ");
        System.out.println(numbers);

        Collections.sort(numbers,ordering.nullsFirst());
        System.out.println("Null first Sorted List: ");
        System.out.println(numbers);
        System.out.println("======================");

        Collections.sort(numbers,ordering.nullsLast());
        System.out.println("Null Last Sorted List: ");
        System.out.println(numbers);
        System.out.println("======================");
    }

    public void order_list_of_integer_least_to_greatest () {

        List<Integer> startingLineUp = Lists.newArrayList(
                73, 58, 66, 57, 32, 88, 90, 12, 15, 99, 11
        );

        List<Integer> startingLineUpInOrder = Ordering
                .natural()
                .leastOf(startingLineUp, startingLineUp.size());

        System.out.println(startingLineUpInOrder);

        assertEquals(new Integer(11), startingLineUpInOrder.get(0));
    }

    public void order_list_of_integer_greatest_to_least () {

        List<Integer> startingLineUp = Lists.newArrayList(
                73, 58, 66, 57, 32, 88, 90, 12, 15, 99, 11
        );

        List<Integer> startingLineUpGreatestToLeast = Ordering
                .natural()
                .greatestOf(startingLineUp, startingLineUp.size());

        System.out.println(startingLineUpGreatestToLeast);

        assertEquals(new Integer(99), startingLineUpGreatestToLeast.get(0));
    }

    public void is_list_of_numbers_sorted_in_java_with_guava () {

        List<Integer> uwConferenceTitles = Lists.newArrayList(
                1896, 1897, 1901, 1906, 1912,
                1952, 1959, 1962, 1993, 1998,
                1999, 2010, 2011, 2012);

        boolean isSorted = Ordering
                .natural()
                .isOrdered(uwConferenceTitles);

        System.out.println(isSorted);
        assertTrue(isSorted);
    }


    private void naturalSorting(){
        List<Integer> toSort = Arrays.asList(3, 5, 4, 1, 2);
        System.out.println(toSort);
        Collections.sort(toSort, Ordering.natural());
        System.out.println(toSort);
        System.out.println(Ordering.natural().isOrdered(toSort));


    }

    private void reverseSorting(){
        List<Integer> toSort = Arrays.asList(3, 5, 4,  1, 2);
        System.out.println(toSort);
        Collections.sort(toSort, Ordering.natural().reverse());
        System.out.println(toSort);
    }


    private void chainingToOrder(){
        List<Integer> toSort = Arrays.asList(3, 5, 4, 1, 2);
        System.out.println(toSort);
        Collections.sort(toSort, Ordering.natural().reverse());
        System.out.println(toSort);
    }

    private void isStrictlyOrdered(){
        List<Integer> toSort = Arrays.asList(3, 5, 4, 2, 1, 2);
        Collections.sort(toSort, Ordering.natural());
        System.out.println(Ordering.natural().isStrictlyOrdered(toSort));

    }

    private void order_list_of_strings_alphabetically_case_insensitive (){
        List<String> TOP_RATED_CENTERS = Lists.newArrayList(
                "Gatski", "Langer", "Hein",
                "Frankie Baggadonuts","Dawson", "Turner", "Trafton",
                "Stephenson", "Ringo", "Otto", "Webster");
        System.out.println(TOP_RATED_CENTERS);
        String topNameAlphabetically = Ordering
                .from(String.CASE_INSENSITIVE_ORDER)
                .min(TOP_RATED_CENTERS);
        System.out.println(topNameAlphabetically);

    }

    private void example2(){
        List<String> names = new ArrayList<String>();

        names.add("Ram");
        names.add("Shyam");
        names.add("Mohan");
        names.add("Sohan");
        names.add("Ramesh");
        names.add("Suresh");
        names.add("Naresh");
        names.add("Mahesh");
        names.add(null);
        names.add("Vikas");
        names.add("Deepak");

        System.out.println("Another List: ");
        System.out.println(names);
        Ordering ordering = Ordering.natural();
        Collections.sort(names,ordering.nullsFirst().reverse());
        System.out.println("Null first then reverse sorted list: ");
        System.out.println(names);
    }
    public void order_elements_based_on_length () {

        Ordering<String> byLength = new Ordering<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Ints.compare(s1.length(), s2.length());
            }
        };

        List<String> famousBridges = Lists.newArrayList(
                "Great Belt Bridge",
                "Chapel Bridge",
                "Chengyang Bridge",
                "null",
                "Brooklyn Bridge",
                "Ponte Vecchio"
        );

        Collections.sort(famousBridges,
                byLength.nullsFirst());


        System.out.println(famousBridges);

    }

    public void reverse_elements_in_list () {

        Ordering<String> byLength = new Ordering<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Ints.compare(s1.length(), s2.length());
            }
        };

        List<String> famousBridges = Lists.newArrayList(
                "Great Belt Bridge",
                "Chapel Bridge",
                "Chengyang Bridge",
                "null",
                "Brooklyn Bridge",
                "Ponte Vecchio"
        );

        Collections.sort(famousBridges,
                byLength.nullsFirst().reverse());

        System.out.println(famousBridges);
    }
    public void is_list_of_strings_sorted_in_java_with_guava () {

        List<String> secConferenceEast = Lists.newArrayList(
                "Florida",
                "Georgia",
                "Missouri",
                "South Carolina",
                "Tennessee",
                "Vanderbilt");

        boolean isSorted = Ordering
                .natural()
                .isOrdered(secConferenceEast);
        System.out.println(isSorted);
    }
    public void is_list_of_strings_sorted_case_insensitive_in_java_with_guava () {

        List<String> secConferenceEast = Lists.newArrayList(
                "alabama",
                "Alabama",
                "ALABAMA");

        boolean isSorted = Ordering
                .from(String.CASE_INSENSITIVE_ORDER)
                .isOrdered(secConferenceEast);

        System.out.println(isSorted);
    }

    public void order_by_object_field () {

        List<GlassWare> beerGlasses = Lists.newArrayList(
                new GlassWare("Flute Glass", "Enhances and showcases..."),
                new GlassWare("Pilsner Glass (or Pokal)", "showcases color, ..."),
                new GlassWare("Pint Glass", "cheap to make..."),
                new GlassWare("Goblet (or Chalice)", "Eye candy..."),
                new GlassWare("Mug (or Seidel, Stein)", "Easy to drink..."),
                new GlassWare(null, null)
        );

        Ordering<GlassWare> byGlassWareName = Ordering.natural().nullsFirst()
                .onResultOf(new Function<GlassWare, String>() {
                    public String apply(GlassWare glassWare) {
                        return glassWare.getName();
                    }
                });

        GlassWare firstBeerGlass = byGlassWareName.min(beerGlasses);

        // first element will be null
        System.out.println(firstBeerGlass.getName());

        GlassWare lastBeerGlass = byGlassWareName.max(beerGlasses);
        System.out.println(lastBeerGlass.getName());

    }


    @SuppressLint("LongLogTag")
    private void customOrderStringsbylength(){
        Log.e("customOrderStringsbylength","---------------");
         class OrderingByLenght extends Ordering<String> {
            @Override
            public int compare(String s1, String s2) {
                return Ints.compare(s1.length(), s2.length());
            }
        }
        List<String> toSort = Arrays.asList("zz", "aa", "b", "ccc");
        Ordering<String> byLength = new OrderingByLenght();
        Collections.sort(toSort, byLength);

        Ordering<String> expectedOrder = Ordering.explicit(Lists.newArrayList("b", "zz", "aa", "ccc"));
        System.out.println(expectedOrder.isOrdered(toSort));
    }


    private void checkingExplicitOrder(){
        Log.e("checkingExplicitOrder","---------------");
        class OrderingByLenght extends Ordering<String> {
            @Override
            public int compare(String s1, String s2) {
                return Ints.compare(s1.length(), s2.length());
            }
        }
        List<String> toSort = Arrays.asList("zz", "aa", "b", "ccc");
        Ordering<String> byLength = new OrderingByLenght();
        Collections.sort(toSort, byLength);

        Ordering<String> expectedOrder = Ordering.explicit(Lists.newArrayList("b", "zz", "aa", "ccc"));
        System.out.println(expectedOrder.isOrdered(toSort));
    }
    private void secondaryOrdering(){
        Log.e("secondaryOrdering","---------------");

        class OrderingByLenght extends Ordering<String> {
            @Override
            public int compare(String s1, String s2) {
                return Ints.compare(s1.length(), s2.length());
            }
        }
        List<String> toSort = Arrays.asList("zz", "aa", "b", "ccc");
        Ordering<String> byLength = new OrderingByLenght();
        Collections.sort(toSort, byLength.compound(Ordering.natural()));

        Ordering<String> expectedOrder = Ordering.explicit(Lists.newArrayList("b", "aa", "zz", "ccc"));
        System.out.println(expectedOrder.isOrdered(toSort));
    }
    private void complexCustomOrderingwithChaining(){
        Log.e("complexCustomOrdering","---------------");

        class OrderingByLenght extends Ordering<String> {
            @Override
            public int compare(String s1, String s2) {
                return Ints.compare(s1.length(), s2.length());
            }
        }
        List<String> toSort = Arrays.asList("zz", "aa", null, "b", "ccc");
        Collections.sort(toSort,
                new OrderingByLenght().reverse().compound(Ordering.natural()).nullsLast());
        System.out.println(toSort);
    }


    private void sortUsingToString(){
        Log.e("sortUsingToString","---------------");
        List<Integer> toSort = Arrays.asList(1, 2, 11);
        Collections.sort(toSort, Ordering.usingToString());
        System.out.println(toSort);
        Ordering<Integer> expectedOrder = Ordering.explicit(Lists.newArrayList(1, 11, 2));
        System.out.println(expectedOrder.isOrdered(toSort));
    }

    private void binarySearchImpl(){
        Log.e("binarySearchImpl","---------------");
        List<Integer> toSort = Arrays.asList(1, 2, 11);
        Collections.sort(toSort, Ordering.usingToString());
        int found = Ordering.usingToString().binarySearch(toSort, 2);
        System.out.println(found);
    }

   private void findMinWithoutSort(){
       Log.e("findMinWithoutSort","---------------");
        List<Integer> toSort = Arrays.asList(2, 1, 11, 100, 8, 14);
        int found = Ordering.usingToString().min(toSort);
        System.out.println(found);
    }

    private void creatingSortedCopy(){
        Log.e("creatingSortedCopy","---------------");
        class OrderingByLenght extends Ordering<String> {
            @Override
            public int compare(String s1, String s2) {
                return Ints.compare(s1.length(), s2.length());
            }
        }
        List<String> toSort = Arrays.asList("aa", "b", "ccc");
        List<String> sortedCopy = new OrderingByLenght().sortedCopy(toSort);

        Ordering<String> expectedOrder = Ordering.explicit(Lists.newArrayList("b", "aa", "ccc"));
        System.out.println(expectedOrder.isOrdered(toSort));
        System.out.println(expectedOrder.isOrdered(sortedCopy));
    }

    private void creatingSortedPartialCopy(){
        Log.e("ortedPartialCopy","---------------");
        List<Integer> toSort = Arrays.asList(2, 1, 11, 100, 8, 14);
        List<Integer> leastOf = Ordering.natural().leastOf(toSort, 3);
        List<Integer> expected = Lists.newArrayList(1, 2, 8);
        System.out.println(leastOf);
        System.out.println(expected);
    }

    private void orderingViaIntermediaryFunction(){
        Log.e("orderingViaIntermediary","---------------");
        List<Integer> toSort = Arrays.asList(2, 1, 11, 100, 8, 14);
        Ordering<Object> ordering = Ordering.natural().onResultOf(Functions.toStringFunction());
        List<Integer> sortedCopy = ordering.sortedCopy(toSort);

        List<Integer> expected = Lists.newArrayList(1, 100, 11, 14, 2, 8);
        System.out.println(sortedCopy);
        System.out.println(expected);
    }
}
