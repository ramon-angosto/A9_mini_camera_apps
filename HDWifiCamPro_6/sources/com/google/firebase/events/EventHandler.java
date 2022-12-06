package com.google.firebase.events;

/* compiled from: com.google.firebase:firebase-common@@19.0.0 */
public interface EventHandler<T> {
    void handle(Event<T> event);
}
