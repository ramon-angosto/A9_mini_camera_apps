package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;

public interface W {
    void a(X x);

    void a(X x, Placement placement);

    void a(X x, String str);

    void a(IronSourceError ironSourceError, X x);

    void b(X x);

    void b(X x, Placement placement);

    void b(X x, String str);

    void c(X x);

    void d(X x);
}
