package com.vungle.warren.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonUtil {
    public static boolean hasNonNull(JsonElement jsonElement, String str) {
        if (jsonElement == null || jsonElement.isJsonNull() || !jsonElement.isJsonObject()) {
            return false;
        }
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        if (!asJsonObject.has(str) || asJsonObject.get(str) == null || asJsonObject.get(str).isJsonNull()) {
            return false;
        }
        return true;
    }

    public static boolean getAsBoolean(JsonElement jsonElement, String str, boolean z) {
        return hasNonNull(jsonElement, str) ? jsonElement.getAsJsonObject().get(str).getAsBoolean() : z;
    }

    public static String getAsString(JsonElement jsonElement, String str, String str2) {
        return hasNonNull(jsonElement, str) ? jsonElement.getAsJsonObject().get(str).getAsString() : str2;
    }

    public static int getAsInt(JsonElement jsonElement, String str, int i) {
        return hasNonNull(jsonElement, str) ? jsonElement.getAsJsonObject().get(str).getAsInt() : i;
    }

    public static JsonObject getAsObject(JsonElement jsonElement, String str) {
        if (hasNonNull(jsonElement, str)) {
            return jsonElement.getAsJsonObject().get(str).getAsJsonObject();
        }
        return null;
    }
}
