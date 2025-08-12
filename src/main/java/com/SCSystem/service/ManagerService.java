package com.SCSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.SCSystem.dto.Manager;
import com.SCSystem.mapper.ManagerMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ManagerService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ManagerMapper managerMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public Manager getManager(Manager manager) {
		Manager loginManager = managerMapper.getManager(manager);
		if(loginManager != null && !passwordEncoder.matches(manager.getPassword(), loginManager.getPassword())) {
			loginManager = null;
		}
		return loginManager;	 
	}
	
	public int insertManager(Manager manager) {
		manager.setPassword(passwordEncoder.encode(manager.getPassword()));
		try {
			return managerMapper.insertManager(manager);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
}

