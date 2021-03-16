package com.dnk.swa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String searchlog() {
		String address = "dnk/logtable";
		return address;
	}
	@RequestMapping(value = "/stt_login")
	public String stt_login(@RequestParam(value = "STT_ID", defaultValue = "-")String STT_ID
							,@RequestParam(value = "STT_PW", defaultValue = "-")String STT_PW) {
		String address = "";
		logger.info("STT_ID : " + STT_ID);
		logger.info("STT_PW : " + STT_PW);
		if(STT_ID.equals("admin")) {
			address = "dnk/logtable";
		} else if(STT_ID.equals("jeff")) {
			address = "dnk/grant";
		} else {
			address = "redirect:/stt";
		}
		
		return address;
	}
	
}
