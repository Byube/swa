package com.dnk.swa.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnk.swa.dao.SwaDao;
import com.dnk.swa.dto.SwaLogDto;
import com.dnk.swa.dto.SwaLoginDto;
import com.dnk.swa.dto.SwaMemDto;
import com.dnk.swa.dto.SwaMstDto;

@Service
public class SwaServiceImpl implements SwaService{
	
	@Autowired
	SwaDao dao;
	
	

	@Override
	public void insertLog(SwaLogDto log) {
		dao.insertLog(log);
	}

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
	public int getLogCount(SwaLogDto sld) {
		return dao.getLogCount(sld);
	}

	
	@Override
	public String getUserId(SwaLoginDto sld) {
		return dao.getUserId(sld);
	}

	@Override
	public ArrayList<SwaLoginDto> getUser(SwaLoginDto sld) {
		return dao.getUser(sld);
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

	@Override
	public boolean checkIdok(SwaLoginDto sld) {
		boolean check = false;
		int checkid = dao.checkIdok(sld);
		if(checkid == 0) {
			check = true;
		}
		return check;
	}

	@Override
	public String getMin() {
		return dao.getMin();
	}

	@Override
	public List<SwaLogDto> getMenu() {
		return dao.getMenu();
	}

	@Override
	public int getMstCount(SwaMstDto smd) {
		return dao.getMstCount(smd);
	}
	

	@Override
	public String getMstMin() {
		return dao.getMstMin();
	}

	@Override
	public List<SwaMstDto> getMstList(SwaMstDto smd) {
		
		List<SwaMstDto> plist = dao.getMstList(smd);
		
		return plist;
	}

	@Override
	public String getMstC(SwaMstDto smd) {
		return dao.getMstC(smd);
	}

	@Override
	public void insertSwaMem(SwaMemDto smd) {
		dao.insertSwaMem(smd);
	}

	@Override
	public boolean checksIdok(SwaMemDto smd) {
		boolean check = false;
		int checkid = dao.checksIdok(smd);
		if(checkid == 0) {
			check = true;
		}
		return check;
	}

	@Override
	public int getSwaMemCount(SwaMemDto smd) {
		return dao.getSwaMemCount(smd);
	}

	@Override
	public List<SwaMemDto> getSwaMemList(SwaMemDto smd) {
		return dao.getSwaMemList(smd);
	}

	@Override
	public String getSwaMemName(SwaMemDto smd) {
		return dao.getSwaMemName(smd);
	}

	@Override
	public void updateSwaMem(SwaMemDto smd) {
		dao.updateSwaMem(smd);
	}

	@Override
	public void deleteSwaMem(SwaMemDto smd) {
		dao.deleteSwaMem(smd);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
