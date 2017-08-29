package com.example.hdd.loginapplication;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ShangpinAdapter extends ArrayAdapter{
    private int resourceId;

    public ShangpinAdapter(Context context, int textViewResourceId, List<Shangpin> objects) {
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Shangpin shangpin = (Shangpin) getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }else {
            view = convertView;
        }
        TextView shangpinName = (TextView) view.findViewById(R.id.id_shangpin);
        shangpinName.setText(shangpin.getName());
        return view;
    }
}
