package com.moby.mrsix.bean;

/**
 * Created by Moby on 16/3/29.
 */
public class PhotoBean {
    private String photoID;
    private String photoLocal;
    private String photoDateTime;
    private String patrolID;

    public String getPhotoID() {
        return photoID;
    }

    public void setPhotoID(String photoID) {
        this.photoID = photoID;
    }

    public String getPhotoLocal() {
        return photoLocal;
    }

    public void setPhotoLocal(String photoLocal) {
        this.photoLocal = photoLocal;
    }

    public String getPhotoDateTime() {
        return photoDateTime;
    }

    public void setPhotoDateTime(String photoDateTime) {
        this.photoDateTime = photoDateTime;
    }

    public String getPatrolID() {
        return patrolID;
    }

    public void setPatrolID(String patrolID) {
        this.patrolID = patrolID;
    }
}
