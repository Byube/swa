package com.dnk.swa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwaLogDto {
	private int STT_SEQ;
	private String STT_DATE;
	private String STT_CENTER;
	private String STT_USER;
	private String STT_IP;
	private String STT_MENU;
	private String STT_CONTENTS;
	
	
	// 페이징 
	private String startDate;
	private String endDate;
	private int rowNum;
	private int startRow;
	private int endRow;
}
