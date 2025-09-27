package com.SCSystem.mapper;

import com.SCSystem.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppMapper {
	Manager getManager(String id);
	List<Charger> getChargersFromDistributionIdx(Integer distributionIdx);
	ChargerModel getChargerModel(Integer chargerModelIdx);
	List<ChargerStation> getNonFixedChargerStations(Integer companyIdx);
	Integer updateStationManager(Integer chargerStationIdx, Integer managerIdx);
	ChargerStation getStationFromIdx(Integer chargerStationIdx);
	List<Distribution> getDistributions(Integer chargerStationIdx);
	Integer updateStationFixed(Integer chargerStationIdx);

	Integer insertOrUpdateForeground(Integer checkMstIdx, Integer distributionIdx, String foregroundUrl, String foregroundPath);
	Integer insertOrUpdateMeter(Integer checkMstIdx, Integer distributionIdx, String meterUrl, String meterPath, String meterText);
	Integer insertOrUpdateModemFront(Integer checkMstIdx, Integer distributionIdx, String modemFrontUrl, String modemFrontPath, String modemFrontText);
	Integer insertOrUpdateModemBack(Integer checkMstIdx, Integer distributionIdx, String modemBackUrl, String modemBackPath, String modemBackText);

}