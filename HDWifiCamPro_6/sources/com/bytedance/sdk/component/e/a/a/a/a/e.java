package com.bytedance.sdk.component.e.a.a.a.a;

import android.content.Context;
import com.bytedance.sdk.component.e.a.d.b.a;
import com.bytedance.sdk.component.e.a.i;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: StatsBatchLogEventRepoImpl */
public class e extends f {
    public byte a() {
        return 1;
    }

    public byte b() {
        return 3;
    }

    public e(Context context, a aVar) {
        super(context, aVar);
    }

    public String c() {
        return i.e().b().e();
    }

    public static String d() {
        return "CREATE TABLE IF NOT EXISTS " + i.e().b().e() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT," + "id" + " TEXT UNIQUE," + AppMeasurementSdk.ConditionalUserProperty.VALUE + " TEXT ," + "gen_time" + " TEXT , " + "retry" + " INTEGER default 0 , " + "encrypt" + " INTEGER default 0" + ")";
    }
}
