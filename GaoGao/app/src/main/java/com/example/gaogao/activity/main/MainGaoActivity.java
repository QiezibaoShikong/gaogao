package com.example.gaogao.activity.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gaogao.R;

public class MainGaoActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_add_notice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gao);
        initViews();
        initListener();
        initData();
    }


    private void initViews() {
        btn_add_notice = (Button) findViewById(R.id.btn_add_notice);

    }

    private void initListener() {
        btn_add_notice.setOnClickListener(this);

    }


    private void initData() {

    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.btn_add_notice:
                break;
        }

    }
}
