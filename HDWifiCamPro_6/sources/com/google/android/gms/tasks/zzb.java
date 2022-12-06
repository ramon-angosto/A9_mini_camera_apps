package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.1 */
final class zzb extends CancellationToken {
    private final zzw<Void> zza = new zzw<>();

    zzb() {
    }

    public final boolean isCancellationRequested() {
        return this.zza.isComplete();
    }

    public final CancellationToken onCanceledRequested(OnTokenCanceledListener onTokenCanceledListener) {
        this.zza.addOnSuccessListener(TaskExecutors.MAIN_THREAD, new zza(this, onTokenCanceledListener));
        return this;
    }

    public final void zza() {
        this.zza.zze(null);
    }
}
