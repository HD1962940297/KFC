package com.example.hdd.loginapplication;

import android.os.Bundle;

import com.journeyapps.barcodescanner.CaptureActivity;

public class ScanActivity extends CaptureActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

}
