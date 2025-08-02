package com.SCSystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.SCSystem.dto.Manager;
import com.SCSystem.dto.Company;

@Mapper
public interface CompanyMapper {

	Manager getManager(Manager manager);
	
	int insertManager(Manager manager);

}

