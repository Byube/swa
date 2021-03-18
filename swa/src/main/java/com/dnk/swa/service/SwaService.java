package com.dnk.swa.service;

import java.util.List;

import com.dnk.swa.dto.SwaLoginDto;

public interface SwaService {
	
	public List<SwaLoginDto> getMember();
	
	public boolean checkLogin(SwaLoginDto sld);

}
