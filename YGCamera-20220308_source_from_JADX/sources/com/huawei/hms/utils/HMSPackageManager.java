package com.huawei.hms.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.device.C0712a;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import java.security.cert.X509Certificate;
import java.util.List;

public class HMSPackageManager {

    /* renamed from: f */
    public static HMSPackageManager f1023f;

    /* renamed from: g */
    public static final Object f1024g = new Object();

    /* renamed from: h */
    public static final Object f1025h = new Object();

    /* renamed from: a */
    public final Context f1026a;

    /* renamed from: b */
    public final PackageManagerHelper f1027b;

    /* renamed from: c */
    public String f1028c;

    /* renamed from: d */
    public String f1029d;

    /* renamed from: e */
    public int f1030e;

    public HMSPackageManager(Context context) {
        this.f1026a = context;
        this.f1027b = new PackageManagerHelper(context);
    }

    public static HMSPackageManager getInstance(Context context) {
        synchronized (f1024g) {
            if (f1023f == null) {
                if (context.getApplicationContext() != null) {
                    f1023f = new HMSPackageManager(context.getApplicationContext());
                } else {
                    f1023f = new HMSPackageManager(context);
                }
                f1023f.mo14650b();
            }
        }
        return f1023f;
    }

    /* renamed from: a */
    public final Pair<String, String> mo14648a() {
        List<ResolveInfo> queryIntentServices = this.f1026a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
        if (queryIntentServices.size() == 0) {
            return null;
        }
        for (ResolveInfo next : queryIntentServices) {
            String str = next.serviceInfo.applicationInfo.packageName;
            Bundle bundle = next.serviceInfo.metaData;
            if (bundle == null) {
                HMSLog.m1377e("HMSPackageManager", "skip package " + str + " for metadata is null");
            } else if (!bundle.containsKey("hms_app_signer")) {
                HMSLog.m1377e("HMSPackageManager", "skip package " + str + " for no signer");
            } else if (!bundle.containsKey("hms_app_cert_chain")) {
                HMSLog.m1377e("HMSPackageManager", "skip package " + str + " for no cert chain");
            } else {
                String packageSignature = this.f1027b.getPackageSignature(str);
                if (mo14649a(str + ContainerUtils.FIELD_DELIMITER + packageSignature, bundle.getString("hms_app_signer"), bundle.getString("hms_app_cert_chain"))) {
                    return new Pair<>(str, packageSignature);
                }
                HMSLog.m1377e("HMSPackageManager", "checkSinger failed");
            }
        }
        return null;
    }

    /* renamed from: b */
    public final void mo14650b() {
        synchronized (f1025h) {
            Pair<String, String> a = mo14648a();
            if (a == null) {
                HMSLog.m1377e("HMSPackageManager", "Failed to find HMS apk");
                this.f1028c = null;
                this.f1029d = null;
                this.f1030e = 0;
                return;
            }
            this.f1028c = (String) a.first;
            this.f1029d = (String) a.second;
            this.f1030e = this.f1027b.getPackageVersionCode(getHMSPackageName());
            HMSLog.m1379i("HMSPackageManager", "Succeed to find HMS apk: " + this.f1028c + " version: " + this.f1030e);
        }
    }

    /* renamed from: c */
    public final boolean mo14651c() {
        PackageManager packageManager = this.f1026a.getPackageManager();
        if (packageManager == null) {
            HMSLog.m1377e("HMSPackageManager", "In isMinApkVersionEffective, Failed to get 'PackageManager' instance.");
            return true;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(getHMSPackageName(), 128).applicationInfo;
            if (applicationInfo != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey("com.huawei.hms.kit.api_level:hmscore") && (getHmsVersionCode() >= 50000000 || getHmsVersionCode() <= 19999999)) {
                HMSLog.m1379i("HMSPackageManager", "MinApkVersion is disabled.");
                return false;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.m1377e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.");
        }
        return true;
    }

    public String getHMSFingerprint() {
        String str = this.f1029d;
        return str == null ? "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05" : str;
    }

    public String getHMSPackageName() {
        refresh();
        String str = this.f1028c;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.f1027b.getPackageStates(str))) {
                HMSLog.m1379i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                mo14650b();
            }
            String str2 = this.f1028c;
            if (str2 != null) {
                return str2;
            }
        }
        if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.f1027b.getPackageStates("com.huawei.hwid")) || this.f1027b.getPackageSignature("com.huawei.hwid").equalsIgnoreCase("B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05")) {
        }
        return "com.huawei.hwid";
    }

    public PackageManagerHelper.PackageStates getHMSPackageStates() {
        if (TextUtils.isEmpty(this.f1028c) || TextUtils.isEmpty(this.f1029d)) {
            mo14650b();
            return this.f1027b.getPackageStates(this.f1028c);
        }
        PackageManagerHelper.PackageStates packageStates = this.f1027b.getPackageStates(this.f1028c);
        return (packageStates != PackageManagerHelper.PackageStates.ENABLED || this.f1029d.equals(this.f1027b.getPackageSignature(this.f1028c))) ? packageStates : PackageManagerHelper.PackageStates.NOT_INSTALLED;
    }

    public int getHmsVersionCode() {
        return this.f1027b.getPackageVersionCode(getHMSPackageName());
    }

    public boolean hmsVerHigherThan(int i) {
        if (this.f1030e >= i || !mo14651c()) {
            return true;
        }
        this.f1030e = this.f1027b.getPackageVersionCode(getHMSPackageName());
        if (this.f1030e >= i) {
            return true;
        }
        return false;
    }

    public boolean isApkUpdateNecessary(int i) {
        int hmsVersionCode = getHmsVersionCode();
        HMSLog.m1379i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", minimum version requirements: " + i);
        return mo14651c() && hmsVersionCode < i;
    }

    public void refresh() {
        if (TextUtils.isEmpty(this.f1028c) || TextUtils.isEmpty(this.f1029d)) {
            mo14650b();
        }
    }

    /* renamed from: a */
    public final boolean mo14649a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            HMSLog.m1377e("HMSPackageManager", "args is invalid");
            return false;
        }
        List<X509Certificate> b = C0712a.m457b(str3);
        if (b.size() == 0) {
            HMSLog.m1377e("HMSPackageManager", "certChain is empty");
            return false;
        } else if (!C0712a.m454a(C0712a.m447a(this.f1026a), b)) {
            HMSLog.m1377e("HMSPackageManager", "failed to verify cert chain");
            return false;
        } else {
            X509Certificate x509Certificate = b.get(b.size() - 1);
            if (!C0712a.m452a(x509Certificate, "Huawei CBG HMS")) {
                HMSLog.m1377e("HMSPackageManager", "CN is invalid");
                return false;
            } else if (!C0712a.m459b(x509Certificate, "Huawei CBG Cloud Security Signer")) {
                HMSLog.m1377e("HMSPackageManager", "OU is invalid");
                return false;
            } else if (C0712a.m453a(x509Certificate, str, str2)) {
                return true;
            } else {
                HMSLog.m1377e("HMSPackageManager", "signature is invalid: " + str);
                return false;
            }
        }
    }
}
