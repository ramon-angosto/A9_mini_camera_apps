package com.aliyun.sls.android.producer;

import java.util.HashMap;
import java.util.Map;

public class Log {
    private Map<String, String> content = new HashMap();
    private long logTime = (System.currentTimeMillis() / 1000);

    public void putContent(String str, String str2) {
        this.content.put(str, str2);
    }

    public Map<String, String> getContent() {
        return this.content;
    }

    public long getLogTime() {
        return this.logTime;
    }

    public void setLogTime(long j) {
        this.logTime = j;
    }
}
