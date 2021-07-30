package com.example.userapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListAdapter extends BaseAdapter {

    ArrayList<User>arruser;
     Activity act;

    public  ListAdapter(Activity act,ArrayList<User>arruser){
        this.act=act;
        this.arruser=arruser;
    }


    @Override
    public int getCount() {
        return arruser.size();
    }

    @Override
    public Object getItem(int position) {
        return arruser.get(position);
    }

    @Override
    public long getItemId(int i) {
        return arruser.get(i).getId();
    }

    private class ViewHolder{
        TextView fname_tv,lname_tv,gender_tv,hobby_tv;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder vh;
        LayoutInflater inflater=act.getLayoutInflater();
        //LayoutInflater inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            view = inflater.inflate(R.layout.listview,null);
            vh = new ViewHolder();
            vh.fname_tv = (TextView) view.findViewById(R.id.tv_fname_dispay);
            vh.lname_tv = (TextView) view.findViewById(R.id.tv_lname_dispay);
            vh.gender_tv = (TextView) view.findViewById(R.id.tv_gender_dispay);
            vh.hobby_tv = (TextView) view.findViewById(R.id.tv_hobby_dispay);
           // vh.regid_tv = (TextView) view.findViewById(R.id.regid);
            view.setTag(vh);
         }else {
            vh=(ViewHolder)view.getTag();
        }
        vh.fname_tv.setText(arruser.get(i).getFname());
        vh.lname_tv.setText(arruser.get(i).getLname());
        vh.gender_tv.setText(arruser.get(i).getGender());
        //if (arruser.get(i).getHobby1().equals("movies"))
            vh.hobby_tv.setText(arruser.get(i).getHobby1());
       // if (arruser.get(i).getHobby1().equals("music"))
            vh.hobby_tv.setText(arruser.get(i).getHobby2());
       // if (arruser.get(i).getHobby1().equals("travelling"))
            vh.hobby_tv.setText(arruser.get(i).getHobby3());
        //vh.regid_tv.setText(arruser.get(i).getId()+"");

        return view;
    }
}
