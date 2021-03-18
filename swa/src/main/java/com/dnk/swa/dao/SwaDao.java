package com.dnk.swa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dnk.swa.dto.SwaLoginDto;

@Mapper
public interface SwaDao {
	
	public List<SwaLoginDto> getMember();
	
	public String checkLogin(SwaLoginDto sld);

}
