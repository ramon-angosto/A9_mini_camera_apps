package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSink;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.ReusableBufferedOutputStream;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class CacheDataSink implements DataSink {
    public static final int DEFAULT_BUFFER_SIZE = 20480;
    private final int bufferSize;
    private ReusableBufferedOutputStream bufferedOutputStream;
    private final Cache cache;
    private DataSpec dataSpec;
    private long dataSpecBytesWritten;
    private File file;
    private final long maxCacheFileSize;
    private OutputStream outputStream;
    private long outputStreamBytesWritten;
    private final boolean syncFileDescriptor;
    private FileOutputStream underlyingFileOutputStream;

    public static class CacheDataSinkException extends Cache.CacheException {
        public CacheDataSinkException(IOException iOException) {
            super((Throwable) iOException);
        }
    }

    public CacheDataSink(Cache cache2, long j) {
        this(cache2, j, DEFAULT_BUFFER_SIZE, true);
    }

    public CacheDataSink(Cache cache2, long j, boolean z) {
        this(cache2, j, DEFAULT_BUFFER_SIZE, z);
    }

    public CacheDataSink(Cache cache2, long j, int i) {
        this(cache2, j, i, true);
    }

    public CacheDataSink(Cache cache2, long j, int i, boolean z) {
        this.cache = (Cache) Assertions.checkNotNull(cache2);
        this.maxCacheFileSize = j;
        this.bufferSize = i;
        this.syncFileDescriptor = z;
    }

    public final void open(DataSpec dataSpec2) throws CacheDataSinkException {
        if (dataSpec2.length != -1 || dataSpec2.isFlagSet(2)) {
            this.dataSpec = dataSpec2;
            this.dataSpecBytesWritten = 0;
            try {
                openNextOutputStream();
            } catch (IOException e) {
                throw new CacheDataSinkException(e);
            }
        } else {
            this.dataSpec = null;
        }
    }

    public final void write(byte[] bArr, int i, int i2) throws CacheDataSinkException {
        if (this.dataSpec != null) {
            int i3 = 0;
            while (i3 < i2) {
                try {
                    if (this.outputStreamBytesWritten == this.maxCacheFileSize) {
                        closeCurrentOutputStream();
                        openNextOutputStream();
                    }
                    int min = (int) Math.min((long) (i2 - i3), this.maxCacheFileSize - this.outputStreamBytesWritten);
                    this.outputStream.write(bArr, i + i3, min);
                    i3 += min;
                    long j = (long) min;
                    this.outputStreamBytesWritten += j;
                    this.dataSpecBytesWritten += j;
                } catch (IOException e) {
                    throw new CacheDataSinkException(e);
                }
            }
        }
    }

    public final void close() throws CacheDataSinkException {
        if (this.dataSpec != null) {
            try {
                closeCurrentOutputStream();
            } catch (IOException e) {
                throw new CacheDataSinkException(e);
            }
        }
    }

    private void openNextOutputStream() throws IOException {
        long j;
        if (this.dataSpec.length == -1) {
            j = this.maxCacheFileSize;
        } else {
            j = Math.min(this.dataSpec.length - this.dataSpecBytesWritten, this.maxCacheFileSize);
        }
        Cache cache2 = this.cache;
        String str = this.dataSpec.key;
        this.file = cache2.startFile(str, this.dataSpecBytesWritten + this.dataSpec.absoluteStreamPosition, j);
        this.underlyingFileOutputStream = new FileOutputStream(this.file);
        int i = this.bufferSize;
        if (i > 0) {
            ReusableBufferedOutputStream reusableBufferedOutputStream = this.bufferedOutputStream;
            if (reusableBufferedOutputStream == null) {
                this.bufferedOutputStream = new ReusableBufferedOutputStream(this.underlyingFileOutputStream, i);
            } else {
                reusableBufferedOutputStream.reset(this.underlyingFileOutputStream);
            }
            this.outputStream = this.bufferedOutputStream;
        } else {
            this.outputStream = this.underlyingFileOutputStream;
        }
        this.outputStreamBytesWritten = 0;
    }

    private void closeCurrentOutputStream() throws IOException {
        OutputStream outputStream2 = this.outputStream;
        if (outputStream2 != null) {
            try {
                outputStream2.flush();
                if (this.syncFileDescriptor) {
                    this.underlyingFileOutputStream.getFD().sync();
                }
                Util.closeQuietly((Closeable) this.outputStream);
                this.outputStream = null;
                File file2 = this.file;
                this.file = null;
                this.cache.commitFile(file2);
            } catch (Throwable th) {
                Util.closeQuietly((Closeable) this.outputStream);
                this.outputStream = null;
                File file3 = this.file;
                this.file = null;
                file3.delete();
                throw th;
            }
        }
    }
}
