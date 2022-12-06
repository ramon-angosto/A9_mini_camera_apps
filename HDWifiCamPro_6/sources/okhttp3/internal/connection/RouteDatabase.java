package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

final class RouteDatabase {
    private final Set<Route> failedRoutes = new LinkedHashSet();

    RouteDatabase() {
    }

    public synchronized void failed(Route route) {
        this.failedRoutes.add(route);
    }

    public synchronized void connected(Route route) {
        this.failedRoutes.remove(route);
    }

    public synchronized boolean shouldPostpone(Route route) {
        return this.failedRoutes.contains(route);
    }
}
