package com.example.pizza_loop;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
//import android.widget.TextView;
//
// import android.widget.TextView;
import android.widget.TextView;
import android.widget.Toast;


public class FullDetails extends AppCompatActivity {


    TextView pizzaname, pizzaprice, pizzadescription, allprice1,output;

    ImageView pizzaimage;

    Button Buy, Cancel;

    String Pizzaname1;
    String PizzaDescription1;
    String Imageurl;
    Double Allprice;

    int qty=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_details);

        pizzaname = findViewById(R.id.name);

        pizzadescription = findViewById(R.id.description);
        pizzaprice = findViewById(R.id.price);
        allprice1 = findViewById(R.id.allprice);





        final Spinner spinner=findViewById(R.id.spi);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,R.array.qty,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //String text= spinner.getSelectedItem().toString();

//        qty=Integer.parseInt(spinner.getSelectedItem().toString());





        pizzaimage = findViewById(R.id.image);


        //getting data from homeActivity
        Intent intent = getIntent();
        final String imgurl = intent.getStringExtra("IMG");
        final Double pizzaprice1 = intent.getDoubleExtra("PRICE", 0.00);
        final String pizzaname1 = intent.getStringExtra("NAME");
        final String pizzadescription1 = intent.getStringExtra("DETAILS");


        //assign homeActivity data to DetailsActivity's variables
        Imageurl = imgurl;
        PizzaDescription1 = pizzadescription1;
        Pizzaname1 = pizzaname1;


        //setting data to xml file
        // picasso.with(FullDetails.this).load(imgurl).into(pizzaimage);
        pizzaname.setText(pizzaname1);
        pizzadescription.setText(pizzadescription1);
        pizzaprice.setText("Rs." + pizzaprice1);
        allprice1.setText("Rs. " + pizzaprice1);

        Allprice = pizzaprice1;

        allprice1.setText(""+Allprice*(Integer.parseInt(spinner.getSelectedItem().toString())));

        System.out.println("nnnnnnnnnnnnnnn"+qty);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa"+Allprice);
        //output=(TextView)findViewById(R.id.oup);
        Buy = (Button) findViewById(R.id.addToCart);
       // EditText pr=(EditText)findViewById(R.id.prices);
        Buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FullDetails.this,PaymentDetails.class);
                startActivity(intent);
            }
        });
        Cancel=(Button)findViewById(R.id.cancel);
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FullDetails.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Thank you for using our app",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
