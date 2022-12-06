package com.google.android.material.datepicker;

abstract class OnSelectionChangedListener<S> {
    /* access modifiers changed from: package-private */
    public void onIncompleteSelectionChanged() {
    }

    /* access modifiers changed from: package-private */
    public abstract void onSelectionChanged(S s);

    OnSelectionChangedListener() {
    }
}
