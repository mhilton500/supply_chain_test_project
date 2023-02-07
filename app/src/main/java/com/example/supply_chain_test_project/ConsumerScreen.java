package com.example.supply_chain_test_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConsumerScreen extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consumer_screen);

        ImageView groceriesImage_1 = findViewById(R.id.groceriesImage_1);
        TextView groceriesText_1 = findViewById(R.id.groceries_text_1);

        ImageView groceriesImage_2 = findViewById(R.id.groceriesImage_2);
        TextView groceriesText_2 = findViewById(R.id.groceries_text_2);

        ImageView groceriesImage_3 = findViewById(R.id.groceriesImage_3);
        TextView groceriesText_3 = findViewById(R.id.groceries_text_3);


        // on click listeners for shipping and tracking images and texts
        groceriesImage_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openProductTrackingScreen_1();}
        });

        groceriesText_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openProductTrackingScreen_1();}
        });


        groceriesImage_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openProductTrackingScreen_2();}
        });

        groceriesText_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openProductTrackingScreen_2();}
        });


        groceriesImage_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openProductTrackingScreen_3();}
        });

        groceriesText_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openProductTrackingScreen_3();}
        });



    }

    public void openProductTrackingScreen_1() {
        Intent intent = new Intent(this, productTrackingScreen_1.class);

        startActivity(intent);
    }

    public void openProductTrackingScreen_2() {
        Intent intent = new Intent(this, productTrackingScreen_2.class);

        startActivity(intent);
    }


    public void openProductTrackingScreen_3() {
        Intent intent = new Intent(this, productTrackingScreen_3.class);

        startActivity(intent);
    }

}
