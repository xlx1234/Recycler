package com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.app.App;

/**
 * Created by Lenovo on 2017/10/25.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        App.context=this;
        init();
        loadData();
    }
    protected abstract int getLayout();
    protected abstract void loadData();

    protected abstract void init();


}
