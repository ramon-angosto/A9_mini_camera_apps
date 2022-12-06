package com.huawei.android.pushselfshow.utils.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.b.a;
import com.huawei.android.pushselfshow.richpush.a.b;
import com.huawei.android.pushselfshow.richpush.favorites.f;
import com.huawei.android.pushselfshow.richpush.provider.RichMediaProvider;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;

public class c {
    public static ArrayList a(Context context, String str) {
        String str2;
        String[] strArr;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        if (str == null) {
            str2 = "SELECT pushmsg._id,pushmsg.msg,pushmsg.token,pushmsg.url,notify.bmp  FROM pushmsg LEFT OUTER JOIN notify ON pushmsg.url = notify.url order by pushmsg._id desc limit 1000;";
            strArr = null;
        } else {
            strArr = new String[]{str};
            str2 = "SELECT pushmsg._id,pushmsg.msg,pushmsg.token,pushmsg.url,notify.bmp  FROM pushmsg LEFT OUTER JOIN notify ON pushmsg.url = notify.url and pushmsg.url = ? order by pushmsg._id desc";
        }
        try {
            cursor = b.a().a(context, RichMediaProvider.a.f, str2, strArr);
        } catch (Exception e) {
            e.c("PushSelfShowLog", e.toString(), e);
        }
        if (cursor == null) {
            e.a("PushSelfShowLog", "cursor is null.");
            return arrayList;
        }
        while (cursor.moveToNext()) {
            try {
                int i = cursor.getInt(0);
                byte[] blob = cursor.getBlob(1);
                if (blob == null) {
                    e.d("PushSelfShowLog", "msg is null");
                } else {
                    a aVar = new a(blob, " ".getBytes("UTF-8"));
                    if (!aVar.b()) {
                        e.a("PushSelfShowLog", "parseMessage failed");
                    }
                    String string = cursor.getString(3);
                    f fVar = new f();
                    fVar.a(i);
                    fVar.a(string);
                    fVar.a(aVar);
                    arrayList.add(fVar);
                }
            } catch (Exception e2) {
                e.c("TAG", "query favo error " + e2.toString(), e2);
            } catch (Throwable th) {
                cursor.close();
                throw th;
            }
        }
        cursor.close();
        e.e("PushSelfShowLog", "query favo size is " + arrayList.size());
        return arrayList;
    }

    public static void a(Context context, int i) {
        try {
            b a = b.a();
            Uri uri = RichMediaProvider.a.g;
            a.a(context, uri, "pushmsg", "_id = ?", new String[]{"" + i});
        } catch (Exception e) {
            e.c("PushSelfShowLog", e.toString(), e);
        }
    }

    public static boolean a(Context context, String str, a aVar) {
        if (context == null || str == null || aVar == null) {
            e.e("PushSelfShowLog", "insertPushMsginfo ilegle param");
            return false;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(PushConstants.WEB_URL, str);
            contentValues.put("msg", aVar.c());
            contentValues.put(Constants.EXTRA_KEY_TOKEN, " ".getBytes("UTF-8"));
            e.a("PushSelfShowLog", "insertPushMsginfo select url is %s ,rpl is %s", str, aVar.C);
            ArrayList a = a(context, str);
            String str2 = aVar.C;
            int i = 0;
            while (i < a.size()) {
                if (((f) a.get(i)).b() == null || !str2.equals(((f) a.get(i)).b().C)) {
                    i++;
                } else {
                    e.a("PushSelfShowLog", str2 + " already exist");
                    return true;
                }
            }
            e.e("PushSelfShowLog", "insertPushMsginfo " + contentValues.toString());
            b.a().a(context, RichMediaProvider.a.e, "pushmsg", contentValues);
            return true;
        } catch (Exception e) {
            e.d("PushSelfShowLog", "insertBmpinfo error", e);
            return false;
        }
    }
}
