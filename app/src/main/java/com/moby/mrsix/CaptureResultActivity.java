/**
 *
 */
package com.moby.mrsix;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @author yumin
 */
public class CaptureResultActivity extends Activity {

    /**
     *
     */
    private TextView tv_qrcode_result;
//    private TextView tvResultFormat;
//    private TextView tvUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_result);
        initActivity();
        initData();
    }

    private void initActivity() {

        tv_qrcode_result = (TextView) findViewById(R.id.tv_qrcode_result);
//        tvResultFormat = (TextView) findViewById(R.id.tv_result_format);
//        tvUri = (TextView) findViewById(R.id.tv_uri);
    }

    private void initData() {

        Intent intent = getIntent();
        if (null != intent) {
            tv_qrcode_result.setText(intent.getStringExtra(Intents.Scan.RESULT));
//            tvResultFormat.setText(intent.getStringExtra(Intents.Scan.RESULT_FORMAT));
//            tvUri.setText(intent.toUri(intent.getFlags()));
        }
    }
}
