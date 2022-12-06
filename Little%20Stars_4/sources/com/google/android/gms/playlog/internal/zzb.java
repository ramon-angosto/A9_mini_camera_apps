package com.google.android.gms.playlog.internal;

import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzamo;
import java.util.ArrayList;

public class zzb {
    private final ArrayList<zza> zzbkS;
    private int zzbkT;

    public static class zza {
        public final PlayLoggerContext zzbkU;
        public final LogEvent zzbkV;
        public final zzamo.zzd zzbkW;

        private zza(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
            this.zzbkU = (PlayLoggerContext) zzaa.zzz(playLoggerContext);
            this.zzbkV = (LogEvent) zzaa.zzz(logEvent);
            this.zzbkW = null;
        }
    }

    public zzb() {
        this(100);
    }

    public zzb(int i) {
        this.zzbkS = new ArrayList<>();
        this.zzbkT = i;
    }

    private void zzIh() {
        while (getSize() > getCapacity()) {
            this.zzbkS.remove(0);
        }
    }

    public void clear() {
        this.zzbkS.clear();
    }

    public int getCapacity() {
        return this.zzbkT;
    }

    public int getSize() {
        return this.zzbkS.size();
    }

    public boolean isEmpty() {
        return this.zzbkS.isEmpty();
    }

    public ArrayList<zza> zzIg() {
        return this.zzbkS;
    }

    public void zza(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        this.zzbkS.add(new zza(playLoggerContext, logEvent));
        zzIh();
    }
}
