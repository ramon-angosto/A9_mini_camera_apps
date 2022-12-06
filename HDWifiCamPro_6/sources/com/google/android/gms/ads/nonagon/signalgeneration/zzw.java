package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzbkl;
import com.google.android.gms.internal.ads.zzcfd;
import com.google.android.gms.internal.ads.zzcfk;
import com.google.android.gms.internal.ads.zzcgp;
import com.google.android.gms.internal.ads.zzfjj;
import com.google.android.gms.internal.ads.zzfju;
import com.google.android.gms.internal.ads.zzfzc;
import com.google.android.gms.internal.ads.zzfzp;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzw implements zzfzc {
    final /* synthetic */ zzfzp zza;
    final /* synthetic */ zzcfk zzb;
    final /* synthetic */ zzcfd zzc;
    final /* synthetic */ zzfjj zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ zzaa zzf;

    zzw(zzaa zzaa, zzfzp zzfzp, zzcfk zzcfk, zzcfd zzcfd, zzfjj zzfjj, long j) {
        this.zzf = zzaa;
        this.zza = zzfzp;
        this.zzb = zzcfk;
        this.zzc = zzcfd;
        this.zzd = zzfjj;
        this.zze = j;
    }

    public final void zza(Throwable th) {
        long currentTimeMillis = zzt.zzB().currentTimeMillis();
        long j = this.zze;
        String message = th.getMessage();
        zzt.zzo().zzt(th, "SignalGeneratorImpl.generateSignals");
        zzaa zzaa = this.zzf;
        zzf.zzc(zzaa.zzr, zzaa.zzj, "sgf", new Pair("sgf_reason", message), new Pair("tqgt", String.valueOf(currentTimeMillis - j)));
        zzfju zzr = zzaa.zzr(this.zza, this.zzb);
        if (((Boolean) zzbkl.zze.zze()).booleanValue() && zzr != null) {
            zzfjj zzfjj = this.zzd;
            zzfjj.zze(false);
            zzr.zza(zzfjj);
            zzr.zzg();
        }
        try {
            zzcfd zzcfd = this.zzc;
            zzcfd.zzb("Internal error. " + message);
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzam zzam = (zzam) obj;
        zzfju zzr = zzaa.zzr(this.zza, this.zzb);
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzgF)).booleanValue()) {
            try {
                this.zzc.zzb("QueryInfo generation has been disabled.");
            } catch (RemoteException e) {
                zze.zzg("QueryInfo generation has been disabled.".concat(e.toString()));
            }
            if (((Boolean) zzbkl.zze.zze()).booleanValue() && zzr != null) {
                zzfjj zzfjj = this.zzd;
                zzfjj.zze(false);
                zzr.zza(zzfjj);
                zzr.zzg();
                return;
            }
            return;
        }
        long currentTimeMillis = zzt.zzB().currentTimeMillis() - this.zze;
        if (zzam == null) {
            try {
                this.zzc.zzc((String) null, (String) null, (Bundle) null);
                zzaa zzaa = this.zzf;
                zzf.zzc(zzaa.zzr, zzaa.zzj, "sgs", new Pair("rid", "-1"));
                this.zzd.zze(true);
                if (((Boolean) zzbkl.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzg();
                }
            } catch (RemoteException e2) {
                this.zzd.zze(false);
                zzcgp.zzh("", e2);
                if (((Boolean) zzbkl.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzg();
                }
            } catch (Throwable th) {
                if (((Boolean) zzbkl.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzg();
                }
                throw th;
            }
        } else {
            try {
                String optString = new JSONObject(zzam.zzb).optString("request_id", "");
                if (TextUtils.isEmpty(optString)) {
                    zze.zzj("The request ID is empty in request JSON.");
                    this.zzc.zzb("Internal error: request ID is empty in request JSON.");
                    zzaa zzaa2 = this.zzf;
                    zzf.zzc(zzaa2.zzr, zzaa2.zzj, "sgf", new Pair("sgf_reason", "rid_missing"));
                    this.zzd.zze(false);
                    if (((Boolean) zzbkl.zze.zze()).booleanValue() && zzr != null) {
                        zzr.zza(this.zzd);
                        zzr.zzg();
                        return;
                    }
                    return;
                }
                zzaa zzaa3 = this.zzf;
                zzaa.zzG(zzaa3, optString, zzam.zzb, zzaa3.zzj);
                Bundle bundle = zzam.zzc;
                zzaa zzaa4 = this.zzf;
                if (zzaa4.zzw && bundle != null && bundle.getInt(zzaa4.zzy, -1) == -1) {
                    zzaa zzaa5 = this.zzf;
                    bundle.putInt(zzaa5.zzy, zzaa5.zzz.get());
                }
                zzaa zzaa6 = this.zzf;
                if (zzaa6.zzv && bundle != null && TextUtils.isEmpty(bundle.getString(zzaa6.zzx))) {
                    if (TextUtils.isEmpty(this.zzf.zzB)) {
                        zzaa zzaa7 = this.zzf;
                        zzs zzp = zzt.zzp();
                        zzaa zzaa8 = this.zzf;
                        zzaa7.zzB = zzp.zzc(zzaa8.zzg, zzaa8.zzA.zza);
                    }
                    zzaa zzaa9 = this.zzf;
                    bundle.putString(zzaa9.zzx, zzaa9.zzB);
                }
                this.zzc.zzc(zzam.zza, zzam.zzb, bundle);
                zzaa zzaa10 = this.zzf;
                zzf.zzc(zzaa10.zzr, zzaa10.zzj, "sgs", new Pair("tqgt", String.valueOf(currentTimeMillis)));
                this.zzd.zze(true);
                if (((Boolean) zzbkl.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzg();
                }
            } catch (JSONException e3) {
                zze.zzj("Failed to create JSON object from the request string.");
                zzcfd zzcfd = this.zzc;
                String obj2 = e3.toString();
                zzcfd.zzb("Internal error for request JSON: " + obj2);
                zzaa zzaa11 = this.zzf;
                zzf.zzc(zzaa11.zzr, zzaa11.zzj, "sgf", new Pair("sgf_reason", "request_invalid"));
                this.zzd.zze(false);
                if (((Boolean) zzbkl.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzg();
                }
            }
        }
    }
}
