package com.huawei.updatesdk.service.appmgr.bean;

import android.text.TextUtils;
import com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0991b;

/* renamed from: com.huawei.updatesdk.service.appmgr.bean.c */
public class C1056c extends C0991b {
    @SDKNetTransmission
    private String appName;
    @SDKNetTransmission
    private String downUrl;
    @SDKNetTransmission
    private long fileSize;
    @SDKNetTransmission
    private String pkgName;
    @SDKNetTransmission
    private String sha256;
    @SDKNetTransmission
    private long versionCode;
    @SDKNetTransmission
    private String versionName;

    /* renamed from: a */
    public String mo15135a() {
        return this.appName;
    }

    /* renamed from: b */
    public String mo15136b() {
        return this.downUrl;
    }

    /* renamed from: c */
    public long mo15137c() {
        return this.fileSize;
    }

    /* renamed from: d */
    public String mo15138d() {
        return this.pkgName;
    }

    /* renamed from: e */
    public String mo15139e() {
        return this.sha256;
    }

    /* renamed from: f */
    public boolean mo15140f() {
        return !TextUtils.isEmpty(this.sha256) && !TextUtils.isEmpty(this.downUrl) && this.fileSize > 0;
    }
}
