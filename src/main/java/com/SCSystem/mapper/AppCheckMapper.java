package com.SCSystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AppCheckMapper {
    Integer insertDistributionForeground(
        @Param("checkMstIdx") Integer checkMstIdx, 
        @Param("distributionIdx") Integer distributionIdx, 
        @Param("foregroundUrl") String foregroundUrl, 
        @Param("foregroundPath") String foregroundPath
    );
    
    Integer insertDistributionMeter(
        @Param("checkMstIdx") Integer checkMstIdx, 
        @Param("distributionIdx") Integer distributionIdx, 
        @Param("meterUrl") String meterUrl, 
        @Param("meterPath") String meterPath, 
        @Param("meterText") String meterText
    );
    
    Integer insertDistributionModemFront(
        @Param("checkMstIdx") Integer checkMstIdx, 
        @Param("distributionIdx") Integer distributionIdx, 
        @Param("modemFrontUrl") String modemFrontUrl, 
        @Param("modemFrontPath") String modemFrontPath, 
        @Param("modemFrontText") String modemFrontText
    );
    
    Integer insertDistributionModemBack(
        @Param("checkMstIdx") Integer checkMstIdx, 
        @Param("distributionIdx") Integer distributionIdx, 
        @Param("modemBackUrl") String modemBackUrl, 
        @Param("modemBackPath") String modemBackPath, 
        @Param("modemBackText") String modemBackText
    );
    
    Integer insertDistributionBollard(
        @Param("checkMstIdx") Integer checkMstIdx, 
        @Param("distributionIdx") Integer distributionIdx, 
        @Param("bollardUrl") String bollardUrl, 
        @Param("bollardPath") String bollardPath
    );
    
    Integer insertDistributionInternal(
        @Param("checkMstIdx") Integer checkMstIdx, 
        @Param("distributionIdx") Integer distributionIdx, 
        @Param("internalUrl") String internalUrl, 
        @Param("internalPath") String internalPath
    );
    
    Integer insertDistributionExternal(
        @Param("checkMstIdx") Integer checkMstIdx, 
        @Param("distributionIdx") Integer distributionIdx, 
        @Param("externalUrl") String externalUrl, 
        @Param("externalPath") String externalPath
    );
    
    Integer insertDistributionMccb(
        @Param("checkMstIdx") Integer checkMstIdx, 
        @Param("distributionIdx") Integer distributionIdx, 
        @Param("mccbUrl") String mccbUrl, 
        @Param("mccbPath") String mccbPath
    );
    
    Integer insertDistributionResistance(
        @Param("checkMstIdx") Integer checkMstIdx, 
        @Param("distributionIdx") Integer distributionIdx, 
        @Param("resistanceUrl") String resistanceUrl, 
        @Param("resistancePath") String resistancePath
    );
    
    Integer insertDistributionWireStatus(
        @Param("checkMstIdx") Integer checkMstIdx, 
        @Param("distributionIdx") Integer distributionIdx, 
        @Param("wireStatusUrl") String wireStatusUrl, 
        @Param("wireStatusPath") String wireStatusPath
    );
    
    Integer insertDistributionEtc(
        @Param("checkMstIdx") Integer checkMstIdx, 
        @Param("distributionIdx") Integer distributionIdx, 
        @Param("etcUrl") String etcUrl, 
        @Param("etcPath") String etcPath
    );
    
    Integer getStationIdxByDistributionIdx(@Param("distributionIdx") Integer distributionIdx);
    Integer getCheckMstIdxByDistributionIdx(@Param("distributionIdx") Integer distributionIdx);

    Integer updateElectricalStabilityOvercurrentA(
        @Param("checkMstIdx") Integer checkMstIdx, 
        @Param("distributionIdx") Integer distributionIdx, 
        @Param("overcurrentA") String overcurrentA
    );
    
    Integer updateElectricalStabilityResistance(
        @Param("checkMstIdx") Integer checkMstIdx, 
        @Param("distributionIdx") Integer distributionIdx, 
        @Param("resistance") String resistance
    );

    Integer updateElectricalStabilityThickness(
        @Param("checkMstIdx") Integer checkMstIdx, 
        @Param("distributionIdx") Integer distributionIdx, 
        @Param("thickness") String thickness
    );
    
    Integer updateElectricalStabilityWireThickness(
        @Param("checkMstIdx") Integer checkMstIdx, 
        @Param("distributionIdx") Integer distributionIdx, 
        @Param("wireThickness") String wireThickness
    );
    
    Integer updateElectricalStabilityDistribution(
        @Param("checkMstIdx") Integer checkMstIdx, 
        @Param("distributionIdx") Integer distributionIdx, 
        @Param("distribution") String distribution
    );
    
    Integer updateElectricalStabilityCable(
        @Param("checkMstIdx") Integer checkMstIdx, 
        @Param("distributionIdx") Integer distributionIdx, 
        @Param("cable") String cable
    );
    
    Integer updateElectricalStabilitySensitivity(
        @Param("checkMstIdx") Integer checkMstIdx, 
        @Param("distributionIdx") Integer distributionIdx, 
        @Param("sensitivity") String sensitivity
    );
    
    Integer updateElectricalStabilityLeakA(
        @Param("checkMstIdx") Integer checkMstIdx, 
        @Param("distributionIdx") Integer distributionIdx, 
        @Param("leakageA") String leakageA
    );

    //ChargerCheck
    Integer getCheckMstIdxByChargerIdx(@Param("chargerIdx") Integer chargerIdx);
    
    Integer updateChargerFileTest(
        @Param("checkMst") Integer checkMst, 
        @Param("testUrl") String testUrl, 
        @Param("testPath") String testPath
    );
    
    Integer updateChargerFilePlate(
        @Param("checkMst") Integer checkMst, 
        @Param("plateUrl") String plateUrl, 
        @Param("platePath") String platePath
    );
    
    Integer updateChargerFileResistance(
        @Param("checkMst") Integer checkMst, 
        @Param("resistanceUrl") String resistanceUrl, 
        @Param("resistancePath") String resistancePath
    );
    
    Integer updateChargerFileInfo(
        @Param("checkMst") Integer checkMst, 
        @Param("infoUrl") String infoUrl, 
        @Param("infoPath") String infoPath
    );
    
    Integer updateChargerFileBollard(
        @Param("checkMst") Integer checkMst, 
        @Param("bollardUrl") String bollardUrl, 
        @Param("bollardPath") String bollardPath
    );
    
    Integer updateChargerFileConnector(
        @Param("checkMst") Integer checkMst, 
        @Param("connectorUrl") String connectorUrl, 
        @Param("connectorPath") String connectorPath
    );
}