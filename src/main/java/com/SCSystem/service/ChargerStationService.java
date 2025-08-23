package com.SCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.SCSystem.dto.ChargerStation;
import com.SCSystem.mapper.ChargerStationMapper;
import com.SCSystem.mapper.CheckListMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChargerStationService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ChargerStationMapper mapper;
	CheckListMapper checkListMapper;

	public List<ChargerStation> getList(String search) {
		return mapper.getSearchList(search);
	}
	
	public ChargerStation get(int idx) {
		return mapper.get(idx);
	}
	
	public int insert(ChargerStation dto) {
		try {
			return mapper.insert(dto);
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
			return mapper.delete(idx);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
}

