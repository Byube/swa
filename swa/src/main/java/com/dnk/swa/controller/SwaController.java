package com.dnk.swa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dnk.swa.service.SwaService;

@Controller
public class SwaController {
	
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
	
}
