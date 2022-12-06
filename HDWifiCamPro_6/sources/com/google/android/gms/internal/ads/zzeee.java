package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzeee implements zzfyn {
    public final /* synthetic */ zzeek zza;

    public /* synthetic */ zzeee(zzeek zzeek) {
        this.zza = zzeek;
    }

    public final zzfzp zza(Object obj) {
        ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
        ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
        zzchc.zza.execute(new zzffd((InputStream) obj, createPipe[1]));
        return zzfzg.zzi(parcelFileDescriptor);
    }
}
