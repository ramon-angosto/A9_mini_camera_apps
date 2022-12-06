package com.mbridge.msdk.video.dynview;

import android.content.Context;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;

/* compiled from: ViewOption */
public final class b {
    private Context a;
    private String b;
    private int c;
    private float d;
    private float e;
    private int f;
    private int g;
    private View h;
    private List<CampaignEx> i;
    private int j;

    /* renamed from: com.mbridge.msdk.video.dynview.b$b  reason: collision with other inner class name */
    /* compiled from: ViewOption */
    public interface C0103b {
        C0103b a(float f);

        C0103b a(int i);

        C0103b a(Context context);

        C0103b a(View view);

        C0103b a(String str);

        C0103b a(List<CampaignEx> list);

        b a();

        C0103b b(float f);

        C0103b b(int i);

        C0103b c(int i);

        C0103b d(int i);
    }

    public final Context a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final float c() {
        return this.d;
    }

    public final float d() {
        return this.e;
    }

    public final int e() {
        return this.f;
    }

    public final View f() {
        return this.h;
    }

    public final List<CampaignEx> g() {
        return this.i;
    }

    public final int h() {
        return this.c;
    }

    public final int i() {
        return this.j;
    }

    private b(a aVar) {
        this.e = aVar.e;
        this.d = aVar.d;
        this.f = aVar.f;
        this.g = aVar.g;
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
    }

    /* compiled from: ViewOption */
    public static class a implements C0103b {
        /* access modifiers changed from: private */
        public Context a;
        /* access modifiers changed from: private */
        public String b;
        /* access modifiers changed from: private */
        public int c;
        /* access modifiers changed from: private */
        public float d;
        /* access modifiers changed from: private */
        public float e;
        /* access modifiers changed from: private */
        public int f;
        /* access modifiers changed from: private */
        public int g;
        /* access modifiers changed from: private */
        public View h;
        /* access modifiers changed from: private */
        public List<CampaignEx> i;
        /* access modifiers changed from: private */
        public int j;

        public final C0103b a(Context context) {
            this.a = context.getApplicationContext();
            return this;
        }

        public final C0103b a(String str) {
            this.b = str;
            return this;
        }

        public final C0103b a(int i2) {
            this.c = i2;
            return this;
        }

        public final C0103b a(float f2) {
            this.d = f2;
            return this;
        }

        public final C0103b b(float f2) {
            this.e = f2;
            return this;
        }

        public final C0103b b(int i2) {
            this.f = i2;
            return this;
        }

        public final C0103b c(int i2) {
            this.g = i2;
            return this;
        }

        public final C0103b a(View view) {
            this.h = view;
            return this;
        }

        public final C0103b a(List<CampaignEx> list) {
            this.i = list;
            return this;
        }

        public final C0103b d(int i2) {
            this.j = i2;
            return this;
        }

        public final b a() {
            return new b(this);
        }
    }
}
