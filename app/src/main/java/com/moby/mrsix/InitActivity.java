package com.moby.mrsix;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by moby on 3/15/16.
 */
public class InitActivity extends Activity implements View.OnClickListener {
    private BaseApplication mApplication;
    private TextView tv_date;
    private Button btn_enter;
    private EditText et_user;
    private String loginTime;
    private Intent intent_init2index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.init_main);
        // 获取Application对象
        mApplication = (BaseApplication) getApplication();

        tv_date = (TextView) findViewById(R.id.tv_date);
        btn_enter = (Button) findViewById(R.id.btn_enter);
        et_user = (EditText) findViewById(R.id.et_user);
        // init date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        loginTime = dateFormat.format(new Date());
        tv_date.setText(loginTime);
        // init enter button
        btn_enter.setOnClickListener(this);
        // init Intent
        intent_init2index = new Intent(this, IndexActivity.class);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_enter) {
            mApplication.setLogin_user(String.valueOf(et_user.getText()));
            startActivity(intent_init2index);
        }


    }
}
