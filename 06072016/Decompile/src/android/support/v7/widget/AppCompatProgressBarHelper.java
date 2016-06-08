package android.support.v7.widget;

import android.widget.*;
import android.graphics.drawable.shapes.*;
import android.support.v4.graphics.drawable.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.util.*;
import android.support.v7.internal.widget.*;

class AppCompatProgressBarHelper
{
    private static final int[] TINT_ATTRS;
    private Bitmap mSampleTile;
    final TintManager mTintManager;
    private final ProgressBar mView;
    
    static {
        TINT_ATTRS = new int[] { 16843067, 16843068 };
    }
    
    AppCompatProgressBarHelper(final ProgressBar mView, final TintManager mTintManager) {
        this.mView = mView;
        this.mTintManager = mTintManager;
    }
    
    private Shape getDrawableShape() {
        return (Shape)new RoundRectShape(new float[] { 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f }, (RectF)null, (float[])null);
    }
    
    private Drawable tileify(Drawable drawable, final boolean b) {
        if (drawable instanceof DrawableWrapper) {
            final Drawable wrappedDrawable = ((DrawableWrapper)drawable).getWrappedDrawable();
            if (wrappedDrawable != null) {
                ((DrawableWrapper)drawable).setWrappedDrawable(this.tileify(wrappedDrawable, b));
            }
        }
        else if (drawable instanceof LayerDrawable) {
            final LayerDrawable layerDrawable = (LayerDrawable)drawable;
            final int numberOfLayers = layerDrawable.getNumberOfLayers();
            final Drawable[] array = new Drawable[numberOfLayers];
            for (int i = 0; i < numberOfLayers; ++i) {
                final int id = layerDrawable.getId(i);
                array[i] = this.tileify(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
            }
            final Object o = new LayerDrawable(array);
            int n = 0;
            while (true) {
                drawable = (Drawable)o;
                if (n >= numberOfLayers) {
                    break;
                }
                ((LayerDrawable)o).setId(n, layerDrawable.getId(n));
                ++n;
            }
        }
        else if (drawable instanceof BitmapDrawable) {
            final Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
            if (this.mSampleTile == null) {
                this.mSampleTile = bitmap;
            }
            final ShapeDrawable shapeDrawable = new ShapeDrawable(this.getDrawableShape());
            shapeDrawable.getPaint().setShader((Shader)new BitmapShader(bitmap, Shader$TileMode.REPEAT, Shader$TileMode.CLAMP));
            Object o2 = shapeDrawable;
            if (b) {
                o2 = new ClipDrawable((Drawable)shapeDrawable, 3, 1);
            }
            return (Drawable)o2;
        }
        return drawable;
    }
    
    private Drawable tileifyIndeterminate(final Drawable drawable) {
        Object o = drawable;
        if (drawable instanceof AnimationDrawable) {
            final AnimationDrawable animationDrawable = (AnimationDrawable)drawable;
            final int numberOfFrames = animationDrawable.getNumberOfFrames();
            o = new AnimationDrawable();
            ((AnimationDrawable)o).setOneShot(animationDrawable.isOneShot());
            for (int i = 0; i < numberOfFrames; ++i) {
                final Drawable tileify = this.tileify(animationDrawable.getFrame(i), true);
                tileify.setLevel(10000);
                ((AnimationDrawable)o).addFrame(tileify, animationDrawable.getDuration(i));
            }
            ((AnimationDrawable)o).setLevel(10000);
        }
        return (Drawable)o;
    }
    
    Bitmap getSampleTime() {
        return this.mSampleTile;
    }
    
    void loadFromAttributes(final AttributeSet set, final int n) {
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), set, AppCompatProgressBarHelper.TINT_ATTRS, n, 0);
        final Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
        if (drawableIfKnown != null) {
            this.mView.setIndeterminateDrawable(this.tileifyIndeterminate(drawableIfKnown));
        }
        final Drawable drawableIfKnown2 = obtainStyledAttributes.getDrawableIfKnown(1);
        if (drawableIfKnown2 != null) {
            this.mView.setProgressDrawable(this.tileify(drawableIfKnown2, false));
        }
        obtainStyledAttributes.recycle();
    }
}
