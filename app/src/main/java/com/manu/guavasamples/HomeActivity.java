package com.manu.guavasamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.manu.guavasamples.collection.predicate.PredicateActivity;
import com.manu.guavasamples.objects.ObjectActivity;
import com.manu.guavasamples.ordering.OrderingClassActivity;

/**
 * Created by manu on 3/27/2018.
 */

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button optionalButton  =  findViewById(R.id.optionalButton);
        optionalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,OptionalClassActivity.class);
                startActivity(intent);
            }
        });


        Button preConditionButton  =  findViewById(R.id.preConditionButton);
        preConditionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,PreConditionaClassActivity.class);
                startActivity(intent);
            }
        });

        Button orderingButton  =  findViewById(R.id.orderingButton);
        orderingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,OrderingClassActivity.class);
                startActivity(intent);
            }
        });

        Button objectButton  =  findViewById(R.id.objectButton);
        objectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,ObjectActivity.class);
                startActivity(intent);
            }
        });

        Button predicateButton  =  findViewById(R.id.predicateButton);
        predicateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,PredicateActivity.class);
                startActivity(intent);
            }
        });
    }
}
