package com.SCSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.SCSystem.dto.ChargerFile;
import com.SCSystem.dto.ChargingOperation;
import com.SCSystem.dto.Check;
import com.SCSystem.dto.CheckMst;
import com.SCSystem.dto.Compatibility;
import com.SCSystem.dto.Convenience;
import com.SCSystem.dto.DistributionFile;
import com.SCSystem.dto.ElectricalStability;
import com.SCSystem.dto.Environment;
import com.SCSystem.dto.FireSafety;
import com.SCSystem.dto.Maintenance;
import com.SCSystem.dto.Opinion;
import com.SCSystem.dto.ProductSafety;
import com.SCSystem.dto.Search;

@Mapper
public interface CheckMapper {
	
	List<CheckMst> getSearchList(Search search);
	
	CheckMst getCheckMst(int idx);
	Compatibility getCompatibility(CheckMst checkMst);
	Environment getEnvironment(CheckMst checkMst);
	Convenience getConvenience(CheckMst checkMst);
	ProductSafety getProductSafety(CheckMst checkMst);
	ElectricalStability getElectricalStability(CheckMst checkMst);
	FireSafety getFireSafety(CheckMst checkMst);
	Maintenance getMaintenance(CheckMst checkMst);
	ChargingOperation getChargingOperation(CheckMst checkMst);
	Opinion getOpinion(CheckMst checkMst);
	
	int insertCheck(@Param("p_company_idx") Integer company_idx, 
					@Param("p_manager_idx") Integer manager_idx,
					@Param("p_charger_station_idx") Integer charger_station_idx,
					@Param("p_distribution_idx") Integer distribution_idx);
	
	int updateCheckMst(CheckMst checkMst);
	int updateCompatibility(Compatibility compatibility);
	int updateEnvironment(Environment environment);
	int updateConvenience(Convenience convenience);
	int updateProductSafety(ProductSafety productSafety);
	int updateElectricalStability(ElectricalStability electricalStability);
	int updateFireSafety(FireSafety fireSafety);
	int updateMaintenance(Maintenance maintenance);
	int updateChargingOperation(ChargingOperation chargingOperation);
	int updateOpinion(Opinion opinion);
	
	int deleteCheck(@Param("p_check_mst_idx") Integer check_mst_idx);
	
	int getCheckMstIdxByDistribution(int distribution_idx);
	
	ChargerFile getChargerFile(int idx);
	int insertChargerFile(ChargerFile chargerFile);
	int updateChargerFile(ChargerFile chargerFile);
	int deleteChargerFile(int charger_idx);
	
	DistributionFile getDistributionFile(int idx);
	int insertDistributionFile(DistributionFile distributionFile);
	int updateDistributionFile(DistributionFile distributionFile);
	int deleteDistributionFile(int distribution_idx);
}

