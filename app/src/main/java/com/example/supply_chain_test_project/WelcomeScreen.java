package com.example.supply_chain_test_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);

        ImageView farmPic = findViewById(R.id.farmImage);
        ImageView truckPic = findViewById(R.id.truckImage);


        farmPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openFarmerScreen();}

        });

        truckPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openConsumerScreen();}
        });

    }

    public void openFarmerScreen() {
        Intent intent = new Intent(this, FarmerScreen.class);

        startActivity(intent);
    }

    public void openConsumerScreen() {
        Intent intent = new Intent(this, ConsumerScreen.class);

        startActivity(intent);
    }


}
