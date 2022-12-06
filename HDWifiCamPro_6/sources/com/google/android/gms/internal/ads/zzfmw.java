package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzfmw implements Continuation {
    public final /* synthetic */ zzalw zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzfmw(zzalw zzalw, int i) {
        this.zza = zzalw;
        this.zzb = i;
    }

    public final Object then(Task task) {
        zzalw zzalw = this.zza;
        int i = this.zzb;
        int i2 = zzfmx.zza;
        if (!task.isSuccessful()) {
            return false;
        }
        zzfoy zza2 = ((zzfoz) task.getResult()).zza(((zzama) zzalw.zzam()).zzax());
        zza2.zza(i);
        zza2.zzc();
        return true;
    }
}
