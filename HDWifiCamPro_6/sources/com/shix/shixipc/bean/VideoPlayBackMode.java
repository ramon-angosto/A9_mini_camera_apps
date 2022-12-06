package com.shix.shixipc.bean;

public class VideoPlayBackMode {
    private int height;
    private int len;
    private int sectime;
    private int type;
    private byte[] video;
    private int width;

    public byte[] getVideo() {
        return this.video;
    }

    public void setVideo(byte[] bArr) {
        this.video = bArr;
    }

    public int getSectime() {
        return this.sectime;
    }

    public void setSectime(int i) {
        this.sectime = i;
    }

    public int getLen() {
        return this.len;
    }

    public void setLen(int i) {
        this.len = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }
}
