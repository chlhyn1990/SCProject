package com.SCSystem.service;

import com.SCSystem.mapper.AppCheckMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AppCheckService {
    @Autowired
    AppCheckMapper appCheckMapper;

    public Integer insertElectricalStability(Integer distributionIdx, String insertType, String data){
        Integer checkMstIdx = appCheckMapper.getCheckMstIdxByDistributionIdx(distributionIdx);
        Integer result;
        switch (insertType){
            case "thickness":
                result = appCheckMapper.updateElectricalStabilityThickness(checkMstIdx, distributionIdx, data);
                break;
            case "wire_thickness":
                result = appCheckMapper.updateElectricalStabilityWireThickness(checkMstIdx, distributionIdx, data);
                break;
            case "distribution":
                result = appCheckMapper.updateElectricalStabilityDistribution(checkMstIdx, distributionIdx, data);
                break;
            case "cable":
                result = appCheckMapper.updateElectricalStabilityCable(checkMstIdx, distributionIdx, data);
                break;
            case "sensitivity":
                result = appCheckMapper.updateElectricalStabilitySensitivity(checkMstIdx, distributionIdx, data);
                break;
            case "leakageA":
                result =appCheckMapper.updateElectricalStabilityLeakA(checkMstIdx, distributionIdx,data);
                break;
            default:
                result=-1;
        }
        return result;
    }



}
