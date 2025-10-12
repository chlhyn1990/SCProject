package com.SCSystem.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppCheckMapper {
    Integer insertDistributionForeground(Integer checkMstIdx, Integer distributionIdx, String foregroundUrl, String foregroundPath);
    Integer insertDistributionMeter(Integer checkMstIdx, Integer distributionIdx, String meterUrl, String meterPath, String meterText);
    Integer insertDistributionModemFront(Integer checkMstIdx, Integer distributionIdx, String modemFrontUrl, String modemFrontPath, String modemFrontText);
    Integer insertDistributionModemBack(Integer checkMstIdx, Integer distributionIdx, String modemBackUrl, String modemBackPath, String modemBackText);
    Integer insertDistributionBollard(Integer checkMstIdx, Integer distributionIdx, String bollardUrl, String bollardPath);
    Integer insertDistributionInternal(Integer checkMstIdx, Integer distributionIdx, String internalUrl, String internalPath);
    Integer insertDistributionExternal(Integer checkMstIdx, Integer distributionIdx, String externalUrl, String externalPath);
    Integer insertDistributionMccb(Integer checkMstIdx, Integer distributionIdx, String mccbUrl, String mccbPath);
    Integer insertDistributionResistance(Integer checkMstIdx, Integer distributionIdx, String resistanceUrl, String resistancePath);
    Integer insertDistributionWireStatus(Integer checkMstIdx, Integer distributionIdx, String wireStatusUrl, String wireStatusPath);
    Integer insertDistributionEtc(Integer checkMstIdx, Integer distributionIdx, String etcUrl, String etcPath);
    Integer getStationIdxByDistributionIdx(Integer distributionIdx);
    Integer getCheckMstIdxByDistributionIdx(Integer distributionIdx);

    Integer updateElectricalStabilityOvercurrentA(Integer checkMstIdx, Integer distributionIdx, String overcurrentA);
    Integer updateElectricalStabilityResistance(Integer checkMstIdx, Integer distributionIdx, String resistance);

    Integer updateElectricalStabilityThickness(Integer checkMstIdx, Integer distributionIdx, String thickness);
    Integer updateElectricalStabilityWireThickness(Integer checkMstIdx, Integer distributionIdx, String wireThickness);
    Integer updateElectricalStabilityDistribution(Integer checkMstIdx, Integer distributionIdx, String distribution);
    Integer updateElectricalStabilityCable(Integer checkMstIdx, Integer distributionIdx, String cable);
    Integer updateElectricalStabilitySensitivity(Integer checkMstIdx, Integer distributionIdx, String sensitivity);
    Integer updateElectricalStabilityLeakA(Integer checkMstIdx, Integer distributionIdx, String leakageA);



    //ChargerCheck
    Integer getCheckMstIdxByChargerIdx(Integer chargerIdx);
    Integer updateChargerFileTest(Integer checkMst, String testUrl, String testPath);
    Integer updateChargerFilePlate(Integer checkMst, String plateUrl, String platePath);
    Integer updateChargerFileResistance(Integer checkMst, String resistanceUrl, String resistancePath);
    Integer updateChargerFileInfo(Integer checkMst, String infoUrl, String infoPath);
    Integer updateChargerFileBollard(Integer checkMst, String bollardUrl, String bollardPath);
    Integer updateChargerFileConnector(Integer checkMst, String connectorUrl, String connectorPath);
}
