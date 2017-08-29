package com.example.hdd.loginapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FoodAdapter extends ArrayAdapter<Food> {

    private int resourceId;

    public FoodAdapter(Context context, int textViewResourceId, List<Food> objects){
        super(context,textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        Food food = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }else{
            view = convertView;
        }
        ImageView foodImage = (ImageView) view.findViewById(R.id.id_foodImage);
        TextView foodName = (TextView) view.findViewById(R.id.id_foodName);
        TextView foodPrice = (TextView) view.findViewById(R.id.id_foodPrice);
        foodImage.setImageResource(food.getImageId());
        foodName.setText(food.getName());
        foodPrice.setText(food.getPrice());
        return view;
    }
}
