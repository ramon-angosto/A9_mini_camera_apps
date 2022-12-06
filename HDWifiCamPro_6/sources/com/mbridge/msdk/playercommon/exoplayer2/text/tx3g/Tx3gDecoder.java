package com.mbridge.msdk.playercommon.exoplayer2.text.tx3g;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;
import com.mbridge.msdk.playercommon.exoplayer2.text.SimpleSubtitleDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.text.Subtitle;
import com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleDecoderException;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.UByte;

public final class Tx3gDecoder extends SimpleSubtitleDecoder {
    private static final char BOM_UTF16_BE = '﻿';
    private static final char BOM_UTF16_LE = '￾';
    private static final int DEFAULT_COLOR = -1;
    private static final int DEFAULT_FONT_FACE = 0;
    private static final String DEFAULT_FONT_FAMILY = "sans-serif";
    private static final float DEFAULT_VERTICAL_PLACEMENT = 0.85f;
    private static final int FONT_FACE_BOLD = 1;
    private static final int FONT_FACE_ITALIC = 2;
    private static final int FONT_FACE_UNDERLINE = 4;
    private static final int SIZE_ATOM_HEADER = 8;
    private static final int SIZE_BOM_UTF16 = 2;
    private static final int SIZE_SHORT = 2;
    private static final int SIZE_STYLE_RECORD = 12;
    private static final int SPAN_PRIORITY_HIGH = 0;
    private static final int SPAN_PRIORITY_LOW = 16711680;
    private static final String TX3G_SERIF = "Serif";
    private static final int TYPE_STYL = Util.getIntegerCodeForString("styl");
    private static final int TYPE_TBOX = Util.getIntegerCodeForString("tbox");
    private int calculatedVideoTrackHeight;
    private boolean customVerticalPlacement;
    private int defaultColorRgba;
    private int defaultFontFace;
    private String defaultFontFamily;
    private float defaultVerticalPlacement;
    private final ParsableByteArray parsableByteArray = new ParsableByteArray();

    public Tx3gDecoder(List<byte[]> list) {
        super("Tx3gDecoder");
        decodeInitializationData(list);
    }

    private void decodeInitializationData(List<byte[]> list) {
        String str = "sans-serif";
        boolean z = false;
        if (list != null && list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.defaultFontFace = bArr[24];
            this.defaultColorRgba = ((bArr[26] & UByte.MAX_VALUE) << 24) | ((bArr[27] & UByte.MAX_VALUE) << 16) | ((bArr[28] & UByte.MAX_VALUE) << 8) | (bArr[29] & UByte.MAX_VALUE);
            if (TX3G_SERIF.equals(Util.fromUtf8Bytes(bArr, 43, bArr.length - 43))) {
                str = C.SERIF_NAME;
            }
            this.defaultFontFamily = str;
            this.calculatedVideoTrackHeight = bArr[25] * 20;
            if ((bArr[0] & 32) != 0) {
                z = true;
            }
            this.customVerticalPlacement = z;
            if (this.customVerticalPlacement) {
                this.defaultVerticalPlacement = ((float) ((bArr[11] & UByte.MAX_VALUE) | ((bArr[10] & UByte.MAX_VALUE) << 8))) / ((float) this.calculatedVideoTrackHeight);
                this.defaultVerticalPlacement = Util.constrainValue(this.defaultVerticalPlacement, 0.0f, 0.95f);
                return;
            }
            this.defaultVerticalPlacement = DEFAULT_VERTICAL_PLACEMENT;
            return;
        }
        this.defaultFontFace = 0;
        this.defaultColorRgba = -1;
        this.defaultFontFamily = str;
        this.customVerticalPlacement = false;
        this.defaultVerticalPlacement = DEFAULT_VERTICAL_PLACEMENT;
    }

    /* access modifiers changed from: protected */
    public final Subtitle decode(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        this.parsableByteArray.reset(bArr, i);
        String readSubtitleText = readSubtitleText(this.parsableByteArray);
        if (readSubtitleText.isEmpty()) {
            return Tx3gSubtitle.EMPTY;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(readSubtitleText);
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        attachFontFace(spannableStringBuilder2, this.defaultFontFace, 0, 0, spannableStringBuilder.length(), SPAN_PRIORITY_LOW);
        attachColor(spannableStringBuilder2, this.defaultColorRgba, -1, 0, spannableStringBuilder.length(), SPAN_PRIORITY_LOW);
        attachFontFamily(spannableStringBuilder2, this.defaultFontFamily, "sans-serif", 0, spannableStringBuilder.length(), SPAN_PRIORITY_LOW);
        float f = this.defaultVerticalPlacement;
        while (this.parsableByteArray.bytesLeft() >= 8) {
            int position = this.parsableByteArray.getPosition();
            int readInt = this.parsableByteArray.readInt();
            int readInt2 = this.parsableByteArray.readInt();
            boolean z2 = true;
            if (readInt2 == TYPE_STYL) {
                if (this.parsableByteArray.bytesLeft() < 2) {
                    z2 = false;
                }
                assertTrue(z2);
                int readUnsignedShort = this.parsableByteArray.readUnsignedShort();
                for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                    applyStyleRecord(this.parsableByteArray, spannableStringBuilder);
                }
            } else if (readInt2 == TYPE_TBOX && this.customVerticalPlacement) {
                if (this.parsableByteArray.bytesLeft() < 2) {
                    z2 = false;
                }
                assertTrue(z2);
                f = Util.constrainValue(((float) this.parsableByteArray.readUnsignedShort()) / ((float) this.calculatedVideoTrackHeight), 0.0f, 0.95f);
            }
            this.parsableByteArray.setPosition(position + readInt);
        }
        return new Tx3gSubtitle(new Cue(spannableStringBuilder, (Layout.Alignment) null, f, 0, 0, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE));
    }

    private static String readSubtitleText(ParsableByteArray parsableByteArray2) throws SubtitleDecoderException {
        char peekChar;
        assertTrue(parsableByteArray2.bytesLeft() >= 2);
        int readUnsignedShort = parsableByteArray2.readUnsignedShort();
        if (readUnsignedShort == 0) {
            return "";
        }
        if (parsableByteArray2.bytesLeft() < 2 || ((peekChar = parsableByteArray2.peekChar()) != 65279 && peekChar != 65534)) {
            return parsableByteArray2.readString(readUnsignedShort, Charset.forName("UTF-8"));
        }
        return parsableByteArray2.readString(readUnsignedShort, Charset.forName(C.UTF16_NAME));
    }

    private void applyStyleRecord(ParsableByteArray parsableByteArray2, SpannableStringBuilder spannableStringBuilder) throws SubtitleDecoderException {
        assertTrue(parsableByteArray2.bytesLeft() >= 12);
        int readUnsignedShort = parsableByteArray2.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray2.readUnsignedShort();
        parsableByteArray2.skipBytes(2);
        int readUnsignedByte = parsableByteArray2.readUnsignedByte();
        parsableByteArray2.skipBytes(1);
        int readInt = parsableByteArray2.readInt();
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        int i = readUnsignedShort;
        int i2 = readUnsignedShort2;
        attachFontFace(spannableStringBuilder2, readUnsignedByte, this.defaultFontFace, i, i2, 0);
        attachColor(spannableStringBuilder2, readInt, this.defaultColorRgba, i, i2, 0);
    }

    private static void attachFontFace(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            int i6 = i5 | 33;
            boolean z = true;
            boolean z2 = (i & 1) != 0;
            boolean z3 = (i & 2) != 0;
            if (z2) {
                if (z3) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
                }
            } else if (z3) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
            }
            if ((i & 4) == 0) {
                z = false;
            }
            if (z) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
            }
            if (!z && !z2 && !z3) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
            }
        }
    }

    private static void attachColor(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & 255) << 24)), i3, i4, i5 | 33);
        }
    }

    private static void attachFontFamily(SpannableStringBuilder spannableStringBuilder, String str, String str2, int i, int i2, int i3) {
        if (str != str2) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i, i2, i3 | 33);
        }
    }

    private static void assertTrue(boolean z) throws SubtitleDecoderException {
        if (!z) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }
}
