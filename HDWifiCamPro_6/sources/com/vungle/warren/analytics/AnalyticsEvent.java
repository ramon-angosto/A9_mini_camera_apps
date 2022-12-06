package com.vungle.warren.analytics;

public interface AnalyticsEvent {

    public interface Ad {
        public static final String clickUrl = "click_url";
        public static final String mute = "mute";
        public static final String postrollClick = "postroll_click";
        public static final String postrollView = "postroll_view";
        public static final String unmute = "unmute";
        public static final String videoClick = "video_click";
        public static final String videoClose = "video_close";
        public static final String videoLength = "videoLength";
    }
}
