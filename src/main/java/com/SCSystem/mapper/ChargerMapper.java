package com.SCSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.SCSystem.dto.Charger;

@Mapper
public interface ChargerMapper {
	
	List<Charger> getList();
	
	List<Charger> getSearchList(String search);
	
	Charger get(int idx);
	
	int insert(Charger manager);
	
	int update(Charger manager);
	
	int delete(int idx);

}

