package com.ironsource.mediationsdk.adunit.c;

import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.B;
import com.ironsource.mediationsdk.C0155h;
import com.ironsource.mediationsdk.C0156i;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.aa;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdInteractionAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.adunit.c.b.a;
import com.ironsource.mediationsdk.adunit.c.e;
import com.ironsource.mediationsdk.adunit.d.a.a;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.server.b;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.k;
import com.ironsource.mediationsdk.utils.o;
import java.util.Iterator;
import java.util.Set;

public abstract class d<Smash extends a<?>, Adapter extends BaseAdInteractionAdapter<?, ? extends AdapterAdInteractionListener>> extends e<Smash, Adapter> implements com.ironsource.mediationsdk.adunit.c.a.a {
    public d(a aVar, Set<ImpressionDataListener> set, IronSourceSegment ironSourceSegment) {
        super(aVar, set, ironSourceSegment);
    }

    private void a(IronSourceError ironSourceError, String str) {
        this.q.d.a(h(), ironSourceError.getErrorCode(), ironSourceError.getErrorMessage(), str);
        this.o.b();
        this.r.b(ironSourceError);
        if (this.m.h.b()) {
            a(false, false);
        }
    }

    public final void a(a<?> aVar) {
        IronLog.INTERNAL.verbose(a(aVar.l()));
        b bVar = this.r;
        if (bVar.a == IronSource.AD_UNIT.INTERSTITIAL) {
            B.a().e();
        } else if (bVar.a != IronSource.AD_UNIT.REWARDED_VIDEO) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.warning("ad unit not supported - " + bVar.a);
        }
    }

    public final void a(IronSourceError ironSourceError, a<?> aVar) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a(aVar.l() + " - error = " + ironSourceError));
        this.c.put(aVar.k(), C0156i.a.ISAuctionPerformanceFailedToShow);
        a(e.a.READY_TO_LOAD);
        a(ironSourceError, "");
    }

    public final void a(Placement placement) {
        a aVar;
        IronSourceError ironSourceError;
        String stringBuffer;
        IronLog.INTERNAL.verbose(a("state = " + this.n));
        synchronized (this.t) {
            this.j = placement;
            this.q.d.a(h());
            e.a aVar2 = this.n;
            e.a aVar3 = e.a.SHOWING;
            int i = IronSourceError.ERROR_CODE_GENERIC;
            aVar = null;
            if (aVar2 == aVar3) {
                IronSource.AD_UNIT ad_unit = this.m.a;
                if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
                    i = IronSourceError.ERROR_IS_SHOW_CALLED_DURING_SHOW;
                } else if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
                    i = IronSourceError.ERROR_RV_SHOW_CALLED_DURING_SHOW;
                } else {
                    IronLog.INTERNAL.warning("ad unit not supported - " + ad_unit);
                }
                ironSourceError = new IronSourceError(i, "can't show ad while an ad is already showing");
            } else if (this.n != e.a.READY_TO_SHOW) {
                ironSourceError = new IronSourceError(IronSourceError.ERROR_CODE_NO_ADS_TO_SHOW, "show called while no ads are available");
            } else if (placement == null) {
                IronSource.AD_UNIT ad_unit2 = this.m.a;
                if (ad_unit2 == IronSource.AD_UNIT.INTERSTITIAL) {
                    i = 1020;
                } else if (ad_unit2 == IronSource.AD_UNIT.REWARDED_VIDEO) {
                    i = 1021;
                } else {
                    IronLog.INTERNAL.warning("ad unit not supported - " + ad_unit2);
                }
                ironSourceError = new IronSourceError(i, "empty default placement");
            } else if (k.a(ContextProvider.getInstance().getApplicationContext(), placement.getPlacementName(), this.m.a)) {
                ironSourceError = new IronSourceError(IronSourceError.ERROR_REACHED_CAP_LIMIT_PER_PLACEMENT, "placement " + placement.getPlacementName() + " is capped");
            } else {
                ironSourceError = null;
            }
            if (ironSourceError != null) {
                IronLog.API.error(a(ironSourceError.getErrorMessage()));
                stringBuffer = "";
            } else {
                StringBuffer stringBuffer2 = new StringBuffer();
                Iterator it = this.a.a().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a aVar4 = (a) it.next();
                    if (aVar4.a()) {
                        a(e.a.SHOWING);
                        aVar4.a(true);
                        aVar = aVar4;
                        break;
                    }
                    if (aVar4.g() != null) {
                        stringBuffer2.append(aVar4.k() + ":" + aVar4.g() + ",");
                    }
                    aVar4.a(false);
                    IronLog.INTERNAL.verbose(a(aVar4.l() + " - not ready to show"));
                }
                if (aVar == null) {
                    ironSourceError = ErrorBuilder.buildNoAdsToShowError(this.m.a.toString());
                    stringBuffer = stringBuffer2.toString();
                }
            }
            a(ironSourceError, stringBuffer);
        }
        if (aVar != null) {
            Placement placement2 = this.j;
            if (this.m.h.b()) {
                this.p.a();
            }
            aVar.a(placement2);
        }
    }

    public final void b(a<?> aVar) {
        IronLog.INTERNAL.verbose(a(aVar.l()));
        this.a.a(aVar);
        this.l.a(aVar);
        if (this.l.b(aVar)) {
            IronLog.INTERNAL.verbose(a(aVar.k() + " was session capped"));
            aVar.f();
            IronSourceUtils.sendAutomationLog(aVar.k() + " was session capped");
        }
        k.b(ContextProvider.getInstance().getApplicationContext(), h(), this.m.a);
        if (k.a(ContextProvider.getInstance().getApplicationContext(), h(), this.m.a)) {
            IronLog.INTERNAL.verbose(a("placement " + h() + " is capped"));
            this.q.d.h(h());
        }
        b bVar = this.r;
        if (bVar.a == IronSource.AD_UNIT.INTERSTITIAL) {
            B.a().c();
        } else if (bVar.a == IronSource.AD_UNIT.REWARDED_VIDEO) {
            aa.a().b();
        } else {
            IronLog.INTERNAL.warning("ad unit not supported - " + bVar.a);
        }
        if (this.m.h.b()) {
            a(false, false);
        }
        o.a().a(this.m.a);
        if (this.m.a()) {
            b bVar2 = (b) this.b.get(aVar.k());
            if (bVar2 != null) {
                C0155h.a(bVar2, aVar.i(), this.i, h());
                this.c.put(aVar.k(), C0156i.a.ISAuctionPerformanceShowedSuccessfully);
                a(bVar2, h());
            } else {
                String k = aVar.k();
                String str = "showing instance missing from waterfall - " + k;
                IronLog.INTERNAL.verbose(a(str));
                this.q.e.a(1011, str, k);
            }
        }
        c cVar = this.o;
        if (cVar.a.a == a.C0091a.AUTOMATIC_LOAD_WHILE_SHOW) {
            cVar.a(cVar.a.b);
        }
    }

    public final boolean b() {
        if (!f()) {
            return false;
        }
        if (this.k && !IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getApplicationContext())) {
            return false;
        }
        Iterator it = this.a.a().iterator();
        while (it.hasNext()) {
            if (((com.ironsource.mediationsdk.adunit.d.a.a) it.next()).a()) {
                return true;
            }
        }
        return false;
    }

    public final String c() {
        StringBuilder sb = new StringBuilder();
        if (this.n == e.a.READY_TO_SHOW) {
            Iterator it = this.a.a().iterator();
            while (it.hasNext()) {
                com.ironsource.mediationsdk.adunit.d.a.a aVar = (com.ironsource.mediationsdk.adunit.d.a.a) it.next();
                if (aVar.d()) {
                    sb.append(aVar.k() + ";");
                }
            }
        }
        return sb.toString();
    }

    public final void c(com.ironsource.mediationsdk.adunit.d.a.a<?> aVar) {
        IronLog.INTERNAL.verbose(a(aVar.l()));
        if (this.n == e.a.SHOWING) {
            a(e.a.READY_TO_LOAD);
        }
        c cVar = this.o;
        if (cVar.a.a == a.C0091a.AUTOMATIC_LOAD_AFTER_CLOSE) {
            cVar.a(cVar.a.b);
        }
        b bVar = this.r;
        if (bVar.a == IronSource.AD_UNIT.INTERSTITIAL) {
            B.a().d();
        } else if (bVar.a == IronSource.AD_UNIT.REWARDED_VIDEO) {
            aa.a().c();
        } else {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.warning("ad unit not supported - " + bVar.a);
        }
    }

    public final void d(com.ironsource.mediationsdk.adunit.d.a.a<?> aVar) {
        IronLog.INTERNAL.verbose(a(aVar.l()));
        b bVar = this.r;
        if (bVar.a == IronSource.AD_UNIT.REWARDED_VIDEO) {
            aa.a().d();
            return;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.warning("ad unit not supported - " + bVar.a);
    }

    public final void e(com.ironsource.mediationsdk.adunit.d.a.a<?> aVar) {
        IronLog.INTERNAL.verbose(a(aVar.l()));
        b bVar = this.r;
        if (bVar.a == IronSource.AD_UNIT.REWARDED_VIDEO) {
            aa.a().e();
            return;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.warning("ad unit not supported - " + bVar.a);
    }
}
