package com.huawei.hms.opendevice;

import android.content.Context;

/* renamed from: com.huawei.hms.opendevice.f */
/* compiled from: AutoInitRunnable */
public class C0852f implements Runnable {

    /* renamed from: a */
    public Context f788a;

    public C0852f(Context context) {
        this.f788a = context;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:40|41|48) */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        com.huawei.hms.support.log.HMSLog.m1379i("AutoInit", "push kit sdk not exists");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x008e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r9 = this;
            java.lang.String r0 = "push kit sdk not exists"
            java.lang.String r1 = "Push init failed"
            java.lang.String r2 = "AutoInit"
            com.huawei.hms.aaid.constant.ErrorEnum r3 = com.huawei.hms.aaid.constant.ErrorEnum.SUCCESS     // Catch:{ Exception -> 0x0092 }
            int r3 = r3.getInternalCode()     // Catch:{ Exception -> 0x0092 }
            r4 = 0
            android.content.Context r5 = r9.f788a     // Catch:{ ApiException -> 0x0029 }
            com.huawei.hms.aaid.HmsInstanceId r5 = com.huawei.hms.aaid.HmsInstanceId.getInstance(r5)     // Catch:{ ApiException -> 0x0029 }
            android.content.Context r6 = r9.f788a     // Catch:{ ApiException -> 0x0029 }
            java.lang.String r6 = com.huawei.hms.utils.Util.getAppId(r6)     // Catch:{ ApiException -> 0x0029 }
            java.lang.String r4 = r5.getToken(r6, r4)     // Catch:{ ApiException -> 0x0029 }
            java.lang.String r5 = "Push init succeed"
            com.huawei.hms.support.log.HMSLog.m1379i(r2, r5)     // Catch:{ ApiException -> 0x0029 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ ApiException -> 0x0029 }
            if (r5 == 0) goto L_0x0031
            return
        L_0x0029:
            r3 = move-exception
            int r3 = r3.getStatusCode()     // Catch:{ Exception -> 0x0092 }
            com.huawei.hms.support.log.HMSLog.m1377e(r2, r1)     // Catch:{ Exception -> 0x0092 }
        L_0x0031:
            android.content.Context r5 = r9.f788a     // Catch:{ NameNotFoundException -> 0x008e }
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch:{ NameNotFoundException -> 0x008e }
            android.content.Context r6 = r9.f788a     // Catch:{ NameNotFoundException -> 0x008e }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ NameNotFoundException -> 0x008e }
            r7 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo(r6, r7)     // Catch:{ NameNotFoundException -> 0x008e }
            android.os.Bundle r6 = r5.metaData     // Catch:{ NameNotFoundException -> 0x008e }
            if (r6 == 0) goto L_0x008a
            android.os.Bundle r5 = r5.metaData     // Catch:{ NameNotFoundException -> 0x008e }
            java.lang.String r6 = "com.huawei.hms.client.service.name:push"
            java.lang.String r5 = r5.getString(r6)     // Catch:{ NameNotFoundException -> 0x008e }
            if (r5 == 0) goto L_0x008a
            android.content.Intent r5 = new android.content.Intent     // Catch:{ NameNotFoundException -> 0x008e }
            java.lang.String r6 = "com.huawei.push.action.MESSAGING_EVENT"
            r5.<init>(r6)     // Catch:{ NameNotFoundException -> 0x008e }
            android.content.Context r6 = r9.f788a     // Catch:{ NameNotFoundException -> 0x008e }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ NameNotFoundException -> 0x008e }
            r5.setPackage(r6)     // Catch:{ NameNotFoundException -> 0x008e }
            android.os.Bundle r6 = new android.os.Bundle     // Catch:{ NameNotFoundException -> 0x008e }
            r6.<init>()     // Catch:{ NameNotFoundException -> 0x008e }
            java.lang.String r7 = "message_type"
            java.lang.String r8 = "new_token"
            r6.putString(r7, r8)     // Catch:{ NameNotFoundException -> 0x008e }
            java.lang.String r7 = "device_token"
            r6.putString(r7, r4)     // Catch:{ NameNotFoundException -> 0x008e }
            java.lang.String r4 = "error"
            r6.putInt(r4, r3)     // Catch:{ NameNotFoundException -> 0x008e }
            com.huawei.hms.opendevice.h r3 = new com.huawei.hms.opendevice.h     // Catch:{ NameNotFoundException -> 0x008e }
            r3.<init>()     // Catch:{ NameNotFoundException -> 0x008e }
            android.content.Context r4 = r9.f788a     // Catch:{ NameNotFoundException -> 0x008e }
            boolean r3 = r3.mo14163a(r4, r6, r5)     // Catch:{ NameNotFoundException -> 0x008e }
            if (r3 != 0) goto L_0x0096
            java.lang.String r3 = "start service failed"
            com.huawei.hms.support.log.HMSLog.m1377e(r2, r3)     // Catch:{ NameNotFoundException -> 0x008e }
            goto L_0x0096
        L_0x008a:
            com.huawei.hms.support.log.HMSLog.m1379i(r2, r0)     // Catch:{ NameNotFoundException -> 0x008e }
            goto L_0x0096
        L_0x008e:
            com.huawei.hms.support.log.HMSLog.m1379i(r2, r0)     // Catch:{ Exception -> 0x0092 }
            goto L_0x0096
        L_0x0092:
            r0 = move-exception
            com.huawei.hms.support.log.HMSLog.m1378e((java.lang.String) r2, (java.lang.String) r1, (java.lang.Throwable) r0)
        L_0x0096:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.opendevice.C0852f.run():void");
    }
}
