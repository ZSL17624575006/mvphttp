package com.example.day02.base;

public class BasePresenter<V extends BaseView> {
    public V iView;
    public void BaseIView(V v){
        iView = v;
    }
}
