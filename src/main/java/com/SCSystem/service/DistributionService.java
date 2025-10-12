package com.SCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.SCSystem.dto.Charger;
import com.SCSystem.dto.ChargerFile;
import com.SCSystem.dto.Distribution;
import com.SCSystem.dto.DistributionFile;
import com.SCSystem.mapper.DistributionMapper;
import com.SCSystem.mapper.ChargerMapper;
import com.SCSystem.mapper.CheckMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DistributionService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	DistributionMapper mapper;
	@Autowired
	ChargerService chargerService;
	@Autowired
	CheckMapper checkMapper;
	
	public List<Distribution> getList() {
		List<Distribution> distributionList = mapper.getList();
		return distributionList;
	}

	public List<Distribution> getListByStation(int charger_station_idx) {
		List<Distribution> distributionList = mapper.getListByStation(charger_station_idx);
		for(int i = 0; i < distributionList.size(); i++) {
			distributionList.get(i).setChargerList(chargerService.getListByDistribution(distributionList.get(i).getIdx()));
		}
		return distributionList;
	}
	
	public Distribution get(int idx) {
		return mapper.get(idx);
	}
	
	@Transactional
	public int insert(Distribution dto) {
		try {
			mapper.insert(dto);
			int distributionIdx = dto.getIdx();
			checkMapper.insertCheck(dto.getCompany_idx(), dto.getManager_idx(), dto.getCharger_station_idx(), dto.getIdx());
			int checkMstIdx = checkMapper.getCheckMstIdxByDistribution(distributionIdx);
			DistributionFile distributionFile = new DistributionFile();
			distributionFile.setDistribution_idx(distributionIdx);
			distributionFile.setCheck_mst_idx(checkMstIdx);
			checkMapper.insertDistributionFile(distributionFile);
			return distributionIdx;
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
	
	public int update(Distribution dto) {
		try {
			return mapper.update(dto);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
	
	@Transactional
	public int delete(int idx) {
		try {
			List<Charger> list = chargerService.getListByDistribution(idx);
			for(Charger charger : list) {
				chargerService.delete(charger.getIdx());
			}
			checkMapper.deleteDistributionFile(idx);
			int checkMstIdx = checkMapper.getCheckMstIdxByDistribution(idx);
			checkMapper.deleteCheck(checkMstIdx);
			return mapper.delete(idx);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
}

