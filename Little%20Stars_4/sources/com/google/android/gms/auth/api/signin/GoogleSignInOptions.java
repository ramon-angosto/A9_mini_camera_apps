package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new zzb();
    public static final GoogleSignInOptions DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
    private static Comparator<Scope> zzacv = new Comparator<Scope>() {
        /* renamed from: zza */
        public int compare(Scope scope, Scope scope2) {
            return scope.zzrw().compareTo(scope2.zzrw());
        }
    };
    public static final Scope zzacw = new Scope(Scopes.PROFILE);
    public static final Scope zzacx = new Scope("email");
    public static final Scope zzacy = new Scope("openid");
    final int versionCode;
    /* access modifiers changed from: private */
    public Account zzZB;
    /* access modifiers changed from: private */
    public boolean zzacA;
    /* access modifiers changed from: private */
    public final boolean zzacB;
    /* access modifiers changed from: private */
    public final boolean zzacC;
    /* access modifiers changed from: private */
    public String zzacD;
    /* access modifiers changed from: private */
    public String zzacE;
    /* access modifiers changed from: private */
    public final ArrayList<Scope> zzacz;

    public static final class Builder {
        private Account zzZB;
        private boolean zzacA;
        private boolean zzacB;
        private boolean zzacC;
        private String zzacD;
        private String zzacE;
        private Set<Scope> zzacF = new HashSet();

        public Builder() {
        }

        public Builder(@NonNull GoogleSignInOptions googleSignInOptions) {
            zzaa.zzz(googleSignInOptions);
            this.zzacF = new HashSet(googleSignInOptions.zzacz);
            this.zzacB = googleSignInOptions.zzacB;
            this.zzacC = googleSignInOptions.zzacC;
            this.zzacA = googleSignInOptions.zzacA;
            this.zzacD = googleSignInOptions.zzacD;
            this.zzZB = googleSignInOptions.zzZB;
            this.zzacE = googleSignInOptions.zzacE;
        }

        private String zzcp(String str) {
            zzaa.zzdl(str);
            String str2 = this.zzacD;
            zzaa.zzb(str2 == null || str2.equals(str), (Object) "two different server client ids provided");
            return str;
        }

        public GoogleSignInOptions build() {
            if (this.zzacA && (this.zzZB == null || !this.zzacF.isEmpty())) {
                requestId();
            }
            return new GoogleSignInOptions((Set) this.zzacF, this.zzZB, this.zzacA, this.zzacB, this.zzacC, this.zzacD, this.zzacE);
        }

        public Builder requestEmail() {
            this.zzacF.add(GoogleSignInOptions.zzacx);
            return this;
        }

        public Builder requestId() {
            this.zzacF.add(GoogleSignInOptions.zzacy);
            return this;
        }

        public Builder requestIdToken(String str) {
            this.zzacA = true;
            this.zzacD = zzcp(str);
            return this;
        }

        public Builder requestProfile() {
            this.zzacF.add(GoogleSignInOptions.zzacw);
            return this;
        }

        public Builder requestScopes(Scope scope, Scope... scopeArr) {
            this.zzacF.add(scope);
            this.zzacF.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public Builder requestServerAuthCode(String str) {
            return requestServerAuthCode(str, false);
        }

        public Builder requestServerAuthCode(String str, boolean z) {
            this.zzacB = true;
            this.zzacD = zzcp(str);
            this.zzacC = z;
            return this;
        }

        public Builder setAccountName(String str) {
            this.zzZB = new Account(zzaa.zzdl(str), "com.google");
            return this;
        }

        public Builder setHostedDomain(String str) {
            this.zzacE = zzaa.zzdl(str);
            return this;
        }
    }

    GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this.versionCode = i;
        this.zzacz = arrayList;
        this.zzZB = account;
        this.zzacA = z;
        this.zzacB = z2;
        this.zzacC = z3;
        this.zzacD = str;
        this.zzacE = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private GoogleSignInOptions(Set<Scope> set, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this(2, (ArrayList<Scope>) new ArrayList(set), account, z, z2, z3, str, str2);
        Set<Scope> set2 = set;
    }

    @Nullable
    public static GoogleSignInOptions zzco(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String optString = jSONObject.optString("accountName", (String) null);
        return new GoogleSignInOptions(hashSet, !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", (String) null), jSONObject.optString("hostedDomain", (String) null));
    }

    private JSONObject zzpi() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.zzacz, zzacv);
            Iterator<Scope> it = this.zzacz.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().zzrw());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.zzZB != null) {
                jSONObject.put("accountName", this.zzZB.name);
            }
            jSONObject.put("idTokenRequested", this.zzacA);
            jSONObject.put("forceCodeForRefreshToken", this.zzacC);
            jSONObject.put("serverAuthRequested", this.zzacB);
            if (!TextUtils.isEmpty(this.zzacD)) {
                jSONObject.put("serverClientId", this.zzacD);
            }
            if (!TextUtils.isEmpty(this.zzacE)) {
                jSONObject.put("hostedDomain", this.zzacE);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.zzacz.size() != googleSignInOptions.zzpj().size()) {
                return false;
            }
            if (!this.zzacz.containsAll(googleSignInOptions.zzpj())) {
                return false;
            }
            if (this.zzZB == null) {
                if (googleSignInOptions.getAccount() != null) {
                    return false;
                }
            } else if (!this.zzZB.equals(googleSignInOptions.getAccount())) {
                return false;
            }
            if (TextUtils.isEmpty(this.zzacD)) {
                if (!TextUtils.isEmpty(googleSignInOptions.zzpn())) {
                    return false;
                }
            } else if (!this.zzacD.equals(googleSignInOptions.zzpn())) {
                return false;
            }
            return this.zzacC == googleSignInOptions.zzpm() && this.zzacA == googleSignInOptions.zzpk() && this.zzacB == googleSignInOptions.zzpl();
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public Account getAccount() {
        return this.zzZB;
    }

    public Scope[] getScopeArray() {
        ArrayList<Scope> arrayList = this.zzacz;
        return (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        Iterator<Scope> it = this.zzacz.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().zzrw());
        }
        Collections.sort(arrayList);
        return new zze().zzq(arrayList).zzq(this.zzZB).zzq(this.zzacD).zzX(this.zzacC).zzX(this.zzacA).zzX(this.zzacB).zzpv();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public String zzpg() {
        return zzpi().toString();
    }

    public ArrayList<Scope> zzpj() {
        return new ArrayList<>(this.zzacz);
    }

    public boolean zzpk() {
        return this.zzacA;
    }

    public boolean zzpl() {
        return this.zzacB;
    }

    public boolean zzpm() {
        return this.zzacC;
    }

    public String zzpn() {
        return this.zzacD;
    }

    public String zzpo() {
        return this.zzacE;
    }
}
