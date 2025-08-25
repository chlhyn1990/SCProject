package com.SCSystem.controller;

import com.SCSystem.dto.*;
import com.SCSystem.service.AppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RequestMapping("/app/api")
@Slf4j
@RestController
public class AppApiController {

    @Autowired
    AppService appService;

    @PostMapping("/login")
    public ResponseEntity<Manager> getMember(@RequestBody Manager manager){

        String id=manager.getId();
        String password=manager.getPassword();

        log.info("id:{}, passwd:{}", id, password);
        Manager loginManager = appService.getManager(id,password);

        if(loginManager.getIdx()>0) {
            //SUCCESS Login
            log.info("[getMember]id:{}, name:{}", id, loginManager.getName());
             return new ResponseEntity<>(
                    loginManager,
                    HttpStatus.OK);
        }
        else if(loginManager.getIdx()==0){
            //NOT FOUND user ID
            log.info("[getMember]NOT Found User id:{}",id);
            return new ResponseEntity<>(
                    loginManager,
                    HttpStatus.NOT_FOUND);
        }
        else if(loginManager.getIdx()==-1){
            log.info("[getMember]NOT Matched Password id:{}",id);
            //NOT MATCHED password
            return new ResponseEntity<>(
                    loginManager,
                    HttpStatus.UNAUTHORIZED);
        }
        return null;
    }

    @PostMapping("/get/chargers_from_station_id")
    public ResponseEntity<List<Charger>> getChargerListFromStationIdx(@RequestBody HashMap<String, Integer> stationIdx){

        List<Charger> nonFixedChargers = appService.getNonFixedChargers(stationIdx.get("stationIdx"));

        if(nonFixedChargers.isEmpty()) {
            log.info("[getChargerListFromStationIdx]NOT FOUND CHARGER!");
            return new ResponseEntity<>(
                    nonFixedChargers,
                    HttpStatus.NOT_FOUND);
        }
        else{
            log.info("[getChargerListFromStationIdx]FOUND CHARGER!");
            return new ResponseEntity<>(
                    nonFixedChargers,
                    HttpStatus.OK);
        }
    }

    @PostMapping("/get/charger_model")
    public ResponseEntity<ChargerModel> getChargerModels(@RequestBody HashMap<String, Integer> chargerModelIdx ){

        ChargerModel chargerModel = appService.getChargerModel(chargerModelIdx.get("chargerModelIdx"));
        if(null==chargerModel) {
            chargerModel = new ChargerModel();
            chargerModel.setIdx(0);
            log.info("[getChargerModels]NOT FOUND CHARGER MODELS!");
            return new ResponseEntity<>(
                    chargerModel,
                    HttpStatus.NOT_FOUND);
        }
        else{
            log.info("[getChargerModels]FOUND CHARGER MODELS!");
            return new ResponseEntity<>(
                    chargerModel,
                    HttpStatus.OK);
        }
    }

    @PostMapping("/get/non_fixed_charger_stations")
    public ResponseEntity<List<ChargerStation>> getNonFixedChargerStations(@RequestBody HashMap<String, Integer> companyIdx){
        List<ChargerStation> chargerStations = appService.getNonFixedChargerStations(companyIdx.get("companyIdx"));

        if(chargerStations.isEmpty()) {
            log.info("[getNonFixedChargerStations]NOT FOUND CHARGER STATIONS!");
            return new ResponseEntity<>(
                    chargerStations,
                    HttpStatus.NOT_FOUND);
        }
        else{
            log.info("[getNonFixedChargerStations]FOUND CHARGER STATIONS!");
            return new ResponseEntity<>(
                    chargerStations,
                    HttpStatus.OK);
        }
    }

    @PostMapping("/set/station_manager")
    public ResponseEntity<ChargerStation> setStationManager(@RequestBody HashMap<String, Integer> data) {
        Integer updated = appService.setStationManager(data.get("stationIdx"), data.get("managerIdx"));
        ChargerStation chargerStation = appService.getStationFromIdx(data.get("stationIdx"));

        if (updated == 1) {
            log.info("[setStationManager]UPDATED MANAGER CHARGER STATIONS!");
            return new ResponseEntity<>(
                    chargerStation,
                    HttpStatus.OK);
        } else {
            log.info("[setStationManager]FAILED TO UPDATE MANAGER CHARGER STATIONS!");
            chargerStation = new ChargerStation();
            chargerStation.setIdx(-1);
            return new ResponseEntity<>(
                    chargerStation,
                    HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/get/distributions_from_station_id")
    public ResponseEntity<List<Distribution>> getDistributions(@RequestBody HashMap<String, Integer> stationIdx){

        List<Distribution> distributions = appService.getDistributions(stationIdx.get("stationIdx"));

        if(distributions.isEmpty()) {
            log.info("[getChargerListFromStationIdx]NOT FOUND CHARGER!");
            return new ResponseEntity<>(
                    distributions,
                    HttpStatus.NOT_FOUND);
        }
        else{
            log.info("[getChargerListFromStationIdx]FOUND CHARGER!");
            return new ResponseEntity<>(
                    distributions,
                    HttpStatus.OK);
        }
    }

}