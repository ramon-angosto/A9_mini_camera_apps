package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbxo extends zzbxc {
    private final RtbAdapter zza;
    /* access modifiers changed from: private */
    public MediationInterstitialAd zzb;
    /* access modifiers changed from: private */
    public MediationRewardedAd zzc;
    private String zzd = "";

    public zzbxo(RtbAdapter rtbAdapter) {
        this.zza = rtbAdapter;
    }

    private final Bundle zzs(zzl zzl) {
        Bundle bundle;
        Bundle bundle2 = zzl.zzm;
        if (bundle2 == null || (bundle = bundle2.getBundle(this.zza.getClass().getName())) == null) {
            return new Bundle();
        }
        return bundle;
    }

    private static final Bundle zzt(String str) throws RemoteException {
        zzcgp.zzj("Server parameters: ".concat(String.valueOf(str)));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e) {
            zzcgp.zzh("", e);
            throw new RemoteException();
        }
    }

    private static final boolean zzu(zzl zzl) {
        if (zzl.zzf) {
            return true;
        }
        zzaw.zzb();
        return zzcgi.zzq();
    }

    private static final String zzv(String str, zzl zzl) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return zzl.zzu;
        }
    }

    public final zzdk zze() {
        RtbAdapter rtbAdapter = this.zza;
        if (rtbAdapter instanceof zzb) {
            try {
                return ((zzb) rtbAdapter).getVideoController();
            } catch (Throwable th) {
                zzcgp.zzh("", th);
            }
        }
        return null;
    }

    public final zzbxq zzf() throws RemoteException {
        return zzbxq.zza(this.zza.getVersionInfo());
    }

    public final zzbxq zzg() throws RemoteException {
        return zzbxq.zza(this.zza.getSDKVersionInfo());
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(com.google.android.gms.dynamic.IObjectWrapper r8, java.lang.String r9, android.os.Bundle r10, android.os.Bundle r11, com.google.android.gms.ads.internal.client.zzq r12, com.google.android.gms.internal.ads.zzbxg r13) throws android.os.RemoteException {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzbxm r0 = new com.google.android.gms.internal.ads.zzbxm     // Catch:{ all -> 0x008c }
            r0.<init>(r7, r13)     // Catch:{ all -> 0x008c }
            com.google.android.gms.ads.mediation.rtb.RtbAdapter r13 = r7.zza     // Catch:{ all -> 0x008c }
            com.google.android.gms.ads.mediation.MediationConfiguration r1 = new com.google.android.gms.ads.mediation.MediationConfiguration     // Catch:{ all -> 0x008c }
            int r2 = r9.hashCode()     // Catch:{ all -> 0x008c }
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r2) {
                case -1396342996: goto L_0x003d;
                case -1052618729: goto L_0x0033;
                case -239580146: goto L_0x0029;
                case 604727084: goto L_0x001f;
                case 1911491517: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0047
        L_0x0015:
            java.lang.String r2 = "rewarded_interstitial"
            boolean r9 = r9.equals(r2)
            if (r9 == 0) goto L_0x0047
            r9 = r4
            goto L_0x0048
        L_0x001f:
            java.lang.String r2 = "interstitial"
            boolean r9 = r9.equals(r2)
            if (r9 == 0) goto L_0x0047
            r9 = r6
            goto L_0x0048
        L_0x0029:
            java.lang.String r2 = "rewarded"
            boolean r9 = r9.equals(r2)
            if (r9 == 0) goto L_0x0047
            r9 = r5
            goto L_0x0048
        L_0x0033:
            java.lang.String r2 = "native"
            boolean r9 = r9.equals(r2)
            if (r9 == 0) goto L_0x0047
            r9 = r3
            goto L_0x0048
        L_0x003d:
            java.lang.String r2 = "banner"
            boolean r9 = r9.equals(r2)
            if (r9 == 0) goto L_0x0047
            r9 = 0
            goto L_0x0048
        L_0x0047:
            r9 = -1
        L_0x0048:
            if (r9 == 0) goto L_0x0066
            if (r9 == r6) goto L_0x0063
            if (r9 == r5) goto L_0x0060
            if (r9 == r4) goto L_0x005d
            if (r9 != r3) goto L_0x0055
            com.google.android.gms.ads.AdFormat r9 = com.google.android.gms.ads.AdFormat.NATIVE     // Catch:{ all -> 0x008c }
            goto L_0x0068
        L_0x0055:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x008c }
            java.lang.String r9 = "Internal Error"
            r8.<init>(r9)     // Catch:{ all -> 0x008c }
            throw r8     // Catch:{ all -> 0x008c }
        L_0x005d:
            com.google.android.gms.ads.AdFormat r9 = com.google.android.gms.ads.AdFormat.REWARDED_INTERSTITIAL     // Catch:{ all -> 0x008c }
            goto L_0x0068
        L_0x0060:
            com.google.android.gms.ads.AdFormat r9 = com.google.android.gms.ads.AdFormat.REWARDED     // Catch:{ all -> 0x008c }
            goto L_0x0068
        L_0x0063:
            com.google.android.gms.ads.AdFormat r9 = com.google.android.gms.ads.AdFormat.INTERSTITIAL     // Catch:{ all -> 0x008c }
            goto L_0x0068
        L_0x0066:
            com.google.android.gms.ads.AdFormat r9 = com.google.android.gms.ads.AdFormat.BANNER     // Catch:{ all -> 0x008c }
        L_0x0068:
            r1.<init>(r9, r11)     // Catch:{ all -> 0x008c }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x008c }
            r9.<init>()     // Catch:{ all -> 0x008c }
            r9.add(r1)     // Catch:{ all -> 0x008c }
            com.google.android.gms.ads.mediation.rtb.RtbSignalData r11 = new com.google.android.gms.ads.mediation.rtb.RtbSignalData     // Catch:{ all -> 0x008c }
            java.lang.Object r8 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r8)     // Catch:{ all -> 0x008c }
            android.content.Context r8 = (android.content.Context) r8     // Catch:{ all -> 0x008c }
            int r1 = r12.zze     // Catch:{ all -> 0x008c }
            int r2 = r12.zzb     // Catch:{ all -> 0x008c }
            java.lang.String r12 = r12.zza     // Catch:{ all -> 0x008c }
            com.google.android.gms.ads.AdSize r12 = com.google.android.gms.ads.zzb.zzc(r1, r2, r12)     // Catch:{ all -> 0x008c }
            r11.<init>(r8, r9, r10, r12)     // Catch:{ all -> 0x008c }
            r13.collectSignals(r11, r0)     // Catch:{ all -> 0x008c }
            return
        L_0x008c:
            r8 = move-exception
            java.lang.String r9 = "Error generating signals for RTB"
            com.google.android.gms.internal.ads.zzcgp.zzh(r9, r8)
            android.os.RemoteException r8 = new android.os.RemoteException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbxo.zzh(com.google.android.gms.dynamic.IObjectWrapper, java.lang.String, android.os.Bundle, android.os.Bundle, com.google.android.gms.ads.internal.client.zzq, com.google.android.gms.internal.ads.zzbxg):void");
    }

    public final void zzl(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbwx zzbwx, zzbvq zzbvq) throws RemoteException {
        zzm(str, str2, zzl, iObjectWrapper, zzbwx, zzbvq, (zzbls) null);
    }

    public final void zzp(String str) {
        this.zzd = str;
    }

    public final boolean zzq(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationInterstitialAd mediationInterstitialAd = this.zzb;
        if (mediationInterstitialAd == null) {
            return false;
        }
        try {
            mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzcgp.zzh("", th);
            return true;
        }
    }

    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationRewardedAd mediationRewardedAd = this.zzc;
        if (mediationRewardedAd == null) {
            return false;
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzcgp.zzh("", th);
            return true;
        }
    }

    public final void zzn(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbxa zzbxa, zzbvq zzbvq) throws RemoteException {
        zzl zzl2 = zzl;
        try {
            this.zza.loadRtbRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzt(str2), zzs(zzl2), zzu(zzl), zzl2.zzk, zzl2.zzg, zzl2.zzt, zzv(str2, zzl), this.zzd), new zzbxn(this, zzbxa, zzbvq));
        } catch (Throwable th) {
            zzcgp.zzh("Adapter failed to render rewarded interstitial ad.", th);
            throw new RemoteException();
        }
    }

    public final void zzo(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbxa zzbxa, zzbvq zzbvq) throws RemoteException {
        zzl zzl2 = zzl;
        try {
            this.zza.loadRtbRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzt(str2), zzs(zzl2), zzu(zzl), zzl2.zzk, zzl2.zzg, zzl2.zzt, zzv(str2, zzl), this.zzd), new zzbxn(this, zzbxa, zzbvq));
        } catch (Throwable th) {
            zzcgp.zzh("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    public final void zzk(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbwu zzbwu, zzbvq zzbvq) throws RemoteException {
        zzl zzl2 = zzl;
        try {
            this.zza.loadRtbInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzt(str2), zzs(zzl2), zzu(zzl), zzl2.zzk, zzl2.zzg, zzl2.zzt, zzv(str2, zzl), this.zzd), new zzbxk(this, zzbwu, zzbvq));
        } catch (Throwable th) {
            zzcgp.zzh("Adapter failed to render interstitial ad.", th);
            throw new RemoteException();
        }
    }

    public final void zzm(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbwx zzbwx, zzbvq zzbvq, zzbls zzbls) throws RemoteException {
        zzl zzl2 = zzl;
        try {
            zzbxl zzbxl = new zzbxl(this, zzbwx, zzbvq);
            RtbAdapter rtbAdapter = this.zza;
            MediationNativeAdConfiguration mediationNativeAdConfiguration = r4;
            MediationNativeAdConfiguration mediationNativeAdConfiguration2 = new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzt(str2), zzs(zzl2), zzu(zzl), zzl2.zzk, zzl2.zzg, zzl2.zzt, zzv(str2, zzl), this.zzd, zzbls);
            rtbAdapter.loadRtbNativeAd(mediationNativeAdConfiguration, zzbxl);
        } catch (Throwable th) {
            zzcgp.zzh("Adapter failed to render native ad.", th);
            throw new RemoteException();
        }
    }

    public final void zzi(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbwr zzbwr, zzbvq zzbvq, zzq zzq) throws RemoteException {
        zzl zzl2 = zzl;
        zzq zzq2 = zzq;
        try {
            zzbxi zzbxi = new zzbxi(this, zzbwr, zzbvq);
            RtbAdapter rtbAdapter = this.zza;
            Bundle zzt = zzt(str2);
            Bundle zzs = zzs(zzl2);
            boolean zzu = zzu(zzl);
            Location location = zzl2.zzk;
            int i = zzl2.zzg;
            int i2 = zzl2.zzt;
            String zzv = zzv(str2, zzl);
            AdSize zzc2 = com.google.android.gms.ads.zzb.zzc(zzq2.zze, zzq2.zzb, zzq2.zza);
            String str3 = this.zzd;
            MediationBannerAdConfiguration mediationBannerAdConfiguration = r5;
            MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzt, zzs, zzu, location, i, i2, zzv, zzc2, str3);
            rtbAdapter.loadRtbBannerAd(mediationBannerAdConfiguration, zzbxi);
        } catch (Throwable th) {
            zzcgp.zzh("Adapter failed to render banner ad.", th);
            throw new RemoteException();
        }
    }

    public final void zzj(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbwr zzbwr, zzbvq zzbvq, zzq zzq) throws RemoteException {
        zzl zzl2 = zzl;
        zzq zzq2 = zzq;
        try {
            zzbxj zzbxj = new zzbxj(this, zzbwr, zzbvq);
            RtbAdapter rtbAdapter = this.zza;
            Bundle zzt = zzt(str2);
            Bundle zzs = zzs(zzl2);
            boolean zzu = zzu(zzl);
            Location location = zzl2.zzk;
            int i = zzl2.zzg;
            int i2 = zzl2.zzt;
            String zzv = zzv(str2, zzl);
            AdSize zzc2 = com.google.android.gms.ads.zzb.zzc(zzq2.zze, zzq2.zzb, zzq2.zza);
            String str3 = this.zzd;
            MediationBannerAdConfiguration mediationBannerAdConfiguration = r5;
            MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzt, zzs, zzu, location, i, i2, zzv, zzc2, str3);
            rtbAdapter.loadRtbInterscrollerAd(mediationBannerAdConfiguration, zzbxj);
        } catch (Throwable th) {
            zzcgp.zzh("Adapter failed to render interscroller ad.", th);
            throw new RemoteException();
        }
    }
}
