package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.gms.ads.internal.client.zzay;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaqs extends zzarq {
    private static final zzarr zzi = new zzarr();
    private final Context zzj;

    public zzaqs(zzaqe zzaqe, String str, String str2, zzamk zzamk, int i, int i2, Context context, zzamd zzamd) {
        super(zzaqe, "hhtrMjcGMTQSGdrv1+l2gakNTe0Pfchc8VT5kRHtsehlafuJ8JEE4iewNV4y5I/U", "o5W1eROpLyVNcsDGW3Y0lGc2x/V+mDPvMXouv3gbW6M=", zzamk, i, 27);
        this.zzj = context;
    }

    private final String zzc() {
        try {
            if (this.zzb.zzl() != null) {
                this.zzb.zzl().get();
            }
            zzana zzc = this.zzb.zzc();
            if (zzc == null || !zzc.zzaj()) {
                return null;
            }
            return zzc.zzh();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzanq zzanq;
        int i;
        Boolean bool;
        AtomicReference zza = zzi.zza(this.zzj.getPackageName());
        synchronized (zza) {
            zzanq zzanq2 = (zzanq) zza.get();
            if (zzanq2 == null || zzaqh.zzg(zzanq2.zza) || zzanq2.zza.equals("E") || zzanq2.zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                if (!zzaqh.zzg((String) null)) {
                    i = 5;
                } else {
                    if (!zzaqh.zzg((String) null)) {
                        bool = false;
                    } else {
                        bool = false;
                    }
                    i = (!bool.booleanValue() || !this.zzb.zzp()) ? 3 : 4;
                }
                Boolean valueOf = Boolean.valueOf(i == 3);
                Boolean bool2 = (Boolean) zzay.zzc().zzb(zzbjc.zzbY);
                String zzb = ((Boolean) zzay.zzc().zzb(zzbjc.zzbX)).booleanValue() ? zzb() : null;
                if (bool2.booleanValue() && this.zzb.zzp() && zzaqh.zzg(zzb)) {
                    zzb = zzc();
                }
                zzanq zzanq3 = new zzanq((String) this.zzf.invoke((Object) null, new Object[]{this.zzj, valueOf, zzb}));
                if (zzaqh.zzg(zzanq3.zza) || zzanq3.zza.equals("E")) {
                    int i2 = i - 1;
                    if (i2 == 3) {
                        String zzc = zzc();
                        if (!zzaqh.zzg(zzc)) {
                            zzanq3.zza = zzc;
                        }
                    } else if (i2 == 4) {
                        throw null;
                    }
                }
                zza.set(zzanq3);
            }
            zzanq = (zzanq) zza.get();
        }
        synchronized (this.zze) {
            if (zzanq != null) {
                this.zze.zzx(zzanq.zza);
                this.zze.zzX(zzanq.zzb);
                this.zze.zzZ(zzanq.zzc);
                this.zze.zzi(zzanq.zzd);
                this.zze.zzw(zzanq.zze);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final String zzb() {
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            byte[] zzi2 = zzaqh.zzi((String) zzay.zzc().zzb(zzbjc.zzbZ));
            ArrayList arrayList = new ArrayList();
            arrayList.add(instance.generateCertificate(new ByteArrayInputStream(zzi2)));
            if (!Build.TYPE.equals("user")) {
                arrayList.add(instance.generateCertificate(new ByteArrayInputStream(zzaqh.zzi((String) zzay.zzc().zzb(zzbjc.zzca)))));
            }
            Context context = this.zzj;
            String packageName = context.getPackageName();
            this.zzb.zzk();
            if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals("S")) {
                return null;
            }
            zzfzy zzf = zzfzy.zzf();
            context.getPackageManager().requestChecksums(packageName, false, 8, arrayList, new zzars(zzf));
            return (String) zzf.get();
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }
}
