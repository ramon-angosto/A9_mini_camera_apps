package com.xiaomi.push;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.Map;

/* renamed from: com.xiaomi.push.ew */
public class C1778ew extends Notification.Builder {

    /* renamed from: a */
    private Context f2247a;

    public C1778ew(Context context) {
        super(context);
        this.f2247a = context;
    }

    /* renamed from: a */
    public int mo17547a(Resources resources, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            return resources.getIdentifier(str, str2, str3);
        }
        return 0;
    }

    /* renamed from: a */
    public final int mo17542a(String str) {
        return mo17547a(mo17543a().getResources(), str, "id", mo17543a().getPackageName());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Context mo17543a() {
        return this.f2247a;
    }

    /* renamed from: a */
    public C1778ew addExtras(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 20) {
            super.addExtras(bundle);
        }
        return this;
    }

    /* renamed from: a */
    public C1778ew setCustomContentView(RemoteViews remoteViews) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.setCustomContentView(remoteViews);
        } else {
            super.setContent(remoteViews);
        }
        return this;
    }

    /* renamed from: a */
    public C1778ew mo17550a(Map<String, String> map) {
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void m3429a() {
    }

    public Notification build() {
        mo17543a();
        return super.build();
    }
}
