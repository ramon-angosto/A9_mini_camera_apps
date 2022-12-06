package com.iab.omid.library.bigosg.b;

import com.iab.omid.library.bigosg.e.d;

public final class c {
    final i a;
    public final i b;
    final boolean c;
    final f d;
    final h e;

    private c(f fVar, h hVar, i iVar, i iVar2) {
        this.d = fVar;
        this.e = hVar;
        this.a = iVar;
        if (iVar2 == null) {
            this.b = i.NONE;
        } else {
            this.b = iVar2;
        }
        this.c = false;
    }

    public static c a(f fVar, h hVar, i iVar, i iVar2) {
        d.a((Object) fVar, "CreativeType is null");
        d.a((Object) hVar, "ImpressionType is null");
        d.a((Object) iVar, "Impression owner is null");
        if (iVar == i.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        } else if (fVar == f.DEFINED_BY_JAVASCRIPT && iVar == i.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        } else if (hVar != h.DEFINED_BY_JAVASCRIPT || iVar != i.NATIVE) {
            return new c(fVar, hVar, iVar, iVar2);
        } else {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
    }
}
