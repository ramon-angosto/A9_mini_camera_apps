package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
final class zzlb implements zzlv {
    private static final zzlh zza = new zzkz();
    private final zzlh zzb;

    public zzlb() {
        zzlh zzlh;
        zzlh[] zzlhArr = new zzlh[2];
        zzlhArr[0] = zzjx.zza();
        try {
            zzlh = (zzlh) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzlh = zza;
        }
        zzlhArr[1] = zzlh;
        zzla zzla = new zzla(zzlhArr);
        zzkk.zzf(zzla, "messageInfoFactory");
        this.zzb = zzla;
    }

    private static boolean zzb(zzlg zzlg) {
        return zzlg.zzc() == 1;
    }

    public final zzlu zza(Class cls) {
        zzlw.zzG(cls);
        zzlg zzb2 = this.zzb.zzb(cls);
        if (zzb2.zzb()) {
            if (zzkc.class.isAssignableFrom(cls)) {
                return zzln.zzc(zzlw.zzB(), zzjr.zzb(), zzb2.zza());
            }
            return zzln.zzc(zzlw.zzz(), zzjr.zza(), zzb2.zza());
        } else if (zzkc.class.isAssignableFrom(cls)) {
            if (zzb(zzb2)) {
                return zzlm.zzl(cls, zzb2, zzlp.zzb(), zzkx.zzd(), zzlw.zzB(), zzjr.zzb(), zzlf.zzb());
            }
            return zzlm.zzl(cls, zzb2, zzlp.zzb(), zzkx.zzd(), zzlw.zzB(), (zzjp) null, zzlf.zzb());
        } else if (zzb(zzb2)) {
            return zzlm.zzl(cls, zzb2, zzlp.zza(), zzkx.zzc(), zzlw.zzz(), zzjr.zza(), zzlf.zza());
        } else {
            return zzlm.zzl(cls, zzb2, zzlp.zza(), zzkx.zzc(), zzlw.zzA(), (zzjp) null, zzlf.zza());
        }
    }
}
