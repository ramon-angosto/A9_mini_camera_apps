package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzpc extends Fragment implements zzor {
    private static WeakHashMap<FragmentActivity, WeakReference<zzpc>> zzaoq = new WeakHashMap<>();
    /* access modifiers changed from: private */
    public int zzDO = 0;
    private Map<String, zzoq> zzaor = new ArrayMap();
    /* access modifiers changed from: private */
    public Bundle zzaos;

    public static zzpc zza(FragmentActivity fragmentActivity) {
        zzpc zzpc;
        WeakReference weakReference = zzaoq.get(fragmentActivity);
        if (weakReference != null && (zzpc = (zzpc) weakReference.get()) != null) {
            return zzpc;
        }
        try {
            zzpc zzpc2 = (zzpc) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
            if (zzpc2 == null || zzpc2.isRemoving()) {
                zzpc2 = new zzpc();
                fragmentActivity.getSupportFragmentManager().beginTransaction().add((Fragment) zzpc2, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
            }
            zzaoq.put(fragmentActivity, new WeakReference(zzpc2));
            return zzpc2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
        }
    }

    private void zzb(final String str, @NonNull final zzoq zzoq) {
        if (this.zzDO > 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (zzpc.this.zzDO >= 1) {
                        zzoq.onCreate(zzpc.this.zzaos != null ? zzpc.this.zzaos.getBundle(str) : null);
                    }
                    if (zzpc.this.zzDO >= 2) {
                        zzoq.onStart();
                    }
                    if (zzpc.this.zzDO >= 3) {
                        zzoq.onStop();
                    }
                }
            });
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

    /* renamed from: zzsH */
    public FragmentActivity zzsF() {
        return getActivity();
    }
}
