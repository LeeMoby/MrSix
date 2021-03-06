package com.moby.mrsix;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by moby on 3/15/16.
 */
public class IndexActivity extends Activity implements AdapterView.OnItemClickListener, View.OnClickListener {
    private BaseApplication baseApplication;
    private ImageButton ibtn_return;
    private TextView tv_index_user;
    private TextView tv_index_date;
    private TextView tv_patrol_index_date;
    private TextView tv_index_patrol_number;
    private TextView tv_index_anomaly_number;
    private TextView tv_index_photo_number;
    private ListView lv_index;
    private List<Map<String, Object>> dataList;
    private SimpleAdapter simpleAdapter;
    private String username;
    private String[] keyArray;
    private int[] valueArray;
    private String[] timesArray;
    private String[] anomalyArray;
    private String[] photoArray;
    private Intent intent_index2patrolIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_main);
        initActivity();
        initData();
        initListViewData();
        //init adapter
        simpleAdapter = new SimpleAdapter(this, dataList, R.layout.index_listview, keyArray, valueArray);
        lv_index.setAdapter(simpleAdapter);
        initListener();
    }

    private void initListener() {
        //init listener
        lv_index.setOnItemClickListener(this);
        ibtn_return.setOnClickListener(this);
    }

    private void initData() {
        // init intent
        intent_index2patrolIndex = new Intent(this, PatrolIndexActivity.class);
        // init user
        username = baseApplication.getLoginUser();
        tv_index_user.setText(username);
        // init today data
        tv_index_patrol_number.setText("127");
        tv_index_anomaly_number.setText("23");
        tv_index_photo_number.setText("36");
        // init date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        tv_patrol_index_date.setText(dateFormat.format(new Date()));
    }

    private void initActivity() {
        //init
        baseApplication = (BaseApplication) getApplication();
        ibtn_return = (ImageButton) findViewById(R.id.ibtn_return);
        tv_index_user = (TextView) findViewById(R.id.tv_index_user);
        tv_index_date = (TextView) findViewById(R.id.tv_index_date);
        tv_patrol_index_date = (TextView) findViewById(R.id.tv_patrol_index_date);
        tv_index_patrol_number = (TextView) findViewById(R.id.tv_index_patrol_number);
        tv_index_anomaly_number = (TextView) findViewById(R.id.tv_index_anomaly_number);
        tv_index_photo_number = (TextView) findViewById(R.id.tv_index_photo_number);
        lv_index = (ListView) findViewById(R.id.lv_index);
        dataList = new ArrayList<Map<String, Object>>();
    }

    private void initListViewData() {
        keyArray = new String[]{"times", "anomaly", "photo"};
        valueArray = new int[]{R.id.tv_index_listview_times, R.id.tv_index_listview_anomaly, R.id.tv_index_listview_photo};
        timesArray = new String[]{"1.08:30", "2.11:00", "3.14:30", "4.17:00"};
        anomalyArray = new String[]{"3", "0", "5", "15"};
        photoArray = new String[]{"5", "0", "8", "23"};
        // first patrol
        // second patrol
        // third patrol
        // fourth patrol
        for (int i = 0; i < timesArray.length; i++) {
            Map<String, Object> aMap = new HashMap<String, Object>();
            aMap.put("times", timesArray[i]);
            aMap.put("anomaly", anomalyArray[i] + " 异常");
            aMap.put("photo", photoArray[i] + " 照片");
            dataList.add(aMap);

        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        baseApplication.setPatrolTimes(position);
        startActivity(intent_index2patrolIndex);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ibtn_return:
                onBackPressed();
                break;
            default:
                break;

        }
    }


}
