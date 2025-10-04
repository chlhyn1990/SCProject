package com.SCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.SCSystem.dto.Company;
import com.SCSystem.dto.Manager;
import com.SCSystem.mapper.ManagerMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ManagerService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ManagerMapper mapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public Manager login(Manager manager) {
		Manager loginManager = mapper.login(manager);
		if(loginManager != null && !passwordEncoder.matches(manager.getPassword(), loginManager.getPassword())) {
			loginManager = null;
		}
		return loginManager;	 
	}
	
	public List<Manager> getList(String search) {
		return mapper.getSearchList(search);
	}
	
	public Manager get(int idx) {
		return mapper.get(idx);
	}

	public int insert(Manager dto) {
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		try {
			return mapper.insert(dto);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
	public int update(Manager dto) {
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		try {
			return mapper.update(dto);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}

	public int delete(int idx) {
		try {
			return mapper.delete(idx);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
}

