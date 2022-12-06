package com.bytedance.sdk.openadsdk.c;

import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: StatsEventRepertoryImpl */
public class l {
    public static String a() {
        return "CREATE TABLE IF NOT EXISTS " + "logstats" + " (_id INTEGER PRIMARY KEY AUTOINCREMENT," + "id" + " TEXT UNIQUE," + AppMeasurementSdk.ConditionalUserProperty.VALUE + " TEXT ," + "gen_time" + " TEXT , " + "encrypt" + " INTEGER default 0 , " + "retry" + " INTEGER default 0" + ")";
    }

    public static String b() {
        return "ALTER TABLE " + "logstats" + " ADD COLUMN " + "encrypt" + " INTEGER default 0";
    }
}
