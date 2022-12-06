package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import java.io.IOException;

public interface LoaderErrorThrower {

    public static final class Dummy implements LoaderErrorThrower {
        public final void maybeThrowError() throws IOException {
        }

        public final void maybeThrowError(int i) throws IOException {
        }
    }

    void maybeThrowError() throws IOException;

    void maybeThrowError(int i) throws IOException;
}
