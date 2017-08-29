package com.example.hdd.loginapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LeftFragment extends Fragment implements ListView.OnItemClickListener{

    public List<Food> foodList = new ArrayList<>();
    public int sum;
    public static String s;
    private  List<Shangpin> shangpins = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_left, container, false);
        initFoods();
        FoodAdapter a = new FoodAdapter(getActivity(), R.layout.food_item, foodList);
        ListView listView = (ListView) view.findViewById(R.id.id_list);
        listView.setOnItemClickListener(this);
        listView.setAdapter(a);
        sum = 0;
        return view;
    }

    private void initFoods() {
            Food hanbao = new Food("汉堡","12", R.drawable.hamburger);
            foodList.add(hanbao);
            Food jichi = new Food("鸡翅","10", R.drawable.jichi);
            foodList.add(jichi);
            Food shutiao = new Food("薯条","20",R.drawable.shutiao);
            foodList.add(shutiao);
            Food kele = new Food("可乐","10",R.drawable.kele);
            foodList.add(kele);
            Food fenda = new Food("芬达","10",R.drawable.fengda);
            foodList.add(fenda);
            Food guozhen = new Food("果珍","10",R.drawable.guozhen);
            foodList.add(guozhen);
            Food quanjiatong = new Food("全家桶","25",R.drawable.quanjiatong);
            foodList.add(quanjiatong);
            Food jimihua = new Food("鸡米花","15",R.drawable.jimihua);
            foodList.add(jimihua);
            Food yuanweidanta = new Food("原味蛋挞","25",R.drawable.yuanweidanta);
            foodList.add(yuanweidanta);
            Food putao = new Food("葡萄蛋挞","10",R.drawable.putaodanta);
            foodList.add(putao);
            Food shangxiao = new Food("上校鸡块","15",R.drawable.shangxiaojikuai);
            foodList.add(shangxiao);
            Food xinaoer = new Food("新奥尔良烤翅","15",R.drawable.xinaoerliang);
            foodList.add(xinaoer);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Food f = foodList.get(position);
        ListView list = (ListView) getActivity().findViewById(R.id.id_list2);
        Shangpin data = new Shangpin(f.getName()+"      +1");
        shangpins.add(data);
        ShangpinAdapter adapter = new ShangpinAdapter(getActivity(),R.layout.shangpin,shangpins);
        list.setAdapter(adapter);
        sum += Integer.valueOf(f.getPrice());
        s = String.valueOf(sum);
        Toast.makeText(getActivity(),"共"+s+"元",Toast.LENGTH_SHORT).show();
    }
}
