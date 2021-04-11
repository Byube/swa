package com.dnk.swa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwaMstDto {
	private String R_FILE_NM;
	private String R_F_NM;
	private String STT_DTM;
	private String STT_STAT;
	private String STT_USER_NAME;
	private String STT_RX;
	private String STT_TX;
	private String STT_MRESULT;
	
	//내선번호, 고객전화
	private String STT_USER_NUM;
	private String STT_MEM_NUM;
	
	//청취듣기위함
	private String STT_CALL1;
	private String STT_CALL2;
	private String STT_CALL3;
	private String STT_CALL;
	
	// 페이징 
	private String startDate;
	private String endDate;
	private int rowNum;
	private int startRow;
	private int endRow;
	private String dateSort;
}
