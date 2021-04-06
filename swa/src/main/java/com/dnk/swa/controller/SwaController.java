package com.dnk.swa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dnk.swa.dto.PageDto;
import com.dnk.swa.dto.SwaLogDto;
import com.dnk.swa.dto.SwaLoginDto;
import com.dnk.swa.dto.SwaMstDto;
import com.dnk.swa.service.PagingService;
import com.dnk.swa.service.SwaService;


@Controller
public class SwaController {
	
	private static final Logger logger = LoggerFactory.getLogger(SwaController.class);
	
	private String ip = "";
	SwaLogDto log = new SwaLogDto();
	
	
	
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
							,@RequestParam(value = "now_page", defaultValue = "0")String now_page
							,@RequestParam(value = "dateSort", defaultValue = "")String dateSort
							,@RequestParam(value = "startDate", defaultValue = "")String startDate
							,@RequestParam(value = "endDate", defaultValue = "")String endDate
							,@RequestParam(value = "STT_ID", defaultValue = "")String STT_ID
							,@RequestParam(value = "STT_MENU", defaultValue = "")String STT_MENU) {
		//logger.info(">>>>>>>>>>>>>>>>" + STT_ID + " : " + STT_MENU);
		String address = "dnk/logtable";
		PageDto pageDto = new PageDto();
		SwaLogDto sld = new SwaLogDto();
		SwaLoginDto slg = new SwaLoginDto();
		slg.setSTT_ID("hello");
		String page = now_page;
		String dateMin = "";
		int totalCount = 0;
		int nowPage = 1;
		int pageCount = 0;
		
		if(page.equals("0")) {
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
		
		sld.setDateSort(dateSort);
		sld.setStartDate(startDate);
		sld.setEndDate(endDate);

		sld.setSTT_USER(STT_ID);
		sld.setSTT_MENU(STT_MENU);
		
		totalCount = swaService.getLogCount(sld);
		pageCount = totalCount / recordCnt + 1;
		if(totalCount % recordCnt == 0) {
			pageCount = totalCount / recordCnt;
		}
		if(nowPage > pageCount) {
			nowPage = 1;
		}
		pageDto.setNowPage(nowPage);
		pageDto.setTotalCount(totalCount);
		
		PagingService pagingService = new PagingService(pageDto, recordCnt, pagingCnt, "pageEvent");
		sld.setStartRow(pagingService.getStartRow());
		sld.setEndRow(pagingService.getEndRow());
		
		List<SwaLogDto> plist = swaService.getLogtable(sld);
		ArrayList<SwaLoginDto> mlist = swaService.getUser(slg);
		List<SwaLogDto> menu = swaService.getMenu();
		model.addAttribute("menu", menu);
		model.addAttribute("mlist", mlist);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("pageTag", pagingService.resultString());
		model.addAttribute("loglist", plist);
		model.addAttribute("dateSort", dateSort);
		dateMin = swaService.getMin();
		model.addAttribute("dateMin", dateMin);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("sttuser", STT_ID);
		model.addAttribute("sttmenu", STT_MENU);
		return address;
	}
	
	@RequestMapping(value = "/stt_login")
	public String stt_login(@RequestParam(value = "STT_ID", defaultValue = "-")String STT_ID
							,@RequestParam(value = "STT_PW", defaultValue = "-")String STT_PW
							,Model model
							,HttpServletRequest request
							,HttpSession session) {
		String address = "";
		log.setSTT_MENU("로그인");
		log.setSTT_USER(STT_ID);
		ip = request.getHeader("X-FORWARDED-FOR");
		if (ip == null)
			ip = request.getRemoteAddr();
		log.setSTT_IP(ip);
		log.setSTT_CONTENTS(STT_ID + "님 ip : " + ip +" 에서 로그인 하셨습니다.");
		SwaLoginDto sld = new SwaLoginDto();
		sld.setSTT_ID(STT_ID);
		sld.setSTT_PW(STT_PW);
		if(swaService.checkLogin(sld)) {
			SwaLoginDto who = swaService.getMember(sld);
			session.setAttribute("User_Name", who.getSTT_NAME());	
			session.setAttribute("level", who.getSTT_LEVEL());
			session.setAttribute("User_Id", who.getSTT_ID());
			model.addAttribute("check", who.getSTT_PW());
			model.addAttribute("seq", who.getSTT_SEQ());
			model.addAttribute("userId", who.getSTT_ID() + "|" + ip);
			model.addAttribute("menuKey", who.getSTT_CENTER());
			log.setSTT_CENTER(who.getSTT_CENTER());
			swaService.insertLog(log);
			address = "dnk/lmtool";
		} else {
			address = "redirect:/stt";
		}		
		return address;
	}
	@RequestMapping(value = "/changePw")
	public String changePw(Model model
						,@RequestParam(value = "seq", defaultValue = "")int seq) {
		String address = "dnk/changePw";
		//logger.info(">>>>>>>>>>>>>>>>>  seq " + seq);
		model.addAttribute("seq", seq);
		return address;
	}
	
	@RequestMapping(value = "/listenAgo")
	public String listenAgo(Model model
							,@RequestParam(value = "now_page", defaultValue = "0")String now_page
							,@RequestParam(value = "dateSort", defaultValue = "")String dateSort
							,@RequestParam(value = "startDate", defaultValue = "")String startDate
							,@RequestParam(value = "endDate", defaultValue = "")String endDate
							,@RequestParam(value = "STT_ID", defaultValue = "")String STT_ID
							,@RequestParam(value = "STT_MENU", defaultValue = "")String STT_MENU) {
		String address = "dnk/listenAgo";
		SwaMstDto smd = new SwaMstDto();
		PageDto pageDto = new PageDto();
		String page = now_page;
		String dateMin = "";
		int totalCount = 0;
		int nowPage = 1;
		int pageCount = 0;
		
		if(page.equals("0")) {
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
		
		smd.setDateSort(dateSort);
		smd.setStartDate(startDate);
		smd.setEndDate(endDate);

		
		
		totalCount = swaService.getMstCount(smd);
		pageCount = totalCount / recordCnt + 1;
		if(totalCount % recordCnt == 0) {
			pageCount = totalCount / recordCnt;
		}
		if(nowPage > pageCount) {
			nowPage = 1;
		}
		pageDto.setNowPage(nowPage);
		pageDto.setTotalCount(totalCount);
		
		PagingService pagingService = new PagingService(pageDto, recordCnt, pagingCnt, "pageEvent");
		smd.setStartRow(pagingService.getStartRow());
		smd.setEndRow(pagingService.getEndRow());
		
		List<SwaMstDto> agolist = swaService.getMstList(smd);
		String[] user_nm;
		SwaMstDto smmd = new SwaMstDto();
		for (int i = 0; i < agolist.size(); i++) {
			smmd = agolist.get(i);
			user_nm = smmd.getR_FILE_NM().split("_");
			for (int j = 0; j < user_nm.length; j++) {
				smmd.setSTT_USER_NUM(user_nm[3]);
				smmd.setSTT_MEM_NUM(user_nm[1]);
				smmd.setCall_Id1(user_nm[4]);
				smmd.setCall_Id2(user_nm[5]);
				smmd.setCall_Id3(user_nm[6]);
			}
		}
		
		agolist.add(smmd);
		
		
		
		
		
		model.addAttribute("agolist", agolist);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("pageTag", pagingService.resultString());
		model.addAttribute("dateSort", dateSort);
		dateMin = swaService.getMstMin();
		model.addAttribute("dateMin", dateMin);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
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
		log.setSTT_MENU("운영자 생성");
		log.setSTT_CONTENTS("새로운 운영자 "+ STT_ID +" 생성");
		swaService.insertLog(log);
		swaService.insertUser(sld);
		return address;
	}
	
	@RequestMapping(value = "/createUser")
	public String createUser(Model model) {
		String address = "dnk/createUser";
		SwaLoginDto sld = new SwaLoginDto();
		ArrayList<SwaLoginDto> alist = new ArrayList<>();
		sld.setSTT_ID(null);
		alist = swaService.getUser(sld);
		model.addAttribute("SwaUser", alist);
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
			log.setSTT_MENU("권한부여");
			log.setSTT_CONTENTS("운영자 "+swaService.getUserId(sld)+"님에게 권한부여");
			swaService.insertLog(log);
		} else {
			log.setSTT_MENU("권한회수");
			log.setSTT_CONTENTS("운영자 "+swaService.getUserId(sld)+"님 권한회수");
			swaService.insertLog(log);
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
		
		log.setSTT_MENU("운영자 삭제");
		log.setSTT_CONTENTS("운영자 "+swaService.getUserId(sld)+"님 계정 삭제");
		swaService.insertLog(log);
		
		swaService.deleteUser(sld);
		
		return address;
	}
	
	@RequestMapping(value = "/resetPw")
	public String resetPw(@RequestParam(value = "STT_SEQ", defaultValue = "")int STT_SEQ) {
		String address = "redirect:/createUser";
		SwaLoginDto sld = new SwaLoginDto();
		sld.setSTT_SEQ(STT_SEQ);
		sld.setSTT_PW("1234");
		log.setSTT_MENU("운영자 비밀번호 초기화");
		log.setSTT_CONTENTS("운영자 "+swaService.getUserId(sld)+"님 비밀번호 초기화");
		swaService.insertLog(log);
		swaService.resetPw(sld);
		return address;
	}
	
	@RequestMapping(value = "/changePws")
	public String changePws(@RequestParam(value = "STT_SEQ", defaultValue = "")int STT_SEQ
							,@RequestParam(value = "STT_PW", defaultValue = "")String STT_PW) {
		String address = "redirect:/stt";
		SwaLoginDto sld = new SwaLoginDto();
		//logger.info(">>>>>>>>>>>>>>>>>" + STT_SEQ);
		sld.setSTT_PW(STT_PW);
		sld.setSTT_SEQ(STT_SEQ);
		log.setSTT_MENU("비밀번호 변경");
		log.setSTT_CONTENTS("운영자 "+swaService.getUserId(sld)+"님 초기 설정 비밀번호 변경");
		swaService.insertLog(log);
		swaService.resetPw(sld);
		return address;
	}
	
	@RequestMapping(value = "/player")
	public String player(Model model) {
		String address = "dnk/player";
		return address;
	}
	
	@RequestMapping(value = "/checkIdok")
	@ResponseBody
	public String checkIdok(@RequestParam(value = "id", defaultValue = "")String id) {
		String result = "false";
		SwaLoginDto sld = new SwaLoginDto();
		sld.setSTT_ID(id);
		boolean check = swaService.checkIdok(sld);
		if(check) {
			result = "true";
		}
		return result;
	}
	
	@RequestMapping(value = "/logout")
	public String logout(Model model
						,HttpSession session) {
		String address = "redirect:/stt";
		session.invalidate();
		return address;
	}
	
	@RequestMapping(value = "/swaMem")
	public String swaMem(Model model) {
		String address = "dnk/memList";
		
		return address;
	}
	
	@RequestMapping(value = "/test")
	public String test(Model model) {
		String address = "dnk/test";
		return address;
	}
	
	@RequestMapping(value = "/excel/download")
	public void excelDownload(HttpServletResponse response
							,@RequestParam(value = "now_page", defaultValue = "0")String now_page
							,@RequestParam(value = "dateSort", defaultValue = "")String dateSort
							,@RequestParam(value = "startDate", defaultValue = "")String startDate
							,@RequestParam(value = "endDate", defaultValue = "")String endDate
							,@RequestParam(value = "STT_ID", defaultValue = "")String STT_ID
							,@RequestParam(value = "STT_MENU", defaultValue = "")String STT_MENU) throws IOException{
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("테스트 시트");
		Row row = null;
		Cell cell = null;
		int rowNum = 0;
		
		PageDto pageDto = new PageDto();
		SwaLogDto sld = new SwaLogDto();
		SwaLoginDto slg = new SwaLoginDto();
		slg.setSTT_ID("hello");
		String page = now_page;
		String dateMin = "";
		int totalCount = 0;
		int nowPage = 1;
		int pageCount = 0;
		
		if(page.equals("0")) {
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
		
		sld.setDateSort(dateSort);
		sld.setStartDate(startDate);
		sld.setEndDate(endDate);

		sld.setSTT_USER(STT_ID);
		sld.setSTT_MENU(STT_MENU);
		
		totalCount = swaService.getLogCount(sld);
		pageCount = totalCount / recordCnt + 1;
		if(totalCount % recordCnt == 0) {
			pageCount = totalCount / recordCnt;
		}
		if(nowPage > pageCount) {
			nowPage = 1;
		}
		pageDto.setNowPage(nowPage);
		pageDto.setTotalCount(totalCount);
		
		PagingService pagingService = new PagingService(pageDto, recordCnt, pagingCnt, "pageEvent");
		sld.setStartRow(pagingService.getStartRow());
		sld.setEndRow(totalCount);
		
		List<SwaLogDto> plist = swaService.getLogtable(sld);

	    // Header
	    row = sheet.createRow(rowNum++);
	    
	    cell = row.createCell(0);
	    cell.setCellValue("작업일시");
	    cell = row.createCell(1);
	    cell.setCellValue("센터");
	    cell = row.createCell(2);
	    cell.setCellValue("관리자");
	    cell = row.createCell(3);
	    cell.setCellValue("ip");
	    cell = row.createCell(4);
	    cell.setCellValue("접근메뉴");
	    cell = row.createCell(5);
	    cell.setCellValue("작업내용");

	    // Body
	    SwaLogDto sld2 = new SwaLogDto();
	    for (int i = 0; i < plist.size(); i++) {
	    	 sld2 = plist.get(i);
	    	row = sheet.createRow(rowNum++);
	 	    cell = row.createCell(0);
	 	    cell.setCellValue(sld2.getSTT_DATE());
	 	    cell = row.createCell(1);
	 	    cell.setCellValue(sld2.getSTT_CENTER());
	 	    cell = row.createCell(2);
	 	    cell.setCellValue(sld2.getSTT_USER());
	 	    cell = row.createCell(3);
	 	    cell.setCellValue(sld2.getSTT_IP());
	 	    cell = row.createCell(4);
	 	    cell.setCellValue(sld2.getSTT_MENU());
	 	    cell = row.createCell(5);
	 	    cell.setCellValue(sld2.getSTT_CONTENTS());
		}

	    // 컨텐츠 타입과 파일명 지정
	    response.setContentType("ms-vnd/excel");
	    response.setHeader("Content-Disposition", "attachment;filename=example.xlsx");

	    // Excel File Output
	    wb.write(response.getOutputStream());
	    wb.close();
	}
	
}
