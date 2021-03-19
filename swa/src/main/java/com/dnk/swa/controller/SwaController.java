package com.dnk.swa.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dnk.swa.dto.SwaLogDto;
import com.dnk.swa.dto.SwaLoginDto;
import com.dnk.swa.service.SwaService;

@Controller
public class SwaController {
	
	private static final Logger logger = LoggerFactory.getLogger(SwaController.class);
	
	@Autowired
	SwaService swaService;
	
	@RequestMapping(value = "/stt")
	public String stt() {
		String address = "dnk/admin";
		return address;
	}
	
	@RequestMapping(value = "/searchlog")
	public String searchlog(Model model) {
		String address = "dnk/logtable";
		
		SwaLogDto sld = new SwaLogDto();
		List<SwaLogDto> list = swaService.getLogtable(sld);
		
		model.addAttribute("loglist", list);
		
		return address;
	}
	@RequestMapping(value = "/stt_login")
	public String stt_login(@RequestParam(value = "STT_ID", defaultValue = "-")String STT_ID
							,@RequestParam(value = "STT_PW", defaultValue = "-")String STT_PW
							,Model model
							,HttpServletRequest request) {
		String address = "";
		String ip = request.getHeader("X-FORWARDED-FOR");
		if (ip == null)
			ip = request.getRemoteAddr();
		logger.info("ip : " + ip);
		//logger.info("STT_ID : " + STT_ID);
		//logger.info("STT_PW : " + STT_PW);
		
		SwaLoginDto sld = new SwaLoginDto();
		sld.setSTT_ID(STT_ID);
		sld.setSTT_PW(STT_PW);
		
		if(swaService.checkLogin(sld)) {
			SwaLoginDto who = swaService.getMember(sld);
			model.addAttribute("userId", who.getSTT_ID() + "|" + ip);
			model.addAttribute("menuKey", who.getSTT_CENTER());
			address = "dnk/lmtool";
		} else {
			address = "redirect:/stt";
		}
			
//		if(STT_ID.equals("admin")) {
//			if(swaService.checkLogin(sld)) {
//				address = "dnk/grant";
//			} else {
//				address = "redirect:/stt";
//			}
//		} else {
//			if(swaService.checkLogin(sld)) {
//				address = "dnk/logtable";
//			} else {
//				address = "redirect:/stt";
//			}
//		}
		
		
		return address;
	}
	
	
}
