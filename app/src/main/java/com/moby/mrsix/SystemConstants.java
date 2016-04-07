package com.moby.mrsix;

import java.text.SimpleDateFormat;

/**
 * 系统常量
 * Created by Moby on 16/3/31.
 */
public final class SystemConstants {
    private SystemConstants(){}

    public static final String PATROL_NUMBER = "patrolNumber";
    public static final String ANOMALY_NUMBER = "anomalyNumber";
    public static final String PHOTO_NUMBER = "photoNumber";
    public static final String CABINET_NUMBER = "cabinetNumber";
    public static final String TEMPERATURE = "temperature";
    public static final String HUMIDITY = "humidity";
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
}
