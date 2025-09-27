package com.SCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.SCSystem.dto.Charger;
import com.SCSystem.mapper.CheckMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CheckService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	CheckMapper mapper;
	
	public List<Charger> getList(int distribution_idx) {
		return mapper.getList(distribution_idx);
	}

	public List<Charger> getSearchList(String search) {
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
	public int deleteFromStation(int charger_station_idx) {
		try {
			return mapper.deleteFromStation(charger_station_idx);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
	public int deleteFromDistribution(int distribution_idx) {
		try {
			return mapper.deleteFromDistribution(distribution_idx);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
}

