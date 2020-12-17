package com.example.day01.base;

public class BasePresenter<V extends BaseView> {
    public V iView;
    public void BaseIView(V v){
        iView = v;
    }
}
