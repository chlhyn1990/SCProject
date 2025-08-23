package com.SCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.SCSystem.dto.CheckList;
import com.SCSystem.dto.Search;
import com.SCSystem.mapper.CheckListMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CheckListService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	CheckListMapper mapper;

	public List<CheckList> getList(Search search) {
		return mapper.getSearchList(search);
	}
	
	public CheckList get(int idx) {
		return mapper.get(idx);
	}
	
	public int insert(CheckList dto) {
		try {
			return mapper.insert(dto);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
	
	public int update(CheckList dto) {
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

