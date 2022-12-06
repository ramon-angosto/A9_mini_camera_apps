package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
final class zzjx implements zzlh {
    private static final zzjx zza = new zzjx();

    private zzjx() {
    }

    public static zzjx zza() {
        return zza;
    }

    public final zzlg zzb(Class cls) {
        if (zzkc.class.isAssignableFrom(cls)) {
            try {
                return (zzlg) zzkc.zzbC(cls.asSubclass(zzkc.class)).zzl(3, (Object) null, (Object) null);
            } catch (Exception e) {
                throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
    }

    public final boolean zzc(Class cls) {
        return zzkc.class.isAssignableFrom(cls);
    }
}
