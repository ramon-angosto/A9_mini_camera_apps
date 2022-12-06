package com.xiaomi.push.service.timers;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMJobService;
import com.xiaomi.push.service.timers.a;
import com.xiaomi.smack.j;

@TargetApi(21)
public class c implements a.C0055a {
    Context a;
    JobScheduler b;
    private boolean c = false;

    c(Context context) {
        this.a = context;
        this.b = (JobScheduler) context.getSystemService("jobscheduler");
    }

    public void a() {
        this.c = false;
        this.b.cancel(1);
    }

    /* access modifiers changed from: package-private */
    public void a(long j) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j);
        builder.setRequiredNetworkType(1);
        builder.setPersisted(false);
        JobInfo build = builder.build();
        b.c("schedule Job = " + build.getId() + " in " + j);
        this.b.schedule(builder.build());
    }

    public void a(boolean z) {
        if (z || this.c) {
            long c2 = (long) j.c();
            if (z) {
                a();
                c2 -= SystemClock.elapsedRealtime() % c2;
            }
            this.c = true;
            a(c2);
        }
    }

    public boolean b() {
        return this.c;
    }
}
