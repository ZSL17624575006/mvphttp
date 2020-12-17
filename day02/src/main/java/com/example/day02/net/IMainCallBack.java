package com.example.day02.net;

public interface IMainCallBack<T> {
    public void onSuccess(T t);
    public void onFail(String msg);
}
