package com.shix.shixipc.utils;

import android.media.AudioTrack;
import android.util.Log;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import java.io.PrintStream;

public class AudioPlayer {
    CustomBuffer audioBuffer = null;
    private Thread audioThread = null;
    /* access modifiers changed from: private */
    public boolean bAudioPlaying = false;
    /* access modifiers changed from: private */
    public AudioTrack m_AudioTrack = null;

    public AudioPlayer(CustomBuffer customBuffer) {
        this.audioBuffer = customBuffer;
    }

    public boolean isAudioPlaying() {
        return this.bAudioPlaying;
    }

    public boolean AudioPlayStart() {
        synchronized (this) {
            if (this.bAudioPlaying) {
                return true;
            }
            this.bAudioPlaying = true;
            this.audioThread = new Thread(new AudioPlayThread());
            this.audioThread.start();
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0018, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void AudioPlayStop() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.bAudioPlaying     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0017
            java.lang.Thread r0 = r1.audioThread     // Catch:{ all -> 0x0019 }
            if (r0 != 0) goto L_0x000a
            goto L_0x0017
        L_0x000a:
            r0 = 0
            r1.bAudioPlaying = r0     // Catch:{ all -> 0x0019 }
            java.lang.Thread r0 = r1.audioThread     // Catch:{ Exception -> 0x0012 }
            r0.join()     // Catch:{ Exception -> 0x0012 }
        L_0x0012:
            r0 = 0
            r1.audioThread = r0     // Catch:{ all -> 0x0019 }
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            return
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            return
        L_0x0019:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.utils.AudioPlayer.AudioPlayStop():void");
    }

    public boolean initAudioDev() {
        Log.d(RemoteMessageConst.Notification.TAG, "??????????????AudioTrack");
        int minBufferSize = AudioTrack.getMinBufferSize(JosStatusCodes.RTN_CODE_COMMON_ERROR, 2, 2);
        PrintStream printStream = System.out;
        printStream.println("--audio, mMinBufSize=" + minBufferSize);
        if (!(minBufferSize == -2 || minBufferSize == -1)) {
            try {
                this.m_AudioTrack = new AudioTrack(3, JosStatusCodes.RTN_CODE_COMMON_ERROR, 2, 2, minBufferSize * 2, 1);
                this.m_AudioTrack.play();
                return true;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    class AudioPlayThread implements Runnable {
        AudioPlayThread() {
        }

        public void run() {
            if (!AudioPlayer.this.initAudioDev()) {
                Log.d(RemoteMessageConst.Notification.TAG, "??????????????audioTrack????????");
                return;
            }
            while (AudioPlayer.this.bAudioPlaying) {
                CustomBufferData RemoveData = AudioPlayer.this.audioBuffer.RemoveData();
                if (RemoveData == null) {
                    try {
                        Thread.sleep(50);
                    } catch (Exception unused) {
                        AudioPlayer.this.m_AudioTrack.stop();
                        return;
                    }
                } else {
                    AudioPlayer.this.m_AudioTrack.write(RemoveData.data, 0, RemoveData.head.length);
                }
            }
            Log.d(RemoteMessageConst.Notification.TAG, "stop/release Audio");
            AudioPlayer.this.m_AudioTrack.stop();
            AudioPlayer.this.m_AudioTrack.release();
            AudioTrack unused2 = AudioPlayer.this.m_AudioTrack = null;
        }
    }
}
