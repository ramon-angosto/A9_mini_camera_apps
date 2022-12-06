package com.mbridge.msdk.playercommon.exoplayer2.source;

import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.FormatHolder;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.source.SampleMetadataQueue;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocation;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.ByteCompanionObject;

public final class SampleQueue implements TrackOutput {
    public static final int ADVANCE_FAILED = -1;
    private static final int INITIAL_SCRATCH_SIZE = 32;
    private final int allocationLength;
    private final Allocator allocator;
    private Format downstreamFormat;
    private final SampleMetadataQueue.SampleExtrasHolder extrasHolder = new SampleMetadataQueue.SampleExtrasHolder();
    private AllocationNode firstAllocationNode = new AllocationNode(0, this.allocationLength);
    private Format lastUnadjustedFormat;
    private final SampleMetadataQueue metadataQueue = new SampleMetadataQueue();
    private boolean pendingFormatAdjustment;
    private boolean pendingSplice;
    private AllocationNode readAllocationNode;
    private long sampleOffsetUs;
    private final ParsableByteArray scratch = new ParsableByteArray(32);
    private long totalBytesWritten;
    private UpstreamFormatChangedListener upstreamFormatChangeListener;
    private AllocationNode writeAllocationNode;

    public interface UpstreamFormatChangedListener {
        void onUpstreamFormatChanged(Format format);
    }

    public SampleQueue(Allocator allocator2) {
        this.allocator = allocator2;
        this.allocationLength = allocator2.getIndividualAllocationLength();
        AllocationNode allocationNode = this.firstAllocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
    }

    public final void reset() {
        reset(false);
    }

    public final void reset(boolean z) {
        this.metadataQueue.reset(z);
        clearAllocationNodes(this.firstAllocationNode);
        this.firstAllocationNode = new AllocationNode(0, this.allocationLength);
        AllocationNode allocationNode = this.firstAllocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
        this.totalBytesWritten = 0;
        this.allocator.trim();
    }

    public final void sourceId(int i) {
        this.metadataQueue.sourceId(i);
    }

    public final void splice() {
        this.pendingSplice = true;
    }

    public final int getWriteIndex() {
        return this.metadataQueue.getWriteIndex();
    }

    public final void discardUpstreamSamples(int i) {
        this.totalBytesWritten = this.metadataQueue.discardUpstreamSamples(i);
        long j = this.totalBytesWritten;
        if (j == 0 || j == this.firstAllocationNode.startPosition) {
            clearAllocationNodes(this.firstAllocationNode);
            this.firstAllocationNode = new AllocationNode(this.totalBytesWritten, this.allocationLength);
            AllocationNode allocationNode = this.firstAllocationNode;
            this.readAllocationNode = allocationNode;
            this.writeAllocationNode = allocationNode;
            return;
        }
        AllocationNode allocationNode2 = this.firstAllocationNode;
        while (this.totalBytesWritten > allocationNode2.endPosition) {
            allocationNode2 = allocationNode2.next;
        }
        AllocationNode allocationNode3 = allocationNode2.next;
        clearAllocationNodes(allocationNode3);
        allocationNode2.next = new AllocationNode(allocationNode2.endPosition, this.allocationLength);
        this.writeAllocationNode = this.totalBytesWritten == allocationNode2.endPosition ? allocationNode2.next : allocationNode2;
        if (this.readAllocationNode == allocationNode3) {
            this.readAllocationNode = allocationNode2.next;
        }
    }

    public final boolean hasNextSample() {
        return this.metadataQueue.hasNextSample();
    }

    public final int getFirstIndex() {
        return this.metadataQueue.getFirstIndex();
    }

    public final int getReadIndex() {
        return this.metadataQueue.getReadIndex();
    }

    public final int peekSourceId() {
        return this.metadataQueue.peekSourceId();
    }

    public final Format getUpstreamFormat() {
        return this.metadataQueue.getUpstreamFormat();
    }

    public final long getLargestQueuedTimestampUs() {
        return this.metadataQueue.getLargestQueuedTimestampUs();
    }

    public final long getFirstTimestampUs() {
        return this.metadataQueue.getFirstTimestampUs();
    }

    public final void rewind() {
        this.metadataQueue.rewind();
        this.readAllocationNode = this.firstAllocationNode;
    }

    public final void discardTo(long j, boolean z, boolean z2) {
        discardDownstreamTo(this.metadataQueue.discardTo(j, z, z2));
    }

    public final void discardToRead() {
        discardDownstreamTo(this.metadataQueue.discardToRead());
    }

    public final void discardToEnd() {
        discardDownstreamTo(this.metadataQueue.discardToEnd());
    }

    public final int advanceToEnd() {
        return this.metadataQueue.advanceToEnd();
    }

    public final int advanceTo(long j, boolean z, boolean z2) {
        return this.metadataQueue.advanceTo(j, z, z2);
    }

    public final boolean setReadPosition(int i) {
        return this.metadataQueue.setReadPosition(i);
    }

    public final int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z, boolean z2, long j) {
        int read = this.metadataQueue.read(formatHolder, decoderInputBuffer, z, z2, this.downstreamFormat, this.extrasHolder);
        if (read == -5) {
            this.downstreamFormat = formatHolder.format;
            return -5;
        } else if (read == -4) {
            if (!decoderInputBuffer.isEndOfStream()) {
                if (decoderInputBuffer.timeUs < j) {
                    decoderInputBuffer.addFlag(Integer.MIN_VALUE);
                }
                if (decoderInputBuffer.isEncrypted()) {
                    readEncryptionData(decoderInputBuffer, this.extrasHolder);
                }
                decoderInputBuffer.ensureSpaceForWrite(this.extrasHolder.size);
                readData(this.extrasHolder.offset, decoderInputBuffer.data, this.extrasHolder.size);
            }
            return -4;
        } else if (read == -3) {
            return -3;
        } else {
            throw new IllegalStateException();
        }
    }

    private void readEncryptionData(DecoderInputBuffer decoderInputBuffer, SampleMetadataQueue.SampleExtrasHolder sampleExtrasHolder) {
        DecoderInputBuffer decoderInputBuffer2 = decoderInputBuffer;
        SampleMetadataQueue.SampleExtrasHolder sampleExtrasHolder2 = sampleExtrasHolder;
        long j = sampleExtrasHolder2.offset;
        int i = 1;
        this.scratch.reset(1);
        readData(j, this.scratch.data, 1);
        long j2 = j + 1;
        byte b = this.scratch.data[0];
        boolean z = (b & ByteCompanionObject.MIN_VALUE) != 0;
        byte b2 = b & ByteCompanionObject.MAX_VALUE;
        if (decoderInputBuffer2.cryptoInfo.iv == null) {
            decoderInputBuffer2.cryptoInfo.iv = new byte[16];
        }
        readData(j2, decoderInputBuffer2.cryptoInfo.iv, (int) b2);
        long j3 = j2 + ((long) b2);
        if (z) {
            this.scratch.reset(2);
            readData(j3, this.scratch.data, 2);
            j3 += 2;
            i = this.scratch.readUnsignedShort();
        }
        int i2 = i;
        int[] iArr = decoderInputBuffer2.cryptoInfo.numBytesOfClearData;
        if (iArr == null || iArr.length < i2) {
            iArr = new int[i2];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = decoderInputBuffer2.cryptoInfo.numBytesOfEncryptedData;
        if (iArr3 == null || iArr3.length < i2) {
            iArr3 = new int[i2];
        }
        int[] iArr4 = iArr3;
        if (z) {
            int i3 = i2 * 6;
            this.scratch.reset(i3);
            readData(j3, this.scratch.data, i3);
            j3 += (long) i3;
            this.scratch.setPosition(0);
            for (int i4 = 0; i4 < i2; i4++) {
                iArr2[i4] = this.scratch.readUnsignedShort();
                iArr4[i4] = this.scratch.readUnsignedIntToInt();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = sampleExtrasHolder2.size - ((int) (j3 - sampleExtrasHolder2.offset));
        }
        TrackOutput.CryptoData cryptoData = sampleExtrasHolder2.cryptoData;
        decoderInputBuffer2.cryptoInfo.set(i2, iArr2, iArr4, cryptoData.encryptionKey, decoderInputBuffer2.cryptoInfo.iv, cryptoData.cryptoMode, cryptoData.encryptedBlocks, cryptoData.clearBlocks);
        int i5 = (int) (j3 - sampleExtrasHolder2.offset);
        sampleExtrasHolder2.offset += (long) i5;
        sampleExtrasHolder2.size -= i5;
    }

    private void readData(long j, ByteBuffer byteBuffer, int i) {
        advanceReadTo(j);
        while (i > 0) {
            int min = Math.min(i, (int) (this.readAllocationNode.endPosition - j));
            byteBuffer.put(this.readAllocationNode.allocation.data, this.readAllocationNode.translateOffset(j), min);
            i -= min;
            j += (long) min;
            if (j == this.readAllocationNode.endPosition) {
                this.readAllocationNode = this.readAllocationNode.next;
            }
        }
    }

    private void readData(long j, byte[] bArr, int i) {
        advanceReadTo(j);
        long j2 = j;
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.readAllocationNode.endPosition - j2));
            System.arraycopy(this.readAllocationNode.allocation.data, this.readAllocationNode.translateOffset(j2), bArr, i - i2, min);
            i2 -= min;
            j2 += (long) min;
            if (j2 == this.readAllocationNode.endPosition) {
                this.readAllocationNode = this.readAllocationNode.next;
            }
        }
    }

    private void advanceReadTo(long j) {
        while (j >= this.readAllocationNode.endPosition) {
            this.readAllocationNode = this.readAllocationNode.next;
        }
    }

    private void discardDownstreamTo(long j) {
        if (j != -1) {
            while (j >= this.firstAllocationNode.endPosition) {
                this.allocator.release(this.firstAllocationNode.allocation);
                this.firstAllocationNode = this.firstAllocationNode.clear();
            }
            if (this.readAllocationNode.startPosition < this.firstAllocationNode.startPosition) {
                this.readAllocationNode = this.firstAllocationNode;
            }
        }
    }

    public final void setUpstreamFormatChangeListener(UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.upstreamFormatChangeListener = upstreamFormatChangedListener;
    }

    public final void setSampleOffsetUs(long j) {
        if (this.sampleOffsetUs != j) {
            this.sampleOffsetUs = j;
            this.pendingFormatAdjustment = true;
        }
    }

    public final void format(Format format) {
        Format adjustedSampleFormat = getAdjustedSampleFormat(format, this.sampleOffsetUs);
        boolean format2 = this.metadataQueue.format(adjustedSampleFormat);
        this.lastUnadjustedFormat = format;
        this.pendingFormatAdjustment = false;
        UpstreamFormatChangedListener upstreamFormatChangedListener = this.upstreamFormatChangeListener;
        if (upstreamFormatChangedListener != null && format2) {
            upstreamFormatChangedListener.onUpstreamFormatChanged(adjustedSampleFormat);
        }
    }

    public final int sampleData(ExtractorInput extractorInput, int i, boolean z) throws IOException, InterruptedException {
        int read = extractorInput.read(this.writeAllocationNode.allocation.data, this.writeAllocationNode.translateOffset(this.totalBytesWritten), preAppend(i));
        if (read != -1) {
            postAppend(read);
            return read;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public final void sampleData(ParsableByteArray parsableByteArray, int i) {
        while (i > 0) {
            int preAppend = preAppend(i);
            parsableByteArray.readBytes(this.writeAllocationNode.allocation.data, this.writeAllocationNode.translateOffset(this.totalBytesWritten), preAppend);
            i -= preAppend;
            postAppend(preAppend);
        }
    }

    public final void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
        long j2 = j;
        if (this.pendingFormatAdjustment) {
            format(this.lastUnadjustedFormat);
        }
        if (this.pendingSplice) {
            if ((i & 1) != 0 && this.metadataQueue.attemptSplice(j)) {
                this.pendingSplice = false;
            } else {
                return;
            }
        }
        this.metadataQueue.commitSample(j2 + this.sampleOffsetUs, i, (this.totalBytesWritten - ((long) i2)) - ((long) i3), i2, cryptoData);
    }

    private void clearAllocationNodes(AllocationNode allocationNode) {
        if (allocationNode.wasInitialized) {
            Allocation[] allocationArr = new Allocation[((this.writeAllocationNode.wasInitialized ? 1 : 0) + (((int) (this.writeAllocationNode.startPosition - allocationNode.startPosition)) / this.allocationLength))];
            for (int i = 0; i < allocationArr.length; i++) {
                allocationArr[i] = allocationNode.allocation;
                allocationNode = allocationNode.clear();
            }
            this.allocator.release(allocationArr);
        }
    }

    private int preAppend(int i) {
        if (!this.writeAllocationNode.wasInitialized) {
            this.writeAllocationNode.initialize(this.allocator.allocate(), new AllocationNode(this.writeAllocationNode.endPosition, this.allocationLength));
        }
        return Math.min(i, (int) (this.writeAllocationNode.endPosition - this.totalBytesWritten));
    }

    private void postAppend(int i) {
        this.totalBytesWritten += (long) i;
        if (this.totalBytesWritten == this.writeAllocationNode.endPosition) {
            this.writeAllocationNode = this.writeAllocationNode.next;
        }
    }

    private static Format getAdjustedSampleFormat(Format format, long j) {
        if (format == null) {
            return null;
        }
        return (j == 0 || format.subsampleOffsetUs == Long.MAX_VALUE) ? format : format.copyWithSubsampleOffsetUs(format.subsampleOffsetUs + j);
    }

    private static final class AllocationNode {
        public Allocation allocation;
        public final long endPosition;
        public AllocationNode next;
        public final long startPosition;
        public boolean wasInitialized;

        public AllocationNode(long j, int i) {
            this.startPosition = j;
            this.endPosition = j + ((long) i);
        }

        public final void initialize(Allocation allocation2, AllocationNode allocationNode) {
            this.allocation = allocation2;
            this.next = allocationNode;
            this.wasInitialized = true;
        }

        public final int translateOffset(long j) {
            return ((int) (j - this.startPosition)) + this.allocation.offset;
        }

        public final AllocationNode clear() {
            this.allocation = null;
            AllocationNode allocationNode = this.next;
            this.next = null;
            return allocationNode;
        }
    }
}
