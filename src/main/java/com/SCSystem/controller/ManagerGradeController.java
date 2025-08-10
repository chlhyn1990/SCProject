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
import com.SCSystem.dto.ManagerGrade;
import com.SCSystem.service.ManagerGradeService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/managerGrade")
@Slf4j
@RestController
public class ManagerGradeController {

	@Autowired
	ManagerGradeService managerGradeService;
	
	@PostMapping({"/list", "/list/{search}"})
	@ResponseBody
	public ResponseEntity<List<ManagerGrade>> getManagerGradeList(@PathVariable(required = false) String search){
		List<ManagerGrade> managerGradeList = managerGradeService.getManagerGradeList(search);
        return new ResponseEntity<>(
        		managerGradeList,
                HttpStatus.OK
        		);
	}
	
	@PostMapping("/{managerGradeId}")
	@ResponseBody
	public ResponseEntity<ManagerGrade> getManagerGrade(@PathVariable int managerGradeId){
		ManagerGrade companyGrade = managerGradeService.getManagerGrade(managerGradeId);
        return new ResponseEntity<>(
        		companyGrade,
                HttpStatus.OK
        		);
	}
	
	@PostMapping("/delete/{managerGradeId}")
	@ResponseBody
	public ResponseEntity<ApiResult> deleteManagerGrade(@PathVariable  int managerGradeId){
		ApiResult apiResult = new ApiResult();
		if(managerGradeService.deleteManagerGrade(managerGradeId) == 1){
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
	public ResponseEntity<ApiResult> insertManagerGrade(@RequestBody ManagerGrade managerGrade){
		ApiResult apiResult = new ApiResult();
		if(managerGradeService.insertManagerGrade(managerGrade) == 1){
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
	public ResponseEntity<ApiResult> updateManagerGrade(@RequestBody  ManagerGrade managerGrade){
		ApiResult apiResult = new ApiResult();
		if(managerGradeService.updateManagerGrade(managerGrade) == 1){
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

