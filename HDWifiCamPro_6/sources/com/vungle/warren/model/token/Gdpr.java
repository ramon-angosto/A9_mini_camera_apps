package com.vungle.warren.model.token;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Gdpr {
    public static final String OPTED_IN = "opted_in";
    public static final String OPTED_OUT = "opted_out";
    public static final String OPTED_OUT_BY_TIMEOUT = "opted_out_by_timeout";
    public static final String UNKNOWN = "unknown";
    @SerializedName("message_version")
    @Expose
    private String messageVersion;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("timestamp")
    @Expose
    private Long timestamp;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
    }

    public String getStatus() {
        return this.status;
    }

    public String getSource() {
        return this.source;
    }

    public String getMessageVersion() {
        return this.messageVersion;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public Gdpr(String str, String str2, String str3, Long l) {
        this.status = str;
        this.source = str2;
        this.messageVersion = str3;
        this.timestamp = l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Gdpr gdpr = (Gdpr) obj;
        if (!this.status.equals(gdpr.status) || !this.source.equals(gdpr.source) || !this.messageVersion.equals(gdpr.messageVersion) || !this.timestamp.equals(gdpr.timestamp)) {
            return false;
        }
        return true;
    }
}
