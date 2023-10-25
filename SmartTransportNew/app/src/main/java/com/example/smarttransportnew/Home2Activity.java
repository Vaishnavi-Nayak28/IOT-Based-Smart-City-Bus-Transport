package com.example.smarttransportnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Home2Activity extends AppCompatActivity implements View.OnClickListener {
    Button btnsearch;
    TextView tvdata;
    Button btnlogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        Spinner myspinner =(Spinner)findViewById(R.id.spinner);
        Spinner myspinner2=(Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Home2Activity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.LOCATIONS));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myAdapter);
        myspinner2.setAdapter(myAdapter);


        btnsearch=findViewById(R.id.button3);
        tvdata=findViewById(R.id.textView5);

        btnsearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewId=v.getId();
        if(viewId==R.id.button3){
            Spinner myspinner=findViewById(R.id.spinner);
            String source= myspinner.getSelectedItem().toString();
            Spinner myspinner2=findViewById(R.id.spinner2);
            String destination = myspinner2.getSelectedItem().toString();
            String loc= "From  "+source + " --->>> " + destination;
            tvdata.setText(loc);
        }
        btnlogout= findViewById(R.id.button7);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Home2Activity.this,ChooseActivity.class);
                startActivity(i);
            }
        });
    }
}
