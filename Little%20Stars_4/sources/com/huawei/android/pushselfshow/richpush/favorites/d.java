package com.huawei.android.pushselfshow.richpush.favorites;

import android.content.DialogInterface;
import com.huawei.android.pushselfshow.richpush.favorites.FavoritesActivity;

class d implements DialogInterface.OnClickListener {
    final /* synthetic */ FavoritesActivity.b a;

    d(FavoritesActivity.b bVar) {
        this.a = bVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        FavoritesActivity.this.f.a(FavoritesActivity.this.j);
        new Thread(new e(this)).start();
    }
}
