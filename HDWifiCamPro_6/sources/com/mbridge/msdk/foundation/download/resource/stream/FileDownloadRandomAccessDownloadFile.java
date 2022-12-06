package com.mbridge.msdk.foundation.download.resource.stream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileDownloadRandomAccessDownloadFile implements DownloadFileOutputStream {
    private final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.randomAccess.getFD()));
    private final FileDescriptor fileDescriptor = this.randomAccess.getFD();
    private final RandomAccessFile randomAccess;

    public FileDownloadRandomAccessDownloadFile(File file) throws IOException {
        this.randomAccess = new RandomAccessFile(file, "rw");
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.bufferedOutputStream.write(bArr, i, i2);
    }

    public void flushAndSync() throws IOException {
        this.bufferedOutputStream.flush();
        this.fileDescriptor.sync();
    }

    public void close() throws IOException {
        this.bufferedOutputStream.close();
        this.randomAccess.close();
    }

    public void seek(long j) throws IOException {
        this.randomAccess.seek(j);
    }

    public void setLength(long j) throws IOException {
        this.randomAccess.setLength(j);
    }

    public static DownloadFileOutputStream create(File file) throws IOException {
        return new FileDownloadRandomAccessDownloadFile(file);
    }
}
