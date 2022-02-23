package com.example.gaogao.activity.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.SaveInfo;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gaogao.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LoginCreateActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back;
    private EditText et_create_number;
    private EditText et_create_password;
    private EditText et_create_password_again;
    private TextView tv_create;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_create);
        initViews();
        initListener();
        initData();
    }

    protected void initViews() {

        iv_back = (ImageView) findViewById(R.id.iv_back);
        et_create_number = (EditText) findViewById(R.id.et_create_number);
        et_create_password = (EditText) findViewById(R.id.et_create_password);
        et_create_password_again = (EditText) findViewById(R.id.et_create_password_again);
        tv_create = (TextView) findViewById(R.id.tv_create);


    }

    protected void initListener() {

        iv_back.setOnClickListener(this);
        tv_create.setOnClickListener(this);

    }

    protected void initData() {

    }

    @Override
    public void onClick(View view) {

        String username = et_create_number.getText().toString().trim();
        String password = et_create_password.getText().toString().trim();
        String password2 = et_create_password_again.getText().toString().trim();

        int id = view.getId();
        switch (id){
            case R.id.iv_back:
                finish();
                break;
            //注册开始，判断注册条件
            case R.id.tv_create:
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(password2)) {
                    Toast.makeText(LoginCreateActivity.this, "各项均不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    if (TextUtils.equals(password, password2)) {
                        //执行注册操作
                        SaveInfo.SaveInformation(LoginCreateActivity.this,username,password,password2);
                        Toast.makeText(LoginCreateActivity.this,"注册成功,请返回登录",Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginCreateActivity.this, "两次输入的密码不一样", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

        }

    }
    public static class SaveInfo {
        public static boolean SaveInformation(Context context, String username, String password, String password2) {
            try {
                FileOutputStream fos = context.openFileOutput("data.txt", Context.MODE_APPEND);
                fos.write(("用户名:" + username + " 密码:" + password ).getBytes());
                fos.close();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public static Map<String, String> getSaveInformation(Context context) {
            try {
                FileInputStream fis = context.openFileInput("data.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                String str = br.readLine();
                String[] infos = str.split("用户名:"+"密码:");
                Map<String, String> map = new HashMap<String, String>();
                map.put("username", infos[0]);
                map.put("password", infos[1]);
                fis.close();
                return map;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }


}
