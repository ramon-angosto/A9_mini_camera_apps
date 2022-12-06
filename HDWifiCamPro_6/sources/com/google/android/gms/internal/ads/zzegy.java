package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzegy implements zzegz {
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzfkw zzf(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -382745961(0xffffffffe92fc297, float:-1.3280059E25)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 112202875(0x6b0147b, float:6.6233935E-35)
            if (r0 == r1) goto L_0x0020
            r1 = 714893483(0x2a9c68ab, float:2.7783795E-13)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "nativeDisplay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = r3
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "video"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = r2
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "htmlDisplay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 0
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x0043
            if (r4 == r3) goto L_0x0040
            if (r4 == r2) goto L_0x003d
            r4 = 0
            return r4
        L_0x003d:
            com.google.android.gms.internal.ads.zzfkw r4 = com.google.android.gms.internal.ads.zzfkw.VIDEO
            return r4
        L_0x0040:
            com.google.android.gms.internal.ads.zzfkw r4 = com.google.android.gms.internal.ads.zzfkw.NATIVE_DISPLAY
            return r4
        L_0x0043:
            com.google.android.gms.internal.ads.zzfkw r4 = com.google.android.gms.internal.ads.zzfkw.HTML_DISPLAY
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzegy.zzf(java.lang.String):com.google.android.gms.internal.ads.zzfkw");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzfky zzg(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -1104128070(0xffffffffbe3057ba, float:-0.17220965)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 1318088141(0x4e906dcd, float:1.2115575E9)
            if (r0 == r1) goto L_0x0020
            r1 = 1988248512(0x768243c0, float:1.3210405E33)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "onePixel"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = r2
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "definedByJavascript"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = r3
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "beginToRender"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 0
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x0044
            if (r4 == r3) goto L_0x0041
            if (r4 == r2) goto L_0x003e
            com.google.android.gms.internal.ads.zzfky r4 = com.google.android.gms.internal.ads.zzfky.UNSPECIFIED
            return r4
        L_0x003e:
            com.google.android.gms.internal.ads.zzfky r4 = com.google.android.gms.internal.ads.zzfky.ONE_PIXEL
            return r4
        L_0x0041:
            com.google.android.gms.internal.ads.zzfky r4 = com.google.android.gms.internal.ads.zzfky.DEFINED_BY_JAVASCRIPT
            return r4
        L_0x0044:
            com.google.android.gms.internal.ads.zzfky r4 = com.google.android.gms.internal.ads.zzfky.BEGIN_TO_RENDER
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzegy.zzg(java.lang.String):com.google.android.gms.internal.ads.zzfky");
    }

    private static zzfkz zzh(String str) {
        if ("native".equals(str)) {
            return zzfkz.NATIVE;
        }
        if ("javascript".equals(str)) {
            return zzfkz.JAVASCRIPT;
        }
        return zzfkz.NONE;
    }

    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4, zzehb zzehb, zzeha zzeha, String str5) {
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzeg)).booleanValue() || !zzfkp.zzb()) {
            return null;
        }
        zzfla zza = zzfla.zza("Google", str);
        zzfkz zzh = zzh("javascript");
        zzfkw zzf = zzf(zzeha.toString());
        if (zzh == zzfkz.NONE) {
            zze.zzj("Omid html session error; Unable to parse impression owner: javascript");
            return null;
        } else if (zzf == null) {
            zze.zzj("Omid html session error; Unable to parse creative type: ".concat(String.valueOf(String.valueOf(zzeha))));
            return null;
        } else {
            zzfkz zzh2 = zzh(str4);
            if (zzf == zzfkw.VIDEO && zzh2 == zzfkz.NONE) {
                zze.zzj("Omid html session error; Video events owner unknown for video creative: ".concat(String.valueOf(str4)));
                return null;
            }
            return ObjectWrapper.wrap(zzfkr.zza(zzfks.zza(zzf, zzg(zzehb.toString()), zzh, zzh2, true), zzfkt.zzb(zza, webView, str5, "")));
        }
    }

    public final IObjectWrapper zzb(String str, WebView webView, String str2, String str3, String str4, String str5, zzehb zzehb, zzeha zzeha, String str6) {
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzeg)).booleanValue() || !zzfkp.zzb()) {
            return null;
        }
        zzfla zza = zzfla.zza(str5, str);
        zzfkz zzh = zzh("javascript");
        zzfkz zzh2 = zzh(str4);
        zzfkw zzf = zzf(zzeha.toString());
        if (zzh == zzfkz.NONE) {
            zze.zzj("Omid js session error; Unable to parse impression owner: javascript");
            return null;
        } else if (zzf == null) {
            zze.zzj("Omid js session error; Unable to parse creative type: ".concat(String.valueOf(String.valueOf(zzeha))));
            return null;
        } else if (zzf == zzfkw.VIDEO && zzh2 == zzfkz.NONE) {
            zze.zzj("Omid js session error; Video events owner unknown for video creative: ".concat(String.valueOf(str4)));
            return null;
        } else {
            return ObjectWrapper.wrap(zzfkr.zza(zzfks.zza(zzf, zzg(zzehb.toString()), zzh, zzh2, true), zzfkt.zzc(zza, webView, str6, "")));
        }
    }

    public final void zzc(IObjectWrapper iObjectWrapper, View view) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzeg)).booleanValue() && zzfkp.zzb()) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (unwrap instanceof zzfkr) {
                ((zzfkr) unwrap).zzd(view);
            }
        }
    }

    public final void zzd(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzeg)).booleanValue() && zzfkp.zzb()) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (unwrap instanceof zzfkr) {
                ((zzfkr) unwrap).zze();
            }
        }
    }

    public final boolean zze(Context context) {
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzeg)).booleanValue()) {
            zze.zzj("Omid flag is disabled");
            return false;
        } else if (zzfkp.zzb()) {
            return true;
        } else {
            zzfkp.zza(context);
            return zzfkp.zzb();
        }
    }
}
