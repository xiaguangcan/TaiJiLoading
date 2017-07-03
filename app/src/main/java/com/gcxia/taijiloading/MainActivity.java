package com.gcxia.taijiloading;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gcxia.taijiloading.widget.TaiJiLoading;

public class MainActivity extends AppCompatActivity {

    private TaiJiLoading tjTaijiLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tjTaijiLoading = (TaiJiLoading) findViewById(R.id.tj_taiji_loading);
        tjTaijiLoading.startTaiJi();
    }
}
