package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdxz {
    private final zzg zza;
    private final List zzb = new ArrayList();
    private boolean zzc = false;
    private boolean zzd = false;
    private final String zze;
    private final zzdxv zzf;

    public zzdxz(String str, zzdxv zzdxv) {
        this.zze = str;
        this.zzf = zzdxv;
        this.zza = zzt.zzo().zzh();
    }

    private final Map zzg() {
        String str;
        Map zza2 = this.zzf.zza();
        zza2.put("tms", Long.toString(zzt.zzB().elapsedRealtime(), 10));
        if (this.zza.zzP()) {
            str = "";
        } else {
            str = this.zze;
        }
        zza2.put("tid", str);
        return zza2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzbiu r3 = com.google.android.gms.internal.ads.zzbjc.zzbN     // Catch:{ all -> 0x0041 }
            com.google.android.gms.internal.ads.zzbja r0 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x0041 }
            java.lang.Object r3 = r0.zzb(r3)     // Catch:{ all -> 0x0041 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0041 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0041 }
            if (r3 == 0) goto L_0x003f
            com.google.android.gms.internal.ads.zzbiu r3 = com.google.android.gms.internal.ads.zzbjc.zzhs     // Catch:{ all -> 0x0041 }
            com.google.android.gms.internal.ads.zzbja r0 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x0041 }
            java.lang.Object r3 = r0.zzb(r3)     // Catch:{ all -> 0x0041 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0041 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0041 }
            if (r3 == 0) goto L_0x0026
            goto L_0x003f
        L_0x0026:
            java.util.Map r3 = r2.zzg()     // Catch:{ all -> 0x0041 }
            java.lang.String r0 = "action"
            java.lang.String r1 = "aaia"
            r3.put(r0, r1)     // Catch:{ all -> 0x0041 }
            java.lang.String r0 = "aair"
            java.lang.String r1 = "MalformedJson"
            r3.put(r0, r1)     // Catch:{ all -> 0x0041 }
            java.util.List r0 = r2.zzb     // Catch:{ all -> 0x0041 }
            r0.add(r3)     // Catch:{ all -> 0x0041 }
            monitor-exit(r2)
            return
        L_0x003f:
            monitor-exit(r2)
            return
        L_0x0041:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxz.zza(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzbN     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x0044 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x0044 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0044 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0042
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzhs     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x0044 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x0044 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0044 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0026
            goto L_0x0042
        L_0x0026:
            java.util.Map r0 = r3.zzg()     // Catch:{ all -> 0x0044 }
            java.lang.String r1 = "action"
            java.lang.String r2 = "adapter_init_finished"
            r0.put(r1, r2)     // Catch:{ all -> 0x0044 }
            java.lang.String r1 = "ancn"
            r0.put(r1, r4)     // Catch:{ all -> 0x0044 }
            java.lang.String r4 = "rqe"
            r0.put(r4, r5)     // Catch:{ all -> 0x0044 }
            java.util.List r4 = r3.zzb     // Catch:{ all -> 0x0044 }
            r4.add(r0)     // Catch:{ all -> 0x0044 }
            monitor-exit(r3)
            return
        L_0x0042:
            monitor-exit(r3)
            return
        L_0x0044:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxz.zzb(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzc(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzbN     // Catch:{ all -> 0x003f }
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x003f }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x003f }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x003f }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x003d
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzhs     // Catch:{ all -> 0x003f }
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x003f }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x003f }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x003f }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0026
            goto L_0x003d
        L_0x0026:
            java.util.Map r0 = r3.zzg()     // Catch:{ all -> 0x003f }
            java.lang.String r1 = "action"
            java.lang.String r2 = "adapter_init_started"
            r0.put(r1, r2)     // Catch:{ all -> 0x003f }
            java.lang.String r1 = "ancn"
            r0.put(r1, r4)     // Catch:{ all -> 0x003f }
            java.util.List r4 = r3.zzb     // Catch:{ all -> 0x003f }
            r4.add(r0)     // Catch:{ all -> 0x003f }
            monitor-exit(r3)
            return
        L_0x003d:
            monitor-exit(r3)
            return
        L_0x003f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxz.zzc(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzd(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzbN     // Catch:{ all -> 0x003f }
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x003f }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x003f }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x003f }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x003d
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzhs     // Catch:{ all -> 0x003f }
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x003f }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x003f }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x003f }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0026
            goto L_0x003d
        L_0x0026:
            java.util.Map r0 = r3.zzg()     // Catch:{ all -> 0x003f }
            java.lang.String r1 = "action"
            java.lang.String r2 = "adapter_init_finished"
            r0.put(r1, r2)     // Catch:{ all -> 0x003f }
            java.lang.String r1 = "ancn"
            r0.put(r1, r4)     // Catch:{ all -> 0x003f }
            java.util.List r4 = r3.zzb     // Catch:{ all -> 0x003f }
            r4.add(r0)     // Catch:{ all -> 0x003f }
            monitor-exit(r3)
            return
        L_0x003d:
            monitor-exit(r3)
            return
        L_0x003f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxz.zzd(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zze() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzbN     // Catch:{ all -> 0x005b }
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x005b }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x005b }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005b }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x0059
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzhs     // Catch:{ all -> 0x005b }
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x005b }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x005b }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005b }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x0026
            goto L_0x0059
        L_0x0026:
            boolean r0 = r3.zzd     // Catch:{ all -> 0x005b }
            if (r0 != 0) goto L_0x0057
            java.util.Map r0 = r3.zzg()     // Catch:{ all -> 0x005b }
            java.lang.String r1 = "action"
            java.lang.String r2 = "init_finished"
            r0.put(r1, r2)     // Catch:{ all -> 0x005b }
            java.util.List r1 = r3.zzb     // Catch:{ all -> 0x005b }
            r1.add(r0)     // Catch:{ all -> 0x005b }
            java.util.List r0 = r3.zzb     // Catch:{ all -> 0x005b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x005b }
        L_0x0040:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x005b }
            if (r1 == 0) goto L_0x0052
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x005b }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x005b }
            com.google.android.gms.internal.ads.zzdxv r2 = r3.zzf     // Catch:{ all -> 0x005b }
            r2.zze(r1)     // Catch:{ all -> 0x005b }
            goto L_0x0040
        L_0x0052:
            r0 = 1
            r3.zzd = r0     // Catch:{ all -> 0x005b }
            monitor-exit(r3)
            return
        L_0x0057:
            monitor-exit(r3)
            return
        L_0x0059:
            monitor-exit(r3)
            return
        L_0x005b:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxz.zze():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzf() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzbN     // Catch:{ all -> 0x0043 }
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x0043 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x0043 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0043 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0041
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzhs     // Catch:{ all -> 0x0043 }
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x0043 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x0043 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0043 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0026
            goto L_0x0041
        L_0x0026:
            boolean r0 = r3.zzc     // Catch:{ all -> 0x0043 }
            if (r0 != 0) goto L_0x003f
            java.util.Map r0 = r3.zzg()     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = "action"
            java.lang.String r2 = "init_started"
            r0.put(r1, r2)     // Catch:{ all -> 0x0043 }
            java.util.List r1 = r3.zzb     // Catch:{ all -> 0x0043 }
            r1.add(r0)     // Catch:{ all -> 0x0043 }
            r0 = 1
            r3.zzc = r0     // Catch:{ all -> 0x0043 }
            monitor-exit(r3)
            return
        L_0x003f:
            monitor-exit(r3)
            return
        L_0x0041:
            monitor-exit(r3)
            return
        L_0x0043:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxz.zzf():void");
    }
}
