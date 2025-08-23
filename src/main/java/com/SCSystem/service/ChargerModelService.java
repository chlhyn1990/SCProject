package com.SCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.SCSystem.dto.ChargerModel;
import com.SCSystem.mapper.ChargerModelMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChargerModelService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ChargerModelMapper mapper;

	public List<ChargerModel> getList(String search) {
		return mapper.getSearchList(search);
	}
	
	public ChargerModel get(int idx) {
		return mapper.get(idx);
	}
	
	public int insert(ChargerModel dto) {
		try {
			return mapper.insert(dto);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
	
	public int update(ChargerModel dto) {
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

