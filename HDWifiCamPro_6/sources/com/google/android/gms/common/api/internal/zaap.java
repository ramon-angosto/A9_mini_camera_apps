package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zaap extends zaav {
    final /* synthetic */ zaaw zaa;
    private final ArrayList<Api.Client> zac;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaap(zaaw zaaw, ArrayList<Api.Client> arrayList) {
        super(zaaw, (zaau) null);
        this.zaa = zaaw;
        this.zac = arrayList;
    }

    public final void zaa() {
        zaaw zaaw = this.zaa;
        zaaw.zaa.zag.zad = zaaw.zao(zaaw);
        ArrayList<Api.Client> arrayList = this.zac;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zaaw zaaw2 = this.zaa;
            arrayList.get(i).getRemoteService(zaaw2.zao, zaaw2.zaa.zag.zad);
        }
    }
}
