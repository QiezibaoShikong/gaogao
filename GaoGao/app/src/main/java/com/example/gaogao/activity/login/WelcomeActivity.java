package com.example.gaogao.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gaogao.R;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout ll_login_now;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_login);
        initViews();
        initListener();
        initData();
    }

    protected void initViews() {

        ll_login_now = (LinearLayout) findViewById(R.id.ll_login_now);

    }

    protected void initListener() {

        ll_login_now.setOnClickListener(this);
    }

    protected Void initData() {
        return null;
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        switch (id){
            case R.id.ll_login_now:
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
