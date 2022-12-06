package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbt {
    private static final ArrayList zza = new ArrayList();
    private static final Pattern zzb = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(java.lang.String r6, java.lang.String r7) {
        /*
            int r0 = r6.hashCode()
            r1 = 8
            r2 = 7
            r3 = 5
            r4 = 6
            r5 = 0
            switch(r0) {
                case -2123537834: goto L_0x005f;
                case -1095064472: goto L_0x0055;
                case -53558318: goto L_0x004b;
                case 187078296: goto L_0x0041;
                case 187078297: goto L_0x0037;
                case 1504578661: goto L_0x002d;
                case 1504831518: goto L_0x0023;
                case 1505942594: goto L_0x0019;
                case 1556697186: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0069
        L_0x000f:
            java.lang.String r0 = "audio/true-hd"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0069
            r6 = r1
            goto L_0x006a
        L_0x0019:
            java.lang.String r0 = "audio/vnd.dts.hd"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0069
            r6 = r2
            goto L_0x006a
        L_0x0023:
            java.lang.String r0 = "audio/mpeg"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0069
            r6 = r5
            goto L_0x006a
        L_0x002d:
            java.lang.String r0 = "audio/eac3"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0069
            r6 = 3
            goto L_0x006a
        L_0x0037:
            java.lang.String r0 = "audio/ac4"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0069
            r6 = r3
            goto L_0x006a
        L_0x0041:
            java.lang.String r0 = "audio/ac3"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0069
            r6 = 2
            goto L_0x006a
        L_0x004b:
            java.lang.String r0 = "audio/mp4a-latm"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0069
            r6 = 1
            goto L_0x006a
        L_0x0055:
            java.lang.String r0 = "audio/vnd.dts"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0069
            r6 = r4
            goto L_0x006a
        L_0x005f:
            java.lang.String r0 = "audio/eac3-joc"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0069
            r6 = 4
            goto L_0x006a
        L_0x0069:
            r6 = -1
        L_0x006a:
            switch(r6) {
                case 0: goto L_0x008a;
                case 1: goto L_0x007b;
                case 2: goto L_0x007a;
                case 3: goto L_0x0079;
                case 4: goto L_0x0076;
                case 5: goto L_0x0073;
                case 6: goto L_0x0072;
                case 7: goto L_0x0071;
                case 8: goto L_0x006e;
                default: goto L_0x006d;
            }
        L_0x006d:
            return r5
        L_0x006e:
            r6 = 14
            return r6
        L_0x0071:
            return r1
        L_0x0072:
            return r2
        L_0x0073:
            r6 = 17
            return r6
        L_0x0076:
            r6 = 18
            return r6
        L_0x0079:
            return r4
        L_0x007a:
            return r3
        L_0x007b:
            if (r7 != 0) goto L_0x007e
            return r5
        L_0x007e:
            com.google.android.gms.internal.ads.zzbs r6 = zzc(r7)
            if (r6 != 0) goto L_0x0085
            return r5
        L_0x0085:
            int r6 = r6.zza()
            return r6
        L_0x008a:
            r6 = 9
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbt.zza(java.lang.String, java.lang.String):int");
    }

    public static int zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (zzg(str)) {
            return 1;
        }
        if (zzh(str)) {
            return 2;
        }
        if (MimeTypes.BASE_TYPE_TEXT.equals(zzi(str)) || MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str) || MimeTypes.APPLICATION_MP4CEA608.equals(str) || MimeTypes.APPLICATION_SUBRIP.equals(str) || MimeTypes.APPLICATION_TTML.equals(str) || MimeTypes.APPLICATION_TX3G.equals(str) || MimeTypes.APPLICATION_MP4VTT.equals(str) || MimeTypes.APPLICATION_RAWCC.equals(str) || MimeTypes.APPLICATION_VOBSUB.equals(str) || MimeTypes.APPLICATION_PGS.equals(str) || MimeTypes.APPLICATION_DVBSUBS.equals(str)) {
            return 3;
        }
        if ("image".equals(zzi(str))) {
            return 4;
        }
        if (MimeTypes.APPLICATION_ID3.equals(str) || MimeTypes.APPLICATION_EMSG.equals(str) || MimeTypes.APPLICATION_SCTE35.equals(str)) {
            return 5;
        }
        if (MimeTypes.APPLICATION_CAMERA_MOTION.equals(str)) {
            return 6;
        }
        int size = zza.size();
        for (int i = 0; i < size; i++) {
            zzbr zzbr = (zzbr) zza.get(i);
            String str2 = zzbr.zza;
            if (str.equals((Object) null)) {
                int i2 = zzbr.zzb;
                return 0;
            }
        }
        return -1;
    }

    static zzbs zzc(String str) {
        Matcher matcher = zzb.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(1);
        if (group != null) {
            String group2 = matcher.group(2);
            try {
                return new zzbs(Integer.parseInt(group, 16), group2 != null ? Integer.parseInt(group2) : 0);
            } catch (NumberFormatException unused) {
                return null;
            }
        } else {
            throw null;
        }
    }

    public static String zzd(int i) {
        if (i == 32) {
            return MimeTypes.VIDEO_MP4V;
        }
        if (i == 33) {
            return "video/avc";
        }
        if (i == 35) {
            return "video/hevc";
        }
        if (i == 64) {
            return MimeTypes.AUDIO_AAC;
        }
        if (i == 163) {
            return MimeTypes.VIDEO_VC1;
        }
        if (i == 177) {
            return MimeTypes.VIDEO_VP9;
        }
        if (i == 165) {
            return MimeTypes.AUDIO_AC3;
        }
        if (i == 166) {
            return MimeTypes.AUDIO_E_AC3;
        }
        switch (i) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return MimeTypes.VIDEO_MPEG2;
            case 102:
            case 103:
            case 104:
                return MimeTypes.AUDIO_AAC;
            case 105:
            case 107:
                return MimeTypes.AUDIO_MPEG;
            case 106:
                return MimeTypes.VIDEO_MPEG;
            default:
                switch (i) {
                    case 169:
                    case 172:
                        return MimeTypes.AUDIO_DTS;
                    case 170:
                    case 171:
                        return MimeTypes.AUDIO_DTS_HD;
                    case 173:
                        return MimeTypes.AUDIO_OPUS;
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0042 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String zze(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -1007807498(0xffffffffc3ee13f6, float:-476.15594)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = -586683234(0xffffffffdd07ec9e, float:-6.1214856E17)
            if (r0 == r1) goto L_0x0020
            r1 = 187090231(0xb26c537, float:3.2118805E-32)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "audio/mp3"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = r3
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "audio/x-wav"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = r2
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "audio/x-flac"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 0
            goto L_0x0035
        L_0x0034:
            r0 = -1
        L_0x0035:
            if (r0 == 0) goto L_0x0042
            if (r0 == r3) goto L_0x003f
            if (r0 == r2) goto L_0x003c
            return r4
        L_0x003c:
            java.lang.String r4 = "audio/wav"
            return r4
        L_0x003f:
            java.lang.String r4 = "audio/mpeg"
            return r4
        L_0x0042:
            java.lang.String r4 = "audio/flac"
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbt.zze(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0090, code lost:
        r3 = (r3 = zzc(r4)).zza();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zzf(java.lang.String r3, java.lang.String r4) {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r3.hashCode()
            r2 = 1
            switch(r1) {
                case -2123537834: goto L_0x0076;
                case -432837260: goto L_0x006c;
                case -432837259: goto L_0x0062;
                case -53558318: goto L_0x0057;
                case 187078296: goto L_0x004d;
                case 187094639: goto L_0x0043;
                case 1504578661: goto L_0x0038;
                case 1504619009: goto L_0x002e;
                case 1504831518: goto L_0x0024;
                case 1903231877: goto L_0x0019;
                case 1903589369: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0081
        L_0x000e:
            java.lang.String r1 = "audio/g711-mlaw"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0081
            r3 = 5
            goto L_0x0082
        L_0x0019:
            java.lang.String r1 = "audio/g711-alaw"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0081
            r3 = 4
            goto L_0x0082
        L_0x0024:
            java.lang.String r1 = "audio/mpeg"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0081
            r3 = r0
            goto L_0x0082
        L_0x002e:
            java.lang.String r1 = "audio/flac"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0081
            r3 = 6
            goto L_0x0082
        L_0x0038:
            java.lang.String r1 = "audio/eac3"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0081
            r3 = 8
            goto L_0x0082
        L_0x0043:
            java.lang.String r1 = "audio/raw"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0081
            r3 = 3
            goto L_0x0082
        L_0x004d:
            java.lang.String r1 = "audio/ac3"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0081
            r3 = 7
            goto L_0x0082
        L_0x0057:
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0081
            r3 = 10
            goto L_0x0082
        L_0x0062:
            java.lang.String r1 = "audio/mpeg-L2"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0081
            r3 = 2
            goto L_0x0082
        L_0x006c:
            java.lang.String r1 = "audio/mpeg-L1"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0081
            r3 = r2
            goto L_0x0082
        L_0x0076:
            java.lang.String r1 = "audio/eac3-joc"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0081
            r3 = 9
            goto L_0x0082
        L_0x0081:
            r3 = -1
        L_0x0082:
            switch(r3) {
                case 0: goto L_0x009c;
                case 1: goto L_0x009c;
                case 2: goto L_0x009c;
                case 3: goto L_0x009c;
                case 4: goto L_0x009c;
                case 5: goto L_0x009c;
                case 6: goto L_0x009c;
                case 7: goto L_0x009c;
                case 8: goto L_0x009c;
                case 9: goto L_0x009c;
                case 10: goto L_0x0086;
                default: goto L_0x0085;
            }
        L_0x0085:
            return r0
        L_0x0086:
            if (r4 != 0) goto L_0x0089
            return r0
        L_0x0089:
            com.google.android.gms.internal.ads.zzbs r3 = zzc(r4)
            if (r3 != 0) goto L_0x0090
            return r0
        L_0x0090:
            int r3 = r3.zza()
            if (r3 == 0) goto L_0x009b
            r4 = 16
            if (r3 == r4) goto L_0x009b
            return r2
        L_0x009b:
            return r0
        L_0x009c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbt.zzf(java.lang.String, java.lang.String):boolean");
    }

    public static boolean zzg(String str) {
        return MimeTypes.BASE_TYPE_AUDIO.equals(zzi(str));
    }

    public static boolean zzh(String str) {
        return "video".equals(zzi(str));
    }

    private static String zzi(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }
}
