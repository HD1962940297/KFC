package com.example.hdd.loginapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
    public String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);
        b10 = (Button) findViewById(R.id.button10);
        b11 = (Button) findViewById(R.id.button11);
        b12 = (Button) findViewById(R.id.button12);
        b13= (Button) findViewById(R.id.button13);
        b14 = (Button) findViewById(R.id.button14);
        b15 = (Button) findViewById(R.id.button15);
        b16 = (Button) findViewById(R.id.button16);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b13.setOnClickListener(this);
        b14.setOnClickListener(this);
        b15.setOnClickListener(this);
        b16.setOnClickListener(this);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                s = b1.getText().toString();break;
            case R.id.button2:
                s = b2.getText().toString();break;
            case R.id.button3:
                s = b3.getText().toString();break;
            case R.id.button4:
                s = b4.getText().toString();break;
            case R.id.button5:
                s = b5.getText().toString();break;
            case R.id.button6:
                s = b6.getText().toString();break;
            case R.id.button7:
                s = b7.getText().toString();break;
            case R.id.button8:
                s = b8.getText().toString();break;
            case R.id.button9:
                s = b9.getText().toString();break;
            case R.id.button10:
                s = b10.getText().toString();break;
            case R.id.button11:
                s = b11.getText().toString();break;
            case R.id.button12:
                s = b12.getText().toString();break;
            case R.id.button13:
                s = b13.getText().toString();break;
            case R.id.button14:
                s = b14.getText().toString();break;
            case R.id.button15:
                s = b15.getText().toString();break;
            case R.id.button16:
                s = b16.getText().toString();break;
        }
        Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
        intent.putExtra("key",s);
        startActivity(intent);
    }
}
