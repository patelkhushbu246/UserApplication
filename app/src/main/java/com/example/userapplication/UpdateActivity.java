package com.example.userapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class UpdateActivity extends AppCompatActivity {

    TextView fntxt,lntxt,emailtxt,untxt,passtxt,gentxt,utypetxt,hobby1txt,hobby2txt,hobby3txt;
    User user;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        fntxt=(TextView)findViewById(R.id.fn_tv_details);
        lntxt=(TextView)findViewById(R.id.ln_tv_details);
        emailtxt=(TextView)findViewById(R.id.email_tv_details);
        untxt=(TextView)findViewById(R.id.un_tv_details);
        passtxt=(TextView)findViewById(R.id.pwd_tv_details);
        gentxt=(TextView)findViewById(R.id.gen_tv_details);
        utypetxt=(TextView)findViewById(R.id.utype_tv_details);
        hobby1txt=(TextView)findViewById(R.id.hobbie1_tv_details);
        hobby2txt=(TextView)findViewById(R.id.hobbie2_tv_details);
        hobby3txt=(TextView)findViewById(R.id.hobbie3_tv_details);
        String strid=getIntent().getStringExtra("ID");
        db=new DBHelper(this);
        user=db.selectbyId(Integer.parseInt(strid));
        fntxt.setText(user.getFname());
        lntxt.setText(user.getLname());
        emailtxt.setText(user.getEmail());
        untxt.setText(user.getUname());
        passtxt.setText(user.getPass());
        gentxt.setText(user.getGender());
        utypetxt.setText(user.getUtype());
        hobby1txt.setText(user.getHobby1());
        hobby2txt.setText(user.getHobby2());
        hobby3txt.setText(user.getHobby3());
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