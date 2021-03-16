package com.dnk.swa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwaLoginDto {
	private int STT_SEQ;
	private String STT_NAME;
	private String STT_ID;
	private String STT_PW;
	private int STT_LEVEL;
	private String STT_DATE;
	private int STT_STATUS;
	private String STT_CENTER;
}
