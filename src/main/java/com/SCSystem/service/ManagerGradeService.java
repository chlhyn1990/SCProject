package com.SCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.SCSystem.dto.ManagerGrade;
import com.SCSystem.mapper.ManagerGradeMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ManagerGradeService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ManagerGradeMapper managerGradeMapper;
	
	public List<ManagerGrade> getManagerGradeList(String search) {
		if(search == null || search.equals(""))
			return managerGradeMapper.getManagerGradeList();
		else
			return managerGradeMapper.getManagerGradeSearchList(search);
	}
	
	public ManagerGrade getManagerGrade(int managerGradeId) {
		return managerGradeMapper.getManagerGrade(managerGradeId);
	}
	
	public int insertManagerGrade(ManagerGrade manager) {
		try {
			return managerGradeMapper.insertManagerGrade(manager);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
	
	public int updateManagerGrade(ManagerGrade manager) {
		try {
			return managerGradeMapper.updateManagerGrade(manager);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
	
	public int deleteManagerGrade(int managerGradeId) {
		try {
			return managerGradeMapper.deleteManagerGrade(managerGradeId);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
}

