package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.zztd;

@Deprecated
public class zztc implements zztd.zza {
    private final zztd zzbkK;
    private boolean zzbkL;

    public zztc(Context context, int i) {
        this(context, i, (String) null);
    }

    public zztc(Context context, int i, String str) {
        this(context, i, str, (String) null, true);
    }

    public zztc(Context context, int i, String str, String str2, boolean z) {
        this.zzbkK = new zztd(context, i, str, str2, this, z, context != context.getApplicationContext() ? context.getClass().getName() : "OneTimePlayLogger");
        this.zzbkL = true;
    }

    private void zzId() {
        if (!this.zzbkL) {
            throw new IllegalStateException("Cannot reuse one-time logger after sending.");
        }
    }

    public void send() {
        zzId();
        this.zzbkK.start();
        this.zzbkL = false;
    }

    public void zzIe() {
        this.zzbkK.stop();
    }

    public void zzIf() {
        Log.w("OneTimePlayLogger", "logger connection failed");
    }

    public void zza(String str, byte[] bArr, String... strArr) {
        zzId();
        this.zzbkK.zzb(str, bArr, strArr);
    }

    public void zzc(PendingIntent pendingIntent) {
        String valueOf = String.valueOf(pendingIntent);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
        sb.append("logger connection failed: ");
        sb.append(valueOf);
        Log.w("OneTimePlayLogger", sb.toString());
    }
}
