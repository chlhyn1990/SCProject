package com.SCSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.SCSystem.dto.CheckList;

@Mapper
public interface CheckListMapper {
	
	List<CheckList> getList();
	
	List<CheckList> getSearchList(String search);
	
	CheckList get(int idx);
	
	int insert(CheckList manager);
	
	int update(CheckList manager);
	
	int delete(int idx);

}

