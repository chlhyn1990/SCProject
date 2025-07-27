package com.SCSystem.service;

import com.SCSystem.dto.Manager;
import com.SCSystem.mapper.AppMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Slf4j
@Service
public class AppService {
    @Autowired
    AppMapper appMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Manager getManager(String id, String passwd) {
        Manager loginManager = appMapper.getManager(id);

        if (null == loginManager) {
            loginManager = new Manager();
            loginManager.setIdx(0);
            return loginManager;
        }

        else if (passwordEncoder.matches(passwd, loginManager.getPassword())){
            return loginManager;
        }
        else {
            loginManager = new Manager();
            loginManager.setIdx(-1);
            return loginManager;
        }
    }

}