package com.xiaomi.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.service.C1974af;
import com.xiaomi.push.service.C1993ar;
import com.xiaomi.push.service.C1994as;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.xiaomi.push.ey */
public abstract class C1780ey extends C1778ew {

    /* renamed from: a */
    private int f2254a;

    /* renamed from: a */
    protected Bitmap f2255a;

    /* renamed from: a */
    private RemoteViews f2256a;

    /* renamed from: a */
    protected CharSequence f2257a;

    /* renamed from: a */
    private String f2258a;

    /* renamed from: a */
    private ArrayList<Notification.Action> f2259a;

    /* renamed from: a */
    protected Map<String, String> f2260a;

    /* renamed from: a */
    private boolean f2261a;

    /* renamed from: b */
    private int f2262b;

    /* renamed from: b */
    protected CharSequence f2263b;

    /* renamed from: b */
    private boolean f2264b;

    public C1780ey(Context context, int i, String str) {
        super(context);
        this.f2259a = new ArrayList<>();
        this.f2262b = 0;
        this.f2258a = str;
        this.f2254a = i;
        m3442c();
    }

    public C1780ey(Context context, String str) {
        this(context, 0, str);
    }

    /* renamed from: a */
    private Bitmap mo17543a() {
        return C1974af.m4907a(C1816g.m3659a(mo17543a(), this.f2258a));
    }

    /* renamed from: c */
    private String m3442c() {
        this.f2264b = m3447e();
        return this.f2264b ? mo17545b() : mo17543a();
    }

    /* renamed from: c */
    private void m3443c() {
        int a = mo17547a(mo17543a().getResources(), m3442c(), "layout", mo17543a().getPackageName());
        if (a != 0) {
            this.f2256a = new RemoteViews(mo17543a().getPackageName(), a);
            this.f2261a = mo17543a();
            return;
        }
        C1524b.m2141a("create RemoteViews failed, no such layout resource was found");
    }

    /* renamed from: c */
    private boolean m3444c() {
        Map<String, String> map = this.f2260a;
        return map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"));
    }

    /* renamed from: d */
    private void m3445d() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.setContentTitle(this.f2257a);
            super.setContentText(this.f2263b);
        }
    }

    /* renamed from: d */
    private boolean m3446d() {
        return !TextUtils.isEmpty(mo17545b()) && !TextUtils.isEmpty(this.f2258a);
    }

    /* renamed from: e */
    private boolean m3447e() {
        return m3445d() && m3448f();
    }

    /* renamed from: f */
    private boolean m3448f() {
        List<StatusBarNotification> b;
        if (Build.VERSION.SDK_INT >= 20 && (b = C1993ar.m5005a(mo17543a(), this.f2258a).mo18462b()) != null && !b.isEmpty()) {
            for (StatusBarNotification statusBarNotification : b) {
                if (statusBarNotification.getId() == this.f2254a) {
                    Notification notification = statusBarNotification.getNotification();
                    if (notification == null) {
                        return false;
                    }
                    return !notification.extras.getBoolean("mipush.customCopyLayout", true);
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo17557a(float f) {
        return (int) ((f * mo17543a().getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Bitmap mo17558a(Bitmap bitmap, float f) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new RectF(rect), f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    /* renamed from: a */
    public final RemoteViews m3451a() {
        return this.f2256a;
    }

    /* renamed from: a */
    public C1778ew mo17550a(Map<String, String> map) {
        this.f2260a = map;
        return this;
    }

    /* renamed from: a */
    public C1780ey addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT >= 19) {
            addAction(new Notification.Action(i, charSequence, pendingIntent));
        }
        return this;
    }

    /* renamed from: a */
    public C1780ey addAction(Notification.Action action) {
        if (action != null) {
            this.f2259a.add(action);
        }
        int i = this.f2262b;
        this.f2262b = i + 1;
        mo17563a(i, action);
        return this;
    }

    /* renamed from: a */
    public C1780ey setLargeIcon(Bitmap bitmap) {
        this.f2255a = bitmap;
        return this;
    }

    /* renamed from: a */
    public C1780ey setContentTitle(CharSequence charSequence) {
        this.f2257a = charSequence;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String m3457a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void m3458a() {
        super.mo17543a();
        Bundle bundle = new Bundle();
        if (m3445d()) {
            bundle.putBoolean("mipush.customCopyLayout", this.f2264b);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        bundle.putBoolean("mipush.customNotification", true);
        bundle.putInt("mipush.customLargeIconId", mo17542a("large_icon"));
        if (this.f2259a.size() > 0) {
            Notification.Action[] actionArr = new Notification.Action[this.f2259a.size()];
            this.f2259a.toArray(actionArr);
            bundle.putParcelableArray("mipush.customActions", actionArr);
        }
        if (m3442c() || !C1994as.m5029a(mo17543a().getContentResolver())) {
            m3445d();
        } else {
            bundle.putCharSequence("mipush.customTitle", this.f2257a);
            bundle.putCharSequence("mipush.customContent", this.f2263b);
        }
        addExtras(bundle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo17562a(int i) {
        Bitmap a = mo17543a();
        if (a != null) {
            mo17543a().setImageViewBitmap(i, a);
            return;
        }
        int b = C1816g.m3669b(mo17543a(), this.f2258a);
        if (b != 0) {
            mo17543a().setImageViewResource(i, b);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo17563a(int i, Notification.Action action) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean m3461a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean m3462a(int i) {
        double red = (double) Color.red(i);
        Double.isNaN(red);
        double green = (double) Color.green(i);
        Double.isNaN(green);
        double d = (red * 0.299d) + (green * 0.587d);
        double blue = (double) Color.blue(i);
        Double.isNaN(blue);
        return d + (blue * 0.114d) < 192.0d;
    }

    /* renamed from: b */
    public C1780ey setContentText(CharSequence charSequence) {
        this.f2263b = charSequence;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract String mo17545b();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void m3465b() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.setContentTitle(this.f2257a);
            super.setContentText(this.f2263b);
            Bitmap bitmap = this.f2255a;
            if (bitmap != null) {
                super.setLargeIcon(bitmap);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final boolean m3466b() {
        return this.f2261a;
    }
}
