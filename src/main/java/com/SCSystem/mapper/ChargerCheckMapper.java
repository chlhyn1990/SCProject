package com.SCSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.SCSystem.dto.ChargerCheck;

@Mapper
public interface ChargerCheckMapper {
	
	List<ChargerCheck> getList();
	
	List<ChargerCheck> getSearchList(String search);
	
	ChargerCheck get(int idx);
	
	int insert(ChargerCheck manager);
	
	int insertCheckList(@Param("company_idx") Integer company_idx, 
	        			@Param("manager_idx") Integer manager_idx);
	
	int update(ChargerCheck manager);
	
	int delete(int idx);

}

