package com.shix.shixipc.widget;

public class VieoBean {
    int heigth;
    int iOrp;
    int len;
    byte[] video;
    int width;

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeigth() {
        return this.heigth;
    }

    public void setHeigth(int i) {
        this.heigth = i;
    }

    public byte[] getVideo() {
        return this.video;
    }

    public void setVideo(byte[] bArr) {
        this.video = bArr;
    }

    public int getiOrp() {
        return this.iOrp;
    }

    public void setiOrp(int i) {
        this.iOrp = i;
    }

    public int getLen() {
        return this.len;
    }

    public void setLen(int i) {
        this.len = i;
    }
}
