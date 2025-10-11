package com.SCSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.SCSystem.dto.Distribution;

@Mapper
public interface ExcelMapper {
	
	List<Distribution> getList();
	
	List<Distribution> getListByStation(int charger_station_idx);
	
	
	Distribution get(int idx);
	
	int insert(Distribution manager);
	
	int update(Distribution manager);
	
	int delete(int idx);
	

}

