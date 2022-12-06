package sg.bigo.ads.core.adview;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import sg.bigo.ads.R;
import sg.bigo.ads.api.AdActivity;
import sg.bigo.ads.api.a;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.core.landing.WebViewActivityImpl;

public final class b extends c {
    public b(a<?> aVar) {
        super(aVar);
    }

    public final void a(c cVar) {
        if (cVar != null) {
            this.a.removeAllViews();
            c.d q = cVar.q();
            sg.bigo.ads.common.view.a aVar = new sg.bigo.ads.common.view.a(this.a.getContext());
            final String str = "";
            String a = q != null ? q.a() : str;
            if (q != null) {
                str = q.b();
            }
            aVar.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    Context context = b.this.a.getContext();
                    String str = str;
                    Intent a2 = AdActivity.a(context, WebViewActivityImpl.class);
                    a2.putExtra("url", str);
                    context.startActivity(a2);
                }
            });
            aVar.setImageURI("res://" + R.drawable.bigo_ad_ic_ads);
            if (!TextUtils.isEmpty(a)) {
                aVar.setImageURI(a);
            }
            aVar.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            a(aVar);
        }
    }
}
