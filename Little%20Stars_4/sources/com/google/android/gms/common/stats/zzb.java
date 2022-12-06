package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.stats.zzc;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzt;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class zzb {
    private static final Object zzarP = new Object();
    private static zzb zzatn;
    private static Integer zzatt;
    private final List<String> zzato;
    private final List<String> zzatp;
    private final List<String> zzatq;
    private final List<String> zzatr;
    private zze zzats;
    private zze zzatu;

    private zzb() {
        if (getLogLevel() == zzd.LOG_LEVEL_OFF) {
            this.zzato = Collections.EMPTY_LIST;
            this.zzatp = Collections.EMPTY_LIST;
            this.zzatq = Collections.EMPTY_LIST;
            this.zzatr = Collections.EMPTY_LIST;
            return;
        }
        String str = zzc.zza.zzaty.get();
        this.zzato = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(Constants.ACCEPT_TIME_SEPARATOR_SP));
        String str2 = zzc.zza.zzatz.get();
        this.zzatp = str2 == null ? Collections.EMPTY_LIST : Arrays.asList(str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP));
        String str3 = zzc.zza.zzatA.get();
        this.zzatq = str3 == null ? Collections.EMPTY_LIST : Arrays.asList(str3.split(Constants.ACCEPT_TIME_SEPARATOR_SP));
        String str4 = zzc.zza.zzatB.get();
        this.zzatr = str4 == null ? Collections.EMPTY_LIST : Arrays.asList(str4.split(Constants.ACCEPT_TIME_SEPARATOR_SP));
        this.zzats = new zze(1024, zzc.zza.zzatC.get().longValue());
        this.zzatu = new zze(1024, zzc.zza.zzatC.get().longValue());
    }

    private static int getLogLevel() {
        if (zzatt == null) {
            try {
                zzatt = Integer.valueOf(zzd.zzmW() ? zzc.zza.zzatx.get().intValue() : zzd.LOG_LEVEL_OFF);
            } catch (SecurityException unused) {
                zzatt = Integer.valueOf(zzd.LOG_LEVEL_OFF);
            }
        }
        return zzatt.intValue();
    }

    private static String zza(StackTraceElement[] stackTraceElementArr, int i) {
        int i2 = i + 4;
        if (i2 >= stackTraceElementArr.length) {
            return "<bottom of call stack>";
        }
        StackTraceElement stackTraceElement = stackTraceElementArr[i2];
        String valueOf = String.valueOf(stackTraceElement.getClassName());
        String valueOf2 = String.valueOf(stackTraceElement.getMethodName());
        int lineNumber = stackTraceElement.getLineNumber();
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 13 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append(".");
        sb.append(valueOf2);
        sb.append(":");
        sb.append(lineNumber);
        return sb.toString();
    }

    private void zza(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        int i2 = i;
        long currentTimeMillis = System.currentTimeMillis();
        String zzn = ((getLogLevel() & zzd.zzatH) == 0 || i2 == 13) ? null : zzn(3, 5);
        long j = 0;
        if ((getLogLevel() & zzd.zzatJ) != 0) {
            j = Debug.getNativeHeapAllocatedSize();
        }
        long j2 = j;
        context.startService(new Intent().setComponent(zzd.zzatD).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", (i2 == 1 || i2 == 4 || i2 == 14) ? new ConnectionEvent(currentTimeMillis, i, (String) null, (String) null, (String) null, (String) null, zzn, str, SystemClock.elapsedRealtime(), j2) : new ConnectionEvent(currentTimeMillis, i, str2, str3, str4, str5, zzn, str, SystemClock.elapsedRealtime(), j2)));
    }

    private void zza(Context context, String str, String str2, Intent intent, int i) {
        String str3;
        String str4;
        String str5;
        if (zzuI() && this.zzats != null) {
            if (i != 4 && i != 1) {
                ServiceInfo zzd = zzd(context, intent);
                if (zzd == null) {
                    Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[]{str2, intent.toUri(0)}));
                    return;
                }
                String str6 = zzd.processName;
                String str7 = zzd.name;
                String zzvi = zzt.zzvi();
                if (zzb(zzvi, str2, str6, str7)) {
                    this.zzats.zzdr(str);
                    str4 = str6;
                    str5 = zzvi;
                    str3 = str7;
                } else {
                    return;
                }
            } else if (this.zzats.zzds(str)) {
                str5 = null;
                str4 = null;
                str3 = null;
            } else {
                return;
            }
            zza(context, str, i, str5, str2, str4, str3);
        }
    }

    private String zzb(ServiceConnection serviceConnection) {
        return String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(serviceConnection)));
    }

    private boolean zzb(String str, String str2, String str3, String str4) {
        int logLevel = getLogLevel();
        if (this.zzato.contains(str) || this.zzatp.contains(str2) || this.zzatq.contains(str3) || this.zzatr.contains(str4)) {
            return false;
        }
        return !str3.equals(str) || (zzd.zzatI & logLevel) == 0;
    }

    private boolean zzc(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            return zzd.zzm(context, component.getPackageName());
        }
        return false;
    }

    private static ServiceInfo zzd(Context context, Intent intent) {
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), zzn(3, 20)}));
            return null;
        } else if (queryIntentServices.size() <= 1) {
            return queryIntentServices.get(0).serviceInfo;
        } else {
            Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), zzn(3, 20)}));
            for (ResolveInfo resolveInfo : queryIntentServices) {
                Log.w("ConnectionTracker", resolveInfo.serviceInfo.name);
            }
            return null;
        }
    }

    private static String zzn(int i, int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + i;
        while (i < i3) {
            stringBuffer.append(zza(stackTrace, i));
            stringBuffer.append(" ");
            i++;
        }
        return stringBuffer.toString();
    }

    public static zzb zzuH() {
        synchronized (zzarP) {
            if (zzatn == null) {
                zzatn = new zzb();
            }
        }
        return zzatn;
    }

    private boolean zzuI() {
        return false;
    }

    @SuppressLint({"UntrackedBindService"})
    public void zza(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        zza(context, zzb(serviceConnection), (String) null, (Intent) null, 1);
    }

    public void zza(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
        zza(context, zzb(serviceConnection), str, intent, 3);
    }

    public boolean zza(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return zza(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    public boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (zzc(context, intent)) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        if (bindService) {
            zza(context, zzb(serviceConnection), str, intent, 2);
        }
        return bindService;
    }

    public void zzb(Context context, ServiceConnection serviceConnection) {
        zza(context, zzb(serviceConnection), (String) null, (Intent) null, 4);
    }
}
