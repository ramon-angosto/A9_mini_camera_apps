package com.google.android.gms.common;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public class UserRecoverableException extends Exception {
    private final Intent zza;

    public UserRecoverableException(String str, Intent intent) {
        super(str);
        this.zza = intent;
    }

    public Intent getIntent() {
        return new Intent(this.zza);
    }
}
