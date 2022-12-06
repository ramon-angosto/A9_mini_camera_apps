package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    private static final Object zza = new Object();
    private boolean zzb = false;

    protected static boolean canUnparcelSafely(String str) {
        synchronized (zza) {
        }
        return true;
    }

    protected static Integer getUnparcelClientVersion() {
        synchronized (zza) {
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract boolean prepareForClientVersion(int i);

    public void setShouldDowngrade(boolean z) {
        this.zzb = z;
    }

    /* access modifiers changed from: protected */
    public boolean shouldDowngrade() {
        return this.zzb;
    }
}
