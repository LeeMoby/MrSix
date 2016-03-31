package com.moby.mrsix.model;

import com.moby.mrsix.bean.PatrolBean;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Moby on 16/3/28.
 */
public interface IPatrolModel {


    PatrolBean getPatrolByID(String patrolID);
    PatrolBean getPatrolByDateAndTimesAndCabinetID(String cabinetID);
    PatrolBean getPatrolByDateAndTimesAndCabinetNO(String cabinetNO);
    List<PatrolBean> findPatrolByDate(String date);
    List<PatrolBean> findPatrolByTimes(String times);
    List<PatrolBean> findPatrolByDateAndTimes(String Date, String times);

    /**
     * 根据日期获取当日的巡检统计信息
     * @param date
     * @return HashMap Key(PATROL_NUMBER, ANOMALY_NUMBER, PHOTO_NUMBER)
     */
    List<HashMap<String, String>> findPatrolStaticsByDate(String date);

    /**
     * 根据日期和次数(第几次巡检)获取当日当次的巡检统计信息
     * @param date
     * @param times
     * @return HashMap Key(PATROL_NUMBER, ANOMALY_NUMBER, PHOTO_NUMBER)
     */
    List<HashMap<String, String>> findPatrolStaticsByDateAndTimes(String date, String times);

    /**
     * 根据日期,次数(第几次巡检)和机房ID获取当日当次的巡检统计信息
     * @param date
     * @param times
     * @param roomID
     * @return HashMap Key(PATROL_NUMBER, ANOMALY_NUMBER, PHOTO_NUMBER, CABINET_NUMBER, TEMPERATURE, HUMIDITY)
     */
    List<HashMap<String, String>> findPatrolStaticsByDateAndTimesAndRoomID(String date, String times, String roomID);

    /**
     * 根据开始日期和结束日期获取该时间段的巡检统计信息
     * @param startDate
     * @param endDate
     * @return HashMap Key(PATROL_NUMBER, ANOMALY_NUMBER, PHOTO_NUMBER)
     */
    List<HashMap<String, String>> findPatrolStaticsByStartAndEnd(String startDate, String endDate);
}
