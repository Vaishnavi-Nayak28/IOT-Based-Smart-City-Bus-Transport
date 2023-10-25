package com.example.smarttransportnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    public EditText emailID,password;
    Button btnSignUp;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth= FirebaseAuth.getInstance();
        emailID=findViewById(R.id.editText2);
        password=findViewById(R.id.editText);
        btnSignUp=findViewById(R.id.button);
        tvSignIn= findViewById(R.id.textView);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailID.getText().toString();
                String pwd = password.getText().toString();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                    if (email.isEmpty()) {
                        emailID.setError("PLEASE ENTER EMAIL ID");
                        emailID.requestFocus();
                    } else if (pwd.isEmpty()) {
                        password.setError("PLEASE ENTER PASSWORD");
                        password.requestFocus();
                    } else if (email.isEmpty() && pwd.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Field are empty!", Toast.LENGTH_SHORT).show();
                    } else if (!(email.isEmpty() && pwd.isEmpty())) {
                        mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "Signup Unsuccessful,Please Try Again", Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                                }
                            }
                        });
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Error Occured", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i= new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
