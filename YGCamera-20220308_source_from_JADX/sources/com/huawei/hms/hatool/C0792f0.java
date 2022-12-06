package com.huawei.hms.hatool;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.UUID;

/* renamed from: com.huawei.hms.hatool.f0 */
public class C0792f0 {

    /* renamed from: a */
    public long f620a = 1800000;

    /* renamed from: b */
    public volatile boolean f621b = false;

    /* renamed from: c */
    public C0793a f622c = null;

    /* renamed from: com.huawei.hms.hatool.f0$a */
    public class C0793a {

        /* renamed from: a */
        public String f623a = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");

        /* renamed from: b */
        public boolean f624b;

        /* renamed from: c */
        public long f625c;

        public C0793a(long j) {
            this.f623a += "_" + j;
            this.f625c = j;
            this.f624b = true;
            boolean unused = C0792f0.this.f621b = false;
        }

        /* renamed from: a */
        public void mo13955a(long j) {
            if (C0792f0.this.f621b) {
                boolean unused = C0792f0.this.f621b = false;
                mo13957b(j);
            } else if (mo13958b(this.f625c, j) || mo13956a(this.f625c, j)) {
                mo13957b(j);
            } else {
                this.f625c = j;
                this.f624b = false;
            }
        }

        /* renamed from: a */
        public final boolean mo13956a(long j, long j2) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j);
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(j2);
            return (instance.get(1) == instance2.get(1) && instance.get(6) == instance2.get(6)) ? false : true;
        }

        /* renamed from: b */
        public final void mo13957b(long j) {
            C0841y.m1087c("hmsSdk", "getNewSession() session is flush!");
            this.f623a = UUID.randomUUID().toString();
            this.f623a = this.f623a.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            this.f623a += "_" + j;
            this.f625c = j;
            this.f624b = true;
        }

        /* renamed from: b */
        public final boolean mo13958b(long j, long j2) {
            return j2 - j >= C0792f0.this.f620a;
        }
    }

    /* renamed from: a */
    public String mo13952a() {
        C0793a aVar = this.f622c;
        if (aVar != null) {
            return aVar.f623a;
        }
        C0841y.m1092f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    }

    /* renamed from: a */
    public void mo13953a(long j) {
        C0793a aVar = this.f622c;
        if (aVar == null) {
            C0841y.m1087c("hmsSdk", "Session is first flush");
            this.f622c = new C0793a(j);
            return;
        }
        aVar.mo13955a(j);
    }

    /* renamed from: b */
    public boolean mo13954b() {
        C0793a aVar = this.f622c;
        if (aVar != null) {
            return aVar.f624b;
        }
        C0841y.m1092f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    }
}
