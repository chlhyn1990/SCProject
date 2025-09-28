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

    public Integer setForeground(Integer checkMstIdx, Integer distributionIdx, String foregroundUrl, String foregroundPath) {
        return appMapper.insertDistributionForeground(checkMstIdx, distributionIdx, foregroundUrl, foregroundPath);
    }

    public Integer setMeter(Integer checkMstIdx, Integer distributionIdx, String meterUrl, String meterPath, String meterText) {
        return appMapper.insertDistributionMeter(checkMstIdx, distributionIdx, meterUrl, meterPath, meterText);
    }

    public Integer setModemFront(Integer checkMstIdx, Integer distributionIdx, String modemFrontUrl, String modemFrontPath, String modemFrontText) {
        return appMapper.insertDistributionModemFront(checkMstIdx, distributionIdx, modemFrontUrl, modemFrontPath, modemFrontText);
    }

    public Integer setModemBack(Integer checkMstIdx, Integer distributionIdx, String modemBackUrl, String modemBackPath, String modemBackText) {
        return appMapper.insertDistributionModemBack(checkMstIdx, distributionIdx, modemBackUrl, modemBackPath, modemBackText);
    }

    public Integer setDistributionBollard(Integer checkMstIdx, Integer distributionIdx, String bollardUrl, String bollardPath){
        return appMapper.insertDistributionBollard(checkMstIdx, distributionIdx, bollardUrl, bollardPath);
    }
    public Integer setDistributionInternal(Integer checkMstIdx, Integer distributionIdx, String internalUrl, String internalPath){
        return appMapper.insertDistributionInternal(checkMstIdx, distributionIdx, internalUrl, internalPath);
    }
    public Integer setDistributionExternal(Integer checkMstIdx, Integer distributionIdx, String externalUrl, String externalPath){
        return appMapper.insertDistributionExternal(checkMstIdx, distributionIdx, externalUrl, externalPath);
    }
    public Integer setDistributionResistance(Integer checkMstIdx, Integer distributionIdx, String resistanceUrl, String resistanceUrlPath){
        return appMapper.insertDistributionResistance(checkMstIdx, distributionIdx, resistanceUrl, resistanceUrlPath);
    }
    public Integer setDistributionWireStatus(Integer checkMstIdx, Integer distributionIdx, String wireStatusUrl, String wireStatusPath){
        return appMapper.insertDistributionWireStatus(checkMstIdx, distributionIdx, wireStatusUrl, wireStatusPath);
    }
    public Integer setDistributionMccb(Integer checkMstIdx, Integer distributionIdx, String mccbUrl, String mccbPath){
        return appMapper.insertDistributionMccb(checkMstIdx, distributionIdx, mccbUrl, mccbPath);
    }
    public Integer setDistributionEtc(Integer checkMstIdx, Integer distributionIdx, String etcUrl, String etcPath){
        return appMapper.insertDistributionEtc(checkMstIdx, distributionIdx, etcUrl, etcPath);
    }


}