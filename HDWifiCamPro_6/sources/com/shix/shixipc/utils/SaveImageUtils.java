package com.shix.shixipc.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.Toast;
import com.vungle.warren.model.Advertisement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveImageUtils {
    public static void saveImageToGallery(Context context, Bitmap bitmap) {
        File file = new File(CommonUtil.getSDFilePath(), "Boohee");
        if (!file.exists()) {
            file.mkdir();
        }
        String str = System.currentTimeMillis() + ".jpg";
        File file2 = new File(file, str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(), file2.getAbsolutePath(), str, (String) null);
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
        }
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse(Advertisement.FILE_SCHEME + file2.getPath())));
    }

    public static void saveImageToGallerys(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            Toast.makeText(context, "保存出错了...", 0).show();
            return;
        }
        File file = new File(CommonUtil.getSDFilePath(), "Boohee");
        if (!file.exists()) {
            file.mkdir();
        }
        String str = System.currentTimeMillis() + ".jpg";
        File file2 = new File(file, str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            Toast.makeText(context, "文件未发现...", 0).show();
            e.printStackTrace();
        } catch (IOException e2) {
            Toast.makeText(context, "保存出错了...", 0).show();
            e2.printStackTrace();
        } catch (Exception e3) {
            Toast.makeText(context, "保存出错了...", 0).show();
            e3.printStackTrace();
        }
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(), file2.getAbsolutePath(), str, (String) null);
        } catch (FileNotFoundException e4) {
            e4.printStackTrace();
        }
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file2));
        context.sendBroadcast(intent);
        Toast.makeText(context, "保存出错了...", 0).show();
    }
}
