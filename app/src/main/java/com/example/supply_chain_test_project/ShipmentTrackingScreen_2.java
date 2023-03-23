package com.example.supply_chain_test_project;


import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.JointType;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RoundCap;

public class ShipmentTrackingScreen_2 extends AppCompatActivity implements OnMapReadyCallback {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.shipment_tracking_screen_2);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_test);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        float zoomLevel = 17.0f; //This goes up to 21


        //Creating polyline to show route of product
        Polyline polyline1 = googleMap.addPolyline(new PolylineOptions()
                .clickable(true)
                //.add( new LatLng(40.678808, -80.295234))
                .add(new LatLng(40.675697, -80.310508))
                .add(new LatLng(40.676628, -80.309949))
                .add(new LatLng(40.678012, -80.308745))
                .add(new LatLng(40.678295, -80.308462))
                .add(new LatLng(40.679358, -80.306802))
                .add(new LatLng(40.680055, -80.304873))
                .add(new LatLng(40.680574, -80.303169))
                .add(new LatLng(40.680410, -80.302816))
                .add(new LatLng(40.679854, -80.302475))
                .width(15)
                .color(Color.YELLOW)

        );
        polyline1.setStartCap(new RoundCap());
        polyline1.setJointType(JointType.ROUND);

        //Creating marker along route for the first destination
        Marker marker_1 = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.679854, -80.302475))
                .title("Final Destination")

        );

        //loads screen to desired marker and zoom level
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(40.679854, -80.302475),zoomLevel));

    }
}

