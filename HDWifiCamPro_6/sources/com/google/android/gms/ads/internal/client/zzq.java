package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final boolean zzd;
    public final int zze;
    public final int zzf;
    public final zzq[] zzg;
    public final boolean zzh;
    public final boolean zzi;
    public boolean zzj;
    public boolean zzk;
    public boolean zzl;
    public boolean zzm;
    public boolean zzn;
    public boolean zzo;

    public zzq() {
        this("interstitial_mb", 0, 0, true, 0, 0, (zzq[]) null, false, false, false, false, false, false, false, false);
    }

    public static int zza(DisplayMetrics displayMetrics) {
        return (int) (((float) zzf(displayMetrics)) * displayMetrics.density);
    }

    public static zzq zzb() {
        return new zzq("interstitial_mb", 0, 0, false, 0, 0, (zzq[]) null, false, false, false, false, true, false, false, false);
    }

    public static zzq zzc() {
        return new zzq("320x50_mb", 0, 0, false, 0, 0, (zzq[]) null, true, false, false, false, false, false, false, false);
    }

    public static zzq zzd() {
        return new zzq("reward_mb", 0, 0, true, 0, 0, (zzq[]) null, false, false, false, false, false, false, false, false);
    }

    public static zzq zze() {
        return new zzq("invalid", 0, 0, false, 0, 0, (zzq[]) null, false, false, false, true, false, false, false, false);
    }

    private static int zzf(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzb);
        SafeParcelWriter.writeInt(parcel, 4, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.writeInt(parcel, 6, this.zze);
        SafeParcelWriter.writeInt(parcel, 7, this.zzf);
        SafeParcelWriter.writeTypedArray(parcel, 8, this.zzg, i, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzj);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzk);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzl);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzm);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzn);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzo);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzq(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzq(android.content.Context r12, com.google.android.gms.ads.AdSize[] r13) {
        /*
            r11 = this;
            r11.<init>()
            r0 = 0
            r1 = r13[r0]
            r11.zzd = r0
            boolean r2 = r1.isFluid()
            r11.zzi = r2
            boolean r2 = com.google.android.gms.ads.zzb.zzf(r1)
            r11.zzm = r2
            boolean r2 = com.google.android.gms.ads.zzb.zzg(r1)
            r11.zzn = r2
            boolean r2 = com.google.android.gms.ads.zzb.zzh(r1)
            r11.zzo = r2
            boolean r3 = r11.zzi
            if (r3 == 0) goto L_0x0035
            com.google.android.gms.ads.AdSize r2 = com.google.android.gms.ads.AdSize.BANNER
            int r2 = r2.getWidth()
            r11.zze = r2
            com.google.android.gms.ads.AdSize r2 = com.google.android.gms.ads.AdSize.BANNER
            int r2 = r2.getHeight()
            r11.zzb = r2
            goto L_0x0061
        L_0x0035:
            boolean r3 = r11.zzn
            if (r3 == 0) goto L_0x0046
            int r2 = r1.getWidth()
            r11.zze = r2
            int r2 = com.google.android.gms.ads.zzb.zza(r1)
            r11.zzb = r2
            goto L_0x0061
        L_0x0046:
            if (r2 == 0) goto L_0x0055
            int r2 = r1.getWidth()
            r11.zze = r2
            int r2 = com.google.android.gms.ads.zzb.zzb(r1)
            r11.zzb = r2
            goto L_0x0061
        L_0x0055:
            int r2 = r1.getWidth()
            r11.zze = r2
            int r2 = r1.getHeight()
            r11.zzb = r2
        L_0x0061:
            int r3 = r11.zze
            android.content.res.Resources r4 = r12.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            r5 = -1
            if (r3 != r5) goto L_0x00f8
            com.google.android.gms.ads.internal.client.zzaw.zzb()
            android.content.res.Resources r6 = r12.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.orientation
            r7 = 2
            if (r6 == r7) goto L_0x007f
            goto L_0x00e0
        L_0x007f:
            android.content.res.Resources r6 = r12.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            int r7 = r6.heightPixels
            float r7 = (float) r7
            float r6 = r6.density
            float r7 = r7 / r6
            int r6 = (int) r7
            r7 = 600(0x258, float:8.41E-43)
            if (r6 >= r7) goto L_0x00e0
            com.google.android.gms.ads.internal.client.zzaw.zzb()
            android.content.res.Resources r6 = r12.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            java.lang.String r7 = "window"
            java.lang.Object r7 = r12.getSystemService(r7)
            android.view.WindowManager r7 = (android.view.WindowManager) r7
            if (r7 == 0) goto L_0x00e0
            android.view.Display r7 = r7.getDefaultDisplay()
            r7.getRealMetrics(r6)
            int r8 = r6.heightPixels
            int r9 = r6.widthPixels
            r7.getMetrics(r6)
            int r7 = r6.heightPixels
            int r6 = r6.widthPixels
            if (r7 != r8) goto L_0x00e0
            if (r6 != r9) goto L_0x00e0
            int r6 = r4.widthPixels
            com.google.android.gms.ads.internal.client.zzaw.zzb()
            android.content.res.Resources r7 = r12.getResources()
            java.lang.String r8 = "navigation_bar_width"
            java.lang.String r9 = "dimen"
            java.lang.String r10 = "android"
            int r7 = r7.getIdentifier(r8, r9, r10)
            if (r7 <= 0) goto L_0x00db
            android.content.res.Resources r8 = r12.getResources()
            int r7 = r8.getDimensionPixelSize(r7)
            goto L_0x00dc
        L_0x00db:
            r7 = r0
        L_0x00dc:
            int r6 = r6 - r7
            r11.zzf = r6
            goto L_0x00e4
        L_0x00e0:
            int r6 = r4.widthPixels
            r11.zzf = r6
        L_0x00e4:
            float r6 = (float) r6
            float r7 = r4.density
            float r6 = r6 / r7
            double r6 = (double) r6
            int r8 = (int) r6
            double r9 = (double) r8
            double r6 = r6 - r9
            r9 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r6 < 0) goto L_0x0105
            int r8 = r8 + 1
            goto L_0x0105
        L_0x00f8:
            int r8 = r11.zze
            com.google.android.gms.ads.internal.client.zzaw.zzb()
            int r6 = r11.zze
            int r6 = com.google.android.gms.internal.ads.zzcgi.zzo(r4, r6)
            r11.zzf = r6
        L_0x0105:
            r6 = -2
            if (r2 != r6) goto L_0x010d
            int r7 = zzf(r4)
            goto L_0x010f
        L_0x010d:
            int r7 = r11.zzb
        L_0x010f:
            com.google.android.gms.ads.internal.client.zzaw.zzb()
            int r4 = com.google.android.gms.internal.ads.zzcgi.zzo(r4, r7)
            r11.zzc = r4
            java.lang.String r4 = "_as"
            java.lang.String r9 = "x"
            if (r3 == r5) goto L_0x0154
            if (r2 != r6) goto L_0x0121
            goto L_0x0154
        L_0x0121:
            boolean r2 = r11.zzn
            if (r2 != 0) goto L_0x0138
            boolean r2 = r11.zzo
            if (r2 == 0) goto L_0x012a
            goto L_0x0138
        L_0x012a:
            boolean r2 = r11.zzi
            if (r2 == 0) goto L_0x0131
            java.lang.String r1 = "320x50_mb"
            goto L_0x0151
        L_0x0131:
            java.lang.String r1 = r1.toString()
            r11.zza = r1
            goto L_0x016b
        L_0x0138:
            int r1 = r11.zze
            int r2 = r11.zzb
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            r3.append(r9)
            r3.append(r2)
            r3.append(r4)
            java.lang.String r1 = r3.toString()
        L_0x0151:
            r11.zza = r1
            goto L_0x016b
        L_0x0154:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r8)
            r1.append(r9)
            r1.append(r7)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r11.zza = r1
        L_0x016b:
            int r1 = r13.length
            r2 = 1
            if (r1 <= r2) goto L_0x0185
            com.google.android.gms.ads.internal.client.zzq[] r1 = new com.google.android.gms.ads.internal.client.zzq[r1]
            r11.zzg = r1
            r1 = r0
        L_0x0174:
            int r2 = r13.length
            if (r1 >= r2) goto L_0x0188
            com.google.android.gms.ads.internal.client.zzq[] r2 = r11.zzg
            com.google.android.gms.ads.internal.client.zzq r3 = new com.google.android.gms.ads.internal.client.zzq
            r4 = r13[r1]
            r3.<init>((android.content.Context) r12, (com.google.android.gms.ads.AdSize) r4)
            r2[r1] = r3
            int r1 = r1 + 1
            goto L_0x0174
        L_0x0185:
            r12 = 0
            r11.zzg = r12
        L_0x0188:
            r11.zzh = r0
            r11.zzj = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzq.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    zzq(String str, int i, int i2, boolean z, int i3, int i4, zzq[] zzqArr, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = z;
        this.zze = i3;
        this.zzf = i4;
        this.zzg = zzqArr;
        this.zzh = z2;
        this.zzi = z3;
        this.zzj = z4;
        this.zzk = z5;
        this.zzl = z6;
        this.zzm = z7;
        this.zzn = z8;
        this.zzo = z9;
    }
}
