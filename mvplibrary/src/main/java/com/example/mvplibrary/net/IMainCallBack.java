package com.example.mvplibrary.net;

public interface IMainCallBack<T> {
    public void onSuccess(T t);
    public void onFail(String msg);
}
