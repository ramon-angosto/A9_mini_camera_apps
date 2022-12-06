package com.bytedance.sdk.component.adexpress.dynamic.b;

import java.util.Arrays;

/* compiled from: DynamicPoint */
public class i {
    public float a;
    public float b;

    public i(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (Float.compare(iVar.a, this.a) == 0 && Float.compare(iVar.b, this.b) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a), Float.valueOf(this.b)});
    }
}
