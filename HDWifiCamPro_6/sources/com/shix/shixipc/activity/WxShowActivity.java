package com.shix.shixipc.activity;

import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.SaveImageUtils;

public class WxShowActivity extends BaseActivity implements View.OnClickListener {
    /* access modifiers changed from: private */
    public int countPic = 0;
    /* access modifiers changed from: private */
    public ImageView img_show;
    /* access modifiers changed from: private */
    public boolean isSer = true;
    Bitmap logoBmp = null;
    /* access modifiers changed from: private */
    public PopupWindow popupWindow_Icut;
    private View popv_icut;
    private Button showCancel;
    /* access modifiers changed from: private */
    public TextView tvNexts;
    /* access modifiers changed from: private */
    public TextView tvUp;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_wxshow);
        CommonUtil.Log(1, "SHIX  onCreate");
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        findViewById(R.id.tvNext).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);
        initExitPopupWindow_Icut();
        this.logoBmp = BitmapFactory.decodeResource(getResources(), R.mipmap.cypush);
        findViewById(R.id.iv_er).setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(WxShowActivity.this, 10);
                }
                if (WxShowActivity.this.logoBmp == null) {
                    return false;
                }
                WxShowActivity wxShowActivity = WxShowActivity.this;
                SaveImageUtils.saveImageToGallery(wxShowActivity, wxShowActivity.logoBmp);
                WxShowActivity.this.showToast("保存成功，请打开微信识别");
                return false;
            }
        });
        findViewById(R.id.iv_scan).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(WxShowActivity.this, 10);
                }
                if (WxShowActivity.this.logoBmp != null) {
                    WxShowActivity wxShowActivity = WxShowActivity.this;
                    SaveImageUtils.saveImageToGallery(wxShowActivity, wxShowActivity.logoBmp);
                }
            }
        });
        findViewById(R.id.iv_er).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(WxShowActivity.this, 10);
                }
                if (WxShowActivity.this.logoBmp != null) {
                    WxShowActivity wxShowActivity = WxShowActivity.this;
                    SaveImageUtils.saveImageToGallery(wxShowActivity, wxShowActivity.logoBmp);
                }
                int unused = WxShowActivity.this.countPic = 0;
                boolean unused2 = WxShowActivity.this.isSer = false;
                WxShowActivity.this.img_show.setImageResource(R.mipmap.cypush);
                WxShowActivity.this.tvUp.setVisibility(8);
                WxShowActivity.this.tvNexts.setText("下一步");
                WxShowActivity.this.popupWindow_Icut.showAtLocation(WxShowActivity.this.findViewById(R.id.back), 17, 0, 0);
            }
        });
        findViewById(R.id.img_showadd2_2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int unused = WxShowActivity.this.countPic = 1;
                boolean unused2 = WxShowActivity.this.isSer = false;
                WxShowActivity.this.tvUp.setVisibility(0);
                WxShowActivity.this.img_show.setImageResource(R.mipmap.scan_ss_a);
                WxShowActivity.this.tvNexts.setText("下一步");
                WxShowActivity.this.popupWindow_Icut.showAtLocation(WxShowActivity.this.findViewById(R.id.back), 17, 0, 0);
            }
        });
        findViewById(R.id.img_showadd2_3).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int unused = WxShowActivity.this.countPic = 2;
                boolean unused2 = WxShowActivity.this.isSer = false;
                WxShowActivity.this.tvUp.setVisibility(0);
                WxShowActivity.this.img_show.setImageResource(R.mipmap.scan_ss_b);
                WxShowActivity.this.tvNexts.setText("下一步");
                WxShowActivity.this.popupWindow_Icut.showAtLocation(WxShowActivity.this.findViewById(R.id.back), 17, 0, 0);
            }
        });
        findViewById(R.id.img_showadd2_4).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int unused = WxShowActivity.this.countPic = 3;
                boolean unused2 = WxShowActivity.this.isSer = false;
                WxShowActivity.this.tvUp.setVisibility(0);
                WxShowActivity.this.img_show.setImageResource(R.mipmap.scan_ss_c);
                WxShowActivity.this.tvNexts.setText("打开微信\n前往扫一扫");
                WxShowActivity.this.popupWindow_Icut.showAtLocation(WxShowActivity.this.findViewById(R.id.back), 17, 0, 0);
            }
        });
        findViewById(R.id.img_showadd1_1).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int unused = WxShowActivity.this.countPic = 0;
                boolean unused2 = WxShowActivity.this.isSer = true;
                WxShowActivity.this.img_show.setImageResource(R.mipmap.cypushser);
                WxShowActivity.this.tvUp.setVisibility(8);
                WxShowActivity.this.tvNexts.setText("下一步");
                WxShowActivity.this.popupWindow_Icut.showAtLocation(WxShowActivity.this.findViewById(R.id.back), 17, 0, 0);
            }
        });
        findViewById(R.id.img_showadd1_2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int unused = WxShowActivity.this.countPic = 1;
                boolean unused2 = WxShowActivity.this.isSer = true;
                WxShowActivity.this.tvUp.setVisibility(0);
                WxShowActivity.this.img_show.setImageResource(R.mipmap.scan_wxshow_a);
                WxShowActivity.this.tvNexts.setText("下一步");
                WxShowActivity.this.popupWindow_Icut.showAtLocation(WxShowActivity.this.findViewById(R.id.back), 17, 0, 0);
            }
        });
        findViewById(R.id.img_showadd1_3).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int unused = WxShowActivity.this.countPic = 2;
                boolean unused2 = WxShowActivity.this.isSer = true;
                WxShowActivity.this.tvUp.setVisibility(0);
                WxShowActivity.this.img_show.setImageResource(R.mipmap.scan_wxshow_b);
                WxShowActivity.this.tvNexts.setText("下一步");
                WxShowActivity.this.popupWindow_Icut.showAtLocation(WxShowActivity.this.findViewById(R.id.back), 17, 0, 0);
            }
        });
        findViewById(R.id.img_showadd1_4).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int unused = WxShowActivity.this.countPic = 3;
                boolean unused2 = WxShowActivity.this.isSer = true;
                WxShowActivity.this.tvUp.setVisibility(0);
                WxShowActivity.this.img_show.setImageResource(R.mipmap.scan_wxshow_c);
                WxShowActivity.this.tvNexts.setText("打开微信\n前往搜一搜");
                WxShowActivity.this.popupWindow_Icut.showAtLocation(WxShowActivity.this.findViewById(R.id.back), 17, 0, 0);
            }
        });
        ((ClipboardManager) getSystemService("clipboard")).setText("CyPush");
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            finish();
        } else if (id == R.id.tvNext) {
            Bitmap bitmap = this.logoBmp;
            if (bitmap != null) {
                SaveImageUtils.saveImageToGallery(this, bitmap);
            }
            try {
                Intent intent = new Intent();
                ComponentName componentName = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
                intent.setAction("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.addFlags(268435456);
                intent.setComponent(componentName);
                startActivity(intent);
            } catch (Exception unused) {
                showToast("请检查是否安装了微信，请安装好微信再使用此功能");
            }
        }
    }

    public void initExitPopupWindow_Icut() {
        this.popv_icut = LayoutInflater.from(this).inflate(R.layout.popup_addimgshow, (ViewGroup) null);
        this.showCancel = (Button) this.popv_icut.findViewById(R.id.showCancel);
        this.img_show = (ImageView) this.popv_icut.findViewById(R.id.img_show);
        this.showCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WxShowActivity.this.popupWindow_Icut.dismiss();
            }
        });
        this.tvUp = (TextView) this.popv_icut.findViewById(R.id.tvUp);
        this.tvUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (WxShowActivity.this.isSer) {
                    if (WxShowActivity.this.countPic == 0) {
                        WxShowActivity.this.popupWindow_Icut.dismiss();
                    } else if (WxShowActivity.this.countPic == 1) {
                        int unused = WxShowActivity.this.countPic = 0;
                        WxShowActivity.this.img_show.setImageResource(R.mipmap.cypushser);
                    } else if (WxShowActivity.this.countPic == 2) {
                        int unused2 = WxShowActivity.this.countPic = 1;
                        WxShowActivity.this.img_show.setImageResource(R.mipmap.scan_wxshow_a);
                    } else if (WxShowActivity.this.countPic == 3) {
                        WxShowActivity.this.tvNexts.setText("下一步");
                        int unused3 = WxShowActivity.this.countPic = 2;
                        WxShowActivity.this.img_show.setImageResource(R.mipmap.scan_wxshow_b);
                    }
                } else if (WxShowActivity.this.countPic == 0) {
                    WxShowActivity.this.popupWindow_Icut.dismiss();
                } else if (WxShowActivity.this.countPic == 1) {
                    int unused4 = WxShowActivity.this.countPic = 0;
                    WxShowActivity.this.img_show.setImageResource(R.mipmap.cypush);
                } else if (WxShowActivity.this.countPic == 2) {
                    int unused5 = WxShowActivity.this.countPic = 1;
                    WxShowActivity.this.img_show.setImageResource(R.mipmap.scan_ss_a);
                } else if (WxShowActivity.this.countPic == 3) {
                    WxShowActivity.this.tvNexts.setText("下一步");
                    int unused6 = WxShowActivity.this.countPic = 2;
                    WxShowActivity.this.img_show.setImageResource(R.mipmap.scan_ss_b);
                }
            }
        });
        this.tvNexts = (TextView) this.popv_icut.findViewById(R.id.tvNexts);
        this.tvNexts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (WxShowActivity.this.isSer) {
                    if (WxShowActivity.this.countPic == 0) {
                        int unused = WxShowActivity.this.countPic = 1;
                        WxShowActivity.this.tvUp.setVisibility(0);
                        WxShowActivity.this.img_show.setImageResource(R.mipmap.scan_wxshow_a);
                    } else if (WxShowActivity.this.countPic == 1) {
                        int unused2 = WxShowActivity.this.countPic = 2;
                        WxShowActivity.this.tvUp.setVisibility(0);
                        WxShowActivity.this.img_show.setImageResource(R.mipmap.scan_wxshow_b);
                    } else if (WxShowActivity.this.countPic == 2) {
                        int unused3 = WxShowActivity.this.countPic = 3;
                        WxShowActivity.this.tvUp.setVisibility(0);
                        WxShowActivity.this.img_show.setImageResource(R.mipmap.scan_wxshow_c);
                        WxShowActivity.this.tvNexts.setText("打开微信\n前往搜一搜");
                    } else if (WxShowActivity.this.countPic == 3) {
                        try {
                            Intent intent = new Intent();
                            ComponentName componentName = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
                            intent.setAction("android.intent.action.MAIN");
                            intent.addCategory("android.intent.category.LAUNCHER");
                            intent.addFlags(268435456);
                            intent.setComponent(componentName);
                            WxShowActivity.this.startActivity(intent);
                        } catch (Exception unused4) {
                            WxShowActivity.this.showToast("请检查是否安装了微信，请安装好微信再使用此功能");
                        }
                    }
                } else if (WxShowActivity.this.countPic == 0) {
                    int unused5 = WxShowActivity.this.countPic = 1;
                    WxShowActivity.this.tvUp.setVisibility(0);
                    WxShowActivity.this.img_show.setImageResource(R.mipmap.scan_ss_a);
                } else if (WxShowActivity.this.countPic == 1) {
                    int unused6 = WxShowActivity.this.countPic = 2;
                    WxShowActivity.this.tvUp.setVisibility(0);
                    WxShowActivity.this.img_show.setImageResource(R.mipmap.scan_ss_b);
                } else if (WxShowActivity.this.countPic == 2) {
                    int unused7 = WxShowActivity.this.countPic = 3;
                    WxShowActivity.this.tvUp.setVisibility(0);
                    WxShowActivity.this.img_show.setImageResource(R.mipmap.scan_ss_c);
                    WxShowActivity.this.tvNexts.setText("打开微信\n前往扫一扫");
                } else if (WxShowActivity.this.countPic == 3) {
                    if (WxShowActivity.this.logoBmp != null) {
                        WxShowActivity wxShowActivity = WxShowActivity.this;
                        SaveImageUtils.saveImageToGallery(wxShowActivity, wxShowActivity.logoBmp);
                        WxShowActivity.this.showToast("保存成功，请打开微信识别");
                    }
                    try {
                        Intent intent2 = new Intent();
                        ComponentName componentName2 = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
                        intent2.setAction("android.intent.action.MAIN");
                        intent2.addCategory("android.intent.category.LAUNCHER");
                        intent2.addFlags(268435456);
                        intent2.setComponent(componentName2);
                        WxShowActivity.this.startActivity(intent2);
                    } catch (Exception unused8) {
                        WxShowActivity.this.showToast("请检查是否安装了微信，请安装好微信再使用此功能");
                    }
                }
            }
        });
        this.popupWindow_Icut = new PopupWindow(this.popv_icut, -1, -1);
        this.popupWindow_Icut.setAnimationStyle(R.style.MainAnimationPreview);
        this.popupWindow_Icut.setFocusable(true);
        this.popupWindow_Icut.setInputMethodMode(1);
        this.popupWindow_Icut.setSoftInputMode(16);
        this.popupWindow_Icut.setOutsideTouchable(true);
        this.popupWindow_Icut.setBackgroundDrawable(new ColorDrawable(0));
        this.popv_icut.setFocusableInTouchMode(true);
        this.popv_icut.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 82) {
                    return false;
                }
                WxShowActivity.this.popupWindow_Icut.dismiss();
                return false;
            }
        });
        this.popupWindow_Icut.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                WxShowActivity.this.popupWindow_Icut.dismiss();
            }
        });
        this.popupWindow_Icut.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                WxShowActivity.this.popupWindow_Icut.dismiss();
                return false;
            }
        });
    }
}
