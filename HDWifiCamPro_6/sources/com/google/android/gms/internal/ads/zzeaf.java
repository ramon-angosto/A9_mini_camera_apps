package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeaf {
    private final zzdzs zza;
    private final zzdvi zzb;
    private final Object zzc = new Object();
    private final List zzd;
    private boolean zze;

    zzeaf(zzdzs zzdzs, zzdvi zzdvi) {
        this.zza = zzdzs;
        this.zzb = zzdvi;
        this.zzd = new ArrayList();
    }

    /* access modifiers changed from: private */
    public final void zzd(List list) {
        String str;
        boolean z;
        synchronized (this.zzc) {
            if (!this.zze) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    zzbrq zzbrq = (zzbrq) it.next();
                    if (((Boolean) zzay.zzc().zzb(zzbjc.zzhY)).booleanValue()) {
                        zzdvh zza2 = this.zzb.zza(zzbrq.zza);
                        if (zza2 != null) {
                            zzbxq zzbxq = zza2.zzc;
                            if (zzbxq != null) {
                                str = zzbxq.toString();
                            }
                        }
                        str = "";
                    } else {
                        str = "";
                    }
                    String str2 = str;
                    if (((Boolean) zzay.zzc().zzb(zzbjc.zzhZ)).booleanValue()) {
                        zzdvh zza3 = this.zzb.zza(zzbrq.zza);
                        if (zza3 != null) {
                            if (zza3.zzd) {
                                z = true;
                                List list2 = this.zzd;
                                String str3 = zzbrq.zza;
                                list2.add(new zzeae(str3, str2, this.zzb.zzc(str3), zzbrq.zzb ? 1 : 0, zzbrq.zzd, zzbrq.zzc, z));
                            }
                        }
                    }
                    z = false;
                    List list22 = this.zzd;
                    String str32 = zzbrq.zza;
                    list22.add(new zzeae(str32, str2, this.zzb.zzc(str32), zzbrq.zzb ? 1 : 0, zzbrq.zzd, zzbrq.zzc, z));
                }
                this.zze = true;
            }
        }
    }

    public final JSONArray zza() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.zzc) {
            if (!this.zze) {
                if (this.zza.zzt()) {
                    zzd(this.zza.zzg());
                } else {
                    zzc();
                    return jSONArray;
                }
            }
            for (zzeae zza2 : this.zzd) {
                jSONArray.put(zza2.zza());
            }
            return jSONArray;
        }
    }

    public final void zzc() {
        this.zza.zzs(new zzead(this));
    }
}
