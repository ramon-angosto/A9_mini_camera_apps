package com.mbridge.msdk.playercommon.exoplayer2.source.chunk;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;

public abstract class DataChunk extends Chunk {
    private static final int READ_GRANULARITY = 16384;
    private byte[] data;
    private int limit;
    private volatile boolean loadCanceled;

    /* access modifiers changed from: protected */
    public abstract void consume(byte[] bArr, int i) throws IOException;

    public DataChunk(DataSource dataSource, DataSpec dataSpec, int i, Format format, int i2, Object obj, byte[] bArr) {
        super(dataSource, dataSpec, i, format, i2, obj, C.TIME_UNSET, C.TIME_UNSET);
        this.data = bArr;
    }

    public byte[] getDataHolder() {
        return this.data;
    }

    public long bytesLoaded() {
        return (long) this.limit;
    }

    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    public final void load() throws IOException, InterruptedException {
        try {
            this.dataSource.open(this.dataSpec);
            int i = 0;
            this.limit = 0;
            while (i != -1 && !this.loadCanceled) {
                maybeExpandData();
                i = this.dataSource.read(this.data, this.limit, 16384);
                if (i != -1) {
                    this.limit += i;
                }
            }
            if (!this.loadCanceled) {
                consume(this.data, this.limit);
            }
        } finally {
            Util.closeQuietly(this.dataSource);
        }
    }

    private void maybeExpandData() {
        byte[] bArr = this.data;
        if (bArr == null) {
            this.data = new byte[16384];
        } else if (bArr.length < this.limit + 16384) {
            this.data = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }
}
