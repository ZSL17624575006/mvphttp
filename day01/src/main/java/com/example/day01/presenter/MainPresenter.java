package com.example.day01.presenter;

import com.example.day01.bean.MainDataBean;
import com.example.day01.conteact.MainConteact;
import com.example.day01.model.MainModel;
import com.example.mvplibrary.base.BasePresenter;
import com.example.mvplibrary.net.IMainCallBack;

public class MainPresenter extends BasePresenter<MainConteact.IMainView, MainConteact.IMainModel> implements MainConteact.IMainPresenter {

    private MainConteact.IMainModel mainModel;

    public MainPresenter() {
        this.mainModel = new MainModel(this);
    }
    @Override
    public void MainData(String string) {
        mainModel.getMainData(string, new IMainCallBack<MainDataBean>() {
            @Override
            public void onSuccess(MainDataBean mainDataBean) {
                iView.getMainDataRelt(mainDataBean);
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

    @Override
    protected MainConteact.IMainModel getiModel() {
        return new MainModel(this);
    }
}
