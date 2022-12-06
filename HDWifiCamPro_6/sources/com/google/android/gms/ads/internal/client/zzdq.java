package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzcgp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzdq {
    /* access modifiers changed from: private */
    public final HashSet zza = new HashSet();
    /* access modifiers changed from: private */
    public final Bundle zzb = new Bundle();
    /* access modifiers changed from: private */
    public final HashMap zzc = new HashMap();
    /* access modifiers changed from: private */
    public final HashSet zzd = new HashSet();
    /* access modifiers changed from: private */
    public final Bundle zze = new Bundle();
    /* access modifiers changed from: private */
    public final HashSet zzf = new HashSet();
    /* access modifiers changed from: private */
    public Date zzg;
    /* access modifiers changed from: private */
    public String zzh;
    /* access modifiers changed from: private */
    public final List zzi = new ArrayList();
    /* access modifiers changed from: private */
    public int zzj = -1;
    /* access modifiers changed from: private */
    public String zzk;
    /* access modifiers changed from: private */
    public String zzl;
    /* access modifiers changed from: private */
    public int zzm = -1;
    /* access modifiers changed from: private */
    public boolean zzn;
    /* access modifiers changed from: private */
    public AdInfo zzo;
    /* access modifiers changed from: private */
    public String zzp;
    /* access modifiers changed from: private */
    public int zzq = 60000;

    @Deprecated
    public final void zzA(Date date) {
        this.zzg = date;
    }

    public final void zzB(String str) {
        this.zzh = str;
    }

    @Deprecated
    public final void zzC(int i) {
        this.zzj = i;
    }

    public final void zzD(int i) {
        this.zzq = i;
    }

    @Deprecated
    public final void zzE(boolean z) {
        this.zzn = z;
    }

    public final void zzF(List list) {
        this.zzi.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (TextUtils.isEmpty(str)) {
                zzcgp.zzj("neighboring content URL should not be null or empty");
            } else {
                this.zzi.add(str);
            }
        }
    }

    public final void zzG(String str) {
        this.zzk = str;
    }

    public final void zzH(String str) {
        this.zzl = str;
    }

    @Deprecated
    public final void zzI(boolean z) {
        this.zzm = z ? 1 : 0;
    }

    public final void zzq(String str) {
        this.zzf.add(str);
    }

    public final void zzr(Class cls, Bundle bundle) {
        if (this.zzb.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.zzb.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        Bundle bundle2 = this.zzb.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        Preconditions.checkNotNull(bundle2);
        bundle2.putBundle(cls.getName(), bundle);
    }

    public final void zzs(String str, String str2) {
        this.zze.putString(str, str2);
    }

    public final void zzt(String str) {
        this.zza.add(str);
    }

    public final void zzu(Class cls, Bundle bundle) {
        this.zzb.putBundle(cls.getName(), bundle);
    }

    @Deprecated
    public final void zzv(NetworkExtras networkExtras) {
        this.zzc.put(networkExtras.getClass(), networkExtras);
    }

    public final void zzw(String str) {
        this.zzd.add(str);
    }

    public final void zzx(String str) {
        this.zzd.remove("B3EEABB8EE11C2BE770B684D95219ECB");
    }

    public final void zzy(AdInfo adInfo) {
        this.zzo = adInfo;
    }

    public final void zzz(String str) {
        this.zzp = str;
    }
}
