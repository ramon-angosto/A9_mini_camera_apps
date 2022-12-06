package sg.bigo.ads.core.player.a.a;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.common.utils.e;

public final class a implements sg.bigo.ads.core.player.a.a {
    public File a;
    public sg.bigo.ads.common.d.a b;
    private RandomAccessFile c;

    public a(sg.bigo.ads.common.d.a aVar) {
        try {
            this.b = aVar;
            this.a = new File(aVar.a());
            this.a = this.a.exists() ? this.a : new File(this.a.getParentFile(), e.c(this.a.getName()));
            this.c = new RandomAccessFile(this.a, CampaignEx.JSON_KEY_AD_R);
        } catch (IOException e) {
            sg.bigo.ads.common.k.a.a(0, "ProxyCache", "Error using file " + this.a + " as disc cache, error message is : " + e.toString());
        }
    }

    public final synchronized int a(byte[] bArr, long j) {
        int i;
        i = 0;
        try {
            this.c.seek(j);
            i = this.c.read(bArr, 0, 8192);
        } catch (IOException e) {
            sg.bigo.ads.common.k.a.a(0, "ProxyCache", "Error reading 8192 bytes with offset " + j + " from file[" + a() + " bytes] to buffer[" + bArr.length + " bytes], error message is : " + e.toString());
        }
        return i;
    }

    public final synchronized long a() {
        long j;
        j = 0;
        try {
            j = this.c.length();
        } catch (IOException e) {
            sg.bigo.ads.core.d.a.a((c) null, (int) IronSourceConstants.BN_INSTANCE_LOAD_SUCCESS, 10112, e.toString());
            sg.bigo.ads.common.k.a.a(0, "ProxyCache", "Error reading length of file " + this.a + ", error message is : " + e.toString());
        }
        return j;
    }

    public final synchronized void b() {
        try {
            this.c.close();
        } catch (IOException e) {
            sg.bigo.ads.common.k.a.a(0, "ProxyCache", "Error closing file " + this.a + ", error message is : " + e.toString());
        }
    }

    public final synchronized boolean c() {
        return this.b.b();
    }
}
