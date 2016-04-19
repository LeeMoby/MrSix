package com.moby.mrsix;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.moby.mrsix.bean.RoomBean;
import com.moby.mrsix.zxing.CaptureActivity;
import com.moby.mrsix.zxing.Intents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by moby on 3/16/16.
 */
public class PatrolIndexActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private BaseApplication baseApplication;
    private static final int REQUEST_CODE = 200;
    private String username;
    private int patrolTimes;
    private Button btn_patrol;
    private ImageButton ibtn_patrol_return;
    private TextView tv_patrol_index_user;
    private TextView tv_patrol_index_title;
    private TextView tv_patrol_index_time;
    private ImageButton ibtn_patrol_index_left;
    private ImageButton ibtn_patrol_index_right;
    private ListView lv_patrol_index;
    private PatrolIndexAdapter patrolIndexAdapter;
    private String[] fromArray;
    private String[] roomNameArray;
    private String[] roomTypeArray;
    private String[] temperatureArray;
    private String[] humidityArray;
    private String[] alreadyPatrolArray;
    private String[] countPatrolArray;
    private String[] anomalyArray;
    private List<Map<String, Object>> dataList;
    private String titleStr;
    private String patrolTimeStr;
    private Intent intent_patrol2room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patrol_index);
        //init
        baseApplication = (BaseApplication) getApplication();
        username = baseApplication.getLoginUser();
        patrolTimes = baseApplication.getPatrolTimes();
        ibtn_patrol_return = (ImageButton) findViewById(R.id.ibtn_patrol_return);
        ibtn_patrol_index_left = (ImageButton) findViewById(R.id.ibtn_patrol_index_left);
        ibtn_patrol_index_right = (ImageButton) findViewById(R.id.ibtn_patrol_index_right);
        tv_patrol_index_user = (TextView) findViewById(R.id.tv_patrol_index_user);
        tv_patrol_index_title = (TextView) findViewById(R.id.tv_patrol_index_title);
        lv_patrol_index = (ListView) findViewById(R.id.lv_patrol_index);
        tv_patrol_index_time = (TextView) findViewById(R.id.tv_patrol_index_time);
        btn_patrol = (Button) findViewById(R.id.btn_patrol);
        dataList = new ArrayList<Map<String, Object>>();
        intent_patrol2room = new Intent(this, RoomActivity.class);
        // init data
        initListViewData();
        //init adapter
        patrolIndexAdapter = new PatrolIndexAdapter(this, dataList);
        lv_patrol_index.setAdapter(patrolIndexAdapter);
        // set TextView
        tv_patrol_index_user.setText(username);
        initTitle();
        tv_patrol_index_title.setText(titleStr);
        initPatrolTime();
        tv_patrol_index_time.setText(patrolTimeStr);

        btn_patrol.setOnClickListener(this);
        ibtn_patrol_return.setOnClickListener(this);
        ibtn_patrol_index_left.setOnClickListener(this);
        ibtn_patrol_index_right.setOnClickListener(this);
        lv_patrol_index.setOnItemClickListener(this);

    }

    private void initPatrolTime() {
        String[] patrolTimeArray = new String[]{"08:30", "11:00", "14:30", "17:00"};
        patrolTimeStr = patrolTimeArray[patrolTimes];

    }


    private void initTitle() {
        titleStr = "This is first patrol";
        switch (patrolTimes) {
            case 0:
                titleStr = "第一次巡检";
                break;
            case 1:
                titleStr = "第二次巡检";
                break;
            case 2:
                titleStr = "第三次巡检";
                break;
            case 3:
                titleStr = "第四次巡检";
                break;
            default:
                titleStr = "第一次巡检";
                break;
        }
    }


    private void initListViewData() {
        fromArray = new String[]{"room", "roomType", "temperature", "humidity", "alreadyPatrol", "countPatrol", "anomaly"};
        roomNameArray = new String[]{"21", "22", "12", "13", "102", "110", "204", "212", "00", "01"};
        roomTypeArray = new String[]{"机房", "机房", "机房", "机房", "弱电间", "弱电间", "弱电间", "弱电间", "暗室", "辅楼"};
        temperatureArray = new String[]{"24.3", "23.3", "21.5", "22.6", "19.3", "19.6", "18.7", "18.3", "17.5", "24.5"};
        humidityArray = new String[]{"40.1", "39.5", "44.6", "43.2", "32.5", "33.2", "33.7", "31.4", "40.1", "47.5"};
        alreadyPatrolArray = new String[]{"78", "80", "68", "68", "1", "1", "0", "0", "0", "0"};
        countPatrolArray = new String[]{"80", "80", "80", "80", "2", "2", "2", "2", "1", "1"};
        anomalyArray = new String[]{"0", "3", "0", "0", "0", "0", "0", "0", "0", "0"};

        for (int i = 0; i < roomNameArray.length; i++) {
            Map<String, Object> aMap = new HashMap<String, Object>();
            aMap.put(fromArray[0], roomNameArray[i]);
            aMap.put(fromArray[1], roomTypeArray[i]);
            aMap.put(fromArray[2], temperatureArray[i] + " ℃");
            aMap.put(fromArray[3], humidityArray[i] + " %");
            aMap.put(fromArray[4], alreadyPatrolArray[i]);
            aMap.put(fromArray[5], countPatrolArray[i]);
            aMap.put(fromArray[6], anomalyArray[i]);
            dataList.add(aMap);

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_patrol:
                /**
                 * 启动摄像头,扫描二维码
                 */
                Intent intent = new Intent();
                intent.setAction(Intents.Scan.ACTION);
                // intent.putExtra(Intents.Scan.MODE, Intents.Scan.QR_CODE_MODE);
                intent.putExtra(Intents.Scan.CHARACTER_SET, "UTF-8"); // GBK | null
                intent.putExtra(Intents.Scan.WIDTH, 800);
                intent.putExtra(Intents.Scan.HEIGHT, 600);
                // intent.putExtra(Intents.Scan.PROMPT_MESSAGE, "type your prompt message");
                intent.setClass(this, CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case R.id.ibtn_patrol_return:
                onBackPressed();
                break;
            case R.id.ibtn_patrol_index_left:
                Toast.makeText(this, "Left", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ibtn_patrol_index_right:
                Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show();
            default:
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (null != data && requestCode == REQUEST_CODE) {
            switch (resultCode) {
                case Activity.RESULT_OK:
                    data.setClass(this, CaptureResultActivity.class);
                    startActivity(data);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "" + position, Toast.LENGTH_SHORT).show();
//        intent_patrol2room.putExtra("position", position);
//        startActivity(intent_patrol2room);
    }
}
