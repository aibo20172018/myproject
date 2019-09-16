package com.yb.base.utils.json;

import java.util.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JSONUtils {

    public static <V> V toObject(String text, Class<V> clazz) {
        return JSON.parseObject(text, clazz);
    }

    public static String toJson(Object object) {
        return JSON.toJSONString(object, SerializerFeature.WriteDateUseDateFormat);
    }

    public static <T> List<T> toArray(String json, Class<T> clazz) {
        return JSON.parseArray(json, clazz);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <K, V> Map<K, V> toMap(String json, Object typeReference) {
        return (Map<K, V>) JSON.parseObject(json, (TypeReference) typeReference);
    }


    public static String objToJson(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Number ||
                value instanceof String
        ) {
            return value.toString();
        }

        return JSONUtils.toJson(value);
    }

    public static <T> T jsonToObj(String json, Class<T> type) {
        if (json == null || json.length() == 0) {
            return null;
        }
        if (type.isPrimitive()){
            return type.cast(json);
        }
        return JSONUtils.toObject(json, type);
    }

}
