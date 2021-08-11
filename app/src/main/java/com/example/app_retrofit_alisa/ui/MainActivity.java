package com.example.app_retrofit_alisa.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app_retrofit_alisa.R;
import com.example.app_retrofit_alisa.data.ModelDo;
import com.example.app_retrofit_alisa.data.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView activity;
    private Button btnGo;
    private ImageView heart;
    private TextView price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        btnGo.setOnClickListener(v -> {
            RetrofitBuilder.getInstance().getActivities().enqueue(new Callback<ModelDo>() {
                @Override
                public void onResponse(Call<ModelDo> call, Response<ModelDo> response) {
                    if (response.isSuccessful() && response.body() != null){
                        activity.setText(response.body().getActivity());
                        price.setText(String.valueOf(response.body().getPrice() +" dollars"));
                    }
                }

                @Override
                public void onFailure(Call<ModelDo> call, Throwable t) {

                }
            });
        });

    }

    private void initView() {
        heart = findViewById(R.id.heart);
        price = findViewById(R.id.price);
        activity = findViewById(R.id.activity);
        btnGo = findViewById(R.id.btnGo);

    }
}