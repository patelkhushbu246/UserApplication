package com.example.userapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListAdapter extends ArrayAdapter {

    List list=new ArrayList();
    public ListAdapter(Context context, int resource) {
        super(context, resource);

    }
    static class LayoutHandler{
        TextView fname_tv,lname_tv,gender_tv,hobby_tv;
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;
        LayoutHandler lh;
        if (row==null){
            LayoutInflater inflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.listview,parent,false);
            lh=new LayoutHandler();
            lh.fname_tv=(TextView)row.findViewById(R.id.tv_fname_dispay);
            lh.lname_tv=(TextView)row.findViewById(R.id.tv_lname_dispay);
            lh.gender_tv=(TextView)row.findViewById(R.id.tv_gender_dispay);
            lh.hobby_tv=(TextView)row.findViewById(R.id.tv_hobby_dispay);
            row.setTag(lh);
        }else {
            lh=(LayoutHandler)row.getTag();
        }
        User u=(User)this.getItem(position);
        lh.fname_tv.setText(u.getFname());
        lh.lname_tv.setText(u.getLname());
        lh.gender_tv.setText(u.getGender());
        lh.hobby_tv.setText(u.getHobby1());
        lh.hobby_tv.setText(u.getHobby2());
        lh.hobby_tv.setText(u.getHobby3());
        return row;

    }
}
