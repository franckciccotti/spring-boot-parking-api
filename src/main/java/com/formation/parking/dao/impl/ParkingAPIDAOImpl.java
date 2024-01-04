package com.formation.parking.dao.impl;

import com.formation.parking.dao.ParkingAPIDAO;
import com.formation.parking.dao.entity.ReponseParkingAPIEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ParkingAPIDAOImpl implements ParkingAPIDAO {

    private static final String URL_API_OPEN_DATA = "https://data.nantesmetropole.fr/api/explore/v2.1/catalog/datasets/244400404_parkings-publics-nantes-disponibilites/records?limit=100";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ReponseParkingAPIEntity getListeParkings() {
        return restTemplate.getForEntity(URL_API_OPEN_DATA, ReponseParkingAPIEntity.class).getBody();
    }
}
