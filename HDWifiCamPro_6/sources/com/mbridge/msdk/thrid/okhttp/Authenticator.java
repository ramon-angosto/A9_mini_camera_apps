package com.mbridge.msdk.thrid.okhttp;

import java.io.IOException;
import javax.annotation.Nullable;

public interface Authenticator {
    public static final Authenticator NONE = new Authenticator() {
        public Request authenticate(@Nullable Route route, Response response) {
            return null;
        }
    };

    @Nullable
    Request authenticate(@Nullable Route route, Response response) throws IOException;
}
