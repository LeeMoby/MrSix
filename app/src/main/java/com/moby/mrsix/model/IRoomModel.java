package com.moby.mrsix.model;

import com.moby.mrsix.bean.RoomBean;

import java.util.List;

/**
 * Created by Moby on 16/3/28.
 */
public interface IRoomModel {
    RoomBean getRoomByID(String roomID);
    RoomBean getRoomByNO(String roomNO);
    List<RoomBean> findAllRoom();
    List<RoomBean> findRoomByRoomType(String roomType);
}
