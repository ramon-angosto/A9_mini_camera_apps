package com.xiaomi.push;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.channel.commonutils.logger.C1524b;

/* renamed from: com.xiaomi.push.ev */
public class C1777ev extends C1780ey {

    /* renamed from: a */
    private int f2244a = 16777216;

    /* renamed from: b */
    private Bitmap f2245b;

    /* renamed from: c */
    private Bitmap f2246c;

    public C1777ev(Context context, String str) {
        super(context, str);
    }

    /* renamed from: a */
    public C1777ev setLargeIcon(Bitmap bitmap) {
        if (mo17545b() && bitmap != null) {
            if (bitmap.getWidth() != 984 || 184 > bitmap.getHeight() || bitmap.getHeight() > 1678) {
                C1524b.m2141a("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
            } else {
                this.f2245b = bitmap;
            }
        }
        return this;
    }

    /* renamed from: a */
    public C1777ev mo17542a(String str) {
        if (mo17545b() && !TextUtils.isEmpty(str)) {
            try {
                this.f2244a = Color.parseColor(str);
            } catch (Exception unused) {
                C1524b.m2141a("parse banner notification image text color error");
            }
        }
        return this;
    }

    /* renamed from: a */
    public C1780ey m3417a(Bitmap bitmap) {
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo17543a() {
        return "notification_banner";
    }

    /* renamed from: a */
    public void m3419a() {
        Bitmap bitmap;
        RemoteViews remoteViews;
        if (!mo17545b() || this.f2245b == null) {
            mo17545b();
            return;
        }
        super.mo17543a();
        Resources resources = mo17543a().getResources();
        String packageName = mo17543a().getPackageName();
        int a = mo17547a(resources, "bg", "id", packageName);
        if (C1938m.m4714a(mo17543a()) >= 10) {
            remoteViews = mo17543a();
            bitmap = mo17558a(this.f2245b, 30.0f);
        } else {
            remoteViews = mo17543a();
            bitmap = this.f2245b;
        }
        remoteViews.setImageViewBitmap(a, bitmap);
        int a2 = mo17547a(resources, RemoteMessageConst.Notification.ICON, "id", packageName);
        if (this.f2246c != null) {
            mo17543a().setImageViewBitmap(a2, this.f2246c);
        } else {
            mo17562a(a2);
        }
        int a3 = mo17547a(resources, "title", "id", packageName);
        mo17543a().setTextViewText(a3, this.f2257a);
        if (this.f2260a != null && this.f2244a == 16777216) {
            mo17542a((String) this.f2260a.get("notification_image_text_color"));
        }
        RemoteViews a4 = mo17543a();
        int i = this.f2244a;
        a4.setTextColor(a3, (i == 16777216 || !mo17562a(i)) ? -1 : -16777216);
        setCustomContentView(mo17543a());
        Bundle bundle = new Bundle();
        bundle.putBoolean("miui.customHeight", true);
        addExtras(bundle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m3420a() {
        if (!C1938m.m4714a(mo17543a())) {
            return false;
        }
        Resources resources = mo17543a().getResources();
        String packageName = mo17543a().getPackageName();
        return (mo17547a(mo17543a().getResources(), "bg", "id", mo17543a().getPackageName()) == 0 || mo17547a(resources, RemoteMessageConst.Notification.ICON, "id", packageName) == 0 || mo17547a(resources, "title", "id", packageName) == 0 || C1938m.m4714a(mo17543a()) < 9) ? false : true;
    }

    /* renamed from: b */
    public C1777ev mo17544b(Bitmap bitmap) {
        if (mo17545b() && bitmap != null) {
            this.f2246c = bitmap;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo17545b() {
        return null;
    }
}
