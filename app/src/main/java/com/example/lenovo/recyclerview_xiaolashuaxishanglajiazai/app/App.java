package com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.app;

import android.app.Application;

import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.base.BaseActivity;

/**
 * Created by Lenovo on 2017/10/25.
 */
public class App extends Application {
    public static BaseActivity context;
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
