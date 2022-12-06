package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
final class zzf implements DynamiteModule.VersionPolicy {
    zzf() {
    }

    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int zzb = iVersions.zzb(context, str, true);
        selectionResult.remoteVersion = zzb;
        if (zzb != 0) {
            selectionResult.selection = 1;
        } else {
            int zza = iVersions.zza(context, str);
            selectionResult.localVersion = zza;
            if (zza != 0) {
                selectionResult.selection = -1;
            }
        }
        return selectionResult;
    }
}
