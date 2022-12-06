package com.shix.shixipc.widget;

import android.util.Log;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VideoVo implements Serializable {
    public static List<VideoVo> datas = new ArrayList();
    public static Set<String> keys = new HashSet();
    long duration;
    String fileName;
    boolean isAlarm;
    long startTime;

    public boolean isAlarm() {
        return this.isAlarm;
    }

    public void setAlarm(boolean z) {
        this.isAlarm = z;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public static void clearAll() {
        Set<String> set = keys;
        if (set != null) {
            set.clear();
        }
        List<VideoVo> list = datas;
        if (list != null) {
            list.clear();
        }
    }

    public static void clearData() {
        List<VideoVo> list = datas;
        if (list != null) {
            list.clear();
        }
    }

    public static void clearDate() {
        Set<String> set = keys;
        if (set != null) {
            set.clear();
        }
    }

    public static void addDate(String str) {
        Set<String> set = keys;
        if (set != null && !set.contains(str)) {
            keys.add(str);
        }
    }

    public static void addData(VideoVo videoVo) {
        List<VideoVo> list = datas;
        if (list != null) {
            list.add(videoVo);
        }
    }

    public static long str2TimeStamp1(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Log.e("times_format", str);
        try {
            Date parse = simpleDateFormat.parse(str);
            Log.e("times_format", "time stamp " + parse.getTime());
            return parse.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static long str2TimeStamp(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Log.e("times_format", str + str2);
        try {
            Date parse = simpleDateFormat.parse(str + str2);
            Log.e("times_format", "time stamp " + parse.getTime());
            return parse.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
