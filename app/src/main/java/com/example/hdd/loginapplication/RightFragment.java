package com.example.hdd.loginapplication;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class RightFragment extends Fragment implements View.OnClickListener {

    TextView text;
    Button jiesuan;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_right,container,false);
        text = (TextView) view.findViewById(R.id.id_rightText);
        jiesuan = (Button) view.findViewById(R.id.id_jiesuan);
        jiesuan.setOnClickListener(this);
        text.setText("已选");
        return view;
    }

    @Override
    public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ZhufuActivity.class);
                startActivity(intent);
    }
}
