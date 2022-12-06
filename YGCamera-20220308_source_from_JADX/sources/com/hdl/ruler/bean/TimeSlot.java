package com.hdl.ruler.bean;

import com.hdl.ruler.utils.DateUtils;
import java.io.Serializable;

public class TimeSlot implements Serializable {
    private long currentDayStartTimeMillis;
    private long endTime;
    private long startTime;
    int type;

    public TimeSlot(long j, long j2, long j3, int i) {
        this.currentDayStartTimeMillis = j;
        this.startTime = j2;
        this.endTime = j3;
        this.type = i;
    }

    public float getStartTime() {
        long j = this.currentDayStartTimeMillis;
        long j2 = this.startTime;
        if (j > j2) {
            return 0.0f;
        }
        return ((float) (j2 - DateUtils.getTodayStart(j2))) / 1000.0f;
    }

    public long getStartTimeMillis() {
        long j = this.currentDayStartTimeMillis;
        long j2 = this.startTime;
        if (j > j2) {
            return 0;
        }
        return j2 - DateUtils.getTodayStart(j2);
    }

    public float getEndTime() {
        long j = this.endTime;
        if (this.currentDayStartTimeMillis + 86400000 <= j) {
            return 86399.0f;
        }
        return ((float) (j - DateUtils.getTodayStart(j))) / 1000.0f;
    }

    public long getEndTimeMillis() {
        long j = this.endTime;
        if (this.currentDayStartTimeMillis + 86400000 <= j) {
            return 86399000;
        }
        return j - DateUtils.getTodayStart(j);
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "TimeSlot{startTime=" + getStartTime() + ",startTimeMillis=" + getStartTimeMillis() + ", endTime=" + getEndTime() + ",endTimeMillis=" + getEndTimeMillis() + '}';
    }
}
