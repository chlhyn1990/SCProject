package com.SCSystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SCSystem.dto.Member;
import com.SCSystem.service.ApiService;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/member")
@Slf4j
@Controller
public class ApiController {

	@Autowired
	ApiService apiService;
	
	
	@PostMapping("/login")
	public ResponseEntity<Member> getMember(@RequestBody  Member member){
		Member loginMember = apiService.getMember(member);
        return new ResponseEntity<>(
        		loginMember,
                HttpStatus.OK
        );
	}

	
	
}

