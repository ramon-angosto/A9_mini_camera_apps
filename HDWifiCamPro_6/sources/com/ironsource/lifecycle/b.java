package com.ironsource.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public final class b extends Fragment {
    a a;

    interface a {
        void a(Activity activity);

        void b(Activity activity);
    }

    static b a(Activity activity) {
        return (b) activity.getFragmentManager().findFragmentByTag("com.ironsource.lifecycle.IronsourceLifecycleFragment");
    }

    static void b(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager != null && fragmentManager.findFragmentByTag("com.ironsource.lifecycle.IronsourceLifecycleFragment") == null) {
            fragmentManager.beginTransaction().add(new b(), "com.ironsource.lifecycle.IronsourceLifecycleFragment").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.a != null) {
            getActivity();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.a = null;
    }

    public final void onPause() {
        super.onPause();
    }

    public final void onResume() {
        super.onResume();
        a aVar = this.a;
        if (aVar != null) {
            aVar.b(getActivity());
        }
    }

    public final void onStart() {
        super.onStart();
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(getActivity());
        }
    }

    public final void onStop() {
        super.onStop();
    }
}
