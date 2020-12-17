package com.example.day02.conteact;

import com.example.day02.base.BaseView;
import com.example.day02.net.IMainCallBack;

public class MainConteact {
    public interface IMainModel{
        <T> void getMainData(String string, IMainCallBack<T> callBack);
    }
    public interface IMainPresenter{
        void MainData(String string);
    }
    public interface IMainView extends BaseView {
        <T> void getMainDataRelt(T t);
    }
}
