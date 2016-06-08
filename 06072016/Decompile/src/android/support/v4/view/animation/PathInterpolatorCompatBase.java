package android.support.v4.view.animation;

import android.view.animation.*;
import android.graphics.*;

class PathInterpolatorCompatBase
{
    public static Interpolator create(final float n, final float n2) {
        return (Interpolator)new PathInterpolatorDonut(n, n2);
    }
    
    public static Interpolator create(final float n, final float n2, final float n3, final float n4) {
        return (Interpolator)new PathInterpolatorDonut(n, n2, n3, n4);
    }
    
    public static Interpolator create(final Path path) {
        return (Interpolator)new PathInterpolatorDonut(path);
    }
}
