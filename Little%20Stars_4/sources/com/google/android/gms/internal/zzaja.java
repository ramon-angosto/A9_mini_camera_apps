package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.UserProfileChangeRequest;

public interface zzaja {
    @Nullable
    FirebaseUser getCurrentUser();

    @NonNull
    Task<Void> zza(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential);

    @NonNull
    Task<Void> zza(@NonNull FirebaseUser firebaseUser, @NonNull UserProfileChangeRequest userProfileChangeRequest);

    @NonNull
    Task<AuthResult> zza(@NonNull FirebaseUser firebaseUser, @NonNull String str);

    @NonNull
    Task<GetTokenResult> zza(@Nullable FirebaseUser firebaseUser, boolean z);

    @NonNull
    Task<Void> zzb(@NonNull FirebaseUser firebaseUser);

    @NonNull
    Task<AuthResult> zzb(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential);

    @NonNull
    Task<Void> zzb(@NonNull FirebaseUser firebaseUser, @NonNull String str);

    @NonNull
    Task<Void> zzc(@NonNull FirebaseUser firebaseUser);

    @NonNull
    Task<Void> zzc(@NonNull FirebaseUser firebaseUser, @NonNull String str);
}
