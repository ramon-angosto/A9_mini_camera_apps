package com.shix.shixipc.utils;

import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import com.shix.shixipc.system.ContentCommon;
import java.io.File;
import object.p2pipcam.nativecaller.NativeCaller;

public class TakeVideoThread extends Thread {
    private AudioBuffer audioBuffer = null;
    private byte[] audioByte;
    private long availableBlocks;
    private long blockSize;
    private int frame = 5;
    public int height = 0;
    private int heightRun = 0;
    private IorPBuffer iorPBuffer = null;
    private boolean isStart = false;
    private boolean isone = false;
    private String name;
    private int sleepTime = 0;
    private String strDID = "";
    private String szDid = "";
    private int tag = 0;
    private int thisIoP = 0;
    private long totalBlocks;
    private VideoBuffer videoBuffer = null;
    private byte[] videoByte;
    private int video_i = 0;
    public int width = 0;
    private int widthRun = 0;

    public TakeVideoThread(int i, String str, int i2, int i3, int i4) {
        Log.e(ContentCommon.SERVER_STRING, "video tag:" + i + "  did:" + str + "  frame:" + i2 + "  width:" + i3 + "  height:" + i4);
        this.szDid = str;
        this.tag = i;
        this.frame = 15;
        if (i2 == 0) {
            this.frame = 15;
        }
        this.sleepTime = 1000 / this.frame;
        this.width = i3;
        this.height = i4;
        this.videoBuffer = new VideoBuffer();
        this.audioBuffer = new AudioBuffer();
        if (i != 0) {
            this.iorPBuffer = new IorPBuffer();
        }
        this.strDID = str;
        this.isStart = true;
        this.isone = true;
    }

    public boolean addAudio(byte[] bArr) {
        return this.audioBuffer.addAudioData(bArr);
    }

    public boolean addVideo(byte[] bArr, int i, int i2, int i3) {
        Log.e(ContentCommon.SERVER_STRING, "video data width:" + i2 + "  heigh:" + i3);
        this.width = i2;
        this.height = i3;
        if (this.tag == 0) {
            return this.videoBuffer.addData(bArr);
        }
        if (!this.videoBuffer.addData(bArr) || !this.iorPBuffer.addData(i)) {
            this.videoBuffer.ClearAll();
            this.iorPBuffer.ClearAll();
            return false;
        } else if (this.videoBuffer.size() == this.iorPBuffer.size()) {
            return true;
        } else {
            this.videoBuffer.ClearAll();
            this.iorPBuffer.ClearAll();
            return false;
        }
    }

    public boolean isRun() {
        return this.isStart;
    }

    public void clearAll() {
        if (this.tag != 0) {
            this.videoBuffer.ClearAll();
            this.iorPBuffer.ClearAll();
            this.audioBuffer.ClearAudioAll();
            return;
        }
        this.videoBuffer.ClearAll();
        this.audioBuffer.ClearAudioAll();
    }

    public void stopThread() {
        this.isStart = false;
        this.video_i = 0;
        NativeCaller.CloseAvi(this.szDid);
    }

    public String GetAviName() {
        return this.name;
    }

    public void run() {
        while (true) {
            if (!this.isStart) {
                break;
            }
            Log.e(ContentCommon.SERVER_STRING, "video start:" + this.isStart);
            this.video_i = this.video_i + 1;
            try {
                Thread.sleep((long) this.sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (this.video_i == 1) {
                this.name = CommonUtil.getFileNameWithTime(1);
                if (this.tag > 0) {
                    File file = new File(Environment.getExternalStorageDirectory(), "YGCamera/video/ALLFile");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String str = this.szDid;
                    NativeCaller.OpenAviFileName(str, Environment.getExternalStorageDirectory() + "/" + ContentCommon.SDCARD_PATH + "/video/" + ContentCommon.SAVEFILES + "/" + this.name, "h264", this.height, this.width, this.frame, JosStatusCodes.RTN_CODE_COMMON_ERROR);
                    this.widthRun = this.width;
                    this.heightRun = this.height;
                } else {
                    File file2 = new File(Environment.getExternalStorageDirectory(), "YGCamera/video/ALLFile");
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    String str2 = this.szDid;
                    NativeCaller.OpenAviFileName(str2, Environment.getExternalStorageDirectory() + "/" + ContentCommon.SDCARD_PATH + "/video/" + ContentCommon.SAVEFILES + "/" + this.name, "mjpg", this.height, this.width, this.frame, JosStatusCodes.RTN_CODE_COMMON_ERROR);
                    this.widthRun = this.width;
                    this.heightRun = this.height;
                }
            }
            int i = this.video_i;
            if (i > 1 && i < 120000 / this.sleepTime) {
                if (this.widthRun == this.width && this.heightRun == this.height) {
                    this.audioByte = this.audioBuffer.RemoveAudioData();
                    this.videoByte = this.videoBuffer.RemoveData();
                    Log.e(ContentCommon.SERVER_STRING, "video start write1");
                    if (this.tag != 0) {
                        this.thisIoP = this.iorPBuffer.RemoveData();
                        if (this.videoByte == null) {
                            this.videoByte = new byte[0];
                        }
                        String str3 = this.szDid;
                        byte[] bArr = this.videoByte;
                        NativeCaller.WriteData(str3, bArr, bArr.length, this.thisIoP);
                        Log.e(ContentCommon.SERVER_STRING, "kkkkkWriteVideoData width:" + this.width + "  heigh:" + this.height);
                    } else {
                        if (this.videoByte == null) {
                            this.videoByte = new byte[0];
                        }
                        String str4 = this.szDid;
                        byte[] bArr2 = this.videoByte;
                        NativeCaller.WriteData(str4, bArr2, bArr2.length, 1);
                    }
                    byte[] bArr3 = this.audioByte;
                    if (bArr3 != null) {
                        NativeCaller.WriteAudioData(this.szDid, bArr3, bArr3.length);
                        Log.i(ContentCommon.SERVER_STRING, "kkkkkWriteAudioData");
                    }
                    this.audioByte = this.audioBuffer.RemoveAudioData();
                    byte[] bArr4 = this.audioByte;
                    if (bArr4 != null) {
                        NativeCaller.WriteAudioData(this.szDid, bArr4, bArr4.length);
                        Log.i(ContentCommon.SERVER_STRING, "kkkkkWriteAudioData");
                    }
                } else {
                    Log.e(ContentCommon.SERVER_STRING, "video writedata width:" + this.width + "  heigh:" + this.height + "   widthRun:" + this.widthRun + "   heightRun:" + this.heightRun);
                    NativeCaller.CloseAvi(this.szDid);
                    this.videoBuffer.ClearAll();
                    if (this.video_i < 20) {
                        boolean delete = new File(Environment.getExternalStorageDirectory() + "/" + ContentCommon.SDCARD_PATH + "/video/" + ContentCommon.SAVEFILES + "/" + this.name).delete();
                        StringBuilder sb = new StringBuilder();
                        sb.append("if delect====");
                        sb.append(delete);
                        Log.e("tagdel", sb.toString());
                    }
                    this.video_i = 0;
                }
            }
            if (this.video_i == 120000 / this.sleepTime) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                this.availableBlocks = (long) statFs.getAvailableBlocks();
                this.blockSize = (long) statFs.getBlockSize();
                if ((this.availableBlocks * this.blockSize) / 1048576 < 50) {
                    NativeCaller.CloseAvi(this.szDid);
                    clearAll();
                    this.isStart = false;
                    this.video_i = 0;
                    break;
                }
                NativeCaller.CloseAvi(this.szDid);
                this.video_i = 0;
            } else {
                continue;
            }
        }
        super.run();
    }
}
