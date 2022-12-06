package com.mbridge.msdk.playercommon.exoplayer2.extractor.ts;

import android.util.Log;
import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.DummyTrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsPayloadReader;
import com.mbridge.msdk.playercommon.exoplayer2.util.CodecSpecificDataUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import java.util.Collections;
import kotlin.UByte;

public final class AdtsReader implements ElementaryStreamReader {
    private static final int CRC_SIZE = 2;
    private static final int HEADER_SIZE = 5;
    private static final int ID3_HEADER_SIZE = 10;
    private static final byte[] ID3_IDENTIFIER = {73, 68, 51};
    private static final int ID3_SIZE_OFFSET = 6;
    private static final int MATCH_STATE_FF = 512;
    private static final int MATCH_STATE_I = 768;
    private static final int MATCH_STATE_ID = 1024;
    private static final int MATCH_STATE_START = 256;
    private static final int MATCH_STATE_VALUE_SHIFT = 8;
    private static final int STATE_FINDING_SAMPLE = 0;
    private static final int STATE_READING_ADTS_HEADER = 2;
    private static final int STATE_READING_ID3_HEADER = 1;
    private static final int STATE_READING_SAMPLE = 3;
    private static final String TAG = "AdtsReader";
    private final ParsableBitArray adtsScratch;
    private int bytesRead;
    private TrackOutput currentOutput;
    private long currentSampleDuration;
    private final boolean exposeId3;
    private String formatId;
    private boolean hasCrc;
    private boolean hasOutputFormat;
    private final ParsableByteArray id3HeaderBuffer;
    private TrackOutput id3Output;
    private final String language;
    private int matchState;
    private TrackOutput output;
    private long sampleDurationUs;
    private int sampleSize;
    private int state;
    private long timeUs;

    public final void packetFinished() {
    }

    public AdtsReader(boolean z) {
        this(z, (String) null);
    }

    public AdtsReader(boolean z, String str) {
        this.adtsScratch = new ParsableBitArray(new byte[7]);
        this.id3HeaderBuffer = new ParsableByteArray(Arrays.copyOf(ID3_IDENTIFIER, 10));
        setFindingSampleState();
        this.exposeId3 = z;
        this.language = str;
    }

    public final void seek() {
        setFindingSampleState();
    }

    public final void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
        if (this.exposeId3) {
            trackIdGenerator.generateNewId();
            this.id3Output = extractorOutput.track(trackIdGenerator.getTrackId(), 4);
            this.id3Output.format(Format.createSampleFormat(trackIdGenerator.getFormatId(), MimeTypes.APPLICATION_ID3, (String) null, -1, (DrmInitData) null));
            return;
        }
        this.id3Output = new DummyTrackOutput();
    }

    public final void packetStarted(long j, boolean z) {
        this.timeUs = j;
    }

    public final void consume(ParsableByteArray parsableByteArray) throws ParserException {
        while (parsableByteArray.bytesLeft() > 0) {
            int i = this.state;
            if (i == 0) {
                findNextSample(parsableByteArray);
            } else if (i != 1) {
                if (i == 2) {
                    if (continueRead(parsableByteArray, this.adtsScratch.data, this.hasCrc ? 7 : 5)) {
                        parseAdtsHeader();
                    }
                } else if (i == 3) {
                    readSample(parsableByteArray);
                }
            } else if (continueRead(parsableByteArray, this.id3HeaderBuffer.data, 10)) {
                parseId3Header();
            }
        }
    }

    private boolean continueRead(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        int min = Math.min(parsableByteArray.bytesLeft(), i - this.bytesRead);
        parsableByteArray.readBytes(bArr, this.bytesRead, min);
        this.bytesRead += min;
        return this.bytesRead == i;
    }

    private void setFindingSampleState() {
        this.state = 0;
        this.bytesRead = 0;
        this.matchState = 256;
    }

    private void setReadingId3HeaderState() {
        this.state = 1;
        this.bytesRead = ID3_IDENTIFIER.length;
        this.sampleSize = 0;
        this.id3HeaderBuffer.setPosition(0);
    }

    private void setReadingSampleState(TrackOutput trackOutput, long j, int i, int i2) {
        this.state = 3;
        this.bytesRead = i;
        this.currentOutput = trackOutput;
        this.currentSampleDuration = j;
        this.sampleSize = i2;
    }

    private void setReadingAdtsHeaderState() {
        this.state = 2;
        this.bytesRead = 0;
    }

    private void findNextSample(ParsableByteArray parsableByteArray) {
        byte[] bArr = parsableByteArray.data;
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        while (position < limit) {
            int i = position + 1;
            byte b = bArr[position] & UByte.MAX_VALUE;
            if (this.matchState != 512 || b < 240 || b == 255) {
                int i2 = this.matchState;
                byte b2 = b | i2;
                if (b2 == 329) {
                    this.matchState = MATCH_STATE_I;
                } else if (b2 == 511) {
                    this.matchState = 512;
                } else if (b2 == 836) {
                    this.matchState = 1024;
                } else if (b2 == 1075) {
                    setReadingId3HeaderState();
                    parsableByteArray.setPosition(i);
                    return;
                } else if (i2 != 256) {
                    this.matchState = 256;
                    i--;
                }
                position = i;
            } else {
                boolean z = true;
                if ((b & 1) != 0) {
                    z = false;
                }
                this.hasCrc = z;
                setReadingAdtsHeaderState();
                parsableByteArray.setPosition(i);
                return;
            }
        }
        parsableByteArray.setPosition(position);
    }

    private void parseId3Header() {
        this.id3Output.sampleData(this.id3HeaderBuffer, 10);
        this.id3HeaderBuffer.setPosition(6);
        setReadingSampleState(this.id3Output, 0, 10, this.id3HeaderBuffer.readSynchSafeInt() + 10);
    }

    private void parseAdtsHeader() throws ParserException {
        this.adtsScratch.setPosition(0);
        if (!this.hasOutputFormat) {
            int readBits = this.adtsScratch.readBits(2) + 1;
            if (readBits != 2) {
                Log.w(TAG, "Detected audio object type: " + readBits + ", but assuming AAC LC.");
                readBits = 2;
            }
            int readBits2 = this.adtsScratch.readBits(4);
            this.adtsScratch.skipBits(1);
            byte[] buildAacAudioSpecificConfig = CodecSpecificDataUtil.buildAacAudioSpecificConfig(readBits, readBits2, this.adtsScratch.readBits(3));
            Pair<Integer, Integer> parseAacAudioSpecificConfig = CodecSpecificDataUtil.parseAacAudioSpecificConfig(buildAacAudioSpecificConfig);
            Format createAudioSampleFormat = Format.createAudioSampleFormat(this.formatId, MimeTypes.AUDIO_AAC, (String) null, -1, -1, ((Integer) parseAacAudioSpecificConfig.second).intValue(), ((Integer) parseAacAudioSpecificConfig.first).intValue(), Collections.singletonList(buildAacAudioSpecificConfig), (DrmInitData) null, 0, this.language);
            this.sampleDurationUs = 1024000000 / ((long) createAudioSampleFormat.sampleRate);
            this.output.format(createAudioSampleFormat);
            this.hasOutputFormat = true;
        } else {
            this.adtsScratch.skipBits(10);
        }
        this.adtsScratch.skipBits(4);
        int readBits3 = (this.adtsScratch.readBits(13) - 2) - 5;
        if (this.hasCrc) {
            readBits3 -= 2;
        }
        setReadingSampleState(this.output, this.sampleDurationUs, 0, readBits3);
    }

    private void readSample(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
        this.currentOutput.sampleData(parsableByteArray, min);
        this.bytesRead += min;
        int i = this.bytesRead;
        int i2 = this.sampleSize;
        if (i == i2) {
            this.currentOutput.sampleMetadata(this.timeUs, 1, i2, 0, (TrackOutput.CryptoData) null);
            this.timeUs += this.currentSampleDuration;
            setFindingSampleState();
        }
    }
}
