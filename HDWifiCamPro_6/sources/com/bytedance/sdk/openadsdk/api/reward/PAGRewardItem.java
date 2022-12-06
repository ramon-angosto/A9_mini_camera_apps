package com.bytedance.sdk.openadsdk.api.reward;

public class PAGRewardItem {
    private int a;
    private String b;

    public PAGRewardItem(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public int getRewardAmount() {
        return this.a;
    }

    public String getRewardName() {
        return this.b;
    }
}
