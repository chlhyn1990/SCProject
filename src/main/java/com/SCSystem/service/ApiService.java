package com.SCSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.SCSystem.dto.Member;
import com.SCSystem.mapper.ApiMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ApiService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ApiMapper apiMapper;
	
	public Member getMember(Member member) {
		return apiMapper.getMember(member);
	}
	
	
}

