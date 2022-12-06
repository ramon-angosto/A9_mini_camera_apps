package kotlin.io;

import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0001\u001aK\u0010\u0005\u001a\u0002H\u0006\"\n\b\u0000\u0010\u0007*\u0004\u0018\u00010\u0002\"\u0004\b\u0001\u0010\u0006*\u0002H\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00060\tH\bø\u0001\u0000ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\n\u0002\u000f\n\u0005\b20\u0001\n\u0006\b\u0011(\u000b0\u0001¨\u0006\f"}, d2 = {"closeFinally", "", "Ljava/io/Closeable;", "cause", "", "use", "R", "T", "block", "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Requires newer compiler version to be inlined correctly.", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Closeable.kt */
public final class CloseableKt {
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        if (kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        if (r3 != null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        closeFinally(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T extends java.io.Closeable, R> R use(T r3, kotlin.jvm.functions.Function1<? super T, ? extends R> r4) {
        /*
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 0
            r1 = 1
            java.lang.Object r4 = r4.invoke(r3)     // Catch:{ all -> 0x0022 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            boolean r0 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r1, r1, r0)
            if (r0 == 0) goto L_0x0019
            r0 = 0
            closeFinally(r3, r0)
            goto L_0x001e
        L_0x0019:
            if (r3 == 0) goto L_0x001e
            r3.close()
        L_0x001e:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            return r4
        L_0x0022:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0024 }
        L_0x0024:
            r2 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            boolean r0 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r1, r1, r0)
            if (r0 != 0) goto L_0x0034
            if (r3 == 0) goto L_0x0037
            r3.close()     // Catch:{ all -> 0x0037 }
            goto L_0x0037
        L_0x0034:
            closeFinally(r3, r4)
        L_0x0037:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.CloseableKt.use(java.io.Closeable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    public static final void closeFinally(Closeable closeable, Throwable th) {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            ExceptionsKt.addSuppressed(th, th2);
        }
    }
}
