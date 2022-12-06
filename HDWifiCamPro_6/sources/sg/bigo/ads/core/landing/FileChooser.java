package sg.bigo.ads.core.landing;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.webkit.ValueCallback;
import java.util.ArrayList;
import sg.bigo.ads.common.k.a;
import sg.bigo.ads.common.utils.o;

public class FileChooser {
    final Activity a;
    ValueCallback<Uri> b;
    ValueCallback<Uri[]> c;

    public FileChooser(Activity activity) {
        this.a = activity;
    }

    /* JADX WARNING: type inference failed for: r8v8, types: [java.lang.Object[], java.io.Serializable] */
    /* access modifiers changed from: package-private */
    public final void a(String... strArr) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        ArrayList arrayList = new ArrayList();
        if (strArr != null) {
            for (String str : strArr) {
                if (!o.b(str)) {
                    arrayList.add(str);
                }
            }
        }
        if (arrayList.isEmpty()) {
            intent.setType("*/*");
        } else {
            intent.setType((String) arrayList.get(0));
            if (Build.VERSION.SDK_INT >= 19 && arrayList.size() > 1) {
                intent.putExtra("android.intent.extra.MIME_TYPES", arrayList.toArray());
            }
        }
        this.a.startActivityForResult(Intent.createChooser(intent, "Select File"), 101);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        a.a(0, 3, "FileChooser", "openFileChooser");
        this.b = valueCallback;
        a(str);
    }
}
