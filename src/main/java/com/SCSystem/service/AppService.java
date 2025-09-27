package com.SCSystem.service;

import com.SCSystem.dto.*;
import com.SCSystem.mapper.AppMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class AppService {
    @Autowired
    AppMapper appMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Manager getManager(String id, String passwd) {
        Manager loginManager = appMapper.getManager(id);

        if (null == loginManager) {
            loginManager = new Manager();
            loginManager.setIdx(0);
            return loginManager;
        }

        else if (passwordEncoder.matches(passwd, loginManager.getPassword())){
            return loginManager;
        }
        else {
            loginManager = new Manager();
            loginManager.setIdx(-1);
            return loginManager;
        }
    }

    public List<Charger> getChargersFromDistributionIdx(Integer distributionIdx) {
        return appMapper.getChargersFromDistributionIdx(distributionIdx);
    }

    public ChargerModel getChargerModel(Integer chargerModelIdx) {
        return appMapper.getChargerModel(chargerModelIdx);
    }

    public List<ChargerStation> getNonFixedChargerStations(Integer companyIdx) {
        return appMapper.getNonFixedChargerStations(companyIdx);
    }

    public Integer setStationManager(Integer chargerStationIdx, Integer managerIdx){
        if(managerIdx==0){
            managerIdx=null;
        }
        return appMapper.updateStationManager(chargerStationIdx, managerIdx);
    }

    public ChargerStation getStationFromIdx(Integer chargerStationIdx){
        return appMapper.getStationFromIdx(chargerStationIdx);
    }
    public List<Distribution> getDistributions(Integer chargerStationIdx){
        return appMapper.getDistributions(chargerStationIdx);
    };

    public Integer setStationFixed(Integer chargerStationIdx){
        return appMapper.updateStationFixed(chargerStationIdx);
    }

    @Autowired

    public Integer saveForeground(Integer checkMstIdx, Integer distributionIdx, String foregroundUrl, String foregroundPath) {
        return appMapper.insertOrUpdateForeground(checkMstIdx, distributionIdx, foregroundUrl, foregroundPath);
    }

    public Integer saveMeter(Integer checkMstIdx, Integer distributionIdx, String meterUrl, String meterPath, String meterText) {
        return appMapper.insertOrUpdateMeter(checkMstIdx, distributionIdx, meterUrl, meterPath, meterText);
    }

    public Integer saveModemFront(Integer checkMstIdx, Integer distributionIdx, String modemFrontUrl, String modemFrontPath, String modemFrontText) {
        return appMapper.insertOrUpdateModemFront(checkMstIdx, distributionIdx, modemFrontUrl, modemFrontPath, modemFrontText);
    }

    public Integer saveModemBack(Integer checkMstIdx, Integer distributionIdx, String modemBackUrl, String modemBackPath, String modemBackText) {
        return appMapper.insertOrUpdateModemBack(checkMstIdx, distributionIdx, modemBackUrl, modemBackPath, modemBackText);
    }


}