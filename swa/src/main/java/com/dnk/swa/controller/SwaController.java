package com.dnk.swa.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dnk.swa.dto.PageDto;
import com.dnk.swa.dto.SwaLogDto;
import com.dnk.swa.dto.SwaLoginDto;
import com.dnk.swa.service.PagingService;
import com.dnk.swa.service.SwaService;

@Controller
public class SwaController {
	
	private static final Logger logger = LoggerFactory.getLogger(SwaController.class);
	
	@Autowired
	SwaService swaService;
	
	private final int pagingCnt = 10;
	private final int recordCnt = 10;
	
	@RequestMapping(value = "/stt")
	public String stt() {
		String address = "dnk/admin";
		return address;
	}
	
	@RequestMapping(value = "/searchlog")
	public String searchlog(Model model
							,HttpSession session, HttpServletRequest request
							,@RequestParam(value = "now_page", defaultValue = "0")String now_page) {
		
		String address = "dnk/logtable";
		PageDto pageDto = new PageDto();
		SwaLogDto sld = new SwaLogDto();
		String page = now_page;
		int totalCount = 0;
		int nowPage = 1;
		int pageCount = 0;
		
		if(page.equals("0")) {
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
		
		totalCount = swaService.getLogCount();
		
		logger.info("count : " + totalCount);
		
		pageCount = totalCount / recordCnt + 1;
		if(totalCount % recordCnt == 0) {
			pageCount = totalCount / recordCnt;
		}
		if(nowPage > pageCount) {
			nowPage = 1;
		}
		
		logger.info("count : " + totalCount);
		
		pageDto.setNowPage(nowPage);
		pageDto.setTotalCount(totalCount);
		
		PagingService pagingService = new PagingService(pageDto, recordCnt, pagingCnt, "pageEvent");
		sld.setStartRow(pagingService.getStartRow());
		sld.setEndRow(pagingService.getEndRow());
		
		List<SwaLogDto> list = swaService.getLogtable(sld);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("pageTag", pagingService.resultString());
		
		
		model.addAttribute("loglist", list);
		
		return address;
	}
	@RequestMapping(value = "/stt_login")
	public String stt_login(@RequestParam(value = "STT_ID", defaultValue = "-")String STT_ID
							,@RequestParam(value = "STT_PW", defaultValue = "-")String STT_PW
							,Model model
							,HttpServletRequest request
							,HttpSession session) {
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
			session.setAttribute("User_Name", who.getSTT_NAME());	
			session.setAttribute("level", who.getSTT_LEVEL());
			session.setAttribute("User_Id", who.getSTT_ID());
			model.addAttribute("check", who.getSTT_PW());
			model.addAttribute("userId", who.getSTT_ID() + "|" + ip);
			model.addAttribute("menuKey", who.getSTT_CENTER());
			address = "dnk/lmtool";
		} else {
			address = "redirect:/stt";
		}		
		
		return address;
	}
	
	@RequestMapping(value = "/insertUser")
	public String insertUser(Model model) {
		String address = "dnk/insertUser";
		return address;
	}
	
	@RequestMapping(value = "/addUser")
	public String addUser(Model model
							,@RequestParam(value = "STT_NAME", defaultValue = "NO")String STT_NAME
							,@RequestParam(value = "STT_ID", defaultValue = "user")String STT_ID
							,@RequestParam(value = "STT_CENTER", defaultValue = "-")String STT_CENTER) {
		String address = "redirect:/createUser";
		SwaLoginDto sld = new SwaLoginDto();
		sld.setSTT_NAME(STT_NAME);
		sld.setSTT_ID(STT_ID);
		sld.setSTT_CENTER(STT_CENTER);
		swaService.insertUser(sld);
		return address;
	}
	
	@RequestMapping(value = "/createUser")
	public String createUser(Model model) {
		String address = "dnk/createUser";
		SwaLoginDto sld = new SwaLoginDto();
		ArrayList<SwaLoginDto> list = new ArrayList<>();
		list = swaService.getUser();
		model.addAttribute("SwaUser", list);
		return address;
	}
	
	@RequestMapping(value = "/levelChange")
	public String levelChange(@RequestParam(value = "STT_SEQ", defaultValue = "")int STT_SEQ
							,@RequestParam(value = "code", defaultValue = "")String code) {
		String address = "redirect:/createUser";
		SwaLoginDto sld = new SwaLoginDto();
		sld.setSTT_SEQ(STT_SEQ);
		if(code.equals("add")) {
			sld.setSTT_LEVEL(0);
		} else {
			sld.setSTT_LEVEL(1);
		}
		swaService.levelChange(sld);
		return address;
	}
	
	@RequestMapping(value = "/deleteUser")
	public String deleteUser(@RequestParam(value = "STT_SEQ", defaultValue = "")int STT_SEQ) {
		String address = "redirect:/createUser";
		SwaLoginDto sld = new SwaLoginDto();
		sld.setSTT_SEQ(STT_SEQ);
		sld.setSTT_STATUS(40);
		swaService.deleteUser(sld);
		return address;
	}
	
	@RequestMapping(value = "/resetPw")
	public String resetPw(@RequestParam(value = "STT_SEQ", defaultValue = "")int STT_SEQ) {
		String address = "redirect:/createUser";
		SwaLoginDto sld = new SwaLoginDto();
		sld.setSTT_SEQ(STT_SEQ);
		sld.setSTT_PW("1234");
		swaService.resetPw(sld);
		return address;
	}
	
	
}