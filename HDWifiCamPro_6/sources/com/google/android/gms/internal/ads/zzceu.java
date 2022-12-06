package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzez;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.reflect.Method;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzceu {
    final AtomicBoolean zza = new AtomicBoolean(false);
    private final AtomicReference zzb = new AtomicReference((Object) null);
    private final Object zzc = new Object();
    private String zzd = null;
    private String zze = null;
    private final AtomicInteger zzf = new AtomicInteger(-1);
    private final AtomicReference zzg = new AtomicReference((Object) null);
    private final AtomicReference zzh = new AtomicReference((Object) null);
    private final ConcurrentMap zzi = new ConcurrentHashMap(9);
    private final AtomicReference zzj = new AtomicReference((Object) null);
    private final BlockingQueue zzk = new ArrayBlockingQueue(20);
    private final Object zzl = new Object();

    private final void zzA(Context context, String str, String str2) {
        if (zzE(context, "com.google.android.gms.measurement.AppMeasurement", this.zzg, true)) {
            Method method = (Method) this.zzi.get(str2);
            if (method == null) {
                try {
                    method = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str2, new Class[]{String.class});
                    this.zzi.put(str2, method);
                } catch (Exception unused) {
                    zzC(str2, false);
                    method = null;
                }
            }
            try {
                method.invoke(this.zzg.get(), new Object[]{str});
                zze.zza("Invoke Firebase method " + str2 + ", Ad Unit Id: " + str);
            } catch (Exception unused2) {
                zzC(str2, false);
            }
        }
    }

    private final void zzB(Context context, String str, String str2, Bundle bundle) {
        if (zzu(context)) {
            Bundle bundle2 = new Bundle();
            try {
                bundle2.putLong("_aeid", Long.parseLong(str2));
            } catch (NullPointerException | NumberFormatException e) {
                zze.zzh("Invalid event ID: ".concat(String.valueOf(str2)), e);
            }
            if ("_ac".equals(str)) {
                bundle2.putInt("_r", 1);
            }
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            if (zzv(context)) {
                zzD("logEventInternal", new zzceg(str, bundle2));
            } else if (zzE(context, "com.google.android.gms.measurement.AppMeasurement", this.zzg, true)) {
                Method method = (Method) this.zzi.get("logEventInternal");
                if (method == null) {
                    try {
                        method = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", new Class[]{String.class, String.class, Bundle.class});
                        this.zzi.put("logEventInternal", method);
                    } catch (Exception unused) {
                        zzC("logEventInternal", true);
                        method = null;
                    }
                }
                try {
                    method.invoke(this.zzg.get(), new Object[]{"am", str, bundle2});
                } catch (Exception unused2) {
                    zzC("logEventInternal", true);
                }
            }
        }
    }

    private final void zzC(String str, boolean z) {
        if (!this.zza.get()) {
            zze.zzj("Invoke Firebase method " + str + " error.");
            if (z) {
                zze.zzj("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
                this.zza.set(true);
            }
        }
    }

    private final void zzD(String str, zzcet zzcet) {
        synchronized (this.zzj) {
            FutureTask futureTask = new FutureTask(new zzceh(this, zzcet, str), (Object) null);
            if (this.zzj.get() != null) {
                futureTask.run();
            } else {
                this.zzk.offer(futureTask);
            }
        }
    }

    private final boolean zzE(Context context, String str, AtomicReference atomicReference, boolean z) {
        if (atomicReference.get() == null) {
            try {
                zzced.zza(atomicReference, (Object) null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{context}));
            } catch (Exception unused) {
                zzC("getInstance", z);
                return false;
            }
        }
        return true;
    }

    static final boolean zzv(Context context) {
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzaf)).booleanValue()) {
            return false;
        }
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) < ((Integer) zzay.zzc().zzb(zzbjc.zzag)).intValue()) {
            return false;
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzah)).booleanValue()) {
            try {
                context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                return false;
            } catch (ClassNotFoundException unused) {
            }
        }
        return true;
    }

    private final Object zzw(String str, Object obj, zzces zzces) {
        synchronized (this.zzj) {
            if (((zzcog) this.zzj.get()) != null) {
                try {
                    Object zza2 = zzces.zza((zzcog) this.zzj.get());
                    return zza2;
                } catch (Exception unused) {
                    zzC(str, false);
                    return obj;
                }
            }
        }
    }

    private final Object zzx(String str, Context context) {
        if (!zzE(context, "com.google.android.gms.measurement.AppMeasurement", this.zzg, true)) {
            return null;
        }
        try {
            return zzy(context, str).invoke(this.zzg.get(), new Object[0]);
        } catch (Exception unused) {
            zzC(str, true);
            return null;
        }
    }

    private final Method zzy(Context context, String str) {
        Method method = (Method) this.zzi.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.zzi.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            zzC(str, false);
            return null;
        }
    }

    /* JADX WARNING: type inference failed for: r0v9, types: [java.util.concurrent.ExecutorService] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.concurrent.ExecutorService zzz() {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicReference r0 = r9.zzb
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L_0x0067
            boolean r0 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r0 == 0) goto L_0x002d
            com.google.android.gms.internal.ads.zzfpv r0 = com.google.android.gms.internal.ads.zzfpy.zza()
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zzae
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r1 = r2.zzb(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            com.google.android.gms.internal.ads.zzcer r2 = new com.google.android.gms.internal.ads.zzcer
            r2.<init>(r9)
            r3 = 2
            java.util.concurrent.ExecutorService r0 = r0.zzc(r1, r2, r3)
            goto L_0x0061
        L_0x002d:
            java.util.concurrent.ThreadPoolExecutor r0 = new java.util.concurrent.ThreadPoolExecutor
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zzae
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r1 = r2.zzb(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r2 = r1.intValue()
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zzae
            com.google.android.gms.internal.ads.zzbja r3 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r1 = r3.zzb(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r3 = r1.intValue()
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MINUTES
            java.util.concurrent.LinkedBlockingQueue r7 = new java.util.concurrent.LinkedBlockingQueue
            r7.<init>()
            com.google.android.gms.internal.ads.zzcer r8 = new com.google.android.gms.internal.ads.zzcer
            r8.<init>(r9)
            r4 = 1
            r1 = r0
            r1.<init>(r2, r3, r4, r6, r7, r8)
        L_0x0061:
            java.util.concurrent.atomic.AtomicReference r1 = r9.zzb
            r2 = 0
            com.google.android.gms.internal.ads.zzced.zza(r1, r2, r0)
        L_0x0067:
            java.util.concurrent.atomic.AtomicReference r0 = r9.zzb
            java.lang.Object r0 = r0.get()
            java.util.concurrent.ExecutorService r0 = (java.util.concurrent.ExecutorService) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzceu.zzz():java.util.concurrent.ExecutorService");
    }

    public final String zza(Context context) {
        if (!zzu(context)) {
            return null;
        }
        if (zzv(context)) {
            Long l = (Long) zzw("getAdEventId", (Object) null, zzcei.zza);
            if (l != null) {
                return Long.toString(l.longValue());
            }
            return null;
        }
        Object zzx = zzx("generateEventId", context);
        if (zzx != null) {
            return zzx.toString();
        }
        return null;
    }

    public final String zzb(Context context) {
        if (!zzu(context)) {
            return null;
        }
        synchronized (this.zzc) {
            String str = this.zze;
            if (str != null) {
                return str;
            }
            if (zzv(context)) {
                this.zze = (String) zzw("getAppIdOrigin", this.zze, zzcem.zza);
            } else {
                this.zze = "fa";
            }
            String str2 = this.zze;
            return str2;
        }
    }

    public final String zzc(Context context) {
        if (!zzu(context)) {
            return null;
        }
        long longValue = ((Long) zzay.zzc().zzb(zzbjc.zzad)).longValue();
        if (zzv(context)) {
            if (longValue >= 0) {
                return (String) zzz().submit(new zzceo(this)).get(longValue, TimeUnit.MILLISECONDS);
            }
            try {
                return (String) zzw("getAppInstanceId", (Object) null, zzcen.zza);
            } catch (TimeoutException unused) {
                return "TIME_OUT";
            } catch (Exception unused2) {
                return null;
            }
        } else if (longValue < 0) {
            return (String) zzx("getAppInstanceId", context);
        } else {
            try {
                return (String) zzz().submit(new zzcep(this, context)).get(longValue, TimeUnit.MILLISECONDS);
            } catch (TimeoutException unused3) {
                return "TIME_OUT";
            } catch (Exception unused4) {
                return null;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzd(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "getCurrentScreenName"
            boolean r1 = r6.zzu(r7)
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x000b
            return r2
        L_0x000b:
            boolean r1 = zzv(r7)
            if (r1 == 0) goto L_0x001c
            com.google.android.gms.internal.ads.zzcej r7 = com.google.android.gms.internal.ads.zzcej.zza
            java.lang.String r0 = "getCurrentScreenNameOrScreenClass"
            java.lang.Object r7 = r6.zzw(r0, r2, r7)
            java.lang.String r7 = (java.lang.String) r7
            return r7
        L_0x001c:
            java.util.concurrent.atomic.AtomicReference r1 = r6.zzg
            r3 = 1
            java.lang.String r4 = "com.google.android.gms.measurement.AppMeasurement"
            boolean r1 = r6.zzE(r7, r4, r1, r3)
            if (r1 != 0) goto L_0x0028
            return r2
        L_0x0028:
            r1 = 0
            java.lang.reflect.Method r3 = r6.zzy(r7, r0)     // Catch:{ Exception -> 0x0056 }
            java.util.concurrent.atomic.AtomicReference r4 = r6.zzg     // Catch:{ Exception -> 0x0056 }
            java.lang.Object r4 = r4.get()     // Catch:{ Exception -> 0x0056 }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0056 }
            java.lang.Object r3 = r3.invoke(r4, r5)     // Catch:{ Exception -> 0x0056 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0056 }
            if (r3 != 0) goto L_0x0052
            java.lang.String r3 = "getCurrentScreenClass"
            java.lang.reflect.Method r7 = r6.zzy(r7, r3)     // Catch:{ Exception -> 0x0056 }
            java.util.concurrent.atomic.AtomicReference r3 = r6.zzg     // Catch:{ Exception -> 0x0056 }
            java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x0056 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0056 }
            java.lang.Object r7 = r7.invoke(r3, r4)     // Catch:{ Exception -> 0x0056 }
            r3 = r7
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0056 }
        L_0x0052:
            if (r3 == 0) goto L_0x0055
            return r3
        L_0x0055:
            return r2
        L_0x0056:
            r6.zzC(r0, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzceu.zzd(android.content.Context):java.lang.String");
    }

    public final String zze(Context context) {
        if (!zzu(context)) {
            return null;
        }
        synchronized (this.zzc) {
            String str = this.zzd;
            if (str != null) {
                return str;
            }
            if (zzv(context)) {
                this.zzd = (String) zzw("getGmpAppId", this.zzd, zzcef.zza);
            } else {
                this.zzd = (String) zzx("getGmpAppId", context);
            }
            String str2 = this.zzd;
            return str2;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzf() throws Exception {
        return (String) zzw("getAppInstanceId", (Object) null, zzcen.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzg(Context context) throws Exception {
        return (String) zzx("getAppInstanceId", context);
    }

    public final void zzh(Context context, String str) {
        if (zzu(context)) {
            if (zzv(context)) {
                zzD("beginAdUnitExposure", new zzcee(str));
            } else {
                zzA(context, str, "beginAdUnitExposure");
            }
        }
    }

    public final void zzi(Context context, String str) {
        if (zzu(context)) {
            if (zzv(context)) {
                zzD("endAdUnitExposure", new zzcel(str));
            } else {
                zzA(context, str, "endAdUnitExposure");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(zzcet zzcet, String str) {
        if (((zzcog) this.zzj.get()) != null) {
            try {
                zzcet.zza((zzcog) this.zzj.get());
            } catch (Exception unused) {
                zzC(str, false);
            }
        }
    }

    public final void zzk(Context context, String str) {
        zzB(context, "_aa", str, (Bundle) null);
    }

    public final void zzl(Context context, String str) {
        zzB(context, "_aq", str, (Bundle) null);
    }

    public final void zzm(Context context, String str) {
        zzB(context, "_ac", str, (Bundle) null);
    }

    public final void zzn(Context context, String str) {
        zzB(context, "_ai", str, (Bundle) null);
    }

    public final void zzo(Context context, String str, String str2, String str3, int i) {
        if (zzu(context)) {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str2);
            bundle.putString("reward_type", str3);
            bundle.putInt("reward_value", i);
            zzB(context, "_ar", str, bundle);
            zze.zza("Log a Firebase reward video event, reward type: " + str3 + ", reward value: " + i);
        }
    }

    public final void zzp(Context context, zzl zzl2) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzak)).booleanValue() && zzu(context) && zzv(context)) {
            synchronized (this.zzl) {
            }
        }
    }

    public final void zzq(Context context, zzez zzez) {
        zzcev.zzd(context).zzb().zzd(zzez);
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzak)).booleanValue() && zzu(context) && zzv(context)) {
            synchronized (this.zzl) {
            }
        }
    }

    public final void zzr(Bundle bundle) {
        zzD("setConsent", new zzceq(bundle));
    }

    @Deprecated
    public final void zzs(Context context, String str) {
        if (!zzu(context) || !(context instanceof Activity)) {
            return;
        }
        if (zzv(context)) {
            zzD("setScreenName", new zzcek(context, str));
        } else if (zzE(context, "com.google.firebase.analytics.FirebaseAnalytics", this.zzh, false)) {
            Method method = (Method) this.zzi.get("setCurrentScreen");
            if (method == null) {
                try {
                    method = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod("setCurrentScreen", new Class[]{Activity.class, String.class, String.class});
                    this.zzi.put("setCurrentScreen", method);
                } catch (Exception unused) {
                    zzC("setCurrentScreen", false);
                    method = null;
                }
            }
            try {
                method.invoke(this.zzh.get(), new Object[]{(Activity) context, str, context.getPackageName()});
            } catch (Exception unused2) {
                zzC("setCurrentScreen", false);
            }
        }
    }

    public final boolean zzt() {
        synchronized (this.zzl) {
        }
        return false;
    }

    public final boolean zzu(Context context) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzY)).booleanValue() && !this.zza.get()) {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzai)).booleanValue()) {
                return true;
            }
            if (this.zzf.get() == -1) {
                zzaw.zzb();
                if (!zzcgi.zzr(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                    zzaw.zzb();
                    if (zzcgi.zzs(context)) {
                        zze.zzj("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                        this.zzf.set(0);
                    }
                }
                this.zzf.set(1);
            }
            if (this.zzf.get() == 1) {
                return true;
            }
        }
        return false;
    }
}
