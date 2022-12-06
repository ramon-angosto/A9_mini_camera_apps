package ms.bd.o.Pgl;

import android.content.Context;
import android.os.Process;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.ByteCompanionObject;
import ms.bd.o.Pgl.pblb;

public abstract class pblo extends pblb.pgla {
    public Object a(int i, int i2, long j, String str, Object obj) throws Throwable {
        boolean z;
        String[] strArr = {(String) pblk.a(16777217, 0, 0, "ce879f", new byte[]{115, 105, 79, 81, 9, 120, 100, 10, 121, 98, 96, 106, 66, 80, 21, 120, 111, 74, 39, 78, 92, 83, 110, 113, 40, 84, 84})};
        try {
            Context b = pgla.a().b();
            int i3 = 0;
            while (true) {
                if (i3 >= 1) {
                    z = true;
                    break;
                } else if (b.checkPermission(strArr[i3], Process.myPid(), Process.myUid()) != 0) {
                    break;
                } else {
                    i3++;
                }
            }
        } catch (Throwable unused) {
        }
        z = false;
        if (!z) {
            return null;
        }
        switch (i) {
            case 196609:
                Object[] objArr = (Object[]) obj;
                return a(str, (byte[]) objArr[0], (String) objArr[1], (String) objArr[2]);
            case 196610:
                Object[] objArr2 = (Object[]) obj;
                return b(str, (String) objArr2[0], (String) objArr2[1]);
            case 196611:
                Object[] objArr3 = (Object[]) obj;
                return a(str, (String) objArr3[0], (String) objArr3[1]);
            default:
                return super.a(i, i2, j, str, obj);
        }
    }

    /* access modifiers changed from: protected */
    public void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
                String str = (String) pblk.a(16777217, 0, 0, "c3cb49", new byte[]{ByteCompanionObject.MAX_VALUE, 50, 47, 21, 2});
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
                String str = (String) pblk.a(16777217, 0, 0, "cfc1d9", new byte[]{ByteCompanionObject.MAX_VALUE, 103, 47, 70, 84});
            }
        }
    }

    public abstract Object[] a(String str, String str2, String str3);

    public abstract Object[] a(String str, byte[] bArr, String str2, String str3);

    public abstract Object[] b(String str, String str2, String str3);
}
