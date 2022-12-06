package sg.bigo.ads.common.l.c;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.Closeable;
import java.io.InputStream;
import java.util.List;
import sg.bigo.ads.common.utils.g;
import sg.bigo.ads.common.utils.o;

public final class a implements c<InputStream> {
    public final int a;
    public final InputStream b;
    public final g<List<String>> c;
    private final int d;
    private final Closeable e;

    public a(int i, int i2, InputStream inputStream, g<List<String>> gVar, Closeable closeable) {
        this.d = i;
        this.a = i2;
        this.b = inputStream;
        this.c = gVar;
        this.e = closeable;
    }

    public final long a() {
        String a2 = a(HttpHeaders.CONTENT_LENGTH);
        if (o.c(a2)) {
            try {
                return Long.parseLong(a2);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
        return -1;
    }

    public final String a(String str) {
        List<String> a2;
        if (!TextUtils.isEmpty(str) && (a2 = this.c.a(str)) != null && !a2.isEmpty()) {
            for (String str2 : a2) {
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
            }
        }
        return "";
    }
}
