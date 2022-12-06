package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.common.PackageConstants;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;

/* renamed from: com.huawei.hms.push.j */
/* compiled from: SelfShowType */
public class C0880j {

    /* renamed from: a */
    public static final String[] f882a = {"url", "app", "cosa", "rp"};

    /* renamed from: b */
    public Context f883b;

    /* renamed from: c */
    public C0881k f884c;

    public C0880j(Context context, C0881k kVar) {
        this.f883b = context;
        this.f884c = kVar;
    }

    /* renamed from: b */
    public static boolean m1230b(String str) {
        for (String equals : f882a) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final void mo14286a() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("enter launchApp, appPackageName =");
            sb.append(this.f884c.mo14299d());
            sb.append(",and msg.intentUri is ");
            sb.append(this.f884c.mo14317n());
            HMSLog.m1379i("PushSelfShowLog", sb.toString());
            if (C0887q.m1310c(this.f883b, this.f884c.mo14299d())) {
                mo14287b();
            } else {
                mo14289d();
            }
        } catch (Exception e) {
            HMSLog.m1377e("PushSelfShowLog", "launchApp error:" + e.toString());
        }
    }

    /* renamed from: c */
    public void mo14288c() {
        C0881k kVar;
        HMSLog.m1374d("PushSelfShowLog", "enter launchNotify()");
        if (this.f883b == null || (kVar = this.f884c) == null) {
            HMSLog.m1374d("PushSelfShowLog", "launchNotify  context or msg is null");
        } else if ("app".equals(kVar.mo14309i())) {
            mo14286a();
        } else if ("cosa".equals(this.f884c.mo14309i())) {
            mo14287b();
        } else if ("rp".equals(this.f884c.mo14309i())) {
            HMSLog.m1380w("PushSelfShowLog", this.f884c.mo14309i() + " not support rich message.");
        } else if ("url".equals(this.f884c.mo14309i())) {
            HMSLog.m1380w("PushSelfShowLog", this.f884c.mo14309i() + " not support URL.");
        } else {
            HMSLog.m1374d("PushSelfShowLog", this.f884c.mo14309i() + " is not exist in hShowType");
        }
    }

    /* renamed from: d */
    public final void mo14289d() {
        try {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.f884c.mo14317n())) {
                sb.append("&referrer=");
                sb.append(Uri.encode(mo14285a(this.f884c.mo14317n())));
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("market://details?id=");
            sb2.append(this.f884c.mo14299d());
            sb2.append(sb);
            String sb3 = sb2.toString();
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(sb3));
            intent.setPackage(PackageConstants.SERVICES_PACKAGE_APPMARKET);
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(sb3));
            intent2.setPackage("com.android.vending");
            if (C0887q.m1302a(this.f883b, "com.android.vending", intent2).booleanValue()) {
                intent2.setFlags(402653184);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("open google play store's app detail, IntentUrl is:");
                sb4.append(intent2.toURI());
                HMSLog.m1379i("PushSelfShowLog", sb4.toString());
                this.f883b.startActivity(intent2);
            } else if (C0887q.m1302a(this.f883b, PackageConstants.SERVICES_PACKAGE_APPMARKET, intent).booleanValue()) {
                intent.setFlags(402653184);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("open HiApp's app detail, IntentUrl is:");
                sb5.append(intent.toURI());
                HMSLog.m1379i("PushSelfShowLog", sb5.toString());
                this.f883b.startActivity(intent);
            } else {
                HMSLog.m1379i("PushSelfShowLog", "open app detail by browser.");
                mo14290e();
            }
        } catch (Exception e) {
            HMSLog.m1377e("PushSelfShowLog", "open market app detail failed,exception:" + e);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:12|13) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        com.huawei.hms.support.log.HMSLog.m1379i("PushSelfShowLog", "parse h_w_hiapp_referrer failed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        com.huawei.hms.support.log.HMSLog.m1379i("PushSelfShowLog", "parse h_w_hiapp_referrer failed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        r4 = r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0026 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x001b */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0082  */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo14290e() {
        /*
            r6 = this;
            java.lang.String r0 = "parse h_w_hiapp_referrer failed"
            java.lang.String r1 = ""
            java.lang.String r2 = "PushSelfShowLog"
            com.huawei.hms.push.k r3 = r6.f884c     // Catch:{ Exception -> 0x002c }
            java.lang.String r3 = r3.mo14317n()     // Catch:{ Exception -> 0x002c }
            java.lang.String r3 = android.net.Uri.decode(r3)     // Catch:{ Exception -> 0x002c }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x002c }
            java.lang.String r4 = "h_w_hiapp_referrer"
            java.lang.String r4 = r3.getQueryParameter(r4)     // Catch:{ Exception -> 0x001b }
            goto L_0x001f
        L_0x001b:
            com.huawei.hms.support.log.HMSLog.m1379i(r2, r0)     // Catch:{ Exception -> 0x002c }
            r4 = r1
        L_0x001f:
            java.lang.String r5 = "h_w_gp_referrer"
            java.lang.String r1 = r3.getQueryParameter(r5)     // Catch:{ Exception -> 0x0026 }
            goto L_0x0046
        L_0x0026:
            com.huawei.hms.support.log.HMSLog.m1379i(r2, r0)     // Catch:{ Exception -> 0x002a }
            goto L_0x0046
        L_0x002a:
            r0 = move-exception
            goto L_0x002e
        L_0x002c:
            r0 = move-exception
            r4 = r1
        L_0x002e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "parse intentUri error."
            r3.append(r5)
            java.lang.String r0 = r0.toString()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.huawei.hms.support.log.HMSLog.m1380w(r2, r0)
        L_0x0046:
            r0 = 0
            boolean r3 = com.huawei.hms.utils.Util.isEMUI()
            if (r3 == 0) goto L_0x0082
            boolean r3 = com.huawei.hms.utils.Util.isChinaROM()
            if (r3 != 0) goto L_0x0054
            goto L_0x0082
        L_0x0054:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "It is China device, open Huawei market web, referrer: "
            r1.append(r3)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.huawei.hms.support.log.HMSLog.m1379i(r2, r1)
            java.lang.String r1 = android.net.Uri.decode(r4)
            boolean r3 = android.webkit.URLUtil.isValidUrl(r1)
            if (r3 == 0) goto L_0x0074
            r0 = r1
            goto L_0x00c1
        L_0x0074:
            android.content.Context r1 = r6.f883b
            if (r1 == 0) goto L_0x00c1
            com.huawei.hms.utils.ResourceLoaderUtil.setmContext(r1)
            java.lang.String r0 = "hms_push_vmall"
            java.lang.String r0 = com.huawei.hms.utils.ResourceLoaderUtil.getString(r0)
            goto L_0x00c1
        L_0x0082:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "not EMUI system or not in China, open google play web, referrer: "
            r0.append(r3)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.huawei.hms.support.log.HMSLog.m1379i(r2, r0)
            java.lang.String r0 = android.net.Uri.decode(r1)
            boolean r1 = android.webkit.URLUtil.isValidUrl(r0)
            if (r1 == 0) goto L_0x00a1
            goto L_0x00c1
        L_0x00a1:
            android.content.Context r0 = r6.f883b
            com.huawei.hms.utils.ResourceLoaderUtil.setmContext(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "hms_push_google"
            java.lang.String r1 = com.huawei.hms.utils.ResourceLoaderUtil.getString(r1)
            r0.append(r1)
            com.huawei.hms.push.k r1 = r6.f884c
            java.lang.String r1 = r1.mo14299d()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x00c1:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "open the URL by browser: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            com.huawei.hms.support.log.HMSLog.m1379i(r2, r1)
            android.content.Context r1 = r6.f883b
            com.huawei.hms.push.C0887q.m1312e(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.push.C0880j.mo14290e():void");
    }

    /* renamed from: b */
    public final void mo14287b() {
        HMSLog.m1379i("PushSelfShowLog", "run into launchCosaApp");
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("enter launchExistApp cosa, appPackageName =");
            sb.append(this.f884c.mo14299d());
            sb.append(",and msg.intentUri is ");
            sb.append(this.f884c.mo14317n());
            HMSLog.m1379i("PushSelfShowLog", sb.toString());
            Intent b = C0887q.m1309b(this.f883b, this.f884c.mo14299d());
            boolean z = false;
            if (this.f884c.mo14317n() != null) {
                try {
                    Intent parseUri = Intent.parseUri(this.f884c.mo14317n(), 0);
                    parseUri.setSelector((Intent) null);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Intent.parseUri(msg.intentUri, 0), action:");
                    sb2.append(parseUri.getAction());
                    HMSLog.m1379i("PushSelfShowLog", sb2.toString());
                    z = C0887q.m1302a(this.f883b, this.f884c.mo14299d(), parseUri).booleanValue();
                    if (z) {
                        b = parseUri;
                    }
                } catch (Exception e) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("intentUri error.");
                    sb3.append(e.toString());
                    HMSLog.m1380w("PushSelfShowLog", sb3.toString());
                }
            } else {
                if (this.f884c.mo14291a() != null) {
                    Intent intent = new Intent(this.f884c.mo14291a());
                    if (C0887q.m1302a(this.f883b, this.f884c.mo14299d(), intent).booleanValue()) {
                        b = intent;
                    }
                }
                b.setPackage(this.f884c.mo14299d());
            }
            if (b == null) {
                HMSLog.m1379i("PushSelfShowLog", "launchCosaApp,intent == null");
                return;
            }
            if (z) {
                b.addFlags(268435456);
            } else {
                b.setFlags(805437440);
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("start ");
            sb4.append(b.toURI());
            HMSLog.m1379i("PushSelfShowLog", sb4.toString());
            this.f883b.startActivity(b);
        } catch (Exception e2) {
            HMSLog.m1377e("PushSelfShowLog", "launch Cosa App exception." + e2.toString());
        }
    }

    /* renamed from: a */
    public final String mo14285a(String str) {
        String str2;
        try {
            int indexOf = str.indexOf(63);
            if (indexOf == -1) {
                return str;
            }
            int i = indexOf + 1;
            String[] split = str.substring(i).split(ContainerUtils.FIELD_DELIMITER);
            ArrayList arrayList = new ArrayList();
            for (String str3 : split) {
                if (!str3.startsWith("h_w_hiapp_referrer")) {
                    if (!str3.startsWith("h_w_gp_referrer")) {
                        arrayList.add(str3);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append((String) arrayList.get(i2));
                if (i2 < arrayList.size() - 1) {
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                }
            }
            if (arrayList.size() == 0) {
                str2 = str.substring(0, indexOf);
            } else {
                str2 = str.substring(0, i) + sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("after delete referrer, the new IntentUri is:");
            sb2.append(str2);
            HMSLog.m1374d("PushSelfShowLog", sb2.toString());
            return str2;
        } catch (Exception e) {
            HMSLog.m1377e("PushSelfShowLog", "delete referrer exception." + e.toString());
            return str;
        }
    }
}
