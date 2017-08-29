package com.example.hdd.loginapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class Sign extends AppCompatActivity implements View.OnClickListener {

    private EditText edit_name;
    private EditText edit_password;
    private EditText edit_adress;
    private EditText edit_email;
    private Button enterzhuce;
    private EditText edit_password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        edit_name = (EditText) findViewById(R.id.editId_name);
        edit_password = (EditText) findViewById(R.id.editId_password);
        edit_password2 = (EditText) findViewById(R.id.editId_password2);
        edit_adress = (EditText) findViewById(R.id.editId_adress);
        edit_email = (EditText) findViewById(R.id.editId_email);
        enterzhuce = (Button) findViewById(R.id.id_enterzhuce);
        enterzhuce.setOnClickListener(this);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    @Override
    public void onClick(View v) {
        String sName = edit_name.getText().toString();
        String sPassword = edit_password.getText().toString();
        String sPassword2 = edit_password2.getText().toString();
        String sAdress = edit_adress.getText().toString();
        String sEmail = edit_email.getText().toString();
        if(TextUtils.isEmpty(sName)||TextUtils.isEmpty(sPassword)){
            Toast.makeText(Sign.this,"密码或账户不能为空",Toast.LENGTH_SHORT).show();
        }else {
            if (sPassword.equals(sPassword2)) {
                Bmob.initialize(this, "4d015c3a30ffb84c15f6fc4464781c52");
                Student stu = new Student();
                stu.setUsername(sName);
                stu.setPassword(sPassword);
                stu.setAddress(sAdress);
                stu.setEmail(sEmail);
                stu.setVipcard(String.valueOf(0));
                stu.signUp(new SaveListener<String>() {
                    @Override
                    public void done(String objectId, BmobException e) {
                        if (e != null) {
                            Toast.makeText(Sign.this, "添加数据成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Sign.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Sign.this, "创建数据失败：" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } else {
                Toast.makeText(Sign.this, "密码或账户不能为空或两次输入的密码不相同，请重新输入！", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
