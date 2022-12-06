package com.huawei.updatesdk.p039b.p043b;

import android.content.Context;
import android.os.Build;
import com.huawei.updatesdk.p025a.p026a.p031d.p032h.C0981c;
import com.huawei.updatesdk.p025a.p034b.p035a.C0985a;
import com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0993c;
import com.huawei.updatesdk.p039b.p044c.C1008b;
import com.huawei.updatesdk.p039b.p044c.C1009c;
import com.huawei.updatesdk.p039b.p049h.C1036a;
import com.huawei.updatesdk.service.appmgr.bean.SDKNetTransmission;

/* renamed from: com.huawei.updatesdk.b.b.c */
public class C1005c extends C0993c {
    @SDKNetTransmission
    private String buildNumber;
    @SDKNetTransmission
    private String density;
    @SDKNetTransmission
    private int emuiApiLevel = 0;
    @SDKNetTransmission
    private String firmwareVersion;
    @SDKNetTransmission
    private String manufacturer;
    @SDKNetTransmission
    private String phoneType;
    @SDKNetTransmission
    private String resolution;
    @SDKNetTransmission

    /* renamed from: ts */
    private long f1366ts;

    public C1005c() {
        Context a = C0985a.m1757c().mo14892a();
        this.f1366ts = System.currentTimeMillis();
        this.firmwareVersion = Build.VERSION.RELEASE.trim();
        this.buildNumber = C0981c.m1733c();
        C1009c a2 = C1008b.m1856a();
        this.phoneType = a2.mo14978f();
        this.density = C0981c.m1738f(a);
        this.resolution = C0981c.m1737e(a);
        this.emuiApiLevel = C1036a.m1952d().mo15011a();
        this.manufacturer = a2.mo14977e();
    }

    public String toString() {
        return getClass().getName() + " {\n\tmethod_: " + mo14922b() + "\n}";
    }
}
