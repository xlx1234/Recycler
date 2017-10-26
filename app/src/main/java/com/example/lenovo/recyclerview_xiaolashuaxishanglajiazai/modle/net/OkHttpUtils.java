package com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.modle.net;

import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.app.App;
import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.modle.net.Callbake.INetworkCallbake;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Lenovo on 2017/10/25.
 */
public class OkHttpUtils implements IHttp {
    private OkHttpClient okHttpClient;

    private OkHttpUtils() {
        okHttpClient = new OkHttpClient();
    }

    private static OkHttpUtils okHttpUtils;

    public static OkHttpUtils getInstance() {
        if (okHttpUtils == null) {
            synchronized (OkHttpUtils.class) {
                if (okHttpUtils == null) {
                    okHttpUtils = new OkHttpUtils();
                }
            }
        }
        return okHttpUtils;
    }

    @Override
    public <T> void get(String url, final INetworkCallbake<T> callbake) {
        Request request=new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callbake.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                      callbake.onSuccee(getGeneric(string,callbake));
                    }
                });
            }
        });
    }
    private <T> T getGeneric(String jsonData,INetworkCallbake<T> callBack) {
        Gson gson = new Gson();
        //通过反射获取泛型的实例
        Type[] types = callBack.getClass().getGenericInterfaces();//得到这个类所实现的所有接口的集合
        Type[] actualTypeArguments = ((ParameterizedType) types[0]).getActualTypeArguments();//获取该接口中所有的参数
        Type type = actualTypeArguments[0];//取第一个参数，就是对应JavaBean
        T t = gson.fromJson(jsonData, type);//通过gson转到对应的JavaBean
        return t;

    }
}
