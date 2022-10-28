package com.example.myapplication6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.ClosedSubscriberGroupInfo;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;

public class regsiter extends AppCompatActivity {
    TextView btn;

    private EditText inputusername, inputpassword, inputEmail, inputconformpassword;
    Button btnregsiter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regsiter);

        btn = findViewById(R.id.textView2);
        inputusername = findViewById(R.id.editTextTextPersonName);
        inputEmail = findViewById(R.id.editTextTextPersonName3);
        inputpassword = findViewById(R.id.editTextTextPersonName2);
        inputconformpassword = findViewById(R.id.editTextTextPersonName4);

        btnregsiter=findViewById(R.id.button);
        btnregsiter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V) {
                chekcrededentials();
            }
        });
        chekcrededentials();


        btn.setOnClickListener((v) -> {
            ;
            startActivity(new Intent(regsiter.this,LoginActivity. class));


        });
    }


    private void chekcrededentials() {
        String username=inputusername.getText().toString();
        String email=inputEmail.getText().toString();
        String password=inputpassword.getText().toString();
        String conformpassword=inputconformpassword.getText().toString();

        if (username.isEmpty() || username.length()<7)
        {
           showError(inputusername,"اسم المستخدم خطأ");
        }
        else if (email.isEmpty() || !email.contains("@"))
        {
            showError(inputEmail,"البريد الاكتروني خطأ");
        }
        else if (password.isEmpty() || password.length()<7)
        {
            showError(inputpassword,"كلمة السر اقبل من 7 حروف");
        }
        else if (conformpassword.isEmpty() || !conformpassword.equals(password))
        {
           showError(inputconformpassword,"كلمة المرور غير متاطبقه");
        }
        else
        {
            Toast.makeText(this, "Call Registration Method", Toast.LENGTH_SHORT).show();
        }


    }


    private void showError(EditText input, String s) {
       input.setError(s);
       input.requestFocus();
    }
}