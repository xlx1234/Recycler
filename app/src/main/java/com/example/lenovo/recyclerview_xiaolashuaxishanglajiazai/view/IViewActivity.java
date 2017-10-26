package com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.view;

import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.modle.entiry.ModleData;

import java.util.List;

/**
 * Created by Lenovo on 2017/10/25.
 */
public interface IViewActivity {
    void showProgressBar();

    void dimiss();
    void refersh(List<ModleData.AlllistBean> homeData);

    void jiazai(List<ModleData.AlllistBean> homeData);
    void showErrorMsg(String errorMsg);

}
