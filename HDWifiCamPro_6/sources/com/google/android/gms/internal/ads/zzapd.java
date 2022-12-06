package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzapd extends zzapc {
    protected zzapd(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static zzapd zzs(String str, Context context, boolean z) {
        zzq(context, false);
        return new zzapd(context, str, false);
    }

    @Deprecated
    public static zzapd zzt(String str, Context context, boolean z, int i) {
        zzq(context, z);
        return new zzapd(context, str, z);
    }

    /* access modifiers changed from: protected */
    public final List zzo(zzaqe zzaqe, Context context, zzamk zzamk, zzamd zzamd) {
        if (zzaqe.zzk() == null || !this.zzt) {
            return super.zzo(zzaqe, context, zzamk, (zzamd) null);
        }
        int zza = zzaqe.zza();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zzo(zzaqe, context, zzamk, (zzamd) null));
        arrayList.add(new zzaqw(zzaqe, "ysEnh8zkgcN8WwINs5FP7vGybZW2TtVSX36HO6emvdUrcCkVbC9hrF5Pe5ZSZx3i", "3LpdW89cIASEFv5WvS5ZDEWsiVGQitP33SL3WZgJ6zE=", zzamk, zza, 24));
        return arrayList;
    }
}
