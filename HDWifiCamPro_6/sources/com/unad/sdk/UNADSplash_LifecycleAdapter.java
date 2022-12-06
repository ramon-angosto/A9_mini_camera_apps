package com.unad.sdk;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

public class UNADSplash_LifecycleAdapter implements GeneratedAdapter {
    final UNADSplash mReceiver;

    UNADSplash_LifecycleAdapter(UNADSplash uNADSplash) {
        this.mReceiver = uNADSplash;
    }

    public void callMethods(LifecycleOwner lifecycleOwner, Lifecycle.Event event, boolean z, MethodCallsLogger methodCallsLogger) {
        boolean z2 = methodCallsLogger != null;
        if (!z && event == Lifecycle.Event.ON_START) {
            if (!z2 || methodCallsLogger.approveCall("onMoveToForeground", 1)) {
                this.mReceiver.onMoveToForeground();
            }
            if (!z2 || methodCallsLogger.approveCall("onStart", 1)) {
                this.mReceiver.onStart();
            }
        }
    }
}
