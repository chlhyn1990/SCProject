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

	Integer insertDistributionForeground(Integer checkMstIdx, Integer distributionIdx, String foregroundUrl, String foregroundPath);
	Integer insertDistributionMeter(Integer checkMstIdx, Integer distributionIdx, String meterUrl, String meterPath, String meterText);
	Integer insertDistributionModemFront(Integer checkMstIdx, Integer distributionIdx, String modemFrontUrl, String modemFrontPath, String modemFrontText);
	Integer insertDistributionModemBack(Integer checkMstIdx, Integer distributionIdx, String modemBackUrl, String modemBackPath, String modemBackText);
	Integer insertDistributionBollard(Integer checkMstIdx, Integer distributionIdx, String bollardUrl, String bollardPath);
	Integer insertDistributionInternal(Integer checkMstIdx, Integer distributionIdx, String internalUrl, String internalPath);
	Integer insertDistributionExternal(Integer checkMstIdx, Integer distributionIdx, String externalUrl, String externalPath);
	Integer insertDistributionMccb(Integer checkMstIdx, Integer distributionIdx, String mccbUrl, String mccbPath);
	Integer insertDistributionResistance(Integer checkMstIdx, Integer distributionIdx, String resistanceUrl, String resistanceUrlPath);
	Integer insertDistributionWireStatus(Integer checkMstIdx, Integer distributionIdx, String wireStatusUrl, String wireStatusPath);
	Integer insertDistributionEtc(Integer checkMstIdx, Integer distributionIdx, String etcUrl, String etcPath);







}