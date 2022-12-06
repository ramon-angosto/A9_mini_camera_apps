package object.p2pipcam.utils;

import java.util.LinkedList;
import java.util.List;

public class VideoBuffer {
    private List<byte[]> DataBuffer;

    public VideoBuffer() {
        this.DataBuffer = null;
        this.DataBuffer = new LinkedList();
    }

    public boolean addData(byte[] bArr) {
        synchronized (this) {
            this.DataBuffer.add(bArr);
        }
        return true;
    }

    public byte[] RemoveData() {
        synchronized (this) {
            if (this.DataBuffer.isEmpty()) {
                return null;
            }
            byte[] remove = this.DataBuffer.remove(0);
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
