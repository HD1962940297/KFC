package com.example.hdd.loginapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity{

    private TextView zhuohao,haozhun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        zhuohao = (TextView) findViewById(R.id.id_zhunhao);
        haozhun = (TextView) findViewById(R.id.id_haozhun);
        Intent intent = getIntent();
        String s = intent.getStringExtra("key");
        zhuohao.setText(s);
        haozhun.setText("号桌");
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

}
