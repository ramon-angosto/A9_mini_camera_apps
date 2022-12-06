package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zztw;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzg {
    private final Account zzZB;
    private final String zzaaN;
    private final Set<Scope> zzald;
    private final int zzalf;
    private final View zzalg;
    private final String zzalh;
    private final Set<Scope> zzaro;
    private final Map<Api<?>, zza> zzarp;
    private final zztw zzarq;
    private Integer zzarr;

    public static final class zza {
        public final Set<Scope> zzacF;
        public final boolean zzars;

        public zza(Set<Scope> set, boolean z) {
            zzaa.zzz(set);
            this.zzacF = Collections.unmodifiableSet(set);
            this.zzars = z;
        }
    }

    public zzg(Account account, Set<Scope> set, Map<Api<?>, zza> map, int i, View view, String str, String str2, zztw zztw) {
        this.zzZB = account;
        this.zzald = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.zzarp = map == null ? Collections.EMPTY_MAP : map;
        this.zzalg = view;
        this.zzalf = i;
        this.zzaaN = str;
        this.zzalh = str2;
        this.zzarq = zztw;
        HashSet hashSet = new HashSet(this.zzald);
        for (zza zza2 : this.zzarp.values()) {
            hashSet.addAll(zza2.zzacF);
        }
        this.zzaro = Collections.unmodifiableSet(hashSet);
    }

    public static zzg zzau(Context context) {
        return new GoogleApiClient.Builder(context).zzrt();
    }

    public Account getAccount() {
        return this.zzZB;
    }

    @Deprecated
    public String getAccountName() {
        Account account = this.zzZB;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    public Set<Scope> zzb(Api<?> api) {
        zza zza2 = this.zzarp.get(api);
        if (zza2 == null || zza2.zzacF.isEmpty()) {
            return this.zzald;
        }
        HashSet hashSet = new HashSet(this.zzald);
        hashSet.addAll(zza2.zzacF);
        return hashSet;
    }

    public void zzc(Integer num) {
        this.zzarr = num;
    }

    public View zztA() {
        return this.zzalg;
    }

    public zztw zztB() {
        return this.zzarq;
    }

    public Integer zztC() {
        return this.zzarr;
    }

    public Account zztk() {
        Account account = this.zzZB;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    public int zztu() {
        return this.zzalf;
    }

    public Set<Scope> zztv() {
        return this.zzald;
    }

    public Set<Scope> zztw() {
        return this.zzaro;
    }

    public Map<Api<?>, zza> zztx() {
        return this.zzarp;
    }

    public String zzty() {
        return this.zzaaN;
    }

    public String zztz() {
        return this.zzalh;
    }
}
