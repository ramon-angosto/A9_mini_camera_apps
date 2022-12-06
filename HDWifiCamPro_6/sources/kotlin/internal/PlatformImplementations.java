package kotlin.internal;

import java.lang.reflect.Method;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;
import kotlin.text.MatchGroup;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u0013"}, d2 = {"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "getSuppressed", "", "ReflectThrowable", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PlatformImplementations.kt */
public class PlatformImplementations {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlin/internal/PlatformImplementations$ReflectThrowable;", "", "()V", "addSuppressed", "Ljava/lang/reflect/Method;", "getSuppressed", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PlatformImplementations.kt */
    private static final class ReflectThrowable {
        public static final ReflectThrowable INSTANCE = new ReflectThrowable();
        public static final Method addSuppressed;
        public static final Method getSuppressed;

        private ReflectThrowable() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0041 A[LOOP:0: B:1:0x0015->B:10:0x0041, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0045 A[EDGE_INSN: B:21:0x0045->B:12:0x0045 ?: BREAK  , SYNTHETIC] */
        static {
            /*
                kotlin.internal.PlatformImplementations$ReflectThrowable r0 = new kotlin.internal.PlatformImplementations$ReflectThrowable
                r0.<init>()
                INSTANCE = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = r3
            L_0x0015:
                r5 = 0
                if (r4 >= r2) goto L_0x0044
                r6 = r1[r4]
                java.lang.String r7 = r6.getName()
                java.lang.String r8 = "addSuppressed"
                boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
                if (r7 == 0) goto L_0x003d
                java.lang.Class[] r7 = r6.getParameterTypes()
                java.lang.String r8 = "it.parameterTypes"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
                java.lang.Object[] r7 = (java.lang.Object[]) r7
                java.lang.Object r7 = kotlin.collections.ArraysKt.singleOrNull((T[]) r7)
                boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
                if (r7 == 0) goto L_0x003d
                r7 = 1
                goto L_0x003e
            L_0x003d:
                r7 = r3
            L_0x003e:
                if (r7 == 0) goto L_0x0041
                goto L_0x0045
            L_0x0041:
                int r4 = r4 + 1
                goto L_0x0015
            L_0x0044:
                r6 = r5
            L_0x0045:
                addSuppressed = r6
                int r0 = r1.length
            L_0x0048:
                if (r3 >= r0) goto L_0x005c
                r2 = r1[r3]
                java.lang.String r4 = r2.getName()
                java.lang.String r6 = "getSuppressed"
                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
                if (r4 == 0) goto L_0x0059
                goto L_0x005d
            L_0x0059:
                int r3 = r3 + 1
                goto L_0x0048
            L_0x005c:
                r2 = r5
            L_0x005d:
                getSuppressed = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.PlatformImplementations.ReflectThrowable.<clinit>():void");
        }
    }

    public void addSuppressed(Throwable th, Throwable th2) {
        Intrinsics.checkNotNullParameter(th, "cause");
        Intrinsics.checkNotNullParameter(th2, "exception");
        Method method = ReflectThrowable.addSuppressed;
        if (method != null) {
            method.invoke(th, new Object[]{th2});
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        r3 = kotlin.collections.ArraysKt.asList((T[]) (java.lang.Throwable[]) (r3 = r0.invoke(r3, new java.lang.Object[0])));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.Throwable> getSuppressed(java.lang.Throwable r3) {
        /*
            r2 = this;
            java.lang.String r0 = "exception"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.reflect.Method r0 = kotlin.internal.PlatformImplementations.ReflectThrowable.getSuppressed
            if (r0 == 0) goto L_0x001a
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object r3 = r0.invoke(r3, r1)
            if (r3 == 0) goto L_0x001a
            java.lang.Throwable[] r3 = (java.lang.Throwable[]) r3
            java.util.List r3 = kotlin.collections.ArraysKt.asList((T[]) r3)
            if (r3 != 0) goto L_0x001e
        L_0x001a:
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
        L_0x001e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.PlatformImplementations.getSuppressed(java.lang.Throwable):java.util.List");
    }

    public MatchGroup getMatchResultNamedGroup(MatchResult matchResult, String str) {
        Intrinsics.checkNotNullParameter(matchResult, "matchResult");
        Intrinsics.checkNotNullParameter(str, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    public Random defaultPlatformRandom() {
        return new FallbackThreadLocalRandom();
    }
}
