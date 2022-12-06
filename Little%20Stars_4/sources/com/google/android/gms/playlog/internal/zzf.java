package com.google.android.gms.playlog.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.playlog.internal.zza;
import com.google.android.gms.playlog.internal.zzb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zzf extends zzd<zza> {
    private final String zzZC;
    private final zzd zzblh;
    private final zzb zzbli = new zzb();
    private boolean zzblj = true;
    private final Object zzpp = new Object();

    public zzf(Context context, Looper looper, zzd zzd, String str) {
        super(context, looper, 24, zzd, zzd, str);
        this.zzZC = context.getPackageName();
        this.zzblh = (zzd) zzaa.zzz(zzd);
        this.zzblh.zza(this);
    }

    private void zzIi() {
        zzb.zzai(!this.zzblj);
        if (!this.zzbli.isEmpty()) {
            PlayLoggerContext playLoggerContext = null;
            try {
                ArrayList arrayList = new ArrayList();
                Iterator<zzb.zza> it = this.zzbli.zzIg().iterator();
                while (it.hasNext()) {
                    zzb.zza next = it.next();
                    if (!next.zzbkU.equals(playLoggerContext)) {
                        if (!arrayList.isEmpty()) {
                            ((zza) zztm()).zza(this.zzZC, playLoggerContext, (List<LogEvent>) arrayList);
                            arrayList.clear();
                        }
                        playLoggerContext = next.zzbkU;
                    }
                    arrayList.add(next.zzbkV);
                }
                if (!arrayList.isEmpty()) {
                    ((zza) zztm()).zza(this.zzZC, playLoggerContext, (List<LogEvent>) arrayList);
                }
                this.zzbli.clear();
            } catch (RemoteException unused) {
                Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
            }
        }
    }

    private void zzc(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        this.zzbli.zza(playLoggerContext, logEvent);
    }

    private void zzd(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        String str;
        try {
            zzIi();
            ((zza) zztm()).zza(this.zzZC, playLoggerContext, logEvent);
            return;
        } catch (RemoteException unused) {
            str = "Couldn't send log event.  Will try caching.";
        } catch (IllegalStateException unused2) {
            str = "Service was disconnected.  Will try caching.";
        }
        Log.e("PlayLoggerImpl", str);
        zzc(playLoggerContext, logEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zzpp
            monitor-enter(r0)
            boolean r1 = r3.isConnecting()     // Catch:{ all -> 0x001d }
            if (r1 != 0) goto L_0x001b
            boolean r1 = r3.isConnected()     // Catch:{ all -> 0x001d }
            if (r1 == 0) goto L_0x0010
            goto L_0x001b
        L_0x0010:
            com.google.android.gms.playlog.internal.zzd r1 = r3.zzblh     // Catch:{ all -> 0x001d }
            r2 = 1
            r1.zzaA(r2)     // Catch:{ all -> 0x001d }
            r3.zztj()     // Catch:{ all -> 0x001d }
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            return
        L_0x001b:
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            return
        L_0x001d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.playlog.internal.zzf.start():void");
    }

    public void stop() {
        synchronized (this.zzpp) {
            this.zzblh.zzaA(false);
            disconnect();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzaB(boolean z) {
        synchronized (this.zzpp) {
            boolean z2 = this.zzblj;
            this.zzblj = z;
            if (z2 && !this.zzblj) {
                zzIi();
            }
        }
    }

    public void zzb(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        synchronized (this.zzpp) {
            if (this.zzblj) {
                zzc(playLoggerContext, logEvent);
            } else {
                zzd(playLoggerContext, logEvent);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdR */
    public zza zzab(IBinder iBinder) {
        return zza.C0028zza.zzdQ(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzhT() {
        return "com.google.android.gms.playlog.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzhU() {
        return "com.google.android.gms.playlog.internal.IPlayLogService";
    }
}
