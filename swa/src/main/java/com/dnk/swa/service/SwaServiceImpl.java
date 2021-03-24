package com.dnk.swa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnk.swa.dao.SwaDao;
import com.dnk.swa.dto.SwaLogDto;
import com.dnk.swa.dto.SwaLoginDto;

@Service
public class SwaServiceImpl implements SwaService{
	
	@Autowired
	SwaDao dao;

	@Override
	public SwaLoginDto getMember(SwaLoginDto sld) {
		return dao.getMember(sld);
	}

	@Override
	public boolean checkLogin(SwaLoginDto sld) {
		boolean check = false;
		if(sld.getSTT_PW().equals(dao.checkLogin(sld))){
			check = true;
		}
		return check;
	}

	@Override
	public List<SwaLogDto> getLogtable(SwaLogDto sld) {
		return dao.getLogtable(sld);
	}

	@Override
	public int getLogCount() {
		return dao.getLogCount();
	}

	@Override
	public ArrayList<SwaLoginDto> getUser() {
		return dao.getUser();
	}

	@Override
	public void insertUser(SwaLoginDto sld) {
		dao.insertUser(sld);
	}
	

	@Override
	public void levelChange(SwaLoginDto sld) {
		dao.levelChange(sld);
	}

	@Override
	public void deleteUser(SwaLoginDto sld) {
		dao.deleteUser(sld);
	}

	@Override
	public void resetPw(SwaLoginDto sld) {
		dao.resetPw(sld);
	}

	
	
	
	
	
	
	
	

}
