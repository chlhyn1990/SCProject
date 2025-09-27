package com.SCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.SCSystem.dto.Check;
import com.SCSystem.dto.CheckMst;

import com.SCSystem.mapper.CheckMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CheckService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	CheckMapper mapper;

	public List<CheckMst> getSearchList(String search) {
		return mapper.getSearchList(search);
	}
	
	public Check get(int idx) {
		Check check = new Check();
		check.setCheckMst(mapper.getCheckMst(idx));
		check.setCompatibility(mapper.getCompatibility(check.getCheckMst()));
		check.setEnvironment(mapper.getEnvironment(check.getCheckMst()));
		check.setConvenience(mapper.getConvenience(check.getCheckMst()));
		check.setProductSafety(mapper.getProductSafety(check.getCheckMst()));
		check.setElectricalStability(mapper.getElectricalStability(check.getCheckMst()));
		check.setFireSafety(mapper.getFireSafety(check.getCheckMst()));
		check.setMaintenance(mapper.getMaintenance(check.getCheckMst()));
		check.setChargingOperation(mapper.getChargingOperation(check.getCheckMst()));
		check.setOpinion(mapper.getOpinion(check.getCheckMst()));
		return check;
	}
	
	@Transactional
	public int insert(Integer company_idx, Integer manager_idx, Integer charger_station_idx, Integer distribution_idx) {
		try {
			return mapper.insertCheck(company_idx, manager_idx, charger_station_idx, distribution_idx);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
	
	@Transactional
	public int update(Check check) {
		try {
			int result = 0;
			result += mapper.updateCheckMst(check.getCheckMst());
			result += mapper.updateCompatibility(check.getCompatibility());
			result += mapper.updateEnvironment(check.getEnvironment());
			result += mapper.updateConvenience(check.getConvenience());
			result += mapper.updateProductSafety(check.getProductSafety());
			result += mapper.updateElectricalStability(check.getElectricalStability());
			result += mapper.updateFireSafety(check.getFireSafety());
			result += mapper.updateMaintenance(check.getMaintenance());
			result += mapper.updateChargingOperation(check.getChargingOperation());
			result += mapper.updateOpinion(check.getOpinion());			
			return result;
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
	

}

