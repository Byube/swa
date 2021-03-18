package com.dnk.swa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnk.swa.dao.SwaDao;
import com.dnk.swa.dto.SwaLoginDto;

@Service
public class SwaServiceImpl implements SwaService{
	
	@Autowired
	SwaDao dao;

	@Override
	public List<SwaLoginDto> getMember() {
		return dao.getMember();
	}

	@Override
	public boolean checkLogin(SwaLoginDto sld) {
		boolean check = false;
		if(sld.getSTT_PW().equals(dao.checkLogin(sld))){
			check = true;
		}
		return check;
	}
	
	

}
