package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbax extends Surface {
    private static boolean zza;
    private static boolean zzb;
    private final zzbav zzc;
    private boolean zzd;

    /* synthetic */ zzbax(zzbav zzbav, SurfaceTexture surfaceTexture, boolean z, zzbaw zzbaw) {
        super(surfaceTexture);
        this.zzc = zzbav;
    }

    public static zzbax zza(Context context, boolean z) {
        if (zzbar.zza >= 17) {
            boolean z2 = true;
            if (z && !zzb(context)) {
                z2 = false;
            }
            zzbac.zze(z2);
            return new zzbav().zza(z);
        }
        throw new UnsupportedOperationException("Unsupported prior to API level 17");
    }

    public static synchronized boolean zzb(Context context) {
        boolean z;
        synchronized (zzbax.class) {
            if (!zzb) {
                if (zzbar.zza >= 17) {
                    boolean z2 = false;
                    String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                    if (eglQueryString != null && eglQueryString.contains("EGL_EXT_protected_content")) {
                        if (zzbar.zza != 24 || ((!zzbar.zzd.startsWith("SM-G950") && !zzbar.zzd.startsWith("SM-G955")) || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance"))) {
                            z2 = true;
                        }
                    }
                    zza = z2;
                }
                zzb = true;
            }
            z = zza;
        }
        return z;
    }

    public final void release() {
        super.release();
        synchronized (this.zzc) {
            if (!this.zzd) {
                this.zzc.zzb();
                this.zzd = true;
            }
        }
    }
}
