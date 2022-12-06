package com.xiaomi.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.service.C1974af;

/* renamed from: com.xiaomi.push.ex */
public class C1779ex extends C1780ey {

    /* renamed from: a */
    private int f2248a = 16777216;

    /* renamed from: a */
    private PendingIntent f2249a;

    /* renamed from: b */
    private int f2250b = 16777216;

    /* renamed from: b */
    private Bitmap f2251b;

    /* renamed from: c */
    private int f2252c = 16777216;

    /* renamed from: c */
    private CharSequence f2253c;

    public C1779ex(Context context, int i, String str) {
        super(context, i, str);
    }

    /* renamed from: a */
    private Drawable m3430a(int i, int i2, int i3, float f) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, (RectF) null, (float[]) null));
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.setIntrinsicWidth(i2);
        shapeDrawable.setIntrinsicHeight(i3);
        return shapeDrawable;
    }

    /* renamed from: a */
    private void m3431a(RemoteViews remoteViews, int i, int i2, int i3, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            int a = mo17557a(6.0f);
            remoteViews.setViewPadding(i, a, 0, a, 0);
        }
        int i4 = z ? -1 : -16777216;
        remoteViews.setTextColor(i2, i4);
        remoteViews.setTextColor(i3, i4);
    }

    /* renamed from: a */
    public C1779ex mo17541a(Bitmap bitmap) {
        if (mo17545b() && bitmap != null) {
            if (bitmap.getWidth() != 984 || bitmap.getHeight() < 177 || bitmap.getHeight() > 207) {
                C1524b.m2141a("colorful notification bg image resolution error, must [984*177, 984*207]");
            } else {
                this.f2251b = bitmap;
            }
        }
        return this;
    }

    /* renamed from: a */
    public C1779ex mo17554a(CharSequence charSequence, PendingIntent pendingIntent) {
        if (mo17545b()) {
            super.addAction(0, charSequence, pendingIntent);
            this.f2253c = charSequence;
            this.f2249a = pendingIntent;
        }
        return this;
    }

    /* renamed from: a */
    public C1779ex mo17542a(String str) {
        if (mo17545b() && !TextUtils.isEmpty(str)) {
            try {
                this.f2250b = Color.parseColor(str);
            } catch (Exception unused) {
                C1524b.m2141a("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo17543a() {
        return "notification_colorful";
    }

    /* renamed from: a */
    public void m3436a() {
        Bitmap bitmap;
        RemoteViews remoteViews;
        boolean z;
        RemoteViews a;
        Drawable drawable;
        RemoteViews remoteViews2;
        if (mo17545b()) {
            super.mo17543a();
            Resources resources = mo17543a().getResources();
            String packageName = mo17543a().getPackageName();
            int a2 = mo17547a(resources, RemoteMessageConst.Notification.ICON, "id", packageName);
            if (this.f2255a == null) {
                mo17562a(a2);
            } else {
                mo17543a().setImageViewBitmap(a2, this.f2255a);
            }
            int a3 = mo17547a(resources, "title", "id", packageName);
            int a4 = mo17547a(resources, RemoteMessageConst.Notification.CONTENT, "id", packageName);
            mo17543a().setTextViewText(a3, this.f2257a);
            mo17543a().setTextViewText(a4, this.f2263b);
            if (!TextUtils.isEmpty(this.f2253c)) {
                int a5 = mo17547a(resources, "buttonContainer", "id", packageName);
                int a6 = mo17547a(resources, "button", "id", packageName);
                int a7 = mo17547a(resources, "buttonBg", "id", packageName);
                mo17543a().setViewVisibility(a5, 0);
                mo17543a().setTextViewText(a6, this.f2253c);
                mo17543a().setOnClickPendingIntent(a5, this.f2249a);
                if (this.f2250b != 16777216) {
                    int a8 = mo17557a(70.0f);
                    int a9 = mo17557a(29.0f);
                    mo17543a().setImageViewBitmap(a7, C1974af.m4907a(m3430a(this.f2250b, a8, a9, ((float) a9) / 2.0f)));
                    mo17543a().setTextColor(a6, mo17562a(this.f2250b) ? -1 : -16777216);
                }
            }
            int a10 = mo17547a(resources, "bg", "id", packageName);
            int a11 = mo17547a(resources, "container", "id", packageName);
            if (this.f2248a != 16777216) {
                if (C1938m.m4714a(mo17543a()) >= 10) {
                    remoteViews2 = mo17543a();
                    drawable = m3430a(this.f2248a, 984, 192, 30.0f);
                } else {
                    remoteViews2 = mo17543a();
                    drawable = m3430a(this.f2248a, 984, 192, 0.0f);
                }
                remoteViews2.setImageViewBitmap(a10, C1974af.m4907a(drawable));
                a = mo17543a();
                z = mo17562a(this.f2248a);
            } else if (this.f2251b != null) {
                if (C1938m.m4714a(mo17543a()) >= 10) {
                    remoteViews = mo17543a();
                    bitmap = mo17558a(this.f2251b, 30.0f);
                } else {
                    remoteViews = mo17543a();
                    bitmap = this.f2251b;
                }
                remoteViews.setImageViewBitmap(a10, bitmap);
                if (this.f2260a != null && this.f2252c == 16777216) {
                    mo17556c((String) this.f2260a.get("notification_image_text_color"));
                }
                int i = this.f2252c;
                z = i == 16777216 || !mo17562a(i);
                a = mo17543a();
            } else {
                if (Build.VERSION.SDK_INT >= 24) {
                    mo17543a().setViewVisibility(a2, 8);
                    mo17543a().setViewVisibility(a10, 8);
                    try {
                        C1656bj.m2697a((Object) this, "setStyle", C2087u.m5373a(mo17543a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception unused) {
                        C1524b.m2141a("load class DecoratedCustomViewStyle failed");
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("miui.customHeight", true);
                addExtras(bundle);
                setCustomContentView(mo17543a());
                return;
            }
            m3431a(a, a11, a3, a4, z);
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("miui.customHeight", true);
            addExtras(bundle2);
            setCustomContentView(mo17543a());
            return;
        }
        mo17545b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m3437a() {
        if (!C1938m.m4714a(mo17543a())) {
            return false;
        }
        Resources resources = mo17543a().getResources();
        String packageName = mo17543a().getPackageName();
        return (mo17547a(resources, RemoteMessageConst.Notification.ICON, "id", packageName) == 0 || mo17547a(resources, "title", "id", packageName) == 0 || mo17547a(resources, RemoteMessageConst.Notification.CONTENT, "id", packageName) == 0) ? false : true;
    }

    /* renamed from: b */
    public C1779ex mo17555b(String str) {
        if (mo17545b() && !TextUtils.isEmpty(str)) {
            try {
                this.f2248a = Color.parseColor(str);
            } catch (Exception unused) {
                C1524b.m2141a("parse colorful notification bg color error");
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo17545b() {
        return "notification_colorful_copy";
    }

    /* renamed from: c */
    public C1779ex mo17556c(String str) {
        if (mo17545b() && !TextUtils.isEmpty(str)) {
            try {
                this.f2252c = Color.parseColor(str);
            } catch (Exception unused) {
                C1524b.m2141a("parse colorful notification image text color error");
            }
        }
        return this;
    }
}
