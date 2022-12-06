package com.mbridge.msdk.playercommon.exoplayer2.text.ttml;

import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;
import com.mbridge.msdk.playercommon.exoplayer2.text.Subtitle;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class TtmlSubtitle implements Subtitle {
    private final long[] eventTimesUs;
    private final Map<String, TtmlStyle> globalStyles;
    private final Map<String, TtmlRegion> regionMap;
    private final TtmlNode root;

    public TtmlSubtitle(TtmlNode ttmlNode, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2) {
        this.root = ttmlNode;
        this.regionMap = map2;
        this.globalStyles = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.eventTimesUs = ttmlNode.getEventTimesUs();
    }

    public final int getNextEventTimeIndex(long j) {
        int binarySearchCeil = Util.binarySearchCeil(this.eventTimesUs, j, false, false);
        if (binarySearchCeil < this.eventTimesUs.length) {
            return binarySearchCeil;
        }
        return -1;
    }

    public final int getEventTimeCount() {
        return this.eventTimesUs.length;
    }

    public final long getEventTime(int i) {
        return this.eventTimesUs[i];
    }

    /* access modifiers changed from: package-private */
    public final TtmlNode getRoot() {
        return this.root;
    }

    public final List<Cue> getCues(long j) {
        return this.root.getCues(j, this.globalStyles, this.regionMap);
    }

    /* access modifiers changed from: package-private */
    public final Map<String, TtmlStyle> getGlobalStyles() {
        return this.globalStyles;
    }
}
