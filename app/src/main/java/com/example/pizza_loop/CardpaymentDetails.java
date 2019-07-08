package com.example.pizza_loop;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class CardpaymentDetails extends AppCompatActivity {
    TextView cardnum,expirydate,code,Owner;
    EditText editnum,editdate,editcode,editname;
    Button pay;
    ImageView paymethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardpayment_details);

        cardnum=(TextView)findViewById(R.id.crdnumber);
        expirydate=(TextView)findViewById(R.id.exdate);
        code=(TextView)findViewById(R.id.cvcode);
        Owner=(TextView)findViewById(R.id.ownername);

        editnum=(EditText)findViewById(R.id.enternum);
        editdate=(EditText)findViewById(R.id.enterdate);
        editcode=(EditText)findViewById(R.id.entercvcode);
        editname=(EditText)findViewById(R.id.entercardowner);

        pay=(Button)findViewById(R.id.confirm);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(CardpaymentDetails.this,Location.class);
                startActivity(in);
            }
        });
    }
}
