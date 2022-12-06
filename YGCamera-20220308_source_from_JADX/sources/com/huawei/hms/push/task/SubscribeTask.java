package com.huawei.hms.push.task;

public class SubscribeTask extends BaseVoidTask {
    public SubscribeTask(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public int getMinApkVersion() {
        return 40003000;
    }
}
