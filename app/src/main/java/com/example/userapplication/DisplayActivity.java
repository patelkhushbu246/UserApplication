package com.example.userapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<User> arr;
    //create ListAdapter class reference
    ListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        lv=(ListView)findViewById(R.id.lv_item);
        DBHelper db=new DBHelper(getApplicationContext());
        arr=db.retrivedata();
        listAdapter=new ListAdapter(this,arr);
        lv.setAdapter(listAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               /* Intent i=new Intent(DisplayActivity.this,UpdateActivity.class);
                startActivity(i);*/
                TextView txtid=(TextView)findViewById(R.id.regid);
                String str=txtid.getText().toString().trim();
                Intent i=new Intent(DisplayActivity.this,UpdateActivity.class);
                i.putExtra("ID",str);
               /* i.putExtra("Fname",str);
                i.putExtra("Lname",str);
                i.putExtra("Email",str);
                i.putExtra("Password",str);
                i.putExtra("Gender",str);
                i.putExtra("Usertype",str);
                i.putExtra("Hobby1",str);
                i.putExtra("Hobby2",str);
                i.putExtra("Hobby3",str);*/

                startActivity(i);

            }
        });

    }
}