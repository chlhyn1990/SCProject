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
import com.SCSystem.dto.CompanyGrade;
import com.SCSystem.service.CompanyGradeService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/company")
@Slf4j
@RestController
public class CompanyGradeController {

	@Autowired
	CompanyGradeService companyGradeService;
	
	@PostMapping("/{search}")
	@ResponseBody
	public ResponseEntity<List<CompanyGrade>> getCompanyGradeList(@PathVariable String search){
		List<CompanyGrade> companyGradeList = companyGradeService.getCompanyGradeList(search);
        return new ResponseEntity<>(
        		companyGradeList,
                HttpStatus.OK
        		);
	}
	
	@PostMapping("/{companyGradeId}")
	@ResponseBody
	public ResponseEntity<CompanyGrade> getCompanyGrade(@PathVariable int companyGradeId){
		CompanyGrade companyGrade = companyGradeService.getCompanyGrade(companyGradeId);
        return new ResponseEntity<>(
        		companyGrade,
                HttpStatus.OK
        		);
	}
	
	@PostMapping("/delete/{companyGradeId}")
	@ResponseBody
	public ResponseEntity<ApiResult> deleteCompanyGrade(@PathVariable  int companyGradeId){
		ApiResult apiResult = new ApiResult();
		if(companyGradeService.deleteCompanyGrade(companyGradeId) == 1){
			apiResult.setCode(ApiResult.SUCCESS);
			apiResult.setMsg(ApiResult.SUCCESS_MSG);
		}else {
			apiResult.setCode(ApiResult.COMPANY_DELETE_FAIL);
			apiResult.setMsg(ApiResult.COMPANY_DELETE_FAIL_MSG);
		}
		return new ResponseEntity<>(
				apiResult,
                HttpStatus.OK
				);
	}
	
	@PostMapping("/insert")
	@ResponseBody
	public ResponseEntity<ApiResult> insertCompanyGrade(@RequestBody CompanyGrade companyGrade){
		ApiResult apiResult = new ApiResult();
		if(companyGradeService.insertCompanyGrade(companyGrade) == 1){
			apiResult.setCode(ApiResult.SUCCESS);
			apiResult.setMsg(ApiResult.SUCCESS_MSG);
		}else {
			apiResult.setCode(ApiResult.COMPANY_INSERT_FAIL);
			apiResult.setMsg(ApiResult.COMPANY_INSERT_FAIL_MSG);
		}
		return new ResponseEntity<>(
				apiResult,
                HttpStatus.OK
				);
	}
	
	@PostMapping("/update")
	@ResponseBody
	public ResponseEntity<ApiResult> updateCompanyGrade(@RequestBody  CompanyGrade companyGrade){
		ApiResult apiResult = new ApiResult();
		if(companyGradeService.updateCompanyGrade(companyGrade) == 1){
			apiResult.setCode(ApiResult.SUCCESS);
			apiResult.setMsg(ApiResult.SUCCESS_MSG);
		}else {
			apiResult.setCode(ApiResult.COMPANY_UPDATE_FAIL);
			apiResult.setMsg(ApiResult.COMPANY_UPDATE_FAIL_MSG);
		}
		return new ResponseEntity<>(
				apiResult,
                HttpStatus.OK
				);
	}
	
	

	
	
}

