package com.example.myapplication6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class regsiter extends AppCompatActivity {
    TextView btn;

    private EditText inputusername, inputpassword, InputEmail, Inputconformpassword;
    Button btnregsiter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regsiter);

        btn = findViewById(R.id.textView2);
        inputusername = findViewById(R.id.editTextTextPersonName);
        InputEmail = findViewById(R.id.editTextTextPersonName3);
        inputpassword = findViewById(R.id.editTextTextPersonName2);
        Inputconformpassword = findViewById(R.id.editTextTextPersonName4);

        btnregsiter=findViewById(R.id.button);
        btnregsiter.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onclick() {
            checkCredenrials();
        }





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(regsiter.this, LoginActivity.class));


            }
        });
    }

    private void checkCredenrials() {
        String username = inputusername.getText().toString();
        String email = InputEmail.getText().toString();
        String password = inputpassword.getText().toString();
        String conformpassword = Inputconformpassword.getText().toString();

        if (username.isEmpty() || username.length() < 7);
            {
                showError(inputusername, "اسم المستخدم خطأ");
            }
            else if  (email.isEmpty() || email.contains("@")) ;


        {
            showError(InputEmail, "هناك خطأ في البريد");
        }
          if (password.isEmpty()||password.length()<7);
        {
            showError(inputpassword, "لا تحتوي كلمة علي 7 احرف");
        }
        if (conformpassword.isEmpty() || !conformpassword.equals(password));
        {
            showError(Inputconformpassword,"تأكد من كلمة المرور");
        }
        else {
            Toast.makeText(this, "جاري مرجعة البيانات", Toast.LENGTH_SHORT).show();
        }

    }

    private void showError(EditText input,String s) {
        input.setError(s);
        input.requestFocus();
     }
    }

    
    
