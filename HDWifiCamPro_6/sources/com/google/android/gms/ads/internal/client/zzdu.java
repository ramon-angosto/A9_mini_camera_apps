package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbce;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzbkq;
import com.google.android.gms.internal.ads.zzbvh;
import com.google.android.gms.internal.ads.zzcgi;
import com.google.android.gms.internal.ads.zzcgp;
import java.util.concurrent.atomic.AtomicBoolean;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzdu {
    final zzax zza;
    private final zzbvh zzb;
    private final zzp zzc;
    private final AtomicBoolean zzd;
    /* access modifiers changed from: private */
    public final VideoController zze;
    private zza zzf;
    private AdListener zzg;
    private AdSize[] zzh;
    private AppEventListener zzi;
    private zzbs zzj;
    private VideoOptions zzk;
    private String zzl;
    @NotOnlyInitialized
    private final ViewGroup zzm;
    private int zzn;
    private boolean zzo;
    private OnPaidEventListener zzp;

    public zzdu(ViewGroup viewGroup) {
        this(viewGroup, (AttributeSet) null, false, zzp.zza, (zzbs) null, 0);
    }

    private static zzq zzC(Context context, AdSize[] adSizeArr, int i) {
        for (AdSize equals : adSizeArr) {
            if (equals.equals(AdSize.INVALID)) {
                return zzq.zze();
            }
        }
        zzq zzq = new zzq(context, adSizeArr);
        zzq.zzj = zzD(i);
        return zzq;
    }

    private static boolean zzD(int i) {
        return i == 1;
    }

    public final boolean zzA() {
        try {
            zzbs zzbs = this.zzj;
            if (zzbs != null) {
                return zzbs.zzY();
            }
            return false;
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final AdSize[] zzB() {
        return this.zzh;
    }

    public final AdListener zza() {
        return this.zzg;
    }

    public final AdSize zzb() {
        zzq zzg2;
        try {
            zzbs zzbs = this.zzj;
            if (!(zzbs == null || (zzg2 = zzbs.zzg()) == null)) {
                return zzb.zzc(zzg2.zze, zzg2.zzb, zzg2.zza);
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
        AdSize[] adSizeArr = this.zzh;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public final OnPaidEventListener zzc() {
        return this.zzp;
    }

    public final ResponseInfo zzd() {
        zzdh zzdh = null;
        try {
            zzbs zzbs = this.zzj;
            if (zzbs != null) {
                zzdh = zzbs.zzk();
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zza(zzdh);
    }

    public final VideoController zzf() {
        return this.zze;
    }

    public final VideoOptions zzg() {
        return this.zzk;
    }

    public final AppEventListener zzh() {
        return this.zzi;
    }

    public final zzdk zzi() {
        zzbs zzbs = this.zzj;
        if (zzbs != null) {
            try {
                return zzbs.zzl();
            } catch (RemoteException e) {
                zzcgp.zzl("#007 Could not call remote method.", e);
            }
        }
        return null;
    }

    public final String zzj() {
        zzbs zzbs;
        if (this.zzl == null && (zzbs = this.zzj) != null) {
            try {
                this.zzl = zzbs.zzr();
            } catch (RemoteException e) {
                zzcgp.zzl("#007 Could not call remote method.", e);
            }
        }
        return this.zzl;
    }

    public final void zzk() {
        try {
            zzbs zzbs = this.zzj;
            if (zzbs != null) {
                zzbs.zzx();
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(IObjectWrapper iObjectWrapper) {
        this.zzm.addView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzm(zzdr zzdr) {
        zzbs zzbs;
        try {
            if (this.zzj == null) {
                if (this.zzh == null || this.zzl == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.zzm.getContext();
                zzq zzC = zzC(context, this.zzh, this.zzn);
                if ("search_v2".equals(zzC.zza)) {
                    zzbs = (zzbs) new zzaj(zzaw.zza(), context, zzC, this.zzl).zzd(context, false);
                } else {
                    zzbs = (zzbs) new zzah(zzaw.zza(), context, zzC, this.zzl, this.zzb).zzd(context, false);
                }
                this.zzj = zzbs;
                this.zzj.zzD(new zzg(this.zza));
                zza zza2 = this.zzf;
                if (zza2 != null) {
                    this.zzj.zzC(new zzb(zza2));
                }
                AppEventListener appEventListener = this.zzi;
                if (appEventListener != null) {
                    this.zzj.zzG(new zzbce(appEventListener));
                }
                if (this.zzk != null) {
                    this.zzj.zzU(new zzff(this.zzk));
                }
                this.zzj.zzP(new zzey(this.zzp));
                this.zzj.zzN(this.zzo);
                zzbs zzbs2 = this.zzj;
                if (zzbs2 != null) {
                    try {
                        IObjectWrapper zzn2 = zzbs2.zzn();
                        if (zzn2 != null) {
                            if (((Boolean) zzbkq.zzf.zze()).booleanValue()) {
                                if (((Boolean) zzay.zzc().zzb(zzbjc.zziM)).booleanValue()) {
                                    zzcgi.zza.post(new zzds(this, zzn2));
                                }
                            }
                            this.zzm.addView((View) ObjectWrapper.unwrap(zzn2));
                        }
                    } catch (RemoteException e) {
                        zzcgp.zzl("#007 Could not call remote method.", e);
                    }
                }
            }
            zzbs zzbs3 = this.zzj;
            if (zzbs3 != null) {
                zzbs3.zzaa(this.zzc.zza(this.zzm.getContext(), zzdr));
                return;
            }
            throw null;
        } catch (RemoteException e2) {
            zzcgp.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void zzn() {
        try {
            zzbs zzbs = this.zzj;
            if (zzbs != null) {
                zzbs.zzz();
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzo() {
        if (!this.zzd.getAndSet(true)) {
            try {
                zzbs zzbs = this.zzj;
                if (zzbs != null) {
                    zzbs.zzA();
                }
            } catch (RemoteException e) {
                zzcgp.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    public final void zzp() {
        try {
            zzbs zzbs = this.zzj;
            if (zzbs != null) {
                zzbs.zzB();
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzq(zza zza2) {
        try {
            this.zzf = zza2;
            zzbs zzbs = this.zzj;
            if (zzbs != null) {
                zzbs.zzC(zza2 != null ? new zzb(zza2) : null);
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzr(AdListener adListener) {
        this.zzg = adListener;
        this.zza.zza(adListener);
    }

    public final void zzs(AdSize... adSizeArr) {
        if (this.zzh == null) {
            zzt(adSizeArr);
            return;
        }
        throw new IllegalStateException("The ad size can only be set once on AdView.");
    }

    public final void zzt(AdSize... adSizeArr) {
        this.zzh = adSizeArr;
        try {
            zzbs zzbs = this.zzj;
            if (zzbs != null) {
                zzbs.zzF(zzC(this.zzm.getContext(), this.zzh, this.zzn));
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
        this.zzm.requestLayout();
    }

    public final void zzu(String str) {
        if (this.zzl == null) {
            this.zzl = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }

    public final void zzv(AppEventListener appEventListener) {
        try {
            this.zzi = appEventListener;
            zzbs zzbs = this.zzj;
            if (zzbs != null) {
                zzbs.zzG(appEventListener != null ? new zzbce(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzw(boolean z) {
        this.zzo = z;
        try {
            zzbs zzbs = this.zzj;
            if (zzbs != null) {
                zzbs.zzN(z);
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzx(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzp = onPaidEventListener;
            zzbs zzbs = this.zzj;
            if (zzbs != null) {
                zzbs.zzP(new zzey(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final boolean zzz(zzbs zzbs) {
        try {
            IObjectWrapper zzn2 = zzbs.zzn();
            if (zzn2 == null || ((View) ObjectWrapper.unwrap(zzn2)).getParent() != null) {
                return false;
            }
            this.zzm.addView((View) ObjectWrapper.unwrap(zzn2));
            this.zzj = zzbs;
            return true;
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
            return false;
        }
    }

    public zzdu(ViewGroup viewGroup, int i) {
        this(viewGroup, (AttributeSet) null, false, zzp.zza, (zzbs) null, i);
    }

    public final void zzy(VideoOptions videoOptions) {
        zzff zzff;
        this.zzk = videoOptions;
        try {
            zzbs zzbs = this.zzj;
            if (zzbs != null) {
                if (videoOptions == null) {
                    zzff = null;
                } else {
                    zzff = new zzff(videoOptions);
                }
                zzbs.zzU(zzff);
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public zzdu(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzp.zza, (zzbs) null, 0);
    }

    public zzdu(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, z, zzp.zza, (zzbs) null, i);
    }

    zzdu(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzp zzp2, zzbs zzbs, int i) {
        zzq zzq;
        this.zzb = new zzbvh();
        this.zze = new VideoController();
        this.zza = new zzdt(this);
        this.zzm = viewGroup;
        this.zzc = zzp2;
        this.zzj = null;
        this.zzd = new AtomicBoolean(false);
        this.zzn = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzy zzy = new zzy(context, attributeSet);
                this.zzh = zzy.zzb(z);
                this.zzl = zzy.zza();
                if (viewGroup.isInEditMode()) {
                    zzcgi zzb2 = zzaw.zzb();
                    AdSize adSize = this.zzh[0];
                    int i2 = this.zzn;
                    if (adSize.equals(AdSize.INVALID)) {
                        zzq = zzq.zze();
                    } else {
                        zzq zzq2 = new zzq(context, adSize);
                        zzq2.zzj = zzD(i2);
                        zzq = zzq2;
                    }
                    zzb2.zzl(viewGroup, zzq, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzaw.zzb().zzk(viewGroup, new zzq(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }
}
