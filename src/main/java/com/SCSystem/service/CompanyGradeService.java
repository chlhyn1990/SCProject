package com.SCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.SCSystem.dto.CompanyGrade;
import com.SCSystem.mapper.CompanyGradeMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CompanyGradeService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	CompanyGradeMapper companyGradeMapper;
	
	public List<CompanyGrade> getCompanyGradeList(String search) {
		return companyGradeMapper.getCompanyGradeSearchList(search);
	}
	
	public CompanyGrade getCompanyGrade(int companyGradeId) {
		return companyGradeMapper.getCompanyGrade(companyGradeId);
	}
	
	public int insertCompanyGrade(CompanyGrade company) {
		try {
			return companyGradeMapper.insertCompanyGrade(company);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
	
	public int updateCompanyGrade(CompanyGrade company) {
		try {
			return companyGradeMapper.updateCompanyGrade(company);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
	
	public int deleteCompanyGrade(int companyGradeId) {
		try {
			return companyGradeMapper.deleteCompanyGrade(companyGradeId);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
}

