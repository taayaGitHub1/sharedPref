package com.example.sharedprefs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button login,register;
EditText uname,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this gets info from status file
        SharedPreferences obj = getSharedPreferences("status",MODE_PRIVATE);
        boolean check = obj.getBoolean("LoginStatus",false);

        if (check==true){
            Intent i = new Intent(MainActivity.this, ActivityHome.class);
            startActivity(i);
        }
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);

        uname = findViewById(R.id.uname);
        password = findViewById(R.id.password);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, ActivityRegister.class);
                startActivity(i);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = uname.getText().toString();
                String b = password.getText().toString();
                SharedPreferences sp = getSharedPreferences("file", MODE_PRIVATE);
                String user = sp.getString("key", "");
                String pass = sp.getString("pass", "");
                if (a.equals(user) && b.equals(pass)) {
                    //login successful!
                    Toast.makeText(MainActivity.this, "Login successful!",
                            Toast.LENGTH_SHORT).show();
                    // this is for saving status of login
                    SharedPreferences share = getSharedPreferences("status",MODE_PRIVATE);
                    SharedPreferences.Editor edit = share.edit();
                    edit.putBoolean("LoginStatus",true);
                    edit.commit();

                    Intent i = new Intent(MainActivity.this,ActivityHome.class);
                    startActivity(i);

                    finish();

                } else {
                    Toast.makeText(MainActivity.this, "Invalid credentials",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

    }}