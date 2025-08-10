package com.SCSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.SCSystem.dto.ManagerGrade;

@Mapper
public interface ManagerGradeMapper {

	List<ManagerGrade> getManagerGradeList();
	
	List<ManagerGrade> getManagerGradeSearchList(String search);
	
	ManagerGrade getManagerGrade(int managerGradeId);
	
	int insertManagerGrade(ManagerGrade managerGrade);
	
	int updateManagerGrade(ManagerGrade managerGrade);
	
	int deleteManagerGrade(int managerGradeId);
}

