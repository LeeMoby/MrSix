package com.moby.mrsix;

import android.app.Application;

/**
 * Created by Moby on 16/3/23.
 */
public class BaseApplication extends Application {
    private String login_user;
    private int patrol_times;

    public String getLogin_user() {
        return login_user;
    }

    public void setLogin_user(String login_user){
        this.login_user = login_user;
    }

    public int getPatrol_times() {
        return patrol_times;
    }

    public void setPatrol_times(int patrol_times) {
        this.patrol_times = patrol_times;
    }
}
