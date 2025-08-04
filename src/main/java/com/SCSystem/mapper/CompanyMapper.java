package com.SCSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.SCSystem.dto.Manager;
import com.SCSystem.dto.Company;

@Mapper
public interface CompanyMapper {

	List<Company> getCompanyList();
	
	Company getCompany(int companyId);
	
	int insertCompany(Company company);
	
	int updateCompany(Company company);
	
	int deleteCompany(int companyId);
}

