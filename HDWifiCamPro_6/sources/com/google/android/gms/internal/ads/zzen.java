package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.ads.AdError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import kotlin.UByte;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzen {
    public static final int zza = Build.VERSION.SDK_INT;
    public static final String zzb = Build.DEVICE;
    public static final String zzc = Build.MANUFACTURER;
    public static final String zzd = Build.MODEL;
    public static final String zze;
    public static final byte[] zzf = new byte[0];
    private static final Pattern zzg = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
    private static final Pattern zzh = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
    private static final Pattern zzi = Pattern.compile("%([A-Fa-f0-9]{2})");
    private static final Pattern zzj = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
    private static HashMap zzk;
    private static final String[] zzl = {"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
    private static final String[] zzm = {"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
    private static final int[] zzn = {0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
    private static final int[] zzo = {0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, 144, 151, 158, 153, IronSourceConstants.USING_CACHE_FOR_INIT_EVENT, 139, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 133, 168, 175, 166, 161, 180, 179, 186, PsExtractor.PRIVATE_STREAM_1, 199, PsExtractor.AUDIO_STREAM, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, 136, TsExtractor.TS_STREAM_TYPE_AC3, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, 142, TsExtractor.TS_STREAM_TYPE_E_AC3, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, PsExtractor.VIDEO_STREAM_MASK, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED, 145, 152, 159, TsExtractor.TS_STREAM_TYPE_DTS, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, 250, 253, 244, 243};

    static {
        String str = zzb;
        String str2 = zzd;
        String str3 = zzc;
        int i = zza;
        zze = str + ", " + str2 + ", " + str3 + ", " + i;
    }

    public static Intent zzA(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (zza < 33) {
            return context.registerReceiver(broadcastReceiver, intentFilter);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, 4);
    }

    public static Point zzB(Context context) {
        String str;
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        Display display = displayManager != null ? displayManager.getDisplay(0) : null;
        if (display == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                display = windowManager.getDefaultDisplay();
            } else {
                throw null;
            }
        }
        if (display.getDisplayId() == 0 && zzX(context)) {
            if (zza < 28) {
                str = zzai("sys.display-size");
            } else {
                str = zzai("vendor.display-size");
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    String[] split = str.trim().split("x", -1);
                    if (split.length == 2) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        if (parseInt > 0 && parseInt2 > 0) {
                            return new Point(parseInt, parseInt2);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                zzdw.zzb("Util", "Invalid display size: ".concat(String.valueOf(str)));
            }
            if ("Sony".equals(zzc) && zzd.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        if (zza >= 23) {
            Display.Mode mode = display.getMode();
            point.x = mode.getPhysicalWidth();
            point.y = mode.getPhysicalHeight();
            return point;
        }
        display.getRealSize(point);
        return point;
    }

    public static Handler zzC(Looper looper, Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static Handler zzD(Handler.Callback callback) {
        Looper myLooper = Looper.myLooper();
        zzdd.zzb(myLooper);
        return new Handler(myLooper, (Handler.Callback) null);
    }

    public static Looper zzE() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            return myLooper;
        }
        return Looper.getMainLooper();
    }

    public static zzaf zzF(int i, int i2, int i3) {
        zzad zzad = new zzad();
        zzad.zzS(MimeTypes.AUDIO_RAW);
        zzad.zzw(i2);
        zzad.zzT(i3);
        zzad.zzN(i);
        return zzad.zzY();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0068 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b2 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzcc zzG(com.google.android.gms.internal.ads.zzcg r11, com.google.android.gms.internal.ads.zzcc r12) {
        /*
            boolean r0 = r11.zzs()
            boolean r1 = r11.zzc()
            r2 = r11
            com.google.android.gms.internal.ads.zzm r2 = (com.google.android.gms.internal.ads.zzm) r2
            com.google.android.gms.internal.ads.zzcn r3 = r2.zzn()
            boolean r4 = r3.zzo()
            r5 = -1
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L_0x001a
        L_0x0018:
            r3 = r7
            goto L_0x002b
        L_0x001a:
            int r4 = r2.zzf()
            r2.zzj()
            r2.zzr()
            int r3 = r3.zzk(r4, r7, r7)
            if (r3 == r5) goto L_0x0018
            r3 = r6
        L_0x002b:
            com.google.android.gms.internal.ads.zzcn r4 = r2.zzn()
            boolean r8 = r4.zzo()
            if (r8 == 0) goto L_0x0037
        L_0x0035:
            r2 = r7
            goto L_0x0048
        L_0x0037:
            int r8 = r2.zzf()
            r2.zzj()
            r2.zzr()
            int r2 = r4.zzj(r8, r7, r7)
            if (r2 == r5) goto L_0x0035
            r2 = r6
        L_0x0048:
            boolean r4 = r11.zzb()
            boolean r5 = r11.zza()
            com.google.android.gms.internal.ads.zzcn r11 = r11.zzn()
            boolean r11 = r11.zzo()
            com.google.android.gms.internal.ads.zzca r8 = new com.google.android.gms.internal.ads.zzca
            r8.<init>()
            r8.zzb(r12)
            r12 = 4
            r9 = r0 ^ 1
            r8.zzd(r12, r9)
            if (r1 == 0) goto L_0x006c
            if (r0 != 0) goto L_0x006c
            r12 = r6
            goto L_0x006d
        L_0x006c:
            r12 = r7
        L_0x006d:
            r10 = 5
            r8.zzd(r10, r12)
            if (r3 == 0) goto L_0x0077
            if (r0 != 0) goto L_0x0077
            r12 = r6
            goto L_0x0078
        L_0x0077:
            r12 = r7
        L_0x0078:
            r10 = 6
            r8.zzd(r10, r12)
            if (r11 != 0) goto L_0x0088
            if (r3 != 0) goto L_0x0084
            if (r4 == 0) goto L_0x0084
            if (r1 == 0) goto L_0x0088
        L_0x0084:
            if (r0 != 0) goto L_0x0088
            r12 = r6
            goto L_0x0089
        L_0x0088:
            r12 = r7
        L_0x0089:
            r3 = 7
            r8.zzd(r3, r12)
            if (r2 == 0) goto L_0x0093
            if (r0 != 0) goto L_0x0093
            r12 = r6
            goto L_0x0094
        L_0x0093:
            r12 = r7
        L_0x0094:
            r3 = 8
            r8.zzd(r3, r12)
            if (r11 != 0) goto L_0x00a5
            if (r2 != 0) goto L_0x00a1
            if (r4 == 0) goto L_0x00a5
            if (r5 == 0) goto L_0x00a5
        L_0x00a1:
            if (r0 != 0) goto L_0x00a5
            r11 = r6
            goto L_0x00a6
        L_0x00a5:
            r11 = r7
        L_0x00a6:
            r12 = 9
            r8.zzd(r12, r11)
            r11 = 10
            r8.zzd(r11, r9)
            if (r1 == 0) goto L_0x00b6
            if (r0 != 0) goto L_0x00b6
            r11 = r6
            goto L_0x00b7
        L_0x00b6:
            r11 = r7
        L_0x00b7:
            r12 = 11
            r8.zzd(r12, r11)
            if (r1 == 0) goto L_0x00c1
            if (r0 != 0) goto L_0x00c1
            r7 = r6
        L_0x00c1:
            r11 = 12
            r8.zzd(r11, r7)
            com.google.android.gms.internal.ads.zzcc r11 = r8.zze()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzen.zzG(com.google.android.gms.internal.ads.zzcg, com.google.android.gms.internal.ads.zzcc):com.google.android.gms.internal.ads.zzcc");
    }

    @EnsuresNonNull({"#1"})
    public static Object zzH(Object obj) {
        return obj;
    }

    public static String zzI(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String zzJ(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, zzfsk.zzc);
    }

    public static String zzK(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int length = objArr.length;
            if (i >= length) {
                return sb.toString();
            }
            sb.append(objArr[i].getClass().getSimpleName());
            if (i < length - 1) {
                sb.append(", ");
            }
            i++;
        }
    }

    public static String zzL(Context context) {
        TelephonyManager telephonyManager;
        if (!(context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null)) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return zzfse.zzb(networkCountryIso);
            }
        }
        return zzfse.zzb(Locale.getDefault().getCountry());
    }

    public static String zzM(int i) {
        if (i == 0) {
            return "NO";
        }
        if (i == 1) {
            return "NO_UNSUPPORTED_TYPE";
        }
        if (i == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (i == 3) {
            return "NO_EXCEEDS_CAPABILITIES";
        }
        if (i == 4) {
            return "YES";
        }
        throw new IllegalStateException();
    }

    public static String zzN(Locale locale) {
        if (zza >= 21) {
            return locale.toLanguageTag();
        }
        return locale.toString();
    }

    public static String zzO(int i) {
        switch (i) {
            case -2:
                return "none";
            case -1:
                return "unknown";
            case 0:
                return "default";
            case 1:
                return MimeTypes.BASE_TYPE_AUDIO;
            case 2:
                return "video";
            case 3:
                return MimeTypes.BASE_TYPE_TEXT;
            case 4:
                return "image";
            case 5:
                return TtmlNode.TAG_METADATA;
            default:
                return "camera motion";
        }
    }

    public static String zzP(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace('_', '-');
        if (!replace.isEmpty() && !replace.equals(C.LANGUAGE_UNDETERMINED)) {
            str = replace;
        }
        String zza2 = zzfse.zza(str);
        int i = 0;
        String str2 = zza2.split("-", 2)[0];
        if (zzk == null) {
            zzk = zzaj();
        }
        String str3 = (String) zzk.get(str2);
        if (str3 != null) {
            zza2 = str3.concat(String.valueOf(zza2.substring(str2.length())));
            str2 = str3;
        }
        if (!"no".equals(str2) && !"i".equals(str2) && !"zh".equals(str2)) {
            return zza2;
        }
        while (true) {
            String[] strArr = zzm;
            int length = strArr.length;
            if (i >= 18) {
                return zza2;
            }
            if (zza2.startsWith(strArr[i])) {
                String[] strArr2 = zzm;
                return String.valueOf(strArr2[i + 1]).concat(String.valueOf(zza2.substring(strArr2[i].length())));
            }
            i += 2;
        }
    }

    public static ExecutorService zzQ(String str) {
        return Executors.newSingleThreadExecutor(new zzem(str));
    }

    public static void zzS(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static boolean zzT(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean zzU(int i) {
        return i == 536870912 || i == 805306368 || i == 4;
    }

    public static boolean zzV(int i) {
        return i == 3 || i == 2 || i == 268435456 || i == 536870912 || i == 805306368 || i == 4;
    }

    public static boolean zzW(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || "file".equals(scheme);
    }

    public static boolean zzX(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static boolean zzY(Handler handler, Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    public static boolean zzZ(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static float zza(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f, f3));
    }

    public static byte[] zzaa(String str) {
        return str.getBytes(zzfsk.zzc);
    }

    public static byte[] zzab(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    @EnsuresNonNull({"#1"})
    public static Object[] zzac(Object[] objArr) {
        return objArr;
    }

    public static Object[] zzad(Object[] objArr, Object[] objArr2) {
        int length = objArr.length;
        int length2 = objArr2.length;
        Object[] copyOf = Arrays.copyOf(objArr, length + length2);
        System.arraycopy(objArr2, 0, copyOf, length, length2);
        return copyOf;
    }

    public static Object[] zzae(Object[] objArr, int i) {
        zzdd.zzd(i <= objArr.length);
        return Arrays.copyOf(objArr, i);
    }

    public static String[] zzaf() {
        String[] strArr;
        Configuration configuration = Resources.getSystem().getConfiguration();
        if (zza >= 24) {
            strArr = configuration.getLocales().toLanguageTags().split(",", -1);
        } else {
            strArr = new String[]{zzN(configuration.locale)};
        }
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = zzP(strArr[i]);
        }
        return strArr;
    }

    public static String[] zzag(String str, String str2) {
        return str.split(str2, -1);
    }

    public static String[] zzah(String str, String str2) {
        return str.split(str2, 2);
    }

    private static String zzai(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Exception e) {
            zzdw.zzc("Util", "Failed to read system property ".concat(str), e);
            return null;
        }
    }

    private static HashMap zzaj() {
        int length = zzl.length;
        HashMap hashMap = new HashMap(r2 + 88);
        int i = 0;
        for (String str : Locale.getISOLanguages()) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    hashMap.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = zzl;
            int length2 = strArr.length;
            if (i >= 88) {
                return hashMap;
            }
            hashMap.put(strArr[i], strArr[i + 1]);
            i += 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzb(long[] r2, long r3, boolean r5, boolean r6) {
        /*
            int r6 = java.util.Arrays.binarySearch(r2, r3)
            if (r6 >= 0) goto L_0x0008
            int r2 = ~r6
            goto L_0x0016
        L_0x0008:
            int r6 = r6 + 1
            int r0 = r2.length
            if (r6 >= r0) goto L_0x0013
            r0 = r2[r6]
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x0008
        L_0x0013:
            if (r5 != 0) goto L_0x0017
            r2 = r6
        L_0x0016:
            return r2
        L_0x0017:
            int r6 = r6 + -1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzen.zzb(long[], long, boolean, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzc(int[] r2, int r3, boolean r4, boolean r5) {
        /*
            int r0 = java.util.Arrays.binarySearch(r2, r3)
            if (r0 >= 0) goto L_0x000a
            int r0 = r0 + 2
            int r2 = -r0
            goto L_0x0018
        L_0x000a:
            int r0 = r0 + -1
            if (r0 < 0) goto L_0x0012
            r1 = r2[r0]
            if (r1 == r3) goto L_0x000a
        L_0x0012:
            if (r4 == 0) goto L_0x0017
            int r2 = r0 + 1
            goto L_0x0018
        L_0x0017:
            r2 = r0
        L_0x0018:
            if (r5 == 0) goto L_0x001f
            r3 = 0
            int r2 = java.lang.Math.max(r3, r2)
        L_0x001f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzen.zzc(int[], int, boolean, boolean):int");
    }

    public static int zzd(long[] jArr, long j, boolean z, boolean z2) {
        int i;
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            i = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0 || jArr[binarySearch] != j) {
                    i = binarySearch + 1;
                }
                binarySearch--;
                break;
            } while (jArr[binarySearch] != j);
            i = binarySearch + 1;
        }
        return z2 ? Math.max(0, i) : i;
    }

    public static int zze(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    public static int zzf(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i, i3));
    }

    public static int zzg(byte[] bArr, int i, int i2, int i3) {
        int i4 = -1;
        for (int i5 = 0; i5 < i2; i5++) {
            i4 = zzn[(i4 >>> 24) ^ (bArr[i5] & UByte.MAX_VALUE)] ^ (i4 << 8);
        }
        return i4;
    }

    public static int zzh(byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        while (i < i2) {
            i4 = zzo[i4 ^ (bArr[i] & UByte.MAX_VALUE)];
            i++;
        }
        return i4;
    }

    public static int zzi(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null) {
            return -1;
        }
        return audioManager.generateAudioSessionId();
    }

    public static int zzj(int i) {
        if (i == 12) {
            return zza >= 32 ? 743676 : 0;
        }
        switch (i) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                int i2 = zza;
                return (i2 < 23 && i2 < 21) ? 0 : 6396;
            default:
                return 0;
        }
    }

    public static int zzk(ByteBuffer byteBuffer, int i) {
        int i2 = byteBuffer.getInt(i);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i2 : Integer.reverseBytes(i2);
    }

    public static int zzl(int i) {
        if (i == 2 || i == 4) {
            return 6005;
        }
        if (i == 10) {
            return 6004;
        }
        if (i == 7) {
            return 6005;
        }
        if (i == 8) {
            return AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE;
        }
        switch (i) {
            case 15:
                return AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE;
            case 16:
            case 18:
                return 6005;
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                return 6004;
            default:
                switch (i) {
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        return AdError.ICONVIEW_MISSING_ERROR_CODE;
                    default:
                        return 6006;
                }
        }
    }

    public static int zzm(String str) {
        String[] split;
        int length;
        if (str == null || (length = split.length) < 2) {
            return 0;
        }
        String str2 = (split = str.split("_", -1))[length - 1];
        boolean z = length >= 3 && "neg".equals(split[length + -2]);
        if (str2 != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                return z ? -parseInt : parseInt;
            } catch (NumberFormatException unused) {
                return 0;
            }
        } else {
            throw null;
        }
    }

    public static int zzn(int i) {
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 2;
        }
        if (i != 24) {
            return i != 32 ? 0 : 805306368;
        }
        return 536870912;
    }

    public static int zzo(int i, int i2) {
        if (i != 2) {
            if (i == 3) {
                return i2;
            }
            if (i != 4) {
                if (i != 268435456) {
                    if (i == 536870912) {
                        return i2 * 3;
                    }
                    if (i != 805306368) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            return i2 * 4;
        }
        return i2 + i2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzp(android.net.Uri r7) {
        /*
            java.lang.String r0 = r7.getScheme()
            r1 = 3
            if (r0 == 0) goto L_0x0011
            java.lang.String r2 = "rtsp"
            boolean r0 = com.google.android.gms.internal.ads.zzfse.zzc(r2, r0)
            if (r0 != 0) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            return r1
        L_0x0011:
            java.lang.String r0 = r7.getLastPathSegment()
            r2 = 4
            if (r0 != 0) goto L_0x0019
            return r2
        L_0x0019:
            r3 = 46
            int r3 = r0.lastIndexOf(r3)
            r4 = 0
            r5 = 2
            r6 = 1
            if (r3 < 0) goto L_0x0071
            int r3 = r3 + r6
            java.lang.String r0 = r0.substring(r3)
            java.lang.String r0 = com.google.android.gms.internal.ads.zzfse.zza(r0)
            int r3 = r0.hashCode()
            switch(r3) {
                case 104579: goto L_0x0053;
                case 108321: goto L_0x0049;
                case 3242057: goto L_0x003f;
                case 3299913: goto L_0x0035;
                default: goto L_0x0034;
            }
        L_0x0034:
            goto L_0x005d
        L_0x0035:
            java.lang.String r3 = "m3u8"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x005d
            r0 = r6
            goto L_0x005e
        L_0x003f:
            java.lang.String r3 = "isml"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x005d
            r0 = r1
            goto L_0x005e
        L_0x0049:
            java.lang.String r3 = "mpd"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x005d
            r0 = r4
            goto L_0x005e
        L_0x0053:
            java.lang.String r3 = "ism"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x005d
            r0 = r5
            goto L_0x005e
        L_0x005d:
            r0 = -1
        L_0x005e:
            if (r0 == 0) goto L_0x006c
            if (r0 == r6) goto L_0x006a
            if (r0 == r5) goto L_0x0068
            if (r0 == r1) goto L_0x0068
            r0 = r2
            goto L_0x006d
        L_0x0068:
            r0 = r6
            goto L_0x006d
        L_0x006a:
            r0 = r5
            goto L_0x006d
        L_0x006c:
            r0 = r4
        L_0x006d:
            if (r0 != r2) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            return r0
        L_0x0071:
            java.util.regex.Pattern r0 = zzj
            java.lang.String r7 = r7.getPath()
            if (r7 == 0) goto L_0x009d
            java.util.regex.Matcher r7 = r0.matcher(r7)
            boolean r0 = r7.matches()
            if (r0 == 0) goto L_0x009c
            java.lang.String r7 = r7.group(r5)
            if (r7 == 0) goto L_0x009b
            java.lang.String r0 = "format=mpd-time-csf"
            boolean r0 = r7.contains(r0)
            if (r0 == 0) goto L_0x0092
            return r4
        L_0x0092:
            java.lang.String r0 = "format=m3u8-aapl"
            boolean r7 = r7.contains(r0)
            if (r7 == 0) goto L_0x009b
            return r5
        L_0x009b:
            return r6
        L_0x009c:
            return r2
        L_0x009d:
            r7 = 0
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzen.zzp(android.net.Uri):int");
    }

    public static long zzq(long j, long j2, long j3) {
        long j4 = j + j2;
        if (((j ^ j4) & (j2 ^ j4)) < 0) {
            return Long.MAX_VALUE;
        }
        return j4;
    }

    public static long zzr(long j, long j2, long j3) {
        return Math.max(j2, Math.min(j, j3));
    }

    public static long zzs(long j, float f) {
        return f == 1.0f ? j : Math.round(((double) j) * ((double) f));
    }

    public static long zzt(long j) {
        if (j == C.TIME_UNSET) {
            return System.currentTimeMillis();
        }
        return j + SystemClock.elapsedRealtime();
    }

    public static long zzu(long j, float f) {
        return f == 1.0f ? j : Math.round(((double) j) / ((double) f));
    }

    public static long zzv(long j) {
        return (j == C.TIME_UNSET || j == Long.MIN_VALUE) ? j : j * 1000;
    }

    public static long zzw(long j, long j2, long j3) {
        int i = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
        if (i < 0 || j3 % j2 != 0) {
            return (i >= 0 || j2 % j3 != 0) ? (long) (((double) j) * (((double) j2) / ((double) j3))) : j * (j2 / j3);
        }
        return j / (j3 / j2);
    }

    public static long zzx(long j, long j2, long j3) {
        long j4 = j - j2;
        if (((j ^ j4) & (j2 ^ j)) < 0) {
            return Long.MIN_VALUE;
        }
        return j4;
    }

    public static long zzy(int i, int i2) {
        return (((long) i2) & 4294967295L) | ((((long) i) & 4294967295L) << 32);
    }

    public static long zzz(long j) {
        return (j == C.TIME_UNSET || j == Long.MIN_VALUE) ? j : j / 1000;
    }

    public static void zzR(long[] jArr, long j, long j2) {
        int i = (j2 > 1000000 ? 1 : (j2 == 1000000 ? 0 : -1));
        int i2 = 0;
        if (i >= 0 && j2 % 1000000 == 0) {
            long j3 = j2 / 1000000;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] / j3;
                i2++;
            }
        } else if (i >= 0 || 1000000 % j2 != 0) {
            double d = 1000000.0d / ((double) j2);
            while (i2 < jArr.length) {
                jArr[i2] = (long) (((double) jArr[i2]) * d);
                i2++;
            }
        } else {
            long j4 = 1000000 / j2;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] * j4;
                i2++;
            }
        }
    }
}
