package com.tzh.ipcamera.presenter.utils;

public class TimeUtils {
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    public TimeUtils(long j) {
        int i = (int) j;
        this.second = i % 60;
        this.minute = (i / 60) % 60;
        this.hour = i / 3600;
    }

    public String getTime() {
        return String.format("%02d:%02d:%02d\n", new Object[]{Integer.valueOf(this.hour), Integer.valueOf(this.minute), Integer.valueOf(this.second)});
    }
}
