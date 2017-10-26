package com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.modle.biz;

import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.config.Usrl;
import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.modle.net.Callbake.INetworkCallbake;
import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.modle.net.HttpFractry;

/**
 * Created by Lenovo on 2017/10/25.
 */
public class HomeModle implements IHomeModle {
    @Override
    public <T> void listModle(INetworkCallbake<T> callbake) {
        HttpFractry.create().get(Usrl.BASEURL,callbake);
    }
}
