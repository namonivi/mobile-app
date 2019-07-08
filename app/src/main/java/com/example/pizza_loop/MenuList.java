package com.example.pizza_loop;


import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MenuList extends AppCompatActivity implements PizzaAdapter.OnItemClickListner {

    private static final String URL_DATA = "http://172.168.43.216:8080/demo/all";
    RecyclerView recyclerView;
    PizzaAdapter adapter;
    List<Pizza> productslist;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);


    button=(Button)findViewById(R.id.but);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(MenuList.this,FullDetails.class);
            startActivity(intent);
        }
    });

        productslist = new ArrayList<>();

        recyclerView =  findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadRecyclerviewData();
        /*LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);*/


    }


    private void loadRecyclerviewData(){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONArray products  = new JSONArray(response);

                    for (int i =0; i<products.length(); i++){

                        JSONObject productobject  = products.getJSONObject(i);

                        int pizzaId = productobject.getInt("id");
                        String name = productobject.getString("name");
                        String details = productobject.getString("description");
                        Double price = productobject.getDouble("price");
                     String  imageURL = productobject.getString("image");
                        Pizza product = new Pizza(pizzaId, name,details,price,imageURL);
                        productslist.add(product);

                    }
                    adapter = new PizzaAdapter(MenuList.this, productslist);
                    recyclerView.setAdapter(adapter);
                    adapter.setOnItemCliclListener(MenuList.this);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MenuList.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MenuList.this, error.getMessage(), Toast.LENGTH_LONG).show();
                error.printStackTrace();
            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }
    @Override
    public void onItemClick(int position) {

        Intent detailintent = new Intent(this, FullDetails.class);
        Pizza clickItem = productslist.get(position);

        detailintent.putExtra("NAME", clickItem.getName());
        detailintent.putExtra("DETAILS", clickItem.getDetails());
        detailintent.putExtra("PRICE", clickItem.getPrice());
        detailintent.putExtra("IMG", clickItem.getImageURL());

        startActivity(detailintent);

    }
}


