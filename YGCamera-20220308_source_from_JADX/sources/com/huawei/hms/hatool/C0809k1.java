package com.huawei.hms.hatool;

import android.content.Context;

/* renamed from: com.huawei.hms.hatool.k1 */
public class C0809k1 {

    /* renamed from: a */
    public C0807k f685a;

    /* renamed from: b */
    public C0807k f686b;

    /* renamed from: c */
    public Context f687c;

    /* renamed from: d */
    public String f688d;

    public C0809k1(Context context) {
        if (context != null) {
            this.f687c = context.getApplicationContext();
        }
        this.f685a = new C0807k();
        this.f686b = new C0807k();
    }

    /* renamed from: a */
    public C0809k1 mo14034a(int i, String str) {
        C0807k kVar;
        C0841y.m1087c("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + i);
        if (!C0830t0.m1032b(str)) {
            str = "";
        }
        if (i == 0) {
            kVar = this.f685a;
        } else if (i != 1) {
            C0841y.m1092f("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
            return this;
        } else {
            kVar = this.f686b;
        }
        kVar.mo14007b(str);
        return this;
    }

    /* renamed from: a */
    public C0809k1 mo14035a(String str) {
        C0841y.m1087c("hmsSdk", "Builder.setAppID is execute");
        this.f688d = str;
        return this;
    }

    @Deprecated
    /* renamed from: a */
    public C0809k1 mo14036a(boolean z) {
        C0841y.m1087c("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
        this.f685a.mo14024j().mo13988a(z);
        this.f686b.mo14024j().mo13988a(z);
        return this;
    }

    /* renamed from: a */
    public void mo14037a() {
        if (this.f687c == null) {
            C0841y.m1084b("hmsSdk", "analyticsConf create(): context is null,create failed!");
            return;
        }
        C0841y.m1087c("hmsSdk", "Builder.create() is execute.");
        C0800h1 h1Var = new C0800h1("_hms_config_tag");
        h1Var.mo13977b(new C0807k(this.f685a));
        h1Var.mo13975a(new C0807k(this.f686b));
        C0794f1.m820a().mo13959a(this.f687c);
        C0797g1.m836a().mo13962a(this.f687c);
        C0815m1.m965c().mo14078a(h1Var);
        C0794f1.m820a().mo13960a(this.f688d);
    }

    @Deprecated
    /* renamed from: b */
    public C0809k1 mo14038b(boolean z) {
        C0841y.m1087c("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
        this.f685a.mo14024j().mo13990b(z);
        this.f686b.mo14024j().mo13990b(z);
        return this;
    }

    @Deprecated
    /* renamed from: c */
    public C0809k1 mo14039c(boolean z) {
        C0841y.m1087c("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
        this.f685a.mo14024j().mo13992c(z);
        this.f686b.mo14024j().mo13992c(z);
        return this;
    }
}
