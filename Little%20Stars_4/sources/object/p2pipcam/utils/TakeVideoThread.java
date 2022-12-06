package object.p2pipcam.utils;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tzh.ipcamera.presenter.LogUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;

@SuppressLint({"SimpleDateFormat"})
public class TakeVideoThread extends Thread {
    public static final int Y_TYPE_H264 = 1;
    public static final int Y_TYPE_H2654 = 2;
    public static final int Y_TYPE_MJPEG = 0;
    private AudioBuffer audioBuffer = null;
    private byte[] audioByte;
    private long availableBlocks;
    private long blockSize;
    private int frame = 5;
    public int hTarget = 0;
    public int height = 0;
    private int heightRun = 0;
    private IorPBuffer iorPBuffer = null;
    private boolean isStart = false;
    private boolean isone = false;
    LogUtils logUtils = LogUtils.setLogger(TakeVideoThread.class);
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
    public int wTarget = 0;
    public int width = 0;
    private int widthRun = 0;

    public TakeVideoThread(int i, String str, int i2, int i3, int i4, int i5, int i6) {
        Log.e("test", "video tag:" + i + "  did:" + str + "  frame:" + i2 + "  width:" + i3 + "  height:" + i4);
        this.szDid = str;
        this.tag = i;
        this.frame = 15;
        if (i2 == 0) {
            this.frame = 15;
        }
        this.sleepTime = PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_NOTIFICATIONSERVICE / this.frame;
        this.width = i3;
        this.height = i4;
        this.wTarget = i5;
        this.hTarget = i6;
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
        Log.e("test", "video data width:" + i2 + "  heigh:" + i3);
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
        NativeCaller.iYuanRelease();
    }

    public void run() {
        while (true) {
            if (!this.isStart) {
                break;
            }
            Log.e("test", "video start:" + this.isStart);
            this.video_i = this.video_i + 1;
            try {
                Thread.sleep((long) this.sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (this.video_i == 1) {
                this.name = getDateTime();
                if (this.tag > 0) {
                    File file = new File(Environment.getExternalStorageDirectory(), "LittleStars/video");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String format = String.format("%s%s.mp4", new Object[]{file.getAbsolutePath(), this.name});
                    File file2 = new File(format);
                    if (!file2.exists()) {
                        try {
                            file2.createNewFile();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    NativeCaller.iYuanInit(this.width, this.height, this.wTarget, this.hTarget, 0, 10, 4194304, format);
                    LogUtils logUtils2 = this.logUtils;
                    logUtils2.e("### iYuanInit! " + format);
                    this.widthRun = this.width;
                    this.heightRun = this.height;
                } else {
                    File file3 = new File(Environment.getExternalStorageDirectory(), "LittleStars/video");
                    if (!file3.exists()) {
                        file3.mkdirs();
                    }
                    String format2 = String.format("%s/%s.mp4", new Object[]{file3.getAbsolutePath(), this.name});
                    LogUtils logUtils3 = this.logUtils;
                    logUtils3.e("###recordPath:" + format2);
                    int i = this.width;
                    int i2 = this.height;
                    NativeCaller.iYuanInit(i, i2, i, i2, 0, 10, 4194304, format2);
                    this.logUtils.e("### iYuanInit! start rec");
                    this.widthRun = this.width;
                    this.heightRun = this.height;
                }
            }
            int i3 = this.video_i;
            if (i3 > 1 && i3 < 120000 / this.sleepTime) {
                if (this.widthRun == this.width && this.heightRun == this.height) {
                    this.audioByte = this.audioBuffer.RemoveAudioData();
                    this.videoByte = this.videoBuffer.RemoveData();
                    Log.e("test", "video start write1");
                    if (this.tag != 0) {
                        this.thisIoP = this.iorPBuffer.RemoveData();
                        if (this.videoByte == null) {
                            this.videoByte = new byte[0];
                        }
                        byte[] bArr = this.videoByte;
                        NativeCaller.iYuanProc(bArr, bArr.length);
                        this.logUtils.e("###iYuanProc 111");
                    } else {
                        if (this.videoByte == null) {
                            this.videoByte = new byte[0];
                        }
                        byte[] bArr2 = this.videoByte;
                        NativeCaller.iYuanProc(bArr2, bArr2.length);
                        this.logUtils.e("###iYuanProc 111");
                    }
                    if (this.audioByte != null) {
                        Log.i("test", "kkkkkWriteAudioData");
                    }
                    this.audioByte = this.audioBuffer.RemoveAudioData();
                    if (this.audioByte != null) {
                        Log.i("test", "kkkkkWriteAudioData");
                    }
                } else {
                    Log.e("test", "video writedata width:" + this.width + "  heigh:" + this.height + "   widthRun:" + this.widthRun + "   heightRun:" + this.heightRun);
                    NativeCaller.iYuanRelease();
                    this.videoBuffer.ClearAll();
                    if (this.video_i < 20) {
                        boolean delete = new File(Environment.getExternalStorageDirectory() + "/" + ContentCommon.SDCARD_PATH + "/video/" + this.name + ".mp4").delete();
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
                    NativeCaller.iYuanRelease();
                    clearAll();
                    this.isStart = false;
                    this.video_i = 0;
                    break;
                }
                NativeCaller.iYuanRelease();
                this.video_i = 0;
            } else {
                continue;
            }
        }
        super.run();
    }

    private String getDateTime() {
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        Log.d("tag", "record strDate:" + format);
        return this.strDID + "!" + ContentCommon.SDCARD_PATH + "_" + format;
    }
}
