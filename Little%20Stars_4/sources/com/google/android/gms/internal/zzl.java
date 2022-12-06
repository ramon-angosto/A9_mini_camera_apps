package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class zzl {
    private AtomicInteger zzX;
    private final Map<String, Queue<zzk<?>>> zzY;
    private final Set<zzk<?>> zzZ;
    private final PriorityBlockingQueue<zzk<?>> zzaa;
    private final PriorityBlockingQueue<zzk<?>> zzab;
    private zzg[] zzac;
    private zzc zzad;
    private List<zza> zzae;
    private final zzb zzi;
    private final zzn zzj;
    private final zzf zzy;

    public interface zza<T> {
        void zzg(zzk<T> zzk);
    }

    public zzl(zzb zzb, zzf zzf) {
        this(zzb, zzf, 4);
    }

    public zzl(zzb zzb, zzf zzf, int i) {
        this(zzb, zzf, i, new zze(new Handler(Looper.getMainLooper())));
    }

    public zzl(zzb zzb, zzf zzf, int i, zzn zzn) {
        this.zzX = new AtomicInteger();
        this.zzY = new HashMap();
        this.zzZ = new HashSet();
        this.zzaa = new PriorityBlockingQueue<>();
        this.zzab = new PriorityBlockingQueue<>();
        this.zzae = new ArrayList();
        this.zzi = zzb;
        this.zzy = zzf;
        this.zzac = new zzg[i];
        this.zzj = zzn;
    }

    public int getSequenceNumber() {
        return this.zzX.incrementAndGet();
    }

    public void start() {
        stop();
        this.zzad = new zzc(this.zzaa, this.zzab, this.zzi, this.zzj);
        this.zzad.start();
        for (int i = 0; i < this.zzac.length; i++) {
            zzg zzg = new zzg(this.zzab, this.zzy, this.zzi, this.zzj);
            this.zzac[i] = zzg;
            zzg.start();
        }
    }

    public void stop() {
        zzc zzc = this.zzad;
        if (zzc != null) {
            zzc.quit();
        }
        int i = 0;
        while (true) {
            zzg[] zzgArr = this.zzac;
            if (i < zzgArr.length) {
                if (zzgArr[i] != null) {
                    zzgArr[i].quit();
                }
                i++;
            } else {
                return;
            }
        }
    }

    public <T> zzk<T> zze(zzk<T> zzk) {
        zzk.zza(this);
        synchronized (this.zzZ) {
            this.zzZ.add(zzk);
        }
        zzk.zza(getSequenceNumber());
        zzk.zzc("add-to-queue");
        if (!zzk.zzq()) {
            this.zzab.add(zzk);
            return zzk;
        }
        synchronized (this.zzY) {
            String zzg = zzk.zzg();
            if (this.zzY.containsKey(zzg)) {
                Queue queue = this.zzY.get(zzg);
                if (queue == null) {
                    queue = new LinkedList();
                }
                queue.add(zzk);
                this.zzY.put(zzg, queue);
                if (zzs.DEBUG) {
                    zzs.zza("Request for cacheKey=%s is in flight, putting on hold.", zzg);
                }
            } else {
                this.zzY.put(zzg, (Object) null);
                this.zzaa.add(zzk);
            }
        }
        return zzk;
    }

    /* access modifiers changed from: package-private */
    public <T> void zzf(zzk<T> zzk) {
        synchronized (this.zzZ) {
            this.zzZ.remove(zzk);
        }
        synchronized (this.zzae) {
            for (zza zzg : this.zzae) {
                zzg.zzg(zzk);
            }
        }
        if (zzk.zzq()) {
            synchronized (this.zzY) {
                String zzg2 = zzk.zzg();
                Queue remove = this.zzY.remove(zzg2);
                if (remove != null) {
                    if (zzs.DEBUG) {
                        zzs.zza("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), zzg2);
                    }
                    this.zzaa.addAll(remove);
                }
            }
        }
    }
}
