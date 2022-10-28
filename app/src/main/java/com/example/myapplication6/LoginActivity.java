package com.example.myapplication6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    TextView btn;
    EditText inputEmail, inputpassword;
    Button btnlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn = findViewById(R.id.textViewSignUp);
        inputEmail = findViewById(R.id.editTextTextPersonName3);
        inputpassword = findViewById(R.id.editTextTextPersonName);
        btnlogin = findViewById(R.id.button2);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chekcrededentials();
            }
        });


        btn.setOnClickListener((v) -> {
            startActivity(new Intent(LoginActivity.this, regsiter.class));


        });
    }

    private void chekcrededentials() {
        String email=inputEmail.getText().toString();
        String password=inputpassword.getText().toString();


         if (email.isEmpty() || !email.contains("@"))
        {
            showError(inputEmail,"البريد الاكتروني خطأ");
        }
        else if (password.isEmpty() || password.length()<7)
        {
            showError(inputpassword,"كلمة السر اقبل من 7 حروف");
        }
        else
        {
            Toast.makeText(this, "Call login Method", Toast.LENGTH_SHORT).show();
        }


    }


    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}