package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzayf implements zzayc, zzayb {
    public final zzayc[] zza;
    private final IdentityHashMap zzb = new IdentityHashMap();
    private zzayb zzc;
    private int zzd;
    private zzayt zze;
    private zzayc[] zzf;
    private zzayq zzg;

    public zzayf(zzayc... zzaycArr) {
        this.zza = zzaycArr;
    }

    public final long zzB(zzayx[] zzayxArr, boolean[] zArr, zzayo[] zzayoArr, boolean[] zArr2, long j) {
        int length;
        int i;
        zzayx[] zzayxArr2 = zzayxArr;
        zzayo[] zzayoArr2 = zzayoArr;
        int length2 = zzayxArr2.length;
        int[] iArr = new int[length2];
        int[] iArr2 = new int[length2];
        int i2 = 0;
        while (true) {
            length = zzayxArr2.length;
            if (i2 >= length) {
                break;
            }
            zzayo zzayo = zzayoArr2[i2];
            if (zzayo == null) {
                i = -1;
            } else {
                i = ((Integer) this.zzb.get(zzayo)).intValue();
            }
            iArr[i2] = i;
            iArr2[i2] = -1;
            zzayx zzayx = zzayxArr2[i2];
            if (zzayx != null) {
                zzays zzd2 = zzayx.zzd();
                int i3 = 0;
                while (true) {
                    zzayc[] zzaycArr = this.zza;
                    if (i3 >= zzaycArr.length) {
                        break;
                    } else if (zzaycArr[i3].zzn().zza(zzd2) != -1) {
                        iArr2[i2] = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            i2++;
        }
        this.zzb.clear();
        zzayo[] zzayoArr3 = new zzayo[length];
        zzayo[] zzayoArr4 = new zzayo[length];
        zzayx[] zzayxArr3 = new zzayx[length];
        ArrayList arrayList = new ArrayList(this.zza.length);
        long j2 = j;
        int i4 = 0;
        while (i4 < this.zza.length) {
            for (int i5 = 0; i5 < zzayxArr2.length; i5++) {
                zzayx zzayx2 = null;
                zzayoArr4[i5] = iArr[i5] == i4 ? zzayoArr2[i5] : null;
                if (iArr2[i5] == i4) {
                    zzayx2 = zzayxArr2[i5];
                }
                zzayxArr3[i5] = zzayx2;
            }
            zzayx[] zzayxArr4 = zzayxArr3;
            ArrayList arrayList2 = arrayList;
            int i6 = i4;
            long zzB = this.zza[i4].zzB(zzayxArr3, zArr, zzayoArr4, zArr2, j2);
            if (i6 == 0) {
                j2 = zzB;
            } else if (zzB != j2) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (int i7 = 0; i7 < zzayxArr2.length; i7++) {
                boolean z2 = true;
                if (iArr2[i7] == i6) {
                    zzbac.zze(zzayoArr4[i7] != null);
                    zzayo zzayo2 = zzayoArr4[i7];
                    zzayoArr3[i7] = zzayo2;
                    this.zzb.put(zzayo2, Integer.valueOf(i6));
                    z = true;
                } else if (iArr[i7] == i6) {
                    if (zzayoArr4[i7] != null) {
                        z2 = false;
                    }
                    zzbac.zze(z2);
                }
            }
            if (z) {
                arrayList2.add(this.zza[i6]);
            }
            i4 = i6 + 1;
            arrayList = arrayList2;
            zzayxArr3 = zzayxArr4;
        }
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zzayoArr3, 0, zzayoArr2, 0, zzayoArr3.length);
        this.zzf = new zzayc[arrayList3.size()];
        arrayList3.toArray(this.zzf);
        this.zzg = new zzaxq(this.zzf);
        return j2;
    }

    public final long zza() {
        return this.zzg.zza();
    }

    public final boolean zzbj(long j) {
        return this.zzg.zzbj(j);
    }

    public final /* bridge */ /* synthetic */ void zze(zzayq zzayq) {
        zzayc zzayc = (zzayc) zzayq;
        if (this.zze != null) {
            this.zzc.zze(this);
        }
    }

    public final void zzf(zzayc zzayc) {
        int i = this.zzd - 1;
        this.zzd = i;
        if (i <= 0) {
            int i2 = 0;
            for (zzayc zzn : this.zza) {
                i2 += zzn.zzn().zzb;
            }
            zzays[] zzaysArr = new zzays[i2];
            zzayc[] zzaycArr = this.zza;
            int length = zzaycArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                zzayt zzn2 = zzaycArr[i3].zzn();
                int i5 = zzn2.zzb;
                int i6 = i4;
                int i7 = 0;
                while (i7 < i5) {
                    zzaysArr[i6] = zzn2.zzb(i7);
                    i7++;
                    i6++;
                }
                i3++;
                i4 = i6;
            }
            this.zze = new zzayt(zzaysArr);
            this.zzc.zzf(this);
        }
    }

    public final long zzg() {
        long j = Long.MAX_VALUE;
        for (zzayc zzg2 : this.zzf) {
            long zzg3 = zzg2.zzg();
            if (zzg3 != Long.MIN_VALUE) {
                j = Math.min(j, zzg3);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final long zzh() {
        long zzh = this.zza[0].zzh();
        int i = 1;
        while (true) {
            zzayc[] zzaycArr = this.zza;
            if (i >= zzaycArr.length) {
                if (zzh != C.TIME_UNSET) {
                    zzayc[] zzaycArr2 = this.zzf;
                    int length = zzaycArr2.length;
                    int i2 = 0;
                    while (i2 < length) {
                        zzayc zzayc = zzaycArr2[i2];
                        if (zzayc == this.zza[0] || zzayc.zzi(zzh) == zzh) {
                            i2++;
                        } else {
                            throw new IllegalStateException("Children seeked to different positions");
                        }
                    }
                }
                return zzh;
            } else if (zzaycArr[i].zzh() == C.TIME_UNSET) {
                i++;
            } else {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
    }

    public final long zzi(long j) {
        long zzi = this.zzf[0].zzi(j);
        int i = 1;
        while (true) {
            zzayc[] zzaycArr = this.zzf;
            if (i >= zzaycArr.length) {
                return zzi;
            }
            if (zzaycArr[i].zzi(zzi) == zzi) {
                i++;
            } else {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
    }

    public final zzayt zzn() {
        return this.zze;
    }

    public final void zzq(long j) {
        for (zzayc zzq : this.zzf) {
            zzq.zzq(j);
        }
    }

    public final void zzs() throws IOException {
        for (zzayc zzs : this.zza) {
            zzs.zzs();
        }
    }

    public final void zzw(zzayb zzayb, long j) {
        this.zzc = zzayb;
        this.zzd = r0;
        for (zzayc zzw : this.zza) {
            zzw.zzw(this, j);
        }
    }
}
