package com.example.hdd.loginapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ZhufuActivity extends AppCompatActivity implements View.OnClickListener {

    Button xianjin,scan;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhufu);
        xianjin = (Button) findViewById(R.id.id_xianjin);
        scan = (Button) findViewById(R.id.id_scan);
        textView = (TextView) findViewById(R.id.id_Text);
        xianjin.setOnClickListener(this);
        scan.setOnClickListener(this);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        final IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                textView.setText(result.getContents());
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_xianjin:
                Intent intent1 = new Intent(this,jiesuanActivity.class);
                startActivity(intent1);break;
            case R.id.id_scan:IntentIntegrator integrator = new IntentIntegrator(this);
                integrator.setCaptureActivity(ScanActivity.class);
                integrator.setPrompt("请扫描用于支付的二维码"); //底部的提示文字，设为""可以置空
                integrator.setCameraId(0); //前置或者后置摄像头
                integrator.setBeepEnabled(true); //扫描成功的「哔哔」声，默认开启
                integrator.initiateScan();
        }
    }
}
