package com.example.hdd.loginapplication;

import android.util.Log;
import android.widget.Toast;
import cn.bmob.v3.BmobUser;


public class Student extends BmobUser{
    private String age;
    private String address;
    private String vipcard;

    public String getVipcard() {
        return vipcard;
    }

    public void setVipcard(String vipcard) {
        this.vipcard = vipcard;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAge(){
        return age;
    }

    public void setAge(String age){
        this.age = age;
    }
}
