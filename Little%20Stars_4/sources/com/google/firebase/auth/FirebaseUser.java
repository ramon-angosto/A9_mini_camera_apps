package com.google.firebase.auth;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import java.util.List;

public abstract class FirebaseUser implements UserInfo {
    @NonNull
    public Task<Void> delete() {
        return zzOl().zzNS().zzc(this);
    }

    @Nullable
    public abstract String getDisplayName();

    @Nullable
    public abstract String getEmail();

    @Nullable
    public abstract Uri getPhotoUrl();

    @NonNull
    public abstract List<? extends UserInfo> getProviderData();

    @NonNull
    public abstract String getProviderId();

    @Nullable
    public abstract List<String> getProviders();

    @NonNull
    public Task<GetTokenResult> getToken(boolean z) {
        return zzOl().zzNS().zza(this, z);
    }

    @NonNull
    public abstract String getUid();

    public abstract boolean isAnonymous();

    @NonNull
    public Task<AuthResult> linkWithCredential(@NonNull AuthCredential authCredential) {
        zzaa.zzz(authCredential);
        return zzOl().zzNS().zzb(this, authCredential);
    }

    public Task<Void> reauthenticate(@NonNull AuthCredential authCredential) {
        zzaa.zzz(authCredential);
        return zzOl().zzNS().zza(this, authCredential);
    }

    @NonNull
    public Task<Void> reload() {
        return zzOl().zzNS().zzb(this);
    }

    public Task<AuthResult> unlink(@NonNull String str) {
        zzaa.zzdl(str);
        return zzOl().zzNS().zza(this, str);
    }

    @NonNull
    public Task<Void> updateEmail(@NonNull String str) {
        zzaa.zzdl(str);
        return zzOl().zzNS().zzb(this, str);
    }

    @NonNull
    public Task<Void> updatePassword(@NonNull String str) {
        zzaa.zzdl(str);
        return zzOl().zzNS().zzc(this, str);
    }

    @NonNull
    public Task<Void> updateProfile(@NonNull UserProfileChangeRequest userProfileChangeRequest) {
        zzaa.zzz(userProfileChangeRequest);
        return zzOl().zzNS().zza(this, userProfileChangeRequest);
    }

    @NonNull
    public abstract FirebaseUser zzN(@NonNull List<? extends UserInfo> list);

    @NonNull
    public abstract FirebaseApp zzOl();

    @NonNull
    public abstract String zzOm();

    public abstract FirebaseUser zzaK(boolean z);

    public abstract void zzhG(@NonNull String str);
}
