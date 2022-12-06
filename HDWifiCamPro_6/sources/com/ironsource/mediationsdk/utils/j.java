package com.ironsource.mediationsdk.utils;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J?\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018¨\u0006&"}, d2 = {"Lcom/ironsource/mediationsdk/utils/PixelSettings;", "", "pixelEventsEnabled", "", "pixelEventsUrl", "", "pixelEventsCompression", "pixelOptOut", "", "pixelOptIn", "(ZLjava/lang/String;Z[I[I)V", "getPixelEventsCompression", "()Z", "setPixelEventsCompression", "(Z)V", "getPixelEventsEnabled", "setPixelEventsEnabled", "getPixelEventsUrl", "()Ljava/lang/String;", "setPixelEventsUrl", "(Ljava/lang/String;)V", "getPixelOptIn", "()[I", "setPixelOptIn", "([I)V", "getPixelOptOut", "setPixelOptOut", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "mediationsdk_release"}, k = 1, mv = {1, 4, 2})
public final class j {
    public boolean a;
    public String b;
    public boolean c;
    public int[] d;
    public int[] e;

    public j() {
        this(false, (String) null, false, (int[]) null, (int[]) null, 31);
    }

    private j(boolean z, String str, boolean z2, int[] iArr, int[] iArr2) {
        Intrinsics.checkNotNullParameter(str, "pixelEventsUrl");
        this.a = z;
        this.b = str;
        this.c = z2;
        this.d = iArr;
        this.e = iArr2;
    }

    private /* synthetic */ j(boolean z, String str, boolean z2, int[] iArr, int[] iArr2, int i) {
        this(true, "https://outcome-ssp.supersonicads.com/mediation?adUnit=3", false, (int[]) null, (int[]) null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.a == jVar.a && Intrinsics.areEqual((Object) this.b, (Object) jVar.b) && this.c == jVar.c && Intrinsics.areEqual((Object) this.d, (Object) jVar.d) && Intrinsics.areEqual((Object) this.e, (Object) jVar.e);
    }

    public final int hashCode() {
        boolean z = this.a;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        String str = this.b;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z3 = this.c;
        if (!z3) {
            z2 = z3;
        }
        int i3 = (hashCode + (z2 ? 1 : 0)) * 31;
        int[] iArr = this.d;
        int hashCode2 = (i3 + (iArr != null ? Arrays.hashCode(iArr) : 0)) * 31;
        int[] iArr2 = this.e;
        if (iArr2 != null) {
            i2 = Arrays.hashCode(iArr2);
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "PixelSettings(pixelEventsEnabled=" + this.a + ", pixelEventsUrl=" + this.b + ", pixelEventsCompression=" + this.c + ", pixelOptOut=" + Arrays.toString(this.d) + ", pixelOptIn=" + Arrays.toString(this.e) + ")";
    }
}
