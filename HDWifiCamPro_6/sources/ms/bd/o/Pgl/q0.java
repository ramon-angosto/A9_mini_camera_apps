package ms.bd.o.Pgl;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class q0 extends o0 {
    private Interceptor a;
    /* access modifiers changed from: private */
    public long b;

    class pgla implements Interceptor {
        pgla() {
        }

        public SsResponse intercept(Interceptor.Chain chain) throws Exception {
            SsResponse proceed = chain.proceed(chain.request());
            Iterator it = proceed.headers().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Header header = (Header) it.next();
                if (((String) pblk.a(16777217, 0, 0, "b86b16", new byte[]{107, 119, 81, 91, 20, 41, 102})).equals(header.getName()) && header.getValue() != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add((String) pblk.a(16777217, 0, 0, "eb8180", new byte[]{102, 101, 91, 122, 3, 38, 114, 66}));
                    arrayList.add(header.getValue());
                    pblb.a(117440513, 0, q0.this.b, (String) pblk.a(16777217, 0, 0, "e1acaa", new byte[]{102, 54, 2, 24, 76, 98}), (String[]) arrayList.toArray(new String[0]));
                    break;
                }
            }
            return proceed;
        }
    }

    /* access modifiers changed from: protected */
    public Object a(long j) {
        this.b = j;
        pgla pgla2 = new pgla();
        this.a = pgla2;
        RetrofitUtils.addInterceptor(pgla2);
        return Boolean.TRUE;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        RetrofitUtils.removeInterceptor(this.a);
        super.finalize();
    }
}
