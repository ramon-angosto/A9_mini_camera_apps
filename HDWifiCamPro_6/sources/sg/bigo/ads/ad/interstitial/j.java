package sg.bigo.ads.ad.interstitial;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.a.b;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.core.n;
import sg.bigo.ads.common.f.c;
import sg.bigo.ads.common.h.d;
import sg.bigo.ads.common.h.e;
import sg.bigo.ads.common.i;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.common.utils.s;

public final class j {
    Bitmap a;
    private final b b;
    private int c = 0;
    private final List<a> d = new ArrayList();

    interface a {
        void a();
    }

    public j(b bVar) {
        this.b = bVar;
    }

    private void a(final ImageView imageView) {
        a((a) new a() {
            public final void a() {
                c.b(new Runnable() {
                    public final void run() {
                        imageView.setImageBitmap(j.this.a);
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    }
                });
            }
        });
    }

    private static void a(TextView textView, String str) {
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        }
    }

    private synchronized void a(a aVar) {
        if (this.a != null) {
            aVar.a();
            return;
        }
        this.d.add(aVar);
        if (this.c != 1) {
            this.c = 1;
            n q = this.b.q();
            if (q.ad()) {
                String b2 = i.b(q.X());
                if (!o.b(b2)) {
                    final String path = Uri.parse(b2).getPath();
                    c.a(3, new Runnable() {
                        public final void run() {
                            j.this.a(sg.bigo.ads.common.utils.c.a(Uri.parse(path).getPath()));
                        }
                    });
                    return;
                }
                return;
            }
            String ae = q.ae();
            if (!o.b(ae)) {
                sg.bigo.ads.common.h.c.a(ae, new e() {
                    public final void a(Bitmap bitmap, d dVar) {
                        j.this.a(bitmap);
                    }

                    public final void a(String str, String str2) {
                        j.this.a((Bitmap) null);
                    }
                });
            }
        }
    }

    private static void b(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(Bitmap bitmap) {
        this.a = bitmap;
        Iterator<a> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().a();
            it.remove();
        }
        this.c = 2;
    }

    public final void a(final ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 17) {
            a((a) new a() {
                public final void a() {
                    c.b(new Runnable() {
                        public final void run() {
                            Bitmap bitmap;
                            Context context = viewGroup.getContext();
                            ImageView imageView = new ImageView(context);
                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                            Bitmap bitmap2 = j.this.a;
                            if (bitmap2 == null) {
                                bitmap = null;
                            } else {
                                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, Math.round(((float) bitmap2.getWidth()) * 0.25f), Math.round(((float) bitmap2.getHeight()) * 0.25f), false);
                                if (createScaledBitmap.getConfig() != Bitmap.Config.ARGB_8888) {
                                    createScaledBitmap = bitmap2.copy(Bitmap.Config.ARGB_8888, true);
                                }
                                bitmap = Bitmap.createBitmap(createScaledBitmap);
                                RenderScript create = RenderScript.create(context);
                                ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                                Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
                                Allocation createFromBitmap2 = Allocation.createFromBitmap(create, bitmap);
                                create2.setRadius(10.0f);
                                create2.setInput(createFromBitmap);
                                create2.forEach(createFromBitmap2);
                                createFromBitmap2.copyTo(bitmap);
                                create.destroy();
                                createScaledBitmap.recycle();
                                createFromBitmap.destroy();
                                createFromBitmap2.destroy();
                            }
                            imageView.setImageBitmap(bitmap);
                            s.a(imageView, viewGroup, (ViewGroup.LayoutParams) null, 0);
                        }
                    });
                }
            });
        }
    }

    public final void a(ViewGroup viewGroup, View view, int i, int i2, View... viewArr) {
        ArrayList arrayList = new ArrayList();
        TextView textView = (TextView) view.findViewById(R.id.inter_title);
        if (textView != null) {
            textView.setTag(2);
            a(textView, this.b.getTitle());
            arrayList.add(textView);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.inter_description);
        if (textView2 != null) {
            textView2.setTag(6);
            a(textView2, this.b.getDescription());
            arrayList.add(textView2);
        }
        TextView textView3 = (TextView) view.findViewById(R.id.inter_warning);
        if (textView3 != null) {
            textView3.setTag(8);
            b(textView3, this.b.getWarning());
        }
        TextView textView4 = (TextView) view.findViewById(R.id.inter_btn_cta);
        if (textView4 != null) {
            textView4.setTag(7);
            a(textView4, this.b.getCallToAction());
            arrayList.add(textView4);
        }
        TextView textView5 = (TextView) view.findViewById(R.id.inter_btn_cta_main);
        if (textView5 != null) {
            textView5.setTag(7);
            a(textView5, this.b.getCallToAction());
            arrayList.add(textView5);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.end_page_image);
        if (imageView != null) {
            imageView.setTag(5);
            imageView.setImageBitmap(this.a);
        }
        ImageView imageView2 = (ImageView) view.findViewById(R.id.inter_icon);
        MediaView mediaView = (MediaView) view.findViewById(R.id.inter_media);
        this.b.a(viewGroup, mediaView, imageView2, (AdOptionsView) view.findViewById(R.id.inter_options), (List<View>) arrayList, i2, viewArr);
        if (imageView2 != null && !this.b.hasIcon()) {
            if (i == 2) {
                imageView2.setImageDrawable(imageView2.getContext().getResources().getDrawable(R.drawable.bigo_ad_icon_default));
            } else if (i == 1) {
                a(imageView2);
            }
        }
    }
}
