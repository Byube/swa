package com.dnk.swa.service;

import java.util.ArrayList;
import java.util.List;

import com.dnk.swa.dto.SwaLogDto;
import com.dnk.swa.dto.SwaLoginDto;
import com.dnk.swa.dto.SwaMemDto;
import com.dnk.swa.dto.SwaMstDto;

public interface SwaService {
	
	public void insertLog(SwaLogDto log);
	public SwaLoginDto getMember(SwaLoginDto sld);
	public boolean checkLogin(SwaLoginDto sld);
	public List<SwaLogDto> getLogtable(SwaLogDto sld);
	public int getLogCount(SwaLogDto sld);
	public String getUserId(SwaLoginDto sld);
	public ArrayList<SwaLoginDto> getUser(SwaLoginDto sld);
	
	public void insertUser(SwaLoginDto sld);
	
	public void levelChange(SwaLoginDto sld);
	public void deleteUser(SwaLoginDto sld);
	public void resetPw(SwaLoginDto sld);
	public boolean checkIdok(SwaLoginDto sld);
	public String getMin();
	public List<SwaLogDto> getMenu();
	public int getMstCount(SwaMstDto smd);
	public String getMstMin();
	public List<SwaMstDto> getMstList(SwaMstDto smd);
	public String getMstC(SwaMstDto smd);
	public void insertSwaMem(SwaMemDto smd);
	public boolean checksIdok(SwaMemDto smd);
	public int getSwaMemCount(SwaMemDto smd);
	public List<SwaMemDto> getSwaMemList(SwaMemDto smd);
	public String getSwaMemName(SwaMemDto smd);
	public void updateSwaMem(SwaMemDto smd);
	public void deleteSwaMem(SwaMemDto smd);

}
