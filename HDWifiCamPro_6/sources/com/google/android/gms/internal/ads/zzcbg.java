package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.zzt;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcbg {
    private int zzA;
    private final String zzB;
    private boolean zzC;
    private int zza;
    private boolean zzb;
    private boolean zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private String zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;
    private int zzl;
    private double zzm;
    private boolean zzn;
    private String zzo;
    private String zzp;
    private final boolean zzq;
    private final boolean zzr;
    private final String zzs;
    private final boolean zzt;
    private final boolean zzu;
    private final boolean zzv;
    private final String zzw;
    private final String zzx;
    private float zzy;
    private int zzz;

    /* JADX WARNING: Removed duplicated region for block: B:21:0x009a A[Catch:{ Exception -> 0x00b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00bf A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzcbg(android.content.Context r7) {
        /*
            r6 = this;
            r6.<init>()
            android.content.pm.PackageManager r0 = r7.getPackageManager()
            com.google.android.gms.internal.ads.zzbjc.zzc(r7)
            r6.zzc(r7)
            r6.zze(r7)
            r6.zzd(r7)
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r2 = "geo:0,0?q=donuts"
            android.content.pm.ResolveInfo r2 = zzb(r0, r2)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0023
            r2 = r3
            goto L_0x0024
        L_0x0023:
            r2 = r4
        L_0x0024:
            r6.zzq = r2
            java.lang.String r2 = "http://www.google.com"
            android.content.pm.ResolveInfo r2 = zzb(r0, r2)
            if (r2 == 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r3 = r4
        L_0x0030:
            r6.zzr = r3
            java.lang.String r2 = r1.getCountry()
            r6.zzs = r2
            com.google.android.gms.ads.internal.zzt.zzp()
            com.google.android.gms.ads.internal.client.zzaw.zzb()
            boolean r2 = com.google.android.gms.internal.ads.zzcgi.zzq()
            r6.zzt = r2
            boolean r2 = com.google.android.gms.common.util.DeviceProperties.isLatchsky(r7)
            r6.zzu = r2
            boolean r2 = com.google.android.gms.common.util.DeviceProperties.isSidewinder(r7)
            r6.zzv = r2
            java.lang.String r1 = r1.getLanguage()
            r6.zzw = r1
            java.lang.String r1 = "market://details?id=com.google.android.gms.ads"
            android.content.pm.ResolveInfo r0 = zzb(r0, r1)
            java.lang.String r1 = "."
            r2 = 0
            if (r0 != 0) goto L_0x0063
        L_0x0061:
            r0 = r2
            goto L_0x008a
        L_0x0063:
            android.content.pm.ActivityInfo r0 = r0.activityInfo
            if (r0 != 0) goto L_0x0068
            goto L_0x0061
        L_0x0068:
            com.google.android.gms.common.wrappers.PackageManagerWrapper r3 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r7)     // Catch:{ NameNotFoundException -> 0x0061 }
            java.lang.String r5 = r0.packageName     // Catch:{ NameNotFoundException -> 0x0061 }
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r5, r4)     // Catch:{ NameNotFoundException -> 0x0061 }
            if (r3 == 0) goto L_0x0061
            int r3 = r3.versionCode     // Catch:{ NameNotFoundException -> 0x0061 }
            java.lang.String r0 = r0.packageName     // Catch:{ NameNotFoundException -> 0x0061 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NameNotFoundException -> 0x0061 }
            r4.<init>()     // Catch:{ NameNotFoundException -> 0x0061 }
            r4.append(r3)     // Catch:{ NameNotFoundException -> 0x0061 }
            r4.append(r1)     // Catch:{ NameNotFoundException -> 0x0061 }
            r4.append(r0)     // Catch:{ NameNotFoundException -> 0x0061 }
            java.lang.String r0 = r4.toString()     // Catch:{ NameNotFoundException -> 0x0061 }
        L_0x008a:
            r6.zzx = r0
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r7)     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r3 = "com.android.vending"
            r4 = 128(0x80, float:1.794E-43)
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r3, r4)     // Catch:{ Exception -> 0x00b0 }
            if (r0 == 0) goto L_0x00b0
            int r3 = r0.versionCode     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r0 = r0.packageName     // Catch:{ Exception -> 0x00b0 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b0 }
            r4.<init>()     // Catch:{ Exception -> 0x00b0 }
            r4.append(r3)     // Catch:{ Exception -> 0x00b0 }
            r4.append(r1)     // Catch:{ Exception -> 0x00b0 }
            r4.append(r0)     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x00b0 }
        L_0x00b0:
            r6.zzB = r2
            android.content.res.Resources r7 = r7.getResources()
            if (r7 != 0) goto L_0x00b9
            return
        L_0x00b9:
            android.util.DisplayMetrics r7 = r7.getDisplayMetrics()
            if (r7 != 0) goto L_0x00c0
            return
        L_0x00c0:
            float r0 = r7.density
            r6.zzy = r0
            int r0 = r7.widthPixels
            r6.zzz = r0
            int r7 = r7.heightPixels
            r6.zzA = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbg.<init>(android.content.Context):void");
    }

    private static ResolveInfo zzb(PackageManager packageManager, String str) {
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        } catch (Throwable th) {
            zzt.zzo().zzt(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    private final void zzc(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager != null) {
            try {
                this.zza = audioManager.getMode();
                this.zzb = audioManager.isMusicActive();
                this.zzc = audioManager.isSpeakerphoneOn();
                this.zzd = audioManager.getStreamVolume(3);
                this.zze = audioManager.getRingerMode();
                this.zzf = audioManager.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                zzt.zzo().zzt(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.zza = -2;
        this.zzb = false;
        this.zzc = false;
        this.zzd = 0;
        this.zze = 2;
        this.zzf = 0;
    }

    private final void zzd(Context context) {
        Intent intent;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zziE)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            intent = context.registerReceiver((BroadcastReceiver) null, intentFilter);
        } else {
            intent = context.registerReceiver((BroadcastReceiver) null, intentFilter, 4);
        }
        if (intent != null) {
            int intExtra = intent.getIntExtra("status", -1);
            this.zzm = (double) (((float) intent.getIntExtra("level", -1)) / ((float) intent.getIntExtra("scale", -1)));
            boolean z = true;
            if (!(intExtra == 2 || intExtra == 5)) {
                z = false;
            }
            this.zzn = z;
            return;
        }
        this.zzm = -1.0d;
        this.zzn = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zze(android.content.Context r6) {
        /*
            r5 = this;
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r6.getSystemService(r0)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            java.lang.String r1 = "connectivity"
            java.lang.Object r1 = r6.getSystemService(r1)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            java.lang.String r2 = r0.getNetworkOperator()
            r5.zzg = r2
            boolean r2 = com.google.android.gms.common.util.PlatformVersion.isAtLeastR()
            r3 = 0
            if (r2 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzbiu r2 = com.google.android.gms.internal.ads.zzbjc.zzhn
            com.google.android.gms.internal.ads.zzbja r4 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r2 = r4.zzb(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0031
            r2 = r3
            goto L_0x0035
        L_0x0031:
            int r2 = r0.getNetworkType()
        L_0x0035:
            r5.zzi = r2
            int r0 = r0.getPhoneType()
            r5.zzj = r0
            r0 = -2
            r5.zzh = r0
            r5.zzk = r3
            r0 = -1
            r5.zzl = r0
            com.google.android.gms.ads.internal.zzt.zzp()
            java.lang.String r2 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r6 = com.google.android.gms.ads.internal.util.zzs.zzx(r6, r2)
            if (r6 == 0) goto L_0x006f
            android.net.NetworkInfo r6 = r1.getActiveNetworkInfo()
            if (r6 == 0) goto L_0x0067
            int r0 = r6.getType()
            r5.zzh = r0
            android.net.NetworkInfo$DetailedState r6 = r6.getDetailedState()
            int r6 = r6.ordinal()
            r5.zzl = r6
            goto L_0x0069
        L_0x0067:
            r5.zzh = r0
        L_0x0069:
            boolean r6 = r1.isActiveNetworkMetered()
            r5.zzk = r6
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbg.zze(android.content.Context):void");
    }

    public final zzcbh zza() {
        return new zzcbh(this.zza, this.zzq, this.zzr, this.zzg, this.zzs, this.zzt, this.zzu, this.zzv, this.zzb, this.zzc, this.zzw, this.zzx, this.zzB, this.zzd, this.zzh, this.zzi, this.zzj, this.zze, this.zzf, this.zzy, this.zzz, this.zzA, this.zzm, this.zzn, this.zzk, this.zzl, this.zzo, this.zzC, this.zzp);
    }

    public zzcbg(Context context, zzcbh zzcbh) {
        zzbjc.zzc(context);
        zzc(context);
        zze(context);
        zzd(context);
        this.zzo = Build.FINGERPRINT;
        this.zzp = Build.DEVICE;
        this.zzC = zzbka.zzg(context);
        this.zzq = zzcbh.zza;
        this.zzr = zzcbh.zzb;
        this.zzs = zzcbh.zzd;
        this.zzt = zzcbh.zze;
        this.zzu = zzcbh.zzf;
        this.zzv = zzcbh.zzg;
        this.zzw = zzcbh.zzh;
        this.zzx = zzcbh.zzi;
        this.zzB = zzcbh.zzj;
        this.zzy = zzcbh.zzm;
        this.zzz = zzcbh.zzn;
        this.zzA = zzcbh.zzo;
    }
}
