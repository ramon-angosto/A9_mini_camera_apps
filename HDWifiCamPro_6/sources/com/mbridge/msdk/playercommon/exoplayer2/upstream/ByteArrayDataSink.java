package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class ByteArrayDataSink implements DataSink {
    private ByteArrayOutputStream stream;

    public final void open(DataSpec dataSpec) throws IOException {
        if (dataSpec.length == -1) {
            this.stream = new ByteArrayOutputStream();
            return;
        }
        Assertions.checkArgument(dataSpec.length <= 2147483647L);
        this.stream = new ByteArrayOutputStream((int) dataSpec.length);
    }

    public final void close() throws IOException {
        this.stream.close();
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.stream.write(bArr, i, i2);
    }

    public final byte[] getData() {
        ByteArrayOutputStream byteArrayOutputStream = this.stream;
        if (byteArrayOutputStream == null) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
