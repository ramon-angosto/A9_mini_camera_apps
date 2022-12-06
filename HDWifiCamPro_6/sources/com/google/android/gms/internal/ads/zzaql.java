package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaql implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Application.ActivityLifecycleCallbacks {
    private static final Handler zza = new Handler(Looper.getMainLooper());
    private final Context zzb;
    private Application zzc;
    private final PowerManager zzd;
    private final KeyguardManager zze;
    private BroadcastReceiver zzf;
    private final zzapx zzg;
    private WeakReference zzh;
    private WeakReference zzi;
    private zzapu zzj;
    private byte zzk = -1;
    private int zzl = -1;
    private long zzm = -3;

    public zzaql(Context context, zzapx zzapx) {
        this.zzb = context.getApplicationContext();
        this.zzg = zzapx;
        this.zzd = (PowerManager) this.zzb.getSystemService("power");
        this.zze = (KeyguardManager) this.zzb.getSystemService("keyguard");
        Context context2 = this.zzb;
        if (context2 instanceof Application) {
            Application application = (Application) context2;
            this.zzc = application;
            this.zzj = new zzapu(application, this);
        }
        zzd((View) null);
    }

    private final void zze(Activity activity, int i) {
        Window window;
        if (this.zzi != null && (window = activity.getWindow()) != null) {
            View peekDecorView = window.peekDecorView();
            View zzb2 = zzb();
            if (zzb2 != null && peekDecorView != null && zzb2.getRootView() == peekDecorView.getRootView()) {
                this.zzl = i;
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005c, code lost:
        if ((r5.flags & 524288) != 0) goto L_0x0060;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf() {
        /*
            r7 = this;
            java.lang.ref.WeakReference r0 = r7.zzi
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.view.View r0 = r7.zzb()
            r1 = -1
            r2 = -3
            if (r0 != 0) goto L_0x0013
            r7.zzm = r2
            r7.zzk = r1
            return
        L_0x0013:
            int r4 = r0.getVisibility()
            if (r4 == 0) goto L_0x001b
            r4 = 1
            goto L_0x001c
        L_0x001b:
            r4 = 0
        L_0x001c:
            boolean r5 = r0.isShown()
            if (r5 != 0) goto L_0x0024
            r4 = r4 | 2
        L_0x0024:
            android.os.PowerManager r5 = r7.zzd
            if (r5 == 0) goto L_0x0030
            boolean r5 = r5.isScreenOn()
            if (r5 != 0) goto L_0x0030
            r4 = r4 | 4
        L_0x0030:
            com.google.android.gms.internal.ads.zzapx r5 = r7.zzg
            boolean r5 = r5.zza()
            if (r5 != 0) goto L_0x0060
            android.app.KeyguardManager r5 = r7.zze
            if (r5 == 0) goto L_0x005e
            boolean r5 = r5.inKeyguardRestrictedInputMode()
            if (r5 == 0) goto L_0x005e
            android.app.Activity r5 = com.google.android.gms.internal.ads.zzaqh.zzb(r0)
            if (r5 != 0) goto L_0x0049
            goto L_0x005e
        L_0x0049:
            android.view.Window r5 = r5.getWindow()
            if (r5 != 0) goto L_0x0051
            r5 = 0
            goto L_0x0055
        L_0x0051:
            android.view.WindowManager$LayoutParams r5 = r5.getAttributes()
        L_0x0055:
            if (r5 == 0) goto L_0x005e
            int r5 = r5.flags
            r6 = 524288(0x80000, float:7.34684E-40)
            r5 = r5 & r6
            if (r5 != 0) goto L_0x0060
        L_0x005e:
            r4 = r4 | 8
        L_0x0060:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getGlobalVisibleRect(r5)
            if (r5 != 0) goto L_0x006d
            r4 = r4 | 16
        L_0x006d:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getLocalVisibleRect(r5)
            if (r5 != 0) goto L_0x007a
            r4 = r4 | 32
        L_0x007a:
            int r0 = r0.getWindowVisibility()
            int r5 = r7.zzl
            if (r5 == r1) goto L_0x0083
            r0 = r5
        L_0x0083:
            if (r0 == 0) goto L_0x0087
            r4 = r4 | 64
        L_0x0087:
            byte r0 = r7.zzk
            if (r0 == r4) goto L_0x009a
            byte r0 = (byte) r4
            r7.zzk = r0
            if (r4 != 0) goto L_0x0095
            long r0 = android.os.SystemClock.elapsedRealtime()
            goto L_0x0098
        L_0x0095:
            long r0 = (long) r4
            long r0 = r2 - r0
        L_0x0098:
            r7.zzm = r0
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaql.zzf():void");
    }

    private final void zzg() {
        zza.post(new zzaqj(this));
    }

    private final void zzh(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzh = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzf == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzf = new zzaqk(this);
            this.zzb.registerReceiver(this.zzf, intentFilter);
        }
        Application application = this.zzc;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzj);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001b */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025 A[Catch:{ Exception -> 0x002b }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002f A[SYNTHETIC, Splitter:B:17:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003a A[SYNTHETIC, Splitter:B:23:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzi(android.view.View r4) {
        /*
            r3 = this;
            r0 = 0
            java.lang.ref.WeakReference r1 = r3.zzh     // Catch:{ Exception -> 0x001b }
            if (r1 == 0) goto L_0x001b
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x001b }
            android.view.ViewTreeObserver r1 = (android.view.ViewTreeObserver) r1     // Catch:{ Exception -> 0x001b }
            if (r1 == 0) goto L_0x0019
            boolean r2 = r1.isAlive()     // Catch:{ Exception -> 0x001b }
            if (r2 == 0) goto L_0x0019
            r1.removeOnScrollChangedListener(r3)     // Catch:{ Exception -> 0x001b }
            r1.removeGlobalOnLayoutListener(r3)     // Catch:{ Exception -> 0x001b }
        L_0x0019:
            r3.zzh = r0     // Catch:{ Exception -> 0x001b }
        L_0x001b:
            android.view.ViewTreeObserver r4 = r4.getViewTreeObserver()     // Catch:{ Exception -> 0x002b }
            boolean r1 = r4.isAlive()     // Catch:{ Exception -> 0x002b }
            if (r1 == 0) goto L_0x002b
            r4.removeOnScrollChangedListener(r3)     // Catch:{ Exception -> 0x002b }
            r4.removeGlobalOnLayoutListener(r3)     // Catch:{ Exception -> 0x002b }
        L_0x002b:
            android.content.BroadcastReceiver r4 = r3.zzf
            if (r4 == 0) goto L_0x0036
            android.content.Context r1 = r3.zzb     // Catch:{ Exception -> 0x0034 }
            r1.unregisterReceiver(r4)     // Catch:{ Exception -> 0x0034 }
        L_0x0034:
            r3.zzf = r0
        L_0x0036:
            android.app.Application r4 = r3.zzc
            if (r4 == 0) goto L_0x003f
            com.google.android.gms.internal.ads.zzapu r0 = r3.zzj     // Catch:{ Exception -> 0x003f }
            r4.unregisterActivityLifecycleCallbacks(r0)     // Catch:{ Exception -> 0x003f }
        L_0x003f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaql.zzi(android.view.View):void");
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zze(activity, 0);
        zzf();
    }

    public final void onActivityDestroyed(Activity activity) {
        zzf();
    }

    public final void onActivityPaused(Activity activity) {
        zze(activity, 4);
        zzf();
    }

    public final void onActivityResumed(Activity activity) {
        zze(activity, 0);
        zzf();
        zzg();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzf();
    }

    public final void onActivityStarted(Activity activity) {
        zze(activity, 0);
        zzf();
    }

    public final void onActivityStopped(Activity activity) {
        zzf();
    }

    public final void onGlobalLayout() {
        zzf();
    }

    public final void onScrollChanged() {
        zzf();
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzl = -1;
        zzh(view);
        zzf();
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zzl = -1;
        zzf();
        zzg();
        zzi(view);
    }

    public final long zza() {
        if (this.zzm <= -2 && zzb() == null) {
            this.zzm = -3;
        }
        return this.zzm;
    }

    /* access modifiers changed from: package-private */
    public final View zzb() {
        WeakReference weakReference = this.zzi;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(View view) {
        long j;
        View zzb2 = zzb();
        if (zzb2 != null) {
            zzb2.removeOnAttachStateChangeListener(this);
            zzi(zzb2);
        }
        this.zzi = new WeakReference(view);
        if (view != null) {
            if (!(view.getWindowToken() == null && view.getWindowVisibility() == 8)) {
                zzh(view);
            }
            view.addOnAttachStateChangeListener(this);
            j = -2;
        } else {
            j = -3;
        }
        this.zzm = j;
    }
}
