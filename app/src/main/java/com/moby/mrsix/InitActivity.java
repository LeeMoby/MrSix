package com.moby.mrsix;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by moby on 3/15/16.
 */
public class InitActivity extends Activity implements View.OnClickListener{
    private TextView tv_date;
    private Button btn_enter;
    private EditText et_user;
    private Calendar calObj;
    private String loginTime;
    private Intent intent_init2index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.init_main);
        tv_date = (TextView) findViewById(R.id.tv_date);
        btn_enter = (Button) findViewById(R.id.btn_enter);
        et_user = (EditText) findViewById(R.id.et_user);
        // init date
        calObj = Calendar.getInstance();
        loginTime = calObj.get(Calendar.YEAR) + "-" +
                (calObj.get(Calendar.MONTH) + 1) + "-" + calObj.get(Calendar.DAY_OF_MONTH) + " " + calObj.get(Calendar.HOUR_OF_DAY) + ":" + calObj.get(Calendar.MINUTE);
        tv_date.setText(loginTime);
        // init enter button
        btn_enter.setOnClickListener(this);
        // init Intent
        intent_init2index = new Intent(this, IndexActivity.class);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_enter){
            String username = String.valueOf(et_user.getText());
            Toast.makeText(this, username, Toast.LENGTH_SHORT).show();
            intent_init2index.putExtra("user", username);
            startActivity(intent_init2index);
        }


    }
}
