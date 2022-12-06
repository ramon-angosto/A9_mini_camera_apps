package com.bytedance.sdk.openadsdk.c;

import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: HighPriorityEventRepertoryImpl */
public class g extends d {
    public static String c() {
        return "CREATE TABLE IF NOT EXISTS " + "loghighpriority" + " (_id INTEGER PRIMARY KEY AUTOINCREMENT," + "id" + " TEXT UNIQUE," + AppMeasurementSdk.ConditionalUserProperty.VALUE + " TEXT ," + "gen_time" + " TEXT , " + "retry" + " INTEGER default 0 , " + "encrypt" + " INTEGER default 0" + ")";
    }

    public static String d() {
        return "ALTER TABLE " + "loghighpriority" + " ADD COLUMN " + "encrypt" + " INTEGER default 0";
    }
}
