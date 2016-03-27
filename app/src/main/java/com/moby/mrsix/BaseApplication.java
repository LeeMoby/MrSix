package com.moby.mrsix;

import android.app.Application;

/**
 * Created by Moby on 16/3/23.
 */
public class BaseApplication extends Application {
    private String loginUser;
    private int patrolTimes;
    private String[] roomName;
    private String[] roomType;
    private String[] roomId;

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public int getPatrolTimes() {
        return patrolTimes;
    }

    public void setPatrolTimes(int patrolTimes) {
        this.patrolTimes = patrolTimes;
    }


    public String[] getRoomName() {
        return roomName;
    }

    public void setRoomName(String[] roomName) {
        this.roomName = roomName;
    }

    public String[] getRoomType() {
        return roomType;
    }

    public void setRoomType(String[] roomType) {
        this.roomType = roomType;
    }

    public String[] getRoomId() {
        return roomId;
    }

    public void setRoomId(String[] roomId) {
        this.roomId = roomId;
    }
}
