package com.tzh.ipcamera.model;

import java.util.LinkedList;
import java.util.List;

public class CustomBuffer {
    private static CustomBuffer buffer;
    private List<CustomBufferData> DataBuffer = new LinkedList();

    public static CustomBuffer getInstance() {
        if (buffer == null) {
            buffer = new CustomBuffer();
        }
        return buffer;
    }

    public boolean addData(CustomBufferData customBufferData) {
        synchronized (this) {
            this.DataBuffer.add(customBufferData);
        }
        return true;
    }

    public boolean addShortData(CustomBufferData customBufferData) {
        synchronized (this) {
            this.DataBuffer.add(customBufferData);
        }
        return true;
    }

    public CustomBufferData RemoveData() {
        CustomBufferData remove;
        synchronized (this) {
            remove = this.DataBuffer.isEmpty() ? null : this.DataBuffer.remove(0);
        }
        return remove;
    }

    public void ClearAll() {
        synchronized (this) {
            this.DataBuffer.clear();
        }
    }
}
