package com.vungle.warren.analytics;

import com.google.gson.JsonObject;

public interface AdAnalytics {
    String[] ping(String[] strArr);

    String[] retryUnsent();

    void ri(JsonObject jsonObject);

    void saveVungleUrls(String[] strArr);
}
