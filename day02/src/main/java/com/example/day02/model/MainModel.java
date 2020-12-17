package com.example.day02.model;

import com.example.day02.bean.MainDataBean;
import com.example.day02.conteact.MainConteact;
import com.example.day02.net.IMainCallBack;
import com.example.day02.net.MainRetrofitUrils;

public class MainModel implements MainConteact.IMainModel {

    private MainConteact.IMainPresenter presenter;

    public MainModel(MainConteact.IMainPresenter presenter) {
        this.presenter = presenter;
    }
    @Override
    public <T> void getMainData(String string, IMainCallBack<T> callBack) {
        MainRetrofitUrils.getInstance().get(string, new IMainCallBack<MainDataBean>() {
            @Override
            public void onSuccess(MainDataBean mainDataBean) {
                callBack.onSuccess((T) mainDataBean);
            }

            @Override
            public void onFail(String msg) {
                callBack.onFail(msg);
            }
        });
    }
}
