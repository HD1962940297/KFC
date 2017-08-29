package com.example.hdd.loginapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;

public class VipActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView huiyuanname,yue;
    private EditText money;
    private Button button;
    public static String hname;
    private String objectId,mon;
    MainActivity name;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip);
        name = new MainActivity();
        huiyuanname = (TextView) findViewById(R.id.id_huiyuanname);
        money = (EditText) findViewById(R.id.id_money);
        button = (Button) findViewById(R.id.id_button);
        yue = (TextView) findViewById(R.id.id_yue);
        huiyuanname.setText(name.saccount);
        ActivityCollector.addActivity(this);
        Bmob.initialize(this,"4d015c3a30ffb84c15f6fc4464781c52");
        BmobQuery<Student> bmobQuery = new BmobQuery<>();
        hname = name.saccount;
        bmobQuery.addWhereEqualTo("username",hname);
        bmobQuery.findObjects(new FindListener<Student>() {
            @Override
            public void done(List<Student> list, BmobException e) {
                if(e == null){
                    for (Student student:list){
                        mon = student.getVipcard().toString();
                        yue.setText(mon+"元");
                        objectId = student.getObjectId();
                    }
                }else{
                    Toast.makeText(VipActivity.this,"查询余额失败！",Toast.LENGTH_SHORT).show();
                }
            }
        });
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Bmob.initialize(this,"4d015c3a30ffb84c15f6fc4464781c52");
        Student stu = new Student();
        int i = Integer.valueOf(money.getText().toString());
        int j = Integer.valueOf(mon);
        stu.setVipcard(String.valueOf(i+j));
        stu.update(objectId, new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e == null){
                    Toast.makeText(VipActivity.this,"充值成功！",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(VipActivity.this,"充值失败！",Toast.LENGTH_SHORT).show();
                }
            }
        });
        Intent intent = new Intent(VipActivity.this,diandaActivity.class);
        startActivity(intent);
    }
}
