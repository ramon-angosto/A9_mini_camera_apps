package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.net.Uri;
import android.util.Base64;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;
import java.net.URLDecoder;

public final class DataSchemeDataSource implements DataSource {
    public static final String SCHEME_DATA = "data";
    private int bytesRead;
    private byte[] data;
    private DataSpec dataSpec;

    public final long open(DataSpec dataSpec2) throws IOException {
        this.dataSpec = dataSpec2;
        Uri uri = dataSpec2.uri;
        String scheme = uri.getScheme();
        if (SCHEME_DATA.equals(scheme)) {
            String[] split = Util.split(uri.getSchemeSpecificPart(), ",");
            if (split.length == 2) {
                String str = split[1];
                if (split[0].contains(";base64")) {
                    try {
                        this.data = Base64.decode(str, 0);
                    } catch (IllegalArgumentException e) {
                        throw new ParserException("Error while parsing Base64 encoded string: " + str, e);
                    }
                } else {
                    this.data = URLDecoder.decode(str, C.ASCII_NAME).getBytes();
                }
                return (long) this.data.length;
            }
            throw new ParserException("Unexpected URI format: " + uri);
        }
        throw new ParserException("Unsupported scheme: " + scheme);
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int length = this.data.length - this.bytesRead;
        if (length == 0) {
            return -1;
        }
        int min = Math.min(i2, length);
        System.arraycopy(this.data, this.bytesRead, bArr, i, min);
        this.bytesRead += min;
        return min;
    }

    public final Uri getUri() {
        DataSpec dataSpec2 = this.dataSpec;
        if (dataSpec2 != null) {
            return dataSpec2.uri;
        }
        return null;
    }

    public final void close() throws IOException {
        this.dataSpec = null;
        this.data = null;
    }
}
