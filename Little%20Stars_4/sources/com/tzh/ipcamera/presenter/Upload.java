package com.tzh.ipcamera.presenter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import com.tzh.ipcamera.view.AblumUtils;
import java.io.File;
import java.io.FileNotFoundException;

public class Upload {
    private Context mContext;
    private long tStart = System.currentTimeMillis();

    public Upload(Context context) {
        this.mContext = context;
    }

    public void uploadImg(File file) {
        try {
            MediaStore.Images.Media.insertImage(this.mContext.getContentResolver(), file.getAbsolutePath(), file.getName(), (String) null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Context context = this.mContext;
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
    }

    public void uploadVideo(File file) {
        AblumUtils.getInstance(this.mContext).insertVideoToMediaStore(this.mContext, file.getAbsolutePath(), this.tStart, 640, 480, System.currentTimeMillis() - this.tStart);
    }
}
