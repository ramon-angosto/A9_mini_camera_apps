package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzd;
import com.google.android.gms.internal.zznt;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class zzpf {
    private static final zznt.zza<?, ?>[] zzaoJ = new zznt.zza[0];
    private final Map<Api.zzc<?>, Api.zze> zzann;
    final Set<zznt.zza<?, ?>> zzaoK;
    private final zzb zzaoL;

    private static class zza implements IBinder.DeathRecipient, zzb {
        private final WeakReference<zznt.zza<?, ?>> zzaoN;
        private final WeakReference<zzd> zzaoO;
        private final WeakReference<IBinder> zzaoP;

        private zza(zznt.zza<?, ?> zza, zzd zzd, IBinder iBinder) {
            this.zzaoO = new WeakReference<>(zzd);
            this.zzaoN = new WeakReference<>(zza);
            this.zzaoP = new WeakReference<>(iBinder);
        }

        private void zzst() {
            zznt.zza zza = (zznt.zza) this.zzaoN.get();
            zzd zzd = (zzd) this.zzaoO.get();
            if (!(zzd == null || zza == null)) {
                zzd.remove(zza.zzrv().intValue());
            }
            IBinder iBinder = (IBinder) this.zzaoP.get();
            if (this.zzaoP != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        public void binderDied() {
            zzst();
        }

        public void zzh(zznt.zza<?, ?> zza) {
            zzst();
        }
    }

    interface zzb {
        void zzh(zznt.zza<?, ?> zza);
    }

    public zzpf(Api.zzc<?> zzc, Api.zze zze) {
        this.zzaoK = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.zzaoL = new zzb() {
            public void zzh(zznt.zza<?, ?> zza) {
                zzpf.this.zzaoK.remove(zza);
                if (zza.zzrv() != null && zzpf.zza(zzpf.this) != null) {
                    zzpf.zza(zzpf.this).remove(zza.zzrv().intValue());
                }
            }
        };
        this.zzann = new ArrayMap();
        this.zzann.put(zzc, zze);
    }

    public zzpf(Map<Api.zzc<?>, Api.zze> map) {
        this.zzaoK = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.zzaoL = new zzb() {
            public void zzh(zznt.zza<?, ?> zza) {
                zzpf.this.zzaoK.remove(zza);
                if (zza.zzrv() != null && zzpf.zza(zzpf.this) != null) {
                    zzpf.zza(zzpf.this).remove(zza.zzrv().intValue());
                }
            }
        };
        this.zzann = map;
    }

    static /* synthetic */ zzd zza(zzpf zzpf) {
        return null;
    }

    private static void zza(zznt.zza<?, ?> zza2, zzd zzd, IBinder iBinder) {
        if (zza2.isReady()) {
            zza2.zza((zzb) new zza(zza2, zzd, iBinder));
            return;
        }
        if (iBinder == null || !iBinder.isBinderAlive()) {
            zza2.zza((zzb) null);
        } else {
            zza zza3 = new zza(zza2, zzd, iBinder);
            zza2.zza((zzb) zza3);
            try {
                iBinder.linkToDeath(zza3, 0);
                return;
            } catch (RemoteException unused) {
            }
        }
        zza2.cancel();
        zzd.remove(zza2.zzrv().intValue());
    }

    public void dump(PrintWriter printWriter) {
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.zzaoK.size());
    }

    public void release() {
        for (zznt.zza zza2 : (zznt.zza[]) this.zzaoK.toArray(zzaoJ)) {
            zza2.zza((zzb) null);
            if (zza2.zzrv() != null) {
                zza2.zzrD();
                zza(zza2, (zzd) null, this.zzann.get(zza2.zzre()).zzrh());
            } else if (!zza2.zzrH()) {
            }
            this.zzaoK.remove(zza2);
        }
    }

    /* access modifiers changed from: package-private */
    public <A extends Api.zzb> void zzg(zznt.zza<? extends Result, A> zza2) {
        this.zzaoK.add(zza2);
        zza2.zza(this.zzaoL);
    }

    public void zzsL() {
        for (zznt.zza zzy : (zznt.zza[]) this.zzaoK.toArray(zzaoJ)) {
            zzy.zzy(new Status(8, "The connection to Google Play services was lost"));
        }
    }

    public boolean zzsM() {
        for (zznt.zza isReady : (zznt.zza[]) this.zzaoK.toArray(zzaoJ)) {
            if (!isReady.isReady()) {
                return true;
            }
        }
        return false;
    }
}
