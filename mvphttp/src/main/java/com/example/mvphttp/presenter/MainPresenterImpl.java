package com.example.mvphttp.presenter;

import com.example.mvphttp.base.BasePresenter;
import com.example.mvphttp.conteact.MainContract;
import com.example.mvphttp.model.MainModelImpl;
import com.example.mvphttp.model.UserBean;
import com.example.mvphttp.net.INetCallBack;

public class MainPresenterImpl extends BasePresenter<MainContract.IMainView> implements MainContract.IMainPresenter {

    private MainContract.IMainModel mainModel;
    private MainContract.IMainView mainView;

    public MainPresenterImpl(MainContract.IMainView mainView) {
        this.mainModel = new MainModelImpl(this);
        this.mainView = mainView;
    }

    @Override
    public void login(String url) {
        mainModel.getLoginData(url, new INetCallBack<UserBean>() {
            @Override
            public void onSuccess(UserBean userBean) {
                iView.loginRelt(userBean);
            }

            @Override
            public void onFail(String err) {
            }
        });
    }
}
