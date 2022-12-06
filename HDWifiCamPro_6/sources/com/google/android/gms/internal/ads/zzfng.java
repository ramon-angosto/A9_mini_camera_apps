package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.facebook.ads.AdError;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfng implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzfoe zza;
    private final String zzb;
    private final String zzc;
    private final LinkedBlockingQueue zzd;
    private final HandlerThread zze = new HandlerThread("GassDGClient");
    private final zzfmx zzf;
    private final long zzg;
    private final int zzh;

    public zzfng(Context context, int i, int i2, String str, String str2, String str3, zzfmx zzfmx) {
        this.zzb = str;
        this.zzh = i2;
        this.zzc = str2;
        this.zzf = zzfmx;
        this.zze.start();
        this.zzg = System.currentTimeMillis();
        this.zza = new zzfoe(context, this.zze.getLooper(), this, this, 19621000);
        this.zzd = new LinkedBlockingQueue();
        this.zza.checkAvailabilityAndConnect();
    }

    static zzfoq zza() {
        return new zzfoq((byte[]) null, 1);
    }

    private final void zze(int i, long j, Exception exc) {
        this.zzf.zzc(i, System.currentTimeMillis() - j, exc);
    }

    public final void onConnected(Bundle bundle) {
        zzfoj zzd2 = zzd();
        if (zzd2 != null) {
            try {
                zzfoq zzf2 = zzd2.zzf(new zzfoo(1, this.zzh, this.zzb, this.zzc));
                zze(IronSourceConstants.errorCode_internal, this.zzg, (Exception) null);
                this.zzd.put(zzf2);
            } catch (Throwable th) {
                zzc();
                this.zze.quit();
                throw th;
            }
            zzc();
            this.zze.quit();
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zze(4012, this.zzg, (Exception) null);
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    public final void onConnectionSuspended(int i) {
        try {
            zze(4011, this.zzg, (Exception) null);
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    public final zzfoq zzb(int i) {
        zzfoq zzfoq;
        try {
            zzfoq = (zzfoq) this.zzd.poll(50000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zze(AdError.INTERSTITIAL_AD_TIMEOUT, this.zzg, e);
            zzfoq = null;
        }
        zze(3004, this.zzg, (Exception) null);
        if (zzfoq != null) {
            if (zzfoq.zzc == 7) {
                zzfmx.zzg(3);
            } else {
                zzfmx.zzg(2);
            }
        }
        return zzfoq == null ? zza() : zzfoq;
    }

    public final void zzc() {
        zzfoe zzfoe = this.zza;
        if (zzfoe == null) {
            return;
        }
        if (zzfoe.isConnected() || this.zza.isConnecting()) {
            this.zza.disconnect();
        }
    }

    /* access modifiers changed from: protected */
    public final zzfoj zzd() {
        try {
            return this.zza.zzp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}
