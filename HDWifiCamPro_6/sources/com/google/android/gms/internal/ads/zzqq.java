package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Trace;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.utility.platform.Platform;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzqq extends zzgr {
    private static final byte[] zzb = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    private float zzA;
    private ArrayDeque zzB;
    private zzqp zzC;
    private zzqn zzD;
    private int zzE;
    private boolean zzF;
    private boolean zzG;
    private boolean zzH;
    private boolean zzI;
    private boolean zzJ;
    private boolean zzK;
    private boolean zzL;
    private boolean zzM;
    private boolean zzN;
    private zzqg zzO;
    private long zzP;
    private int zzQ;
    private int zzR;
    private ByteBuffer zzS;
    private boolean zzT;
    private boolean zzU;
    private boolean zzV;
    private boolean zzW;
    private boolean zzX;
    private boolean zzY;
    private int zzZ;
    protected zzgs zza;
    private int zzaa;
    private int zzab;
    private boolean zzac;
    private boolean zzad;
    private boolean zzae;
    private long zzaf;
    private long zzag;
    private boolean zzah;
    private boolean zzai;
    private boolean zzaj;
    private long zzak;
    private long zzal;
    private int zzam;
    private zzpr zzan;
    private zzpr zzao;
    private final zzqk zzc;
    private final zzqs zzd;
    private final float zze;
    private final zzgi zzf;
    private final zzgi zzg;
    private final zzgi zzh;
    private final zzqf zzi;
    private final zzek zzj;
    private final ArrayList zzk;
    private final MediaCodec.BufferInfo zzl;
    private final long[] zzm;
    private final long[] zzn;
    private final long[] zzo;
    private zzaf zzp;
    private zzaf zzq;
    private MediaCrypto zzr;
    private boolean zzs;
    private long zzt;
    private float zzu;
    private float zzv;
    private zzql zzw;
    private zzaf zzx;
    private MediaFormat zzy;
    private boolean zzz;

    public zzqq(int i, zzqk zzqk, zzqs zzqs, boolean z, float f) {
        super(i);
        this.zzc = zzqk;
        if (zzqs != null) {
            this.zzd = zzqs;
            this.zze = f;
            this.zzf = new zzgi(0, 0);
            this.zzg = new zzgi(0, 0);
            this.zzh = new zzgi(2, 0);
            this.zzi = new zzqf();
            this.zzj = new zzek(10);
            this.zzk = new ArrayList();
            this.zzl = new MediaCodec.BufferInfo();
            this.zzu = 1.0f;
            this.zzv = 1.0f;
            this.zzt = C.TIME_UNSET;
            this.zzm = new long[10];
            this.zzn = new long[10];
            this.zzo = new long[10];
            this.zzak = C.TIME_UNSET;
            this.zzal = C.TIME_UNSET;
            this.zzi.zzi(0);
            this.zzi.zzb.order(ByteOrder.nativeOrder());
            this.zzA = -1.0f;
            this.zzE = 0;
            this.zzZ = 0;
            this.zzQ = -1;
            this.zzR = -1;
            this.zzP = C.TIME_UNSET;
            this.zzaf = C.TIME_UNSET;
            this.zzag = C.TIME_UNSET;
            this.zzaa = 0;
            this.zzab = 0;
            return;
        }
        throw null;
    }

    private final void zzT() {
        this.zzX = false;
        this.zzi.zzb();
        this.zzh.zzb();
        this.zzW = false;
        this.zzV = false;
    }

    private final void zzU() throws zzha {
        if (this.zzac) {
            this.zzaa = 1;
            this.zzab = 3;
            return;
        }
        zzap();
        zzan();
    }

    private final void zzaA() throws zzha {
        try {
            throw null;
        } catch (MediaCryptoException e) {
            throw zzbg(e, this.zzp, false, 6006);
        }
    }

    private final boolean zzaB() throws zzha {
        if (this.zzac) {
            this.zzaa = 1;
            if (this.zzG || this.zzI) {
                this.zzab = 3;
                return false;
            }
            this.zzab = 2;
        } else {
            zzaA();
        }
        return true;
    }

    private final boolean zzaC() throws zzha {
        zzql zzql = this.zzw;
        if (zzql == null || this.zzaa == 2 || this.zzah) {
            return false;
        }
        if (this.zzQ < 0) {
            int zza2 = zzql.zza();
            this.zzQ = zza2;
            if (zza2 < 0) {
                return false;
            }
            this.zzg.zzb = this.zzw.zzf(zza2);
            this.zzg.zzb();
        }
        if (this.zzaa == 1) {
            if (!this.zzN) {
                this.zzad = true;
                this.zzw.zzj(this.zzQ, 0, 0, 0, 4);
                zzay();
            }
            this.zzaa = 2;
            return false;
        } else if (this.zzL) {
            this.zzL = false;
            this.zzg.zzb.put(zzb);
            this.zzw.zzj(this.zzQ, 0, 38, 0, 0);
            zzay();
            this.zzac = true;
            return true;
        } else {
            if (this.zzZ == 1) {
                for (int i = 0; i < this.zzx.zzo.size(); i++) {
                    this.zzg.zzb.put((byte[]) this.zzx.zzo.get(i));
                }
                this.zzZ = 2;
            }
            int position = this.zzg.zzb.position();
            zzjg zzh2 = zzh();
            try {
                int zzbf = zzbf(zzh2, this.zzg, 0);
                if (zzG()) {
                    this.zzag = this.zzaf;
                }
                if (zzbf == -3) {
                    return false;
                }
                if (zzbf == -5) {
                    if (this.zzZ == 2) {
                        this.zzg.zzb();
                        this.zzZ = 1;
                    }
                    zzS(zzh2);
                    return true;
                }
                zzgi zzgi = this.zzg;
                if (zzgi.zzg()) {
                    if (this.zzZ == 2) {
                        zzgi.zzb();
                        this.zzZ = 1;
                    }
                    this.zzah = true;
                    if (!this.zzac) {
                        zzax();
                        return false;
                    }
                    try {
                        if (!this.zzN) {
                            this.zzad = true;
                            this.zzw.zzj(this.zzQ, 0, 0, 0, 4);
                            zzay();
                        }
                        return false;
                    } catch (MediaCodec.CryptoException e) {
                        throw zzbg(e, this.zzp, false, zzen.zzl(e.getErrorCode()));
                    }
                } else if (this.zzac || zzgi.zzh()) {
                    boolean zzk2 = zzgi.zzk();
                    if (zzk2) {
                        zzgi.zza.zzb(position);
                    }
                    if (this.zzF && !zzk2) {
                        ByteBuffer byteBuffer = this.zzg.zzb;
                        byte[] bArr = zzaaf.zza;
                        int position2 = byteBuffer.position();
                        int i2 = 0;
                        int i3 = 0;
                        while (true) {
                            int i4 = i2 + 1;
                            if (i4 >= position2) {
                                byteBuffer.clear();
                                break;
                            }
                            byte b = byteBuffer.get(i2) & UByte.MAX_VALUE;
                            if (i3 == 3) {
                                if (b == 1) {
                                    if ((byteBuffer.get(i4) & 31) == 7) {
                                        ByteBuffer duplicate = byteBuffer.duplicate();
                                        duplicate.position(i2 - 3);
                                        duplicate.limit(position2);
                                        byteBuffer.position(0);
                                        byteBuffer.put(duplicate);
                                        break;
                                    }
                                    b = 1;
                                }
                            } else if (b == 0) {
                                i3++;
                            }
                            if (b != 0) {
                                i3 = 0;
                            }
                            i2 = i4;
                        }
                        if (this.zzg.zzb.position() == 0) {
                            return true;
                        }
                        this.zzF = false;
                    }
                    zzgi zzgi2 = this.zzg;
                    long j = zzgi2.zzd;
                    zzqg zzqg = this.zzO;
                    if (zzqg != null) {
                        j = zzqg.zzb(this.zzp, zzgi2);
                        this.zzaf = Math.max(this.zzaf, this.zzO.zza(this.zzp));
                    }
                    long j2 = j;
                    if (this.zzg.zzf()) {
                        this.zzk.add(Long.valueOf(j2));
                    }
                    if (this.zzaj) {
                        this.zzj.zzd(j2, this.zzp);
                        this.zzaj = false;
                    }
                    this.zzaf = Math.max(this.zzaf, j2);
                    this.zzg.zzj();
                    zzgi zzgi3 = this.zzg;
                    if (zzgi3.zze()) {
                        zzam(zzgi3);
                    }
                    zzad(this.zzg);
                    if (zzk2) {
                        try {
                            this.zzw.zzk(this.zzQ, 0, this.zzg.zza, j2, 0);
                        } catch (MediaCodec.CryptoException e2) {
                            throw zzbg(e2, this.zzp, false, zzen.zzl(e2.getErrorCode()));
                        }
                    } else {
                        this.zzw.zzj(this.zzQ, 0, this.zzg.zzb.limit(), j2, 0);
                    }
                    zzay();
                    this.zzac = true;
                    this.zzZ = 0;
                    this.zza.zzc++;
                    return true;
                } else {
                    zzgi.zzb();
                    if (this.zzZ == 2) {
                        this.zzZ = 1;
                    }
                    return true;
                }
            } catch (zzgh e3) {
                zzX(e3);
                zzaE(0);
                zzab();
                return true;
            }
        }
    }

    private final boolean zzaD() {
        return this.zzR >= 0;
    }

    private final boolean zzaE(int i) throws zzha {
        zzjg zzh2 = zzh();
        this.zzf.zzb();
        int zzbf = zzbf(zzh2, this.zzf, i | 4);
        if (zzbf == -5) {
            zzS(zzh2);
            return true;
        } else if (zzbf != -4 || !this.zzf.zzg()) {
            return false;
        } else {
            this.zzah = true;
            zzax();
            return false;
        }
    }

    private final boolean zzaF(long j) {
        return this.zzt == C.TIME_UNSET || SystemClock.elapsedRealtime() - j < this.zzt;
    }

    private final boolean zzaG(zzaf zzaf2) throws zzha {
        if (!(zzen.zza < 23 || this.zzw == null || this.zzab == 3 || zzbe() == 0)) {
            float zzP2 = zzP(this.zzv, zzaf2, zzJ());
            float f = this.zzA;
            if (f == zzP2) {
                return true;
            }
            if (zzP2 == -1.0f) {
                zzU();
                return false;
            } else if (f == -1.0f && zzP2 <= this.zze) {
                return true;
            } else {
                Bundle bundle = new Bundle();
                bundle.putFloat("operating-rate", zzP2);
                this.zzw.zzp(bundle);
                this.zzA = zzP2;
            }
        }
        return true;
    }

    private final void zzab() {
        try {
            this.zzw.zzi();
        } finally {
            zzaq();
        }
    }

    protected static boolean zzav(zzaf zzaf2) {
        return zzaf2.zzF == 0;
    }

    /* JADX INFO: finally extract failed */
    private final void zzaw(zzqn zzqn, MediaCrypto mediaCrypto) throws Exception {
        float f;
        zzql zzql;
        int i;
        boolean z;
        boolean z2;
        MediaCodec mediaCodec;
        zzqn zzqn2 = zzqn;
        String str = zzqn2.zza;
        if (zzen.zza < 23) {
            f = -1.0f;
        } else {
            f = zzP(this.zzv, this.zzp, zzJ());
        }
        if (f <= this.zze) {
            f = -1.0f;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        zzqj zzV2 = zzV(zzqn2, this.zzp, (MediaCrypto) null, f);
        if (zzen.zza >= 31) {
            zzqo.zza(zzV2, zzl());
        }
        try {
            Trace.beginSection("createCodec:" + str);
            if (zzen.zza < 23 || zzen.zza < 31) {
                try {
                    zzqn zzqn3 = zzV2.zza;
                    if (zzqn3 != null) {
                        String str2 = zzqn3.zza;
                        Trace.beginSection("createCodec:".concat(String.valueOf(str2)));
                        mediaCodec = MediaCodec.createByCodecName(str2);
                        Trace.endSection();
                        try {
                            Trace.beginSection("configureCodec");
                            mediaCodec.configure(zzV2.zzb, zzV2.zzd, (MediaCrypto) null, 0);
                            Trace.endSection();
                            Trace.beginSection("startCodec");
                            mediaCodec.start();
                            Trace.endSection();
                            zzql = new zzrh(mediaCodec, (zzrg) null);
                        } catch (IOException | RuntimeException e) {
                            e = e;
                            if (mediaCodec != null) {
                                mediaCodec.release();
                            }
                            throw e;
                        }
                    } else {
                        throw null;
                    }
                } catch (IOException | RuntimeException e2) {
                    e = e2;
                    mediaCodec = null;
                }
            } else {
                int zzb2 = zzbt.zzb(zzV2.zzc.zzm);
                zzdw.zzd("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type ".concat(zzen.zzO(zzb2)));
                zzql = new zzpw(zzb2, false).zzc(zzV2);
            }
            this.zzw = zzql;
            Trace.endSection();
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            this.zzD = zzqn2;
            this.zzA = f;
            this.zzx = this.zzp;
            if (zzen.zza > 25 || !"OMX.Exynos.avc.dec.secure".equals(str) || (!zzen.zzd.startsWith("SM-T585") && !zzen.zzd.startsWith("SM-A510") && !zzen.zzd.startsWith("SM-A520") && !zzen.zzd.startsWith("SM-J700"))) {
                i = (zzen.zza >= 24 || (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) || (!"flounder".equals(zzen.zzb) && !"flounder_lte".equals(zzen.zzb) && !"grouper".equals(zzen.zzb) && !"tilapia".equals(zzen.zzb))) ? 0 : 1;
            } else {
                i = 2;
            }
            this.zzE = i;
            this.zzF = zzen.zza < 21 && this.zzx.zzo.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
            this.zzG = zzen.zza == 19 && zzen.zzd.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str));
            this.zzH = zzen.zza == 29 && "c2.android.aac.decoder".equals(str);
            if ((zzen.zza > 23 || !"OMX.google.vorbis.decoder".equals(str)) && (zzen.zza > 19 || ((!"hb2000".equals(zzen.zzb) && !"stvm8".equals(zzen.zzb)) || (!"OMX.amlogic.avc.decoder.awesome".equals(str) && !"OMX.amlogic.avc.decoder.awesome.secure".equals(str))))) {
                z = false;
            } else {
                z = true;
            }
            this.zzI = z;
            this.zzJ = zzen.zza == 21 && "OMX.google.aac.decoder".equals(str);
            this.zzK = zzen.zza < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(zzen.zzc) && (zzen.zzb.startsWith("baffin") || zzen.zzb.startsWith("grand") || zzen.zzb.startsWith("fortuna") || zzen.zzb.startsWith("gprimelte") || zzen.zzb.startsWith("j2y18lte") || zzen.zzb.startsWith("ms01"));
            String str3 = zzqn2.zza;
            if ((zzen.zza > 25 || !"OMX.rk.video_decoder.avc".equals(str3)) && ((zzen.zza > 29 || (!"OMX.broadcom.video_decoder.tunnel".equals(str3) && !"OMX.broadcom.video_decoder.tunnel.secure".equals(str3))) && (!Platform.MANUFACTURER_AMAZON.equals(zzen.zzc) || !"AFTS".equals(zzen.zzd) || !zzqn2.zzf))) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.zzN = z2;
            this.zzw.zzr();
            if ("c2.android.mp3.decoder".equals(zzqn2.zza)) {
                this.zzO = new zzqg();
            }
            if (zzbe() == 2) {
                this.zzP = SystemClock.elapsedRealtime() + 1000;
            }
            this.zza.zza++;
            zzY(str, zzV2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    private final void zzay() {
        this.zzQ = -1;
        this.zzg.zzb = null;
    }

    private final void zzaz() {
        this.zzR = -1;
        this.zzS = null;
    }

    public void zzD(float f, float f2) throws zzha {
        this.zzu = f;
        this.zzv = f2;
        zzaG(this.zzx);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v6, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v34, resolved type: com.google.android.gms.internal.ads.zzql} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v35, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v36, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v37, resolved type: android.media.MediaFormat} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v14, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v80, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v81, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v84, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v85, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v25, resolved type: com.google.android.gms.internal.ads.zzaf} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v93, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v94, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v95, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v96, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v97, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v98, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v99, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v100, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v33, resolved type: com.google.android.gms.internal.ads.zzaf} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v34, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX WARNING: type inference failed for: r19v0 */
    /* JADX WARNING: type inference failed for: r19v1 */
    /* JADX WARNING: type inference failed for: r19v3 */
    /* JADX WARNING: type inference failed for: r19v6 */
    /* JADX WARNING: type inference failed for: r19v16 */
    /* JADX WARNING: type inference failed for: r19v19 */
    /* JADX WARNING: type inference failed for: r19v20 */
    /* JADX WARNING: Can't wrap try/catch for region: R(13:175|176|177|178|179|(1:181)|182|183|268|(1:203)|207|218|219) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:94|95|(1:97)(0)) */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x027b, code lost:
        if (r15.zzq != null) goto L_0x027d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x02c9, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:?, code lost:
        zzax();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x02cc, code lost:
        r15 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x02ce, code lost:
        r19 = r19;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x02d0, code lost:
        if (r15.zzai != false) goto L_0x02d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x02d2, code lost:
        zzap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x02d5, code lost:
        r1 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x02d6, code lost:
        r2 = r21;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x02d9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x02da, code lost:
        r2 = true;
        r19 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x034a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x034b, code lost:
        r1 = r15;
        r19 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007f, code lost:
        r14 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0080, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r15.zzai = true;
        r13 = false;
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x012d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x012e, code lost:
        r2 = true;
        r1 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x015e, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
        zzax();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0163, code lost:
        if (r15.zzai != false) goto L_0x0165;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0165, code lost:
        zzap();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:175:0x02c9 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:94:0x015e */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0178 A[Catch:{ IllegalStateException -> 0x0370 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01b1 A[Catch:{ IllegalStateException -> 0x0370 }] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0309  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x032a A[Catch:{ IllegalStateException -> 0x036d }, LOOP:2: B:85:0x0147->B:201:0x032a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0335 A[Catch:{ IllegalStateException -> 0x036d }, LOOP:4: B:203:0x0335->B:206:0x033f, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x0332 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0329 A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzL(long r24, long r26) throws com.google.android.gms.internal.ads.zzha {
        /*
            r23 = this;
            r15 = r23
            r14 = 1
            r13 = 0
            boolean r0 = r15.zzai     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 == 0) goto L_0x000c
            r23.zzae()     // Catch:{ IllegalStateException -> 0x0370 }
            return
        L_0x000c:
            com.google.android.gms.internal.ads.zzaf r0 = r15.zzp     // Catch:{ IllegalStateException -> 0x0370 }
            r11 = 2
            if (r0 != 0) goto L_0x0019
            boolean r0 = r15.zzaE(r11)     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 == 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            return
        L_0x0019:
            r23.zzan()     // Catch:{ IllegalStateException -> 0x0370 }
            boolean r0 = r15.zzV     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 == 0) goto L_0x0138
            java.lang.String r0 = "bypassRender"
            int r1 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ IllegalStateException -> 0x0370 }
            android.os.Trace.beginSection(r0)     // Catch:{ IllegalStateException -> 0x0370 }
        L_0x0027:
            boolean r0 = r15.zzai     // Catch:{ IllegalStateException -> 0x0370 }
            r0 = r0 ^ r14
            com.google.android.gms.internal.ads.zzdd.zzf(r0)     // Catch:{ IllegalStateException -> 0x0370 }
            com.google.android.gms.internal.ads.zzqf r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0370 }
            boolean r1 = r0.zzp()     // Catch:{ IllegalStateException -> 0x0370 }
            if (r1 == 0) goto L_0x007b
            java.nio.ByteBuffer r7 = r0.zzb     // Catch:{ IllegalStateException -> 0x0370 }
            int r8 = r15.zzR     // Catch:{ IllegalStateException -> 0x0370 }
            int r10 = r0.zzl()     // Catch:{ IllegalStateException -> 0x0370 }
            long r11 = r0.zzd     // Catch:{ IllegalStateException -> 0x0370 }
            boolean r16 = r0.zzf()     // Catch:{ IllegalStateException -> 0x0370 }
            r6 = 0
            r9 = 0
            boolean r0 = r0.zzg()     // Catch:{ IllegalStateException -> 0x0370 }
            com.google.android.gms.internal.ads.zzaf r4 = r15.zzq     // Catch:{ IllegalStateException -> 0x0370 }
            r1 = r23
            r2 = r24
            r17 = r4
            r4 = r26
            r13 = r16
            r14 = r0
            r15 = r17
            boolean r0 = r1.zzaf(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x0075 }
            if (r0 == 0) goto L_0x006f
            r15 = r23
            com.google.android.gms.internal.ads.zzqf r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0131 }
            long r0 = r0.zzm()     // Catch:{ IllegalStateException -> 0x0131 }
            r15.zzao(r0)     // Catch:{ IllegalStateException -> 0x0131 }
            com.google.android.gms.internal.ads.zzqf r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0131 }
            r0.zzb()     // Catch:{ IllegalStateException -> 0x0131 }
            goto L_0x007b
        L_0x006f:
            r15 = r23
            r13 = 0
            r14 = 1
            goto L_0x0124
        L_0x0075:
            r0 = move-exception
            r2 = 1
            r19 = 0
            goto L_0x02db
        L_0x007b:
            boolean r0 = r15.zzah     // Catch:{ IllegalStateException -> 0x0131 }
            if (r0 == 0) goto L_0x0085
            r14 = 1
            r15.zzai = r14     // Catch:{ IllegalStateException -> 0x012d }
            r13 = 0
            goto L_0x0124
        L_0x0085:
            r14 = 1
            boolean r0 = r15.zzW     // Catch:{ IllegalStateException -> 0x012d }
            if (r0 == 0) goto L_0x0099
            com.google.android.gms.internal.ads.zzqf r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x012d }
            com.google.android.gms.internal.ads.zzgi r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x012d }
            boolean r0 = r0.zzo(r1)     // Catch:{ IllegalStateException -> 0x012d }
            com.google.android.gms.internal.ads.zzdd.zzf(r0)     // Catch:{ IllegalStateException -> 0x012d }
            r13 = 0
            r15.zzW = r13     // Catch:{ IllegalStateException -> 0x0370 }
            goto L_0x009a
        L_0x0099:
            r13 = 0
        L_0x009a:
            boolean r0 = r15.zzX     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 == 0) goto L_0x00b2
            com.google.android.gms.internal.ads.zzqf r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0370 }
            boolean r0 = r0.zzp()     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 != 0) goto L_0x0027
            r23.zzT()     // Catch:{ IllegalStateException -> 0x0370 }
            r15.zzX = r13     // Catch:{ IllegalStateException -> 0x0370 }
            r23.zzan()     // Catch:{ IllegalStateException -> 0x0370 }
            boolean r0 = r15.zzV     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 == 0) goto L_0x0124
        L_0x00b2:
            boolean r0 = r15.zzah     // Catch:{ IllegalStateException -> 0x0370 }
            r0 = r0 ^ r14
            com.google.android.gms.internal.ads.zzdd.zzf(r0)     // Catch:{ IllegalStateException -> 0x0370 }
            com.google.android.gms.internal.ads.zzjg r0 = r23.zzh()     // Catch:{ IllegalStateException -> 0x0370 }
            com.google.android.gms.internal.ads.zzgi r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0370 }
            r1.zzb()     // Catch:{ IllegalStateException -> 0x0370 }
        L_0x00c1:
            com.google.android.gms.internal.ads.zzgi r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0370 }
            r1.zzb()     // Catch:{ IllegalStateException -> 0x0370 }
            com.google.android.gms.internal.ads.zzgi r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0370 }
            int r1 = r15.zzbf(r0, r1, r13)     // Catch:{ IllegalStateException -> 0x0370 }
            r2 = -5
            if (r1 == r2) goto L_0x0104
            r2 = -4
            if (r1 == r2) goto L_0x00d3
            goto L_0x0107
        L_0x00d3:
            com.google.android.gms.internal.ads.zzgi r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0370 }
            boolean r1 = r1.zzg()     // Catch:{ IllegalStateException -> 0x0370 }
            if (r1 == 0) goto L_0x00de
            r15.zzah = r14     // Catch:{ IllegalStateException -> 0x0370 }
            goto L_0x0107
        L_0x00de:
            boolean r1 = r15.zzaj     // Catch:{ IllegalStateException -> 0x0370 }
            if (r1 == 0) goto L_0x00f2
            com.google.android.gms.internal.ads.zzaf r1 = r15.zzp     // Catch:{ IllegalStateException -> 0x0370 }
            r2 = 0
            if (r1 == 0) goto L_0x00f1
            r15.zzq = r1     // Catch:{ IllegalStateException -> 0x0370 }
            com.google.android.gms.internal.ads.zzaf r1 = r15.zzq     // Catch:{ IllegalStateException -> 0x0370 }
            r15.zzaa(r1, r2)     // Catch:{ IllegalStateException -> 0x0370 }
            r15.zzaj = r13     // Catch:{ IllegalStateException -> 0x0370 }
            goto L_0x00f2
        L_0x00f1:
            throw r2     // Catch:{ IllegalStateException -> 0x0370 }
        L_0x00f2:
            com.google.android.gms.internal.ads.zzgi r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0370 }
            r1.zzj()     // Catch:{ IllegalStateException -> 0x0370 }
            com.google.android.gms.internal.ads.zzqf r1 = r15.zzi     // Catch:{ IllegalStateException -> 0x0370 }
            com.google.android.gms.internal.ads.zzgi r2 = r15.zzh     // Catch:{ IllegalStateException -> 0x0370 }
            boolean r1 = r1.zzo(r2)     // Catch:{ IllegalStateException -> 0x0370 }
            if (r1 != 0) goto L_0x00c1
            r15.zzW = r14     // Catch:{ IllegalStateException -> 0x0370 }
            goto L_0x0107
        L_0x0104:
            r15.zzS(r0)     // Catch:{ IllegalStateException -> 0x0370 }
        L_0x0107:
            com.google.android.gms.internal.ads.zzqf r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0370 }
            boolean r1 = r0.zzp()     // Catch:{ IllegalStateException -> 0x0370 }
            if (r1 == 0) goto L_0x0112
            r0.zzj()     // Catch:{ IllegalStateException -> 0x0370 }
        L_0x0112:
            com.google.android.gms.internal.ads.zzqf r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0370 }
            boolean r0 = r0.zzp()     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 != 0) goto L_0x0027
            boolean r0 = r15.zzah     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 != 0) goto L_0x0027
            boolean r0 = r15.zzX     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 == 0) goto L_0x0124
            goto L_0x0027
        L_0x0124:
            android.os.Trace.endSection()     // Catch:{ IllegalStateException -> 0x0370 }
            r19 = r13
            r2 = r14
            r1 = r15
            goto L_0x0365
        L_0x012d:
            r0 = move-exception
            r2 = r14
            r1 = r15
            goto L_0x0134
        L_0x0131:
            r0 = move-exception
            r1 = r15
            r2 = 1
        L_0x0134:
            r19 = 0
            goto L_0x0375
        L_0x0138:
            com.google.android.gms.internal.ads.zzql r0 = r15.zzw     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 == 0) goto L_0x0353
            long r9 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IllegalStateException -> 0x034d }
            java.lang.String r0 = "drainAndFeed"
            int r1 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ IllegalStateException -> 0x034d }
            android.os.Trace.beginSection(r0)     // Catch:{ IllegalStateException -> 0x034d }
        L_0x0147:
            boolean r0 = r23.zzaD()     // Catch:{ IllegalStateException -> 0x034d }
            if (r0 != 0) goto L_0x0286
            boolean r0 = r15.zzJ     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 == 0) goto L_0x016e
            boolean r0 = r15.zzad     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 == 0) goto L_0x016e
            com.google.android.gms.internal.ads.zzql r0 = r15.zzw     // Catch:{ IllegalStateException -> 0x015e }
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x015e }
            int r0 = r0.zzb(r1)     // Catch:{ IllegalStateException -> 0x015e }
            goto L_0x0176
        L_0x015e:
            r23.zzax()     // Catch:{ IllegalStateException -> 0x0370 }
            boolean r0 = r15.zzai     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 == 0) goto L_0x0168
            r23.zzap()     // Catch:{ IllegalStateException -> 0x0370 }
        L_0x0168:
            r2 = r9
            r19 = r13
            r1 = r15
            goto L_0x0335
        L_0x016e:
            com.google.android.gms.internal.ads.zzql r0 = r15.zzw     // Catch:{ IllegalStateException -> 0x0370 }
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x0370 }
            int r0 = r0.zzb(r1)     // Catch:{ IllegalStateException -> 0x0370 }
        L_0x0176:
            if (r0 >= 0) goto L_0x01b1
            r1 = -2
            if (r0 != r1) goto L_0x01a1
            r15.zzae = r14     // Catch:{ IllegalStateException -> 0x0370 }
            com.google.android.gms.internal.ads.zzql r0 = r15.zzw     // Catch:{ IllegalStateException -> 0x0370 }
            android.media.MediaFormat r0 = r0.zzc()     // Catch:{ IllegalStateException -> 0x0370 }
            int r1 = r15.zzE     // Catch:{ IllegalStateException -> 0x0370 }
            if (r1 == 0) goto L_0x019c
            java.lang.String r1 = "width"
            int r1 = r0.getInteger(r1)     // Catch:{ IllegalStateException -> 0x0370 }
            r2 = 32
            if (r1 != r2) goto L_0x019c
            java.lang.String r1 = "height"
            int r1 = r0.getInteger(r1)     // Catch:{ IllegalStateException -> 0x0370 }
            if (r1 != r2) goto L_0x019c
            r15.zzM = r14     // Catch:{ IllegalStateException -> 0x0370 }
            goto L_0x01bc
        L_0x019c:
            r15.zzy = r0     // Catch:{ IllegalStateException -> 0x0370 }
            r15.zzz = r14     // Catch:{ IllegalStateException -> 0x0370 }
            goto L_0x01bc
        L_0x01a1:
            boolean r0 = r15.zzN     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 == 0) goto L_0x0168
            boolean r0 = r15.zzah     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 != 0) goto L_0x01ad
            int r0 = r15.zzaa     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 != r11) goto L_0x0168
        L_0x01ad:
            r23.zzax()     // Catch:{ IllegalStateException -> 0x0370 }
            goto L_0x0168
        L_0x01b1:
            boolean r1 = r15.zzM     // Catch:{ IllegalStateException -> 0x0370 }
            if (r1 == 0) goto L_0x01c3
            r15.zzM = r13     // Catch:{ IllegalStateException -> 0x0370 }
            com.google.android.gms.internal.ads.zzql r1 = r15.zzw     // Catch:{ IllegalStateException -> 0x0370 }
            r1.zzn(r0, r13)     // Catch:{ IllegalStateException -> 0x0370 }
        L_0x01bc:
            r2 = r9
            r0 = r11
            r19 = r13
            r1 = r15
            goto L_0x0323
        L_0x01c3:
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x0370 }
            int r1 = r1.size     // Catch:{ IllegalStateException -> 0x0370 }
            if (r1 != 0) goto L_0x01d5
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x0370 }
            int r1 = r1.flags     // Catch:{ IllegalStateException -> 0x0370 }
            r1 = r1 & 4
            if (r1 == 0) goto L_0x01d5
            r23.zzax()     // Catch:{ IllegalStateException -> 0x0370 }
            goto L_0x0168
        L_0x01d5:
            r15.zzR = r0     // Catch:{ IllegalStateException -> 0x0370 }
            com.google.android.gms.internal.ads.zzql r1 = r15.zzw     // Catch:{ IllegalStateException -> 0x0370 }
            java.nio.ByteBuffer r0 = r1.zzg(r0)     // Catch:{ IllegalStateException -> 0x0370 }
            r15.zzS = r0     // Catch:{ IllegalStateException -> 0x0370 }
            java.nio.ByteBuffer r0 = r15.zzS     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 == 0) goto L_0x01f8
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x0370 }
            int r1 = r1.offset     // Catch:{ IllegalStateException -> 0x0370 }
            r0.position(r1)     // Catch:{ IllegalStateException -> 0x0370 }
            java.nio.ByteBuffer r0 = r15.zzS     // Catch:{ IllegalStateException -> 0x0370 }
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x0370 }
            int r1 = r1.offset     // Catch:{ IllegalStateException -> 0x0370 }
            android.media.MediaCodec$BufferInfo r2 = r15.zzl     // Catch:{ IllegalStateException -> 0x0370 }
            int r2 = r2.size     // Catch:{ IllegalStateException -> 0x0370 }
            int r1 = r1 + r2
            r0.limit(r1)     // Catch:{ IllegalStateException -> 0x0370 }
        L_0x01f8:
            boolean r0 = r15.zzK     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 == 0) goto L_0x021d
            android.media.MediaCodec$BufferInfo r0 = r15.zzl     // Catch:{ IllegalStateException -> 0x0370 }
            long r0 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0370 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x021d
            android.media.MediaCodec$BufferInfo r0 = r15.zzl     // Catch:{ IllegalStateException -> 0x0370 }
            int r0 = r0.flags     // Catch:{ IllegalStateException -> 0x0370 }
            r0 = r0 & 4
            if (r0 == 0) goto L_0x021d
            long r0 = r15.zzaf     // Catch:{ IllegalStateException -> 0x0370 }
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x021d
            android.media.MediaCodec$BufferInfo r2 = r15.zzl     // Catch:{ IllegalStateException -> 0x0370 }
            r2.presentationTimeUs = r0     // Catch:{ IllegalStateException -> 0x0370 }
        L_0x021d:
            android.media.MediaCodec$BufferInfo r0 = r15.zzl     // Catch:{ IllegalStateException -> 0x0370 }
            long r0 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0370 }
            java.util.ArrayList r2 = r15.zzk     // Catch:{ IllegalStateException -> 0x0370 }
            int r2 = r2.size()     // Catch:{ IllegalStateException -> 0x0370 }
            r3 = r13
        L_0x0228:
            if (r3 >= r2) goto L_0x0244
            java.util.ArrayList r4 = r15.zzk     // Catch:{ IllegalStateException -> 0x0370 }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ IllegalStateException -> 0x0370 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ IllegalStateException -> 0x0370 }
            long r4 = r4.longValue()     // Catch:{ IllegalStateException -> 0x0370 }
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 != 0) goto L_0x0241
            java.util.ArrayList r0 = r15.zzk     // Catch:{ IllegalStateException -> 0x0370 }
            r0.remove(r3)     // Catch:{ IllegalStateException -> 0x0370 }
            r0 = r14
            goto L_0x0245
        L_0x0241:
            int r3 = r3 + 1
            goto L_0x0228
        L_0x0244:
            r0 = r13
        L_0x0245:
            r15.zzT = r0     // Catch:{ IllegalStateException -> 0x0370 }
            long r0 = r15.zzag     // Catch:{ IllegalStateException -> 0x0370 }
            android.media.MediaCodec$BufferInfo r2 = r15.zzl     // Catch:{ IllegalStateException -> 0x0370 }
            long r2 = r2.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0370 }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0253
            r0 = r14
            goto L_0x0254
        L_0x0253:
            r0 = r13
        L_0x0254:
            r15.zzU = r0     // Catch:{ IllegalStateException -> 0x0370 }
            android.media.MediaCodec$BufferInfo r0 = r15.zzl     // Catch:{ IllegalStateException -> 0x0370 }
            long r0 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0370 }
            com.google.android.gms.internal.ads.zzek r2 = r15.zzj     // Catch:{ IllegalStateException -> 0x0370 }
            java.lang.Object r0 = r2.zzc(r0)     // Catch:{ IllegalStateException -> 0x0370 }
            com.google.android.gms.internal.ads.zzaf r0 = (com.google.android.gms.internal.ads.zzaf) r0     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 != 0) goto L_0x0270
            boolean r1 = r15.zzz     // Catch:{ IllegalStateException -> 0x0370 }
            if (r1 == 0) goto L_0x0270
            com.google.android.gms.internal.ads.zzek r0 = r15.zzj     // Catch:{ IllegalStateException -> 0x0370 }
            java.lang.Object r0 = r0.zzb()     // Catch:{ IllegalStateException -> 0x0370 }
            com.google.android.gms.internal.ads.zzaf r0 = (com.google.android.gms.internal.ads.zzaf) r0     // Catch:{ IllegalStateException -> 0x0370 }
        L_0x0270:
            if (r0 == 0) goto L_0x0275
            r15.zzq = r0     // Catch:{ IllegalStateException -> 0x0370 }
            goto L_0x027d
        L_0x0275:
            boolean r0 = r15.zzz     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 == 0) goto L_0x0286
            com.google.android.gms.internal.ads.zzaf r0 = r15.zzq     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 == 0) goto L_0x0286
        L_0x027d:
            com.google.android.gms.internal.ads.zzaf r0 = r15.zzq     // Catch:{ IllegalStateException -> 0x0370 }
            android.media.MediaFormat r1 = r15.zzy     // Catch:{ IllegalStateException -> 0x0370 }
            r15.zzaa(r0, r1)     // Catch:{ IllegalStateException -> 0x0370 }
            r15.zzz = r13     // Catch:{ IllegalStateException -> 0x0370 }
        L_0x0286:
            boolean r0 = r15.zzJ     // Catch:{ IllegalStateException -> 0x034d }
            if (r0 == 0) goto L_0x02df
            boolean r0 = r15.zzad     // Catch:{ IllegalStateException -> 0x0370 }
            if (r0 == 0) goto L_0x02df
            com.google.android.gms.internal.ads.zzql r6 = r15.zzw     // Catch:{ IllegalStateException -> 0x02c5 }
            java.nio.ByteBuffer r7 = r15.zzS     // Catch:{ IllegalStateException -> 0x02c5 }
            int r8 = r15.zzR     // Catch:{ IllegalStateException -> 0x02c5 }
            android.media.MediaCodec$BufferInfo r0 = r15.zzl     // Catch:{ IllegalStateException -> 0x02c5 }
            int r0 = r0.flags     // Catch:{ IllegalStateException -> 0x02c5 }
            r12 = 1
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x02c5 }
            long r4 = r1.presentationTimeUs     // Catch:{ IllegalStateException -> 0x02c5 }
            boolean r2 = r15.zzT     // Catch:{ IllegalStateException -> 0x02c5 }
            boolean r3 = r15.zzU     // Catch:{ IllegalStateException -> 0x02c5 }
            com.google.android.gms.internal.ads.zzaf r1 = r15.zzq     // Catch:{ IllegalStateException -> 0x02c5 }
            r16 = r1
            r1 = r23
            r17 = r2
            r18 = r3
            r2 = r24
            r19 = r4
            r4 = r26
            r21 = r9
            r9 = r0
            r10 = r12
            r0 = r11
            r11 = r19
            r19 = r13
            r13 = r17
            r14 = r18
            r15 = r16
            boolean r1 = r1.zzaf(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x02c9 }
            goto L_0x0307
        L_0x02c5:
            r21 = r9
            r19 = r13
        L_0x02c9:
            r23.zzax()     // Catch:{ IllegalStateException -> 0x02d9 }
            r15 = r23
            boolean r0 = r15.zzai     // Catch:{ IllegalStateException -> 0x034a }
            if (r0 == 0) goto L_0x02d5
            r23.zzap()     // Catch:{ IllegalStateException -> 0x034a }
        L_0x02d5:
            r1 = r15
        L_0x02d6:
            r2 = r21
            goto L_0x0335
        L_0x02d9:
            r0 = move-exception
            r2 = 1
        L_0x02db:
            r1 = r23
            goto L_0x0375
        L_0x02df:
            r21 = r9
            r0 = r11
            r19 = r13
            com.google.android.gms.internal.ads.zzql r6 = r15.zzw     // Catch:{ IllegalStateException -> 0x034a }
            java.nio.ByteBuffer r7 = r15.zzS     // Catch:{ IllegalStateException -> 0x034a }
            int r8 = r15.zzR     // Catch:{ IllegalStateException -> 0x034a }
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x034a }
            int r9 = r1.flags     // Catch:{ IllegalStateException -> 0x034a }
            r10 = 1
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x034a }
            long r11 = r1.presentationTimeUs     // Catch:{ IllegalStateException -> 0x034a }
            boolean r13 = r15.zzT     // Catch:{ IllegalStateException -> 0x034a }
            boolean r14 = r15.zzU     // Catch:{ IllegalStateException -> 0x034a }
            com.google.android.gms.internal.ads.zzaf r4 = r15.zzq     // Catch:{ IllegalStateException -> 0x034a }
            r1 = r23
            r2 = r24
            r16 = r4
            r4 = r26
            r15 = r16
            boolean r1 = r1.zzaf(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x0346 }
        L_0x0307:
            if (r1 == 0) goto L_0x0332
            r1 = r23
            android.media.MediaCodec$BufferInfo r2 = r1.zzl     // Catch:{ IllegalStateException -> 0x036d }
            long r2 = r2.presentationTimeUs     // Catch:{ IllegalStateException -> 0x036d }
            r1.zzao(r2)     // Catch:{ IllegalStateException -> 0x036d }
            android.media.MediaCodec$BufferInfo r2 = r1.zzl     // Catch:{ IllegalStateException -> 0x036d }
            int r2 = r2.flags     // Catch:{ IllegalStateException -> 0x036d }
            r23.zzaz()     // Catch:{ IllegalStateException -> 0x036d }
            r2 = r2 & 4
            if (r2 == 0) goto L_0x0321
            r23.zzax()     // Catch:{ IllegalStateException -> 0x036d }
            goto L_0x02d6
        L_0x0321:
            r2 = r21
        L_0x0323:
            boolean r4 = r1.zzaF(r2)     // Catch:{ IllegalStateException -> 0x036d }
            if (r4 != 0) goto L_0x032a
            goto L_0x0335
        L_0x032a:
            r11 = r0
            r15 = r1
            r9 = r2
            r13 = r19
            r14 = 1
            goto L_0x0147
        L_0x0332:
            r1 = r23
            goto L_0x02d6
        L_0x0335:
            boolean r0 = r23.zzaC()     // Catch:{ IllegalStateException -> 0x036d }
            if (r0 == 0) goto L_0x0341
            boolean r0 = r1.zzaF(r2)     // Catch:{ IllegalStateException -> 0x036d }
            if (r0 != 0) goto L_0x0335
        L_0x0341:
            android.os.Trace.endSection()     // Catch:{ IllegalStateException -> 0x036d }
            r2 = 1
            goto L_0x0365
        L_0x0346:
            r0 = move-exception
            r1 = r23
            goto L_0x036e
        L_0x034a:
            r0 = move-exception
            r1 = r15
            goto L_0x036e
        L_0x034d:
            r0 = move-exception
            r19 = r13
            r1 = r15
            r2 = r14
            goto L_0x0375
        L_0x0353:
            r19 = r13
            r1 = r15
            com.google.android.gms.internal.ads.zzgs r0 = r1.zza     // Catch:{ IllegalStateException -> 0x036d }
            int r2 = r0.zzd     // Catch:{ IllegalStateException -> 0x036d }
            int r3 = r23.zzd(r24)     // Catch:{ IllegalStateException -> 0x036d }
            int r2 = r2 + r3
            r0.zzd = r2     // Catch:{ IllegalStateException -> 0x036d }
            r2 = 1
            r1.zzaE(r2)     // Catch:{ IllegalStateException -> 0x036b }
        L_0x0365:
            com.google.android.gms.internal.ads.zzgs r0 = r1.zza     // Catch:{ IllegalStateException -> 0x036b }
            r0.zza()     // Catch:{ IllegalStateException -> 0x036b }
            return
        L_0x036b:
            r0 = move-exception
            goto L_0x0375
        L_0x036d:
            r0 = move-exception
        L_0x036e:
            r2 = 1
            goto L_0x0375
        L_0x0370:
            r0 = move-exception
            r19 = r13
            r2 = r14
            r1 = r15
        L_0x0375:
            int r3 = com.google.android.gms.internal.ads.zzen.zza
            r4 = 21
            if (r3 < r4) goto L_0x0380
            boolean r3 = r0 instanceof android.media.MediaCodec.CodecException
            if (r3 == 0) goto L_0x0380
            goto L_0x0395
        L_0x0380:
            java.lang.StackTraceElement[] r3 = r0.getStackTrace()
            int r5 = r3.length
            if (r5 <= 0) goto L_0x03c0
            r3 = r3[r19]
            java.lang.String r3 = r3.getClassName()
            java.lang.String r5 = "android.media.MediaCodec"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x03c0
        L_0x0395:
            r1.zzX(r0)
            int r3 = com.google.android.gms.internal.ads.zzen.zza
            if (r3 < r4) goto L_0x03aa
            boolean r3 = r0 instanceof android.media.MediaCodec.CodecException
            if (r3 == 0) goto L_0x03aa
            r3 = r0
            android.media.MediaCodec$CodecException r3 = (android.media.MediaCodec.CodecException) r3
            boolean r3 = r3.isRecoverable()
            if (r3 == 0) goto L_0x03aa
            goto L_0x03ac
        L_0x03aa:
            r2 = r19
        L_0x03ac:
            if (r2 == 0) goto L_0x03b1
            r23.zzap()
        L_0x03b1:
            com.google.android.gms.internal.ads.zzqn r3 = r1.zzD
            com.google.android.gms.internal.ads.zzqm r0 = r1.zzak(r0, r3)
            com.google.android.gms.internal.ads.zzaf r3 = r1.zzp
            r4 = 4003(0xfa3, float:5.61E-42)
            com.google.android.gms.internal.ads.zzha r0 = r1.zzbg(r0, r3, r2, r4)
            throw r0
        L_0x03c0:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqq.zzL(long, long):void");
    }

    public boolean zzM() {
        return this.zzai;
    }

    public boolean zzN() {
        if (this.zzp == null) {
            return false;
        }
        if (zzI() || zzaD()) {
            return true;
        }
        return this.zzP != C.TIME_UNSET && SystemClock.elapsedRealtime() < this.zzP;
    }

    public final int zzO(zzaf zzaf2) throws zzha {
        try {
            return zzQ(this.zzd, zzaf2);
        } catch (zzqz e) {
            throw zzbg(e, zzaf2, false, 4002);
        }
    }

    /* access modifiers changed from: protected */
    public float zzP(float f, zzaf zzaf2, zzaf[] zzafArr) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public abstract int zzQ(zzqs zzqs, zzaf zzaf2) throws zzqz;

    /* access modifiers changed from: protected */
    public zzgt zzR(zzqn zzqn, zzaf zzaf2, zzaf zzaf3) {
        throw null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005e, code lost:
        if (zzaB() == false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x008b, code lost:
        if (zzaB() == false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x009d, code lost:
        if (zzaB() == false) goto L_0x0060;
     */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d1 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ads.zzgt zzS(com.google.android.gms.internal.ads.zzjg r13) throws com.google.android.gms.internal.ads.zzha {
        /*
            r12 = this;
            r0 = 1
            r12.zzaj = r0
            com.google.android.gms.internal.ads.zzaf r4 = r13.zza
            r1 = 0
            if (r4 == 0) goto L_0x0109
            java.lang.String r2 = r4.zzm
            r3 = 0
            if (r2 == 0) goto L_0x00fd
            com.google.android.gms.internal.ads.zzpr r13 = r13.zzb
            r12.zzao = r13
            r12.zzp = r4
            boolean r13 = r12.zzV
            if (r13 == 0) goto L_0x001a
            r12.zzX = r0
            return r1
        L_0x001a:
            com.google.android.gms.internal.ads.zzql r13 = r12.zzw
            if (r13 != 0) goto L_0x0024
            r12.zzB = r1
            r12.zzan()
            return r1
        L_0x0024:
            com.google.android.gms.internal.ads.zzqn r1 = r12.zzD
            com.google.android.gms.internal.ads.zzaf r5 = r12.zzx
            com.google.android.gms.internal.ads.zzpr r2 = r12.zzan
            com.google.android.gms.internal.ads.zzpr r6 = r12.zzao
            r7 = 23
            if (r2 != r6) goto L_0x00d2
            if (r6 == r2) goto L_0x0039
            int r8 = com.google.android.gms.internal.ads.zzen.zza
            if (r8 < r7) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r7 = r3
            goto L_0x003a
        L_0x0039:
            r7 = r0
        L_0x003a:
            com.google.android.gms.internal.ads.zzdd.zzf(r7)
            com.google.android.gms.internal.ads.zzgt r7 = r12.zzR(r1, r5, r4)
            int r8 = r7.zzd
            r9 = 3
            r10 = 16
            r11 = 2
            if (r8 == 0) goto L_0x00b5
            if (r8 == r0) goto L_0x008e
            if (r8 == r11) goto L_0x0062
            boolean r0 = r12.zzaG(r4)
            if (r0 != 0) goto L_0x0056
        L_0x0053:
            r6 = r10
            goto L_0x00b9
        L_0x0056:
            r12.zzx = r4
            if (r6 == r2) goto L_0x00b8
            boolean r0 = r12.zzaB()
            if (r0 != 0) goto L_0x00b8
        L_0x0060:
            r6 = r11
            goto L_0x00b9
        L_0x0062:
            boolean r8 = r12.zzaG(r4)
            if (r8 != 0) goto L_0x0069
            goto L_0x0053
        L_0x0069:
            r12.zzY = r0
            r12.zzZ = r0
            int r8 = r12.zzE
            if (r8 == r11) goto L_0x0081
            if (r8 != r0) goto L_0x0080
            int r8 = r4.zzr
            int r10 = r5.zzr
            if (r8 != r10) goto L_0x0080
            int r8 = r4.zzs
            int r10 = r5.zzs
            if (r8 != r10) goto L_0x0080
            goto L_0x0081
        L_0x0080:
            r0 = r3
        L_0x0081:
            r12.zzL = r0
            r12.zzx = r4
            if (r6 == r2) goto L_0x00b8
            boolean r0 = r12.zzaB()
            if (r0 != 0) goto L_0x00b8
            goto L_0x0060
        L_0x008e:
            boolean r8 = r12.zzaG(r4)
            if (r8 != 0) goto L_0x0095
            goto L_0x0053
        L_0x0095:
            r12.zzx = r4
            if (r6 == r2) goto L_0x00a0
            boolean r0 = r12.zzaB()
            if (r0 != 0) goto L_0x00b8
            goto L_0x0060
        L_0x00a0:
            boolean r2 = r12.zzac
            if (r2 == 0) goto L_0x00b8
            r12.zzaa = r0
            boolean r2 = r12.zzG
            if (r2 != 0) goto L_0x00b2
            boolean r2 = r12.zzI
            if (r2 == 0) goto L_0x00af
            goto L_0x00b2
        L_0x00af:
            r12.zzab = r0
            goto L_0x00b8
        L_0x00b2:
            r12.zzab = r9
            goto L_0x0060
        L_0x00b5:
            r12.zzU()
        L_0x00b8:
            r6 = r3
        L_0x00b9:
            int r0 = r7.zzd
            if (r0 == 0) goto L_0x00d1
            com.google.android.gms.internal.ads.zzql r0 = r12.zzw
            if (r0 != r13) goto L_0x00c5
            int r13 = r12.zzab
            if (r13 != r9) goto L_0x00d1
        L_0x00c5:
            com.google.android.gms.internal.ads.zzgt r13 = new com.google.android.gms.internal.ads.zzgt
            java.lang.String r2 = r1.zza
            r0 = 0
            r1 = r13
            r3 = r5
            r5 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            return r13
        L_0x00d1:
            return r7
        L_0x00d2:
            if (r6 == 0) goto L_0x00ec
            if (r2 != 0) goto L_0x00d7
            goto L_0x00ec
        L_0x00d7:
            int r13 = com.google.android.gms.internal.ads.zzen.zza
            if (r13 < r7) goto L_0x00ec
            java.util.UUID r13 = com.google.android.gms.internal.ads.zzo.zze
            java.util.UUID r0 = com.google.android.gms.internal.ads.zzo.zza
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00ec
            java.util.UUID r13 = com.google.android.gms.internal.ads.zzo.zze
            java.util.UUID r0 = com.google.android.gms.internal.ads.zzo.zza
            r13.equals(r0)
        L_0x00ec:
            r12.zzU()
            com.google.android.gms.internal.ads.zzgt r13 = new com.google.android.gms.internal.ads.zzgt
            java.lang.String r2 = r1.zza
            r0 = 0
            r6 = 128(0x80, float:1.794E-43)
            r1 = r13
            r3 = r5
            r5 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            return r13
        L_0x00fd:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            r13.<init>()
            r0 = 4005(0xfa5, float:5.612E-42)
            com.google.android.gms.internal.ads.zzha r13 = r12.zzbg(r13, r4, r3, r0)
            throw r13
        L_0x0109:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqq.zzS(com.google.android.gms.internal.ads.zzjg):com.google.android.gms.internal.ads.zzgt");
    }

    /* access modifiers changed from: protected */
    public abstract zzqj zzV(zzqn zzqn, zzaf zzaf2, MediaCrypto mediaCrypto, float f);

    /* access modifiers changed from: protected */
    public abstract List zzW(zzqs zzqs, zzaf zzaf2, boolean z) throws zzqz;

    /* access modifiers changed from: protected */
    public void zzX(Exception exc) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzY(String str, zzqj zzqj, long j, long j2) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzZ(String str) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzaa(zzaf zzaf2, MediaFormat mediaFormat) throws zzha {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzac() {
    }

    /* access modifiers changed from: protected */
    public void zzad(zzgi zzgi) throws zzha {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzae() throws zzha {
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzaf(long j, long j2, zzql zzql, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzaf zzaf2) throws zzha;

    /* access modifiers changed from: protected */
    public boolean zzag(zzaf zzaf2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public final float zzah() {
        return this.zzu;
    }

    /* access modifiers changed from: protected */
    public final long zzai() {
        return this.zzal;
    }

    /* access modifiers changed from: protected */
    public final zzql zzaj() {
        return this.zzw;
    }

    /* access modifiers changed from: protected */
    public zzqm zzak(Throwable th, zzqn zzqn) {
        return new zzqm(th, zzqn);
    }

    /* access modifiers changed from: protected */
    public final zzqn zzal() {
        return this.zzD;
    }

    /* access modifiers changed from: protected */
    public void zzam(zzgi zzgi) throws zzha {
    }

    /* access modifiers changed from: protected */
    public final void zzan() throws zzha {
        zzaf zzaf2;
        if (this.zzw == null && !this.zzV && (zzaf2 = this.zzp) != null) {
            if (this.zzao != null || !zzag(zzaf2)) {
                this.zzan = this.zzao;
                String str = this.zzp.zzm;
                if (this.zzan == null || !zzps.zza) {
                    try {
                        if (this.zzB == null) {
                            List zzW2 = zzW(this.zzd, this.zzp, false);
                            zzW2.isEmpty();
                            this.zzB = new ArrayDeque();
                            if (!zzW2.isEmpty()) {
                                this.zzB.add((zzqn) zzW2.get(0));
                            }
                            this.zzC = null;
                        }
                        if (!this.zzB.isEmpty()) {
                            zzqn zzqn = (zzqn) this.zzB.peekFirst();
                            while (this.zzw == null) {
                                zzqn zzqn2 = (zzqn) this.zzB.peekFirst();
                                if (zzau(zzqn2)) {
                                    try {
                                        zzaw(zzqn2, (MediaCrypto) null);
                                    } catch (Exception e) {
                                        if (zzqn2 == zzqn) {
                                            zzdw.zze("MediaCodecRenderer", "Preferred decoder instantiation failed. Sleeping for 50ms then retrying.");
                                            Thread.sleep(50);
                                            zzaw(zzqn2, (MediaCrypto) null);
                                        } else {
                                            throw e;
                                        }
                                    } catch (Exception e2) {
                                        zzdw.zzf("MediaCodecRenderer", "Failed to initialize decoder: ".concat(String.valueOf(String.valueOf(zzqn2))), e2);
                                        this.zzB.removeFirst();
                                        zzqp zzqp = new zzqp(this.zzp, (Throwable) e2, false, zzqn2);
                                        zzX(zzqp);
                                        zzqp zzqp2 = this.zzC;
                                        if (zzqp2 == null) {
                                            this.zzC = zzqp;
                                        } else {
                                            this.zzC = zzqp.zza(zzqp2, zzqp);
                                        }
                                        if (this.zzB.isEmpty()) {
                                            throw this.zzC;
                                        }
                                    }
                                } else {
                                    return;
                                }
                            }
                            this.zzB = null;
                            return;
                        }
                        throw new zzqp(this.zzp, (Throwable) null, false, -49999);
                    } catch (zzqz e3) {
                        throw new zzqp(this.zzp, (Throwable) e3, false, -49998);
                    } catch (zzqp e4) {
                        throw zzbg(e4, this.zzp, false, 4001);
                    }
                } else {
                    zzpi zza2 = this.zzan.zza();
                    throw zzbg(zza2, this.zzp, false, zza2.zza);
                }
            } else {
                zzaf zzaf3 = this.zzp;
                zzT();
                String str2 = zzaf3.zzm;
                if (MimeTypes.AUDIO_AAC.equals(str2) || MimeTypes.AUDIO_MPEG.equals(str2) || MimeTypes.AUDIO_OPUS.equals(str2)) {
                    this.zzi.zzn(32);
                } else {
                    this.zzi.zzn(1);
                }
                this.zzV = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzao(long j) {
        while (true) {
            int i = this.zzam;
            if (i != 0 && j >= this.zzo[0]) {
                long[] jArr = this.zzm;
                this.zzak = jArr[0];
                this.zzal = this.zzn[0];
                int i2 = i - 1;
                this.zzam = i2;
                System.arraycopy(jArr, 1, jArr, 0, i2);
                long[] jArr2 = this.zzn;
                System.arraycopy(jArr2, 1, jArr2, 0, this.zzam);
                long[] jArr3 = this.zzo;
                System.arraycopy(jArr3, 1, jArr3, 0, this.zzam);
                zzac();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzap() {
        try {
            zzql zzql = this.zzw;
            if (zzql != null) {
                zzql.zzl();
                this.zza.zzb++;
                zzZ(this.zzD.zza);
            }
        } finally {
            this.zzw = null;
            this.zzr = null;
            this.zzan = null;
            zzar();
        }
    }

    /* access modifiers changed from: protected */
    public void zzaq() {
        zzay();
        zzaz();
        this.zzP = C.TIME_UNSET;
        this.zzad = false;
        this.zzac = false;
        this.zzL = false;
        this.zzM = false;
        this.zzT = false;
        this.zzU = false;
        this.zzk.clear();
        this.zzaf = C.TIME_UNSET;
        this.zzag = C.TIME_UNSET;
        zzqg zzqg = this.zzO;
        if (zzqg != null) {
            zzqg.zzc();
        }
        this.zzaa = 0;
        this.zzab = 0;
        this.zzZ = this.zzY ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public final void zzar() {
        zzaq();
        this.zzO = null;
        this.zzB = null;
        this.zzD = null;
        this.zzx = null;
        this.zzy = null;
        this.zzz = false;
        this.zzae = false;
        this.zzA = -1.0f;
        this.zzE = 0;
        this.zzF = false;
        this.zzG = false;
        this.zzH = false;
        this.zzI = false;
        this.zzJ = false;
        this.zzK = false;
        this.zzN = false;
        this.zzY = false;
        this.zzZ = 0;
        this.zzs = false;
    }

    /* access modifiers changed from: protected */
    public final boolean zzas() throws zzha {
        boolean zzat = zzat();
        if (zzat) {
            zzan();
        }
        return zzat;
    }

    /* access modifiers changed from: protected */
    public final boolean zzat() {
        if (this.zzw == null) {
            return false;
        }
        int i = this.zzab;
        if (i == 3 || this.zzG || ((this.zzH && !this.zzae) || (this.zzI && this.zzad))) {
            zzap();
            return true;
        }
        if (i == 2) {
            zzdd.zzf(zzen.zza >= 23);
            if (zzen.zza >= 23) {
                try {
                    zzaA();
                } catch (zzha e) {
                    zzdw.zzf("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
                    zzap();
                    return true;
                }
            }
        }
        zzab();
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean zzau(zzqn zzqn) {
        return true;
    }

    public final int zze() {
        return 8;
    }

    /* access modifiers changed from: protected */
    public void zzs() {
        this.zzp = null;
        this.zzak = C.TIME_UNSET;
        this.zzal = C.TIME_UNSET;
        this.zzam = 0;
        zzat();
    }

    /* access modifiers changed from: protected */
    public void zzt(boolean z, boolean z2) throws zzha {
        this.zza = new zzgs();
    }

    /* access modifiers changed from: protected */
    public void zzu(long j, boolean z) throws zzha {
        this.zzah = false;
        this.zzai = false;
        if (this.zzV) {
            this.zzi.zzb();
            this.zzh.zzb();
            this.zzW = false;
        } else {
            zzas();
        }
        zzek zzek = this.zzj;
        if (zzek.zza() > 0) {
            this.zzaj = true;
        }
        zzek.zze();
        int i = this.zzam;
        if (i != 0) {
            int i2 = i - 1;
            this.zzal = this.zzn[i2];
            this.zzak = this.zzm[i2];
            this.zzam = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void zzv() {
        try {
            zzT();
            zzap();
        } finally {
            this.zzao = null;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzy(zzaf[] zzafArr, long j, long j2) throws zzha {
        boolean z = true;
        if (this.zzal == C.TIME_UNSET) {
            if (this.zzak != C.TIME_UNSET) {
                z = false;
            }
            zzdd.zzf(z);
            this.zzak = j;
            this.zzal = j2;
            return;
        }
        int i = this.zzam;
        if (i == 10) {
            zzdw.zze("MediaCodecRenderer", "Too many stream changes, so dropping offset: " + this.zzn[9]);
        } else {
            this.zzam = i + 1;
        }
        long[] jArr = this.zzm;
        int i2 = this.zzam - 1;
        jArr[i2] = j;
        this.zzn[i2] = j2;
        this.zzo[i2] = this.zzaf;
    }

    private final void zzax() throws zzha {
        int i = this.zzab;
        if (i == 1) {
            zzab();
        } else if (i == 2) {
            zzab();
            zzaA();
        } else if (i != 3) {
            this.zzai = true;
            zzae();
        } else {
            zzap();
            zzan();
        }
    }
}
