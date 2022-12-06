package com.google.android.gms.internal;

import android.os.RemoteException;

public abstract class zzsd<T> {
    private final int zzwP;
    private final String zzwQ;
    private final T zzwR;

    public static class zza extends zzsd<Boolean> {
        public zza(int i, String str, Boolean bool) {
            super(i, str, bool);
        }

        /* renamed from: zzb */
        public Boolean zza(zzsg zzsg) {
            try {
                return Boolean.valueOf(zzsg.getBooleanFlagValue(getKey(), ((Boolean) zzeq()).booleanValue(), getSource()));
            } catch (RemoteException unused) {
                return (Boolean) zzeq();
            }
        }
    }

    public static class zzb extends zzsd<Integer> {
        public zzb(int i, String str, Integer num) {
            super(i, str, num);
        }

        /* renamed from: zzc */
        public Integer zza(zzsg zzsg) {
            try {
                return Integer.valueOf(zzsg.getIntFlagValue(getKey(), ((Integer) zzeq()).intValue(), getSource()));
            } catch (RemoteException unused) {
                return (Integer) zzeq();
            }
        }
    }

    public static class zzc extends zzsd<Long> {
        public zzc(int i, String str, Long l) {
            super(i, str, l);
        }

        /* renamed from: zzd */
        public Long zza(zzsg zzsg) {
            try {
                return Long.valueOf(zzsg.getLongFlagValue(getKey(), ((Long) zzeq()).longValue(), getSource()));
            } catch (RemoteException unused) {
                return (Long) zzeq();
            }
        }
    }

    public static class zzd extends zzsd<String> {
        public zzd(int i, String str, String str2) {
            super(i, str, str2);
        }

        /* renamed from: zze */
        public String zza(zzsg zzsg) {
            try {
                return zzsg.getStringFlagValue(getKey(), (String) zzeq(), getSource());
            } catch (RemoteException unused) {
                return (String) zzeq();
            }
        }
    }

    private zzsd(int i, String str, T t) {
        this.zzwP = i;
        this.zzwQ = str;
        this.zzwR = t;
        zzsh.zzyE().zza(this);
    }

    public static zza zzb(int i, String str, Boolean bool) {
        return new zza(i, str, bool);
    }

    public static zzb zzb(int i, String str, int i2) {
        return new zzb(i, str, Integer.valueOf(i2));
    }

    public static zzc zzb(int i, String str, long j) {
        return new zzc(i, str, Long.valueOf(j));
    }

    public static zzd zzc(int i, String str, String str2) {
        return new zzd(i, str, str2);
    }

    public T get() {
        return zzsh.zzyF().zzb(this);
    }

    public String getKey() {
        return this.zzwQ;
    }

    public int getSource() {
        return this.zzwP;
    }

    /* access modifiers changed from: protected */
    public abstract T zza(zzsg zzsg);

    public T zzeq() {
        return this.zzwR;
    }
}
