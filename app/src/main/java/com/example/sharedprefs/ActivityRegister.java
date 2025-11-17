package com.example.sharedprefs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityRegister extends AppCompatActivity {
    Button register;
    EditText uname,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register = findViewById(R.id.register);

        uname = findViewById(R.id.uname);
        password = findViewById(R.id.password);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = uname.getText().toString();
                String pass = password.getText().toString();
                if(TextUtils.isEmpty(user)){
                    uname.setError("X username");
                }
                else{
                    SharedPreferences sp=getSharedPreferences("file",MODE_PRIVATE);
                    SharedPreferences.Editor et = sp.edit();
                    et.putString("key",user);
                    et.putString("pass",pass);
                    et.commit();

                    Intent i = new Intent(ActivityRegister.this,MainActivity.class);
                    startActivity(i);
                }
            }
        });


    }}
