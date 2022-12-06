package androidx.work;

import android.content.Context;

public abstract class WorkerFactory {
    private static final String TAG = Logger.tagWithPrefix("WorkerFactory");

    public abstract ListenableWorker createWorker(Context context, String str, WorkerParameters workerParameters);

    /* JADX WARNING: Removed duplicated region for block: B:16:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0094 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.work.ListenableWorker createWorkerWithDefaultFallback(android.content.Context r11, java.lang.String r12, androidx.work.WorkerParameters r13) {
        /*
            r10 = this;
            androidx.work.ListenableWorker r0 = r10.createWorker(r11, r12, r13)
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x0070
            r4 = 0
            java.lang.Class r5 = java.lang.Class.forName(r12)     // Catch:{ all -> 0x0015 }
            java.lang.Class<androidx.work.ListenableWorker> r6 = androidx.work.ListenableWorker.class
            java.lang.Class r4 = r5.asSubclass(r6)     // Catch:{ all -> 0x0015 }
            goto L_0x0034
        L_0x0015:
            r5 = move-exception
            androidx.work.Logger r6 = androidx.work.Logger.get()
            java.lang.String r7 = TAG
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Invalid class: "
            r8.append(r9)
            r8.append(r12)
            java.lang.String r8 = r8.toString()
            java.lang.Throwable[] r9 = new java.lang.Throwable[r2]
            r9[r3] = r5
            r6.error(r7, r8, r9)
        L_0x0034:
            if (r4 == 0) goto L_0x0070
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ all -> 0x0051 }
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r5[r3] = r6     // Catch:{ all -> 0x0051 }
            java.lang.Class<androidx.work.WorkerParameters> r6 = androidx.work.WorkerParameters.class
            r5[r2] = r6     // Catch:{ all -> 0x0051 }
            java.lang.reflect.Constructor r4 = r4.getDeclaredConstructor(r5)     // Catch:{ all -> 0x0051 }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x0051 }
            r5[r3] = r11     // Catch:{ all -> 0x0051 }
            r5[r2] = r13     // Catch:{ all -> 0x0051 }
            java.lang.Object r11 = r4.newInstance(r5)     // Catch:{ all -> 0x0051 }
            androidx.work.ListenableWorker r11 = (androidx.work.ListenableWorker) r11     // Catch:{ all -> 0x0051 }
            goto L_0x0071
        L_0x0051:
            r11 = move-exception
            androidx.work.Logger r13 = androidx.work.Logger.get()
            java.lang.String r4 = TAG
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Could not instantiate "
            r5.append(r6)
            r5.append(r12)
            java.lang.String r5 = r5.toString()
            java.lang.Throwable[] r6 = new java.lang.Throwable[r2]
            r6[r3] = r11
            r13.error(r4, r5, r6)
        L_0x0070:
            r11 = r0
        L_0x0071:
            if (r11 == 0) goto L_0x0094
            boolean r13 = r11.isUsed()
            if (r13 != 0) goto L_0x007a
            goto L_0x0094
        L_0x007a:
            java.lang.Class r11 = r10.getClass()
            java.lang.String r11 = r11.getName()
            java.lang.Object[] r13 = new java.lang.Object[r1]
            r13[r3] = r11
            r13[r2] = r12
            java.lang.String r11 = "WorkerFactory (%s) returned an instance of a ListenableWorker (%s) which has already been invoked. createWorker() must always return a new instance of a ListenableWorker."
            java.lang.String r11 = java.lang.String.format(r11, r13)
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            r12.<init>(r11)
            throw r12
        L_0x0094:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.WorkerFactory.createWorkerWithDefaultFallback(android.content.Context, java.lang.String, androidx.work.WorkerParameters):androidx.work.ListenableWorker");
    }

    public static WorkerFactory getDefaultWorkerFactory() {
        return new WorkerFactory() {
            public ListenableWorker createWorker(Context context, String str, WorkerParameters workerParameters) {
                return null;
            }
        };
    }
}
