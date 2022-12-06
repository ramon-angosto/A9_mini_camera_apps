package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdvl {
    private final zzfey zza;
    private final zzdvi zzb;

    zzdvl(zzfey zzfey, zzdvi zzdvi) {
        this.zza = zzfey;
        this.zzb = zzdvi;
    }

    /* access modifiers changed from: package-private */
    public final zzbvk zza() throws RemoteException {
        zzbvk zzb2 = this.zza.zzb();
        if (zzb2 != null) {
            return zzb2;
        }
        zze.zzj("Unexpected call to adapter creator.");
        throw new RemoteException();
    }

    public final zzbxd zzb(String str) throws RemoteException {
        zzbxd zzc = zza().zzc(str);
        this.zzb.zze(str, zzc);
        return zzc;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(r6) != false) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzffa zzc(java.lang.String r6, org.json.JSONObject r7) throws com.google.android.gms.internal.ads.zzfek {
        /*
            r5 = this;
            java.lang.String r0 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter"
            com.google.android.gms.internal.ads.zzffa r1 = new com.google.android.gms.internal.ads.zzffa     // Catch:{ all -> 0x0070 }
            java.lang.String r2 = "com.google.ads.mediation.admob.AdMobAdapter"
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x0070 }
            if (r2 == 0) goto L_0x0017
            com.google.android.gms.internal.ads.zzbwj r7 = new com.google.android.gms.internal.ads.zzbwj     // Catch:{ all -> 0x0070 }
            com.google.ads.mediation.admob.AdMobAdapter r0 = new com.google.ads.mediation.admob.AdMobAdapter     // Catch:{ all -> 0x0070 }
            r0.<init>()     // Catch:{ all -> 0x0070 }
            r7.<init>((com.google.android.gms.ads.mediation.MediationAdapter) r0)     // Catch:{ all -> 0x0070 }
            goto L_0x0067
        L_0x0017:
            java.lang.String r2 = "com.google.ads.mediation.admob.AdMobCustomTabsAdapter"
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x0070 }
            if (r2 == 0) goto L_0x002a
            com.google.android.gms.internal.ads.zzbwj r7 = new com.google.android.gms.internal.ads.zzbwj     // Catch:{ all -> 0x0070 }
            com.google.android.gms.internal.ads.zzbxu r0 = new com.google.android.gms.internal.ads.zzbxu     // Catch:{ all -> 0x0070 }
            r0.<init>()     // Catch:{ all -> 0x0070 }
            r7.<init>((com.google.android.gms.ads.mediation.MediationAdapter) r0)     // Catch:{ all -> 0x0070 }
            goto L_0x0067
        L_0x002a:
            com.google.android.gms.internal.ads.zzbvk r2 = r5.zza()     // Catch:{ all -> 0x0070 }
            boolean r3 = r0.equals(r6)     // Catch:{ all -> 0x0070 }
            java.lang.String r4 = "com.google.ads.mediation.customevent.CustomEventAdapter"
            if (r3 != 0) goto L_0x003c
            boolean r3 = r4.equals(r6)     // Catch:{ all -> 0x0070 }
            if (r3 == 0) goto L_0x0063
        L_0x003c:
            java.lang.String r3 = "class_name"
            java.lang.String r7 = r7.getString(r3)     // Catch:{ JSONException -> 0x005d }
            boolean r3 = r2.zze(r7)     // Catch:{ JSONException -> 0x005d }
            if (r3 == 0) goto L_0x004d
            com.google.android.gms.internal.ads.zzbvn r7 = r2.zzb(r0)     // Catch:{ JSONException -> 0x005d }
            goto L_0x0067
        L_0x004d:
            boolean r0 = r2.zzd(r7)     // Catch:{ JSONException -> 0x005d }
            if (r0 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzbvn r7 = r2.zzb(r7)     // Catch:{ JSONException -> 0x005d }
            goto L_0x0067
        L_0x0058:
            com.google.android.gms.internal.ads.zzbvn r7 = r2.zzb(r4)     // Catch:{ JSONException -> 0x005d }
            goto L_0x0067
        L_0x005d:
            r7 = move-exception
            java.lang.String r0 = "Invalid custom event."
            com.google.android.gms.ads.internal.util.zze.zzh(r0, r7)     // Catch:{ all -> 0x0070 }
        L_0x0063:
            com.google.android.gms.internal.ads.zzbvn r7 = r2.zzb(r6)     // Catch:{ all -> 0x0070 }
        L_0x0067:
            r1.<init>(r7)     // Catch:{ all -> 0x0070 }
            com.google.android.gms.internal.ads.zzdvi r7 = r5.zzb
            r7.zzd(r6, r1)
            return r1
        L_0x0070:
            r7 = move-exception
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzhZ
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0089
            com.google.android.gms.internal.ads.zzdvi r0 = r5.zzb
            r1 = 0
            r0.zzd(r6, r1)
        L_0x0089:
            com.google.android.gms.internal.ads.zzfek r6 = new com.google.android.gms.internal.ads.zzfek
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdvl.zzc(java.lang.String, org.json.JSONObject):com.google.android.gms.internal.ads.zzffa");
    }

    public final boolean zzd() {
        return this.zza.zzb() != null;
    }
}
