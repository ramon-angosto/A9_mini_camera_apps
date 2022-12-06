package com.shix.shixipc.widget;

public class RecordInfo {
    long endTime;
    int endValue;
    long startTime;
    int startValue;
    int type;

    public long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public int getStartValue() {
        return this.startValue;
    }

    public void setStartValue(int i) {
        this.startValue = i;
    }

    public int getEndValue() {
        return this.endValue;
    }

    public void setEndValue(int i) {
        this.endValue = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
