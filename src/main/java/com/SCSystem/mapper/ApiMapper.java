package com.SCSystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.SCSystem.dto.Member;

@Mapper
public interface ApiMapper {

	Member getMember(Member member);

}

