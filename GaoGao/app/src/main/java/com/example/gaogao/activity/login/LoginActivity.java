package com.example.gaogao.activity.login;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gaogao.MainActivity;
import com.example.gaogao.R;
import com.example.gaogao.activity.main.MainGaoActivity;

import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back;
    private EditText et_login_number;
    private EditText et_login_password;
    private String uerName,password,spPsw;//获取的用户名，密码，加密密码
    private TextView tv_login_create;
    private TextView tv_login_forget;
    private TextView tv_login;
    private CheckBox cb_login_agreement;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initViews();
        initListener();
        initData();

    }


    private void initViews() {

        iv_back = (ImageView) findViewById(R.id.iv_back);
        et_login_number = (EditText) findViewById(R.id.et_login_number);
        et_login_password = (EditText) findViewById(R.id.et_login_password);
        tv_login_create = (TextView) findViewById(R.id.tv_login_create);
        tv_login_forget = (TextView) findViewById(R.id.tv_login_forget);
        tv_login = (TextView) findViewById(R.id.tv_login);
        cb_login_agreement = (CheckBox) findViewById(R.id.cb_login_agreement);
    }

    private void initListener() {

        iv_back.setOnClickListener(this);
        tv_login_create.setOnClickListener(this);
        tv_login_forget.setOnClickListener(this);
        tv_login.setOnClickListener(this);

    }


    private void initData() {
        Map<String, String> userInfo = LoginCreateActivity.SaveInfo.getSaveInformation(this);
        if (userInfo != null) {
            et_login_number.setText(userInfo.get("username"));
            et_login_password.setText(userInfo.get("password"));
        }
    }

    @Override
    public void onClick(View view) {

        String username =et_login_number.getText().toString().trim();
        String password =et_login_password.getText().toString().trim();
        int id = view.getId();
        switch (id){
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_login_create:
                Intent intent = new Intent(this,LoginCreateActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_login_forget:
                break;
            case R.id.tv_login:
                //隐私政策
                if (!cb_login_agreement.isChecked()){
                    Toast.makeText(LoginActivity.this,"请在下方勾选同意后再登录",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this,"密码或账号不能为空",Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    intent = new Intent(LoginActivity.this, MainGaoActivity.class);
                    startActivity(intent);
                }
                break;
        }

    }
}
