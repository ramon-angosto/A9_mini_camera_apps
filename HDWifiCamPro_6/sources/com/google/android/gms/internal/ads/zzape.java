package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzape {
    private static final String[] zza = {"/aclk", "/pcs/click", "/dbm/clk"};
    private final String zzb = "ad.doubleclick.net";
    private final String[] zzc = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private final zzapa zzd;

    @Deprecated
    public zzape(zzapa zzapa) {
        this.zzd = zzapa;
    }

    @Deprecated
    public final Uri zza(Uri uri, Context context, View view, Activity activity) throws zzapf {
        try {
            return zzg(uri, this.zzd.zzf(context, uri.getQueryParameter("ai"), view, activity));
        } catch (UnsupportedOperationException unused) {
            throw new zzapf("Provided Uri is not in a valid state");
        }
    }

    @Deprecated
    public final Uri zzb(Uri uri, Context context) throws zzapf {
        return zzg(uri, this.zzd.zzg(context));
    }

    @Deprecated
    public final zzapa zzc() {
        return this.zzd;
    }

    @Deprecated
    public final void zzd(MotionEvent motionEvent) {
        this.zzd.zzk(motionEvent);
    }

    public final boolean zze(Uri uri) {
        if (zzf(uri)) {
            String[] strArr = zza;
            for (int i = 0; i < 3; i++) {
                if (uri.getPath().endsWith(strArr[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    private final Uri zzg(Uri uri, String str) throws zzapf {
        if (uri != null) {
            try {
                if (uri.getHost().equals(this.zzb)) {
                    try {
                        if (!uri.toString().contains("dc_ms=")) {
                            String uri2 = uri.toString();
                            int indexOf = uri2.indexOf(";adurl");
                            if (indexOf != -1) {
                                int i = indexOf + 1;
                                return Uri.parse(uri2.substring(0, i) + "dc_ms" + "=" + str + ";" + uri2.substring(i));
                            }
                            String encodedPath = uri.getEncodedPath();
                            int indexOf2 = uri2.indexOf(encodedPath);
                            return Uri.parse(uri2.substring(0, encodedPath.length() + indexOf2) + ";" + "dc_ms" + "=" + str + ";" + uri2.substring(indexOf2 + encodedPath.length()));
                        }
                        throw new zzapf("Parameter already exists: dc_ms");
                    } catch (UnsupportedOperationException unused) {
                        throw new zzapf("Provided Uri is not in a valid state");
                    }
                }
            } catch (NullPointerException unused2) {
            }
            if (uri.getQueryParameter("ms") == null) {
                String uri3 = uri.toString();
                int indexOf3 = uri3.indexOf("&adurl");
                if (indexOf3 == -1) {
                    indexOf3 = uri3.indexOf("?adurl");
                }
                if (indexOf3 == -1) {
                    return uri.buildUpon().appendQueryParameter("ms", str).build();
                }
                int i2 = indexOf3 + 1;
                return Uri.parse(uri3.substring(0, i2) + "ms" + "=" + str + "&" + uri3.substring(i2));
            }
            throw new zzapf("Query parameter already exists: ms");
        }
        throw null;
    }

    public final boolean zzf(Uri uri) {
        if (uri != null) {
            try {
                String host = uri.getHost();
                String[] strArr = this.zzc;
                for (int i = 0; i < 3; i++) {
                    if (host.endsWith(strArr[i])) {
                        return true;
                    }
                }
            } catch (NullPointerException unused) {
            }
            return false;
        }
        throw null;
    }
}
