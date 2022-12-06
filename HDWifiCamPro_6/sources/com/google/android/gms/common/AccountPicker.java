package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public final class AccountPicker {

    /* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
    public static class AccountChooserOptions {
        /* access modifiers changed from: private */
        public Account zza;
        /* access modifiers changed from: private */
        public boolean zzb;
        /* access modifiers changed from: private */
        public ArrayList<Account> zzc;
        /* access modifiers changed from: private */
        public ArrayList<String> zzd;
        /* access modifiers changed from: private */
        public boolean zze;
        /* access modifiers changed from: private */
        public String zzf;
        /* access modifiers changed from: private */
        public Bundle zzg;
        /* access modifiers changed from: private */
        public boolean zzh;
        /* access modifiers changed from: private */
        public int zzi;
        /* access modifiers changed from: private */
        public String zzj;
        /* access modifiers changed from: private */
        public boolean zzk;
        /* access modifiers changed from: private */
        public zza zzl;
        /* access modifiers changed from: private */
        public String zzm;
        /* access modifiers changed from: private */
        public boolean zzn;
        /* access modifiers changed from: private */
        public boolean zzo;

        /* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
        public static class Builder {
            private Account zza;
            private ArrayList<Account> zzb;
            private ArrayList<String> zzc;
            private boolean zzd = false;
            private String zze;
            private Bundle zzf;

            public AccountChooserOptions build() {
                Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
                Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
                AccountChooserOptions accountChooserOptions = new AccountChooserOptions();
                accountChooserOptions.zzd = this.zzc;
                accountChooserOptions.zzc = this.zzb;
                accountChooserOptions.zze = this.zzd;
                accountChooserOptions.zzl = null;
                accountChooserOptions.zzj = null;
                accountChooserOptions.zzg = this.zzf;
                accountChooserOptions.zza = this.zza;
                accountChooserOptions.zzb = false;
                accountChooserOptions.zzh = false;
                accountChooserOptions.zzm = null;
                accountChooserOptions.zzi = 0;
                accountChooserOptions.zzf = this.zze;
                accountChooserOptions.zzk = false;
                accountChooserOptions.zzn = false;
                accountChooserOptions.zzo = false;
                return accountChooserOptions;
            }

            public Builder setAllowableAccounts(List<Account> list) {
                this.zzb = list == null ? null : new ArrayList<>(list);
                return this;
            }

            public Builder setAllowableAccountsTypes(List<String> list) {
                this.zzc = list == null ? null : new ArrayList<>(list);
                return this;
            }

            public Builder setAlwaysShowAccountPicker(boolean z) {
                this.zzd = z;
                return this;
            }

            public Builder setOptionsForAddingAccount(Bundle bundle) {
                this.zzf = bundle;
                return this;
            }

            public Builder setSelectedAccount(Account account) {
                this.zza = account;
                return this;
            }

            public Builder setTitleOverrideText(String str) {
                this.zze = str;
                return this;
            }
        }
    }

    private AccountPicker() {
    }

    @Deprecated
    public static Intent newChooseAccountIntent(Account account, ArrayList<Account> arrayList, String[] strArr, boolean z, String str, String str2, String[] strArr2, Bundle bundle) {
        Intent intent = new Intent();
        Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("allowableAccounts", arrayList);
        intent.putExtra("allowableAccountTypes", strArr);
        intent.putExtra("addAccountOptions", bundle);
        intent.putExtra("selectedAccount", account);
        intent.putExtra("alwaysPromptForAccount", z);
        intent.putExtra("descriptionTextOverride", str);
        intent.putExtra("authTokenType", str2);
        intent.putExtra("addAccountRequiredFeatures", strArr2);
        intent.putExtra("setGmsCoreAccount", false);
        intent.putExtra("overrideTheme", 0);
        intent.putExtra("overrideCustomTheme", 0);
        intent.putExtra("hostedDomainFilter", (String) null);
        return intent;
    }

    public static Intent newChooseAccountIntent(AccountChooserOptions accountChooserOptions) {
        Intent intent = new Intent();
        boolean unused = accountChooserOptions.zzk;
        String unused2 = accountChooserOptions.zzj;
        Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
        zza unused3 = accountChooserOptions.zzl;
        Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
        boolean unused4 = accountChooserOptions.zzb;
        Preconditions.checkArgument(true, "Making the selected account non-clickable is only supported for the theme THEME_DAY_NIGHT_GOOGLE_MATERIAL2");
        boolean unused5 = accountChooserOptions.zzk;
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("allowableAccounts", accountChooserOptions.zzc);
        if (accountChooserOptions.zzd != null) {
            intent.putExtra("allowableAccountTypes", (String[]) accountChooserOptions.zzd.toArray(new String[0]));
        }
        intent.putExtra("addAccountOptions", accountChooserOptions.zzg);
        intent.putExtra("selectedAccount", accountChooserOptions.zza);
        boolean unused6 = accountChooserOptions.zzb;
        intent.putExtra("selectedAccountIsNotClickable", false);
        intent.putExtra("alwaysPromptForAccount", accountChooserOptions.zze);
        intent.putExtra("descriptionTextOverride", accountChooserOptions.zzf);
        boolean unused7 = accountChooserOptions.zzh;
        intent.putExtra("setGmsCoreAccount", false);
        String unused8 = accountChooserOptions.zzm;
        intent.putExtra("realClientPackage", (String) null);
        int unused9 = accountChooserOptions.zzi;
        intent.putExtra("overrideTheme", 0);
        boolean unused10 = accountChooserOptions.zzk;
        intent.putExtra("overrideCustomTheme", 0);
        String unused11 = accountChooserOptions.zzj;
        intent.putExtra("hostedDomainFilter", (String) null);
        Bundle bundle = new Bundle();
        boolean unused12 = accountChooserOptions.zzk;
        zza unused13 = accountChooserOptions.zzl;
        boolean unused14 = accountChooserOptions.zzn;
        boolean unused15 = accountChooserOptions.zzo;
        if (!bundle.isEmpty()) {
            intent.putExtra("first_party_options_bundle", bundle);
        }
        return intent;
    }
}
