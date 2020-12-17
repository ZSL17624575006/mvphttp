package com.example.daima02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.daima02.view.HomeActivity;
import com.example.daima02.view.LoginActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private Button mainBt;
    private Disposable subscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDao();
    }

    long l;

    private void initDao() {
        subscribe = Observable.intervalRange(0, 4, 0, 1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        l = 3 - aLong;
                        mainBt.setText(l+"s");
                        if (l == 0){
                            mainBt.setText("跳转");
                            subscribe.dispose();
                            startActivity(new Intent(MainActivity.this, LoginActivity.class));
                            finish();
                        }
                    }
                });
    }

    private void initView() {
        mainBt = (Button) findViewById(R.id.main_bt);
        mainBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (l == 0){
                    subscribe.dispose();
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }else {
                    Toast.makeText(MainActivity.this, "倒计时没有结束", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}