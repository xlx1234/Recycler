package com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.modle.net;

import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.modle.net.Callbake.INetworkCallbake;

/**
 * Created by Lenovo on 2017/10/25.
 */
public interface IHttp {
      <T> void get(String url, INetworkCallbake <T> callbake);
}
