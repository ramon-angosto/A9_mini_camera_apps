package com.google.zxing.client.j2se;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import javax.imageio.ImageIO;

public final class ImageReader {
    private static final String BASE64TOKEN = "base64,";

    private ImageReader() {
    }

    public static BufferedImage readImage(URI uri) throws IOException {
        if (RemoteMessageConst.DATA.equals(uri.getScheme())) {
            return readDataURIImage(uri);
        }
        try {
            BufferedImage read = ImageIO.read(uri.toURL());
            if (read != null) {
                return read;
            }
            throw new IOException("Could not load " + uri);
        } catch (IllegalArgumentException e) {
            throw new IOException("Resource not found: " + uri, e);
        }
    }

    public static BufferedImage readDataURIImage(URI uri) throws IOException {
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        if (schemeSpecificPart.startsWith("image/")) {
            int indexOf = schemeSpecificPart.indexOf(BASE64TOKEN);
            if (indexOf >= 0) {
                return ImageIO.read(new ByteArrayInputStream(Base64Decoder.getInstance().decode(schemeSpecificPart.substring(indexOf + 7))));
            }
            throw new IOException("Unsupported data URI encoding");
        }
        throw new IOException("Unsupported data URI MIME type");
    }
}
