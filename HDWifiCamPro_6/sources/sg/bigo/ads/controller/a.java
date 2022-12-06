package sg.bigo.ads.controller;

import sg.bigo.ads.api.core.g;

public final class a implements b {
    private final b a;

    public a(b bVar) {
        this.a = bVar;
    }

    public final void a(int i, int i2, int i3, String str, Object obj) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.a(i, i2, i3, str, obj);
        }
    }

    public final /* bridge */ /* synthetic */ void a(int i, Object obj) {
        g gVar = (g) obj;
        b bVar = this.a;
        if (bVar != null) {
            bVar.a(i, gVar);
        }
    }
}
