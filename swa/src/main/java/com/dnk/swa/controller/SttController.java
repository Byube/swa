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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dnk.swa.dto.SwaMstDto;
import com.dnk.swa.service.MultipartFileSender;
import com.dnk.swa.service.SwaService;

@Controller
public class SttController {
	
	private static final Logger logger = LoggerFactory.getLogger(SwaController.class);
	
	@Autowired
	SwaService swaService;
	
	
	
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
//        return "";
        
        SwaMstDto smd = new SwaMstDto();
        String result = "";
        String result1 = "";
        smd.setSTT_CALL(R_F_NM);
        result = swaService.getMstC(smd);
        
        logger.info(STT_CALL1 + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + STT_CALL2 + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + STT_CALL3);
        
        smd.setSTT_USER_NUM(STT_USER_NUM);
        smd.setSTT_MEM_NUM(STT_MEM_NUM);
        String[] line;
        String []hp;
        line = result.split("\n");
        for (int i = 0; i < line.length - 3; i++) {
			hp = line[i].split("\\|");
			result1 += hp[0] + "|" + hp[1] + "|" + hp[2] +"\n";
			
		}
        
//       logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+result1);
        return result1;
//        		"72|702|미래를 함께하는 신한 은행 송민숙 입니다 고객님 네 그 유로 환전할 인데요 네\n"
//        + "702|885|그 수수료\n"
//        + "885|1170|우선 우대쿠폰 뭐 이런게 있다고 하는데 그거 어떻게\n"
//        + "1170|1971|하는 건지 해가지고요 아 그러세요 고객님 네 유로화로 환전 하실때 지금 우대를 가장 많이 받으실 수있는 방법이\n"
//        + "1971|2448|예 저희 신한은행에 써니뱅크 라고 하는 어플이 있습니다\n"
//        + "2448|2646|써니뱅크 요 예\n"
//        + "2646|2919|검색 예 스마트 폰에서 검색하셔서\n"
//        + "2919|3192|써니뱅크 어플을 다운로드 받으시구요\n"
//        + "3192|3543|네 그니까 저 신한은행 거래가 기존의 있으십니까\n"
//        + "3543|3759|예 그러시면은\n"
//        + "3759|4362|그 써니뱅크 로 접속해서 유로화 환전 하시게 되면 최고 구십 퍼센트\n"
//        + "4362|4575|환율우대 받으실 수가있고요\n"
//        + "4575|4908|고객님 환전하실 금액은 얼마정도 되십니까\n"
//        + "4908|5112|하나만 이상 백만원 좀\n"
//        + "5112|5718|아 예 그러시면은 하류에 원화로 백만원 까지만 환전 신청을 하실 수가있기 때문에\n"
//        + "5718|6036|예 이백만원 에서 삼백만원 이라고 하면\n"
//        + "6036|6669|그 이틀이나 삼일 동안 환전 신청하시고 수령은 같은 날짜로 지정해서 받으실 수가있는 데요\n"
//        + "6669|7209|예 환전한 그 다음날부터 수령을 받으실수 있기 때문에\n"
//        + "7209|7422|참고 해주시구요 고객님\n"
//        + "7422|7593|수령은 어디가서 해요\n"
//        + "7593|7956|공항 지점에서 환전소 에서 수령하시는 건데 혹시\n"
//        + "7956|8607|예 출국할 예정 이신 거죠 고객님 네 예 어느 공항 이용하십니까 인천공항 이용하십니까\n"
//        + "8607|9021|예 그러시면은 인천공항 출국장 쪽에 환전소 있습니다\n"
//        + "9021|9648|음 예 거기에서 이제 환전 환전을 다 완료 하게되면 환전 번호가 생성이 되는데\n"
//        + "9648|9801|네 환전 번호와\n"
//        + "9801|9981|고객님의 신분증\n"
//        + "9981|10362|지참 하시고 환전소 방문하시면 수령 받으실 수있습니다\n"
//        + "10362|10854|아 그 또한 고객님 아까 그 어플 해서 신청할때 네\n"
//        + "10854|11739|따로 모바일 뱅킹은 가입되어 있거나 뭐 이래야 되나요 아니면 아무것도 안돼서 되나요 잠시만 기다려주세요 확인 한번 해보겠습니다 네\n"
//        + "11739|12222|저희 신한 은행 인터넷뱅킹 사용 안하세요\n"
//        + "12222|12417|아 그러세요 해고 다 됐는데\n"
//        + "12417|13023|예 잠시만 기다려 주시겠습니까 네\n"
//        + "13023|13140|고객님\n"
//        + "13140|13392|네 아네 기다려주셔서 고맙습니다\n"
//        + "13392|13890|어 일단은 저희 인터넷뱅킹 가입이 되어 있어야지만\n"
//        + "13890|14268|당행 거래 고객으로 환전신청 하실수가있는데요\n"
//        + "14268|14613|네 만약에 인터넷뱅킹 이용이 어렵다라고 하면\n"
//        + "14613|14994|저희 타행 거래 고객 으로 이용하시는 방법도 있으세요\n"
//        + "14994|15195|그러면 수수료도 올라가는거는\n"
//        + "15195|15765|우대율 은 동일하구요 고객님 환전 신청하시는 방법이 조금 차이가 있어서 그러는데\n"
//        + "15765|16020|아 예 당행 거래 고객은\n"
//        + "16020|16557|저 신한은행 계좌에 자금이 바로 출금이 되면서 환전신청 되는거구요\n"
//        + "16557|16806|네 예 타행 거래 고객은\n"
//        + "16806|17079|가상계좌 번호를 부여해 해드립니다\n"
//        + "17079|17469|아 그러면 이제 삼십분 이내로 그 가상계좌로\n"
//        + "17469|18432|그 문자받으신 내용 대로 예 송금을 하시면 되세요 아 네 네 알겠습니다 그럼 상으로는 똑같은데 방법만 가는거죠 예 그렇습니다\n"
//        + "18432|18480|아\n"
//        + "18480|18834|그 그 신청 하고나서 그날 기준 환율로\n"
//        + "18834|18933|되는거죠\n"
//        + "18933|19359|환전신청 하는 그 시점에 그 환율이 적용이 되는겁니다\n"
//        + "19359|20736|아 네 알겠습니다 감사합니다 예 다른 더 궁금하신 사항 있으십니까 아니요 예 고맙습니다 즐거운 하루 되십시오 송민숙 입니다 네 수고하세요 네\n";
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
