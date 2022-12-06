package com.mbridge.msdk.playercommon.exoplayer2.text.cea;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;
import com.mbridge.msdk.playercommon.exoplayer2.text.Subtitle;
import com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleDecoderException;
import com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleOutputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;

public final class Cea708Decoder extends CeaDecoder {
    private static final int CC_VALID_FLAG = 4;
    private static final int CHARACTER_BIG_CARONS = 42;
    private static final int CHARACTER_BIG_OE = 44;
    private static final int CHARACTER_BOLD_BULLET = 53;
    private static final int CHARACTER_CLOSE_DOUBLE_QUOTE = 52;
    private static final int CHARACTER_CLOSE_SINGLE_QUOTE = 50;
    private static final int CHARACTER_DIAERESIS_Y = 63;
    private static final int CHARACTER_ELLIPSIS = 37;
    private static final int CHARACTER_FIVE_EIGHTHS = 120;
    private static final int CHARACTER_HORIZONTAL_BORDER = 125;
    private static final int CHARACTER_LOWER_LEFT_BORDER = 124;
    private static final int CHARACTER_LOWER_RIGHT_BORDER = 126;
    private static final int CHARACTER_MN = 127;
    private static final int CHARACTER_NBTSP = 33;
    private static final int CHARACTER_ONE_EIGHTH = 118;
    private static final int CHARACTER_OPEN_DOUBLE_QUOTE = 51;
    private static final int CHARACTER_OPEN_SINGLE_QUOTE = 49;
    private static final int CHARACTER_SEVEN_EIGHTHS = 121;
    private static final int CHARACTER_SM = 61;
    private static final int CHARACTER_SMALL_CARONS = 58;
    private static final int CHARACTER_SMALL_OE = 60;
    private static final int CHARACTER_SOLID_BLOCK = 48;
    private static final int CHARACTER_THREE_EIGHTHS = 119;
    private static final int CHARACTER_TM = 57;
    private static final int CHARACTER_TSP = 32;
    private static final int CHARACTER_UPPER_LEFT_BORDER = 127;
    private static final int CHARACTER_UPPER_RIGHT_BORDER = 123;
    private static final int CHARACTER_VERTICAL_BORDER = 122;
    private static final int COMMAND_BS = 8;
    private static final int COMMAND_CLW = 136;
    private static final int COMMAND_CR = 13;
    private static final int COMMAND_CW0 = 128;
    private static final int COMMAND_CW1 = 129;
    private static final int COMMAND_CW2 = 130;
    private static final int COMMAND_CW3 = 131;
    private static final int COMMAND_CW4 = 132;
    private static final int COMMAND_CW5 = 133;
    private static final int COMMAND_CW6 = 134;
    private static final int COMMAND_CW7 = 135;
    private static final int COMMAND_DF0 = 152;
    private static final int COMMAND_DF1 = 153;
    private static final int COMMAND_DF2 = 154;
    private static final int COMMAND_DF3 = 155;
    private static final int COMMAND_DF4 = 156;
    private static final int COMMAND_DF5 = 157;
    private static final int COMMAND_DF6 = 158;
    private static final int COMMAND_DF7 = 159;
    private static final int COMMAND_DLC = 142;
    private static final int COMMAND_DLW = 140;
    private static final int COMMAND_DLY = 141;
    private static final int COMMAND_DSW = 137;
    private static final int COMMAND_ETX = 3;
    private static final int COMMAND_EXT1 = 16;
    private static final int COMMAND_EXT1_END = 23;
    private static final int COMMAND_EXT1_START = 17;
    private static final int COMMAND_FF = 12;
    private static final int COMMAND_HCR = 14;
    private static final int COMMAND_HDW = 138;
    private static final int COMMAND_NUL = 0;
    private static final int COMMAND_P16_END = 31;
    private static final int COMMAND_P16_START = 24;
    private static final int COMMAND_RST = 143;
    private static final int COMMAND_SPA = 144;
    private static final int COMMAND_SPC = 145;
    private static final int COMMAND_SPL = 146;
    private static final int COMMAND_SWA = 151;
    private static final int COMMAND_TGW = 139;
    private static final int DTVCC_PACKET_DATA = 2;
    private static final int DTVCC_PACKET_START = 3;
    private static final int GROUP_C0_END = 31;
    private static final int GROUP_C1_END = 159;
    private static final int GROUP_C2_END = 31;
    private static final int GROUP_C3_END = 159;
    private static final int GROUP_G0_END = 127;
    private static final int GROUP_G1_END = 255;
    private static final int GROUP_G2_END = 127;
    private static final int GROUP_G3_END = 255;
    private static final int NUM_WINDOWS = 8;
    private static final String TAG = "Cea708Decoder";
    private final ParsableByteArray ccData = new ParsableByteArray();
    private final CueBuilder[] cueBuilders;
    private List<Cue> cues;
    private CueBuilder currentCueBuilder;
    private DtvCcPacket currentDtvCcPacket;
    private int currentWindow;
    private List<Cue> lastCues;
    private final int selectedServiceNumber;
    private final ParsableBitArray serviceBlockPacket = new ParsableBitArray();

    public final String getName() {
        return TAG;
    }

    public final /* bridge */ /* synthetic */ SubtitleInputBuffer dequeueInputBuffer() throws SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    public final /* bridge */ /* synthetic */ SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        return super.dequeueOutputBuffer();
    }

    public final /* bridge */ /* synthetic */ void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        super.queueInputBuffer(subtitleInputBuffer);
    }

    public final /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    public final /* bridge */ /* synthetic */ void setPositionUs(long j) {
        super.setPositionUs(j);
    }

    public Cea708Decoder(int i) {
        this.selectedServiceNumber = i == -1 ? 1 : i;
        this.cueBuilders = new CueBuilder[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.cueBuilders[i2] = new CueBuilder();
        }
        this.currentCueBuilder = this.cueBuilders[0];
        resetCueBuilders();
    }

    public final void flush() {
        super.flush();
        this.cues = null;
        this.lastCues = null;
        this.currentWindow = 0;
        this.currentCueBuilder = this.cueBuilders[this.currentWindow];
        resetCueBuilders();
        this.currentDtvCcPacket = null;
    }

    /* access modifiers changed from: protected */
    public final boolean isNewSubtitleDataAvailable() {
        return this.cues != this.lastCues;
    }

    /* access modifiers changed from: protected */
    public final Subtitle createSubtitle() {
        List<Cue> list = this.cues;
        this.lastCues = list;
        return new CeaSubtitle(list);
    }

    /* access modifiers changed from: protected */
    public final void decode(SubtitleInputBuffer subtitleInputBuffer) {
        this.ccData.reset(subtitleInputBuffer.data.array(), subtitleInputBuffer.data.limit());
        while (this.ccData.bytesLeft() >= 3) {
            int readUnsignedByte = this.ccData.readUnsignedByte() & 7;
            int i = readUnsignedByte & 3;
            boolean z = false;
            boolean z2 = (readUnsignedByte & 4) == 4;
            byte readUnsignedByte2 = (byte) this.ccData.readUnsignedByte();
            byte readUnsignedByte3 = (byte) this.ccData.readUnsignedByte();
            if ((i == 2 || i == 3) && z2) {
                if (i == 3) {
                    finalizeCurrentPacket();
                    int i2 = (readUnsignedByte2 & 192) >> 6;
                    byte b = readUnsignedByte2 & 63;
                    if (b == 0) {
                        b = 64;
                    }
                    this.currentDtvCcPacket = new DtvCcPacket(i2, b);
                    byte[] bArr = this.currentDtvCcPacket.packetData;
                    DtvCcPacket dtvCcPacket = this.currentDtvCcPacket;
                    int i3 = dtvCcPacket.currentIndex;
                    dtvCcPacket.currentIndex = i3 + 1;
                    bArr[i3] = readUnsignedByte3;
                } else {
                    if (i == 2) {
                        z = true;
                    }
                    Assertions.checkArgument(z);
                    DtvCcPacket dtvCcPacket2 = this.currentDtvCcPacket;
                    if (dtvCcPacket2 == null) {
                        Log.e(TAG, "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                    } else {
                        byte[] bArr2 = dtvCcPacket2.packetData;
                        DtvCcPacket dtvCcPacket3 = this.currentDtvCcPacket;
                        int i4 = dtvCcPacket3.currentIndex;
                        dtvCcPacket3.currentIndex = i4 + 1;
                        bArr2[i4] = readUnsignedByte2;
                        byte[] bArr3 = this.currentDtvCcPacket.packetData;
                        DtvCcPacket dtvCcPacket4 = this.currentDtvCcPacket;
                        int i5 = dtvCcPacket4.currentIndex;
                        dtvCcPacket4.currentIndex = i5 + 1;
                        bArr3[i5] = readUnsignedByte3;
                    }
                }
                if (this.currentDtvCcPacket.currentIndex == (this.currentDtvCcPacket.packetSize * 2) - 1) {
                    finalizeCurrentPacket();
                }
            }
        }
    }

    private void finalizeCurrentPacket() {
        if (this.currentDtvCcPacket != null) {
            processCurrentPacket();
            this.currentDtvCcPacket = null;
        }
    }

    private void processCurrentPacket() {
        if (this.currentDtvCcPacket.currentIndex != (this.currentDtvCcPacket.packetSize * 2) - 1) {
            Log.w(TAG, "DtvCcPacket ended prematurely; size is " + ((this.currentDtvCcPacket.packetSize * 2) - 1) + ", but current index is " + this.currentDtvCcPacket.currentIndex + " (sequence number " + this.currentDtvCcPacket.sequenceNumber + "); ignoring packet");
            return;
        }
        this.serviceBlockPacket.reset(this.currentDtvCcPacket.packetData, this.currentDtvCcPacket.currentIndex);
        int readBits = this.serviceBlockPacket.readBits(3);
        int readBits2 = this.serviceBlockPacket.readBits(5);
        if (readBits == 7) {
            this.serviceBlockPacket.skipBits(2);
            readBits += this.serviceBlockPacket.readBits(6);
        }
        if (readBits2 == 0) {
            if (readBits != 0) {
                Log.w(TAG, "serviceNumber is non-zero (" + readBits + ") when blockSize is 0");
            }
        } else if (readBits == this.selectedServiceNumber) {
            boolean z = false;
            while (this.serviceBlockPacket.bitsLeft() > 0) {
                int readBits3 = this.serviceBlockPacket.readBits(8);
                if (readBits3 == 16) {
                    int readBits4 = this.serviceBlockPacket.readBits(8);
                    if (readBits4 <= 31) {
                        handleC2Command(readBits4);
                    } else if (readBits4 <= 127) {
                        handleG2Character(readBits4);
                    } else if (readBits4 <= 159) {
                        handleC3Command(readBits4);
                    } else if (readBits4 <= 255) {
                        handleG3Character(readBits4);
                    } else {
                        Log.w(TAG, "Invalid extended command: " + readBits4);
                    }
                } else if (readBits3 <= 31) {
                    handleC0Command(readBits3);
                } else if (readBits3 <= 127) {
                    handleG0Character(readBits3);
                } else if (readBits3 <= 159) {
                    handleC1Command(readBits3);
                } else if (readBits3 <= 255) {
                    handleG1Character(readBits3);
                } else {
                    Log.w(TAG, "Invalid base command: " + readBits3);
                }
                z = true;
            }
            if (z) {
                this.cues = getDisplayCues();
            }
        }
    }

    private void handleC0Command(int i) {
        if (i == 0) {
            return;
        }
        if (i == 3) {
            this.cues = getDisplayCues();
        } else if (i != 8) {
            switch (i) {
                case 12:
                    resetCueBuilders();
                    return;
                case 13:
                    this.currentCueBuilder.append(10);
                    return;
                case 14:
                    return;
                default:
                    if (i >= 17 && i <= 23) {
                        Log.w(TAG, "Currently unsupported COMMAND_EXT1 Command: " + i);
                        this.serviceBlockPacket.skipBits(8);
                        return;
                    } else if (i < 24 || i > 31) {
                        Log.w(TAG, "Invalid C0 command: " + i);
                        return;
                    } else {
                        Log.w(TAG, "Currently unsupported COMMAND_P16 Command: " + i);
                        this.serviceBlockPacket.skipBits(16);
                        return;
                    }
            }
        } else {
            this.currentCueBuilder.backspace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0093, code lost:
        if (r2 > 8) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009b, code lost:
        if (r4.serviceBlockPacket.readBit() == false) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009d, code lost:
        r4.cueBuilders[8 - r2].reset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a6, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c5, code lost:
        if (r2 > 8) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cd, code lost:
        if (r4.serviceBlockPacket.readBit() == false) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cf, code lost:
        r4.cueBuilders[8 - r2].setVisibility(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d9, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f3, code lost:
        if (r2 > 8) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00fb, code lost:
        if (r4.serviceBlockPacket.readBit() == false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fd, code lost:
        r4.cueBuilders[8 - r2].clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0106, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleC1Command(int r5) {
        /*
            r4 = this;
            r0 = 16
            r1 = 8
            r2 = 1
            switch(r5) {
                case 128: goto L_0x0109;
                case 129: goto L_0x0109;
                case 130: goto L_0x0109;
                case 131: goto L_0x0109;
                case 132: goto L_0x0109;
                case 133: goto L_0x0109;
                case 134: goto L_0x0109;
                case 135: goto L_0x0109;
                case 136: goto L_0x00f3;
                case 137: goto L_0x00dc;
                case 138: goto L_0x00c5;
                case 139: goto L_0x00a9;
                case 140: goto L_0x0093;
                case 141: goto L_0x008c;
                case 142: goto L_0x0117;
                case 143: goto L_0x0087;
                case 144: goto L_0x0073;
                case 145: goto L_0x005d;
                case 146: goto L_0x0049;
                case 147: goto L_0x0008;
                case 148: goto L_0x0008;
                case 149: goto L_0x0008;
                case 150: goto L_0x0008;
                case 151: goto L_0x0033;
                case 152: goto L_0x0020;
                case 153: goto L_0x0020;
                case 154: goto L_0x0020;
                case 155: goto L_0x0020;
                case 156: goto L_0x0020;
                case 157: goto L_0x0020;
                case 158: goto L_0x0020;
                case 159: goto L_0x0020;
                default: goto L_0x0008;
            }
        L_0x0008:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid C1 command: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "Cea708Decoder"
            android.util.Log.w(r0, r5)
            goto L_0x0117
        L_0x0020:
            int r5 = r5 + -152
            r4.handleDefineWindow(r5)
            int r0 = r4.currentWindow
            if (r0 == r5) goto L_0x0117
            r4.currentWindow = r5
            com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder$CueBuilder[] r0 = r4.cueBuilders
            r5 = r0[r5]
            r4.currentCueBuilder = r5
            goto L_0x0117
        L_0x0033:
            com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder$CueBuilder r5 = r4.currentCueBuilder
            boolean r5 = r5.isDefined()
            if (r5 != 0) goto L_0x0044
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r5 = r4.serviceBlockPacket
            r0 = 32
            r5.skipBits(r0)
            goto L_0x0117
        L_0x0044:
            r4.handleSetWindowAttributes()
            goto L_0x0117
        L_0x0049:
            com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder$CueBuilder r5 = r4.currentCueBuilder
            boolean r5 = r5.isDefined()
            if (r5 != 0) goto L_0x0058
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r5 = r4.serviceBlockPacket
            r5.skipBits(r0)
            goto L_0x0117
        L_0x0058:
            r4.handleSetPenLocation()
            goto L_0x0117
        L_0x005d:
            com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder$CueBuilder r5 = r4.currentCueBuilder
            boolean r5 = r5.isDefined()
            if (r5 != 0) goto L_0x006e
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r5 = r4.serviceBlockPacket
            r0 = 24
            r5.skipBits(r0)
            goto L_0x0117
        L_0x006e:
            r4.handleSetPenColor()
            goto L_0x0117
        L_0x0073:
            com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder$CueBuilder r5 = r4.currentCueBuilder
            boolean r5 = r5.isDefined()
            if (r5 != 0) goto L_0x0082
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r5 = r4.serviceBlockPacket
            r5.skipBits(r0)
            goto L_0x0117
        L_0x0082:
            r4.handleSetPenAttributes()
            goto L_0x0117
        L_0x0087:
            r4.resetCueBuilders()
            goto L_0x0117
        L_0x008c:
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r5 = r4.serviceBlockPacket
            r5.skipBits(r1)
            goto L_0x0117
        L_0x0093:
            if (r2 > r1) goto L_0x0117
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r5 = r4.serviceBlockPacket
            boolean r5 = r5.readBit()
            if (r5 == 0) goto L_0x00a6
            com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder$CueBuilder[] r5 = r4.cueBuilders
            int r0 = 8 - r2
            r5 = r5[r0]
            r5.reset()
        L_0x00a6:
            int r2 = r2 + 1
            goto L_0x0093
        L_0x00a9:
            r5 = r2
        L_0x00aa:
            if (r5 > r1) goto L_0x0117
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r0 = r4.serviceBlockPacket
            boolean r0 = r0.readBit()
            if (r0 == 0) goto L_0x00c2
            com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder$CueBuilder[] r0 = r4.cueBuilders
            int r3 = 8 - r5
            r0 = r0[r3]
            boolean r3 = r0.isVisible()
            r3 = r3 ^ r2
            r0.setVisibility(r3)
        L_0x00c2:
            int r5 = r5 + 1
            goto L_0x00aa
        L_0x00c5:
            if (r2 > r1) goto L_0x0117
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r5 = r4.serviceBlockPacket
            boolean r5 = r5.readBit()
            if (r5 == 0) goto L_0x00d9
            com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder$CueBuilder[] r5 = r4.cueBuilders
            int r0 = 8 - r2
            r5 = r5[r0]
            r0 = 0
            r5.setVisibility(r0)
        L_0x00d9:
            int r2 = r2 + 1
            goto L_0x00c5
        L_0x00dc:
            r5 = r2
        L_0x00dd:
            if (r5 > r1) goto L_0x0117
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r0 = r4.serviceBlockPacket
            boolean r0 = r0.readBit()
            if (r0 == 0) goto L_0x00f0
            com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder$CueBuilder[] r0 = r4.cueBuilders
            int r3 = 8 - r5
            r0 = r0[r3]
            r0.setVisibility(r2)
        L_0x00f0:
            int r5 = r5 + 1
            goto L_0x00dd
        L_0x00f3:
            if (r2 > r1) goto L_0x0117
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r5 = r4.serviceBlockPacket
            boolean r5 = r5.readBit()
            if (r5 == 0) goto L_0x0106
            com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder$CueBuilder[] r5 = r4.cueBuilders
            int r0 = 8 - r2
            r5 = r5[r0]
            r5.clear()
        L_0x0106:
            int r2 = r2 + 1
            goto L_0x00f3
        L_0x0109:
            int r5 = r5 + -128
            int r0 = r4.currentWindow
            if (r0 == r5) goto L_0x0117
            r4.currentWindow = r5
            com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder$CueBuilder[] r0 = r4.cueBuilders
            r5 = r0[r5]
            r4.currentCueBuilder = r5
        L_0x0117:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder.handleC1Command(int):void");
    }

    private void handleC2Command(int i) {
        if (i > 7) {
            if (i <= 15) {
                this.serviceBlockPacket.skipBits(8);
            } else if (i <= 23) {
                this.serviceBlockPacket.skipBits(16);
            } else if (i <= 31) {
                this.serviceBlockPacket.skipBits(24);
            }
        }
    }

    private void handleC3Command(int i) {
        if (i <= 135) {
            this.serviceBlockPacket.skipBits(32);
        } else if (i <= COMMAND_RST) {
            this.serviceBlockPacket.skipBits(40);
        } else if (i <= 159) {
            this.serviceBlockPacket.skipBits(2);
            this.serviceBlockPacket.skipBits(this.serviceBlockPacket.readBits(6) * 8);
        }
    }

    private void handleG0Character(int i) {
        if (i == 127) {
            this.currentCueBuilder.append(9835);
        } else {
            this.currentCueBuilder.append((char) (i & 255));
        }
    }

    private void handleG1Character(int i) {
        this.currentCueBuilder.append((char) (i & 255));
    }

    private void handleG2Character(int i) {
        if (i == 32) {
            this.currentCueBuilder.append(' ');
        } else if (i == 33) {
            this.currentCueBuilder.append(Typography.nbsp);
        } else if (i == 37) {
            this.currentCueBuilder.append(Typography.ellipsis);
        } else if (i == 42) {
            this.currentCueBuilder.append(352);
        } else if (i == 44) {
            this.currentCueBuilder.append(338);
        } else if (i == 63) {
            this.currentCueBuilder.append(376);
        } else if (i == 57) {
            this.currentCueBuilder.append(Typography.tm);
        } else if (i == 58) {
            this.currentCueBuilder.append(353);
        } else if (i == 60) {
            this.currentCueBuilder.append(339);
        } else if (i != 61) {
            switch (i) {
                case 48:
                    this.currentCueBuilder.append(9608);
                    return;
                case 49:
                    this.currentCueBuilder.append(Typography.leftSingleQuote);
                    return;
                case 50:
                    this.currentCueBuilder.append(Typography.rightSingleQuote);
                    return;
                case 51:
                    this.currentCueBuilder.append(Typography.leftDoubleQuote);
                    return;
                case 52:
                    this.currentCueBuilder.append(Typography.rightDoubleQuote);
                    return;
                case 53:
                    this.currentCueBuilder.append(Typography.bullet);
                    return;
                default:
                    switch (i) {
                        case 118:
                            this.currentCueBuilder.append(8539);
                            return;
                        case 119:
                            this.currentCueBuilder.append(8540);
                            return;
                        case 120:
                            this.currentCueBuilder.append(8541);
                            return;
                        case 121:
                            this.currentCueBuilder.append(8542);
                            return;
                        case 122:
                            this.currentCueBuilder.append(9474);
                            return;
                        case 123:
                            this.currentCueBuilder.append(9488);
                            return;
                        case 124:
                            this.currentCueBuilder.append(9492);
                            return;
                        case CHARACTER_HORIZONTAL_BORDER /*125*/:
                            this.currentCueBuilder.append(9472);
                            return;
                        case CHARACTER_LOWER_RIGHT_BORDER /*126*/:
                            this.currentCueBuilder.append(9496);
                            return;
                        case 127:
                            this.currentCueBuilder.append(9484);
                            return;
                        default:
                            Log.w(TAG, "Invalid G2 character: " + i);
                            return;
                    }
            }
        } else {
            this.currentCueBuilder.append(8480);
        }
    }

    private void handleG3Character(int i) {
        if (i == 160) {
            this.currentCueBuilder.append(13252);
            return;
        }
        Log.w(TAG, "Invalid G3 character: " + i);
        this.currentCueBuilder.append('_');
    }

    private void handleSetPenAttributes() {
        this.currentCueBuilder.setPenAttributes(this.serviceBlockPacket.readBits(4), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBit(), this.serviceBlockPacket.readBit(), this.serviceBlockPacket.readBits(3), this.serviceBlockPacket.readBits(3));
    }

    private void handleSetPenColor() {
        int argbColorFromCeaColor = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
        int argbColorFromCeaColor2 = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
        this.serviceBlockPacket.skipBits(2);
        this.currentCueBuilder.setPenColor(argbColorFromCeaColor, argbColorFromCeaColor2, CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2)));
    }

    private void handleSetPenLocation() {
        this.serviceBlockPacket.skipBits(4);
        int readBits = this.serviceBlockPacket.readBits(4);
        this.serviceBlockPacket.skipBits(2);
        this.currentCueBuilder.setPenLocation(readBits, this.serviceBlockPacket.readBits(6));
    }

    private void handleSetWindowAttributes() {
        int argbColorFromCeaColor = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
        int readBits = this.serviceBlockPacket.readBits(2);
        int argbColorFromCeaColor2 = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
        if (this.serviceBlockPacket.readBit()) {
            readBits |= 4;
        }
        boolean readBit = this.serviceBlockPacket.readBit();
        int readBits2 = this.serviceBlockPacket.readBits(2);
        int readBits3 = this.serviceBlockPacket.readBits(2);
        int readBits4 = this.serviceBlockPacket.readBits(2);
        this.serviceBlockPacket.skipBits(8);
        this.currentCueBuilder.setWindowAttributes(argbColorFromCeaColor, argbColorFromCeaColor2, readBit, readBits, readBits2, readBits3, readBits4);
    }

    private void handleDefineWindow(int i) {
        CueBuilder cueBuilder = this.cueBuilders[i];
        this.serviceBlockPacket.skipBits(2);
        boolean readBit = this.serviceBlockPacket.readBit();
        boolean readBit2 = this.serviceBlockPacket.readBit();
        boolean readBit3 = this.serviceBlockPacket.readBit();
        int readBits = this.serviceBlockPacket.readBits(3);
        boolean readBit4 = this.serviceBlockPacket.readBit();
        int readBits2 = this.serviceBlockPacket.readBits(7);
        int readBits3 = this.serviceBlockPacket.readBits(8);
        int readBits4 = this.serviceBlockPacket.readBits(4);
        int readBits5 = this.serviceBlockPacket.readBits(4);
        this.serviceBlockPacket.skipBits(2);
        int readBits6 = this.serviceBlockPacket.readBits(6);
        this.serviceBlockPacket.skipBits(2);
        cueBuilder.defineWindow(readBit, readBit2, readBit3, readBits, readBit4, readBits2, readBits3, readBits5, readBits6, readBits4, this.serviceBlockPacket.readBits(3), this.serviceBlockPacket.readBits(3));
    }

    private List<Cue> getDisplayCues() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            if (!this.cueBuilders[i].isEmpty() && this.cueBuilders[i].isVisible()) {
                arrayList.add(this.cueBuilders[i].build());
            }
        }
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    private void resetCueBuilders() {
        for (int i = 0; i < 8; i++) {
            this.cueBuilders[i].reset();
        }
    }

    private static final class DtvCcPacket {
        int currentIndex = 0;
        public final byte[] packetData;
        public final int packetSize;
        public final int sequenceNumber;

        public DtvCcPacket(int i, int i2) {
            this.sequenceNumber = i;
            this.packetSize = i2;
            this.packetData = new byte[((i2 * 2) - 1)];
        }
    }

    private static final class CueBuilder {
        private static final int BORDER_AND_EDGE_TYPE_NONE = 0;
        private static final int BORDER_AND_EDGE_TYPE_UNIFORM = 3;
        public static final int COLOR_SOLID_BLACK = getArgbColorFromCeaColor(0, 0, 0, 0);
        public static final int COLOR_SOLID_WHITE = getArgbColorFromCeaColor(2, 2, 2, 0);
        public static final int COLOR_TRANSPARENT = getArgbColorFromCeaColor(0, 0, 0, 3);
        private static final int DEFAULT_PRIORITY = 4;
        private static final int DIRECTION_BOTTOM_TO_TOP = 3;
        private static final int DIRECTION_LEFT_TO_RIGHT = 0;
        private static final int DIRECTION_RIGHT_TO_LEFT = 1;
        private static final int DIRECTION_TOP_TO_BOTTOM = 2;
        private static final int HORIZONTAL_SIZE = 209;
        private static final int JUSTIFICATION_CENTER = 2;
        private static final int JUSTIFICATION_FULL = 3;
        private static final int JUSTIFICATION_LEFT = 0;
        private static final int JUSTIFICATION_RIGHT = 1;
        private static final int MAXIMUM_ROW_COUNT = 15;
        private static final int PEN_FONT_STYLE_DEFAULT = 0;
        private static final int PEN_FONT_STYLE_MONOSPACED_WITHOUT_SERIFS = 3;
        private static final int PEN_FONT_STYLE_MONOSPACED_WITH_SERIFS = 1;
        private static final int PEN_FONT_STYLE_PROPORTIONALLY_SPACED_WITHOUT_SERIFS = 4;
        private static final int PEN_FONT_STYLE_PROPORTIONALLY_SPACED_WITH_SERIFS = 2;
        private static final int PEN_OFFSET_NORMAL = 1;
        private static final int PEN_SIZE_STANDARD = 1;
        private static final int[] PEN_STYLE_BACKGROUND;
        private static final int[] PEN_STYLE_EDGE_TYPE = {0, 0, 0, 0, 0, 3, 3};
        private static final int[] PEN_STYLE_FONT_STYLE = {0, 1, 2, 3, 4, 3, 4};
        private static final int RELATIVE_CUE_SIZE = 99;
        private static final int VERTICAL_SIZE = 74;
        private static final int[] WINDOW_STYLE_FILL;
        private static final int[] WINDOW_STYLE_JUSTIFICATION = {0, 0, 0, 0, 0, 2, 0};
        private static final int[] WINDOW_STYLE_PRINT_DIRECTION = {0, 0, 0, 0, 0, 0, 2};
        private static final int[] WINDOW_STYLE_SCROLL_DIRECTION = {3, 3, 3, 3, 3, 3, 1};
        private static final boolean[] WINDOW_STYLE_WORD_WRAP = {false, false, false, true, true, true, false};
        private int anchorId;
        private int backgroundColor;
        private int backgroundColorStartPosition;
        private final SpannableStringBuilder captionStringBuilder = new SpannableStringBuilder();
        private boolean defined;
        private int foregroundColor;
        private int foregroundColorStartPosition;
        private int horizontalAnchor;
        private int italicsStartPosition;
        private int justification;
        private int penStyleId;
        private int priority;
        private boolean relativePositioning;
        private final List<SpannableString> rolledUpCaptions = new ArrayList();
        private int row;
        private int rowCount;
        private boolean rowLock;
        private int underlineStartPosition;
        private int verticalAnchor;
        private boolean visible;
        private int windowFillColor;
        private int windowStyleId;

        static {
            int i = COLOR_SOLID_BLACK;
            int i2 = COLOR_TRANSPARENT;
            WINDOW_STYLE_FILL = new int[]{i, i2, i, i, i2, i, i};
            PEN_STYLE_BACKGROUND = new int[]{i, i, i, i, i, i2, i2};
        }

        public CueBuilder() {
            reset();
        }

        public final boolean isEmpty() {
            return !isDefined() || (this.rolledUpCaptions.isEmpty() && this.captionStringBuilder.length() == 0);
        }

        public final void reset() {
            clear();
            this.defined = false;
            this.visible = false;
            this.priority = 4;
            this.relativePositioning = false;
            this.verticalAnchor = 0;
            this.horizontalAnchor = 0;
            this.anchorId = 0;
            this.rowCount = 15;
            this.rowLock = true;
            this.justification = 0;
            this.windowStyleId = 0;
            this.penStyleId = 0;
            int i = COLOR_SOLID_BLACK;
            this.windowFillColor = i;
            this.foregroundColor = COLOR_SOLID_WHITE;
            this.backgroundColor = i;
        }

        public final void clear() {
            this.rolledUpCaptions.clear();
            this.captionStringBuilder.clear();
            this.italicsStartPosition = -1;
            this.underlineStartPosition = -1;
            this.foregroundColorStartPosition = -1;
            this.backgroundColorStartPosition = -1;
            this.row = 0;
        }

        public final boolean isDefined() {
            return this.defined;
        }

        public final void setVisibility(boolean z) {
            this.visible = z;
        }

        public final boolean isVisible() {
            return this.visible;
        }

        public final void defineWindow(boolean z, boolean z2, boolean z3, int i, boolean z4, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            boolean z5 = z2;
            int i9 = i7;
            int i10 = i8;
            this.defined = true;
            this.visible = z;
            this.rowLock = z5;
            this.priority = i;
            this.relativePositioning = z4;
            this.verticalAnchor = i2;
            this.horizontalAnchor = i3;
            this.anchorId = i6;
            int i11 = i4 + 1;
            if (this.rowCount != i11) {
                this.rowCount = i11;
                while (true) {
                    if ((!z5 || this.rolledUpCaptions.size() < this.rowCount) && this.rolledUpCaptions.size() < 15) {
                        break;
                    }
                    this.rolledUpCaptions.remove(0);
                }
            }
            if (!(i9 == 0 || this.windowStyleId == i9)) {
                this.windowStyleId = i9;
                int i12 = i9 - 1;
                setWindowAttributes(WINDOW_STYLE_FILL[i12], COLOR_TRANSPARENT, WINDOW_STYLE_WORD_WRAP[i12], 0, WINDOW_STYLE_PRINT_DIRECTION[i12], WINDOW_STYLE_SCROLL_DIRECTION[i12], WINDOW_STYLE_JUSTIFICATION[i12]);
            }
            if (i10 != 0 && this.penStyleId != i10) {
                this.penStyleId = i10;
                int i13 = i10 - 1;
                setPenAttributes(0, 1, 1, false, false, PEN_STYLE_EDGE_TYPE[i13], PEN_STYLE_FONT_STYLE[i13]);
                setPenColor(COLOR_SOLID_WHITE, PEN_STYLE_BACKGROUND[i13], COLOR_SOLID_BLACK);
            }
        }

        public final void setWindowAttributes(int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
            this.windowFillColor = i;
            this.justification = i6;
        }

        public final void setPenAttributes(int i, int i2, int i3, boolean z, boolean z2, int i4, int i5) {
            if (this.italicsStartPosition != -1) {
                if (!z) {
                    this.captionStringBuilder.setSpan(new StyleSpan(2), this.italicsStartPosition, this.captionStringBuilder.length(), 33);
                    this.italicsStartPosition = -1;
                }
            } else if (z) {
                this.italicsStartPosition = this.captionStringBuilder.length();
            }
            if (this.underlineStartPosition != -1) {
                if (!z2) {
                    this.captionStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, this.captionStringBuilder.length(), 33);
                    this.underlineStartPosition = -1;
                }
            } else if (z2) {
                this.underlineStartPosition = this.captionStringBuilder.length();
            }
        }

        public final void setPenColor(int i, int i2, int i3) {
            int i4;
            int i5;
            if (!(this.foregroundColorStartPosition == -1 || (i5 = this.foregroundColor) == i)) {
                this.captionStringBuilder.setSpan(new ForegroundColorSpan(i5), this.foregroundColorStartPosition, this.captionStringBuilder.length(), 33);
            }
            if (i != COLOR_SOLID_WHITE) {
                this.foregroundColorStartPosition = this.captionStringBuilder.length();
                this.foregroundColor = i;
            }
            if (!(this.backgroundColorStartPosition == -1 || (i4 = this.backgroundColor) == i2)) {
                this.captionStringBuilder.setSpan(new BackgroundColorSpan(i4), this.backgroundColorStartPosition, this.captionStringBuilder.length(), 33);
            }
            if (i2 != COLOR_SOLID_BLACK) {
                this.backgroundColorStartPosition = this.captionStringBuilder.length();
                this.backgroundColor = i2;
            }
        }

        public final void setPenLocation(int i, int i2) {
            if (this.row != i) {
                append(10);
            }
            this.row = i;
        }

        public final void backspace() {
            int length = this.captionStringBuilder.length();
            if (length > 0) {
                this.captionStringBuilder.delete(length - 1, length);
            }
        }

        public final void append(char c) {
            if (c == 10) {
                this.rolledUpCaptions.add(buildSpannableString());
                this.captionStringBuilder.clear();
                if (this.italicsStartPosition != -1) {
                    this.italicsStartPosition = 0;
                }
                if (this.underlineStartPosition != -1) {
                    this.underlineStartPosition = 0;
                }
                if (this.foregroundColorStartPosition != -1) {
                    this.foregroundColorStartPosition = 0;
                }
                if (this.backgroundColorStartPosition != -1) {
                    this.backgroundColorStartPosition = 0;
                }
                while (true) {
                    if ((this.rowLock && this.rolledUpCaptions.size() >= this.rowCount) || this.rolledUpCaptions.size() >= 15) {
                        this.rolledUpCaptions.remove(0);
                    } else {
                        return;
                    }
                }
            } else {
                this.captionStringBuilder.append(c);
            }
        }

        public final SpannableString buildSpannableString() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.captionStringBuilder);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.italicsStartPosition != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.italicsStartPosition, length, 33);
                }
                if (this.underlineStartPosition != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, length, 33);
                }
                if (this.foregroundColorStartPosition != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.foregroundColorStartPosition, length, 33);
                }
                if (this.backgroundColorStartPosition != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.backgroundColorStartPosition, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0065  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x008f  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0091  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x009d  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x009f  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00ab  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Cue build() {
            /*
                r15 = this;
                boolean r0 = r15.isEmpty()
                if (r0 == 0) goto L_0x0008
                r0 = 0
                return r0
            L_0x0008:
                android.text.SpannableStringBuilder r2 = new android.text.SpannableStringBuilder
                r2.<init>()
                r0 = 0
                r1 = r0
            L_0x000f:
                java.util.List<android.text.SpannableString> r3 = r15.rolledUpCaptions
                int r3 = r3.size()
                if (r1 >= r3) goto L_0x002a
                java.util.List<android.text.SpannableString> r3 = r15.rolledUpCaptions
                java.lang.Object r3 = r3.get(r1)
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r2.append(r3)
                r3 = 10
                r2.append(r3)
                int r1 = r1 + 1
                goto L_0x000f
            L_0x002a:
                android.text.SpannableString r1 = r15.buildSpannableString()
                r2.append(r1)
                int r1 = r15.justification
                r3 = 2
                r4 = 3
                r5 = 1
                if (r1 == 0) goto L_0x005e
                if (r1 == r5) goto L_0x005b
                if (r1 == r3) goto L_0x0058
                if (r1 != r4) goto L_0x003f
                goto L_0x005e
            L_0x003f:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Unexpected justification value: "
                r1.append(r2)
                int r2 = r15.justification
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0058:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER
                goto L_0x0060
            L_0x005b:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE
                goto L_0x0060
            L_0x005e:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL
            L_0x0060:
                r6 = r1
                boolean r1 = r15.relativePositioning
                if (r1 == 0) goto L_0x0070
                int r1 = r15.horizontalAnchor
                float r1 = (float) r1
                r7 = 1120272384(0x42c60000, float:99.0)
                float r1 = r1 / r7
                int r8 = r15.verticalAnchor
                float r8 = (float) r8
                float r8 = r8 / r7
                goto L_0x007d
            L_0x0070:
                int r1 = r15.horizontalAnchor
                float r1 = (float) r1
                r7 = 1129381888(0x43510000, float:209.0)
                float r1 = r1 / r7
                int r7 = r15.verticalAnchor
                float r7 = (float) r7
                r8 = 1116995584(0x42940000, float:74.0)
                float r8 = r7 / r8
            L_0x007d:
                r7 = 1063675494(0x3f666666, float:0.9)
                float r1 = r1 * r7
                r9 = 1028443341(0x3d4ccccd, float:0.05)
                float r10 = r1 + r9
                float r8 = r8 * r7
                float r7 = r8 + r9
                int r1 = r15.anchorId
                int r8 = r1 % 3
                if (r8 != 0) goto L_0x0091
                r8 = r0
                goto L_0x0097
            L_0x0091:
                int r1 = r1 % r4
                if (r1 != r5) goto L_0x0096
                r8 = r5
                goto L_0x0097
            L_0x0096:
                r8 = r3
            L_0x0097:
                int r1 = r15.anchorId
                int r9 = r1 / 3
                if (r9 != 0) goto L_0x009f
                r9 = r0
                goto L_0x00a5
            L_0x009f:
                int r1 = r1 / r4
                if (r1 != r5) goto L_0x00a4
                r9 = r5
                goto L_0x00a5
            L_0x00a4:
                r9 = r3
            L_0x00a5:
                int r1 = r15.windowFillColor
                int r3 = COLOR_SOLID_BLACK
                if (r1 == r3) goto L_0x00ac
                r0 = r5
            L_0x00ac:
                com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Cue r13 = new com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Cue
                r5 = 0
                r11 = 1
                int r12 = r15.windowFillColor
                int r14 = r15.priority
                r1 = r13
                r3 = r6
                r4 = r7
                r6 = r8
                r7 = r10
                r8 = r9
                r9 = r11
                r10 = r0
                r11 = r12
                r12 = r14
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder.CueBuilder.build():com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Cue");
        }

        public static int getArgbColorFromCeaColor(int i, int i2, int i3) {
            return getArgbColorFromCeaColor(i, i2, i3, 0);
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0023  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0025  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0028  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x002a  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x002d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int getArgbColorFromCeaColor(int r4, int r5, int r6, int r7) {
            /*
                r0 = 4
                r1 = 0
                com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkIndex(r4, r1, r0)
                com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkIndex(r5, r1, r0)
                com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkIndex(r6, r1, r0)
                com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkIndex(r7, r1, r0)
                r0 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L_0x001b
                if (r7 == r0) goto L_0x001b
                r3 = 2
                if (r7 == r3) goto L_0x001f
                r3 = 3
                if (r7 == r3) goto L_0x001d
            L_0x001b:
                r7 = r2
                goto L_0x0021
            L_0x001d:
                r7 = r1
                goto L_0x0021
            L_0x001f:
                r7 = 127(0x7f, float:1.78E-43)
            L_0x0021:
                if (r4 <= r0) goto L_0x0025
                r4 = r2
                goto L_0x0026
            L_0x0025:
                r4 = r1
            L_0x0026:
                if (r5 <= r0) goto L_0x002a
                r5 = r2
                goto L_0x002b
            L_0x002a:
                r5 = r1
            L_0x002b:
                if (r6 <= r0) goto L_0x002e
                r1 = r2
            L_0x002e:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r1)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder.CueBuilder.getArgbColorFromCeaColor(int, int, int, int):int");
        }
    }
}
