package com.SCSystem.controller;

import com.SCSystem.dto.Manager;
import com.SCSystem.dto.Member;
import com.SCSystem.service.ApiService;
import com.SCSystem.service.AppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/app/api")
@Slf4j
@Controller
public class AppApiController {

    @Autowired
    AppService appService;

    @PostMapping("/login")
    public ResponseEntity<Manager> getMember(@RequestBody String id, @RequestBody String passwd){
        Manager loginManager = appService.getManager(id,passwd);

        if(loginManager.getIdx()>0) {
            //SUCCESS Login
            return new ResponseEntity<>(
                    loginManager,
                    HttpStatus.OK);
        }
        else if(loginManager.getIdx()==0){
            //NOT FOUND user ID
            return new ResponseEntity<>(
                    null,
                    HttpStatus.NOT_FOUND);
        }
        else if(loginManager.getIdx()==-1){
            //NOT MATCHED password
            return new ResponseEntity<>(
                    null,
                    HttpStatus.UNAUTHORIZED);
        }
        return null;
    }
}