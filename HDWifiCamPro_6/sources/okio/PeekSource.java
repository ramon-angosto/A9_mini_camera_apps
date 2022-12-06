package okio;

import java.io.IOException;

final class PeekSource implements Source {
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private Segment expectedSegment = this.buffer.head;
    private long pos;
    private final BufferedSource upstream;

    PeekSource(BufferedSource bufferedSource) {
        this.upstream = bufferedSource;
        this.buffer = bufferedSource.buffer();
        Segment segment = this.expectedSegment;
        this.expectedPos = segment != null ? segment.pos : -1;
    }

    public long read(Buffer buffer2, long j) throws IOException {
        if (!this.closed) {
            Segment segment = this.expectedSegment;
            if (segment == null || (segment == this.buffer.head && this.expectedPos == this.buffer.head.pos)) {
                this.upstream.request(this.pos + j);
                if (this.expectedSegment == null && this.buffer.head != null) {
                    this.expectedSegment = this.buffer.head;
                    this.expectedPos = this.buffer.head.pos;
                }
                long min = Math.min(j, this.buffer.size - this.pos);
                if (min <= 0) {
                    return -1;
                }
                this.buffer.copyTo(buffer2, this.pos, min);
                this.pos += min;
                return min;
            }
            throw new IllegalStateException("Peek source is invalid because upstream source was used");
        }
        throw new IllegalStateException("closed");
    }

    public Timeout timeout() {
        return this.upstream.timeout();
    }

    public void close() throws IOException {
        this.closed = true;
    }
}
