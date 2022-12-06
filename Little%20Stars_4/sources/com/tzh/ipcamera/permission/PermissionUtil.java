package com.tzh.ipcamera.permission;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import java.util.ArrayList;

public class PermissionUtil {
    public static String[] getDeniedPermissions(Context context, String[] strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (context.checkSelfPermission(str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return null;
    }

    public static void PermissionDialog(final Activity activity, String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setCancelable(false);
        builder.setMessage(str);
        builder.setNegativeButton("算了", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                activity.finish();
            }
        });
        builder.setPositiveButton("去设置", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.parse("package:" + activity.getPackageName()));
                activity.startActivity(intent);
            }
        });
        builder.create().show();
    }

    public static String permissionText(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            if (str.equals("android.permission.CAMERA")) {
                sb.append("相机权限(用于拍照，视频聊天);\n");
            } else if (str.equals("android.permission.RECORD_AUDIO")) {
                sb.append("麦克风权限(用于发语音，语音及视频聊天);\n");
            } else if (str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                sb.append("读取权限(用于读取数据);\n");
            } else if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                sb.append("存储(用于存储必要信息，缓存数据);\n");
            }
        }
        return "程序运行需要如下权限：\n" + sb.toString();
    }
}
