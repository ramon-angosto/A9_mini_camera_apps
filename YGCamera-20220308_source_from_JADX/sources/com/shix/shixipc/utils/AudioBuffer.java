package com.shix.shixipc.utils;

import java.util.LinkedList;
import java.util.List;

public class AudioBuffer {
    private List<byte[]> DataBuffer;
    private byte[] data;
    private int size;

    public AudioBuffer() {
        this.DataBuffer = null;
        this.DataBuffer = new LinkedList();
    }

    public boolean addAudioData(byte[] bArr) {
        synchronized (this) {
            this.DataBuffer.add(bArr);
        }
        return true;
    }

    public byte[] RemoveAudioData() {
        synchronized (this) {
            if (this.DataBuffer.isEmpty()) {
                return null;
            }
            byte[] remove = this.DataBuffer.remove(0);
            return remove;
        }
    }

    public void ClearAudioAll() {
        synchronized (this) {
            this.DataBuffer.clear();
        }
    }

    public AudioBuffer(byte[] bArr, int i) {
        this.DataBuffer = null;
        this.data = bArr;
        this.size = i;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getSize() {
        return this.size;
    }
}
