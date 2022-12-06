package com.apm.insight.b;

import android.content.Context;
import android.os.SystemClock;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.h;
import com.apm.insight.l.i;
import com.apm.insight.l.l;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.a;
import com.apm.insight.runtime.o;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    static volatile boolean a = true;
    private static volatile boolean f;
    private long A = 0;
    private final Runnable B = new Runnable() {
        public void run() {
            try {
                b.this.a(200, 25);
            } catch (Throwable th) {
                com.apm.insight.b.a().a("NPTH_CATCH", th);
            }
        }
    };
    private int C = 0;
    private List<Pattern> D = null;
    private File E = null;
    Pattern b = null;
    private c c;
    private final Context d;
    private volatile boolean e;
    private long g = -1;
    private File h = null;
    /* access modifiers changed from: private */
    public boolean i = true;
    private JSONObject j;
    private JSONObject k;
    private String l = "unknown";
    private String m = "unknown";
    private String n = "unknown";
    private String o = "npth_inner_default";
    private JSONArray p;
    private JSONObject q;
    private int r = 0;
    private long s = -1;
    private JSONArray t;
    private JSONArray u;
    private JSONObject v;
    private boolean w;
    private final Object x = new Object();
    private volatile boolean y;
    private long z = -1;

    public b(Context context) {
        this.d = context;
    }

    private static String a(float f2) {
        return f2 <= 0.0f ? "0%" : f2 <= 0.1f ? "0% - 10%" : f2 <= 0.3f ? "10% - 30%" : f2 <= 0.6f ? "30% - 60%" : f2 <= 0.9f ? "60% - 90%" : "90% - 100%";
    }

    private static String a(float f2, float f3) {
        return f3 > 0.0f ? a(f2 / f3) : f2 > 0.0f ? "100%" : "0%";
    }

    private JSONObject a(String str, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONArray a2 = l.a(256, 128, jSONArray);
        if (a2.length() != jSONArray.length()) {
            this.r++;
        }
        try {
            jSONObject.put("thread_name", str);
            jSONObject.put("thread_stack", a2);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0211, code lost:
        if (r7 != 5) goto L_0x026f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0262  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02c7  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02d0 A[LOOP:3: B:98:0x01fb->B:158:0x02d0, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0363  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x03e8 A[EDGE_INSN: B:217:0x03e8->B:204:0x03e8 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x03d1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x03cb A[EDGE_INSN: B:223:0x03cb->B:199:0x03cb ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r28, org.json.JSONObject r29) {
        /*
            r27 = this;
            r0 = r27
            r1 = r29
            android.os.SystemClock.uptimeMillis()
            java.lang.String r2 = "\n"
            r3 = r28
            java.lang.String[] r2 = r3.split(r2)
            r3 = 3
            float[] r4 = new float[r3]
            r4 = {-1082130432, -1082130432, -1082130432} // fill-array
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            int r10 = r2.length
            java.lang.String r11 = "unknown"
            r15 = r11
            r16 = r15
            r13 = 0
            r14 = 0
            r17 = 0
        L_0x0038:
            java.lang.String r12 = "total"
            if (r13 >= r10) goto L_0x03e4
            r3 = r2[r13]
            boolean r18 = android.text.TextUtils.isEmpty(r3)
            if (r18 == 0) goto L_0x0050
            r18 = r2
            r24 = r7
            r23 = r8
            r19 = r10
            r21 = r11
            goto L_0x03d1
        L_0x0050:
            r18 = r2
            java.lang.String r2 = ""
            r19 = r10
            r10 = 1
            if (r14 == 0) goto L_0x03ab
            if (r14 == r10) goto L_0x02e2
            r10 = 2
            if (r14 == r10) goto L_0x02d8
            r10 = 3
            if (r14 == r10) goto L_0x006b
            r24 = r7
            r23 = r8
            r21 = r11
            r22 = r14
            goto L_0x03cb
        L_0x006b:
            java.lang.String r10 = "\\s"
            java.lang.String[] r10 = r3.split(r10)
            r21 = r11
            int r11 = r10.length
            r22 = r14
            r14 = 2
            if (r11 >= r14) goto L_0x007c
            r24 = r7
            goto L_0x00bd
        L_0x007c:
            r11 = 0
            r14 = r10[r11]
            java.lang.String r11 = "CPU"
            boolean r11 = r11.equalsIgnoreCase(r14)
            if (r11 == 0) goto L_0x00c9
            r11 = 1
            r14 = r10[r11]
            java.lang.String r11 = "usage"
            boolean r11 = r11.equalsIgnoreCase(r14)
            if (r11 == 0) goto L_0x00c9
            java.lang.String r2 = "ago"
            boolean r2 = r3.contains(r2)
            if (r2 == 0) goto L_0x009c
            r17 = 1
        L_0x009c:
            boolean r2 = r5.isEmpty()
            if (r2 == 0) goto L_0x00c1
            boolean r2 = r6.isEmpty()
            if (r2 == 0) goto L_0x00c1
            boolean r2 = r7.isEmpty()
            if (r2 == 0) goto L_0x00c1
            boolean r2 = r9.isEmpty()
            if (r2 == 0) goto L_0x00c1
            boolean r2 = r8.isEmpty()
            if (r2 != 0) goto L_0x00bb
            goto L_0x00c1
        L_0x00bb:
            r24 = r7
        L_0x00bd:
            r23 = r8
            goto L_0x03cb
        L_0x00c1:
            r24 = r7
            r23 = r8
            r0 = 4
            r14 = 4
            goto L_0x03ce
        L_0x00c9:
            boolean r11 = r5.isEmpty()
            if (r11 != 0) goto L_0x00e8
            boolean r11 = r6.isEmpty()
            if (r11 != 0) goto L_0x00e8
            boolean r11 = r7.isEmpty()
            if (r11 != 0) goto L_0x00e8
            boolean r11 = r9.isEmpty()
            if (r11 != 0) goto L_0x00e8
            boolean r11 = r8.isEmpty()
            if (r11 != 0) goto L_0x00e8
            goto L_0x00c1
        L_0x00e8:
            boolean r14 = r5.isEmpty()
            if (r14 == 0) goto L_0x00ff
            r14 = 1
            r11 = r10[r14]
            java.lang.String r14 = "TOTAL:"
            boolean r11 = r11.equalsIgnoreCase(r14)
            if (r11 == 0) goto L_0x00ff
            r1 = r2
            r0 = r5
            r24 = r7
            goto L_0x019a
        L_0x00ff:
            android.content.Context r11 = r0.d
            java.lang.String r11 = r11.getPackageName()
            boolean r11 = r3.contains(r11)
            if (r11 == 0) goto L_0x0163
            r11 = r2
            r3 = 0
        L_0x010d:
            int r14 = r10.length
            if (r3 >= r14) goto L_0x015a
            r14 = r10[r3]
            r23 = r11
            android.content.Context r11 = r0.d
            java.lang.String r11 = r11.getPackageName()
            boolean r11 = r14.contains(r11)
            if (r11 == 0) goto L_0x014d
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r14 = r10[r3]
            r0 = r10[r3]
            r24 = r7
            r7 = 47
            int r0 = r0.indexOf(r7)
            r7 = 1
            int r0 = r0 + r7
            r20 = r10[r3]
            int r20 = r20.length()
            int r1 = r20 + -1
            java.lang.String r0 = r14.substring(r0, r1)
            r11.append(r0)
            r0 = 95
            r11.append(r0)
            java.lang.String r0 = r11.toString()
            r11 = r0
            goto L_0x0151
        L_0x014d:
            r24 = r7
            r11 = r23
        L_0x0151:
            int r3 = r3 + 1
            r0 = r27
            r1 = r29
            r7 = r24
            goto L_0x010d
        L_0x015a:
            r24 = r7
            r23 = r11
            r1 = r23
            r0 = r24
            goto L_0x019a
        L_0x0163:
            r24 = r7
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L_0x0176
            java.lang.String r0 = "system_server:"
            boolean r0 = r3.contains(r0)
            if (r0 == 0) goto L_0x0176
            r1 = r2
            r0 = r6
            goto L_0x019a
        L_0x0176:
            boolean r0 = r9.isEmpty()
            if (r0 == 0) goto L_0x0187
            java.lang.String r0 = "kswapd"
            boolean r0 = r3.contains(r0)
            if (r0 == 0) goto L_0x0187
            r1 = r2
            r0 = r9
            goto L_0x019a
        L_0x0187:
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto L_0x0198
            java.lang.String r0 = "dex2oat"
            boolean r0 = r3.contains(r0)
            if (r0 == 0) goto L_0x0198
            r1 = r2
            r0 = r8
            goto L_0x019a
        L_0x0198:
            r1 = r2
            r0 = 0
        L_0x019a:
            if (r0 == 0) goto L_0x00bd
            r3 = 0
        L_0x019d:
            r7 = r10[r3]
            java.lang.String r11 = "%"
            boolean r7 = r7.contains(r11)
            if (r7 != 0) goto L_0x01ac
            int r3 = r3 + 1
            int r7 = r10.length
            if (r3 < r7) goto L_0x019d
        L_0x01ac:
            r7 = r10[r3]     // Catch:{ all -> 0x01de }
            java.lang.String r7 = r7.replace(r11, r2)     // Catch:{ all -> 0x01de }
            java.lang.Float r7 = java.lang.Float.valueOf(r7)     // Catch:{ all -> 0x01de }
            float r7 = r7.floatValue()     // Catch:{ all -> 0x01de }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x01de }
            r14.<init>()     // Catch:{ all -> 0x01de }
            r14.append(r1)     // Catch:{ all -> 0x01de }
            r14.append(r12)     // Catch:{ all -> 0x01de }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x01de }
            if (r0 != r5) goto L_0x01ce
            r23 = r8
            goto L_0x01d6
        L_0x01ce:
            r23 = r8
            int r8 = com.apm.insight.l.d.e()     // Catch:{ all -> 0x01e0 }
            float r8 = (float) r8     // Catch:{ all -> 0x01e0 }
            float r7 = r7 / r8
        L_0x01d6:
            java.lang.Float r7 = java.lang.Float.valueOf(r7)     // Catch:{ all -> 0x01e0 }
            r0.put(r14, r7)     // Catch:{ all -> 0x01e0 }
            goto L_0x01f8
        L_0x01de:
            r23 = r8
        L_0x01e0:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r1)
            r7.append(r12)
            java.lang.String r7 = r7.toString()
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            r0.put(r7, r8)
        L_0x01f8:
            int r3 = r3 + 3
            r7 = 0
        L_0x01fb:
            int r8 = r10.length
            if (r3 >= r8) goto L_0x03cb
            java.lang.String r14 = "softirq"
            if (r7 == 0) goto L_0x0220
            r8 = 1
            if (r7 == r8) goto L_0x021d
            r8 = 2
            if (r7 == r8) goto L_0x021a
            r8 = 3
            if (r7 == r8) goto L_0x0217
            r8 = 4
            if (r7 == r8) goto L_0x0214
            r8 = 5
            r26 = r7
            if (r7 == r8) goto L_0x0265
            goto L_0x026f
        L_0x0214:
            r26 = r7
            goto L_0x025a
        L_0x0217:
            r26 = r7
            goto L_0x024c
        L_0x021a:
            r26 = r7
            goto L_0x023e
        L_0x021d:
            r26 = r7
            goto L_0x0230
        L_0x0220:
            r8 = r10[r3]
            r26 = r7
            java.lang.String r7 = "user"
            boolean r7 = r7.equalsIgnoreCase(r8)
            if (r7 == 0) goto L_0x0230
            java.lang.String r8 = "user"
            r7 = 1
            goto L_0x0272
        L_0x0230:
            r7 = r10[r3]
            java.lang.String r8 = "kernel"
            boolean r7 = r8.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x023e
            java.lang.String r8 = "kernel"
            r7 = 2
            goto L_0x0272
        L_0x023e:
            r7 = r10[r3]
            java.lang.String r8 = "iowait"
            boolean r7 = r8.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x024c
            java.lang.String r8 = "iowait"
            r7 = 3
            goto L_0x0272
        L_0x024c:
            r7 = r10[r3]
            java.lang.String r8 = "irq"
            boolean r7 = r8.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x025a
            java.lang.String r8 = "irq"
            r7 = 4
            goto L_0x0272
        L_0x025a:
            r7 = r10[r3]
            boolean r7 = r14.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x0265
            r7 = 5
        L_0x0263:
            r8 = r14
            goto L_0x0272
        L_0x0265:
            r7 = r10[r3]
            boolean r7 = r14.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x026f
            r7 = 6
            goto L_0x0263
        L_0x026f:
            r7 = r26
            r8 = 0
        L_0x0272:
            if (r8 == 0) goto L_0x02c7
            int r14 = r3 + -1
            r14 = r10[r14]     // Catch:{ all -> 0x02aa }
            java.lang.String r14 = r14.replace(r11, r2)     // Catch:{ all -> 0x02aa }
            java.lang.Float r14 = java.lang.Float.valueOf(r14)     // Catch:{ all -> 0x02aa }
            float r14 = r14.floatValue()     // Catch:{ all -> 0x02aa }
            r25 = r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ac }
            r10.<init>()     // Catch:{ all -> 0x02ac }
            r10.append(r1)     // Catch:{ all -> 0x02ac }
            r10.append(r8)     // Catch:{ all -> 0x02ac }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x02ac }
            if (r0 != r5) goto L_0x029a
            r26 = r11
            goto L_0x02a2
        L_0x029a:
            r26 = r11
            int r11 = com.apm.insight.l.d.e()     // Catch:{ all -> 0x02ae }
            float r11 = (float) r11     // Catch:{ all -> 0x02ae }
            float r14 = r14 / r11
        L_0x02a2:
            java.lang.Float r11 = java.lang.Float.valueOf(r14)     // Catch:{ all -> 0x02ae }
            r0.put(r10, r11)     // Catch:{ all -> 0x02ae }
            goto L_0x02cb
        L_0x02aa:
            r25 = r10
        L_0x02ac:
            r26 = r11
        L_0x02ae:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r1)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            java.lang.Float r10 = java.lang.Float.valueOf(r10)
            r0.put(r8, r10)
            goto L_0x02cb
        L_0x02c7:
            r25 = r10
            r26 = r11
        L_0x02cb:
            r8 = 6
            if (r7 < r8) goto L_0x02d0
            goto L_0x03cb
        L_0x02d0:
            int r3 = r3 + 3
            r10 = r25
            r11 = r26
            goto L_0x01fb
        L_0x02d8:
            r24 = r7
            r23 = r8
            r21 = r11
            r22 = r14
            goto L_0x0367
        L_0x02e2:
            r24 = r7
            r23 = r8
            r21 = r11
            r22 = r14
            java.lang.String r3 = r3.trim()
            java.lang.String r0 = r3.toLowerCase()
            java.lang.String r1 = "shortmsg"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x0306
            r1 = 58
            int r1 = r3.indexOf(r1)
            r3.substring(r1)
            r20 = 0
            goto L_0x0319
        L_0x0306:
            java.lang.String r1 = "reason:"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x039b
            r1 = 58
            int r1 = r3.indexOf(r1)
            r3.substring(r1)
            r20 = 1
        L_0x0319:
            java.lang.String r1 = "input dispatch"
            boolean r1 = r0.contains(r1)
            java.lang.String r11 = "executing service"
            if (r1 == 0) goto L_0x0328
            java.lang.String r11 = "Input dispatching timed out"
        L_0x0325:
            r16 = r11
            goto L_0x0361
        L_0x0328:
            java.lang.String r1 = "broadcast of intent"
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L_0x0333
            java.lang.String r11 = "Broadcast of Intent"
            goto L_0x0325
        L_0x0333:
            java.lang.String r1 = "executing service"
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L_0x0354
            java.lang.String r0 = "null"
            boolean r0 = r0.equalsIgnoreCase(r15)
            if (r0 == 0) goto L_0x0325
            java.lang.String r0 = "service "
            int r0 = r3.indexOf(r0)
            int r0 = r0 + 8
            java.lang.String r0 = r3.substring(r0)
            java.lang.String r15 = r0.trim()
            goto L_0x0325
        L_0x0354:
            java.lang.String r1 = "service.startforeground"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x035f
            java.lang.String r11 = "not call Service.startForeground"
            goto L_0x0325
        L_0x035f:
            r16 = r21
        L_0x0361:
            if (r20 == 0) goto L_0x0367
            r0 = 4
            r14 = 2
            goto L_0x03ce
        L_0x0367:
            java.lang.String r0 = r3.trim()
            java.lang.String r1 = "Load:"
            boolean r3 = r0.startsWith(r1)
            if (r3 == 0) goto L_0x03cb
            java.lang.String r0 = r0.replace(r1, r2)
            java.lang.String r0 = r0.trim()
            java.lang.String r1 = "/"
            java.lang.String[] r0 = r0.split(r1)
            int r1 = r4.length
            int r2 = r0.length
            if (r1 != r2) goto L_0x0398
            r1 = 0
        L_0x0386:
            int r2 = r0.length
            if (r1 >= r2) goto L_0x0398
            r2 = r0[r1]
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            float r2 = r2.floatValue()
            r4[r1] = r2
            int r1 = r1 + 1
            goto L_0x0386
        L_0x0398:
            r0 = 4
            r14 = 3
            goto L_0x03ce
        L_0x039b:
            java.lang.String r1 = "appfreeze"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x03cb
            r3 = 10
            java.lang.String r0 = "AppFreeze"
            r16 = r0
            r14 = r3
            goto L_0x03cd
        L_0x03ab:
            r24 = r7
            r23 = r8
            r21 = r11
            r22 = r14
            java.lang.String r0 = r3.trim()
            java.lang.String r1 = "tag:"
            boolean r3 = r0.startsWith(r1)
            if (r3 == 0) goto L_0x03cb
            java.lang.String r0 = r0.replace(r1, r2)
            java.lang.String r0 = r0.trim()
            r15 = r0
            r0 = 4
            r14 = 1
            goto L_0x03ce
        L_0x03cb:
            r14 = r22
        L_0x03cd:
            r0 = 4
        L_0x03ce:
            if (r14 < r0) goto L_0x03d1
            goto L_0x03e8
        L_0x03d1:
            int r13 = r13 + 1
            r0 = r27
            r1 = r29
            r2 = r18
            r10 = r19
            r11 = r21
            r8 = r23
            r7 = r24
            r3 = 3
            goto L_0x0038
        L_0x03e4:
            r24 = r7
            r23 = r8
        L_0x03e8:
            r0 = r16
            java.lang.String r1 = "anr_tag"
            r2 = r29
            r2.put(r1, r15)
            java.lang.String r1 = java.lang.String.valueOf(r17)
            java.lang.String r3 = "anr_has_ago"
            r2.put(r3, r1)
            java.lang.String r1 = "anr_reason"
            r2.put(r1, r0)
            java.lang.String r0 = "app"
            r1 = r24
            a(r1, r2, r0)
            a(r5, r2, r12)
            boolean r0 = r6.isEmpty()
            java.lang.String r1 = "npth_anr_systemserver_total"
            java.lang.String r3 = "not found"
            if (r0 == 0) goto L_0x0417
            r2.put(r1, r3)
            goto L_0x0426
        L_0x0417:
            java.lang.Float r0 = com.apm.insight.l.r.a((java.util.Map<? super java.lang.String, java.lang.Float>) r6)
            float r0 = r0.floatValue()
            java.lang.String r0 = b((float) r0)
            r2.put(r1, r0)
        L_0x0426:
            boolean r0 = r9.isEmpty()
            java.lang.String r1 = "npth_anr_kswapd_total"
            if (r0 == 0) goto L_0x0432
            r2.put(r1, r3)
            goto L_0x0441
        L_0x0432:
            java.lang.Float r0 = com.apm.insight.l.r.a((java.util.Map<? super java.lang.String, java.lang.Float>) r9)
            float r0 = r0.floatValue()
            java.lang.String r0 = b((float) r0)
            r2.put(r1, r0)
        L_0x0441:
            boolean r0 = r23.isEmpty()
            if (r0 == 0) goto L_0x044d
            java.lang.String r0 = "npth_anr_dex2oat_total"
            r2.put(r0, r3)
            goto L_0x045e
        L_0x044d:
            java.lang.Float r0 = com.apm.insight.l.r.a((java.util.Map<? super java.lang.String, java.lang.Float>) r23)
            float r0 = r0.floatValue()
            java.lang.String r0 = b((float) r0)
            java.lang.String r1 = "npth_anr_dex2oat_total"
            r2.put(r1, r0)
        L_0x045e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.b.b.a(java.lang.String, org.json.JSONObject):void");
    }

    private static void a(HashMap<String, Float> hashMap, JSONObject jSONObject, String str) {
        String str2;
        String a2;
        String str3 = "npth_anr_" + str;
        if (hashMap.isEmpty()) {
            str2 = str3 + "_total";
            a2 = "not found";
        } else {
            float f2 = 0.0f;
            float f3 = 0.0f;
            float f4 = 0.0f;
            float f5 = 0.0f;
            float f6 = 0.0f;
            for (Map.Entry next : hashMap.entrySet()) {
                String str4 = (String) next.getKey();
                if (str4.endsWith("user")) {
                    f2 += ((Float) next.getValue()).floatValue();
                } else if (str4.endsWith("kernel")) {
                    f3 += ((Float) next.getValue()).floatValue();
                } else if (str4.endsWith("iowait")) {
                    f4 += ((Float) next.getValue()).floatValue();
                } else if (str4.endsWith("irq")) {
                    f5 += ((Float) next.getValue()).floatValue();
                } else if (str4.endsWith("softirq")) {
                    f6 += ((Float) next.getValue()).floatValue();
                }
            }
            float f7 = f2 + f3 + f4 + f5 + f6;
            jSONObject.put(str3 + "_total", b(f7));
            jSONObject.put(str3 + "_kernel_user_ratio", a(f3, f7));
            str2 = str3 + "_iowait_user_ratio";
            a2 = a(f4, f7);
        }
        jSONObject.put(str2, a2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0185  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.json.JSONArray r17) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            if (r2 != 0) goto L_0x0007
            return
        L_0x0007:
            r3 = 0
            r1.j = r3
            r1.q = r3
            r4 = 0
            r1.r = r4
            org.json.JSONArray r5 = new org.json.JSONArray
            r5.<init>()
            org.json.JSONArray r6 = new org.json.JSONArray
            r6.<init>()
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            java.lang.String r7 = "unknown"
            r1.l = r7
            r1.m = r7
            r1.n = r7
            r7 = 3
            int[] r7 = new int[r7]
            r7 = {0, 0, 0} // fill-array
            r10 = r0
            r0 = r3
            r8 = r4
            r9 = r8
        L_0x0030:
            int r11 = r17.length()
            if (r8 >= r11) goto L_0x01c1
            java.lang.String r11 = r2.optString(r8)
            boolean r12 = android.text.TextUtils.isEmpty(r11)
            java.lang.String r13 = "NPTH_CATCH"
            r14 = 40
            java.lang.String r15 = "main"
            r3 = 1
            if (r12 == 0) goto L_0x00ca
            int r11 = r10.length()
            if (r11 <= 0) goto L_0x00bb
            boolean r11 = android.text.TextUtils.isEmpty(r0)
            if (r11 != 0) goto L_0x00bb
            org.json.JSONObject r11 = r1.j
            if (r11 != 0) goto L_0x0064
            boolean r11 = r15.equals(r0)
            if (r11 == 0) goto L_0x0064
            org.json.JSONObject r11 = r1.c((org.json.JSONArray) r10)
            r1.j = r11
            goto L_0x006b
        L_0x0064:
            org.json.JSONObject r11 = r1.a((java.lang.String) r0, (org.json.JSONArray) r10)
            r5.put(r11)
        L_0x006b:
            boolean r11 = r15.equals(r0)     // Catch:{ all -> 0x007d }
            if (r11 != 0) goto L_0x007d
            int r11 = r0.indexOf(r14)     // Catch:{ all -> 0x007d }
            java.lang.String r11 = r0.substring(r4, r11)     // Catch:{ all -> 0x007d }
            java.lang.String r0 = r11.trim()     // Catch:{ all -> 0x007d }
        L_0x007d:
            r11 = r0
            boolean r0 = r1.a((java.lang.String) r11)
            if (r0 != 0) goto L_0x00bb
            int[] r0 = r1.b((org.json.JSONArray) r10)     // Catch:{ IllegalArgumentException -> 0x0089, all -> 0x0092 }
            goto L_0x0093
        L_0x0089:
            r0 = move-exception
            r12 = r0
            com.apm.insight.c r0 = com.apm.insight.b.a()
            r0.a((java.lang.String) r13, (java.lang.Throwable) r12)
        L_0x0092:
            r0 = 0
        L_0x0093:
            if (r0 != 0) goto L_0x0096
            goto L_0x00bb
        L_0x0096:
            r12 = r0[r4]
            r13 = r7[r4]
            if (r12 <= r13) goto L_0x00a2
            r12 = r0[r4]
            r7[r4] = r12
            r1.l = r11
        L_0x00a2:
            r12 = r0[r3]
            r13 = r7[r3]
            if (r12 <= r13) goto L_0x00ae
            r12 = r0[r3]
            r7[r3] = r12
            r1.m = r11
        L_0x00ae:
            r3 = 2
            r12 = r0[r3]
            r13 = r7[r3]
            if (r12 <= r13) goto L_0x00bb
            r0 = r0[r3]
            r7[r3] = r0
            r1.n = r11
        L_0x00bb:
            int r0 = r10.length()
            if (r0 <= 0) goto L_0x00c7
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            r10 = r0
        L_0x00c7:
            r0 = 0
            goto L_0x01bb
        L_0x00ca:
            if (r9 == 0) goto L_0x019d
            if (r9 == r3) goto L_0x00d0
            goto L_0x01bb
        L_0x00d0:
            java.lang.String r12 = " prio="
            boolean r12 = r11.contains(r12)
            if (r12 == 0) goto L_0x018f
            int r12 = r10.length()
            if (r12 <= 0) goto L_0x014c
            boolean r12 = android.text.TextUtils.isEmpty(r0)
            if (r12 != 0) goto L_0x014c
            org.json.JSONObject r12 = r1.j
            if (r12 != 0) goto L_0x00f5
            boolean r12 = r15.equals(r0)
            if (r12 == 0) goto L_0x00f5
            org.json.JSONObject r12 = r1.c((org.json.JSONArray) r10)
            r1.j = r12
            goto L_0x00fc
        L_0x00f5:
            org.json.JSONObject r12 = r1.a((java.lang.String) r0, (org.json.JSONArray) r10)
            r5.put(r12)
        L_0x00fc:
            boolean r12 = r15.equals(r0)     // Catch:{ all -> 0x010e }
            if (r12 != 0) goto L_0x010e
            int r12 = r0.indexOf(r14)     // Catch:{ all -> 0x010e }
            java.lang.String r12 = r0.substring(r4, r12)     // Catch:{ all -> 0x010e }
            java.lang.String r0 = r12.trim()     // Catch:{ all -> 0x010e }
        L_0x010e:
            r12 = r0
            boolean r0 = r1.a((java.lang.String) r12)
            if (r0 != 0) goto L_0x014c
            int[] r0 = r1.b((org.json.JSONArray) r10)     // Catch:{ IllegalArgumentException -> 0x011a, all -> 0x0123 }
            goto L_0x0124
        L_0x011a:
            r0 = move-exception
            r14 = r0
            com.apm.insight.c r0 = com.apm.insight.b.a()
            r0.a((java.lang.String) r13, (java.lang.Throwable) r14)
        L_0x0123:
            r0 = 0
        L_0x0124:
            if (r0 != 0) goto L_0x0127
            goto L_0x014c
        L_0x0127:
            r13 = r0[r4]
            r14 = r7[r4]
            if (r13 <= r14) goto L_0x0133
            r13 = r0[r4]
            r7[r4] = r13
            r1.l = r12
        L_0x0133:
            r13 = r0[r3]
            r14 = r7[r3]
            if (r13 <= r14) goto L_0x013f
            r13 = r0[r3]
            r7[r3] = r13
            r1.m = r12
        L_0x013f:
            r13 = 2
            r14 = r0[r13]
            r4 = r7[r13]
            if (r14 <= r4) goto L_0x014c
            r0 = r0[r13]
            r7[r13] = r0
            r1.n = r12
        L_0x014c:
            r0 = 34
            int r4 = r11.indexOf(r0, r3)
            java.lang.String r4 = r11.substring(r3, r4)
            boolean r12 = r15.equals(r4)
            if (r12 != 0) goto L_0x017f
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r4)
            java.lang.String r4 = "  ("
            r12.append(r4)
            r4 = 2
            int r0 = r11.indexOf(r0, r4)
            int r0 = r0 + r3
            java.lang.String r0 = r11.substring(r0)
            r12.append(r0)
            java.lang.String r0 = " )"
            r12.append(r0)
            java.lang.String r4 = r12.toString()
        L_0x017f:
            int r0 = r10.length()
            if (r0 <= 0) goto L_0x018a
            org.json.JSONArray r10 = new org.json.JSONArray
            r10.<init>()
        L_0x018a:
            r10.put(r11)
            r0 = r4
            goto L_0x01bb
        L_0x018f:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x0199
            r6.put(r11)
            goto L_0x01bb
        L_0x0199:
            r10.put(r11)
            goto L_0x01bb
        L_0x019d:
            java.lang.String r4 = "DALVIK THREADS"
            boolean r4 = r11.startsWith(r4)
            if (r4 != 0) goto L_0x01b7
            java.lang.String r4 = "suspend"
            boolean r4 = r11.startsWith(r4)
            if (r4 != 0) goto L_0x01b7
            java.lang.String r4 = "\""
            boolean r4 = r11.startsWith(r4)
            if (r4 == 0) goto L_0x01b6
            goto L_0x01b7
        L_0x01b6:
            r3 = r9
        L_0x01b7:
            r6.put(r11)
            r9 = r3
        L_0x01bb:
            int r8 = r8 + 1
            r3 = 0
            r4 = 0
            goto L_0x0030
        L_0x01c1:
            int r0 = r5.length()
            if (r0 <= 0) goto L_0x01e7
            r1.p = r6
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01e3 }
            r0.<init>()     // Catch:{ JSONException -> 0x01e3 }
            r1.q = r0     // Catch:{ JSONException -> 0x01e3 }
            org.json.JSONObject r0 = r1.q     // Catch:{ JSONException -> 0x01e3 }
            java.lang.String r2 = "thread_all_count"
            int r3 = r5.length()     // Catch:{ JSONException -> 0x01e3 }
            r0.put(r2, r3)     // Catch:{ JSONException -> 0x01e3 }
            org.json.JSONObject r0 = r1.q     // Catch:{ JSONException -> 0x01e3 }
            java.lang.String r2 = "thread_stacks"
            r0.put(r2, r5)     // Catch:{ JSONException -> 0x01e3 }
            goto L_0x01e7
        L_0x01e3:
            r0 = move-exception
            r0.printStackTrace()
        L_0x01e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.b.b.a(org.json.JSONArray):void");
    }

    private boolean a(long j2) {
        if (this.y) {
            this.y = false;
            b(j2);
        }
        return false;
    }

    private boolean a(String str) {
        if (this.D == null) {
            JSONArray c2 = a.c();
            if (c2 != null) {
                this.D = new LinkedList();
                this.o = c2.optString(0);
                for (int i2 = 1; i2 < c2.length(); i2++) {
                    try {
                        this.D.add(Pattern.compile(c2.optString(i2)));
                    } catch (Throwable unused) {
                    }
                }
            }
            if (this.D == null) {
                this.D = new LinkedList();
                this.D.add(Pattern.compile("^main$"));
                this.D.add(Pattern.compile("^default_npth_thread$"));
                this.D.add(Pattern.compile("^RenderThread$"));
                this.D.add(Pattern.compile("^Jit thread pool worker thread.*$"));
            }
        }
        for (Pattern matcher : this.D) {
            if (matcher.matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    private static String b(float f2) {
        return a(f2 / 100.0f);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:2|3|(1:5)(1:6)|7|8|9|(3:11|12|13)|17|(1:20)|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00db, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        com.apm.insight.b.a().a("NPTH_CATCH", r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ee, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ef, code lost:
        com.apm.insight.b.a().a("NPTH_CATCH", r13);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x005d */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0061 A[Catch:{ IOException -> 0x00e3, all -> 0x00db, all -> 0x00ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00e7 A[Catch:{ IOException -> 0x00e3, all -> 0x00db, all -> 0x00ee }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(long r13) {
        /*
            r12 = this;
            long r0 = r12.A
            long r2 = r12.z
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            java.lang.String r1 = "anr_trace"
            java.lang.String r2 = "\n"
            java.lang.String r3 = ".txt"
            r4 = 95
            r5 = 58
            r6 = 21
            r7 = 0
            r8 = 1
            java.lang.String r9 = "NPTH_CATCH"
            if (r0 == 0) goto L_0x00fb
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x005d }
            r12.s = r10     // Catch:{ all -> 0x005d }
            com.apm.insight.b.h r0 = com.apm.insight.b.g.b()     // Catch:{ all -> 0x005d }
            org.json.JSONArray r0 = r0.c()     // Catch:{ all -> 0x005d }
            r12.u = r0     // Catch:{ all -> 0x005d }
            r0 = 100
            org.json.JSONArray r0 = com.apm.insight.b.k.a((int) r0, (long) r13)     // Catch:{ all -> 0x005d }
            r12.t = r0     // Catch:{ all -> 0x005d }
            com.apm.insight.b.h r0 = com.apm.insight.b.g.b()     // Catch:{ all -> 0x005d }
            com.apm.insight.b.h$e r13 = r0.a((long) r13)     // Catch:{ all -> 0x005d }
            org.json.JSONObject r13 = r13.a()     // Catch:{ all -> 0x005d }
            r12.k = r13     // Catch:{ all -> 0x005d }
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ all -> 0x005d }
            r13.<init>()     // Catch:{ all -> 0x005d }
            r12.v = r13     // Catch:{ all -> 0x005d }
            android.content.Context r13 = r12.d     // Catch:{ all -> 0x005d }
            org.json.JSONObject r14 = r12.v     // Catch:{ all -> 0x005d }
            com.apm.insight.l.a.a((android.content.Context) r13, (org.json.JSONObject) r14)     // Catch:{ all -> 0x005d }
            boolean r13 = r12.g()     // Catch:{ all -> 0x005d }
            r12.w = r13     // Catch:{ all -> 0x005d }
            boolean r13 = com.apm.insight.Npth.hasCrash()     // Catch:{ all -> 0x005d }
            if (r13 != 0) goto L_0x005a
            r13 = r8
            goto L_0x005b
        L_0x005a:
            r13 = r7
        L_0x005b:
            r12.i = r13     // Catch:{ all -> 0x005d }
        L_0x005d:
            int r13 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00ee }
            if (r13 < r6) goto L_0x00e3
            long r13 = r12.s     // Catch:{ all -> 0x00ee }
            r12.g = r13     // Catch:{ all -> 0x00ee }
            java.lang.String r13 = com.apm.insight.l.o.b()     // Catch:{ all -> 0x00ee }
            java.io.File r14 = new java.io.File     // Catch:{ all -> 0x00ee }
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x00ee }
            android.content.Context r6 = r12.d     // Catch:{ all -> 0x00ee }
            java.io.File r6 = com.apm.insight.l.o.f((android.content.Context) r6)     // Catch:{ all -> 0x00ee }
            r0.<init>(r6, r13)     // Catch:{ all -> 0x00ee }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ee }
            r6.<init>()     // Catch:{ all -> 0x00ee }
            java.lang.String r10 = "trace_"
            r6.append(r10)     // Catch:{ all -> 0x00ee }
            android.content.Context r10 = r12.d     // Catch:{ all -> 0x00ee }
            java.lang.String r10 = com.apm.insight.l.a.c(r10)     // Catch:{ all -> 0x00ee }
            java.lang.String r4 = r10.replace(r5, r4)     // Catch:{ all -> 0x00ee }
            r6.append(r4)     // Catch:{ all -> 0x00ee }
            r6.append(r3)     // Catch:{ all -> 0x00ee }
            java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x00ee }
            r14.<init>(r0, r3)     // Catch:{ all -> 0x00ee }
            java.io.File r0 = r14.getParentFile()     // Catch:{ all -> 0x00ee }
            r0.mkdirs()     // Catch:{ all -> 0x00ee }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ee }
            r0.<init>()     // Catch:{ all -> 0x00ee }
            java.text.DateFormat r3 = com.apm.insight.l.b.a()     // Catch:{ all -> 0x00ee }
            java.util.Date r4 = new java.util.Date     // Catch:{ all -> 0x00ee }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00ee }
            r4.<init>(r5)     // Catch:{ all -> 0x00ee }
            java.lang.String r3 = r3.format(r4)     // Catch:{ all -> 0x00ee }
            r0.append(r3)     // Catch:{ all -> 0x00ee }
            r0.append(r2)     // Catch:{ all -> 0x00ee }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00ee }
            com.apm.insight.l.i.a((java.io.File) r14, (java.lang.String) r0, (boolean) r7)     // Catch:{ all -> 0x00ee }
            com.apm.insight.runtime.r.a((java.lang.String) r1, (java.lang.String) r13)     // Catch:{ all -> 0x00ee }
            java.lang.String r13 = r14.getAbsolutePath()     // Catch:{ all -> 0x00ee }
            com.apm.insight.nativecrash.NativeImpl.i(r13)     // Catch:{ all -> 0x00ee }
            java.lang.String r13 = r14.getAbsolutePath()     // Catch:{ IOException -> 0x00e3, all -> 0x00db }
            org.json.JSONArray r13 = com.apm.insight.l.i.b((java.lang.String) r13)     // Catch:{ IOException -> 0x00e3, all -> 0x00db }
            r12.p = r13     // Catch:{ IOException -> 0x00e3, all -> 0x00db }
            org.json.JSONArray r13 = r12.p     // Catch:{ IOException -> 0x00e3, all -> 0x00db }
            r12.a((org.json.JSONArray) r13)     // Catch:{ IOException -> 0x00e3, all -> 0x00db }
            goto L_0x00e3
        L_0x00db:
            r13 = move-exception
            com.apm.insight.c r14 = com.apm.insight.b.a()     // Catch:{ all -> 0x00ee }
            r14.a((java.lang.String) r9, (java.lang.Throwable) r13)     // Catch:{ all -> 0x00ee }
        L_0x00e3:
            org.json.JSONObject r13 = r12.j     // Catch:{ all -> 0x00ee }
            if (r13 != 0) goto L_0x00f6
            org.json.JSONObject r13 = com.apm.insight.b.d.a((boolean) r8)     // Catch:{ all -> 0x00ee }
            r12.j = r13     // Catch:{ all -> 0x00ee }
            goto L_0x00f6
        L_0x00ee:
            r13 = move-exception
            com.apm.insight.c r14 = com.apm.insight.b.a()
            r14.a((java.lang.String) r9, (java.lang.Throwable) r13)
        L_0x00f6:
            com.apm.insight.l.f.a()
            goto L_0x0194
        L_0x00fb:
            long r13 = r12.s     // Catch:{ all -> 0x018c }
            r12.g = r13     // Catch:{ all -> 0x018c }
            int r13 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x018c }
            if (r13 < r6) goto L_0x0181
            java.lang.String r13 = com.apm.insight.l.o.b()     // Catch:{ all -> 0x018c }
            java.io.File r14 = new java.io.File     // Catch:{ all -> 0x018c }
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x018c }
            android.content.Context r6 = r12.d     // Catch:{ all -> 0x018c }
            java.io.File r6 = com.apm.insight.l.o.f((android.content.Context) r6)     // Catch:{ all -> 0x018c }
            r0.<init>(r6, r13)     // Catch:{ all -> 0x018c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x018c }
            r6.<init>()     // Catch:{ all -> 0x018c }
            java.lang.String r10 = "trace"
            r6.append(r10)     // Catch:{ all -> 0x018c }
            android.content.Context r10 = r12.d     // Catch:{ all -> 0x018c }
            java.lang.String r10 = com.apm.insight.l.a.c(r10)     // Catch:{ all -> 0x018c }
            java.lang.String r4 = r10.replace(r5, r4)     // Catch:{ all -> 0x018c }
            r6.append(r4)     // Catch:{ all -> 0x018c }
            r6.append(r3)     // Catch:{ all -> 0x018c }
            java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x018c }
            r14.<init>(r0, r3)     // Catch:{ all -> 0x018c }
            java.io.File r0 = r14.getParentFile()     // Catch:{ all -> 0x018c }
            r0.mkdirs()     // Catch:{ all -> 0x018c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x018c }
            r0.<init>()     // Catch:{ all -> 0x018c }
            java.text.DateFormat r3 = com.apm.insight.l.b.a()     // Catch:{ all -> 0x018c }
            java.util.Date r4 = new java.util.Date     // Catch:{ all -> 0x018c }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x018c }
            r4.<init>(r5)     // Catch:{ all -> 0x018c }
            java.lang.String r3 = r3.format(r4)     // Catch:{ all -> 0x018c }
            r0.append(r3)     // Catch:{ all -> 0x018c }
            r0.append(r2)     // Catch:{ all -> 0x018c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x018c }
            com.apm.insight.l.i.a((java.io.File) r14, (java.lang.String) r0, (boolean) r7)     // Catch:{ all -> 0x018c }
            com.apm.insight.runtime.r.a((java.lang.String) r1, (java.lang.String) r13)     // Catch:{ all -> 0x018c }
            java.lang.String r13 = r14.getAbsolutePath()     // Catch:{ all -> 0x018c }
            com.apm.insight.nativecrash.NativeImpl.i(r13)     // Catch:{ all -> 0x018c }
            java.lang.String r13 = r14.getAbsolutePath()     // Catch:{ IOException -> 0x0181, all -> 0x0179 }
            org.json.JSONArray r13 = com.apm.insight.l.i.b((java.lang.String) r13)     // Catch:{ IOException -> 0x0181, all -> 0x0179 }
            r12.p = r13     // Catch:{ IOException -> 0x0181, all -> 0x0179 }
            org.json.JSONArray r13 = r12.p     // Catch:{ IOException -> 0x0181, all -> 0x0179 }
            r12.a((org.json.JSONArray) r13)     // Catch:{ IOException -> 0x0181, all -> 0x0179 }
            goto L_0x0181
        L_0x0179:
            r13 = move-exception
            com.apm.insight.c r14 = com.apm.insight.b.a()     // Catch:{ all -> 0x018c }
            r14.a((java.lang.String) r9, (java.lang.Throwable) r13)     // Catch:{ all -> 0x018c }
        L_0x0181:
            org.json.JSONObject r13 = r12.j     // Catch:{ all -> 0x018c }
            if (r13 != 0) goto L_0x0194
            org.json.JSONObject r13 = com.apm.insight.b.d.a((boolean) r8)     // Catch:{ all -> 0x018c }
            r12.j = r13     // Catch:{ all -> 0x018c }
            goto L_0x0194
        L_0x018c:
            r13 = move-exception
            com.apm.insight.c r14 = com.apm.insight.b.a()
            r14.a((java.lang.String) r9, (java.lang.Throwable) r13)
        L_0x0194:
            long r13 = r12.z
            r12.A = r13
            r13 = -1
            r12.z = r13
            long r13 = r12.A
            long r0 = r12.z
            int r13 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r13 != 0) goto L_0x01a9
            r13 = 1
            long r0 = r0 - r13
            r12.A = r0
        L_0x01a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.b.b.b(long):void");
    }

    private static void b(String str) {
        for (ICrashCallback onCrash : o.a().e()) {
            try {
                onCrash.onCrash(CrashType.ANR, str, (Thread) null);
            } catch (Throwable th) {
                com.apm.insight.b.a().a("NPTH_CATCH", th);
            }
        }
    }

    private int[] b(JSONArray jSONArray) {
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            String optString = jSONArray.optString(i2);
            int indexOf = (optString == null || optString.isEmpty()) ? -1 : optString.indexOf("utm=");
            if (indexOf > 0) {
                if (this.b == null) {
                    this.b = Pattern.compile("[^0-9]+");
                }
                String[] split = this.b.split(optString.substring(indexOf));
                if (split == null || split.length < 2) {
                    return null;
                }
                try {
                    int intValue = Integer.decode(split[1]).intValue();
                    int intValue2 = Integer.decode(split[2]).intValue();
                    return new int[]{intValue, intValue2, intValue + intValue2};
                } catch (Throwable unused) {
                    throw new IllegalArgumentException("Err stack line: " + optString);
                }
            } else {
                i2++;
            }
        }
        return null;
    }

    private String c(long j2) {
        long j3 = j2 - h.j();
        return j3 < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS ? "0 - 30s" : j3 < ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS ? "30s - 1min" : j3 < 120000 ? "1min - 2min" : j3 < PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS ? "2min - 5min" : j3 < TTAdConstant.AD_MAX_EVENT_TIME ? "5min - 10min" : j3 < 1800000 ? "10min - 30min" : j3 < 3600000 ? "30min - 1h" : "1h - ";
    }

    private JSONObject c(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONArray a2 = l.a(256, 128, jSONArray);
        if (a2.length() != jSONArray.length()) {
            this.r++;
        }
        try {
            jSONObject.put("thread_number", 1);
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < a2.length(); i2++) {
                sb.append(a2.getString(i2));
                sb.append(10);
            }
            jSONObject.put("mainStackFromTrace", sb.toString());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private boolean g() {
        boolean z2 = !com.apm.insight.l.a.a(this.d);
        if (!z2 || com.apm.insight.runtime.a.b.d().e() > 2000) {
            return z2;
        }
        return false;
    }

    private File h() {
        if (this.E == null) {
            File filesDir = this.d.getFilesDir();
            this.E = new File(filesDir, "has_anr_signal_" + com.apm.insight.l.a.c(this.d).replaceAll(":", "_"));
        }
        return this.E;
    }

    private boolean i() {
        return a.i();
    }

    public void a() {
        if (!this.e) {
            this.c = new c(this);
            this.g = h.j();
            this.e = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:148:0x0437 */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0268 A[SYNTHETIC, Splitter:B:100:0x0268] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0278 A[Catch:{ all -> 0x0273, all -> 0x03dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0330 A[Catch:{ all -> 0x0273, all -> 0x03dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0333 A[Catch:{ all -> 0x0273, all -> 0x03dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x033e A[Catch:{ all -> 0x0273, all -> 0x03dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x033f A[Catch:{ all -> 0x0273, all -> 0x03dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0358 A[Catch:{ all -> 0x0273, all -> 0x03dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x035b A[Catch:{ all -> 0x0273, all -> 0x03dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x038e A[Catch:{ all -> 0x0273, all -> 0x03dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x039b  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x03ad A[Catch:{ all -> 0x03a1, all -> 0x03de }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x03e0 A[SYNTHETIC, Splitter:B:138:0x03e0] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0409 A[Catch:{ all -> 0x0486 }] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x045e A[Catch:{ all -> 0x046a }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01eb A[Catch:{ all -> 0x0486 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01ee A[Catch:{ all -> 0x0486 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01f5 A[Catch:{ all -> 0x0486 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x020a A[Catch:{ all -> 0x0486 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0210 A[Catch:{ all -> 0x0486 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(int r24, int r25) {
        /*
            r23 = this;
            r1 = r23
            boolean r0 = com.apm.insight.b.f.a()
            long r2 = android.os.SystemClock.uptimeMillis()
            boolean r4 = r1.a((long) r2)
            android.content.Context r5 = r1.d
            r6 = 1
            java.lang.String r5 = com.apm.insight.b.d.a((android.content.Context) r5, (int) r6)
            long r7 = java.lang.System.currentTimeMillis()
            boolean r9 = android.text.TextUtils.isEmpty(r5)
            r10 = 0
            if (r9 == 0) goto L_0x0024
            if (r4 == 0) goto L_0x0024
            r9 = r6
            goto L_0x0025
        L_0x0024:
            r9 = r10
        L_0x0025:
            r11 = 20000(0x4e20, double:9.8813E-320)
            java.lang.String r14 = "normal"
            if (r4 != 0) goto L_0x004e
            boolean r4 = android.text.TextUtils.isEmpty(r5)
            if (r4 != 0) goto L_0x0032
            goto L_0x004e
        L_0x0032:
            java.lang.String r4 = "unknown"
            java.lang.String r15 = "unknown"
            java.lang.String r16 = "unknown"
            r6 = r7
            r19 = r10
            r21 = r19
            r10 = r16
            r25 = 0
            r8 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r18 = 0
            r22 = r15
            r15 = r4
            r4 = r22
            goto L_0x00c5
        L_0x004e:
            java.lang.Object r4 = r1.x
            monitor-enter(r4)
            if (r9 != 0) goto L_0x0055
            r7 = r6
            goto L_0x0056
        L_0x0055:
            r7 = r10
        L_0x0056:
            monitor-exit(r4)     // Catch:{ all -> 0x0491 }
            org.json.JSONObject r4 = r1.j
            if (r4 == 0) goto L_0x0071
            long r15 = java.lang.System.currentTimeMillis()
            r25 = r7
            long r6 = r1.g
            long r15 = r15 - r6
            int r4 = (r15 > r11 ? 1 : (r15 == r11 ? 0 : -1))
            if (r4 > 0) goto L_0x0073
            if (r9 == 0) goto L_0x006d
            java.lang.String r4 = "trace_only"
            goto L_0x006f
        L_0x006d:
            java.lang.String r4 = "trace_last"
        L_0x006f:
            r14 = r4
            goto L_0x007e
        L_0x0071:
            r25 = r7
        L_0x0073:
            boolean r4 = r1.y
            if (r4 == 0) goto L_0x007b
            r1.y = r10
            java.lang.String r14 = "trace_after"
        L_0x007b:
            r1.b((long) r2)
        L_0x007e:
            org.json.JSONObject r4 = r1.j
            java.lang.String r6 = r1.l
            java.lang.String r15 = r1.m
            java.lang.String r7 = r1.n
            org.json.JSONArray r8 = r1.p
            org.json.JSONArray r11 = r1.u
            org.json.JSONArray r12 = r1.t
            org.json.JSONObject r10 = r1.v
            org.json.JSONObject r13 = r1.k
            r18 = r4
            boolean r4 = r1.w
            r19 = r6
            r20 = r7
            long r6 = r1.s
            r21 = r4
            if (r9 != 0) goto L_0x00b8
            r4 = 0
            r1.j = r4
            r1.p = r4
            r1.t = r4
            r1.k = r4
            r1.u = r4
            java.lang.String r4 = "unknown"
            r1.l = r4
            java.lang.String r4 = "unknown"
            r1.m = r4
            java.lang.String r4 = "unknown"
            r1.n = r4
            r4 = 0
            r1.r = r4
        L_0x00b8:
            r4 = r15
            r15 = r19
            r19 = r25
            r25 = r13
            r13 = r18
            r18 = r10
            r10 = r20
        L_0x00c5:
            if (r9 != 0) goto L_0x0125
            boolean r20 = android.text.TextUtils.isEmpty(r5)
            if (r20 == 0) goto L_0x0125
            org.json.JSONObject r0 = r1.j
            if (r0 == 0) goto L_0x0103
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r1.g
            long r2 = r2 - r4
            r4 = 20000(0x4e20, double:9.8813E-320)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0103
            r2 = 0
            r1.j = r2
            r1.p = r2
            r1.t = r2
            r1.k = r2
            r1.u = r2
            java.lang.String r0 = "unknown"
            r1.l = r0
            java.lang.String r0 = "unknown"
            r1.m = r0
            java.lang.String r0 = "unknown"
            r1.n = r0
            r2 = 0
            r1.r = r2
            java.io.File r0 = r1.h
            if (r0 == 0) goto L_0x00ff
            com.apm.insight.l.i.a((java.io.File) r0)
        L_0x00ff:
            r3 = 0
            r1.h = r3
            return r2
        L_0x0103:
            org.json.JSONObject r0 = r1.j
            if (r0 == 0) goto L_0x0123
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r1.g
            long r2 = r2 - r4
            r4 = 2000(0x7d0, double:9.88E-321)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0123
            boolean r0 = com.apm.insight.nativecrash.NativeImpl.g()
            if (r0 == 0) goto L_0x0121
            java.io.File r0 = r23.h()
            com.apm.insight.l.i.a((java.io.File) r0)
        L_0x0121:
            r2 = 0
            return r2
        L_0x0123:
            r2 = 0
            return r2
        L_0x0125:
            if (r13 != 0) goto L_0x0165
            if (r12 != 0) goto L_0x015c
            com.apm.insight.b.h r16 = com.apm.insight.b.g.b()     // Catch:{ all -> 0x0165 }
            org.json.JSONArray r11 = r16.c()     // Catch:{ all -> 0x0165 }
            r16 = r11
            r11 = 100
            org.json.JSONArray r12 = com.apm.insight.b.k.a((int) r11, (long) r2)     // Catch:{ all -> 0x0157 }
            com.apm.insight.b.h r11 = com.apm.insight.b.g.b()     // Catch:{ all -> 0x0157 }
            com.apm.insight.b.h$e r2 = r11.a((long) r2)     // Catch:{ all -> 0x0157 }
            org.json.JSONObject r2 = r2.a()     // Catch:{ all -> 0x0157 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x0159 }
            r3.<init>()     // Catch:{ all -> 0x0159 }
            android.content.Context r11 = r1.d     // Catch:{ all -> 0x0154 }
            com.apm.insight.l.a.a((android.content.Context) r11, (org.json.JSONObject) r3)     // Catch:{ all -> 0x0154 }
            r18 = r3
            r11 = r16
            goto L_0x015e
        L_0x0154:
            r18 = r3
            goto L_0x0159
        L_0x0157:
            r2 = r25
        L_0x0159:
            r11 = r16
            goto L_0x0167
        L_0x015c:
            r2 = r25
        L_0x015e:
            boolean r3 = a     // Catch:{ all -> 0x0167 }
            org.json.JSONObject r13 = com.apm.insight.b.d.a((boolean) r3)     // Catch:{ all -> 0x0167 }
            goto L_0x0167
        L_0x0165:
            r2 = r25
        L_0x0167:
            r3 = r18
            if (r13 == 0) goto L_0x0490
            int r16 = r13.length()
            if (r16 <= 0) goto L_0x0490
            r25 = r5
            java.lang.String r5 = "pid"
            r16 = r0
            int r0 = android.os.Process.myPid()     // Catch:{ all -> 0x0486 }
            r13.put(r5, r0)     // Catch:{ all -> 0x0486 }
            java.lang.String r0 = "package"
            android.content.Context r5 = r1.d     // Catch:{ all -> 0x0486 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ all -> 0x0486 }
            r13.put(r0, r5)     // Catch:{ all -> 0x0486 }
            java.lang.String r0 = "is_remote_process"
            r5 = 0
            r13.put(r0, r5)     // Catch:{ all -> 0x0486 }
            java.lang.String r0 = "is_new_stack"
            r5 = 10
            r13.put(r0, r5)     // Catch:{ all -> 0x0486 }
            com.apm.insight.entity.a r0 = new com.apm.insight.entity.a     // Catch:{ all -> 0x0486 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x0486 }
            r5.<init>()     // Catch:{ all -> 0x0486 }
            r0.<init>(r5)     // Catch:{ all -> 0x0486 }
            java.lang.String r5 = "data"
            r17 = r10
            java.lang.String r10 = r13.toString()     // Catch:{ all -> 0x0486 }
            r0.a((java.lang.String) r5, (java.lang.Object) r10)     // Catch:{ all -> 0x0486 }
            java.lang.String r5 = "is_anr"
            r24 = r13
            r10 = 1
            java.lang.Integer r13 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0486 }
            r0.a((java.lang.String) r5, (java.lang.Object) r13)     // Catch:{ all -> 0x0486 }
            java.lang.String r5 = "anrType"
            r0.a((java.lang.String) r5, (java.lang.Object) r14)     // Catch:{ all -> 0x0486 }
            java.lang.String r5 = "history_message"
            r0.a((java.lang.String) r5, (java.lang.Object) r11)     // Catch:{ all -> 0x0486 }
            java.lang.String r5 = "current_message"
            r0.a((java.lang.String) r5, (java.lang.Object) r2)     // Catch:{ all -> 0x0486 }
            java.lang.String r2 = "pending_messages"
            r0.a((java.lang.String) r2, (java.lang.Object) r12)     // Catch:{ all -> 0x0486 }
            java.lang.String r2 = "anr_time"
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0486 }
            java.lang.Long r5 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0486 }
            r0.a((java.lang.String) r2, (java.lang.Object) r5)     // Catch:{ all -> 0x0486 }
            java.lang.String r2 = "crash_time"
            java.lang.Long r5 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0486 }
            r0.a((java.lang.String) r2, (java.lang.Object) r5)     // Catch:{ all -> 0x0486 }
            com.apm.insight.c.b.b()     // Catch:{ all -> 0x0486 }
            r0.c((org.json.JSONObject) r3)     // Catch:{ all -> 0x0486 }
            java.lang.String r2 = "anr_info"
            if (r9 == 0) goto L_0x01ee
            java.lang.String r5 = "Resons for no ANR_INFO:\n1. User click close button too quickly as soon as the ANR dialog appear.\n2. User close the app since can not stand the carton.\n3. Some OS force stop the process group without any hint dialog.\n\nThe ANR will be upload by the follow ways only:\n1. Receive the ANR signal(SIGQUIT).\n2. The app is forground or was forground last 2s.\n3. Happens in main process.\n4. Process was killed exactly."
            goto L_0x01f0
        L_0x01ee:
            r5 = r25
        L_0x01f0:
            r0.a((java.lang.String) r2, (java.lang.Object) r5)     // Catch:{ all -> 0x0486 }
            if (r8 == 0) goto L_0x01fa
            java.lang.String r2 = "dump_trace"
            r0.a((java.lang.String) r2, (java.lang.Object) r8)     // Catch:{ all -> 0x0486 }
        L_0x01fa:
            java.lang.String r2 = "all_thread_stacks"
            if (r9 != 0) goto L_0x0210
            org.json.JSONObject r3 = r1.q     // Catch:{ all -> 0x0486 }
            if (r3 == 0) goto L_0x020a
            org.json.JSONObject r3 = r1.q     // Catch:{ all -> 0x0486 }
            int r3 = r3.length()     // Catch:{ all -> 0x0486 }
            if (r3 != 0) goto L_0x0210
        L_0x020a:
            r3 = 0
            org.json.JSONObject r5 = com.apm.insight.l.v.b((java.lang.String) r3)     // Catch:{ all -> 0x0486 }
            goto L_0x0212
        L_0x0210:
            org.json.JSONObject r5 = r1.q     // Catch:{ all -> 0x0486 }
        L_0x0212:
            r0.a((java.lang.String) r2, (java.lang.Object) r5)     // Catch:{ all -> 0x0486 }
            com.apm.insight.runtime.a.f r2 = com.apm.insight.runtime.a.f.a()     // Catch:{ all -> 0x0486 }
            com.apm.insight.CrashType r3 = com.apm.insight.CrashType.ANR     // Catch:{ all -> 0x0486 }
            com.apm.insight.entity.a r2 = r2.a((com.apm.insight.CrashType) r3, (com.apm.insight.entity.a) r0)     // Catch:{ all -> 0x0486 }
            java.lang.String r0 = "is_background"
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r21)     // Catch:{ all -> 0x0486 }
            r2.a((java.lang.String) r0, (java.lang.Object) r3)     // Catch:{ all -> 0x0486 }
            java.lang.String r0 = "logcat"
            java.lang.String r3 = com.apm.insight.h.f()     // Catch:{ all -> 0x0486 }
            org.json.JSONArray r3 = com.apm.insight.runtime.k.b(r3)     // Catch:{ all -> 0x0486 }
            r2.a((java.lang.String) r0, (java.lang.Object) r3)     // Catch:{ all -> 0x0486 }
            java.lang.String r0 = "has_dump"
            java.lang.String r3 = "true"
            r2.a((java.lang.String) r0, (java.lang.Object) r3)     // Catch:{ all -> 0x0486 }
            java.lang.String r0 = "crash_uuid"
            com.apm.insight.CrashType r3 = com.apm.insight.CrashType.ANR     // Catch:{ all -> 0x0486 }
            r5 = 0
            java.lang.String r3 = com.apm.insight.h.a(r6, r3, r5, r5)     // Catch:{ all -> 0x0486 }
            r2.a((java.lang.String) r0, (java.lang.Object) r3)     // Catch:{ all -> 0x0486 }
            java.lang.String r0 = "jiffy"
            long r11 = com.apm.insight.runtime.q.a.a()     // Catch:{ all -> 0x0486 }
            java.lang.Long r3 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0486 }
            r2.a((java.lang.String) r0, (java.lang.Object) r3)     // Catch:{ all -> 0x0486 }
            org.json.JSONObject r0 = r2.h()     // Catch:{ all -> 0x0486 }
            java.lang.String r3 = "filters"
            org.json.JSONObject r0 = r0.optJSONObject(r3)     // Catch:{ all -> 0x0486 }
            org.json.JSONObject r3 = r2.h()     // Catch:{ all -> 0x0486 }
            com.apm.insight.entity.d.b(r3)     // Catch:{ all -> 0x0486 }
            if (r0 != 0) goto L_0x0278
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x0273 }
            r3.<init>()     // Catch:{ all -> 0x0273 }
            java.lang.String r0 = "filters"
            r2.a((java.lang.String) r0, (java.lang.Object) r3)     // Catch:{ all -> 0x03dc }
            goto L_0x0279
        L_0x0273:
            r4 = r25
            r3 = r0
            goto L_0x03de
        L_0x0278:
            r3 = r0
        L_0x0279:
            java.lang.String r0 = "anrType"
            r3.put(r0, r14)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "max_utm_thread"
            r3.put(r0, r15)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "max_stm_thread"
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "max_utm_stm_thread"
            r4 = r17
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "max_utm_thread_version"
            java.lang.String r4 = r1.o     // Catch:{ all -> 0x03dc }
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "crash_length"
            java.lang.String r4 = r1.c((long) r6)     // Catch:{ all -> 0x03dc }
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "disable_looper_monitor"
            boolean r4 = com.apm.insight.runtime.a.d()     // Catch:{ all -> 0x03dc }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03dc }
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "npth_force_apm_crash"
            boolean r4 = com.apm.insight.c.b.b()     // Catch:{ all -> 0x03dc }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03dc }
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "sdk_version"
            java.lang.String r4 = "1.3.8.nourl-alpha.7"
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "has_logcat"
            boolean r4 = r2.a()     // Catch:{ all -> 0x03dc }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03dc }
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "memory_leak"
            boolean r4 = r2.f()     // Catch:{ all -> 0x03dc }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03dc }
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "fd_leak"
            boolean r4 = r2.d()     // Catch:{ all -> 0x03dc }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03dc }
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "threads_leak"
            boolean r4 = r2.e()     // Catch:{ all -> 0x03dc }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03dc }
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "is_64_devices"
            boolean r4 = com.apm.insight.entity.Header.a()     // Catch:{ all -> 0x03dc }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03dc }
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "is_64_runtime"
            boolean r4 = com.apm.insight.nativecrash.NativeImpl.e()     // Catch:{ all -> 0x03dc }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03dc }
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "is_x86_devices"
            boolean r4 = com.apm.insight.entity.Header.b()     // Catch:{ all -> 0x03dc }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03dc }
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "has_meminfo_file"
            boolean r4 = r2.g()     // Catch:{ all -> 0x03dc }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03dc }
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "is_root"
            boolean r4 = com.apm.insight.nativecrash.b.m()     // Catch:{ all -> 0x03dc }
            if (r4 == 0) goto L_0x0333
            java.lang.String r4 = "true"
            goto L_0x0335
        L_0x0333:
            java.lang.String r4 = "false"
        L_0x0335:
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "anr_normal_trace"
            boolean r4 = r1.y     // Catch:{ all -> 0x03dc }
            if (r4 != 0) goto L_0x033f
            goto L_0x0340
        L_0x033f:
            r10 = 0
        L_0x0340:
            java.lang.String r4 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x03dc }
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "anr_no_run"
            java.lang.String r4 = java.lang.String.valueOf(r16)     // Catch:{ all -> 0x03dc }
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "crash_after_crash"
            boolean r4 = com.apm.insight.Npth.hasCrash()     // Catch:{ all -> 0x03dc }
            if (r4 == 0) goto L_0x035b
            java.lang.String r4 = "true"
            goto L_0x035d
        L_0x035b:
            java.lang.String r4 = "false"
        L_0x035d:
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "from_file"
            boolean r4 = com.apm.insight.b.d.a()     // Catch:{ all -> 0x03dc }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03dc }
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "has_dump"
            java.lang.String r4 = "true"
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "from_kill"
            java.lang.String r4 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x03dc }
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            java.lang.String r0 = "last_resume_activity"
            com.apm.insight.runtime.a.b r4 = com.apm.insight.runtime.a.b.d()     // Catch:{ all -> 0x03dc }
            java.lang.String r4 = r4.h()     // Catch:{ all -> 0x03dc }
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
            int r0 = r1.r     // Catch:{ all -> 0x03dc }
            if (r0 <= 0) goto L_0x0399
            java.lang.String r0 = "may_have_stack_overflow"
            int r4 = r1.r     // Catch:{ all -> 0x03dc }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03dc }
            r3.put(r0, r4)     // Catch:{ all -> 0x03dc }
        L_0x0399:
            if (r9 != 0) goto L_0x03ad
            r4 = r25
            r1.a((java.lang.String) r4, (org.json.JSONObject) r3)     // Catch:{ all -> 0x03a1 }
            goto L_0x03de
        L_0x03a1:
            r0 = move-exception
            r5 = r0
            com.apm.insight.c r0 = com.apm.insight.b.a()     // Catch:{ all -> 0x03de }
            java.lang.String r8 = "NPTH_CATCH"
            r0.a((java.lang.String) r8, (java.lang.Throwable) r5)     // Catch:{ all -> 0x03de }
            goto L_0x03de
        L_0x03ad:
            r4 = r25
            boolean r0 = r23.i()     // Catch:{ all -> 0x03de }
            if (r0 != 0) goto L_0x03de
            java.lang.String r0 = "aid"
            com.apm.insight.entity.Header r5 = r2.i()     // Catch:{ all -> 0x03de }
            org.json.JSONObject r5 = r5.f()     // Catch:{ all -> 0x03de }
            java.lang.String r8 = "aid"
            java.lang.Object r5 = r5.opt(r8)     // Catch:{ all -> 0x03de }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x03de }
            r3.put(r0, r5)     // Catch:{ all -> 0x03de }
            com.apm.insight.entity.Header r0 = r2.i()     // Catch:{ all -> 0x03de }
            org.json.JSONObject r0 = r0.f()     // Catch:{ all -> 0x03de }
            java.lang.String r5 = "aid"
            r8 = 2010(0x7da, float:2.817E-42)
            r0.put(r5, r8)     // Catch:{ all -> 0x03de }
            goto L_0x03de
        L_0x03dc:
            r4 = r25
        L_0x03de:
            if (r9 == 0) goto L_0x0409
            java.lang.String r0 = com.apm.insight.k.e.c()     // Catch:{ all -> 0x0486 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0486 }
            android.content.Context r4 = r1.d     // Catch:{ all -> 0x0486 }
            java.io.File r4 = com.apm.insight.l.o.a((android.content.Context) r4)     // Catch:{ all -> 0x0486 }
            com.apm.insight.CrashType r5 = com.apm.insight.CrashType.ANR     // Catch:{ all -> 0x0486 }
            r8 = 0
            java.lang.String r5 = com.apm.insight.h.a(r6, r5, r8, r8)     // Catch:{ all -> 0x0486 }
            r3.<init>(r4, r5)     // Catch:{ all -> 0x0486 }
            r1.h = r3     // Catch:{ all -> 0x0486 }
            java.lang.String r4 = r3.getName()     // Catch:{ all -> 0x0486 }
            org.json.JSONObject r2 = r2.h()     // Catch:{ all -> 0x0486 }
            boolean r5 = com.apm.insight.k.e.b()     // Catch:{ all -> 0x0486 }
            com.apm.insight.l.i.a(r3, r4, r0, r2, r5)     // Catch:{ all -> 0x0486 }
            goto L_0x0490
        L_0x0409:
            java.io.File r0 = r1.h     // Catch:{ all -> 0x0486 }
            if (r0 == 0) goto L_0x0415
            java.io.File r0 = r1.h     // Catch:{ all -> 0x0486 }
            com.apm.insight.l.i.a((java.io.File) r0)     // Catch:{ all -> 0x0486 }
            r5 = 0
            r1.h = r5     // Catch:{ all -> 0x0486 }
        L_0x0415:
            com.apm.insight.a.a r0 = com.apm.insight.a.a.a()     // Catch:{ all -> 0x0486 }
            com.apm.insight.CrashType r5 = com.apm.insight.CrashType.ANR     // Catch:{ all -> 0x0486 }
            java.lang.String r8 = com.apm.insight.h.e()     // Catch:{ all -> 0x0486 }
            r0.a((com.apm.insight.CrashType) r5, (long) r6, (java.lang.String) r8)     // Catch:{ all -> 0x0486 }
            java.io.File r0 = com.apm.insight.l.f.f()     // Catch:{ all -> 0x0437 }
            long r8 = r0.length()     // Catch:{ all -> 0x0437 }
            r10 = 1024(0x400, double:5.06E-321)
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x0437
            java.lang.String r0 = "has_system_traces"
            java.lang.String r5 = "true"
            r2.a((java.lang.String) r0, (java.lang.String) r5)     // Catch:{ all -> 0x0437 }
        L_0x0437:
            java.lang.String r0 = com.apm.insight.h.f()     // Catch:{ all -> 0x046a }
            java.io.File r0 = com.apm.insight.l.o.e((java.lang.String) r0)     // Catch:{ all -> 0x046a }
            java.lang.String r5 = com.apm.insight.h.f()     // Catch:{ all -> 0x046a }
            java.io.File r5 = com.apm.insight.l.o.f((java.lang.String) r5)     // Catch:{ all -> 0x046a }
            org.json.JSONArray r0 = com.apm.insight.nativecrash.c.a(r0, r5)     // Catch:{ all -> 0x046a }
            java.lang.String r5 = "leak_threads_count"
            int r8 = r0.length()     // Catch:{ all -> 0x046a }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x046a }
            r3.put(r5, r8)     // Catch:{ all -> 0x046a }
            int r3 = r0.length()     // Catch:{ all -> 0x046a }
            if (r3 <= 0) goto L_0x046a
            java.lang.String r3 = com.apm.insight.h.f()     // Catch:{ all -> 0x046a }
            java.io.File r3 = com.apm.insight.l.o.g((java.lang.String) r3)     // Catch:{ all -> 0x046a }
            r5 = 0
            com.apm.insight.l.i.a((java.io.File) r3, (org.json.JSONArray) r0, (boolean) r5)     // Catch:{ all -> 0x046a }
        L_0x046a:
            java.lang.String r0 = "mainStackFromTrace"
            r13 = r24
            java.lang.String r0 = r13.optString(r0)     // Catch:{ all -> 0x0486 }
            org.json.JSONArray r0 = com.apm.insight.entity.b.a((java.lang.String) r0)     // Catch:{ all -> 0x0486 }
            org.json.JSONObject r2 = r2.h()     // Catch:{ all -> 0x0486 }
            com.apm.insight.b.b$2 r3 = new com.apm.insight.b.b$2     // Catch:{ all -> 0x0486 }
            r3.<init>(r6)     // Catch:{ all -> 0x0486 }
            com.apm.insight.entity.b.a((org.json.JSONObject) r2, (org.json.JSONArray) r0, (com.apm.insight.entity.b.a) r3)     // Catch:{ all -> 0x0486 }
            b((java.lang.String) r4)     // Catch:{ all -> 0x0486 }
            goto L_0x0490
        L_0x0486:
            r0 = move-exception
            com.apm.insight.c r2 = com.apm.insight.b.a()
            java.lang.String r3 = "NPTH_CATCH"
            r2.a((java.lang.String) r3, (java.lang.Throwable) r0)
        L_0x0490:
            return r19
        L_0x0491:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0491 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.b.b.a(int, int):boolean");
    }

    public void b() {
        if (this.e) {
            this.e = false;
            c cVar = this.c;
            if (cVar != null) {
                cVar.b();
            }
            this.c = null;
        }
    }

    public void c() {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void d() {
        if (!f) {
            synchronized (this.x) {
                if (!f) {
                    this.B.run();
                }
            }
        }
    }

    public void e() {
        if (NativeImpl.g()) {
            try {
                i.a(h(), String.valueOf(this.C + 1), false);
            } catch (Throwable th) {
                com.apm.insight.b.a().a("NPTH_CATCH", th);
            }
        }
        this.z = SystemClock.uptimeMillis();
        this.y = true;
    }

    public void f() {
        File h2 = h();
        try {
            this.C = Integer.decode(i.c(h2.getAbsolutePath())).intValue();
            if (this.C >= 2) {
                NativeImpl.a(false);
            } else {
                NativeImpl.a(true);
            }
        } catch (IOException unused) {
            NativeImpl.a(true);
        } catch (Throwable unused2) {
            i.a(h2);
        }
    }
}
