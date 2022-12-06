package com.google.firebase.auth;

public abstract class AuthCredential {
    AuthCredential() {
    }

    public abstract String getProvider();
}
