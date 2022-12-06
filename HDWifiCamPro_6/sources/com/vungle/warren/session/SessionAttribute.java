package com.vungle.warren.session;

public enum SessionAttribute {
    PLACEMENT_ID,
    TIMESTAMP,
    SUCCESS,
    EVENT_ID,
    ORIENTATION,
    VIDEO_CACHED,
    USED,
    URL,
    MUTED,
    ENABLED,
    REASON;

    public String toString() {
        return name().toLowerCase();
    }
}
