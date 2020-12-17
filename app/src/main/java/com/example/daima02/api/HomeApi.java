package com.example.daima02.api;

import com.example.daima02.data.AnewsListBean;
import com.example.daima02.data.AstudentBean;
import com.example.daima02.data.BannerBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface HomeApi {
    String BASE_URL = "http://cdwan.cn:7000/";

    //exam2003/abannerlist.json
    @GET("exam2003/abannerlist.json")
    Flowable<BannerBean> getBannerDesc();
    //http://cdwan.cn:7000/exam2003/anewslist.json
    @GET("exam2003/anewslist.json")
    Flowable<AnewsListBean> getAnewsList();
    //http://cdwan.cn:7000/exam2003/astudent.json
    @GET("exam2003/astudent.json")
    Flowable<AstudentBean> getAstudent();
}
