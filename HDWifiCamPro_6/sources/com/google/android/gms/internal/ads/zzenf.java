package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zze;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzenf extends zzbxf {
    private final String zza;
    private final zzbxd zzb;
    private final zzchh zzc;
    private final JSONObject zzd = new JSONObject();
    private boolean zze = false;

    public zzenf(String str, zzbxd zzbxd, zzchh zzchh) {
        this.zzc = zzchh;
        this.zza = str;
        this.zzb = zzbxd;
        try {
            this.zzd.put("adapter_version", this.zzb.zzf().toString());
            this.zzd.put("sdk_version", this.zzb.zzg().toString());
            this.zzd.put("name", this.zza);
        } catch (RemoteException | NullPointerException | JSONException unused) {
        }
    }

    public static synchronized void zzb(String str, zzchh zzchh) {
        synchronized (zzenf.class) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", str);
                jSONObject.put("signal_error", "Adapter failed to instantiate");
                if (((Boolean) zzay.zzc().zzb(zzbjc.zzbt)).booleanValue()) {
                    jSONObject.put("signal_error_code", 1);
                }
                zzchh.zzd(jSONObject);
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:6|7|(1:9)|10|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzh(java.lang.String r3, int r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zze     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            org.json.JSONObject r0 = r2.zzd     // Catch:{ JSONException -> 0x0027 }
            java.lang.String r1 = "signal_error"
            r0.put(r1, r3)     // Catch:{ JSONException -> 0x0027 }
            com.google.android.gms.internal.ads.zzbiu r3 = com.google.android.gms.internal.ads.zzbjc.zzbt     // Catch:{ JSONException -> 0x0027 }
            com.google.android.gms.internal.ads.zzbja r0 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ JSONException -> 0x0027 }
            java.lang.Object r3 = r0.zzb(r3)     // Catch:{ JSONException -> 0x0027 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ JSONException -> 0x0027 }
            boolean r3 = r3.booleanValue()     // Catch:{ JSONException -> 0x0027 }
            if (r3 == 0) goto L_0x0027
            org.json.JSONObject r3 = r2.zzd     // Catch:{ JSONException -> 0x0027 }
            java.lang.String r0 = "signal_error_code"
            r3.put(r0, r4)     // Catch:{ JSONException -> 0x0027 }
        L_0x0027:
            com.google.android.gms.internal.ads.zzchh r3 = r2.zzc     // Catch:{ all -> 0x0033 }
            org.json.JSONObject r4 = r2.zzd     // Catch:{ all -> 0x0033 }
            r3.zzd(r4)     // Catch:{ all -> 0x0033 }
            r3 = 1
            r2.zze = r3     // Catch:{ all -> 0x0033 }
            monitor-exit(r2)
            return
        L_0x0033:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzenf.zzh(java.lang.String, int):void");
    }

    public final synchronized void zzc() {
        zzh("Signal collection timeout.", 3);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:6|7|(1:9)|10|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzd() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zze     // Catch:{ all -> 0x002d }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzbt     // Catch:{ JSONException -> 0x0021 }
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ JSONException -> 0x0021 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ JSONException -> 0x0021 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ JSONException -> 0x0021 }
            boolean r0 = r0.booleanValue()     // Catch:{ JSONException -> 0x0021 }
            if (r0 == 0) goto L_0x0021
            org.json.JSONObject r0 = r3.zzd     // Catch:{ JSONException -> 0x0021 }
            java.lang.String r1 = "signal_error_code"
            r2 = 0
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0021 }
        L_0x0021:
            com.google.android.gms.internal.ads.zzchh r0 = r3.zzc     // Catch:{ all -> 0x002d }
            org.json.JSONObject r1 = r3.zzd     // Catch:{ all -> 0x002d }
            r0.zzd(r1)     // Catch:{ all -> 0x002d }
            r0 = 1
            r3.zze = r0     // Catch:{ all -> 0x002d }
            monitor-exit(r3)
            return
        L_0x002d:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzenf.zzd():void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:12|13|(1:15)|16|17|18|19) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0031 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zze(java.lang.String r3) throws android.os.RemoteException {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zze     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            if (r3 != 0) goto L_0x0010
            java.lang.String r3 = "Adapter returned null signals"
            r2.zzf(r3)     // Catch:{ all -> 0x003d }
            monitor-exit(r2)
            return
        L_0x0010:
            org.json.JSONObject r0 = r2.zzd     // Catch:{ JSONException -> 0x0031 }
            java.lang.String r1 = "signals"
            r0.put(r1, r3)     // Catch:{ JSONException -> 0x0031 }
            com.google.android.gms.internal.ads.zzbiu r3 = com.google.android.gms.internal.ads.zzbjc.zzbt     // Catch:{ JSONException -> 0x0031 }
            com.google.android.gms.internal.ads.zzbja r0 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ JSONException -> 0x0031 }
            java.lang.Object r3 = r0.zzb(r3)     // Catch:{ JSONException -> 0x0031 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ JSONException -> 0x0031 }
            boolean r3 = r3.booleanValue()     // Catch:{ JSONException -> 0x0031 }
            if (r3 == 0) goto L_0x0031
            org.json.JSONObject r3 = r2.zzd     // Catch:{ JSONException -> 0x0031 }
            java.lang.String r0 = "signal_error_code"
            r1 = 0
            r3.put(r0, r1)     // Catch:{ JSONException -> 0x0031 }
        L_0x0031:
            com.google.android.gms.internal.ads.zzchh r3 = r2.zzc     // Catch:{ all -> 0x003d }
            org.json.JSONObject r0 = r2.zzd     // Catch:{ all -> 0x003d }
            r3.zzd(r0)     // Catch:{ all -> 0x003d }
            r3 = 1
            r2.zze = r3     // Catch:{ all -> 0x003d }
            monitor-exit(r2)
            return
        L_0x003d:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzenf.zze(java.lang.String):void");
    }

    public final synchronized void zzf(String str) throws RemoteException {
        zzh(str, 2);
    }

    public final synchronized void zzg(zze zze2) throws RemoteException {
        zzh(zze2.zzb, 2);
    }
}
