package com.dnk.swa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dnk.swa.dto.SwaLogDto;
import com.dnk.swa.dto.SwaLoginDto;

@Mapper
public interface SwaDao {
	
	public SwaLoginDto getMember(SwaLoginDto sld);
	public String checkLogin(SwaLoginDto sld);
	public List<SwaLogDto> getLogtable(SwaLogDto sld);

}
