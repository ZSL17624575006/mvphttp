package com.example.daima02.interfaces;

public interface Callback<T> {

    void fail(String msg);

    void success(T t);

}
