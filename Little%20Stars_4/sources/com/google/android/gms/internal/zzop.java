package com.google.android.gms.internal;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zzs;

public class zzop {
    private final Object zzaoo;

    public zzop(Activity activity) {
        zzaa.zzb(activity, (Object) "Activity must not be null");
        zzaa.zzb(zzs.zzuX() || (activity instanceof FragmentActivity), (Object) "This Activity is not supported before platform version 11 (3.0 Honeycomb). Please use FragmentActivity instead.");
        this.zzaoo = activity;
    }

    public boolean zzsC() {
        return this.zzaoo instanceof FragmentActivity;
    }

    public Activity zzsD() {
        return (Activity) this.zzaoo;
    }

    public FragmentActivity zzsE() {
        return (FragmentActivity) this.zzaoo;
    }
}
