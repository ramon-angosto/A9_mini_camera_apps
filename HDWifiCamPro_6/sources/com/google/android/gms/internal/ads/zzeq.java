package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.facebook.ads.AdError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeq extends zzer {
    private final AssetManager zza;
    private Uri zzb;
    private InputStream zzc;
    private long zzd;
    private boolean zze;

    public zzeq(Context context) {
        super(false);
        this.zza = context.getAssets();
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzep {
        if (i2 == 0) {
            return 0;
        }
        long j = this.zzd;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, (long) i2);
            } catch (IOException e) {
                throw new zzep(e, 2000);
            }
        }
        InputStream inputStream = this.zzc;
        int i3 = zzen.zza;
        int read = inputStream.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        long j2 = this.zzd;
        if (j2 != -1) {
            this.zzd = j2 - ((long) read);
        }
        zzg(read);
        return read;
    }

    public final long zzb(zzfc zzfc) throws zzep {
        try {
            this.zzb = zzfc.zza;
            String path = this.zzb.getPath();
            if (path != null) {
                if (path.startsWith("/android_asset/")) {
                    path = path.substring(15);
                } else if (path.startsWith("/")) {
                    path = path.substring(1);
                }
                zzi(zzfc);
                this.zzc = this.zza.open(path, 1);
                if (this.zzc.skip(zzfc.zzf) >= zzfc.zzf) {
                    long j = zzfc.zzg;
                    if (j != -1) {
                        this.zzd = j;
                    } else {
                        long available = (long) this.zzc.available();
                        this.zzd = available;
                        if (available == 2147483647L) {
                            this.zzd = -1;
                        }
                    }
                    this.zze = true;
                    zzj(zzfc);
                    return this.zzd;
                }
                throw new zzep((Throwable) null, AdError.REMOTE_ADS_SERVICE_ERROR);
            }
            throw null;
        } catch (zzep e) {
            throw e;
        } catch (IOException e2) {
            throw new zzep(e2, true != (e2 instanceof FileNotFoundException) ? 2000 : IronSourceConstants.IS_INSTANCE_OPENED);
        }
    }

    public final Uri zzc() {
        return this.zzb;
    }

    public final void zzd() throws zzep {
        this.zzb = null;
        try {
            InputStream inputStream = this.zzc;
            if (inputStream != null) {
                inputStream.close();
            }
            this.zzc = null;
            if (this.zze) {
                this.zze = false;
                zzh();
            }
        } catch (IOException e) {
            throw new zzep(e, 2000);
        } catch (Throwable th) {
            this.zzc = null;
            if (this.zze) {
                this.zze = false;
                zzh();
            }
            throw th;
        }
    }
}
