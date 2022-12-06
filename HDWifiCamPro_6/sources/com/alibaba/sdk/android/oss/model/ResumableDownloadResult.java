package com.alibaba.sdk.android.oss.model;

public class ResumableDownloadResult extends OSSResult {
    private ObjectMetadata metadata;

    public ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public void setMetadata(ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }
}
