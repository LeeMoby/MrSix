package com.moby.mrsix;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by Moby on 16/3/18.
 */
public class PatrolIndexAdapter extends BaseAdapter {
    private LayoutInflater piInflater;
    private List<Map<String, Object>> dataList;
    private String[] keyStr;

    public PatrolIndexAdapter(Context context, List<Map<String, Object>> news) {
        this.piInflater = LayoutInflater.from(context);
        this.dataList = news;
        this.keyStr = new String[]{"room", "roomType", "temperature", "humidity", "alreadyPatrol", "countPatrol", "anomaly"};
    }

    @Override
    public int getCount() {
        return this.dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = piInflater.inflate(R.layout.patrol_index_listview, null);
            // init
            holder.roomName = (TextView) convertView.findViewById(R.id.tv_patrol_index_listview_room);
            holder.roomType = (TextView) convertView.findViewById(R.id.tv_patrol_index_listview_room_type);
            holder.temperature = (TextView) convertView.findViewById(R.id.tv_patrol_index_listview_temperature);
            holder.humidity = (TextView) convertView.findViewById(R.id.tv_patrol_index_listview_humidity);
            holder.patrolAlready = (TextView) convertView.findViewById(R.id.tv_patrol_index_listview_patrol_already);
            holder.patrolCount = (TextView) convertView.findViewById(R.id.tv_patrol_index_listview_patrol_count);
            holder.anomaly = (TextView) convertView.findViewById(R.id.tv_patrol_index_listview_anomaly);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //set text
        holder.roomName.setText((String)dataList.get(position).get(keyStr[0]));
        holder.roomType.setText((String)dataList.get(position).get(keyStr[1]));
        holder.temperature.setText((String)dataList.get(position).get(keyStr[2]));
        holder.humidity.setText((String)dataList.get(position).get(keyStr[3]));
        holder.patrolAlready.setText((String)dataList.get(position).get(keyStr[4]));
        holder.patrolCount.setText((String)dataList.get(position).get(keyStr[5]));
        holder.anomaly.setText((String)dataList.get(position).get(keyStr[6]));
        //set backgroud
        LinearLayout leftLayout = (LinearLayout) convertView.findViewById(R.id.tv_patrol_index_listview_layout_left);
        LinearLayout rightLayout = (LinearLayout) convertView.findViewById(R.id.tv_patrol_index_listview_layout_right);
        if (!"0".equals(holder.anomaly.getText())) {
            leftLayout.setBackgroundResource(R.drawable.room_orange);
            rightLayout.setBackgroundResource(R.drawable.detail_orange);
        } else if ("0".equals(holder.patrolAlready.getText())) {
            leftLayout.setBackgroundResource(R.drawable.room_blue);
            rightLayout.setBackgroundResource(R.drawable.detail_blue);
        } else {
            leftLayout.setBackgroundResource(R.drawable.room_green);
            rightLayout.setBackgroundResource(R.drawable.detail_green);
        }

        return convertView;
    }
}
