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
import com.SCSystem.dto.ChargerCheck;
import com.SCSystem.service.ChargerCheckService;
import com.SCSystem.service.DistributionService;
import com.SCSystem.service.ChargerService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/chargerCheck")
@Slf4j
@RestController
public class ChargerCheckController {

	@Autowired
	ChargerCheckService service;
	@Autowired
	DistributionService distributionService;
	@Autowired
	ChargerService chargerService;
	
	
	@PostMapping({"/list", "/list/{search}"})
	@ResponseBody
	public ResponseEntity<List<ChargerCheck>> getList(@PathVariable(required = false) String search){
		List<ChargerCheck> dtos = service.getList(search);
        return new ResponseEntity<>(
        		dtos,
                HttpStatus.OK
        		);
	}
	
	@PostMapping("/{idx}")
	@ResponseBody
	public ResponseEntity<ChargerCheck> get(@PathVariable int idx){
		ChargerCheck dto = service.get(idx);
        return new ResponseEntity<>(
        		dto,
                HttpStatus.OK
        		);
	}
	
	@PostMapping("/delete/{idx}")
	@ResponseBody
	public ResponseEntity<ApiResult> delete(@PathVariable  int idx){
		ApiResult apiResult = new ApiResult();
		chargerService.deleteFromStation(idx);
		distributionService.deleteFromStation(idx);
		if(service.delete(idx) == 1){
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
	public ResponseEntity<Integer> insert(@RequestBody  ChargerCheck dto){
		ApiResult apiResult = new ApiResult();
		int insertIdx = service.insert(dto);
		if(insertIdx > 0){
			apiResult.setCode(ApiResult.SUCCESS);
			apiResult.setMsg(ApiResult.SUCCESS_MSG);
		}else {
			apiResult.setCode(ApiResult.COMMON_INSERT_FAIL);
			apiResult.setMsg(ApiResult.COMMON_INSERT_FAIL_MSG);
		}

		return new ResponseEntity<>(
				insertIdx,
                HttpStatus.OK
				);
	}
	
	@PostMapping("/update")
	@ResponseBody
	public ResponseEntity<ApiResult> update(@RequestBody  ChargerCheck dto){
		ApiResult apiResult = new ApiResult();
		if(service.update(dto) == 1){
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

