package com.example.daima02.view.fragment;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daima02.R;
import com.example.daima02.adapter.RecyAdapter;
import com.example.daima02.adapter.RecyclAdapter;
import com.example.daima02.data.AnewsListBean;
import com.example.daima02.data.AstudentBean;
import com.example.daima02.data.BannerBean;
import com.example.daima02.interfaces.discover.IHome;
import com.example.daima02.presenter.HomePresenter;
import com.example.mylibrary.fragments.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ScoreInquiryFragment extends BaseFragment<HomePresenter> implements IHome.View{

    private int i;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private List<AnewsListBean.NewsBean> newslist;
    private List<AstudentBean.StudenlistBean> studenlist;
    private RecyAdapter adapter;
    private RecyclAdapter adapter1;


    public ScoreInquiryFragment(int i) {
        this.i = i;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_public;
    }

    @Override
    public void initView() {
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.addItemDecoration(new DividerItemDecoration(getActivity(),1));
        if (i == 1){
            newslist = new ArrayList<>();
            adapter = new RecyAdapter(getActivity(), newslist);
            recycler.setAdapter(adapter);
        } else {
            studenlist = new ArrayList<>();
            adapter1 = new RecyclAdapter(getActivity(), studenlist);
            recycler.setAdapter(adapter1);
        }
    }

    @Override
    public HomePresenter createPersenter() {
        return new HomePresenter(this);
    }

    @Override
    public void initData() {
        persenter.getAnewsList();
        persenter.getAstudent();
    }

    @Override
    public void tips(String tip) {

    }

    @Override
    public void loading(int visible) {

    }

    @Override
    public void getBannerReturn(BannerBean bannerBean) {

    }

    @Override
    public void getAnewsListReturn(AnewsListBean anewsListBean) {
        if (i == 1){
            List<AnewsListBean.NewsBean> news = anewsListBean.getNews();
            Log.e("TAG", "Anewssss: "+news.get(0).getContent());
            newslist.clear();
            newslist.addAll(news);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getAstudentReturn(AstudentBean astudentBean) {
        if (i == 2){
            List<AstudentBean.StudenlistBean> list = astudentBean.getStudenlist();
            studenlist.clear();
            studenlist.addAll(list);
            adapter1.notifyDataSetChanged();
        }
    }
}
