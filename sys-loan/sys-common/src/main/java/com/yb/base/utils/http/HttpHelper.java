package com.yb.base.utils.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class HttpHelper {

	protected static Logger logger = LoggerFactory.getLogger(HttpHelper.class);

	/**
	 * 发送form请求
	 *
	 * @param requestParam
	 * @return
	 * @throws Exception
	 */
	public static String requestByForm(HttpParam requestParam) {
		HttpClient httpClient = null;
		HttpResponse resp = null;
		String title = requestParam.getTitle();
		String reqUrl = requestParam.getReqUrl();
		String method = requestParam.getReqMethod();
		List<NameValuePair> formparams = parse2formParam(requestParam.getReqData());
		try {
			String encoding = StringUtils.defaultIfBlank(requestParam.getCharset(), "UTF-8");
			UrlEncodedFormEntity postEntity = new UrlEncodedFormEntity(formparams, encoding);
			httpClient = HttpClients.createAuthNonHttpClient();
			HttpRequestBase request;
			if ("POST".equalsIgnoreCase(method)) {
				HttpPost httpPost = new HttpPost(reqUrl);
				httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=" + encoding);
				httpPost.setEntity(postEntity);
				if (null != requestParam.getRequestConfig()) {
					httpPost.setConfig(requestParam.getRequestConfig());
				}
				request = httpPost;
			} else {
				String queryParam = EntityUtils.toString(postEntity, encoding);
				HttpGet httpGet = new HttpGet(requestParam.getReqUrl() + "?" + queryParam);
				if (null != requestParam.getRequestConfig()) {
					httpGet.setConfig(requestParam.getRequestConfig());
				}
				request = httpGet;
			}
			long reqBeforeTime = System.currentTimeMillis();
			logger.info("request:{}", request);
			resp = httpClient.execute(request);
			double usedTime = (System.currentTimeMillis() - reqBeforeTime) / 1000.00D;
			String resultContent;
			int statusCode = resp.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				if (requestParam.isRedirect() && statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
					Header header = resp.getFirstHeader("location");
					resultContent = header.getValue();
				} else {
					throw new RuntimeException(title + "-发送请求失败-状态码：" + resp.getStatusLine().toString());
				}
			} else {

				HttpEntity entity = resp.getEntity();
				resultContent = EntityUtils.toString(entity, "UTF-8");
			}
			logger.info("{}-form请求-url：{},参数：{}，耗时：{},返回结果：{}", title, reqUrl, formparams, usedTime, resultContent);
			return resultContent;
		} catch (Exception e) {
			logger.info("{}-form请求处理异常-url：{},参数：{}", title, reqUrl, formparams);
			throw new RuntimeException(title + "-发送请求失败", e);
		} finally {
			HttpClientUtils.closeQuietly(resp);
			HttpClientUtils.closeQuietly(httpClient);
		}
	}

	private static List<NameValuePair> parse2formParam(Object params) {
		List<NameValuePair> nameValuePairs = Lists.newArrayList();
		if (params instanceof Map) {
			for (Map.Entry<String, Object> entry : ((Map<String, Object>) params).entrySet()) {
				if (entry.getValue() != null) {
					nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
				}
			}
		} else {
			SerializeFilter[] serializeFilters = new SerializeFilter[] { new PropertyFilter() {
				@Override
				public boolean apply(Object o, String s, Object o1) {
					if (o1 == null) {
						return false;
					}
					if (o1 instanceof String && StringUtils.isBlank((String) o1)) {
						return false;
					}
					return true;
				}
			}/* , new NullToEmptyFilter() */ };
			String jsonString = JSON.toJSONString(params, serializeFilters/*
																			 * , SerializerFeature.WriteMapNullValue,
																			 * SerializerFeature.WriteNullStringAsEmpty
																			 */);
			JSONObject jsonObject = JSON.parseObject(jsonString);
			for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
				nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
			}
		}
		return nameValuePairs;
	}

	/**
	 * 发送请求
	 *
	 * @param requestParam
	 * @return
	 * @throws Exception
	 */
	public static String request(HttpParam requestParam) {
		HttpClient httpClient = null;
		HttpResponse resp = null;
		String title = requestParam.getTitle();
		String reqUrl = requestParam.getReqUrl();
		try {
			HttpPost httpPost = new HttpPost(reqUrl);
			httpPost.setHeader("Content-Type", StringUtils.defaultString(requestParam.getContentType(), "application/json;charset=" + requestParam.getCharset()));
			HttpEntity postEntity = new StringEntity((String) requestParam.getReqData(), requestParam.getCharset());
			httpPost.setEntity(postEntity);
			if (null != requestParam.getRequestConfig()) {
				httpPost.setConfig(requestParam.getRequestConfig());
			}
			httpClient = HttpClients.createAuthNonHttpClient();
			long reqBeforeTime = System.currentTimeMillis();
			resp = httpClient.execute(httpPost);
			double usedTime = (System.currentTimeMillis() - reqBeforeTime) / 1000.00D;
			if (resp.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				throw new RuntimeException(title + "-发送请求失败-状态码：" + resp.getStatusLine().toString());
			}
			HttpEntity entity = resp.getEntity();
			String resultContent = EntityUtils.toString(entity, requestParam.getCharset());
			logger.info("{}-请求-url：{},\r\n参数：{},\r\n耗时：{},\r\n返回结果:{}", title, reqUrl, requestParam.getReqData(), usedTime,	resultContent);
			return resultContent;
		} catch (Exception e) {
			logger.info("{}-发送请求处理异常-url：{},\r\n参数：{}", title, reqUrl, requestParam.getReqData());
			throw new RuntimeException(requestParam.getTitle() + "-发送请求失败", e);
		} finally {
			HttpClientUtils.closeQuietly(resp);
			HttpClientUtils.closeQuietly(httpClient);
		}
	}

	/**
	 * 将url的search转换为json
	 *
	 * @param urlQuery
	 * @return
	 */
	public static JSONObject parseUrlQuery2Json(String urlQuery) {
		JSONObject jsonObject = new JSONObject();
		String[] keyValues = urlQuery.split("&");
		for (String keyValue : keyValues) {
			int index = StringUtils.indexOf(keyValue, "=");
			jsonObject.put(StringUtils.substring(keyValue, 0, index), StringUtils.substring(keyValue, index + 1));
		}
		return jsonObject;
	}

	public static String parse2reqGetUrl(String url, Object reqParam, String encoding) {
		List<NameValuePair> formparams = parse2formParam(reqParam);
		try {
			UrlEncodedFormEntity postEntity = new UrlEncodedFormEntity(formparams, encoding);
			String queryParam = EntityUtils.toString(postEntity, encoding);
			if (StringUtils.isNotBlank(url)) {
				return url + "?" + queryParam;
			} else {
				return queryParam;
			}
		} catch (Exception e) {
			throw new RuntimeException("解析请求地址异常", e);
		}
	}

	public static String map2noEncodeHttpQuery(JSONObject param) {
		StringBuffer sb = new StringBuffer();
		boolean isFirst = true;
		for (Map.Entry entry : param.entrySet()) {
			if (isFirst) {
				isFirst = false;
			} else {
				sb.append("&");
			}
			sb.append(entry.getKey()).append("=").append(entry.getValue());
		}
		return sb.toString();
	}

	/**
	 * 前台交易构造HTTP POST交易表单,默认编码为utf-8<br>
	 *
	 * @param action       表单提交地址<br>
	 * @param formElements 以MAP形式存储的表单键值<br>
	 * @return 构造好的HTTP POST交易表单<br>
	 */
	public static String createAutoFormHtml(String action, Map<String, ?> formElements) {
		return createAutoFormHtml(action, formElements, "UTF-8");
	}

	/**
	 * 前台交易构造HTTP POST交易表单<br>
	 *
	 * @param action       表单提交地址<br>
	 * @param formElements 以MAP形式存储的表单键值<br>
	 * @param encoding     上送请求报文域encoding字段的值<br>
	 * @return 构造好的HTTP POST交易表单<br>
	 */
	public static String createAutoFormHtml(String action, Map<String, ?> formElements, String encoding) {
		StringBuffer sf = new StringBuffer();
		sf.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=" + encoding + "\"/></head><body>");
		sf.append("<form id = \"autoForm\" action=\"" + action + "\" method=\"post\">");
		if (null != formElements && !formElements.isEmpty()) {
			for (Map.Entry<String, ?> entry : formElements.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();
				if(value == null){
					continue;
				}
				String targetValue = value.toString();
				if(StringUtils.isBlank(targetValue)){
					continue;
				}
				//html特殊字符处理
				targetValue = StringEscapeUtils.escapeHtml4(targetValue);
				sf.append("<input type=\"hidden\" name=\"" + key + "\" id=\"" + key + "\" value=\"" + targetValue + "\"/>");
			}
		}
		sf.append("</form>");
		sf.append("</body>");
		sf.append("<script type=\"text/javascript\">");
		sf.append("document.all.autoForm.submit();");
		sf.append("</script>");
		sf.append("</html>");
		return sf.toString();
	}

	public static String createAutoFormHtml(String action, Map<String, String> formElements, String encoding, String acceptEncoding) {
		StringBuffer sf = new StringBuffer();
		sf.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=" + encoding + "\"/></head><body>");
		sf.append("<form id = \"autoForm\" action=\"" + action + "\" method=\"post\" accept-charset=\""+acceptEncoding + "\">");
		if (null != formElements && !formElements.isEmpty()) {
			for (Map.Entry<String, String> entry : formElements.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();
				if(value == null){
					continue;
				}
				String targetValue = value.toString();
				if(StringUtils.isBlank(targetValue)){
					continue;
				}
				//html特殊字符处理
				targetValue = StringEscapeUtils.escapeHtml4(targetValue);
				sf.append("<input type=\"hidden\" name=\"" + key + "\" id=\"" + key + "\" value=\"" + targetValue + "\"/>");
			}
		}
		sf.append("</form>");
		sf.append("</body>");
		sf.append("<script type=\"text/javascript\">");
		sf.append("document.all.autoForm.submit();");
		sf.append("</script>");
		sf.append("</html>");
		return sf.toString();
	}

	public static String createFormHtml(String action, Map<String, String> formElements,String acceptEncoding) {
		StringBuffer sf = new StringBuffer();
		sf.append("<form id = \"autoForm\" action=\"" + action + "\" method=\"post\" accept-charset=\""+acceptEncoding + "\">");
		if (null != formElements && !formElements.isEmpty()) {
			for (Map.Entry<String, String> entry : formElements.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				//html特殊字符处理
				value = StringEscapeUtils.escapeHtml4(value);
				sf.append("<input type=\"hidden\" name=\"" + key + "\" id=\"" + key + "\" value=\"" + value + "\"/>");
			}
		}
		sf.append("</form>");
		return sf.toString();
	}

}
