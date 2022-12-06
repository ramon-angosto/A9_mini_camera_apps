package com.mbridge.msdk.playercommon.exoplayer2.drm;

import android.os.Handler;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public interface DefaultDrmSessionEventListener {
    void onDrmKeysLoaded();

    void onDrmKeysRemoved();

    void onDrmKeysRestored();

    void onDrmSessionManagerError(Exception exc);

    public static final class EventDispatcher {
        private final CopyOnWriteArrayList<HandlerAndListener> listeners = new CopyOnWriteArrayList<>();

        public final void addListener(Handler handler, DefaultDrmSessionEventListener defaultDrmSessionEventListener) {
            Assertions.checkArgument((handler == null || defaultDrmSessionEventListener == null) ? false : true);
            this.listeners.add(new HandlerAndListener(handler, defaultDrmSessionEventListener));
        }

        public final void removeListener(DefaultDrmSessionEventListener defaultDrmSessionEventListener) {
            Iterator<HandlerAndListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                HandlerAndListener next = it.next();
                if (next.listener == defaultDrmSessionEventListener) {
                    this.listeners.remove(next);
                }
            }
        }

        public final void drmKeysLoaded() {
            Iterator<HandlerAndListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                HandlerAndListener next = it.next();
                final DefaultDrmSessionEventListener defaultDrmSessionEventListener = next.listener;
                next.handler.post(new Runnable() {
                    public void run() {
                        defaultDrmSessionEventListener.onDrmKeysLoaded();
                    }
                });
            }
        }

        public final void drmSessionManagerError(final Exception exc) {
            Iterator<HandlerAndListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                HandlerAndListener next = it.next();
                final DefaultDrmSessionEventListener defaultDrmSessionEventListener = next.listener;
                next.handler.post(new Runnable() {
                    public void run() {
                        defaultDrmSessionEventListener.onDrmSessionManagerError(exc);
                    }
                });
            }
        }

        public final void drmKeysRestored() {
            Iterator<HandlerAndListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                HandlerAndListener next = it.next();
                final DefaultDrmSessionEventListener defaultDrmSessionEventListener = next.listener;
                next.handler.post(new Runnable() {
                    public void run() {
                        defaultDrmSessionEventListener.onDrmKeysRestored();
                    }
                });
            }
        }

        public final void drmKeysRemoved() {
            Iterator<HandlerAndListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                HandlerAndListener next = it.next();
                final DefaultDrmSessionEventListener defaultDrmSessionEventListener = next.listener;
                next.handler.post(new Runnable() {
                    public void run() {
                        defaultDrmSessionEventListener.onDrmKeysRemoved();
                    }
                });
            }
        }

        private static final class HandlerAndListener {
            public final Handler handler;
            public final DefaultDrmSessionEventListener listener;

            public HandlerAndListener(Handler handler2, DefaultDrmSessionEventListener defaultDrmSessionEventListener) {
                this.handler = handler2;
                this.listener = defaultDrmSessionEventListener;
            }
        }
    }
}
