package com.dnk.swa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListenAgoDto {
	//
	private String r_cust_phone1;
	private String r_ext_num;
	private String r_listen_url;
	
	//청취듣기위함
	private String r_call_id1;
	private String r_call_id2;
	private String r_call_id3;


}
