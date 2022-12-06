package com.huawei.hms.availableupdate;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.utils.Checker;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: com.huawei.hms.availableupdate.c */
/* compiled from: ThreadWrapper */
public class C0636c implements C0645e {

    /* renamed from: b */
    public static final Executor f350b = Executors.newSingleThreadExecutor();

    /* renamed from: a */
    public final C0645e f351a;

    /* renamed from: com.huawei.hms.availableupdate.c$a */
    /* compiled from: ThreadWrapper */
    public static class C0637a implements C0649f {

        /* renamed from: a */
        public final /* synthetic */ C0649f f352a;

        /* renamed from: com.huawei.hms.availableupdate.c$a$a */
        /* compiled from: ThreadWrapper */
        public class C0638a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ int f353a;

            /* renamed from: b */
            public final /* synthetic */ C0653g f354b;

            public C0638a(int i, C0653g gVar) {
                this.f353a = i;
                this.f354b = gVar;
            }

            public void run() {
                C0637a.this.f352a.mo13231a(this.f353a, this.f354b);
            }
        }

        /* renamed from: com.huawei.hms.availableupdate.c$a$b */
        /* compiled from: ThreadWrapper */
        public class C0639b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ int f356a;

            /* renamed from: b */
            public final /* synthetic */ int f357b;

            /* renamed from: c */
            public final /* synthetic */ int f358c;

            /* renamed from: d */
            public final /* synthetic */ File f359d;

            public C0639b(int i, int i2, int i3, File file) {
                this.f356a = i;
                this.f357b = i2;
                this.f358c = i3;
                this.f359d = file;
            }

            public void run() {
                C0637a.this.f352a.mo13230a(this.f356a, this.f357b, this.f358c, this.f359d);
            }
        }

        public C0637a(C0649f fVar) {
            this.f352a = fVar;
        }

        /* renamed from: a */
        public void mo13231a(int i, C0653g gVar) {
            new Handler(Looper.getMainLooper()).post(new C0638a(i, gVar));
        }

        /* renamed from: a */
        public void mo13230a(int i, int i2, int i3, File file) {
            new Handler(Looper.getMainLooper()).post(new C0639b(i, i2, i3, file));
        }
    }

    /* renamed from: com.huawei.hms.availableupdate.c$b */
    /* compiled from: ThreadWrapper */
    public class C0640b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ C0649f f361a;

        /* renamed from: b */
        public final /* synthetic */ C0653g f362b;

        public C0640b(C0649f fVar, C0653g gVar) {
            this.f361a = fVar;
            this.f362b = gVar;
        }

        public void run() {
            C0636c.this.f351a.mo13229a(C0636c.m274b(this.f361a), this.f362b);
        }
    }

    public C0636c(C0645e eVar) {
        Checker.checkNonNull(eVar, "update must not be null.");
        this.f351a = eVar;
    }

    /* renamed from: b */
    public static C0649f m274b(C0649f fVar) {
        return new C0637a(fVar);
    }

    /* renamed from: a */
    public void mo13228a() {
        this.f351a.mo13228a();
    }

    /* renamed from: a */
    public void mo13229a(C0649f fVar, C0653g gVar) {
        f350b.execute(new C0640b(fVar, gVar));
    }
}
