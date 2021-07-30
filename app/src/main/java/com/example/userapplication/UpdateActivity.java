package com.example.userapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class UpdateActivity extends AppCompatActivity {

    TextView txtid,fntxt, lntxt, emailtxt, untxt, passtxt, gentxt, utypetxt, hobby1txt, hobby2txt, hobby3txt;


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

                /*fntxt.setText(user.getString(1));
                lntxt.setText(user.getString(2));
                emailtxt.setText(user.getString(3));
                untxt.setText(user.getString(4));
                passtxt.setText(user.getString(5));
                gentxt.setText(user.getString(6));
                utypetxt.setText(user.getString(7));
                hobby1txt.setText(user.getString(8));
                hobby2txt.setText(user.getString(9));
                hobby3txt.setText(user.getString(10));*/
       /* emailtxt.setText(user.getEmail());
        untxt.setText(user.getUname());
        passtxt.setText(user.getPass());
        gentxt.setText(user.getGender());
        utypetxt.setText(user.getUtype());
        hobby1txt.setText(user.getHobby1());
        hobby2txt.setText(user.getHobby2());
        hobby3txt.setText(user.getHobby3());*/




       /* Cursor c= (Cursor) db.selectbyId();
        if (c.moveToNext()) {
            id = getIntent().getExtras().getInt("id");
            String fname = getIntent().getExtras().getString("Fname");
            String lname = getIntent().getExtras().getString("Lname");
            String email = getIntent().getExtras().getString("Email");
            String uname = getIntent().getExtras().getString("Uname");
            String pass = getIntent().getExtras().getString("Pass");
            String gen = getIntent().getExtras().getString("Gender");
            String utype = getIntent().getExtras().getString("Utype");
            String hobby1 = getIntent().getExtras().getString("Hobby1");
            String hobby2 = getIntent().getExtras().getString("Hobby2");
            String hobby3 = getIntent().getExtras().getString("Hobby3");
            User u=new User(fname,lname,email,uname,pass,gen,utype,hobby1,hobby2,hobby3);
            fntxt.setText(u.getFname());
            lntxt.setText(u.getLname());
            emailtxt.setText(u.getEmail());
            untxt.setText(u.getUname());
            passtxt.setText(u.getPass());
            gentxt.setText(u.getGender());
            utypetxt.setText(u.getUtype());
            hobbytxt.setText(u.getHobby1());
            hobbytxt.setText(u.getHobby2());
            hobbytxt.setText(u.getHobby3());
        }*/





    }

}
