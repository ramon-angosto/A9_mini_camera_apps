package com.shix.shixipc.utils;

import com.shix.shixipc.bean.AudioMode;
import java.util.LinkedList;
import java.util.List;

public class AudioCustomBuffer {
    private List<AudioMode> DataBuffer = new LinkedList();

    public boolean addData(AudioMode audioMode) {
        synchronized (this) {
            this.DataBuffer.add(audioMode);
        }
        return true;
    }

    public AudioMode RemoveData() {
        synchronized (this) {
            if (this.DataBuffer.isEmpty()) {
                return null;
            }
            AudioMode remove = this.DataBuffer.remove(0);
            return remove;
        }
    }

    public int SIZE() {
        int size;
        synchronized (this) {
            size = this.DataBuffer.size();
        }
        return size;
    }

    public void ClearAll() {
        synchronized (this) {
            this.DataBuffer.clear();
        }
    }
}
