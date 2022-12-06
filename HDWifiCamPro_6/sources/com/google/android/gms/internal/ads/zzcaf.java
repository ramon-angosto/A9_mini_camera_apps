package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.wrappers.Wrappers;
import com.mbridge.msdk.MBridgeConstans;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzcaf implements zzcah {
    static zzcah zza = null;
    static zzcah zzb = null;
    private static final Object zzc = new Object();
    private final Object zzd = new Object();
    private final Context zze;
    private final WeakHashMap zzf = new WeakHashMap();
    private final ExecutorService zzg;
    private final zzcgv zzh;

    protected zzcaf(Context context, zzcgv zzcgv) {
        zzfpy.zza();
        this.zzg = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());
        this.zze = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzh = zzcgv;
    }

    public static zzcah zza(Context context) {
        synchronized (zzc) {
            if (zza == null) {
                if (((Boolean) zzbla.zze.zze()).booleanValue()) {
                    if (!((Boolean) zzay.zzc().zzb(zzbjc.zzgH)).booleanValue()) {
                        zza = new zzcaf(context, zzcgv.zza());
                    }
                }
                zza = new zzcag();
            }
        }
        return zza;
    }

    public static zzcah zzb(Context context, zzcgv zzcgv) {
        synchronized (zzc) {
            if (zzb == null) {
                if (((Boolean) zzbla.zze.zze()).booleanValue()) {
                    if (!((Boolean) zzay.zzc().zzb(zzbjc.zzgH)).booleanValue()) {
                        zzcaf zzcaf = new zzcaf(context, zzcgv);
                        Thread thread = Looper.getMainLooper().getThread();
                        if (thread != null) {
                            synchronized (zzcaf.zzd) {
                                zzcaf.zzf.put(thread, true);
                            }
                            thread.setUncaughtExceptionHandler(new zzcae(zzcaf, thread.getUncaughtExceptionHandler()));
                        }
                        Thread.setDefaultUncaughtExceptionHandler(new zzcad(zzcaf, Thread.getDefaultUncaughtExceptionHandler()));
                        zzb = zzcaf;
                    }
                }
                zzb = new zzcag();
            }
        }
        return zzb;
    }

    /* access modifiers changed from: protected */
    public final void zzc(Thread thread, Throwable th) {
        if (th != null) {
            boolean z = false;
            boolean z2 = false;
            Throwable th2 = th;
            while (th2 != null) {
                boolean z3 = z;
                for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                    z3 |= zzcgi.zzn(stackTraceElement.getClassName());
                    z2 |= getClass().getName().equals(stackTraceElement.getClassName());
                }
                th2 = th2.getCause();
                z = z3;
            }
            if (z && !z2) {
                zze(th, "", 1.0f);
            }
        }
    }

    public final void zzd(Throwable th, String str) {
        zze(th, str, 1.0f);
    }

    public final void zze(Throwable th, String str, float f) {
        boolean z;
        String str2;
        if (zzcgi.zzf(th) != null) {
            String name = th.getClass().getName();
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            double d = (double) f;
            double random = Math.random();
            int i = f > 0.0f ? (int) (1.0f / f) : 1;
            if (random < d) {
                ArrayList<String> arrayList = new ArrayList<>();
                try {
                    z = Wrappers.packageManager(this.zze).isCallerInstantApp();
                } catch (Throwable th2) {
                    zzcgp.zzh("Error fetching instant app info", th2);
                    z = false;
                }
                try {
                    str2 = this.zze.getPackageName();
                } catch (Throwable unused) {
                    zzcgp.zzj("Cannot obtain package name, proceeding.");
                    str2 = "unknown";
                }
                Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
                String str3 = Build.MANUFACTURER;
                String str4 = Build.MODEL;
                if (!str4.startsWith(str3)) {
                    str4 = str3 + " " + str4;
                }
                arrayList.add(appendQueryParameter.appendQueryParameter("device", str4).appendQueryParameter("js", this.zzh.zza).appendQueryParameter("appid", str2).appendQueryParameter("exceptiontype", name).appendQueryParameter("stacktrace", stringWriter2).appendQueryParameter("eids", TextUtils.join(",", zzbjc.zza())).appendQueryParameter("exceptionkey", str).appendQueryParameter("cl", "474357726").appendQueryParameter("rc", "dev").appendQueryParameter("sampling_rate", Integer.toString(i)).appendQueryParameter("pb_tm", String.valueOf(zzbla.zzc.zze())).appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zze))).appendQueryParameter("lite", true != this.zzh.zze ? MBridgeConstans.ENDCARD_URL_TYPE_PL : "1").toString());
                for (String zzcac : arrayList) {
                    this.zzg.execute(new zzcac(new zzcgu((String) null), zzcac));
                }
            }
        }
    }
}
