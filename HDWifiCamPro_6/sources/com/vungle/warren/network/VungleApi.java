package com.vungle.warren.network;

import com.google.gson.JsonObject;
import java.util.Map;

public interface VungleApi {
    Call<JsonObject> ads(String str, String str2, JsonObject jsonObject);

    Call<JsonObject> cacheBust(String str, String str2, JsonObject jsonObject);

    Call<JsonObject> config(String str, JsonObject jsonObject);

    Call<Void> pingTPAT(String str, String str2);

    Call<JsonObject> reportAd(String str, String str2, JsonObject jsonObject);

    Call<JsonObject> reportNew(String str, String str2, Map<String, String> map);

    Call<JsonObject> ri(String str, String str2, JsonObject jsonObject);

    Call<JsonObject> sendBiAnalytics(String str, String str2, JsonObject jsonObject);

    Call<JsonObject> sendLog(String str, String str2, JsonObject jsonObject);

    Call<JsonObject> willPlayAd(String str, String str2, JsonObject jsonObject);
}
