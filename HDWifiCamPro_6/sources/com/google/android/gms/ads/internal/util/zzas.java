package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzchc;
import com.google.android.gms.internal.ads.zzeag;
import com.google.android.gms.internal.ads.zzeak;
import com.google.android.gms.internal.ads.zzfzq;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzas {
    private final Context zza;
    private final zzeak zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private int zzg;
    private int zzh;
    private PointF zzi;
    private PointF zzj;
    private Handler zzk;
    private Runnable zzl;

    public zzas(Context context) {
        this.zzg = 0;
        this.zzl = new zzar(this);
        this.zza = context;
        this.zzh = ViewConfiguration.get(context).getScaledTouchSlop();
        zzt.zzt().zzb();
        this.zzk = zzt.zzt().zza();
        this.zzb = zzt.zzs().zza();
    }

    private final void zzs(Context context) {
        ArrayList arrayList = new ArrayList();
        int zzu = zzu(arrayList, "None", true);
        int zzu2 = zzu(arrayList, "Shake", true);
        int zzu3 = zzu(arrayList, "Flick", true);
        zzeag zzeag = zzeag.NONE;
        int ordinal = this.zzb.zza().ordinal();
        int i = ordinal != 1 ? ordinal != 2 ? zzu : zzu3 : zzu2;
        zzt.zzp();
        AlertDialog.Builder zzG = zzs.zzG(context);
        AtomicInteger atomicInteger = new AtomicInteger(i);
        zzG.setTitle("Setup gesture");
        zzG.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[0]), i, new zzaj(atomicInteger));
        zzG.setNegativeButton("Dismiss", new zzak(this));
        zzG.setPositiveButton("Save", new zzal(this, atomicInteger, i, zzu2, zzu3));
        zzG.setOnCancelListener(new zzam(this));
        zzG.create().show();
    }

    private final boolean zzt(float f, float f2, float f3, float f4) {
        return Math.abs(this.zzi.x - f) < ((float) this.zzh) && Math.abs(this.zzi.y - f2) < ((float) this.zzh) && Math.abs(this.zzj.x - f3) < ((float) this.zzh) && Math.abs(this.zzj.y - f4) < ((float) this.zzh);
    }

    private static final int zzu(List list, String str, boolean z) {
        if (!z) {
            return -1;
        }
        list.add(str);
        return list.size() - 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.zzc);
        sb.append(",DebugSignal: ");
        sb.append(this.zzf);
        sb.append(",AFMA Version: ");
        sb.append(this.zze);
        sb.append(",Ad Unit ID: ");
        sb.append(this.zzd);
        sb.append("}");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza() {
        zzs(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb() {
        zzs(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzfzq zzfzq) {
        if (!zzt.zzs().zzj(this.zza, this.zzd, this.zze)) {
            zzt.zzs().zzd(this.zza, this.zzd, this.zze);
        } else {
            zzfzq.execute(new zzaf(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzfzq zzfzq) {
        if (!zzt.zzs().zzj(this.zza, this.zzd, this.zze)) {
            zzt.zzs().zzd(this.zza, this.zzd, this.zze);
        } else {
            zzfzq.execute(new zzaq(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze() {
        zzt.zzs().zzc(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf() {
        zzt.zzs().zzc(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg() {
        this.zzg = 4;
        zzr();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(AtomicInteger atomicInteger, int i, int i2, int i3, DialogInterface dialogInterface, int i4) {
        if (atomicInteger.get() != i) {
            if (atomicInteger.get() == i2) {
                this.zzb.zzk(zzeag.SHAKE);
            } else if (atomicInteger.get() == i3) {
                this.zzb.zzk(zzeag.FLICK);
            } else {
                this.zzb.zzk(zzeag.NONE);
            }
        }
        zzr();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(String str, DialogInterface dialogInterface, int i) {
        zzt.zzp();
        zzs.zzJ(this.zza, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(int i, int i2, int i3, int i4, int i5, DialogInterface dialogInterface, int i6) {
        if (i6 == i) {
            if (!(this.zza instanceof Activity)) {
                zze.zzi("Can not create dialog without Activity Context");
                return;
            }
            String str = this.zzc;
            String str2 = "No debug information";
            if (!TextUtils.isEmpty(str)) {
                Uri build = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
                StringBuilder sb = new StringBuilder();
                zzt.zzp();
                Map zzL = zzs.zzL(build);
                for (String str3 : zzL.keySet()) {
                    sb.append(str3);
                    sb.append(" = ");
                    sb.append((String) zzL.get(str3));
                    sb.append("\n\n");
                }
                String trim = sb.toString().trim();
                if (!TextUtils.isEmpty(trim)) {
                    str2 = trim;
                }
            }
            zzt.zzp();
            AlertDialog.Builder zzG = zzs.zzG(this.zza);
            zzG.setMessage(str2);
            zzG.setTitle("Ad Information");
            zzG.setPositiveButton("Share", new zzad(this, str2));
            zzG.setNegativeButton("Close", zzae.zza);
            zzG.create().show();
        } else if (i6 == i2) {
            zze.zze("Debug mode [Creative Preview] selected.");
            zzchc.zza.execute(new zzac(this));
        } else if (i6 == i3) {
            zze.zze("Debug mode [Troubleshooting] selected.");
            zzchc.zza.execute(new zzag(this));
        } else if (i6 == i4) {
            zzfzq zzfzq = zzchc.zze;
            zzfzq zzfzq2 = zzchc.zza;
            if (this.zzb.zzn()) {
                zzfzq.execute(new zzan(this));
            } else {
                zzfzq2.execute(new zzao(this, zzfzq));
            }
        } else if (i6 == i5) {
            zzfzq zzfzq3 = zzchc.zze;
            zzfzq zzfzq4 = zzchc.zza;
            if (this.zzb.zzn()) {
                zzfzq3.execute(new zzah(this));
            } else {
                zzfzq4.execute(new zzai(this, zzfzq3));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk() {
        zzaw zzs = zzt.zzs();
        Context context = this.zza;
        String str = this.zzd;
        String str2 = this.zze;
        String str3 = this.zzf;
        boolean zzm = zzs.zzm();
        zzs.zzh(zzs.zzj(context, str, str2));
        if (zzs.zzm()) {
            if (!zzm && !TextUtils.isEmpty(str3)) {
                zzs.zze(context, str2, str3, str);
            }
            zze.zze("Device is linked for debug signals.");
            zzs.zzi(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        zzs.zzd(context, str, str2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl() {
        zzaw zzs = zzt.zzs();
        Context context = this.zza;
        String str = this.zzd;
        String str2 = this.zze;
        if (!zzs.zzk(context, str, str2)) {
            zzs.zzi(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
        } else if ("2".equals(zzs.zza)) {
            zze.zze("Creative is not pushed for this device.");
            zzs.zzi(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(zzs.zza)) {
            zze.zze("The app is not linked for creative preview.");
            zzs.zzd(context, str, str2);
        } else if (MBridgeConstans.ENDCARD_URL_TYPE_PL.equals(zzs.zza)) {
            zze.zze("Device is linked for in app preview.");
            zzs.zzi(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final void zzm(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.zzg = 0;
            this.zzi = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        int i = this.zzg;
        if (i != -1) {
            if (i == 0) {
                if (actionMasked == 5) {
                    this.zzg = 5;
                    this.zzj = new PointF(motionEvent.getX(1), motionEvent.getY(1));
                    this.zzk.postDelayed(this.zzl, ((Long) zzay.zzc().zzb(zzbjc.zzdO)).longValue());
                }
            } else if (i == 5) {
                if (pointerCount == 2) {
                    if (actionMasked == 2) {
                        boolean z = false;
                        for (int i2 = 0; i2 < historySize; i2++) {
                            z |= !zzt(motionEvent.getHistoricalX(0, i2), motionEvent.getHistoricalY(0, i2), motionEvent.getHistoricalX(1, i2), motionEvent.getHistoricalY(1, i2));
                        }
                        if (zzt(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1)) && !z) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                this.zzg = -1;
                this.zzk.removeCallbacks(this.zzl);
            }
        }
    }

    public final void zzn(String str) {
        this.zzd = str;
    }

    public final void zzo(String str) {
        this.zze = str;
    }

    public final void zzp(String str) {
        this.zzc = str;
    }

    public final void zzq(String str) {
        this.zzf = str;
    }

    public final void zzr() {
        try {
            if (!(this.zza instanceof Activity)) {
                zze.zzi("Can not create dialog without Activity Context");
                return;
            }
            String str = "Creative preview (enabled)";
            if (true == TextUtils.isEmpty(zzt.zzs().zzb())) {
                str = "Creative preview";
            }
            String str2 = "Troubleshooting (enabled)";
            if (true != zzt.zzs().zzm()) {
                str2 = "Troubleshooting";
            }
            ArrayList arrayList = new ArrayList();
            int zzu = zzu(arrayList, "Ad information", true);
            int zzu2 = zzu(arrayList, str, true);
            int zzu3 = zzu(arrayList, str2, true);
            boolean booleanValue = ((Boolean) zzay.zzc().zzb(zzbjc.zzhT)).booleanValue();
            int zzu4 = zzu(arrayList, "Open ad inspector", booleanValue);
            int zzu5 = zzu(arrayList, "Ad inspector settings", booleanValue);
            zzt.zzp();
            AlertDialog.Builder zzG = zzs.zzG(this.zza);
            zzG.setTitle("Select a debug mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new zzap(this, zzu, zzu2, zzu3, zzu4, zzu5));
            zzG.create().show();
        } catch (WindowManager.BadTokenException e) {
            zze.zzb("", e);
        }
    }

    public zzas(Context context, String str) {
        this(context);
        this.zzc = str;
    }
}
