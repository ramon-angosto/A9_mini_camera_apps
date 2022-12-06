package sg.bigo.ads.ad;

import com.mbridge.msdk.MBridgeConstans;
import java.util.Map;
import sg.bigo.ads.api.AdBid;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.core.b.b;

public final class a {

    /* renamed from: sg.bigo.ads.ad.a$a  reason: collision with other inner class name */
    static class C0111a implements AdBid {
        private final g a;
        private final c b;
        private final sg.bigo.ads.core.e.a.a c;
        private boolean d = false;
        private boolean e = false;

        public C0111a(g gVar, c cVar, sg.bigo.ads.core.e.a.a aVar) {
            this.a = gVar;
            this.b = cVar;
            this.c = aVar;
        }

        public final double getPrice() {
            return this.b.N();
        }

        public final void notifyLoss(Double d2, String str, int i) {
            if (!this.e) {
                this.e = true;
                if (d2 != null) {
                    this.c.a("first_price", String.valueOf(d2));
                }
                if (str != null) {
                    this.c.a("first_bidder", str);
                }
                this.c.a("loss_reason", String.valueOf(i));
                sg.bigo.ads.common.f.c.a(1, new Runnable() {
                    final /* synthetic */ boolean a = false;

                    public final void run() {
                        a.this.d(this.a);
                    }
                });
                c cVar = this.b;
                int O = cVar.O();
                Map<String, String> b2 = sg.bigo.ads.core.d.a.b(cVar);
                b2.put("auc_mode", String.valueOf(O));
                b2.put("bid_rslt", MBridgeConstans.ENDCARD_URL_TYPE_PL);
                if (d2 != null) {
                    b2.put("first_price", String.valueOf(d2));
                }
                if (str != null) {
                    b2.put("first_bidder", str);
                }
                b2.put("loss_reason", String.valueOf(i));
                sg.bigo.ads.core.d.a.a("06002045", b2);
            }
        }

        public final void notifyWin(Double d2, String str) {
            if (!this.d) {
                this.d = true;
                if (d2 != null) {
                    this.c.a("sec_price", String.valueOf(d2));
                }
                if (str != null) {
                    this.c.a("sec_bidder", str);
                }
                sg.bigo.ads.common.f.c.a(1, new Runnable() {
                    final /* synthetic */ boolean a = false;

                    public final void run() {
                        a.this.c(this.a);
                    }
                });
                c cVar = this.b;
                int O = cVar.O();
                Map<String, String> b2 = sg.bigo.ads.core.d.a.b(cVar);
                b2.put("auc_mode", String.valueOf(O));
                b2.put("bid_rslt", "1");
                if (d2 != null) {
                    b2.put("sec_price", String.valueOf(d2));
                }
                if (str != null) {
                    b2.put("sec_bidder", str);
                }
                sg.bigo.ads.core.d.a.a("06002045", b2);
                b.a().a("win", sg.bigo.ads.core.b.a.a("win", this.a, Integer.valueOf(this.b.O()), d2 == null ? null : String.valueOf(d2), str));
            }
        }
    }
}
