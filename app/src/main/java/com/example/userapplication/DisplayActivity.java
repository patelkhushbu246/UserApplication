package com.example.userapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    ListView lv;
    //create ListAdapter class reference
    ListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        lv=(ListView)findViewById(R.id.lv_item);
        DBHelper db=new DBHelper(getApplicationContext());
        SQLiteDatabase sqLiteDatabase=db.getReadableDatabase();
        Cursor c=db.retrivedata();
        listAdapter=new ListAdapter(getApplicationContext(),R.layout.listview);
        lv.setAdapter(listAdapter);
        if (c.moveToFirst()){
            do {
                String fname,lname,gender,hobby1,hobby2,hobby3;
                fname=c.getString(1);
                lname=c.getString(2);
                gender=c.getString(6);
                hobby1=c.getString(8);
                hobby2=c.getString(9);
                hobby3=c.getString(10);
                User u=new User(fname,lname,gender,hobby1,hobby2,hobby3);
                listAdapter.add(u);


            }
            while (c.moveToNext());
        }
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(DisplayActivity.this,UpdateActivity.class);
                startActivity(i);
               /* User u=arrayList.get(position);
                Intent i=new Intent(DisplayActivity.this,UpdateActivity.class);
                String fname=u.getFname();
                String lname=u.getLname();
                String gender=u.getGender();
                String hobby1=u.getHobby1();
                String hobby2=u.getHobby2();
                String hobby3=u.getHobby3();
                i.putExtra("Fname",fname);
                i.putExtra("Lname",lname);
                i.putExtra("Gender",gender);
                if (hobby1.equals("")||hobby2.equals("")) {
                    i.putExtra("Hobby1", hobby1);
                    i.putExtra("Hobby2",hobby2);
                }
                else {
                    i.putExtra("Hobby3", hobby3);
                }
                startActivity(i);
                finish();*/

            }
        });

    }
}