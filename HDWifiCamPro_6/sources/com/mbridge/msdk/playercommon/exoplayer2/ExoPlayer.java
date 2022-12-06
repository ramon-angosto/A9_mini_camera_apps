package com.mbridge.msdk.playercommon.exoplayer2;

import android.os.Looper;
import com.mbridge.msdk.playercommon.exoplayer2.Player;
import com.mbridge.msdk.playercommon.exoplayer2.PlayerMessage;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;

public interface ExoPlayer extends Player {
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_OFF = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int STATE_BUFFERING = 2;
    public static final int STATE_ENDED = 4;
    public static final int STATE_IDLE = 1;
    public static final int STATE_READY = 3;

    public interface EventListener extends Player.EventListener {
    }

    public interface ExoPlayerComponent extends PlayerMessage.Target {
    }

    void blockingSendMessages(ExoPlayerMessage... exoPlayerMessageArr);

    PlayerMessage createMessage(PlayerMessage.Target target);

    Looper getPlaybackLooper();

    void prepare(MediaSource mediaSource);

    void prepare(MediaSource mediaSource, boolean z, boolean z2);

    void sendMessages(ExoPlayerMessage... exoPlayerMessageArr);

    void setSeekParameters(SeekParameters seekParameters);

    public static final class ExoPlayerMessage {
        public final Object message;
        public final int messageType;
        public final PlayerMessage.Target target;

        public ExoPlayerMessage(PlayerMessage.Target target2, int i, Object obj) {
            this.target = target2;
            this.messageType = i;
            this.message = obj;
        }
    }
}
