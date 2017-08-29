package com.example.hdd.loginapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText account;
    private EditText password;
    private Button login;
    private Button zhuce;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox rememberPass;
    public static String saccount;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        account = (EditText) findViewById(R.id.account);
        password = (EditText) findViewById(R.id.password);
        rememberPass = (CheckBox) findViewById(R.id.checkbox);
        login = (Button) findViewById(R.id.loginbutton);
        zhuce = (Button) findViewById(R.id.id_login);
        progressBar = (ProgressBar) findViewById(R.id.id_progressbar);
        ActivityCollector.addActivity(this);       //把当前正在创建的活动添加到活动管理器中
        boolean isRemember = pref.getBoolean("remember_password",false);
        if(isRemember){
            String a = pref.getString("a","");
            String p = pref.getString("p","");
            account.setText(a);
            password.setText(p);
            rememberPass.setChecked(true);
        }
        login.setOnClickListener(this);
        zhuce.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginbutton:
                if(progressBar.getVisibility() == View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                }else{
                    progressBar.setVisibility(View.GONE);
                }
                Bmob.initialize(MainActivity.this,"4d015c3a30ffb84c15f6fc4464781c52");
                BmobUser user = new BmobUser();
                final String sAccount = account.getText().toString();
                final String sPassword = password.getText().toString();
                user.setUsername(sAccount);
                user.setPassword(sPassword);
                user.login(new SaveListener<BmobUser>() {
                    @Override
                    public void done(BmobUser bmobUser, BmobException e) {
                        if (e == null) {
                            Toast.makeText(MainActivity.this,"登录成功！",Toast.LENGTH_SHORT).show();
                            editor = pref.edit();
                            if(rememberPass.isChecked()){
                                editor.putBoolean("remember_password",true);
                                editor.putString("a",sAccount);
                                editor.putString("p",sPassword);
                            }else{
                                editor.clear();
                            }
                            editor.apply();
                            saccount = account.getText().toString();
                            Intent intent = new Intent(MainActivity.this,diandaActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this,"登录失败，请检查用户名和密码是否正确",Toast.LENGTH_SHORT).show();
                            if(progressBar.getVisibility() == View.GONE){
                                progressBar.setVisibility(View.VISIBLE);
                            }else{
                                progressBar.setVisibility(View.GONE);
                            }
                        }
                    }
                });break;
            case R.id.id_login:
                Intent intent1 = new Intent(MainActivity.this,Sign.class);
                startActivity(intent1);break;
        }
    }
}
