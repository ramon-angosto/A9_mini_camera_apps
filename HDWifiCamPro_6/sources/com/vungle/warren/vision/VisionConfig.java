package com.vungle.warren.vision;

import com.google.gson.annotations.SerializedName;

public class VisionConfig {
    @SerializedName("aggregation_filters")
    public String[] aggregationFilters;
    @SerializedName("aggregation_time_windows")
    public int[] aggregationTimeWindows;
    @SerializedName("enabled")
    public boolean enabled;
    @SerializedName("view_limit")
    public Limits viewLimit;

    public static class Limits {
        @SerializedName("device")
        public int device;
        @SerializedName("mobile")
        public int mobile;
        @SerializedName("wifi")
        public int wifi;
    }
}
