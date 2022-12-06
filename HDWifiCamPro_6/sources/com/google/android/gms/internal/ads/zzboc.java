package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.internal.client.zzcr;
import com.google.android.gms.ads.internal.client.zzcu;
import com.google.android.gms.ads.internal.client.zzcv;
import com.google.android.gms.ads.internal.client.zzdh;
import com.google.android.gms.ads.internal.client.zzej;
import com.google.android.gms.ads.internal.client.zzey;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzboc extends UnifiedNativeAd {
    private final zzbob zza;
    private final List zzb = new ArrayList();
    private final zzbmf zzc;
    private final VideoController zzd = new VideoController();
    private final NativeAd.AdChoicesInfo zze;
    private final List zzf = new ArrayList();

    /* JADX WARNING: type inference failed for: r3v5, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0054 A[Catch:{ RemoteException -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b3 A[Catch:{ RemoteException -> 0x00c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0029 A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzboc(com.google.android.gms.internal.ads.zzbob r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r5.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzb = r1
            com.google.android.gms.ads.VideoController r1 = new com.google.android.gms.ads.VideoController
            r1.<init>()
            r5.zzd = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzf = r1
            r5.zza = r6
            r6 = 0
            com.google.android.gms.internal.ads.zzbob r1 = r5.zza     // Catch:{ RemoteException -> 0x005f }
            java.util.List r1 = r1.zzu()     // Catch:{ RemoteException -> 0x005f }
            if (r1 == 0) goto L_0x0063
            java.util.Iterator r1 = r1.iterator()     // Catch:{ RemoteException -> 0x005f }
        L_0x0029:
            boolean r2 = r1.hasNext()     // Catch:{ RemoteException -> 0x005f }
            if (r2 == 0) goto L_0x0063
            java.lang.Object r2 = r1.next()     // Catch:{ RemoteException -> 0x005f }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x005f }
            if (r3 == 0) goto L_0x0051
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x005f }
            if (r2 != 0) goto L_0x003c
            goto L_0x0051
        L_0x003c:
            java.lang.String r3 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)     // Catch:{ RemoteException -> 0x005f }
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzbme     // Catch:{ RemoteException -> 0x005f }
            if (r4 == 0) goto L_0x004a
            r2 = r3
            com.google.android.gms.internal.ads.zzbme r2 = (com.google.android.gms.internal.ads.zzbme) r2     // Catch:{ RemoteException -> 0x005f }
            goto L_0x0052
        L_0x004a:
            com.google.android.gms.internal.ads.zzbmc r3 = new com.google.android.gms.internal.ads.zzbmc     // Catch:{ RemoteException -> 0x005f }
            r3.<init>(r2)     // Catch:{ RemoteException -> 0x005f }
            r2 = r3
            goto L_0x0052
        L_0x0051:
            r2 = r6
        L_0x0052:
            if (r2 == 0) goto L_0x0029
            java.util.List r3 = r5.zzb     // Catch:{ RemoteException -> 0x005f }
            com.google.android.gms.internal.ads.zzbmf r4 = new com.google.android.gms.internal.ads.zzbmf     // Catch:{ RemoteException -> 0x005f }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x005f }
            r3.add(r4)     // Catch:{ RemoteException -> 0x005f }
            goto L_0x0029
        L_0x005f:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzcgp.zzh(r0, r1)
        L_0x0063:
            com.google.android.gms.internal.ads.zzbob r1 = r5.zza     // Catch:{ RemoteException -> 0x0092 }
            java.util.List r1 = r1.zzv()     // Catch:{ RemoteException -> 0x0092 }
            if (r1 == 0) goto L_0x0096
            java.util.Iterator r1 = r1.iterator()     // Catch:{ RemoteException -> 0x0092 }
        L_0x006f:
            boolean r2 = r1.hasNext()     // Catch:{ RemoteException -> 0x0092 }
            if (r2 == 0) goto L_0x0096
            java.lang.Object r2 = r1.next()     // Catch:{ RemoteException -> 0x0092 }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x0092 }
            if (r3 == 0) goto L_0x0084
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x0092 }
            com.google.android.gms.ads.internal.client.zzcu r2 = com.google.android.gms.ads.internal.client.zzct.zzb(r2)     // Catch:{ RemoteException -> 0x0092 }
            goto L_0x0085
        L_0x0084:
            r2 = r6
        L_0x0085:
            if (r2 == 0) goto L_0x006f
            java.util.List r3 = r5.zzf     // Catch:{ RemoteException -> 0x0092 }
            com.google.android.gms.ads.internal.client.zzcv r4 = new com.google.android.gms.ads.internal.client.zzcv     // Catch:{ RemoteException -> 0x0092 }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0092 }
            r3.add(r4)     // Catch:{ RemoteException -> 0x0092 }
            goto L_0x006f
        L_0x0092:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzcgp.zzh(r0, r1)
        L_0x0096:
            com.google.android.gms.internal.ads.zzbob r1 = r5.zza     // Catch:{ RemoteException -> 0x00a4 }
            com.google.android.gms.internal.ads.zzbme r1 = r1.zzk()     // Catch:{ RemoteException -> 0x00a4 }
            if (r1 == 0) goto L_0x00a8
            com.google.android.gms.internal.ads.zzbmf r2 = new com.google.android.gms.internal.ads.zzbmf     // Catch:{ RemoteException -> 0x00a4 }
            r2.<init>(r1)     // Catch:{ RemoteException -> 0x00a4 }
            goto L_0x00a9
        L_0x00a4:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzcgp.zzh(r0, r1)
        L_0x00a8:
            r2 = r6
        L_0x00a9:
            r5.zzc = r2
            com.google.android.gms.internal.ads.zzbob r1 = r5.zza     // Catch:{ RemoteException -> 0x00c0 }
            com.google.android.gms.internal.ads.zzblw r1 = r1.zzi()     // Catch:{ RemoteException -> 0x00c0 }
            if (r1 == 0) goto L_0x00c4
            com.google.android.gms.internal.ads.zzblx r1 = new com.google.android.gms.internal.ads.zzblx     // Catch:{ RemoteException -> 0x00c0 }
            com.google.android.gms.internal.ads.zzbob r2 = r5.zza     // Catch:{ RemoteException -> 0x00c0 }
            com.google.android.gms.internal.ads.zzblw r2 = r2.zzi()     // Catch:{ RemoteException -> 0x00c0 }
            r1.<init>(r2)     // Catch:{ RemoteException -> 0x00c0 }
            r6 = r1
            goto L_0x00c4
        L_0x00c0:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzcgp.zzh(r0, r1)
        L_0x00c4:
            r5.zze = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzboc.<init>(com.google.android.gms.internal.ads.zzbob):void");
    }

    public final void cancelUnconfirmedClick() {
        try {
            this.zza.zzw();
        } catch (RemoteException e) {
            zzcgp.zzh("Failed to cancelUnconfirmedClick", e);
        }
    }

    public final void destroy() {
        try {
            this.zza.zzx();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
    }

    public final void enableCustomClickGesture() {
        try {
            this.zza.zzC();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
    }

    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zze;
    }

    public final String getAdvertiser() {
        try {
            return this.zza.zzn();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return null;
        }
    }

    public final String getBody() {
        try {
            return this.zza.zzo();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return null;
        }
    }

    public final String getCallToAction() {
        try {
            return this.zza.zzp();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            Bundle zzf2 = this.zza.zzf();
            if (zzf2 != null) {
                return zzf2;
            }
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
        return new Bundle();
    }

    public final String getHeadline() {
        try {
            return this.zza.zzq();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return null;
        }
    }

    public final NativeAd.Image getIcon() {
        return this.zzc;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzb;
    }

    public final MediaContent getMediaContent() {
        try {
            if (this.zza.zzj() != null) {
                return new zzej(this.zza.zzj(), (zzbmy) null);
            }
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
        return null;
    }

    public final String getMediationAdapterClassName() {
        try {
            return this.zza.zzr();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return null;
        }
    }

    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.zzf;
    }

    public final String getPrice() {
        try {
            return this.zza.zzs();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return null;
        }
    }

    public final ResponseInfo getResponseInfo() {
        zzdh zzdh;
        try {
            zzdh = this.zza.zzg();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            zzdh = null;
        }
        return ResponseInfo.zza(zzdh);
    }

    public final Double getStarRating() {
        try {
            double zze2 = this.zza.zze();
            if (zze2 == -1.0d) {
                return null;
            }
            return Double.valueOf(zze2);
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return null;
        }
    }

    public final String getStore() {
        try {
            return this.zza.zzt();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zza.zzh() != null) {
                this.zzd.zzb(this.zza.zzh());
            }
        } catch (RemoteException e) {
            zzcgp.zzh("Exception occurred while getting video controller", e);
        }
        return this.zzd;
    }

    public final boolean isCustomClickGestureEnabled() {
        try {
            return this.zza.zzG();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return false;
        }
    }

    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.zza.zzH();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return false;
        }
    }

    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            if (this.zza.zzH()) {
                if (muteThisAdReason == null) {
                    try {
                        this.zza.zzy((zzcu) null);
                        return;
                    } catch (RemoteException e) {
                        zzcgp.zzh("", e);
                        return;
                    }
                } else if (muteThisAdReason instanceof zzcv) {
                    this.zza.zzy(((zzcv) muteThisAdReason).zza());
                    return;
                } else {
                    zzcgp.zzg("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
                    return;
                }
            }
        } catch (RemoteException e2) {
            zzcgp.zzh("", e2);
        }
        zzcgp.zzg("Ad is not custom mute enabled");
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zza.zzz(bundle);
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
    }

    public final void recordCustomClickGesture() {
        try {
            this.zza.zzA();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zza.zzI(bundle);
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zza.zzB(bundle);
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
    }

    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.zza.zzD(new zzcr(muteThisAdListener));
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zza.zzE(new zzey(onPaidEventListener));
        } catch (RemoteException e) {
            zzcgp.zzh("Failed to setOnPaidEventListener", e);
        }
    }

    public final void setUnconfirmedClickListener(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zza.zzF(new zzbon(unconfirmedClickListener));
        } catch (RemoteException e) {
            zzcgp.zzh("Failed to setUnconfirmedClickListener", e);
        }
    }

    public final Object zza() {
        try {
            IObjectWrapper zzl = this.zza.zzl();
            if (zzl != null) {
                return ObjectWrapper.unwrap(zzl);
            }
            return null;
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return null;
        }
    }
}
