package com.SCSystem.service;

import com.SCSystem.mapper.AppCheckMapper;
import com.SCSystem.mapper.CheckMapper;
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
                result = appCheckMapper.insertElectricalStabilityThickness(checkMstIdx, distributionIdx, data);
                break;
            case "wire_thickness":
                result = appCheckMapper.insertElectricalStabilityWireThickness(checkMstIdx, distributionIdx, data);
                break;
            case "distribution":
                result = appCheckMapper.insertElectricalStabilityDistribution(checkMstIdx, distributionIdx, data);
                break;
            case "cable":
                result = appCheckMapper.insertElectricalStabilityCable(checkMstIdx, distributionIdx, data);
                break;
            case "sensitivity":
                result = appCheckMapper.insertElectricalStabilitySensitivity(checkMstIdx, distributionIdx, data);
                break;
            case "leakageA":
                result =appCheckMapper.insertElectricalStabilityLeakA(checkMstIdx, distributionIdx,data);
                break;
            default:
                result=-1;
        }
        return result;
    }


    public Integer insertElectricalStabilityThickness(Integer checkMstIdx, Integer distributionIdx, String thickness){
        return appCheckMapper.insertElectricalStabilityThickness(checkMstIdx, distributionIdx, thickness);
    }
    public Integer insertElectricalStabilityWireThickness(Integer checkMstIdx, Integer distributionIdx, String wireThickness){
        return appCheckMapper.insertElectricalStabilityWireThickness(checkMstIdx, distributionIdx, wireThickness);
    }
    public Integer insertElectricalStabilityDistribution(Integer checkMstIdx, Integer distributionIdx, String distribution){
        return appCheckMapper.insertElectricalStabilityDistribution(checkMstIdx, distributionIdx, distribution);
    }
    public Integer insertElectricalStabilityCable(Integer checkMstIdx, Integer distributionIdx, String cable){
        return appCheckMapper.insertElectricalStabilityCable(checkMstIdx, distributionIdx, cable);
    }
    public Integer insertElectricalStabilitySensitivity(Integer checkMstIdx, Integer distributionIdx, String sensitivity){
        return appCheckMapper.insertElectricalStabilitySensitivity(checkMstIdx, distributionIdx, sensitivity);
    }
}
