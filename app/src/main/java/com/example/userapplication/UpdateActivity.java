package com.example.userapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class UpdateActivity extends AppCompatActivity {

    TextView txtid,fntxt, lntxt, emailtxt, untxt, passtxt, gentxt, utypetxt, hobby1txt, hobby2txt, hobby3txt;
    FloatingActionButton floatingActionButton;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        fntxt = (TextView) findViewById(R.id.fn_tv_details);
        lntxt = (TextView) findViewById(R.id.ln_tv_details);
        emailtxt = (TextView) findViewById(R.id.email_tv_details);
        untxt = (TextView) findViewById(R.id.un_tv_details);
        passtxt = (TextView) findViewById(R.id.pwd_tv_details);
        gentxt = (TextView) findViewById(R.id.gen_tv_details);
        utypetxt = (TextView) findViewById(R.id.utype_tv_details);
        hobby1txt = (TextView) findViewById(R.id.hobbie1_tv_details);
        hobby2txt = (TextView) findViewById(R.id.hobbie2_tv_details);
        hobby3txt = (TextView) findViewById(R.id.hobbie3_tv_details);
         txtid=(TextView)findViewById(R.id.regid);


        //String strid=getIntent().getStringExtra("ID");
       // ArrayList<User> user=db.selectbyId();
        db=new DBHelper(UpdateActivity.this);
        Intent i=getIntent();
        int strid=i.getIntExtra("id",0);
        String fname=i.getStringExtra("Fname");
        String lname=i.getStringExtra("Lname");
        String email=i.getStringExtra("Email");
        String uname=i.getStringExtra("Uname");
        String pass=i.getStringExtra("Password");
        String gen=i.getStringExtra("Gender");
        String utype=i.getStringExtra("Usertype");
        String hobby1=i.getStringExtra("Hobby1");
        String hobby2=i.getStringExtra("Hobby2");
        String hobby3=i.getStringExtra("Hobby3");
        txtid.setText(""+strid);
        fntxt.setText(fname);
        lntxt.setText(lname);
        emailtxt.setText(email);
        untxt.setText(uname);
        passtxt.setText(pass);
        gentxt.setText(gen);
        utypetxt.setText(utype);
        hobby1txt.setText(hobby1);
        hobby2txt.setText(hobby2);
        hobby3txt.setText(hobby3);


        floatingActionButton=findViewById(R.id.update_btn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




    }

}
