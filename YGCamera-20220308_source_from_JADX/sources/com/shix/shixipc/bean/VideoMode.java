package com.shix.shixipc.bean;

public class VideoMode {
    private int type;
    private byte[] video;

    public byte[] getVideo() {
        return this.video;
    }

    public void setVideo(byte[] bArr) {
        this.video = bArr;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
