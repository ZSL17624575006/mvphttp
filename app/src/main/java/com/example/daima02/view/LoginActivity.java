package com.example.daima02.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.daima02.R;

public class LoginActivity extends AppCompatActivity {

    private EditText loginName;
    private EditText loginPaw;
    private Button loginBt;
    private boolean log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences login = getSharedPreferences("login", Context.MODE_PRIVATE);
        log = login.getBoolean("log", true);
        initView();
    }

    private void initView() {
        loginName = (EditText) findViewById(R.id.login_name);
        loginPaw = (EditText) findViewById(R.id.login_paw);
        loginBt = (Button) findViewById(R.id.login_bt);

        if (log){

        } else {
            Toast.makeText(LoginActivity.this, "已自动登录", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            finish();
        }

        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = loginName.getText().toString();
                String paw = loginPaw.getText().toString();
                if (name.equals("H2003xs") && paw.equals("H2003")){
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    SharedPreferences login = getSharedPreferences("login", Context.MODE_PRIVATE);
                    SharedPreferences.Editor log = login.edit();
                    log.putBoolean("log",false);
                    log.commit();
                    startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                }else {
                    Toast.makeText(LoginActivity.this, "账号密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}