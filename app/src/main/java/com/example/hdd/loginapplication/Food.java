package com.example.hdd.loginapplication;


public class Food {
    private String name;
    private int imageId;
    private String price;

    public Food(String name,String price,int imageId){
        this.name = name;
        this.imageId = imageId;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }

    public String getPrice(){
        return price;
    }
}
