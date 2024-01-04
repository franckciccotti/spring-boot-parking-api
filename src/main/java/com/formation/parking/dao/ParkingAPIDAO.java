package com.formation.parking.dao;

import com.formation.parking.dao.entity.ReponseParkingAPIEntity;

public interface ParkingAPIDAO {

    public default ReponseParkingAPIEntity getListeParkings() {
        return null;
    }

}
