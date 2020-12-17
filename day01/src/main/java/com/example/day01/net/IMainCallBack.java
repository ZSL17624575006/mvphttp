package com.example.day01.net;

public interface IMainCallBack<T> {
    public void onSuccess(T t);
    public void onFail(String msg);
}
