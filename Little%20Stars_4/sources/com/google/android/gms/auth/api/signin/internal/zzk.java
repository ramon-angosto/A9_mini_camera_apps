package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.zzaa;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class zzk {
    private static final Lock zzadb = new ReentrantLock();
    private static zzk zzadc;
    private final Lock zzadd = new ReentrantLock();
    private final SharedPreferences zzade;

    zzk(Context context) {
        this.zzade = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static zzk zzab(Context context) {
        zzaa.zzz(context);
        zzadb.lock();
        try {
            if (zzadc == null) {
                zzadc = new zzk(context.getApplicationContext());
            }
            return zzadc;
        } finally {
            zzadb.unlock();
        }
    }

    private String zzw(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 0 + ":".length() + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void zza(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzaa.zzz(googleSignInAccount);
        zzaa.zzz(googleSignInOptions);
        String zzpf = googleSignInAccount.zzpf();
        zzv(zzw("googleSignInAccount", zzpf), googleSignInAccount.zzph());
        zzv(zzw("googleSignInOptions", zzpf), googleSignInOptions.zzpg());
    }

    public void zzb(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzaa.zzz(googleSignInAccount);
        zzaa.zzz(googleSignInOptions);
        zzv("defaultGoogleSignInAccount", googleSignInAccount.zzpf());
        zza(googleSignInAccount, googleSignInOptions);
    }

    /* access modifiers changed from: package-private */
    public GoogleSignInAccount zzcq(String str) {
        String zzcs;
        if (TextUtils.isEmpty(str) || (zzcs = zzcs(zzw("googleSignInAccount", str))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.zzcm(zzcs);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public GoogleSignInOptions zzcr(String str) {
        String zzcs;
        if (TextUtils.isEmpty(str) || (zzcs = zzcs(zzw("googleSignInOptions", str))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.zzco(zzcs);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public String zzcs(String str) {
        this.zzadd.lock();
        try {
            return this.zzade.getString(str, (String) null);
        } finally {
            this.zzadd.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzct(String str) {
        if (!TextUtils.isEmpty(str)) {
            zzcu(zzw("googleSignInAccount", str));
            zzcu(zzw("googleSignInOptions", str));
        }
    }

    /* access modifiers changed from: protected */
    public void zzcu(String str) {
        this.zzadd.lock();
        try {
            this.zzade.edit().remove(str).apply();
        } finally {
            this.zzadd.unlock();
        }
    }

    public GoogleSignInAccount zzpC() {
        return zzcq(zzcs("defaultGoogleSignInAccount"));
    }

    public GoogleSignInOptions zzpD() {
        return zzcr(zzcs("defaultGoogleSignInAccount"));
    }

    public void zzpE() {
        String zzcs = zzcs("defaultGoogleSignInAccount");
        zzcu("defaultGoogleSignInAccount");
        zzct(zzcs);
    }

    /* access modifiers changed from: protected */
    public void zzv(String str, String str2) {
        this.zzadd.lock();
        try {
            this.zzade.edit().putString(str, str2).apply();
        } finally {
            this.zzadd.unlock();
        }
    }
}
