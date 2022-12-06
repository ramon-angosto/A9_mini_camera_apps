package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1615ah;
import com.xiaomi.push.C1618ak;
import com.xiaomi.push.C1653bi;
import com.xiaomi.push.C1945s;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.xiaomi.push.service.bq */
public final class C2030bq implements C1983al {

    /* renamed from: a */
    private static volatile C2030bq f3838a;

    /* renamed from: a */
    private long f3839a;

    /* renamed from: a */
    Context f3840a;

    /* renamed from: a */
    private SharedPreferences f3841a;

    /* renamed from: a */
    private ConcurrentHashMap<String, C2031a> f3842a = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public volatile boolean f3843a = false;

    /* renamed from: com.xiaomi.push.service.bq$a */
    public static abstract class C2031a implements Runnable {

        /* renamed from: a */
        long f3844a;

        /* renamed from: a */
        String f3845a;

        C2031a(String str, long j) {
            this.f3845a = str;
            this.f3844a = j;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo18443a(C2030bq bqVar);

        public void run() {
            if (C2030bq.mo18449a() != null) {
                Context context = C2030bq.mo18449a().f3840a;
                if (C1653bi.m2687d(context)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SharedPreferences a = C2030bq.m5166a(C2030bq.mo18449a());
                    if (currentTimeMillis - a.getLong(":ts-" + this.f3845a, 0) > this.f3844a || C1615ah.m2512a(context)) {
                        SharedPreferences.Editor edit = C2030bq.m5166a(C2030bq.mo18449a()).edit();
                        C1945s.m4744a(edit.putLong(":ts-" + this.f3845a, System.currentTimeMillis()));
                        mo18443a(C2030bq.mo18449a());
                    }
                }
            }
        }
    }

    private C2030bq(Context context) {
        this.f3840a = context.getApplicationContext();
        this.f3841a = context.getSharedPreferences("sync", 0);
    }

    /* renamed from: a */
    public static C2030bq m5168a(Context context) {
        if (f3838a == null) {
            synchronized (C2030bq.class) {
                if (f3838a == null) {
                    f3838a = new C2030bq(context);
                }
            }
        }
        return f3838a;
    }

    /* renamed from: a */
    public String mo18509a(String str, String str2) {
        SharedPreferences sharedPreferences = this.f3841a;
        return sharedPreferences.getString(str + Constants.COLON_SEPARATOR + str2, "");
    }

    /* renamed from: a */
    public void m5172a() {
        if (!this.f3843a) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f3839a >= 3600000) {
                this.f3839a = currentTimeMillis;
                this.f3843a = true;
                C1618ak.m2518a(this.f3840a).mo17213a((Runnable) new C2032br(this), (int) (Math.random() * 10.0d));
            }
        }
    }

    /* renamed from: a */
    public void mo18510a(C2031a aVar) {
        if (this.f3842a.putIfAbsent(aVar.f3845a, aVar) == null) {
            C1618ak.m2518a(this.f3840a).mo17213a((Runnable) aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    /* renamed from: a */
    public void mo18511a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = f3838a.f3841a.edit();
        C1945s.m4744a(edit.putString(str + Constants.COLON_SEPARATOR + str2, str3));
    }
}
