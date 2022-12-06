package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.common.util.zzw;
import com.google.android.gms.common.util.zzy;

public class zztx {
    private static boolean DEBUG = false;
    private static String TAG = "WakeLock";
    private static String zzbnr = "*gcore*:";
    private final Context mContext;
    private WorkSource zzaUG;
    private final String zzatO;
    private final String zzatQ;
    private final PowerManager.WakeLock zzbns;
    private final int zzbnt;
    private final String zzbnu;
    private boolean zzbnv;
    private int zzbnw;
    private int zzbnx;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zztx(Context context, int i, String str) {
        this(context, i, str, (String) null, context == null ? null : context.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public zztx(Context context, int i, String str, String str2, String str3) {
        this(context, i, str, str2, str3, (String) null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public zztx(Context context, int i, String str, String str2, String str3, String str4) {
        this.zzbnv = true;
        zzaa.zzh(str, "Wake lock name can NOT be empty");
        this.zzbnt = i;
        this.zzbnu = str2;
        this.zzatQ = str4;
        this.mContext = context.getApplicationContext();
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(zzbnr);
            String valueOf2 = String.valueOf(str);
            this.zzatO = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } else {
            this.zzatO = str;
        }
        this.zzbns = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (zzy.zzaF(this.mContext)) {
            this.zzaUG = zzy.zzn(context, zzw.zzdv(str3) ? context.getPackageName() : str3);
            zzc(this.zzaUG);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r11.zzbnx == 1) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r0 == false) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzgd(java.lang.String r12) {
        /*
            r11 = this;
            boolean r0 = r11.zzge(r12)
            java.lang.String r6 = r11.zzo(r12, r0)
            monitor-enter(r11)
            boolean r12 = r11.zzbnv     // Catch:{ all -> 0x0043 }
            r10 = 1
            if (r12 == 0) goto L_0x0017
            int r12 = r11.zzbnw     // Catch:{ all -> 0x0043 }
            int r12 = r12 - r10
            r11.zzbnw = r12     // Catch:{ all -> 0x0043 }
            if (r12 == 0) goto L_0x001f
            if (r0 != 0) goto L_0x001f
        L_0x0017:
            boolean r12 = r11.zzbnv     // Catch:{ all -> 0x0043 }
            if (r12 != 0) goto L_0x0041
            int r12 = r11.zzbnx     // Catch:{ all -> 0x0043 }
            if (r12 != r10) goto L_0x0041
        L_0x001f:
            com.google.android.gms.common.stats.zzh r1 = com.google.android.gms.common.stats.zzh.zzuS()     // Catch:{ all -> 0x0043 }
            android.content.Context r2 = r11.mContext     // Catch:{ all -> 0x0043 }
            android.os.PowerManager$WakeLock r12 = r11.zzbns     // Catch:{ all -> 0x0043 }
            java.lang.String r3 = com.google.android.gms.common.stats.zzf.zza(r12, r6)     // Catch:{ all -> 0x0043 }
            r4 = 8
            java.lang.String r5 = r11.zzatO     // Catch:{ all -> 0x0043 }
            java.lang.String r7 = r11.zzatQ     // Catch:{ all -> 0x0043 }
            int r8 = r11.zzbnt     // Catch:{ all -> 0x0043 }
            android.os.WorkSource r12 = r11.zzaUG     // Catch:{ all -> 0x0043 }
            java.util.List r9 = com.google.android.gms.common.util.zzy.zzb(r12)     // Catch:{ all -> 0x0043 }
            r1.zza(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0043 }
            int r12 = r11.zzbnx     // Catch:{ all -> 0x0043 }
            int r12 = r12 - r10
            r11.zzbnx = r12     // Catch:{ all -> 0x0043 }
        L_0x0041:
            monitor-exit(r11)     // Catch:{ all -> 0x0043 }
            return
        L_0x0043:
            r12 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x0043 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zztx.zzgd(java.lang.String):void");
    }

    private boolean zzge(String str) {
        return !TextUtils.isEmpty(str) && !str.equals(this.zzbnu);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r12.zzbnx == 0) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r0 == false) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzj(java.lang.String r13, long r14) {
        /*
            r12 = this;
            boolean r0 = r12.zzge(r13)
            java.lang.String r6 = r12.zzo(r13, r0)
            monitor-enter(r12)
            boolean r13 = r12.zzbnv     // Catch:{ all -> 0x0044 }
            if (r13 == 0) goto L_0x0017
            int r13 = r12.zzbnw     // Catch:{ all -> 0x0044 }
            int r1 = r13 + 1
            r12.zzbnw = r1     // Catch:{ all -> 0x0044 }
            if (r13 == 0) goto L_0x001f
            if (r0 != 0) goto L_0x001f
        L_0x0017:
            boolean r13 = r12.zzbnv     // Catch:{ all -> 0x0044 }
            if (r13 != 0) goto L_0x0042
            int r13 = r12.zzbnx     // Catch:{ all -> 0x0044 }
            if (r13 != 0) goto L_0x0042
        L_0x001f:
            com.google.android.gms.common.stats.zzh r1 = com.google.android.gms.common.stats.zzh.zzuS()     // Catch:{ all -> 0x0044 }
            android.content.Context r2 = r12.mContext     // Catch:{ all -> 0x0044 }
            android.os.PowerManager$WakeLock r13 = r12.zzbns     // Catch:{ all -> 0x0044 }
            java.lang.String r3 = com.google.android.gms.common.stats.zzf.zza(r13, r6)     // Catch:{ all -> 0x0044 }
            r4 = 7
            java.lang.String r5 = r12.zzatO     // Catch:{ all -> 0x0044 }
            java.lang.String r7 = r12.zzatQ     // Catch:{ all -> 0x0044 }
            int r8 = r12.zzbnt     // Catch:{ all -> 0x0044 }
            android.os.WorkSource r13 = r12.zzaUG     // Catch:{ all -> 0x0044 }
            java.util.List r9 = com.google.android.gms.common.util.zzy.zzb(r13)     // Catch:{ all -> 0x0044 }
            r10 = r14
            r1.zza(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0044 }
            int r13 = r12.zzbnx     // Catch:{ all -> 0x0044 }
            int r13 = r13 + 1
            r12.zzbnx = r13     // Catch:{ all -> 0x0044 }
        L_0x0042:
            monitor-exit(r12)     // Catch:{ all -> 0x0044 }
            return
        L_0x0044:
            r13 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x0044 }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zztx.zzj(java.lang.String, long):void");
    }

    private String zzo(String str, boolean z) {
        return (!this.zzbnv || !z) ? this.zzbnu : str;
    }

    public void acquire(long j) {
        if (!zzs.zzva() && this.zzbnv) {
            String str = TAG;
            String valueOf = String.valueOf(this.zzatO);
            Log.wtf(str, valueOf.length() != 0 ? "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: ".concat(valueOf) : new String("Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: "));
        }
        zzj((String) null, j);
        this.zzbns.acquire(j);
    }

    public boolean isHeld() {
        return this.zzbns.isHeld();
    }

    public void release() {
        zzgd((String) null);
        this.zzbns.release();
    }

    public void setReferenceCounted(boolean z) {
        this.zzbns.setReferenceCounted(z);
        this.zzbnv = z;
    }

    public void zzc(WorkSource workSource) {
        if (workSource != null && zzy.zzaF(this.mContext)) {
            WorkSource workSource2 = this.zzaUG;
            if (workSource2 != null) {
                workSource2.add(workSource);
            } else {
                this.zzaUG = workSource;
            }
            this.zzbns.setWorkSource(this.zzaUG);
        }
    }
}
