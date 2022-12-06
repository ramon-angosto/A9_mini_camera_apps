package com.google.android.gms.common.stats;

import com.google.android.gms.internal.zzpg;

public final class zzc {
    public static zzpg<Integer> zzatv = zzpg.zza("gms:common:stats:max_num_of_events", (Integer) 100);
    public static zzpg<Integer> zzatw = zzpg.zza("gms:common:stats:max_chunk_size", (Integer) 100);

    public static final class zza {
        public static zzpg<String> zzatA = zzpg.zzz("gms:common:stats:connections:ignored_target_processes", "");
        public static zzpg<String> zzatB = zzpg.zzz("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
        public static zzpg<Long> zzatC = zzpg.zza("gms:common:stats:connections:time_out_duration", (Long) 600000L);
        public static zzpg<Integer> zzatx = zzpg.zza("gms:common:stats:connections:level", Integer.valueOf(zzd.LOG_LEVEL_OFF));
        public static zzpg<String> zzaty = zzpg.zzz("gms:common:stats:connections:ignored_calling_processes", "");
        public static zzpg<String> zzatz = zzpg.zzz("gms:common:stats:connections:ignored_calling_services", "");
    }

    public static final class zzb {
        public static zzpg<Long> zzatC = zzpg.zza("gms:common:stats:wakelocks:time_out_duration", (Long) 600000L);
        public static zzpg<Integer> zzatx = zzpg.zza("gms:common:stats:wakeLocks:level", Integer.valueOf(zzd.LOG_LEVEL_OFF));
    }
}
