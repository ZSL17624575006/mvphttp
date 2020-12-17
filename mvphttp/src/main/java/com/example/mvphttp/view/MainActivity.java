package com.example.mvphttp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvphttp.R;
import com.example.mvphttp.api.URLConstant;
import com.example.mvphttp.base.BaseActivity;
import com.example.mvphttp.conteact.MainContract;
import com.example.mvphttp.model.UserBean;
import com.example.mvphttp.presenter.MainPresenterImpl;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<MainPresenterImpl> implements MainContract.IMainView {

    private TextView mainTv;
    private Button mainBt;


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenterImpl add() {
        return new MainPresenterImpl(this);
    }

    @Override
    protected void initData() {
        presenter.login(URLConstant.NEWLIST);
    }

    @Override
    protected void initView() {
        mainTv = (TextView) findViewById(R.id.main_tv);
        mainBt = (Button) findViewById(R.id.main_bt);
    }

    @Override
    public <T> void loginRelt(T t) {
        UserBean userBean = (UserBean) t;
        List<UserBean.NewsBean> news = userBean.getNews();
        for (int i = 0; i < news.size(); i++) {
            Log.d("TAG", "loginRelt: "+news.get(i).getContent());
            Log.d("TAG", "loginRelt: "+news.get(i).getImageUrl());
            Log.d("TAG", "loginRelt: "+news.get(i).getTile());
        }
    }
}