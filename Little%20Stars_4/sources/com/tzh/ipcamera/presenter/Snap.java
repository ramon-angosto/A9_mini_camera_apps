package com.tzh.ipcamera.presenter;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.DataBaseHelper;

public class Snap {
    public static Snap snap;
    private FileOutputStream fos = null;
    private DataBaseHelper helper;
    /* access modifiers changed from: private */
    public boolean isPictSave = false;
    public boolean is_Toast = true;
    /* access modifiers changed from: private */
    public Bitmap mBitmap = null;
    /* access modifiers changed from: private */
    public Activity mContext = null;
    private File mSnapFile = null;
    private Thread mThread = null;
    /* access modifiers changed from: private */
    public String strDID = null;

    public Snap(Activity activity, String str) {
        snap = this;
        this.mContext = activity;
        this.strDID = str;
        this.helper = DataBaseHelper.getInstance(activity);
        snapFileInit();
    }

    public void snapSetID(String str) {
        this.strDID = str;
    }

    private void snapFileInit() {
        this.mSnapFile = new File(Environment.getExternalStorageDirectory(), "LittleStars/picid");
        if (!this.mSnapFile.exists()) {
            this.mSnapFile.mkdirs();
        }
    }

    public void saveLastPic(byte[] bArr, int i, int i2, boolean z) {
        Thread thread = this.mThread;
        if (thread == null || !thread.isAlive()) {
            this.mThread = new Thread(new SnapRunnable(bArr, i, i2, z));
            this.mThread.start();
        }
    }

    /* access modifiers changed from: private */
    public void UpdataBitmp(String str, Bitmap bitmap) {
        for (int i = 0; i < SystemValue.arrayList.size(); i++) {
            if (str != null && str.equals(SystemValue.arrayList.get(i).getDid())) {
                SystemValue.arrayList.get(i).setBmp(bitmap);
                SystemValue.arrayList.get(i).setPlayBitmap(bitmap);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void writeBmpFile(String str, Bitmap bitmap) {
        try {
            File file = this.mSnapFile;
            File file2 = new File(file, str + ".jpg");
            this.fos = new FileOutputStream(file2);
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, this.fos)) {
                this.fos.flush();
                this.fos.close();
                Cursor queryFirstpic = this.helper.queryFirstpic(str);
                if (queryFirstpic.getCount() <= 0) {
                    this.helper.addFirstpic(str, file2.getAbsolutePath());
                }
                if (queryFirstpic != null) {
                    queryFirstpic.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void takePicture(final Bitmap bitmap) {
        new Thread() {
            public void run() {
                Snap.this.savePicToSDcard(bitmap);
            }
        }.start();
    }

    private String getStrDate() {
        return new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss").format(new Date());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x014e A[SYNTHETIC, Splitter:B:45:0x014e] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0156 A[SYNTHETIC, Splitter:B:49:0x0156] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x015f A[SYNTHETIC, Splitter:B:56:0x015f] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x0116=Splitter:B:32:0x0116, B:53:0x015b=Splitter:B:53:0x015b, B:27:0x010f=Splitter:B:27:0x010f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void savePicToSDcard(android.graphics.Bitmap r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r0 = r9.getStrDate()     // Catch:{ all -> 0x0168 }
            java.lang.String r1 = "savePicToSDcard"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0168 }
            r2.<init>()     // Catch:{ all -> 0x0168 }
            java.lang.String r3 = "genghuai savePicToSDcard11:"
            r2.append(r3)     // Catch:{ all -> 0x0168 }
            r2.append(r0)     // Catch:{ all -> 0x0168 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0168 }
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x0168 }
            r1 = 10
            r2 = 0
            java.lang.String r3 = r0.substring(r2, r1)     // Catch:{ all -> 0x0168 }
            java.lang.String r4 = "savePicToSDcard"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0168 }
            r5.<init>()     // Catch:{ all -> 0x0168 }
            java.lang.String r6 = "genghuai savePicToSDcard22:"
            r5.append(r6)     // Catch:{ all -> 0x0168 }
            r5.append(r3)     // Catch:{ all -> 0x0168 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0168 }
            android.util.Log.d(r4, r5)     // Catch:{ all -> 0x0168 }
            object.p2pipcam.utils.DataBaseHelper r4 = r9.helper     // Catch:{ all -> 0x0168 }
            java.lang.String r5 = r9.strDID     // Catch:{ all -> 0x0168 }
            android.database.Cursor r4 = r4.queryAllPicture(r5)     // Catch:{ all -> 0x0168 }
            r5 = 0
        L_0x0041:
            boolean r6 = r4.moveToNext()     // Catch:{ all -> 0x0168 }
            if (r6 == 0) goto L_0x006e
            java.lang.String r6 = "filepath"
            int r6 = r4.getColumnIndex(r6)     // Catch:{ all -> 0x0168 }
            java.lang.String r6 = r4.getString(r6)     // Catch:{ all -> 0x0168 }
            java.lang.String r7 = "/"
            int r7 = r6.lastIndexOf(r7)     // Catch:{ all -> 0x0168 }
            int r7 = r7 + 1
            java.lang.String r6 = r6.substring(r7)     // Catch:{ all -> 0x0168 }
            java.lang.String r6 = r6.substring(r2, r1)     // Catch:{ all -> 0x0168 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0168 }
            boolean r6 = r6.equals(r3)     // Catch:{ all -> 0x0168 }
            if (r6 == 0) goto L_0x0041
            int r5 = r5 + 1
            goto L_0x0041
        L_0x006e:
            r1 = 500(0x1f4, float:7.0E-43)
            if (r5 < r1) goto L_0x007e
            android.app.Activity r10 = r9.mContext     // Catch:{ all -> 0x0168 }
            com.tzh.ipcamera.presenter.Snap$2 r0 = new com.tzh.ipcamera.presenter.Snap$2     // Catch:{ all -> 0x0168 }
            r0.<init>()     // Catch:{ all -> 0x0168 }
            r10.runOnUiThread(r0)     // Catch:{ all -> 0x0168 }
            monitor-exit(r9)
            return
        L_0x007e:
            if (r4 == 0) goto L_0x0083
            r4.close()     // Catch:{ all -> 0x0168 }
        L_0x0083:
            object.p2pipcam.utils.DataBaseHelper r1 = r9.helper     // Catch:{ all -> 0x0168 }
            java.lang.String r3 = r9.strDID     // Catch:{ all -> 0x0168 }
            java.lang.String r4 = "picture"
            android.database.Cursor r1 = r1.queryVideoOrPictureByDate(r3, r0, r4)     // Catch:{ all -> 0x0168 }
            int r3 = r1.getCount()     // Catch:{ all -> 0x0168 }
            int r3 = r3 + 1
            r4 = 0
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x0122 }
            java.io.File r6 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x0122 }
            java.lang.String r7 = "LittleStars/pic"
            r5.<init>(r6, r7)     // Catch:{ Exception -> 0x0122 }
            boolean r6 = r5.exists()     // Catch:{ Exception -> 0x0122 }
            if (r6 != 0) goto L_0x00a8
            r5.mkdirs()     // Catch:{ Exception -> 0x0122 }
        L_0x00a8:
            java.lang.String r6 = "test"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0122 }
            r7.<init>()     // Catch:{ Exception -> 0x0122 }
            java.lang.String r8 = "savePicToSDcard playdiv:"
            r7.append(r8)     // Catch:{ Exception -> 0x0122 }
            r7.append(r5)     // Catch:{ Exception -> 0x0122 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0122 }
            android.util.Log.d(r6, r7)     // Catch:{ Exception -> 0x0122 }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0122 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0122 }
            r7.<init>()     // Catch:{ Exception -> 0x0122 }
            r7.append(r0)     // Catch:{ Exception -> 0x0122 }
            java.lang.String r8 = "_="
            r7.append(r8)     // Catch:{ Exception -> 0x0122 }
            java.lang.String r8 = r9.strDID     // Catch:{ Exception -> 0x0122 }
            r7.append(r8)     // Catch:{ Exception -> 0x0122 }
            java.lang.String r8 = "!"
            r7.append(r8)     // Catch:{ Exception -> 0x0122 }
            r7.append(r3)     // Catch:{ Exception -> 0x0122 }
            java.lang.String r3 = "_.jpg"
            r7.append(r3)     // Catch:{ Exception -> 0x0122 }
            java.lang.String r3 = r7.toString()     // Catch:{ Exception -> 0x0122 }
            r6.<init>(r5, r3)     // Catch:{ Exception -> 0x0122 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0122 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0122 }
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x011d, all -> 0x011a }
            r5 = 100
            boolean r10 = r10.compress(r4, r5, r3)     // Catch:{ Exception -> 0x011d, all -> 0x011a }
            if (r10 == 0) goto L_0x010f
            r3.flush()     // Catch:{ Exception -> 0x011d, all -> 0x011a }
            object.p2pipcam.utils.DataBaseHelper r10 = r9.helper     // Catch:{ Exception -> 0x011d, all -> 0x011a }
            java.lang.String r4 = r9.strDID     // Catch:{ Exception -> 0x011d, all -> 0x011a }
            java.lang.String r5 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x011d, all -> 0x011a }
            java.lang.String r6 = "picture"
            r10.createVideoOrPic(r4, r5, r6, r0)     // Catch:{ Exception -> 0x011d, all -> 0x011a }
            android.app.Activity r10 = r9.mContext     // Catch:{ Exception -> 0x011d, all -> 0x011a }
            com.tzh.ipcamera.presenter.Snap$3 r0 = new com.tzh.ipcamera.presenter.Snap$3     // Catch:{ Exception -> 0x011d, all -> 0x011a }
            r0.<init>()     // Catch:{ Exception -> 0x011d, all -> 0x011a }
            r10.runOnUiThread(r0)     // Catch:{ Exception -> 0x011d, all -> 0x011a }
        L_0x010f:
            r9.isPictSave = r2     // Catch:{ all -> 0x0168 }
            r3.close()     // Catch:{ IOException -> 0x0115 }
            goto L_0x0154
        L_0x0115:
            r10 = move-exception
        L_0x0116:
            r10.printStackTrace()     // Catch:{ all -> 0x0168 }
            goto L_0x0154
        L_0x011a:
            r10 = move-exception
            r4 = r3
            goto L_0x015b
        L_0x011d:
            r10 = move-exception
            r4 = r3
            goto L_0x0123
        L_0x0120:
            r10 = move-exception
            goto L_0x015b
        L_0x0122:
            r10 = move-exception
        L_0x0123:
            android.app.Activity r0 = r9.mContext     // Catch:{ all -> 0x0120 }
            com.tzh.ipcamera.presenter.Snap$4 r3 = new com.tzh.ipcamera.presenter.Snap$4     // Catch:{ all -> 0x0120 }
            r3.<init>()     // Catch:{ all -> 0x0120 }
            r0.runOnUiThread(r3)     // Catch:{ all -> 0x0120 }
            java.lang.String r0 = "tag"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0120 }
            r3.<init>()     // Catch:{ all -> 0x0120 }
            java.lang.String r5 = "exception:"
            r3.append(r5)     // Catch:{ all -> 0x0120 }
            java.lang.String r5 = r10.getMessage()     // Catch:{ all -> 0x0120 }
            r3.append(r5)     // Catch:{ all -> 0x0120 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0120 }
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x0120 }
            r10.printStackTrace()     // Catch:{ all -> 0x0120 }
            r9.isPictSave = r2     // Catch:{ all -> 0x0168 }
            if (r4 == 0) goto L_0x0154
            r4.close()     // Catch:{ IOException -> 0x0152 }
            goto L_0x0154
        L_0x0152:
            r10 = move-exception
            goto L_0x0116
        L_0x0154:
            if (r1 == 0) goto L_0x0159
            r1.close()     // Catch:{ all -> 0x0168 }
        L_0x0159:
            monitor-exit(r9)
            return
        L_0x015b:
            r9.isPictSave = r2     // Catch:{ all -> 0x0168 }
            if (r4 == 0) goto L_0x0167
            r4.close()     // Catch:{ IOException -> 0x0163 }
            goto L_0x0167
        L_0x0163:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0168 }
        L_0x0167:
            throw r10     // Catch:{ all -> 0x0168 }
        L_0x0168:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x016c
        L_0x016b:
            throw r10
        L_0x016c:
            goto L_0x016b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tzh.ipcamera.presenter.Snap.savePicToSDcard(android.graphics.Bitmap):void");
    }

    class SnapRunnable implements Runnable {
        private byte[] Buffer;
        private int height;
        private boolean isH264 = false;
        private int width;

        public SnapRunnable(byte[] bArr, int i, int i2, boolean z) {
            this.Buffer = bArr;
            this.width = i;
            this.height = i2;
            this.isH264 = z;
        }

        public void run() {
            if (this.isH264) {
                int i = this.width;
                int i2 = this.height;
                byte[] bArr = new byte[(i * i2 * 2)];
                NativeCaller.YUV4202RGB565(this.Buffer, bArr, i, i2);
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                Bitmap unused = Snap.this.mBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
                Snap.this.mBitmap.copyPixelsFromBuffer(wrap);
            }
            if (Snap.this.mBitmap != null) {
                int width2 = Snap.this.mBitmap.getWidth();
                int height2 = Snap.this.mBitmap.getHeight();
                Matrix matrix = new Matrix();
                matrix.postScale(100.0f / ((float) width2), 80.0f / ((float) height2));
                Bitmap.createBitmap(Snap.this.mBitmap, 0, 0, width2, height2, matrix, true);
                File file = new File(Environment.getExternalStorageDirectory(), "LittleStars/picid");
                File file2 = new File(file, Snap.this.strDID + ".jpg");
                if (file2.exists()) {
                    Log.d("first_pic", file2.delete() + "");
                }
                Snap snap = Snap.this;
                snap.UpdataBitmp(snap.strDID, Snap.this.mBitmap);
                Snap snap2 = Snap.this;
                snap2.writeBmpFile(snap2.strDID, Snap.this.mBitmap);
            }
        }
    }
}
