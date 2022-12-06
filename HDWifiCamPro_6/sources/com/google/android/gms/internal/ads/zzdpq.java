package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzbx;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdpq {
    private final zzg zza;
    private final zzfef zzb;
    private final zzdov zzc;
    private final zzdoq zzd;
    private final zzdqb zze;
    private final zzdqj zzf;
    private final Executor zzg;
    private final Executor zzh;
    private final zzbls zzi;
    private final zzdon zzj;

    public zzdpq(zzg zzg2, zzfef zzfef, zzdov zzdov, zzdoq zzdoq, zzdqb zzdqb, zzdqj zzdqj, Executor executor, Executor executor2, zzdon zzdon) {
        this.zza = zzg2;
        this.zzb = zzfef;
        this.zzi = zzfef.zzi;
        this.zzc = zzdov;
        this.zzd = zzdoq;
        this.zze = zzdqb;
        this.zzf = zzdqj;
        this.zzg = executor;
        this.zzh = executor2;
        this.zzj = zzdon;
    }

    private final boolean zzh(ViewGroup viewGroup, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        View zzf2 = z ? this.zzd.zzf() : this.zzd.zzg();
        if (zzf2 == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (zzf2.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzf2.getParent()).removeView(zzf2);
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzcX)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(zzf2, layoutParams);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(ViewGroup viewGroup) {
        boolean z = viewGroup != null;
        zzdoq zzdoq = this.zzd;
        if (zzdoq.zzf() == null) {
            return;
        }
        if (zzdoq.zzc() == 2 || zzdoq.zzc() == 1) {
            this.zza.zzI(this.zzb.zzf, String.valueOf(zzdoq.zzc()), z);
        } else if (zzdoq.zzc() == 6) {
            this.zza.zzI(this.zzb.zzf, "2", z);
            this.zza.zzI(this.zzb.zzf, "1", z);
        }
    }

    /* JADX WARNING: type inference failed for: r7v2, types: [android.view.View] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzb(com.google.android.gms.internal.ads.zzdql r10) {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzdov r0 = r9.zzc
            boolean r0 = r0.zzf()
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzdov r0 = r9.zzc
            boolean r0 = r0.zze()
            if (r0 == 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r0 = r2
            goto L_0x0034
        L_0x0015:
            java.lang.String r0 = "1098"
            java.lang.String r3 = "3011"
            java.lang.String[] r0 = new java.lang.String[]{r0, r3}
            r3 = r1
        L_0x001e:
            r4 = 2
            if (r3 >= r4) goto L_0x0013
            r4 = r0[r3]
            android.view.View r4 = r10.zzg(r4)
            if (r4 == 0) goto L_0x0031
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x0031
            r0 = r4
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x0034
        L_0x0031:
            int r3 = r3 + 1
            goto L_0x001e
        L_0x0034:
            android.view.View r3 = r10.zzf()
            android.content.Context r3 = r3.getContext()
            android.widget.RelativeLayout$LayoutParams r4 = new android.widget.RelativeLayout$LayoutParams
            r5 = -2
            r4.<init>(r5, r5)
            com.google.android.gms.internal.ads.zzdoq r5 = r9.zzd
            android.view.View r6 = r5.zze()
            if (r6 == 0) goto L_0x005e
            android.view.View r3 = r5.zze()
            com.google.android.gms.internal.ads.zzbls r5 = r9.zzi
            if (r5 != 0) goto L_0x0053
            goto L_0x008c
        L_0x0053:
            if (r0 != 0) goto L_0x008c
            int r5 = r5.zze
            zzg(r4, r5)
            r3.setLayoutParams(r4)
            goto L_0x008c
        L_0x005e:
            com.google.android.gms.internal.ads.zzblw r6 = r5.zzl()
            boolean r6 = r6 instanceof com.google.android.gms.internal.ads.zzbln
            if (r6 != 0) goto L_0x0068
            r3 = r2
            goto L_0x008c
        L_0x0068:
            com.google.android.gms.internal.ads.zzblw r5 = r5.zzl()
            com.google.android.gms.internal.ads.zzbln r5 = (com.google.android.gms.internal.ads.zzbln) r5
            if (r0 != 0) goto L_0x0077
            int r6 = r5.zzc()
            zzg(r4, r6)
        L_0x0077:
            com.google.android.gms.internal.ads.zzblo r6 = new com.google.android.gms.internal.ads.zzblo
            r6.<init>(r3, r5, r4)
            com.google.android.gms.internal.ads.zzbiu r3 = com.google.android.gms.internal.ads.zzbjc.zzcV
            com.google.android.gms.internal.ads.zzbja r4 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r3 = r4.zzb(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r6.setContentDescription(r3)
            r3 = r6
        L_0x008c:
            r4 = -1
            r5 = 1
            if (r3 != 0) goto L_0x0091
            goto L_0x00d3
        L_0x0091:
            android.view.ViewParent r6 = r3.getParent()
            boolean r6 = r6 instanceof android.view.ViewGroup
            if (r6 == 0) goto L_0x00a2
            android.view.ViewParent r6 = r3.getParent()
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r6.removeView(r3)
        L_0x00a2:
            if (r0 == 0) goto L_0x00ab
            r0.removeAllViews()
            r0.addView(r3)
            goto L_0x00cc
        L_0x00ab:
            com.google.android.gms.ads.formats.zza r0 = new com.google.android.gms.ads.formats.zza
            android.view.View r6 = r10.zzf()
            android.content.Context r6 = r6.getContext()
            r0.<init>(r6)
            android.widget.FrameLayout$LayoutParams r6 = new android.widget.FrameLayout$LayoutParams
            r6.<init>(r4, r4)
            r0.setLayoutParams(r6)
            r0.addView(r3)
            android.widget.FrameLayout r6 = r10.zzh()
            if (r6 == 0) goto L_0x00cc
            r6.addView(r0)
        L_0x00cc:
            java.lang.String r0 = r10.zzk()
            r10.zzq(r0, r3, r5)
        L_0x00d3:
            com.google.android.gms.internal.ads.zzfvn r0 = com.google.android.gms.internal.ads.zzdpm.zza
            int r3 = r0.size()
            r6 = r1
        L_0x00da:
            if (r6 >= r3) goto L_0x00f0
            java.lang.Object r7 = r0.get(r6)
            java.lang.String r7 = (java.lang.String) r7
            android.view.View r7 = r10.zzg(r7)
            int r6 = r6 + 1
            boolean r8 = r7 instanceof android.view.ViewGroup
            if (r8 == 0) goto L_0x00da
            r0 = r7
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x00f1
        L_0x00f0:
            r0 = r2
        L_0x00f1:
            java.util.concurrent.Executor r3 = r9.zzh
            com.google.android.gms.internal.ads.zzdpn r6 = new com.google.android.gms.internal.ads.zzdpn
            r6.<init>(r9, r0)
            r3.execute(r6)
            if (r0 != 0) goto L_0x00ff
            goto L_0x01b1
        L_0x00ff:
            boolean r3 = r9.zzh(r0, r5)
            if (r3 == 0) goto L_0x011a
            com.google.android.gms.internal.ads.zzdoq r1 = r9.zzd
            com.google.android.gms.internal.ads.zzcmp r2 = r1.zzr()
            if (r2 == 0) goto L_0x01b1
            com.google.android.gms.internal.ads.zzcmp r1 = r1.zzr()
            com.google.android.gms.internal.ads.zzdpp r2 = new com.google.android.gms.internal.ads.zzdpp
            r2.<init>(r10, r0)
            r1.zzaq(r2)
            return
        L_0x011a:
            com.google.android.gms.internal.ads.zzbiu r3 = com.google.android.gms.internal.ads.zzbjc.zzik
            com.google.android.gms.internal.ads.zzbja r5 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r3 = r5.zzb(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0147
            boolean r1 = r9.zzh(r0, r1)
            if (r1 == 0) goto L_0x0147
            com.google.android.gms.internal.ads.zzdoq r1 = r9.zzd
            com.google.android.gms.internal.ads.zzcmp r2 = r1.zzp()
            if (r2 == 0) goto L_0x01b1
            com.google.android.gms.internal.ads.zzcmp r1 = r1.zzp()
            com.google.android.gms.internal.ads.zzdpp r2 = new com.google.android.gms.internal.ads.zzdpp
            r2.<init>(r10, r0)
            r1.zzaq(r2)
            return
        L_0x0147:
            r0.removeAllViews()
            android.view.View r1 = r10.zzf()
            if (r1 == 0) goto L_0x0155
            android.content.Context r1 = r1.getContext()
            goto L_0x0156
        L_0x0155:
            r1 = r2
        L_0x0156:
            if (r1 == 0) goto L_0x01b1
            com.google.android.gms.internal.ads.zzdon r3 = r9.zzj
            com.google.android.gms.internal.ads.zzbmb r3 = r3.zza()
            if (r3 == 0) goto L_0x01b1
            com.google.android.gms.dynamic.IObjectWrapper r3 = r3.zzi()     // Catch:{ RemoteException -> 0x01ac }
            if (r3 == 0) goto L_0x01b1
            java.lang.Object r3 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r3)
            android.graphics.drawable.Drawable r3 = (android.graphics.drawable.Drawable) r3
            if (r3 == 0) goto L_0x01b1
            android.widget.ImageView r5 = new android.widget.ImageView
            r5.<init>(r1)
            r5.setImageDrawable(r3)
            if (r10 == 0) goto L_0x017c
            com.google.android.gms.dynamic.IObjectWrapper r2 = r10.zzj()
        L_0x017c:
            if (r2 == 0) goto L_0x019b
            com.google.android.gms.internal.ads.zzbiu r10 = com.google.android.gms.internal.ads.zzbjc.zzfl
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r10 = r1.zzb(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L_0x0191
            goto L_0x019b
        L_0x0191:
            java.lang.Object r10 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)
            android.widget.ImageView$ScaleType r10 = (android.widget.ImageView.ScaleType) r10
            r5.setScaleType(r10)
            goto L_0x01a0
        L_0x019b:
            android.widget.ImageView$ScaleType r10 = android.widget.ImageView.ScaleType.CENTER_INSIDE
            r5.setScaleType(r10)
        L_0x01a0:
            android.widget.FrameLayout$LayoutParams r10 = new android.widget.FrameLayout$LayoutParams
            r10.<init>(r4, r4)
            r5.setLayoutParams(r10)
            r0.addView(r5)
            return
        L_0x01ac:
            java.lang.String r10 = "Could not get main image drawable"
            com.google.android.gms.ads.internal.util.zze.zzj(r10)
        L_0x01b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdpq.zzb(com.google.android.gms.internal.ads.zzdql):void");
    }

    public final void zzc(zzdql zzdql) {
        if (zzdql != null && this.zze != null && zzdql.zzh() != null && this.zzc.zzg()) {
            try {
                zzdql.zzh().addView(this.zze.zza());
            } catch (zzcna e) {
                zze.zzb("web view can not be obtained", e);
            }
        }
    }

    public final void zzd(zzdql zzdql) {
        if (zzdql != null) {
            Context context = zzdql.zzf().getContext();
            if (zzbx.zzh(context, this.zzc.zza)) {
                if (!(context instanceof Activity)) {
                    zze.zze("Activity context is needed for policy validator.");
                } else if (this.zzf != null && zzdql.zzh() != null) {
                    try {
                        WindowManager windowManager = (WindowManager) context.getSystemService("window");
                        windowManager.addView(this.zzf.zza(zzdql.zzh(), windowManager), zzbx.zzb());
                    } catch (zzcna e) {
                        zze.zzb("web view can not be obtained", e);
                    }
                }
            }
        }
    }

    public final void zze(zzdql zzdql) {
        this.zzg.execute(new zzdpo(this, zzdql));
    }

    public final boolean zzf(ViewGroup viewGroup) {
        return zzh(viewGroup, true);
    }

    private static void zzg(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }
}
