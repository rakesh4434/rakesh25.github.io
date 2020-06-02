package com.infor.newsApplication.constant;

/*
	@author 1822780
*/ 
public class NewsApplicationConstant {
	public static final String CREATE_SECTION_ENDPOINT="/createSection";
	public static final String GET_SECTION_ENDPOINT="/sectionNews/{sectionName}";
	public static final String UPDATE_SECTION_ENDPOINT = "/updateSection";
	public static final String DELETE_SECTION_ENDPOINT = "/deleteSection";
	
	public static final String OK="OK";
	public static final String CREATED="CREATED";
	public static final String NOT_FOUND="NOT FOUND";
	public static final String INTERNAL_SERVER_ERROR="INTERNAL SERVER ERROR";
	public static final String BAD_REQUEST="BAD REQUEST";
	public static final String UNAUTHORIZED="UNAUTHORIZED";
	
	public static final int STATUS_CODE_OK=200;
	public static final int STATUS_CODE_CREATED=201;
	public static final int STATUS_CODE_NOT_FOUND=200;
	public static final int STATUS_CODE_INTERNAL_SERVER_ERROR=500;
	public static final int STATUS_CODE_BAD_REQUEST=400;
	public static final int STATUS_CODE_UNAUTHORIZED=401;
}
