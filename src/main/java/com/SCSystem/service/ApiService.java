package com.SCSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.SCSystem.dto.Manager;
import com.SCSystem.mapper.ApiMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ApiService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ApiMapper apiMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public Manager getManager(Manager manager) {
		Manager loginManager = apiMapper.getManager(manager);
		if(loginManager != null && !passwordEncoder.matches(manager.getPassword(), loginManager.getPassword())) {
			loginManager = null;
		}
		return loginManager;	 
	}
	
	public int insertManager(Manager manager) {
		manager.setPassword(passwordEncoder.encode(manager.getPassword()));
		try {
			return apiMapper.insertManager(manager);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
}

