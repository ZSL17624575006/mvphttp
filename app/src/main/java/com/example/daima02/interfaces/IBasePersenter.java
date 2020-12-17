package com.example.daima02.interfaces;

public interface IBasePersenter<V extends IBaseView> {

    void attachView(V view);

    void unAttachView();


}
