package com.SCSystem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SCSystem.dto.ApiResult;
import com.SCSystem.dto.Company;
import com.SCSystem.service.CompanyService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/company")
@Slf4j
@RestController
public class CompanyController {

	@Autowired
	CompanyService companyService;
	
	@PostMapping({"/list", "/list/{search}"})
	@ResponseBody
	public ResponseEntity<List<Company>> getCompanyList(@PathVariable(required = false) String search){
		List<Company> companys = companyService.getCompanyList(search);
        return new ResponseEntity<>(
        		companys,
                HttpStatus.OK
        		);
	}
	
	@PostMapping("/{companyId}")
	@ResponseBody
	public ResponseEntity<Company> getCompany(@PathVariable int companyId){
		Company company = companyService.getCompany(companyId);
        return new ResponseEntity<>(
        		company,
                HttpStatus.OK
        		);
	}
	
	@PostMapping("/delete/{companyId}")
	@ResponseBody
	public ResponseEntity<ApiResult> deleteCompany(@PathVariable  int companyId){
		ApiResult apiResult = new ApiResult();
		if(companyService.deleteCompany(companyId) == 1){
			apiResult.setCode(ApiResult.SUCCESS);
			apiResult.setMsg(ApiResult.SUCCESS_MSG);
		}else {
			apiResult.setCode(ApiResult.COMMON_DELETE_FAIL);
			apiResult.setMsg(ApiResult.COMMON_DELETE_FAIL_MSG);
		}
		return new ResponseEntity<>(
				apiResult,
                HttpStatus.OK
				);
	}
	
	@PostMapping("/insert")
	@ResponseBody
	public ResponseEntity<ApiResult> insertCompany(@RequestBody Company company){
		ApiResult apiResult = new ApiResult();
		if(companyService.insertCompany(company) == 1){
			apiResult.setCode(ApiResult.SUCCESS);
			apiResult.setMsg(ApiResult.SUCCESS_MSG);
		}else {
			apiResult.setCode(ApiResult.COMMON_INSERT_FAIL);
			apiResult.setMsg(ApiResult.COMMON_INSERT_FAIL_MSG);
		}
		return new ResponseEntity<>(
				apiResult,
                HttpStatus.OK
				);
	}
	
	@PostMapping("/update")
	@ResponseBody
	public ResponseEntity<ApiResult> updateCompany(@RequestBody  Company company){
		ApiResult apiResult = new ApiResult();
		if(companyService.updateCompany(company) == 1){
			apiResult.setCode(ApiResult.SUCCESS);
			apiResult.setMsg(ApiResult.SUCCESS_MSG);
		}else {
			apiResult.setCode(ApiResult.COMMON_UPDATE_FAIL);
			apiResult.setMsg(ApiResult.COMMON_UPDATE_FAIL_MSG);
		}
		return new ResponseEntity<>(
				apiResult,
                HttpStatus.OK
				);
	}
	
	

	
	
}

