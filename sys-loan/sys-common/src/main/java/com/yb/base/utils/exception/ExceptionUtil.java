package com.yb.base.utils.exception;

public class ExceptionUtil {
	
	public static Throwable getRootCause(Throwable exception) {
        Throwable rootCause = exception;
        for (Throwable cause = exception.getCause(); cause != null && cause != rootCause; cause = cause.getCause()) {
            rootCause = cause;
        }
        return rootCause;
    } 

}
