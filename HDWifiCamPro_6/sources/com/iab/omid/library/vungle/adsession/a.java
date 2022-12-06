package com.iab.omid.library.vungle.adsession;

import android.view.View;
import com.iab.omid.library.vungle.b.c;
import com.iab.omid.library.vungle.b.f;
import com.iab.omid.library.vungle.d.e;
import com.iab.omid.library.vungle.publisher.AdSessionStatePublisher;
import com.iab.omid.library.vungle.publisher.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class a extends AdSession {
    private static final Pattern a = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final AdSessionContext b;
    private final AdSessionConfiguration c;
    private final List<c> d = new ArrayList();
    private com.iab.omid.library.vungle.e.a e;
    private AdSessionStatePublisher f;
    private boolean g = false;
    private boolean h = false;
    private final String i;
    private boolean j;
    private boolean k;

    a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this.c = adSessionConfiguration;
        this.b = adSessionContext;
        this.i = UUID.randomUUID().toString();
        c((View) null);
        this.f = (adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML || adSessionContext.getAdSessionContextType() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.vungle.publisher.a(adSessionContext.getWebView()) : new b(adSessionContext.getInjectedResourcesMap(), adSessionContext.getOmidJsScriptContent());
        this.f.a();
        com.iab.omid.library.vungle.b.a.a().a(this);
        this.f.a(adSessionConfiguration);
    }

    private c a(View view) {
        for (c next : this.d) {
            if (next.a().get() == view) {
                return next;
            }
        }
        return null;
    }

    private void a(String str) {
        if (str == null) {
            return;
        }
        if (str.length() > 50) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
        } else if (!a.matcher(str).matches()) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
        }
    }

    private static void b(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    private void c(View view) {
        this.e = new com.iab.omid.library.vungle.e.a(view);
    }

    private void d(View view) {
        Collection<a> b2 = com.iab.omid.library.vungle.b.a.a().b();
        if (b2 != null && !b2.isEmpty()) {
            for (a next : b2) {
                if (next != this && next.d() == view) {
                    next.e.clear();
                }
            }
        }
    }

    private void j() {
        if (this.j) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    private void k() {
        if (this.k) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    public List<c> a() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        k();
        getAdSessionStatePublisher().a(jSONObject);
        this.k = true;
    }

    public void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        if (!this.h) {
            b(view);
            a(str);
            if (a(view) == null) {
                this.d.add(new c(view, friendlyObstructionPurpose, str));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        j();
        getAdSessionStatePublisher().g();
        this.j = true;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        k();
        getAdSessionStatePublisher().h();
        this.k = true;
    }

    public View d() {
        return (View) this.e.get();
    }

    public boolean e() {
        return this.g && !this.h;
    }

    public void error(ErrorType errorType, String str) {
        if (!this.h) {
            e.a((Object) errorType, "Error type is null");
            e.a(str, "Message is null");
            getAdSessionStatePublisher().a(errorType, str);
            return;
        }
        throw new IllegalStateException("AdSession is finished");
    }

    public boolean f() {
        return this.g;
    }

    public void finish() {
        if (!this.h) {
            this.e.clear();
            removeAllFriendlyObstructions();
            this.h = true;
            getAdSessionStatePublisher().f();
            com.iab.omid.library.vungle.b.a.a().c(this);
            getAdSessionStatePublisher().b();
            this.f = null;
        }
    }

    public boolean g() {
        return this.h;
    }

    public String getAdSessionId() {
        return this.i;
    }

    public AdSessionStatePublisher getAdSessionStatePublisher() {
        return this.f;
    }

    public boolean h() {
        return this.c.isNativeImpressionOwner();
    }

    public boolean i() {
        return this.c.isNativeMediaEventsOwner();
    }

    public void registerAdView(View view) {
        if (!this.h) {
            e.a((Object) view, "AdView is null");
            if (d() != view) {
                c(view);
                getAdSessionStatePublisher().i();
                d(view);
            }
        }
    }

    public void removeAllFriendlyObstructions() {
        if (!this.h) {
            this.d.clear();
        }
    }

    public void removeFriendlyObstruction(View view) {
        if (!this.h) {
            b(view);
            c a2 = a(view);
            if (a2 != null) {
                this.d.remove(a2);
            }
        }
    }

    public void start() {
        if (!this.g) {
            this.g = true;
            com.iab.omid.library.vungle.b.a.a().b(this);
            this.f.a(f.a().d());
            this.f.a(this, this.b);
        }
    }
}
