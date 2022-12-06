package com.alibaba.sdk.android.oss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.OkHttpClient;

public class ClientConfiguration {
    private static final int DEFAULT_MAX_RETRIES = 2;
    private boolean checkCRC64 = false;
    private int connectionTimeout = 60000;
    private List<String> customCnameExcludeList = new ArrayList();
    private boolean customPathPrefixEnable = false;
    private boolean followRedirectsEnable = false;
    private boolean httpDnsEnable = false;
    private String ipWithHeader;
    private String mUserAgentMark;
    private int maxConcurrentRequest = 5;
    private int maxErrorRetry = 2;
    private long max_log_size = 5242880;
    private OkHttpClient okHttpClient = null;
    private boolean pathStyleAccessEnable = false;
    private String proxyHost;
    private int proxyPort;
    private int socketTimeout = 60000;

    public static ClientConfiguration getDefaultConf() {
        return new ClientConfiguration();
    }

    public int getMaxConcurrentRequest() {
        return this.maxConcurrentRequest;
    }

    public void setMaxConcurrentRequest(int i) {
        this.maxConcurrentRequest = i;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }

    public void setSocketTimeout(int i) {
        this.socketTimeout = i;
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public void setConnectionTimeout(int i) {
        this.connectionTimeout = i;
    }

    public long getMaxLogSize() {
        return this.max_log_size;
    }

    public void setMaxLogSize(long j) {
        this.max_log_size = j;
    }

    public int getMaxErrorRetry() {
        return this.maxErrorRetry;
    }

    public void setMaxErrorRetry(int i) {
        this.maxErrorRetry = i;
    }

    public List<String> getCustomCnameExcludeList() {
        return Collections.unmodifiableList(this.customCnameExcludeList);
    }

    public void setCustomCnameExcludeList(List<String> list) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("cname exclude list should not be null.");
        }
        this.customCnameExcludeList.clear();
        for (String next : list) {
            if (next.contains("://")) {
                this.customCnameExcludeList.add(next.substring(next.indexOf("://") + 3));
            } else {
                this.customCnameExcludeList.add(next);
            }
        }
    }

    public String getProxyHost() {
        return this.proxyHost;
    }

    public void setProxyHost(String str) {
        this.proxyHost = str;
    }

    public int getProxyPort() {
        return this.proxyPort;
    }

    public void setProxyPort(int i) {
        this.proxyPort = i;
    }

    public String getCustomUserMark() {
        return this.mUserAgentMark;
    }

    public void setUserAgentMark(String str) {
        this.mUserAgentMark = str;
    }

    public boolean isHttpDnsEnable() {
        return this.httpDnsEnable;
    }

    public void setHttpDnsEnable(boolean z) {
        this.httpDnsEnable = z;
    }

    public boolean isCheckCRC64() {
        return this.checkCRC64;
    }

    public void setCheckCRC64(boolean z) {
        this.checkCRC64 = z;
    }

    public String getIpWithHeader() {
        return this.ipWithHeader;
    }

    public void setIpWithHeader(String str) {
        this.ipWithHeader = str;
    }

    public boolean isPathStyleAccessEnable() {
        return this.pathStyleAccessEnable;
    }

    public void setPathStyleAccessEnable(boolean z) {
        this.pathStyleAccessEnable = z;
    }

    public boolean isCustomPathPrefixEnable() {
        return this.customPathPrefixEnable;
    }

    public void setCustomPathPrefixEnable(boolean z) {
        this.customPathPrefixEnable = z;
    }

    public boolean isFollowRedirectsEnable() {
        return this.followRedirectsEnable;
    }

    public void setFollowRedirectsEnable(boolean z) {
        this.followRedirectsEnable = z;
    }

    public OkHttpClient getOkHttpClient() {
        return this.okHttpClient;
    }

    public void setOkHttpClient(OkHttpClient okHttpClient2) {
        this.okHttpClient = okHttpClient2;
    }
}
