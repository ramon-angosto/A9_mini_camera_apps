package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.BinderThread;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzd<T extends IInterface> {
    public static final String[] zzaqJ = {"service_esmobile", "service_googleme"};
    private final Context mContext;
    final Handler mHandler;
    private final Looper zzakW;
    private final com.google.android.gms.common.zzc zzamE;
    private T zzaqA;
    /* access modifiers changed from: private */
    public final ArrayList<zze<?>> zzaqB;
    private zzh zzaqC;
    private int zzaqD;
    /* access modifiers changed from: private */
    public final zzb zzaqE;
    /* access modifiers changed from: private */
    public final zzc zzaqF;
    private final int zzaqG;
    private final String zzaqH;
    protected AtomicInteger zzaqI;
    private int zzaqr;
    private long zzaqs;
    private long zzaqt;
    private int zzaqu;
    private long zzaqv;
    private final zzm zzaqw;
    /* access modifiers changed from: private */
    public final Object zzaqx;
    /* access modifiers changed from: private */
    public zzu zzaqy;
    /* access modifiers changed from: private */
    public zzf zzaqz;
    private final Object zzpp;

    private abstract class zza extends zze<Boolean> {
        public final int statusCode;
        public final Bundle zzaqK;

        @BinderThread
        protected zza(int i, Bundle bundle) {
            super(true);
            this.statusCode = i;
            this.zzaqK = bundle;
        }

        /* JADX WARNING: type inference failed for: r4v11, types: [android.os.Parcelable] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: zzc */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void zzw(java.lang.Boolean r4) {
            /*
                r3 = this;
                r0 = 1
                r1 = 0
                if (r4 != 0) goto L_0x000a
                com.google.android.gms.common.internal.zzd r4 = com.google.android.gms.common.internal.zzd.this
                r4.zzb(r0, r1)
                return
            L_0x000a:
                int r4 = r3.statusCode
                if (r4 == 0) goto L_0x003c
                r2 = 10
                if (r4 == r2) goto L_0x002f
                com.google.android.gms.common.internal.zzd r4 = com.google.android.gms.common.internal.zzd.this
                r4.zzb(r0, r1)
                android.os.Bundle r4 = r3.zzaqK
                if (r4 == 0) goto L_0x0024
                java.lang.String r0 = "pendingIntent"
                android.os.Parcelable r4 = r4.getParcelable(r0)
                r1 = r4
                android.app.PendingIntent r1 = (android.app.PendingIntent) r1
            L_0x0024:
                com.google.android.gms.common.ConnectionResult r4 = new com.google.android.gms.common.ConnectionResult
                int r0 = r3.statusCode
                r4.<init>(r0, r1)
            L_0x002b:
                r3.zzl(r4)
                goto L_0x004f
            L_0x002f:
                com.google.android.gms.common.internal.zzd r4 = com.google.android.gms.common.internal.zzd.this
                r4.zzb(r0, r1)
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "A fatal developer error has occurred. Check the logs for further information."
                r4.<init>(r0)
                throw r4
            L_0x003c:
                boolean r4 = r3.zztp()
                if (r4 != 0) goto L_0x004f
                com.google.android.gms.common.internal.zzd r4 = com.google.android.gms.common.internal.zzd.this
                r4.zzb(r0, r1)
                com.google.android.gms.common.ConnectionResult r4 = new com.google.android.gms.common.ConnectionResult
                r0 = 8
                r4.<init>(r0, r1)
                goto L_0x002b
            L_0x004f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzd.zza.zzw(java.lang.Boolean):void");
        }

        /* access modifiers changed from: protected */
        public abstract void zzl(ConnectionResult connectionResult);

        /* access modifiers changed from: protected */
        public abstract boolean zztp();

        /* access modifiers changed from: protected */
        public void zztq() {
        }
    }

    public interface zzb {
        void onConnected(@Nullable Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface zzc {
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    /* renamed from: com.google.android.gms.common.internal.zzd$zzd  reason: collision with other inner class name */
    final class C0003zzd extends Handler {
        public C0003zzd(Looper looper) {
            super(looper);
        }

        private void zza(Message message) {
            zze zze = (zze) message.obj;
            zze.zztq();
            zze.unregister();
        }

        private boolean zzb(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.app.PendingIntent} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r6) {
            /*
                r5 = this;
                com.google.android.gms.common.internal.zzd r0 = com.google.android.gms.common.internal.zzd.this
                java.util.concurrent.atomic.AtomicInteger r0 = r0.zzaqI
                int r0 = r0.get()
                int r1 = r6.arg1
                if (r0 == r1) goto L_0x0016
                boolean r0 = r5.zzb(r6)
                if (r0 == 0) goto L_0x0015
                r5.zza(r6)
            L_0x0015:
                return
            L_0x0016:
                int r0 = r6.what
                r1 = 1
                if (r0 == r1) goto L_0x0020
                int r0 = r6.what
                r2 = 5
                if (r0 != r2) goto L_0x002c
            L_0x0020:
                com.google.android.gms.common.internal.zzd r0 = com.google.android.gms.common.internal.zzd.this
                boolean r0 = r0.isConnecting()
                if (r0 != 0) goto L_0x002c
                r5.zza(r6)
                return
            L_0x002c:
                int r0 = r6.what
                r2 = 3
                r3 = 0
                if (r0 != r2) goto L_0x0053
                java.lang.Object r0 = r6.obj
                boolean r0 = r0 instanceof android.app.PendingIntent
                if (r0 == 0) goto L_0x003d
                java.lang.Object r0 = r6.obj
                r3 = r0
                android.app.PendingIntent r3 = (android.app.PendingIntent) r3
            L_0x003d:
                com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult
                int r6 = r6.arg2
                r0.<init>(r6, r3)
                com.google.android.gms.common.internal.zzd r6 = com.google.android.gms.common.internal.zzd.this
                com.google.android.gms.common.internal.zzd$zzf r6 = r6.zzaqz
                r6.zzh(r0)
                com.google.android.gms.common.internal.zzd r6 = com.google.android.gms.common.internal.zzd.this
                r6.onConnectionFailed(r0)
                return
            L_0x0053:
                int r0 = r6.what
                r2 = 4
                if (r0 != r2) goto L_0x007d
                com.google.android.gms.common.internal.zzd r0 = com.google.android.gms.common.internal.zzd.this
                r0.zzb(r2, r3)
                com.google.android.gms.common.internal.zzd r0 = com.google.android.gms.common.internal.zzd.this
                com.google.android.gms.common.internal.zzd$zzb r0 = r0.zzaqE
                if (r0 == 0) goto L_0x0070
                com.google.android.gms.common.internal.zzd r0 = com.google.android.gms.common.internal.zzd.this
                com.google.android.gms.common.internal.zzd$zzb r0 = r0.zzaqE
                int r4 = r6.arg2
                r0.onConnectionSuspended(r4)
            L_0x0070:
                com.google.android.gms.common.internal.zzd r0 = com.google.android.gms.common.internal.zzd.this
                int r6 = r6.arg2
                r0.onConnectionSuspended(r6)
                com.google.android.gms.common.internal.zzd r6 = com.google.android.gms.common.internal.zzd.this
                boolean unused = r6.zza((int) r2, (int) r1, r3)
                return
            L_0x007d:
                int r0 = r6.what
                r1 = 2
                if (r0 != r1) goto L_0x008e
                com.google.android.gms.common.internal.zzd r0 = com.google.android.gms.common.internal.zzd.this
                boolean r0 = r0.isConnected()
                if (r0 != 0) goto L_0x008e
                r5.zza(r6)
                return
            L_0x008e:
                boolean r0 = r5.zzb(r6)
                if (r0 == 0) goto L_0x009c
                java.lang.Object r6 = r6.obj
                com.google.android.gms.common.internal.zzd$zze r6 = (com.google.android.gms.common.internal.zzd.zze) r6
                r6.zztr()
                return
            L_0x009c:
                int r6 = r6.what
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = 45
                r0.<init>(r1)
                java.lang.String r1 = "Don't know how to handle message: "
                r0.append(r1)
                r0.append(r6)
                java.lang.String r6 = r0.toString()
                java.lang.Exception r0 = new java.lang.Exception
                r0.<init>()
                java.lang.String r1 = "GmsClient"
                android.util.Log.wtf(r1, r6, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzd.C0003zzd.handleMessage(android.os.Message):void");
        }
    }

    protected abstract class zze<TListener> {
        private TListener mListener;
        private boolean zzaqM = false;

        public zze(TListener tlistener) {
            this.mListener = tlistener;
        }

        public void unregister() {
            zzts();
            synchronized (zzd.this.zzaqB) {
                zzd.this.zzaqB.remove(this);
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zztq();

        public void zztr() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.mListener;
                if (this.zzaqM) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            }
            if (tlistener != null) {
                try {
                    zzw(tlistener);
                } catch (RuntimeException e) {
                    zztq();
                    throw e;
                }
            } else {
                zztq();
            }
            synchronized (this) {
                this.zzaqM = true;
            }
            unregister();
        }

        public void zzts() {
            synchronized (this) {
                this.mListener = null;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzw(TListener tlistener);
    }

    public interface zzf {
        void zzh(@NonNull ConnectionResult connectionResult);
    }

    public static final class zzg extends zzt.zza {
        private zzd zzaqN;
        private final int zzaqO;

        public zzg(@NonNull zzd zzd, int i) {
            this.zzaqN = zzd;
            this.zzaqO = i;
        }

        private void zztt() {
            this.zzaqN = null;
        }

        @BinderThread
        public void zza(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
            zzaa.zzb(this.zzaqN, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.zzaqN.zza(i, iBinder, bundle, this.zzaqO);
            zztt();
        }

        @BinderThread
        public void zzb(int i, @Nullable Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }
    }

    public final class zzh implements ServiceConnection {
        private final int zzaqO;

        public zzh(int i) {
            this.zzaqO = i;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zzaa.zzb(iBinder, (Object) "Expecting a valid IBinder");
            synchronized (zzd.this.zzaqx) {
                zzu unused = zzd.this.zzaqy = zzu.zza.zzaW(iBinder);
            }
            zzd.this.zza(0, (Bundle) null, this.zzaqO);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (zzd.this.zzaqx) {
                zzu unused = zzd.this.zzaqy = null;
            }
            zzd.this.mHandler.sendMessage(zzd.this.mHandler.obtainMessage(4, this.zzaqO, 1));
        }
    }

    protected class zzi implements zzf {
        public zzi() {
        }

        public void zzh(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                zzd zzd = zzd.this;
                zzd.zza((zzq) null, zzd.zzto());
            } else if (zzd.this.zzaqF != null) {
                zzd.this.zzaqF.onConnectionFailed(connectionResult);
            }
        }
    }

    protected final class zzj extends zza {
        public final IBinder zzaqP;

        @BinderThread
        public zzj(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.zzaqP = iBinder;
        }

        /* access modifiers changed from: protected */
        public void zzl(ConnectionResult connectionResult) {
            if (zzd.this.zzaqF != null) {
                zzd.this.zzaqF.onConnectionFailed(connectionResult);
            }
            zzd.this.onConnectionFailed(connectionResult);
        }

        /* access modifiers changed from: protected */
        public boolean zztp() {
            try {
                String interfaceDescriptor = this.zzaqP.getInterfaceDescriptor();
                if (!zzd.this.zzhU().equals(interfaceDescriptor)) {
                    String valueOf = String.valueOf(zzd.this.zzhU());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(valueOf);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface zzab = zzd.this.zzab(this.zzaqP);
                if (zzab == null || !zzd.this.zza(2, 3, zzab)) {
                    return false;
                }
                Bundle zzqr = zzd.this.zzqr();
                if (zzd.this.zzaqE == null) {
                    return true;
                }
                zzd.this.zzaqE.onConnected(zzqr);
                return true;
            } catch (RemoteException unused) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    protected final class zzk extends zza {
        @BinderThread
        public zzk(int i, Bundle bundle) {
            super(i, bundle);
        }

        /* access modifiers changed from: protected */
        public void zzl(ConnectionResult connectionResult) {
            zzd.this.zzaqz.zzh(connectionResult);
            zzd.this.onConnectionFailed(connectionResult);
        }

        /* access modifiers changed from: protected */
        public boolean zztp() {
            zzd.this.zzaqz.zzh(ConnectionResult.zzakj);
            return true;
        }
    }

    protected zzd(Context context, Looper looper, int i, zzb zzb2, zzc zzc2, String str) {
        this(context, looper, zzm.zzav(context), com.google.android.gms.common.zzc.zzqV(), i, (zzb) zzaa.zzz(zzb2), (zzc) zzaa.zzz(zzc2), str);
    }

    protected zzd(Context context, Looper looper, zzm zzm, com.google.android.gms.common.zzc zzc2, int i, zzb zzb2, zzc zzc3, String str) {
        this.zzpp = new Object();
        this.zzaqx = new Object();
        this.zzaqB = new ArrayList<>();
        this.zzaqD = 1;
        this.zzaqI = new AtomicInteger(0);
        this.mContext = (Context) zzaa.zzb(context, (Object) "Context must not be null");
        this.zzakW = (Looper) zzaa.zzb(looper, (Object) "Looper must not be null");
        this.zzaqw = (zzm) zzaa.zzb(zzm, (Object) "Supervisor must not be null");
        this.zzamE = (com.google.android.gms.common.zzc) zzaa.zzb(zzc2, (Object) "API availability must not be null");
        this.mHandler = new C0003zzd(looper);
        this.zzaqG = i;
        this.zzaqE = zzb2;
        this.zzaqF = zzc3;
        this.zzaqH = str;
    }

    /* access modifiers changed from: private */
    public boolean zza(int i, int i2, T t) {
        synchronized (this.zzpp) {
            if (this.zzaqD != i) {
                return false;
            }
            zzb(i2, t);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void zzb(int i, T t) {
        boolean z = false;
        if ((i == 3) == (t != null)) {
            z = true;
        }
        zzaa.zzaj(z);
        synchronized (this.zzpp) {
            this.zzaqD = i;
            this.zzaqA = t;
            zzc(i, t);
            if (i == 1) {
                zzti();
            } else if (i == 2) {
                zzth();
            } else if (i == 3) {
                zza(t);
            }
        }
    }

    private void zzth() {
        if (this.zzaqC != null) {
            String valueOf = String.valueOf(zzhT());
            String valueOf2 = String.valueOf(zztf());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 70 + String.valueOf(valueOf2).length());
            sb.append("Calling connect() while still connected, missing disconnect() for ");
            sb.append(valueOf);
            sb.append(" on ");
            sb.append(valueOf2);
            Log.e("GmsClient", sb.toString());
            this.zzaqw.zzb(zzhT(), zztf(), this.zzaqC, zztg());
            this.zzaqI.incrementAndGet();
        }
        this.zzaqC = new zzh(this.zzaqI.get());
        if (!this.zzaqw.zza(zzhT(), zztf(), this.zzaqC, zztg())) {
            String valueOf3 = String.valueOf(zzhT());
            String valueOf4 = String.valueOf(zztf());
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf3).length() + 34 + String.valueOf(valueOf4).length());
            sb2.append("unable to connect to service: ");
            sb2.append(valueOf3);
            sb2.append(" on ");
            sb2.append(valueOf4);
            Log.e("GmsClient", sb2.toString());
            zza(16, (Bundle) null, this.zzaqI.get());
        }
    }

    private void zzti() {
        if (this.zzaqC != null) {
            this.zzaqw.zzb(zzhT(), zztf(), this.zzaqC, zztg());
            this.zzaqC = null;
        }
    }

    public void disconnect() {
        this.zzaqI.incrementAndGet();
        synchronized (this.zzaqB) {
            int size = this.zzaqB.size();
            for (int i = 0; i < size; i++) {
                this.zzaqB.get(i).zzts();
            }
            this.zzaqB.clear();
        }
        synchronized (this.zzaqx) {
            this.zzaqy = null;
        }
        zzb(1, (IInterface) null);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        synchronized (this.zzpp) {
            i = this.zzaqD;
            t = this.zzaqA;
        }
        printWriter.append(str).append("mConnectState=");
        printWriter.print(i != 1 ? i != 2 ? i != 3 ? i != 4 ? "UNKNOWN" : "DISCONNECTING" : "CONNECTED" : "CONNECTING" : "DISCONNECTED");
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.println("null");
        } else {
            printWriter.append(zzhU()).append("@").println(Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzaqt > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j = this.zzaqt;
            String valueOf = String.valueOf(simpleDateFormat.format(new Date(j)));
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21);
            sb.append(j);
            sb.append(" ");
            sb.append(valueOf);
            append.println(sb.toString());
        }
        if (this.zzaqs > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            int i2 = this.zzaqr;
            printWriter.append(i2 != 1 ? i2 != 2 ? String.valueOf(i2) : "CAUSE_NETWORK_LOST" : "CAUSE_SERVICE_DISCONNECTED");
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.zzaqs;
            String valueOf2 = String.valueOf(simpleDateFormat.format(new Date(j2)));
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 21);
            sb2.append(j2);
            sb2.append(" ");
            sb2.append(valueOf2);
            append2.println(sb2.toString());
        }
        if (this.zzaqv > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzaqu));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.zzaqv;
            String valueOf3 = String.valueOf(simpleDateFormat.format(new Date(j3)));
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 21);
            sb3.append(j3);
            sb3.append(" ");
            sb3.append(valueOf3);
            append3.println(sb3.toString());
        }
    }

    public Account getAccount() {
        return null;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzakW;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.zzpp) {
            z = this.zzaqD == 3;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzpp) {
            z = this.zzaqD == 2;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzaqu = connectionResult.getErrorCode();
        this.zzaqv = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onConnectionSuspended(int i) {
        this.zzaqr = i;
        this.zzaqs = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void zza(int i, @Nullable Bundle bundle, int i2) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(5, i2, -1, new zzk(i, bundle)));
    }

    /* access modifiers changed from: protected */
    @BinderThread
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, new zzj(i, iBinder, bundle)));
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void zza(@NonNull T t) {
        this.zzaqt = System.currentTimeMillis();
    }

    public void zza(@NonNull zzf zzf2) {
        this.zzaqz = (zzf) zzaa.zzb(zzf2, (Object) "Connection progress callbacks cannot be null.");
        zzb(2, (IInterface) null);
    }

    @WorkerThread
    public void zza(zzq zzq, Set<Scope> set) {
        try {
            GetServiceRequest zzl = new GetServiceRequest(this.zzaqG).zzdf(this.mContext.getPackageName()).zzl(zzoO());
            if (set != null) {
                zzl.zzd(set);
            }
            if (zzpd()) {
                zzl.zzc(zztk()).zzb(zzq);
            } else if (zztn()) {
                zzl.zzc(getAccount());
            }
            synchronized (this.zzaqx) {
                if (this.zzaqy != null) {
                    this.zzaqy.zza((zzt) new zzg(this, this.zzaqI.get()), zzl);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException unused) {
            Log.w("GmsClient", "service died");
            zzbZ(1);
        } catch (RemoteException e) {
            Log.w("GmsClient", "Remote exception occurred", e);
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract T zzab(IBinder iBinder);

    public void zzbZ(int i) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(4, this.zzaqI.get(), i));
    }

    /* access modifiers changed from: package-private */
    public void zzc(int i, T t) {
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract String zzhT();

    /* access modifiers changed from: protected */
    @NonNull
    public abstract String zzhU();

    /* access modifiers changed from: protected */
    public Bundle zzoO() {
        return new Bundle();
    }

    public boolean zzpd() {
        return false;
    }

    public boolean zzps() {
        return false;
    }

    public Intent zzpt() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public Bundle zzqr() {
        return null;
    }

    public boolean zzrg() {
        return true;
    }

    @Nullable
    public IBinder zzrh() {
        synchronized (this.zzaqx) {
            if (this.zzaqy == null) {
                return null;
            }
            IBinder asBinder = this.zzaqy.asBinder();
            return asBinder;
        }
    }

    /* access modifiers changed from: protected */
    public String zztf() {
        return "com.google.android.gms";
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zztg() {
        String str = this.zzaqH;
        return str == null ? this.mContext.getClass().getName() : str;
    }

    public void zztj() {
        int isGooglePlayServicesAvailable = this.zzamE.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            zzb(1, (IInterface) null);
            this.zzaqz = new zzi();
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(3, this.zzaqI.get(), isGooglePlayServicesAvailable));
            return;
        }
        zza((zzf) new zzi());
    }

    public final Account zztk() {
        return getAccount() != null ? getAccount() : new Account("<<default account>>", "com.google");
    }

    /* access modifiers changed from: protected */
    public final void zztl() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T zztm() throws DeadObjectException {
        T t;
        synchronized (this.zzpp) {
            if (this.zzaqD != 4) {
                zztl();
                zzaa.zza(this.zzaqA != null, (Object) "Client is connected but service is null");
                t = this.zzaqA;
            } else {
                throw new DeadObjectException();
            }
        }
        return t;
    }

    public boolean zztn() {
        return false;
    }

    /* access modifiers changed from: protected */
    public Set<Scope> zzto() {
        return Collections.EMPTY_SET;
    }
}
