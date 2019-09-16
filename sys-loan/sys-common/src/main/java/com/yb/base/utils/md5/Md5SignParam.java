package com.yb.base.utils.md5;

/**
 * <br>
 * <b>功能：</b>详细的功能描述<br>
 * <b>作者：</b>Jojo@oft.com<br>
 * <b>日期：</b> 2016/9/25 <br>
 * <b>版权所有：<b>在线金融科技有限公司版权所有(C) 2016<br>
 */
public class Md5SignParam {
    private Object plainParam;
    private String signKey;
    private boolean isWithKeyName = true;
    private boolean isUppper = true;
    private String[] filters = new String[0];
    private String sign;
    private String charset = "utf-8";
    private String separator = "&";
    private String keyPrefix = "&key=";

    public Md5SignParam(Object plainParam, String signKey) {
        this.plainParam = plainParam;
        this.signKey = signKey;
    }

    public Md5SignParam(Object plainParam, String signKey, String[] filters) {
        this.plainParam = plainParam;
        this.signKey = signKey;
        this.filters = filters;
    }

    public Md5SignParam(Object plainParam, String signKey, boolean isWithKeyName, boolean isUppper, String[] filters) {
        this.plainParam = plainParam;
        this.signKey = signKey;
        this.isWithKeyName = isWithKeyName;
        this.isUppper = isUppper;
        this.filters = filters;
    }

    public Object getPlainParam() {
        return plainParam;
    }

    public void setPlainParam(Object plainParam) {
        this.plainParam = plainParam;
    }

    public String getSignKey() {
        return signKey;
    }

    public void setSignKey(String signKey) {
        this.signKey = signKey;
    }

    public boolean isWithKeyName() {
        return isWithKeyName;
    }

    public void setIsWithKeyName(boolean isWithKeyName) {
        this.isWithKeyName = isWithKeyName;
    }

    public boolean isUppper() {
        return isUppper;
    }

    public void setIsUppper(boolean isUppper) {
        this.isUppper = isUppper;
    }

    public String[] getFilters() {
        return filters;
    }

    public void setFilters(String[] filters) {
        this.filters = filters;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getKeyPrefix() {
        return keyPrefix;
    }

    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }
}
