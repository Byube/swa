package com.dnk.swa.dto;

import lombok.Data;

@Data
public class PageDto {
	private int boardMSeq;
	private int nowPage = 0;
	private int totalCount = 0;
	private String searchCate = "";
	private String searchValue = "";

}
