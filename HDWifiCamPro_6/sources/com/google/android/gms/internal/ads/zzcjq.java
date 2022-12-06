package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcjq extends zzcie implements TextureView.SurfaceTextureListener, zzcio {
    private final zzciy zzd;
    private final zzciz zze;
    private final zzcix zzf;
    private zzcid zzg;
    private Surface zzh;
    private zzcip zzi;
    private String zzj;
    private String[] zzk;
    private boolean zzl;
    private int zzm = 1;
    private zzciw zzn;
    private final boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private int zzr;
    private int zzs;
    private float zzt;

    public zzcjq(Context context, zzciz zzciz, zzciy zzciy, boolean z, boolean z2, zzcix zzcix, Integer num) {
        super(context, num);
        this.zzd = zzciy;
        this.zze = zzciz;
        this.zzo = z;
        this.zzf = zzcix;
        setSurfaceTextureListener(this);
        this.zze.zza(this);
    }

    private static String zzS(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        return str + "/" + canonicalName + ":" + message;
    }

    private final void zzT() {
        zzcip zzcip = this.zzi;
        if (zzcip != null) {
            zzcip.zzM(true);
        }
    }

    private final void zzU() {
        if (!this.zzp) {
            this.zzp = true;
            zzs.zza.post(new zzcjk(this));
            zzn();
            this.zze.zzb();
            if (this.zzq) {
                zzp();
            }
        }
    }

    private final void zzV(boolean z) {
        zzcip zzcip = this.zzi;
        if ((zzcip == null || z) && this.zzj != null && this.zzh != null) {
            if (z) {
                if (zzad()) {
                    zzcip.zzQ();
                    zzX();
                } else {
                    zze.zzj("No valid ExoPlayerAdapter exists when switch source.");
                    return;
                }
            }
            if (this.zzj.startsWith("cache:")) {
                zzclb zzr2 = this.zzd.zzr(this.zzj);
                if (zzr2 instanceof zzclk) {
                    this.zzi = ((zzclk) zzr2).zzj();
                    if (!this.zzi.zzR()) {
                        zze.zzj("Precached video player has been released.");
                        return;
                    }
                } else if (zzr2 instanceof zzclh) {
                    zzclh zzclh = (zzclh) zzr2;
                    String zzE = zzE();
                    ByteBuffer zzl2 = zzclh.zzl();
                    boolean zzm2 = zzclh.zzm();
                    String zzi2 = zzclh.zzi();
                    if (zzi2 == null) {
                        zze.zzj("Stream cache URL is null.");
                        return;
                    }
                    this.zzi = zzD();
                    this.zzi.zzD(new Uri[]{Uri.parse(zzi2)}, zzE, zzl2, zzm2);
                } else {
                    zze.zzj("Stream cache miss: ".concat(String.valueOf(this.zzj)));
                    return;
                }
            } else {
                this.zzi = zzD();
                String zzE2 = zzE();
                Uri[] uriArr = new Uri[this.zzk.length];
                int i = 0;
                while (true) {
                    String[] strArr = this.zzk;
                    if (i >= strArr.length) {
                        break;
                    }
                    uriArr[i] = Uri.parse(strArr[i]);
                    i++;
                }
                this.zzi.zzC(uriArr, zzE2);
            }
            this.zzi.zzI(this);
            zzZ(this.zzh, false);
            if (this.zzi.zzR()) {
                int zzt2 = this.zzi.zzt();
                this.zzm = zzt2;
                if (zzt2 == 3) {
                    zzU();
                }
            }
        }
    }

    private final void zzW() {
        zzcip zzcip = this.zzi;
        if (zzcip != null) {
            zzcip.zzM(false);
        }
    }

    private final void zzX() {
        if (this.zzi != null) {
            zzZ((Surface) null, true);
            zzcip zzcip = this.zzi;
            if (zzcip != null) {
                zzcip.zzI((zzcio) null);
                this.zzi.zzE();
                this.zzi = null;
            }
            this.zzm = 1;
            this.zzl = false;
            this.zzp = false;
            this.zzq = false;
        }
    }

    private final void zzY(float f, boolean z) {
        zzcip zzcip = this.zzi;
        if (zzcip != null) {
            try {
                zzcip.zzP(f, false);
            } catch (IOException e) {
                zzcgp.zzk("", e);
            }
        } else {
            zze.zzj("Trying to set volume before player is initialized.");
        }
    }

    private final void zzZ(Surface surface, boolean z) {
        zzcip zzcip = this.zzi;
        if (zzcip != null) {
            try {
                zzcip.zzO(surface, z);
            } catch (IOException e) {
                zzcgp.zzk("", e);
            }
        } else {
            zze.zzj("Trying to set surface before player is initialized.");
        }
    }

    private final void zzaa() {
        zzab(this.zzr, this.zzs);
    }

    private final void zzab(int i, int i2) {
        float f = i2 > 0 ? ((float) i) / ((float) i2) : 1.0f;
        if (this.zzt != f) {
            this.zzt = f;
            requestLayout();
        }
    }

    private final boolean zzac() {
        return zzad() && this.zzm != 1;
    }

    private final boolean zzad() {
        zzcip zzcip = this.zzi;
        return zzcip != null && zzcip.zzR() && !this.zzl;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = this.zzt;
        if (f != 0.0f && this.zzn == null) {
            float f2 = (float) measuredWidth;
            float f3 = f2 / ((float) measuredHeight);
            if (f > f3) {
                measuredHeight = (int) (f2 / f);
            }
            if (f < f3) {
                measuredWidth = (int) (((float) measuredHeight) * f);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzciw zzciw = this.zzn;
        if (zzciw != null) {
            zzciw.zzc(measuredWidth, measuredHeight);
        }
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzo) {
            this.zzn = new zzciw(getContext());
            this.zzn.zzd(surfaceTexture, i, i2);
            this.zzn.start();
            SurfaceTexture zzb = this.zzn.zzb();
            if (zzb != null) {
                surfaceTexture = zzb;
            } else {
                this.zzn.zze();
                this.zzn = null;
            }
        }
        this.zzh = new Surface(surfaceTexture);
        if (this.zzi == null) {
            zzV(false);
        } else {
            zzZ(this.zzh, true);
            if (!this.zzf.zza) {
                zzT();
            }
        }
        if (this.zzr == 0 || this.zzs == 0) {
            zzab(i, i2);
        } else {
            zzaa();
        }
        zzs.zza.post(new zzcjl(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzo();
        zzciw zzciw = this.zzn;
        if (zzciw != null) {
            zzciw.zze();
            this.zzn = null;
        }
        if (this.zzi != null) {
            zzW();
            Surface surface = this.zzh;
            if (surface != null) {
                surface.release();
            }
            this.zzh = null;
            zzZ((Surface) null, true);
        }
        zzs.zza.post(new zzcjo(this));
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzciw zzciw = this.zzn;
        if (zzciw != null) {
            zzciw.zzc(i, i2);
        }
        zzs.zza.post(new zzcjn(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zze.zzf(this);
        this.zza.zza(surfaceTexture, this.zzg);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        zze.zza("AdExoPlayerView3 window visibility changed to " + i);
        zzs.zza.post(new zzcjm(this, i));
        super.onWindowVisibilityChanged(i);
    }

    public final void zzA(int i) {
        zzcip zzcip = this.zzi;
        if (zzcip != null) {
            zzcip.zzN(i);
        }
    }

    public final void zzC(int i, int i2) {
        this.zzr = i;
        this.zzs = i2;
        zzaa();
    }

    /* access modifiers changed from: package-private */
    public final zzcip zzD() {
        if (this.zzf.zzm) {
            return new zzcmc(this.zzd.getContext(), this.zzf, this.zzd);
        }
        return new zzckg(this.zzd.getContext(), this.zzf, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final String zzE() {
        return zzt.zzp().zzc(this.zzd.getContext(), this.zzd.zzp().zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzF(String str) {
        zzcid zzcid = this.zzg;
        if (zzcid != null) {
            zzcid.zzb("ExoPlayerAdapter error", str);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzG() {
        zzcid zzcid = this.zzg;
        if (zzcid != null) {
            zzcid.zza();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzH() {
        zzcid zzcid = this.zzg;
        if (zzcid != null) {
            zzcid.zzf();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzI(boolean z, long j) {
        this.zzd.zzx(z, j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzJ(String str) {
        zzcid zzcid = this.zzg;
        if (zzcid != null) {
            zzcid.zzc("ExoPlayerAdapter exception", str);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzK() {
        zzcid zzcid = this.zzg;
        if (zzcid != null) {
            zzcid.zzg();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzL() {
        zzcid zzcid = this.zzg;
        if (zzcid != null) {
            zzcid.zzh();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzM() {
        zzcid zzcid = this.zzg;
        if (zzcid != null) {
            zzcid.zzi();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzN(int i, int i2) {
        zzcid zzcid = this.zzg;
        if (zzcid != null) {
            zzcid.zzj(i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzO() {
        zzY(this.zzb.zza(), false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzP(int i) {
        zzcid zzcid = this.zzg;
        if (zzcid != null) {
            zzcid.onWindowVisibilityChanged(i);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzQ() {
        zzcid zzcid = this.zzg;
        if (zzcid != null) {
            zzcid.zzd();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzR() {
        zzcid zzcid = this.zzg;
        if (zzcid != null) {
            zzcid.zze();
        }
    }

    public final int zza() {
        if (zzac()) {
            return (int) this.zzi.zzy();
        }
        return 0;
    }

    public final int zzb() {
        zzcip zzcip = this.zzi;
        if (zzcip != null) {
            return zzcip.zzr();
        }
        return -1;
    }

    public final int zzc() {
        if (zzac()) {
            return (int) this.zzi.zzz();
        }
        return 0;
    }

    public final int zzd() {
        return this.zzs;
    }

    public final int zze() {
        return this.zzr;
    }

    public final long zzf() {
        zzcip zzcip = this.zzi;
        if (zzcip != null) {
            return zzcip.zzx();
        }
        return -1;
    }

    public final long zzg() {
        zzcip zzcip = this.zzi;
        if (zzcip != null) {
            return zzcip.zzA();
        }
        return -1;
    }

    public final long zzh() {
        zzcip zzcip = this.zzi;
        if (zzcip != null) {
            return zzcip.zzB();
        }
        return -1;
    }

    public final void zzi(boolean z, long j) {
        if (this.zzd != null) {
            zzchc.zze.execute(new zzcjd(this, z, j));
        }
    }

    public final String zzj() {
        return "ExoPlayer/3".concat(true != this.zzo ? "" : " spherical");
    }

    public final void zzk(String str, Exception exc) {
        String zzS = zzS(str, exc);
        zze.zzj("ExoPlayerAdapter error: ".concat(zzS));
        this.zzl = true;
        if (this.zzf.zza) {
            zzW();
        }
        zzs.zza.post(new zzcjg(this, zzS));
        zzt.zzo().zzs(exc, "AdExoPlayerView.onError");
    }

    public final void zzl(String str, Exception exc) {
        String zzS = zzS("onLoadException", exc);
        zze.zzj("ExoPlayerAdapter exception: ".concat(zzS));
        zzt.zzo().zzs(exc, "AdExoPlayerView.onException");
        zzs.zza.post(new zzcjf(this, zzS));
    }

    public final void zzm(int i) {
        if (this.zzm != i) {
            this.zzm = i;
            if (i == 3) {
                zzU();
            } else if (i == 4) {
                if (this.zzf.zza) {
                    zzW();
                }
                this.zze.zze();
                this.zzb.zzc();
                zzs.zza.post(new zzcje(this));
            }
        }
    }

    public final void zzn() {
        if (this.zzf.zzm) {
            zzs.zza.post(new zzcji(this));
        } else {
            zzY(this.zzb.zza(), false);
        }
    }

    public final void zzo() {
        if (zzac()) {
            if (this.zzf.zza) {
                zzW();
            }
            this.zzi.zzL(false);
            this.zze.zze();
            this.zzb.zzc();
            zzs.zza.post(new zzcjj(this));
        }
    }

    public final void zzp() {
        if (zzac()) {
            if (this.zzf.zza) {
                zzT();
            }
            this.zzi.zzL(true);
            this.zze.zzc();
            this.zzb.zzb();
            this.zza.zzb();
            zzs.zza.post(new zzcjp(this));
            return;
        }
        this.zzq = true;
    }

    public final void zzq(int i) {
        if (zzac()) {
            this.zzi.zzF((long) i);
        }
    }

    public final void zzr(zzcid zzcid) {
        this.zzg = zzcid;
    }

    public final void zzs(String str) {
        if (str != null) {
            zzB(str, (String[]) null);
        }
    }

    public final void zzt() {
        if (zzad()) {
            this.zzi.zzQ();
            zzX();
        }
        this.zze.zze();
        this.zzb.zzc();
        this.zze.zzd();
    }

    public final void zzu(float f, float f2) {
        zzciw zzciw = this.zzn;
        if (zzciw != null) {
            zzciw.zzf(f, f2);
        }
    }

    public final void zzv() {
        zzs.zza.post(new zzcjh(this));
    }

    public final void zzw(int i) {
        zzcip zzcip = this.zzi;
        if (zzcip != null) {
            zzcip.zzG(i);
        }
    }

    public final void zzx(int i) {
        zzcip zzcip = this.zzi;
        if (zzcip != null) {
            zzcip.zzH(i);
        }
    }

    public final void zzy(int i) {
        zzcip zzcip = this.zzi;
        if (zzcip != null) {
            zzcip.zzJ(i);
        }
    }

    public final void zzz(int i) {
        zzcip zzcip = this.zzi;
        if (zzcip != null) {
            zzcip.zzK(i);
        }
    }

    public final void zzB(String str, String[] strArr) {
        if (str != null) {
            boolean z = false;
            if (strArr == null) {
                this.zzk = new String[]{str};
            } else {
                this.zzk = (String[]) Arrays.copyOf(strArr, strArr.length);
            }
            String str2 = this.zzj;
            if (this.zzf.zzn && str2 != null && !str.equals(str2) && this.zzm == 4) {
                z = true;
            }
            this.zzj = str;
            zzV(z);
        }
    }
}
