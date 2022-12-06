package com.google.android.gms.internal.ads;

import android.media.AudioTimestamp;
import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzatx extends zzatw {
    private final AudioTimestamp zzb = new AudioTimestamp();
    private long zzc;
    private long zzd;
    private long zze;

    public zzatx() {
        super((zzatv) null);
    }

    public final long zzc() {
        return this.zze;
    }

    public final long zzd() {
        return this.zzb.nanoTime;
    }

    public final void zzg(AudioTrack audioTrack, boolean z) {
        super.zzg(audioTrack, z);
        this.zzc = 0;
        this.zzd = 0;
        this.zze = 0;
    }

    public final boolean zzh() {
        boolean timestamp = this.zza.getTimestamp(this.zzb);
        if (timestamp) {
            long j = this.zzb.framePosition;
            if (this.zzd > j) {
                this.zzc++;
            }
            this.zzd = j;
            this.zze = j + (this.zzc << 32);
        }
        return timestamp;
    }
}
