package com.SCSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.SCSystem.dto.CompanyGrade;

@Mapper
public interface CompanyGradeMapper {

	List<CompanyGrade> getCompanyGradeList();
	
	List<CompanyGrade> getCompanyGradeSearchList(String search);
	
	CompanyGrade getCompanyGrade(int companyGradeId);
	
	int insertCompanyGrade(CompanyGrade companyGrade);
	
	int updateCompanyGrade(CompanyGrade companyGrade);
	
	int deleteCompanyGrade(int companyGradeId);
}

