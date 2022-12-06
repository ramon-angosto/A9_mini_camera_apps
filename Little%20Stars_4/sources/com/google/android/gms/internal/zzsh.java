package com.google.android.gms.internal;

public final class zzsh {
    private static zzsh zzaIH;
    private final zzse zzaII = new zzse();
    private final zzsf zzaIJ = new zzsf();

    static {
        zza(new zzsh());
    }

    private zzsh() {
    }

    protected static void zza(zzsh zzsh) {
        synchronized (zzsh.class) {
            zzaIH = zzsh;
        }
    }

    private static zzsh zzyD() {
        zzsh zzsh;
        synchronized (zzsh.class) {
            zzsh = zzaIH;
        }
        return zzsh;
    }

    public static zzse zzyE() {
        return zzyD().zzaII;
    }

    public static zzsf zzyF() {
        return zzyD().zzaIJ;
    }
}
