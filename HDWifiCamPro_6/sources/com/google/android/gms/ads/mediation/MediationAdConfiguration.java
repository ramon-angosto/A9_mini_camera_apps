package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public class MediationAdConfiguration {
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    private final String zza;
    private final Bundle zzb;
    private final Bundle zzc;
    private final Context zzd;
    private final boolean zze;
    private final Location zzf;
    private final int zzg;
    private final int zzh;
    private final String zzi;
    private final String zzj;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
    public @interface TagForChildDirectedTreatment {
    }

    public MediationAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z, Location location, int i, int i2, String str2, String str3) {
        this.zza = str;
        this.zzb = bundle;
        this.zzc = bundle2;
        this.zzd = context;
        this.zze = z;
        this.zzf = location;
        this.zzg = i;
        this.zzh = i2;
        this.zzi = str2;
        this.zzj = str3;
    }

    public String getBidResponse() {
        return this.zza;
    }

    public Context getContext() {
        return this.zzd;
    }

    public String getMaxAdContentRating() {
        return this.zzi;
    }

    public Bundle getMediationExtras() {
        return this.zzc;
    }

    public Bundle getServerParameters() {
        return this.zzb;
    }

    public String getWatermark() {
        return this.zzj;
    }

    public boolean isTestRequest() {
        return this.zze;
    }

    public int taggedForChildDirectedTreatment() {
        return this.zzg;
    }

    public int taggedForUnderAgeTreatment() {
        return this.zzh;
    }
}
