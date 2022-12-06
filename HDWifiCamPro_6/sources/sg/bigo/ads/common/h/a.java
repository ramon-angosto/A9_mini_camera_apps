package sg.bigo.ads.common.h;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.common.f.c;

public final class a {
    public final List<WeakReference<e>> a = new ArrayList();
    private final ImageView b;

    public a(ImageView imageView) {
        this.b = imageView;
        this.b.setAdjustViewBounds(true);
    }

    private void b(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            ImageView imageView = this.b;
            imageView.setImageDrawable(imageView.getResources().getDrawable(parseInt));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void c(final String str) {
        final WeakReference weakReference = new WeakReference(this.b);
        c.a(3, new Runnable() {
            public final void run() {
                c.a(str, new e(weakReference) {
                    final /* synthetic */ WeakReference a;

                    {
                        this.a = r2;
                    }

                    public final void a(Bitmap bitmap, d dVar) {
                        ImageView imageView = (ImageView) this.a.get();
                        if (imageView != null) {
                            imageView.setImageBitmap(bitmap);
                        }
                        for (WeakReference<e> weakReference : a.this.a) {
                            e eVar = (e) weakReference.get();
                            if (eVar != null) {
                                eVar.a(bitmap, dVar);
                            }
                        }
                    }

                    public final void a(String str, String str2) {
                        for (WeakReference<e> weakReference : a.this.a) {
                            e eVar = (e) weakReference.get();
                            if (eVar != null) {
                                eVar.a(str, str2);
                            }
                        }
                    }
                });
            }
        });
    }

    private void d(final String str) {
        final WeakReference weakReference = new WeakReference(this.b);
        c.a(3, new Runnable() {
            public final void run() {
                final Bitmap a2 = sg.bigo.ads.common.utils.c.a(str);
                if (a2 != null) {
                    c.b(new Runnable() {
                        public final void run() {
                            ImageView imageView = (ImageView) weakReference.get();
                            if (imageView != null) {
                                imageView.setImageBitmap(a2);
                            }
                        }
                    });
                }
            }
        });
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if ("res".equalsIgnoreCase(scheme)) {
                b(parse.getHost());
            } else if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                c(str);
            } else if ("file".equalsIgnoreCase(scheme)) {
                d(parse.getPath());
            }
        }
    }
}
