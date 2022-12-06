package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.SparseIntArray;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaxe {
    private static final zzaws zza = zzaws.zzb("OMX.google.raw.decoder");
    private static final Pattern zzb = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap zzc = new HashMap();
    private static final SparseIntArray zzd = new SparseIntArray();
    private static final SparseIntArray zze = new SparseIntArray();
    private static final Map zzf = new HashMap();
    private static int zzg = -1;

    static {
        zzd.put(66, 1);
        zzd.put(77, 2);
        zzd.put(88, 4);
        zzd.put(100, 8);
        zze.put(10, 1);
        zze.put(11, 4);
        zze.put(12, 8);
        zze.put(13, 16);
        zze.put(20, 32);
        zze.put(21, 64);
        zze.put(22, 128);
        zze.put(30, 256);
        zze.put(31, 512);
        zze.put(32, 1024);
        zze.put(40, 2048);
        zze.put(41, 4096);
        zze.put(42, 8192);
        zze.put(50, 16384);
        zze.put(51, 32768);
        zze.put(52, 65536);
        zzf.put("L30", 1);
        zzf.put("L60", 4);
        zzf.put("L63", 16);
        zzf.put("L90", 64);
        zzf.put("L93", 256);
        zzf.put("L120", 1024);
        zzf.put("L123", 4096);
        zzf.put("L150", 16384);
        zzf.put("L153", 65536);
        zzf.put("L156", 262144);
        zzf.put("L180", 1048576);
        zzf.put("L183", 4194304);
        zzf.put("L186", 16777216);
        zzf.put("H30", 2);
        zzf.put("H60", 8);
        zzf.put("H63", 32);
        zzf.put("H90", 128);
        zzf.put("H93", 512);
        zzf.put("H120", 2048);
        zzf.put("H123", 8192);
        zzf.put("H150", 32768);
        zzf.put("H153", 131072);
        zzf.put("H156", 524288);
        zzf.put("H180", 2097152);
        zzf.put("H183", 8388608);
        zzf.put("H186", 33554432);
    }

    public static int zza() throws zzawz {
        int i;
        int i2 = zzg;
        if (i2 == -1) {
            i2 = 0;
            zzaws zzc2 = zzc("video/avc", false);
            if (zzc2 != null) {
                MediaCodecInfo.CodecProfileLevel[] zzg2 = zzc2.zzg();
                int length = zzg2.length;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = zzg2[i2].level;
                    if (i4 != 1 && i4 != 2) {
                        switch (i4) {
                            case 8:
                            case 16:
                            case 32:
                                i = 101376;
                                break;
                            case 64:
                                i = 202752;
                                break;
                            case 128:
                            case 256:
                                i = 414720;
                                break;
                            case 512:
                                i = 921600;
                                break;
                            case 1024:
                                i = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i = 2097152;
                                break;
                            case 8192:
                                i = 2228224;
                                break;
                            case 16384:
                                i = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i = 9437184;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                    } else {
                        i = 25344;
                    }
                    i3 = Math.max(i, i3);
                    i2++;
                }
                i2 = Math.max(i3, zzbar.zza >= 21 ? 345600 : 172800);
            }
            zzg = i2;
        }
        return i2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair zzb(java.lang.String r12) {
        /*
            java.lang.String r0 = "\\."
            java.lang.String[] r0 = r12.split(r0)
            r1 = 0
            r2 = r0[r1]
            int r3 = r2.hashCode()
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r3) {
                case 3006243: goto L_0x0032;
                case 3006244: goto L_0x0028;
                case 3199032: goto L_0x001e;
                case 3214780: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x003c
        L_0x0014:
            java.lang.String r3 = "hvc1"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x003c
            r2 = r6
            goto L_0x003d
        L_0x001e:
            java.lang.String r3 = "hev1"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x003c
            r2 = r1
            goto L_0x003d
        L_0x0028:
            java.lang.String r3 = "avc2"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x003c
            r2 = r4
            goto L_0x003d
        L_0x0032:
            java.lang.String r3 = "avc1"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x003c
            r2 = r5
            goto L_0x003d
        L_0x003c:
            r2 = -1
        L_0x003d:
            r3 = 4
            java.lang.String r7 = "MediaCodecUtil"
            r8 = 0
            if (r2 == 0) goto L_0x00d3
            if (r2 == r6) goto L_0x00d3
            if (r2 == r5) goto L_0x004a
            if (r2 == r4) goto L_0x004a
            return r8
        L_0x004a:
            int r2 = r0.length
            java.lang.String r9 = "Ignoring malformed AVC codec string: "
            if (r2 >= r5) goto L_0x0058
            java.lang.String r12 = r9.concat(r12)
            android.util.Log.w(r7, r12)
            goto L_0x00d2
        L_0x0058:
            r10 = r0[r6]     // Catch:{ NumberFormatException -> 0x00cb }
            int r10 = r10.length()     // Catch:{ NumberFormatException -> 0x00cb }
            r11 = 6
            if (r10 != r11) goto L_0x0080
            r2 = r0[r6]     // Catch:{ NumberFormatException -> 0x00cb }
            java.lang.String r1 = r2.substring(r1, r5)     // Catch:{ NumberFormatException -> 0x00cb }
            r2 = 16
            int r1 = java.lang.Integer.parseInt(r1, r2)     // Catch:{ NumberFormatException -> 0x00cb }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x00cb }
            r0 = r0[r6]     // Catch:{ NumberFormatException -> 0x00cb }
            java.lang.String r0 = r0.substring(r3)     // Catch:{ NumberFormatException -> 0x00cb }
            int r0 = java.lang.Integer.parseInt(r0, r2)     // Catch:{ NumberFormatException -> 0x00cb }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00cb }
            goto L_0x0096
        L_0x0080:
            if (r2 < r4) goto L_0x00b8
            r1 = r0[r6]     // Catch:{ NumberFormatException -> 0x00cb }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x00cb }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x00cb }
            r0 = r0[r5]     // Catch:{ NumberFormatException -> 0x00cb }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x00cb }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00cb }
        L_0x0096:
            android.util.SparseIntArray r0 = zzd
            int r1 = r1.intValue()
            int r0 = r0.get(r1)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            android.util.SparseIntArray r1 = zze
            int r12 = r12.intValue()
            int r12 = r1.get(r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            android.util.Pair r8 = new android.util.Pair
            r8.<init>(r0, r12)
            goto L_0x00d2
        L_0x00b8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00cb }
            r0.<init>()     // Catch:{ NumberFormatException -> 0x00cb }
            r0.append(r9)     // Catch:{ NumberFormatException -> 0x00cb }
            r0.append(r12)     // Catch:{ NumberFormatException -> 0x00cb }
            java.lang.String r0 = r0.toString()     // Catch:{ NumberFormatException -> 0x00cb }
            android.util.Log.w(r7, r0)     // Catch:{ NumberFormatException -> 0x00cb }
            goto L_0x00d2
        L_0x00cb:
            java.lang.String r12 = r9.concat(r12)
            android.util.Log.w(r7, r12)
        L_0x00d2:
            return r8
        L_0x00d3:
            int r1 = r0.length
            java.lang.String r2 = "Ignoring malformed HEVC codec string: "
            if (r1 >= r3) goto L_0x00e0
            java.lang.String r12 = r2.concat(r12)
            android.util.Log.w(r7, r12)
            goto L_0x0141
        L_0x00e0:
            java.util.regex.Pattern r1 = zzb
            r3 = r0[r6]
            java.util.regex.Matcher r1 = r1.matcher(r3)
            boolean r3 = r1.matches()
            if (r3 != 0) goto L_0x00f6
            java.lang.String r12 = r2.concat(r12)
            android.util.Log.w(r7, r12)
            goto L_0x0141
        L_0x00f6:
            java.lang.String r12 = r1.group(r6)
            java.lang.String r2 = "1"
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x0104
            r5 = r6
            goto L_0x010c
        L_0x0104:
            java.lang.String r2 = "2"
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x0134
        L_0x010c:
            java.util.Map r12 = zzf
            r0 = r0[r4]
            java.lang.Object r12 = r12.get(r0)
            java.lang.Integer r12 = (java.lang.Integer) r12
            if (r12 != 0) goto L_0x012a
            java.lang.String r12 = r1.group(r6)
            java.lang.String r12 = java.lang.String.valueOf(r12)
            java.lang.String r0 = "Unknown HEVC level string: "
            java.lang.String r12 = r0.concat(r12)
            android.util.Log.w(r7, r12)
            goto L_0x0141
        L_0x012a:
            android.util.Pair r8 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r8.<init>(r0, r12)
            goto L_0x0141
        L_0x0134:
            java.lang.String r12 = java.lang.String.valueOf(r12)
            java.lang.String r0 = "Unknown HEVC profile string: "
            java.lang.String r12 = r0.concat(r12)
            android.util.Log.w(r7, r12)
        L_0x0141:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxe.zzb(java.lang.String):android.util.Pair");
    }

    public static zzaws zzc(String str, boolean z) throws zzawz {
        List zzd2 = zzd(str, z);
        if (zzd2.isEmpty()) {
            return null;
        }
        return (zzaws) zzd2.get(0);
    }

    public static synchronized List zzd(String str, boolean z) throws zzawz {
        zzaxa zzaxa;
        int i;
        synchronized (zzaxe.class) {
            zzawx zzawx = new zzawx(str, z);
            List list = (List) zzc.get(zzawx);
            if (list != null) {
                return list;
            }
            if (zzbar.zza >= 21) {
                zzaxa = new zzaxd(z);
            } else {
                zzaxa = new zzaxc((zzaxb) null);
            }
            List zze2 = zze(zzawx, zzaxa);
            if (z && zze2.isEmpty() && (i = zzbar.zza) >= 21 && i <= 23) {
                zze2 = zze(zzawx, new zzaxc((zzaxb) null));
                if (!zze2.isEmpty()) {
                    String str2 = ((zzaws) zze2.get(0)).zza;
                    Log.w("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + str2);
                }
            }
            List unmodifiableList = Collections.unmodifiableList(zze2);
            zzc.put(zzawx, unmodifiableList);
            return unmodifiableList;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:0x01f0 A[Catch:{ Exception -> 0x01eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0233 A[SYNTHETIC, Splitter:B:146:0x0233] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0253 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List zze(com.google.android.gms.internal.ads.zzawx r18, com.google.android.gms.internal.ads.zzaxa r19) throws com.google.android.gms.internal.ads.zzawz {
        /*
            r1 = r18
            r2 = r19
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0290 }
            r3.<init>()     // Catch:{ Exception -> 0x0290 }
            java.lang.String r4 = r1.zza     // Catch:{ Exception -> 0x0290 }
            int r5 = r19.zza()     // Catch:{ Exception -> 0x0290 }
            boolean r6 = r19.zzd()     // Catch:{ Exception -> 0x0290 }
            r8 = 0
        L_0x0014:
            if (r8 >= r5) goto L_0x028f
            android.media.MediaCodecInfo r9 = r2.zzb(r8)     // Catch:{ Exception -> 0x0290 }
            java.lang.String r10 = r9.getName()     // Catch:{ Exception -> 0x0290 }
            boolean r0 = r9.isEncoder()     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r11 = ".secure"
            if (r6 != 0) goto L_0x0030
            boolean r0 = r10.endsWith(r11)     // Catch:{ Exception -> 0x0290 }
            if (r0 == 0) goto L_0x0030
            goto L_0x0284
        L_0x0030:
            int r0 = com.google.android.gms.internal.ads.zzbar.zza     // Catch:{ Exception -> 0x0290 }
            r12 = 21
            if (r0 >= r12) goto L_0x0066
            java.lang.String r0 = "CIPAACDecoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = "CIPMP3Decoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = "CIPVorbisDecoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = "CIPAMRNBDecoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = "AACDecoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = "MP3Decoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
        L_0x0066:
            int r0 = com.google.android.gms.internal.ads.zzbar.zza     // Catch:{ Exception -> 0x0290 }
            r12 = 18
            if (r0 >= r12) goto L_0x0074
            java.lang.String r0 = "OMX.SEC.MP3.Decoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
        L_0x0074:
            int r0 = com.google.android.gms.internal.ads.zzbar.zza     // Catch:{ Exception -> 0x0290 }
            if (r0 >= r12) goto L_0x008a
            java.lang.String r0 = "OMX.MTK.AUDIO.DECODER.AAC"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x0290 }
            if (r0 == 0) goto L_0x008a
            java.lang.String r0 = "a70"
            java.lang.String r12 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r0 = r0.equals(r12)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
        L_0x008a:
            int r0 = com.google.android.gms.internal.ads.zzbar.zza     // Catch:{ Exception -> 0x0290 }
            r12 = 16
            if (r0 != r12) goto L_0x0110
            java.lang.String r0 = "OMX.qcom.audio.decoder.mp3"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x0290 }
            if (r0 == 0) goto L_0x0110
            java.lang.String r0 = "dlxu"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = "protou"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = "ville"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = "villeplus"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = "villec2"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            java.lang.String r13 = "gee"
            boolean r0 = r0.startsWith(r13)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = "C6602"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = "C6603"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = "C6606"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = "C6616"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = "L36h"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = "SO-02E"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
        L_0x0110:
            int r0 = com.google.android.gms.internal.ads.zzbar.zza     // Catch:{ Exception -> 0x0290 }
            if (r0 != r12) goto L_0x0144
            java.lang.String r0 = "OMX.qcom.audio.decoder.aac"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x0290 }
            if (r0 == 0) goto L_0x0144
            java.lang.String r0 = "C1504"
            java.lang.String r12 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r0 = r0.equals(r12)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = "C1505"
            java.lang.String r12 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r0 = r0.equals(r12)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = "C1604"
            java.lang.String r12 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r0 = r0.equals(r12)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = "C1605"
            java.lang.String r12 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r0 = r0.equals(r12)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
        L_0x0144:
            int r0 = com.google.android.gms.internal.ads.zzbar.zza     // Catch:{ Exception -> 0x0290 }
            java.lang.String r12 = "jflte"
            r13 = 19
            if (r0 > r13) goto L_0x018e
            java.lang.String r0 = "OMX.SEC.vp8.dec"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x0290 }
            if (r0 == 0) goto L_0x018e
            java.lang.String r0 = "samsung"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzbar.zzc     // Catch:{ Exception -> 0x0290 }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x0290 }
            if (r0 == 0) goto L_0x018e
            java.lang.String r0 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            java.lang.String r14 = "d2"
            boolean r0 = r0.startsWith(r14)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            java.lang.String r14 = "serrano"
            boolean r0 = r0.startsWith(r14)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r0 = r0.startsWith(r12)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            java.lang.String r14 = "santos"
            boolean r0 = r0.startsWith(r14)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            java.lang.String r14 = "t0"
            boolean r0 = r0.startsWith(r14)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
        L_0x018e:
            int r0 = com.google.android.gms.internal.ads.zzbar.zza     // Catch:{ Exception -> 0x0290 }
            if (r0 > r13) goto L_0x01a2
            java.lang.String r0 = com.google.android.gms.internal.ads.zzbar.zzb     // Catch:{ Exception -> 0x0290 }
            boolean r0 = r0.startsWith(r12)     // Catch:{ Exception -> 0x0290 }
            if (r0 == 0) goto L_0x01a2
            java.lang.String r0 = "OMX.qcom.video.decoder.vp8"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x0290 }
            if (r0 != 0) goto L_0x0284
        L_0x01a2:
            java.lang.String[] r12 = r9.getSupportedTypes()     // Catch:{ Exception -> 0x0290 }
            int r13 = r12.length     // Catch:{ Exception -> 0x0290 }
            r14 = 0
        L_0x01a8:
            if (r14 >= r13) goto L_0x0284
            r15 = r12[r14]     // Catch:{ Exception -> 0x0290 }
            boolean r0 = r15.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0290 }
            if (r0 == 0) goto L_0x0275
            android.media.MediaCodecInfo$CodecCapabilities r0 = r9.getCapabilitiesForType(r15)     // Catch:{ Exception -> 0x0225 }
            boolean r7 = r2.zzc(r4, r0)     // Catch:{ Exception -> 0x0225 }
            int r2 = com.google.android.gms.internal.ads.zzbar.zza     // Catch:{ Exception -> 0x0225 }
            r16 = r5
            r5 = 22
            r17 = r9
            r9 = 1
            if (r2 > r5) goto L_0x01ed
            java.lang.String r2 = com.google.android.gms.internal.ads.zzbar.zzd     // Catch:{ Exception -> 0x01eb }
            java.lang.String r5 = "ODROID-XU3"
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x01eb }
            if (r2 != 0) goto L_0x01d9
            java.lang.String r2 = com.google.android.gms.internal.ads.zzbar.zzd     // Catch:{ Exception -> 0x01eb }
            java.lang.String r5 = "Nexus 10"
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x01eb }
            if (r2 == 0) goto L_0x01ed
        L_0x01d9:
            java.lang.String r2 = "OMX.Exynos.AVC.Decoder"
            boolean r2 = r2.equals(r10)     // Catch:{ Exception -> 0x01eb }
            if (r2 != 0) goto L_0x01e9
            java.lang.String r2 = "OMX.Exynos.AVC.Decoder.secure"
            boolean r2 = r2.equals(r10)     // Catch:{ Exception -> 0x01eb }
            if (r2 == 0) goto L_0x01ed
        L_0x01e9:
            r2 = r9
            goto L_0x01ee
        L_0x01eb:
            r0 = move-exception
            goto L_0x022a
        L_0x01ed:
            r2 = 0
        L_0x01ee:
            if (r6 == 0) goto L_0x01f7
            boolean r5 = r1.zzb     // Catch:{ Exception -> 0x01eb }
            if (r5 == r7) goto L_0x01f5
            goto L_0x01f7
        L_0x01f5:
            r5 = 0
            goto L_0x01fe
        L_0x01f7:
            if (r6 != 0) goto L_0x0209
            boolean r5 = r1.zzb     // Catch:{ Exception -> 0x01eb }
            if (r5 != 0) goto L_0x0209
            goto L_0x01f5
        L_0x01fe:
            com.google.android.gms.internal.ads.zzaws r0 = com.google.android.gms.internal.ads.zzaws.zza(r10, r4, r0, r2, r5)     // Catch:{ Exception -> 0x0207 }
            r3.add(r0)     // Catch:{ Exception -> 0x0207 }
            goto L_0x027a
        L_0x0207:
            r0 = move-exception
            goto L_0x022b
        L_0x0209:
            r5 = 0
            if (r6 != 0) goto L_0x027a
            if (r7 == 0) goto L_0x027a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0207 }
            r7.<init>()     // Catch:{ Exception -> 0x0207 }
            r7.append(r10)     // Catch:{ Exception -> 0x0207 }
            r7.append(r11)     // Catch:{ Exception -> 0x0207 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0207 }
            com.google.android.gms.internal.ads.zzaws r0 = com.google.android.gms.internal.ads.zzaws.zza(r7, r4, r0, r2, r9)     // Catch:{ Exception -> 0x0207 }
            r3.add(r0)     // Catch:{ Exception -> 0x0207 }
            return r3
        L_0x0225:
            r0 = move-exception
            r16 = r5
            r17 = r9
        L_0x022a:
            r5 = 0
        L_0x022b:
            int r2 = com.google.android.gms.internal.ads.zzbar.zza     // Catch:{ Exception -> 0x0290 }
            r7 = 23
            java.lang.String r9 = "MediaCodecUtil"
            if (r2 > r7) goto L_0x0253
            boolean r2 = r3.isEmpty()     // Catch:{ Exception -> 0x0290 }
            if (r2 != 0) goto L_0x0253
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0290 }
            r0.<init>()     // Catch:{ Exception -> 0x0290 }
            java.lang.String r2 = "Skipping codec "
            r0.append(r2)     // Catch:{ Exception -> 0x0290 }
            r0.append(r10)     // Catch:{ Exception -> 0x0290 }
            java.lang.String r2 = " (failed to query capabilities)"
            r0.append(r2)     // Catch:{ Exception -> 0x0290 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0290 }
            android.util.Log.e(r9, r0)     // Catch:{ Exception -> 0x0290 }
            goto L_0x027a
        L_0x0253:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0290 }
            r1.<init>()     // Catch:{ Exception -> 0x0290 }
            java.lang.String r2 = "Failed to query codec "
            r1.append(r2)     // Catch:{ Exception -> 0x0290 }
            r1.append(r10)     // Catch:{ Exception -> 0x0290 }
            java.lang.String r2 = " ("
            r1.append(r2)     // Catch:{ Exception -> 0x0290 }
            r1.append(r15)     // Catch:{ Exception -> 0x0290 }
            java.lang.String r2 = ")"
            r1.append(r2)     // Catch:{ Exception -> 0x0290 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0290 }
            android.util.Log.e(r9, r1)     // Catch:{ Exception -> 0x0290 }
            throw r0     // Catch:{ Exception -> 0x0290 }
        L_0x0275:
            r16 = r5
            r17 = r9
            r5 = 0
        L_0x027a:
            int r14 = r14 + 1
            r2 = r19
            r5 = r16
            r9 = r17
            goto L_0x01a8
        L_0x0284:
            r16 = r5
            r5 = 0
            int r8 = r8 + 1
            r2 = r19
            r5 = r16
            goto L_0x0014
        L_0x028f:
            return r3
        L_0x0290:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzawz r1 = new com.google.android.gms.internal.ads.zzawz
            r2 = 0
            r1.<init>(r0, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxe.zze(com.google.android.gms.internal.ads.zzawx, com.google.android.gms.internal.ads.zzaxa):java.util.List");
    }
}
