package com.dnk.swa.service;

import java.util.List;

import com.dnk.swa.dto.SwaLogDto;
import com.dnk.swa.dto.SwaLoginDto;

public interface SwaService {
	
	public SwaLoginDto getMember(SwaLoginDto sld);
	public boolean checkLogin(SwaLoginDto sld);
	public List<SwaLogDto> getLogtable(SwaLogDto sld);

}
