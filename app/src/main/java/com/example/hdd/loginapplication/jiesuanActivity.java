package com.example.hdd.loginapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import   java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;

public class jiesuanActivity extends AppCompatActivity implements View.OnClickListener {

    private Button dayin,queren;
    int you_money = 0;
    TextView zongji,zhaoling,data,youhui;
    String id;
    public static String mon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiesuan);
        dayin = (Button) findViewById(R.id.id_dayin);
        zongji = (TextView) findViewById(R.id.id_zongji);
        zhaoling = (TextView) findViewById(R.id.id_zhaoling);
        data = (TextView) findViewById(R.id.id_data);
        queren = (Button) findViewById(R.id.id_queren);
        youhui = (TextView) findViewById(R.id.id_youhui);
        dayin.setOnClickListener(this);
        queren.setOnClickListener(this);
        ActivityCollector.addActivity(this);
        Bmob.initialize(this,"4d015c3a30ffb84c15f6fc4464781c52");
        BmobQuery<Student> bmobQuery = new BmobQuery<>();
        bmobQuery.addWhereEqualTo("username",MainActivity.saccount);
        bmobQuery.findObjects(new FindListener<Student>() {
            @Override
            public void done(List<Student> list, BmobException e) {
                if(e == null) {
                    if(list == null){
                        Toast.makeText(jiesuanActivity.this, "xxxxxx！", Toast.LENGTH_SHORT).show();
                    }else{
                        for (Student student : list) {
                            mon = student.getVipcard();
                            id = student.getObjectId();
                            youhui.setText(mon+"元");
                        }
                    }

                }else{
                    Toast.makeText(jiesuanActivity.this, "失败！", Toast.LENGTH_SHORT).show();
                }
            }
        });
        zongji.setText(LeftFragment.s+"元");
        SimpleDateFormat formatter = new SimpleDateFormat   ("yyyy年MM月dd日   HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        data.setText(str);
        AlertDialog.Builder dialog = new AlertDialog.Builder(jiesuanActivity.this);
        dialog.setTitle("优惠服务");
        dialog.setMessage("您有一张30元的优惠券可使用！");
        dialog.setCancelable(false);
        dialog.setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                you_money = 30;
            }
        });
        dialog.setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        dialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_queren:
                int j = Integer.valueOf(mon);
                int k = Integer.valueOf(LeftFragment.s);
                if(j >= 0.8*(k-you_money)){
                    Bmob.initialize(this,"4d015c3a30ffb84c15f6fc4464781c52");
                    Student stu = new Student();
                    int yue = (int) (j - 0.8*(k-you_money));
                    String y = String.valueOf(yue);
                    stu.setVipcard(y);
                    stu.update(id, new UpdateListener() {
                        @Override
                        public void done(BmobException e) {
                            if(e == null){
                            }else{
                            }
                        }
                    });
                    zhaoling.setText(y+"元");
                }else{
                    Toast.makeText(jiesuanActivity.this,"余额不足，请充值！",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.id_dayin:
                Toast.makeText(jiesuanActivity.this, "正在打印小票，请稍候！", Toast.LENGTH_SHORT).show();break;
        }
    }
}
