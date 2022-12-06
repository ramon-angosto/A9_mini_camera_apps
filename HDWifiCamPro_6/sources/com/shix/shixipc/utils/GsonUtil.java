package com.shix.shixipc.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class GsonUtil {
    private static Gson gson = new Gson();

    private GsonUtil() {
    }

    public static String beanToString(Object obj) {
        Gson gson2 = gson;
        if (gson2 != null) {
            return gson2.toJson(obj);
        }
        return null;
    }

    public static <T> T stringToBean(String str, Class<T> cls) {
        Gson gson2 = gson;
        if (gson2 != null) {
            return gson2.fromJson(str, cls);
        }
        return null;
    }

    public static <T> ArrayList<T> stringToList(String str, Class<T> cls) {
        ArrayList<T> arrayList = new ArrayList<>();
        if (gson != null) {
            Iterator<JsonElement> it = new JsonParser().parse(str).getAsJsonArray().iterator();
            while (it.hasNext()) {
                arrayList.add(gson.fromJson(it.next(), cls));
            }
        }
        return arrayList;
    }

    public static <T> ArrayList<T> stringToList(String str) {
        Gson gson2 = gson;
        if (gson2 != null) {
            return (ArrayList) gson2.fromJson(str, new TypeToken<ArrayList<T>>() {
            }.getType());
        }
        return null;
    }

    public static <T> Map<String, T> stringToMaps(String str, Class<T> cls) {
        Gson gson2 = gson;
        if (gson2 != null) {
            return (Map) gson2.fromJson(str, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return null;
    }
}
