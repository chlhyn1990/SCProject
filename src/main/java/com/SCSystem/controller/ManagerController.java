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
import com.SCSystem.dto.Manager;
import com.SCSystem.service.ManagerService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/manager")
@Slf4j
@RestController
public class ManagerController {

	@Autowired
	ManagerService service;
	
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<Manager> login(@RequestBody  Manager dto){
		Manager loginManager = service.login(dto);
        return new ResponseEntity<>(
        		loginManager,
                HttpStatus.OK
        		);
	}
	
	@PostMapping({"/list", "/list/{search}"})
	@ResponseBody
	public ResponseEntity<List<Manager>> getCompanyList(@PathVariable(required = false) String search){
		List<Manager> dtos = service.getList(search);
        return new ResponseEntity<>(
        		dtos,
                HttpStatus.OK
        		);
	}
	
	@PostMapping("/{idx}")
	@ResponseBody
	public ResponseEntity<Manager> getCompany(@PathVariable int idx){
		Manager manager = service.get(idx);
        return new ResponseEntity<>(
        		manager,
                HttpStatus.OK
        		);
	}
	
	@PostMapping("/delete/{idx}")
	@ResponseBody
	public ResponseEntity<ApiResult> deleteCompany(@PathVariable  int idx){
		ApiResult apiResult = new ApiResult();
		if(service.delete(idx) == 1){
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
	public ResponseEntity<ApiResult> insert(@RequestBody  Manager dto){
		ApiResult apiResult = new ApiResult();
		if(service.insert(dto) == 1){
			apiResult.setCode(ApiResult.SUCCESS);
			apiResult.setMsg(ApiResult.SUCCESS_MSG);
		}else {
			apiResult.setCode(ApiResult.MANAGER_INSERT_FAIL);
			apiResult.setMsg(ApiResult.MANAGER_INSERT_FAIL_MSG);
		}
		return new ResponseEntity<>(
				apiResult,
                HttpStatus.OK
				);
	}
	
	@PostMapping("/update")
	@ResponseBody
	public ResponseEntity<ApiResult> update(@RequestBody  Manager dto){
		ApiResult apiResult = new ApiResult();
		if(service.update(dto) == 1){
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

