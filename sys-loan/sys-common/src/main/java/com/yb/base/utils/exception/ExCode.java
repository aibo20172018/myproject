package com.yb.base.utils.exception;

public interface ExCode {
	
	public static final String BIZ_EX_PREFIX = "";
	public static final String SYS_EX_PREFIX = "-";
	
	public String getErrorCode();
	
	public String getErrorMsg();
}
