package com.shix.shixipc.bean;

public class AudioMode {
    private byte[] audio;
    private int len;
    private int sectime;

    public int getLen() {
        return this.len;
    }

    public void setLen(int i) {
        this.len = i;
    }

    public byte[] getAudio() {
        return this.audio;
    }

    public void setAudio(byte[] bArr) {
        this.audio = bArr;
    }

    public int getSectime() {
        return this.sectime;
    }

    public void setSectime(int i) {
        this.sectime = i;
    }
}
