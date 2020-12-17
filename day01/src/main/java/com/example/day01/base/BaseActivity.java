package com.example.day01.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.day01.conteact.MainConteact;
import com.example.day01.presenter.MainPresenter;

public abstract class BaseActivity<P extends MainPresenter> extends AppCompatActivity implements MainConteact.IMainView {
    public P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        if (presenter == null){
            presenter = add();
            presenter.BaseIView(this);
        }
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P add();

    protected abstract int getLayout();
}
