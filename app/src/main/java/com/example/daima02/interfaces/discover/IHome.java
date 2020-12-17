package com.example.daima02.interfaces.discover;


import com.example.daima02.data.AnewsListBean;
import com.example.daima02.data.AstudentBean;
import com.example.daima02.data.BannerBean;
import com.example.daima02.interfaces.Callback;
import com.example.daima02.interfaces.IBasePersenter;
import com.example.daima02.interfaces.IBaseView;
import com.example.daima02.interfaces.IModel;

/**
 * 同袍首页推荐功能接口锲约类
 */
public interface IHome {

    interface View extends IBaseView, com.example.mylibrary.interfaces.IBaseView {
        //首页Banner
        void getBannerReturn(BannerBean bannerBean);

        void getAnewsListReturn(AnewsListBean anewsListBean);

        void getAstudentReturn(AstudentBean astudentBean);
    }

    interface Persenter extends IBasePersenter<View> {
        //首页Banner
        void getBanner();

        void getAnewsList();

        void getAstudent();
    }

    interface Model extends IModel {
        //首页Banner
        void getBannerData(Callback callback);

        void getAnewsListData(Callback callback);

        void getAstudentData(Callback callback);
    }


}
