package com.google.zxing.client.j2se;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ResultParser;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.multi.GenericMultipleBarcodeReader;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Callable;
import javax.imageio.ImageIO;

final class DecodeWorker implements Callable<Integer> {
    private static final int BLACK = -16777216;
    private static final int RED = -65536;
    private static final int WHITE = -1;
    private final DecoderConfig config;
    private final Map<DecodeHintType, ?> hints;
    private final Queue<URI> inputs;

    DecodeWorker(DecoderConfig decoderConfig, Queue<URI> queue) {
        this.config = decoderConfig;
        this.inputs = queue;
        this.hints = decoderConfig.buildHints();
    }

    public Integer call() throws IOException {
        int i = 0;
        while (true) {
            URI poll = this.inputs.poll();
            if (poll == null) {
                return Integer.valueOf(i);
            }
            Result[] decode = decode(poll, this.hints);
            if (decode != null) {
                i++;
                if (this.config.dumpResults) {
                    dumpResult(poll, decode);
                }
            }
        }
    }

    private static Path buildOutputPath(URI uri, String str) throws IOException {
        String str2;
        Path path;
        String str3;
        if ("file".equals(uri.getScheme())) {
            Path path2 = Paths.get(uri);
            path = path2.getParent();
            str2 = path2.getFileName().toString();
        } else {
            path = Paths.get(".", new String[0]).toRealPath(new LinkOption[0]);
            String path3 = uri.getPath();
            if (path3 == null) {
                str2 = "input";
            } else {
                String[] split = path3.split("/");
                str2 = split[split.length - 1];
            }
        }
        int lastIndexOf = str2.lastIndexOf(46);
        if (lastIndexOf > 0) {
            str3 = String.valueOf(str2.substring(0, lastIndexOf)) + str;
        } else {
            str3 = String.valueOf(str2) + str;
        }
        return path.resolve(str3);
    }

    private static void dumpResult(URI uri, Result... resultArr) throws IOException {
        ArrayList arrayList = new ArrayList();
        for (Result text : resultArr) {
            arrayList.add(text.getText());
        }
        Files.write(buildOutputPath(uri, ".txt"), arrayList, StandardCharsets.UTF_8, new OpenOption[0]);
    }

    private Result[] decode(URI uri, Map<DecodeHintType, ?> map) throws IOException {
        BufferedImageLuminanceSource bufferedImageLuminanceSource;
        Result[] resultArr;
        BufferedImage readImage = ImageReader.readImage(uri);
        if (this.config.crop == null) {
            bufferedImageLuminanceSource = new BufferedImageLuminanceSource(readImage);
        } else {
            List<Integer> list = this.config.crop;
            bufferedImageLuminanceSource = new BufferedImageLuminanceSource(readImage, list.get(0).intValue(), list.get(1).intValue(), list.get(2).intValue(), list.get(3).intValue());
        }
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(bufferedImageLuminanceSource));
        if (this.config.dumpBlackPoint) {
            dumpBlackPoint(uri, readImage, binaryBitmap);
        }
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        try {
            if (this.config.multi) {
                resultArr = new GenericMultipleBarcodeReader(multiFormatReader).decodeMultiple(binaryBitmap, map);
            } else {
                resultArr = new Result[]{multiFormatReader.decode(binaryBitmap, map)};
            }
            if (this.config.brief) {
                System.out.println(uri + ": Success");
            } else {
                StringWriter stringWriter = new StringWriter();
                for (Result result : resultArr) {
                    ParsedResult parseResult = ResultParser.parseResult(result);
                    stringWriter.write(uri + " (format: " + result.getBarcodeFormat() + ", type: " + parseResult.getType() + "):\n" + "Raw result:\n" + result.getText() + "\n" + "Parsed result:\n" + parseResult.getDisplayResult() + "\n");
                    ResultPoint[] resultPoints = result.getResultPoints();
                    int length = resultPoints.length;
                    StringBuilder sb = new StringBuilder("Found ");
                    sb.append(length);
                    sb.append(" result points.\n");
                    stringWriter.write(sb.toString());
                    for (int i = 0; i < length; i++) {
                        ResultPoint resultPoint = resultPoints[i];
                        if (resultPoint != null) {
                            stringWriter.write("  Point " + i + ": (" + resultPoint.getX() + ',' + resultPoint.getY() + ')');
                            if (i != length - 1) {
                                stringWriter.write(10);
                            }
                        }
                    }
                    stringWriter.write(10);
                }
                System.out.println(stringWriter);
            }
            return resultArr;
        } catch (NotFoundException unused) {
            System.out.println(uri + ": No barcode found");
            return null;
        }
    }

    private static void dumpBlackPoint(URI uri, BufferedImage bufferedImage, BinaryBitmap binaryBitmap) throws IOException {
        int width = binaryBitmap.getWidth();
        int height = binaryBitmap.getHeight();
        int i = width * 3;
        int[] iArr = new int[(i * height)];
        int[] iArr2 = new int[width];
        for (int i2 = 0; i2 < height; i2++) {
            URI uri2 = uri;
            BinaryBitmap binaryBitmap2 = binaryBitmap;
            bufferedImage.getRGB(0, i2, width, 1, iArr2, 0, width);
            System.arraycopy(iArr2, 0, iArr, i2 * i, width);
        }
        BitArray bitArray = new BitArray(width);
        for (int i3 = 0; i3 < height; i3++) {
            URI uri3 = uri;
            try {
                BitArray blackRow = binaryBitmap.getBlackRow(i3, bitArray);
                int i4 = (i3 * i) + width;
                for (int i5 = 0; i5 < width; i5++) {
                    iArr[i4 + i5] = blackRow.get(i5) ? -16777216 : -1;
                }
                bitArray = blackRow;
            } catch (NotFoundException unused) {
                int i6 = (i3 * i) + width;
                Arrays.fill(iArr, i6, i6 + width, -65536);
            }
        }
        int i7 = 0;
        while (i7 < height) {
            try {
                BitMatrix blackMatrix = binaryBitmap.getBlackMatrix();
                int i8 = (i7 * i) + (width * 2);
                for (int i9 = 0; i9 < width; i9++) {
                    iArr[i8 + i9] = blackMatrix.get(i9, i7) ? -16777216 : -1;
                }
                i7++;
            } catch (NotFoundException unused2) {
            }
        }
        writeResultImage(i, height, iArr, uri, ".mono.png");
    }

    private static void writeResultImage(int i, int i2, int[] iArr, URI uri, String str) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(i, i2, 2);
        bufferedImage.setRGB(0, 0, i, i2, iArr, 0, i);
        Path buildOutputPath = buildOutputPath(uri, str);
        try {
            if (!ImageIO.write(bufferedImage, "png", buildOutputPath.toFile())) {
                PrintStream printStream = System.err;
                printStream.println("Could not encode an image to " + buildOutputPath);
            }
        } catch (IOException unused) {
            PrintStream printStream2 = System.err;
            printStream2.println("Could not write to " + buildOutputPath);
        }
    }
}
