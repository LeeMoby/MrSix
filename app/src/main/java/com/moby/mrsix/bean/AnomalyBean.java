package com.moby.mrsix.bean;

/**
 * Created by Moby on 16/3/29.
 */
public class AnomalyBean {
    private String anomalyID;
    private String anomalyDetail;
    private String isDone;
    private String doneDateTime;
    private String anomalyRecord;
    private String workTicket;
    private String anomalyType;
    private String patrolID;

    public String getAnomalyID() {
        return anomalyID;
    }

    public void setAnomalyID(String anomalyID) {
        this.anomalyID = anomalyID;
    }

    public String getAnomalyDetail() {
        return anomalyDetail;
    }

    public void setAnomalyDetail(String anomalyDetail) {
        this.anomalyDetail = anomalyDetail;
    }

    public String getIsDone() {
        return isDone;
    }

    public void setIsDone(String isDone) {
        this.isDone = isDone;
    }

    public String getDoneDateTime() {
        return doneDateTime;
    }

    public void setDoneDateTime(String doneDateTime) {
        this.doneDateTime = doneDateTime;
    }

    public String getAnomalyRecord() {
        return anomalyRecord;
    }

    public void setAnomalyRecord(String anomalyRecord) {
        this.anomalyRecord = anomalyRecord;
    }

    public String getWorkTicket() {
        return workTicket;
    }

    public void setWorkTicket(String workTicket) {
        this.workTicket = workTicket;
    }

    public String getAnomalyType() {
        return anomalyType;
    }

    public void setAnomalyType(String anomalyType) {
        this.anomalyType = anomalyType;
    }

    public String getPatrolID() {
        return patrolID;
    }

    public void setPatrolID(String patrolID) {
        this.patrolID = patrolID;
    }
}
