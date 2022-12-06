package com.google.android.gms.ads.rewarded;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public class ServerSideVerificationOptions {
    private final String zza;
    private final String zzb;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public String zza = "";
        /* access modifiers changed from: private */
        public String zzb = "";

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this, (zzd) null);
        }

        public Builder setCustomData(String str) {
            this.zzb = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.zza = str;
            return this;
        }
    }

    /* synthetic */ ServerSideVerificationOptions(Builder builder, zzd zzd) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
    }

    public String getCustomData() {
        return this.zzb;
    }

    public String getUserId() {
        return this.zza;
    }
}
