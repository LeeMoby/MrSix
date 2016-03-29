package com.moby.mrsix.bean;

import java.util.List;

/**
 * Created by Moby on 16/3/28.
 */
public class RoomBean {
    private String roomID;
    private String roomName;
    private String roomType;
    private String roomNO;
    private String roomLocal;
    private List<CabinetBean> cabinetList;

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public List<CabinetBean> getCabinetList() {
        return cabinetList;
    }

    public void setCabinetList(List<CabinetBean> cabinetList) {
        this.cabinetList = cabinetList;
    }

    public String getRoomNO() {
        return roomNO;
    }

    public void setRoomNO(String roomNO) {
        this.roomNO = roomNO;
    }

    public String getRoomLocal() {
        return roomLocal;
    }

    public void setRoomLocal(String roomLocal) {
        this.roomLocal = roomLocal;
    }
}
