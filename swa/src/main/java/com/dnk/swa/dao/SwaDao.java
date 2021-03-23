package com.dnk.swa.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dnk.swa.dto.SwaLogDto;
import com.dnk.swa.dto.SwaLoginDto;

@Mapper
public interface SwaDao {
	
	public SwaLoginDto getMember(SwaLoginDto sld);
	public String checkLogin(SwaLoginDto sld);
	public List<SwaLogDto> getLogtable(SwaLogDto sld);
	public int getLogCount();
	public ArrayList<SwaLoginDto> getUser();
	
	public void insertUser(SwaLoginDto sld);
	public void levelChange(SwaLoginDto sld);
	public void deleteUser(SwaLoginDto sld);
	public void resetPw(SwaLoginDto sld);
}
