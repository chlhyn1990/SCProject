package com.SCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.SCSystem.dto.ChargerCheck;
import com.SCSystem.mapper.ChargerCheckMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChargerCheckService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ChargerCheckMapper mapper;

	public List<ChargerCheck> getList(String search) {
		return mapper.getSearchList(search);
	}
	
	public ChargerCheck get(int idx) {
		return mapper.get(idx);
	}
	
	public int insert(ChargerCheck dto) {
		try {
			mapper.insertCheckList(dto.getManager_idx(), dto.getManager_idx());
			mapper.insert(dto);
			return dto.getIdx();
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
	
	public int update(ChargerCheck dto) {
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

