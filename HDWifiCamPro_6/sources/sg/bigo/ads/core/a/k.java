package sg.bigo.ads.core.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import sg.bigo.ads.common.f.c;
import sg.bigo.ads.common.utils.o;

public final class k extends BroadcastReceiver {
    private static final long a = TimeUnit.SECONDS.toMillis(3);
    private static volatile k b;
    private static a c;
    private final List<a> d = new ArrayList();
    private final Set<String> e = new HashSet();

    public interface a {
        void a(String str, long j);

        void a(String str, long j, long j2);

        void b(String str, long j);
    }

    static class b implements Runnable {
        private final Set<String> a;
        private final String b;

        private b(Set<String> set, String str) {
            this.a = set;
            this.b = str;
        }

        /* synthetic */ b(Set set, String str, byte b2) {
            this(set, str);
        }

        public final void run() {
            this.a.remove(this.b);
        }
    }

    private void a(Context context, String str) {
        long e2 = sg.bigo.ads.common.utils.b.e(context, str);
        long f = sg.bigo.ads.common.utils.b.f(context, str);
        if (e2 == 0) {
            e2 = System.currentTimeMillis();
        }
        sg.bigo.ads.common.k.a.a(0, 3, "InstReceiver", "handler inst, " + str + " inst, inst_ts=" + e2 + ", update_ts=" + f);
        if (e2 == f || f == 0) {
            for (a a2 : this.d) {
                a2.a(str, e2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r3, sg.bigo.ads.core.a.k.a r4, sg.bigo.ads.core.a.a r5) {
        /*
            java.lang.Class<sg.bigo.ads.core.a.k> r0 = sg.bigo.ads.core.a.k.class
            monitor-enter(r0)
            c = r5     // Catch:{ all -> 0x007e }
            sg.bigo.ads.core.a.k r5 = b     // Catch:{ all -> 0x007e }
            if (r5 != 0) goto L_0x0075
            sg.bigo.ads.core.a.k r5 = new sg.bigo.ads.core.a.k     // Catch:{ all -> 0x007e }
            r5.<init>()     // Catch:{ all -> 0x007e }
            b = r5     // Catch:{ all -> 0x007e }
            android.content.IntentFilter r5 = new android.content.IntentFilter     // Catch:{ all -> 0x007e }
            r5.<init>()     // Catch:{ all -> 0x007e }
            sg.bigo.ads.core.a.a r1 = c     // Catch:{ all -> 0x007e }
            java.lang.String r1 = r1.a     // Catch:{ all -> 0x007e }
            boolean r1 = sg.bigo.ads.common.utils.b.a(r3, r1)     // Catch:{ all -> 0x007e }
            if (r1 == 0) goto L_0x0031
            sg.bigo.ads.core.a.a r1 = c     // Catch:{ all -> 0x007e }
            java.lang.String r1 = r1.c     // Catch:{ all -> 0x007e }
            boolean r1 = sg.bigo.ads.common.utils.o.b(r1)     // Catch:{ all -> 0x007e }
            if (r1 != 0) goto L_0x0040
            sg.bigo.ads.core.a.a r1 = c     // Catch:{ all -> 0x007e }
            java.lang.String r1 = r1.c     // Catch:{ all -> 0x007e }
        L_0x002d:
            r5.addAction(r1)     // Catch:{ all -> 0x007e }
            goto L_0x0040
        L_0x0031:
            sg.bigo.ads.core.a.a r1 = c     // Catch:{ all -> 0x007e }
            java.lang.String r1 = r1.b     // Catch:{ all -> 0x007e }
            boolean r1 = sg.bigo.ads.common.utils.o.b(r1)     // Catch:{ all -> 0x007e }
            if (r1 != 0) goto L_0x0040
            sg.bigo.ads.core.a.a r1 = c     // Catch:{ all -> 0x007e }
            java.lang.String r1 = r1.b     // Catch:{ all -> 0x007e }
            goto L_0x002d
        L_0x0040:
            sg.bigo.ads.core.a.a r1 = c     // Catch:{ all -> 0x007e }
            java.lang.String r1 = r1.d     // Catch:{ all -> 0x007e }
            boolean r1 = sg.bigo.ads.common.utils.o.b(r1)     // Catch:{ all -> 0x007e }
            if (r1 != 0) goto L_0x0051
            sg.bigo.ads.core.a.a r1 = c     // Catch:{ all -> 0x007e }
            java.lang.String r1 = r1.d     // Catch:{ all -> 0x007e }
            r5.addAction(r1)     // Catch:{ all -> 0x007e }
        L_0x0051:
            sg.bigo.ads.core.a.a r1 = c     // Catch:{ all -> 0x007e }
            java.lang.String r1 = r1.e     // Catch:{ all -> 0x007e }
            boolean r1 = sg.bigo.ads.common.utils.o.b(r1)     // Catch:{ all -> 0x007e }
            if (r1 != 0) goto L_0x0062
            sg.bigo.ads.core.a.a r1 = c     // Catch:{ all -> 0x007e }
            java.lang.String r1 = r1.e     // Catch:{ all -> 0x007e }
            r5.addAction(r1)     // Catch:{ all -> 0x007e }
        L_0x0062:
            java.lang.String r1 = "package"
            r5.addDataScheme(r1)     // Catch:{ all -> 0x007e }
            sg.bigo.ads.core.a.k r1 = b     // Catch:{ all -> 0x007e }
            r3.registerReceiver(r1, r5)     // Catch:{ all -> 0x007e }
            java.lang.String r3 = "InstReceiver"
            java.lang.String r5 = "Register install receiver"
            r1 = 0
            r2 = 3
            sg.bigo.ads.common.k.a.a(r1, r2, r3, r5)     // Catch:{ all -> 0x007e }
        L_0x0075:
            sg.bigo.ads.core.a.k r3 = b     // Catch:{ all -> 0x007e }
            java.util.List<sg.bigo.ads.core.a.k$a> r3 = r3.d     // Catch:{ all -> 0x007e }
            r3.add(r4)     // Catch:{ all -> 0x007e }
            monitor-exit(r0)
            return
        L_0x007e:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.a.k.a(android.content.Context, sg.bigo.ads.core.a.k$a, sg.bigo.ads.core.a.a):void");
    }

    private void a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        for (a b2 : this.d) {
            b2.b(str, currentTimeMillis);
        }
    }

    static /* synthetic */ void a(k kVar, Context context, Intent intent) {
        String action = intent.getAction();
        String replaceFirst = intent.getDataString().replaceFirst("package:", "");
        if (!o.b(replaceFirst)) {
            boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
            sg.bigo.ads.common.k.a.a(0, 3, "InstReceiver", "handleReceiveInternal, " + replaceFirst + " update is " + booleanExtra + ", action=" + action);
            if (action.equals(c.b)) {
                if (kVar.e.contains(replaceFirst)) {
                    sg.bigo.ads.common.k.a.a(0, "InstReceiver", "handleReceiveInternal, " + replaceFirst + " in pkg set, return.");
                } else if (!booleanExtra) {
                    kVar.a(context, replaceFirst);
                }
            } else if (action.equals(c.c)) {
                if (!booleanExtra) {
                    kVar.a(context, replaceFirst);
                }
            } else if (action.equals(c.d)) {
                if (!booleanExtra) {
                    if (!sg.bigo.ads.common.utils.b.a(context, c.a)) {
                        kVar.e.add(replaceFirst);
                        c.a(3, new b(kVar.e, replaceFirst, (byte) 0), a);
                    }
                    kVar.a(replaceFirst);
                }
            } else if (action.equals(c.e)) {
                kVar.b(context, replaceFirst);
            }
        }
    }

    private void b(Context context, String str) {
        long e2 = sg.bigo.ads.common.utils.b.e(context, str);
        long f = sg.bigo.ads.common.utils.b.f(context, str);
        if (e2 == 0) {
            e2 = System.currentTimeMillis();
        }
        if (f == 0) {
            f = System.currentTimeMillis();
        }
        sg.bigo.ads.common.k.a.a(0, 3, "InstReceiver", "handler replaced, " + str + ", inst_ts=" + e2 + ", update_ts=" + f);
        for (a a2 : this.d) {
            a2.a(str, e2, f);
        }
    }

    public final void onReceive(final Context context, final Intent intent) {
        if (intent != null && intent.getAction() != null) {
            sg.bigo.ads.common.k.a.a(0, 3, "InstReceiver", "onReceive, ".concat(String.valueOf(intent)));
            c.a(3, new Runnable() {
                public final void run() {
                    k.a(k.this, context, intent);
                }
            });
        }
    }
}
