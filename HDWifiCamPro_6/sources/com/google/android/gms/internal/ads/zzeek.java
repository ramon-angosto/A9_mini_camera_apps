package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.zzt;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeek extends zzcat {
    private final Context zza;
    private final Executor zzb;
    private final zzfzq zzc;
    private final zzcbn zzd;
    private final zzctt zze;
    private final ArrayDeque zzf;
    private final zzfjw zzg;
    private final zzcbo zzh;
    private final zzeep zzi;

    public zzeek(Context context, Executor executor, zzfzq zzfzq, zzcbo zzcbo, zzctt zzctt, zzcbn zzcbn, ArrayDeque arrayDeque, zzeep zzeep, zzfjw zzfjw, byte[] bArr) {
        zzbjc.zzc(context);
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzfzq;
        this.zzh = zzcbo;
        this.zzd = zzcbn;
        this.zze = zzctt;
        this.zzf = arrayDeque;
        this.zzi = zzeep;
        this.zzg = zzfjw;
    }

    private final synchronized zzeeh zzl(String str) {
        Iterator it = this.zzf.iterator();
        while (it.hasNext()) {
            zzeeh zzeeh = (zzeeh) it.next();
            if (zzeeh.zzd.equals(str)) {
                it.remove();
                return zzeeh;
            }
        }
        return null;
    }

    private final synchronized zzeeh zzm(String str) {
        Iterator it = this.zzf.iterator();
        while (it.hasNext()) {
            zzeeh zzeeh = (zzeeh) it.next();
            if (zzeeh.zzc.equals(str)) {
                it.remove();
                return zzeeh;
            }
        }
        return null;
    }

    private static zzfzp zzn(zzfzp zzfzp, zzfih zzfih, zzbuk zzbuk, zzfju zzfju, zzfjj zzfjj) {
        zzbua zza2 = zzbuk.zza("AFMA_getAdDictionary", zzbuh.zza, zzeeb.zza);
        zzfjt.zzd(zzfzp, zzfjj);
        zzfhm zza3 = zzfih.zzb(zzfib.BUILD_URL, zzfzp).zzf(zza2).zza();
        zzfjt.zzc(zza3, zzfju, zzfjj);
        return zza3;
    }

    private static zzfzp zzo(zzcbc zzcbc, zzfih zzfih, zzevw zzevw) {
        zzedv zzedv = new zzedv(zzevw);
        return zzfih.zzb(zzfib.GMS_SIGNALS, zzfzg.zzi(zzcbc.zza)).zzf(zzedv).zze(zzedw.zza).zza();
    }

    private final synchronized void zzp(zzeeh zzeeh) {
        zzq();
        this.zzf.addLast(zzeeh);
    }

    private final synchronized void zzq() {
        int intValue = ((Long) zzbky.zzc.zze()).intValue();
        while (this.zzf.size() >= intValue) {
            this.zzf.removeFirst();
        }
    }

    private final void zzr(zzfzp zzfzp, zzcay zzcay) {
        zzfzg.zzr(zzfzg.zzn(zzfzp, new zzeee(this), zzchc.zza), new zzeeg(this, zzcay), zzchc.zzf);
    }

    public final zzfzp zzb(zzcbc zzcbc, int i) {
        if (!((Boolean) zzbky.zza.zze()).booleanValue()) {
            return zzfzg.zzh(new Exception("Split request is disabled."));
        }
        zzffx zzffx = zzcbc.zzi;
        if (zzffx == null) {
            return zzfzg.zzh(new Exception("Pool configuration missing from request."));
        }
        if (zzffx.zzc == 0 || zzffx.zzd == 0) {
            return zzfzg.zzh(new Exception("Caching is disabled."));
        }
        zzbuk zzb2 = zzt.zzf().zzb(this.zza, zzcgv.zza(), this.zzg);
        zzevw zzp = this.zze.zzp(zzcbc, i);
        zzfih zzc2 = zzp.zzc();
        zzfzp zzo = zzo(zzcbc, zzc2, zzp);
        zzfju zzd2 = zzp.zzd();
        zzfjj zza2 = zzfji.zza(this.zza, 9);
        zzfzp zzn = zzn(zzo, zzc2, zzb2, zzd2, zza2);
        return zzc2.zza(zzfib.GET_URL_AND_CACHE_KEY, zzo, zzn).zza(new zzeea(this, zzn, zzo, zzcbc, zza2)).zza();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzfzp zzc(com.google.android.gms.internal.ads.zzcbc r17, int r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            com.google.android.gms.internal.ads.zzbub r2 = com.google.android.gms.ads.internal.zzt.zzf()
            android.content.Context r3 = r0.zza
            com.google.android.gms.internal.ads.zzcgv r4 = com.google.android.gms.internal.ads.zzcgv.zza()
            com.google.android.gms.internal.ads.zzfjw r5 = r0.zzg
            com.google.android.gms.internal.ads.zzbuk r2 = r2.zzb(r3, r4, r5)
            com.google.android.gms.internal.ads.zzctt r3 = r0.zze
            r8 = r18
            com.google.android.gms.internal.ads.zzevw r3 = r3.zzp(r1, r8)
            com.google.android.gms.internal.ads.zzbud r4 = com.google.android.gms.internal.ads.zzeej.zza
            com.google.android.gms.internal.ads.zzbuc r5 = com.google.android.gms.internal.ads.zzbuh.zzb
            java.lang.String r6 = "google.afma.response.normalize"
            com.google.android.gms.internal.ads.zzbua r10 = r2.zza(r6, r4, r5)
            com.google.android.gms.internal.ads.zzbke r4 = com.google.android.gms.internal.ads.zzbky.zza
            java.lang.Object r4 = r4.zze()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r5 = 0
            if (r4 != 0) goto L_0x0046
            java.lang.String r4 = r1.zzj
            if (r4 == 0) goto L_0x0044
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0044
            java.lang.String r4 = "Request contained a PoolKey but split request is disabled."
            com.google.android.gms.ads.internal.util.zze.zza(r4)
        L_0x0044:
            r11 = r5
            goto L_0x0073
        L_0x0046:
            com.google.android.gms.internal.ads.zzbke r4 = com.google.android.gms.internal.ads.zzbky.zzd
            java.lang.Object r4 = r4.zze()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x005c
            java.lang.String r4 = r1.zzh
            com.google.android.gms.internal.ads.zzeeh r4 = r0.zzm(r4)
        L_0x005a:
            r5 = r4
            goto L_0x006b
        L_0x005c:
            java.lang.String r4 = r1.zzj
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x006b
            java.lang.String r4 = r1.zzj
            com.google.android.gms.internal.ads.zzeeh r4 = r0.zzl(r4)
            goto L_0x005a
        L_0x006b:
            if (r5 != 0) goto L_0x0044
            java.lang.String r4 = "Request contained a PoolKey but no matching parameters were found."
            com.google.android.gms.ads.internal.util.zze.zza(r4)
            goto L_0x0044
        L_0x0073:
            if (r11 != 0) goto L_0x007e
            android.content.Context r4 = r0.zza
            r5 = 9
            com.google.android.gms.internal.ads.zzfjj r4 = com.google.android.gms.internal.ads.zzfji.zza(r4, r5)
            goto L_0x0080
        L_0x007e:
            com.google.android.gms.internal.ads.zzfjj r4 = r11.zze
        L_0x0080:
            r12 = r4
            com.google.android.gms.internal.ads.zzfju r13 = r3.zzd()
            android.os.Bundle r4 = r1.zza
            java.lang.String r5 = "ad_types"
            java.util.ArrayList r4 = r4.getStringArrayList(r5)
            r13.zzd(r4)
            com.google.android.gms.internal.ads.zzeer r14 = new com.google.android.gms.internal.ads.zzeer
            java.lang.String r4 = r1.zzg
            r14.<init>(r4, r13, r12)
            android.content.Context r5 = r0.zza
            com.google.android.gms.internal.ads.zzcgv r4 = r1.zzb
            java.lang.String r6 = r4.zza
            com.google.android.gms.internal.ads.zzcbo r7 = r0.zzh
            com.google.android.gms.internal.ads.zzeeo r15 = new com.google.android.gms.internal.ads.zzeeo
            r9 = 0
            r4 = r15
            r8 = r18
            r4.<init>(r5, r6, r7, r8, r9)
            com.google.android.gms.internal.ads.zzfih r4 = r3.zzc()
            android.content.Context r5 = r0.zza
            r6 = 11
            com.google.android.gms.internal.ads.zzfjj r5 = com.google.android.gms.internal.ads.zzfji.zza(r5, r6)
            r6 = 10
            r7 = 1
            r8 = 0
            r9 = 2
            if (r11 != 0) goto L_0x011a
            com.google.android.gms.internal.ads.zzfzp r1 = zzo(r1, r4, r3)
            com.google.android.gms.internal.ads.zzfzp r2 = zzn(r1, r4, r2, r13, r12)
            android.content.Context r3 = r0.zza
            com.google.android.gms.internal.ads.zzfjj r3 = com.google.android.gms.internal.ads.zzfji.zza(r3, r6)
            com.google.android.gms.internal.ads.zzfib r6 = com.google.android.gms.internal.ads.zzfib.HTTP
            com.google.android.gms.internal.ads.zzfzp[] r11 = new com.google.android.gms.internal.ads.zzfzp[r9]
            r11[r8] = r2
            r11[r7] = r1
            com.google.android.gms.internal.ads.zzfhp r6 = r4.zza(r6, r11)
            com.google.android.gms.internal.ads.zzedy r11 = new com.google.android.gms.internal.ads.zzedy
            r11.<init>(r1, r2)
            com.google.android.gms.internal.ads.zzfhy r6 = r6.zza(r11)
            com.google.android.gms.internal.ads.zzfhy r6 = r6.zze(r14)
            com.google.android.gms.internal.ads.zzfjp r11 = new com.google.android.gms.internal.ads.zzfjp
            r11.<init>(r3)
            com.google.android.gms.internal.ads.zzfhy r6 = r6.zze(r11)
            com.google.android.gms.internal.ads.zzfhy r6 = r6.zze(r15)
            com.google.android.gms.internal.ads.zzfhm r6 = r6.zza()
            com.google.android.gms.internal.ads.zzfjt.zza(r6, r13, r3)
            com.google.android.gms.internal.ads.zzfjt.zzd(r6, r5)
            com.google.android.gms.internal.ads.zzfib r3 = com.google.android.gms.internal.ads.zzfib.PRE_PROCESS
            r11 = 3
            com.google.android.gms.internal.ads.zzfzp[] r11 = new com.google.android.gms.internal.ads.zzfzp[r11]
            r11[r8] = r1
            r11[r7] = r2
            r11[r9] = r6
            com.google.android.gms.internal.ads.zzfhp r3 = r4.zza(r3, r11)
            com.google.android.gms.internal.ads.zzedz r4 = new com.google.android.gms.internal.ads.zzedz
            r4.<init>(r6, r1, r2)
            com.google.android.gms.internal.ads.zzfhy r1 = r3.zza(r4)
            com.google.android.gms.internal.ads.zzfhy r1 = r1.zzf(r10)
            com.google.android.gms.internal.ads.zzfhm r1 = r1.zza()
            goto L_0x016f
        L_0x011a:
            com.google.android.gms.internal.ads.zzeeq r1 = new com.google.android.gms.internal.ads.zzeeq
            org.json.JSONObject r2 = r11.zzb
            com.google.android.gms.internal.ads.zzcbf r3 = r11.zza
            r1.<init>(r2, r3)
            android.content.Context r2 = r0.zza
            com.google.android.gms.internal.ads.zzfjj r2 = com.google.android.gms.internal.ads.zzfji.zza(r2, r6)
            com.google.android.gms.internal.ads.zzfib r3 = com.google.android.gms.internal.ads.zzfib.HTTP
            com.google.android.gms.internal.ads.zzfzp r1 = com.google.android.gms.internal.ads.zzfzg.zzi(r1)
            com.google.android.gms.internal.ads.zzfhy r1 = r4.zzb(r3, r1)
            com.google.android.gms.internal.ads.zzfhy r1 = r1.zze(r14)
            com.google.android.gms.internal.ads.zzfjp r3 = new com.google.android.gms.internal.ads.zzfjp
            r3.<init>(r2)
            com.google.android.gms.internal.ads.zzfhy r1 = r1.zze(r3)
            com.google.android.gms.internal.ads.zzfhy r1 = r1.zze(r15)
            com.google.android.gms.internal.ads.zzfhm r1 = r1.zza()
            com.google.android.gms.internal.ads.zzfjt.zza(r1, r13, r2)
            com.google.android.gms.internal.ads.zzfzp r2 = com.google.android.gms.internal.ads.zzfzg.zzi(r11)
            com.google.android.gms.internal.ads.zzfjt.zzd(r1, r5)
            com.google.android.gms.internal.ads.zzfib r3 = com.google.android.gms.internal.ads.zzfib.PRE_PROCESS
            com.google.android.gms.internal.ads.zzfzp[] r6 = new com.google.android.gms.internal.ads.zzfzp[r9]
            r6[r8] = r1
            r6[r7] = r2
            com.google.android.gms.internal.ads.zzfhp r3 = r4.zza(r3, r6)
            com.google.android.gms.internal.ads.zzeed r4 = new com.google.android.gms.internal.ads.zzeed
            r4.<init>(r1, r2)
            com.google.android.gms.internal.ads.zzfhy r1 = r3.zza(r4)
            com.google.android.gms.internal.ads.zzfhy r1 = r1.zzf(r10)
            com.google.android.gms.internal.ads.zzfhm r1 = r1.zza()
        L_0x016f:
            com.google.android.gms.internal.ads.zzfjt.zza(r1, r13, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeek.zzc(com.google.android.gms.internal.ads.zzcbc, int):com.google.android.gms.internal.ads.zzfzp");
    }

    public final zzfzp zzd(zzcbc zzcbc, int i) {
        zzbuk zzb2 = zzt.zzf().zzb(this.zza, zzcgv.zza(), this.zzg);
        if (!((Boolean) zzbld.zza.zze()).booleanValue()) {
            return zzfzg.zzh(new Exception("Signal collection disabled."));
        }
        zzevw zzp = this.zze.zzp(zzcbc, i);
        zzevh zza2 = zzp.zza();
        zzbua zza3 = zzb2.zza("google.afma.request.getSignals", zzbuh.zza, zzbuh.zzb);
        zzfjj zza4 = zzfji.zza(this.zza, 22);
        zzfhm zza5 = zzp.zzc().zzb(zzfib.GET_SIGNALS, zzfzg.zzi(zzcbc.zza)).zze(new zzfjp(zza4)).zzf(new zzeec(zza2)).zzb(zzfib.JS_SIGNALS).zzf(zza3).zza();
        zzfju zzd2 = zzp.zzd();
        zzd2.zzd(zzcbc.zza.getStringArrayList("ad_types"));
        zzfjt.zzb(zza5, zzd2, zza4);
        return zza5;
    }

    public final void zze(zzcbc zzcbc, zzcay zzcay) {
        zzr(zzb(zzcbc, Binder.getCallingUid()), zzcay);
    }

    public final void zzf(zzcbc zzcbc, zzcay zzcay) {
        zzr(zzd(zzcbc, Binder.getCallingUid()), zzcay);
    }

    public final void zzg(zzcbc zzcbc, zzcay zzcay) {
        zzfzp zzc2 = zzc(zzcbc, Binder.getCallingUid());
        zzr(zzc2, zzcay);
        if (((Boolean) zzbkq.zzj.zze()).booleanValue()) {
            zzc2.zzc(new zzedx(this), this.zzc);
        } else {
            zzc2.zzc(new zzedx(this), this.zzb);
        }
    }

    public final void zzh(String str, zzcay zzcay) {
        zzr(zzi(str), zzcay);
    }

    public final zzfzp zzi(String str) {
        zzeeh zzeeh;
        if (!((Boolean) zzbky.zza.zze()).booleanValue()) {
            return zzfzg.zzh(new Exception("Split request is disabled."));
        }
        zzeef zzeef = new zzeef(this);
        if (((Boolean) zzbky.zzd.zze()).booleanValue()) {
            zzeeh = zzm(str);
        } else {
            zzeeh = zzl(str);
        }
        if (zzeeh == null) {
            return zzfzg.zzh(new Exception("URL to be removed not found for cache key: ".concat(String.valueOf(str))));
        }
        return zzfzg.zzi(zzeef);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zzj(zzfzp zzfzp, zzfzp zzfzp2, zzcbc zzcbc, zzfjj zzfjj) throws Exception {
        String zzc2 = ((zzcbf) zzfzp.get()).zzc();
        String str = zzcbc.zzh;
        zzp(new zzeeh((zzcbf) zzfzp.get(), (JSONObject) zzfzp2.get(), str, zzc2, zzfjj));
        return new ByteArrayInputStream(zzc2.getBytes(zzfsk.zzc));
    }
}
