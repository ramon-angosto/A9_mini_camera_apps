package com.vungle.warren;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.vungle.warren.model.JsonUtil;

public class CleverCacheSettings {
    static final boolean DEFAULT_ENABLED = true;
    static final long DEFAULT_TIMESTAMP = -1;
    static final String KEY_CLEVER_CACHE = "clever_cache";
    static final String KEY_ENABLED = "enabled";
    static final String KEY_TIMESTAMP = "clear_shared_cache_timestamp";
    @SerializedName("enabled")
    private final boolean enabled;
    @SerializedName("clear_shared_cache_timestamp")
    private final long timestamp;

    private CleverCacheSettings(boolean z, long j) {
        this.enabled = z;
        this.timestamp = j;
    }

    public String serializeToString() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("clever_cache", new GsonBuilder().create().toJsonTree(this));
        return jsonObject.toString();
    }

    public static CleverCacheSettings fromJson(JsonObject jsonObject) {
        if (!JsonUtil.hasNonNull(jsonObject, "clever_cache")) {
            return null;
        }
        long j = -1;
        boolean z = true;
        JsonObject asJsonObject = jsonObject.getAsJsonObject("clever_cache");
        try {
            if (asJsonObject.has(KEY_TIMESTAMP)) {
                j = asJsonObject.get(KEY_TIMESTAMP).getAsLong();
            }
        } catch (NumberFormatException unused) {
        }
        if (asJsonObject.has(KEY_ENABLED)) {
            JsonElement jsonElement = asJsonObject.get(KEY_ENABLED);
            if (jsonElement.isJsonPrimitive() && "false".equalsIgnoreCase(jsonElement.getAsString())) {
                z = false;
            }
        }
        return new CleverCacheSettings(z, j);
    }

    static CleverCacheSettings deserializeFromString(String str) {
        if (str == null) {
            return null;
        }
        try {
            return fromJson((JsonObject) new GsonBuilder().create().fromJson(str, JsonObject.class));
        } catch (JsonSyntaxException unused) {
            return null;
        }
    }

    static CleverCacheSettings getDefault() {
        return new CleverCacheSettings(true, -1);
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CleverCacheSettings cleverCacheSettings = (CleverCacheSettings) obj;
        if (this.enabled != cleverCacheSettings.enabled) {
            return false;
        }
        if (this.timestamp == cleverCacheSettings.timestamp) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.timestamp;
        return ((this.enabled ? 1 : 0) * true) + ((int) (j ^ (j >>> 32)));
    }
}
