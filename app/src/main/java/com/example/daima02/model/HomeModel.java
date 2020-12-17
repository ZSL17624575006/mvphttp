package com.example.daima02.model;

import com.example.daima02.api.HomeApi;
import com.example.daima02.data.AnewsListBean;
import com.example.daima02.data.AstudentBean;
import com.example.daima02.data.BannerBean;
import com.example.daima02.interfaces.Callback;
import com.example.daima02.interfaces.discover.IHome;
import com.example.daima02.net.CommonSubscriber;
import com.example.daima02.net.HomeHttpManager;
import com.example.daima02.utils.RxUtils;
import com.example.mylibrary.base.BaseModel;

public class HomeModel extends BaseModel implements IHome.Model {

    private final HomeApi api;

    public HomeModel() {
        api = HomeHttpManager.getInstance().getDiscoverApi();
    }

    @Override
    public void getBannerData(Callback callback) {
        addDisposable(api.getBannerDesc().compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<BannerBean>(callback) {
                    @Override
                    public void onNext(BannerBean bannerBean) {
                        callback.success(bannerBean);
                    }
                }));
    }

    @Override
    public void getAnewsListData(Callback callback) {
        addDisposable(api.getAnewsList().compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<AnewsListBean>(callback) {
                    @Override
                    public void onNext(AnewsListBean anewsListBean) {
                        callback.success(anewsListBean);
                    }
                }));
    }

    @Override
    public void getAstudentData(Callback callback) {
        addDisposable(api.getAstudent().compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<AstudentBean>(callback) {
                    @Override
                    public void onNext(AstudentBean astudentBean) {
                        callback.success(astudentBean);
                    }
                }));
    }
}
