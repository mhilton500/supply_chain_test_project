package com.example.supply_chain_test_project;


import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class productTrackingScreen_1 extends AppCompatActivity implements OnMapReadyCallback {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.product_tracking_screen_1);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_test);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.69,-80.30))
                .title("Marker"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(40.69,-80.30)));

    }


    //   @Override
    //   public void onMapReady(GoogleMap googleMap) {
    //      googleMap .addMarker(new MarkerOptions()
    //             .position(new LatLng(0,0))
    //             .title("Marker"));
    // }
}

