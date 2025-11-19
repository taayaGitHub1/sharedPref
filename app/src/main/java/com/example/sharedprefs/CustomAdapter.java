package com.example.sharedprefs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    ArrayList<DatabaseModel> globaldata = new ArrayList<>();
    Context globalcontext;
    public CustomAdapter(ActivityHome activityHome, ArrayList<DatabaseModel> data) {
        globaldata = data;
        globalcontext = activityHome;
    }

    @Override
    public int getCount() {
        return globaldata.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(globalcontext).inflate(R.layout.view_data,null);
        TextView name = convertView.findViewById(R.id.Name);
        TextView faculty =convertView.findViewById(R.id.Faculty);
        TextView address = convertView.findViewById(R.id.Address);
        name.setText(globaldata.get(position).getName());
        faculty.setText(globaldata.get(position).getFaculty());
        address.setText(globaldata.get(position).getAddress());
        return convertView;
    }
}
