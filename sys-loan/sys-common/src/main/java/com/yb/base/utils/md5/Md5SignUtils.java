package com.yb.base.utils.md5;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Sets;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.*;

/**
 * <br>
 * <b>功能：</b>详细的功能描述<br>
 * <b>作者：</b>Jojo@oft.com<br>
 * <b>日期：</b> 2016/9/6 <br>
 * <b>版权所有：<b>在线金融科技有限公司版权所有(C) 2016<br>
 */
public class Md5SignUtils {


    private static Logger logger = LoggerFactory.getLogger(Md5SignUtils.class);

    /**
     * 根据json数据生成签名信息
     *
     * @param signKey
     * @param signJsonPlainText
     * @return
     */
    public static String createSignInfo(String signKey, String signJsonPlainText) {
        /*signJsonPlainText = StringUtils.replaceEach(signJsonPlainText, new String[]{"\":\"", "\":", "\",\"", ",\""}, new String[]{"=", "=", "&", "&"});
        signJsonPlainText = Pattern.compile("^\\{\"", Pattern.DOTALL).matcher(signJsonPlainText).replaceAll("");
        signJsonPlainText = Pattern.compile("\"}|}$", Pattern.DOTALL).matcher(signJsonPlainText).replaceAll("");*/
        signJsonPlainText += "&key=" + signKey;
        logger.debug("签名-明文:{}", signJsonPlainText);
        String signInfo = md5(signJsonPlainText).toUpperCase();
        logger.debug("签名-密文:{}", signInfo);
        return signInfo;
    }

    /**
     * 生成签名信息
     *
     * @param signKey
     * @param dataInfo
     * @return
     */
    public static String createSign4Object(String signKey, Object dataInfo, String... filters) {
        String signJsonPlainText = createSignPlainText(dataInfo, filters);
        signJsonPlainText += "&key=" + signKey;
        logger.debug("签名-明文:{}", signJsonPlainText);
        String signInfo = md5(signJsonPlainText).toUpperCase();
        logger.debug("签名-密文:{}", signInfo);
        return signInfo;
    }

    /**
     * 生成md5信息(不带签名key)
     *
     * @param signKey
     * @param dataInfo
     * @return
     */
    public static String createMd54Object(String signKey, Object dataInfo, String... filters) {
        String signJsonPlainText = createSignPlainText(dataInfo, filters);
        logger.debug("签名-明文:{}", signJsonPlainText);
        String signInfo = md5(signJsonPlainText).toUpperCase();
        logger.debug("签名-密文:{}", signInfo);
        return signInfo;
    }


    /**
     * 生成签名明文信息(指定串接字符)
     *
     * @param dataInfo
     * @return
     */
    public static String createSignPlainTextWithSeparator(Object dataInfo, String separator, String... filters) {
        String signJsonPlainText = createSignPlainTextWithSeparator(dataInfo, separator, false, filters);
        logger.debug("签名-明文:{}", signJsonPlainText);
        return signJsonPlainText;
    }

    /**
     * 生成签名明文信息不区分大小写
     *
     * @param dataInfo
     * @return
     */
    public static String createSignPlainText(Object dataInfo, String... filters) {
        return createSignPlainTextWithSeparator(dataInfo, "&", false, filters);
    }

    /**
     * 生成签名明文信息不区分大小写
     *
     * @param dataInfo
     * @return
     */
    public static String createSignPlainText(Object dataInfo, boolean isWithEmpty, String... filters) {
        return createSignPlainTextWithSeparator(dataInfo, "&", isWithEmpty, filters);
    }

    /**
     * 生成签名明文信息
     *
     * @param dataInfo
     * @param isWithEmpty 是否包含空
     * @return
     */
    public static String createSignPlainTextWithSeparator(final Object dataInfo, String separator, final boolean isWithEmpty, final String... filters) {
        if (dataInfo instanceof String) {
            return (String) dataInfo;
        }
        if (dataInfo instanceof Map) {
            Map<String, Object> dataMap = (Map<String, Object>) dataInfo;
            return createMapSignPlainText(dataMap, separator, isWithEmpty, filters);
        }
        String signJsonPlainText = JSON.toJSONString(dataInfo);
        JSONObject jsonObject = JSON.parseObject(signJsonPlainText);
        return createMapSignPlainText(jsonObject, separator, isWithEmpty, filters);
    }


    private static String createMapSignPlainText(Map<String, Object> dataMap, String separator, final boolean isWithEmpty, final String... filters) {
        final StringBuilder sb = new StringBuilder();
        final Set<String> filterSet = Sets.newHashSet(filters);
        List<String> list = new ArrayList<String>();
        for (Map.Entry<String, Object> entry : dataMap.entrySet()) {
            Object value = entry.getValue();
            if (!isWithEmpty) {
                if (value == null) {
                    continue;
                }
                if (value instanceof String && StringUtils.isBlank((String) value)) {
                    continue;
                }
            }
            String keyName = entry.getKey();
            if (filterSet.contains(keyName)) {
                continue;
            }
            if ("sign".equalsIgnoreCase(keyName.toLowerCase())) {
                continue;
            }
            list.add(keyName + "=" + entry.getValue());
        }
        int size = list.size();
        String[] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < size; i++) {
            sb.append(arrayToSort[i]);
            if (i < size - 1) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }

    /**
     * 生成签名明文信息 区分大小写排序
     *
     * @param dataInfo
     * @return
     */
    public static String createSignPlainTextCaseSensitive(Object dataInfo, String... filters) {
        return createSignPlainTextCaseSensitive(dataInfo, false, filters);
    }

    /**
     * 生成签名明文信息
     *
     * @param dataInfo
     * @param isWithEmpty 是否包含空
     * @return
     */
    public static String createSignPlainTextCaseSensitive(final Object dataInfo, final boolean isWithEmpty, final String... filters) {
        return createSignPlainTextCaseSensitive(dataInfo, "&", isWithEmpty, filters);
    }

    /**
     * 生成签名明文信息
     *
     * @param dataInfo
     * @param isWithEmpty 是否包含空
     * @return
     */
    public static String createSignPlainTextCaseSensitive(final Object dataInfo, String separator, final boolean isWithEmpty, final String... filters) {
        if (dataInfo instanceof String) {
            return (String) dataInfo;
        }
        if (dataInfo instanceof Map) {
            Map<String, Object> dataMap = (Map<String, Object>) dataInfo;
            return createMapSignPlainTextCaseSensitive(dataMap, separator, isWithEmpty, filters);
        }
        String signJsonPlainText = JSON.toJSONString(dataInfo /*,serializeFilters*//*, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty*/);
        JSONObject jsonObject = JSON.parseObject(signJsonPlainText);
        return createMapSignPlainTextCaseSensitive(jsonObject, separator, isWithEmpty, filters);
    }

    /**
     * 区分大小写
     *
     * @param dataMap
     * @param isWithEmpty
     * @param filters
     * @return
     */
    private static String createMapSignPlainTextCaseSensitive(Map<String, Object> dataMap, String separator, final boolean isWithEmpty, final String... filters) {
        final StringBuilder sb = new StringBuilder();
        final Set<String> filterSet = Sets.newHashSet(filters);
        List<String> list = new ArrayList<String>();
        for (Map.Entry<String, Object> entry : dataMap.entrySet()) {
            Object value = entry.getValue();
            if (!isWithEmpty) {
                if (value == null) {
                    continue;
                }
                if (value instanceof String && StringUtils.isBlank((String) value)) {
                    continue;
                }
            }
            String keyName = entry.getKey();
            if (filterSet.contains(keyName)) {
                continue;
            }
            if ("sign".equalsIgnoreCase(keyName.toLowerCase())) {
                continue;
            }
            list.add(keyName + "=" + entry.getValue());
        }
        int size = list.size();
        String[] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort);
        for (int i = 0; i < size; i++) {
            sb.append(arrayToSort[i]);
            if (i < size - 1) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }

    /**
     * 对明文进行md5
     *
     * @param plainText
     * @return
     */
    public static String md5(String plainText) {
        return md5(plainText, "utf-8");
    }

    /**
     * 对明文进行md5
     *
     * @param plainText
     * @param charset
     * @return
     */
    public static String md5(String plainText, String charset) {
        charset = StringUtils.defaultString(charset, "utf-8");
        try {
            return Hex.encodeHexString(md5(new ByteArrayInputStream(plainText.getBytes(charset))));
        } catch (Exception ex) {
            throw new RuntimeException("md5错误", ex);
        }
    }

    public static byte[] md5(InputStream input) throws IOException {
        return digest(input, "MD5");
    }

    private static byte[] digest(InputStream input, String algorithm) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            int bufferLength = 8192;
            byte[] buffer = new byte[bufferLength];

            for (int read = input.read(buffer, 0, bufferLength); read > -1; read = input.read(buffer, 0, bufferLength)) {
                messageDigest.update(buffer, 0, read);
            }

            return messageDigest.digest();
        } catch (GeneralSecurityException var6) {
            throw new RuntimeException(var6);
        }
    }
}
