package com.example.app_retrofit_alisa.data;

import android.widget.TextView;

import com.google.gson.annotations.SerializedName;

public class ModelDo {

@SerializedName("key")
    private String key;

@SerializedName("activity")
    private String activity;

@SerializedName("price")
 private double price;

    public  String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key= key;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
