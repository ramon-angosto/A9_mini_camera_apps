package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class ClientSettings {
    @Nullable
    private final Account zaa;
    private final Set<Scope> zab;
    private final Set<Scope> zac;
    private final Map<Api<?>, zab> zad;
    private final int zae;
    @Nullable
    private final View zaf;
    private final String zag;
    private final String zah;
    private final SignInOptions zai;
    private Integer zaj;

    /* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
    public static final class Builder {
        @Nullable
        private Account zaa;
        private ArraySet<Scope> zab;
        private String zac;
        private String zad;
        private SignInOptions zae = SignInOptions.zaa;

        public ClientSettings build() {
            return new ClientSettings(this.zaa, this.zab, (Map<Api<?>, zab>) null, 0, (View) null, this.zac, this.zad, this.zae, false);
        }

        public Builder setRealClientPackageName(String str) {
            this.zac = str;
            return this;
        }

        public final Builder zaa(Collection<Scope> collection) {
            if (this.zab == null) {
                this.zab = new ArraySet<>();
            }
            this.zab.addAll(collection);
            return this;
        }

        public final Builder zab(@Nullable Account account) {
            this.zaa = account;
            return this;
        }

        public final Builder zac(String str) {
            this.zad = str;
            return this;
        }
    }

    public ClientSettings(Account account, Set<Scope> set, Map<Api<?>, zab> map, int i, @Nullable View view, String str, String str2, @Nullable SignInOptions signInOptions) {
        this(account, set, map, i, view, str, str2, signInOptions, false);
    }

    public static ClientSettings createDefault(Context context) {
        return new GoogleApiClient.Builder(context).zaa();
    }

    public Account getAccount() {
        return this.zaa;
    }

    @Deprecated
    public String getAccountName() {
        Account account = this.zaa;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    public Account getAccountOrDefault() {
        Account account = this.zaa;
        return account != null ? account : new Account("<<default account>>", AccountType.GOOGLE);
    }

    public Set<Scope> getAllRequestedScopes() {
        return this.zac;
    }

    public Set<Scope> getApplicableScopes(Api<?> api) {
        zab zab2 = this.zad.get(api);
        if (zab2 == null || zab2.zaa.isEmpty()) {
            return this.zab;
        }
        HashSet hashSet = new HashSet(this.zab);
        hashSet.addAll(zab2.zaa);
        return hashSet;
    }

    public int getGravityForPopups() {
        return this.zae;
    }

    public String getRealClientPackageName() {
        return this.zag;
    }

    public Set<Scope> getRequiredScopes() {
        return this.zab;
    }

    public View getViewForPopups() {
        return this.zaf;
    }

    public final SignInOptions zaa() {
        return this.zai;
    }

    public final Integer zab() {
        return this.zaj;
    }

    public final String zac() {
        return this.zah;
    }

    public final Map<Api<?>, zab> zad() {
        return this.zad;
    }

    public final void zae(Integer num) {
        this.zaj = num;
    }

    public ClientSettings(@Nullable Account account, Set<Scope> set, Map<Api<?>, zab> map, int i, @Nullable View view, String str, String str2, @Nullable SignInOptions signInOptions, boolean z) {
        this.zaa = account;
        this.zab = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.zad = map == null ? Collections.emptyMap() : map;
        this.zaf = view;
        this.zae = i;
        this.zag = str;
        this.zah = str2;
        this.zai = signInOptions == null ? SignInOptions.zaa : signInOptions;
        HashSet hashSet = new HashSet(this.zab);
        for (zab zab2 : this.zad.values()) {
            hashSet.addAll(zab2.zaa);
        }
        this.zac = Collections.unmodifiableSet(hashSet);
    }
}
