package com.SCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.SCSystem.dto.Distribution;
import com.SCSystem.mapper.DistributionMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DistributionService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	DistributionMapper mapper;

	public List<Distribution> getList(int charger_station_idx) {
		return mapper.getList(charger_station_idx);
	}
	
	public Distribution get(int idx) {
		return mapper.get(idx);
	}
	
	public int insert(Distribution dto) {
		try {
			return mapper.insert(dto);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
	
	public int update(Distribution dto) {
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
}

