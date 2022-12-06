package com.google.android.gms.internal;

public abstract class zzpg<T> {
    private static zza zzaoQ = null;
    private static int zzaoR = 0;
    private static String zzaoS = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    private static final Object zzrs = new Object();
    private T zzaoT = null;
    protected final String zzwQ;
    protected final T zzwR;

    private interface zza {
        Long getLong(String str, Long l);

        String getString(String str, String str2);

        Boolean zza(String str, Boolean bool);

        Float zzb(String str, Float f);

        Integer zzb(String str, Integer num);
    }

    protected zzpg(String str, T t) {
        this.zzwQ = str;
        this.zzwR = t;
    }

    public static zzpg<Float> zza(String str, Float f) {
        return new zzpg<Float>(str, f) {
            /* access modifiers changed from: protected */
            /* renamed from: zzcW */
            public Float zzcS(String str) {
                return zzpg.zzsN().zzb(this.zzwQ, (Float) this.zzwR);
            }
        };
    }

    public static zzpg<Integer> zza(String str, Integer num) {
        return new zzpg<Integer>(str, num) {
            /* access modifiers changed from: protected */
            /* renamed from: zzcV */
            public Integer zzcS(String str) {
                return zzpg.zzsN().zzb(this.zzwQ, (Integer) this.zzwR);
            }
        };
    }

    public static zzpg<Long> zza(String str, Long l) {
        return new zzpg<Long>(str, l) {
            /* access modifiers changed from: protected */
            /* renamed from: zzcU */
            public Long zzcS(String str) {
                return zzpg.zzsN().getLong(this.zzwQ, (Long) this.zzwR);
            }
        };
    }

    public static zzpg<Boolean> zzl(String str, boolean z) {
        return new zzpg<Boolean>(str, Boolean.valueOf(z)) {
            /* access modifiers changed from: protected */
            /* renamed from: zzcT */
            public Boolean zzcS(String str) {
                return zzpg.zzsN().zza(this.zzwQ, (Boolean) this.zzwR);
            }
        };
    }

    static /* synthetic */ zza zzsN() {
        return null;
    }

    public static zzpg<String> zzz(String str, String str2) {
        return new zzpg<String>(str, str2) {
            /* access modifiers changed from: protected */
            /* renamed from: zzcX */
            public String zzcS(String str) {
                return zzpg.zzsN().getString(this.zzwQ, (String) this.zzwR);
            }
        };
    }

    public final T get() {
        return zzcS(this.zzwQ);
    }

    /* access modifiers changed from: protected */
    public abstract T zzcS(String str);
}
