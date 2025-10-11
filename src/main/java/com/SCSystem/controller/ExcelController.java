package com.SCSystem.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SCSystem.service.ExcelService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/excel")
@Slf4j
@RestController
public class ExcelController {
	
	@Autowired
	ExcelService service;
 
	@PostMapping("/{check_mst_idx}")
	 public ResponseEntity<byte[]> generateReport(@PathVariable int check_mst_idx) {
	     byte[] excelData;
		try {
			excelData = service.createInspectionForm(check_mst_idx);
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
