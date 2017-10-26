package com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.adapter;

import android.content.Context;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.R;
import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.modle.entiry.ModleData;

import java.util.List;

/**
 * Created by Lenovo on 2017/10/25.
 */
//
public class MyAdapter extends BaseAdapter<ModleData.AlllistBean>{


    public MyAdapter(Context context, List<ModleData.AlllistBean> datas) {
        super(context, R.layout.activity_adapter, datas);
    }

    @Override
    public void convert(ViewHolder holder, ModleData.AlllistBean alllistBean) {
        holder.setText(R.id.Text,alllistBean.getTitle());
//        ImageView imageView = holder.getView(R.id.Imager);
//        Glide.with(context).load(alllistBean.getUrl()).into(imageView);
    }
}
