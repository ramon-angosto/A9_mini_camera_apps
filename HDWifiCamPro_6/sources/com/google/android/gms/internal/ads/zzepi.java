package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.client.zzay;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzepi implements zzeve {
    private final zzfzq zza;
    private final zzfzq zzb;
    private final Context zzc;
    private final zzfef zzd;
    private final View zze;

    public zzepi(zzfzq zzfzq, zzfzq zzfzq2, Context context, zzfef zzfef, ViewGroup viewGroup) {
        this.zza = zzfzq;
        this.zzb = zzfzq2;
        this.zzc = context;
        this.zzd = zzfef;
        this.zze = viewGroup;
    }

    private final List zze() {
        ArrayList arrayList = new ArrayList();
        View view = this.zze;
        while (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                break;
            }
            int indexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", indexOfChild);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return arrayList;
    }

    public final int zza() {
        return 3;
    }

    public final zzfzp zzb() {
        zzbjc.zzc(this.zzc);
        if (((Boolean) zzay.zzc().zzb(zzbjc.zziF)).booleanValue()) {
            return this.zzb.zzb(new zzepg(this));
        }
        return this.zza.zzb(new zzeph(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzepj zzc() throws Exception {
        return new zzepj(this.zzc, this.zzd.zze, zze());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzepj zzd() throws Exception {
        return new zzepj(this.zzc, this.zzd.zze, zze());
    }
}
