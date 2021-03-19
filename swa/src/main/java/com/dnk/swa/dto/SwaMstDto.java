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
	private String STT_USER_LEVEL;
	private String STT_RX;
	private String STT_TX;
	private String STT_MRESULT;
}
