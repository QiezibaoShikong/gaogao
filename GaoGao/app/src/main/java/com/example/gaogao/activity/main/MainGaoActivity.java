package com.example.gaogao.activity.main;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gaogao.R;

public class MainGaoActivity extends AppCompatActivity implements View.OnClickListener {
    private CheckBox cb_add_notice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gao);
        initViews();
        initListener();
        initData();
    }


    private void initViews() {
        cb_add_notice = (CheckBox) findViewById(R.id.cb_add_notice);

    }

    private void initListener() {
        cb_add_notice.setOnClickListener(this);

    }

    private void initData() {

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.cb_add_notice:
                break;
        }

    }
}
