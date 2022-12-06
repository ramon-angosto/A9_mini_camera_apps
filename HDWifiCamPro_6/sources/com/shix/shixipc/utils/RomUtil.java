package com.shix.shixipc.utils;

import android.os.Build;
import android.text.TextUtils;

public class RomUtil {
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    public static final String ROM_EMUI = "EMUI";
    public static final String ROM_FLYME = "FLYME";
    public static final String ROM_MIUI = "MIUI";
    public static final String ROM_OPPO = "OPPO";
    public static final String ROM_QIKU = "QIKU";
    public static final String ROM_SMARTISAN = "SMARTISAN";
    public static final String ROM_VIVO = "VIVO";
    private static final String TAG = "Rom";
    private static String sName;
    private static String sVersion;

    public static boolean isEmui() {
        return check(ROM_EMUI);
    }

    public static boolean isMiui() {
        return check(ROM_MIUI);
    }

    public static boolean isVivo() {
        return check(ROM_VIVO);
    }

    public static boolean isOppo() {
        return check(ROM_OPPO);
    }

    public static boolean isFlyme() {
        return check(ROM_FLYME);
    }

    public static boolean is360() {
        return check(ROM_QIKU) || check("360");
    }

    public static boolean isSmartisan() {
        return check(ROM_SMARTISAN);
    }

    public static String getName() {
        if (sName == null) {
            check("");
        }
        return sName;
    }

    public static String getVersion() {
        if (sVersion == null) {
            check("");
        }
        return sVersion;
    }

    public static boolean check(String str) {
        String str2 = sName;
        if (str2 != null) {
            return str2.equals(str);
        }
        String prop = getProp(KEY_VERSION_MIUI);
        sVersion = prop;
        if (!TextUtils.isEmpty(prop)) {
            sName = ROM_MIUI;
        } else {
            String prop2 = getProp(KEY_VERSION_EMUI);
            sVersion = prop2;
            if (!TextUtils.isEmpty(prop2)) {
                sName = ROM_EMUI;
            } else {
                String prop3 = getProp(KEY_VERSION_OPPO);
                sVersion = prop3;
                if (!TextUtils.isEmpty(prop3)) {
                    sName = ROM_OPPO;
                } else {
                    String prop4 = getProp(KEY_VERSION_VIVO);
                    sVersion = prop4;
                    if (!TextUtils.isEmpty(prop4)) {
                        sName = ROM_VIVO;
                    } else {
                        String prop5 = getProp(KEY_VERSION_SMARTISAN);
                        sVersion = prop5;
                        if (!TextUtils.isEmpty(prop5)) {
                            sName = ROM_SMARTISAN;
                        } else {
                            sVersion = Build.DISPLAY;
                            if (sVersion.toUpperCase().contains(ROM_FLYME)) {
                                sName = ROM_FLYME;
                            } else {
                                sVersion = "unknown";
                                sName = Build.MANUFACTURER.toUpperCase();
                            }
                        }
                    }
                }
            }
        }
        return sName.equals(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058 A[SYNTHETIC, Splitter:B:18:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065 A[SYNTHETIC, Splitter:B:26:0x0065] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getProp(java.lang.String r6) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r2.<init>()     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            java.lang.String r3 = "getprop "
            r2.append(r3)     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r2.append(r6)     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            java.lang.Process r1 = r1.exec(r2)     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            java.io.InputStream r1 = r1.getInputStream()     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r3.<init>(r1)     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r1 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3, r1)     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            java.lang.String r1 = r2.readLine()     // Catch:{ IOException -> 0x003a }
            r2.close()     // Catch:{ IOException -> 0x003a }
            r2.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0039:
            return r1
        L_0x003a:
            r1 = move-exception
            goto L_0x0040
        L_0x003c:
            r6 = move-exception
            goto L_0x0063
        L_0x003e:
            r1 = move-exception
            r2 = r0
        L_0x0040:
            java.lang.String r3 = "Rom"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            r4.<init>()     // Catch:{ all -> 0x0061 }
            java.lang.String r5 = "Unable to read prop "
            r4.append(r5)     // Catch:{ all -> 0x0061 }
            r4.append(r6)     // Catch:{ all -> 0x0061 }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x0061 }
            android.util.Log.e(r3, r6, r1)     // Catch:{ all -> 0x0061 }
            if (r2 == 0) goto L_0x0060
            r2.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x0060
        L_0x005c:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0060:
            return r0
        L_0x0061:
            r6 = move-exception
            r0 = r2
        L_0x0063:
            if (r0 == 0) goto L_0x006d
            r0.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x006d
        L_0x0069:
            r0 = move-exception
            r0.printStackTrace()
        L_0x006d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.utils.RomUtil.getProp(java.lang.String):java.lang.String");
    }
}
