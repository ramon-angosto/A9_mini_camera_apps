package com.shix.shixipc.bean;

import java.io.Serializable;

public class CloudBean implements Serializable {
    private static final long serialVersionUID = 112;
    private String cloudPath;
    private String createTime;
    private String fileName;
    private String strDid;
    private int type;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getCloudPath() {
        return this.cloudPath;
    }

    public void setCloudPath(String str) {
        this.cloudPath = str;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public String getStrDid() {
        return this.strDid;
    }

    public void setStrDid(String str) {
        this.strDid = str;
    }
}
