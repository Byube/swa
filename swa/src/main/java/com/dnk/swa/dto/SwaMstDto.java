package com.dnk.swa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwaMstDto {
	private String R_FILE_NM;
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
	private String Call_Id1;
	private String Call_Id2;
	private String Call_Id3;
	
	// 페이징 
	private String startDate;
	private String endDate;
	private int rowNum;
	private int startRow;
	private int endRow;
	private String dateSort;
}
