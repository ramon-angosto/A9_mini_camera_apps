package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.playlog.internal.LogEvent;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import com.google.android.gms.playlog.internal.zzd;
import com.google.android.gms.playlog.internal.zzf;

@Deprecated
public class zztd {
    private final zzf zzbkM;
    private PlayLoggerContext zzbkN;

    public interface zza {
        void zzIe();

        void zzIf();

        void zzc(PendingIntent pendingIntent);
    }

    public zztd(Context context, int i, String str, String str2, zza zza2, boolean z, String str3) {
        int i2;
        String packageName = context.getPackageName();
        try {
            i2 = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.wtf("PlayLogger", "This can't happen.", e);
            i2 = 0;
        }
        this.zzbkN = new PlayLoggerContext(packageName, i2, i, str, str2, z);
        this.zzbkM = new zzf(context, context.getMainLooper(), new zzd(zza2), str3);
    }

    public void start() {
        this.zzbkM.start();
    }

    public void stop() {
        this.zzbkM.stop();
    }

    public void zza(long j, String str, byte[] bArr, String... strArr) {
        this.zzbkM.zzb(this.zzbkN, new LogEvent(j, 0, str, bArr, strArr));
    }

    public void zzb(String str, byte[] bArr, String... strArr) {
        zza(System.currentTimeMillis(), str, bArr, strArr);
    }
}
