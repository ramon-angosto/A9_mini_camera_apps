package object.p2pipcam.utils;

import java.util.LinkedList;
import java.util.List;

public class AudioBuffer {
    private List<byte[]> DataBuffer;

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
}
