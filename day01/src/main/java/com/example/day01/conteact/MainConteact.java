package com.example.day01.conteact;


import com.example.mvplibrary.base.BaseModel;
import com.example.mvplibrary.base.BaseView;
import com.example.mvplibrary.net.IMainCallBack;

public class MainConteact {
    public interface IMainModel extends BaseModel {
        <T> void getMainData(String string, IMainCallBack<T> callBack);
    }
    public interface IMainPresenter{
        void MainData(String string);
    }
    public interface IMainView extends BaseView {
        <T> void getMainDataRelt(T t);
    }
}
