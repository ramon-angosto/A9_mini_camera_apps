package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.zzt;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfjl implements zzfjj {
    private final Context zza;
    /* access modifiers changed from: private */
    public long zzb = 0;
    /* access modifiers changed from: private */
    public long zzc = -1;
    /* access modifiers changed from: private */
    public boolean zzd = false;
    /* access modifiers changed from: private */
    public int zze = 0;
    /* access modifiers changed from: private */
    public String zzf = "";
    /* access modifiers changed from: private */
    public String zzg = "";
    /* access modifiers changed from: private */
    public String zzh = "";
    /* access modifiers changed from: private */
    public String zzi = "";
    private boolean zzj = false;
    private boolean zzk = false;
    /* access modifiers changed from: private */
    public final int zzl;
    /* access modifiers changed from: private */
    public int zzm = 2;
    /* access modifiers changed from: private */
    public int zzn = 2;

    zzfjl(Context context, int i) {
        this.zza = context;
        this.zzl = i;
    }

    public final synchronized zzfjl zzA(int i) {
        this.zzm = i;
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfjj zza(zze zze2) {
        zzo(zze2);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfjj zzb(zzfdv zzfdv) {
        zzp(zzfdv);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfjj zzc(String str) {
        zzq(str);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfjj zzd(String str) {
        zzr(str);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfjj zze(boolean z) {
        zzs(z);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfjj zzf() {
        zzt();
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfjj zzg() {
        zzu();
        return this;
    }

    public final synchronized boolean zzh() {
        return this.zzk;
    }

    public final boolean zzi() {
        return !TextUtils.isEmpty(this.zzh);
    }

    public final synchronized zzfjn zzj() {
        if (this.zzj) {
            return null;
        }
        this.zzj = true;
        if (!this.zzk) {
            zzt();
        }
        if (this.zzc < 0) {
            zzu();
        }
        return new zzfjn(this, (zzfjm) null);
    }

    public final /* bridge */ /* synthetic */ zzfjj zzk(int i) {
        zzA(i);
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.ads.zzfjl zzo(com.google.android.gms.ads.internal.client.zze r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            android.os.IBinder r3 = r3.zze     // Catch:{ all -> 0x0023 }
            if (r3 != 0) goto L_0x0007
            monitor-exit(r2)
            return r2
        L_0x0007:
            com.google.android.gms.internal.ads.zzdct r3 = (com.google.android.gms.internal.ads.zzdct) r3     // Catch:{ all -> 0x0023 }
            java.lang.String r0 = r3.zzk()     // Catch:{ all -> 0x0023 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0023 }
            if (r1 != 0) goto L_0x0015
            r2.zzf = r0     // Catch:{ all -> 0x0023 }
        L_0x0015:
            java.lang.String r3 = r3.zzi()     // Catch:{ all -> 0x0023 }
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x0021
            r2.zzg = r3     // Catch:{ all -> 0x0023 }
        L_0x0021:
            monitor-exit(r2)
            return r2
        L_0x0023:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfjl.zzo(com.google.android.gms.ads.internal.client.zze):com.google.android.gms.internal.ads.zzfjl");
    }

    public final synchronized zzfjl zzp(zzfdv zzfdv) {
        if (!TextUtils.isEmpty(zzfdv.zzb.zzb)) {
            this.zzf = zzfdv.zzb.zzb;
        }
        Iterator it = zzfdv.zza.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            zzfdk zzfdk = (zzfdk) it.next();
            if (!TextUtils.isEmpty(zzfdk.zzac)) {
                this.zzg = zzfdk.zzac;
                break;
            }
        }
        return this;
    }

    public final synchronized zzfjl zzq(String str) {
        this.zzh = str;
        return this;
    }

    public final synchronized zzfjl zzr(String str) {
        this.zzi = str;
        return this;
    }

    public final synchronized zzfjl zzs(boolean z) {
        this.zzd = z;
        return this;
    }

    public final synchronized zzfjl zzt() {
        this.zze = zzt.zzq().zzl(this.zza);
        Resources resources = this.zza.getResources();
        int i = 2;
        if (resources != null) {
            Configuration configuration = resources.getConfiguration();
            if (configuration != null) {
                i = configuration.orientation == 2 ? 4 : 3;
            }
        }
        this.zzn = i;
        this.zzb = zzt.zzB().elapsedRealtime();
        this.zzk = true;
        return this;
    }

    public final synchronized zzfjl zzu() {
        this.zzc = zzt.zzB().elapsedRealtime();
        return this;
    }
}
