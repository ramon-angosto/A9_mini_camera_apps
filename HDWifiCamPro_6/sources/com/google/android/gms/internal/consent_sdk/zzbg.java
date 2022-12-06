package com.google.android.gms.internal.consent_sdk;

import android.os.Handler;
import android.webkit.WebView;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final class zzbg extends WebView {
    private final Handler zza;
    /* access modifiers changed from: private */
    public final zzbm zzb;
    /* access modifiers changed from: private */
    public boolean zzc = false;

    public zzbg(zzbi zzbi, Handler handler, zzbm zzbm) {
        super(zzbi);
        this.zza = handler;
        this.zzb = zzbm;
    }

    static /* synthetic */ boolean zzc(zzbg zzbg, String str) {
        return str != null && str.startsWith("consent://");
    }

    public final void zzb(String str, String str2) {
        StringBuilder sb = new StringBuilder(str.length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("(");
        sb.append(str2);
        sb.append(");");
        this.zza.post(new zzbd(this, sb.toString()));
    }
}
