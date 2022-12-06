package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.internal.Util;

public final class RouteException extends RuntimeException {
    private IOException firstException;
    private IOException lastException;

    RouteException(IOException iOException) {
        super(iOException);
        this.firstException = iOException;
        this.lastException = iOException;
    }

    public IOException getFirstConnectException() {
        return this.firstException;
    }

    public IOException getLastConnectException() {
        return this.lastException;
    }

    /* access modifiers changed from: package-private */
    public void addConnectException(IOException iOException) {
        Util.addSuppressedIfPossible(this.firstException, iOException);
        this.lastException = iOException;
    }
}
