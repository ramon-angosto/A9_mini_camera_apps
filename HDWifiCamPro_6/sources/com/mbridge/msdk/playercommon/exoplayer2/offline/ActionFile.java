package com.mbridge.msdk.playercommon.exoplayer2.offline;

import com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadAction;
import com.mbridge.msdk.playercommon.exoplayer2.util.AtomicFile;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public final class ActionFile {
    static final int VERSION = 0;
    private final File actionFile;
    private final AtomicFile atomicFile;

    public ActionFile(File file) {
        this.actionFile = file;
        this.atomicFile = new AtomicFile(file);
    }

    public final DownloadAction[] load(DownloadAction.Deserializer... deserializerArr) throws IOException {
        if (!this.actionFile.exists()) {
            return new DownloadAction[0];
        }
        InputStream inputStream = null;
        try {
            inputStream = this.atomicFile.openRead();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            int readInt = dataInputStream.readInt();
            if (readInt <= 0) {
                int readInt2 = dataInputStream.readInt();
                DownloadAction[] downloadActionArr = new DownloadAction[readInt2];
                for (int i = 0; i < readInt2; i++) {
                    downloadActionArr[i] = DownloadAction.deserializeFromStream(deserializerArr, dataInputStream);
                }
                return downloadActionArr;
            }
            throw new IOException("Unsupported action file version: " + readInt);
        } finally {
            Util.closeQuietly((Closeable) inputStream);
        }
    }

    public final void store(DownloadAction... downloadActionArr) throws IOException {
        DataOutputStream dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(this.atomicFile.startWrite());
            try {
                dataOutputStream.writeInt(0);
                dataOutputStream.writeInt(downloadActionArr.length);
                for (DownloadAction serializeToStream : downloadActionArr) {
                    DownloadAction.serializeToStream(serializeToStream, dataOutputStream);
                }
                this.atomicFile.endWrite(dataOutputStream);
                Util.closeQuietly((Closeable) null);
            } catch (Throwable th) {
                th = th;
                Util.closeQuietly((Closeable) dataOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream = null;
            Util.closeQuietly((Closeable) dataOutputStream);
            throw th;
        }
    }
}
