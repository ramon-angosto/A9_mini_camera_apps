package com.shix.shixipc.utils;

import android.os.Environment;
import android.util.Log;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class CustomVideoRecord {
    private int PCount = 0;
    /* access modifiers changed from: private */
    public LinkedList<VideoRecordBean> dataBuff = null;
    /* access modifiers changed from: private */
    public String fileName = "";
    private boolean isBuffOut = false;
    private boolean isFirstH264 = true;
    private Thread mThread;
    /* access modifiers changed from: private */
    public FileOutputStream outStream;
    /* access modifiers changed from: private */
    public boolean startRecording = false;
    private long startTime = 0;
    private String strDID;
    /* access modifiers changed from: private */
    public int sum = 0;
    /* access modifiers changed from: private */
    public int sumFrame = 0;
    /* access modifiers changed from: private */
    public int type = 0;
    private int videoEnd = 0;
    /* access modifiers changed from: private */
    public int videoSumTime = 0;
    /* access modifiers changed from: private */
    public String videopath;

    static /* synthetic */ int access$708(CustomVideoRecord customVideoRecord) {
        int i = customVideoRecord.sumFrame;
        customVideoRecord.sumFrame = i + 1;
        return i;
    }

    public CustomVideoRecord(String str) {
        this.strDID = str;
    }

    public void startRecordVideo(int i, String str) {
        synchronized (this) {
            try {
                this.fileName = str;
                this.type = i;
                this.startRecording = true;
                this.isFirstH264 = true;
                this.startTime = new Date().getTime() / 1000;
                this.sumFrame = 0;
                this.sum = 0;
                this.PCount = 0;
                this.dataBuff = new LinkedList<>();
                Log.d(RemoteMessageConst.Notification.TAG, "start record video");
                this.mThread = new Thread(new myRunnable());
                this.mThread.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isRecordVideo() {
        return this.startRecording;
    }

    public void stopRecordVideo() {
        synchronized (this) {
            this.startRecording = false;
            this.videoSumTime = (int) ((new Date().getTime() / 1000) - this.startTime);
        }
    }

    public void VideoRecordData(int i, byte[] bArr, int i2, int i3, int i4) {
        if (!this.startRecording) {
            return;
        }
        if (this.dataBuff.size() <= 1000) {
            Log.d(RemoteMessageConst.Notification.TAG, "SHIZHAO dataBuff<10 IorP:" + i);
            VideoRecordBean videoRecordBean = new VideoRecordBean();
            int i5 = this.type;
            if (i5 == 1) {
                if (this.isFirstH264) {
                    if (i == 0 || i == 5) {
                        this.isFirstH264 = false;
                        Log.d(RemoteMessageConst.Notification.TAG, "第一帧是i帧");
                        this.PCount = 0;
                    } else {
                        Log.d(RemoteMessageConst.Notification.TAG, "第一帧不是i帧");
                        return;
                    }
                }
                if (this.isBuffOut) {
                    this.isBuffOut = false;
                    if (!(i == 0 || i == 5)) {
                        return;
                    }
                }
                videoRecordBean.setPicture(bArr);
                videoRecordBean.setType(i);
                videoRecordBean.setTspan(i4);
                videoRecordBean.setWidth(i2);
                videoRecordBean.setHeight(i3);
                LinkedList<VideoRecordBean> linkedList = this.dataBuff;
                if (linkedList != null) {
                    linkedList.add(videoRecordBean);
                }
            } else if (i5 == 2) {
                videoRecordBean.setPicture(bArr);
                videoRecordBean.setWidth(i2);
                videoRecordBean.setHeight(i3);
                videoRecordBean.setTspan(i4);
                videoRecordBean.setType(i);
                this.dataBuff.addLast(videoRecordBean);
            }
        } else {
            this.isBuffOut = true;
            Log.d(RemoteMessageConst.Notification.TAG, "SHIZHAO  dataBuff>10");
        }
    }

    private class myRunnable implements Runnable {
        private myRunnable() {
        }

        public void run() {
            try {
                File file = new File(Environment.getExternalStorageDirectory(), "YGCamera/video/ALLFile");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, CustomVideoRecord.this.fileName);
                Log.d(RemoteMessageConst.Notification.TAG, "start record video  fileName:" + file2.getAbsolutePath());
                String unused = CustomVideoRecord.this.videopath = file2.getAbsolutePath();
                FileOutputStream unused2 = CustomVideoRecord.this.outStream = new FileOutputStream(new File(CustomVideoRecord.this.videopath), true);
                Log.d(RemoteMessageConst.Notification.TAG, "码流 type:" + CustomVideoRecord.this.type);
                int access$400 = CustomVideoRecord.this.type;
                if (access$400 == 1) {
                    Log.d(RemoteMessageConst.Notification.TAG, "SHIZHAO  h264码流");
                    CustomVideoRecord.this.outStream.write(CustomVideoRecord.intToByte(1));
                } else if (access$400 == 2) {
                    Log.d(RemoteMessageConst.Notification.TAG, "SHIZHAO  jpg码流");
                    CustomVideoRecord.this.outStream.write(CustomVideoRecord.intToByte(2));
                }
                while (CustomVideoRecord.this.startRecording) {
                    synchronized (this) {
                        if (CustomVideoRecord.this.dataBuff.size() > 0) {
                            CustomVideoRecord.access$708(CustomVideoRecord.this);
                            Log.d(RemoteMessageConst.Notification.TAG, "SHIZHAO  总共录了" + CustomVideoRecord.this.sumFrame + " 帧    向文件中写了一帧");
                            VideoRecordBean videoRecordBean = (VideoRecordBean) CustomVideoRecord.this.dataBuff.poll();
                            if (videoRecordBean == null) {
                                Thread.sleep(500);
                            } else {
                                if (CustomVideoRecord.this.type == 1) {
                                    int type = videoRecordBean.getType();
                                    int tspan = videoRecordBean.getTspan();
                                    byte[] intToByte = CustomVideoRecord.intToByte(type);
                                    byte[] picture = videoRecordBean.getPicture();
                                    byte[] intToByte2 = CustomVideoRecord.intToByte(tspan);
                                    byte[] intToByte3 = CustomVideoRecord.intToByte(picture.length);
                                    byte[] intToByte4 = CustomVideoRecord.intToByte(videoRecordBean.getWidth());
                                    byte[] intToByte5 = CustomVideoRecord.intToByte(videoRecordBean.getHeight());
                                    CustomVideoRecord.this.outStream.write(intToByte3);
                                    CustomVideoRecord.this.outStream.write(intToByte4);
                                    CustomVideoRecord.this.outStream.write(intToByte5);
                                    CustomVideoRecord.this.outStream.write(intToByte);
                                    CustomVideoRecord.this.outStream.write(intToByte2);
                                    CustomVideoRecord.this.outStream.write(picture);
                                    int unused3 = CustomVideoRecord.this.sum = CustomVideoRecord.this.sum + tspan;
                                } else {
                                    byte[] picture2 = videoRecordBean.getPicture();
                                    byte[] intToByte6 = CustomVideoRecord.intToByte(picture2.length);
                                    int tspan2 = videoRecordBean.getTspan();
                                    byte[] intToByte7 = CustomVideoRecord.intToByte(tspan2);
                                    byte[] intToByte8 = CustomVideoRecord.intToByte(videoRecordBean.getType());
                                    Log.d(RemoteMessageConst.Notification.TAG, "SHIZHAO 录制时两帧时间差 Tspan: " + tspan2);
                                    int unused4 = CustomVideoRecord.this.sum = CustomVideoRecord.this.sum + tspan2;
                                    CustomVideoRecord.this.outStream.write(intToByte6);
                                    CustomVideoRecord.this.outStream.write(intToByte8);
                                    CustomVideoRecord.this.outStream.write(intToByte7);
                                    CustomVideoRecord.this.outStream.write(picture2);
                                }
                                CustomVideoRecord.this.outStream.flush();
                            }
                        } else {
                            Log.d(RemoteMessageConst.Notification.TAG, "SHIZHAO 没有图片，暂停100毫秒");
                            Thread.sleep(100);
                        }
                    }
                }
                Log.d(RemoteMessageConst.Notification.TAG, "SHIZHAO 录制总时间 videoSumTime: " + CustomVideoRecord.this.videoSumTime + "  sum:" + CustomVideoRecord.this.sum);
                CustomVideoRecord.this.outStream.write(CustomVideoRecord.intToByte(CustomVideoRecord.this.sum));
                CustomVideoRecord.this.outStream.flush();
                CustomVideoRecord.this.dataBuff.clear();
                LinkedList unused5 = CustomVideoRecord.this.dataBuff = null;
                if (CustomVideoRecord.this.outStream != null) {
                    CustomVideoRecord.this.outStream.close();
                    FileOutputStream unused6 = CustomVideoRecord.this.outStream = null;
                }
            } catch (Exception e) {
                Log.d(RemoteMessageConst.Notification.TAG, "SHIZHAO  保存录像文件异常:" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static byte[] intToByte(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = new Integer(i & 255).byteValue();
            i >>= 8;
        }
        return bArr;
    }

    public static int byteToInt(byte[] bArr) {
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
    }

    public static byte[] longToByte(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = new Long(255 & j).byteValue();
            j >>= 8;
        }
        return bArr;
    }

    public static long byteToLong(byte[] bArr) {
        return ((long) (bArr[0] & 255)) | (((long) (bArr[1] & 255)) << 8) | (((long) (bArr[2] & 255)) << 16) | (((long) (bArr[3] & 255)) << 24) | (((long) (bArr[4] & 255)) << 32) | (((long) (bArr[5] & 255)) << 40) | (((long) (bArr[6] & 255)) << 48) | (((long) (bArr[7] & 255)) << 56);
    }

    private String getStrDate() {
        String format = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss").format(new Date());
        Log.d(RemoteMessageConst.Notification.TAG, "record strDate:" + format);
        return format;
    }
}
