package com.example.userapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION=1;
    private static final String DB_NAME="registrationdb";
    private static final String TABLE_REG="registrationdetails";
    private static final String KEY_ID="ID";
    private static final String KEY_FNAME="Fname";
    private static final String KEY_LNAME="Lname";
    private static final String KEY_EMAIL="Email";
    private static final String KEY_UNAME="Uname";
    private static final String KEY_PASS="Password";
    private static final String KEY_GENDER="Gender";
    private static final String KEY_USERTYPE="Usertype";
    private static final String KEY_HOBBY1="Hobby1";
    private static final String KEY_HOBBY2="Hobby2";
    private static final String KEY_HOBBY3="Hobby3";


    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+TABLE_REG+"("+KEY_ID+" INTEGER PRIMARY KEY,"+KEY_FNAME+" TEXT,"+KEY_LNAME+" TEXT,"+KEY_EMAIL+
                " TEXT,"+KEY_UNAME+" TEXT,"+KEY_PASS+" TEXT,"+KEY_GENDER+" TEXT,"+KEY_USERTYPE+" TEXT,"+KEY_HOBBY1+" TEXT,"+KEY_HOBBY2+
                " TEXT,"+KEY_HOBBY3+" TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_REG+"");
        onCreate(db);

    }
    public long adduser(String fname,String lname,String email,String uname, String pass,String gen,String utype,String hobby1,String hobby2,String hobby3){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("Fname",fname);
        cv.put("Lname",lname);
        cv.put("Email",email);
        cv.put("Uname",uname);
        cv.put("Password",pass);
        cv.put("Gender",gen);
        cv.put("Usertype",utype);
        cv.put("Hobby1",hobby1);
        cv.put("Hobby2",hobby2);
        cv.put("Hobby3",hobby3);
        long res=db.insert(TABLE_REG,null,cv);
        db.close();
        return res;
    }
    public boolean checklogin(String username, String password){
        String[] column={KEY_ID};
        SQLiteDatabase db=this.getReadableDatabase();
        String selection=KEY_UNAME+"=?"+"AND "+KEY_PASS+"=?";
        String[] selectionArgs={username,password};
        Cursor c=db.query("registrationdetails",column,selection,selectionArgs,null,null,null);
        int res=c.getCount();
        db.close();
        if(res>0)
            return true;
        else
            return false;
    }
}

