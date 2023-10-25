package com.example.smarttransportnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login2Activity extends AppCompatActivity {
    public EditText emailID, password;
    Button btnLogin;
    private int counter=3;
    TextView tvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        emailID = findViewById(R.id.editText2);
        password = findViewById(R.id.editText);

        btnLogin = findViewById(R.id.button);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(emailID.getText().toString(),password.getText().toString());
            }
        });

        tvSignUp = findViewById(R.id.textView);
        tvSignUp.setText("NUMBER OF ATTEMPTS REMAINING: 3");
    }
    private void validate(String user,String users){
        if ((user=="smart@gmail.com") && (users=="smart"))
        {
            Intent i= new Intent(Login2Activity.this,AdminActivity.class);
            startActivity(i);
        }
        else if (user.isEmpty() && users.isEmpty()) {
            Toast.makeText(Login2Activity.this, "Field are empty!", Toast.LENGTH_SHORT).show();
        }
        else{
            counter--;
            tvSignUp.setText("NUMBER OF ATTEMPTS REMAINING " + String.valueOf(counter));

            if(counter==0){
                Intent i= new Intent(Login2Activity.this,AdminActivity.class);
                startActivity(i);
                //btnLogin.setEnabled(false);
            }
        }
}}
