package com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.persenter;

import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.modle.biz.HomeModle;
import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.modle.biz.IHomeModle;
import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.modle.entiry.ModleData;
import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.modle.net.Callbake.INetworkCallbake;
import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.view.IViewActivity;

/**
 * Created by Lenovo on 2017/10/25.
 */
public class Persenter implements IPersenter{

   private IHomeModle homeModle;
    private IViewActivity viewActivity;
    public Persenter(IViewActivity viewActivity) {
        this.homeModle=new HomeModle();
        this.viewActivity = viewActivity;
    }

    @Override
    public void refresh() {
            viewActivity.showProgressBar();
            homeModle.listModle(new INetworkCallbake<ModleData>() {
                @Override
                public void onSuccee(ModleData modleData) {
                    viewActivity.refersh(modleData.getAlllist());
                    viewActivity.dimiss();
                }

                @Override
                public void onError(String msg) {
                    viewActivity.showErrorMsg("失败");
                    viewActivity.dimiss();
                }
            });
        }

    @Override
    public void jiazai() {
        homeModle.listModle(new INetworkCallbake<ModleData>() {
            @Override
            public void onSuccee(ModleData modleData) {
                viewActivity.jiazai(modleData.getAlllist());
                viewActivity.dimiss();
            }

            @Override
            public void onError(String msg) {
                viewActivity.showErrorMsg("失败");
                viewActivity.dimiss();
            }
        });
    }
}
