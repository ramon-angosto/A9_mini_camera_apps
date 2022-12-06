package com.google.android.ump;

import android.content.Context;
import com.google.android.gms.internal.consent_sdk.zzbx;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public class ConsentDebugSettings {
    private final boolean zza;
    private final int zzb;

    /* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
    public static class Builder {
        private final List<String> zza = new ArrayList();
        private final Context zzb;
        /* access modifiers changed from: private */
        public int zzc = 0;
        private boolean zzd;

        public Builder(Context context) {
            this.zzb = context.getApplicationContext();
        }

        public Builder addTestDeviceHashedId(String str) {
            this.zza.add(str);
            return this;
        }

        public ConsentDebugSettings build() {
            Context context = this.zzb;
            List<String> list = this.zza;
            boolean z = true;
            if (!zzbx.zzb() && !list.contains(zzbx.zza(context)) && !this.zzd) {
                z = false;
            }
            return new ConsentDebugSettings(z, this, (zza) null);
        }

        public Builder setDebugGeography(int i) {
            this.zzc = i;
            return this;
        }

        public Builder setForceTesting(boolean z) {
            this.zzd = z;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
    public @interface DebugGeography {
        public static final int DEBUG_GEOGRAPHY_DISABLED = 0;
        public static final int DEBUG_GEOGRAPHY_EEA = 1;
        public static final int DEBUG_GEOGRAPHY_NOT_EEA = 2;
    }

    /* synthetic */ ConsentDebugSettings(boolean z, Builder builder, zza zza2) {
        this.zza = z;
        this.zzb = builder.zzc;
    }

    public int getDebugGeography() {
        return this.zzb;
    }

    public boolean isTestDevice() {
        return this.zza;
    }
}
