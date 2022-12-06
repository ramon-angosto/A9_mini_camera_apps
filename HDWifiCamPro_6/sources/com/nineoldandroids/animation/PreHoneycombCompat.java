package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.util.Property;
import com.nineoldandroids.view.animation.AnimatorProxy;

final class PreHoneycombCompat {
    static Property<View, Float> ALPHA = new FloatProperty<View>("alpha") {
        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setAlpha(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getAlpha());
        }
    };
    static Property<View, Float> PIVOT_X = new FloatProperty<View>("pivotX") {
        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setPivotX(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getPivotX());
        }
    };
    static Property<View, Float> PIVOT_Y = new FloatProperty<View>("pivotY") {
        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setPivotY(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getPivotY());
        }
    };
    static Property<View, Float> ROTATION = new FloatProperty<View>("rotation") {
        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setRotation(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotation());
        }
    };
    static Property<View, Float> ROTATION_X = new FloatProperty<View>("rotationX") {
        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setRotationX(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotationX());
        }
    };
    static Property<View, Float> ROTATION_Y = new FloatProperty<View>("rotationY") {
        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setRotationY(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotationY());
        }
    };
    static Property<View, Float> SCALE_X = new FloatProperty<View>("scaleX") {
        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setScaleX(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getScaleX());
        }
    };
    static Property<View, Float> SCALE_Y = new FloatProperty<View>("scaleY") {
        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setScaleY(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getScaleY());
        }
    };
    static Property<View, Integer> SCROLL_X = new IntProperty<View>("scrollX") {
        public void setValue(View view, int i) {
            AnimatorProxy.wrap(view).setScrollX(i);
        }

        public Integer get(View view) {
            return Integer.valueOf(AnimatorProxy.wrap(view).getScrollX());
        }
    };
    static Property<View, Integer> SCROLL_Y = new IntProperty<View>("scrollY") {
        public void setValue(View view, int i) {
            AnimatorProxy.wrap(view).setScrollY(i);
        }

        public Integer get(View view) {
            return Integer.valueOf(AnimatorProxy.wrap(view).getScrollY());
        }
    };
    static Property<View, Float> TRANSLATION_X = new FloatProperty<View>("translationX") {
        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setTranslationX(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getTranslationX());
        }
    };
    static Property<View, Float> TRANSLATION_Y = new FloatProperty<View>("translationY") {
        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setTranslationY(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getTranslationY());
        }
    };
    static Property<View, Float> X = new FloatProperty<View>("x") {
        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setX(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getX());
        }
    };
    static Property<View, Float> Y = new FloatProperty<View>("y") {
        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setY(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getY());
        }
    };

    private PreHoneycombCompat() {
    }
}
