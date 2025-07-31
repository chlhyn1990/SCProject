package com.SCSystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SCSystem.dto.Manager;
import com.SCSystem.service.ApiService;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/manager")
@Slf4j
@RestController
public class ApiController {

	@Autowired
	ApiService apiService;
	
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<Manager> getMember(@RequestBody  Manager manager){
		Manager loginManager = apiService.getManager(manager);
        return new ResponseEntity<>(
        		loginManager,
                HttpStatus.OK
        );
	}

	
	
}

