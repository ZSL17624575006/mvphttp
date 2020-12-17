package com.example.day01.conteact;

import com.example.day01.base.BaseView;
import com.example.day01.net.IMainCallBack;

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
