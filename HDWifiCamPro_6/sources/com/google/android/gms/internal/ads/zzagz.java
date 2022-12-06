package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzagz implements zzain {
    private final List zza;

    public zzagz() {
        this(0);
    }

    private final zzaid zzb(zzaim zzaim) {
        return new zzaid(zzd(zzaim));
    }

    private final zzair zzc(zzaim zzaim) {
        return new zzair(zzd(zzaim));
    }

    private final List zzd(zzaim zzaim) {
        String str;
        int i;
        List list;
        zzef zzef = new zzef(zzaim.zzd);
        List list2 = this.zza;
        while (zzef.zza() > 0) {
            int zzk = zzef.zzk();
            int zzc = zzef.zzc() + zzef.zzk();
            if (zzk == 134) {
                list2 = new ArrayList();
                int zzk2 = zzef.zzk() & 31;
                for (int i2 = 0; i2 < zzk2; i2++) {
                    String zzx = zzef.zzx(3, zzfsk.zzc);
                    int zzk3 = zzef.zzk();
                    int i3 = zzk3 & 128;
                    if (i3 != 0) {
                        i = zzk3 & 63;
                        str = MimeTypes.APPLICATION_CEA708;
                    } else {
                        str = MimeTypes.APPLICATION_CEA608;
                        i = 1;
                    }
                    byte zzk4 = (byte) zzef.zzk();
                    zzef.zzG(1);
                    if (i3 != 0) {
                        int i4 = zzdf.zza;
                        list = Collections.singletonList((zzk4 & 64) != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        list = null;
                    }
                    zzad zzad = new zzad();
                    zzad.zzS(str);
                    zzad.zzK(zzx);
                    zzad.zzu(i);
                    zzad.zzI(list);
                    list2.add(zzad.zzY());
                }
            }
            zzef.zzF(zzc);
        }
        return list2;
    }

    public final zzaip zza(int i, zzaim zzaim) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new zzaht(new zzahq(zzaim.zzb));
            }
            if (i == 21) {
                return new zzaht(new zzaho());
            }
            if (i == 27) {
                return new zzaht(new zzahl(zzb(zzaim), false, false));
            }
            if (i == 36) {
                return new zzaht(new zzahn(zzb(zzaim)));
            }
            if (i == 89) {
                return new zzaht(new zzahb(zzaim.zzc));
            }
            if (i == 138) {
                return new zzaht(new zzaha(zzaim.zzb));
            }
            if (i == 172) {
                return new zzaht(new zzagv(zzaim.zzb));
            }
            if (i == 257) {
                return new zzaic(new zzahs("application/vnd.dvb.ait"));
            }
            if (i == 134) {
                return new zzaic(new zzahs(MimeTypes.APPLICATION_SCTE35));
            }
            if (i != 135) {
                switch (i) {
                    case 15:
                        return new zzaht(new zzagy(false, zzaim.zzb));
                    case 16:
                        return new zzaht(new zzahh(zzc(zzaim)));
                    case 17:
                        return new zzaht(new zzahp(zzaim.zzb));
                    default:
                        switch (i) {
                            case 128:
                                break;
                            case TsExtractor.TS_STREAM_TYPE_AC3 /*129*/:
                                break;
                            default:
                                return null;
                        }
                }
            }
            return new zzaht(new zzags(zzaim.zzb));
        }
        return new zzaht(new zzahe(zzc(zzaim)));
    }

    public zzagz(int i) {
        this.zza = zzfvn.zzo();
    }
}
