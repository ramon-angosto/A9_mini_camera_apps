package sg.bigo.ads.ad.b;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import sg.bigo.ads.R;

final class a extends Dialog {
    /* access modifiers changed from: private */
    public C0112a a;

    /* renamed from: sg.bigo.ads.ad.b.a$a  reason: collision with other inner class name */
    interface C0112a {
        void a();

        void b();

        void c();
    }

    public a(Context context) {
        super(context, R.style.BigoAd_Dialog_Fullscreen);
        setCanceledOnTouchOutside(true);
    }

    public final void a(C0112a aVar) {
        this.a = aVar;
        getWindow().setFlags(8, 8);
        super.show();
        View decorView = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            decorView.setSystemUiVisibility(5894);
        }
        getWindow().clearFlags(8);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigo_ad_dialog_reward_retain, (ViewGroup) null, false);
        setContentView(inflate);
        inflate.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.dismiss();
            }
        });
        inflate.findViewById(R.id.btn_resume).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (a.this.a != null) {
                    C0112a unused = a.this.a;
                }
                a.this.dismiss();
            }
        });
        inflate.findViewById(R.id.btn_skip).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (a.this.a != null) {
                    a.this.a.c();
                }
                a.this.dismiss();
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void onStart() {
        super.onStart();
        C0112a aVar = this.a;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* access modifiers changed from: protected */
    public final void onStop() {
        super.onStop();
        C0112a aVar = this.a;
        if (aVar != null) {
            aVar.b();
            this.a = null;
        }
    }
}
