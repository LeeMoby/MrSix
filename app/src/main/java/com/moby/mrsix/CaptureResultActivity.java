package com.moby.mrsix;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.moby.mrsix.zxing.Intents;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yumin
 */
public class CaptureResultActivity extends Activity implements View.OnClickListener{

    private TextView tv_qrcode_result;
    private String patrolTime;
    private TextView tv_qrcode_time;
    private Button btn_qrcode_cancel;
    private Button btn_qrcode_save;
//    private TextView tvResultFormat;
//    private TextView tvUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_result);
        initActivity();
        initData();
        initListener();
    }

    private void initListener() {
        btn_qrcode_cancel.setOnClickListener(this);
        btn_qrcode_save.setOnClickListener(this);
    }

    private void initActivity() {

        tv_qrcode_result = (TextView) findViewById(R.id.tv_qrcode_result);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        patrolTime = dateFormat.format(new Date());
        tv_qrcode_time = (TextView) findViewById(R.id.tv_qrcode_time);
        btn_qrcode_cancel = (Button) findViewById(R.id.btn_qrcode_cancel);
        btn_qrcode_save = (Button) findViewById(R.id.btn_qrcode_save);
//        tvResultFormat = (TextView) findViewById(R.id.tv_result_format);
//        tvUri = (TextView) findViewById(R.id.tv_uri);
    }

    private void initData() {

        Intent intent = getIntent();
        if (null != intent) {
            tv_qrcode_result.setText(intent.getStringExtra(Intents.Scan.RESULT));
            tv_qrcode_time.setText(patrolTime);
//            tvResultFormat.setText(intent.getStringExtra(Intents.Scan.RESULT_FORMAT));
//            tvUri.setText(intent.toUri(intent.getFlags()));
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_qrcode_cancel:
                finish();
                break;
            case R.id.btn_qrcode_save:

                break;
            default:
                break;
        }
    }
}
