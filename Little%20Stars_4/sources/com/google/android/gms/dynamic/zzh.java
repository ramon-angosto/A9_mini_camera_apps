package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.zzc;

public final class zzh extends zzc.zza {
    private Fragment zzaCl;

    private zzh(Fragment fragment) {
        this.zzaCl = fragment;
    }

    public static zzh zza(Fragment fragment) {
        if (fragment != null) {
            return new zzh(fragment);
        }
        return null;
    }

    public Bundle getArguments() {
        return this.zzaCl.getArguments();
    }

    public int getId() {
        return this.zzaCl.getId();
    }

    public boolean getRetainInstance() {
        return this.zzaCl.getRetainInstance();
    }

    public String getTag() {
        return this.zzaCl.getTag();
    }

    public int getTargetRequestCode() {
        return this.zzaCl.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.zzaCl.getUserVisibleHint();
    }

    public zzd getView() {
        return zze.zzD(this.zzaCl.getView());
    }

    public boolean isAdded() {
        return this.zzaCl.isAdded();
    }

    public boolean isDetached() {
        return this.zzaCl.isDetached();
    }

    public boolean isHidden() {
        return this.zzaCl.isHidden();
    }

    public boolean isInLayout() {
        return this.zzaCl.isInLayout();
    }

    public boolean isRemoving() {
        return this.zzaCl.isRemoving();
    }

    public boolean isResumed() {
        return this.zzaCl.isResumed();
    }

    public boolean isVisible() {
        return this.zzaCl.isVisible();
    }

    public void setHasOptionsMenu(boolean z) {
        this.zzaCl.setHasOptionsMenu(z);
    }

    public void setMenuVisibility(boolean z) {
        this.zzaCl.setMenuVisibility(z);
    }

    public void setRetainInstance(boolean z) {
        this.zzaCl.setRetainInstance(z);
    }

    public void setUserVisibleHint(boolean z) {
        this.zzaCl.setUserVisibleHint(z);
    }

    public void startActivity(Intent intent) {
        this.zzaCl.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.zzaCl.startActivityForResult(intent, i);
    }

    public void zzv(zzd zzd) {
        this.zzaCl.registerForContextMenu((View) zze.zzx(zzd));
    }

    public void zzw(zzd zzd) {
        this.zzaCl.unregisterForContextMenu((View) zze.zzx(zzd));
    }

    public zzd zzxe() {
        return zze.zzD(this.zzaCl.getActivity());
    }

    public zzc zzxf() {
        return zza(this.zzaCl.getParentFragment());
    }

    public zzd zzxg() {
        return zze.zzD(this.zzaCl.getResources());
    }

    public zzc zzxh() {
        return zza(this.zzaCl.getTargetFragment());
    }
}
