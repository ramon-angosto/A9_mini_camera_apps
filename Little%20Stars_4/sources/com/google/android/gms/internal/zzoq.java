package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzoq {
    protected final zzor zzaop;

    protected zzoq(zzor zzor) {
        this.zzaop = zzor;
    }

    protected static zzor zzc(zzop zzop) {
        return zzop.zzsC() ? zzpc.zza(zzop.zzsE()) : zzos.zzt(zzop.zzsD());
    }

    protected static zzor zzs(Activity activity) {
        return zzc(new zzop(activity));
    }

    @MainThread
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity getActivity() {
        return this.zzaop.zzsF();
    }

    @MainThread
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @MainThread
    public void onCreate(Bundle bundle) {
    }

    @MainThread
    public void onSaveInstanceState(Bundle bundle) {
    }

    @MainThread
    public void onStart() {
    }

    @MainThread
    public void onStop() {
    }
}
