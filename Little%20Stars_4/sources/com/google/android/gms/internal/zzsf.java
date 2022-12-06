package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import com.google.android.gms.internal.zzqi;
import com.google.android.gms.internal.zzsg;

public class zzsf {
    private zzsg zzaIG = null;
    private boolean zzru = false;

    public void initialize(Context context) {
        synchronized (this) {
            if (!this.zzru) {
                try {
                    this.zzaIG = zzsg.zza.asInterface(zzqi.zza(context, zzqi.zzaCo, ModuleDescriptor.MODULE_ID).zzdM("com.google.android.gms.flags.impl.FlagProviderImpl"));
                    this.zzaIG.init(zze.zzD(context));
                    this.zzru = true;
                } catch (RemoteException | zzqi.zza e) {
                    Log.w("FlagValueProvider", "Failed to initialize flags module.", e);
                }
            }
        }
    }

    public <T> T zzb(zzsd<T> zzsd) {
        synchronized (this) {
            if (this.zzru) {
                return zzsd.zza(this.zzaIG);
            }
            T zzeq = zzsd.zzeq();
            return zzeq;
        }
    }
}
