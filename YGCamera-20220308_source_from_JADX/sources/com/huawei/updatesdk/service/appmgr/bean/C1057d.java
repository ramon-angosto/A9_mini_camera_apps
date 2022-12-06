package com.huawei.updatesdk.service.appmgr.bean;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.huawei.updatesdk.p025a.p026a.p031d.p032h.C0978b;
import com.huawei.updatesdk.p025a.p026a.p031d.p032h.C0981c;
import com.huawei.updatesdk.p025a.p034b.p035a.C0985a;
import com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0991b;
import com.huawei.updatesdk.p039b.p043b.C1003a;
import com.huawei.updatesdk.p039b.p043b.C1005c;
import com.huawei.updatesdk.p039b.p044c.C1008b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.updatesdk.service.appmgr.bean.d */
public class C1057d extends C1005c {
    public static final String APIMETHOD = "client.updateCheck";
    public static final int DEFAULT_UPGRADE_RESULT = 0;
    public static final int FULL_UPGRADE_RESULT = 1;
    public static final int INSTALL_CHECK_DEFAULT = 0;
    private String agVersion_;
    private C0978b deviceSpecParams_;
    private int getSafeGame_;
    private int gmsSupport_;
    @SDKNetTransmission
    private int hardwareType;
    private int installCheck_;
    private int isFullUpgrade_;
    @SDKNetTransmission
    private int isUpdateSdk;
    @SDKNetTransmission
    private String locale;
    private int mapleVer_;
    private String packageName_;
    private C1058a pkgInfo_;
    private String serviceCountry_;
    @SDKNetTransmission
    private int serviceType;
    private int supportMaple_;
    private int versionCode_;
    private String version_;

    /* renamed from: com.huawei.updatesdk.service.appmgr.bean.d$a */
    public static class C1058a extends C0991b {
        private List<Param> params_;

        /* renamed from: a */
        public void mo15152a(List<Param> list) {
            this.params_ = list;
        }
    }

    public C1057d() {
        this.serviceType = 0;
        this.isUpdateSdk = 1;
        this.installCheck_ = 0;
        this.isFullUpgrade_ = 0;
        this.getSafeGame_ = 1;
        this.supportMaple_ = 0;
        this.locale = null;
        Context a = C0985a.m1757c().mo14892a();
        mo14921a(APIMETHOD);
        mo14923b("1.2");
        this.locale = C0981c.m1742h();
        mo15151g(C0981c.m1743h(a));
        mo15149f(C0981c.m1741g(a));
        mo15141a(C0981c.m1745i(a) ? 1 : 0);
        mo15148e(C0985a.m1757c().mo14892a().getPackageName());
        mo15150f(C1003a.m1831d().mo14954a());
        mo15147e(C0981c.m1734d().mo14889a());
        mo15144c(C0981c.m1734d().mo14891b());
        this.deviceSpecParams_ = new C0978b.C0980b(a).mo14887a(true).mo14888a();
        this.hardwareType = C1008b.m1856a().mo14973b();
    }

    public C1057d(List<Param> list) {
        this();
        C1058a aVar = new C1058a();
        aVar.mo15152a(list);
        mo15142a(aVar);
    }

    /* renamed from: a */
    public static C1057d m2007a(List<PackageInfo> list) {
        C1057d dVar = new C1057d();
        C1058a aVar = new C1058a();
        dVar.mo15142a(aVar);
        ArrayList arrayList = new ArrayList();
        aVar.mo15152a(arrayList);
        for (PackageInfo param : list) {
            arrayList.add(new Param(param));
        }
        return dVar;
    }

    /* renamed from: a */
    public void mo15141a(int i) {
        this.gmsSupport_ = i;
    }

    /* renamed from: a */
    public void mo15142a(C1058a aVar) {
        this.pkgInfo_ = aVar;
    }

    /* renamed from: b */
    public void mo15143b(int i) {
        this.installCheck_ = i;
    }

    /* renamed from: c */
    public void mo15144c(int i) {
        this.mapleVer_ = i;
    }

    /* renamed from: d */
    public void mo15145d(int i) {
        this.serviceType = i;
    }

    /* renamed from: d */
    public void mo15146d(String str) {
        this.agVersion_ = str;
    }

    /* renamed from: e */
    public void mo15147e(int i) {
        this.supportMaple_ = i;
    }

    /* renamed from: e */
    public void mo15148e(String str) {
        this.packageName_ = str;
    }

    /* renamed from: f */
    public void mo15149f(int i) {
        this.versionCode_ = i;
    }

    /* renamed from: f */
    public void mo15150f(String str) {
        this.serviceCountry_ = str;
    }

    /* renamed from: g */
    public void mo15151g(String str) {
        this.version_ = str;
    }
}
