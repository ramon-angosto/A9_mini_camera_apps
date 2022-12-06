package com.bytedance.sdk.component.e.a.a.a.a;

import android.content.Context;
import com.bytedance.sdk.component.e.a.d.b.a;
import com.bytedance.sdk.component.e.a.i;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: HighPriorityAdEventRepoImpl */
public class c extends a {
    public byte d() {
        return 1;
    }

    public byte e() {
        return 0;
    }

    public c(Context context, a aVar) {
        super(context, aVar);
    }

    public String c() {
        return i.e().b().a();
    }

    public static String g() {
        return "CREATE TABLE IF NOT EXISTS " + i.e().b().a() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT," + "id" + " TEXT UNIQUE," + AppMeasurementSdk.ConditionalUserProperty.VALUE + " TEXT ," + "gen_time" + " TEXT , " + "retry" + " INTEGER default 0 , " + "encrypt" + " INTEGER default 0" + ")";
    }
}
