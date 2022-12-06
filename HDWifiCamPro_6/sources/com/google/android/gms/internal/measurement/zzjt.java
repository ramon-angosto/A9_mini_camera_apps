package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
final class zzjt {
    private static final zzjt zzb = new zzjt(true);
    final zzmh zza = new zzlx(16);
    private boolean zzc;
    private boolean zzd;

    private zzjt() {
    }

    public static zzjt zza() {
        zzjt zzjt = zzb;
        throw null;
    }

    private static final void zzd(zzjs zzjs, Object obj) {
        boolean z;
        zznb zzb2 = zzjs.zzb();
        zzkk.zze(obj);
        zznb zznb = zznb.DOUBLE;
        zznc zznc = zznc.INT;
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
                if ((obj instanceof zzjb) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzke)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzlj) || (obj instanceof zzko)) {
                    return;
                }
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzjs.zza()), zzjs.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzjt zzjt = new zzjt();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry zzg = this.zza.zzg(i);
            zzjt.zzc((zzjs) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzjt.zzc((zzjs) entry.getKey(), entry.getValue());
        }
        zzjt.zzd = this.zzd;
        return zzjt;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjt)) {
            return false;
        }
        return this.zza.equals(((zzjt) obj).zza);
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

    public final void zzc(zzjs zzjs, Object obj) {
        if (!zzjs.zzc()) {
            zzd(zzjs, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(zzjs, arrayList.get(i));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzko) {
            this.zzd = true;
        }
        this.zza.put(zzjs, obj);
    }

    private zzjt(boolean z) {
        zzb();
        zzb();
    }
}
