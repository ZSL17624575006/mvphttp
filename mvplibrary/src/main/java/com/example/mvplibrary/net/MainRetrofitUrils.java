package com.example.mvplibrary.net;

import com.example.mvplibrary.api.ApiService;
import com.example.mvplibrary.api.URLConstant;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class MainRetrofitUrils implements MainNetRetrofitUrils {
    private static MainRetrofitUrils retrofitUrils;
    private ApiService apiService;

    private MainRetrofitUrils(){
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLConstant.URLBEAN)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }
    public static MainRetrofitUrils getInstance(){
        if (retrofitUrils == null){
            synchronized (MainRetrofitUrils.class){
                if (retrofitUrils == null){
                    retrofitUrils = new MainRetrofitUrils();
                }
            }
        }
        return retrofitUrils;
    }

    @Override
    public <T> void get(String url, IMainCallBack<T> callBack) {
        apiService.getMainData(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type t = actualTypeArguments[0];
                            Gson gson = new Gson();
                            T resultt = gson.fromJson(string, t);
                            callBack.onSuccess(resultt);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <T> void post(String url, IMainCallBack<T> callBack) {

    }

    @Override
    public <T> void post(String url, HashMap<String, String> map, IMainCallBack<T> callBack) {

    }
}
