package com.example.mvphttp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvphttp.conteact.MainContract;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements MainContract.IMainView {
    public P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        if (presenter == null){
            presenter = add();
            presenter.attachView(this);
        }
        initView();
        initData();
    }

    protected abstract P add();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayout();
}
