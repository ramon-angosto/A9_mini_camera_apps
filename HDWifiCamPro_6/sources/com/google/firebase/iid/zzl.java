package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.platforminfo.UserAgentPublisher;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class zzl {
    private final FirebaseApp zza;
    private final zzai zzb;
    private final zzao zzc;
    private final Executor zzd;
    private final UserAgentPublisher zze;

    zzl(FirebaseApp firebaseApp, zzai zzai, Executor executor, UserAgentPublisher userAgentPublisher) {
        this(firebaseApp, zzai, executor, new zzao(firebaseApp.getApplicationContext(), zzai), userAgentPublisher);
    }

    private zzl(FirebaseApp firebaseApp, zzai zzai, Executor executor, zzao zzao, UserAgentPublisher userAgentPublisher) {
        this.zza = firebaseApp;
        this.zzb = zzai;
        this.zzc = zzao;
        this.zzd = executor;
        this.zze = userAgentPublisher;
    }

    public final Task<String> zza(String str, String str2, String str3) {
        return zzb(zza(str, str2, str3, new Bundle()));
    }

    public final Task<Void> zzb(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(RequestParameters.SUBRESOURCE_DELETE, "1");
        return zza(zzb(zza(str, str2, str3, bundle)));
    }

    public final Task<Void> zza(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("iid-operation", RequestParameters.SUBRESOURCE_DELETE);
        bundle.putString(RequestParameters.SUBRESOURCE_DELETE, "1");
        return zza(zzb(zza(str, "*", "*", bundle)));
    }

    public final Task<Void> zzc(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        String valueOf2 = String.valueOf(str3);
        return zza(zzb(zza(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle)));
    }

    public final Task<Void> zzd(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        bundle.putString(RequestParameters.SUBRESOURCE_DELETE, "1");
        String valueOf2 = String.valueOf(str3);
        return zza(zzb(zza(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle)));
    }

    private final Task<Bundle> zza(String str, String str2, String str3, Bundle bundle) {
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        bundle.putString("gmp_app_id", this.zza.getOptions().getApplicationId());
        bundle.putString("gmsv", Integer.toString(this.zzb.zzd()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.zzb.zzb());
        bundle.putString("app_ver_name", this.zzb.zzc());
        String version = LibraryVersion.getInstance().getVersion("firebase-iid");
        if ("UNKNOWN".equals(version)) {
            int i = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
            StringBuilder sb = new StringBuilder(19);
            sb.append("unknown_");
            sb.append(i);
            version = sb.toString();
        }
        String valueOf = String.valueOf(version);
        bundle.putString("cliv", valueOf.length() != 0 ? "fiid-".concat(valueOf) : new String("fiid-"));
        bundle.putString("Firebase-Client", this.zze.getUserAgent());
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzd.execute(new zzn(this, bundle, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: private */
    public static String zza(Bundle bundle) throws IOException {
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string != null) {
                return string;
            }
            String string2 = bundle.getString("unregistered");
            if (string2 != null) {
                return string2;
            }
            String string3 = bundle.getString(CampaignEx.JSON_NATIVE_VIDEO_ERROR);
            if ("RST".equals(string3)) {
                throw new IOException("INSTANCE_ID_RESET");
            } else if (string3 != null) {
                throw new IOException(string3);
            } else {
                String valueOf = String.valueOf(bundle);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21);
                sb.append("Unexpected response: ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString(), new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        } else {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    private final <T> Task<Void> zza(Task<T> task) {
        return task.continueWith(zza.zza(), new zzm(this));
    }

    private final Task<String> zzb(Task<Bundle> task) {
        return task.continueWith(this.zzd, new zzp(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Bundle bundle, TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(this.zzc.zza(bundle));
        } catch (IOException e) {
            taskCompletionSource.setException(e);
        }
    }
}
