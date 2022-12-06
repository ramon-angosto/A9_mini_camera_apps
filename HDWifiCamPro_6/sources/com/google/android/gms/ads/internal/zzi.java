package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.internal.ads.zzaox;
import com.google.android.gms.internal.ads.zzapa;
import com.google.android.gms.internal.ads.zzapd;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzcgi;
import com.google.android.gms.internal.ads.zzcgv;
import com.google.android.gms.internal.ads.zzchc;
import com.google.android.gms.internal.ads.zzfmx;
import com.google.android.gms.internal.ads.zzfnz;
import com.google.android.gms.internal.ads.zzfot;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzi implements Runnable, zzapa {
    protected boolean zza;
    final CountDownLatch zzb = new CountDownLatch(1);
    private final List zzc = new Vector();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final boolean zzf;
    private final boolean zzg;
    private final Executor zzh;
    /* access modifiers changed from: private */
    public final zzfmx zzi;
    private Context zzj;
    private final Context zzk;
    private zzcgv zzl;
    private final zzcgv zzm;
    private final boolean zzn;
    private int zzo;

    public zzi(Context context, zzcgv zzcgv) {
        this.zzj = context;
        this.zzk = context;
        this.zzl = zzcgv;
        this.zzm = zzcgv;
        this.zzh = Executors.newCachedThreadPool();
        boolean booleanValue = ((Boolean) zzay.zzc().zzb(zzbjc.zzbV)).booleanValue();
        this.zzn = booleanValue;
        this.zzi = zzfmx.zza(context, this.zzh, booleanValue);
        this.zzf = ((Boolean) zzay.zzc().zzb(zzbjc.zzbR)).booleanValue();
        this.zzg = ((Boolean) zzay.zzc().zzb(zzbjc.zzbW)).booleanValue();
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzbU)).booleanValue()) {
            this.zzo = 2;
        } else {
            this.zzo = 1;
        }
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzcF)).booleanValue()) {
            this.zza = zzc();
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzcy)).booleanValue()) {
            zzchc.zza.execute(this);
            return;
        }
        zzaw.zzb();
        if (zzcgi.zzt()) {
            zzchc.zza.execute(this);
        } else {
            run();
        }
    }

    private final zzapa zzj() {
        if (zzi() == 2) {
            return (zzapa) this.zze.get();
        }
        return (zzapa) this.zzd.get();
    }

    private final void zzm() {
        zzapa zzj2 = zzj();
        if (!this.zzc.isEmpty() && zzj2 != null) {
            for (Object[] objArr : this.zzc) {
                int length = objArr.length;
                if (length == 1) {
                    zzj2.zzk((MotionEvent) objArr[0]);
                } else if (length == 3) {
                    zzj2.zzl(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.zzc.clear();
        }
    }

    private final void zzo(boolean z) {
        this.zzd.set(zzapd.zzt(this.zzl.zza, zzp(this.zzj), z, this.zzo));
    }

    private static final Context zzp(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final void run() {
        boolean z;
        long currentTimeMillis;
        try {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzcF)).booleanValue()) {
                this.zza = zzc();
            }
            boolean z2 = this.zzl.zzd;
            z = false;
            if (!((Boolean) zzay.zzc().zzb(zzbjc.zzaQ)).booleanValue() && z2) {
                z = true;
            }
            if (zzi() == 1) {
                zzo(z);
                if (this.zzo == 2) {
                    this.zzh.execute(new zzg(this, z));
                }
            } else {
                currentTimeMillis = System.currentTimeMillis();
                zzaox zza2 = zzaox.zza(this.zzl.zza, zzp(this.zzj), z, this.zzn);
                this.zze.set(zza2);
                if (this.zzg && !zza2.zzq()) {
                    this.zzo = 1;
                    zzo(z);
                }
            }
        } catch (NullPointerException e) {
            this.zzo = 1;
            zzo(z);
            this.zzi.zzc(2031, System.currentTimeMillis() - currentTimeMillis, e);
        } catch (Throwable th) {
            this.zzb.countDown();
            this.zzj = null;
            this.zzl = null;
            throw th;
        }
        this.zzb.countDown();
        this.zzj = null;
        this.zzl = null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzaox.zza(this.zzm.zza, zzp(this.zzk), z, this.zzn).zzo();
        } catch (NullPointerException e) {
            this.zzi.zzc(2027, System.currentTimeMillis() - currentTimeMillis, e);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzc() {
        Context context = this.zzj;
        zzfmx zzfmx = this.zzi;
        zzh zzh2 = new zzh(this);
        return new zzfot(this.zzj, zzfnz.zzb(context, zzfmx), zzh2, ((Boolean) zzay.zzc().zzb(zzbjc.zzbS)).booleanValue()).zzd(1);
    }

    public final boolean zzd() {
        try {
            this.zzb.await();
            return true;
        } catch (InterruptedException e) {
            zze.zzk("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    public final String zze(Context context, String str, View view) {
        return zzf(context, str, view, (Activity) null);
    }

    public final String zzf(Context context, String str, View view, Activity activity) {
        if (!zzd()) {
            return "";
        }
        zzapa zzj2 = zzj();
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzir)).booleanValue()) {
            zzt.zzp();
            zzs.zzF(view, 4, (MotionEvent) null);
        }
        if (zzj2 == null) {
            return "";
        }
        zzm();
        return zzj2.zzf(zzp(context), str, view, activity);
    }

    public final String zzg(Context context) {
        zzapa zzj2;
        if (!zzd() || (zzj2 = zzj()) == null) {
            return "";
        }
        zzm();
        return zzj2.zzg(zzp(context));
    }

    public final String zzh(Context context, View view, Activity activity) {
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zziq)).booleanValue()) {
            zzapa zzj2 = zzj();
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzir)).booleanValue()) {
                zzt.zzp();
                zzs.zzF(view, 2, (MotionEvent) null);
            }
            return zzj2 != null ? zzj2.zzh(context, view, activity) : "";
        } else if (!zzd()) {
            return "";
        } else {
            zzapa zzj3 = zzj();
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzir)).booleanValue()) {
                zzt.zzp();
                zzs.zzF(view, 2, (MotionEvent) null);
            }
            if (zzj3 != null) {
                return zzj3.zzh(context, view, activity);
            }
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public final int zzi() {
        if (!this.zzf || this.zza) {
            return this.zzo;
        }
        return 1;
    }

    public final void zzk(MotionEvent motionEvent) {
        zzapa zzj2 = zzj();
        if (zzj2 != null) {
            zzm();
            zzj2.zzk(motionEvent);
            return;
        }
        this.zzc.add(new Object[]{motionEvent});
    }

    public final void zzl(int i, int i2, int i3) {
        zzapa zzj2 = zzj();
        if (zzj2 != null) {
            zzm();
            zzj2.zzl(i, i2, i3);
            return;
        }
        this.zzc.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final void zzn(View view) {
        zzapa zzj2 = zzj();
        if (zzj2 != null) {
            zzj2.zzn(view);
        }
    }
}
