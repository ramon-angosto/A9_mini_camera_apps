package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.push.p */
/* compiled from: PushSelfShowThread */
public class C0886p extends Thread {

    /* renamed from: a */
    public Context f923a;

    /* renamed from: b */
    public C0881k f924b;

    public C0886p(Context context, C0881k kVar) {
        this.f923a = context;
        this.f924b = kVar;
    }

    /* renamed from: a */
    public static Intent m1297a(Context context, C0881k kVar) {
        if (kVar == null) {
            return null;
        }
        Intent b = C0887q.m1309b(context, kVar.mo14299d());
        if (kVar.mo14317n() != null) {
            try {
                Intent parseUri = Intent.parseUri(kVar.mo14317n(), 0);
                parseUri.setSelector((Intent) null);
                StringBuilder sb = new StringBuilder();
                sb.append("Intent.parseUri(msg.intentUri, 0), action:");
                sb.append(parseUri.getAction());
                HMSLog.m1374d("PushSelfShowLog", sb.toString());
                if (C0887q.m1302a(context, kVar.mo14299d(), parseUri).booleanValue()) {
                    return parseUri;
                }
                return b;
            } catch (Exception e) {
                HMSLog.m1380w("PushSelfShowLog", "intentUri error," + e.toString());
                return b;
            }
        } else {
            if (kVar.mo14291a() != null) {
                Intent intent = new Intent(kVar.mo14291a());
                if (C0887q.m1302a(context, kVar.mo14299d(), intent).booleanValue()) {
                    b = intent;
                }
            }
            b.setPackage(kVar.mo14299d());
            return b;
        }
    }

    /* renamed from: b */
    public final boolean mo14331b(Context context) {
        if ("cosa".equals(this.f924b.mo14309i())) {
            return mo14330a(context);
        }
        return true;
    }

    public void run() {
        HMSLog.m1379i("PushSelfShowLog", "enter run()");
        try {
            if (mo14331b(this.f923a) && !mo14332b(this.f923a, this.f924b)) {
                C0885o.m1287a(this.f923a, this.f924b);
            }
        } catch (Exception e) {
            HMSLog.m1377e("PushSelfShowLog", e.toString());
        }
    }

    /* renamed from: b */
    public final boolean mo14332b(Context context, C0881k kVar) {
        if (!"cosa".equals(kVar.mo14309i()) || m1297a(context, kVar) != null) {
            return false;
        }
        HMSLog.m1374d("PushSelfShowLog", "launchCosaApp,intent == null");
        return true;
    }

    /* renamed from: a */
    public final boolean mo14330a(Context context) {
        return C0887q.m1310c(context, this.f924b.mo14299d());
    }
}
