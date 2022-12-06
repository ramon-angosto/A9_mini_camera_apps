package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.internal.zzy;

@Deprecated
public final class zzom {
    private static zzom zzaog;
    private static Object zzrs = new Object();
    private final String zzPx;
    private final String zzaoh;
    private final Status zzaoi;
    private final String zzaoj;
    private final String zzaok;
    private final String zzaol;
    private final boolean zzaom;
    private final boolean zzaon;

    zzom(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        boolean z = true;
        if (identifier != 0) {
            z = resources.getInteger(identifier) == 0 ? false : z;
            this.zzaon = !z;
        } else {
            this.zzaon = false;
        }
        this.zzaom = z;
        zzah zzah = new zzah(context);
        this.zzaoj = zzah.getString("firebase_database_url");
        this.zzaol = zzah.getString("google_storage_bucket");
        this.zzaok = zzah.getString("gcm_defaultSenderId");
        this.zzaoh = zzah.getString("google_api_key");
        String zzaw = zzy.zzaw(context);
        zzaw = zzaw == null ? zzah.getString("google_app_id") : zzaw;
        if (TextUtils.isEmpty(zzaw)) {
            this.zzaoi = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.zzPx = null;
            return;
        }
        this.zzPx = zzaw;
        this.zzaoi = Status.zzalw;
    }

    zzom(String str, boolean z) {
        this(str, z, (String) null, (String) null, (String) null);
    }

    zzom(String str, boolean z, String str2, String str3, String str4) {
        this.zzPx = str;
        this.zzaoh = null;
        this.zzaoi = Status.zzalw;
        this.zzaom = z;
        this.zzaon = !z;
        this.zzaoj = str2;
        this.zzaok = str4;
        this.zzaol = str3;
    }

    public static Status zzas(Context context) {
        Status status;
        zzaa.zzb(context, (Object) "Context must not be null.");
        synchronized (zzrs) {
            if (zzaog == null) {
                zzaog = new zzom(context);
            }
            status = zzaog.zzaoi;
        }
        return status;
    }

    public static Status zzc(Context context, String str, boolean z) {
        zzaa.zzb(context, (Object) "Context must not be null.");
        zzaa.zzh(str, "App ID must be nonempty.");
        synchronized (zzrs) {
            if (zzaog != null) {
                Status zzcQ = zzaog.zzcQ(str);
                return zzcQ;
            }
            zzaog = new zzom(str, z);
            Status status = zzaog.zzaoi;
            return status;
        }
    }

    private static zzom zzcR(String str) {
        zzom zzom;
        synchronized (zzrs) {
            if (zzaog != null) {
                zzom = zzaog;
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
        }
        return zzom;
    }

    public static String zzsA() {
        return zzcR("getGoogleAppId").zzPx;
    }

    public static boolean zzsB() {
        return zzcR("isMeasurementExplicitlyDisabled").zzaon;
    }

    /* access modifiers changed from: package-private */
    public Status zzcQ(String str) {
        String str2 = this.zzPx;
        if (str2 == null || str2.equals(str)) {
            return Status.zzalw;
        }
        String str3 = this.zzPx;
        StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 97);
        sb.append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '");
        sb.append(str3);
        sb.append("'.");
        return new Status(10, sb.toString());
    }
}
