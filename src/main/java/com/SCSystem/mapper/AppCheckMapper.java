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
    Integer insertDistributionResistance(Integer checkMstIdx, Integer distributionIdx, String resistanceUrl, String resistanceUrlPath);
    Integer insertDistributionWireStatus(Integer checkMstIdx, Integer distributionIdx, String wireStatusUrl, String wireStatusPath);
    Integer insertDistributionEtc(Integer checkMstIdx, Integer distributionIdx, String etcUrl, String etcPath);
    Integer getStationIdxByDistributionIdx(Integer distributionIdx);
    Integer getCheckMstIdxByDistributionIdx(Integer distributionIdx);
    Integer insertElectricalStabilityOverCurrentA(Integer checkMstIdx, Integer distributionIdx, String overCurrentA);
    Integer insertElectricalStabilityResistance(Integer checkMstIdx, Integer distributionIdx, String resistance);

    Integer insertElectricalStabilityThickness(Integer checkMstIdx, Integer distributionIdx, String thickness);
    Integer insertElectricalStabilityWireThickness(Integer checkMstIdx, Integer distributionIdx, String wireThickness);
    Integer insertElectricalStabilityDistribution(Integer checkMstIdx, Integer distributionIdx, String distribution);
    Integer insertElectricalStabilityCable(Integer checkMstIdx, Integer distributionIdx, String cable);
    Integer insertElectricalStabilitySensitivity(Integer checkMstIdx, Integer distributionIdx, String sensitivity);
}
