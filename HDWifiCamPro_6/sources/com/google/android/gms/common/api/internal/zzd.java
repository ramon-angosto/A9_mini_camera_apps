package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.internal.common.zzi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public final class zzd extends Fragment implements LifecycleFragment {
    private static final WeakHashMap<FragmentActivity, WeakReference<zzd>> zza = new WeakHashMap<>();
    private final Map<String, LifecycleCallback> zzb = Collections.synchronizedMap(new ArrayMap());
    /* access modifiers changed from: private */
    public int zzc = 0;
    /* access modifiers changed from: private */
    public Bundle zzd;

    public static zzd zzc(FragmentActivity fragmentActivity) {
        zzd zzd2;
        WeakReference weakReference = zza.get(fragmentActivity);
        if (weakReference != null && (zzd2 = (zzd) weakReference.get()) != null) {
            return zzd2;
        }
        try {
            zzd zzd3 = (zzd) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
            if (zzd3 == null || zzd3.isRemoving()) {
                zzd3 = new zzd();
                fragmentActivity.getSupportFragmentManager().beginTransaction().add((Fragment) zzd3, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
            }
            zza.put(fragmentActivity, new WeakReference(zzd3));
            return zzd3;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
        }
    }

    public final void addCallback(String str, LifecycleCallback lifecycleCallback) {
        if (!this.zzb.containsKey(str)) {
            this.zzb.put(str, lifecycleCallback);
            if (this.zzc > 0) {
                new zzi(Looper.getMainLooper()).post(new zzc(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
        sb.append("LifecycleCallback with tag ");
        sb.append(str);
        sb.append(" already added to this fragment.");
        throw new IllegalArgumentException(sb.toString());
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback dump : this.zzb.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final <T extends LifecycleCallback> T getCallbackOrNull(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.zzb.get(str));
    }

    public final /* synthetic */ Activity getLifecycleActivity() {
        return getActivity();
    }

    public final boolean isCreated() {
        return this.zzc > 0;
    }

    public final boolean isStarted() {
        return this.zzc >= 2;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback onActivityResult : this.zzb.values()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzc = 1;
        this.zzd = bundle;
        for (Map.Entry next : this.zzb.entrySet()) {
            ((LifecycleCallback) next.getValue()).onCreate(bundle != null ? bundle.getBundle((String) next.getKey()) : null);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.zzc = 5;
        for (LifecycleCallback onDestroy : this.zzb.values()) {
            onDestroy.onDestroy();
        }
    }

    public final void onResume() {
        super.onResume();
        this.zzc = 3;
        for (LifecycleCallback onResume : this.zzb.values()) {
            onResume.onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry next : this.zzb.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) next.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) next.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.zzc = 2;
        for (LifecycleCallback onStart : this.zzb.values()) {
            onStart.onStart();
        }
    }

    public final void onStop() {
        super.onStop();
        this.zzc = 4;
        for (LifecycleCallback onStop : this.zzb.values()) {
            onStop.onStop();
        }
    }
}
