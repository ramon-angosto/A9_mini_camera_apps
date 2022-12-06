package com.baidu.mapapi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.mapapi.d;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import object.p2pipcam.utils.DataBaseHelper;

public class PlaceCaterActivity extends Activity implements d.a {
    static ImageView c = null;
    static DisplayMetrics n = null;
    static Hashtable<Integer, View> o = new Hashtable<>();
    static Handler p = new q();
    private static int q = -2;
    private static int r = -1;
    private static int s = 10;
    private static int t = 5;
    private static int u = 1;
    private static int v = -7566196;
    private static int w = -12487463;
    private static int x = -1710619;
    TextView a;
    TextView b;
    LinearLayout d;
    TextView e;
    TextView f;
    TextView g;
    TextView h;
    TextView i;
    TextView j;
    TextView k;
    TextView l;
    LinearLayout m;

    private Bitmap a(String str) {
        try {
            return BitmapFactory.decodeStream(getAssets().open(str));
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void a(LinearLayout linearLayout, List<h> list) {
        List<h> list2 = list;
        if (list2 != null && list.size() > 0) {
            this.m.removeAllViews();
            o.clear();
            int size = list.size();
            int i2 = (size / 2) + (size % 2);
            int i3 = 0;
            int i4 = 0;
            while (i4 < i2) {
                LinearLayout linearLayout2 = new LinearLayout(this);
                linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(r, q));
                linearLayout.addView(linearLayout2);
                LinearLayout linearLayout3 = new LinearLayout(this);
                linearLayout3.setOrientation(i3);
                linearLayout3.setLayoutParams(new ViewGroup.LayoutParams(r, q));
                linearLayout3.setPadding(20, 5, 5, 5);
                linearLayout2.addView(linearLayout3);
                ((LinearLayout.LayoutParams) linearLayout3.getLayoutParams()).weight = 1.0f;
                ImageView imageView = new ImageView(this);
                imageView.setLayoutParams(new ViewGroup.LayoutParams((int) (n.density * 22.0f), (int) (n.density * 22.0f)));
                int i5 = i4 * 2;
                imageView.setTag(Integer.valueOf(i5));
                int i6 = i5 + 1;
                d.a(linearLayout.hashCode(), i6, h.a.replaceAll("#replace#", list2.get(i5).d), this);
                o.put(Integer.valueOf(i6), imageView);
                linearLayout3.addView(imageView);
                ((LinearLayout.LayoutParams) imageView.getLayoutParams()).gravity = 17;
                TextView textView = new TextView(this);
                textView.setTag(list2.get(i5));
                int i7 = s;
                textView.setPadding(i7, i7, i7, i7);
                int i8 = q;
                textView.setLayoutParams(new ViewGroup.LayoutParams(i8, i8));
                textView.setClickable(true);
                textView.setText(list2.get(i5).b);
                textView.setTextColor(w);
                textView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        h hVar = (h) view.getTag();
                        PlaceCaterActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(hVar.c)));
                        s a2 = s.a();
                        a2.a("place_cater_moreinfo_click", "{\"cat\":\"" + hVar.b + "\"}");
                    }
                });
                linearLayout3.addView(textView);
                ((LinearLayout.LayoutParams) textView.getLayoutParams()).gravity = 17;
                if (i6 < size) {
                    LinearLayout linearLayout4 = new LinearLayout(this);
                    linearLayout4.setPadding(20, 5, 5, 5);
                    linearLayout4.setLayoutParams(new ViewGroup.LayoutParams(r, q));
                    linearLayout2.addView(linearLayout4);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout4.getLayoutParams();
                    layoutParams.weight = 1.0f;
                    layoutParams.gravity = 17;
                    ImageView imageView2 = new ImageView(this);
                    imageView2.setLayoutParams(new ViewGroup.LayoutParams((int) (n.density * 22.0f), (int) (n.density * 22.0f)));
                    list2.get(i6);
                    int i9 = i6 + 1;
                    d.a(linearLayout.hashCode(), i9, h.a.replaceAll("#replace#", list2.get(i6).d), this);
                    o.put(Integer.valueOf(i9), imageView2);
                    linearLayout4.addView(imageView2);
                    ((LinearLayout.LayoutParams) imageView2.getLayoutParams()).gravity = 16;
                    TextView textView2 = new TextView(this);
                    textView2.setTag(list2.get(i6));
                    int i10 = s;
                    textView2.setPadding(i10, i10, i10, i10);
                    textView2.setClickable(true);
                    textView2.setTextColor(w);
                    textView2.setText(list2.get(i6).b);
                    textView2.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            h hVar = (h) view.getTag();
                            PlaceCaterActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(hVar.c)));
                            s a2 = s.a();
                            a2.a("place_cater_moreinfo_click", "{\"cat\":\"" + hVar.b + "\"}");
                        }
                    });
                    linearLayout4.addView(textView2);
                    ((LinearLayout.LayoutParams) textView2.getLayoutParams()).gravity = 17;
                }
                i4++;
                i3 = 0;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        ViewGroup.LayoutParams layoutParams;
        ImageView imageView;
        LinearLayout linearLayout = this.d;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            int i2 = (int) f2;
            for (int i3 = 0; i3 < 5; i3++) {
                if (i3 < i2) {
                    imageView = new ImageView(this);
                    imageView.setImageBitmap(a("star_light.png"));
                    layoutParams = new ViewGroup.LayoutParams((int) (n.density * 20.0f), (int) (n.density * 20.0f));
                } else {
                    imageView = new ImageView(this);
                    imageView.setImageBitmap(a("star_gray.png"));
                    layoutParams = new ViewGroup.LayoutParams((int) (n.density * 20.0f), (int) (n.density * 20.0f));
                }
                imageView.setLayoutParams(layoutParams);
                imageView.setPadding(1, 1, 1, 1);
                this.d.addView(imageView);
            }
            TextView textView = new TextView(this);
            int i4 = q;
            textView.setLayoutParams(new ViewGroup.LayoutParams(i4, i4));
            textView.setText(Float.toString(f2));
            textView.setPadding(10, 0, 10, 0);
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.d.addView(textView);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(DisplayMetrics displayMetrics) {
        DisplayMetrics displayMetrics2 = displayMetrics;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-3355444);
        linearLayout.setPadding(1, 1, 1, 1);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setPadding(1, 1, 1, 1);
        linearLayout2.setBackgroundColor(-1);
        linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        linearLayout2.setOrientation(1);
        linearLayout.addView(linearLayout2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout2.getLayoutParams();
        int i2 = u;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = i2;
        layoutParams.topMargin = i2;
        layoutParams.leftMargin = i2;
        this.a = new TextView(this);
        this.a.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        this.a.setTextSize(18.0f);
        this.a.setText("");
        TextView textView = this.a;
        int i3 = t;
        textView.setPadding(i3, i3, i3, i3);
        this.a.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.a.setTypeface(Typeface.DEFAULT, 1);
        linearLayout2.addView(this.a);
        ((LinearLayout.LayoutParams) this.a.getLayoutParams()).leftMargin = 1;
        this.b = new TextView(this);
        this.b.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        this.b.setTextSize(16.0f);
        TextView textView2 = this.b;
        int i4 = s;
        textView2.setPadding(i4, i4, i4, i4);
        this.b.setTextColor(v);
        linearLayout2.addView(this.b);
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setBackgroundColor(-1);
        linearLayout3.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.addView(linearLayout3);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) linearLayout3.getLayoutParams();
        int i5 = u;
        layoutParams2.topMargin = i5;
        layoutParams2.rightMargin = i5;
        layoutParams2.bottomMargin = i5;
        layoutParams2.leftMargin = i5;
        c = new ImageView(this);
        c.setPadding(5, 5, 5, 5);
        c.setLayoutParams(new ViewGroup.LayoutParams((int) (displayMetrics2.density * 120.0f), (int) (displayMetrics2.density * 90.0f)));
        linearLayout3.addView(c);
        LinearLayout linearLayout4 = new LinearLayout(this);
        linearLayout4.setOrientation(1);
        linearLayout4.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        int i6 = s;
        linearLayout4.setPadding(i6, i6, i6, i6);
        linearLayout3.addView(linearLayout4);
        ((LinearLayout.LayoutParams) linearLayout4.getLayoutParams()).gravity = 16;
        this.d = new LinearLayout(this);
        this.d.setPadding(2, 2, 2, 2);
        this.d.setOrientation(0);
        linearLayout4.addView(this.d);
        LinearLayout linearLayout5 = new LinearLayout(this);
        linearLayout5.setPadding(2, 2, 2, 2);
        int i7 = q;
        linearLayout5.setLayoutParams(new ViewGroup.LayoutParams(i7, i7));
        linearLayout4.addView(linearLayout5);
        TextView textView3 = new TextView(this);
        textView3.setTextColor(v);
        textView3.setTextSize(16.0f);
        textView3.setText("参考价：");
        linearLayout5.addView(textView3);
        this.e = new TextView(this);
        this.e.setTextColor(-4712681);
        this.e.setTextSize(16.0f);
        linearLayout5.addView(this.e);
        LinearLayout linearLayout6 = new LinearLayout(this);
        linearLayout6.setPadding(2, 2, 2, 2);
        linearLayout4.addView(linearLayout6);
        this.f = new TextView(this);
        this.f.setPadding(0, 0, 5, 0);
        this.f.setText("口味:3.0");
        this.f.setTextColor(v);
        this.f.setTextSize(12.0f);
        linearLayout6.addView(this.f);
        this.g = new TextView(this);
        this.g.setPadding(0, 0, 5, 0);
        this.g.setText("服务:3.0");
        this.g.setTextColor(v);
        this.g.setTextSize(12.0f);
        linearLayout6.addView(this.g);
        this.h = new TextView(this);
        this.h.setPadding(0, 0, 5, 0);
        this.h.setText("环境:3.0");
        this.h.setTextColor(v);
        this.h.setTextSize(12.0f);
        linearLayout6.addView(this.h);
        LinearLayout linearLayout7 = new LinearLayout(this);
        linearLayout7.setBackgroundColor(-1);
        linearLayout7.setPadding(5, 5, 5, 5);
        linearLayout7.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout7.setOrientation(0);
        linearLayout.addView(linearLayout7);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) linearLayout7.getLayoutParams();
        int i8 = u;
        layoutParams3.topMargin = i8;
        layoutParams3.rightMargin = i8;
        layoutParams3.bottomMargin = i8;
        layoutParams3.leftMargin = i8;
        linearLayout7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    String obj = PlaceCaterActivity.this.i.getText().toString();
                    PlaceCaterActivity.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + obj.trim())));
                    s.a().a("place_telbutton_click", (String) null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ImageView imageView = new ImageView(this);
        imageView.setPadding(5, 5, 5, 5);
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) (displayMetrics2.density * 35.0f), (int) (displayMetrics2.density * 35.0f)));
        imageView.setImageBitmap(a("iconphone.png"));
        linearLayout7.addView(imageView);
        ((LinearLayout.LayoutParams) imageView.getLayoutParams()).gravity = 16;
        this.i = new TextView(this);
        this.i.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.i.setText("(010)4343243");
        this.i.setPadding(5, 5, 5, 5);
        this.i.setTextSize(16.0f);
        TextView textView4 = this.i;
        int i9 = q;
        textView4.setLayoutParams(new ViewGroup.LayoutParams(i9, i9));
        linearLayout7.addView(this.i);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams4.weight = 1.0f;
        layoutParams4.gravity = 16;
        ImageView imageView2 = new ImageView(this);
        int i10 = q;
        imageView2.setLayoutParams(new ViewGroup.LayoutParams(i10, i10));
        imageView2.setImageBitmap(a("arrow.png"));
        imageView2.setPadding(5, 5, 5, 10);
        linearLayout7.addView(imageView2);
        ((LinearLayout.LayoutParams) imageView2.getLayoutParams()).gravity = 16;
        LinearLayout linearLayout8 = new LinearLayout(this);
        linearLayout8.setBackgroundColor(x);
        linearLayout8.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        linearLayout8.setOrientation(1);
        linearLayout.addView(linearLayout8);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) linearLayout8.getLayoutParams();
        int i11 = u;
        layoutParams5.topMargin = i11;
        layoutParams5.rightMargin = i11;
        layoutParams5.bottomMargin = i11;
        layoutParams5.leftMargin = i11;
        TextView textView5 = new TextView(this);
        textView5.setTextSize(18.0f);
        textView5.setText("商户简介");
        int i12 = t;
        textView5.setPadding(i12, i12, i12, i12);
        textView5.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        int i13 = q;
        textView5.setLayoutParams(new ViewGroup.LayoutParams(i13, i13));
        linearLayout8.addView(textView5);
        this.j = new TextView(this);
        this.j.setBackgroundColor(-1);
        this.j.setTextColor(v);
        TextView textView6 = this.j;
        int i14 = s;
        textView6.setPadding(i14, i14, i14, i14);
        this.j.setTextSize(16.0f);
        this.j.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        linearLayout8.addView(this.j);
        this.k = new TextView(this);
        this.k.setBackgroundColor(-1);
        this.k.setTextColor(v);
        TextView textView7 = this.k;
        int i15 = s;
        textView7.setPadding(i15, i15, i15, i15);
        this.k.setTextSize(16.0f);
        this.k.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        linearLayout8.addView(this.k);
        LinearLayout linearLayout9 = new LinearLayout(this);
        linearLayout9.setBackgroundColor(x);
        linearLayout9.setOrientation(1);
        linearLayout9.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        linearLayout.addView(linearLayout9);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) linearLayout9.getLayoutParams();
        int i16 = u;
        layoutParams6.topMargin = i16;
        layoutParams6.rightMargin = i16;
        layoutParams6.bottomMargin = i16;
        layoutParams6.leftMargin = i16;
        TextView textView8 = new TextView(this);
        textView8.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        textView8.setText("评论信息");
        int i17 = t;
        textView8.setPadding(i17, i17, i17, i17);
        textView8.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView8.setTextSize(18.0f);
        linearLayout9.addView(textView8);
        this.l = new TextView(this);
        TextView textView9 = this.l;
        int i18 = s;
        textView9.setPadding(i18, i18, i18, i18);
        this.l.setBackgroundColor(-1);
        this.l.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        this.l.setTextSize(16.0f);
        this.l.setTextColor(v);
        linearLayout9.addView(this.l);
        LinearLayout linearLayout10 = new LinearLayout(this);
        linearLayout10.setBackgroundColor(x);
        linearLayout10.setOrientation(1);
        linearLayout10.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        linearLayout.addView(linearLayout10);
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) linearLayout10.getLayoutParams();
        int i19 = u;
        layoutParams7.topMargin = i19;
        layoutParams7.rightMargin = i19;
        layoutParams7.bottomMargin = i19;
        layoutParams7.leftMargin = i19;
        TextView textView10 = new TextView(this);
        int i20 = q;
        textView10.setLayoutParams(new ViewGroup.LayoutParams(i20, i20));
        textView10.setTextSize(18.0f);
        int i21 = t;
        textView10.setPadding(i21, i21, i21, i21);
        textView10.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView10.setText("查看更多");
        linearLayout10.addView(textView10);
        this.m = new LinearLayout(this);
        this.m.setOrientation(1);
        this.m.setBackgroundColor(-1);
        this.m.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        linearLayout10.addView(this.m);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setPadding(5, 5, 0, 5);
        int i22 = r;
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(i22, i22));
        scrollView.setBackgroundColor(-526345);
        scrollView.addView(linearLayout);
        ((FrameLayout.LayoutParams) linearLayout.getLayoutParams()).rightMargin = 5;
        setContentView(scrollView);
    }

    /* access modifiers changed from: package-private */
    public void a(l lVar) {
        this.a.setText(lVar.a);
        TextView textView = this.b;
        textView.setText("地址：" + lVar.b);
        TextView textView2 = this.e;
        textView2.setText("￥" + lVar.g);
        TextView textView3 = this.f;
        textView3.setText("口味:" + lVar.h);
        TextView textView4 = this.g;
        textView4.setText("服务:" + lVar.j);
        TextView textView5 = this.h;
        textView5.setText("环境:" + lVar.i);
        this.i.setText(lVar.c);
        if (lVar.l == null || "".equals(lVar.l)) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
            TextView textView6 = this.j;
            textView6.setText("推荐菜：" + lVar.l);
        }
        if (lVar.k == null || "".equals(lVar.k)) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
            TextView textView7 = this.k;
            textView7.setText("商户描述：" + lVar.k);
        }
        if (lVar.m == null || "".equals(lVar.m)) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
            this.l.setText(lVar.m);
        }
        if (lVar.e != null) {
            d.a(c.hashCode(), 0, lVar.e, this);
        }
        float f2 = 0.0f;
        try {
            f2 = Float.valueOf(lVar.f).floatValue();
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
        a(f2);
        a(this.m, lVar.o);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        s sVar;
        String str;
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        l lVar = new l();
        lVar.a = extras.getString(DataBaseHelper.KEY_NAME);
        lVar.b = extras.getString("addr");
        lVar.c = extras.getString("tel");
        lVar.d = extras.getString("uid");
        lVar.e = extras.getString("image");
        lVar.f = extras.getString("overall_rating");
        lVar.g = extras.getString("price");
        lVar.h = extras.getString("taste_rating");
        lVar.i = extras.getString("enviroment_raing");
        lVar.j = extras.getString("service_rating");
        lVar.k = extras.getString("description");
        lVar.l = extras.getString("recommendation");
        lVar.m = extras.getString("review");
        lVar.n = extras.getString("user_logo");
        String[] stringArray = extras.getStringArray("aryMoreLinkName");
        String[] stringArray2 = extras.getStringArray("aryMoreLinkUrl");
        String[] stringArray3 = extras.getStringArray("aryMoreLinkCnName");
        if (!(stringArray == null || stringArray2 == null)) {
            for (int i2 = 0; i2 < stringArray2.length; i2++) {
                if (!"dianping".equals(stringArray[i2])) {
                    h hVar = new h();
                    hVar.d = stringArray[i2];
                    hVar.c = stringArray2[i2];
                    hVar.b = stringArray3[i2];
                    lVar.o.add(hVar);
                }
            }
        }
        if (lVar.c == null || "".equals(lVar.c)) {
            sVar = s.a();
            str = "place_notel_show";
        } else {
            sVar = s.a();
            str = "place_tel_show";
        }
        sVar.a(str, (String) null);
        n = getResources().getDisplayMetrics();
        a(n);
        a(lVar);
    }

    public void onError(int i2, int i3, String str, Object obj) {
        Log.d("kal", "onError  :  url=" + str);
    }

    public void onOk(int i2, int i3, String str, Object obj) {
        Message obtainMessage;
        if (i2 == c.hashCode()) {
            obtainMessage = p.obtainMessage(1);
            obtainMessage.obj = obj;
        } else if (i2 == this.m.hashCode()) {
            obtainMessage = p.obtainMessage(2);
            obtainMessage.obj = obj;
            obtainMessage.arg1 = i3;
        } else {
            return;
        }
        obtainMessage.sendToTarget();
    }
}
