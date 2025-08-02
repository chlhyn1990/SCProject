package com.SCSystem.controller;

import com.SCSystem.dto.Manager;
import com.SCSystem.service.AppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/app/api")
@Slf4j
@RestController
public class AppApiController {

    @Autowired
    AppService appService;

    @PostMapping("/login")
    public ResponseEntity<Manager> getMember(@RequestBody Manager manager){

        String id=manager.getId();
        String password=manager.getPassword();

        log.info("id:{}, passwd:{}", id, password);
        Manager loginManager = appService.getManager(id,password);

        if(loginManager.getIdx()>0) {
            //SUCCESS Login
            log.info("id:{}, name:{}", id, loginManager.getName());
             return new ResponseEntity<>(
                    loginManager,
                    HttpStatus.OK);
        }
        else if(loginManager.getIdx()==0){
            //NOT FOUND user ID
            log.info("NOT Found User id:{}",id);
            return new ResponseEntity<>(
                    loginManager,
                    HttpStatus.NOT_FOUND);
        }
        else if(loginManager.getIdx()==-1){
            log.info("NOT Matched Password id:{}",id);
            //NOT MATCHED password
            return new ResponseEntity<>(
                    loginManager,
                    HttpStatus.UNAUTHORIZED);
        }
        return null;
    }
}