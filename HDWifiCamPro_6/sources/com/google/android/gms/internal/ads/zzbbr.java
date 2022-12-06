package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzbz;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbbr implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Application.ActivityLifecycleCallbacks {
    private static final long zzc = ((Long) zzay.zzc().zzb(zzbjc.zzbf)).longValue();
    BroadcastReceiver zza;
    final WeakReference zzb;
    private final Context zzd;
    private Application zze;
    private final WindowManager zzf;
    private final PowerManager zzg;
    private final KeyguardManager zzh;
    private WeakReference zzi;
    private zzbcd zzj;
    private final zzbz zzk = new zzbz(zzc);
    private boolean zzl = false;
    private int zzm = -1;
    private final HashSet zzn = new HashSet();
    private final DisplayMetrics zzo;
    private final Rect zzp;

    public zzbbr(Context context, View view) {
        this.zzd = context.getApplicationContext();
        this.zzf = (WindowManager) context.getSystemService("window");
        this.zzg = (PowerManager) this.zzd.getSystemService("power");
        this.zzh = (KeyguardManager) context.getSystemService("keyguard");
        Context context2 = this.zzd;
        if (context2 instanceof Application) {
            Application application = (Application) context2;
            this.zze = application;
            this.zzj = new zzbcd(application, this);
        }
        this.zzo = context.getResources().getDisplayMetrics();
        this.zzp = new Rect();
        this.zzp.right = this.zzf.getDefaultDisplay().getWidth();
        this.zzp.bottom = this.zzf.getDefaultDisplay().getHeight();
        WeakReference weakReference = this.zzb;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzm(view2);
        }
        this.zzb = new WeakReference(view);
        if (view != null) {
            if (view.isAttachedToWindow()) {
                zzl(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    private final int zzh(int i) {
        return (int) (((float) i) / this.zzo.density);
    }

    private final void zzi(Activity activity, int i) {
        Window window;
        if (this.zzb != null && (window = activity.getWindow()) != null) {
            View peekDecorView = window.peekDecorView();
            View view = (View) this.zzb.get();
            if (view != null && peekDecorView != null && view.getRootView() == peekDecorView.getRootView()) {
                this.zzm = i;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzj(int i) {
        WeakReference weakReference;
        boolean z;
        boolean z2;
        View view;
        List list;
        boolean z3;
        int i2;
        boolean z4;
        int i3 = i;
        if (!this.zzn.isEmpty() && (weakReference = this.zzb) != null) {
            View view2 = (View) weakReference.get();
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            Rect rect3 = new Rect();
            Rect rect4 = new Rect();
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            if (view2 != null) {
                boolean globalVisibleRect = view2.getGlobalVisibleRect(rect2);
                z2 = view2.getLocalVisibleRect(rect3);
                view2.getHitRect(rect4);
                try {
                    view2.getLocationOnScreen(iArr);
                    view2.getLocationInWindow(iArr2);
                } catch (Exception e) {
                    zze.zzh("Failure getting view location.", e);
                }
                rect.left = iArr[0];
                rect.top = iArr[1];
                rect.right = rect.left + view2.getWidth();
                rect.bottom = rect.top + view2.getHeight();
                view = view2;
                z = globalVisibleRect;
            } else {
                view = null;
                z2 = false;
                z = false;
            }
            if (!((Boolean) zzay.zzc().zzb(zzbjc.zzbi)).booleanValue() || view == null) {
                list = Collections.emptyList();
            } else {
                try {
                    list = new ArrayList();
                    for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                        View view3 = (View) parent;
                        Rect rect5 = new Rect();
                        if (view3.isScrollContainer() && view3.getGlobalVisibleRect(rect5)) {
                            list.add(zza(rect5));
                        }
                    }
                } catch (Exception e2) {
                    zzt.zzo().zzt(e2, "PositionWatcher.getParentScrollViewRects");
                    list = Collections.emptyList();
                }
            }
            List list2 = list;
            int windowVisibility = view != null ? view.getWindowVisibility() : 8;
            int i4 = this.zzm;
            if (i4 != -1) {
                windowVisibility = i4;
            }
            zzt.zzp();
            long zzt = zzs.zzt(view);
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzim)).booleanValue()) {
                if (view2 != null) {
                    zzt.zzp();
                    if (zzs.zzP(view, this.zzg, this.zzh) && z && z2) {
                        if (zzt >= ((long) ((Integer) zzay.zzc().zzb(zzbjc.zzip)).intValue()) && windowVisibility == 0) {
                            z4 = true;
                            i2 = 0;
                            z3 = z4;
                            windowVisibility = i2;
                        }
                    }
                }
                i2 = windowVisibility;
                z4 = false;
                z3 = z4;
                windowVisibility = i2;
            } else {
                if (view2 != null) {
                    zzt.zzp();
                    if (zzs.zzP(view, this.zzg, this.zzh) && z && z2 && windowVisibility == 0) {
                        z3 = true;
                        windowVisibility = 0;
                    }
                }
                z3 = false;
            }
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzir)).booleanValue()) {
                zzt.zzp();
                boolean z5 = (windowVisibility == 0 ? (char) 128 : 0) | (true != zzs.zzP(view, this.zzg, this.zzh) ? 0 : '@') | (true != z ? (char) 0 : 8) | (true != z2 ? (char) 0 : 16);
                char c = zzt >= ((long) ((Integer) zzay.zzc().zzb(zzbjc.zzip)).intValue()) ? ' ' : 0;
                zzt.zzp();
                zzs.zzF(view, (z5 | c) | z3 ? 1 : 0, (MotionEvent) null);
            }
            if (i3 != 1 || this.zzk.zzb() || z3 != this.zzl) {
                if (z3 || this.zzl || i3 != 1) {
                    zzbbp zzbbp = new zzbbp(zzt.zzB().elapsedRealtime(), this.zzg.isScreenOn(), view != null && view.isAttachedToWindow(), view != null ? view.getWindowVisibility() : 8, zza(this.zzp), zza(rect), zza(rect2), z, zza(rect3), z2, zzt, zza(rect4), this.zzo.density, z3, list2);
                    Iterator it = this.zzn.iterator();
                    while (it.hasNext()) {
                        ((zzbbq) it.next()).zzc(zzbbp);
                    }
                    this.zzl = z3;
                }
            }
        }
    }

    private final void zzk() {
        zzs.zza.post(new zzbbn(this));
    }

    private final void zzl(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzi = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zza == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zza = new zzbbo(this);
            zzt.zzv().zzc(this.zzd, this.zza, intentFilter);
        }
        Application application = this.zze;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzj);
            } catch (Exception e) {
                zze.zzh("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private final void zzm(View view) {
        try {
            WeakReference weakReference = this.zzi;
            if (weakReference != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) weakReference.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzi = null;
            }
        } catch (Exception e) {
            zze.zzh("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
            zze.zzh("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.zza != null) {
            try {
                zzt.zzv().zzd(this.zzd, this.zza);
            } catch (IllegalStateException e3) {
                zze.zzh("Failed trying to unregister the receiver", e3);
            } catch (Exception e4) {
                zzt.zzo().zzt(e4, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zza = null;
        }
        Application application = this.zze;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzj);
            } catch (Exception e5) {
                zze.zzh("Error registering activity lifecycle callbacks.", e5);
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    public final void onActivityDestroyed(Activity activity) {
        zzj(3);
        zzk();
    }

    public final void onActivityPaused(Activity activity) {
        zzi(activity, 4);
        zzj(3);
        zzk();
    }

    public final void onActivityResumed(Activity activity) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzj(3);
        zzk();
    }

    public final void onActivityStarted(Activity activity) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    public final void onActivityStopped(Activity activity) {
        zzj(3);
        zzk();
    }

    public final void onGlobalLayout() {
        zzj(2);
        zzk();
    }

    public final void onScrollChanged() {
        zzj(1);
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzm = -1;
        zzl(view);
        zzj(3);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zzm = -1;
        zzj(3);
        zzk();
        zzm(view);
    }

    /* access modifiers changed from: package-private */
    public final Rect zza(Rect rect) {
        return new Rect(zzh(rect.left), zzh(rect.top), zzh(rect.right), zzh(rect.bottom));
    }

    public final void zzc(zzbbq zzbbq) {
        this.zzn.add(zzbbq);
        zzj(3);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        zzj(3);
    }

    public final void zze(zzbbq zzbbq) {
        this.zzn.remove(zzbbq);
    }

    public final void zzf() {
        this.zzk.zza(zzc);
    }

    public final void zzg(long j) {
        this.zzk.zza(j);
    }
}
