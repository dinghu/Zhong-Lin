package android.support.v4.animation;

import android.os.*;
import android.view.*;

public abstract class AnimatorCompatHelper
{
    static AnimatorProvider IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 12) {
            AnimatorCompatHelper.IMPL = new HoneycombMr1AnimatorCompatProvider();
            return;
        }
        AnimatorCompatHelper.IMPL = new DonutAnimatorCompatProvider();
    }
    
    public static void clearInterpolator(final View view) {
        AnimatorCompatHelper.IMPL.clearInterpolator(view);
    }
    
    public static ValueAnimatorCompat emptyValueAnimator() {
        return AnimatorCompatHelper.IMPL.emptyValueAnimator();
    }
}
