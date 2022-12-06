package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class zzn extends zzm implements Handler.Callback {
    private final Handler mHandler;
    /* access modifiers changed from: private */
    public final HashMap<zza, zzb> zzarR = new HashMap<>();
    /* access modifiers changed from: private */
    public final com.google.android.gms.common.stats.zzb zzarS;
    private final long zzarT;
    /* access modifiers changed from: private */
    public final Context zztm;

    private static final class zza {
        private final String zzVt;
        private final String zzarU;
        private final ComponentName zzarV;

        public zza(ComponentName componentName) {
            this.zzVt = null;
            this.zzarU = null;
            this.zzarV = (ComponentName) zzaa.zzz(componentName);
        }

        public zza(String str, String str2) {
            this.zzVt = zzaa.zzdl(str);
            this.zzarU = zzaa.zzdl(str2);
            this.zzarV = null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            return zzz.equal(this.zzVt, zza.zzVt) && zzz.equal(this.zzarV, zza.zzarV);
        }

        public int hashCode() {
            return zzz.hashCode(this.zzVt, this.zzarV);
        }

        public String toString() {
            String str = this.zzVt;
            return str == null ? this.zzarV.flattenToString() : str;
        }

        public Intent zztK() {
            String str = this.zzVt;
            return str != null ? new Intent(str).setPackage(this.zzarU) : new Intent().setComponent(this.zzarV);
        }
    }

    private final class zzb {
        /* access modifiers changed from: private */
        public int mState = 2;
        /* access modifiers changed from: private */
        public IBinder zzaqQ;
        /* access modifiers changed from: private */
        public ComponentName zzarV;
        private final zza zzarW = new zza();
        /* access modifiers changed from: private */
        public final Set<ServiceConnection> zzarX = new HashSet();
        private boolean zzarY;
        /* access modifiers changed from: private */
        public final zza zzarZ;

        public class zza implements ServiceConnection {
            public zza() {
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (zzn.this.zzarR) {
                    IBinder unused = zzb.this.zzaqQ = iBinder;
                    ComponentName unused2 = zzb.this.zzarV = componentName;
                    for (ServiceConnection onServiceConnected : zzb.this.zzarX) {
                        onServiceConnected.onServiceConnected(componentName, iBinder);
                    }
                    int unused3 = zzb.this.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (zzn.this.zzarR) {
                    IBinder unused = zzb.this.zzaqQ = null;
                    ComponentName unused2 = zzb.this.zzarV = componentName;
                    for (ServiceConnection onServiceDisconnected : zzb.this.zzarX) {
                        onServiceDisconnected.onServiceDisconnected(componentName);
                    }
                    int unused3 = zzb.this.mState = 2;
                }
            }
        }

        public zzb(zza zza2) {
            this.zzarZ = zza2;
        }

        public IBinder getBinder() {
            return this.zzaqQ;
        }

        public ComponentName getComponentName() {
            return this.zzarV;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.zzarY;
        }

        public void zza(ServiceConnection serviceConnection, String str) {
            zzn.this.zzarS.zza(zzn.this.zztm, serviceConnection, str, this.zzarZ.zztK());
            this.zzarX.add(serviceConnection);
        }

        public boolean zza(ServiceConnection serviceConnection) {
            return this.zzarX.contains(serviceConnection);
        }

        public void zzb(ServiceConnection serviceConnection, String str) {
            zzn.this.zzarS.zzb(zzn.this.zztm, serviceConnection);
            this.zzarX.remove(serviceConnection);
        }

        @TargetApi(14)
        public void zzdg(String str) {
            this.mState = 3;
            this.zzarY = zzn.this.zzarS.zza(zzn.this.zztm, str, this.zzarZ.zztK(), (ServiceConnection) this.zzarW, 129);
            if (!this.zzarY) {
                this.mState = 2;
                try {
                    zzn.this.zzarS.zza(zzn.this.zztm, (ServiceConnection) this.zzarW);
                } catch (IllegalArgumentException unused) {
                }
            }
        }

        public void zzdh(String str) {
            zzn.this.zzarS.zza(zzn.this.zztm, (ServiceConnection) this.zzarW);
            this.zzarY = false;
            this.mState = 2;
        }

        public boolean zztL() {
            return this.zzarX.isEmpty();
        }
    }

    zzn(Context context) {
        this.zztm = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.zzarS = com.google.android.gms.common.stats.zzb.zzuH();
        this.zzarT = 5000;
    }

    private boolean zza(zza zza2, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        zzaa.zzb(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.zzarR) {
            zzb zzb2 = this.zzarR.get(zza2);
            if (zzb2 == null) {
                zzb2 = new zzb(zza2);
                zzb2.zza(serviceConnection, str);
                zzb2.zzdg(str);
                this.zzarR.put(zza2, zzb2);
            } else {
                this.mHandler.removeMessages(0, zzb2);
                if (!zzb2.zza(serviceConnection)) {
                    zzb2.zza(serviceConnection, str);
                    int state = zzb2.getState();
                    if (state == 1) {
                        serviceConnection.onServiceConnected(zzb2.getComponentName(), zzb2.getBinder());
                    } else if (state == 2) {
                        zzb2.zzdg(str);
                    }
                } else {
                    String valueOf = String.valueOf(zza2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            isBound = zzb2.isBound();
        }
        return isBound;
    }

    private void zzb(zza zza2, ServiceConnection serviceConnection, String str) {
        zzaa.zzb(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.zzarR) {
            zzb zzb2 = this.zzarR.get(zza2);
            if (zzb2 == null) {
                String valueOf = String.valueOf(zza2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (zzb2.zza(serviceConnection)) {
                zzb2.zzb(serviceConnection, str);
                if (zzb2.zztL()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, zzb2), this.zzarT);
                }
            } else {
                String valueOf2 = String.valueOf(zza2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        zzb zzb2 = (zzb) message.obj;
        synchronized (this.zzarR) {
            if (zzb2.zztL()) {
                if (zzb2.isBound()) {
                    zzb2.zzdh("GmsClientSupervisor");
                }
                this.zzarR.remove(zzb2.zzarZ);
            }
        }
        return true;
    }

    public boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zza(new zza(componentName), serviceConnection, str);
    }

    public boolean zza(String str, String str2, ServiceConnection serviceConnection, String str3) {
        return zza(new zza(str, str2), serviceConnection, str3);
    }

    public void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zzb(new zza(componentName), serviceConnection, str);
    }

    public void zzb(String str, String str2, ServiceConnection serviceConnection, String str3) {
        zzb(new zza(str, str2), serviceConnection, str3);
    }
}
