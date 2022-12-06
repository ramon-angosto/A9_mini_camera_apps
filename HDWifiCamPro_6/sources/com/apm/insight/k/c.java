package com.apm.insight.k;

import com.apm.insight.CrashType;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class c {
    private static ConcurrentLinkedQueue<c> a = new ConcurrentLinkedQueue<>();

    /* renamed from: com.apm.insight.k.c$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[CrashType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.apm.insight.CrashType[] r0 = com.apm.insight.CrashType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.apm.insight.CrashType r1 = com.apm.insight.CrashType.JAVA     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.apm.insight.CrashType r1 = com.apm.insight.CrashType.LAUNCH     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.apm.insight.CrashType r1 = com.apm.insight.CrashType.NATIVE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.k.c.AnonymousClass1.<clinit>():void");
        }
    }

    public static class a {
        private JSONObject a;
        private JSONObject b;
        private CrashType c;

        a(JSONObject jSONObject, CrashType crashType) {
            this.c = crashType;
            if (crashType == CrashType.LAUNCH) {
                this.a = ((JSONArray) jSONObject.opt(DataSchemeDataSource.SCHEME_DATA)).optJSONObject(0);
            } else {
                this.a = jSONObject;
            }
            this.b = jSONObject.optJSONObject("header");
        }

        public String a() {
            return this.a.optString("crash_thread_name", (String) null);
        }

        public long b() {
            return (long) this.a.optInt("app_start_time", -1);
        }

        public String c() {
            int i = AnonymousClass1.a[this.c.ordinal()];
            if (i == 1) {
                return this.a.optString(DataSchemeDataSource.SCHEME_DATA, (String) null);
            }
            if (i == 2) {
                return this.a.optString("stack", (String) null);
            }
            if (i != 3) {
                return null;
            }
            return this.a.optString(DataSchemeDataSource.SCHEME_DATA, (String) null);
        }
    }

    static void a(CrashType crashType, JSONObject jSONObject) {
        ConcurrentLinkedQueue<c> concurrentLinkedQueue = a;
        if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
            a aVar = new a(jSONObject, crashType);
            while (!a.isEmpty()) {
                c poll = a.poll();
                if (poll != null) {
                    poll.a(crashType, aVar);
                }
            }
            a = null;
        }
    }

    public abstract void a(CrashType crashType, a aVar);
}
