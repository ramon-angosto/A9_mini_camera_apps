package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public final class zzn {
    private static final Uri zza = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
    private final String zzb;
    private final String zzc;
    private final ComponentName zzd;
    private final int zze;
    private final boolean zzf;

    public zzn(ComponentName componentName, int i) {
        this.zzb = null;
        this.zzc = null;
        Preconditions.checkNotNull(componentName);
        this.zzd = componentName;
        this.zze = i;
        this.zzf = false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzn)) {
            return false;
        }
        zzn zzn = (zzn) obj;
        return Objects.equal(this.zzb, zzn.zzb) && Objects.equal(this.zzc, zzn.zzc) && Objects.equal(this.zzd, zzn.zzd) && this.zze == zzn.zze && this.zzf == zzn.zzf;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb, this.zzc, this.zzd, Integer.valueOf(this.zze), Boolean.valueOf(this.zzf));
    }

    public final String toString() {
        String str = this.zzb;
        if (str != null) {
            return str;
        }
        Preconditions.checkNotNull(this.zzd);
        return this.zzd.flattenToString();
    }

    public final int zza() {
        return this.zze;
    }

    public final ComponentName zzb() {
        return this.zzd;
    }

    public final Intent zzc(Context context) {
        Bundle bundle;
        if (this.zzb == null) {
            return new Intent().setComponent(this.zzd);
        }
        Intent intent = null;
        if (this.zzf) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("serviceActionBundleKey", this.zzb);
            try {
                bundle = context.getContentResolver().call(zza, "serviceIntentCall", (String) null, bundle2);
            } catch (IllegalArgumentException e) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                bundle = null;
            }
            if (bundle != null) {
                intent = (Intent) bundle.getParcelable("serviceResponseIntentKey");
            }
            if (intent == null) {
                String valueOf = String.valueOf(this.zzb);
                Log.w("ConnectionStatusConfig", valueOf.length() != 0 ? "Dynamic lookup for intent failed for action: ".concat(valueOf) : new String("Dynamic lookup for intent failed for action: "));
            }
        }
        if (intent != null) {
            return intent;
        }
        return new Intent(this.zzb).setPackage(this.zzc);
    }

    public final String zzd() {
        return this.zzc;
    }

    public zzn(String str, int i, boolean z) {
        this(str, "com.google.android.gms", i, false);
    }

    public zzn(String str, String str2, int i, boolean z) {
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        Preconditions.checkNotEmpty(str2);
        this.zzc = str2;
        this.zzd = null;
        this.zze = i;
        this.zzf = z;
    }
}
