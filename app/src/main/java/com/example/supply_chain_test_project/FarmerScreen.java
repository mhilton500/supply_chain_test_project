package com.example.supply_chain_test_project;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FarmerScreen extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmer_screen);

        // store UI elements in variables
        LinearLayout farmerLayout = findViewById(R.id.farmer_layout);

        // use Volley to get farm node json data
        RequestQueue queue = Volley.newRequestQueue(FarmerScreen.this);
        String url = "http://10.0.2.2:3000/nodes/supplier";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                String farmName = "";
                double latitude = 0;
                double longitude = 0;

                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject object = response.getJSONObject(i);
                        JSONObject properties = object.getJSONArray("_fields").getJSONObject(0).getJSONObject("properties");

                        // get values from JSON
                        farmName = properties.getString("name");
                        //latitude = properties.getJSONObject("latitude").getDouble("low");
                        //longitude = properties.getJSONObject("longitude").getDouble("low");

                        // create UI elements
                        // linearLayout will hold an ImageButton and TextView
                        LinearLayout linearLayout = new LinearLayout(FarmerScreen.this);
                        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                        // image
                        ImageButton imageButton = new ImageButton(FarmerScreen.this);
                        imageButton.setImageResource(R.drawable.groceries_image);

                        // text
                        TextView textView = new TextView(FarmerScreen.this);
                        textView.setText(farmName);
                        textView.setTextSize(TypedValue.COMPLEX_UNIT_PT, 15);
                        textView.setTypeface(null, Typeface.BOLD);

                        // add imageButton and textView to linearLayout
                        linearLayout.addView(imageButton);
                        linearLayout.addView(textView);

                        // add onClick listener to linearLayout and image
                        imageButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                openShipmentTrackingScreen_1(); //FIXME: use real values
                            }
                        });

                        linearLayout.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                openShipmentTrackingScreen_1(); //FIXME: use real values
                            }
                        });

                        // add linearLayout to ConsumerScreen
                        farmerLayout.addView(linearLayout);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        queue.add(request);

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
