package com.SCSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.SCSystem.dto.ChargerStation;
import com.SCSystem.dto.Search;

@Mapper
public interface ChargerStationMapper {
	
	List<ChargerStation> getList();
	
	List<ChargerStation> getSearchList(Search search);
	
	ChargerStation get(int idx);
	
	int insert(ChargerStation manager);
	
	int update(ChargerStation manager);
	
	int delete(int idx);

}

