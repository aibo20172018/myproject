package com.yb.base.utils.http;

import lombok.Getter;
import lombok.Setter;
import org.apache.http.client.config.RequestConfig;


@Getter
@Setter
public class HttpParam {
	private String title;
	private String reqUrl;
	private Object reqData;
	private String contentType;
	private String charset = "UTF-8";
	private String reqMethod = "POST";

	/**
	 * 外部的网络环境配置
	 */
	private RequestConfig requestConfig;
	/**
	 * 处理重定向
	 */
	private boolean isRedirect;

	public HttpParam(String title, String reqUrl, Object reqData) {
		this.title = title;
		this.reqUrl = reqUrl;
		this.reqData = reqData;
	}


	public HttpParam(String title, String reqUrl, Object reqData, String charset) {
		this.title = title;
		this.reqUrl = reqUrl;
		this.reqData = reqData;
		this.charset = charset;
	}


	public HttpParam(String title, String reqUrl, Object reqData, String contentType, String charset) {
		this.title = title;
		this.reqUrl = reqUrl;
		this.reqData = reqData;
		this.contentType = contentType;
		this.charset = charset;
	}

	public HttpParam(String title, String reqUrl, Object reqData, String contentType, String charset, String reqMethod,
			RequestConfig requestConfig, boolean isRedirect) {
		super();
		this.title = title;
		this.reqUrl = reqUrl;
		this.reqData = reqData;
		this.contentType = contentType;
		this.charset = charset;
		this.reqMethod = reqMethod;
		this.requestConfig = requestConfig;
		this.isRedirect = isRedirect;
	}

}
