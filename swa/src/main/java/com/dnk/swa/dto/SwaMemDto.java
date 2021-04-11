package com.dnk.swa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwaMemDto {
	private int SWA_SEQ;
	private String SWA_CENTER;
	private String SWA_NAME;
	private String SWA_INNUM;
	private String SWA_ID;
	
	
	// 페이징 
	private String startDate;
	private String endDate;
	private int rowNum;
	private int startRow;
	private int endRow;
	private String dateSort;
}
