package com.xiaomi.push;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1783fa;
import com.xiaomi.push.service.XMJobService;

/* renamed from: com.xiaomi.push.fc */
public class C1786fc implements C1783fa.C1784a {

    /* renamed from: a */
    JobScheduler f2277a;

    /* renamed from: a */
    Context f2278a;

    /* renamed from: a */
    private boolean f2279a = false;

    C1786fc(Context context) {
        this.f2278a = context;
        this.f2277a = (JobScheduler) context.getSystemService("jobscheduler");
    }

    /* renamed from: a */
    public void mo17569a() {
        this.f2279a = false;
        this.f2277a.cancel(1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo17572a(long j) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f2278a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j);
        builder.setRequiredNetworkType(1);
        builder.setPersisted(false);
        JobInfo build = builder.build();
        C1524b.m2159c("schedule Job = " + build.getId() + " in " + j);
        this.f2277a.schedule(builder.build());
    }

    /* renamed from: a */
    public void mo17570a(boolean z) {
        if (z || this.f2279a) {
            long b = (long) C1818ga.m3681b();
            if (z) {
                mo17569a();
                b -= SystemClock.elapsedRealtime() % b;
            }
            this.f2279a = true;
            mo17572a(b);
        }
    }

    /* renamed from: a */
    public boolean m3487a() {
        return this.f2279a;
    }
}
