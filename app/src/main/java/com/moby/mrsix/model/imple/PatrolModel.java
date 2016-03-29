package com.moby.mrsix.model.imple;

import com.moby.mrsix.bean.PatrolBean;
import com.moby.mrsix.model.IPatrolModel;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Moby on 16/3/29.
 */
public class PatrolModel implements IPatrolModel {


    @Override
    public PatrolBean getPatrolByID(String patrolID) {
        return null;
    }

    @Override
    public PatrolBean getPatrolByDateAndTimesAndCabinetID(String cabinetID) {
        return null;
    }

    @Override
    public PatrolBean getPatrolByDateAndTimesAndCabinetNO(String cabinetNO) {
        return null;
    }

    @Override
    public List<PatrolBean> findPatrolByDate(String date) {
        return null;
    }

    @Override
    public List<PatrolBean> findPatrolByTimes(String times) {
        return null;
    }

    @Override
    public List<PatrolBean> findPatrolByDateAndTimes(String Date, String times) {
        return null;
    }

    @Override
    public List<HashMap<String, String>> findPatrolStaticsByDate(String date) {
        return null;
    }

    @Override
    public List<HashMap<String, String>> findPatrolStaticsByDateAndTimes(String date, String times) {
        return null;
    }

    @Override
    public List<HashMap<String, String>> findPatrolStaticsByDateAndTimesAndRoomID(String date, String times, String roomID) {
        return null;
    }

    @Override
    public List<HashMap<String, String>> findPatrolStaticsByStartAndEnd(String startDate, String endDate) {
        return null;
    }
}
