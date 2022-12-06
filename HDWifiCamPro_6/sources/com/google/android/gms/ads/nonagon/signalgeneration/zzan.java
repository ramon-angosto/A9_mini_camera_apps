package com.google.android.gms.ads.nonagon.signalgeneration;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzan implements Callable {
    public final /* synthetic */ TaggingLibraryJsInterface zza;

    public /* synthetic */ zzan(TaggingLibraryJsInterface taggingLibraryJsInterface) {
        this.zza = taggingLibraryJsInterface;
    }

    public final Object call() {
        return this.zza.getViewSignals();
    }
}
