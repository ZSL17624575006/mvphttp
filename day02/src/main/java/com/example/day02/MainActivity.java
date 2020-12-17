package com.example.day02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.day02.api.URLConstant;
import com.example.day02.base.BaseActivity;
import com.example.day02.bean.MainDataBean;
import com.example.day02.conteact.MainConteact;
import com.example.day02.presenter.MainPresenter;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<MainPresenter> implements MainConteact.IMainView {

    @Override
    protected void initData() {
        presenter.MainData(URLConstant.DATAURL);
    }

    @Override
    protected void initView() {

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
            Log.d("TAG", "getMainDataRelt: "+newsBeans.get(i).getTile());
            Log.d("TAG", "getMainDataRelt: "+newsBeans.get(i).getImageUrl());
            Log.d("TAG", "getMainDataRelt: "+newsBeans.get(i).getContent());
        }
    }
}