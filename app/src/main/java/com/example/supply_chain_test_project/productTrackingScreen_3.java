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

public class productTrackingScreen_3 extends AppCompatActivity implements OnMapReadyCallback {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.product_tracking_screen_3);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_test);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        float zoomLevel = 16.0f; //This goes up to 21

        //Creating polyline to show route of product
        Polyline polyline1 = googleMap.addPolyline(new PolylineOptions()
                .clickable(true)
                .add( new LatLng(40.678808, -80.295234))
                .add( new LatLng(40.679181, -80.291005))
                .add( new LatLng(40.681514, -80.289234))
                .add( new LatLng(40.681760, -80.289282))
                .add( new LatLng( 40.682173, -80.289648))
                .add( new LatLng( 40.682520, -80.290187))
                .add( new LatLng( 40.684468, -80.291483))
                .add( new LatLng( 40.686402, -80.288682))
                .add( new LatLng( 40.688937, -80.286609))
                .add( new LatLng( 40.691273, -80.285494))
                .add( new LatLng( 40.691248, -80.284151))
                .add( new LatLng( 40.691516, -80.280797))
                .add( new LatLng( 40.693622, -80.281095))
                .add( new LatLng( 40.701479, -80.285161))
                .add( new LatLng( 40.701834, -80.284662))
                .add( new LatLng( 40.704672, -80.277904))
                .add( new LatLng( 40.708693, -80.280795))
                .add( new LatLng(40.708919, -80.280289))
                .width(15)
                .color(Color.YELLOW)

        );
        polyline1.setStartCap(new RoundCap());
        polyline1.setJointType(JointType.ROUND);

        //Creating marker along route for the first destination
        Marker marker_1 = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.691516, -80.280797))
                .title("Destination 1")
        );

        //Marker indication driver and ETA
        Marker marker_2 = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.691273, -80.285494))
                .title("Driver 1 | ETA: 5:00 min")

        );

        //loads screen to desired marker and zoom level
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(40.691516, -80.280797),zoomLevel));

    }
}

