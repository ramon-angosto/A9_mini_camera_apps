package com.bytedance.sdk.openadsdk.c;

import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: StatsBatchEventRepertoryImpl */
public class k {
    public static String a() {
        return "CREATE TABLE IF NOT EXISTS " + "logstatsbatch" + " (_id INTEGER PRIMARY KEY AUTOINCREMENT," + "id" + " TEXT UNIQUE," + AppMeasurementSdk.ConditionalUserProperty.VALUE + " TEXT ," + "gen_time" + " TEXT , " + "retry" + " INTEGER default 0 , " + "encrypt" + " INTEGER default 0" + ")";
    }

    public static String b() {
        return "ALTER TABLE " + "logstatsbatch" + " ADD COLUMN " + "encrypt" + " INTEGER default 0";
    }
}
