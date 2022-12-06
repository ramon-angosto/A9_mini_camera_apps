package kotlin.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u001a6\u0010\u0006\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\b\u001a6\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u0002\u0007\n\u0005\b20\u0001¨\u0006\n"}, d2 = {"read", "T", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "action", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/ReentrantReadWriteLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withLock", "Ljava/util/concurrent/locks/Lock;", "(Ljava/util/concurrent/locks/Lock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "write", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Locks.kt */
public final class LocksKt {
    private static final <T> T withLock(Lock lock, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(lock, "<this>");
        Intrinsics.checkNotNullParameter(function0, "action");
        lock.lock();
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            lock.unlock();
            InlineMarker.finallyEnd(1);
        }
    }

    private static final <T> T read(ReentrantReadWriteLock reentrantReadWriteLock, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(reentrantReadWriteLock, "<this>");
        Intrinsics.checkNotNullParameter(function0, "action");
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        readLock.lock();
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            readLock.unlock();
            InlineMarker.finallyEnd(1);
        }
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private static final <T> T write(java.util.concurrent.locks.ReentrantReadWriteLock r4, kotlin.jvm.functions.Function0<? extends T> r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r4.readLock()
            int r1 = r4.getWriteHoldCount()
            r2 = 0
            if (r1 != 0) goto L_0x001a
            int r1 = r4.getReadHoldCount()
            goto L_0x001b
        L_0x001a:
            r1 = r2
        L_0x001b:
            r3 = r2
        L_0x001c:
            if (r3 >= r1) goto L_0x0024
            r0.unlock()
            int r3 = r3 + 1
            goto L_0x001c
        L_0x0024:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r4 = r4.writeLock()
            r4.lock()
            r3 = 1
            java.lang.Object r5 = r5.invoke()     // Catch:{ all -> 0x0042 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
        L_0x0033:
            if (r2 >= r1) goto L_0x003b
            r0.lock()
            int r2 = r2 + 1
            goto L_0x0033
        L_0x003b:
            r4.unlock()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            return r5
        L_0x0042:
            r5 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
        L_0x0046:
            if (r2 >= r1) goto L_0x004e
            r0.lock()
            int r2 = r2 + 1
            goto L_0x0046
        L_0x004e:
            r4.unlock()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.concurrent.LocksKt.write(java.util.concurrent.locks.ReentrantReadWriteLock, kotlin.jvm.functions.Function0):java.lang.Object");
    }
}
