package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1623an;
import com.xiaomi.push.service.C2027bo;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.dk */
public class C1722dk {

    /* renamed from: a */
    private static volatile C1722dk f2034a;

    /* renamed from: a */
    private Context f2035a;

    /* renamed from: a */
    private final ConcurrentLinkedQueue<C1724b> f2036a = new ConcurrentLinkedQueue<>();

    /* renamed from: com.xiaomi.push.dk$a */
    class C1723a extends C1724b {
        C1723a() {
            super();
        }

        /* renamed from: b */
        public void mo17228b() {
            C1722dk.m3008a(C1722dk.this);
        }
    }

    /* renamed from: com.xiaomi.push.dk$b */
    class C1724b extends C1623an.C1625b {

        /* renamed from: a */
        long f2038a = System.currentTimeMillis();

        C1724b() {
        }

        /* renamed from: a */
        public boolean mo17227a() {
            return true;
        }

        /* renamed from: b */
        public void mo17228b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public final boolean m3022b() {
            return System.currentTimeMillis() - this.f2038a > 172800000;
        }
    }

    /* renamed from: com.xiaomi.push.dk$c */
    class C1725c extends C1724b {

        /* renamed from: a */
        int f2040a;

        /* renamed from: a */
        File f2042a;

        /* renamed from: a */
        String f2043a;

        /* renamed from: a */
        boolean f2044a;

        /* renamed from: b */
        String f2045b;

        /* renamed from: b */
        boolean f2046b;

        C1725c(String str, String str2, File file, boolean z) {
            super();
            this.f2043a = str;
            this.f2045b = str2;
            this.f2042a = file;
            this.f2046b = z;
        }

        /* renamed from: c */
        private boolean mo17229c() {
            int i;
            int i2 = 0;
            SharedPreferences sharedPreferences = C1722dk.m3008a(C1722dk.this).getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                currentTimeMillis = jSONObject.getLong(CrashHianalyticsData.TIME);
                i = jSONObject.getInt("times");
            } catch (JSONException unused) {
                i = 0;
            }
            if (System.currentTimeMillis() - currentTimeMillis >= 86400000) {
                currentTimeMillis = System.currentTimeMillis();
            } else if (i > 10) {
                return false;
            } else {
                i2 = i;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(CrashHianalyticsData.TIME, currentTimeMillis);
                jSONObject2.put("times", i2 + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e) {
                C1524b.m2159c("JSONException on put " + e.getMessage());
            }
            return true;
        }

        /* renamed from: a */
        public boolean mo17227a() {
            return C1653bi.m2688e(C1722dk.m3008a(C1722dk.this)) || (this.f2046b && C1653bi.m2685b(C1722dk.m3008a(C1722dk.this)));
        }

        /* renamed from: b */
        public void mo17228b() {
            try {
                if (mo17229c()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", C2027bo.mo18506a());
                    hashMap.put("token", this.f2045b);
                    hashMap.put("net", C1653bi.m2669a(C1722dk.m3008a(C1722dk.this)));
                    C1653bi.m2679a(this.f2043a, hashMap, this.f2042a, "file");
                }
                this.f2044a = true;
            } catch (IOException unused) {
            }
        }

        /* renamed from: c */
        public void m3026c() {
            if (!this.f2044a) {
                this.f2040a++;
                if (this.f2040a < 3) {
                    C1722dk.m3008a(C1722dk.this).add(this);
                }
            }
            if (this.f2044a || this.f2040a >= 3) {
                this.f2042a.delete();
            }
            C1722dk.this.m3011a((long) ((1 << this.f2040a) * 1000));
        }
    }

    private C1722dk(Context context) {
        this.f2035a = context;
        this.f2036a.add(new C1723a());
        m3015b(0);
    }

    /* renamed from: a */
    public static C1722dk m3009a(Context context) {
        if (f2034a == null) {
            synchronized (C1722dk.class) {
                if (f2034a == null) {
                    f2034a = new C1722dk(context);
                }
            }
        }
        f2034a.f2035a = context;
        return f2034a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3011a(long j) {
        C1724b peek = this.f2036a.peek();
        if (peek != null && peek.mo17227a()) {
            m3015b(j);
        }
    }

    /* renamed from: b */
    private void m3014b() {
        if (!C1610ac.m2501b() && !C1610ac.m2499a()) {
            try {
                File file = new File(this.f2035a.getExternalFilesDir((String) null) + "/.logcache");
                if (file.exists() && file.isDirectory()) {
                    for (File delete : file.listFiles()) {
                        delete.delete();
                    }
                }
            } catch (NullPointerException unused) {
            }
        }
    }

    /* renamed from: b */
    private void m3015b(long j) {
        if (!this.f2036a.isEmpty()) {
            C1845gx.m3806a(new C1727dm(this), j);
        }
    }

    /* renamed from: c */
    private void m3016c() {
        while (!this.f2036a.isEmpty()) {
            C1724b peek = this.f2036a.peek();
            if (peek != null) {
                if (peek.mo17228b() || this.f2036a.size() > 6) {
                    C1524b.m2159c("remove Expired task");
                    this.f2036a.remove(peek);
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo17389a() {
        m3016c();
        m3011a(0);
    }

    /* renamed from: a */
    public void mo17390a(String str, String str2, Date date, Date date2, int i, boolean z) {
        this.f2036a.add(new C1726dl(this, i, date, date2, str, str2, z));
        m3015b(0);
    }
}
