package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.facebook.ads.AdError;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfov {
    private static final HashMap zza = new HashMap();
    private final Context zzb;
    private final zzfow zzc;
    private final zzfmx zzd;
    private final zzfms zze;
    private zzfok zzf;
    private final Object zzg = new Object();

    public zzfov(Context context, zzfow zzfow, zzfmx zzfmx, zzfms zzfms) {
        this.zzb = context;
        this.zzc = zzfow;
        this.zzd = zzfmx;
        this.zze = zzfms;
    }

    private final synchronized Class zzd(zzfol zzfol) throws zzfou {
        String zzk = zzfol.zza().zzk();
        Class cls = (Class) zza.get(zzk);
        if (cls != null) {
            return cls;
        }
        try {
            if (this.zze.zza(zzfol.zzc())) {
                File zzb2 = zzfol.zzb();
                if (!zzb2.exists()) {
                    zzb2.mkdirs();
                }
                Class loadClass = new DexClassLoader(zzfol.zzc().getAbsolutePath(), zzb2.getAbsolutePath(), (String) null, this.zzb.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                zza.put(zzk, loadClass);
                return loadClass;
            }
            throw new zzfou(2026, "VM did not pass signature verification");
        } catch (GeneralSecurityException e) {
            throw new zzfou(2026, (Throwable) e);
        } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e2) {
            throw new zzfou((int) AdError.REMOTE_ADS_SERVICE_ERROR, e2);
        }
    }

    public final zzfna zza() {
        zzfok zzfok;
        synchronized (this.zzg) {
            zzfok = this.zzf;
        }
        return zzfok;
    }

    public final zzfol zzb() {
        synchronized (this.zzg) {
            zzfok zzfok = this.zzf;
            if (zzfok == null) {
                return null;
            }
            zzfol zzf2 = zzfok.zzf();
            return zzf2;
        }
    }

    public final boolean zzc(zzfol zzfol) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Class zzd2 = zzd(zzfol);
            zzfok zzfok = new zzfok(zzd2.getDeclaredConstructor(new Class[]{Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE}).newInstance(new Object[]{this.zzb, "msa-r", zzfol.zze(), null, new Bundle(), 2}), zzfol, this.zzc, this.zzd);
            if (zzfok.zzh()) {
                int zze2 = zzfok.zze();
                if (zze2 == 0) {
                    synchronized (this.zzg) {
                        zzfok zzfok2 = this.zzf;
                        if (zzfok2 != null) {
                            try {
                                zzfok2.zzg();
                            } catch (zzfou e) {
                                this.zzd.zzc(e.zza(), -1, e);
                            }
                        }
                        this.zzf = zzfok;
                    }
                    this.zzd.zzd(PathInterpolatorCompat.MAX_NUM_POINTS, System.currentTimeMillis() - currentTimeMillis);
                    return true;
                }
                throw new zzfou(4001, "ci: " + zze2);
            }
            throw new zzfou((int) PAGSdk.INIT_LOCAL_FAIL_CODE, "init failed");
        } catch (Exception e2) {
            throw new zzfou(2004, (Throwable) e2);
        } catch (zzfou e3) {
            this.zzd.zzc(e3.zza(), System.currentTimeMillis() - currentTimeMillis, e3);
            return false;
        } catch (Exception e4) {
            this.zzd.zzc(4010, System.currentTimeMillis() - currentTimeMillis, e4);
            return false;
        }
    }
}
