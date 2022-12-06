package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

@TargetApi(11)
public final class zzos extends Fragment implements zzor {
    private static WeakHashMap<Activity, WeakReference<zzos>> zzaoq = new WeakHashMap<>();
    /* access modifiers changed from: private */
    public int zzDO = 0;
    private Map<String, zzoq> zzaor = new ArrayMap();
    /* access modifiers changed from: private */
    public Bundle zzaos;

    private void zzb(final String str, @NonNull final zzoq zzoq) {
        if (this.zzDO > 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (zzos.this.zzDO >= 1) {
                        zzoq.onCreate(zzos.this.zzaos != null ? zzos.this.zzaos.getBundle(str) : null);
                    }
                    if (zzos.this.zzDO >= 2) {
                        zzoq.onStart();
                    }
                    if (zzos.this.zzDO >= 3) {
                        zzoq.onStop();
                    }
                }
            });
        }
    }

    public static zzos zzt(Activity activity) {
        zzos zzos;
        WeakReference weakReference = zzaoq.get(activity);
        if (weakReference != null && (zzos = (zzos) weakReference.get()) != null) {
            return zzos;
        }
        try {
            zzos zzos2 = (zzos) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (zzos2 == null || zzos2.isRemoving()) {
                zzos2 = new zzos();
                activity.getFragmentManager().beginTransaction().add(zzos2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            zzaoq.put(activity, new WeakReference(zzos2));
            return zzos2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (zzoq dump : this.zzaor.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (zzoq onActivityResult : this.zzaor.values()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzDO = 1;
        this.zzaos = bundle;
        for (Map.Entry next : this.zzaor.entrySet()) {
            ((zzoq) next.getValue()).onCreate(bundle != null ? bundle.getBundle((String) next.getKey()) : null);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry next : this.zzaor.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((zzoq) next.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) next.getKey(), bundle2);
            }
        }
    }

    public void onStart() {
        super.onStop();
        this.zzDO = 2;
        for (zzoq onStart : this.zzaor.values()) {
            onStart.onStart();
        }
    }

    public void onStop() {
        super.onStop();
        this.zzDO = 3;
        for (zzoq onStop : this.zzaor.values()) {
            onStop.onStop();
        }
    }

    public <T extends zzoq> T zza(String str, Class<T> cls) {
        return (zzoq) cls.cast(this.zzaor.get(str));
    }

    public void zza(String str, @NonNull zzoq zzoq) {
        if (!this.zzaor.containsKey(str)) {
            this.zzaor.put(str, zzoq);
            zzb(str, zzoq);
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
        sb.append("LifecycleCallback with tag ");
        sb.append(str);
        sb.append(" already added to this fragment.");
        throw new IllegalArgumentException(sb.toString());
    }

    public Activity zzsF() {
        return getActivity();
    }
}
