package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbxz extends zzbyf {
    static final Set zza = CollectionUtils.setOf("top-left", "top-right", "top-center", TtmlNode.CENTER, "bottom-left", "bottom-right", "bottom-center");
    private String zzb = "top-right";
    private boolean zzc = true;
    private int zzd = 0;
    private int zze = 0;
    private int zzf = -1;
    private int zzg = 0;
    private int zzh = 0;
    private int zzi = -1;
    private final Object zzj = new Object();
    private final zzcmp zzk;
    private final Activity zzl;
    private zzcoe zzm;
    private ImageView zzn;
    private LinearLayout zzo;
    private final zzbyg zzp;
    private PopupWindow zzq;
    private RelativeLayout zzr;
    private ViewGroup zzs;

    public zzbxz(zzcmp zzcmp, zzbyg zzbyg) {
        super(zzcmp, "resize");
        this.zzk = zzcmp;
        this.zzl = zzcmp.zzk();
        this.zzp = zzbyg;
    }

    public final void zza(boolean z) {
        synchronized (this.zzj) {
            PopupWindow popupWindow = this.zzq;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.zzr.removeView((View) this.zzk);
                ViewGroup viewGroup = this.zzs;
                if (viewGroup != null) {
                    viewGroup.removeView(this.zzn);
                    this.zzs.addView((View) this.zzk);
                    this.zzk.zzai(this.zzm);
                }
                if (z) {
                    zzk("default");
                    zzbyg zzbyg = this.zzp;
                    if (zzbyg != null) {
                        zzbyg.zzb();
                    }
                }
                this.zzq = null;
                this.zzr = null;
                this.zzs = null;
                this.zzo = null;
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01f6 A[Catch:{ RuntimeException -> 0x0429 }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01f7 A[Catch:{ RuntimeException -> 0x0429 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0258 A[Catch:{ RuntimeException -> 0x0429 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x025f A[Catch:{ RuntimeException -> 0x0429 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(java.util.Map r18) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            java.lang.Object r2 = r1.zzj
            monitor-enter(r2)
            android.app.Activity r3 = r1.zzl     // Catch:{ all -> 0x0482 }
            if (r3 != 0) goto L_0x0012
            java.lang.String r0 = "Not an activity context. Cannot resize."
            r1.zzg(r0)     // Catch:{ all -> 0x0482 }
            monitor-exit(r2)     // Catch:{ all -> 0x0482 }
            return
        L_0x0012:
            com.google.android.gms.internal.ads.zzcmp r3 = r1.zzk     // Catch:{ all -> 0x0482 }
            com.google.android.gms.internal.ads.zzcoe r3 = r3.zzQ()     // Catch:{ all -> 0x0482 }
            if (r3 != 0) goto L_0x0021
            java.lang.String r0 = "Webview is not yet available, size is not set."
            r1.zzg(r0)     // Catch:{ all -> 0x0482 }
            monitor-exit(r2)     // Catch:{ all -> 0x0482 }
            return
        L_0x0021:
            com.google.android.gms.internal.ads.zzcmp r3 = r1.zzk     // Catch:{ all -> 0x0482 }
            com.google.android.gms.internal.ads.zzcoe r3 = r3.zzQ()     // Catch:{ all -> 0x0482 }
            boolean r3 = r3.zzi()     // Catch:{ all -> 0x0482 }
            if (r3 == 0) goto L_0x0034
            java.lang.String r0 = "Is interstitial. Cannot resize an interstitial."
            r1.zzg(r0)     // Catch:{ all -> 0x0482 }
            monitor-exit(r2)     // Catch:{ all -> 0x0482 }
            return
        L_0x0034:
            com.google.android.gms.internal.ads.zzcmp r3 = r1.zzk     // Catch:{ all -> 0x0482 }
            boolean r3 = r3.zzaC()     // Catch:{ all -> 0x0482 }
            if (r3 != 0) goto L_0x047b
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0482 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0482 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0482 }
            if (r3 != 0) goto L_0x005b
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x0482 }
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0482 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0482 }
            int r3 = com.google.android.gms.ads.internal.util.zzs.zzK(r3)     // Catch:{ all -> 0x0482 }
            r1.zzi = r3     // Catch:{ all -> 0x0482 }
        L_0x005b:
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0482 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0482 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0482 }
            if (r3 != 0) goto L_0x007a
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x0482 }
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0482 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0482 }
            int r3 = com.google.android.gms.ads.internal.util.zzs.zzK(r3)     // Catch:{ all -> 0x0482 }
            r1.zzf = r3     // Catch:{ all -> 0x0482 }
        L_0x007a:
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0482 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0482 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0482 }
            if (r3 != 0) goto L_0x0099
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x0482 }
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0482 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0482 }
            int r3 = com.google.android.gms.ads.internal.util.zzs.zzK(r3)     // Catch:{ all -> 0x0482 }
            r1.zzg = r3     // Catch:{ all -> 0x0482 }
        L_0x0099:
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0482 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0482 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0482 }
            if (r3 != 0) goto L_0x00b8
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x0482 }
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0482 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0482 }
            int r3 = com.google.android.gms.ads.internal.util.zzs.zzK(r3)     // Catch:{ all -> 0x0482 }
            r1.zzh = r3     // Catch:{ all -> 0x0482 }
        L_0x00b8:
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0482 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0482 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0482 }
            if (r3 != 0) goto L_0x00d4
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0482 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0482 }
            boolean r3 = java.lang.Boolean.parseBoolean(r3)     // Catch:{ all -> 0x0482 }
            r1.zzc = r3     // Catch:{ all -> 0x0482 }
        L_0x00d4:
            java.lang.String r3 = "customClosePosition"
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x0482 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0482 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0482 }
            if (r3 != 0) goto L_0x00e4
            r1.zzb = r0     // Catch:{ all -> 0x0482 }
        L_0x00e4:
            int r0 = r1.zzi     // Catch:{ all -> 0x0482 }
            if (r0 < 0) goto L_0x0474
            int r0 = r1.zzf     // Catch:{ all -> 0x0482 }
            if (r0 < 0) goto L_0x0474
            android.app.Activity r0 = r1.zzl     // Catch:{ all -> 0x0482 }
            android.view.Window r0 = r0.getWindow()     // Catch:{ all -> 0x0482 }
            if (r0 == 0) goto L_0x046d
            android.view.View r3 = r0.getDecorView()     // Catch:{ all -> 0x0482 }
            if (r3 != 0) goto L_0x00fc
            goto L_0x046d
        L_0x00fc:
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x0482 }
            android.app.Activity r3 = r1.zzl     // Catch:{ all -> 0x0482 }
            int[] r3 = com.google.android.gms.ads.internal.util.zzs.zzR(r3)     // Catch:{ all -> 0x0482 }
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x0482 }
            android.app.Activity r4 = r1.zzl     // Catch:{ all -> 0x0482 }
            int[] r4 = com.google.android.gms.ads.internal.util.zzs.zzO(r4)     // Catch:{ all -> 0x0482 }
            r5 = 0
            r6 = r3[r5]     // Catch:{ all -> 0x0482 }
            r7 = 1
            r3 = r3[r7]     // Catch:{ all -> 0x0482 }
            int r8 = r1.zzi     // Catch:{ all -> 0x0482 }
            r9 = 5
            r10 = 4
            r11 = 3
            r13 = 2
            r14 = 50
            if (r8 < r14) goto L_0x0250
            if (r8 <= r6) goto L_0x0122
            goto L_0x0250
        L_0x0122:
            int r15 = r1.zzf     // Catch:{ all -> 0x0482 }
            if (r15 < r14) goto L_0x024a
            if (r15 <= r3) goto L_0x012a
            goto L_0x024a
        L_0x012a:
            if (r15 != r3) goto L_0x0135
            if (r8 != r6) goto L_0x0135
            java.lang.String r3 = "Cannot resize to a full-screen ad."
            com.google.android.gms.ads.internal.util.zze.zzj(r3)     // Catch:{ all -> 0x0482 }
            goto L_0x0255
        L_0x0135:
            boolean r3 = r1.zzc     // Catch:{ all -> 0x0482 }
            if (r3 == 0) goto L_0x0208
            java.lang.String r3 = r1.zzb     // Catch:{ all -> 0x0482 }
            int r16 = r3.hashCode()     // Catch:{ all -> 0x0482 }
            switch(r16) {
                case -1364013995: goto L_0x0175;
                case -1012429441: goto L_0x016b;
                case -655373719: goto L_0x0161;
                case 1163912186: goto L_0x0157;
                case 1288627767: goto L_0x014d;
                case 1755462605: goto L_0x0143;
                default: goto L_0x0142;
            }
        L_0x0142:
            goto L_0x017f
        L_0x0143:
            java.lang.String r12 = "top-center"
            boolean r3 = r3.equals(r12)
            if (r3 == 0) goto L_0x017f
            r3 = r7
            goto L_0x0180
        L_0x014d:
            java.lang.String r12 = "bottom-center"
            boolean r3 = r3.equals(r12)
            if (r3 == 0) goto L_0x017f
            r3 = r10
            goto L_0x0180
        L_0x0157:
            java.lang.String r12 = "bottom-right"
            boolean r3 = r3.equals(r12)
            if (r3 == 0) goto L_0x017f
            r3 = r9
            goto L_0x0180
        L_0x0161:
            java.lang.String r12 = "bottom-left"
            boolean r3 = r3.equals(r12)
            if (r3 == 0) goto L_0x017f
            r3 = r11
            goto L_0x0180
        L_0x016b:
            java.lang.String r12 = "top-left"
            boolean r3 = r3.equals(r12)
            if (r3 == 0) goto L_0x017f
            r3 = r5
            goto L_0x0180
        L_0x0175:
            java.lang.String r12 = "center"
            boolean r3 = r3.equals(r12)
            if (r3 == 0) goto L_0x017f
            r3 = r13
            goto L_0x0180
        L_0x017f:
            r3 = -1
        L_0x0180:
            if (r3 == 0) goto L_0x01e0
            if (r3 == r7) goto L_0x01d4
            if (r3 == r13) goto L_0x01c0
            if (r3 == r11) goto L_0x01b3
            if (r3 == r10) goto L_0x01a5
            if (r3 == r9) goto L_0x019a
            int r3 = r1.zzd     // Catch:{ all -> 0x0482 }
            int r12 = r1.zzg     // Catch:{ all -> 0x0482 }
            int r3 = r3 + r12
            int r3 = r3 + r8
            int r3 = r3 + -50
            int r8 = r1.zze     // Catch:{ all -> 0x0482 }
        L_0x0196:
            int r12 = r1.zzh     // Catch:{ all -> 0x0482 }
            int r8 = r8 + r12
            goto L_0x01e8
        L_0x019a:
            int r3 = r1.zzd     // Catch:{ all -> 0x0482 }
            int r12 = r1.zzg     // Catch:{ all -> 0x0482 }
            int r3 = r3 + r12
            int r3 = r3 + r8
            int r3 = r3 + -50
            int r8 = r1.zze     // Catch:{ all -> 0x0482 }
            goto L_0x01b0
        L_0x01a5:
            int r3 = r1.zzd     // Catch:{ all -> 0x0482 }
            int r12 = r1.zzg     // Catch:{ all -> 0x0482 }
            int r3 = r3 + r12
            int r8 = r8 >> r7
            int r3 = r3 + r8
            int r3 = r3 + -25
            int r8 = r1.zze     // Catch:{ all -> 0x0482 }
        L_0x01b0:
            int r12 = r1.zzh     // Catch:{ all -> 0x0482 }
            goto L_0x01bb
        L_0x01b3:
            int r3 = r1.zzd     // Catch:{ all -> 0x0482 }
            int r8 = r1.zzg     // Catch:{ all -> 0x0482 }
            int r3 = r3 + r8
            int r8 = r1.zze     // Catch:{ all -> 0x0482 }
            goto L_0x01b0
        L_0x01bb:
            int r8 = r8 + r12
            int r8 = r8 + r15
            int r8 = r8 + -50
            goto L_0x01e8
        L_0x01c0:
            int r3 = r1.zzd     // Catch:{ all -> 0x0482 }
            int r12 = r1.zzg     // Catch:{ all -> 0x0482 }
            int r3 = r3 + r12
            int r8 = r8 >> r7
            int r3 = r3 + r8
            int r3 = r3 + -25
            int r8 = r1.zze     // Catch:{ all -> 0x0482 }
            int r12 = r1.zzh     // Catch:{ all -> 0x0482 }
            int r8 = r8 + r12
            int r12 = r15 >> 1
            int r8 = r8 + r12
            int r8 = r8 + -25
            goto L_0x01e8
        L_0x01d4:
            int r3 = r1.zzd     // Catch:{ all -> 0x0482 }
            int r12 = r1.zzg     // Catch:{ all -> 0x0482 }
            int r3 = r3 + r12
            int r8 = r8 >> r7
            int r3 = r3 + r8
            int r3 = r3 + -25
            int r8 = r1.zze     // Catch:{ all -> 0x0482 }
            goto L_0x0196
        L_0x01e0:
            int r3 = r1.zzd     // Catch:{ all -> 0x0482 }
            int r8 = r1.zzg     // Catch:{ all -> 0x0482 }
            int r3 = r3 + r8
            int r8 = r1.zze     // Catch:{ all -> 0x0482 }
            goto L_0x0196
        L_0x01e8:
            if (r3 < 0) goto L_0x0255
            int r3 = r3 + r14
            if (r3 > r6) goto L_0x0255
            r3 = r4[r5]     // Catch:{ all -> 0x0482 }
            if (r8 < r3) goto L_0x0255
            int r8 = r8 + r14
            r3 = r4[r7]     // Catch:{ all -> 0x0482 }
            if (r8 <= r3) goto L_0x01f7
            goto L_0x0255
        L_0x01f7:
            int[] r15 = new int[r13]     // Catch:{ all -> 0x0482 }
            int r3 = r1.zzd     // Catch:{ all -> 0x0482 }
            int r4 = r1.zzg     // Catch:{ all -> 0x0482 }
            int r3 = r3 + r4
            r15[r5] = r3     // Catch:{ all -> 0x0482 }
            int r3 = r1.zze     // Catch:{ all -> 0x0482 }
            int r4 = r1.zzh     // Catch:{ all -> 0x0482 }
            int r3 = r3 + r4
            r15[r7] = r3     // Catch:{ all -> 0x0482 }
            goto L_0x0256
        L_0x0208:
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x0482 }
            android.app.Activity r3 = r1.zzl     // Catch:{ all -> 0x0482 }
            int[] r3 = com.google.android.gms.ads.internal.util.zzs.zzR(r3)     // Catch:{ all -> 0x0482 }
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x0482 }
            android.app.Activity r4 = r1.zzl     // Catch:{ all -> 0x0482 }
            int[] r4 = com.google.android.gms.ads.internal.util.zzs.zzO(r4)     // Catch:{ all -> 0x0482 }
            r3 = r3[r5]     // Catch:{ all -> 0x0482 }
            int r6 = r1.zzd     // Catch:{ all -> 0x0482 }
            int r8 = r1.zzg     // Catch:{ all -> 0x0482 }
            int r6 = r6 + r8
            int r8 = r1.zze     // Catch:{ all -> 0x0482 }
            int r12 = r1.zzh     // Catch:{ all -> 0x0482 }
            int r8 = r8 + r12
            if (r6 >= 0) goto L_0x022a
            r3 = r5
            goto L_0x0233
        L_0x022a:
            int r12 = r1.zzi     // Catch:{ all -> 0x0482 }
            int r15 = r6 + r12
            if (r15 <= r3) goto L_0x0232
            int r3 = r3 - r12
            goto L_0x0233
        L_0x0232:
            r3 = r6
        L_0x0233:
            r6 = r4[r5]     // Catch:{ all -> 0x0482 }
            if (r8 >= r6) goto L_0x0239
            r8 = r6
            goto L_0x0243
        L_0x0239:
            int r6 = r1.zzf     // Catch:{ all -> 0x0482 }
            int r12 = r8 + r6
            r4 = r4[r7]     // Catch:{ all -> 0x0482 }
            if (r12 <= r4) goto L_0x0243
            int r8 = r4 - r6
        L_0x0243:
            int[] r15 = new int[r13]     // Catch:{ all -> 0x0482 }
            r15[r5] = r3     // Catch:{ all -> 0x0482 }
            r15[r7] = r8     // Catch:{ all -> 0x0482 }
            goto L_0x0256
        L_0x024a:
            java.lang.String r3 = "Height is too small or too large."
            com.google.android.gms.ads.internal.util.zze.zzj(r3)     // Catch:{ all -> 0x0482 }
            goto L_0x0255
        L_0x0250:
            java.lang.String r3 = "Width is too small or too large."
            com.google.android.gms.ads.internal.util.zze.zzj(r3)     // Catch:{ all -> 0x0482 }
        L_0x0255:
            r15 = 0
        L_0x0256:
            if (r15 != 0) goto L_0x025f
            java.lang.String r0 = "Resize location out of screen or close button is not visible."
            r1.zzg(r0)     // Catch:{ all -> 0x0482 }
            monitor-exit(r2)     // Catch:{ all -> 0x0482 }
            return
        L_0x025f:
            com.google.android.gms.ads.internal.client.zzaw.zzb()     // Catch:{ all -> 0x0482 }
            android.app.Activity r3 = r1.zzl     // Catch:{ all -> 0x0482 }
            int r4 = r1.zzi     // Catch:{ all -> 0x0482 }
            int r3 = com.google.android.gms.internal.ads.zzcgi.zzw(r3, r4)     // Catch:{ all -> 0x0482 }
            com.google.android.gms.ads.internal.client.zzaw.zzb()     // Catch:{ all -> 0x0482 }
            android.app.Activity r4 = r1.zzl     // Catch:{ all -> 0x0482 }
            int r6 = r1.zzf     // Catch:{ all -> 0x0482 }
            int r4 = com.google.android.gms.internal.ads.zzcgi.zzw(r4, r6)     // Catch:{ all -> 0x0482 }
            com.google.android.gms.internal.ads.zzcmp r6 = r1.zzk     // Catch:{ all -> 0x0482 }
            android.view.View r6 = (android.view.View) r6     // Catch:{ all -> 0x0482 }
            android.view.ViewParent r6 = r6.getParent()     // Catch:{ all -> 0x0482 }
            if (r6 == 0) goto L_0x0466
            boolean r8 = r6 instanceof android.view.ViewGroup     // Catch:{ all -> 0x0482 }
            if (r8 == 0) goto L_0x0466
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6     // Catch:{ all -> 0x0482 }
            com.google.android.gms.internal.ads.zzcmp r8 = r1.zzk     // Catch:{ all -> 0x0482 }
            android.view.View r8 = (android.view.View) r8     // Catch:{ all -> 0x0482 }
            r6.removeView(r8)     // Catch:{ all -> 0x0482 }
            android.widget.PopupWindow r8 = r1.zzq     // Catch:{ all -> 0x0482 }
            if (r8 != 0) goto L_0x02cb
            r1.zzs = r6     // Catch:{ all -> 0x0482 }
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x0482 }
            com.google.android.gms.internal.ads.zzcmp r6 = r1.zzk     // Catch:{ all -> 0x0482 }
            r8 = r6
            android.view.View r8 = (android.view.View) r8     // Catch:{ all -> 0x0482 }
            r8.setDrawingCacheEnabled(r7)     // Catch:{ all -> 0x0482 }
            r8 = r6
            android.view.View r8 = (android.view.View) r8     // Catch:{ all -> 0x0482 }
            android.graphics.Bitmap r8 = r8.getDrawingCache()     // Catch:{ all -> 0x0482 }
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r8)     // Catch:{ all -> 0x0482 }
            android.view.View r6 = (android.view.View) r6     // Catch:{ all -> 0x0482 }
            r6.setDrawingCacheEnabled(r5)     // Catch:{ all -> 0x0482 }
            android.widget.ImageView r6 = new android.widget.ImageView     // Catch:{ all -> 0x0482 }
            android.app.Activity r12 = r1.zzl     // Catch:{ all -> 0x0482 }
            r6.<init>(r12)     // Catch:{ all -> 0x0482 }
            r1.zzn = r6     // Catch:{ all -> 0x0482 }
            android.widget.ImageView r6 = r1.zzn     // Catch:{ all -> 0x0482 }
            r6.setImageBitmap(r8)     // Catch:{ all -> 0x0482 }
            com.google.android.gms.internal.ads.zzcmp r6 = r1.zzk     // Catch:{ all -> 0x0482 }
            com.google.android.gms.internal.ads.zzcoe r6 = r6.zzQ()     // Catch:{ all -> 0x0482 }
            r1.zzm = r6     // Catch:{ all -> 0x0482 }
            android.view.ViewGroup r6 = r1.zzs     // Catch:{ all -> 0x0482 }
            android.widget.ImageView r8 = r1.zzn     // Catch:{ all -> 0x0482 }
            r6.addView(r8)     // Catch:{ all -> 0x0482 }
            goto L_0x02ce
        L_0x02cb:
            r8.dismiss()     // Catch:{ all -> 0x0482 }
        L_0x02ce:
            android.widget.RelativeLayout r6 = new android.widget.RelativeLayout     // Catch:{ all -> 0x0482 }
            android.app.Activity r8 = r1.zzl     // Catch:{ all -> 0x0482 }
            r6.<init>(r8)     // Catch:{ all -> 0x0482 }
            r1.zzr = r6     // Catch:{ all -> 0x0482 }
            android.widget.RelativeLayout r6 = r1.zzr     // Catch:{ all -> 0x0482 }
            r6.setBackgroundColor(r5)     // Catch:{ all -> 0x0482 }
            android.widget.RelativeLayout r6 = r1.zzr     // Catch:{ all -> 0x0482 }
            android.view.ViewGroup$LayoutParams r8 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x0482 }
            r8.<init>(r3, r4)     // Catch:{ all -> 0x0482 }
            r6.setLayoutParams(r8)     // Catch:{ all -> 0x0482 }
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x0482 }
            android.widget.RelativeLayout r6 = r1.zzr     // Catch:{ all -> 0x0482 }
            android.widget.PopupWindow r8 = new android.widget.PopupWindow     // Catch:{ all -> 0x0482 }
            r8.<init>(r6, r3, r4, r5)     // Catch:{ all -> 0x0482 }
            r1.zzq = r8     // Catch:{ all -> 0x0482 }
            android.widget.PopupWindow r6 = r1.zzq     // Catch:{ all -> 0x0482 }
            r6.setOutsideTouchable(r5)     // Catch:{ all -> 0x0482 }
            android.widget.PopupWindow r6 = r1.zzq     // Catch:{ all -> 0x0482 }
            r6.setTouchable(r7)     // Catch:{ all -> 0x0482 }
            android.widget.PopupWindow r6 = r1.zzq     // Catch:{ all -> 0x0482 }
            boolean r8 = r1.zzc     // Catch:{ all -> 0x0482 }
            r8 = r8 ^ r7
            r6.setClippingEnabled(r8)     // Catch:{ all -> 0x0482 }
            android.widget.RelativeLayout r6 = r1.zzr     // Catch:{ all -> 0x0482 }
            com.google.android.gms.internal.ads.zzcmp r8 = r1.zzk     // Catch:{ all -> 0x0482 }
            android.view.View r8 = (android.view.View) r8     // Catch:{ all -> 0x0482 }
            r12 = -1
            r6.addView(r8, r12, r12)     // Catch:{ all -> 0x0482 }
            android.widget.LinearLayout r6 = new android.widget.LinearLayout     // Catch:{ all -> 0x0482 }
            android.app.Activity r8 = r1.zzl     // Catch:{ all -> 0x0482 }
            r6.<init>(r8)     // Catch:{ all -> 0x0482 }
            r1.zzo = r6     // Catch:{ all -> 0x0482 }
            android.widget.RelativeLayout$LayoutParams r6 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x0482 }
            com.google.android.gms.ads.internal.client.zzaw.zzb()     // Catch:{ all -> 0x0482 }
            android.app.Activity r8 = r1.zzl     // Catch:{ all -> 0x0482 }
            int r8 = com.google.android.gms.internal.ads.zzcgi.zzw(r8, r14)     // Catch:{ all -> 0x0482 }
            com.google.android.gms.ads.internal.client.zzaw.zzb()     // Catch:{ all -> 0x0482 }
            android.app.Activity r12 = r1.zzl     // Catch:{ all -> 0x0482 }
            int r12 = com.google.android.gms.internal.ads.zzcgi.zzw(r12, r14)     // Catch:{ all -> 0x0482 }
            r6.<init>(r8, r12)     // Catch:{ all -> 0x0482 }
            java.lang.String r8 = r1.zzb     // Catch:{ all -> 0x0482 }
            int r12 = r8.hashCode()     // Catch:{ all -> 0x0482 }
            switch(r12) {
                case -1364013995: goto L_0x036a;
                case -1012429441: goto L_0x0360;
                case -655373719: goto L_0x0356;
                case 1163912186: goto L_0x034c;
                case 1288627767: goto L_0x0342;
                case 1755462605: goto L_0x0338;
                default: goto L_0x0337;
            }
        L_0x0337:
            goto L_0x0374
        L_0x0338:
            java.lang.String r12 = "top-center"
            boolean r8 = r8.equals(r12)
            if (r8 == 0) goto L_0x0374
            r8 = r7
            goto L_0x0375
        L_0x0342:
            java.lang.String r12 = "bottom-center"
            boolean r8 = r8.equals(r12)
            if (r8 == 0) goto L_0x0374
            r8 = r10
            goto L_0x0375
        L_0x034c:
            java.lang.String r12 = "bottom-right"
            boolean r8 = r8.equals(r12)
            if (r8 == 0) goto L_0x0374
            r8 = r9
            goto L_0x0375
        L_0x0356:
            java.lang.String r12 = "bottom-left"
            boolean r8 = r8.equals(r12)
            if (r8 == 0) goto L_0x0374
            r8 = r11
            goto L_0x0375
        L_0x0360:
            java.lang.String r12 = "top-left"
            boolean r8 = r8.equals(r12)
            if (r8 == 0) goto L_0x0374
            r8 = r5
            goto L_0x0375
        L_0x036a:
            java.lang.String r12 = "center"
            boolean r8 = r8.equals(r12)
            if (r8 == 0) goto L_0x0374
            r8 = r13
            goto L_0x0375
        L_0x0374:
            r8 = -1
        L_0x0375:
            r12 = 9
            r14 = 10
            if (r8 == 0) goto L_0x03b6
            if (r8 == r7) goto L_0x03ad
            if (r8 == r13) goto L_0x03a7
            r13 = 12
            if (r8 == r11) goto L_0x03a0
            if (r8 == r10) goto L_0x0397
            r10 = 11
            if (r8 == r9) goto L_0x0390
            r6.addRule(r14)     // Catch:{ all -> 0x0482 }
            r6.addRule(r10)     // Catch:{ all -> 0x0482 }
            goto L_0x03bc
        L_0x0390:
            r6.addRule(r13)     // Catch:{ all -> 0x0482 }
            r6.addRule(r10)     // Catch:{ all -> 0x0482 }
            goto L_0x03bc
        L_0x0397:
            r6.addRule(r13)     // Catch:{ all -> 0x0482 }
            r8 = 14
            r6.addRule(r8)     // Catch:{ all -> 0x0482 }
            goto L_0x03bc
        L_0x03a0:
            r6.addRule(r13)     // Catch:{ all -> 0x0482 }
            r6.addRule(r12)     // Catch:{ all -> 0x0482 }
            goto L_0x03bc
        L_0x03a7:
            r8 = 13
            r6.addRule(r8)     // Catch:{ all -> 0x0482 }
            goto L_0x03bc
        L_0x03ad:
            r6.addRule(r14)     // Catch:{ all -> 0x0482 }
            r8 = 14
            r6.addRule(r8)     // Catch:{ all -> 0x0482 }
            goto L_0x03bc
        L_0x03b6:
            r6.addRule(r14)     // Catch:{ all -> 0x0482 }
            r6.addRule(r12)     // Catch:{ all -> 0x0482 }
        L_0x03bc:
            android.widget.LinearLayout r8 = r1.zzo     // Catch:{ all -> 0x0482 }
            com.google.android.gms.internal.ads.zzbxy r9 = new com.google.android.gms.internal.ads.zzbxy     // Catch:{ all -> 0x0482 }
            r9.<init>(r1)     // Catch:{ all -> 0x0482 }
            r8.setOnClickListener(r9)     // Catch:{ all -> 0x0482 }
            android.widget.LinearLayout r8 = r1.zzo     // Catch:{ all -> 0x0482 }
            java.lang.String r9 = "Close button"
            r8.setContentDescription(r9)     // Catch:{ all -> 0x0482 }
            android.widget.RelativeLayout r8 = r1.zzr     // Catch:{ all -> 0x0482 }
            android.widget.LinearLayout r9 = r1.zzo     // Catch:{ all -> 0x0482 }
            r8.addView(r9, r6)     // Catch:{ all -> 0x0482 }
            android.widget.PopupWindow r6 = r1.zzq     // Catch:{ RuntimeException -> 0x0429 }
            android.view.View r0 = r0.getDecorView()     // Catch:{ RuntimeException -> 0x0429 }
            com.google.android.gms.ads.internal.client.zzaw.zzb()     // Catch:{ RuntimeException -> 0x0429 }
            android.app.Activity r8 = r1.zzl     // Catch:{ RuntimeException -> 0x0429 }
            r9 = r15[r5]     // Catch:{ RuntimeException -> 0x0429 }
            int r8 = com.google.android.gms.internal.ads.zzcgi.zzw(r8, r9)     // Catch:{ RuntimeException -> 0x0429 }
            com.google.android.gms.ads.internal.client.zzaw.zzb()     // Catch:{ RuntimeException -> 0x0429 }
            android.app.Activity r9 = r1.zzl     // Catch:{ RuntimeException -> 0x0429 }
            r10 = r15[r7]     // Catch:{ RuntimeException -> 0x0429 }
            int r9 = com.google.android.gms.internal.ads.zzcgi.zzw(r9, r10)     // Catch:{ RuntimeException -> 0x0429 }
            r6.showAtLocation(r0, r5, r8, r9)     // Catch:{ RuntimeException -> 0x0429 }
            r0 = r15[r5]     // Catch:{ all -> 0x0482 }
            r6 = r15[r7]     // Catch:{ all -> 0x0482 }
            com.google.android.gms.internal.ads.zzbyg r8 = r1.zzp     // Catch:{ all -> 0x0482 }
            if (r8 == 0) goto L_0x0402
            int r9 = r1.zzi     // Catch:{ all -> 0x0482 }
            int r10 = r1.zzf     // Catch:{ all -> 0x0482 }
            r8.zza(r0, r6, r9, r10)     // Catch:{ all -> 0x0482 }
        L_0x0402:
            com.google.android.gms.internal.ads.zzcmp r0 = r1.zzk     // Catch:{ all -> 0x0482 }
            com.google.android.gms.internal.ads.zzcoe r3 = com.google.android.gms.internal.ads.zzcoe.zzb(r3, r4)     // Catch:{ all -> 0x0482 }
            r0.zzai(r3)     // Catch:{ all -> 0x0482 }
            r0 = r15[r5]     // Catch:{ all -> 0x0482 }
            r3 = r15[r7]     // Catch:{ all -> 0x0482 }
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x0482 }
            android.app.Activity r4 = r1.zzl     // Catch:{ all -> 0x0482 }
            int[] r4 = com.google.android.gms.ads.internal.util.zzs.zzO(r4)     // Catch:{ all -> 0x0482 }
            r4 = r4[r5]     // Catch:{ all -> 0x0482 }
            int r3 = r3 - r4
            int r4 = r1.zzi     // Catch:{ all -> 0x0482 }
            int r5 = r1.zzf     // Catch:{ all -> 0x0482 }
            r1.zzj(r0, r3, r4, r5)     // Catch:{ all -> 0x0482 }
            java.lang.String r0 = "resized"
            r1.zzk(r0)     // Catch:{ all -> 0x0482 }
            monitor-exit(r2)     // Catch:{ all -> 0x0482 }
            return
        L_0x0429:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0482 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0482 }
            r3.<init>()     // Catch:{ all -> 0x0482 }
            java.lang.String r4 = "Cannot show popup window: "
            r3.append(r4)     // Catch:{ all -> 0x0482 }
            r3.append(r0)     // Catch:{ all -> 0x0482 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0482 }
            r1.zzg(r0)     // Catch:{ all -> 0x0482 }
            android.widget.RelativeLayout r0 = r1.zzr     // Catch:{ all -> 0x0482 }
            com.google.android.gms.internal.ads.zzcmp r3 = r1.zzk     // Catch:{ all -> 0x0482 }
            android.view.View r3 = (android.view.View) r3     // Catch:{ all -> 0x0482 }
            r0.removeView(r3)     // Catch:{ all -> 0x0482 }
            android.view.ViewGroup r0 = r1.zzs     // Catch:{ all -> 0x0482 }
            if (r0 == 0) goto L_0x0464
            android.widget.ImageView r3 = r1.zzn     // Catch:{ all -> 0x0482 }
            r0.removeView(r3)     // Catch:{ all -> 0x0482 }
            android.view.ViewGroup r0 = r1.zzs     // Catch:{ all -> 0x0482 }
            com.google.android.gms.internal.ads.zzcmp r3 = r1.zzk     // Catch:{ all -> 0x0482 }
            android.view.View r3 = (android.view.View) r3     // Catch:{ all -> 0x0482 }
            r0.addView(r3)     // Catch:{ all -> 0x0482 }
            com.google.android.gms.internal.ads.zzcmp r0 = r1.zzk     // Catch:{ all -> 0x0482 }
            com.google.android.gms.internal.ads.zzcoe r3 = r1.zzm     // Catch:{ all -> 0x0482 }
            r0.zzai(r3)     // Catch:{ all -> 0x0482 }
        L_0x0464:
            monitor-exit(r2)     // Catch:{ all -> 0x0482 }
            return
        L_0x0466:
            java.lang.String r0 = "Webview is detached, probably in the middle of a resize or expand."
            r1.zzg(r0)     // Catch:{ all -> 0x0482 }
            monitor-exit(r2)     // Catch:{ all -> 0x0482 }
            return
        L_0x046d:
            java.lang.String r0 = "Activity context is not ready, cannot get window or decor view."
            r1.zzg(r0)     // Catch:{ all -> 0x0482 }
            monitor-exit(r2)     // Catch:{ all -> 0x0482 }
            return
        L_0x0474:
            java.lang.String r0 = "Invalid width and height options. Cannot resize."
            r1.zzg(r0)     // Catch:{ all -> 0x0482 }
            monitor-exit(r2)     // Catch:{ all -> 0x0482 }
            return
        L_0x047b:
            java.lang.String r0 = "Cannot resize an expanded banner."
            r1.zzg(r0)     // Catch:{ all -> 0x0482 }
            monitor-exit(r2)     // Catch:{ all -> 0x0482 }
            return
        L_0x0482:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0482 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbxz.zzb(java.util.Map):void");
    }

    public final void zzc(int i, int i2, boolean z) {
        synchronized (this.zzj) {
            this.zzd = i;
            this.zze = i2;
        }
    }

    public final void zzd(int i, int i2) {
        this.zzd = i;
        this.zze = i2;
    }

    public final boolean zze() {
        boolean z;
        synchronized (this.zzj) {
            z = this.zzq != null;
        }
        return z;
    }
}
