package com.example.day02.net;

import java.util.HashMap;

public interface MainNetRetrofitUrils {
    public <T> void get(String url,IMainCallBack<T> callBack);
    public <T> void post(String url,IMainCallBack<T> callBack);
    public <T> void post(String url, HashMap<String,String> map, IMainCallBack<T> callBack);
}
