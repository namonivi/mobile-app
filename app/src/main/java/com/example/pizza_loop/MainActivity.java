package com.example.pizza_loop;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.user_name);
        password = (EditText) findViewById(R.id.passwrd);
        login = (Button) findViewById(R.id.login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("student") && password.getText().toString().equals("number")) {
                    //Toast.makeText(getApplicationContext(),"right",Toast.LENGTH_SHORT).show();
                   Intent i = new Intent(MainActivity.this, MenuList.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(),"please enter valid username and password",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}



