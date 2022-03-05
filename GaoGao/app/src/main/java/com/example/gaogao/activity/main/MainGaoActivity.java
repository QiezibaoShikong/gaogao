package com.example.gaogao.activity.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gaogao.R;

public class MainGaoActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView rb_add_notice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gao);
        initViews();
        initListener();
        initData();
    }


    private void initViews() {
        rb_add_notice = (TextView) findViewById(R.id.rb_add_notice);

    }

    private void initListener() {
        rb_add_notice.setOnClickListener(this);

    }

    private void initData() {

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.rb_add_notice:
                break;
        }

    }
}
