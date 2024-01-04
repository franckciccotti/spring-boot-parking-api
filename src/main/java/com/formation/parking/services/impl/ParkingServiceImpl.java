package com.formation.parking.services.impl;

import com.formation.parking.dao.ParkingAPIDAO;
import com.formation.parking.dao.entity.RecordEntity;
import com.formation.parking.dao.entity.ReponseParkingAPIEntity;
import com.formation.parking.dao.entity.ResultsEntity;
import com.formation.parking.models.Parking;
import com.formation.parking.services.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingServiceImpl implements ParkingService {
    @Autowired
    public ParkingAPIDAO parkingAPIDAO;

    @Override
    public List<Parking> getListParkings() {
        ReponseParkingAPIEntity reponse = parkingAPIDAO.getListeParkings();
        return transformEntityToModel(reponse);
    }

    private List<Parking> transformEntityToModel(ReponseParkingAPIEntity reponse) {
        List<Parking> resultat = new ArrayList<>();
        /*for (RecordEntity record : reponse.getRecords()) {
            Parking parking = new Parking();
            parking.setNom(record.getFields().getGrpNom());
            //parking.setStatut(record.getFields().getGrpStatut());
            parking.setStatut(getLibelleStatut(record));
            parking.setNbPlacesDispo(record.getFields().getGrpDisponible());
            parking.setNbPlacesTotal(record.getFields().getGrpExploitation());
            //parking.setHeureMaj(record.getFields().getGrpHorodatage());
            parking.setHeureMaj(getHeureMaj(record));
            resultat.add(parking);
        }*/
        for (ResultsEntity result : reponse.getResults()) {
            Parking parking = new Parking();
            parking.setNom(result.getGrpNom());
            parking.setStatut(result.getGrpStatut());
            parking.setStatut(getLibelleStatut(result));
            parking.setNbPlacesDispo(result.getGrpDisponible());
            parking.setNbPlacesTotal(result.getGrpExploitation());
            parking.setHeureMaj(result.getGrpHorodatage());
            parking.setHeureMaj(getHeureMaj(result));
            resultat.add(parking);
        }
        return resultat;
    }

    /*private String getHeureMaj(RecordEntity record) {
        OffsetDateTime dateMaj = OffsetDateTime.parse(record.getFields().getGrpHorodatage());
        OffsetDateTime dateMajWithOffSetPlus2 = dateMaj.withOffsetSameInstant(ZoneOffset.of("+02:00"));
        return dateMajWithOffSetPlus2.getHour() + "h" + dateMajWithOffSetPlus2.getMinute();
    }*/

    private String getHeureMaj(ResultsEntity result) {
        OffsetDateTime dateMaj = OffsetDateTime.parse(result.getGrpHorodatage());
        OffsetDateTime dateMajWithOffSetPlus2 = dateMaj.withOffsetSameInstant(ZoneOffset.of("+02:00"));
        return dateMajWithOffSetPlus2.getHour() + "h" + dateMajWithOffSetPlus2.getMinute();
    }

    /*private String getLibelleStatut(RecordEntity record) {
        switch(record.getFields().getGrpStatut()){
            case "1": {
                return "FERME";
            }
            case "2": {
                return "ABONNES";
            }
            case "5": {
                return "OUVERT";
            }
        }
        return "Données non disponibles";
    }*/

    private String getLibelleStatut(ResultsEntity result) {
        switch(result.getGrpStatut()){
            case "1": {
                return "FERME";
            }
            case "2": {
                return "ABONNES";
            }
            case "5": {
                return "OUVERT";
            }
        }
        return "Données non disponibles";
    }

}
