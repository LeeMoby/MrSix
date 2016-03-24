package com.moby.mrsix;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;



/**
 * Created by Moby on 16/3/24.
 */
public class RoomActivity extends Activity {
    private ImageButton ibtn_room_return;
    private TextView tv_room_user;
    private TextView tv_room_date;
    private TextView tv_room_name;
    private TextView tv_room_patrol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_activity);
        initActivity();
        initData();
    }

    private void initActivity() {
        ibtn_room_return = (ImageButton) findViewById(R.id.ibtn_room_return);
        tv_room_user = (TextView) findViewById(R.id.tv_room_user);
        tv_room_date = (TextView) findViewById(R.id.tv_room_date);
        tv_room_name = (TextView) findViewById(R.id.tv_room_name);
        tv_room_patrol = (TextView) findViewById(R.id.tv_room_patrol);


    }

    private void initData() {

    }
}
