package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.zze;

public abstract class zzg<T> {
    private final String zzaCj;
    private T zzaCk;

    public static class zza extends Exception {
        public zza(String str) {
            super(str);
        }

        public zza(String str, Throwable th) {
            super(str, th);
        }
    }

    protected zzg(String str) {
        this.zzaCj = str;
    }

    /* access modifiers changed from: protected */
    public final T zzaI(Context context) throws zza {
        if (this.zzaCk == null) {
            zzaa.zzz(context);
            Context remoteContext = zze.getRemoteContext(context);
            if (remoteContext != null) {
                try {
                    this.zzaCk = zzc((IBinder) remoteContext.getClassLoader().loadClass(this.zzaCj).newInstance());
                } catch (ClassNotFoundException e) {
                    throw new zza("Could not load creator class.", e);
                } catch (InstantiationException e2) {
                    throw new zza("Could not instantiate creator.", e2);
                } catch (IllegalAccessException e3) {
                    throw new zza("Could not access creator.", e3);
                }
            } else {
                throw new zza("Could not get remote context.");
            }
        }
        return this.zzaCk;
    }

    /* access modifiers changed from: protected */
    public abstract T zzc(IBinder iBinder);
}
