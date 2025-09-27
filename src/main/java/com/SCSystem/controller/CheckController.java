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
import com.SCSystem.dto.Check;
import com.SCSystem.dto.CheckMst;
import com.SCSystem.dto.Search;
import com.SCSystem.service.CheckService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/check")
@Slf4j
@RestController
public class CheckController {

	@Autowired
	CheckService service;
	
	@PostMapping({"/list", "/list/{search}"})
	@ResponseBody
	public ResponseEntity<List<CheckMst>> getSearchList(@PathVariable(required = false) Search search){
		List<CheckMst> dtos = service.getSearchList(search);
        return new ResponseEntity<>(
        		dtos,
                HttpStatus.OK
        		);
	}
	
	@PostMapping("/{idx}")
	@ResponseBody
	public ResponseEntity<Check> get(@PathVariable int idx){
		Check dto = service.get(idx);
        return new ResponseEntity<>(
        		dto,
                HttpStatus.OK
        		);
	}
	
	@PostMapping("/insert")
	@ResponseBody
	public ResponseEntity<ApiResult> insert(@RequestBody  Integer company_idx, Integer manager_idx, Integer charger_station_idx, Integer distribution_idx){
		ApiResult apiResult = new ApiResult();
		try {
			service.insert(company_idx, manager_idx, charger_station_idx, distribution_idx);
			apiResult.setCode(ApiResult.SUCCESS);
			apiResult.setMsg(ApiResult.SUCCESS_MSG);
		}catch(Exception e) {
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
	public ResponseEntity<ApiResult> update(@RequestBody  Check dto){
		ApiResult apiResult = new ApiResult();
		if(service.update(dto) == 10){
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

