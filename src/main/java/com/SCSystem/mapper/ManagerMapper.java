package com.SCSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.SCSystem.dto.Manager;

@Mapper
public interface ManagerMapper {
	
	List<Manager> getList();
	
	List<Manager> getSearchList(String search);
	
	Manager get(int idx);

	Manager login(Manager manager);
	
	int insert(Manager manager);
	
	int update(Manager manager);
	
	int delete(int idx);

}

