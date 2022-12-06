package com.huawei.updatesdk.service.appmgr.bean;

import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.huawei.updatesdk.p025a.p026a.p031d.C0969a;
import com.huawei.updatesdk.p025a.p026a.p031d.C0975g;
import com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0991b;
import com.huawei.updatesdk.p039b.p040a.p041a.C0997b;
import com.huawei.updatesdk.p039b.p040a.p042b.C1000b;
import com.huawei.updatesdk.p039b.p049h.C1037b;
import java.util.List;
import java.util.Locale;

public class Param extends C0991b {
    private String fSha2_;
    private int isPre_;
    private List<String> keySets_;
    private int maple_;
    private String oldVersion_;
    private String package_;
    private String sSha2_;
    private int targetSdkVersion_;
    private int versionCode_;

    public Param() {
    }

    public Param(PackageInfo packageInfo) {
        this.package_ = packageInfo.packageName;
        this.versionCode_ = packageInfo.versionCode;
        String str = packageInfo.versionName;
        this.oldVersion_ = str == null ? "null" : str;
        this.targetSdkVersion_ = packageInfo.applicationInfo.targetSdkVersion;
        this.isPre_ = C1037b.m1954a(packageInfo);
        this.maple_ = C1037b.m1955a(this.package_);
        this.keySets_ = C1000b.m1824a().mo14953a(packageInfo);
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null && signatureArr.length > 0) {
            setApkSignature(signatureArr[0].toCharsString());
        }
        this.fSha2_ = C0997b.m1814a().mo14944a(packageInfo);
    }

    public void setApkFileSha256(String str) {
        this.fSha2_ = str;
    }

    public void setApkSignature(String str) {
        String b = C0975g.m1704b(C0969a.m1685a(C0975g.m1705c(str)));
        if (!TextUtils.isEmpty(b)) {
            this.sSha2_ = b.toLowerCase(Locale.getDefault());
        }
    }

    public void setMapleState(int i) {
        this.maple_ = i;
    }

    public void setPackageName(String str) {
        this.package_ = str;
    }

    public void setTargetSdkVersion(int i) {
        this.targetSdkVersion_ = i;
    }

    public void setVersionCode(int i) {
        this.versionCode_ = i;
    }

    public void setVersionName(String str) {
        this.oldVersion_ = str;
    }
}
