package com.moby.mrsix;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by moby on 3/16/16.
 */
public class PatrolIndexActivity extends Activity {
    private String username;
    private int patrolTimes;
    private Intent intent_index2patrolIndex;
    private TextView tv_patrol_index_user;
    private TextView tv_patrol_index_date;
    private TextView tv_patrol_index_title;
    private TextView tv_patrol_index_time;
    private ListView lv_patrol_index;
    private SimpleAdapter simpleAdapter;
    private PatrolIndexAdapter patrolIndexAdapter;
    private String[] fromArray;
    private int[] toArray;
    private String[] roomNameArray;
    private String[] roomTypeArray;
    private String[] temperatureArray;
    private String[] humidityArray;
    private String[] alreadyPatrolArray;
    private String[] countPatrolArray;
    private String[] anomalyArray;
    private List<Map<String, Object>> dataList;
    private String titleStr;
    private String dateStr;
    private String patrolTimeStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patrol_index);
        //init
        intent_index2patrolIndex = getIntent();
        username = intent_index2patrolIndex.getStringExtra("user");
        patrolTimes = intent_index2patrolIndex.getIntExtra("itemIndex", 0);
        tv_patrol_index_user = (TextView) findViewById(R.id.tv_patrol_index_user);
        tv_patrol_index_title = (TextView) findViewById(R.id.tv_patrol_index_title);
        tv_patrol_index_date = (TextView) findViewById(R.id.tv_patrol_index_date);
        lv_patrol_index = (ListView) findViewById(R.id.lv_patrol_index);
        tv_patrol_index_time = (TextView) findViewById(R.id.tv_patrol_index_time);
        dataList = new ArrayList<Map<String, Object>>();
        // init data
        initListViewData();
        //init adapter
//        simpleAdapter = new SimpleAdapter(this, dataList, R.layout.patrol_index_listview, fromArray, toArray);
        patrolIndexAdapter = new PatrolIndexAdapter(this, dataList);
        lv_patrol_index.setAdapter(patrolIndexAdapter);
        // set TextView
        tv_patrol_index_user.setText(username);
        initTitle();
        tv_patrol_index_title.setText(titleStr);
        initDate();
        tv_patrol_index_date.setText(dateStr);
        initPatrolTime();
        tv_patrol_index_time.setText(patrolTimeStr);

    }

    private void initPatrolTime() {
        String[] patrolTimeArray = new String[]{"08:30", "11:00", "14:30", "17:00"};
        patrolTimeStr = patrolTimeArray[patrolTimes];

    }

    private void initDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateStr = dateFormat.format(new Date());

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
//        toArray = new int[]{R.id.tv_patrol_index_listview_room, R.id.tv_patrol_index_listview_room_type, R.id.tv_patrol_index_listview_temperature, R.id.tv_patrol_index_listview_humidity, R.id.tv_patrol_index_listview_patrol_already, R.id.tv_patrol_index_listview_patrol_count, R.id.tv_patrol_index_listview_anomaly};
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
}
