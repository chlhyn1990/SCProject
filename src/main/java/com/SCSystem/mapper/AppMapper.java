package com.SCSystem.mapper;

import com.SCSystem.dto.Charger;
import com.SCSystem.dto.ChargerModel;
import com.SCSystem.dto.ChargerStation;
import com.SCSystem.dto.Manager;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppMapper {
	Manager getManager(String id);
	List<Charger> getChargersFromStationIdx(Integer stationIdx);
	ChargerModel getChargerModel(Integer chargerModelIdx);
	List<ChargerStation> getNonFixedChargerStations(Integer companyIdx);
	Integer updateStationManager(Integer chargerStationIdx, Integer managerIdx);
	ChargerStation getStationFromIdx(Integer chargerStationIdx);
}