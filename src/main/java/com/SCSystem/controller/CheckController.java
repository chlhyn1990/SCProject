package com.SCSystem.controller;


import java.io.IOException;
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
import com.SCSystem.dto.Distribution;
import com.SCSystem.service.CheckService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/check")
@Slf4j
@RestController
public class CheckController {

	@Autowired
	CheckService service;
	
	@PostMapping("/checkMst/{charger_station_idx}")
	@ResponseBody
	public ResponseEntity<List<CheckMst>> getCheckMstByStation(@PathVariable int charger_station_idx){
		List<CheckMst> dto = service.getCheckMstByStation(charger_station_idx);
        return new ResponseEntity<>(
        		dto,
                HttpStatus.OK
        		);
	}
	
	@PostMapping("/distribution/{idx}")
	@ResponseBody
	public ResponseEntity<Distribution> getDistributionByCheckMst(@PathVariable int idx){
		Distribution dto = service.getDistributionByCheckMst(idx);
        return new ResponseEntity<>(
        		dto,
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
	
	@PostMapping("/excel/{charger_station_idx}")
	 public ResponseEntity<byte[]> generateReport(@PathVariable int charger_station_idx) {
	     byte[] excelData;
		try {
			excelData = service.createInspectionForm(charger_station_idx);
			return ResponseEntity.ok()
		             .header("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
		             .header("Content-Disposition", "attachment; filename=\"report.xlsx\"")
		             .body(excelData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	 }
	
	
}

