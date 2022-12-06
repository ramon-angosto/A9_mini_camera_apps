package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzbkn;
import com.google.android.gms.internal.ads.zzbla;
import com.google.android.gms.internal.ads.zzcgi;
import com.google.android.gms.internal.ads.zzcgp;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
abstract class zzav {
    private static final zzcc zza;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: com.google.android.gms.ads.internal.client.zzca} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.gms.ads.internal.client.zzca} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.google.android.gms.ads.internal.client.zzca} */
    /* JADX WARNING: type inference failed for: r2v5, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    static {
        /*
            r0 = 0
            java.lang.Class<com.google.android.gms.ads.internal.client.zzau> r1 = com.google.android.gms.ads.internal.client.zzau.class
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ Exception -> 0x003f }
            java.lang.String r2 = "com.google.android.gms.ads.internal.ClientApi"
            java.lang.Class r1 = r1.loadClass(r2)     // Catch:{ Exception -> 0x003f }
            r2 = 0
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x003f }
            java.lang.reflect.Constructor r1 = r1.getDeclaredConstructor(r3)     // Catch:{ Exception -> 0x003f }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x003f }
            java.lang.Object r1 = r1.newInstance(r2)     // Catch:{ Exception -> 0x003f }
            boolean r2 = r1 instanceof android.os.IBinder     // Catch:{ Exception -> 0x003f }
            if (r2 != 0) goto L_0x0024
            java.lang.String r1 = "ClientApi class is not an instance of IBinder."
            com.google.android.gms.internal.ads.zzcgp.zzj(r1)     // Catch:{ Exception -> 0x003f }
            goto L_0x0044
        L_0x0024:
            android.os.IBinder r1 = (android.os.IBinder) r1     // Catch:{ Exception -> 0x003f }
            if (r1 != 0) goto L_0x0029
            goto L_0x0044
        L_0x0029:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IClientApi"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)     // Catch:{ Exception -> 0x003f }
            boolean r3 = r2 instanceof com.google.android.gms.ads.internal.client.zzcc     // Catch:{ Exception -> 0x003f }
            if (r3 == 0) goto L_0x0038
            r1 = r2
            com.google.android.gms.ads.internal.client.zzcc r1 = (com.google.android.gms.ads.internal.client.zzcc) r1     // Catch:{ Exception -> 0x003f }
            r0 = r1
            goto L_0x0044
        L_0x0038:
            com.google.android.gms.ads.internal.client.zzca r2 = new com.google.android.gms.ads.internal.client.zzca     // Catch:{ Exception -> 0x003f }
            r2.<init>(r1)     // Catch:{ Exception -> 0x003f }
            r0 = r2
            goto L_0x0044
        L_0x003f:
            java.lang.String r1 = "Failed to instantiate ClientApi class."
            com.google.android.gms.internal.ads.zzcgp.zzj(r1)
        L_0x0044:
            zza = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzav.<clinit>():void");
    }

    zzav() {
    }

    private final Object zze() {
        zzcc zzcc = zza;
        if (zzcc != null) {
            try {
                return zzb(zzcc);
            } catch (RemoteException e) {
                zzcgp.zzk("Cannot invoke local loader using ClientApi class.", e);
                return null;
            }
        } else {
            zzcgp.zzj("ClientApi class cannot be loaded.");
            return null;
        }
    }

    private final Object zzf() {
        try {
            return zzc();
        } catch (RemoteException e) {
            zzcgp.zzk("Cannot invoke remote loader.", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zza();

    /* access modifiers changed from: protected */
    public abstract Object zzb(zzcc zzcc) throws RemoteException;

    /* access modifiers changed from: protected */
    public abstract Object zzc() throws RemoteException;

    public final Object zzd(Context context, boolean z) {
        Object obj;
        if (!z) {
            zzaw.zzb();
            if (!zzcgi.zzr(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                zzcgp.zze("Google Play Services is not available.");
                z = true;
            }
        }
        boolean z2 = false;
        boolean z3 = z | (!(DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) <= DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID)));
        zzbjc.zzc(context);
        if (((Boolean) zzbkn.zza.zze()).booleanValue()) {
            z3 = false;
        } else if (((Boolean) zzbkn.zzb.zze()).booleanValue()) {
            z3 = true;
            z2 = true;
        }
        if (z3) {
            obj = zze();
            if (obj == null && !z2) {
                obj = zzf();
            }
        } else {
            Object zzf = zzf();
            if (zzf == null) {
                if (zzaw.zze().nextInt(((Long) zzbla.zza.zze()).intValue()) == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", 1);
                    zzaw.zzb().zzm(context, zzaw.zzc().zza, "gmob-apps", bundle, true);
                }
            }
            obj = zzf == null ? zze() : zzf;
        }
        return obj == null ? zza() : obj;
    }
}
