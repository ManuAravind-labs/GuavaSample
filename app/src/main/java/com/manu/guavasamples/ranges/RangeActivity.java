package com.manu.guavasamples.ranges;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.common.collect.BoundType;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import com.google.common.primitives.Ints;
import com.manu.guavasamples.R;

/**
 * Created by manu on 3/27/2018.
 */

public class RangeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range);
        testRange();
        example2();
    }

    private void testRange() {

        //create a range [a,b] = { x | a <= x <= b}
        Range<Integer> range1 = Range.closed(0, 9);
        System.out.print("[0,9] : ");
        printRange(range1);

        System.out.println("5 is present: " + range1.contains(5));
        System.out.println("(1,2,3) is present: " + range1.containsAll(Ints.asList(1, 2, 3)));
        System.out.println("Lower Bound: " + range1.lowerEndpoint());
        System.out.println("Upper Bound: " + range1.upperEndpoint());

        //create a range (a,b) = { x | a < x < b}
        Range<Integer> range2 = Range.open(0, 9);
        System.out.print("(0,9) : ");
        printRange(range2);

        //create a range (a,b] = { x | a < x <= b}
        Range<Integer> range3 = Range.openClosed(0, 9);
        System.out.print("(0,9] : ");
        printRange(range3);

        //create a range [a,b) = { x | a <= x < b}
        Range<Integer> range4 = Range.closedOpen(0, 9);
        System.out.print("[0,9) : ");
        printRange(range4);

        //create an open ended range (9, infinity
        Range<Integer> range5 = Range.greaterThan(9);
        System.out.println("(9,infinity) : ");
        System.out.println("Lower Bound: " + range5.lowerEndpoint());
        System.out.println("Upper Bound present: " + range5.hasUpperBound());

        Range<Integer> range6 = Range.closed(3, 5);
        printRange(range6);

        //check a subrange [3,5] in [0,9]
        System.out.println("[0,9] encloses [3,5]:" + range1.encloses(range6));

        Range<Integer> range7 = Range.closed(9, 20);
        printRange(range7);

        //check ranges to be connected
        System.out.println("[0,9] is connected [9,20]:" + range1.isConnected(range7));
        Range<Integer> range8 = Range.closed(5, 15);

        //intersection
        printRange(range1.intersection(range8));

        //span
        printRange(range1.span(range8));
    }

    private void printRange(Range<Integer> range) {

        System.out.print("[ ");

        for(int grade : ContiguousSet.create(range, DiscreteDomain.integers())) {
            System.out.print(grade +" ");
        }
        System.out.println("]");
    }

    private void example2(){
        // A range that contains all values greater than or equal to 2
// and less than or equal to 4
        Range.closed(2, 4).contains(1); // -> false
        Range.closed(2, 4).contains(2); // -> true
        Range.closed(2, 4).contains(3); // -> true
        Range.closed(2, 4).contains(4); // -> true
        Range.closed(2, 4).contains(5); // -> false

// A range that contains all values greater than or equal to 2
// and strictly less than 4
        Range.closedOpen(2, 4).contains(1); // -> false
        Range.closedOpen(2, 4).contains(2); // -> true
        Range.closedOpen(2, 4).contains(3); // -> true
        Range.closedOpen(2, 4).contains(4); // -> false
        Range.closedOpen(2, 4).contains(5); // -> false

// A range that contains all values strictly greater than 2
// and strictly less than 4
        Range.open(2, 4).contains(1); // -> false
        Range.open(2, 4).contains(2); // -> false
        Range.open(2, 4).contains(3); // -> true
        Range.open(2, 4).contains(4); // -> false
        Range.open(2, 4).contains(5); // -> false

// A range that contains all values strictly greater than 2
// and less than or equal to 4
        Range.openClosed(2, 4).contains(1); // -> false
        Range.openClosed(2, 4).contains(2); // -> false
        Range.openClosed(2, 4).contains(3); // -> true
        Range.openClosed(2, 4).contains(4); // -> true
        Range.openClosed(2, 4).contains(5); // -> false

// A range that contains all values greater than or equal to 2
        Range.atLeast(2).contains(1); // -> false
        Range.atLeast(2).contains(2); // -> true
        Range.atLeast(2).contains(3); // -> true

// A range that contains all values less than or equal to 2
        Range.atMost(2).contains(1); // -> true
        Range.atMost(2).contains(2); // -> true
        Range.atMost(2).contains(3); // -> false

// A range that contains all values strictly greater than 2
        Range.greaterThan(2).contains(1); // -> false
        Range.greaterThan(2).contains(2); // -> false
        Range.greaterThan(2).contains(3); // -> true

// A range that contains all values strictly less than 2
        Range.lessThan(2).contains(1); // -> true
        Range.lessThan(2).contains(2); // -> false
        Range.lessThan(2).contains(3); // -> false

// A range that contains only 2, closed on both ends
        Range.singleton(2).contains(1); // -> false
        Range.singleton(2).contains(2); // -> true
        Range.singleton(2).contains(3); // -> false

// A range that contains every value
        Range.all().contains(1); // -> true
        Range.all().contains(2); // -> true
        Range.all().contains(3); // -> true

// A range from 2, inclusive (closed), with no upper bound
        Range.downTo(2, BoundType.CLOSED).contains(1); // -> false
        Range.downTo(2, BoundType.CLOSED).contains(2); // -> true
        Range.downTo(2, BoundType.CLOSED).contains(3); // -> true

// A range from 2, exclusive (open), with no upper bound
        Range.downTo(2, BoundType.OPEN).contains(1); // -> false
        Range.downTo(2, BoundType.OPEN).contains(2); // -> false
        Range.downTo(2, BoundType.OPEN).contains(3); // -> true

// A range with no lower bound up to 2, inclusive (closed)
        Range.upTo(2, BoundType.CLOSED).contains(1); // -> true
        Range.upTo(2, BoundType.CLOSED).contains(2); // -> true
        Range.upTo(2, BoundType.CLOSED).contains(3); // -> false

// A range with no lower bound up to 2, exclusive (open)
        Range.upTo(2, BoundType.OPEN).contains(1); // -> true
        Range.upTo(2, BoundType.OPEN).contains(2); // -> false
        Range.upTo(2, BoundType.OPEN).contains(3); // -> false
    }

  //  http://www.javarticles.com/2015/11/guava-range-example.html

//    open(a, b) – It represents a < range < b, and in notation form, (a,b).
//    closed(a, b) – It represents a <= range <= b, and in notation form, [a,b].
//    openClosed(a, b) – It represents a < range <= b, and in notation form, (a,b].
//    closedOpen(a, b) – It represents a <= range < b, and in notation form, [a,b).
//    greaterThan(a) – It represents range > a, and in notation form, (a..+∞).
//    atLeast(a, b) – It represents range >= a, and in notation form, [a..+∞).
//    lessThan(a, b) – It represents range < b, and in notation form, (-∞..b).
//    atMost(a, b) – It represents range <= b, and in notation form, (-∞..b].
//    all() – It represents -∞ < range < +∞, and in notation form, (-∞..+∞).


    private void example3(){
        System.out
                .println("-----------open(1,4) ==> 1<value<4--------------------");

        // 1<value<4
        Range<Integer> range = Range.open(1, 4);
        System.out.println("Conatins 1? " + range.contains(1));
        System.out.println("Conatins 2? " + range.contains(2));
        System.out.println("Conatins 3? " + range.contains(3));
        System.out.println("Conatins 4? " + range.contains(4));
        System.out
                .println("-----------closed(1,4) ==> 1<=value<=4----------------");

        // 1<=value<=4
        range = Range.closed(1, 4);
        System.out.println("Conatins 0? " + range.contains(0));
        System.out.println("Conatins 1? " + range.contains(1));
        System.out.println("Conatins 2? " + range.contains(2));
        System.out.println("Conatins 3? " + range.contains(3));
        System.out.println("Conatins 4? " + range.contains(4));
        System.out.println("Conatins 5? " + range.contains(5));
        System.out
                .println("-----------openClosed(1,4) ==> 1<value<=4-------------");

        // 1<value<=4
        range = Range.openClosed(1, 4);
        System.out.println("Conatins 0? " + range.contains(0));
        System.out.println("Conatins 1? " + range.contains(1));
        System.out.println("Conatins 2? " + range.contains(2));
        System.out.println("Conatins 3? " + range.contains(3));
        System.out.println("Conatins 4? " + range.contains(4));
        System.out.println("Conatins 5? " + range.contains(5));
        System.out
                .println("-----------closedOpen(1,4) ==> 1<=value<4-------------");

        // 1<=value<4
        range = Range.closedOpen(1, 4);
        System.out.println("Conatins 0? " + range.contains(0));
        System.out.println("Conatins 1? " + range.contains(1));
        System.out.println("Conatins 2? " + range.contains(2));
        System.out.println("Conatins 3? " + range.contains(3));
        System.out.println("Conatins 4? " + range.contains(4));
        System.out.println("Conatins 5? " + range.contains(5));

        System.out
                .println("----------------------2<value-------------------------");
        // 2<value
        range = Range.greaterThan(2);
        System.out.println("Conatins 2? " + range.contains(2));
        System.out.println("Conatins 2000? " + range.contains(2000));

        System.out
                .println("----------------------2<=value-------------------------");
        // 2<=value
        range = Range.atLeast(2);
        System.out.println("Conatins 2? " + range.contains(2));
        System.out.println("Conatins 2000? " + range.contains(2000));

        System.out
                .println("----------------------2>value-------------------------");
        // 2>value
        range = Range.lessThan(2);
        System.out.println("Conatins 2? " + range.contains(2));
        System.out.println("Conatins 1? " + range.contains(1));
        System.out.println("Conatins -1? " + range.contains(-1));

        System.out
                .println("----------------------2<=value-------------------------");
        // 2<=value
        range = Range.atMost(2);
        System.out.println("Conatins 2? " + range.contains(2));
        System.out.println("Conatins 1? " + range.contains(1));
        System.out.println("Conatins -1? " + range.contains(-1));

        System.out
                .println("-----------------------(-infinity<value<+infinity)-------------------------");
        // -infinity<value<+infinity
        range = Range.all();
        System.out.println("Conatins -200? " + range.contains(-200));
        System.out.println("Conatins 200? " + range.contains(200));

    }
}
