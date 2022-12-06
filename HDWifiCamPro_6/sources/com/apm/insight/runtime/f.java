package com.apm.insight.runtime;

import com.apm.insight.entity.Header;
import com.apm.insight.h;

public class f {
    private static final f b = new f() {
        Header a = null;

        public Object b(String str) {
            if (this.a == null) {
                this.a = Header.b(h.g());
            }
            return this.a.f().opt(str);
        }
    };
    private f a;

    f() {
        this(b);
    }

    f(f fVar) {
        this.a = null;
        this.a = fVar;
    }

    public Object a(String str) {
        f fVar = this.a;
        if (fVar != null) {
            return fVar.a(str);
        }
        return null;
    }

    public Object b(String str) {
        f fVar = this.a;
        if (fVar != null) {
            return fVar.b(str);
        }
        return null;
    }
}
