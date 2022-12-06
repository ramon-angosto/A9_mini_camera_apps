package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgra;
import com.google.android.gms.internal.ads.zzgre;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzgra<MessageType extends zzgre<MessageType, BuilderType>, BuilderType extends zzgra<MessageType, BuilderType>> extends zzgpe<MessageType, BuilderType> {
    protected zzgre zza;
    protected boolean zzb = false;
    private final zzgre zzc;

    protected zzgra(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (zzgre) messagetype.zzb(4, (Object) null, (Object) null);
    }

    private static final void zza(zzgre zzgre, zzgre zzgre2) {
        zzgsw.zza().zzb(zzgre.getClass()).zzg(zzgre, zzgre2);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzgpe zzah(zzgpf zzgpf) {
        zzak((zzgre) zzgpf);
        return this;
    }

    /* renamed from: zzaj */
    public final zzgra zzag() {
        zzgra zzgra = (zzgra) this.zzc.zzb(5, (Object) null, (Object) null);
        zzgra.zzak(zzao());
        return zzgra;
    }

    public final zzgra zzak(zzgre zzgre) {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        zza(this.zza, zzgre);
        return this;
    }

    public final zzgra zzal(byte[] bArr, int i, int i2, zzgqq zzgqq) throws zzgrq {
        if (this.zzb) {
            zzaq();
            this.zzb = false;
        }
        try {
            zzgsw.zza().zzb(this.zza.getClass()).zzi(this.zza, bArr, 0, i2, new zzgpi(zzgqq));
            return this;
        } catch (zzgrq e) {
            throw e;
        } catch (IndexOutOfBoundsException unused) {
            throw zzgrq.zzj();
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        }
    }

    public final MessageType zzam() {
        MessageType zzan = zzao();
        if (zzan.zzaS()) {
            return zzan;
        }
        throw new zzgtx(zzan);
    }

    /* renamed from: zzan */
    public MessageType zzao() {
        if (this.zzb) {
            return this.zza;
        }
        zzgre zzgre = this.zza;
        zzgsw.zza().zzb(zzgre.getClass()).zzf(zzgre);
        this.zzb = true;
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public void zzaq() {
        zzgre zzgre = (zzgre) this.zza.zzb(4, (Object) null, (Object) null);
        zza(zzgre, this.zza);
        this.zza = zzgre;
    }

    public final /* synthetic */ zzgso zzbh() {
        return this.zzc;
    }
}
