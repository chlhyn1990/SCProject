package com.SCSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.SCSystem.dto.ChargerModel;

@Mapper
public interface ChargerModelMapper {
	
	List<ChargerModel> getList();
	
	List<ChargerModel> getSearchList(String search);
	
	ChargerModel get(int idx);
	
	int insert(ChargerModel manager);
	
	int update(ChargerModel manager);
	
	int delete(int idx);

}

