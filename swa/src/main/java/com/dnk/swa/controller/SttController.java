package com.dnk.swa.controller;

import java.nio.file.Path;
import java.nio.file.Paths;

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
import com.dnk.swa.dto.SwaMstDto;
import com.dnk.swa.service.MultipartFileSender;
import com.dnk.swa.service.SwaService;

@Controller
@RequestMapping("/stt")
public class SttController {
	
	private static final Logger logger = LoggerFactory.getLogger(SttController.class);
	
	@Autowired
	private SwaService swaService;
		
			
	@CrossOrigin
    @RequestMapping("/gettxt/")
    @ResponseBody
    public String gettxt(HttpServletResponse response
    					,@RequestParam(value = "STT_CALL1",defaultValue = "")String STT_CALL1
    					,@RequestParam(value = "STT_CALL2",defaultValue = "")String STT_CALL2
    					,@RequestParam(value = "STT_CALL3",defaultValue = "")String STT_CALL3
    					,@RequestParam(value = "STT_USER_NUM",defaultValue = "")String STT_USER_NUM
    					,@RequestParam(value = "STT_MEM_NUM",defaultValue = "")String STT_MEM_NUM
    					,@RequestParam(value = "R_F_NM",defaultValue = "")String R_F_NM) {
        response.setContentType("text/plain");
        logger.info("[gettxt] :");
        
        SwaMstDto smd = new SwaMstDto();
        String result = "";
        String result1 = "";
        smd.setSTT_CALL(R_F_NM);
        result = swaService.getMstC(smd);
//        logger.info(STT_CALL1 + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + STT_CALL2 + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + STT_CALL3);
        smd.setSTT_USER_NUM(STT_USER_NUM);
        smd.setSTT_MEM_NUM(STT_MEM_NUM);
        String[] line;
        String []hp;
        line = result.split("\n");
        for (int i = 0; i < line.length - 3; i++) {
			hp = line[i].split("\\|");
			result1 += hp[0] + "|" + hp[1] + "|" + hp[2] +"\n";
			
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
		
		lad.setR_cust_phone1(STT_USER_NUM);
		lad.setR_ext_num(STT_MEM_NUM);
		
		result2 = swaService.getMp3Url(lad);
  
		result1 += result2;
        
       logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + result2);
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
