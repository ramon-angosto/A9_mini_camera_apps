package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.RawResourceDataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfe implements zzex {
    private final Context zza;
    private final List zzb = new ArrayList();
    private final zzex zzc;
    private zzex zzd;
    private zzex zze;
    private zzex zzf;
    private zzex zzg;
    private zzex zzh;
    private zzex zzi;
    private zzex zzj;
    private zzex zzk;

    public zzfe(Context context, zzex zzex) {
        this.zza = context.getApplicationContext();
        this.zzc = zzex;
    }

    private final zzex zzg() {
        if (this.zze == null) {
            this.zze = new zzeq(this.zza);
            zzh(this.zze);
        }
        return this.zze;
    }

    private final void zzh(zzex zzex) {
        for (int i = 0; i < this.zzb.size(); i++) {
            zzex.zzf((zzfz) this.zzb.get(i));
        }
    }

    private static final void zzi(zzex zzex, zzfz zzfz) {
        if (zzex != null) {
            zzex.zzf(zzfz);
        }
    }

    public final long zzb(zzfc zzfc) throws IOException {
        zzex zzex;
        zzdd.zzf(this.zzk == null);
        String scheme = zzfc.zza.getScheme();
        if (zzen.zzW(zzfc.zza)) {
            String path = zzfc.zza.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.zzd == null) {
                    this.zzd = new zzfn();
                    zzh(this.zzd);
                }
                this.zzk = this.zzd;
            } else {
                this.zzk = zzg();
            }
        } else if ("asset".equals(scheme)) {
            this.zzk = zzg();
        } else if ("content".equals(scheme)) {
            if (this.zzf == null) {
                this.zzf = new zzeu(this.zza);
                zzh(this.zzf);
            }
            this.zzk = this.zzf;
        } else if ("rtmp".equals(scheme)) {
            if (this.zzg == null) {
                try {
                    this.zzg = (zzex) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                    zzh(this.zzg);
                } catch (ClassNotFoundException unused) {
                    zzdw.zze("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating RTMP extension", e);
                }
                if (this.zzg == null) {
                    this.zzg = this.zzc;
                }
            }
            this.zzk = this.zzg;
        } else if ("udp".equals(scheme)) {
            if (this.zzh == null) {
                this.zzh = new zzgb(2000);
                zzh(this.zzh);
            }
            this.zzk = this.zzh;
        } else if (DataSchemeDataSource.SCHEME_DATA.equals(scheme)) {
            if (this.zzi == null) {
                this.zzi = new zzev();
                zzh(this.zzi);
            }
            this.zzk = this.zzi;
        } else {
            if (RawResourceDataSource.RAW_RESOURCE_SCHEME.equals(scheme) || "android.resource".equals(scheme)) {
                if (this.zzj == null) {
                    this.zzj = new zzfx(this.zza);
                    zzh(this.zzj);
                }
                zzex = this.zzj;
            } else {
                zzex = this.zzc;
            }
            this.zzk = zzex;
        }
        return this.zzk.zzb(zzfc);
    }

    public final Uri zzc() {
        zzex zzex = this.zzk;
        if (zzex == null) {
            return null;
        }
        return zzex.zzc();
    }

    public final void zzd() throws IOException {
        zzex zzex = this.zzk;
        if (zzex != null) {
            try {
                zzex.zzd();
            } finally {
                this.zzk = null;
            }
        }
    }

    public final Map zze() {
        zzex zzex = this.zzk;
        return zzex == null ? Collections.emptyMap() : zzex.zze();
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        zzex zzex = this.zzk;
        if (zzex != null) {
            return zzex.zza(bArr, i, i2);
        }
        throw null;
    }

    public final void zzf(zzfz zzfz) {
        if (zzfz != null) {
            this.zzc.zzf(zzfz);
            this.zzb.add(zzfz);
            zzi(this.zzd, zzfz);
            zzi(this.zze, zzfz);
            zzi(this.zzf, zzfz);
            zzi(this.zzg, zzfz);
            zzi(this.zzh, zzfz);
            zzi(this.zzi, zzfz);
            zzi(this.zzj, zzfz);
            return;
        }
        throw null;
    }
}
