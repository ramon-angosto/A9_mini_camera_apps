package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
final class zzj implements DynamiteModule.VersionPolicy {
    zzj() {
    }

    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        int i;
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int zza = iVersions.zza(context, str);
        selectionResult.localVersion = zza;
        if (zza != 0) {
            i = iVersions.zzb(context, str, false);
            selectionResult.remoteVersion = i;
        } else {
            i = iVersions.zzb(context, str, true);
            selectionResult.remoteVersion = i;
        }
        int i2 = selectionResult.localVersion;
        if (i2 == 0) {
            if (i == 0) {
                selectionResult.selection = 0;
                return selectionResult;
            }
            i2 = 0;
        }
        if (i2 >= i) {
            selectionResult.selection = -1;
        } else {
            selectionResult.selection = 1;
        }
        return selectionResult;
    }
}
