package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbwj extends zzbvm {
    /* access modifiers changed from: private */
    public final Object zza;
    private zzbwl zzb;
    private zzccd zzc;
    private IObjectWrapper zzd;
    /* access modifiers changed from: private */
    public View zze;
    /* access modifiers changed from: private */
    public MediationInterstitialAd zzf;
    /* access modifiers changed from: private */
    public UnifiedNativeAdMapper zzg;
    /* access modifiers changed from: private */
    public MediationRewardedAd zzh;
    /* access modifiers changed from: private */
    public MediationInterscrollerAd zzi;
    private final String zzj = "";

    public zzbwj(Adapter adapter) {
        this.zza = adapter;
    }

    private final Bundle zzR(zzl zzl) {
        Bundle bundle;
        Bundle bundle2 = zzl.zzm;
        if (bundle2 == null || (bundle = bundle2.getBundle(this.zza.getClass().getName())) == null) {
            return new Bundle();
        }
        return bundle;
    }

    private final Bundle zzS(String str, zzl zzl, String str2) throws RemoteException {
        Bundle bundle;
        zzcgp.zze("Server parameters: ".concat(String.valueOf(str)));
        try {
            Bundle bundle2 = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                bundle = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle.putString(next, jSONObject.getString(next));
                }
            } else {
                bundle = bundle2;
            }
            if (this.zza instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzl != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzl.zzg);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
        } catch (Throwable th) {
            zzcgp.zzh("", th);
            throw new RemoteException();
        }
    }

    private static final boolean zzT(zzl zzl) {
        if (zzl.zzf) {
            return true;
        }
        zzaw.zzb();
        return zzcgi.zzq();
    }

    private static final String zzU(String str, zzl zzl) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return zzl.zzu;
        }
    }

    public final void zzA(zzl zzl, String str, String str2) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            zzz(this.zzd, zzl, str, new zzbwm((Adapter) obj, this.zzc));
            return;
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = this.zza.getClass().getCanonicalName();
        zzcgp.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
        throw new RemoteException();
    }

    public final void zzB(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzbvq zzbvq) throws RemoteException {
        zzl zzl2 = zzl;
        String str2 = str;
        if (this.zza instanceof Adapter) {
            zzcgp.zze("Requesting rewarded interstitial ad from adapter.");
            try {
                zzbwi zzbwi = new zzbwi(this, zzbvq);
                Bundle zzS = zzS(str2, zzl2, (String) null);
                Bundle zzR = zzR(zzl2);
                boolean zzT = zzT(zzl);
                Location location = zzl2.zzk;
                int i = zzl2.zzg;
                int i2 = zzl2.zzt;
                String zzU = zzU(str2, zzl2);
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration = r5;
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration2 = new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzS, zzR, zzT, location, i, i2, zzU, "");
                ((Adapter) this.zza).loadRewardedInterstitialAd(mediationRewardedAdConfiguration, zzbwi);
            } catch (Exception e) {
                zzcgp.zzh("", e);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zza.getClass().getCanonicalName();
            zzcgp.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
            throw new RemoteException();
        }
    }

    public final void zzC(IObjectWrapper iObjectWrapper) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        Object obj = this.zza;
        if (obj instanceof OnContextChangedListener) {
            ((OnContextChangedListener) obj).onContextChanged(context);
        }
    }

    public final void zzD() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onPause();
            } catch (Throwable th) {
                zzcgp.zzh("", th);
                throw new RemoteException();
            }
        }
    }

    public final void zzE() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onResume();
            } catch (Throwable th) {
                zzcgp.zzh("", th);
                throw new RemoteException();
            }
        }
    }

    public final void zzF(boolean z) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof OnImmersiveModeUpdatedListener) {
            try {
                ((OnImmersiveModeUpdatedListener) obj).onImmersiveModeUpdated(z);
            } catch (Throwable th) {
                zzcgp.zzh("", th);
            }
        } else {
            String canonicalName = OnImmersiveModeUpdatedListener.class.getCanonicalName();
            String canonicalName2 = this.zza.getClass().getCanonicalName();
            zzcgp.zze(canonicalName + " #009 Class mismatch: " + canonicalName2);
        }
    }

    public final void zzG() throws RemoteException {
        if (this.zza instanceof MediationInterstitialAdapter) {
            zzcgp.zze("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zza).showInterstitial();
            } catch (Throwable th) {
                zzcgp.zzh("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.zza.getClass().getCanonicalName();
            zzcgp.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
            throw new RemoteException();
        }
    }

    public final void zzH(IObjectWrapper iObjectWrapper) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof Adapter) && !(obj instanceof MediationInterstitialAdapter)) {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zza.getClass().getCanonicalName();
            zzcgp.zzj(canonicalName + " or " + canonicalName2 + " #009 Class mismatch: " + canonicalName3);
            throw new RemoteException();
        } else if (obj instanceof MediationInterstitialAdapter) {
            zzG();
        } else {
            zzcgp.zze("Show interstitial ad from adapter.");
            MediationInterstitialAd mediationInterstitialAd = this.zzf;
            if (mediationInterstitialAd != null) {
                mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            } else {
                zzcgp.zzg("Can not show null mediation interstitial ad.");
                throw new RemoteException();
            }
        }
    }

    public final void zzI(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zza instanceof Adapter) {
            zzcgp.zze("Show rewarded ad from adapter.");
            MediationRewardedAd mediationRewardedAd = this.zzh;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            } else {
                zzcgp.zzg("Can not show null mediation rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zza.getClass().getCanonicalName();
            zzcgp.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
            throw new RemoteException();
        }
    }

    public final void zzJ() throws RemoteException {
        if (this.zza instanceof Adapter) {
            MediationRewardedAd mediationRewardedAd = this.zzh;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(this.zzd));
            } else {
                zzcgp.zzg("Can not show null mediated rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zza.getClass().getCanonicalName();
            zzcgp.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
            throw new RemoteException();
        }
    }

    public final boolean zzK() {
        return false;
    }

    public final boolean zzL() throws RemoteException {
        if (this.zza instanceof Adapter) {
            return this.zzc != null;
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = this.zza.getClass().getCanonicalName();
        zzcgp.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
        throw new RemoteException();
    }

    public final zzbvv zzM() {
        return null;
    }

    public final zzbvw zzN() {
        return null;
    }

    public final Bundle zze() {
        Object obj = this.zza;
        if (obj instanceof zzcok) {
            return ((zzcok) obj).zza();
        }
        String canonicalName = zzcok.class.getCanonicalName();
        String canonicalName2 = this.zza.getClass().getCanonicalName();
        zzcgp.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
        return new Bundle();
    }

    public final Bundle zzf() {
        Object obj = this.zza;
        if (obj instanceof zzcol) {
            return ((zzcol) obj).getInterstitialAdapterInfo();
        }
        String canonicalName = zzcol.class.getCanonicalName();
        String canonicalName2 = this.zza.getClass().getCanonicalName();
        zzcgp.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
        return new Bundle();
    }

    public final Bundle zzg() {
        return new Bundle();
    }

    public final zzdk zzh() {
        Object obj = this.zza;
        if (obj instanceof zzb) {
            try {
                return ((zzb) obj).getVideoController();
            } catch (Throwable th) {
                zzcgp.zzh("", th);
            }
        }
        return null;
    }

    public final zzbmy zzi() {
        zzbwl zzbwl = this.zzb;
        if (zzbwl == null) {
            return null;
        }
        NativeCustomTemplateAd zza2 = zzbwl.zza();
        if (zza2 instanceof zzbmz) {
            return ((zzbmz) zza2).zza();
        }
        return null;
    }

    public final zzbvt zzj() {
        MediationInterscrollerAd mediationInterscrollerAd = this.zzi;
        if (mediationInterscrollerAd != null) {
            return new zzbwk(mediationInterscrollerAd);
        }
        return null;
    }

    public final zzbvz zzk() {
        UnifiedNativeAdMapper unifiedNativeAdMapper;
        UnifiedNativeAdMapper zzb2;
        Object obj = this.zza;
        if (obj instanceof MediationNativeAdapter) {
            zzbwl zzbwl = this.zzb;
            if (zzbwl == null || (zzb2 = zzbwl.zzb()) == null) {
                return null;
            }
            return new zzbwo(zzb2);
        } else if (!(obj instanceof Adapter) || (unifiedNativeAdMapper = this.zzg) == null) {
            return null;
        } else {
            return new zzbwo(unifiedNativeAdMapper);
        }
    }

    public final zzbxq zzl() {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            return null;
        }
        return zzbxq.zza(((Adapter) obj).getVersionInfo());
    }

    public final zzbxq zzm() {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            return null;
        }
        return zzbxq.zza(((Adapter) obj).getSDKVersionInfo());
    }

    public final IObjectWrapper zzn() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationBannerAdapter) {
            try {
                return ObjectWrapper.wrap(((MediationBannerAdapter) obj).getBannerView());
            } catch (Throwable th) {
                zzcgp.zzh("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            return ObjectWrapper.wrap(this.zze);
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zza.getClass().getCanonicalName();
            zzcgp.zzj(canonicalName + " or " + canonicalName2 + " #009 Class mismatch: " + canonicalName3);
            throw new RemoteException();
        }
    }

    public final void zzo() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onDestroy();
            } catch (Throwable th) {
                zzcgp.zzh("", th);
                throw new RemoteException();
            }
        }
    }

    public final void zzp(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzccd zzccd, String str2) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            this.zzd = iObjectWrapper;
            this.zzc = zzccd;
            zzccd.zzl(ObjectWrapper.wrap(obj));
            return;
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = this.zza.getClass().getCanonicalName();
        zzcgp.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
        throw new RemoteException();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzq(com.google.android.gms.dynamic.IObjectWrapper r9, com.google.android.gms.internal.ads.zzbru r10, java.util.List r11) throws android.os.RemoteException {
        /*
            r8 = this;
            java.lang.Object r0 = r8.zza
            boolean r0 = r0 instanceof com.google.android.gms.ads.mediation.Adapter
            if (r0 == 0) goto L_0x0096
            com.google.android.gms.internal.ads.zzbwe r0 = new com.google.android.gms.internal.ads.zzbwe
            r0.<init>(r8, r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Iterator r11 = r11.iterator()
        L_0x0014:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L_0x0088
            java.lang.Object r1 = r11.next()
            com.google.android.gms.internal.ads.zzbsa r1 = (com.google.android.gms.internal.ads.zzbsa) r1
            java.lang.String r2 = r1.zza
            int r3 = r2.hashCode()
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            switch(r3) {
                case -1396342996: goto L_0x0056;
                case -1052618729: goto L_0x004c;
                case -239580146: goto L_0x0042;
                case 604727084: goto L_0x0038;
                case 1911491517: goto L_0x002e;
                default: goto L_0x002d;
            }
        L_0x002d:
            goto L_0x0060
        L_0x002e:
            java.lang.String r3 = "rewarded_interstitial"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0060
            r2 = r5
            goto L_0x0061
        L_0x0038:
            java.lang.String r3 = "interstitial"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0060
            r2 = r7
            goto L_0x0061
        L_0x0042:
            java.lang.String r3 = "rewarded"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0060
            r2 = r6
            goto L_0x0061
        L_0x004c:
            java.lang.String r3 = "native"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0060
            r2 = r4
            goto L_0x0061
        L_0x0056:
            java.lang.String r3 = "banner"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0060
            r2 = 0
            goto L_0x0061
        L_0x0060:
            r2 = -1
        L_0x0061:
            if (r2 == 0) goto L_0x0079
            if (r2 == r7) goto L_0x0076
            if (r2 == r6) goto L_0x0073
            if (r2 == r5) goto L_0x0070
            if (r2 == r4) goto L_0x006d
            r2 = 0
            goto L_0x007b
        L_0x006d:
            com.google.android.gms.ads.AdFormat r2 = com.google.android.gms.ads.AdFormat.NATIVE
            goto L_0x007b
        L_0x0070:
            com.google.android.gms.ads.AdFormat r2 = com.google.android.gms.ads.AdFormat.REWARDED_INTERSTITIAL
            goto L_0x007b
        L_0x0073:
            com.google.android.gms.ads.AdFormat r2 = com.google.android.gms.ads.AdFormat.REWARDED
            goto L_0x007b
        L_0x0076:
            com.google.android.gms.ads.AdFormat r2 = com.google.android.gms.ads.AdFormat.INTERSTITIAL
            goto L_0x007b
        L_0x0079:
            com.google.android.gms.ads.AdFormat r2 = com.google.android.gms.ads.AdFormat.BANNER
        L_0x007b:
            if (r2 == 0) goto L_0x0014
            com.google.android.gms.ads.mediation.MediationConfiguration r3 = new com.google.android.gms.ads.mediation.MediationConfiguration
            android.os.Bundle r1 = r1.zzb
            r3.<init>(r2, r1)
            r10.add(r3)
            goto L_0x0014
        L_0x0088:
            java.lang.Object r11 = r8.zza
            com.google.android.gms.ads.mediation.Adapter r11 = (com.google.android.gms.ads.mediation.Adapter) r11
            java.lang.Object r9 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r9)
            android.content.Context r9 = (android.content.Context) r9
            r11.initialize(r9, r0, r10)
            return
        L_0x0096:
            android.os.RemoteException r9 = new android.os.RemoteException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbwj.zzq(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.ads.zzbru, java.util.List):void");
    }

    public final void zzr(IObjectWrapper iObjectWrapper, zzccd zzccd, List list) throws RemoteException {
        zzcgp.zzj("Could not initialize rewarded video adapter.");
        throw new RemoteException();
    }

    public final void zzs(zzl zzl, String str) throws RemoteException {
        zzA(zzl, str, (String) null);
    }

    public final void zzt(IObjectWrapper iObjectWrapper, zzq zzq, zzl zzl, String str, zzbvq zzbvq) throws RemoteException {
        zzu(iObjectWrapper, zzq, zzl, str, (String) null, zzbvq);
    }

    public final void zzu(IObjectWrapper iObjectWrapper, zzq zzq, zzl zzl, String str, String str2, zzbvq zzbvq) throws RemoteException {
        AdSize adSize;
        Date date;
        zzq zzq2 = zzq;
        zzl zzl2 = zzl;
        String str3 = str;
        String str4 = str2;
        zzbvq zzbvq2 = zzbvq;
        Object obj = this.zza;
        if ((obj instanceof MediationBannerAdapter) || (obj instanceof Adapter)) {
            zzcgp.zze("Requesting banner ad from adapter.");
            if (zzq2.zzn) {
                adSize = com.google.android.gms.ads.zzb.zzd(zzq2.zze, zzq2.zzb);
            } else {
                adSize = com.google.android.gms.ads.zzb.zzc(zzq2.zze, zzq2.zzb, zzq2.zza);
            }
            AdSize adSize2 = adSize;
            Object obj2 = this.zza;
            if (obj2 instanceof MediationBannerAdapter) {
                try {
                    MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) obj2;
                    List list = zzl2.zze;
                    HashSet hashSet = list != null ? new HashSet(list) : null;
                    long j = zzl2.zzb;
                    if (j == -1) {
                        date = null;
                    } else {
                        date = new Date(j);
                    }
                    zzbwc zzbwc = new zzbwc(date, zzl2.zzd, hashSet, zzl2.zzk, zzT(zzl), zzl2.zzg, zzl2.zzr, zzl2.zzt, zzU(str3, zzl2));
                    Bundle bundle = zzl2.zzm;
                    mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzbwl(zzbvq2), zzS(str3, zzl2, str4), adSize2, zzbwc, bundle != null ? bundle.getBundle(mediationBannerAdapter.getClass().getName()) : null);
                } catch (Throwable th) {
                    zzcgp.zzh("", th);
                    throw new RemoteException();
                }
            } else if (obj2 instanceof Adapter) {
                try {
                    zzbwf zzbwf = new zzbwf(this, zzbvq2);
                    Bundle zzS = zzS(str3, zzl2, str4);
                    Bundle zzR = zzR(zzl2);
                    boolean zzT = zzT(zzl);
                    Location location = zzl2.zzk;
                    int i = zzl2.zzg;
                    int i2 = zzl2.zzt;
                    String zzU = zzU(str3, zzl2);
                    String str5 = this.zzj;
                    MediationBannerAdConfiguration mediationBannerAdConfiguration = r2;
                    MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzS, zzR, zzT, location, i, i2, zzU, adSize2, str5);
                    ((Adapter) obj2).loadBannerAd(mediationBannerAdConfiguration, zzbwf);
                } catch (Throwable th2) {
                    zzcgp.zzh("", th2);
                    throw new RemoteException();
                }
            }
        } else {
            zzcgp.zzj(MediationBannerAdapter.class.getCanonicalName() + " or " + Adapter.class.getCanonicalName() + " #009 Class mismatch: " + this.zza.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public final void zzv(IObjectWrapper iObjectWrapper, zzq zzq, zzl zzl, String str, String str2, zzbvq zzbvq) throws RemoteException {
        zzq zzq2 = zzq;
        zzl zzl2 = zzl;
        String str3 = str;
        if (this.zza instanceof Adapter) {
            zzcgp.zze("Requesting interscroller ad from adapter.");
            try {
                Adapter adapter = (Adapter) this.zza;
                zzbwd zzbwd = new zzbwd(this, zzbvq, adapter);
                Bundle zzS = zzS(str3, zzl2, str2);
                Bundle zzR = zzR(zzl2);
                boolean zzT = zzT(zzl);
                Location location = zzl2.zzk;
                int i = zzl2.zzg;
                int i2 = zzl2.zzt;
                String zzU = zzU(str3, zzl2);
                AdSize zze2 = com.google.android.gms.ads.zzb.zze(zzq2.zze, zzq2.zzb);
                MediationBannerAdConfiguration mediationBannerAdConfiguration = r6;
                MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzS, zzR, zzT, location, i, i2, zzU, zze2, "");
                adapter.loadInterscrollerAd(mediationBannerAdConfiguration, zzbwd);
            } catch (Exception e) {
                zzcgp.zzh("", e);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zza.getClass().getCanonicalName();
            zzcgp.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
            throw new RemoteException();
        }
    }

    public final void zzw(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzbvq zzbvq) throws RemoteException {
        zzx(iObjectWrapper, zzl, str, (String) null, zzbvq);
    }

    public final void zzx(IObjectWrapper iObjectWrapper, zzl zzl, String str, String str2, zzbvq zzbvq) throws RemoteException {
        Date date;
        zzl zzl2 = zzl;
        String str3 = str;
        String str4 = str2;
        zzbvq zzbvq2 = zzbvq;
        Object obj = this.zza;
        if ((obj instanceof MediationInterstitialAdapter) || (obj instanceof Adapter)) {
            zzcgp.zze("Requesting interstitial ad from adapter.");
            Object obj2 = this.zza;
            if (obj2 instanceof MediationInterstitialAdapter) {
                try {
                    MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) obj2;
                    List list = zzl2.zze;
                    HashSet hashSet = list != null ? new HashSet(list) : null;
                    long j = zzl2.zzb;
                    if (j == -1) {
                        date = null;
                    } else {
                        date = new Date(j);
                    }
                    zzbwc zzbwc = new zzbwc(date, zzl2.zzd, hashSet, zzl2.zzk, zzT(zzl), zzl2.zzg, zzl2.zzr, zzl2.zzt, zzU(str3, zzl2));
                    Bundle bundle = zzl2.zzm;
                    mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzbwl(zzbvq2), zzS(str3, zzl2, str4), zzbwc, bundle != null ? bundle.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
                } catch (Throwable th) {
                    zzcgp.zzh("", th);
                    throw new RemoteException();
                }
            } else if (obj2 instanceof Adapter) {
                try {
                    ((Adapter) obj2).loadInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzS(str3, zzl2, str4), zzR(zzl2), zzT(zzl), zzl2.zzk, zzl2.zzg, zzl2.zzt, zzU(str3, zzl2), this.zzj), new zzbwg(this, zzbvq2));
                } catch (Throwable th2) {
                    zzcgp.zzh("", th2);
                    throw new RemoteException();
                }
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zza.getClass().getCanonicalName();
            zzcgp.zzj(canonicalName + " or " + canonicalName2 + " #009 Class mismatch: " + canonicalName3);
            throw new RemoteException();
        }
    }

    public final void zzy(IObjectWrapper iObjectWrapper, zzl zzl, String str, String str2, zzbvq zzbvq, zzbls zzbls, List list) throws RemoteException {
        Date date;
        zzl zzl2 = zzl;
        String str3 = str;
        String str4 = str2;
        zzbvq zzbvq2 = zzbvq;
        Object obj = this.zza;
        if ((obj instanceof MediationNativeAdapter) || (obj instanceof Adapter)) {
            zzcgp.zze("Requesting native ad from adapter.");
            Object obj2 = this.zza;
            if (obj2 instanceof MediationNativeAdapter) {
                try {
                    MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) obj2;
                    List list2 = zzl2.zze;
                    HashSet hashSet = list2 != null ? new HashSet(list2) : null;
                    long j = zzl2.zzb;
                    if (j == -1) {
                        date = null;
                    } else {
                        date = new Date(j);
                    }
                    zzbwn zzbwn = new zzbwn(date, zzl2.zzd, hashSet, zzl2.zzk, zzT(zzl), zzl2.zzg, zzbls, list, zzl2.zzr, zzl2.zzt, zzU(str3, zzl2));
                    Bundle bundle = zzl2.zzm;
                    Bundle bundle2 = bundle != null ? bundle.getBundle(mediationNativeAdapter.getClass().getName()) : null;
                    this.zzb = new zzbwl(zzbvq2);
                    mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.unwrap(iObjectWrapper), this.zzb, zzS(str3, zzl2, str4), zzbwn, bundle2);
                } catch (Throwable th) {
                    zzcgp.zzh("", th);
                    throw new RemoteException();
                }
            } else if (obj2 instanceof Adapter) {
                try {
                    ((Adapter) obj2).loadNativeAd(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzS(str3, zzl2, str4), zzR(zzl2), zzT(zzl), zzl2.zzk, zzl2.zzg, zzl2.zzt, zzU(str3, zzl2), this.zzj, zzbls), new zzbwh(this, zzbvq2));
                } catch (Throwable th2) {
                    zzcgp.zzh("", th2);
                    throw new RemoteException();
                }
            }
        } else {
            String canonicalName = MediationNativeAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zza.getClass().getCanonicalName();
            zzcgp.zzj(canonicalName + " or " + canonicalName2 + " #009 Class mismatch: " + canonicalName3);
            throw new RemoteException();
        }
    }

    public final void zzz(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzbvq zzbvq) throws RemoteException {
        zzl zzl2 = zzl;
        String str2 = str;
        if (this.zza instanceof Adapter) {
            zzcgp.zze("Requesting rewarded ad from adapter.");
            try {
                zzbwi zzbwi = new zzbwi(this, zzbvq);
                Bundle zzS = zzS(str2, zzl2, (String) null);
                Bundle zzR = zzR(zzl2);
                boolean zzT = zzT(zzl);
                Location location = zzl2.zzk;
                int i = zzl2.zzg;
                int i2 = zzl2.zzt;
                String zzU = zzU(str2, zzl2);
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration = r5;
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration2 = new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzS, zzR, zzT, location, i, i2, zzU, "");
                ((Adapter) this.zza).loadRewardedAd(mediationRewardedAdConfiguration, zzbwi);
            } catch (Exception e) {
                zzcgp.zzh("", e);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zza.getClass().getCanonicalName();
            zzcgp.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
            throw new RemoteException();
        }
    }

    public zzbwj(MediationAdapter mediationAdapter) {
        this.zza = mediationAdapter;
    }
}
