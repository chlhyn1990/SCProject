package com.SCSystem.controller;

import com.SCSystem.dto.Charger;
import com.SCSystem.service.AppCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RequestMapping("/app/api/check")
@Slf4j
@RestController
public class AppCheckController {
    @Autowired
    AppCheckService appCheckService;

    @PostMapping("/distribution")
    public ResponseEntity<String> insertElectricalStability(@RequestBody HashMap<String, String> data){

        log.error("insertElectricalStability data : "+data.toString());
        long longDistributionIdx = Long.valueOf(data.get("distributionIdx"));
        int distributionIdx = (int)longDistributionIdx;

        Integer result = appCheckService.insertElectricalStability(distributionIdx, data.get("insertType"), data.get("data"));

        if(result<0) {
            log.error("[insertElectricalStability]ERROR INSERT!");
            return new ResponseEntity<>(
                    "chargers",
                    HttpStatus.NOT_FOUND);
        }
        else{
            log.info("[insertElectricalStability]SUCCESS INSERT!");
            return new ResponseEntity<>(
                    "chargers",
                    HttpStatus.OK);
        }
    }
}
