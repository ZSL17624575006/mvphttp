package com.example.daima02.view;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.daima02.R;
import com.example.daima02.data.AnewsListBean;
import com.example.daima02.data.AstudentBean;
import com.example.daima02.data.BannerBean;
import com.example.daima02.interfaces.discover.IHome;
import com.example.daima02.presenter.HomePresenter;
import com.example.daima02.view.fragment.SchoolFragment;
import com.example.daima02.view.fragment.ScoreInquiryFragment;
import com.example.mylibrary.base.BaseActivity;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends BaseActivity<HomePresenter> implements IHome.View {

    List<BannerBean.BannerlistBean> list;
    private Banner banner;
    private TabLayout tablayout;
    private ViewPager pager;
    private ArrayList<Fragment> fragments;

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }
    @Override
    public void initView() {
        banner = (Banner) findViewById(R.id.home_banner);
        tablayout = (TabLayout) findViewById(R.id.home_tab);
        pager = (ViewPager) findViewById(R.id.home_vp);

        fragments = new ArrayList<>();

        fragments.add(new SchoolFragment(1));
        fragments.add(new ScoreInquiryFragment(2));

        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        tablayout.setupWithViewPager(pager);
        tablayout.getTabAt(0).setText("学校新闻");
        tablayout.getTabAt(1).setText("班级成绩查询");
    }

    @Override
    protected HomePresenter createPersenter() {
        return new HomePresenter(this);
    }
    @Override
    public void initData() {
        persenter.getBanner();
    }

    @Override
    public void tips(String tip) {
        Log.e("TAG", "解析错误tips: " + tip);
    }

    @Override
    public void loading(int visible) {

    }

    @Override
    public void getBannerReturn(BannerBean bannerBean) {
        Log.e("TAG", "displayImage: ");
        if (bannerBean != null) {
            List<BannerBean.BannerlistBean> list = new ArrayList<>();
            List<BannerBean.BannerlistBean> bannerlist = bannerBean.getBannerlist();
            list.clear();
            list.addAll(bannerlist);
            banner.setImages(list)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            BannerBean.BannerlistBean bannerlistDTO = (BannerBean.BannerlistBean) path;
                            Glide.with(context).load(bannerlistDTO.getImageurl()).into(imageView);
                        }
                    }).start();
        } else {
            Log.e("TAG", "空");
        }
    }

    @Override
    public void getAnewsListReturn(AnewsListBean anewsListBean) {

    }

    @Override
    public void getAstudentReturn(AstudentBean astudentBean) {

    }
}