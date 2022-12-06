package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.internal.client.zzdh;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzebe {
    final Map zza = new HashMap();
    private final Context zzb;
    /* access modifiers changed from: private */
    public final zzeas zzc;
    private final zzfzq zzd;
    private zzeak zze;

    zzebe(Context context, zzeas zzeas, zzfzq zzfzq) {
        this.zzb = context;
        this.zzc = zzeas;
        this.zzd = zzfzq;
    }

    private static AdRequest zzh() {
        return new AdRequest.Builder().build();
    }

    /* access modifiers changed from: private */
    public static String zzi(Object obj) {
        ResponseInfo responseInfo;
        zzdh zzc2;
        if (obj instanceof LoadAdError) {
            responseInfo = ((LoadAdError) obj).getResponseInfo();
        } else if (obj instanceof AppOpenAd) {
            responseInfo = ((AppOpenAd) obj).getResponseInfo();
        } else if (obj instanceof InterstitialAd) {
            responseInfo = ((InterstitialAd) obj).getResponseInfo();
        } else if (obj instanceof RewardedAd) {
            responseInfo = ((RewardedAd) obj).getResponseInfo();
        } else if (obj instanceof RewardedInterstitialAd) {
            responseInfo = ((RewardedInterstitialAd) obj).getResponseInfo();
        } else if (obj instanceof AdView) {
            responseInfo = ((AdView) obj).getResponseInfo();
        } else {
            if (obj instanceof NativeAd) {
                responseInfo = ((NativeAd) obj).getResponseInfo();
            }
            return "";
        }
        if (responseInfo == null || (zzc2 = responseInfo.zzc()) == null) {
            return "";
        }
        try {
            return zzc2.zzh();
        } catch (RemoteException unused) {
        }
    }

    /* access modifiers changed from: private */
    public final synchronized void zzj(String str, String str2) {
        try {
            zzfzg.zzr(this.zze.zzb(str), new zzebc(this, str2), this.zzd);
        } catch (NullPointerException e) {
            zzt.zzo().zzt(e, "OutOfContextTester.setAdAsOutOfContext");
            this.zzc.zzk(str2);
        }
    }

    private final synchronized void zzk(String str, String str2) {
        try {
            zzfzg.zzr(this.zze.zzb(str), new zzebd(this, str2), this.zzd);
        } catch (NullPointerException e) {
            zzt.zzo().zzt(e, "OutOfContextTester.setAdAsShown");
            this.zzc.zzk(str2);
        }
    }

    public final void zzd(zzeak zzeak) {
        this.zze = zzeak;
    }

    /* access modifiers changed from: protected */
    public final synchronized void zze(String str, Object obj, String str2) {
        this.zza.put(str, obj);
        zzj(zzi(obj), str2);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzf(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r6 = this;
            monitor-enter(r6)
            int r0 = r8.hashCode()     // Catch:{ all -> 0x00dd }
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -1999289321: goto L_0x0040;
                case -1372958932: goto L_0x0036;
                case -428325382: goto L_0x002c;
                case 543046670: goto L_0x0022;
                case 1854800829: goto L_0x0018;
                case 1951953708: goto L_0x000e;
                default: goto L_0x000d;
            }     // Catch:{ all -> 0x00dd }
        L_0x000d:
            goto L_0x004a
        L_0x000e:
            java.lang.String r0 = "BANNER"
            boolean r8 = r8.equals(r0)     // Catch:{ all -> 0x00dd }
            if (r8 == 0) goto L_0x004a
            r8 = r5
            goto L_0x004b
        L_0x0018:
            java.lang.String r0 = "REWARDED_INTERSTITIAL"
            boolean r8 = r8.equals(r0)     // Catch:{ all -> 0x00dd }
            if (r8 == 0) goto L_0x004a
            r8 = r1
            goto L_0x004b
        L_0x0022:
            java.lang.String r0 = "REWARDED"
            boolean r8 = r8.equals(r0)     // Catch:{ all -> 0x00dd }
            if (r8 == 0) goto L_0x004a
            r8 = r2
            goto L_0x004b
        L_0x002c:
            java.lang.String r0 = "APP_OPEN_AD"
            boolean r8 = r8.equals(r0)     // Catch:{ all -> 0x00dd }
            if (r8 == 0) goto L_0x004a
            r8 = 0
            goto L_0x004b
        L_0x0036:
            java.lang.String r0 = "INTERSTITIAL"
            boolean r8 = r8.equals(r0)     // Catch:{ all -> 0x00dd }
            if (r8 == 0) goto L_0x004a
            r8 = r4
            goto L_0x004b
        L_0x0040:
            java.lang.String r0 = "NATIVE"
            boolean r8 = r8.equals(r0)     // Catch:{ all -> 0x00dd }
            if (r8 == 0) goto L_0x004a
            r8 = r3
            goto L_0x004b
        L_0x004a:
            r8 = -1
        L_0x004b:
            if (r8 == 0) goto L_0x00cd
            if (r8 == r5) goto L_0x00ad
            if (r8 == r4) goto L_0x009d
            if (r8 == r3) goto L_0x0079
            if (r8 == r2) goto L_0x0069
            if (r8 == r1) goto L_0x0059
            monitor-exit(r6)
            return
        L_0x0059:
            android.content.Context r8 = r6.zzb     // Catch:{ all -> 0x00dd }
            com.google.android.gms.ads.AdRequest r0 = zzh()     // Catch:{ all -> 0x00dd }
            com.google.android.gms.internal.ads.zzeba r1 = new com.google.android.gms.internal.ads.zzeba     // Catch:{ all -> 0x00dd }
            r1.<init>(r6, r7, r9)     // Catch:{ all -> 0x00dd }
            com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd.load((android.content.Context) r8, (java.lang.String) r7, (com.google.android.gms.ads.AdRequest) r0, (com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback) r1)     // Catch:{ all -> 0x00dd }
            monitor-exit(r6)
            return
        L_0x0069:
            android.content.Context r8 = r6.zzb     // Catch:{ all -> 0x00dd }
            com.google.android.gms.ads.AdRequest r0 = zzh()     // Catch:{ all -> 0x00dd }
            com.google.android.gms.internal.ads.zzeaz r1 = new com.google.android.gms.internal.ads.zzeaz     // Catch:{ all -> 0x00dd }
            r1.<init>(r6, r7, r9)     // Catch:{ all -> 0x00dd }
            com.google.android.gms.ads.rewarded.RewardedAd.load((android.content.Context) r8, (java.lang.String) r7, (com.google.android.gms.ads.AdRequest) r0, (com.google.android.gms.ads.rewarded.RewardedAdLoadCallback) r1)     // Catch:{ all -> 0x00dd }
            monitor-exit(r6)
            return
        L_0x0079:
            com.google.android.gms.ads.AdLoader$Builder r8 = new com.google.android.gms.ads.AdLoader$Builder     // Catch:{ all -> 0x00dd }
            android.content.Context r0 = r6.zzb     // Catch:{ all -> 0x00dd }
            r8.<init>(r0, r7)     // Catch:{ all -> 0x00dd }
            com.google.android.gms.internal.ads.zzeav r0 = new com.google.android.gms.internal.ads.zzeav     // Catch:{ all -> 0x00dd }
            r0.<init>(r6, r7, r9)     // Catch:{ all -> 0x00dd }
            r8.forNativeAd(r0)     // Catch:{ all -> 0x00dd }
            com.google.android.gms.internal.ads.zzebb r7 = new com.google.android.gms.internal.ads.zzebb     // Catch:{ all -> 0x00dd }
            r7.<init>(r6, r9)     // Catch:{ all -> 0x00dd }
            r8.withAdListener(r7)     // Catch:{ all -> 0x00dd }
            com.google.android.gms.ads.AdLoader r7 = r8.build()     // Catch:{ all -> 0x00dd }
            com.google.android.gms.ads.AdRequest r8 = zzh()     // Catch:{ all -> 0x00dd }
            r7.loadAd((com.google.android.gms.ads.AdRequest) r8)     // Catch:{ all -> 0x00dd }
            monitor-exit(r6)
            return
        L_0x009d:
            android.content.Context r8 = r6.zzb     // Catch:{ all -> 0x00dd }
            com.google.android.gms.ads.AdRequest r0 = zzh()     // Catch:{ all -> 0x00dd }
            com.google.android.gms.internal.ads.zzeay r1 = new com.google.android.gms.internal.ads.zzeay     // Catch:{ all -> 0x00dd }
            r1.<init>(r6, r7, r9)     // Catch:{ all -> 0x00dd }
            com.google.android.gms.ads.interstitial.InterstitialAd.load(r8, r7, r0, r1)     // Catch:{ all -> 0x00dd }
            monitor-exit(r6)
            return
        L_0x00ad:
            com.google.android.gms.ads.AdView r8 = new com.google.android.gms.ads.AdView     // Catch:{ all -> 0x00dd }
            android.content.Context r0 = r6.zzb     // Catch:{ all -> 0x00dd }
            r8.<init>(r0)     // Catch:{ all -> 0x00dd }
            com.google.android.gms.ads.AdSize r0 = com.google.android.gms.ads.AdSize.BANNER     // Catch:{ all -> 0x00dd }
            r8.setAdSize(r0)     // Catch:{ all -> 0x00dd }
            r8.setAdUnitId(r7)     // Catch:{ all -> 0x00dd }
            com.google.android.gms.internal.ads.zzeax r0 = new com.google.android.gms.internal.ads.zzeax     // Catch:{ all -> 0x00dd }
            r0.<init>(r6, r7, r8, r9)     // Catch:{ all -> 0x00dd }
            r8.setAdListener(r0)     // Catch:{ all -> 0x00dd }
            com.google.android.gms.ads.AdRequest r7 = zzh()     // Catch:{ all -> 0x00dd }
            r8.loadAd(r7)     // Catch:{ all -> 0x00dd }
            monitor-exit(r6)
            return
        L_0x00cd:
            android.content.Context r8 = r6.zzb     // Catch:{ all -> 0x00dd }
            com.google.android.gms.ads.AdRequest r0 = zzh()     // Catch:{ all -> 0x00dd }
            com.google.android.gms.internal.ads.zzeaw r1 = new com.google.android.gms.internal.ads.zzeaw     // Catch:{ all -> 0x00dd }
            r1.<init>(r6, r7, r9)     // Catch:{ all -> 0x00dd }
            com.google.android.gms.ads.appopen.AppOpenAd.load((android.content.Context) r8, (java.lang.String) r7, (com.google.android.gms.ads.AdRequest) r0, (int) r5, (com.google.android.gms.ads.appopen.AppOpenAd.AppOpenAdLoadCallback) r1)     // Catch:{ all -> 0x00dd }
            monitor-exit(r6)
            return
        L_0x00dd:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzebe.zzf(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public final synchronized void zzg(String str, String str2) {
        Activity zzg = this.zzc.zzg();
        if (zzg != null) {
            Object obj = this.zza.get(str);
            if (obj != null) {
                this.zza.remove(str);
                zzk(zzi(obj), str2);
                if (obj instanceof AppOpenAd) {
                    ((AppOpenAd) obj).show(zzg);
                } else if (obj instanceof InterstitialAd) {
                    ((InterstitialAd) obj).show(zzg);
                } else if (obj instanceof RewardedAd) {
                    ((RewardedAd) obj).show(zzg, zzeat.zza);
                } else if (obj instanceof RewardedInterstitialAd) {
                    ((RewardedInterstitialAd) obj).show(zzg, zzeau.zza);
                }
            }
        }
    }
}
