package com.vungle.warren.vision;

public class VisionAggregationData {
    public String id;
    public long lastTimeStamp;
    public int viewCount;

    public VisionAggregationData(String str, int i, long j) {
        this.id = str;
        this.viewCount = i;
        this.lastTimeStamp = j;
    }
}
