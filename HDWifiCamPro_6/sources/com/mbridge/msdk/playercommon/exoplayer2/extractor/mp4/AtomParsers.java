package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import com.mbridge.msdk.playercommon.exoplayer2.video.AvcConfig;
import com.mbridge.msdk.playercommon.exoplayer2.video.ColorInfo;
import com.mbridge.msdk.playercommon.exoplayer2.video.HevcConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class AtomParsers {
    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 3;
    private static final String TAG = "AtomParsers";
    private static final int TYPE_clcp = Util.getIntegerCodeForString("clcp");
    private static final int TYPE_meta = Util.getIntegerCodeForString("meta");
    private static final int TYPE_sbtl = Util.getIntegerCodeForString("sbtl");
    private static final int TYPE_soun = Util.getIntegerCodeForString("soun");
    private static final int TYPE_subt = Util.getIntegerCodeForString("subt");
    private static final int TYPE_text = Util.getIntegerCodeForString(MimeTypes.BASE_TYPE_TEXT);
    private static final int TYPE_vide = Util.getIntegerCodeForString("vide");

    private interface SampleSizeBox {
        int getSampleCount();

        boolean isFixedSampleSize();

        int readNextSampleSize();
    }

    public static final class UnhandledEditListException extends ParserException {
    }

    public static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        long j2;
        Atom.LeafAtom leafAtom2;
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        Atom.ContainerAtom containerAtomOfType = containerAtom2.getContainerAtomOfType(Atom.TYPE_mdia);
        int parseHdlr = parseHdlr(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_hdlr).data);
        if (parseHdlr == -1) {
            return null;
        }
        TkhdData parseTkhd = parseTkhd(containerAtom2.getLeafAtomOfType(Atom.TYPE_tkhd).data);
        long j3 = C.TIME_UNSET;
        if (j == C.TIME_UNSET) {
            j2 = parseTkhd.duration;
            leafAtom2 = leafAtom;
        } else {
            leafAtom2 = leafAtom;
            j2 = j;
        }
        long parseMvhd = parseMvhd(leafAtom2.data);
        if (j2 != C.TIME_UNSET) {
            j3 = Util.scaleLargeTimestamp(j2, 1000000, parseMvhd);
        }
        long j4 = j3;
        Atom.ContainerAtom containerAtomOfType2 = containerAtomOfType.getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl);
        Pair<Long, String> parseMdhd = parseMdhd(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_mdhd).data);
        StsdData parseStsd = parseStsd(containerAtomOfType2.getLeafAtomOfType(Atom.TYPE_stsd).data, parseTkhd.id, parseTkhd.rotationDegrees, (String) parseMdhd.second, drmInitData, z2);
        if (!z) {
            Pair<long[], long[]> parseEdts = parseEdts(containerAtom2.getContainerAtomOfType(Atom.TYPE_edts));
            jArr = (long[]) parseEdts.second;
            jArr2 = (long[]) parseEdts.first;
        } else {
            jArr2 = null;
            jArr = null;
        }
        if (parseStsd.format == null) {
            return null;
        }
        return new Track(parseTkhd.id, parseHdlr, ((Long) parseMdhd.first).longValue(), parseMvhd, j4, parseStsd.format, parseStsd.requiredSampleTransformation, parseStsd.trackEncryptionBoxes, parseStsd.nalUnitLengthFieldLength, jArr2, jArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:125:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x033f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable parseStbl(com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Track r41, com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.ContainerAtom r42, com.mbridge.msdk.playercommon.exoplayer2.extractor.GaplessInfoHolder r43) throws com.mbridge.msdk.playercommon.exoplayer2.ParserException {
        /*
            r1 = r41
            r0 = r42
            r2 = r43
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_stsz
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r3 = r0.getLeafAtomOfType(r3)
            if (r3 == 0) goto L_0x0014
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$StszSampleSizeBox r4 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$StszSampleSizeBox
            r4.<init>(r3)
            goto L_0x0021
        L_0x0014:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_stz2
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r3 = r0.getLeafAtomOfType(r3)
            if (r3 == 0) goto L_0x04c1
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$Stz2SampleSizeBox r4 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$Stz2SampleSizeBox
            r4.<init>(r3)
        L_0x0021:
            int r3 = r4.getSampleCount()
            r5 = 0
            if (r3 != 0) goto L_0x0042
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable r9 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable
            long[] r2 = new long[r5]
            int[] r3 = new int[r5]
            r4 = 0
            long[] r6 = new long[r5]
            int[] r7 = new int[r5]
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0 = r9
            r1 = r41
            r5 = r6
            r6 = r7
            r7 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x0042:
            int r6 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_stco
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r6 = r0.getLeafAtomOfType(r6)
            r7 = 1
            if (r6 != 0) goto L_0x0053
            int r6 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_co64
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r6 = r0.getLeafAtomOfType(r6)
            r8 = r7
            goto L_0x0054
        L_0x0053:
            r8 = r5
        L_0x0054:
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r6 = r6.data
            int r9 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_stsc
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r9 = r0.getLeafAtomOfType(r9)
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r9 = r9.data
            int r10 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_stts
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r10 = r0.getLeafAtomOfType(r10)
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r10 = r10.data
            int r11 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_stss
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r11 = r0.getLeafAtomOfType(r11)
            r12 = 0
            if (r11 == 0) goto L_0x0072
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r11 = r11.data
            goto L_0x0073
        L_0x0072:
            r11 = r12
        L_0x0073:
            int r13 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_ctts
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r0 = r0.getLeafAtomOfType(r13)
            if (r0 == 0) goto L_0x007e
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r0 = r0.data
            goto L_0x007f
        L_0x007e:
            r0 = r12
        L_0x007f:
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$ChunkIterator r13 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$ChunkIterator
            r13.<init>(r9, r6, r8)
            r6 = 12
            r10.setPosition(r6)
            int r8 = r10.readUnsignedIntToInt()
            int r8 = r8 - r7
            int r9 = r10.readUnsignedIntToInt()
            int r14 = r10.readUnsignedIntToInt()
            if (r0 == 0) goto L_0x00a0
            r0.setPosition(r6)
            int r15 = r0.readUnsignedIntToInt()
            goto L_0x00a1
        L_0x00a0:
            r15 = r5
        L_0x00a1:
            r16 = -1
            if (r11 == 0) goto L_0x00b7
            r11.setPosition(r6)
            int r6 = r11.readUnsignedIntToInt()
            if (r6 <= 0) goto L_0x00b5
            int r12 = r11.readUnsignedIntToInt()
            int r16 = r12 + -1
            goto L_0x00b8
        L_0x00b5:
            r11 = r12
            goto L_0x00b8
        L_0x00b7:
            r6 = r5
        L_0x00b8:
            boolean r12 = r4.isFixedSampleSize()
            if (r12 == 0) goto L_0x00d2
            com.mbridge.msdk.playercommon.exoplayer2.Format r12 = r1.format
            java.lang.String r12 = r12.sampleMimeType
            java.lang.String r5 = "audio/raw"
            boolean r5 = r5.equals(r12)
            if (r5 == 0) goto L_0x00d2
            if (r8 != 0) goto L_0x00d2
            if (r15 != 0) goto L_0x00d2
            if (r6 != 0) goto L_0x00d2
            r5 = r7
            goto L_0x00d3
        L_0x00d2:
            r5 = 0
        L_0x00d3:
            java.lang.String r12 = "AtomParsers"
            r18 = 0
            if (r5 != 0) goto L_0x0211
            long[] r5 = new long[r3]
            int[] r7 = new int[r3]
            r42 = r6
            long[] r6 = new long[r3]
            r21 = r8
            int[] r8 = new int[r3]
            r2 = r42
            r27 = r9
            r26 = r10
            r42 = r12
            r10 = r14
            r23 = r15
            r12 = r16
            r14 = r18
            r28 = r21
            r1 = 0
            r9 = 0
            r16 = 0
            r24 = 0
            r25 = 0
            r21 = r14
        L_0x0100:
            if (r9 >= r3) goto L_0x0194
        L_0x0102:
            if (r24 != 0) goto L_0x011c
            boolean r21 = r13.moveNext()
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r21)
            r30 = r2
            r29 = r3
            long r2 = r13.offset
            r21 = r2
            int r2 = r13.numSamples
            r24 = r2
            r3 = r29
            r2 = r30
            goto L_0x0102
        L_0x011c:
            r30 = r2
            r29 = r3
            if (r0 == 0) goto L_0x0133
        L_0x0122:
            if (r16 != 0) goto L_0x0131
            if (r23 <= 0) goto L_0x0131
            int r16 = r0.readUnsignedIntToInt()
            int r25 = r0.readInt()
            int r23 = r23 + -1
            goto L_0x0122
        L_0x0131:
            int r16 = r16 + -1
        L_0x0133:
            r2 = r25
            r5[r9] = r21
            int r3 = r4.readNextSampleSize()
            r7[r9] = r3
            r3 = r7[r9]
            if (r3 <= r1) goto L_0x0143
            r1 = r7[r9]
        L_0x0143:
            r25 = r4
            long r3 = (long) r2
            long r3 = r3 + r14
            r6[r9] = r3
            if (r11 != 0) goto L_0x014d
            r3 = 1
            goto L_0x014e
        L_0x014d:
            r3 = 0
        L_0x014e:
            r8[r9] = r3
            if (r9 != r12) goto L_0x0162
            r3 = 1
            r8[r9] = r3
            int r4 = r30 + -1
            if (r4 <= 0) goto L_0x015e
            int r12 = r11.readUnsignedIntToInt()
            int r12 = r12 - r3
        L_0x015e:
            r31 = r1
            r3 = r2
            goto L_0x0167
        L_0x0162:
            r31 = r1
            r3 = r2
            r4 = r30
        L_0x0167:
            long r1 = (long) r10
            long r14 = r14 + r1
            int r27 = r27 + -1
            r2 = r28
            if (r27 != 0) goto L_0x017e
            if (r2 <= 0) goto L_0x017e
            int r1 = r26.readUnsignedIntToInt()
            int r10 = r26.readInt()
            int r28 = r2 + -1
            r27 = r1
            goto L_0x0180
        L_0x017e:
            r28 = r2
        L_0x0180:
            r1 = r7[r9]
            long r1 = (long) r1
            long r21 = r21 + r1
            int r24 = r24 + -1
            int r9 = r9 + 1
            r2 = r4
            r4 = r25
            r1 = r31
            r25 = r3
            r3 = r29
            goto L_0x0100
        L_0x0194:
            r30 = r2
            r29 = r3
            r3 = r25
            r2 = r28
            long r3 = (long) r3
            long r14 = r14 + r3
            if (r16 != 0) goto L_0x01a2
            r3 = 1
            goto L_0x01a3
        L_0x01a2:
            r3 = 0
        L_0x01a3:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkArgument(r3)
        L_0x01a6:
            if (r23 <= 0) goto L_0x01ba
            int r3 = r0.readUnsignedIntToInt()
            if (r3 != 0) goto L_0x01b0
            r3 = 1
            goto L_0x01b1
        L_0x01b0:
            r3 = 0
        L_0x01b1:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkArgument(r3)
            r0.readInt()
            int r23 = r23 + -1
            goto L_0x01a6
        L_0x01ba:
            if (r30 != 0) goto L_0x01ca
            if (r27 != 0) goto L_0x01ca
            if (r24 != 0) goto L_0x01ca
            if (r2 == 0) goto L_0x01c3
            goto L_0x01ca
        L_0x01c3:
            r2 = r42
            r31 = r1
            r1 = r41
            goto L_0x020c
        L_0x01ca:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Inconsistent stbl box for track "
            r0.append(r3)
            r31 = r1
            r1 = r41
            int r3 = r1.id
            r0.append(r3)
            java.lang.String r3 = ": remainingSynchronizationSamples "
            r0.append(r3)
            r4 = r30
            r0.append(r4)
            java.lang.String r3 = ", remainingSamplesAtTimestampDelta "
            r0.append(r3)
            r9 = r27
            r0.append(r9)
            java.lang.String r3 = ", remainingSamplesInChunk "
            r0.append(r3)
            r3 = r24
            r0.append(r3)
            java.lang.String r3 = ", remainingTimestampDeltaChanges "
            r0.append(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r2 = r42
            android.util.Log.w(r2, r0)
        L_0x020c:
            r3 = r5
            r5 = r8
            r4 = r31
            goto L_0x0252
        L_0x0211:
            r29 = r3
            r2 = r12
            int r0 = r13.length
            long[] r0 = new long[r0]
            int r3 = r13.length
            int[] r3 = new int[r3]
        L_0x021c:
            boolean r4 = r13.moveNext()
            if (r4 == 0) goto L_0x022f
            int r4 = r13.index
            long r5 = r13.offset
            r0[r4] = r5
            int r4 = r13.index
            int r5 = r13.numSamples
            r3[r4] = r5
            goto L_0x021c
        L_0x022f:
            com.mbridge.msdk.playercommon.exoplayer2.Format r4 = r1.format
            int r4 = r4.pcmEncoding
            com.mbridge.msdk.playercommon.exoplayer2.Format r5 = r1.format
            int r5 = r5.channelCount
            int r4 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.getPcmFrameSize(r4, r5)
            long r5 = (long) r14
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.FixedSampleSizeRechunker$Results r0 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.FixedSampleSizeRechunker.rechunk(r4, r0, r3, r5)
            long[] r3 = r0.offsets
            int[] r4 = r0.sizes
            int r5 = r0.maximumSize
            long[] r6 = r0.timestamps
            int[] r7 = r0.flags
            long r14 = r0.duration
            r40 = r7
            r7 = r4
            r4 = r5
            r5 = r40
        L_0x0252:
            r10 = 1000000(0xf4240, double:4.940656E-318)
            long r12 = r1.timescale
            r8 = r14
            long r8 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r8, r10, r12)
            long[] r0 = r1.editListDurations
            if (r0 == 0) goto L_0x04a7
            boolean r0 = r43.hasGaplessInfo()
            if (r0 == 0) goto L_0x0268
            goto L_0x04a7
        L_0x0268:
            long[] r0 = r1.editListDurations
            int r0 = r0.length
            r12 = 1
            if (r0 != r12) goto L_0x02f6
            int r0 = r1.type
            if (r0 != r12) goto L_0x02f6
            int r0 = r6.length
            r12 = 2
            if (r0 < r12) goto L_0x02f6
            long[] r0 = r1.editListMediaTimes
            r12 = 0
            r30 = r0[r12]
            long[] r0 = r1.editListDurations
            r21 = r0[r12]
            long r12 = r1.timescale
            long r10 = r1.movieTimescale
            r23 = r12
            r25 = r10
            long r10 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r21, r23, r25)
            long r10 = r30 + r10
            r21 = r6
            r22 = r14
            r24 = r30
            r26 = r10
            boolean r0 = canApplyEditWithGaplessInfo(r21, r22, r24, r26)
            if (r0 == 0) goto L_0x02f6
            long r21 = r14 - r10
            r0 = 0
            r10 = r6[r0]
            long r23 = r30 - r10
            com.mbridge.msdk.playercommon.exoplayer2.Format r0 = r1.format
            int r0 = r0.sampleRate
            long r10 = (long) r0
            long r12 = r1.timescale
            r25 = r10
            r27 = r12
            long r10 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r23, r25, r27)
            com.mbridge.msdk.playercommon.exoplayer2.Format r0 = r1.format
            int r0 = r0.sampleRate
            long r12 = (long) r0
            r27 = r14
            long r14 = r1.timescale
            r23 = r12
            r25 = r14
            long r12 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r21, r23, r25)
            int r0 = (r10 > r18 ? 1 : (r10 == r18 ? 0 : -1))
            if (r0 != 0) goto L_0x02ca
            int r0 = (r12 > r18 ? 1 : (r12 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x02f4
        L_0x02ca:
            r14 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r0 > 0) goto L_0x02f4
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 > 0) goto L_0x02f4
            int r0 = (int) r10
            r2 = r43
            r2.encoderDelay = r0
            int r0 = (int) r12
            r2.encoderPadding = r0
            long r10 = r1.timescale
            r12 = 1000000(0xf4240, double:4.940656E-318)
            com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestampsInPlace(r6, r12, r10)
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable r10 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable
            r0 = r10
            r1 = r41
            r2 = r3
            r3 = r7
            r11 = r5
            r5 = r6
            r6 = r11
            r7 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r10
        L_0x02f4:
            r11 = r5
            goto L_0x02f9
        L_0x02f6:
            r11 = r5
            r27 = r14
        L_0x02f9:
            long[] r0 = r1.editListDurations
            int r0 = r0.length
            r5 = 1
            if (r0 != r5) goto L_0x033f
            long[] r0 = r1.editListDurations
            r5 = 0
            r8 = r0[r5]
            int r0 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
            if (r0 != 0) goto L_0x033f
            long[] r0 = r1.editListMediaTimes
            r8 = r0[r5]
            r0 = 0
        L_0x030d:
            int r2 = r6.length
            if (r0 >= r2) goto L_0x0324
            r12 = r6[r0]
            long r14 = r12 - r8
            r16 = 1000000(0xf4240, double:4.940656E-318)
            long r12 = r1.timescale
            r18 = r12
            long r12 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r14, r16, r18)
            r6[r0] = r12
            int r0 = r0 + 1
            goto L_0x030d
        L_0x0324:
            long r12 = r27 - r8
            r14 = 1000000(0xf4240, double:4.940656E-318)
            long r8 = r1.timescale
            r16 = r8
            long r8 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r12, r14, r16)
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable r10 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable
            r0 = r10
            r1 = r41
            r2 = r3
            r3 = r7
            r5 = r6
            r6 = r11
            r7 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r10
        L_0x033f:
            int r0 = r1.type
            r5 = 1
            if (r0 != r5) goto L_0x0346
            r0 = 1
            goto L_0x0347
        L_0x0346:
            r0 = 0
        L_0x0347:
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x034b:
            long[] r12 = r1.editListDurations
            int r12 = r12.length
            r13 = -1
            if (r5 >= r12) goto L_0x0391
            long[] r12 = r1.editListMediaTimes
            r42 = r11
            r11 = r12[r5]
            int r13 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r13 == 0) goto L_0x0386
            long[] r13 = r1.editListDurations
            r21 = r13[r5]
            long r13 = r1.timescale
            r16 = r2
            r15 = r3
            long r2 = r1.movieTimescale
            r23 = r13
            r25 = r2
            long r2 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r21, r23, r25)
            r13 = 1
            int r14 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.binarySearchCeil((long[]) r6, (long) r11, (boolean) r13, (boolean) r13)
            long r11 = r11 + r2
            r2 = 0
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.binarySearchCeil((long[]) r6, (long) r11, (boolean) r0, (boolean) r2)
            int r2 = r3 - r14
            int r9 = r9 + r2
            if (r10 == r14) goto L_0x0381
            r2 = 1
            goto L_0x0382
        L_0x0381:
            r2 = 0
        L_0x0382:
            r2 = r2 | r8
            r8 = r2
            r10 = r3
            goto L_0x0389
        L_0x0386:
            r16 = r2
            r15 = r3
        L_0x0389:
            int r5 = r5 + 1
            r11 = r42
            r3 = r15
            r2 = r16
            goto L_0x034b
        L_0x0391:
            r16 = r2
            r15 = r3
            r42 = r11
            r2 = r29
            if (r9 == r2) goto L_0x039c
            r2 = 1
            goto L_0x039d
        L_0x039c:
            r2 = 0
        L_0x039d:
            r2 = r2 | r8
            if (r2 == 0) goto L_0x03a3
            long[] r3 = new long[r9]
            goto L_0x03a4
        L_0x03a3:
            r3 = r15
        L_0x03a4:
            if (r2 == 0) goto L_0x03a9
            int[] r5 = new int[r9]
            goto L_0x03aa
        L_0x03a9:
            r5 = r7
        L_0x03aa:
            if (r2 == 0) goto L_0x03ad
            r4 = 0
        L_0x03ad:
            if (r2 == 0) goto L_0x03b2
            int[] r8 = new int[r9]
            goto L_0x03b4
        L_0x03b2:
            r8 = r42
        L_0x03b4:
            long[] r9 = new long[r9]
            r10 = r4
            r4 = 0
            r11 = 0
        L_0x03b9:
            long[] r12 = r1.editListDurations
            int r12 = r12.length
            if (r4 >= r12) goto L_0x0486
            long[] r12 = r1.editListMediaTimes
            r13 = r12[r4]
            long[] r12 = r1.editListDurations
            r29 = r12[r4]
            r27 = -1
            int r12 = (r13 > r27 ? 1 : (r13 == r27 ? 0 : -1))
            if (r12 == 0) goto L_0x0468
            r12 = r9
            r43 = r10
            long r9 = r1.timescale
            r32 = r4
            r31 = r5
            long r4 = r1.movieTimescale
            r21 = r29
            r23 = r9
            r25 = r4
            long r4 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r21, r23, r25)
            long r4 = r4 + r13
            r9 = 1
            int r10 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.binarySearchCeil((long[]) r6, (long) r13, (boolean) r9, (boolean) r9)
            r9 = 0
            int r4 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.binarySearchCeil((long[]) r6, (long) r4, (boolean) r0, (boolean) r9)
            if (r2 == 0) goto L_0x0400
            int r5 = r4 - r10
            java.lang.System.arraycopy(r15, r10, r3, r11, r5)
            r9 = r31
            java.lang.System.arraycopy(r7, r10, r9, r11, r5)
            r31 = r15
            r15 = r42
            java.lang.System.arraycopy(r15, r10, r8, r11, r5)
            goto L_0x0406
        L_0x0400:
            r9 = r31
            r31 = r15
            r15 = r42
        L_0x0406:
            if (r10 >= r4) goto L_0x0420
            r5 = r8[r11]
            r20 = 1
            r5 = r5 & 1
            if (r5 == 0) goto L_0x0413
            r5 = r16
            goto L_0x0424
        L_0x0413:
            java.lang.String r0 = "Ignoring edit list: edit does not start with a sync sample."
            r5 = r16
            android.util.Log.w(r5, r0)
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$UnhandledEditListException r0 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$UnhandledEditListException
            r0.<init>()
            throw r0
        L_0x0420:
            r5 = r16
            r20 = 1
        L_0x0424:
            r16 = r11
            r11 = r43
        L_0x0428:
            if (r10 >= r4) goto L_0x0462
            r23 = 1000000(0xf4240, double:4.940656E-318)
            r42 = r4
            r33 = r5
            long r4 = r1.movieTimescale
            r21 = r18
            r25 = r4
            long r4 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r21, r23, r25)
            r21 = r6[r10]
            long r34 = r21 - r13
            r36 = 1000000(0xf4240, double:4.940656E-318)
            r21 = r13
            long r13 = r1.timescale
            r38 = r13
            long r13 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r34, r36, r38)
            long r4 = r4 + r13
            r12[r16] = r4
            if (r2 == 0) goto L_0x0457
            r4 = r9[r16]
            if (r4 <= r11) goto L_0x0457
            r11 = r7[r10]
        L_0x0457:
            int r16 = r16 + 1
            int r10 = r10 + 1
            r4 = r42
            r13 = r21
            r5 = r33
            goto L_0x0428
        L_0x0462:
            r33 = r5
            r10 = r11
            r11 = r16
            goto L_0x0476
        L_0x0468:
            r32 = r4
            r12 = r9
            r43 = r10
            r31 = r15
            r33 = r16
            r20 = 1
            r15 = r42
            r9 = r5
        L_0x0476:
            long r18 = r18 + r29
            int r4 = r32 + 1
            r5 = r9
            r9 = r12
            r42 = r15
            r13 = r27
            r15 = r31
            r16 = r33
            goto L_0x03b9
        L_0x0486:
            r12 = r9
            r43 = r10
            r9 = r5
            r23 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = r1.timescale
            r21 = r18
            r25 = r4
            long r10 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r21, r23, r25)
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable r13 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable
            r0 = r13
            r1 = r41
            r2 = r3
            r3 = r9
            r4 = r43
            r5 = r12
            r6 = r8
            r7 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r13
        L_0x04a7:
            r31 = r3
            r15 = r5
            long r2 = r1.timescale
            r10 = 1000000(0xf4240, double:4.940656E-318)
            com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestampsInPlace(r6, r10, r2)
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable r10 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable
            r0 = r10
            r1 = r41
            r2 = r31
            r3 = r7
            r5 = r6
            r6 = r15
            r7 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r10
        L_0x04c1:
            com.mbridge.msdk.playercommon.exoplayer2.ParserException r0 = new com.mbridge.msdk.playercommon.exoplayer2.ParserException
            java.lang.String r1 = "Track has no sample table size information"
            r0.<init>((java.lang.String) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.parseStbl(com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Track, com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$ContainerAtom, com.mbridge.msdk.playercommon.exoplayer2.extractor.GaplessInfoHolder):com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable");
    }

    public static Metadata parseUdta(Atom.LeafAtom leafAtom, boolean z) {
        if (z) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtom.data;
        parsableByteArray.setPosition(8);
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_meta) {
                parsableByteArray.setPosition(position);
                return parseMetaAtom(parsableByteArray, position + readInt);
            }
            parsableByteArray.skipBytes(readInt - 8);
        }
        return null;
    }

    private static Metadata parseMetaAtom(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(12);
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_ilst) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + readInt);
            }
            parsableByteArray.skipBytes(readInt - 8);
        }
        return null;
    }

    private static Metadata parseIlst(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.getPosition() < i) {
            Metadata.Entry parseIlstElement = MetadataUtil.parseIlstElement(parsableByteArray);
            if (parseIlstElement != null) {
                arrayList.add(parseIlstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static long parseMvhd(ParsableByteArray parsableByteArray) {
        int i = 8;
        parsableByteArray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsableByteArray.readInt()) != 0) {
            i = 16;
        }
        parsableByteArray.skipBytes(i);
        return parsableByteArray.readUnsignedInt();
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        boolean z;
        int i = 8;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        int readInt = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        if (parseFullAtomVersion == 0) {
            i = 4;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= i) {
                z = true;
                break;
            } else if (parsableByteArray.data[position + i3] != -1) {
                z = false;
                break;
            } else {
                i3++;
            }
        }
        long j = C.TIME_UNSET;
        if (z) {
            parsableByteArray.skipBytes(i);
        } else {
            long readUnsignedInt = parseFullAtomVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
            if (readUnsignedInt != 0) {
                j = readUnsignedInt;
            }
        }
        parsableByteArray.skipBytes(16);
        int readInt2 = parsableByteArray.readInt();
        int readInt3 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int readInt4 = parsableByteArray.readInt();
        int readInt5 = parsableByteArray.readInt();
        if (readInt2 == 0 && readInt3 == 65536 && readInt4 == -65536 && readInt5 == 0) {
            i2 = 90;
        } else if (readInt2 == 0 && readInt3 == -65536 && readInt4 == 65536 && readInt5 == 0) {
            i2 = 270;
        } else if (readInt2 == -65536 && readInt3 == 0 && readInt4 == 0 && readInt5 == -65536) {
            i2 = 180;
        }
        return new TkhdData(readInt, j, i2);
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        int readInt = parsableByteArray.readInt();
        if (readInt == TYPE_soun) {
            return 1;
        }
        if (readInt == TYPE_vide) {
            return 2;
        }
        if (readInt == TYPE_text || readInt == TYPE_sbtl || readInt == TYPE_subt || readInt == TYPE_clcp) {
            return 3;
        }
        return readInt == TYPE_meta ? 4 : -1;
    }

    private static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        int i = 8;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (parseFullAtomVersion == 0) {
            i = 4;
        }
        parsableByteArray.skipBytes(i);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        return Pair.create(Long.valueOf(readUnsignedInt), "" + ((char) (((readUnsignedShort >> 10) & 31) + 96)) + ((char) (((readUnsignedShort >> 5) & 31) + 96)) + ((char) ((readUnsignedShort & 31) + 96)));
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        parsableByteArray2.setPosition(12);
        int readInt = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            int position = parsableByteArray.getPosition();
            int readInt2 = parsableByteArray.readInt();
            Assertions.checkArgument(readInt2 > 0, "childAtomSize should be positive");
            int readInt3 = parsableByteArray.readInt();
            if (readInt3 == Atom.TYPE_avc1 || readInt3 == Atom.TYPE_avc3 || readInt3 == Atom.TYPE_encv || readInt3 == Atom.TYPE_mp4v || readInt3 == Atom.TYPE_hvc1 || readInt3 == Atom.TYPE_hev1 || readInt3 == Atom.TYPE_s263 || readInt3 == Atom.TYPE_vp08 || readInt3 == Atom.TYPE_vp09) {
                parseVideoSampleEntry(parsableByteArray, readInt3, position, readInt2, i, i2, drmInitData, stsdData, i3);
            } else if (readInt3 == Atom.TYPE_mp4a || readInt3 == Atom.TYPE_enca || readInt3 == Atom.TYPE_ac_3 || readInt3 == Atom.TYPE_ec_3 || readInt3 == Atom.TYPE_dtsc || readInt3 == Atom.TYPE_dtse || readInt3 == Atom.TYPE_dtsh || readInt3 == Atom.TYPE_dtsl || readInt3 == Atom.TYPE_samr || readInt3 == Atom.TYPE_sawb || readInt3 == Atom.TYPE_lpcm || readInt3 == Atom.TYPE_sowt || readInt3 == Atom.TYPE__mp3 || readInt3 == Atom.TYPE_alac) {
                parseAudioSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, z, drmInitData, stsdData, i3);
            } else if (readInt3 == Atom.TYPE_TTML || readInt3 == Atom.TYPE_tx3g || readInt3 == Atom.TYPE_wvtt || readInt3 == Atom.TYPE_stpp || readInt3 == Atom.TYPE_c608) {
                parseTextSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, stsdData);
            } else if (readInt3 == Atom.TYPE_camm) {
                stsdData.format = Format.createSampleFormat(Integer.toString(i), MimeTypes.APPLICATION_CAMERA_MOTION, (String) null, -1, (DrmInitData) null);
            }
            parsableByteArray2.setPosition(position + readInt2);
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, StsdData stsdData) throws ParserException {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i5 = i;
        StsdData stsdData2 = stsdData;
        parsableByteArray2.setPosition(i2 + 8 + 8);
        int i6 = Atom.TYPE_TTML;
        String str2 = MimeTypes.APPLICATION_TTML;
        List list = null;
        long j = Long.MAX_VALUE;
        if (i5 != i6) {
            if (i5 == Atom.TYPE_tx3g) {
                int i7 = (i3 - 8) - 8;
                byte[] bArr = new byte[i7];
                parsableByteArray2.readBytes(bArr, 0, i7);
                list = Collections.singletonList(bArr);
                str2 = MimeTypes.APPLICATION_TX3G;
            } else if (i5 == Atom.TYPE_wvtt) {
                str2 = MimeTypes.APPLICATION_MP4VTT;
            } else if (i5 == Atom.TYPE_stpp) {
                j = 0;
            } else if (i5 == Atom.TYPE_c608) {
                stsdData2.requiredSampleTransformation = 1;
                str2 = MimeTypes.APPLICATION_MP4CEA608;
            } else {
                throw new IllegalStateException();
            }
        }
        stsdData2.format = Format.createTextSampleFormat(Integer.toString(i4), str2, (String) null, -1, 0, str, -1, (DrmInitData) null, j, list);
    }

    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, StsdData stsdData, int i6) throws ParserException {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i7 = i2;
        int i8 = i3;
        DrmInitData drmInitData2 = drmInitData;
        StsdData stsdData2 = stsdData;
        parsableByteArray2.setPosition(i7 + 8 + 8);
        parsableByteArray2.skipBytes(16);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray2.skipBytes(50);
        int position = parsableByteArray.getPosition();
        String str = null;
        int i9 = i;
        if (i9 == Atom.TYPE_encv) {
            Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray2, i7, i8);
            if (parseSampleEntryEncryptionData != null) {
                i9 = ((Integer) parseSampleEntryEncryptionData.first).intValue();
                if (drmInitData2 == null) {
                    drmInitData2 = null;
                } else {
                    drmInitData2 = drmInitData2.copyWithSchemeType(((TrackEncryptionBox) parseSampleEntryEncryptionData.second).schemeType);
                }
                stsdData2.trackEncryptionBoxes[i6] = (TrackEncryptionBox) parseSampleEntryEncryptionData.second;
            }
            parsableByteArray2.setPosition(position);
        }
        DrmInitData drmInitData3 = drmInitData2;
        int i10 = -1;
        List<byte[]> list = null;
        byte[] bArr = null;
        float f = 1.0f;
        boolean z = false;
        while (position - i7 < i8) {
            parsableByteArray2.setPosition(position);
            int position2 = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (readInt == 0 && parsableByteArray.getPosition() - i7 == i8) {
                break;
            }
            Assertions.checkArgument(readInt > 0, "childAtomSize should be positive");
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == Atom.TYPE_avcC) {
                Assertions.checkState(str == null);
                parsableByteArray2.setPosition(position2 + 8);
                AvcConfig parse = AvcConfig.parse(parsableByteArray);
                list = parse.initializationData;
                stsdData2.nalUnitLengthFieldLength = parse.nalUnitLengthFieldLength;
                if (!z) {
                    f = parse.pixelWidthAspectRatio;
                }
                str = "video/avc";
            } else if (readInt2 == Atom.TYPE_hvcC) {
                Assertions.checkState(str == null);
                parsableByteArray2.setPosition(position2 + 8);
                HevcConfig parse2 = HevcConfig.parse(parsableByteArray);
                list = parse2.initializationData;
                stsdData2.nalUnitLengthFieldLength = parse2.nalUnitLengthFieldLength;
                str = "video/hevc";
            } else if (readInt2 == Atom.TYPE_vpcC) {
                Assertions.checkState(str == null);
                str = i9 == Atom.TYPE_vp08 ? MimeTypes.VIDEO_VP8 : MimeTypes.VIDEO_VP9;
            } else if (readInt2 == Atom.TYPE_d263) {
                Assertions.checkState(str == null);
                str = MimeTypes.VIDEO_H263;
            } else if (readInt2 == Atom.TYPE_esds) {
                Assertions.checkState(str == null);
                Pair<String, byte[]> parseEsdsFromParent = parseEsdsFromParent(parsableByteArray2, position2);
                str = (String) parseEsdsFromParent.first;
                list = Collections.singletonList(parseEsdsFromParent.second);
            } else if (readInt2 == Atom.TYPE_pasp) {
                f = parsePaspFromParent(parsableByteArray2, position2);
                z = true;
            } else if (readInt2 == Atom.TYPE_sv3d) {
                bArr = parseProjFromParent(parsableByteArray2, position2, readInt);
            } else if (readInt2 == Atom.TYPE_st3d) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                parsableByteArray2.skipBytes(3);
                if (readUnsignedByte == 0) {
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                    if (readUnsignedByte2 == 0) {
                        i10 = 0;
                    } else if (readUnsignedByte2 == 1) {
                        i10 = 1;
                    } else if (readUnsignedByte2 == 2) {
                        i10 = 2;
                    } else if (readUnsignedByte2 == 3) {
                        i10 = 3;
                    }
                }
            }
            position += readInt;
        }
        if (str != null) {
            stsdData2.format = Format.createVideoSampleFormat(Integer.toString(i4), str, (String) null, -1, -1, readUnsignedShort, readUnsignedShort2, -1.0f, list, i5, f, bArr, i10, (ColorInfo) null, drmInitData3);
        }
    }

    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType;
        if (containerAtom == null || (leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_elst)) == null) {
            return Pair.create((Object) null, (Object) null);
        }
        ParsableByteArray parsableByteArray = leafAtomOfType.data;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[readUnsignedIntToInt];
        long[] jArr2 = new long[readUnsignedIntToInt];
        int i = 0;
        while (i < readUnsignedIntToInt) {
            jArr[i] = parseFullAtomVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i] = parseFullAtomVersion == 1 ? parsableByteArray.readLong() : (long) parsableByteArray.readInt();
            if (parsableByteArray.readShort() == 1) {
                parsableByteArray.skipBytes(2);
                i++;
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8);
        return ((float) parsableByteArray.readUnsignedIntToInt()) / ((float) parsableByteArray.readUnsignedIntToInt());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.String} */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0203: MOVE  (r7v3 java.lang.String) = (r25v0 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    private static void parseAudioSampleEntry(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r28, int r29, int r30, int r31, int r32, java.lang.String r33, boolean r34, com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData r35, com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.StsdData r36, int r37) throws com.mbridge.msdk.playercommon.exoplayer2.ParserException {
        /*
            r0 = r28
            r1 = r30
            r2 = r31
            r14 = r33
            r3 = r35
            r15 = r36
            int r4 = r1 + 8
            r5 = 8
            int r4 = r4 + r5
            r0.setPosition(r4)
            r4 = 6
            r13 = 0
            if (r34 == 0) goto L_0x0020
            int r5 = r28.readUnsignedShort()
            r0.skipBytes(r4)
            goto L_0x0024
        L_0x0020:
            r0.skipBytes(r5)
            r5 = r13
        L_0x0024:
            r12 = 2
            r6 = 16
            r11 = 1
            if (r5 == 0) goto L_0x0047
            if (r5 != r11) goto L_0x002d
            goto L_0x0047
        L_0x002d:
            if (r5 != r12) goto L_0x0046
            r0.skipBytes(r6)
            double r4 = r28.readDouble()
            long r4 = java.lang.Math.round(r4)
            int r4 = (int) r4
            int r5 = r28.readUnsignedIntToInt()
            r6 = 20
            r0.skipBytes(r6)
            r7 = r5
            goto L_0x0057
        L_0x0046:
            return
        L_0x0047:
            int r7 = r28.readUnsignedShort()
            r0.skipBytes(r4)
            int r4 = r28.readUnsignedFixedPoint1616()
            if (r5 != r11) goto L_0x0057
            r0.skipBytes(r6)
        L_0x0057:
            int r5 = r28.getPosition()
            int r6 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_enca
            r16 = 0
            r8 = r29
            if (r8 != r6) goto L_0x008b
            android.util.Pair r6 = parseSampleEntryEncryptionData(r0, r1, r2)
            if (r6 == 0) goto L_0x0088
            java.lang.Object r8 = r6.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            if (r3 != 0) goto L_0x0076
            r3 = r16
            goto L_0x0080
        L_0x0076:
            java.lang.Object r9 = r6.second
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackEncryptionBox r9 = (com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackEncryptionBox) r9
            java.lang.String r9 = r9.schemeType
            com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData r3 = r3.copyWithSchemeType(r9)
        L_0x0080:
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackEncryptionBox[] r9 = r15.trackEncryptionBoxes
            java.lang.Object r6 = r6.second
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackEncryptionBox r6 = (com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackEncryptionBox) r6
            r9[r37] = r6
        L_0x0088:
            r0.setPosition(r5)
        L_0x008b:
            r10 = r3
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_ac_3
            java.lang.String r9 = "audio/raw"
            if (r8 != r3) goto L_0x0095
            java.lang.String r3 = "audio/ac3"
            goto L_0x00df
        L_0x0095:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_ec_3
            if (r8 != r3) goto L_0x009c
            java.lang.String r3 = "audio/eac3"
            goto L_0x00df
        L_0x009c:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_dtsc
            if (r8 != r3) goto L_0x00a3
            java.lang.String r3 = "audio/vnd.dts"
            goto L_0x00df
        L_0x00a3:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_dtsh
            if (r8 == r3) goto L_0x00dd
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_dtsl
            if (r8 != r3) goto L_0x00ac
            goto L_0x00dd
        L_0x00ac:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_dtse
            if (r8 != r3) goto L_0x00b3
            java.lang.String r3 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x00df
        L_0x00b3:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_samr
            if (r8 != r3) goto L_0x00ba
            java.lang.String r3 = "audio/3gpp"
            goto L_0x00df
        L_0x00ba:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_sawb
            if (r8 != r3) goto L_0x00c1
            java.lang.String r3 = "audio/amr-wb"
            goto L_0x00df
        L_0x00c1:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_lpcm
            if (r8 == r3) goto L_0x00db
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_sowt
            if (r8 != r3) goto L_0x00ca
            goto L_0x00db
        L_0x00ca:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE__mp3
            if (r8 != r3) goto L_0x00d1
            java.lang.String r3 = "audio/mpeg"
            goto L_0x00df
        L_0x00d1:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_alac
            if (r8 != r3) goto L_0x00d8
            java.lang.String r3 = "audio/alac"
            goto L_0x00df
        L_0x00d8:
            r3 = r16
            goto L_0x00df
        L_0x00db:
            r3 = r9
            goto L_0x00df
        L_0x00dd:
            java.lang.String r3 = "audio/vnd.dts.hd"
        L_0x00df:
            r18 = r4
            r8 = r5
            r17 = r7
            r19 = r16
            r7 = r3
        L_0x00e7:
            int r3 = r8 - r1
            r4 = -1
            if (r3 >= r2) goto L_0x01f7
            r0.setPosition(r8)
            int r6 = r28.readInt()
            if (r6 <= 0) goto L_0x00f7
            r3 = r11
            goto L_0x00f8
        L_0x00f7:
            r3 = r13
        L_0x00f8:
            java.lang.String r5 = "childAtomSize should be positive"
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkArgument(r3, r5)
            int r3 = r28.readInt()
            int r5 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_esds
            if (r3 == r5) goto L_0x01a4
            if (r34 == 0) goto L_0x010d
            int r5 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_wave
            if (r3 != r5) goto L_0x010d
            goto L_0x01a4
        L_0x010d:
            int r4 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_dac3
            if (r3 != r4) goto L_0x012f
            int r3 = r8 + 8
            r0.setPosition(r3)
            java.lang.String r3 = java.lang.Integer.toString(r32)
            com.mbridge.msdk.playercommon.exoplayer2.Format r3 = com.mbridge.msdk.playercommon.exoplayer2.audio.Ac3Util.parseAc3AnnexFFormat(r0, r3, r14, r10)
            r15.format = r3
        L_0x0120:
            r5 = r6
            r25 = r7
            r6 = r8
            r27 = r9
            r20 = r10
            r21 = r11
            r22 = r12
            r1 = r13
            goto L_0x01a1
        L_0x012f:
            int r4 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_dec3
            if (r3 != r4) goto L_0x0143
            int r3 = r8 + 8
            r0.setPosition(r3)
            java.lang.String r3 = java.lang.Integer.toString(r32)
            com.mbridge.msdk.playercommon.exoplayer2.Format r3 = com.mbridge.msdk.playercommon.exoplayer2.audio.Ac3Util.parseEAc3AnnexFFormat(r0, r3, r14, r10)
            r15.format = r3
            goto L_0x0120
        L_0x0143:
            int r4 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_ddts
            if (r3 != r4) goto L_0x017d
            java.lang.String r3 = java.lang.Integer.toString(r32)
            r5 = 0
            r20 = -1
            r21 = -1
            r22 = 0
            r23 = 0
            r4 = r7
            r24 = r6
            r6 = r20
            r25 = r7
            r7 = r21
            r26 = r8
            r8 = r17
            r27 = r9
            r9 = r18
            r20 = r10
            r10 = r22
            r21 = r11
            r11 = r20
            r22 = r12
            r12 = r23
            r1 = r13
            r13 = r33
            com.mbridge.msdk.playercommon.exoplayer2.Format r3 = com.mbridge.msdk.playercommon.exoplayer2.Format.createAudioSampleFormat(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r15.format = r3
            r5 = r24
            goto L_0x019f
        L_0x017d:
            r24 = r6
            r25 = r7
            r26 = r8
            r27 = r9
            r20 = r10
            r21 = r11
            r22 = r12
            r1 = r13
            int r4 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_alac
            r5 = r24
            if (r3 != r4) goto L_0x019f
            byte[] r3 = new byte[r5]
            r6 = r26
            r0.setPosition(r6)
            r0.readBytes(r3, r1, r5)
            r19 = r3
            goto L_0x01a1
        L_0x019f:
            r6 = r26
        L_0x01a1:
            r7 = r25
            goto L_0x01e8
        L_0x01a4:
            r5 = r6
            r25 = r7
            r6 = r8
            r27 = r9
            r20 = r10
            r21 = r11
            r22 = r12
            r1 = r13
            int r7 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_esds
            if (r3 != r7) goto L_0x01b7
            r8 = r6
            goto L_0x01bb
        L_0x01b7:
            int r8 = findEsdsPosition(r0, r6, r5)
        L_0x01bb:
            if (r8 == r4) goto L_0x01a1
            android.util.Pair r3 = parseEsdsFromParent(r0, r8)
            java.lang.Object r4 = r3.first
            r7 = r4
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r3 = r3.second
            r19 = r3
            byte[] r19 = (byte[]) r19
            java.lang.String r3 = "audio/mp4a-latm"
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x01e8
            android.util.Pair r3 = com.mbridge.msdk.playercommon.exoplayer2.util.CodecSpecificDataUtil.parseAacAudioSpecificConfig(r19)
            java.lang.Object r4 = r3.first
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r18 = r4.intValue()
            java.lang.Object r3 = r3.second
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r17 = r3.intValue()
        L_0x01e8:
            int r8 = r6 + r5
            r13 = r1
            r10 = r20
            r11 = r21
            r12 = r22
            r9 = r27
            r1 = r30
            goto L_0x00e7
        L_0x01f7:
            r25 = r7
            r27 = r9
            r20 = r10
            r22 = r12
            com.mbridge.msdk.playercommon.exoplayer2.Format r0 = r15.format
            if (r0 != 0) goto L_0x0235
            r7 = r25
            if (r7 == 0) goto L_0x0235
            r0 = r27
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x0210
            goto L_0x0212
        L_0x0210:
            r22 = r4
        L_0x0212:
            java.lang.String r0 = java.lang.Integer.toString(r32)
            r2 = 0
            r3 = -1
            r4 = -1
            if (r19 != 0) goto L_0x021e
            r8 = r16
            goto L_0x0223
        L_0x021e:
            java.util.List r1 = java.util.Collections.singletonList(r19)
            r8 = r1
        L_0x0223:
            r10 = 0
            r1 = r7
            r5 = r17
            r6 = r18
            r7 = r22
            r9 = r20
            r11 = r33
            com.mbridge.msdk.playercommon.exoplayer2.Format r0 = com.mbridge.msdk.playercommon.exoplayer2.Format.createAudioSampleFormat(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r15.format = r0
        L_0x0235:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.parseAudioSampleEntry(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray, int, int, int, int, java.lang.String, boolean, com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData, com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$StsdData, int):void");
    }

    private static int findEsdsPosition(ParsableByteArray parsableByteArray, int i, int i2) {
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            Assertions.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == Atom.TYPE_esds) {
                return position;
            }
            position += readInt;
        }
        return -1;
    }

    private static Pair<String, byte[]> parseEsdsFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8 + 4);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if (MimeTypes.AUDIO_MPEG.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS_HD.equals(mimeTypeFromMp4ObjectType)) {
            return Pair.create(mimeTypeFromMp4ObjectType, (Object) null);
        }
        parsableByteArray.skipBytes(12);
        parsableByteArray.skipBytes(1);
        int parseExpandableClassSize = parseExpandableClassSize(parsableByteArray);
        byte[] bArr = new byte[parseExpandableClassSize];
        parsableByteArray.readBytes(bArr, 0, parseExpandableClassSize);
        return Pair.create(mimeTypeFromMp4ObjectType, bArr);
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i, int i2) {
        Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            Assertions.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == Atom.TYPE_sinf && (parseCommonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, readInt)) != null) {
                return parseCommonEncryptionSinfFromParent;
            }
            position += readInt;
        }
        return null;
    }

    static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        int i4 = -1;
        String str = null;
        Integer num = null;
        int i5 = 0;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == Atom.TYPE_frma) {
                num = Integer.valueOf(parsableByteArray.readInt());
            } else if (readInt2 == Atom.TYPE_schm) {
                parsableByteArray.skipBytes(4);
                str = parsableByteArray.readString(4);
            } else if (readInt2 == Atom.TYPE_schi) {
                i4 = i3;
                i5 = readInt;
            }
            i3 += readInt;
        }
        if (!C.CENC_TYPE_cenc.equals(str) && !C.CENC_TYPE_cbc1.equals(str) && !C.CENC_TYPE_cens.equals(str) && !C.CENC_TYPE_cbcs.equals(str)) {
            return null;
        }
        boolean z = true;
        Assertions.checkArgument(num != null, "frma atom is mandatory");
        Assertions.checkArgument(i4 != -1, "schi atom is mandatory");
        TrackEncryptionBox parseSchiFromParent = parseSchiFromParent(parsableByteArray, i4, i5, str);
        if (parseSchiFromParent == null) {
            z = false;
        }
        Assertions.checkArgument(z, "tenc atom is mandatory");
        return Pair.create(num, parseSchiFromParent);
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            parsableByteArray.setPosition(i5);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_tenc) {
                int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (parseFullAtomVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    i3 = readUnsignedByte & 15;
                    i4 = (readUnsignedByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
                }
                boolean z = parsableByteArray.readUnsignedByte() == 1;
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, bArr2.length);
                if (z && readUnsignedByte2 == 0) {
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[readUnsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, readUnsignedByte3);
                }
                return new TrackEncryptionBox(z, str, readUnsignedByte2, bArr2, i4, i3, bArr);
            }
            i5 += readInt;
        }
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_proj) {
                return Arrays.copyOfRange(parsableByteArray.data, i3, readInt + i3);
            }
            i3 += readInt;
        }
        return null;
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = parsableByteArray.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        int constrainValue = Util.constrainValue(3, 0, length);
        int constrainValue2 = Util.constrainValue(jArr.length - 3, 0, length);
        if (jArr[0] > j2 || j2 >= jArr[constrainValue] || jArr[constrainValue2] >= j3 || j3 > j) {
            return false;
        }
        return true;
    }

    private AtomParsers() {
    }

    private static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            Assertions.checkState(parsableByteArray.readInt() != 1 ? false : true, "first_chunk must be 1");
            this.index = -1;
        }

        public final boolean moveNext() {
            long j;
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                return false;
            }
            if (this.chunkOffsetsAreLongs) {
                j = this.chunkOffsets.readUnsignedLongToLong();
            } else {
                j = this.chunkOffsets.readUnsignedInt();
            }
            this.offset = j;
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i2 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i2;
                this.nextSamplesPerChunkChangeIndex = i2 > 0 ? this.stsc.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    private static final class TkhdData {
        /* access modifiers changed from: private */
        public final long duration;
        /* access modifiers changed from: private */
        public final int id;
        /* access modifiers changed from: private */
        public final int rotationDegrees;

        public TkhdData(int i, long j, int i2) {
            this.id = i;
            this.duration = j;
            this.rotationDegrees = i2;
        }
    }

    private static final class StsdData {
        public static final int STSD_HEADER_SIZE = 8;
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i];
        }
    }

    static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize = this.data.readUnsignedIntToInt();
        private final int sampleCount = this.data.readUnsignedIntToInt();

        public StszSampleSizeBox(Atom.LeafAtom leafAtom) {
            this.data = leafAtom.data;
            this.data.setPosition(12);
        }

        public final int getSampleCount() {
            return this.sampleCount;
        }

        public final int readNextSampleSize() {
            int i = this.fixedSampleSize;
            return i == 0 ? this.data.readUnsignedIntToInt() : i;
        }

        public final boolean isFixedSampleSize() {
            return this.fixedSampleSize != 0;
        }
    }

    static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize = (this.data.readUnsignedIntToInt() & 255);
        private final int sampleCount = this.data.readUnsignedIntToInt();
        private int sampleIndex;

        public final boolean isFixedSampleSize() {
            return false;
        }

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            this.data = leafAtom.data;
            this.data.setPosition(12);
        }

        public final int getSampleCount() {
            return this.sampleCount;
        }

        public final int readNextSampleSize() {
            int i = this.fieldSize;
            if (i == 8) {
                return this.data.readUnsignedByte();
            }
            if (i == 16) {
                return this.data.readUnsignedShort();
            }
            int i2 = this.sampleIndex;
            this.sampleIndex = i2 + 1;
            if (i2 % 2 != 0) {
                return this.currentByte & 15;
            }
            this.currentByte = this.data.readUnsignedByte();
            return (this.currentByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
        }
    }
}
