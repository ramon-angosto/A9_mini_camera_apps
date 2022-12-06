package com.mbridge.msdk.foundation.download.resource;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream;
import com.mbridge.msdk.foundation.download.resource.stream.FileDownloadRandomAccessDownloadFile;
import com.mbridge.msdk.foundation.download.utils.UnzipUtility;
import java.io.File;
import java.io.IOException;

public class MBResourceManager {
    /* access modifiers changed from: private */
    public static volatile MBResourceManager MBResourceManager;

    private MBResourceManager() {
    }

    public static MBResourceManager getInstance() {
        if (MBResourceManager == null) {
            synchronized (MBResourceManager.class) {
                if (MBResourceManager == null) {
                    MBResourceManager = new MBResourceManager();
                }
            }
        }
        return MBResourceManager;
    }

    public void unZip(String str, String str2) throws IOException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IOException("zipFilePath or destDirectory is null");
        }
        new UnzipUtility().unzip(str, str2);
    }

    public void deleteFile(File file) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            for (File absolutePath : file.listFiles()) {
                deleteFile(new File(absolutePath.getAbsolutePath()));
            }
            file.delete();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        return "";
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[ExcHandler: UnsupportedEncodingException | NoSuchAlgorithmException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:8:0x0012] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getDownloadId(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.net.URL r0 = new java.net.URL     // Catch:{ MalformedURLException -> 0x000f }
            r0.<init>(r4)     // Catch:{ MalformedURLException -> 0x000f }
            goto L_0x0010
        L_0x000f:
            r4 = 0
        L_0x0010:
            java.lang.String r0 = "MD5"
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0)     // Catch:{ UnsupportedEncodingException | NoSuchAlgorithmException -> 0x0030, UnsupportedEncodingException | NoSuchAlgorithmException -> 0x0030 }
            java.lang.String r2 = "UTF-8"
            byte[] r4 = r4.getBytes(r2)     // Catch:{ UnsupportedEncodingException | NoSuchAlgorithmException -> 0x0030, UnsupportedEncodingException | NoSuchAlgorithmException -> 0x0030 }
            r0.update(r4)     // Catch:{ UnsupportedEncodingException | NoSuchAlgorithmException -> 0x0030, UnsupportedEncodingException | NoSuchAlgorithmException -> 0x0030 }
            java.math.BigInteger r4 = new java.math.BigInteger     // Catch:{ UnsupportedEncodingException | NoSuchAlgorithmException -> 0x0030, UnsupportedEncodingException | NoSuchAlgorithmException -> 0x0030 }
            r2 = 1
            byte[] r0 = r0.digest()     // Catch:{ UnsupportedEncodingException | NoSuchAlgorithmException -> 0x0030, UnsupportedEncodingException | NoSuchAlgorithmException -> 0x0030 }
            r4.<init>(r2, r0)     // Catch:{ UnsupportedEncodingException | NoSuchAlgorithmException -> 0x0030, UnsupportedEncodingException | NoSuchAlgorithmException -> 0x0030 }
            r0 = 16
            java.lang.String r4 = r4.toString(r0)     // Catch:{ UnsupportedEncodingException | NoSuchAlgorithmException -> 0x0030, UnsupportedEncodingException | NoSuchAlgorithmException -> 0x0030 }
            return r4
        L_0x0030:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.resource.MBResourceManager.getDownloadId(java.lang.String):java.lang.String");
    }

    public void deleteFile(String str) {
        deleteFile(new File(str));
    }

    public long getFileSize(File file) {
        long j = 0;
        if (file == null || !file.exists()) {
            return 0;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        for (File fileSize : file.listFiles()) {
            j += getFileSize(fileSize);
        }
        return j;
    }

    public DownloadFileOutputStream getDownloadFileOutputStream(File file) throws IOException {
        if (file != null) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            return new FileDownloadRandomAccessDownloadFile(file);
        }
        throw new IOException("file is null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        r0 = r3.getResourceStrategyQueue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeResourceStrategy(final com.mbridge.msdk.foundation.download.resource.ResourceConfig r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x0034
            java.util.Queue r0 = r3.getResourceStrategyQueue()
            if (r0 == 0) goto L_0x0034
            java.util.Queue r0 = r3.getResourceStrategyQueue()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0034
            java.util.Queue r0 = r3.getResourceStrategyQueue()
            if (r0 == 0) goto L_0x0034
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x001f
            goto L_0x0034
        L_0x001f:
            com.mbridge.msdk.foundation.download.resource.MBResourceManager$1 r1 = new com.mbridge.msdk.foundation.download.resource.MBResourceManager$1
            r1.<init>(r0, r3)
            com.mbridge.msdk.foundation.download.core.ExecutorManager r3 = com.mbridge.msdk.foundation.download.core.ExecutorManager.getInstance()
            com.mbridge.msdk.foundation.download.core.ExecutorSupplier r3 = r3.getExecutorSupplier()
            java.util.concurrent.ExecutorService r3 = r3.getLruCacheThreadTasks()
            r3.execute(r1)
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.resource.MBResourceManager.executeResourceStrategy(com.mbridge.msdk.foundation.download.resource.ResourceConfig):void");
    }
}
