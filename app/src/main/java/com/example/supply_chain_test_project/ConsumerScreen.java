package com.example.supply_chain_test_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class ConsumerScreen extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consumer_screen);

        // store UI elements in variables
        LinearLayout consumerLayout = findViewById(R.id.consumer_layout);

        ImageView groceriesImage_1 = findViewById(R.id.groceriesImage_1);
        TextView groceriesText_1 = findViewById(R.id.groceries_text_1);

        ImageView groceriesImage_2 = findViewById(R.id.groceriesImage_2);
        TextView groceriesText_2 = findViewById(R.id.groceries_text_2);

        ImageView groceriesImage_3 = findViewById(R.id.groceriesImage_3);
        TextView groceriesText_3 = findViewById(R.id.groceries_text_3);

        // use Volley to get json data for food nodes
        RequestQueue queue = Volley.newRequestQueue(ConsumerScreen.this);
        String url = "http://10.0.2.2:3000/nodes/food";

        groceriesText_1.setText("This is a test");
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                String foodName = "";
                double latitude = 0;
                double longitude = 0;

                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject object = response.getJSONObject(i);
                        JSONObject properties = object.getJSONArray("_fields").getJSONObject(0).getJSONObject("properties");

                        // get values from JSON
                        foodName = properties.getString("name");
                        latitude = properties.getJSONObject("latitude").getDouble("low");
                        longitude = properties.getJSONObject("longitude").getDouble("low");

                        // create UI elements
                        // linearLayout will hold an ImageButton and TextView
                        LinearLayout linearLayout = new LinearLayout(ConsumerScreen.this);
                        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                        // image
                        ImageButton imageButton = new ImageButton(ConsumerScreen.this);
                        imageButton.setImageResource(R.drawable.groceries_image);
                        imageButton.setMaxWidth(50);
                        imageButton.setMaxHeight(50);

                        // text
                        TextView textView = new TextView(ConsumerScreen.this);
                        textView.setText(foodName);


                        // add imageButton and textView to linearLayout
                        linearLayout.addView(imageButton);
                        linearLayout.addView(textView);

                        // add linearLayout to ConsumerScreen
                        consumerLayout.addView(linearLayout);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                    groceriesText_1.setText("JSONException");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                groceriesText_1.setText("Response Error");
            }
        });

        queue.add(request);


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


    // Directs to a google maps page
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
