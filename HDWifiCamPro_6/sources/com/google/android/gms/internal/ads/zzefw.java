package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzefw extends zzefx {
    private static final SparseArray zzb = new SparseArray();
    private final Context zzc;
    private final zzdcg zzd;
    private final TelephonyManager zze;
    /* access modifiers changed from: private */
    public final zzefo zzf;
    private int zzg;

    static {
        zzb.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzbhc.CONNECTED);
        zzb.put(NetworkInfo.DetailedState.AUTHENTICATING.ordinal(), zzbhc.CONNECTING);
        zzb.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzbhc.CONNECTING);
        zzb.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzbhc.CONNECTING);
        zzb.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzbhc.DISCONNECTING);
        zzb.put(NetworkInfo.DetailedState.BLOCKED.ordinal(), zzbhc.DISCONNECTED);
        zzb.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzbhc.DISCONNECTED);
        zzb.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzbhc.DISCONNECTED);
        zzb.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzbhc.DISCONNECTED);
        zzb.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzbhc.DISCONNECTED);
        zzb.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzbhc.SUSPENDED);
        zzb.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzbhc.CONNECTING);
        zzb.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzbhc.CONNECTING);
    }

    zzefw(Context context, zzdcg zzdcg, zzefo zzefo, zzefk zzefk, zzg zzg2) {
        super(zzefk, zzg2);
        this.zzc = context;
        this.zzd = zzdcg;
        this.zzf = zzefo;
        this.zze = (TelephonyManager) context.getSystemService("phone");
    }

    static /* bridge */ /* synthetic */ zzbgt zza(zzefw zzefw, Bundle bundle) {
        zzbgm zza = zzbgt.zza();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        int i3 = 2;
        if (i == -1) {
            zzefw.zzg = 2;
        } else {
            zzefw.zzg = 1;
            if (i == 0) {
                zza.zzb(2);
            } else if (i != 1) {
                zza.zzb(1);
            } else {
                zza.zzb(3);
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    i3 = 3;
                    break;
                case 13:
                    i3 = 5;
                    break;
                default:
                    i3 = 1;
                    break;
            }
            zza.zza(i3);
        }
        return (zzbgt) zza.zzam();
    }

    static /* bridge */ /* synthetic */ zzbhc zzb(zzefw zzefw, Bundle bundle) {
        return (zzbhc) zzb.get(zzfeq.zza(zzfeq.zza(bundle, "device"), "network").getInt("active_network_state", -1), zzbhc.UNSPECIFIED);
    }

    static /* bridge */ /* synthetic */ byte[] zze(zzefw zzefw, boolean z, ArrayList arrayList, zzbgt zzbgt, zzbhc zzbhc) {
        zzbgx zzg2 = zzbgy.zzg();
        zzg2.zza(arrayList);
        boolean z2 = false;
        zzg2.zzi(zzg(Settings.Global.getInt(zzefw.zzc.getContentResolver(), "airplane_mode_on", 0) != 0));
        zzg2.zzj(zzt.zzq().zzh(zzefw.zzc, zzefw.zze));
        zzg2.zzf(zzefw.zzf.zze());
        zzg2.zze(zzefw.zzf.zzb());
        zzg2.zzb(zzefw.zzf.zza());
        zzg2.zzc(zzbhc);
        zzg2.zzd(zzbgt);
        zzg2.zzk(zzefw.zzg);
        zzg2.zzl(zzg(z));
        zzg2.zzh(zzefw.zzf.zzd());
        zzg2.zzg(zzt.zzB().currentTimeMillis());
        if (Settings.Global.getInt(zzefw.zzc.getContentResolver(), "wifi_on", 0) != 0) {
            z2 = true;
        }
        zzg2.zzm(zzg(z2));
        return ((zzbgy) zzg2.zzam()).zzax();
    }

    private static final int zzg(boolean z) {
        return z ? 2 : 1;
    }

    public final void zzd(boolean z) {
        zzfzg.zzr(this.zzd.zzb(), new zzefv(this, z), zzchc.zzf);
    }
}
