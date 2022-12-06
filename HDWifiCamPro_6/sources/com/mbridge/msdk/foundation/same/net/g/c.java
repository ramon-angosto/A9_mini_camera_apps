package com.mbridge.msdk.foundation.same.net.g;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: RequestControlUtil */
public final class c {
    private final String a;
    private int b;
    private ArrayList<Integer> c;
    private ConcurrentHashMap<String, a> d;

    /* compiled from: RequestControlUtil */
    private static class b {
        /* access modifiers changed from: private */
        public static final c a = new c();
    }

    private c() {
        this.a = "IDErrorUtil";
        this.c = new ArrayList<>();
        this.d = new ConcurrentHashMap<>();
        com.mbridge.msdk.b.a b2 = com.mbridge.msdk.b.b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
        b2 = b2 == null ? com.mbridge.msdk.b.b.a().b() : b2;
        this.b = b2.ag() * 1000;
        if (b2.ah() == null || b2.ah().size() <= 0) {
            this.c.addAll(Arrays.asList(new Integer[]{-1, -10, -1201, -1202, -1203, -1205, -1206, -1208, -1301, -1302, -1305, -1306, -1307, -1915, 10602, 10603, 10604, 10609, 10610, 10616}));
        } else {
            this.c.addAll(b2.ah());
        }
    }

    public static c a() {
        return b.a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r3, int r4, java.lang.String r5, long r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.g.c$a> r0 = r2.d     // Catch:{ all -> 0x002b }
            boolean r0 = r0.containsKey(r3)     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r2)
            return
        L_0x000b:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0013
            monitor-exit(r2)
            return
        L_0x0013:
            java.util.ArrayList<java.lang.Integer> r0 = r2.c     // Catch:{ all -> 0x002b }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x002b }
            boolean r0 = r0.contains(r1)     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0029
            com.mbridge.msdk.foundation.same.net.g.c$a r0 = new com.mbridge.msdk.foundation.same.net.g.c$a     // Catch:{ all -> 0x002b }
            r0.<init>(r6, r4, r5)     // Catch:{ all -> 0x002b }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.g.c$a> r4 = r2.d     // Catch:{ all -> 0x002b }
            r4.put(r3, r0)     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r2)
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.g.c.a(java.lang.String, int, java.lang.String, long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006f, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.mbridge.msdk.foundation.same.net.g.c.a a(java.lang.String r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.g.c$a> r0 = r7.d     // Catch:{ all -> 0x0070 }
            boolean r0 = r0.containsKey(r8)     // Catch:{ all -> 0x0070 }
            r1 = 0
            if (r0 == 0) goto L_0x006e
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.g.c$a> r0 = r7.d     // Catch:{ all -> 0x0070 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0070 }
            com.mbridge.msdk.foundation.same.net.g.c$a r0 = (com.mbridge.msdk.foundation.same.net.g.c.a) r0     // Catch:{ all -> 0x0070 }
            if (r0 == 0) goto L_0x006e
            int r2 = r0.b     // Catch:{ all -> 0x0070 }
            r3 = -1
            if (r2 != r3) goto L_0x001b
            monitor-exit(r7)
            return r0
        L_0x001b:
            long r2 = r0.a     // Catch:{ all -> 0x0070 }
            int r4 = r7.b     // Catch:{ all -> 0x0070 }
            long r4 = (long) r4     // Catch:{ all -> 0x0070 }
            long r2 = r2 + r4
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0070 }
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x006c
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.g.c$a> r0 = r7.d     // Catch:{ all -> 0x0070 }
            r0.remove(r8)     // Catch:{ all -> 0x0070 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.g.c$a> r8 = r7.d     // Catch:{ all -> 0x0070 }
            int r8 = r8.size()     // Catch:{ all -> 0x0070 }
            if (r8 <= 0) goto L_0x006a
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.g.c$a> r8 = r7.d     // Catch:{ all -> 0x0070 }
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x0070 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0070 }
        L_0x0040:
            boolean r0 = r8.hasNext()     // Catch:{ all -> 0x0070 }
            if (r0 == 0) goto L_0x006a
            java.lang.Object r0 = r8.next()     // Catch:{ all -> 0x0070 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0070 }
            java.lang.Object r2 = r0.getValue()     // Catch:{ all -> 0x0070 }
            com.mbridge.msdk.foundation.same.net.g.c$a r2 = (com.mbridge.msdk.foundation.same.net.g.c.a) r2     // Catch:{ all -> 0x0070 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0070 }
            long r5 = r2.a     // Catch:{ all -> 0x0070 }
            long r3 = r3 - r5
            int r2 = r7.b     // Catch:{ all -> 0x0070 }
            long r5 = (long) r2     // Catch:{ all -> 0x0070 }
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x0040
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.g.c$a> r2 = r7.d     // Catch:{ all -> 0x0070 }
            java.lang.Object r0 = r0.getKey()     // Catch:{ all -> 0x0070 }
            r2.remove(r0)     // Catch:{ all -> 0x0070 }
            goto L_0x0040
        L_0x006a:
            monitor-exit(r7)
            return r1
        L_0x006c:
            monitor-exit(r7)
            return r0
        L_0x006e:
            monitor-exit(r7)
            return r1
        L_0x0070:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.g.c.a(java.lang.String):com.mbridge.msdk.foundation.same.net.g.c$a");
    }

    public final k a(d dVar) {
        int parseInt;
        String str = dVar.b().get("app_id");
        String str2 = dVar.b().get(MBridgeConstans.PROPERTIES_UNIT_ID);
        String str3 = dVar.b().get("ad_type");
        String str4 = dVar.b().get("token");
        String str5 = str + "_" + dVar.b().get("placement_id") + "_" + str2 + "_" + str3;
        a a2 = a(str5);
        if (a2 != null && !TextUtils.isEmpty(a2.c)) {
            try {
                if (a2.b != -1) {
                    return k.a(new JSONObject(a2.c), new com.mbridge.msdk.foundation.same.net.f.c(200, a2.c.getBytes(), (List<com.mbridge.msdk.foundation.same.net.c.b>) null));
                }
                if (!(!TextUtils.isEmpty(str4) || str3 == null || TextUtils.isEmpty(str3) || (parseInt = Integer.parseInt(str3)) == 287 || parseInt == 94)) {
                    if (System.currentTimeMillis() < ((long) (com.mbridge.msdk.b.b.a().d(str, str2).v() * 1000)) + a2.a) {
                        return k.a(new JSONObject(a2.c), new com.mbridge.msdk.foundation.same.net.f.c(200, a2.c.getBytes(), (List<com.mbridge.msdk.foundation.same.net.c.b>) null));
                    }
                    this.d.remove(str5);
                    return null;
                }
            } catch (Exception e) {
                q.d("IDErrorUtil", e.getMessage());
            }
        }
        return null;
    }

    /* compiled from: RequestControlUtil */
    private static class a {
        public long a;
        public int b;
        public String c;

        public a(long j, int i, String str) {
            this.a = j;
            this.b = i;
            this.c = str;
        }
    }
}
