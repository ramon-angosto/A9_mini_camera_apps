package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.common.utils.CaseInsensitiveHashMap;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public class ObjectMetadata {
    public static final String AES_256_SERVER_SIDE_ENCRYPTION = "AES256";
    private Map<String, Object> metadata = new CaseInsensitiveHashMap();
    private Map<String, String> userMetadata = new CaseInsensitiveHashMap();

    public Map<String, String> getUserMetadata() {
        return this.userMetadata;
    }

    public void setUserMetadata(Map<String, String> map) {
        this.userMetadata.clear();
        if (map != null && !map.isEmpty()) {
            this.userMetadata.putAll(map);
        }
    }

    public void setHeader(String str, Object obj) {
        this.metadata.put(str, obj);
    }

    public void addUserMetadata(String str, String str2) {
        this.userMetadata.put(str, str2);
    }

    public Date getLastModified() {
        return (Date) this.metadata.get(HttpHeaders.LAST_MODIFIED);
    }

    public void setLastModified(Date date) {
        this.metadata.put(HttpHeaders.LAST_MODIFIED, date);
    }

    public Date getExpirationTime() throws ParseException {
        return DateUtil.parseRfc822Date((String) this.metadata.get(HttpHeaders.EXPIRES));
    }

    public void setExpirationTime(Date date) {
        this.metadata.put(HttpHeaders.EXPIRES, DateUtil.formatRfc822Date(date));
    }

    public String getRawExpiresValue() {
        return (String) this.metadata.get(HttpHeaders.EXPIRES);
    }

    public long getContentLength() {
        Long l = (Long) this.metadata.get(HttpHeaders.CONTENT_LENGTH);
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    public void setContentLength(long j) {
        if (j <= OSSConstants.DEFAULT_FILE_SIZE_LIMIT) {
            this.metadata.put(HttpHeaders.CONTENT_LENGTH, Long.valueOf(j));
            return;
        }
        throw new IllegalArgumentException("The content length could not be more than 5GB.");
    }

    public String getContentType() {
        return (String) this.metadata.get(HttpHeaders.CONTENT_TYPE);
    }

    public void setContentType(String str) {
        this.metadata.put(HttpHeaders.CONTENT_TYPE, str);
    }

    public String getContentMD5() {
        return (String) this.metadata.get(HttpHeaders.CONTENT_MD5);
    }

    public void setContentMD5(String str) {
        this.metadata.put(HttpHeaders.CONTENT_MD5, str);
    }

    public String getSHA1() {
        return (String) this.metadata.get(OSSHeaders.OSS_HASH_SHA1);
    }

    public void setSHA1(String str) {
        this.metadata.put(OSSHeaders.OSS_HASH_SHA1, str);
    }

    public String getContentEncoding() {
        return (String) this.metadata.get(HttpHeaders.CONTENT_ENCODING);
    }

    public void setContentEncoding(String str) {
        this.metadata.put(HttpHeaders.CONTENT_ENCODING, str);
    }

    public String getCacheControl() {
        return (String) this.metadata.get(HttpHeaders.CACHE_CONTROL);
    }

    public void setCacheControl(String str) {
        this.metadata.put(HttpHeaders.CACHE_CONTROL, str);
    }

    public String getContentDisposition() {
        return (String) this.metadata.get(HttpHeaders.CONTENT_DISPOSITION);
    }

    public void setContentDisposition(String str) {
        this.metadata.put(HttpHeaders.CONTENT_DISPOSITION, str);
    }

    public String getETag() {
        return (String) this.metadata.get(HttpHeaders.ETAG);
    }

    public String getServerSideEncryption() {
        return (String) this.metadata.get(OSSHeaders.OSS_SERVER_SIDE_ENCRYPTION);
    }

    public void setServerSideEncryption(String str) {
        this.metadata.put(OSSHeaders.OSS_SERVER_SIDE_ENCRYPTION, str);
    }

    public String getObjectType() {
        return (String) this.metadata.get(OSSHeaders.OSS_OBJECT_TYPE);
    }

    public Map<String, Object> getRawMetadata() {
        return Collections.unmodifiableMap(this.metadata);
    }

    public String toString() {
        String str;
        try {
            str = getExpirationTime().toString();
        } catch (Exception unused) {
            str = "";
        }
        return "Last-Modified:" + getLastModified() + "\n" + HttpHeaders.EXPIRES + Constants.COLON_SEPARATOR + str + "\nrawExpires:" + getRawExpiresValue() + "\n" + HttpHeaders.CONTENT_MD5 + Constants.COLON_SEPARATOR + getContentMD5() + "\n" + OSSHeaders.OSS_OBJECT_TYPE + Constants.COLON_SEPARATOR + getObjectType() + "\n" + OSSHeaders.OSS_SERVER_SIDE_ENCRYPTION + Constants.COLON_SEPARATOR + getServerSideEncryption() + "\n" + HttpHeaders.CONTENT_DISPOSITION + Constants.COLON_SEPARATOR + getContentDisposition() + "\n" + HttpHeaders.CONTENT_ENCODING + Constants.COLON_SEPARATOR + getContentEncoding() + "\n" + HttpHeaders.CACHE_CONTROL + Constants.COLON_SEPARATOR + getCacheControl() + "\n" + HttpHeaders.ETAG + Constants.COLON_SEPARATOR + getETag() + "\n";
    }
}
