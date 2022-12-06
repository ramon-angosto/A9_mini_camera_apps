package com.unad.sdk.dto;

public class AdError {
    private String code;
    private String message;

    public AdError() {
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public AdError(String str, String str2) {
        this.code = str;
        this.message = str2;
    }
}
