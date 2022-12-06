package sg.bigo.ads.ad.interstitial;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import sg.bigo.ads.R;
import sg.bigo.ads.common.utils.d;
import sg.bigo.ads.common.utils.l;
import sg.bigo.ads.common.utils.o;

public class AdCountDownButton extends FrameLayout {
    protected final Context a;
    l b;
    public boolean c;
    private boolean d;
    /* access modifiers changed from: private */
    public boolean e;
    private boolean f;
    private View g;
    private View h;
    private TextView i;

    public interface a {
        void a();
    }

    public interface b {
        void a();
    }

    public AdCountDownButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public AdCountDownButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    public AdCountDownButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = true;
        this.d = false;
        this.f = false;
        this.a = context;
        setClickable(true);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.AdCountDownButton);
        try {
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.AdCountDownButton_customLayout, 0);
            obtainStyledAttributes.recycle();
            LayoutInflater.from(this.a).inflate(resourceId, this, true);
            this.g = findViewById(R.id.btn_close);
            this.h = findViewById(R.id.view_stroke);
            this.i = (TextView) findViewById(R.id.text_countdown);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        d();
        int i2 = 0;
        this.i.setVisibility(z ? 0 : 8);
        View view = this.h;
        if (!z) {
            i2 = 8;
        }
        view.setVisibility(i2);
    }

    /* access modifiers changed from: private */
    public void b(long j) {
        TextView textView = this.i;
        StringBuilder sb = new StringBuilder("%d");
        sb.append(this.f ? "s" : "");
        textView.setText(o.a(sb.toString(), Integer.valueOf(Math.round(((float) j) / 1000.0f))));
    }

    private void d() {
        this.g.setVisibility(0);
        this.g.setClickable(true);
        this.g.animate().alpha(1.0f).setDuration(200).start();
    }

    private void e() {
        this.g.setVisibility(0);
        this.g.setAlpha(0.2f);
        this.g.setClickable(false);
    }

    public final void a() {
        l lVar = this.b;
        if (lVar != null) {
            lVar.d();
        }
    }

    public final void a(int i2, final b bVar) {
        this.i.setVisibility(0);
        this.h.setVisibility(8);
        this.g.setVisibility(8);
        if (this.d) {
            this.h.setVisibility(0);
            e();
        }
        if (i2 == 0) {
            a(this.e);
            if (bVar != null) {
                bVar.a();
                return;
            }
            return;
        }
        this.c = false;
        if (i2 >= 0) {
            this.b = new l(((long) i2) * 1000) {
                public final void a() {
                    AdCountDownButton adCountDownButton = AdCountDownButton.this;
                    adCountDownButton.a(adCountDownButton.e);
                    b bVar = bVar;
                    if (bVar != null) {
                        bVar.a();
                    }
                    boolean unused = AdCountDownButton.this.c = true;
                }

                public final void a(long j) {
                    if (!AdCountDownButton.this.e) {
                        AdCountDownButton.this.b(j);
                    }
                }
            };
            this.b.c();
        }
    }

    public final void a(long j) {
        if (this.e) {
            b(j);
        }
    }

    public final void b() {
        l lVar = this.b;
        if (lVar != null && lVar.e()) {
            this.b.c();
        }
    }

    public final void c() {
        l lVar = this.b;
        if (lVar != null) {
            lVar.b();
        }
        this.c = true;
        a(false);
    }

    public void setOnCloseListener(final a aVar) {
        View view = this.g;
        if (view != null) {
            if (aVar == null) {
                view.setOnClickListener((View.OnClickListener) null);
            } else {
                view.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        aVar.a();
                    }
                });
            }
        }
    }

    public void setShowCloseButtonInCountdown(boolean z) {
        this.d = z;
        if (this.d) {
            this.i.setPadding(d.a(getContext(), 2), 0, 0, 0);
        } else {
            this.i.setPadding(0, 0, 0, 0);
        }
    }

    public void setTakeoverTickEvent(boolean z) {
        this.e = z;
    }

    public void setWithUnit(boolean z) {
        this.f = z;
    }
}
