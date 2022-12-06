package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzci;
import com.google.android.gms.ads.internal.client.zzcj;
import com.google.android.gms.ads.internal.client.zzeh;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfey {
    private static zzfey zza;
    private final Context zzb;
    private final zzcj zzc;
    private final AtomicReference zzd = new AtomicReference();

    zzfey(Context context, zzcj zzcj) {
        this.zzb = context;
        this.zzc = zzcj;
    }

    static zzcj zza(Context context) {
        try {
            return zzci.asInterface((IBinder) context.getClassLoader().loadClass("com.google.android.gms.ads.internal.client.LiteSdkInfo").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context}));
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            zze.zzh("Failed to retrieve lite SDK info.", e);
            return null;
        }
    }

    public static zzfey zzd(Context context) {
        synchronized (zzfey.class) {
            zzfey zzfey = zza;
            if (zzfey != null) {
                return zzfey;
            }
            Context applicationContext = context.getApplicationContext();
            long longValue = ((Long) zzbku.zzb.zze()).longValue();
            zzcj zzcj = null;
            if (longValue > 0 && longValue <= 223104600) {
                zzcj = zza(applicationContext);
            }
            zza = new zzfey(applicationContext, zzcj);
            zzfey zzfey2 = zza;
            return zzfey2;
        }
    }

    public final zzbvk zzb() {
        return (zzbvk) this.zzd.get();
    }

    public final zzcgv zzc(int i, boolean z, int i2) {
        zzt.zzp();
        boolean zzA = zzs.zzA(this.zzb);
        zzcgv zzcgv = new zzcgv(223104000, i2, true, zzA);
        if (!((Boolean) zzbku.zzc.zze()).booleanValue()) {
            return zzcgv;
        }
        zzcj zzcj = this.zzc;
        zzeh zzeh = null;
        if (zzcj != null) {
            try {
                zzeh = zzcj.getLiteSdkVersion();
            } catch (RemoteException unused) {
            }
        }
        if (zzeh == null) {
            return zzcgv;
        }
        return new zzcgv(223104000, zzeh.zza(), true, zzA);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(com.google.android.gms.internal.ads.zzbvk r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzbke r0 = com.google.android.gms.internal.ads.zzbku.zza
            java.lang.Object r0 = r0.zze()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L_0x0023
            com.google.android.gms.ads.internal.client.zzcj r0 = r3.zzc
            if (r0 != 0) goto L_0x0015
        L_0x0013:
            r0 = r1
            goto L_0x0019
        L_0x0015:
            com.google.android.gms.internal.ads.zzbvk r0 = r0.getAdapterCreator()     // Catch:{ RemoteException -> 0x0013 }
        L_0x0019:
            java.util.concurrent.atomic.AtomicReference r2 = r3.zzd
            if (r0 != 0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            r4 = r0
        L_0x001f:
            com.google.android.gms.internal.ads.zzfex.zza(r2, r1, r4)
            return
        L_0x0023:
            java.util.concurrent.atomic.AtomicReference r0 = r3.zzd
            com.google.android.gms.internal.ads.zzfex.zza(r0, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfey.zze(com.google.android.gms.internal.ads.zzbvk):void");
    }
}
