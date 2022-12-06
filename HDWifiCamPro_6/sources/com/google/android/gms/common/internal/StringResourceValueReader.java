package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.R;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public class StringResourceValueReader {
    private final Resources zza;
    private final String zzb = this.zza.getResourcePackageName(R.string.common_google_play_services_unknown_issue);

    public StringResourceValueReader(Context context) {
        Preconditions.checkNotNull(context);
        this.zza = context.getResources();
    }

    public String getString(String str) {
        int identifier = this.zza.getIdentifier(str, "string", this.zzb);
        if (identifier == 0) {
            return null;
        }
        return this.zza.getString(identifier);
    }
}
