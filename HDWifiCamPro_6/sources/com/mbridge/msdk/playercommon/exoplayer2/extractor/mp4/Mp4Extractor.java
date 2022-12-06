package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorsFactory;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.GaplessInfoHolder;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.PositionHolder;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

public final class Mp4Extractor implements Extractor, SeekMap {
    private static final int BRAND_QUICKTIME = Util.getIntegerCodeForString("qt  ");
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() {
        public final Extractor[] createExtractors() {
            return new Extractor[]{new Mp4Extractor()};
        }
    };
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 1;
    private static final long MAXIMUM_READ_AHEAD_BYTES_STREAM = 10485760;
    private static final long RELOAD_MINIMUM_SEEK_DISTANCE = 262144;
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private long[][] accumulatedSampleSizes;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private final ArrayDeque<Atom.ContainerAtom> containerAtoms;
    private long durationUs;
    private ExtractorOutput extractorOutput;
    private int firstVideoTrackIndex;
    private final int flags;
    private boolean isQuickTime;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleTrackIndex;
    private Mp4Track[] tracks;

    public @interface Flags {
    }

    private @interface State {
    }

    public final boolean isSeekable() {
        return true;
    }

    public final void release() {
    }

    public Mp4Extractor() {
        this(0);
    }

    public Mp4Extractor(int i) {
        this.flags = i;
        this.atomHeader = new ParsableByteArray(16);
        this.containerAtoms = new ArrayDeque<>();
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.sampleTrackIndex = -1;
    }

    public final boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return Sniffer.sniffUnfragmented(extractorInput);
    }

    public final void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
    }

    public final void seek(long j, long j2) {
        this.containerAtoms.clear();
        this.atomHeaderBytesRead = 0;
        this.sampleTrackIndex = -1;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        if (j == 0) {
            enterReadingAtomHeaderState();
        } else if (this.tracks != null) {
            updateSampleIndices(j2);
        }
    }

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        while (true) {
            int i = this.parserState;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return readSample(extractorInput, positionHolder);
                    }
                    throw new IllegalStateException();
                } else if (readAtomPayload(extractorInput, positionHolder)) {
                    return 1;
                }
            } else if (!readAtomHeader(extractorInput)) {
                return -1;
            }
        }
    }

    public final long getDurationUs() {
        return this.durationUs;
    }

    public final SeekMap.SeekPoints getSeekPoints(long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        int indexOfLaterOrEqualSynchronizationSample;
        Mp4Track[] mp4TrackArr = this.tracks;
        if (mp4TrackArr.length == 0) {
            return new SeekMap.SeekPoints(SeekPoint.START);
        }
        int i = this.firstVideoTrackIndex;
        if (i != -1) {
            TrackSampleTable trackSampleTable = mp4TrackArr[i].sampleTable;
            int synchronizationSampleIndex = getSynchronizationSampleIndex(trackSampleTable, j);
            if (synchronizationSampleIndex == -1) {
                return new SeekMap.SeekPoints(SeekPoint.START);
            }
            long j6 = trackSampleTable.timestampsUs[synchronizationSampleIndex];
            j2 = trackSampleTable.offsets[synchronizationSampleIndex];
            if (j6 >= j || synchronizationSampleIndex >= trackSampleTable.sampleCount - 1 || (indexOfLaterOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j)) == -1 || indexOfLaterOrEqualSynchronizationSample == synchronizationSampleIndex) {
                j5 = -1;
                j4 = -9223372036854775807L;
            } else {
                j4 = trackSampleTable.timestampsUs[indexOfLaterOrEqualSynchronizationSample];
                j5 = trackSampleTable.offsets[indexOfLaterOrEqualSynchronizationSample];
            }
            j3 = j5;
            j = j6;
        } else {
            j2 = Long.MAX_VALUE;
            j3 = -1;
            j4 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            Mp4Track[] mp4TrackArr2 = this.tracks;
            if (i2 >= mp4TrackArr2.length) {
                break;
            }
            if (i2 != this.firstVideoTrackIndex) {
                TrackSampleTable trackSampleTable2 = mp4TrackArr2[i2].sampleTable;
                long maybeAdjustSeekOffset = maybeAdjustSeekOffset(trackSampleTable2, j, j2);
                if (j4 != C.TIME_UNSET) {
                    j3 = maybeAdjustSeekOffset(trackSampleTable2, j4, j3);
                }
                j2 = maybeAdjustSeekOffset;
            }
            i2++;
        }
        SeekPoint seekPoint = new SeekPoint(j, j2);
        if (j4 == C.TIME_UNSET) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(j4, j3));
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 0;
        this.atomHeaderBytesRead = 0;
    }

    private boolean readAtomHeader(ExtractorInput extractorInput) throws IOException, InterruptedException {
        if (this.atomHeaderBytesRead == 0) {
            if (!extractorInput.readFully(this.atomHeader.data, 0, 8, true)) {
                return false;
            }
            this.atomHeaderBytesRead = 8;
            this.atomHeader.setPosition(0);
            this.atomSize = this.atomHeader.readUnsignedInt();
            this.atomType = this.atomHeader.readInt();
        }
        long j = this.atomSize;
        if (j == 1) {
            extractorInput.readFully(this.atomHeader.data, 8, 8);
            this.atomHeaderBytesRead += 8;
            this.atomSize = this.atomHeader.readUnsignedLongToLong();
        } else if (j == 0) {
            long length = extractorInput.getLength();
            if (length == -1 && !this.containerAtoms.isEmpty()) {
                length = this.containerAtoms.peek().endPosition;
            }
            if (length != -1) {
                this.atomSize = (length - extractorInput.getPosition()) + ((long) this.atomHeaderBytesRead);
            }
        }
        if (this.atomSize >= ((long) this.atomHeaderBytesRead)) {
            if (shouldParseContainerAtom(this.atomType)) {
                long position = (extractorInput.getPosition() + this.atomSize) - ((long) this.atomHeaderBytesRead);
                this.containerAtoms.push(new Atom.ContainerAtom(this.atomType, position));
                if (this.atomSize == ((long) this.atomHeaderBytesRead)) {
                    processAtomEnded(position);
                } else {
                    enterReadingAtomHeaderState();
                }
            } else if (shouldParseLeafAtom(this.atomType)) {
                Assertions.checkState(this.atomHeaderBytesRead == 8);
                Assertions.checkState(this.atomSize <= 2147483647L);
                this.atomData = new ParsableByteArray((int) this.atomSize);
                System.arraycopy(this.atomHeader.data, 0, this.atomData.data, 0, 8);
                this.parserState = 1;
            } else {
                this.atomData = null;
                this.parserState = 1;
            }
            return true;
        }
        throw new ParserException("Atom size less than header length (unsupported).");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean readAtomPayload(com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput r10, com.mbridge.msdk.playercommon.exoplayer2.extractor.PositionHolder r11) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r9 = this;
            long r0 = r9.atomSize
            int r2 = r9.atomHeaderBytesRead
            long r2 = (long) r2
            long r0 = r0 - r2
            long r2 = r10.getPosition()
            long r2 = r2 + r0
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r4 = r9.atomData
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0045
            byte[] r11 = r4.data
            int r4 = r9.atomHeaderBytesRead
            int r0 = (int) r0
            r10.readFully(r11, r4, r0)
            int r10 = r9.atomType
            int r11 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_ftyp
            if (r10 != r11) goto L_0x0028
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r10 = r9.atomData
            boolean r10 = processFtypAtom(r10)
            r9.isQuickTime = r10
            goto L_0x0050
        L_0x0028:
            java.util.ArrayDeque<com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$ContainerAtom> r10 = r9.containerAtoms
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L_0x0050
            java.util.ArrayDeque<com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$ContainerAtom> r10 = r9.containerAtoms
            java.lang.Object r10 = r10.peek()
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$ContainerAtom r10 = (com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.ContainerAtom) r10
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r11 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom
            int r0 = r9.atomType
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r1 = r9.atomData
            r11.<init>(r0, r1)
            r10.add((com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.LeafAtom) r11)
            goto L_0x0050
        L_0x0045:
            r7 = 262144(0x40000, double:1.295163E-318)
            int r4 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r4 >= 0) goto L_0x0052
            int r11 = (int) r0
            r10.skipFully(r11)
        L_0x0050:
            r10 = r6
            goto L_0x005a
        L_0x0052:
            long r7 = r10.getPosition()
            long r7 = r7 + r0
            r11.position = r7
            r10 = r5
        L_0x005a:
            r9.processAtomEnded(r2)
            if (r10 == 0) goto L_0x0065
            int r10 = r9.parserState
            r11 = 2
            if (r10 == r11) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r5 = r6
        L_0x0066:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Mp4Extractor.readAtomPayload(com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput, com.mbridge.msdk.playercommon.exoplayer2.extractor.PositionHolder):boolean");
    }

    private void processAtomEnded(long j) throws ParserException {
        while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == j) {
            Atom.ContainerAtom pop = this.containerAtoms.pop();
            if (pop.type == Atom.TYPE_moov) {
                processMoovAtom(pop);
                this.containerAtoms.clear();
                this.parserState = 2;
            } else if (!this.containerAtoms.isEmpty()) {
                this.containerAtoms.peek().add(pop);
            }
        }
        if (this.parserState != 2) {
            enterReadingAtomHeaderState();
        }
    }

    private void processMoovAtom(Atom.ContainerAtom containerAtom) throws ParserException {
        Metadata metadata;
        ArrayList<TrackSampleTable> arrayList;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        ArrayList arrayList2 = new ArrayList();
        GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
        Atom.LeafAtom leafAtomOfType = containerAtom2.getLeafAtomOfType(Atom.TYPE_udta);
        if (leafAtomOfType != null) {
            metadata = AtomParsers.parseUdta(leafAtomOfType, this.isQuickTime);
            if (metadata != null) {
                gaplessInfoHolder.setFromMetadata(metadata);
            }
        } else {
            metadata = null;
        }
        int i = 1;
        int i2 = 0;
        try {
            arrayList = getTrackSampleTables(containerAtom2, gaplessInfoHolder, (this.flags & 1) != 0);
        } catch (AtomParsers.UnhandledEditListException unused) {
            gaplessInfoHolder = new GaplessInfoHolder();
            arrayList = getTrackSampleTables(containerAtom2, gaplessInfoHolder, true);
        }
        int size = arrayList.size();
        int i3 = -1;
        long j = C.TIME_UNSET;
        while (i2 < size) {
            TrackSampleTable trackSampleTable = arrayList.get(i2);
            Track track = trackSampleTable.track;
            Mp4Track mp4Track = new Mp4Track(track, trackSampleTable, this.extractorOutput.track(i2, track.type));
            Format copyWithMaxInputSize = track.format.copyWithMaxInputSize(trackSampleTable.maximumSize + 30);
            if (track.type == i) {
                if (gaplessInfoHolder.hasGaplessInfo()) {
                    copyWithMaxInputSize = copyWithMaxInputSize.copyWithGaplessInfo(gaplessInfoHolder.encoderDelay, gaplessInfoHolder.encoderPadding);
                }
                if (metadata != null) {
                    copyWithMaxInputSize = copyWithMaxInputSize.copyWithMetadata(metadata);
                }
            }
            mp4Track.trackOutput.format(copyWithMaxInputSize);
            j = Math.max(j, track.durationUs != C.TIME_UNSET ? track.durationUs : trackSampleTable.durationUs);
            if (track.type == 2) {
                if (i3 == -1) {
                    i3 = arrayList2.size();
                }
            }
            arrayList2.add(mp4Track);
            i2++;
            i = 1;
        }
        this.firstVideoTrackIndex = i3;
        this.durationUs = j;
        this.tracks = (Mp4Track[]) arrayList2.toArray(new Mp4Track[arrayList2.size()]);
        this.accumulatedSampleSizes = calculateAccumulatedSampleSizes(this.tracks);
        this.extractorOutput.endTracks();
        this.extractorOutput.seekMap(this);
    }

    private ArrayList<TrackSampleTable> getTrackSampleTables(Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder, boolean z) throws ParserException {
        Track parseTrak;
        ArrayList<TrackSampleTable> arrayList = new ArrayList<>();
        for (int i = 0; i < containerAtom.containerChildren.size(); i++) {
            Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i);
            if (containerAtom2.type == Atom.TYPE_trak && (parseTrak = AtomParsers.parseTrak(containerAtom2, containerAtom.getLeafAtomOfType(Atom.TYPE_mvhd), C.TIME_UNSET, (DrmInitData) null, z, this.isQuickTime)) != null) {
                TrackSampleTable parseStbl = AtomParsers.parseStbl(parseTrak, containerAtom2.getContainerAtomOfType(Atom.TYPE_mdia).getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl), gaplessInfoHolder);
                if (parseStbl.sampleCount != 0) {
                    arrayList.add(parseStbl);
                }
            }
        }
        return arrayList;
    }

    private int readSample(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        long position = extractorInput.getPosition();
        if (this.sampleTrackIndex == -1) {
            this.sampleTrackIndex = getTrackIndexOfNextReadSample(position);
            if (this.sampleTrackIndex == -1) {
                return -1;
            }
        }
        Mp4Track mp4Track = this.tracks[this.sampleTrackIndex];
        TrackOutput trackOutput = mp4Track.trackOutput;
        int i = mp4Track.sampleIndex;
        long j = mp4Track.sampleTable.offsets[i];
        int i2 = mp4Track.sampleTable.sizes[i];
        long j2 = (j - position) + ((long) this.sampleBytesWritten);
        if (j2 < 0 || j2 >= RELOAD_MINIMUM_SEEK_DISTANCE) {
            positionHolder.position = j;
            return 1;
        }
        if (mp4Track.track.sampleTransformation == 1) {
            j2 += 8;
            i2 -= 8;
        }
        extractorInput.skipFully((int) j2);
        if (mp4Track.track.nalUnitLengthFieldLength == 0) {
            while (true) {
                int i3 = this.sampleBytesWritten;
                if (i3 >= i2) {
                    break;
                }
                int sampleData = trackOutput.sampleData(extractorInput, i2 - i3, false);
                this.sampleBytesWritten += sampleData;
                this.sampleCurrentNalBytesRemaining -= sampleData;
            }
        } else {
            byte[] bArr = this.nalLength.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i4 = mp4Track.track.nalUnitLengthFieldLength;
            int i5 = 4 - mp4Track.track.nalUnitLengthFieldLength;
            while (this.sampleBytesWritten < i2) {
                int i6 = this.sampleCurrentNalBytesRemaining;
                if (i6 == 0) {
                    extractorInput.readFully(this.nalLength.data, i5, i4);
                    this.nalLength.setPosition(0);
                    this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                    this.nalStartCode.setPosition(0);
                    trackOutput.sampleData(this.nalStartCode, 4);
                    this.sampleBytesWritten += 4;
                    i2 += i5;
                } else {
                    int sampleData2 = trackOutput.sampleData(extractorInput, i6, false);
                    this.sampleBytesWritten += sampleData2;
                    this.sampleCurrentNalBytesRemaining -= sampleData2;
                }
            }
        }
        trackOutput.sampleMetadata(mp4Track.sampleTable.timestampsUs[i], mp4Track.sampleTable.flags[i], i2, 0, (TrackOutput.CryptoData) null);
        mp4Track.sampleIndex++;
        this.sampleTrackIndex = -1;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        return 0;
    }

    private int getTrackIndexOfNextReadSample(long j) {
        int i = -1;
        int i2 = -1;
        int i3 = 0;
        long j2 = Long.MAX_VALUE;
        boolean z = true;
        long j3 = Long.MAX_VALUE;
        boolean z2 = true;
        long j4 = Long.MAX_VALUE;
        while (true) {
            Mp4Track[] mp4TrackArr = this.tracks;
            if (i3 >= mp4TrackArr.length) {
                break;
            }
            Mp4Track mp4Track = mp4TrackArr[i3];
            int i4 = mp4Track.sampleIndex;
            if (i4 != mp4Track.sampleTable.sampleCount) {
                long j5 = mp4Track.sampleTable.offsets[i4];
                long j6 = this.accumulatedSampleSizes[i3][i4];
                long j7 = j5 - j;
                boolean z3 = j7 < 0 || j7 >= RELOAD_MINIMUM_SEEK_DISTANCE;
                if ((!z3 && z2) || (z3 == z2 && j7 < j4)) {
                    z2 = z3;
                    i2 = i3;
                    j4 = j7;
                    j3 = j6;
                }
                if (j6 < j2) {
                    z = z3;
                    i = i3;
                    j2 = j6;
                }
            }
            i3++;
        }
        return (j2 == Long.MAX_VALUE || !z || j3 < j2 + MAXIMUM_READ_AHEAD_BYTES_STREAM) ? i2 : i;
    }

    private void updateSampleIndices(long j) {
        for (Mp4Track mp4Track : this.tracks) {
            TrackSampleTable trackSampleTable = mp4Track.sampleTable;
            int indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(j);
            if (indexOfEarlierOrEqualSynchronizationSample == -1) {
                indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j);
            }
            mp4Track.sampleIndex = indexOfEarlierOrEqualSynchronizationSample;
        }
    }

    private static long[][] calculateAccumulatedSampleSizes(Mp4Track[] mp4TrackArr) {
        long[][] jArr = new long[mp4TrackArr.length][];
        int[] iArr = new int[mp4TrackArr.length];
        long[] jArr2 = new long[mp4TrackArr.length];
        boolean[] zArr = new boolean[mp4TrackArr.length];
        for (int i = 0; i < mp4TrackArr.length; i++) {
            jArr[i] = new long[mp4TrackArr[i].sampleTable.sampleCount];
            jArr2[i] = mp4TrackArr[i].sampleTable.timestampsUs[0];
        }
        long j = 0;
        int i2 = 0;
        while (i2 < mp4TrackArr.length) {
            int i3 = -1;
            long j2 = Long.MAX_VALUE;
            for (int i4 = 0; i4 < mp4TrackArr.length; i4++) {
                if (!zArr[i4] && jArr2[i4] <= j2) {
                    j2 = jArr2[i4];
                    i3 = i4;
                }
            }
            int i5 = iArr[i3];
            jArr[i3][i5] = j;
            j += (long) mp4TrackArr[i3].sampleTable.sizes[i5];
            int i6 = i5 + 1;
            iArr[i3] = i6;
            if (i6 < jArr[i3].length) {
                jArr2[i3] = mp4TrackArr[i3].sampleTable.timestampsUs[i6];
            } else {
                zArr[i3] = true;
                i2++;
            }
        }
        return jArr;
    }

    private static long maybeAdjustSeekOffset(TrackSampleTable trackSampleTable, long j, long j2) {
        int synchronizationSampleIndex = getSynchronizationSampleIndex(trackSampleTable, j);
        if (synchronizationSampleIndex == -1) {
            return j2;
        }
        return Math.min(trackSampleTable.offsets[synchronizationSampleIndex], j2);
    }

    private static int getSynchronizationSampleIndex(TrackSampleTable trackSampleTable, long j) {
        int indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(j);
        return indexOfEarlierOrEqualSynchronizationSample == -1 ? trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j) : indexOfEarlierOrEqualSynchronizationSample;
    }

    private static boolean processFtypAtom(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        if (parsableByteArray.readInt() == BRAND_QUICKTIME) {
            return true;
        }
        parsableByteArray.skipBytes(4);
        while (parsableByteArray.bytesLeft() > 0) {
            if (parsableByteArray.readInt() == BRAND_QUICKTIME) {
                return true;
            }
        }
        return false;
    }

    private static boolean shouldParseLeafAtom(int i) {
        return i == Atom.TYPE_mdhd || i == Atom.TYPE_mvhd || i == Atom.TYPE_hdlr || i == Atom.TYPE_stsd || i == Atom.TYPE_stts || i == Atom.TYPE_stss || i == Atom.TYPE_ctts || i == Atom.TYPE_elst || i == Atom.TYPE_stsc || i == Atom.TYPE_stsz || i == Atom.TYPE_stz2 || i == Atom.TYPE_stco || i == Atom.TYPE_co64 || i == Atom.TYPE_tkhd || i == Atom.TYPE_ftyp || i == Atom.TYPE_udta;
    }

    private static boolean shouldParseContainerAtom(int i) {
        return i == Atom.TYPE_moov || i == Atom.TYPE_trak || i == Atom.TYPE_mdia || i == Atom.TYPE_minf || i == Atom.TYPE_stbl || i == Atom.TYPE_edts;
    }

    private static final class Mp4Track {
        public int sampleIndex;
        public final TrackSampleTable sampleTable;
        public final Track track;
        public final TrackOutput trackOutput;

        public Mp4Track(Track track2, TrackSampleTable trackSampleTable, TrackOutput trackOutput2) {
            this.track = track2;
            this.sampleTable = trackSampleTable;
            this.trackOutput = trackOutput2;
        }
    }
}
