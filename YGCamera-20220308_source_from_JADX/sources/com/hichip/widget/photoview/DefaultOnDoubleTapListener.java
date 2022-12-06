package com.hichip.widget.photoview;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

public class DefaultOnDoubleTapListener implements GestureDetector.OnDoubleTapListener {
    private PhotoViewAttacher photoViewAttacher;

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public DefaultOnDoubleTapListener(PhotoViewAttacher photoViewAttacher2) {
        setPhotoViewAttacher(photoViewAttacher2);
    }

    public void setPhotoViewAttacher(PhotoViewAttacher photoViewAttacher2) {
        this.photoViewAttacher = photoViewAttacher2;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF displayRect;
        PhotoViewAttacher photoViewAttacher2 = this.photoViewAttacher;
        if (photoViewAttacher2 == null) {
            return false;
        }
        ImageView imageView = photoViewAttacher2.getImageView();
        if (!(this.photoViewAttacher.getOnPhotoTapListener() == null || (displayRect = this.photoViewAttacher.getDisplayRect()) == null)) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (displayRect.contains(x, y)) {
                this.photoViewAttacher.getOnPhotoTapListener().onPhotoTap(imageView, (x - displayRect.left) / displayRect.width(), (y - displayRect.top) / displayRect.height());
                return true;
            }
        }
        if (this.photoViewAttacher.getOnViewTapListener() != null) {
            this.photoViewAttacher.getOnViewTapListener().onViewTap(imageView, motionEvent.getX(), motionEvent.getY());
        }
        return false;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        PhotoViewAttacher photoViewAttacher2 = this.photoViewAttacher;
        if (photoViewAttacher2 == null) {
            return false;
        }
        try {
            float scale = photoViewAttacher2.getScale();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (scale < this.photoViewAttacher.getMediumScale()) {
                this.photoViewAttacher.setScale(this.photoViewAttacher.getMediumScale(), x, y, true);
            } else if (scale < this.photoViewAttacher.getMediumScale() || scale >= this.photoViewAttacher.getMaximumScale()) {
                this.photoViewAttacher.setScale(this.photoViewAttacher.getMinimumScale(), x, y, true);
            } else {
                this.photoViewAttacher.setScale(this.photoViewAttacher.getMaximumScale(), x, y, true);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
        return true;
    }
}
