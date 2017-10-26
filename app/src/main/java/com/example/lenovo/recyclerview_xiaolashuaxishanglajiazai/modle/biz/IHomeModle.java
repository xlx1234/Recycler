package com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.modle.biz;

import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.modle.net.Callbake.INetworkCallbake;

/**
 * Created by Lenovo on 2017/10/25.
 */
public interface IHomeModle {
    <T> void listModle(INetworkCallbake<T> callbake);

}
