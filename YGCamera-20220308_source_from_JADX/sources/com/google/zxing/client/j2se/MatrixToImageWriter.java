package com.google.zxing.client.j2se;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import javax.imageio.ImageIO;

public final class MatrixToImageWriter {
    private static final MatrixToImageConfig DEFAULT_CONFIG = new MatrixToImageConfig();

    private MatrixToImageWriter() {
    }

    public static BufferedImage toBufferedImage(BitMatrix bitMatrix) {
        return toBufferedImage(bitMatrix, DEFAULT_CONFIG);
    }

    public static BufferedImage toBufferedImage(BitMatrix bitMatrix, MatrixToImageConfig matrixToImageConfig) {
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage bufferedImage = new BufferedImage(width, height, matrixToImageConfig.getBufferedImageColorModel());
        int pixelOnColor = matrixToImageConfig.getPixelOnColor();
        int pixelOffColor = matrixToImageConfig.getPixelOffColor();
        int[] iArr = new int[width];
        BitArray bitArray = new BitArray(width);
        int i = 0;
        while (i < height) {
            BitArray row = bitMatrix.getRow(i, bitArray);
            int i2 = 0;
            while (i2 < width) {
                BitArray bitArray2 = row;
                iArr[i2] = bitArray2.get(i2) ? pixelOnColor : pixelOffColor;
                i2++;
                BitMatrix bitMatrix2 = bitMatrix;
                row = bitArray2;
            }
            bufferedImage.setRGB(0, i, width, 1, iArr, 0, width);
            i++;
            bitArray = row;
        }
        return bufferedImage;
    }

    @Deprecated
    public static void writeToFile(BitMatrix bitMatrix, String str, File file) throws IOException {
        writeToPath(bitMatrix, str, file.toPath());
    }

    public static void writeToPath(BitMatrix bitMatrix, String str, Path path) throws IOException {
        writeToPath(bitMatrix, str, path, DEFAULT_CONFIG);
    }

    @Deprecated
    public static void writeToFile(BitMatrix bitMatrix, String str, File file, MatrixToImageConfig matrixToImageConfig) throws IOException {
        writeToPath(bitMatrix, str, file.toPath(), matrixToImageConfig);
    }

    public static void writeToPath(BitMatrix bitMatrix, String str, Path path, MatrixToImageConfig matrixToImageConfig) throws IOException {
        if (!ImageIO.write(toBufferedImage(bitMatrix, matrixToImageConfig), str, path.toFile())) {
            throw new IOException("Could not write an image of format " + str + " to " + path);
        }
    }

    public static void writeToStream(BitMatrix bitMatrix, String str, OutputStream outputStream) throws IOException {
        writeToStream(bitMatrix, str, outputStream, DEFAULT_CONFIG);
    }

    public static void writeToStream(BitMatrix bitMatrix, String str, OutputStream outputStream, MatrixToImageConfig matrixToImageConfig) throws IOException {
        if (!ImageIO.write(toBufferedImage(bitMatrix, matrixToImageConfig), str, outputStream)) {
            throw new IOException("Could not write an image of format " + str);
        }
    }
}
