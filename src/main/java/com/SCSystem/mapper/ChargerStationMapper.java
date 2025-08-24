package com.SCSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.SCSystem.dto.ChargerStation;

@Mapper
public interface ChargerStationMapper {
	
	List<ChargerStation> getList();
	
	List<ChargerStation> getSearchList(String search);
	
	ChargerStation get(int idx);
	
	int insert(ChargerStation manager);
	
	int insertCheckList(@Param("company_idx") Integer company_idx, 
	        			@Param("manager_idx") Integer manager_idx);
	
	int update(ChargerStation manager);
	
	int delete(int idx);

}

