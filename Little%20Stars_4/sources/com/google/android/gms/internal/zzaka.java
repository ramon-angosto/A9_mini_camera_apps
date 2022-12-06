package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzaka {
    private final List<zzaks> zzbVZ = new ArrayList();
    private zzala zzbWj = zzala.zzbWT;
    private zzakp zzbWk = zzakp.DEFAULT;
    private zzajy zzbWl = zzajx.IDENTITY;
    private final Map<Type, zzakb<?>> zzbWm = new HashMap();
    private final List<zzaks> zzbWn = new ArrayList();
    private int zzbWo = 2;
    private int zzbWp = 2;
    private boolean zzbWq = true;

    private void zza(String str, int i, int i2, List<zzaks> list) {
        zzaju zzaju;
        if (str != null && !"".equals(str.trim())) {
            zzaju = new zzaju(str);
        } else if (i != 2 && i2 != 2) {
            zzaju = new zzaju(i, i2);
        } else {
            return;
        }
        list.add(zzakq.zza((zzalv<?>) zzalv.zzr(Date.class), (Object) zzaju));
        list.add(zzakq.zza((zzalv<?>) zzalv.zzr(Timestamp.class), (Object) zzaju));
        list.add(zzakq.zza((zzalv<?>) zzalv.zzr(java.sql.Date.class), (Object) zzaju));
    }

    public zzaka zzVx() {
        this.zzbWq = false;
        return this;
    }

    public zzajz zzVy() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.zzbVZ);
        Collections.reverse(arrayList);
        arrayList.addAll(this.zzbWn);
        zza((String) null, this.zzbWo, this.zzbWp, arrayList);
        return new zzajz(this.zzbWj, this.zzbWl, this.zzbWm, false, false, false, this.zzbWq, false, false, this.zzbWk, arrayList);
    }

    public zzaka zza(Type type, Object obj) {
        boolean z = obj instanceof zzakn;
        zzakx.zzaj(z || (obj instanceof zzake) || (obj instanceof zzakb) || (obj instanceof zzakr));
        if (obj instanceof zzakb) {
            this.zzbWm.put(type, (zzakb) obj);
        }
        if (z || (obj instanceof zzake)) {
            this.zzbVZ.add(zzakq.zzb(zzalv.zzl(type), obj));
        }
        if (obj instanceof zzakr) {
            this.zzbVZ.add(zzalu.zza(zzalv.zzl(type), (zzakr) obj));
        }
        return this;
    }

    public zzaka zza(zzajv... zzajvArr) {
        for (zzajv zza : zzajvArr) {
            this.zzbWj = this.zzbWj.zza(zza, true, true);
        }
        return this;
    }

    public zzaka zzc(int... iArr) {
        this.zzbWj = this.zzbWj.zzd(iArr);
        return this;
    }
}
