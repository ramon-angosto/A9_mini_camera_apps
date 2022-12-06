package com.xiaomi.push.log;

import android.content.Context;
import android.content.SharedPreferences;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.channel.commonutils.misc.f;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.ah;
import com.xiaomi.smack.util.h;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    private static volatile b c;
    /* access modifiers changed from: private */
    public final ConcurrentLinkedQueue<C0051b> a = new ConcurrentLinkedQueue<>();
    /* access modifiers changed from: private */
    public Context b;

    class a extends C0051b {
        a() {
            super();
        }

        public void b() {
            b.this.b();
        }
    }

    /* renamed from: com.xiaomi.push.log.b$b  reason: collision with other inner class name */
    class C0051b extends f.b {
        long i = System.currentTimeMillis();

        C0051b() {
        }

        public void b() {
        }

        public boolean d() {
            return true;
        }

        /* access modifiers changed from: package-private */
        public final boolean e() {
            return System.currentTimeMillis() - this.i > 172800000;
        }
    }

    class c extends C0051b {
        String a;
        String b;
        File c;
        int d;
        boolean e;
        boolean f;

        c(String str, String str2, File file, boolean z) {
            super();
            this.a = str;
            this.b = str2;
            this.c = file;
            this.f = z;
        }

        private boolean f() {
            int i;
            int i2 = 0;
            SharedPreferences sharedPreferences = b.this.b.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                currentTimeMillis = jSONObject.getLong("time");
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
                jSONObject2.put("time", currentTimeMillis);
                jSONObject2.put("times", i2 + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e2) {
                com.xiaomi.channel.commonutils.logger.b.c("JSONException on put " + e2.getMessage());
            }
            return true;
        }

        public void b() {
            try {
                if (f()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", ah.e());
                    hashMap.put(Constants.EXTRA_KEY_TOKEN, this.b);
                    hashMap.put("net", d.g(b.this.b));
                    d.a(this.a, hashMap, this.c, "file");
                }
                this.e = true;
            } catch (IOException unused) {
            }
        }

        public void c() {
            if (!this.e) {
                this.d++;
                if (this.d < 3) {
                    b.this.a.add(this);
                }
            }
            if (this.e || this.d >= 3) {
                this.c.delete();
            }
            b.this.a((long) ((1 << this.d) * PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_NOTIFICATIONSERVICE));
        }

        public boolean d() {
            return d.f(b.this.b) || (this.f && d.d(b.this.b));
        }
    }

    private b(Context context) {
        this.b = context;
        this.a.add(new a());
        b(0);
    }

    public static b a(Context context) {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b(context);
                }
            }
        }
        c.b = context;
        return c;
    }

    /* access modifiers changed from: private */
    public void a(long j) {
        C0051b peek = this.a.peek();
        if (peek != null && peek.d()) {
            b(j);
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        if (!com.xiaomi.channel.commonutils.file.c.b() && !com.xiaomi.channel.commonutils.file.c.a()) {
            try {
                File file = new File(this.b.getExternalFilesDir((String) null) + "/.logcache");
                if (file.exists() && file.isDirectory()) {
                    for (File delete : file.listFiles()) {
                        delete.delete();
                    }
                }
            } catch (NullPointerException unused) {
            }
        }
    }

    private void b(long j) {
        if (!this.a.isEmpty()) {
            h.a(new d(this), j);
        }
    }

    private void c() {
        while (!this.a.isEmpty()) {
            if (this.a.peek().e() || this.a.size() > 6) {
                com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                this.a.remove();
            } else {
                return;
            }
        }
    }

    public void a() {
        c();
        a(0);
    }

    public void a(String str, String str2, Date date, Date date2, int i, boolean z) {
        this.a.add(new c(this, i, date, date2, str, str2, z));
        b(0);
    }
}
