package com.mbridge.msdk.foundation.download;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DownloadMessage<T> {
    private T campaign;
    private boolean checkMD5 = false;
    private int downloadRate = 100;
    private DownloadResourceType downloadResourceType;
    private String downloadUrl;
    private Map<String, Object> extraData;
    private String md5 = "";
    private String resourceUrl;
    private String saveFileName;
    private String saveFilePath;

    public DownloadMessage(T t, String str, String str2, int i, DownloadResourceType downloadResourceType2) {
        this.campaign = t;
        this.downloadUrl = str;
        this.saveFileName = str2;
        this.downloadRate = i;
        this.downloadResourceType = downloadResourceType2;
        try {
            URL url = new URL(str);
            this.resourceUrl = url.getProtocol() + "://" + url.getHost() + url.getPath();
        } catch (MalformedURLException unused) {
            this.resourceUrl = "";
        }
    }

    public T getCampaign() {
        return this.campaign;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getSaveFileName() {
        return this.saveFileName;
    }

    public String getMd5() {
        return this.md5;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public boolean isCheckMD5() {
        return this.checkMD5;
    }

    public void setCheckMD5(boolean z) {
        this.checkMD5 = z;
    }

    public int getDownloadRate() {
        return this.downloadRate;
    }

    public void setDownloadRate(int i) {
        this.downloadRate = i;
    }

    public void addExtra(String str, Object obj) {
        if (this.extraData == null) {
            this.extraData = new HashMap(4);
        }
        this.extraData.put(str, obj);
    }

    public Object getExtra(String str) {
        Map<String, Object> map = this.extraData;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.extraData.get(str);
    }

    public DownloadResourceType getDownloadResourceType() {
        return this.downloadResourceType;
    }

    public String getSaveFilePath() {
        return this.saveFilePath;
    }

    public void setSaveFilePath(String str) {
        this.saveFilePath = str;
    }

    public String getResourceUrl() {
        return this.resourceUrl;
    }
}
