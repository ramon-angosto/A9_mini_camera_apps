package com.tzh.ipcamera.presenter;

import android.content.Context;
import com.tzh.ipcamera.model.CustomBuffer;
import com.tzh.ipcamera.model.CustomBufferData;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.utils.AudioPlayer;

public class Audio {
    private CustomBuffer AudioBuffer = null;
    private int AudioOrTalkType = 0;
    private AudioPlayer audioPlayer = null;
    private Context mContext;
    private String strDID = "";

    public Audio(Context context, String str, int i) {
        this.mContext = context;
        this.strDID = str;
        this.AudioBuffer = new CustomBuffer();
        this.AudioOrTalkType = i;
    }

    public void startAudio() {
        synchronized (this) {
            this.AudioBuffer.ClearAll();
            if (this.audioPlayer != null) {
                this.audioPlayer.AudioPlayStart();
            }
            NativeCaller.PPPPStartAudio(this.strDID);
        }
    }

    public boolean isAudioPlaying() {
        AudioPlayer audioPlayer2 = this.audioPlayer;
        return audioPlayer2 != null && !audioPlayer2.isAudioPlaying();
    }

    public void putData(CustomBufferData customBufferData) {
        CustomBuffer customBuffer = this.AudioBuffer;
        if (customBuffer != null) {
            customBuffer.addData(customBufferData);
        }
    }

    public void stopAudio() {
        synchronized (this) {
            if (this.audioPlayer != null) {
                this.audioPlayer.AudioPlayStop();
            }
            this.AudioBuffer.ClearAll();
            NativeCaller.PPPPStopAudio(this.strDID);
        }
    }
}
