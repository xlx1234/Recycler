package com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.view;

import android.app.ProgressDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.R;
import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.adapter.MyAdapter;
import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.base.BaseActivity;
import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.modle.entiry.ModleData;
import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.persenter.IPersenter;
import com.example.lenovo.recyclerview_xiaolashuaxishanglajiazai.persenter.Persenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements IViewActivity{

    private PullToRefreshRecyclerView Pull;
    private List<ModleData.AlllistBean> alllist ;
    private MyAdapter adapter;
    private ProgressDialog progressDialog;
    private IPersenter persenter;
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        persenter=new Persenter(this);
        alllist=new ArrayList<>();
        adapter=new MyAdapter(this,alllist);
        Pull = (PullToRefreshRecyclerView) findViewById(R.id.Pull);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        Pull.setLayoutManager(manager);
        Pull.setPullRefreshEnabled(true);
        Pull.setLoadingMoreEnabled(true);
        Pull.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                persenter.refresh();
                Pull.setRefreshComplete();
            }

            @Override
            public void onLoadMore() {
               persenter.jiazai();
                Pull.setLoadMoreComplete();
            }
        });

        Pull.setAdapter(adapter);
    }

    @Override
    protected void loadData() {
        persenter.refresh();



    }

    @Override
    public void showProgressBar() {
       progressDialog=new ProgressDialog(this);
        progressDialog.show();
    }

    @Override
    public void dimiss() {
  if(progressDialog!=null&&progressDialog.isShowing()){
      progressDialog.dismiss();
  }
    }

    @Override
    public void refersh(List<ModleData.AlllistBean> homeData) {
//      this.alllist.clear();
      this.alllist.addAll(homeData);
      adapter.notifyDataSetChanged();
      Pull.setRefreshComplete();
    }

    @Override
    public void jiazai(List<ModleData.AlllistBean> homeData) {
        alllist.addAll(homeData);
        adapter.notifyDataSetChanged();

    }


    @Override
    public void showErrorMsg(String errorMsg) {
        Toast.makeText(MainActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
    }
}
