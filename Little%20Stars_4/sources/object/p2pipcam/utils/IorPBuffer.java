package object.p2pipcam.utils;

import java.util.LinkedList;
import java.util.List;

public class IorPBuffer {
    private List<Integer> DataBuffer;

    public IorPBuffer() {
        this.DataBuffer = null;
        this.DataBuffer = new LinkedList();
    }

    public boolean addData(int i) {
        synchronized (this) {
            this.DataBuffer.add(Integer.valueOf(i));
        }
        return true;
    }

    public int RemoveData() {
        synchronized (this) {
            if (this.DataBuffer.isEmpty()) {
                return 0;
            }
            int intValue = this.DataBuffer.remove(0).intValue();
            return intValue;
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
