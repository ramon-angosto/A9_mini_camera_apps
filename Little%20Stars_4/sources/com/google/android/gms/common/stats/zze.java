package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

public class zze {
    private final long zzatL;
    private final int zzatM;
    private final SimpleArrayMap<String, Long> zzatN;

    public zze() {
        this.zzatL = 60000;
        this.zzatM = 10;
        this.zzatN = new SimpleArrayMap<>(10);
    }

    public zze(int i, long j) {
        this.zzatL = j;
        this.zzatM = i;
        this.zzatN = new SimpleArrayMap<>();
    }

    private void zzb(long j, long j2) {
        for (int size = this.zzatN.size() - 1; size >= 0; size--) {
            if (j2 - this.zzatN.valueAt(size).longValue() > j) {
                this.zzatN.removeAt(size);
            }
        }
    }

    public Long zzdr(String str) {
        Long put;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.zzatL;
        synchronized (this) {
            while (this.zzatN.size() >= this.zzatM) {
                zzb(j, elapsedRealtime);
                j /= 2;
                int i = this.zzatM;
                StringBuilder sb = new StringBuilder(94);
                sb.append("The max capacity ");
                sb.append(i);
                sb.append(" is not enough. Current durationThreshold is: ");
                sb.append(j);
                Log.w("ConnectionTracker", sb.toString());
            }
            put = this.zzatN.put(str, Long.valueOf(elapsedRealtime));
        }
        return put;
    }

    public boolean zzds(String str) {
        boolean z;
        synchronized (this) {
            z = this.zzatN.remove(str) != null;
        }
        return z;
    }
}
