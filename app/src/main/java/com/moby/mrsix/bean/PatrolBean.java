package com.moby.mrsix.bean;

import java.util.List;

/**
 * Created by Moby on 16/3/29.
 */
public class PatrolBean {
    private String patrolID;
    private String patrolDateTime;
    private String patrolTimes;
    private String personID;
    private String roomID;
    private String cabinetID;
    private String patrolResult;
    private String haveAnomaly;
    private String havePhoto;
    private String temperature;
    private String humidity;
    private RoomBean roomBean;
    private CabinetBean cabinetBean;
    private List<PersonBean> personBean;
    private AnomalyBean anomalyBean;
    private List<PhotoBean> photoBean;

    public String getPatrolID() {
        return patrolID;
    }

    public void setPatrolID(String patrolID) {
        this.patrolID = patrolID;
    }

    public String getPatrolDateTime() {
        return patrolDateTime;
    }

    public void setPatrolDateTime(String patrolDateTime) {
        this.patrolDateTime = patrolDateTime;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getCabinetID() {
        return cabinetID;
    }

    public void setCabinetID(String cabinetID) {
        this.cabinetID = cabinetID;
    }

    public String getPatrolResult() {
        return patrolResult;
    }

    public void setPatrolResult(String patrolResult) {
        this.patrolResult = patrolResult;
    }

    public String getHaveAnomaly() {
        return haveAnomaly;
    }

    public void setHaveAnomaly(String haveAnomaly) {
        this.haveAnomaly = haveAnomaly;
    }

    public String getHavePhoto() {
        return havePhoto;
    }

    public void setHavePhoto(String havePhoto) {
        this.havePhoto = havePhoto;
    }

    public CabinetBean getCabinetBean() {
        return cabinetBean;
    }

    public void setCabinetBean(CabinetBean cabinetBean) {
        this.cabinetBean = cabinetBean;
    }

    public AnomalyBean getAnomalyBean() {
        return anomalyBean;
    }

    public void setAnomalyBean(AnomalyBean anomalyBean) {
        this.anomalyBean = anomalyBean;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public RoomBean getRoomBean() {
        return roomBean;
    }

    public void setRoomBean(RoomBean roomBean) {
        this.roomBean = roomBean;
    }

    public List<PhotoBean> getPhotoBean() {
        return photoBean;
    }

    public void setPhotoBean(List<PhotoBean> photoBean) {
        this.photoBean = photoBean;
    }

    public List<PersonBean> getPersonBean() {
        return personBean;
    }

    public void setPersonBean(List<PersonBean> personBean) {
        this.personBean = personBean;
    }

    public String getPatrolTimes() {
        return patrolTimes;
    }

    public void setPatrolTimes(String patrolTimes) {
        this.patrolTimes = patrolTimes;
    }
}
