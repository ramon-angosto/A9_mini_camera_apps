package com.a.a.a.a.e;

import android.text.TextUtils;
import com.a.a.a.a.a;
import com.a.a.a.a.b.f;
import com.a.a.a.a.b.h;
import com.a.a.a.a.b.i;
import com.a.a.a.a.b.m;

public class e {
    public static void a() {
        if (!a.a()) {
            throw new IllegalStateException("Method called before OM SDK activation");
        }
    }

    public static void a(i iVar, f fVar, h hVar) {
        if (iVar == i.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        } else if (fVar == f.DEFINED_BY_JAVASCRIPT && iVar == i.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        } else if (hVar == h.DEFINED_BY_JAVASCRIPT && iVar == i.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
    }

    public static void a(m mVar) {
        if (mVar.l()) {
            throw new IllegalStateException("AdSession is started");
        }
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void a(String str, int i, String str2) {
        if (str.length() > i) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void b(m mVar) {
        if (mVar.m()) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    public static void c(m mVar) {
        h(mVar);
        b(mVar);
    }

    public static void d(m mVar) {
        if (mVar.i().d() != null) {
            throw new IllegalStateException("AdEvents already exists for AdSession");
        }
    }

    public static void e(m mVar) {
        if (mVar.i().e() != null) {
            throw new IllegalStateException("MediaEvents already exists for AdSession");
        }
    }

    public static void f(m mVar) {
        if (!mVar.n()) {
            throw new IllegalStateException("Impression event is not expected from the Native AdSession");
        }
    }

    public static void g(m mVar) {
        if (!mVar.o()) {
            throw new IllegalStateException("Cannot create MediaEvents for JavaScript AdSession");
        }
    }

    private static void h(m mVar) {
        if (!mVar.l()) {
            throw new IllegalStateException("AdSession is not started");
        }
    }
}
