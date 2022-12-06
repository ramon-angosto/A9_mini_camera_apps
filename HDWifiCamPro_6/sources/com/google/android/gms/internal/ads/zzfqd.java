package com.google.android.gms.internal.ads;

import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfqd {
    public static final int zza = (Build.VERSION.SDK_INT > 22 ? 67108864 : 0);
    public static final ClipData zzb = ClipData.newIntent("", new Intent());

    @Nullable
    public static PendingIntent zza(Context context, int i, Intent intent, int i2, int i3) {
        boolean z = true;
        zzfsx.zzf((i2 & 95) == 0, "Cannot set any dangerous parts of intent to be mutable.");
        zzfsx.zzf(intent.getComponent() != null, "Must set component on Intent.");
        if (zzb(0, 1)) {
            zzfsx.zzf(!zzb(i2, 67108864), "Cannot set mutability flags if PendingIntent.FLAG_IMMUTABLE is set.");
        } else {
            if (Build.VERSION.SDK_INT >= 23 && !zzb(i2, 67108864)) {
                z = false;
            }
            zzfsx.zzf(z, "Must set PendingIntent.FLAG_IMMUTABLE for SDK >= 23 if no parts of intent are mutable.");
        }
        Intent intent2 = new Intent(intent);
        if (Build.VERSION.SDK_INT < 23 || !zzb(i2, 67108864)) {
            if (intent2.getPackage() == null) {
                intent2.setPackage(intent2.getComponent().getPackageName());
            }
            if (!zzb(0, 3) && intent2.getAction() == null) {
                intent2.setAction("");
            }
            if (!zzb(0, 9) && intent2.getCategories() == null) {
                intent2.addCategory("");
            }
            if (!zzb(0, 5) && intent2.getData() == null) {
                intent2.setDataAndType(Uri.EMPTY, "*/*");
            }
            if (!zzb(0, 17) && intent2.getClipData() == null) {
                intent2.setClipData(zzb);
            }
        }
        return PendingIntent.getService(context, 0, intent2, i2);
    }

    private static boolean zzb(int i, int i2) {
        return (i & i2) == i2;
    }
}
