package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgsg implements zzgti {
    private static final zzgsm zza = new zzgse();
    private final zzgsm zzb;

    public zzgsg() {
        zzgsm zzgsm;
        zzgsm[] zzgsmArr = new zzgsm[2];
        zzgsmArr[0] = zzgqz.zza();
        try {
            zzgsm = (zzgsm) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzgsm = zza;
        }
        zzgsmArr[1] = zzgsm;
        zzgsf zzgsf = new zzgsf(zzgsmArr);
        zzgro.zzf(zzgsf, "messageInfoFactory");
        this.zzb = zzgsf;
    }

    private static boolean zzb(zzgsl zzgsl) {
        return zzgsl.zzc() == 1;
    }

    public final zzgth zza(Class cls) {
        zzgtj.zzG(cls);
        zzgsl zzb2 = this.zzb.zzb(cls);
        if (zzb2.zzb()) {
            if (zzgre.class.isAssignableFrom(cls)) {
                return zzgss.zzc(zzgtj.zzB(), zzgqt.zzb(), zzb2.zza());
            }
            return zzgss.zzc(zzgtj.zzz(), zzgqt.zza(), zzb2.zza());
        } else if (zzgre.class.isAssignableFrom(cls)) {
            if (zzb(zzb2)) {
                return zzgsr.zzl(cls, zzb2, zzgsu.zzb(), zzgsc.zze(), zzgtj.zzB(), zzgqt.zzb(), zzgsk.zzb());
            }
            return zzgsr.zzl(cls, zzb2, zzgsu.zzb(), zzgsc.zze(), zzgtj.zzB(), (zzgqr) null, zzgsk.zzb());
        } else if (zzb(zzb2)) {
            return zzgsr.zzl(cls, zzb2, zzgsu.zza(), zzgsc.zzd(), zzgtj.zzz(), zzgqt.zza(), zzgsk.zza());
        } else {
            return zzgsr.zzl(cls, zzb2, zzgsu.zza(), zzgsc.zzd(), zzgtj.zzA(), (zzgqr) null, zzgsk.zza());
        }
    }
}
