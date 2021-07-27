package com.example.userapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText uname_edt,pass_edt;
    Button loginbtn, signupbtn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DBHelper(this);
        uname_edt = (EditText) findViewById(R.id.et_un_mainctivity);
        pass_edt = (EditText) findViewById(R.id.et_pw_mainactivity);
        loginbtn = (Button) findViewById(R.id.btn_login_mainactivity);
        signupbtn = (Button) findViewById(R.id.btn_signup_mainactivity);


        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(i);
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=uname_edt.getText().toString();
                String pass=pass_edt.getText().toString();
                boolean res=db.checklogin(user,pass);
                if (res == true){
                    Toast.makeText(LoginActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this, DisplayActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}