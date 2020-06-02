package com.infor.newsApplication.model;

import org.springframework.stereotype.Component;

/*
	@author 1822780
*/
 
@Component
public class SectionResponse {
	private String status;
	private int statusCode;
	private String msg;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/*
	 * public SectionResponse(String status, int statusCode, String msg) { super();
	 * this.status = status; this.statusCode = statusCode; this.msg = msg; }
	 */
	public SectionResponse() {
		super();
	}
	
	
}
