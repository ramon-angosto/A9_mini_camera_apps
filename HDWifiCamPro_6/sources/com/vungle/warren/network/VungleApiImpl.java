package com.vungle.warren.network;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.gson.JsonObject;
import com.vungle.warren.network.converters.Converter;
import com.vungle.warren.network.converters.EmptyResponseConverter;
import com.vungle.warren.network.converters.JsonConverter;
import java.util.Map;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class VungleApiImpl implements VungleApi {
    private static final String CONFIG = "config";
    private static final Converter<ResponseBody, Void> emptyResponseConverter = new EmptyResponseConverter();
    private static final Converter<ResponseBody, JsonObject> jsonConverter = new JsonConverter();
    String appId;
    HttpUrl baseUrl;
    Call.Factory okHttpClient;

    public VungleApiImpl(HttpUrl httpUrl, Call.Factory factory) {
        this.baseUrl = httpUrl;
        this.okHttpClient = factory;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public Call<JsonObject> config(String str, JsonObject jsonObject) {
        return createNewPostCall(str, this.baseUrl.toString() + CONFIG, jsonObject);
    }

    public Call<JsonObject> reportNew(String str, String str2, Map<String, String> map) {
        return createNewGetCall(str, str2, map, jsonConverter);
    }

    public Call<JsonObject> ads(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }

    public Call<JsonObject> willPlayAd(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }

    public Call<JsonObject> ri(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }

    public Call<JsonObject> reportAd(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }

    public Call<JsonObject> sendLog(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }

    public Call<Void> pingTPAT(String str, String str2) {
        return createNewGetCall(str, str2, (Map<String, String>) null, emptyResponseConverter);
    }

    public Call<JsonObject> cacheBust(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }

    public Call<JsonObject> sendBiAnalytics(String str, String str2, JsonObject jsonObject) {
        return createNewPostCall(str, str2, jsonObject);
    }

    private Call<JsonObject> createNewPostCall(String str, String str2, JsonObject jsonObject) {
        return new OkHttpCall(this.okHttpClient.newCall(defaultBuilder(str, str2).post(RequestBody.create((MediaType) null, jsonObject != null ? jsonObject.toString() : "")).build()), jsonConverter);
    }

    private <T> Call<T> createNewGetCall(String str, String str2, Map<String, String> map, Converter<ResponseBody, T> converter) {
        HttpUrl.Builder newBuilder = HttpUrl.get(str2).newBuilder();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                newBuilder.addQueryParameter((String) next.getKey(), (String) next.getValue());
            }
        }
        return new OkHttpCall(this.okHttpClient.newCall(defaultBuilder(str, newBuilder.build().toString()).get().build()), converter);
    }

    private Request.Builder defaultBuilder(String str, String str2) {
        Request.Builder addHeader = new Request.Builder().url(str2).addHeader("User-Agent", str).addHeader("Vungle-Version", "5.10.0").addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        if (!TextUtils.isEmpty(this.appId)) {
            addHeader.addHeader("X-Vungle-App-Id", this.appId);
        }
        return addHeader;
    }
}
