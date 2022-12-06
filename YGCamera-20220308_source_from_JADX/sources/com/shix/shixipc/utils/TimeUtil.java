package com.shix.shixipc.utils;

import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtil {
    public static String getTimeDesc(int i) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        if (i < 60) {
            StringBuilder sb = new StringBuilder();
            sb.append("00:");
            if (i < 10) {
                obj6 = "0" + i;
            } else {
                obj6 = Integer.valueOf(i);
            }
            sb.append(obj6);
            sb.append("");
            return sb.toString();
        } else if (i < 60 || i >= 3600) {
            int i2 = i / 3600;
            int i3 = i % 3600;
            int i4 = i3 / 60;
            int i5 = i3 % 60;
            StringBuilder sb2 = new StringBuilder();
            if (i2 < 10) {
                obj = "0" + i2;
            } else {
                obj = Integer.valueOf(i2);
            }
            sb2.append(obj);
            sb2.append(Constants.COLON_SEPARATOR);
            if (i4 < 10) {
                obj2 = "0" + i4;
            } else {
                obj2 = Integer.valueOf(i4);
            }
            sb2.append(obj2);
            sb2.append(Constants.COLON_SEPARATOR);
            if (i5 < 10) {
                obj3 = "0" + i5;
            } else {
                obj3 = Integer.valueOf(i5);
            }
            sb2.append(obj3);
            sb2.append("");
            return sb2.toString();
        } else {
            int i6 = i / 60;
            int i7 = i % 60;
            StringBuilder sb3 = new StringBuilder();
            if (i6 < 10) {
                obj4 = "0" + i6;
            } else {
                obj4 = Integer.valueOf(i6);
            }
            sb3.append(obj4);
            sb3.append(Constants.COLON_SEPARATOR);
            if (i7 < 10) {
                obj5 = "0" + i7;
            } else {
                obj5 = Integer.valueOf(i7);
            }
            sb3.append(obj5);
            sb3.append("");
            return sb3.toString();
        }
    }

    public static long getUTCTimeSec() {
        return getUTCTime() / 1000;
    }

    public static long getUTCTime() {
        Calendar instance = Calendar.getInstance(TimeZone.getDefault());
        Log.e("TAG", "[UTC-1] Local time:" + (instance.getTimeInMillis() / 1000) + ", date:" + (new Date().getTime() / 1000) + ", System:" + (System.currentTimeMillis() / 1000));
        int i = instance.get(15);
        StringBuilder sb = new StringBuilder();
        sb.append("[UTC-1] zoneOffset:");
        sb.append(i);
        Log.e("TAG", sb.toString());
        int i2 = instance.get(16);
        Log.e("TAG", "[UTC-1] dstOffset:" + i2);
        instance.add(14, -(i + i2));
        Log.e("TAG", "[UTC-1] UTC time :" + instance.getTimeInMillis());
        return instance.getTimeInMillis();
    }
}
