package object.p2pipcam.utils;

import android.media.AudioRecord;
import android.util.Log;

public class CustomAudioRecorder {
    /* access modifiers changed from: private */
    public AudioRecordResult audioResult = null;
    /* access modifiers changed from: private */
    public boolean bRecordThreadRuning = false;
    /* access modifiers changed from: private */
    public int m_in_buf_size = 0;
    /* access modifiers changed from: private */
    public byte[] m_in_bytes = null;
    /* access modifiers changed from: private */
    public AudioRecord m_in_rec = null;
    private Thread recordThread = null;

    public interface AudioRecordResult {
        void AudioRecordData(byte[] bArr, int i);
    }

    public CustomAudioRecorder(AudioRecordResult audioRecordResult) {
        this.audioResult = audioRecordResult;
        initRecorder();
    }

    public void StartRecord() {
        synchronized (this) {
            Log.d("tag", "startRecord");
            if (this.bRecordThreadRuning) {
                Log.d("tag", "is startRecord");
                return;
            }
            Log.d("tag", "begin startRecord");
            this.bRecordThreadRuning = true;
            this.recordThread = new Thread(new RecordThread());
            this.recordThread.start();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:6|7|8|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void StopRecord() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.bRecordThreadRuning     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r2)     // Catch:{ all -> 0x0018 }
            return
        L_0x0007:
            r0 = 0
            r2.bRecordThreadRuning = r0     // Catch:{ all -> 0x0018 }
            java.lang.Thread r0 = r2.recordThread     // Catch:{ Exception -> 0x0016 }
            r0.join()     // Catch:{ Exception -> 0x0016 }
            java.lang.String r0 = "tag"
            java.lang.String r1 = "stopRecord()"
            android.util.Log.d(r0, r1)     // Catch:{ Exception -> 0x0016 }
        L_0x0016:
            monitor-exit(r2)     // Catch:{ all -> 0x0018 }
            return
        L_0x0018:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: object.p2pipcam.utils.CustomAudioRecorder.StopRecord():void");
    }

    public void releaseRecord() {
        Log.d("tag", "releaseRecord");
        AudioRecord audioRecord = this.m_in_rec;
        if (audioRecord != null) {
            audioRecord.release();
            this.m_in_rec = null;
        }
    }

    public boolean initRecorder() {
        this.m_in_buf_size = AudioRecord.getMinBufferSize(8000, 2, 2);
        this.m_in_rec = new AudioRecord(1, 8000, 2, 2, this.m_in_buf_size);
        if (this.m_in_rec == null) {
            return false;
        }
        this.m_in_bytes = new byte[this.m_in_buf_size];
        return true;
    }

    class RecordThread implements Runnable {
        RecordThread() {
        }

        public void run() {
            CustomAudioRecorder.this.m_in_rec.startRecording();
            while (CustomAudioRecorder.this.bRecordThreadRuning) {
                int read = CustomAudioRecorder.this.m_in_rec.read(CustomAudioRecorder.this.m_in_bytes, 0, CustomAudioRecorder.this.m_in_buf_size);
                if (read != 0) {
                    Log.d("tag", "read audio");
                    if (CustomAudioRecorder.this.audioResult != null) {
                        CustomAudioRecorder.this.audioResult.AudioRecordData(CustomAudioRecorder.this.m_in_bytes, read);
                    }
                } else {
                    return;
                }
            }
            CustomAudioRecorder.this.m_in_rec.stop();
        }
    }
}
