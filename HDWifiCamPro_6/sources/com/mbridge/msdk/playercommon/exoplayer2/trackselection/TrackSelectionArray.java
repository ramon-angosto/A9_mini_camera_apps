package com.mbridge.msdk.playercommon.exoplayer2.trackselection;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

public final class TrackSelectionArray {
    private int hashCode;
    public final int length;
    private final TrackSelection[] trackSelections;

    public TrackSelectionArray(TrackSelection... trackSelectionArr) {
        this.trackSelections = trackSelectionArr;
        this.length = trackSelectionArr.length;
    }

    public final TrackSelection get(int i) {
        return this.trackSelections[i];
    }

    public final TrackSelection[] getAll() {
        return (TrackSelection[]) this.trackSelections.clone();
    }

    public final int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = IronSourceError.ERROR_NON_EXISTENT_INSTANCE + Arrays.hashCode(this.trackSelections);
        }
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.trackSelections, ((TrackSelectionArray) obj).trackSelections);
    }
}
