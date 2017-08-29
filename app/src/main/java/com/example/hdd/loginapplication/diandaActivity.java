package com.example.hdd.loginapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.bmob.v3.socketio.I;

public class diandaActivity extends AppCompatActivity implements View.OnClickListener {

    private Button dabao;
    private Button diancan;
    private Button vip;
    private Button youhui;
    private long exitTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dianda);
        dabao =  (Button) findViewById(R.id.id_dabao);
        diancan = (Button) findViewById(R.id.id_diancan);
        vip = (Button) findViewById(R.id.id_vip);
        youhui = (Button) findViewById(R.id.id_youhui);
        dabao.setOnClickListener(this);
        diancan.setOnClickListener(this);
        vip.setOnClickListener(this);
        youhui.setOnClickListener(this);
        ActivityCollector.addActivity(this);       //把当前正在创建的活动添加到活动管理器中
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                ActivityCollector.finishAll();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_diancan:
                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);break;
            case R.id.id_dabao:
                Intent intent2 = new Intent(this,Main3Activity.class);
                startActivity(intent2);break;
            case R.id.id_vip:
                Intent intent3 = new Intent(this,VipActivity.class);
                startActivity(intent3);break;
            case R.id.id_youhui:
                Intent intent4 = new Intent(this,youhuiquanActivity.class);
                startActivity(intent4);
        }
    }
}
