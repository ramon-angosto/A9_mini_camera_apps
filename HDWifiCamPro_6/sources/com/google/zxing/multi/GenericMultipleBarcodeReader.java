package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader {
    private static final int MAX_DEPTH = 4;
    private static final int MIN_DIMENSION_TO_RECUR = 100;
    private final Reader delegate;

    public GenericMultipleBarcodeReader(Reader reader) {
        this.delegate = reader;
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        return decodeMultiple(binaryBitmap, (Map<DecodeHintType, ?>) null);
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        doDecodeMultiple(binaryBitmap, map, arrayList, 0, 0, 0);
        if (!arrayList.isEmpty()) {
            return (Result[]) arrayList.toArray(new Result[arrayList.size()]);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void doDecodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, List<Result> list, int i, int i2, int i3) {
        int i4;
        boolean z;
        float f;
        int i5;
        int i6;
        BinaryBitmap binaryBitmap2 = binaryBitmap;
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        if (i9 <= 4) {
            try {
                Result decode = this.delegate.decode(binaryBitmap2, map);
                Iterator<Result> it = list.iterator();
                while (true) {
                    i4 = 0;
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (it.next().getText().equals(decode.getText())) {
                        z = true;
                        break;
                    } else {
                        List<Result> list2 = list;
                        Map<DecodeHintType, ?> map2 = map;
                    }
                }
                if (!z) {
                    list.add(translateResultPoints(decode, i7, i8));
                } else {
                    List<Result> list3 = list;
                }
                ResultPoint[] resultPoints = decode.getResultPoints();
                if (resultPoints != null && resultPoints.length != 0) {
                    int width = binaryBitmap.getWidth();
                    int height = binaryBitmap.getHeight();
                    int length = resultPoints.length;
                    float f2 = 0.0f;
                    float f3 = 0.0f;
                    float f4 = (float) height;
                    float f5 = (float) width;
                    int i10 = 0;
                    while (i10 < length) {
                        int i11 = height;
                        int i12 = width;
                        int i13 = i4;
                        float f6 = f4;
                        float f7 = f3;
                        ResultPoint resultPoint = resultPoints[i10];
                        if (resultPoint != null) {
                            float x = resultPoint.getX();
                            float y = resultPoint.getY();
                            if (x < f5) {
                                f5 = x;
                            }
                            if (y < f6) {
                                f6 = y;
                            }
                            if (x > f2) {
                                f2 = x;
                            }
                            if (y > f7) {
                                f4 = f6;
                                f3 = y;
                                i10++;
                                i4 = i13;
                                height = i11;
                                width = i12;
                                Map<DecodeHintType, ?> map3 = map;
                            }
                        }
                        f3 = f7;
                        f4 = f6;
                        i10++;
                        i4 = i13;
                        height = i11;
                        width = i12;
                        Map<DecodeHintType, ?> map32 = map;
                    }
                    if (f5 > 100.0f) {
                        BinaryBitmap crop = binaryBitmap2.crop(i4, i4, (int) f5, height);
                        f = f4;
                        i6 = height;
                        i5 = width;
                        doDecodeMultiple(crop, map, list, i, i2, i9 + 1);
                    } else {
                        f = f4;
                        i6 = height;
                        i5 = width;
                    }
                    if (f > 100.0f) {
                        doDecodeMultiple(binaryBitmap2.crop(0, 0, i5, (int) f), map, list, i, i2, i9 + 1);
                    }
                    if (f2 < ((float) (i5 - 100))) {
                        int i14 = (int) f2;
                        doDecodeMultiple(binaryBitmap2.crop(i14, 0, i5 - i14, i6), map, list, i7 + i14, i2, i9 + 1);
                    }
                    float f8 = f3;
                    if (f8 < ((float) (i6 - 100))) {
                        int i15 = (int) f8;
                        doDecodeMultiple(binaryBitmap2.crop(0, i15, i5, i6 - i15), map, list, i, i8 + i15, 1 + i9);
                    }
                }
            } catch (ReaderException unused) {
            }
        }
    }

    private static Result translateResultPoints(Result result, int i, int i2) {
        ResultPoint[] resultPoints = result.getResultPoints();
        if (resultPoints == null) {
            return result;
        }
        ResultPoint[] resultPointArr = new ResultPoint[resultPoints.length];
        for (int i3 = 0; i3 < resultPoints.length; i3++) {
            ResultPoint resultPoint = resultPoints[i3];
            if (resultPoint != null) {
                resultPointArr[i3] = new ResultPoint(resultPoint.getX() + ((float) i), resultPoint.getY() + ((float) i2));
            }
        }
        Result result2 = new Result(result.getText(), result.getRawBytes(), result.getNumBits(), resultPointArr, result.getBarcodeFormat(), result.getTimestamp());
        result2.putAllMetadata(result.getResultMetadata());
        return result2;
    }
}
