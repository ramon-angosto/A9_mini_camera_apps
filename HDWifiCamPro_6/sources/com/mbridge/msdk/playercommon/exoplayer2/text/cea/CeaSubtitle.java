package com.mbridge.msdk.playercommon.exoplayer2.text.cea;

import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;
import com.mbridge.msdk.playercommon.exoplayer2.text.Subtitle;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.List;

final class CeaSubtitle implements Subtitle {
    private final List<Cue> cues;

    public final int getEventTimeCount() {
        return 1;
    }

    public final int getNextEventTimeIndex(long j) {
        return j < 0 ? 0 : -1;
    }

    public CeaSubtitle(List<Cue> list) {
        this.cues = list;
    }

    public final long getEventTime(int i) {
        Assertions.checkArgument(i == 0);
        return 0;
    }

    public final List<Cue> getCues(long j) {
        return j >= 0 ? this.cues : Collections.emptyList();
    }
}
