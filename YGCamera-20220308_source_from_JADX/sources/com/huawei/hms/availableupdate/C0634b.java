package com.huawei.hms.availableupdate;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* renamed from: com.huawei.hms.availableupdate.b */
/* compiled from: RandomFileOutputStream */
public class C0634b extends OutputStream {

    /* renamed from: a */
    public RandomAccessFile f349a;

    public C0634b(File file, int i) {
        try {
            this.f349a = new RandomAccessFile(file, "rwd");
            this.f349a.setLength((long) i);
        } catch (FileNotFoundException unused) {
            HMSLog.m1377e("RandomFileOutputStream", "create  file stream failed");
        } catch (IOException unused2) {
            IOUtils.closeQuietly((Closeable) this.f349a);
            HMSLog.m1377e("RandomFileOutputStream", "create  file stream failed");
        }
    }

    /* renamed from: a */
    public void mo13224a(long j) throws IOException {
        this.f349a.seek(j);
    }

    public void close() throws IOException {
        this.f349a.close();
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f349a.write(bArr, i, i2);
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }
}
