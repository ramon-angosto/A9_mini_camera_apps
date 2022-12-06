package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.service.C1995at;
import com.xiaomi.push.service.XMPushService;
import java.io.File;

/* renamed from: com.xiaomi.push.hj */
public class C1862hj implements XMPushService.C1959l {

    /* renamed from: a */
    private static boolean f2642a = false;

    /* renamed from: a */
    private int f2643a;

    /* renamed from: a */
    private Context f2644a;

    /* renamed from: b */
    private boolean f2645b;

    public C1862hj(Context context) {
        this.f2644a = context;
    }

    /* renamed from: a */
    private String m3871a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f2644a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, (String) null);
    }

    /* renamed from: a */
    private void m3872a(Context context) {
        this.f2645b = C1995at.m5047a(context).mo18472a(C1873ht.TinyDataUploadSwitch.mo17806a(), true);
        this.f2643a = C1995at.m5047a(context).mo18465a(C1873ht.TinyDataUploadFrequency.mo17806a(), 7200);
        this.f2643a = Math.max(60, this.f2643a);
    }

    /* renamed from: a */
    public static void m3873a(boolean z) {
        f2642a = z;
    }

    /* renamed from: a */
    private boolean mo17759a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f2644a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1)) > ((long) this.f2643a);
    }

    /* renamed from: a */
    private boolean m3875a(C1867hn hnVar) {
        if (C1653bi.m2685b(this.f2644a) && hnVar != null && !TextUtils.isEmpty(m3871a(this.f2644a.getPackageName())) && new File(this.f2644a.getFilesDir(), "tiny_data.data").exists() && !f2642a) {
            return !C1995at.m5047a(this.f2644a).mo18472a(C1873ht.ScreenOnOrChargingTinyDataUploadSwitch.mo17806a(), false) || C1907j.m4553a(this.f2644a) || C1907j.m4562b(this.f2644a);
        }
        return false;
    }

    /* renamed from: a */
    public void m3876a() {
        m3872a(this.f2644a);
        if (this.f2645b && mo17759a()) {
            C1524b.m2141a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            C1867hn a = C1866hm.m3887a(this.f2644a).mo17761a();
            if (!m3875a(a)) {
                C1524b.m2141a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
                return;
            }
            f2642a = true;
            C1863hk.m3878a(this.f2644a, a);
        }
    }
}
