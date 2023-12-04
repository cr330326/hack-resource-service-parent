package com.maezia.hack.resource.common.utils;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * @author : ChenRan
 * @date ： 2023/8/2 16:28
 * Description ：JsonUtils
 * project ：tgsop-tgsop-service-parent
 * dep : TT-32
 * company: MA
 */
public class JsonUtils {

    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public static String object2Json(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T json2Object(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static <T> T jsonElement2Object(JsonElement jsonElement, Class<T> clazz) {
        return gson.fromJson(jsonElement, clazz);
    }

    public static <T> T json2Object(String json, Type type) {
        return gson.fromJson(json, type);
    }
}
