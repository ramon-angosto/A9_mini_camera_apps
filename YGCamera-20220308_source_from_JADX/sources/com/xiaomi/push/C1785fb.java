package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1783fa;

/* renamed from: com.xiaomi.push.fb */
class C1785fb implements C1783fa.C1784a {

    /* renamed from: a */
    private volatile long f2274a = 0;

    /* renamed from: a */
    private PendingIntent f2275a = null;

    /* renamed from: a */
    protected Context f2276a = null;

    public C1785fb(Context context) {
        this.f2276a = context;
    }

    /* renamed from: a */
    private void m3479a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        Class<AlarmManager> cls = AlarmManager.class;
        try {
            cls.getMethod("setExact", new Class[]{Integer.TYPE, Long.TYPE, PendingIntent.class}).invoke(alarmManager, new Object[]{0, Long.valueOf(j), pendingIntent});
        } catch (Exception e) {
            C1524b.m2155a((Throwable) e);
        }
    }

    /* renamed from: a */
    public void mo17569a() {
        if (this.f2275a != null) {
            try {
                ((AlarmManager) this.f2276a.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.f2275a);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f2275a = null;
                C1524b.m2159c("unregister timer");
                this.f2274a = 0;
                throw th;
            }
            this.f2275a = null;
            C1524b.m2159c("unregister timer");
            this.f2274a = 0;
        }
        this.f2274a = 0;
    }

    /* renamed from: a */
    public void mo17571a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.f2276a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.f2275a = PendingIntent.getBroadcast(this.f2276a, 0, intent, 0);
        if (Build.VERSION.SDK_INT >= 23) {
            C1656bj.m2697a((Object) alarmManager, "setExactAndAllowWhileIdle", 0, Long.valueOf(j), this.f2275a);
        } else if (Build.VERSION.SDK_INT >= 19) {
            m3479a(alarmManager, j, this.f2275a);
        } else {
            alarmManager.set(0, j, this.f2275a);
        }
        C1524b.m2159c("register timer " + j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (r7.f2274a < java.lang.System.currentTimeMillis()) goto L_0x0039;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo17570a(boolean r8) {
        /*
            r7 = this;
            android.content.Context r0 = r7.f2276a
            com.xiaomi.push.service.i r0 = com.xiaomi.push.service.C2061i.m5236a((android.content.Context) r0)
            long r0 = r0.mo18531a()
            r2 = 0
            if (r8 != 0) goto L_0x0015
            long r4 = r7.f2274a
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0015
            return
        L_0x0015:
            if (r8 == 0) goto L_0x001a
            r7.mo17569a()
        L_0x001a:
            if (r8 != 0) goto L_0x0033
            long r4 = r7.f2274a
            int r8 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r8 != 0) goto L_0x0023
            goto L_0x0033
        L_0x0023:
            long r2 = r7.f2274a
            long r2 = r2 + r0
            r7.f2274a = r2
            long r2 = r7.f2274a
            long r4 = java.lang.System.currentTimeMillis()
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 >= 0) goto L_0x0040
            goto L_0x0039
        L_0x0033:
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r2 = r2 % r0
            long r0 = r0 - r2
        L_0x0039:
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 + r0
            r7.f2274a = r2
        L_0x0040:
            android.content.Intent r8 = new android.content.Intent
            java.lang.String r0 = com.xiaomi.push.service.C2014bd.f3796o
            r8.<init>(r0)
            android.content.Context r0 = r7.f2276a
            java.lang.String r0 = r0.getPackageName()
            r8.setPackage(r0)
            long r0 = r7.f2274a
            r7.mo17571a(r8, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1785fb.mo17570a(boolean):void");
    }

    /* renamed from: a */
    public boolean m3483a() {
        return this.f2274a != 0;
    }
}
