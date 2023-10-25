package com.example.smarttransportnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseActivity extends AppCompatActivity {
    Button admini,useri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        admini= findViewById(R.id.button5);
        admini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(ChooseActivity.this,Login2Activity.class);
                startActivity(i);
            }
        });

        useri= findViewById(R.id.button6);
        useri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(ChooseActivity.this,MainActivity.class);
                startActivity(i);
            }
        });





    }
}
