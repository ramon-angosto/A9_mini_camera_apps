package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.support.log.HMSLog;
import java.util.Map;

/* renamed from: com.huawei.hms.opendevice.m */
/* compiled from: ReportAaidToken */
class C0859m extends Thread {

    /* renamed from: a */
    public final /* synthetic */ Context f799a;

    /* renamed from: b */
    public final /* synthetic */ String f800b;

    public C0859m(Context context, String str) {
        this.f799a = context;
        this.f800b = str;
    }

    public void run() {
        if (!C0864p.m1177a()) {
            HMSLog.m1374d("ReportAaidToken", "Not HW Phone.");
        } else if (!C0860n.m1160b(this.f799a)) {
            String a = C0863o.m1168a(this.f799a);
            if (TextUtils.isEmpty(a)) {
                HMSLog.m1380w("ReportAaidToken", "AAID is empty.");
            } else if (!C0860n.m1162d(this.f799a, a, this.f800b)) {
                HMSLog.m1374d("ReportAaidToken", "This time need not report.");
            } else {
                String string = AGConnectServicesConfig.fromContext(this.f799a).getString("region");
                if (TextUtils.isEmpty(string)) {
                    HMSLog.m1379i("ReportAaidToken", "The data storage region is empty.");
                    return;
                }
                String a2 = C0851e.m1139a(this.f799a, "com.huawei.hms.opendevicesdk", "ROOT", (String) null, string);
                if (!TextUtils.isEmpty(a2)) {
                    String b = C0860n.m1161c(this.f799a, a, this.f800b);
                    Context context = this.f799a;
                    C0860n.m1159b(this.f799a, C0849d.m1135a(context, a2 + "/rest/appdata/v1/aaid/report", b, (Map<String, String>) null), a, this.f800b);
                }
            }
        }
    }
}
