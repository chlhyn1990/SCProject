package com.SCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.SCSystem.dto.ChargerStation;
import com.SCSystem.dto.Distribution;
import com.SCSystem.mapper.ChargerStationMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChargerStationService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ChargerStationMapper mapper;
	@Autowired
	DistributionService distributionService;

	public List<ChargerStation> getList(String search) {
		return mapper.getSearchList(search);
	}
	
	public ChargerStation get(int idx) {
		return mapper.get(idx);
	}
	
	public int insert(ChargerStation dto) {
		try {
			int chargerStationIdx = mapper.insert(dto);
			return chargerStationIdx;
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
	
	public int update(ChargerStation dto) {
		try {
			return mapper.update(dto);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
	
	public int delete(int idx) {
		try {
			List<Distribution> list = distributionService.getListByStation(idx);
			for(Distribution distribution : list) {
				distributionService.delete(distribution.getIdx());
			}
			return mapper.delete(idx);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
}

