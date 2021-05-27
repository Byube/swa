package com.dnk.swa.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dnk.swa.dto.ListenAgoDto;
import com.dnk.swa.dto.SwaLogDto;
import com.dnk.swa.dto.SwaLoginDto;
import com.dnk.swa.dto.SwaMstDto;
import com.dnk.swa.service.MultipartFileSender;
import com.dnk.swa.service.SwaService;
import com.llsollu.eznlp.postproc.PostProcessor2;

@Controller
@RequestMapping("/stt")
public class SttController {
	
	private static final Logger logger = LoggerFactory.getLogger(SttController.class);
	
	@Autowired
	private SwaService swaService;
	
	private PostProcessor2 mPostProcessor = null;
	
	SwaLogDto log = new SwaLogDto();
			
	public SttController() {
		String str = System.getProperty("user.dir");
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Rule Path : "+str);
		mPostProcessor = new PostProcessor2(new File(str, "rules").getAbsolutePath());
	}
	
	@CrossOrigin
    @RequestMapping("/gettxt/")
    @ResponseBody
    public String gettxt(HttpServletResponse response
    					,@RequestParam(value = "STT_CALL1",defaultValue = "")String STT_CALL1
    					,@RequestParam(value = "STT_CALL2",defaultValue = "")String STT_CALL2
    					,@RequestParam(value = "STT_CALL3",defaultValue = "")String STT_CALL3
    					,@RequestParam(value = "STT_USER_NUM",defaultValue = "")String STT_USER_NUM
    					,@RequestParam(value = "STT_MEM_NUM",defaultValue = "")String STT_MEM_NUM
    					,@RequestParam(value = "R_F_NM",defaultValue = "")String R_F_NM
    					,@RequestParam(value = "STT_DTM",defaultValue = "")String STT_DTM
    					,@RequestParam(value = "userId", defaultValue = "-")String userId
    					,HttpServletRequest request) {
        response.setContentType("text/plain");
        logger.info("[gettxt] :");
        
        
        
        SwaMstDto smd = new SwaMstDto();
        SwaLoginDto sld = new SwaLoginDto();
        String result = "";
        String result1 = "";
        String user_p = "";
        String center = "";
        String ip = "";
        ip = request.getHeader("X-FORWARDED-FOR");
        if (ip == null)
			if (request.getRemoteAddr().equals("0:0:0:0:0:0:0:1")) {
				ip = "127.0.0.1";
			} else {
				ip = request.getRemoteAddr();
			}
        
        smd.setSTT_CALL(R_F_NM);
        result = swaService.getMstC(smd);
        
        //로그 입력 부분
        sld.setSTT_ID(userId);
        log.setSTT_USER(userId);
        log.setSTT_IP(ip);
        center = swaService.getCenter(sld);
        log.setSTT_CENTER(center);
        log.setSTT_MENU("과거녹취청취");
		log.setSTT_CONTENTS(userId+ "님 파일 : " + R_F_NM + " 청취 하였습니다.");
		swaService.insertLog(log);
		
        String [] dtm = STT_DTM.split(" ");
        String [] dtm1 = dtm[0].split("-");
        String dtmis = "";
        for (int i = 0; i < dtm1.length; i++) {
			dtmis += dtm1[i];
		}
 //       logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>"+dtmis);
        String[] line;
        String []hp;
        line = result.split("\n");
        for (int i = 0; i < line.length - 3; i++) {
			hp = line[i].split("\\|");
			result1 += hp[0] + "|" + hp[1] + "|" + mPostProcessor.postProcessing(hp[2]) +"\n";
			
		}
		String result2 = "";
		ListenAgoDto lad = new ListenAgoDto();
		if(STT_CALL1.equals("CALLID1")) {
			lad.setR_call_id1("");
		} else {
			lad.setR_call_id1(STT_CALL1);
		}
		if(STT_CALL2.equals("CALLID2")) {
			lad.setR_call_id2("");
		} else {
			lad.setR_call_id2(STT_CALL2);
		}
		if(STT_CALL3.equals("CALLID3")) {
			lad.setR_call_id3("");
		} else {
			lad.setR_call_id3(STT_CALL3);
		}
		if(STT_USER_NUM.substring(0,1).equals("9")) {
			user_p = STT_USER_NUM.substring(1,STT_USER_NUM.length());
		} else {
			user_p = STT_USER_NUM;
		}
	//	logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + user_p);
		lad.setR_cust_phone1(user_p);
		
		lad.setR_ext_num(STT_MEM_NUM);
		lad.setSTT_DTM(dtmis);
		try {
			result2 = swaService.getMp3Url(lad);
		} catch (Exception e) {
			result2 = null;
		}
		
		result1 += result2;
        
  //     logger.info( R_F_NM + " >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + result2);
        return result1;
    }

    @RequestMapping("/getstream/")
    @ResponseBody
    public String getStream(HttpServletRequest request, HttpServletResponse response) {
        Path pathtofile = Paths.get("0000.wav");
    	//Path pathtofile = Paths.get("http://98.28.8.45:28881/listen?url=/var/REC/RecSee_Data/20190925/09/20190925_093609_0156_user_3842_93694654_3842_389666_0010.mp3");
        try {
            MultipartFileSender.fromPath(pathtofile).with(request).with(response).serveResource();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}
