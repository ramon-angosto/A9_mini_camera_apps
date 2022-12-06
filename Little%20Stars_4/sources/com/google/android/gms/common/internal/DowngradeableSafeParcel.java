package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable {
    private static final Object zzaru = new Object();
    private static ClassLoader zzarv = null;
    private static Integer zzarw = null;
    private boolean zzarx = false;

    private static boolean zzd(Class<?> cls) {
        try {
            return SafeParcelable.NULL.equals(cls.getField("NULL").get((Object) null));
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            return false;
        }
    }

    protected static boolean zzde(String str) {
        ClassLoader zztE = zztE();
        if (zztE == null) {
            return true;
        }
        try {
            return zzd(zztE.loadClass(str));
        } catch (Exception unused) {
            return false;
        }
    }

    protected static ClassLoader zztE() {
        synchronized (zzaru) {
        }
        return null;
    }

    protected static Integer zztF() {
        synchronized (zzaru) {
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean zztG() {
        return false;
    }
}
