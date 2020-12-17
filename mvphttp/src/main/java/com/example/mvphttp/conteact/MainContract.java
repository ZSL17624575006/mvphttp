package com.example.mvphttp.conteact;

import com.example.mvphttp.base.BaseView;
import com.example.mvphttp.model.UserBean;
import com.example.mvphttp.net.INetCallBack;

public class MainContract {
    public interface IMainModel {
        <T> void getLoginData(String url, INetCallBack<T> callBack);
    }
    public  interface IMainPresenter {
        void login(String url);
    }
    public interface IMainView extends BaseView {

        <T> void loginRelt(T t);
    }
}
