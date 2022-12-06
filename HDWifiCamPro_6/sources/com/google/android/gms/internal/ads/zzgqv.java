package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgqv {
    private static final zzgqv zzb = new zzgqv(true);
    final zzgtu zza = new zzgtk(16);
    private boolean zzc;
    private boolean zzd;

    private zzgqv() {
    }

    public static zzgqv zza() {
        zzgqv zzgqv = zzb;
        throw null;
    }

    private static final void zzd(zzgqu zzgqu, Object obj) {
        boolean z;
        zzguo zzb2 = zzgqu.zzb();
        zzgro.zze(obj);
        zzguo zzguo = zzguo.DOUBLE;
        zzgup zzgup = zzgup.INT;
        switch (zzb2.zza().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                break;
            case 1:
                z = obj instanceof Long;
                break;
            case 2:
                z = obj instanceof Float;
                break;
            case 3:
                z = obj instanceof Double;
                break;
            case 4:
                z = obj instanceof Boolean;
                break;
            case 5:
                z = obj instanceof String;
                break;
            case 6:
                if ((obj instanceof zzgpw) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzgrg)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzgso) || (obj instanceof zzgrt)) {
                    return;
                }
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzgqu.zza()), zzgqu.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzgqv zzgqv = new zzgqv();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry zzg = this.zza.zzg(i);
            zzgqv.zzc((zzgqu) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzgqv.zzc((zzgqu) entry.getKey(), entry.getValue());
        }
        zzgqv.zzd = this.zzd;
        return zzgqv;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgqv)) {
            return false;
        }
        return this.zza.equals(((zzgqv) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzc) {
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzc(zzgqu zzgqu, Object obj) {
        if (!zzgqu.zzc()) {
            zzd(zzgqu, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(zzgqu, arrayList.get(i));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzgrt) {
            this.zzd = true;
        }
        this.zza.put(zzgqu, obj);
    }

    private zzgqv(boolean z) {
        zzb();
        zzb();
    }
}
