package com.bytedance.sdk.openadsdk.api.open;

import com.bytedance.sdk.openadsdk.api.PAGRequest;

public class PAGAppOpenRequest extends PAGRequest {
    private int a;

    public int getTimeout() {
        return this.a;
    }

    public void setTimeout(int i) {
        this.a = i;
    }
}
