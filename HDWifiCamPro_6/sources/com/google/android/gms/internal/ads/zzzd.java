package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzzd implements zzzp {
    private static final int[] zza = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14};
    private static final zzzc zzc = new zzzc(zzyz.zza);
    private static final zzzc zzd = new zzzc(zzza.zza);

    private static final void zzc(int i, List list) {
        switch (i) {
            case 0:
                list.add(new zzagr());
                return;
            case 1:
                list.add(new zzagu());
                return;
            case 2:
                list.add(new zzagx(0));
                return;
            case 3:
                list.add(new zzaax(0));
                return;
            case 4:
                zzzi zza2 = zzc.zza(0);
                if (zza2 != null) {
                    list.add(zza2);
                    return;
                } else {
                    list.add(new zzabo(0));
                    return;
                }
            case 5:
                list.add(new zzabr());
                return;
            case 6:
                list.add(new zzaei(0));
                return;
            case 7:
                list.add(new zzaeq(0));
                return;
            case 8:
                list.add(new zzafl(0, (zzel) null));
                list.add(new zzafq(0));
                return;
            case 9:
                list.add(new zzagf());
                return;
            case 10:
                list.add(new zzaia());
                return;
            case 11:
                list.add(new zzaik(1, 0, 112800));
                return;
            case 12:
                list.add(new zzaiw());
                return;
            case 14:
                list.add(new zzabw());
                return;
            case 15:
                zzzi zza3 = zzd.zza(new Object[0]);
                if (zza3 != null) {
                    list.add(zza3);
                    return;
                }
                return;
            case 16:
                list.add(new zzabc());
                return;
            default:
                return;
        }
    }

    public final synchronized zzzi[] zza() {
        return zzb(Uri.EMPTY, new HashMap());
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0175, code lost:
        r2 = 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0177, code lost:
        r2 = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0179, code lost:
        r2 = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x017b, code lost:
        r2 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x017d, code lost:
        r2 = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x017f, code lost:
        r2 = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0181, code lost:
        r2 = 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0183, code lost:
        r2 = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0185, code lost:
        r2 = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0187, code lost:
        r2 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0189, code lost:
        r2 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x018b, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0167, code lost:
        r2 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0168, code lost:
        switch(r2) {
            case 0: goto L_0x018b;
            case 1: goto L_0x018b;
            case 2: goto L_0x018b;
            case 3: goto L_0x0189;
            case 4: goto L_0x0187;
            case 5: goto L_0x0187;
            case 6: goto L_0x0187;
            case 7: goto L_0x0185;
            case 8: goto L_0x0183;
            case 9: goto L_0x0181;
            case 10: goto L_0x017f;
            case 11: goto L_0x017f;
            case 12: goto L_0x017f;
            case 13: goto L_0x017f;
            case 14: goto L_0x017f;
            case 15: goto L_0x017d;
            case 16: goto L_0x017b;
            case 17: goto L_0x017b;
            case 18: goto L_0x017b;
            case 19: goto L_0x0179;
            case 20: goto L_0x0177;
            case 21: goto L_0x0175;
            case 22: goto L_0x0173;
            case 23: goto L_0x0171;
            case 24: goto L_0x016f;
            case 25: goto L_0x016d;
            default: goto L_0x016b;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x016d, code lost:
        r2 = 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x016f, code lost:
        r2 = 14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0171, code lost:
        r2 = 13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0173, code lost:
        r2 = 12;
     */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x030a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.ads.zzzi[] zzb(android.net.Uri r18, java.util.Map r19) {
        /*
            r17 = this;
            monitor-enter(r17)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0324 }
            r1 = 16
            r0.<init>(r1)     // Catch:{ all -> 0x0324 }
            java.lang.String r2 = "Content-Type"
            r3 = r19
            java.lang.Object r2 = r3.get(r2)     // Catch:{ all -> 0x0324 }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x0324 }
            r3 = 0
            if (r2 == 0) goto L_0x0023
            boolean r4 = r2.isEmpty()     // Catch:{ all -> 0x0324 }
            if (r4 == 0) goto L_0x001c
            goto L_0x0023
        L_0x001c:
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0324 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0324 }
            goto L_0x0024
        L_0x0023:
            r2 = 0
        L_0x0024:
            r5 = 14
            r6 = 13
            r7 = 12
            r8 = 11
            r9 = 9
            r10 = 6
            r11 = 1
            r12 = 15
            r13 = 10
            r14 = 8
            r15 = -1
            if (r2 != 0) goto L_0x003c
        L_0x0039:
            r2 = r15
            goto L_0x018c
        L_0x003c:
            java.lang.String r2 = com.google.android.gms.internal.ads.zzbt.zze(r2)     // Catch:{ all -> 0x0324 }
            int r16 = r2.hashCode()     // Catch:{ all -> 0x0324 }
            switch(r16) {
                case -2123537834: goto L_0x015d;
                case -1662384011: goto L_0x0152;
                case -1662384007: goto L_0x0147;
                case -1662095187: goto L_0x013d;
                case -1606874997: goto L_0x0133;
                case -1487394660: goto L_0x0128;
                case -1248337486: goto L_0x011d;
                case -1079884372: goto L_0x0112;
                case -1004728940: goto L_0x0107;
                case -387023398: goto L_0x00fc;
                case -43467528: goto L_0x00f1;
                case 13915911: goto L_0x00e6;
                case 187078296: goto L_0x00db;
                case 187078297: goto L_0x00d0;
                case 187078669: goto L_0x00c5;
                case 187090232: goto L_0x00b9;
                case 187091926: goto L_0x00ad;
                case 187099443: goto L_0x00a1;
                case 1331848029: goto L_0x0096;
                case 1503095341: goto L_0x008b;
                case 1504578661: goto L_0x0080;
                case 1504619009: goto L_0x0075;
                case 1504824762: goto L_0x006a;
                case 1504831518: goto L_0x005f;
                case 1505118770: goto L_0x0054;
                case 2039520277: goto L_0x0049;
                default: goto L_0x0047;
            }     // Catch:{ all -> 0x0324 }
        L_0x0047:
            goto L_0x0167
        L_0x0049:
            java.lang.String r3 = "video/x-matroska"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = r13
            goto L_0x0168
        L_0x0054:
            java.lang.String r3 = "audio/webm"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = r6
            goto L_0x0168
        L_0x005f:
            java.lang.String r3 = "audio/mpeg"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = r12
            goto L_0x0168
        L_0x006a:
            java.lang.String r3 = "audio/midi"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = r9
            goto L_0x0168
        L_0x0075:
            java.lang.String r3 = "audio/flac"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = 7
            goto L_0x0168
        L_0x0080:
            java.lang.String r3 = "audio/eac3"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = r11
            goto L_0x0168
        L_0x008b:
            java.lang.String r3 = "audio/3gpp"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = 5
            goto L_0x0168
        L_0x0096:
            java.lang.String r3 = "video/mp4"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = r1
            goto L_0x0168
        L_0x00a1:
            java.lang.String r3 = "audio/wav"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = 22
            goto L_0x0168
        L_0x00ad:
            java.lang.String r3 = "audio/ogg"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = 19
            goto L_0x0168
        L_0x00b9:
            java.lang.String r3 = "audio/mp4"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = 17
            goto L_0x0168
        L_0x00c5:
            java.lang.String r3 = "audio/amr"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = 4
            goto L_0x0168
        L_0x00d0:
            java.lang.String r3 = "audio/ac4"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = 3
            goto L_0x0168
        L_0x00db:
            java.lang.String r3 = "audio/ac3"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = 0
            goto L_0x0168
        L_0x00e6:
            java.lang.String r3 = "video/x-flv"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = r14
            goto L_0x0168
        L_0x00f1:
            java.lang.String r3 = "application/webm"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = r5
            goto L_0x0168
        L_0x00fc:
            java.lang.String r3 = "audio/x-matroska"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = r8
            goto L_0x0168
        L_0x0107:
            java.lang.String r3 = "text/vtt"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = 23
            goto L_0x0168
        L_0x0112:
            java.lang.String r3 = "video/x-msvideo"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = 25
            goto L_0x0168
        L_0x011d:
            java.lang.String r3 = "application/mp4"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = 18
            goto L_0x0168
        L_0x0128:
            java.lang.String r3 = "image/jpeg"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = 24
            goto L_0x0168
        L_0x0133:
            java.lang.String r3 = "audio/amr-wb"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = r10
            goto L_0x0168
        L_0x013d:
            java.lang.String r3 = "video/webm"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = r7
            goto L_0x0168
        L_0x0147:
            java.lang.String r3 = "video/mp2t"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = 21
            goto L_0x0168
        L_0x0152:
            java.lang.String r3 = "video/mp2p"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = 20
            goto L_0x0168
        L_0x015d:
            java.lang.String r3 = "audio/eac3-joc"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0324 }
            if (r2 == 0) goto L_0x0167
            r2 = 2
            goto L_0x0168
        L_0x0167:
            r2 = r15
        L_0x0168:
            switch(r2) {
                case 0: goto L_0x018b;
                case 1: goto L_0x018b;
                case 2: goto L_0x018b;
                case 3: goto L_0x0189;
                case 4: goto L_0x0187;
                case 5: goto L_0x0187;
                case 6: goto L_0x0187;
                case 7: goto L_0x0185;
                case 8: goto L_0x0183;
                case 9: goto L_0x0181;
                case 10: goto L_0x017f;
                case 11: goto L_0x017f;
                case 12: goto L_0x017f;
                case 13: goto L_0x017f;
                case 14: goto L_0x017f;
                case 15: goto L_0x017d;
                case 16: goto L_0x017b;
                case 17: goto L_0x017b;
                case 18: goto L_0x017b;
                case 19: goto L_0x0179;
                case 20: goto L_0x0177;
                case 21: goto L_0x0175;
                case 22: goto L_0x0173;
                case 23: goto L_0x0171;
                case 24: goto L_0x016f;
                case 25: goto L_0x016d;
                default: goto L_0x016b;
            }     // Catch:{ all -> 0x0324 }
        L_0x016b:
            goto L_0x0039
        L_0x016d:
            r2 = r1
            goto L_0x018c
        L_0x016f:
            r2 = r5
            goto L_0x018c
        L_0x0171:
            r2 = r6
            goto L_0x018c
        L_0x0173:
            r2 = r7
            goto L_0x018c
        L_0x0175:
            r2 = r8
            goto L_0x018c
        L_0x0177:
            r2 = r13
            goto L_0x018c
        L_0x0179:
            r2 = r9
            goto L_0x018c
        L_0x017b:
            r2 = r14
            goto L_0x018c
        L_0x017d:
            r2 = 7
            goto L_0x018c
        L_0x017f:
            r2 = r10
            goto L_0x018c
        L_0x0181:
            r2 = r12
            goto L_0x018c
        L_0x0183:
            r2 = 5
            goto L_0x018c
        L_0x0185:
            r2 = 4
            goto L_0x018c
        L_0x0187:
            r2 = 3
            goto L_0x018c
        L_0x0189:
            r2 = r11
            goto L_0x018c
        L_0x018b:
            r2 = 0
        L_0x018c:
            if (r2 == r15) goto L_0x0191
            zzc(r2, r0)     // Catch:{ all -> 0x0324 }
        L_0x0191:
            java.lang.String r3 = r18.getLastPathSegment()     // Catch:{ all -> 0x0324 }
            if (r3 != 0) goto L_0x019a
        L_0x0197:
            r3 = r15
            goto L_0x02fe
        L_0x019a:
            java.lang.String r4 = ".ac3"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 != 0) goto L_0x02fd
            java.lang.String r4 = ".ec3"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 == 0) goto L_0x01ac
            goto L_0x02fd
        L_0x01ac:
            java.lang.String r4 = ".ac4"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 == 0) goto L_0x01b7
            r3 = r11
            goto L_0x02fe
        L_0x01b7:
            java.lang.String r4 = ".adts"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 != 0) goto L_0x02fb
            java.lang.String r4 = ".aac"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 == 0) goto L_0x01c9
            goto L_0x02fb
        L_0x01c9:
            java.lang.String r4 = ".amr"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 == 0) goto L_0x01d4
            r3 = 3
            goto L_0x02fe
        L_0x01d4:
            java.lang.String r4 = ".flac"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 == 0) goto L_0x01df
            r3 = 4
            goto L_0x02fe
        L_0x01df:
            java.lang.String r4 = ".flv"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 == 0) goto L_0x01ea
            r3 = 5
            goto L_0x02fe
        L_0x01ea:
            java.lang.String r4 = ".mid"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 != 0) goto L_0x02f9
            java.lang.String r4 = ".midi"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 != 0) goto L_0x02f9
            java.lang.String r4 = ".smf"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 == 0) goto L_0x0204
            goto L_0x02f9
        L_0x0204:
            java.lang.String r4 = ".mk"
            int r11 = r3.length()     // Catch:{ all -> 0x0324 }
            int r11 = r11 + -4
            boolean r4 = r3.startsWith(r4, r11)     // Catch:{ all -> 0x0324 }
            if (r4 != 0) goto L_0x02f7
            java.lang.String r4 = ".webm"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 == 0) goto L_0x021c
            goto L_0x02f7
        L_0x021c:
            java.lang.String r4 = ".mp3"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 == 0) goto L_0x0227
            r3 = 7
            goto L_0x02fe
        L_0x0227:
            java.lang.String r4 = ".mp4"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 != 0) goto L_0x02f5
            java.lang.String r4 = ".m4"
            int r10 = r3.length()     // Catch:{ all -> 0x0324 }
            int r10 = r10 + -4
            boolean r4 = r3.startsWith(r4, r10)     // Catch:{ all -> 0x0324 }
            if (r4 != 0) goto L_0x02f5
            java.lang.String r4 = ".mp4"
            int r10 = r3.length()     // Catch:{ all -> 0x0324 }
            int r10 = r10 + -5
            boolean r4 = r3.startsWith(r4, r10)     // Catch:{ all -> 0x0324 }
            if (r4 != 0) goto L_0x02f5
            java.lang.String r4 = ".cmf"
            int r10 = r3.length()     // Catch:{ all -> 0x0324 }
            int r10 = r10 + -5
            boolean r4 = r3.startsWith(r4, r10)     // Catch:{ all -> 0x0324 }
            if (r4 == 0) goto L_0x025b
            goto L_0x02f5
        L_0x025b:
            java.lang.String r4 = ".og"
            int r10 = r3.length()     // Catch:{ all -> 0x0324 }
            int r10 = r10 + -4
            boolean r4 = r3.startsWith(r4, r10)     // Catch:{ all -> 0x0324 }
            if (r4 != 0) goto L_0x02f3
            java.lang.String r4 = ".opus"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 == 0) goto L_0x0273
            goto L_0x02f3
        L_0x0273:
            java.lang.String r4 = ".ps"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 != 0) goto L_0x02f1
            java.lang.String r4 = ".mpeg"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 != 0) goto L_0x02f1
            java.lang.String r4 = ".mpg"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 != 0) goto L_0x02f1
            java.lang.String r4 = ".m2p"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 == 0) goto L_0x0295
            goto L_0x02f1
        L_0x0295:
            java.lang.String r4 = ".ts"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 != 0) goto L_0x02ef
            java.lang.String r4 = ".ts"
            int r9 = r3.length()     // Catch:{ all -> 0x0324 }
            int r9 = r9 + -4
            boolean r4 = r3.startsWith(r4, r9)     // Catch:{ all -> 0x0324 }
            if (r4 == 0) goto L_0x02ac
            goto L_0x02ef
        L_0x02ac:
            java.lang.String r4 = ".wav"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 != 0) goto L_0x02ed
            java.lang.String r4 = ".wave"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 == 0) goto L_0x02bd
            goto L_0x02ed
        L_0x02bd:
            java.lang.String r4 = ".vtt"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 != 0) goto L_0x02eb
            java.lang.String r4 = ".webvtt"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 == 0) goto L_0x02ce
            goto L_0x02eb
        L_0x02ce:
            java.lang.String r4 = ".jpg"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 != 0) goto L_0x02e9
            java.lang.String r4 = ".jpeg"
            boolean r4 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r4 == 0) goto L_0x02df
            goto L_0x02e9
        L_0x02df:
            java.lang.String r4 = ".avi"
            boolean r3 = r3.endsWith(r4)     // Catch:{ all -> 0x0324 }
            if (r3 == 0) goto L_0x0197
            r3 = r1
            goto L_0x02fe
        L_0x02e9:
            r3 = r5
            goto L_0x02fe
        L_0x02eb:
            r3 = r6
            goto L_0x02fe
        L_0x02ed:
            r3 = r7
            goto L_0x02fe
        L_0x02ef:
            r3 = r8
            goto L_0x02fe
        L_0x02f1:
            r3 = r13
            goto L_0x02fe
        L_0x02f3:
            r3 = r9
            goto L_0x02fe
        L_0x02f5:
            r3 = r14
            goto L_0x02fe
        L_0x02f7:
            r3 = r10
            goto L_0x02fe
        L_0x02f9:
            r3 = r12
            goto L_0x02fe
        L_0x02fb:
            r3 = 2
            goto L_0x02fe
        L_0x02fd:
            r3 = 0
        L_0x02fe:
            if (r3 == r15) goto L_0x0305
            if (r3 == r2) goto L_0x0305
            zzc(r3, r0)     // Catch:{ all -> 0x0324 }
        L_0x0305:
            int[] r4 = zza     // Catch:{ all -> 0x0324 }
            r5 = 0
        L_0x0308:
            if (r5 >= r1) goto L_0x0316
            r6 = r4[r5]     // Catch:{ all -> 0x0324 }
            if (r6 == r2) goto L_0x0313
            if (r6 == r3) goto L_0x0313
            zzc(r6, r0)     // Catch:{ all -> 0x0324 }
        L_0x0313:
            int r5 = r5 + 1
            goto L_0x0308
        L_0x0316:
            int r1 = r0.size()     // Catch:{ all -> 0x0324 }
            com.google.android.gms.internal.ads.zzzi[] r1 = new com.google.android.gms.internal.ads.zzzi[r1]     // Catch:{ all -> 0x0324 }
            java.lang.Object[] r0 = r0.toArray(r1)     // Catch:{ all -> 0x0324 }
            com.google.android.gms.internal.ads.zzzi[] r0 = (com.google.android.gms.internal.ads.zzzi[]) r0     // Catch:{ all -> 0x0324 }
            monitor-exit(r17)
            return r0
        L_0x0324:
            r0 = move-exception
            monitor-exit(r17)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzd.zzb(android.net.Uri, java.util.Map):com.google.android.gms.internal.ads.zzzi[]");
    }
}
