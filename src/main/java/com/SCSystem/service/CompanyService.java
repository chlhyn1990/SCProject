package com.SCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.SCSystem.dto.Company;
import com.SCSystem.mapper.CompanyMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CompanyService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	CompanyMapper companyMapper;
	
	public List<Company> getCompanyList(String search) {
		return companyMapper.getCompanySearchList(search);
	}
	
	public Company getCompany(int companyId) {
		return companyMapper.getCompany(companyId);
	}

	public int insertCompany(Company company) {
		try {
			return companyMapper.insertCompany(company);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}

	public int updateCompany(Company company) {
		try {
			return companyMapper.updateCompany(company);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}

	public int deleteCompany(int companyId) {
		try {
			return companyMapper.deleteCompany(companyId);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
}

