package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.internal.zznv;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends zznv<BatchResult> {
    /* access modifiers changed from: private */
    public int zzakL;
    /* access modifiers changed from: private */
    public boolean zzakM;
    /* access modifiers changed from: private */
    public boolean zzakN;
    /* access modifiers changed from: private */
    public final PendingResult<?>[] zzakO;
    /* access modifiers changed from: private */
    public final Object zzpp;

    public static final class Builder {
        private GoogleApiClient zzaeN;
        private List<PendingResult<?>> zzakQ = new ArrayList();

        public Builder(GoogleApiClient googleApiClient) {
            this.zzaeN = googleApiClient;
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken<>(this.zzakQ.size());
            this.zzakQ.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.zzakQ, this.zzaeN);
        }
    }

    private Batch(List<PendingResult<?>> list, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzpp = new Object();
        this.zzakL = list.size();
        this.zzakO = new PendingResult[this.zzakL];
        if (list.isEmpty()) {
            zzb(new BatchResult(Status.zzalw, this.zzakO));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            PendingResult<?> pendingResult = list.get(i);
            this.zzakO[i] = pendingResult;
            pendingResult.zza(new PendingResult.zza() {
                /* JADX WARNING: Code restructure failed: missing block: B:24:0x0067, code lost:
                    return;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void zzt(com.google.android.gms.common.api.Status r5) {
                    /*
                        r4 = this;
                        com.google.android.gms.common.api.Batch r0 = com.google.android.gms.common.api.Batch.this
                        java.lang.Object r0 = r0.zzpp
                        monitor-enter(r0)
                        com.google.android.gms.common.api.Batch r1 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0068 }
                        boolean r1 = r1.isCanceled()     // Catch:{ all -> 0x0068 }
                        if (r1 == 0) goto L_0x0011
                        monitor-exit(r0)     // Catch:{ all -> 0x0068 }
                        return
                    L_0x0011:
                        boolean r1 = r5.isCanceled()     // Catch:{ all -> 0x0068 }
                        r2 = 1
                        if (r1 == 0) goto L_0x001e
                        com.google.android.gms.common.api.Batch r5 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0068 }
                        boolean unused = r5.zzakN = r2     // Catch:{ all -> 0x0068 }
                        goto L_0x0029
                    L_0x001e:
                        boolean r5 = r5.isSuccess()     // Catch:{ all -> 0x0068 }
                        if (r5 != 0) goto L_0x0029
                        com.google.android.gms.common.api.Batch r5 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0068 }
                        boolean unused = r5.zzakM = r2     // Catch:{ all -> 0x0068 }
                    L_0x0029:
                        com.google.android.gms.common.api.Batch r5 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0068 }
                        com.google.android.gms.common.api.Batch.zzb(r5)     // Catch:{ all -> 0x0068 }
                        com.google.android.gms.common.api.Batch r5 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0068 }
                        int r5 = r5.zzakL     // Catch:{ all -> 0x0068 }
                        if (r5 != 0) goto L_0x0066
                        com.google.android.gms.common.api.Batch r5 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0068 }
                        boolean r5 = r5.zzakN     // Catch:{ all -> 0x0068 }
                        if (r5 == 0) goto L_0x0044
                        com.google.android.gms.common.api.Batch r5 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0068 }
                        com.google.android.gms.common.api.Batch.super.cancel()     // Catch:{ all -> 0x0068 }
                        goto L_0x0066
                    L_0x0044:
                        com.google.android.gms.common.api.Batch r5 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0068 }
                        boolean r5 = r5.zzakM     // Catch:{ all -> 0x0068 }
                        if (r5 == 0) goto L_0x0054
                        com.google.android.gms.common.api.Status r5 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x0068 }
                        r1 = 13
                        r5.<init>(r1)     // Catch:{ all -> 0x0068 }
                        goto L_0x0056
                    L_0x0054:
                        com.google.android.gms.common.api.Status r5 = com.google.android.gms.common.api.Status.zzalw     // Catch:{ all -> 0x0068 }
                    L_0x0056:
                        com.google.android.gms.common.api.Batch r1 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0068 }
                        com.google.android.gms.common.api.BatchResult r2 = new com.google.android.gms.common.api.BatchResult     // Catch:{ all -> 0x0068 }
                        com.google.android.gms.common.api.Batch r3 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0068 }
                        com.google.android.gms.common.api.PendingResult[] r3 = r3.zzakO     // Catch:{ all -> 0x0068 }
                        r2.<init>(r5, r3)     // Catch:{ all -> 0x0068 }
                        r1.zzb(r2)     // Catch:{ all -> 0x0068 }
                    L_0x0066:
                        monitor-exit(r0)     // Catch:{ all -> 0x0068 }
                        return
                    L_0x0068:
                        r5 = move-exception
                        monitor-exit(r0)     // Catch:{ all -> 0x0068 }
                        throw r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.Batch.AnonymousClass1.zzt(com.google.android.gms.common.api.Status):void");
                }
            });
        }
    }

    static /* synthetic */ int zzb(Batch batch) {
        int i = batch.zzakL;
        batch.zzakL = i - 1;
        return i;
    }

    public void cancel() {
        super.cancel();
        for (PendingResult<?> cancel : this.zzakO) {
            cancel.cancel();
        }
    }

    /* renamed from: createFailedResult */
    public BatchResult zzc(Status status) {
        return new BatchResult(status, this.zzakO);
    }
}
