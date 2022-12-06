package okio;

import java.io.IOException;
import javax.annotation.Nullable;

public final class Pipe {
    final Buffer buffer = new Buffer();
    /* access modifiers changed from: private */
    @Nullable
    public Sink foldedSink;
    final long maxBufferSize;
    private final Sink sink = new PipeSink();
    boolean sinkClosed;
    private final Source source = new PipeSource();
    boolean sourceClosed;

    public Pipe(long j) {
        if (j >= 1) {
            this.maxBufferSize = j;
            return;
        }
        throw new IllegalArgumentException("maxBufferSize < 1: " + j);
    }

    public final Source source() {
        return this.source;
    }

    public final Sink sink() {
        return this.sink;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r8.write(r3, r3.size);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        if (r1 == false) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        r8.flush();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003b, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
        monitor-enter(r7.buffer);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r7.sourceClosed = true;
        r7.buffer.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0047, code lost:
        throw r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void fold(okio.Sink r8) throws java.io.IOException {
        /*
            r7 = this;
        L_0x0000:
            okio.Buffer r0 = r7.buffer
            monitor-enter(r0)
            okio.Sink r1 = r7.foldedSink     // Catch:{ all -> 0x0053 }
            if (r1 != 0) goto L_0x004b
            okio.Buffer r1 = r7.buffer     // Catch:{ all -> 0x0053 }
            boolean r1 = r1.exhausted()     // Catch:{ all -> 0x0053 }
            r2 = 1
            if (r1 == 0) goto L_0x0016
            r7.sourceClosed = r2     // Catch:{ all -> 0x0053 }
            r7.foldedSink = r8     // Catch:{ all -> 0x0053 }
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            return
        L_0x0016:
            boolean r1 = r7.sinkClosed     // Catch:{ all -> 0x0053 }
            okio.Buffer r3 = new okio.Buffer     // Catch:{ all -> 0x0053 }
            r3.<init>()     // Catch:{ all -> 0x0053 }
            okio.Buffer r4 = r7.buffer     // Catch:{ all -> 0x0053 }
            okio.Buffer r5 = r7.buffer     // Catch:{ all -> 0x0053 }
            long r5 = r5.size     // Catch:{ all -> 0x0053 }
            r3.write((okio.Buffer) r4, (long) r5)     // Catch:{ all -> 0x0053 }
            okio.Buffer r4 = r7.buffer     // Catch:{ all -> 0x0053 }
            r4.notifyAll()     // Catch:{ all -> 0x0053 }
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            long r4 = r3.size     // Catch:{ all -> 0x003b }
            r8.write(r3, r4)     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x0037
            r8.close()     // Catch:{ all -> 0x003b }
            goto L_0x0000
        L_0x0037:
            r8.flush()     // Catch:{ all -> 0x003b }
            goto L_0x0000
        L_0x003b:
            r8 = move-exception
            okio.Buffer r1 = r7.buffer
            monitor-enter(r1)
            r7.sourceClosed = r2     // Catch:{ all -> 0x0048 }
            okio.Buffer r0 = r7.buffer     // Catch:{ all -> 0x0048 }
            r0.notifyAll()     // Catch:{ all -> 0x0048 }
            monitor-exit(r1)     // Catch:{ all -> 0x0048 }
            throw r8
        L_0x0048:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0048 }
            throw r8
        L_0x004b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0053 }
            java.lang.String r1 = "sink already folded"
            r8.<init>(r1)     // Catch:{ all -> 0x0053 }
            throw r8     // Catch:{ all -> 0x0053 }
        L_0x0053:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Pipe.fold(okio.Sink):void");
    }

    final class PipeSink implements Sink {
        final PushableTimeout timeout = new PushableTimeout();

        PipeSink() {
        }

        public void write(Buffer buffer, long j) throws IOException {
            Sink sink;
            synchronized (Pipe.this.buffer) {
                if (!Pipe.this.sinkClosed) {
                    while (true) {
                        if (j <= 0) {
                            sink = null;
                            break;
                        } else if (Pipe.this.foldedSink != null) {
                            sink = Pipe.this.foldedSink;
                            break;
                        } else if (!Pipe.this.sourceClosed) {
                            long size = Pipe.this.maxBufferSize - Pipe.this.buffer.size();
                            if (size == 0) {
                                this.timeout.waitUntilNotified(Pipe.this.buffer);
                            } else {
                                long min = Math.min(size, j);
                                Pipe.this.buffer.write(buffer, min);
                                j -= min;
                                Pipe.this.buffer.notifyAll();
                            }
                        } else {
                            throw new IOException("source is closed");
                        }
                    }
                } else {
                    throw new IllegalStateException("closed");
                }
            }
            if (sink != null) {
                this.timeout.push(sink.timeout());
                try {
                    sink.write(buffer, j);
                } finally {
                    this.timeout.pop();
                }
            }
        }

        public void flush() throws IOException {
            Sink sink;
            synchronized (Pipe.this.buffer) {
                if (Pipe.this.sinkClosed) {
                    throw new IllegalStateException("closed");
                } else if (Pipe.this.foldedSink != null) {
                    sink = Pipe.this.foldedSink;
                } else {
                    if (Pipe.this.sourceClosed) {
                        if (Pipe.this.buffer.size() > 0) {
                            throw new IOException("source is closed");
                        }
                    }
                    sink = null;
                }
            }
            if (sink != null) {
                this.timeout.push(sink.timeout());
                try {
                    sink.flush();
                } finally {
                    this.timeout.pop();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
            if (r1 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
            r5.timeout.push(r1.timeout());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x005b, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
            r5.timeout.pop();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0061, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
                r5 = this;
                okio.Pipe r0 = okio.Pipe.this
                okio.Buffer r0 = r0.buffer
                monitor-enter(r0)
                okio.Pipe r1 = okio.Pipe.this     // Catch:{ all -> 0x0063 }
                boolean r1 = r1.sinkClosed     // Catch:{ all -> 0x0063 }
                if (r1 == 0) goto L_0x000d
                monitor-exit(r0)     // Catch:{ all -> 0x0063 }
                return
            L_0x000d:
                okio.Pipe r1 = okio.Pipe.this     // Catch:{ all -> 0x0063 }
                okio.Sink r1 = r1.foldedSink     // Catch:{ all -> 0x0063 }
                if (r1 == 0) goto L_0x001c
                okio.Pipe r1 = okio.Pipe.this     // Catch:{ all -> 0x0063 }
                okio.Sink r1 = r1.foldedSink     // Catch:{ all -> 0x0063 }
                goto L_0x0046
            L_0x001c:
                okio.Pipe r1 = okio.Pipe.this     // Catch:{ all -> 0x0063 }
                boolean r1 = r1.sourceClosed     // Catch:{ all -> 0x0063 }
                if (r1 == 0) goto L_0x0039
                okio.Pipe r1 = okio.Pipe.this     // Catch:{ all -> 0x0063 }
                okio.Buffer r1 = r1.buffer     // Catch:{ all -> 0x0063 }
                long r1 = r1.size()     // Catch:{ all -> 0x0063 }
                r3 = 0
                int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r1 > 0) goto L_0x0031
                goto L_0x0039
            L_0x0031:
                java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x0063 }
                java.lang.String r2 = "source is closed"
                r1.<init>(r2)     // Catch:{ all -> 0x0063 }
                throw r1     // Catch:{ all -> 0x0063 }
            L_0x0039:
                okio.Pipe r1 = okio.Pipe.this     // Catch:{ all -> 0x0063 }
                r2 = 1
                r1.sinkClosed = r2     // Catch:{ all -> 0x0063 }
                okio.Pipe r1 = okio.Pipe.this     // Catch:{ all -> 0x0063 }
                okio.Buffer r1 = r1.buffer     // Catch:{ all -> 0x0063 }
                r1.notifyAll()     // Catch:{ all -> 0x0063 }
                r1 = 0
            L_0x0046:
                monitor-exit(r0)     // Catch:{ all -> 0x0063 }
                if (r1 == 0) goto L_0x0062
                okio.PushableTimeout r0 = r5.timeout
                okio.Timeout r2 = r1.timeout()
                r0.push(r2)
                r1.close()     // Catch:{ all -> 0x005b }
                okio.PushableTimeout r0 = r5.timeout
                r0.pop()
                goto L_0x0062
            L_0x005b:
                r0 = move-exception
                okio.PushableTimeout r1 = r5.timeout
                r1.pop()
                throw r0
            L_0x0062:
                return
            L_0x0063:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0063 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.Pipe.PipeSink.close():void");
        }

        public Timeout timeout() {
            return this.timeout;
        }
    }

    final class PipeSource implements Source {
        final Timeout timeout = new Timeout();

        PipeSource() {
        }

        public long read(Buffer buffer, long j) throws IOException {
            synchronized (Pipe.this.buffer) {
                if (!Pipe.this.sourceClosed) {
                    while (Pipe.this.buffer.size() == 0) {
                        if (Pipe.this.sinkClosed) {
                            return -1;
                        }
                        this.timeout.waitUntilNotified(Pipe.this.buffer);
                    }
                    long read = Pipe.this.buffer.read(buffer, j);
                    Pipe.this.buffer.notifyAll();
                    return read;
                }
                throw new IllegalStateException("closed");
            }
        }

        public void close() throws IOException {
            synchronized (Pipe.this.buffer) {
                Pipe.this.sourceClosed = true;
                Pipe.this.buffer.notifyAll();
            }
        }

        public Timeout timeout() {
            return this.timeout;
        }
    }
}
