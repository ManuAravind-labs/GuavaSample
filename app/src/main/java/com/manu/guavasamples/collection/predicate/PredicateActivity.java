package com.manu.guavasamples.collection.predicate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.manu.guavasamples.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertTrue;

/**
 * Created by manu on 3/27/2018.
 */

public class PredicateActivity extends AppCompatActivity {

    List<Country> countriesList  = Lists.newArrayList();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);
        createDataSet();
        tradintionalApproach();
        approachByGuava();
        transform();

        predicateExample2();
        example3();
        example4();
        chainingPredicatesandFunctions();
        composeTwoFunctions();
    }


    private void createDataSet(){

        countriesList.add(new Country("India",1292707,7));
        countriesList.add(new Country("China",1373490,2));
        countriesList.add(new Country("USA",321601,1));
        countriesList.add(new Country("Germany",82176,4));
        countriesList.add(new Country("Russia",143457,12));
        countriesList.add(new Country("UK",65110,6));
        countriesList.add(new Country("France",64275,5));
    }

    private void tradintionalApproach(){
        List<Country> filteredCountries = Lists.newArrayList();
        for(Country country: countriesList){
            if(country.getName().equals("UK")){
                filteredCountries.add(country);
            }
        }
        Log.e("Traditional ","=======>");
        System.out.println(filteredCountries.size());
    }

    private void approachByGuava(){
        Collection<Country> countries = Collections2.filter(countriesList, new Predicate<Country>() {
            @Override
            public boolean apply(Country input) {
                return input.getName().equals("UK");
            }
        });
        Log.e("BYGuava === > ","------->");
        System.out.println(countries.size());
    }


    private void transform(){
        TextView textView = findViewById(R.id.text_view_exp);

        List<Option> options= generateMockOptions();

        List<OptionBook> optionsBook = generateMockOptionBooks(options);

        String text = "OptionBook size: " + optionsBook.size() + "\n" + "OptionBook Name: "
                + optionsBook.get(0).getName() + "\n" + "OptionBook Type: " + optionsBook.get(0).getDescription()
                + "\n";
        textView.setText(text);

    }


    /**
     * this method generates a mock option list
     * @return
     */
    private List<Option> generateMockOptions() {
        List<Option> options = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Option option = new Option();
            option.setId(i);
            option.setName("option " + i);
            option.setDescription("description example");
            option.setSerial("1234567890");
            option.setType("generic");
            if (i == 4) {
                option.setType(Option.BOOK_TYPE);
                option.setDescription("description book");
            }

            options.add(option);
        }

        return options;

    }
    @SuppressWarnings("unchecked")
    private ArrayList<OptionBook> generateMockOptionBooks(List<Option> options) {

        ImmutableList books = FluentIterable
                .from(options)
                .filter(filterByBookType())
                .transform(transformToOptionBook())
                .toList();


        return new ArrayList<OptionBook>(books);

    }




    /**
     * this predicate {@link Predicate} filters Option Object by specific type like "book"
     */
    private Predicate filterByBookType() {
        return new Predicate<Option>() {
            @Override
            public boolean apply(Option input) {
                return input != null && input.getType().equals(Option.BOOK_TYPE);
            }
        };
    }


    /**
     * this function {@link com.google.common.base.Function} tranforms from the Option Object to OptionBook Object
     */

    private Function<Option, OptionBook> transformToOptionBook() {
        return new Function<Option, OptionBook>() {
            @Override
            public OptionBook apply(Option input) {
                OptionBook book = new OptionBook();
                book.setId(input.getId());
                book.setName(input.getName());
                book.setDescription(input.getDescription());
                book.setSerial(input.getSerial());
                book.setProvider("new provider");
                return book;
            }
        };
    }

  //filter a collection by a condition (custom Predicate)
    private  void predicateExample2(){

        List<Integer> numbers = Lists.newArrayList(1, 2, 3, 6, 10, 34, 57, 89);
        Predicate<Integer> acceptEven = new Predicate<Integer>() {
            @Override
            public boolean apply(Integer number) {
                return (number % 2) == 0;
            }
        };
        List<Integer> evenNumbers = Lists.newArrayList(Collections2.filter(numbers, acceptEven));
        System.out.println(evenNumbers);

        Integer found = Collections.binarySearch(evenNumbers, 34);
        System.out.println(found);

    }


   //filter out nulls from a collection
    private void example3(){
        List<String> withNulls = Lists.newArrayList("a", "bc", null, "def");
        Iterable<String> withoutNuls = Iterables.filter(withNulls, Predicates.notNull());
        System.out.println(withoutNuls);
        System.out.println(Iterables.all(withoutNuls, Predicates.notNull()));
    }

    //check condition for all elements of a collection
    private void example4(){
        List<Integer> evenNumbers = Lists.newArrayList(2, 6, 8, 10, 34, 90);
        Predicate<Integer> acceptEven = new Predicate<Integer>() {
            @Override
            public boolean apply(Integer number) {
                return (number % 2) == 0;
            }
        };
        System.out.println(evenNumbers);
        System.out.println(Iterables.all(evenNumbers, acceptEven));
    }

   //complex example – chaining predicates and functions
    private void  chainingPredicatesandFunctions(){
        List<Integer> numbers = Arrays.asList(2, 1, 11, 100, 8, 14);

        Predicate<Integer> acceptEvenNumber = new Predicate<Integer>() {
            @Override
            public boolean apply(Integer number) {
                return (number % 2) == 0;
            }
        };

        Function<Integer, Integer> powerOfTwo = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer input) {
                return (int) Math.pow(input, 2);
            }
        };

        FluentIterable<Integer> powerOfTwoOnlyForEvenNumbers =
                FluentIterable.from(numbers).filter(acceptEvenNumber).transform(powerOfTwo);
        System.out.println(powerOfTwoOnlyForEvenNumbers);
    }

    private void composeTwoFunctions(){
        List<Integer> numbers = Arrays.asList(2, 3);
        Function<Integer, Integer> powerOfTwo = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer input) {
                return (int) Math.pow(input, 2);
            }
        };
        List<Integer> result = Lists.transform(numbers,
                Functions.compose(powerOfTwo, powerOfTwo));
        System.out.println(result);
    }
//http://www.baeldung.com/guava-functions-predicates
//http://www.javarticles.com/category/guava/page/3
//http://www.baeldung.com/guava-functions-predicates
    //http://www.javarticles.com/2015/04/guava-predicate-examples.html
}


