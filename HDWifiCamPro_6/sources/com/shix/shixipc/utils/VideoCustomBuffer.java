package com.shix.shixipc.utils;

import com.shix.shixipc.bean.VideoPlayBackMode;
import java.util.LinkedList;
import java.util.List;

public class VideoCustomBuffer {
    private List<VideoPlayBackMode> DataBuffer = new LinkedList();

    public boolean addData(VideoPlayBackMode videoPlayBackMode) {
        synchronized (this) {
            this.DataBuffer.add(videoPlayBackMode);
        }
        return true;
    }

    public VideoPlayBackMode RemoveData() {
        synchronized (this) {
            if (this.DataBuffer.isEmpty()) {
                return null;
            }
            VideoPlayBackMode remove = this.DataBuffer.remove(0);
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
