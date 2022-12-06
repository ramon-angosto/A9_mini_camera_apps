package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbrq;
import com.google.android.gms.internal.ads.zzbry;
import com.google.android.gms.internal.ads.zzbrz;
import com.google.android.gms.internal.ads.zzbvd;
import com.google.android.gms.internal.ads.zzcgp;
import com.google.android.gms.internal.ads.zzftm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzed {
    private static zzed zza;
    /* access modifiers changed from: private */
    public final Object zzb = new Object();
    /* access modifiers changed from: private */
    public final ArrayList zzc = new ArrayList();
    /* access modifiers changed from: private */
    public boolean zzd = false;
    /* access modifiers changed from: private */
    public boolean zze = false;
    private final Object zzf = new Object();
    private zzcm zzg;
    /* access modifiers changed from: private */
    @Nullable
    public OnAdInspectorClosedListener zzh = null;
    private RequestConfiguration zzi = new RequestConfiguration.Builder().build();

    private zzed() {
    }

    public static zzed zzf() {
        zzed zzed;
        synchronized (zzed.class) {
            if (zza == null) {
                zza = new zzed();
            }
            zzed = zza;
        }
        return zzed;
    }

    /* access modifiers changed from: private */
    public static InitializationStatus zzw(List list) {
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzbrq zzbrq = (zzbrq) it.next();
            hashMap.put(zzbrq.zza, new zzbry(zzbrq.zzb ? AdapterStatus.State.READY : AdapterStatus.State.NOT_READY, zzbrq.zzd, zzbrq.zzc));
        }
        return new zzbrz(hashMap);
    }

    private final void zzx(Context context, @Nullable String str, @Nullable OnInitializationCompleteListener onInitializationCompleteListener) {
        try {
            zzbvd.zza().zzb(context, (String) null);
            this.zzg.zzj();
            this.zzg.zzk((String) null, ObjectWrapper.wrap(null));
        } catch (RemoteException e) {
            zzcgp.zzk("MobileAdsSettingManager initialization failed", e);
        }
    }

    private final void zzy(Context context) {
        if (this.zzg == null) {
            this.zzg = (zzcm) new zzao(zzaw.zza(), context).zzd(context, false);
        }
    }

    private final void zzz(RequestConfiguration requestConfiguration) {
        try {
            this.zzg.zzs(new zzez(requestConfiguration));
        } catch (RemoteException e) {
            zzcgp.zzh("Unable to set request configuration parcel.", e);
        }
    }

    public final RequestConfiguration zzc() {
        return this.zzi;
    }

    public final InitializationStatus zze() {
        InitializationStatus zzw;
        synchronized (this.zzf) {
            Preconditions.checkState(this.zzg != null, "MobileAds.initialize() must be called prior to getting initialization status.");
            try {
                zzw = zzw(this.zzg.zzg());
            } catch (RemoteException unused) {
                zzcgp.zzg("Unable to get Initialization status.");
                return new zzdv(this);
            }
        }
        return zzw;
    }

    @Deprecated
    public final String zzh() {
        String zzc2;
        synchronized (this.zzf) {
            Preconditions.checkState(this.zzg != null, "MobileAds.initialize() must be called prior to getting version string.");
            try {
                zzc2 = zzftm.zzc(this.zzg.zzf());
            } catch (RemoteException e) {
                zzcgp.zzh("Unable to get version string.", e);
                return "";
            }
        }
        return zzc2;
    }

    public final void zzl(Context context) {
        synchronized (this.zzf) {
            zzy(context);
            try {
                this.zzg.zzi();
            } catch (RemoteException unused) {
                zzcgp.zzg("Unable to disable mediation adapter initialization.");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
        if (r4 == null) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002c, code lost:
        r5 = r3.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        zzy(r4);
        r3.zzg.zzr(new com.google.android.gms.ads.internal.client.zzec(r3, (com.google.android.gms.ads.internal.client.zzeb) null));
        r3.zzg.zzn(new com.google.android.gms.internal.ads.zzbvh());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004e, code lost:
        if (r3.zzi.getTagForChildDirectedTreatment() != -1) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0056, code lost:
        if (r3.zzi.getTagForUnderAgeOfConsent() == -1) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0058, code lost:
        zzz(r3.zzi);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0060, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        com.google.android.gms.internal.ads.zzcgp.zzk("MobileAdsSettingManager initialization failed", r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d7, code lost:
        throw new java.lang.IllegalArgumentException("Context cannot be null.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzm(android.content.Context r4, @javax.annotation.Nullable java.lang.String r5, @javax.annotation.Nullable com.google.android.gms.ads.initialization.OnInitializationCompleteListener r6) {
        /*
            r3 = this;
            java.lang.Object r5 = r3.zzb
            monitor-enter(r5)
            boolean r0 = r3.zzd     // Catch:{ all -> 0x00d8 }
            if (r0 == 0) goto L_0x0010
            if (r6 == 0) goto L_0x000e
            java.util.ArrayList r4 = r3.zzc     // Catch:{ all -> 0x00d8 }
            r4.add(r6)     // Catch:{ all -> 0x00d8 }
        L_0x000e:
            monitor-exit(r5)     // Catch:{ all -> 0x00d8 }
            return
        L_0x0010:
            boolean r0 = r3.zze     // Catch:{ all -> 0x00d8 }
            if (r0 == 0) goto L_0x001f
            if (r6 == 0) goto L_0x001d
            com.google.android.gms.ads.initialization.InitializationStatus r4 = r3.zze()     // Catch:{ all -> 0x00d8 }
            r6.onInitializationComplete(r4)     // Catch:{ all -> 0x00d8 }
        L_0x001d:
            monitor-exit(r5)     // Catch:{ all -> 0x00d8 }
            return
        L_0x001f:
            r0 = 1
            r3.zzd = r0     // Catch:{ all -> 0x00d8 }
            if (r6 == 0) goto L_0x0029
            java.util.ArrayList r0 = r3.zzc     // Catch:{ all -> 0x00d8 }
            r0.add(r6)     // Catch:{ all -> 0x00d8 }
        L_0x0029:
            monitor-exit(r5)     // Catch:{ all -> 0x00d8 }
            if (r4 == 0) goto L_0x00d0
            java.lang.Object r5 = r3.zzf
            monitor-enter(r5)
            r0 = 0
            r3.zzy(r4)     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.ads.internal.client.zzcm r1 = r3.zzg     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.ads.internal.client.zzec r2 = new com.google.android.gms.ads.internal.client.zzec     // Catch:{ RemoteException -> 0x0060 }
            r2.<init>(r3, r0)     // Catch:{ RemoteException -> 0x0060 }
            r1.zzr(r2)     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.ads.internal.client.zzcm r1 = r3.zzg     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.internal.ads.zzbvh r2 = new com.google.android.gms.internal.ads.zzbvh     // Catch:{ RemoteException -> 0x0060 }
            r2.<init>()     // Catch:{ RemoteException -> 0x0060 }
            r1.zzn(r2)     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.ads.RequestConfiguration r1 = r3.zzi     // Catch:{ RemoteException -> 0x0060 }
            int r1 = r1.getTagForChildDirectedTreatment()     // Catch:{ RemoteException -> 0x0060 }
            r2 = -1
            if (r1 != r2) goto L_0x0058
            com.google.android.gms.ads.RequestConfiguration r1 = r3.zzi     // Catch:{ RemoteException -> 0x0060 }
            int r1 = r1.getTagForUnderAgeOfConsent()     // Catch:{ RemoteException -> 0x0060 }
            if (r1 == r2) goto L_0x0066
        L_0x0058:
            com.google.android.gms.ads.RequestConfiguration r1 = r3.zzi     // Catch:{ RemoteException -> 0x0060 }
            r3.zzz(r1)     // Catch:{ RemoteException -> 0x0060 }
            goto L_0x0066
        L_0x005e:
            r4 = move-exception
            goto L_0x00ce
        L_0x0060:
            r1 = move-exception
            java.lang.String r2 = "MobileAdsSettingManager initialization failed"
            com.google.android.gms.internal.ads.zzcgp.zzk(r2, r1)     // Catch:{ all -> 0x005e }
        L_0x0066:
            com.google.android.gms.internal.ads.zzbjc.zzc(r4)     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.ads.zzbke r1 = com.google.android.gms.internal.ads.zzbkq.zza     // Catch:{ all -> 0x005e }
            java.lang.Object r1 = r1.zze()     // Catch:{ all -> 0x005e }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x005e }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x0099
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zziL     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x005e }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ all -> 0x005e }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x005e }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x0099
            java.lang.String r1 = "Initializing on bg thread"
            com.google.android.gms.internal.ads.zzcgp.zze(r1)     // Catch:{ all -> 0x005e }
            java.util.concurrent.ThreadPoolExecutor r1 = com.google.android.gms.internal.ads.zzcge.zza     // Catch:{ all -> 0x005e }
            com.google.android.gms.ads.internal.client.zzdw r2 = new com.google.android.gms.ads.internal.client.zzdw     // Catch:{ all -> 0x005e }
            r2.<init>(r3, r4, r0, r6)     // Catch:{ all -> 0x005e }
            r1.execute(r2)     // Catch:{ all -> 0x005e }
            goto L_0x00cc
        L_0x0099:
            com.google.android.gms.internal.ads.zzbke r1 = com.google.android.gms.internal.ads.zzbkq.zzb     // Catch:{ all -> 0x005e }
            java.lang.Object r1 = r1.zze()     // Catch:{ all -> 0x005e }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x005e }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x00c4
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zziL     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x005e }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ all -> 0x005e }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x005e }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x00c4
            java.util.concurrent.ExecutorService r1 = com.google.android.gms.internal.ads.zzcge.zzb     // Catch:{ all -> 0x005e }
            com.google.android.gms.ads.internal.client.zzdx r2 = new com.google.android.gms.ads.internal.client.zzdx     // Catch:{ all -> 0x005e }
            r2.<init>(r3, r4, r0, r6)     // Catch:{ all -> 0x005e }
            r1.execute(r2)     // Catch:{ all -> 0x005e }
            goto L_0x00cc
        L_0x00c4:
            java.lang.String r1 = "Initializing on calling thread"
            com.google.android.gms.internal.ads.zzcgp.zze(r1)     // Catch:{ all -> 0x005e }
            r3.zzx(r4, r0, r6)     // Catch:{ all -> 0x005e }
        L_0x00cc:
            monitor-exit(r5)     // Catch:{ all -> 0x005e }
            return
        L_0x00ce:
            monitor-exit(r5)     // Catch:{ all -> 0x005e }
            throw r4
        L_0x00d0:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Context cannot be null."
            r4.<init>(r5)
            throw r4
        L_0x00d8:
            r4 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00d8 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzed.zzm(android.content.Context, java.lang.String, com.google.android.gms.ads.initialization.OnInitializationCompleteListener):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(Context context, String str, OnInitializationCompleteListener onInitializationCompleteListener) {
        synchronized (this.zzf) {
            zzx(context, (String) null, onInitializationCompleteListener);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(Context context, String str, OnInitializationCompleteListener onInitializationCompleteListener) {
        synchronized (this.zzf) {
            zzx(context, (String) null, onInitializationCompleteListener);
        }
    }

    public final void zzp(Context context, OnAdInspectorClosedListener onAdInspectorClosedListener) {
        synchronized (this.zzf) {
            zzy(context);
            this.zzh = onAdInspectorClosedListener;
            try {
                this.zzg.zzl(new zzea((zzdz) null));
            } catch (RemoteException unused) {
                zzcgp.zzg("Unable to open the ad inspector.");
                if (onAdInspectorClosedListener != null) {
                    onAdInspectorClosedListener.onAdInspectorClosed(new AdInspectorError(0, "Ad inspector had an internal error.", MobileAds.ERROR_DOMAIN));
                }
            }
        }
    }

    public final void zzq(Context context, String str) {
        synchronized (this.zzf) {
            Preconditions.checkState(this.zzg != null, "MobileAds.initialize() must be called prior to opening debug menu.");
            try {
                this.zzg.zzm(ObjectWrapper.wrap(context), str);
            } catch (RemoteException e) {
                zzcgp.zzh("Unable to open debug menu.", e);
            }
        }
    }

    public final void zzr(Class cls) {
        synchronized (this.zzf) {
            try {
                this.zzg.zzh(cls.getCanonicalName());
            } catch (RemoteException e) {
                zzcgp.zzh("Unable to register RtbAdapter", e);
            }
        }
    }

    public final void zzs(boolean z) {
        synchronized (this.zzf) {
            Preconditions.checkState(this.zzg != null, "MobileAds.initialize() must be called prior to setting app muted state.");
            try {
                this.zzg.zzo(z);
            } catch (RemoteException e) {
                zzcgp.zzh("Unable to set app mute state.", e);
            }
        }
    }

    public final void zzt(float f) {
        boolean z = true;
        Preconditions.checkArgument(f >= 0.0f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        synchronized (this.zzf) {
            if (this.zzg == null) {
                z = false;
            }
            Preconditions.checkState(z, "MobileAds.initialize() must be called prior to setting the app volume.");
            try {
                this.zzg.zzp(f);
            } catch (RemoteException e) {
                zzcgp.zzh("Unable to set app volume.", e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzu(com.google.android.gms.ads.RequestConfiguration r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0004
            r0 = 1
            goto L_0x0005
        L_0x0004:
            r0 = 0
        L_0x0005:
            java.lang.String r1 = "Null passed to setRequestConfiguration."
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0, r1)
            java.lang.Object r0 = r4.zzf
            monitor-enter(r0)
            com.google.android.gms.ads.RequestConfiguration r1 = r4.zzi     // Catch:{ all -> 0x0030 }
            r4.zzi = r5     // Catch:{ all -> 0x0030 }
            com.google.android.gms.ads.internal.client.zzcm r2 = r4.zzg     // Catch:{ all -> 0x0030 }
            if (r2 != 0) goto L_0x0017
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0017:
            int r2 = r1.getTagForChildDirectedTreatment()     // Catch:{ all -> 0x0030 }
            int r3 = r5.getTagForChildDirectedTreatment()     // Catch:{ all -> 0x0030 }
            if (r2 != r3) goto L_0x002b
            int r1 = r1.getTagForUnderAgeOfConsent()     // Catch:{ all -> 0x0030 }
            int r2 = r5.getTagForUnderAgeOfConsent()     // Catch:{ all -> 0x0030 }
            if (r1 == r2) goto L_0x002e
        L_0x002b:
            r4.zzz(r5)     // Catch:{ all -> 0x0030 }
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0030:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzed.zzu(com.google.android.gms.ads.RequestConfiguration):void");
    }

    public final float zza() {
        float f;
        synchronized (this.zzf) {
            zzcm zzcm = this.zzg;
            f = 1.0f;
            if (zzcm == null) {
                return 1.0f;
            }
            try {
                f = zzcm.zze();
            } catch (RemoteException e) {
                zzcgp.zzh("Unable to get app volume.", e);
            }
        }
        return f;
    }

    public final boolean zzv() {
        boolean z;
        synchronized (this.zzf) {
            zzcm zzcm = this.zzg;
            z = false;
            if (zzcm == null) {
                return false;
            }
            try {
                z = zzcm.zzt();
            } catch (RemoteException e) {
                zzcgp.zzh("Unable to get app mute state.", e);
            }
        }
        return z;
    }
}
