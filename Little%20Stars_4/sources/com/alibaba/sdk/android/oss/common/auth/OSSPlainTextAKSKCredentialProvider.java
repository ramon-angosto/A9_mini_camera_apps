package com.alibaba.sdk.android.oss.common.auth;

public class OSSPlainTextAKSKCredentialProvider extends OSSCredentialProvider {
    private String accessKeyId;
    private String accessKeySecret;

    public OSSPlainTextAKSKCredentialProvider(String str, String str2) {
        this.accessKeyId = str;
        this.accessKeySecret = str2;
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    public void setAccessKeySecret(String str) {
        this.accessKeySecret = str;
    }
}
