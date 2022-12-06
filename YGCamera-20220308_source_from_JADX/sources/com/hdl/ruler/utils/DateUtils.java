package com.hdl.ruler.utils;

import com.hdl.ruler.bean.TimeSlot;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    private static SimpleDateFormat format = new SimpleDateFormat("HH:mm");

    public static boolean isCurrentTimeArea(long j, long j2, long j3) {
        return j >= j2 && j <= j3;
    }

    public static long getTodayStart(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(j));
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        return instance.getTimeInMillis();
    }

    public static int getHour(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(j));
        return instance.get(11);
    }

    public static int getMinute(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(j));
        return instance.get(12);
    }

    public static int getSecond(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(j));
        return instance.get(13);
    }

    public static int getMinuteMillisecond(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(j));
        return (instance.get(12) * 60 * 1000) + (instance.get(13) * 1000) + instance.get(14);
    }

    public static int getMillisecond(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(j));
        return instance.get(14);
    }

    public static long getTodayEnd(long j) {
        return (getTodayStart(j) + 86400000) - 1000;
    }

    public static String getDateByCurrentTiem(long j) {
        return new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j));
    }

    public static String getDateTime(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j));
    }

    public static String getHourMinute(int i) {
        return format.format(Integer.valueOf((i * 60 * 1000) + 57600000));
    }

    public static String getTime(long j) {
        return new SimpleDateFormat("HH:mm:ss").format(new Date(j));
    }

    public static String getTimeByCurrentSecond(int i) {
        Object obj;
        Object obj2;
        int i2 = i / 60;
        int i3 = i2 % 60;
        int i4 = i2 / 60;
        if (i4 >= 24) {
            i4 %= 24;
        }
        StringBuilder sb = new StringBuilder();
        if (i4 < 10) {
            obj = "0" + i4;
        } else {
            obj = Integer.valueOf(i4);
        }
        sb.append(obj);
        sb.append(Constants.COLON_SEPARATOR);
        if (i3 < 10) {
            obj2 = "0" + i3;
        } else {
            obj2 = Integer.valueOf(i3);
        }
        sb.append(obj2);
        return sb.toString();
    }

    public static String getTimeByCurrentHours(int i) {
        Object obj;
        Object obj2;
        int i2 = (i * 10) / 60;
        int i3 = i2 % 60;
        int i4 = i2 / 60;
        if (i4 >= 24) {
            i4 %= 24;
        }
        StringBuilder sb = new StringBuilder();
        if (i4 < 10) {
            obj = "0" + i4;
        } else {
            obj = Integer.valueOf(i4);
        }
        sb.append(obj);
        sb.append(Constants.COLON_SEPARATOR);
        if (i3 < 10) {
            obj2 = "0" + i3;
        } else {
            obj2 = Integer.valueOf(i3);
        }
        sb.append(obj2);
        return sb.toString();
    }

    public static boolean isContainTime(TimeSlot timeSlot, long j, long j2) {
        return j >= timeSlot.getStartTimeMillis() && j2 <= timeSlot.getEndTimeMillis();
    }
}
