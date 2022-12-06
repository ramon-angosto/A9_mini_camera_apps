package com.bytedance.sdk.openadsdk.api;

import java.util.Map;

public class PAGRequest {
    private String a;
    private Map<String, Object> b;

    public String getAdString() {
        return this.a;
    }

    public void setAdString(String str) {
        this.a = str;
    }

    public Map<String, Object> getExtraInfo() {
        return this.b;
    }

    public void setExtraInfo(Map<String, Object> map) {
        this.b = map;
    }
}
