package com.shix.shixipc.utils;

import java.util.LinkedList;
import java.util.List;

public class CustomBuffer {
    private List<CustomBufferData> DataBuffer = new LinkedList();

    public boolean addData(CustomBufferData customBufferData) {
        synchronized (this) {
            this.DataBuffer.add(customBufferData);
        }
        return true;
    }

    public CustomBufferData RemoveData() {
        synchronized (this) {
            if (this.DataBuffer.isEmpty()) {
                return null;
            }
            CustomBufferData remove = this.DataBuffer.remove(0);
            return remove;
        }
    }

    public void ClearAll() {
        synchronized (this) {
            this.DataBuffer.clear();
        }
    }
}
