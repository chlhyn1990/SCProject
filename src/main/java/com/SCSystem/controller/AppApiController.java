package com.SCSystem.controller;

import com.SCSystem.dto.Charger;
import com.SCSystem.dto.ChargerModel;
import com.SCSystem.dto.ChargerStation;
import com.SCSystem.dto.Manager;
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
            log.info("id:{}, name:{}", id, loginManager.getName());
             return new ResponseEntity<>(
                    loginManager,
                    HttpStatus.OK);
        }
        else if(loginManager.getIdx()==0){
            //NOT FOUND user ID
            log.info("NOT Found User id:{}",id);
            return new ResponseEntity<>(
                    loginManager,
                    HttpStatus.NOT_FOUND);
        }
        else if(loginManager.getIdx()==-1){
            log.info("NOT Matched Password id:{}",id);
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
            log.info("NOT FOUND CHARGER!");
            return new ResponseEntity<>(
                    nonFixedChargers,
                    HttpStatus.NOT_FOUND);
        }
        else{
            //NOT FOUND user ID
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
            log.info("NOT FOUND CHARGER MODELS!");
            return new ResponseEntity<>(
                    chargerModel,
                    HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(
                    chargerModel,
                    HttpStatus.OK);
        }
    }

    @PostMapping("/get/non_fixed_charger_stations")
    public ResponseEntity<List<ChargerStation>> getNonFixedChargerStations(@RequestBody HashMap<String, Integer> companyIdx){
        List<ChargerStation> chargerStations = appService.getNonFixedChargerStations(companyIdx.get("companyIdx"));

        if(chargerStations.isEmpty()) {
            log.info("NOT FOUND CHARGER STATIONS!");
            return new ResponseEntity<>(
                    chargerStations,
                    HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(
                    chargerStations,
                    HttpStatus.OK);
        }
    }

}