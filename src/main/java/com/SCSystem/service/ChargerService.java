package com.SCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.SCSystem.dto.Charger;
import com.SCSystem.mapper.ChargerMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChargerService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ChargerMapper mapper;

	public List<Charger> getList(String search) {
		return mapper.getSearchList(search);
	}
	
	public Charger get(int idx) {
		return mapper.get(idx);
	}
	
	public int insert(Charger dto) {
		try {
			return mapper.insert(dto);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
	
	public int update(Charger dto) {
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

