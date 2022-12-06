package com.shix.shixipc.utils;

import com.shix.shixipc.bean.VideoMode;
import java.util.LinkedList;
import java.util.List;

public class HardVideoBuffer {
    private List<VideoMode> DataBuffer;

    public HardVideoBuffer() {
        this.DataBuffer = null;
        this.DataBuffer = new LinkedList();
    }

    public boolean addData(byte[] bArr, int i) {
        synchronized (this) {
            VideoMode videoMode = new VideoMode();
            videoMode.setType(i);
            videoMode.setVideo(bArr);
            this.DataBuffer.add(videoMode);
        }
        return true;
    }

    public VideoMode RemoveData() {
        synchronized (this) {
            if (this.DataBuffer.isEmpty()) {
                return null;
            }
            VideoMode remove = this.DataBuffer.remove(0);
            return remove;
        }
    }

    public int size() {
        return this.DataBuffer.size();
    }

    public void ClearAll() {
        synchronized (this) {
            this.DataBuffer.clear();
        }
    }
}
