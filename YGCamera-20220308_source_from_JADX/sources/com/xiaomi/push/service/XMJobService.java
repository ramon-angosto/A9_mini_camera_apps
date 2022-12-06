package com.xiaomi.push.service;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1656bj;
import com.xiaomi.push.C1783fa;

public class XMJobService extends Service {

    /* renamed from: a */
    static Service f3591a;

    /* renamed from: a */
    private IBinder f3592a = null;

    /* renamed from: com.xiaomi.push.service.XMJobService$a */
    static class C1946a extends JobService {

        /* renamed from: a */
        Binder f3593a;

        /* renamed from: a */
        private Handler f3594a;

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a */
        private static class C1947a extends Handler {

            /* renamed from: a */
            JobService f3595a;

            C1947a(JobService jobService) {
                super(jobService.getMainLooper());
                this.f3595a = jobService;
            }

            public void handleMessage(Message message) {
                if (message.what == 1) {
                    JobParameters jobParameters = (JobParameters) message.obj;
                    C1524b.m2141a("Job finished " + jobParameters.getJobId());
                    this.f3595a.jobFinished(jobParameters, false);
                    if (jobParameters.getJobId() == 1) {
                        C1783fa.m3474a(false);
                    }
                }
            }
        }

        C1946a(Service service) {
            this.f3593a = null;
            this.f3593a = (Binder) C1656bj.m2697a((Object) this, "onBind", new Intent());
            C1656bj.m2697a((Object) this, "attachBaseContext", service);
        }

        public boolean onStartJob(JobParameters jobParameters) {
            C1524b.m2141a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f3594a == null) {
                this.f3594a = new C1947a(this);
            }
            Handler handler = this.f3594a;
            handler.sendMessage(Message.obtain(handler, 1, jobParameters));
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            C1524b.m2141a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    public IBinder onBind(Intent intent) {
        IBinder iBinder = this.f3592a;
        return iBinder != null ? iBinder : new Binder();
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f3592a = new C1946a(this).f3593a;
        }
        f3591a = this;
    }

    public void onDestroy() {
        super.onDestroy();
        f3591a = null;
    }
}
