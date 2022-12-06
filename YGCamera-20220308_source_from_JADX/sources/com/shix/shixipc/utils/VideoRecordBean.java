package com.shix.shixipc.utils;

import android.graphics.Bitmap;

public class VideoRecordBean {
    private Bitmap bitmap;
    private int height;
    private byte[] length;
    private byte[] picture;
    private byte[] time;
    private int tspan;
    private int type;
    private int width;

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

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public void setBitmap(Bitmap bitmap2) {
        this.bitmap = bitmap2;
    }

    public int getTspan() {
        return this.tspan;
    }

    public void setTspan(int i) {
        this.tspan = i;
    }

    public byte[] getLength() {
        return this.length;
    }

    public void setLength(byte[] bArr) {
        this.length = bArr;
    }

    public byte[] getTime() {
        return this.time;
    }

    public void setTime(byte[] bArr) {
        this.time = bArr;
    }

    public byte[] getPicture() {
        return this.picture;
    }

    public void setPicture(byte[] bArr) {
        this.picture = bArr;
    }
}
