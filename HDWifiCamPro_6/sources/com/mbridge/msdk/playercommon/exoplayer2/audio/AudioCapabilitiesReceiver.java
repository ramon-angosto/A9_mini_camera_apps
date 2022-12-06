package com.mbridge.msdk.playercommon.exoplayer2.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

public final class AudioCapabilitiesReceiver {
    AudioCapabilities audioCapabilities;
    private final Context context;
    /* access modifiers changed from: private */
    public final Listener listener;
    private final BroadcastReceiver receiver;

    public interface Listener {
        void onAudioCapabilitiesChanged(AudioCapabilities audioCapabilities);
    }

    public AudioCapabilitiesReceiver(Context context2, Listener listener2) {
        this.context = (Context) Assertions.checkNotNull(context2);
        this.listener = (Listener) Assertions.checkNotNull(listener2);
        this.receiver = Util.SDK_INT >= 21 ? new HdmiAudioPlugBroadcastReceiver() : null;
    }

    public final AudioCapabilities register() {
        Intent intent;
        BroadcastReceiver broadcastReceiver = this.receiver;
        if (broadcastReceiver == null) {
            intent = null;
        } else {
            intent = this.context.registerReceiver(broadcastReceiver, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
        }
        this.audioCapabilities = AudioCapabilities.getCapabilities(intent);
        return this.audioCapabilities;
    }

    public final void unregister() {
        BroadcastReceiver broadcastReceiver = this.receiver;
        if (broadcastReceiver != null) {
            this.context.unregisterReceiver(broadcastReceiver);
        }
    }

    private final class HdmiAudioPlugBroadcastReceiver extends BroadcastReceiver {
        private HdmiAudioPlugBroadcastReceiver() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (!isInitialStickyBroadcast()) {
                AudioCapabilities capabilities = AudioCapabilities.getCapabilities(intent);
                if (!capabilities.equals(AudioCapabilitiesReceiver.this.audioCapabilities)) {
                    AudioCapabilitiesReceiver audioCapabilitiesReceiver = AudioCapabilitiesReceiver.this;
                    audioCapabilitiesReceiver.audioCapabilities = capabilities;
                    audioCapabilitiesReceiver.listener.onAudioCapabilitiesChanged(capabilities);
                }
            }
        }
    }
}
