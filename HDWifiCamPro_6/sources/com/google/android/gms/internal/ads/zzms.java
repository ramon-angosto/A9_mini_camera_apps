package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzms implements zzko {
    private final zzde zza;
    private final zzck zzb;
    private final zzcm zzc;
    private final zzmr zzd;
    private final SparseArray zze;
    private zzdt zzf;
    private zzcg zzg;
    private zzdn zzh;
    private boolean zzi;

    public static /* synthetic */ void zzW(zzms zzms) {
        zzkp zzU = zzms.zzU();
        zzms.zzZ(zzU, IronSourceError.ERROR_RV_LOAD_SUCCESS_UNEXPECTED, new zzlo(zzU));
        zzms.zzf.zze();
    }

    private final zzkp zzab(int i, zzsi zzsi) {
        zzcg zzcg = this.zzg;
        if (zzcg == null) {
            throw null;
        } else if (zzsi == null) {
            zzcn zzn = zzcg.zzn();
            if (i >= zzn.zzc()) {
                zzn = zzcn.zza;
            }
            return zzV(zzn, i, (zzsi) null);
        } else if (this.zzd.zza(zzsi) != null) {
            return zzaa(zzsi);
        } else {
            return zzV(zzcn.zza, i, zzsi);
        }
    }

    private final zzkp zzac() {
        return zzaa(this.zzd.zzd());
    }

    private final zzkp zzad() {
        return zzaa(this.zzd.zze());
    }

    private final zzkp zzae(zzbw zzbw) {
        zzbn zzbn;
        if (!(zzbw instanceof zzha) || (zzbn = ((zzha) zzbw).zzj) == null) {
            return zzU();
        }
        return zzaa(new zzsi(zzbn));
    }

    public final void zzA(String str) {
        zzkp zzad = zzad();
        zzZ(zzad, PointerIconCompat.TYPE_NO_DROP, new zzmq(zzad, str));
    }

    public final void zzB(zzgs zzgs) {
        zzkp zzac = zzac();
        zzZ(zzac, PointerIconCompat.TYPE_ALL_SCROLL, new zzmg(zzac, zzgs));
    }

    public final void zzC(zzgs zzgs) {
        zzkp zzad = zzad();
        zzZ(zzad, 1007, new zzlv(zzad, zzgs));
    }

    public final void zzD(zzaf zzaf, zzgt zzgt) {
        zzkp zzad = zzad();
        zzZ(zzad, PointerIconCompat.TYPE_VERTICAL_TEXT, new zzmf(zzad, zzaf, zzgt));
    }

    public final void zzE(long j) {
        zzkp zzad = zzad();
        zzZ(zzad, 1010, new zzmi(zzad, j));
    }

    public final void zzF(Exception exc) {
        zzkp zzad = zzad();
        zzZ(zzad, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, new zzld(zzad, exc));
    }

    public final void zzG(int i, long j, long j2) {
        zzkp zzad = zzad();
        zzZ(zzad, 1011, new zzkv(zzad, i, j, j2));
    }

    public final void zzH(int i, long j) {
        zzkp zzac = zzac();
        zzZ(zzac, PointerIconCompat.TYPE_ZOOM_IN, new zzlq(zzac, i, j));
    }

    public final void zzI(Object obj, long j) {
        zzkp zzad = zzad();
        zzZ(zzad, 26, new zzmm(zzad, obj, j));
    }

    public final void zzJ(Exception exc) {
        zzkp zzad = zzad();
        zzZ(zzad, IronSourceError.ERROR_RV_LOAD_FAIL_UNEXPECTED, new zzlb(zzad, exc));
    }

    public final void zzK(String str, long j, long j2) {
        zzkp zzad = zzad();
        zzZ(zzad, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, new zzlm(zzad, str, j2, j));
    }

    public final void zzL(String str) {
        zzkp zzad = zzad();
        zzZ(zzad, PointerIconCompat.TYPE_ZOOM_OUT, new zzku(zzad, str));
    }

    public final void zzM(zzgs zzgs) {
        zzkp zzac = zzac();
        zzZ(zzac, 1020, new zzml(zzac, zzgs));
    }

    public final void zzN(zzgs zzgs) {
        zzkp zzad = zzad();
        zzZ(zzad, 1015, new zzlr(zzad, zzgs));
    }

    public final void zzO(long j, int i) {
        zzkp zzac = zzac();
        zzZ(zzac, 1021, new zzle(zzac, j, i));
    }

    public final void zzP(zzaf zzaf, zzgt zzgt) {
        zzkp zzad = zzad();
        zzZ(zzad, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, new zzkt(zzad, zzaf, zzgt));
    }

    public final void zzQ() {
        zzdn zzdn = this.zzh;
        zzdd.zzb(zzdn);
        zzdn.zzg(new zzmh(this));
    }

    public final void zzR(zzkr zzkr) {
        this.zzf.zzf(zzkr);
    }

    public final void zzS(zzcg zzcg, Looper looper) {
        boolean z = true;
        if (this.zzg != null && !this.zzd.zzb.isEmpty()) {
            z = false;
        }
        zzdd.zzf(z);
        if (zzcg != null) {
            this.zzg = zzcg;
            this.zzh = this.zza.zzb(looper, (Handler.Callback) null);
            this.zzf = this.zzf.zza(looper, new zzll(this, zzcg));
            return;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public final zzkp zzU() {
        return zzaa(this.zzd.zzb());
    }

    /* access modifiers changed from: protected */
    @RequiresNonNull({"player"})
    public final zzkp zzV(zzcn zzcn, int i, zzsi zzsi) {
        zzcn zzcn2 = zzcn;
        int i2 = i;
        zzsi zzsi2 = true == zzcn.zzo() ? null : zzsi;
        long zza2 = this.zza.zza();
        boolean z = false;
        if (zzcn2.equals(this.zzg.zzn()) && i2 == this.zzg.zzf()) {
            z = true;
        }
        long j = 0;
        if (zzsi2 == null || !zzsi2.zzb()) {
            if (z) {
                j = this.zzg.zzk();
            } else if (!zzcn.zzo()) {
                long j2 = zzcn2.zze(i2, this.zzc, 0).zzm;
                j = zzen.zzz(0);
            }
        } else if (z && this.zzg.zzd() == zzsi2.zzb && this.zzg.zze() == zzsi2.zzc) {
            j = this.zzg.zzl();
        }
        return new zzkp(zza2, zzcn, i, zzsi2, j, this.zzg.zzn(), this.zzg.zzf(), this.zzd.zzb(), this.zzg.zzl(), this.zzg.zzm());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzX(zzcg zzcg, zzkr zzkr, zzaa zzaa) {
        zzkr.zzi(zzcg, new zzkq(zzaa, this.zze));
    }

    public final void zzY(int i, long j, long j2) {
        zzkp zzaa = zzaa(this.zzd.zzc());
        zzZ(zzaa, 1006, new zzlc(zzaa, i, j, j2));
    }

    /* access modifiers changed from: protected */
    public final void zzZ(zzkp zzkp, int i, zzdq zzdq) {
        this.zze.put(i, zzkp);
        zzdt zzdt = this.zzf;
        zzdt.zzd(i, zzdq);
        zzdt.zzc();
    }

    public final void zza(zzcc zzcc) {
        zzkp zzU = zzU();
        zzZ(zzU, 13, new zzlg(zzU, zzcc));
    }

    public final void zzaf(int i, zzsi zzsi, zzse zzse) {
        zzkp zzab = zzab(i, zzsi);
        zzZ(zzab, 1004, new zzla(zzab, zzse));
    }

    public final void zzag(int i, zzsi zzsi, zzrz zzrz, zzse zzse) {
        zzkp zzab = zzab(i, zzsi);
        zzZ(zzab, 1002, new zzls(zzab, zzrz, zzse));
    }

    public final void zzah(int i, zzsi zzsi, zzrz zzrz, zzse zzse) {
        zzkp zzab = zzab(i, zzsi);
        zzZ(zzab, 1001, new zzmc(zzab, zzrz, zzse));
    }

    public final void zzai(int i, zzsi zzsi, zzrz zzrz, zzse zzse, IOException iOException, boolean z) {
        zzkp zzab = zzab(i, zzsi);
        zzZ(zzab, 1003, new zzln(zzab, zzrz, zzse, iOException, z));
    }

    public final void zzaj(int i, zzsi zzsi, zzrz zzrz, zzse zzse) {
        zzkp zzab = zzab(i, zzsi);
        zzZ(zzab, 1000, new zzlw(zzab, zzrz, zzse));
    }

    public final void zzb(zzt zzt) {
        zzkp zzU = zzU();
        zzZ(zzU, 29, new zzlh(zzU, zzt));
    }

    public final void zzc(int i, boolean z) {
        zzkp zzU = zzU();
        zzZ(zzU, 30, new zzlk(zzU, i, z));
    }

    public final void zzd(boolean z) {
        zzkp zzU = zzU();
        zzZ(zzU, 3, new zzmp(zzU, z));
    }

    public final void zze(boolean z) {
        zzkp zzU = zzU();
        zzZ(zzU, 7, new zzly(zzU, z));
    }

    public final void zzf(zzbg zzbg, int i) {
        zzkp zzU = zzU();
        zzZ(zzU, 1, new zzmb(zzU, zzbg, i));
    }

    public final void zzg(zzbm zzbm) {
        zzkp zzU = zzU();
        zzZ(zzU, 14, new zzme(zzU, zzbm));
    }

    public final void zzh(boolean z, int i) {
        zzkp zzU = zzU();
        zzZ(zzU, 5, new zzlx(zzU, z, i));
    }

    public final void zzi(zzby zzby) {
        zzkp zzU = zzU();
        zzZ(zzU, 12, new zzkx(zzU, zzby));
    }

    public final void zzj(int i) {
        zzkp zzU = zzU();
        zzZ(zzU, 4, new zzma(zzU, i));
    }

    public final void zzk(int i) {
        zzkp zzU = zzU();
        zzZ(zzU, 6, new zzmo(zzU, i));
    }

    public final void zzl(zzbw zzbw) {
        zzkp zzae = zzae(zzbw);
        zzZ(zzae, 10, new zzlt(zzae, zzbw));
    }

    public final void zzm(zzbw zzbw) {
        zzkp zzae = zzae(zzbw);
        zzZ(zzae, 10, new zzmd(zzae, zzbw));
    }

    public final void zzn(boolean z, int i) {
        zzkp zzU = zzU();
        zzZ(zzU, -1, new zzks(zzU, z, i));
    }

    public final void zzp() {
        zzkp zzU = zzU();
        zzZ(zzU, -1, new zzkz(zzU));
    }

    public final void zzq(boolean z) {
        zzkp zzad = zzad();
        zzZ(zzad, 23, new zzlz(zzad, z));
    }

    public final void zzr(int i, int i2) {
        zzkp zzad = zzad();
        zzZ(zzad, 24, new zzmn(zzad, i, i2));
    }

    public final void zzt(zzcy zzcy) {
        zzkp zzU = zzU();
        zzZ(zzU, 2, new zzli(zzU, zzcy));
    }

    public final void zzu(zzda zzda) {
        zzkp zzad = zzad();
        zzZ(zzad, 25, new zzmk(zzad, zzda));
    }

    public final void zzv(float f) {
        zzkp zzad = zzad();
        zzZ(zzad, 22, new zzkw(zzad, f));
    }

    public final void zzw(zzkr zzkr) {
        this.zzf.zzb(zzkr);
    }

    public final void zzx() {
        if (!this.zzi) {
            zzkp zzU = zzU();
            this.zzi = true;
            zzZ(zzU, -1, new zzmj(zzU));
        }
    }

    public final void zzy(Exception exc) {
        zzkp zzad = zzad();
        zzZ(zzad, IronSourceError.ERROR_RV_LOAD_SUCCESS_WRONG_AUCTION_ID, new zzlj(zzad, exc));
    }

    public final void zzz(String str, long j, long j2) {
        zzkp zzad = zzad();
        zzZ(zzad, 1008, new zzlu(zzad, str, j2, j));
    }

    private final zzkp zzaa(zzsi zzsi) {
        zzcn zzcn;
        if (this.zzg != null) {
            if (zzsi == null) {
                zzcn = null;
            } else {
                zzcn = this.zzd.zza(zzsi);
            }
            if (zzsi != null && zzcn != null) {
                return zzV(zzcn, zzcn.zzn(zzsi.zza, this.zzb).zzd, zzsi);
            }
            int zzf2 = this.zzg.zzf();
            zzcn zzn = this.zzg.zzn();
            if (zzf2 >= zzn.zzc()) {
                zzn = zzcn.zza;
            }
            return zzV(zzn, zzf2, (zzsi) null);
        }
        throw null;
    }

    public final void zzT(List list, zzsi zzsi) {
        zzmr zzmr = this.zzd;
        zzcg zzcg = this.zzg;
        if (zzcg != null) {
            zzmr.zzh(list, zzsi, zzcg);
            return;
        }
        throw null;
    }

    public final void zzo(zzcf zzcf, zzcf zzcf2, int i) {
        if (i == 1) {
            this.zzi = false;
            i = 1;
        }
        zzmr zzmr = this.zzd;
        zzcg zzcg = this.zzg;
        if (zzcg != null) {
            zzmr.zzg(zzcg);
            zzkp zzU = zzU();
            zzZ(zzU, 11, new zzlf(zzU, i, zzcf, zzcf2));
            return;
        }
        throw null;
    }

    public final void zzs(zzcn zzcn, int i) {
        zzmr zzmr = this.zzd;
        zzcg zzcg = this.zzg;
        if (zzcg != null) {
            zzmr.zzi(zzcg);
            zzkp zzU = zzU();
            zzZ(zzU, 0, new zzlp(zzU, i));
            return;
        }
        throw null;
    }

    public zzms(zzde zzde) {
        if (zzde != null) {
            this.zza = zzde;
            this.zzf = new zzdt(zzen.zzE(), zzde, zzky.zza);
            this.zzb = new zzck();
            this.zzc = new zzcm();
            this.zzd = new zzmr(this.zzb);
            this.zze = new SparseArray();
            return;
        }
        throw null;
    }
}
