package com.SCSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.SCSystem.dto.ChargingOperation;
import com.SCSystem.dto.Check;
import com.SCSystem.dto.CheckMst;
import com.SCSystem.dto.Compatibility;
import com.SCSystem.dto.Convenience;
import com.SCSystem.dto.ElectricalStability;
import com.SCSystem.dto.Environment;
import com.SCSystem.dto.FireSafety;
import com.SCSystem.dto.Maintenance;
import com.SCSystem.dto.Opinion;
import com.SCSystem.dto.ProductSafety;

@Mapper
public interface CheckMapper {
	
	List<CheckMst> getSearchList(String search);
	
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
	
	int insertCheck(@Param("company_idx") Integer company_idx, 
					@Param("manager_idx") Integer manager_idx,
					@Param("p_charger_station_idx") Integer p_charger_station_idx,
					@Param("p_distribution_idx") Integer p_distribution_idx);
	
	int update(Check manager);
	
	
	

}

