package object.p2pipcam.customComponent;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Gallery;
import shix.ihdbell.project.ShowLocalPictureActivity;

public class MyGallery extends Gallery {
    private GestureDetector gestureScanner;
    Handler handler;
    /* access modifiers changed from: private */
    public MyLocalPicImageView imageView;
    /* access modifiers changed from: private */
    public boolean isFirst;
    /* access modifiers changed from: private */
    public MyGalleryEvent myGalleryEvent;

    public interface MyGalleryEvent {
        void myTouch(MotionEvent motionEvent);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public MyGallery(Context context) {
        super(context);
        this.isFirst = true;
        this.myGalleryEvent = null;
        this.handler = new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (MyGallery.this.isFirst) {
                    Log.d("tgg", "isFirst");
                    MotionEvent motionEvent = (MotionEvent) message.obj;
                    if (MyGallery.this.myGalleryEvent != null) {
                        MyGallery.this.myGalleryEvent.myTouch(motionEvent);
                        return;
                    }
                    return;
                }
                Log.d("tgg", "not isFirst");
            }
        };
    }

    public MyGallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isFirst = true;
        this.myGalleryEvent = null;
        this.handler = new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (MyGallery.this.isFirst) {
                    Log.d("tgg", "isFirst");
                    MotionEvent motionEvent = (MotionEvent) message.obj;
                    if (MyGallery.this.myGalleryEvent != null) {
                        MyGallery.this.myGalleryEvent.myTouch(motionEvent);
                        return;
                    }
                    return;
                }
                Log.d("tgg", "not isFirst");
            }
        };
    }

    public MyGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isFirst = true;
        this.myGalleryEvent = null;
        this.handler = new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (MyGallery.this.isFirst) {
                    Log.d("tgg", "isFirst");
                    MotionEvent motionEvent = (MotionEvent) message.obj;
                    if (MyGallery.this.myGalleryEvent != null) {
                        MyGallery.this.myGalleryEvent.myTouch(motionEvent);
                        return;
                    }
                    return;
                }
                Log.d("tgg", "not isFirst");
            }
        };
        this.gestureScanner = new GestureDetector(new MySimpleGesture());
        setOnTouchListener(new View.OnTouchListener() {
            float baseValue;
            float originalScale;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                View selectedView = MyGallery.this.getSelectedView();
                if (selectedView instanceof MyLocalPicImageView) {
                    MyLocalPicImageView unused = MyGallery.this.imageView = (MyLocalPicImageView) selectedView;
                    if (motionEvent.getAction() == 0) {
                        this.baseValue = 0.0f;
                        this.originalScale = MyGallery.this.imageView.getScale();
                        Log.d("tg", "originalScale:" + this.originalScale);
                    }
                    if (motionEvent.getAction() == 2 && motionEvent.getPointerCount() == 2) {
                        float x = motionEvent.getX(0) - motionEvent.getX(1);
                        float y = motionEvent.getY(0) - motionEvent.getY(1);
                        float sqrt = (float) Math.sqrt((double) ((x * x) + (y * y)));
                        float f = this.baseValue;
                        if (f == 0.0f) {
                            this.baseValue = sqrt;
                        } else {
                            float f2 = sqrt / f;
                            Log.d("tg", "MyGallery onTouch scale:" + f2);
                            MyGallery.this.imageView.zoomTo(this.originalScale * f2, x + motionEvent.getX(1), y + motionEvent.getY(1));
                        }
                    }
                }
                return false;
            }
        });
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        View selectedView = getSelectedView();
        if (selectedView instanceof MyLocalPicImageView) {
            this.imageView = (MyLocalPicImageView) selectedView;
            float[] fArr = new float[9];
            this.imageView.getImageMatrix().getValues(fArr);
            float scale = this.imageView.getScale() * ((float) this.imageView.getImageWidth());
            float scale2 = this.imageView.getScale() * ((float) this.imageView.getImageHeight());
            if (((int) scale) > ShowLocalPictureActivity.screenWidth || ((int) scale2) > ShowLocalPictureActivity.screenHeight) {
                float f3 = fArr[2];
                float f4 = scale + f3;
                Rect rect = new Rect();
                this.imageView.getGlobalVisibleRect(rect);
                if (f > 0.0f) {
                    if (rect.left > 0) {
                        super.onScroll(motionEvent, motionEvent2, f, f2);
                        return false;
                    } else if (f4 < ((float) ShowLocalPictureActivity.screenWidth)) {
                        super.onScroll(motionEvent, motionEvent2, f, f2);
                        return false;
                    } else {
                        this.imageView.postTranslate(-f, -f2);
                        return false;
                    }
                } else if (f >= 0.0f) {
                    return false;
                } else {
                    if (rect.right < ShowLocalPictureActivity.screenWidth) {
                        super.onScroll(motionEvent, motionEvent2, f, f2);
                        return false;
                    } else if (f3 > 0.0f) {
                        super.onScroll(motionEvent, motionEvent2, f, f2);
                        return false;
                    } else {
                        this.imageView.postTranslate(-f, -f2);
                        return false;
                    }
                }
            } else {
                super.onScroll(motionEvent, motionEvent2, f, f2);
                return false;
            }
        } else {
            super.onScroll(motionEvent, motionEvent2, f, f2);
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.gestureScanner.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            View selectedView = getSelectedView();
            if (selectedView instanceof MyLocalPicImageView) {
                this.imageView = (MyLocalPicImageView) selectedView;
                float scale = this.imageView.getScale() * ((float) this.imageView.getImageWidth());
                float scale2 = this.imageView.getScale() * ((float) this.imageView.getImageHeight());
                if (((int) scale) <= ShowLocalPictureActivity.screenWidth) {
                    int i = (int) scale2;
                    int i2 = ShowLocalPictureActivity.screenHeight;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMyTouch(MyGalleryEvent myGalleryEvent2) {
        this.myGalleryEvent = myGalleryEvent2;
    }

    private class MySimpleGesture extends GestureDetector.SimpleOnGestureListener {
        private MySimpleGesture() {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            Log.d("tgg", "isFirst");
            boolean unused = MyGallery.this.isFirst = true;
            Message obtainMessage = MyGallery.this.handler.obtainMessage();
            obtainMessage.obj = motionEvent;
            MyGallery.this.handler.sendMessageDelayed(obtainMessage, 300);
            return super.onSingleTapUp(motionEvent);
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            boolean unused = MyGallery.this.isFirst = false;
            Log.d("tgg", "OnDublieTap");
            View selectedView = MyGallery.this.getSelectedView();
            if (!(selectedView instanceof MyLocalPicImageView)) {
                return true;
            }
            MyLocalPicImageView unused2 = MyGallery.this.imageView = (MyLocalPicImageView) selectedView;
            if (MyGallery.this.imageView.getScale() > MyGallery.this.imageView.getScaleRate()) {
                MyGallery.this.imageView.zoomTo(MyGallery.this.imageView.getScaleRate(), (float) (ShowLocalPictureActivity.screenWidth / 2), (float) (ShowLocalPictureActivity.screenHeight / 2), 200.0f);
                return true;
            }
            MyGallery.this.imageView.zoomTo(1.0f, (float) (ShowLocalPictureActivity.screenWidth / 2), (float) (ShowLocalPictureActivity.screenHeight / 2), 200.0f);
            return true;
        }
    }
}
