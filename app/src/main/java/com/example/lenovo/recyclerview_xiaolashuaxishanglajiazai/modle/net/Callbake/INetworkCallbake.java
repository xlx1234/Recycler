package com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.modle.net.Callbake;

/**
 * Created by Lenovo on 2017/10/25.
 */
public interface INetworkCallbake <T>  {
    void onSuccee(T t);
    void  onError(String msg);
}
