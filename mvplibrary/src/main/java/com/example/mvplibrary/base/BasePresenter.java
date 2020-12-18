package com.example.mvplibrary.base;

public abstract class BasePresenter<V extends BaseView,M extends BaseModel> {
    public V iView;
    public M iModel;
    public void BaseIView(V v){
        iView = v;
        iModel = getiModel();
    }

    protected abstract M getiModel();

    //gc回收是调用
    public void detachView(){
        iView = null;
        iModel = null;
    }
}
