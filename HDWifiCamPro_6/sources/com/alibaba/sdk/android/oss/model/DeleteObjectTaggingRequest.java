package com.alibaba.sdk.android.oss.model;

public class DeleteObjectTaggingRequest extends OSSRequest {
    private String bucketName;
    private String objectKey;

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public void setObjectKey(String str) {
        this.objectKey = str;
    }

    public DeleteObjectTaggingRequest(String str, String str2) {
        this.bucketName = str;
        this.objectKey = str2;
    }
}
