package com.tzh.ipcamera.presenter;

import android.content.Context;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.utils.CustomAudioRecorder;

public class Speech {
    private int audioOrTalkType = 0;
    private CustomAudioRecorder customAudioRecorder = null;
    private Context mContext = null;

    public Speech(Context context, CustomAudioRecorder.AudioRecordResult audioRecordResult, int i) {
        this.mContext = context;
        this.audioOrTalkType = i;
        this.customAudioRecorder = new CustomAudioRecorder(audioRecordResult);
    }

    public void startTalk(String str) {
        int i = this.audioOrTalkType;
        if (i == 0 || i == 1) {
            NativeCaller.PPPPStartTalk(str);
            return;
        }
        CustomAudioRecorder customAudioRecorder2 = this.customAudioRecorder;
        if (customAudioRecorder2 != null) {
            customAudioRecorder2.StartRecord();
            NativeCaller.PPPPStartTalk(str);
        }
    }

    public void stopTalk(String str) {
        int i = this.audioOrTalkType;
        if (i == 0 || i == 1) {
            NativeCaller.PPPPStopTalk(str);
            return;
        }
        CustomAudioRecorder customAudioRecorder2 = this.customAudioRecorder;
        if (customAudioRecorder2 != null) {
            customAudioRecorder2.StopRecord();
            NativeCaller.PPPPStopTalk(str);
        }
    }

    public void releaseTalk() {
        CustomAudioRecorder customAudioRecorder2;
        int i = this.audioOrTalkType;
        if (i != 0 && i != 1 && (customAudioRecorder2 = this.customAudioRecorder) != null) {
            customAudioRecorder2.releaseRecord();
        }
    }
}
