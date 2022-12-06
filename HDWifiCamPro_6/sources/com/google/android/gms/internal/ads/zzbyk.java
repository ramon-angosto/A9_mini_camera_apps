package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.internal.client.zzcr;
import com.google.android.gms.ads.internal.client.zzcu;
import com.google.android.gms.ads.internal.client.zzcv;
import com.google.android.gms.ads.internal.client.zzdh;
import com.google.android.gms.ads.internal.client.zzej;
import com.google.android.gms.ads.internal.client.zzey;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbyk extends NativeAd {
    private final zzbob zza;
    private final List zzb = new ArrayList();
    private final zzbyj zzc;
    private final NativeAd.AdChoicesInfo zzd;
    private final List zze = new ArrayList();

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0099 A[Catch:{ RemoteException -> 0x00a6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzbyk(com.google.android.gms.internal.ads.zzbob r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r5.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzb = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zze = r1
            r5.zza = r6
            r6 = 0
            com.google.android.gms.internal.ads.zzbob r1 = r5.zza     // Catch:{ RemoteException -> 0x0045 }
            java.util.List r1 = r1.zzu()     // Catch:{ RemoteException -> 0x0045 }
            if (r1 == 0) goto L_0x0049
            java.util.Iterator r1 = r1.iterator()     // Catch:{ RemoteException -> 0x0045 }
        L_0x0022:
            boolean r2 = r1.hasNext()     // Catch:{ RemoteException -> 0x0045 }
            if (r2 == 0) goto L_0x0049
            java.lang.Object r2 = r1.next()     // Catch:{ RemoteException -> 0x0045 }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x0045 }
            if (r3 == 0) goto L_0x0037
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x0045 }
            com.google.android.gms.internal.ads.zzbme r2 = com.google.android.gms.internal.ads.zzbmd.zzg(r2)     // Catch:{ RemoteException -> 0x0045 }
            goto L_0x0038
        L_0x0037:
            r2 = r6
        L_0x0038:
            if (r2 == 0) goto L_0x0022
            java.util.List r3 = r5.zzb     // Catch:{ RemoteException -> 0x0045 }
            com.google.android.gms.internal.ads.zzbyj r4 = new com.google.android.gms.internal.ads.zzbyj     // Catch:{ RemoteException -> 0x0045 }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0045 }
            r3.add(r4)     // Catch:{ RemoteException -> 0x0045 }
            goto L_0x0022
        L_0x0045:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzcgp.zzh(r0, r1)
        L_0x0049:
            com.google.android.gms.internal.ads.zzbob r1 = r5.zza     // Catch:{ RemoteException -> 0x0078 }
            java.util.List r1 = r1.zzv()     // Catch:{ RemoteException -> 0x0078 }
            if (r1 == 0) goto L_0x007c
            java.util.Iterator r1 = r1.iterator()     // Catch:{ RemoteException -> 0x0078 }
        L_0x0055:
            boolean r2 = r1.hasNext()     // Catch:{ RemoteException -> 0x0078 }
            if (r2 == 0) goto L_0x007c
            java.lang.Object r2 = r1.next()     // Catch:{ RemoteException -> 0x0078 }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x0078 }
            if (r3 == 0) goto L_0x006a
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x0078 }
            com.google.android.gms.ads.internal.client.zzcu r2 = com.google.android.gms.ads.internal.client.zzct.zzb(r2)     // Catch:{ RemoteException -> 0x0078 }
            goto L_0x006b
        L_0x006a:
            r2 = r6
        L_0x006b:
            if (r2 == 0) goto L_0x0055
            java.util.List r3 = r5.zze     // Catch:{ RemoteException -> 0x0078 }
            com.google.android.gms.ads.internal.client.zzcv r4 = new com.google.android.gms.ads.internal.client.zzcv     // Catch:{ RemoteException -> 0x0078 }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0078 }
            r3.add(r4)     // Catch:{ RemoteException -> 0x0078 }
            goto L_0x0055
        L_0x0078:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzcgp.zzh(r0, r1)
        L_0x007c:
            com.google.android.gms.internal.ads.zzbob r1 = r5.zza     // Catch:{ RemoteException -> 0x008a }
            com.google.android.gms.internal.ads.zzbme r1 = r1.zzk()     // Catch:{ RemoteException -> 0x008a }
            if (r1 == 0) goto L_0x008e
            com.google.android.gms.internal.ads.zzbyj r2 = new com.google.android.gms.internal.ads.zzbyj     // Catch:{ RemoteException -> 0x008a }
            r2.<init>(r1)     // Catch:{ RemoteException -> 0x008a }
            goto L_0x008f
        L_0x008a:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzcgp.zzh(r0, r1)
        L_0x008e:
            r2 = r6
        L_0x008f:
            r5.zzc = r2
            com.google.android.gms.internal.ads.zzbob r1 = r5.zza     // Catch:{ RemoteException -> 0x00a6 }
            com.google.android.gms.internal.ads.zzblw r1 = r1.zzi()     // Catch:{ RemoteException -> 0x00a6 }
            if (r1 == 0) goto L_0x00aa
            com.google.android.gms.internal.ads.zzbyh r1 = new com.google.android.gms.internal.ads.zzbyh     // Catch:{ RemoteException -> 0x00a6 }
            com.google.android.gms.internal.ads.zzbob r2 = r5.zza     // Catch:{ RemoteException -> 0x00a6 }
            com.google.android.gms.internal.ads.zzblw r2 = r2.zzi()     // Catch:{ RemoteException -> 0x00a6 }
            r1.<init>(r2)     // Catch:{ RemoteException -> 0x00a6 }
            r6 = r1
            goto L_0x00aa
        L_0x00a6:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzcgp.zzh(r0, r1)
        L_0x00aa:
            r5.zzd = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbyk.<init>(com.google.android.gms.internal.ads.zzbob):void");
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
        return this.zzd;
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
            Bundle zzf = this.zza.zzf();
            if (zzf != null) {
                return zzf;
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

    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.zze;
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

    public final void setUnconfirmedClickListener(NativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zza.zzF(new zzbys(unconfirmedClickListener));
        } catch (RemoteException e) {
            zzcgp.zzh("Failed to setUnconfirmedClickListener", e);
        }
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        try {
            return this.zza.zzm();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return null;
        }
    }
}
