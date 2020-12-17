package com.example.daima02.presenter;

import android.util.Log;

import com.example.daima02.data.AnewsListBean;
import com.example.daima02.data.AstudentBean;
import com.example.daima02.data.BannerBean;
import com.example.daima02.interfaces.Callback;
import com.example.daima02.interfaces.discover.IHome;
import com.example.daima02.model.HomeModel;
import com.example.mylibrary.base.BasePersenter;

public class HomePresenter extends BasePersenter<IHome.View> implements IHome.Persenter {

    IHome.View view;
    IHome.Model model;

    public HomePresenter(IHome.View view) {
        this.view = view;
        model = new HomeModel();
    }

    @Override
    public void getBanner() {
        this.model.getBannerData(new Callback() {
            @Override
            public void fail(String msg) {
                if (view != null){
                    view.tips(msg);
                }
            }

            @Override
            public void success(Object o) {
                if (view != null){
                    view.getBannerReturn((BannerBean) o);
                    Log.d("TAG", "success: "+o.toString());
                }
            }
        });
    }

    @Override
    public void getAnewsList() {
        this.model.getAnewsListData(new Callback() {
            @Override
            public void fail(String msg) {
                if (view != null){
                    view.tips(msg);
                }
            }

            @Override
            public void success(Object o) {
                if (view != null){
                    view.getAnewsListReturn((AnewsListBean) o);
                    Log.d("TAG", "success: "+o.toString());
                }
            }
        });
    }

    @Override
    public void getAstudent() {
        this.model.getAstudentData(new Callback() {
            @Override
            public void fail(String msg) {
                if (view != null){
                    view.tips(msg);
                }
            }

            @Override
            public void success(Object o) {
                if (view != null){
                    view.getAstudentReturn((AstudentBean) o);
                    Log.d("TAG", "success: "+o.toString());
                }
            }
        });
    }
}
