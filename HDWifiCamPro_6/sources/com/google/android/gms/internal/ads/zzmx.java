package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.util.Pair;
import com.facebook.ads.AdError;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.HashMap;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzmx implements zzkr, zzmy {
    private final Context zza;
    private final zzmz zzb = new zzmv(zzmv.zza);
    private final PlaybackSession zzc;
    private final long zzd = SystemClock.elapsedRealtime();
    private final zzcm zze = new zzcm();
    private final zzck zzf = new zzck();
    private final HashMap zzg = new HashMap();
    private final HashMap zzh = new HashMap();
    private String zzi;
    private PlaybackMetrics.Builder zzj;
    private int zzk;
    private int zzl = 0;
    private int zzm = 0;
    private zzbw zzn;
    private zzmw zzo;
    private zzmw zzp;
    private zzmw zzq;
    private zzaf zzr;
    private zzaf zzs;
    private zzaf zzt;
    private boolean zzu;
    private boolean zzv;
    private int zzw;
    private int zzx;
    private int zzy;
    private boolean zzz;

    private zzmx(Context context, PlaybackSession playbackSession) {
        this.zza = context.getApplicationContext();
        this.zzc = playbackSession;
        this.zzb.zzg(this);
    }

    public static zzmx zzb(Context context) {
        MediaMetricsManager mediaMetricsManager = (MediaMetricsManager) context.getSystemService("media_metrics");
        if (mediaMetricsManager == null) {
            return null;
        }
        return new zzmx(context, mediaMetricsManager.createPlaybackSession());
    }

    private static int zzr(int i) {
        switch (zzen.zzl(i)) {
            case AdError.ICONVIEW_MISSING_ERROR_CODE:
                return 24;
            case AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    private final void zzs() {
        long j;
        long j2;
        PlaybackMetrics.Builder builder = this.zzj;
        if (builder != null && this.zzz) {
            builder.setAudioUnderrunCount(this.zzy);
            this.zzj.setVideoFramesDropped(this.zzw);
            this.zzj.setVideoFramesPlayed(this.zzx);
            Long l = (Long) this.zzg.get(this.zzi);
            PlaybackMetrics.Builder builder2 = this.zzj;
            if (l == null) {
                j = 0;
            } else {
                j = l.longValue();
            }
            builder2.setNetworkTransferDurationMillis(j);
            Long l2 = (Long) this.zzh.get(this.zzi);
            PlaybackMetrics.Builder builder3 = this.zzj;
            if (l2 == null) {
                j2 = 0;
            } else {
                j2 = l2.longValue();
            }
            builder3.setNetworkBytesRead(j2);
            this.zzj.setStreamSource((l2 == null || l2.longValue() <= 0) ? 0 : 1);
            this.zzc.reportPlaybackMetrics(this.zzj.build());
        }
        this.zzj = null;
        this.zzi = null;
        this.zzy = 0;
        this.zzw = 0;
        this.zzx = 0;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzz = false;
    }

    private final void zzt(long j, zzaf zzaf, int i) {
        if (!zzen.zzT(this.zzs, zzaf)) {
            int i2 = this.zzs == null ? 1 : 0;
            this.zzs = zzaf;
            zzx(0, j, zzaf, i2);
        }
    }

    private final void zzu(long j, zzaf zzaf, int i) {
        if (!zzen.zzT(this.zzt, zzaf)) {
            int i2 = this.zzt == null ? 1 : 0;
            this.zzt = zzaf;
            zzx(2, j, zzaf, i2);
        }
    }

    @RequiresNonNull({"metricsBuilder"})
    private final void zzv(zzcn zzcn, zzsi zzsi) {
        int zza2;
        PlaybackMetrics.Builder builder = this.zzj;
        if (zzsi != null && (zza2 = zzcn.zza(zzsi.zza)) != -1) {
            int i = 0;
            zzcn.zzd(zza2, this.zzf, false);
            zzcn.zze(this.zzf.zzd, this.zze, 0);
            zzay zzay = this.zze.zzd.zzd;
            int i2 = 2;
            if (zzay != null) {
                int zzp2 = zzen.zzp(zzay.zza);
                i = zzp2 != 0 ? zzp2 != 1 ? zzp2 != 2 ? 1 : 4 : 5 : 3;
            }
            builder.setStreamType(i);
            zzcm zzcm = this.zze;
            if (zzcm.zzn != C.TIME_UNSET && !zzcm.zzl && !zzcm.zzi && !zzcm.zzb()) {
                builder.setMediaDurationMillis(zzen.zzz(this.zze.zzn));
            }
            if (true != this.zze.zzb()) {
                i2 = 1;
            }
            builder.setPlaybackType(i2);
            this.zzz = true;
        }
    }

    private final void zzw(long j, zzaf zzaf, int i) {
        if (!zzen.zzT(this.zzr, zzaf)) {
            int i2 = this.zzr == null ? 1 : 0;
            this.zzr = zzaf;
            zzx(1, j, zzaf, i2);
        }
    }

    private final void zzx(int i, long j, zzaf zzaf, int i2) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = new TrackChangeEvent.Builder(i).setTimeSinceCreatedMillis(j - this.zzd);
        if (zzaf != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(i2 != 1 ? 1 : 2);
            String str = zzaf.zzl;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = zzaf.zzm;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = zzaf.zzj;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i3 = zzaf.zzi;
            if (i3 != -1) {
                timeSinceCreatedMillis.setBitrate(i3);
            }
            int i4 = zzaf.zzr;
            if (i4 != -1) {
                timeSinceCreatedMillis.setWidth(i4);
            }
            int i5 = zzaf.zzs;
            if (i5 != -1) {
                timeSinceCreatedMillis.setHeight(i5);
            }
            int i6 = zzaf.zzz;
            if (i6 != -1) {
                timeSinceCreatedMillis.setChannelCount(i6);
            }
            int i7 = zzaf.zzA;
            if (i7 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i7);
            }
            String str4 = zzaf.zzd;
            if (str4 != null) {
                String[] zzag = zzen.zzag(str4, "-");
                Pair create = Pair.create(zzag[0], zzag.length >= 2 ? zzag[1] : null);
                timeSinceCreatedMillis.setLanguage((String) create.first);
                if (create.second != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) create.second);
                }
            }
            float f = zzaf.zzt;
            if (f != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.zzz = true;
        this.zzc.reportTrackChangeEvent(timeSinceCreatedMillis.build());
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = true)
    private final boolean zzy(zzmw zzmw) {
        return zzmw != null && zzmw.zzc.equals(this.zzb.zzd());
    }

    public final LogSessionId zza() {
        return this.zzc.getSessionId();
    }

    public final void zzc(zzkp zzkp, String str) {
        zzsi zzsi = zzkp.zzd;
        if (zzsi == null || !zzsi.zzb()) {
            zzs();
            this.zzi = str;
            this.zzj = new PlaybackMetrics.Builder().setPlayerName("AndroidXMedia3").setPlayerVersion("1.0.0-beta02");
            zzv(zzkp.zzb, zzkp.zzd);
        }
    }

    public final void zzd(zzkp zzkp, String str, boolean z) {
        zzsi zzsi = zzkp.zzd;
        if ((zzsi == null || !zzsi.zzb()) && str.equals(this.zzi)) {
            zzs();
        }
        this.zzg.remove(str);
        this.zzh.remove(str);
    }

    public final /* synthetic */ void zze(zzkp zzkp, zzaf zzaf, zzgt zzgt) {
    }

    public final void zzf(zzkp zzkp, int i, long j, long j2) {
        long j3;
        zzsi zzsi = zzkp.zzd;
        if (zzsi != null) {
            String zze2 = this.zzb.zze(zzkp.zzb, zzsi);
            Long l = (Long) this.zzh.get(zze2);
            Long l2 = (Long) this.zzg.get(zze2);
            HashMap hashMap = this.zzh;
            long j4 = 0;
            if (l == null) {
                j3 = 0;
            } else {
                j3 = l.longValue();
            }
            hashMap.put(zze2, Long.valueOf(j3 + j));
            HashMap hashMap2 = this.zzg;
            if (l2 != null) {
                j4 = l2.longValue();
            }
            hashMap2.put(zze2, Long.valueOf(j4 + ((long) i)));
        }
    }

    public final void zzg(zzkp zzkp, zzse zzse) {
        zzsi zzsi = zzkp.zzd;
        if (zzsi != null) {
            zzaf zzaf = zzse.zzb;
            if (zzaf != null) {
                zzmw zzmw = new zzmw(zzaf, 0, this.zzb.zze(zzkp.zzb, zzsi));
                int i = zzse.zza;
                if (i != 0) {
                    if (i == 1) {
                        this.zzp = zzmw;
                        return;
                    } else if (i != 2) {
                        if (i == 3) {
                            this.zzq = zzmw;
                            return;
                        }
                        return;
                    }
                }
                this.zzo = zzmw;
                return;
            }
            throw null;
        }
    }

    public final /* synthetic */ void zzh(zzkp zzkp, int i, long j) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:187:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x02e4  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x02e6  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x02e8  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x02ed  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x02ef  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x02f1  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x02f5  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x02f8  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x02fd  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x031f  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0323  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x032e  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0331  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0343  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x0345  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0393  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x03ba  */
    /* JADX WARNING: Removed duplicated region for block: B:271:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(com.google.android.gms.internal.ads.zzcg r19, com.google.android.gms.internal.ads.zzkq r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            int r2 = r20.zzb()
            if (r2 == 0) goto L_0x03c7
            r2 = 0
            r3 = r2
        L_0x000c:
            int r4 = r20.zzb()
            r5 = 11
            if (r3 >= r4) goto L_0x0036
            int r4 = r1.zza(r3)
            com.google.android.gms.internal.ads.zzkp r6 = r1.zzc(r4)
            if (r4 != 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzmz r4 = r0.zzb
            r4.zzj(r6)
            goto L_0x0033
        L_0x0024:
            if (r4 != r5) goto L_0x002e
            com.google.android.gms.internal.ads.zzmz r4 = r0.zzb
            int r5 = r0.zzk
            r4.zzi(r6, r5)
            goto L_0x0033
        L_0x002e:
            com.google.android.gms.internal.ads.zzmz r4 = r0.zzb
            r4.zzh(r6)
        L_0x0033:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x0036:
            long r3 = android.os.SystemClock.elapsedRealtime()
            boolean r6 = r1.zzd(r2)
            if (r6 == 0) goto L_0x004f
            com.google.android.gms.internal.ads.zzkp r6 = r1.zzc(r2)
            android.media.metrics.PlaybackMetrics$Builder r7 = r0.zzj
            if (r7 == 0) goto L_0x004f
            com.google.android.gms.internal.ads.zzcn r7 = r6.zzb
            com.google.android.gms.internal.ads.zzsi r6 = r6.zzd
            r0.zzv(r7, r6)
        L_0x004f:
            r6 = 2
            boolean r7 = r1.zzd(r6)
            r9 = 3
            r10 = 0
            r11 = 1
            if (r7 == 0) goto L_0x00c6
            android.media.metrics.PlaybackMetrics$Builder r7 = r0.zzj
            if (r7 == 0) goto L_0x00c6
            com.google.android.gms.internal.ads.zzcy r7 = r19.zzo()
            com.google.android.gms.internal.ads.zzfvn r7 = r7.zza()
            int r12 = r7.size()
            r13 = r2
        L_0x006a:
            if (r13 >= r12) goto L_0x008f
            java.lang.Object r14 = r7.get(r13)
            com.google.android.gms.internal.ads.zzcx r14 = (com.google.android.gms.internal.ads.zzcx) r14
            r15 = r2
        L_0x0073:
            int r5 = r14.zzb
            int r5 = r13 + 1
            if (r15 > 0) goto L_0x008b
            boolean r5 = r14.zzd(r15)
            if (r5 == 0) goto L_0x0088
            com.google.android.gms.internal.ads.zzaf r5 = r14.zzb(r15)
            com.google.android.gms.internal.ads.zzx r5 = r5.zzp
            if (r5 == 0) goto L_0x0088
            goto L_0x0090
        L_0x0088:
            int r15 = r15 + 1
            goto L_0x0073
        L_0x008b:
            r13 = r5
            r5 = 11
            goto L_0x006a
        L_0x008f:
            r5 = r10
        L_0x0090:
            if (r5 == 0) goto L_0x00c6
            android.media.metrics.PlaybackMetrics$Builder r7 = r0.zzj
            int r12 = com.google.android.gms.internal.ads.zzen.zza
            r12 = r2
        L_0x0097:
            int r13 = r5.zzb
            if (r12 >= r13) goto L_0x00c2
            com.google.android.gms.internal.ads.zzw r13 = r5.zza(r12)
            java.util.UUID r13 = r13.zza
            java.util.UUID r14 = com.google.android.gms.internal.ads.zzo.zzd
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00ab
            r5 = r9
            goto L_0x00c3
        L_0x00ab:
            java.util.UUID r14 = com.google.android.gms.internal.ads.zzo.zze
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00b5
            r5 = r6
            goto L_0x00c3
        L_0x00b5:
            java.util.UUID r14 = com.google.android.gms.internal.ads.zzo.zzc
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x00bf
            r5 = 6
            goto L_0x00c3
        L_0x00bf:
            int r12 = r12 + 1
            goto L_0x0097
        L_0x00c2:
            r5 = r11
        L_0x00c3:
            r7.setDrmType(r5)
        L_0x00c6:
            r5 = 1011(0x3f3, float:1.417E-42)
            boolean r5 = r1.zzd(r5)
            if (r5 == 0) goto L_0x00d3
            int r5 = r0.zzy
            int r5 = r5 + r11
            r0.zzy = r5
        L_0x00d3:
            com.google.android.gms.internal.ads.zzbw r5 = r0.zzn
            if (r5 != 0) goto L_0x00d9
            goto L_0x0267
        L_0x00d9:
            android.content.Context r7 = r0.zza
            int r8 = r5.zzb
            r12 = 1001(0x3e9, float:1.403E-42)
            r16 = 31
            r13 = 21
            r15 = 23
            if (r8 != r12) goto L_0x00f0
            r7 = 20
        L_0x00e9:
            r17 = r7
            r7 = r2
            r2 = r17
            goto L_0x0241
        L_0x00f0:
            r8 = r5
            com.google.android.gms.internal.ads.zzha r8 = (com.google.android.gms.internal.ads.zzha) r8
            int r12 = r8.zze
            int r8 = r8.zzi
            java.lang.Throwable r14 = r5.getCause()
            if (r14 == 0) goto L_0x03c6
            boolean r2 = r14 instanceof java.io.IOException
            if (r2 == 0) goto L_0x01d6
            boolean r2 = r14 instanceof com.google.android.gms.internal.ads.zzfs
            if (r2 == 0) goto L_0x010d
            com.google.android.gms.internal.ads.zzfs r14 = (com.google.android.gms.internal.ads.zzfs) r14
            int r2 = r14.zzd
            r7 = r2
            r2 = 5
            goto L_0x0241
        L_0x010d:
            boolean r2 = r14 instanceof com.google.android.gms.internal.ads.zzfr
            if (r2 != 0) goto L_0x01d3
            boolean r2 = r14 instanceof com.google.android.gms.internal.ads.zzbu
            if (r2 == 0) goto L_0x0117
            goto L_0x01d3
        L_0x0117:
            boolean r2 = r14 instanceof com.google.android.gms.internal.ads.zzfq
            if (r2 != 0) goto L_0x01aa
            boolean r8 = r14 instanceof com.google.android.gms.internal.ads.zzga
            if (r8 == 0) goto L_0x0121
            goto L_0x01aa
        L_0x0121:
            int r2 = r5.zzb
            r7 = 1002(0x3ea, float:1.404E-42)
            if (r2 != r7) goto L_0x012a
            r2 = r13
            goto L_0x01de
        L_0x012a:
            boolean r2 = r14 instanceof com.google.android.gms.internal.ads.zzpi
            if (r2 == 0) goto L_0x017a
            java.lang.Throwable r2 = r14.getCause()
            if (r2 == 0) goto L_0x0179
            int r7 = com.google.android.gms.internal.ads.zzen.zza
            if (r7 < r13) goto L_0x014b
            boolean r7 = r2 instanceof android.media.MediaDrm.MediaDrmStateException
            if (r7 == 0) goto L_0x014b
            android.media.MediaDrm$MediaDrmStateException r2 = (android.media.MediaDrm.MediaDrmStateException) r2
            java.lang.String r2 = r2.getDiagnosticInfo()
            int r2 = com.google.android.gms.internal.ads.zzen.zzm(r2)
            int r7 = zzr(r2)
            goto L_0x00e9
        L_0x014b:
            int r7 = com.google.android.gms.internal.ads.zzen.zza
            if (r7 < r15) goto L_0x0157
            boolean r7 = r2 instanceof android.media.MediaDrmResetException
            if (r7 == 0) goto L_0x0157
            r2 = 27
            goto L_0x01de
        L_0x0157:
            boolean r7 = r2 instanceof android.media.NotProvisionedException
            if (r7 == 0) goto L_0x015f
            r2 = 24
            goto L_0x01de
        L_0x015f:
            boolean r7 = r2 instanceof android.media.DeniedByServerException
            if (r7 == 0) goto L_0x0167
            r2 = 29
            goto L_0x01de
        L_0x0167:
            boolean r7 = r2 instanceof com.google.android.gms.internal.ads.zzpt
            if (r7 == 0) goto L_0x016d
            goto L_0x01eb
        L_0x016d:
            boolean r2 = r2 instanceof com.google.android.gms.internal.ads.zzpg
            if (r2 == 0) goto L_0x0175
            r2 = 28
            goto L_0x01de
        L_0x0175:
            r2 = 30
            goto L_0x01de
        L_0x0179:
            throw r10
        L_0x017a:
            boolean r2 = r14 instanceof com.google.android.gms.internal.ads.zzfm
            if (r2 == 0) goto L_0x01a7
            java.lang.Throwable r2 = r14.getCause()
            boolean r2 = r2 instanceof java.io.FileNotFoundException
            if (r2 == 0) goto L_0x01a7
            java.lang.Throwable r2 = r14.getCause()
            if (r2 == 0) goto L_0x01a6
            java.lang.Throwable r2 = r2.getCause()
            int r7 = com.google.android.gms.internal.ads.zzen.zza
            if (r7 < r13) goto L_0x01a3
            boolean r7 = r2 instanceof android.system.ErrnoException
            if (r7 == 0) goto L_0x01a3
            android.system.ErrnoException r2 = (android.system.ErrnoException) r2
            int r2 = r2.errno
            int r7 = android.system.OsConstants.EACCES
            if (r2 != r7) goto L_0x01a3
            r2 = 32
            goto L_0x01de
        L_0x01a3:
            r2 = r16
            goto L_0x01de
        L_0x01a6:
            throw r10
        L_0x01a7:
            r2 = 9
            goto L_0x01de
        L_0x01aa:
            com.google.android.gms.internal.ads.zzed r7 = com.google.android.gms.internal.ads.zzed.zzb(r7)
            int r7 = r7.zza()
            if (r7 != r11) goto L_0x01b6
            r2 = r9
            goto L_0x01de
        L_0x01b6:
            java.lang.Throwable r7 = r14.getCause()
            boolean r8 = r7 instanceof java.net.UnknownHostException
            if (r8 == 0) goto L_0x01c0
            r2 = 6
            goto L_0x01de
        L_0x01c0:
            boolean r7 = r7 instanceof java.net.SocketTimeoutException
            if (r7 == 0) goto L_0x01c6
            r2 = 7
            goto L_0x01de
        L_0x01c6:
            if (r2 == 0) goto L_0x01d0
            com.google.android.gms.internal.ads.zzfq r14 = (com.google.android.gms.internal.ads.zzfq) r14
            int r2 = r14.zzc
            if (r2 != r11) goto L_0x01d0
            r2 = 4
            goto L_0x01de
        L_0x01d0:
            r2 = 8
            goto L_0x01de
        L_0x01d3:
            r2 = 11
            goto L_0x01de
        L_0x01d6:
            if (r12 != r11) goto L_0x01e0
            if (r8 == 0) goto L_0x01dc
            if (r8 != r11) goto L_0x01e0
        L_0x01dc:
            r2 = 35
        L_0x01de:
            r7 = 0
            goto L_0x0241
        L_0x01e0:
            if (r12 != r11) goto L_0x01e7
            if (r8 != r9) goto L_0x01e7
            r2 = 15
            goto L_0x01de
        L_0x01e7:
            if (r12 != r11) goto L_0x01ed
            if (r8 != r6) goto L_0x01ed
        L_0x01eb:
            r2 = r15
            goto L_0x01de
        L_0x01ed:
            boolean r2 = r14 instanceof com.google.android.gms.internal.ads.zzqp
            if (r2 == 0) goto L_0x01fd
            com.google.android.gms.internal.ads.zzqp r14 = (com.google.android.gms.internal.ads.zzqp) r14
            java.lang.String r2 = r14.zzd
            int r2 = com.google.android.gms.internal.ads.zzen.zzm(r2)
            r7 = 13
            goto L_0x00e9
        L_0x01fd:
            boolean r2 = r14 instanceof com.google.android.gms.internal.ads.zzqm
            if (r2 == 0) goto L_0x020d
            com.google.android.gms.internal.ads.zzqm r14 = (com.google.android.gms.internal.ads.zzqm) r14
            java.lang.String r2 = r14.zzb
            int r2 = com.google.android.gms.internal.ads.zzen.zzm(r2)
            r7 = 14
            goto L_0x00e9
        L_0x020d:
            boolean r2 = r14 instanceof java.lang.OutOfMemoryError
            if (r2 == 0) goto L_0x0214
            r2 = 14
            goto L_0x01de
        L_0x0214:
            boolean r2 = r14 instanceof com.google.android.gms.internal.ads.zznu
            if (r2 == 0) goto L_0x0220
            com.google.android.gms.internal.ads.zznu r14 = (com.google.android.gms.internal.ads.zznu) r14
            int r2 = r14.zza
            r7 = 17
            goto L_0x00e9
        L_0x0220:
            boolean r2 = r14 instanceof com.google.android.gms.internal.ads.zznx
            if (r2 == 0) goto L_0x022c
            com.google.android.gms.internal.ads.zznx r14 = (com.google.android.gms.internal.ads.zznx) r14
            int r2 = r14.zza
            r7 = 18
            goto L_0x00e9
        L_0x022c:
            int r2 = com.google.android.gms.internal.ads.zzen.zza
            boolean r2 = r14 instanceof android.media.MediaCodec.CryptoException
            if (r2 == 0) goto L_0x023e
            android.media.MediaCodec$CryptoException r14 = (android.media.MediaCodec.CryptoException) r14
            int r2 = r14.getErrorCode()
            int r7 = zzr(r2)
            goto L_0x00e9
        L_0x023e:
            r2 = 22
            goto L_0x01de
        L_0x0241:
            android.media.metrics.PlaybackSession r8 = r0.zzc
            android.media.metrics.PlaybackErrorEvent$Builder r12 = new android.media.metrics.PlaybackErrorEvent$Builder
            r12.<init>()
            long r13 = r0.zzd
            long r13 = r3 - r13
            android.media.metrics.PlaybackErrorEvent$Builder r12 = r12.setTimeSinceCreatedMillis(r13)
            android.media.metrics.PlaybackErrorEvent$Builder r2 = r12.setErrorCode(r2)
            android.media.metrics.PlaybackErrorEvent$Builder r2 = r2.setSubErrorCode(r7)
            android.media.metrics.PlaybackErrorEvent$Builder r2 = r2.setException(r5)
            android.media.metrics.PlaybackErrorEvent r2 = r2.build()
            r8.reportPlaybackErrorEvent(r2)
            r0.zzz = r11
            r0.zzn = r10
        L_0x0267:
            boolean r2 = r1.zzd(r6)
            if (r2 == 0) goto L_0x0296
            com.google.android.gms.internal.ads.zzcy r2 = r19.zzo()
            boolean r5 = r2.zzb(r6)
            boolean r7 = r2.zzb(r11)
            boolean r2 = r2.zzb(r9)
            if (r5 != 0) goto L_0x0284
            if (r7 != 0) goto L_0x0284
            if (r2 == 0) goto L_0x0296
            r2 = r11
        L_0x0284:
            if (r5 != 0) goto L_0x028b
            r5 = 0
            r0.zzw(r3, r10, r5)
            goto L_0x028c
        L_0x028b:
            r5 = 0
        L_0x028c:
            if (r7 != 0) goto L_0x0291
            r0.zzt(r3, r10, r5)
        L_0x0291:
            if (r2 != 0) goto L_0x0296
            r0.zzu(r3, r10, r5)
        L_0x0296:
            com.google.android.gms.internal.ads.zzmw r2 = r0.zzo
            boolean r2 = r0.zzy(r2)
            if (r2 == 0) goto L_0x02b0
            com.google.android.gms.internal.ads.zzmw r2 = r0.zzo
            com.google.android.gms.internal.ads.zzaf r5 = r2.zza
            int r7 = r5.zzs
            r8 = -1
            if (r7 == r8) goto L_0x02b0
            int r2 = r2.zzb
            r7 = 0
            r0.zzw(r3, r5, r7)
            r0.zzo = r10
            goto L_0x02b1
        L_0x02b0:
            r7 = 0
        L_0x02b1:
            com.google.android.gms.internal.ads.zzmw r2 = r0.zzp
            boolean r2 = r0.zzy(r2)
            if (r2 == 0) goto L_0x02c4
            com.google.android.gms.internal.ads.zzmw r2 = r0.zzp
            com.google.android.gms.internal.ads.zzaf r5 = r2.zza
            int r2 = r2.zzb
            r0.zzt(r3, r5, r7)
            r0.zzp = r10
        L_0x02c4:
            com.google.android.gms.internal.ads.zzmw r2 = r0.zzq
            boolean r2 = r0.zzy(r2)
            if (r2 == 0) goto L_0x02d7
            com.google.android.gms.internal.ads.zzmw r2 = r0.zzq
            com.google.android.gms.internal.ads.zzaf r5 = r2.zza
            int r2 = r2.zzb
            r0.zzu(r3, r5, r7)
            r0.zzq = r10
        L_0x02d7:
            android.content.Context r2 = r0.zza
            com.google.android.gms.internal.ads.zzed r2 = com.google.android.gms.internal.ads.zzed.zzb(r2)
            int r2 = r2.zza()
            switch(r2) {
                case 0: goto L_0x02f8;
                case 1: goto L_0x02f5;
                case 2: goto L_0x02f3;
                case 3: goto L_0x02f1;
                case 4: goto L_0x02ef;
                case 5: goto L_0x02ed;
                case 6: goto L_0x02e4;
                case 7: goto L_0x02eb;
                case 8: goto L_0x02e4;
                case 9: goto L_0x02e8;
                case 10: goto L_0x02e6;
                default: goto L_0x02e4;
            }
        L_0x02e4:
            r2 = r11
            goto L_0x02f9
        L_0x02e6:
            r2 = 7
            goto L_0x02f9
        L_0x02e8:
            r2 = 8
            goto L_0x02f9
        L_0x02eb:
            r2 = r9
            goto L_0x02f9
        L_0x02ed:
            r2 = 6
            goto L_0x02f9
        L_0x02ef:
            r2 = 5
            goto L_0x02f9
        L_0x02f1:
            r2 = 4
            goto L_0x02f9
        L_0x02f3:
            r2 = r6
            goto L_0x02f9
        L_0x02f5:
            r2 = 9
            goto L_0x02f9
        L_0x02f8:
            r2 = 0
        L_0x02f9:
            int r5 = r0.zzm
            if (r2 == r5) goto L_0x0319
            r0.zzm = r2
            android.media.metrics.PlaybackSession r5 = r0.zzc
            android.media.metrics.NetworkEvent$Builder r7 = new android.media.metrics.NetworkEvent$Builder
            r7.<init>()
            android.media.metrics.NetworkEvent$Builder r2 = r7.setNetworkType(r2)
            long r7 = r0.zzd
            long r7 = r3 - r7
            android.media.metrics.NetworkEvent$Builder r2 = r2.setTimeSinceCreatedMillis(r7)
            android.media.metrics.NetworkEvent r2 = r2.build()
            r5.reportNetworkEvent(r2)
        L_0x0319:
            int r2 = r19.zzh()
            if (r2 == r6) goto L_0x0323
            r2 = 0
            r0.zzu = r2
            goto L_0x0324
        L_0x0323:
            r2 = 0
        L_0x0324:
            r5 = r19
            com.google.android.gms.internal.ads.zzkf r5 = (com.google.android.gms.internal.ads.zzkf) r5
            com.google.android.gms.internal.ads.zzha r5 = r5.zzw()
            if (r5 != 0) goto L_0x0331
            r0.zzv = r2
            goto L_0x033b
        L_0x0331:
            r2 = 10
            boolean r2 = r1.zzd(r2)
            if (r2 == 0) goto L_0x033b
            r0.zzv = r11
        L_0x033b:
            int r2 = r19.zzh()
            boolean r5 = r0.zzu
            if (r5 == 0) goto L_0x0345
            r5 = 5
            goto L_0x038f
        L_0x0345:
            boolean r5 = r0.zzv
            if (r5 == 0) goto L_0x034c
            r5 = 13
            goto L_0x038f
        L_0x034c:
            r5 = 4
            if (r2 != r5) goto L_0x0352
            r5 = 11
            goto L_0x038f
        L_0x0352:
            if (r2 != r6) goto L_0x0370
            int r2 = r0.zzl
            if (r2 == 0) goto L_0x036e
            if (r2 != r6) goto L_0x035b
            goto L_0x036e
        L_0x035b:
            boolean r2 = r19.zzq()
            if (r2 != 0) goto L_0x0363
            r5 = 7
            goto L_0x038f
        L_0x0363:
            int r2 = r19.zzi()
            if (r2 == 0) goto L_0x036c
            r5 = 10
            goto L_0x038f
        L_0x036c:
            r5 = 6
            goto L_0x038f
        L_0x036e:
            r5 = r6
            goto L_0x038f
        L_0x0370:
            if (r2 != r9) goto L_0x0384
            boolean r2 = r19.zzq()
            if (r2 != 0) goto L_0x0379
            goto L_0x038f
        L_0x0379:
            int r2 = r19.zzi()
            if (r2 == 0) goto L_0x0382
            r5 = 9
            goto L_0x038f
        L_0x0382:
            r5 = r9
            goto L_0x038f
        L_0x0384:
            if (r2 != r11) goto L_0x038d
            int r2 = r0.zzl
            if (r2 == 0) goto L_0x038d
            r5 = 12
            goto L_0x038f
        L_0x038d:
            int r5 = r0.zzl
        L_0x038f:
            int r2 = r0.zzl
            if (r2 == r5) goto L_0x03b2
            r0.zzl = r5
            r0.zzz = r11
            android.media.metrics.PlaybackSession r2 = r0.zzc
            android.media.metrics.PlaybackStateEvent$Builder r5 = new android.media.metrics.PlaybackStateEvent$Builder
            r5.<init>()
            int r6 = r0.zzl
            android.media.metrics.PlaybackStateEvent$Builder r5 = r5.setState(r6)
            long r6 = r0.zzd
            long r3 = r3 - r6
            android.media.metrics.PlaybackStateEvent$Builder r3 = r5.setTimeSinceCreatedMillis(r3)
            android.media.metrics.PlaybackStateEvent r3 = r3.build()
            r2.reportPlaybackStateEvent(r3)
        L_0x03b2:
            r2 = 1028(0x404, float:1.44E-42)
            boolean r2 = r1.zzd(r2)
            if (r2 == 0) goto L_0x03c5
            com.google.android.gms.internal.ads.zzmz r2 = r0.zzb
            r3 = 1028(0x404, float:1.44E-42)
            com.google.android.gms.internal.ads.zzkp r1 = r1.zzc(r3)
            r2.zzf(r1)
        L_0x03c5:
            return
        L_0x03c6:
            throw r10
        L_0x03c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmx.zzi(com.google.android.gms.internal.ads.zzcg, com.google.android.gms.internal.ads.zzkq):void");
    }

    public final void zzj(zzkp zzkp, zzrz zzrz, zzse zzse, IOException iOException, boolean z) {
    }

    public final /* synthetic */ void zzk(zzkp zzkp, int i) {
    }

    public final void zzl(zzkp zzkp, zzbw zzbw) {
        this.zzn = zzbw;
    }

    public final void zzm(zzkp zzkp, zzcf zzcf, zzcf zzcf2, int i) {
        int i2 = 1;
        if (i == 1) {
            this.zzu = true;
        } else {
            i2 = i;
        }
        this.zzk = i2;
    }

    public final /* synthetic */ void zzn(zzkp zzkp, Object obj, long j) {
    }

    public final void zzo(zzkp zzkp, zzgs zzgs) {
        this.zzw += zzgs.zzg;
        this.zzx += zzgs.zze;
    }

    public final /* synthetic */ void zzp(zzkp zzkp, zzaf zzaf, zzgt zzgt) {
    }

    public final void zzq(zzkp zzkp, zzda zzda) {
        zzmw zzmw = this.zzo;
        if (zzmw != null) {
            zzaf zzaf = zzmw.zza;
            if (zzaf.zzs == -1) {
                zzad zzb2 = zzaf.zzb();
                zzb2.zzX(zzda.zzc);
                zzb2.zzF(zzda.zzd);
                this.zzo = new zzmw(zzb2.zzY(), 0, zzmw.zzc);
            }
        }
    }
}
