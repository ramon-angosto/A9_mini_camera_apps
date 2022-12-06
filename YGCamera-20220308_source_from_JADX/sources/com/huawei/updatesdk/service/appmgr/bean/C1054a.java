package com.huawei.updatesdk.service.appmgr.bean;

import android.content.Context;
import com.huawei.updatesdk.p025a.p026a.p031d.p032h.C0981c;
import com.huawei.updatesdk.p025a.p026a.p031d.p032h.C0982d;
import com.huawei.updatesdk.p025a.p026a.p031d.p033i.C0984a;
import com.huawei.updatesdk.p025a.p034b.p035a.C0985a;
import com.huawei.updatesdk.p039b.p043b.C1005c;
import com.huawei.updatesdk.p039b.p044c.C1008b;

/* renamed from: com.huawei.updatesdk.service.appmgr.bean.a */
public class C1054a extends C1005c {
    public static final String APIMETHOD = "client.getMarketInfo";
    @SDKNetTransmission
    private String code = "0200";
    @SDKNetTransmission
    private int deviceType;
    @SDKNetTransmission
    private int international;
    @SDKNetTransmission
    private String lang;
    @SDKNetTransmission
    private String marketPkg;
    @SDKNetTransmission
    private int net;
    @SDKNetTransmission
    private String subsystem = "updatesdk";
    @SDKNetTransmission
    private int sysBits;
    @SDKNetTransmission
    private String version;

    public C1054a(String str) {
        mo14921a(APIMETHOD);
        this.marketPkg = str;
        this.sysBits = C0981c.m1740g();
        this.lang = C0981c.m1736e();
        mo14923b("8.0");
        Context a = C0985a.m1757c().mo14892a();
        this.version = C0981c.m1743h(a);
        this.deviceType = C1008b.m1856a().mo14973b();
        this.international = C0982d.m1749a();
        this.net = C0984a.m1754c(a);
    }
}
