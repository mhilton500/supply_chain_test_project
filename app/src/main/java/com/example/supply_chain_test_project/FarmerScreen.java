package com.example.supply_chain_test_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FarmerScreen extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmer_screen);

        ImageView semiTruckImage_1 = findViewById(R.id.semiTruckImage_1);
        TextView shipmentText_1 = findViewById(R.id.shipment_text_1);

        ImageView semiTruckImage_2 = findViewById(R.id.semiTruckImage_2);
        TextView shipmentText_2 = findViewById(R.id.shipment_text_2);

        ImageView semiTruckImage_3 = findViewById(R.id.semiTruckImage_3);
        TextView shipmentText_3 = findViewById(R.id.shipment_text_3);


        // on click listeners for shipment tracking image and text #1
        semiTruckImage_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openShipmentTrackingScreen_1();}
        });

        shipmentText_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openShipmentTrackingScreen_1();}
        });


        // on click listeners for shipment tracking image and text #2
        semiTruckImage_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openShipmentTrackingScreen_2();}
        });

        shipmentText_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openShipmentTrackingScreen_2();}
        });


        // on click listeners for shipment tracking image and text #3
        semiTruckImage_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openShipmentTrackingScreen_3();}
        });

        shipmentText_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openShipmentTrackingScreen_3();}
        });






    }

    //Methods to open shipment tracking screens 1-3 | goes to a google maps page
    public void openShipmentTrackingScreen_1() {
        Intent intent = new Intent(this, ShipmentTrackingScreen_1.class);

        startActivity(intent);
    }

    public void openShipmentTrackingScreen_2() {
        Intent intent = new Intent(this, ShipmentTrackingScreen_2.class);

        startActivity(intent);
    }

    public void openShipmentTrackingScreen_3() {
        Intent intent = new Intent(this, ShipmentTrackingScreen_3.class);

        startActivity(intent);
    }


}
