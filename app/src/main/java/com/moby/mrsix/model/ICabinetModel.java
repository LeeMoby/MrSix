package com.moby.mrsix.model;

import com.moby.mrsix.bean.CabinetBean;

import java.util.List;

/**
 * Created by Moby on 16/3/28.
 */
public interface ICabinetModel {
    CabinetBean getCabinetByID(String cabinetID);

    CabinetBean getCabinetByNO(String cabinetNO);

    List<CabinetBean> findCabinetByRoomID(String roomID);

    List<CabinetBean> findCabinetByRoomNo(String roomNO);

    List<CabinetBean> findCabinetByRoomIDAndLocalX(String roomID, String localX);

    List<CabinetBean> findCabinetByRoomNOAndLocalX(String roomNO, String localX);
}
