package com.example.day01.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.day01.R;
import com.example.day01.api.URLConstant;
import com.example.day01.base.BaseActivity;
import com.example.day01.bean.MainDataBean;
import com.example.day01.conteact.MainConteact;
import com.example.day01.presenter.MainPresenter;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<MainPresenter> implements MainConteact.IMainView {

    @Override
    protected void initData() {
        presenter.MainData(URLConstant.DATAURL);
    }

    @Override
    protected void initView() {
        //老师总是这样给我们教完题就跑了
    }

    @Override
    protected MainPresenter add() {
        return new MainPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public <T> void getMainDataRelt(T t) {
        MainDataBean mainDataBean = (MainDataBean) t;
        ArrayList<MainDataBean.NewsBean> newsBeans = new ArrayList<>();
        newsBeans.clear();
        newsBeans.addAll(mainDataBean.getNews());
        for (int i = 0; i < newsBeans.size(); i++) {
            Log.d("TAG", "getMainDataRelt: "+newsBeans.get(i).getContent());
            Log.d("TAG", "getMainDataRelt: "+newsBeans.get(i).getImageUrl());
            Log.d("TAG", "getMainDataRelt: "+newsBeans.get(i).getTile());
        }
    }
}