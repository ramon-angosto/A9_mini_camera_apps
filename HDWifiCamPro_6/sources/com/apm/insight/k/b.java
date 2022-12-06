package com.apm.insight.k;

import android.content.Context;
import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.Npth;
import com.apm.insight.entity.b;
import com.apm.insight.entity.e;
import com.apm.insight.h;
import com.apm.insight.k.c;
import com.apm.insight.l.i;
import com.apm.insight.l.o;
import com.apm.insight.l.p;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.nativecrash.c;
import com.apm.insight.runtime.s;
import com.google.android.gms.ads.RequestConfiguration;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    private static volatile b d;
    List<File> a = new ArrayList();
    List<File> b = new ArrayList();
    /* access modifiers changed from: private */
    public Context c;
    private int e = -1;
    private C0012b f;
    private HashMap<String, C0012b> g;
    private volatile boolean h = false;
    private Runnable i = new Runnable() {
        public void run() {
            b.this.g();
        }
    };
    private Runnable j = new Runnable() {
        public void run() {
            b.this.e();
        }
    };

    static class a {
        File a;
        long b = -1;
        long c = -1;
        CrashType d;
        String e;

        a(File file, long j, CrashType crashType) {
            this.a = file;
            this.b = j;
            this.d = crashType;
            this.e = file.getName();
        }

        a(File file, CrashType crashType) {
            this.a = file;
            this.d = crashType;
            this.e = file.getName();
        }
    }

    /* renamed from: com.apm.insight.k.b$b  reason: collision with other inner class name */
    static class C0012b {
        String a;
        List<a> b = new ArrayList();
        List<a> c = new ArrayList();
        a d;
        a e;
        boolean f = false;
        int g = 0;

        C0012b(String str) {
            this.a = str;
        }
    }

    private b(Context context) {
        this.c = context;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:54|55) */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r13.put("lastAliveTime", "unknown");
        com.apm.insight.entity.a.a(r13, "filters", "lastAliveTime", "unknown");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x0168 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.apm.insight.entity.e a(java.io.File r20, com.apm.insight.CrashType r21, java.lang.String r22, long r23, long r25) {
        /*
            r19 = this;
            r1 = r19
            r0 = r21
            r2 = r23
            java.lang.String r4 = "data"
            java.lang.String r5 = "unauthentic_version"
            java.lang.String r6 = "unknown"
            java.lang.String r7 = "true"
            java.lang.String r8 = "has_dump"
            java.lang.String r9 = "logcat"
            java.lang.String r10 = "header"
            java.lang.String r11 = "lastAliveTime"
            java.lang.String r12 = "filters"
            boolean r14 = r20.isFile()     // Catch:{ all -> 0x01da }
            if (r14 == 0) goto L_0x0028
            com.apm.insight.l.i.a((java.io.File) r20)     // Catch:{ all -> 0x0024 }
            r13 = 0
            goto L_0x01e9
        L_0x0024:
            r0 = move-exception
        L_0x0025:
            r13 = 0
            goto L_0x01dd
        L_0x0028:
            com.apm.insight.CrashType r14 = com.apm.insight.CrashType.LAUNCH     // Catch:{ all -> 0x01da }
            if (r0 != r14) goto L_0x002e
            r14 = 1
            goto L_0x002f
        L_0x002e:
            r14 = 0
        L_0x002f:
            if (r0 != 0) goto L_0x0049
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x0045 }
            java.lang.String r2 = r20.getName()     // Catch:{ all -> 0x0045 }
            r3 = r20
            r0.<init>(r3, r2)     // Catch:{ all -> 0x0024 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0024 }
            com.apm.insight.entity.e r0 = com.apm.insight.l.i.d((java.lang.String) r0)     // Catch:{ all -> 0x0024 }
            return r0
        L_0x0045:
            r0 = move-exception
            r3 = r20
            goto L_0x0025
        L_0x0049:
            com.apm.insight.entity.e r15 = com.apm.insight.l.i.a((java.io.File) r20, (com.apm.insight.CrashType) r21)     // Catch:{ all -> 0x01da }
            org.json.JSONObject r13 = r15.b()     // Catch:{ all -> 0x01d7 }
            org.json.JSONObject r17 = r15.b()     // Catch:{ all -> 0x01d7 }
            if (r17 == 0) goto L_0x01d2
            r17 = r4
            com.apm.insight.CrashType r4 = com.apm.insight.CrashType.ANR     // Catch:{ all -> 0x01d7 }
            if (r0 != r4) goto L_0x005e
            return r15
        L_0x005e:
            java.lang.String r0 = "crash_time"
            r13.put(r0, r2)     // Catch:{ all -> 0x01d7 }
            java.lang.String r0 = "app_start_time"
            r18 = r5
            r4 = r25
            r13.put(r0, r4)     // Catch:{ all -> 0x01d7 }
            org.json.JSONObject r0 = r13.optJSONObject(r10)     // Catch:{ all -> 0x01d7 }
            if (r0 != 0) goto L_0x007d
            android.content.Context r0 = r1.c     // Catch:{ all -> 0x01d7 }
            com.apm.insight.entity.Header r0 = com.apm.insight.entity.Header.a(r0, r2)     // Catch:{ all -> 0x01d7 }
            org.json.JSONObject r0 = r0.f()     // Catch:{ all -> 0x01d7 }
            goto L_0x0082
        L_0x007d:
            if (r14 == 0) goto L_0x0082
            r13.remove(r10)     // Catch:{ all -> 0x01d7 }
        L_0x0082:
            java.lang.String r4 = "sdk_version_name"
            r5 = 0
            java.lang.String r4 = r0.optString(r4, r5)     // Catch:{ all -> 0x01d7 }
            java.lang.String r5 = "sdk_version"
            if (r4 != 0) goto L_0x008f
            java.lang.String r4 = "1.3.8.nourl-alpha.7"
        L_0x008f:
            com.apm.insight.entity.a.a((org.json.JSONObject) r13, (java.lang.String) r12, (java.lang.String) r5, (java.lang.String) r4)     // Catch:{ all -> 0x01d7 }
            org.json.JSONArray r4 = r13.optJSONArray(r9)     // Catch:{ all -> 0x01d7 }
            boolean r4 = com.apm.insight.l.i.a((org.json.JSONArray) r4)     // Catch:{ all -> 0x01d7 }
            if (r4 == 0) goto L_0x00a3
            org.json.JSONArray r4 = com.apm.insight.runtime.k.b(r22)     // Catch:{ all -> 0x01d7 }
            r13.put(r9, r4)     // Catch:{ all -> 0x01d7 }
        L_0x00a3:
            com.apm.insight.entity.a.a((org.json.JSONObject) r13, (java.lang.String) r12, (java.lang.String) r8, (java.lang.String) r7)     // Catch:{ all -> 0x01d7 }
            java.lang.String r4 = "has_logcat"
            boolean r5 = com.apm.insight.l.l.a((org.json.JSONObject) r13, (java.lang.String) r9)     // Catch:{ all -> 0x01d7 }
            if (r5 != 0) goto L_0x00b1
            r16 = 1
            goto L_0x00b3
        L_0x00b1:
            r16 = 0
        L_0x00b3:
            java.lang.String r5 = java.lang.String.valueOf(r16)     // Catch:{ all -> 0x01d7 }
            com.apm.insight.entity.a.a((org.json.JSONObject) r13, (java.lang.String) r12, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x01d7 }
            java.lang.String r4 = "memory_leak"
            boolean r5 = com.apm.insight.entity.a.b((java.lang.String) r22)     // Catch:{ all -> 0x01d7 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x01d7 }
            com.apm.insight.entity.a.a((org.json.JSONObject) r13, (java.lang.String) r12, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x01d7 }
            java.lang.String r4 = "fd_leak"
            boolean r5 = com.apm.insight.entity.a.c((java.lang.String) r22)     // Catch:{ all -> 0x01d7 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x01d7 }
            com.apm.insight.entity.a.a((org.json.JSONObject) r13, (java.lang.String) r12, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x01d7 }
            java.lang.String r4 = "threads_leak"
            boolean r5 = com.apm.insight.entity.a.d(r22)     // Catch:{ all -> 0x01d7 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x01d7 }
            com.apm.insight.entity.a.a((org.json.JSONObject) r13, (java.lang.String) r12, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x01d7 }
            java.lang.String r4 = "is_64_devices"
            boolean r5 = com.apm.insight.entity.Header.a()     // Catch:{ all -> 0x01d7 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x01d7 }
            com.apm.insight.entity.a.a((org.json.JSONObject) r13, (java.lang.String) r12, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x01d7 }
            java.lang.String r4 = "is_64_runtime"
            boolean r5 = com.apm.insight.nativecrash.NativeImpl.e()     // Catch:{ all -> 0x01d7 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x01d7 }
            com.apm.insight.entity.a.a((org.json.JSONObject) r13, (java.lang.String) r12, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x01d7 }
            java.lang.String r4 = "is_x86_devices"
            boolean r5 = com.apm.insight.entity.Header.b()     // Catch:{ all -> 0x01d7 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x01d7 }
            com.apm.insight.entity.a.a((org.json.JSONObject) r13, (java.lang.String) r12, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x01d7 }
            java.lang.String r4 = "has_meminfo_file"
            boolean r5 = com.apm.insight.entity.a.a((java.lang.String) r22)     // Catch:{ all -> 0x01d7 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x01d7 }
            com.apm.insight.entity.a.a((org.json.JSONObject) r13, (java.lang.String) r12, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x01d7 }
            java.lang.String r4 = "is_root"
            boolean r5 = com.apm.insight.nativecrash.b.m()     // Catch:{ all -> 0x01d7 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x01d7 }
            com.apm.insight.entity.a.a((org.json.JSONObject) r13, (java.lang.String) r12, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x01d7 }
            java.lang.String r4 = "launch_did"
            android.content.Context r5 = r1.c     // Catch:{ all -> 0x01d7 }
            java.lang.String r5 = com.apm.insight.i.a.a(r5)     // Catch:{ all -> 0x01d7 }
            r13.put(r4, r5)     // Catch:{ all -> 0x01d7 }
            java.lang.String r4 = "crash_uuid"
            java.lang.String r5 = r20.getName()     // Catch:{ all -> 0x01d7 }
            r13.put(r4, r5)     // Catch:{ all -> 0x01d7 }
            java.lang.String r4 = "jiffy"
            r16 = r10
            long r9 = com.apm.insight.runtime.q.a.a()     // Catch:{ all -> 0x01d7 }
            r13.put(r4, r9)     // Catch:{ all -> 0x01d7 }
            r4 = r22
            java.lang.String r4 = com.apm.insight.runtime.b.a(r2, r4)     // Catch:{ all -> 0x0168 }
            long r4 = java.lang.Long.parseLong(r4)     // Catch:{ all -> 0x0168 }
            long r2 = r4 - r2
            long r2 = java.lang.Math.abs(r2)     // Catch:{ all -> 0x0168 }
            r9 = 60000(0xea60, double:2.9644E-319)
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r2 >= 0) goto L_0x015b
            java.lang.String r2 = "< 60s"
            goto L_0x015d
        L_0x015b:
            java.lang.String r2 = "> 60s"
        L_0x015d:
            com.apm.insight.entity.a.a((org.json.JSONObject) r13, (java.lang.String) r12, (java.lang.String) r11, (java.lang.String) r2)     // Catch:{ all -> 0x0168 }
            java.lang.String r2 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0168 }
            r13.put(r11, r2)     // Catch:{ all -> 0x0168 }
            goto L_0x016e
        L_0x0168:
            r13.put(r11, r6)     // Catch:{ all -> 0x01d7 }
            com.apm.insight.entity.a.a((org.json.JSONObject) r13, (java.lang.String) r12, (java.lang.String) r11, (java.lang.String) r6)     // Catch:{ all -> 0x01d7 }
        L_0x016e:
            r13.put(r8, r7)     // Catch:{ all -> 0x01d7 }
            java.lang.String r2 = "storage"
            java.lang.Object r2 = r13.opt(r2)     // Catch:{ all -> 0x01d7 }
            if (r2 != 0) goto L_0x0184
            android.content.Context r2 = com.apm.insight.h.g()     // Catch:{ all -> 0x01d7 }
            org.json.JSONObject r2 = com.apm.insight.l.w.a((android.content.Context) r2)     // Catch:{ all -> 0x01d7 }
            com.apm.insight.entity.a.a((org.json.JSONObject) r13, (org.json.JSONObject) r2)     // Catch:{ all -> 0x01d7 }
        L_0x0184:
            boolean r2 = com.apm.insight.entity.Header.b((org.json.JSONObject) r0)     // Catch:{ all -> 0x01d7 }
            if (r2 == 0) goto L_0x018f
            r2 = r18
            com.apm.insight.entity.a.a((org.json.JSONObject) r13, (java.lang.String) r12, (java.lang.String) r2, (java.lang.String) r2)     // Catch:{ all -> 0x01d7 }
        L_0x018f:
            com.apm.insight.entity.d.b(r13)     // Catch:{ all -> 0x01d7 }
            org.json.JSONObject r2 = r15.b()     // Catch:{ all -> 0x01d7 }
            java.lang.String r3 = "upload_scene"
            java.lang.String r4 = "launch_scan"
            r2.put(r3, r4)     // Catch:{ all -> 0x01d7 }
            if (r14 == 0) goto L_0x01cb
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x01d7 }
            r2.<init>()     // Catch:{ all -> 0x01d7 }
            java.lang.String r3 = "event_type"
            java.lang.String r4 = "start_crash"
            r13.put(r3, r4)     // Catch:{ all -> 0x01d7 }
            java.lang.String r3 = "stack"
            r4 = r17
            java.lang.Object r5 = r13.remove(r4)     // Catch:{ all -> 0x01d7 }
            r13.put(r3, r5)     // Catch:{ all -> 0x01d7 }
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ all -> 0x01d7 }
            r3.<init>()     // Catch:{ all -> 0x01d7 }
            org.json.JSONArray r3 = r3.put(r13)     // Catch:{ all -> 0x01d7 }
            r2.put(r4, r3)     // Catch:{ all -> 0x01d7 }
            r3 = r16
            r2.put(r3, r0)     // Catch:{ all -> 0x01d7 }
            r15.a((org.json.JSONObject) r2)     // Catch:{ all -> 0x01d7 }
            goto L_0x01d5
        L_0x01cb:
            java.lang.String r0 = "isJava"
            r2 = 1
            r13.put(r0, r2)     // Catch:{ all -> 0x01d7 }
            goto L_0x01d5
        L_0x01d2:
            com.apm.insight.l.i.a((java.io.File) r20)     // Catch:{ all -> 0x01d7 }
        L_0x01d5:
            r13 = r15
            goto L_0x01e9
        L_0x01d7:
            r0 = move-exception
            r13 = r15
            goto L_0x01dd
        L_0x01da:
            r0 = move-exception
            r5 = 0
            r13 = r5
        L_0x01dd:
            com.apm.insight.l.i.a((java.io.File) r20)
            com.apm.insight.c r2 = com.apm.insight.b.a()
            java.lang.String r3 = "NPTH_CATCH"
            r2.a((java.lang.String) r3, (java.lang.Throwable) r0)
        L_0x01e9:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.k.b.a(java.io.File, com.apm.insight.CrashType, java.lang.String, long, long):com.apm.insight.entity.e");
    }

    public static b a() {
        if (d == null) {
            synchronized (b.class) {
                if (d == null) {
                    d = new b(h.g());
                }
            }
        }
        return d;
    }

    private JSONObject a(com.apm.insight.nativecrash.b bVar) {
        JSONObject d2 = bVar.d();
        if (d2 != null && d2.length() != 0) {
            return d2;
        }
        if (h.d()) {
            bVar.l();
        }
        if (!bVar.c()) {
            bVar.k();
            return null;
        } else if (!bVar.f()) {
            bVar.k();
            return null;
        } else if (bVar.g()) {
            bVar.k();
            return null;
        } else {
            bVar.e();
            return bVar.j();
        }
    }

    private void a(C0012b bVar) {
        i.a(o.a(this.c, bVar.a));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c9, code lost:
        if (r1.e == r7) goto L_0x00cb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a5 A[SYNTHETIC, Splitter:B:34:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x014c A[Catch:{ all -> 0x0161 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.apm.insight.k.b.C0012b r21, boolean r22, com.apm.insight.runtime.h r23) {
        /*
            r20 = this;
            r1 = r21
            r2 = r23
            java.lang.String r3 = "crash_thread_name"
            java.lang.String r4 = "NPTH_CATCH"
            java.lang.String r5 = "aid"
            java.util.List<com.apm.insight.k.b$a> r0 = r1.b
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0013
            return
        L_0x0013:
            com.apm.insight.k.b$a r0 = r1.e
            if (r0 != 0) goto L_0x001b
            com.apm.insight.k.b$a r0 = r1.d
            r1.e = r0
        L_0x001b:
            java.util.List<com.apm.insight.k.b$a> r0 = r1.b
            java.util.Iterator r6 = r0.iterator()
        L_0x0021:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x017d
            java.lang.Object r0 = r6.next()
            r7 = r0
            com.apm.insight.k.b$a r7 = (com.apm.insight.k.b.a) r7
            java.io.File r14 = r7.a     // Catch:{ all -> 0x0168 }
            com.apm.insight.CrashType r15 = r7.d     // Catch:{ all -> 0x0168 }
            java.lang.String r11 = r1.a     // Catch:{ all -> 0x0168 }
            long r12 = r7.b     // Catch:{ all -> 0x0168 }
            long r9 = r7.c     // Catch:{ all -> 0x0168 }
            r8 = r20
            r16 = r9
            r9 = r14
            r10 = r15
            r19 = r6
            r18 = r14
            r6 = r15
            r14 = r16
            com.apm.insight.entity.e r8 = r8.a(r9, r10, r11, r12, r14)     // Catch:{ all -> 0x0166 }
            if (r8 != 0) goto L_0x0050
        L_0x004b:
            com.apm.insight.l.i.a((java.io.File) r18)     // Catch:{ all -> 0x0166 }
            goto L_0x0179
        L_0x0050:
            org.json.JSONObject r9 = r8.b()     // Catch:{ all -> 0x0166 }
            if (r9 != 0) goto L_0x0057
            goto L_0x004b
        L_0x0057:
            java.lang.String r0 = "header"
            org.json.JSONObject r0 = r9.optJSONObject(r0)     // Catch:{ all -> 0x0166 }
            if (r0 != 0) goto L_0x0060
            goto L_0x004b
        L_0x0060:
            if (r6 != 0) goto L_0x0098
            java.io.File r10 = new java.io.File     // Catch:{ all -> 0x0166 }
            java.lang.String r11 = r18.getName()     // Catch:{ all -> 0x0166 }
            r12 = r18
            r10.<init>(r12, r11)     // Catch:{ all -> 0x0166 }
            boolean r10 = r10.exists()     // Catch:{ all -> 0x0166 }
            if (r10 != 0) goto L_0x0081
            java.lang.String r10 = r12.getName()     // Catch:{ all -> 0x0166 }
            java.lang.String r11 = "_"
            java.lang.String[] r10 = r10.split(r11)     // Catch:{ all -> 0x0166 }
            int r10 = r10.length     // Catch:{ all -> 0x0166 }
            r11 = 5
            if (r10 >= r11) goto L_0x009a
        L_0x0081:
            java.lang.String r0 = r8.a()     // Catch:{ all -> 0x0166 }
            java.lang.String r6 = r9.toString()     // Catch:{ all -> 0x0166 }
            com.apm.insight.k.l r0 = com.apm.insight.k.e.b(r0, r6)     // Catch:{ all -> 0x0166 }
            boolean r0 = r0.a()     // Catch:{ all -> 0x0166 }
            if (r0 == 0) goto L_0x0179
        L_0x0093:
            com.apm.insight.l.i.a((java.io.File) r12)     // Catch:{ all -> 0x0166 }
            goto L_0x0179
        L_0x0098:
            r12 = r18
        L_0x009a:
            java.io.File r10 = com.apm.insight.entity.b.a((java.io.File) r12)     // Catch:{ all -> 0x0166 }
            boolean r11 = r10.exists()     // Catch:{ all -> 0x0166 }
            if (r11 != 0) goto L_0x00a5
            goto L_0x0093
        L_0x00a5:
            org.json.JSONArray r11 = new org.json.JSONArray     // Catch:{ all -> 0x0163 }
            java.lang.String r10 = com.apm.insight.l.i.c((java.io.File) r10)     // Catch:{ all -> 0x0163 }
            r11.<init>(r10)     // Catch:{ all -> 0x0163 }
            com.apm.insight.CrashType r10 = com.apm.insight.CrashType.LAUNCH     // Catch:{ all -> 0x0166 }
            if (r6 != r10) goto L_0x00c0
            java.lang.String r10 = "data"
            java.lang.Object r10 = r9.opt(r10)     // Catch:{ all -> 0x0166 }
            org.json.JSONArray r10 = (org.json.JSONArray) r10     // Catch:{ all -> 0x0166 }
            r13 = 0
            org.json.JSONObject r10 = r10.optJSONObject(r13)     // Catch:{ all -> 0x0166 }
            goto L_0x00c1
        L_0x00c0:
            r10 = r9
        L_0x00c1:
            java.lang.String r13 = "ignore"
            java.lang.String r14 = "filters"
            if (r22 != 0) goto L_0x00cb
            com.apm.insight.k.b$a r15 = r1.e     // Catch:{ all -> 0x0166 }
            if (r15 != r7) goto L_0x00d3
        L_0x00cb:
            java.lang.String r15 = r7.e     // Catch:{ all -> 0x0166 }
            boolean r15 = r15.contains(r13)     // Catch:{ all -> 0x0166 }
            if (r15 == 0) goto L_0x0106
        L_0x00d3:
            java.lang.Object r15 = r0.opt(r5)     // Catch:{ all -> 0x00fb }
            java.lang.String r15 = java.lang.String.valueOf(r15)     // Catch:{ all -> 0x00fb }
            java.lang.String r15 = java.lang.String.valueOf(r15)     // Catch:{ all -> 0x00fb }
            com.apm.insight.entity.a.a((org.json.JSONObject) r10, (java.lang.String) r14, (java.lang.String) r5, (java.lang.String) r15)     // Catch:{ all -> 0x00fb }
            java.lang.String r15 = "has_ignore"
            r16 = r6
            java.lang.String r6 = r7.e     // Catch:{ all -> 0x00f9 }
            boolean r6 = r6.contains(r13)     // Catch:{ all -> 0x00f9 }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x00f9 }
            com.apm.insight.entity.a.a((org.json.JSONObject) r10, (java.lang.String) r14, (java.lang.String) r15, (java.lang.String) r6)     // Catch:{ all -> 0x00f9 }
            r6 = 2010(0x7da, float:2.817E-42)
            r0.put(r5, r6)     // Catch:{ all -> 0x00f9 }
            goto L_0x011e
        L_0x00f9:
            r0 = move-exception
            goto L_0x00fe
        L_0x00fb:
            r0 = move-exception
            r16 = r6
        L_0x00fe:
            com.apm.insight.c r6 = com.apm.insight.b.a()     // Catch:{ all -> 0x0166 }
            r6.a((java.lang.String) r4, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0166 }
            goto L_0x011e
        L_0x0106:
            r16 = r6
            if (r2 == 0) goto L_0x011e
            java.lang.String r0 = "crash_md5"
            java.lang.String r6 = "default"
            java.lang.String r0 = r10.optString(r0, r6)     // Catch:{ all -> 0x0166 }
            boolean r0 = r2.a((java.lang.String) r0)     // Catch:{ all -> 0x0166 }
            if (r0 != 0) goto L_0x011e
            java.io.File r0 = r7.a     // Catch:{ all -> 0x0166 }
            com.apm.insight.l.i.a((java.io.File) r0)     // Catch:{ all -> 0x0166 }
            goto L_0x0179
        L_0x011e:
            java.lang.String r0 = "start_uuid"
            java.lang.String r6 = r1.a     // Catch:{ all -> 0x0166 }
            com.apm.insight.entity.a.a((org.json.JSONObject) r10, (java.lang.String) r14, (java.lang.String) r0, (java.lang.String) r6)     // Catch:{ all -> 0x0166 }
            java.lang.String r0 = "leak_threads_count"
            int r6 = r1.g     // Catch:{ all -> 0x0166 }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0166 }
            com.apm.insight.entity.a.a((org.json.JSONObject) r10, (java.lang.String) r14, (java.lang.String) r0, (java.lang.String) r6)     // Catch:{ all -> 0x0166 }
            java.lang.String r0 = "unknown"
            java.lang.String r0 = r10.optString(r3, r0)     // Catch:{ all -> 0x0166 }
            com.apm.insight.entity.a.a((org.json.JSONObject) r10, (java.lang.String) r14, (java.lang.String) r3, (java.lang.String) r0)     // Catch:{ all -> 0x0166 }
            com.apm.insight.l.r.a((org.json.JSONObject) r9)     // Catch:{ all -> 0x0166 }
            com.apm.insight.k.b$3 r0 = new com.apm.insight.k.b$3     // Catch:{ all -> 0x0166 }
            r6 = r20
            r0.<init>(r8, r12, r1)     // Catch:{ all -> 0x0161 }
            com.apm.insight.entity.b.a((org.json.JSONObject) r9, (org.json.JSONArray) r11, (com.apm.insight.entity.b.a) r0)     // Catch:{ all -> 0x0161 }
            boolean r0 = com.apm.insight.l.i.a((java.io.File) r12)     // Catch:{ all -> 0x0161 }
            if (r0 != 0) goto L_0x015b
            com.apm.insight.e.a r0 = com.apm.insight.e.a.a()     // Catch:{ all -> 0x0161 }
            java.lang.String r8 = r12.getAbsolutePath()     // Catch:{ all -> 0x0161 }
            com.apm.insight.e.a.a r8 = com.apm.insight.e.a.a.a(r8)     // Catch:{ all -> 0x0161 }
            r0.a((com.apm.insight.e.a.a) r8)     // Catch:{ all -> 0x0161 }
        L_0x015b:
            r8 = r16
            com.apm.insight.k.c.a((com.apm.insight.CrashType) r8, (org.json.JSONObject) r9)     // Catch:{ all -> 0x0161 }
            goto L_0x0179
        L_0x0161:
            r0 = move-exception
            goto L_0x016d
        L_0x0163:
            r6 = r20
            goto L_0x0179
        L_0x0166:
            r0 = move-exception
            goto L_0x016b
        L_0x0168:
            r0 = move-exception
            r19 = r6
        L_0x016b:
            r6 = r20
        L_0x016d:
            com.apm.insight.c r8 = com.apm.insight.b.a()
            r8.a((java.lang.String) r4, (java.lang.Throwable) r0)
            java.io.File r0 = r7.a
            com.apm.insight.l.i.a((java.io.File) r0)
        L_0x0179:
            r6 = r19
            goto L_0x0021
        L_0x017d:
            r6 = r20
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.k.b.a(com.apm.insight.k.b$b, boolean, com.apm.insight.runtime.h):void");
    }

    private void a(File file, C0012b bVar) {
    }

    private void a(HashMap<String, C0012b> hashMap) {
        File[] listFiles = o.f(this.c).listFiles();
        if (listFiles != null && listFiles.length != 0) {
            int i2 = 0;
            while (i2 < listFiles.length && i2 < 5) {
                File file = listFiles[i2];
                try {
                    if (file.isDirectory() && file.getName().endsWith(RequestConfiguration.MAX_AD_CONTENT_RATING_G)) {
                        String name = file.getName();
                        C0012b bVar = hashMap.get(name);
                        if (bVar == null) {
                            bVar = new C0012b(name);
                            hashMap.put(name, bVar);
                        }
                        JSONArray a2 = c.a(o.l(file), o.m(file));
                        bVar.g = a2.length();
                        if (bVar.g > 0) {
                            try {
                                i.a(o.n(file), a2, false);
                            } catch (Throwable unused) {
                            }
                        }
                        i2++;
                    } else {
                        i.a(file);
                        i2++;
                    }
                } catch (Throwable th) {
                    com.apm.insight.b.a().a("NPTH_CATCH", th);
                    i.a(file);
                }
            }
        }
    }

    private void a(HashMap<String, C0012b> hashMap, C0012b bVar) {
        File[] listFiles = o.d(this.c).listFiles();
        if (listFiles != null && listFiles.length != 0) {
            int i2 = 0;
            while (i2 < listFiles.length && i2 < 5) {
                File file = listFiles[i2];
                try {
                    if (file.isDirectory() && file.getName().endsWith(RequestConfiguration.MAX_AD_CONTENT_RATING_G)) {
                        String name = file.getName();
                        C0012b bVar2 = hashMap.get(name);
                        if (bVar2 == null) {
                            bVar2 = new C0012b(name);
                            hashMap.put(name, bVar2);
                        }
                        bVar2.c.add(new a(file, CrashType.NATIVE));
                        i2++;
                    } else {
                        i.a(file);
                        i2++;
                    }
                } catch (Throwable th) {
                    com.apm.insight.b.a().a("NPTH_CATCH", th);
                    i.a(file);
                }
            }
        }
    }

    private void a(HashMap<String, C0012b> hashMap, C0012b bVar, File file, String str) {
        HashMap<String, C0012b> hashMap2 = hashMap;
        C0012b bVar2 = bVar;
        File file2 = file;
        String str2 = str;
        if (str2.endsWith(RequestConfiguration.MAX_AD_CONTENT_RATING_G)) {
            String[] split = str2.split("_");
            CrashType crashType = null;
            if (split.length < 5) {
                bVar2.b.add(new a(file2, (CrashType) null));
                return;
            }
            try {
                long parseLong = Long.parseLong(split[0]);
                long parseLong2 = Long.parseLong(split[4]);
                String str3 = split[2];
                String str4 = split[1];
                char c2 = 65535;
                int hashCode = str4.hashCode();
                if (hashCode != -1109843021) {
                    if (hashCode != 96741) {
                        if (hashCode == 3254818 && str4.equals("java")) {
                            c2 = 1;
                        }
                    } else if (str4.equals("anr")) {
                        c2 = 2;
                    }
                } else if (str4.equals("launch")) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    crashType = CrashType.LAUNCH;
                } else if (c2 == 1) {
                    crashType = CrashType.JAVA;
                } else if (c2 == 2) {
                    crashType = CrashType.ANR;
                }
                C0012b bVar3 = hashMap2.get(str3);
                if (bVar3 == null) {
                    bVar3 = new C0012b(str3);
                    hashMap2.put(str3, bVar3);
                }
                a aVar = new a(file2, parseLong, crashType);
                aVar.c = parseLong2;
                if ((bVar3.d == null || bVar3.d.b > aVar.b) && crashType != null && crashType != CrashType.ANR && !str2.contains("ignore")) {
                    bVar3.d = aVar;
                }
                bVar3.b.add(aVar);
            } catch (Throwable unused) {
                bVar2.b.add(new a(file2, (CrashType) null));
                com.apm.insight.b.a().a("NPTH_CATCH", (Throwable) new RuntimeException("err format crashTime:" + str2));
            }
        } else {
            i.a(file);
        }
    }

    private boolean a(File file) {
        String[] list = file.list();
        if (list == null) {
            return false;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && str.endsWith("")) {
                return true;
            }
        }
        return false;
    }

    private void b(C0012b bVar, boolean z, com.apm.insight.runtime.h hVar) {
        boolean z2;
        final C0012b bVar2 = bVar;
        com.apm.insight.runtime.h hVar2 = hVar;
        if (bVar2.c.size() <= 1 && bVar2.c.isEmpty()) {
            bVar2.e = bVar2.d;
            return;
        }
        boolean b2 = p.b(this.c);
        bVar2.e = bVar2.d;
        com.apm.insight.nativecrash.b bVar3 = new com.apm.insight.nativecrash.b(this.c);
        for (a next : bVar2.c) {
            final File file = next.a;
            try {
                bVar3.a(file);
                JSONObject a2 = a(bVar3);
                if (a2 != null) {
                    if (a2.length() != 0) {
                        if (a2.length() != 0) {
                            if (!z) {
                                long optLong = a2.optLong("crash_time");
                                try {
                                    if (bVar2.e == null) {
                                        bVar2.e = next;
                                        bVar2.f = true;
                                        if (hVar2 != null) {
                                            if (!hVar2.a("default")) {
                                                bVar3.k();
                                            }
                                        }
                                        z2 = b2;
                                    } else {
                                        if (!bVar2.f) {
                                            z2 = b2;
                                            try {
                                                if (optLong < bVar2.e.b) {
                                                    bVar2.e = next;
                                                    if (hVar2 == null || hVar2.a("default")) {
                                                        if (!a(file)) {
                                                            a(file, bVar2);
                                                        }
                                                        bVar2.f = true;
                                                    } else {
                                                        bVar3.k();
                                                        b2 = z2;
                                                    }
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                com.apm.insight.b.a().a("NPTH_CATCH", th);
                                                i.a(file);
                                                b2 = z2;
                                            }
                                        } else {
                                            z2 = b2;
                                        }
                                        com.apm.insight.entity.a.a(a2, "filters", "aid", String.valueOf(a2.optJSONObject("header").opt("aid")));
                                        a2.optJSONObject("header").put("aid", 2010);
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    z2 = b2;
                                    com.apm.insight.b.a().a("NPTH_CATCH", th);
                                    i.a(file);
                                    b2 = z2;
                                }
                            } else {
                                z2 = b2;
                                if (hVar2 != null && !hVar2.a("default")) {
                                    bVar3.k();
                                }
                            }
                            com.apm.insight.entity.a.a(a2, "filters", "start_uuid", bVar2.a);
                            com.apm.insight.entity.a.a(a2, "filters", "crash_thread_name", a2.optString("crash_thread_name", "unknown"));
                            if (z2) {
                                c.a aVar = new c.a(a2, CrashType.NATIVE);
                                com.apm.insight.entity.b.a(a2, com.apm.insight.entity.b.a(aVar.c(), aVar.a(), s.a().b(aVar.b() == -1 ? System.currentTimeMillis() : aVar.b())), (b.a) new b.a() {
                                    public void a(JSONObject jSONObject) {
                                        d.a().a(jSONObject, file, o.a(b.this.c, bVar2.a));
                                    }
                                });
                                if (!bVar3.k()) {
                                    bVar3.h();
                                }
                            }
                            c.a(CrashType.NATIVE, a2);
                        } else {
                            z2 = b2;
                        }
                        b2 = z2;
                    }
                }
                z2 = b2;
                bVar3.k();
            } catch (Throwable th3) {
                th = th3;
                z2 = b2;
                com.apm.insight.b.a().a("NPTH_CATCH", th);
                i.a(file);
                b2 = z2;
            }
            b2 = z2;
        }
    }

    private void b(HashMap<String, C0012b> hashMap, C0012b bVar) {
        File[] listFiles = o.a(this.c).listFiles();
        if (listFiles != null) {
            Arrays.sort(listFiles, Collections.reverseOrder());
            for (File file : listFiles) {
                try {
                    if (!com.apm.insight.e.a.a().a(file.getAbsolutePath())) {
                        if (!i.g(file)) {
                            if (!com.apm.insight.g.a.a().b(file.getName())) {
                                if (!file.isFile()) {
                                    a(hashMap, bVar, file, file.getName());
                                }
                            }
                        }
                    }
                    i.a(file);
                } catch (Throwable th) {
                    com.apm.insight.b.a().a("NPTH_CATCH", th);
                }
            }
        }
    }

    private void c(HashMap<String, C0012b> hashMap, C0012b bVar) {
        i.a(o.b(this.c));
    }

    private void d() {
        if (this.f == null) {
            this.f = new C0012b("old_uuid");
            this.g = new HashMap<>();
            a(this.g);
            b(this.g, this.f);
            c(this.g, this.f);
            a(this.g, this.f);
            b(this.f, true, (com.apm.insight.runtime.h) null);
            a(this.f, true, (com.apm.insight.runtime.h) null);
            this.f = null;
            if (this.g.isEmpty()) {
                f();
            } else {
                g();
            }
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        if (!this.h && this.g != null) {
            if (!p.b(this.c)) {
                f();
            }
            boolean h2 = h();
            com.apm.insight.runtime.h hVar = new com.apm.insight.runtime.h(this.c);
            for (C0012b b2 : this.g.values()) {
                b(b2, h2, hVar);
            }
            for (C0012b a2 : this.g.values()) {
                a(a2, h2, hVar);
            }
            for (C0012b a3 : this.g.values()) {
                a(a3);
            }
            hVar.a();
            com.apm.insight.runtime.b.a();
            f();
        }
    }

    private void f() {
        this.h = true;
        this.g = null;
        NativeImpl.i();
    }

    /* access modifiers changed from: private */
    public void g() {
        if (!this.h) {
            if (!p.b(this.c) || (System.currentTimeMillis() - h.j() <= DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS && h.i().isApmExists() && !Npth.hasCrash())) {
                com.apm.insight.runtime.p.b().a(this.i, (long) DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
            } else {
                e();
            }
        }
    }

    private boolean h() {
        if (this.e == -1) {
            if (com.apm.insight.runtime.a.b() && com.apm.insight.runtime.a.g()) {
                this.e = 1;
            } else {
                this.e = 0;
            }
        }
        return this.e == 1;
    }

    private void i() {
        File[] listFiles = o.i(this.c).listFiles();
        if (listFiles != null) {
            int i2 = 0;
            while (i2 < listFiles.length && i2 < 5) {
                File file = listFiles[i2];
                if (file.getName().endsWith(".atmp")) {
                    com.apm.insight.a.a.a().a(file.getAbsolutePath());
                } else {
                    try {
                        e e2 = i.e(file.getAbsolutePath());
                        if (e2 != null) {
                            if (e2.b() != null) {
                                e2.b().put("upload_scene", "launch_scan");
                            }
                            if (e.a(e.d(), e2.e(), e2.d(), e2.f(), e2.g())) {
                                i.a(file);
                                i.a(e2.c());
                            }
                        } else {
                            i.a(file);
                        }
                    } catch (Throwable th) {
                        com.apm.insight.b.a().a("NPTH_CATCH", th);
                    }
                }
                i2++;
            }
        }
    }

    public void a(boolean z) {
        if (!Npth.isStopUpload() && z) {
            d();
            i();
            com.apm.insight.c.a.a();
        }
    }

    public void b() {
        try {
            if (this.h) {
                return;
            }
            if (com.apm.insight.l.a.b(h.g())) {
                com.apm.insight.runtime.p.b().a(this.j);
            }
        } catch (Throwable unused) {
        }
    }

    public boolean c() {
        return this.h;
    }
}
