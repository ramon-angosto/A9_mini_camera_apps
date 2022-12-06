package com.google.android.gms.common.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzq;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends ApiOptions> {
    private final String mName;
    private final zzf<?> zzajk;
    private final zza<?, O> zzakG;
    private final zzh<?, O> zzakH = null;
    private final zzi<?> zzakI;

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    public static abstract class zza<T extends zze, O> extends zzd<T, O> {
        public abstract T zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg zzg, O o, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener);
    }

    public interface zzb {
    }

    public static class zzc<C extends zzb> {
    }

    public static abstract class zzd<T extends zzb, O> {
        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public List<Scope> zzp(O o) {
            return Collections.emptyList();
        }
    }

    public interface zze extends zzb {
        void disconnect();

        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        boolean isConnected();

        boolean isConnecting();

        void zza(zzd.zzf zzf);

        void zza(zzq zzq, Set<Scope> set);

        boolean zzpd();

        boolean zzps();

        Intent zzpt();

        boolean zzrg();

        @Nullable
        IBinder zzrh();
    }

    public static final class zzf<C extends zze> extends zzc<C> {
    }

    public interface zzg<T extends IInterface> extends zzb {
        void zza(int i, T t);

        T zzab(IBinder iBinder);

        String zzhT();

        String zzhU();
    }

    public static abstract class zzh<T extends zzg, O> extends zzd<T, O> {
        public abstract T zzr(O o);

        public abstract int zzri();
    }

    public static final class zzi<C extends zzg> extends zzc<C> {
    }

    public <C extends zze> Api(String str, zza<C, O> zza2, zzf<C> zzf2) {
        zzaa.zzb(zza2, (Object) "Cannot construct an Api with a null ClientBuilder");
        zzaa.zzb(zzf2, (Object) "Cannot construct an Api with a null ClientKey");
        this.mName = str;
        this.zzakG = zza2;
        this.zzajk = zzf2;
        this.zzakI = null;
    }

    public String getName() {
        return this.mName;
    }

    public zzd<?, O> zzrb() {
        if (zzrf()) {
            return null;
        }
        return this.zzakG;
    }

    public zza<?, O> zzrc() {
        zzaa.zza(this.zzakG != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.zzakG;
    }

    public zzh<?, O> zzrd() {
        zzaa.zza(false, (Object) "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return null;
    }

    public zzc<?> zzre() {
        zzf<?> zzf2 = this.zzajk;
        if (zzf2 != null) {
            return zzf2;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public boolean zzrf() {
        return false;
    }
}
