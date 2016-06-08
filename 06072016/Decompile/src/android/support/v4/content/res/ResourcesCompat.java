package android.support.v4.content.res;

import android.graphics.drawable.*;
import android.os.*;
import android.support.annotation.*;
import android.content.res.*;

public class ResourcesCompat
{
    @Nullable
    public static Drawable getDrawable(@NonNull final Resources resources, @DrawableRes final int n, @Nullable final Resources$Theme resources$Theme) throws Resources$NotFoundException {
        if (Build$VERSION.SDK_INT >= 21) {
            return ResourcesCompatApi21.getDrawable(resources, n, resources$Theme);
        }
        return resources.getDrawable(n);
    }
    
    @Nullable
    public static Drawable getDrawableForDensity(@NonNull final Resources resources, @DrawableRes final int n, final int n2, @Nullable final Resources$Theme resources$Theme) throws Resources$NotFoundException {
        if (Build$VERSION.SDK_INT >= 21) {
            return ResourcesCompatApi21.getDrawableForDensity(resources, n, n2, resources$Theme);
        }
        if (Build$VERSION.SDK_INT >= 15) {
            return ResourcesCompatIcsMr1.getDrawableForDensity(resources, n, n2);
        }
        return resources.getDrawable(n);
    }
    
    @ColorInt
    public int getColor(@NonNull final Resources resources, @ColorRes final int n, @Nullable final Resources$Theme resources$Theme) throws Resources$NotFoundException {
        if (Build$VERSION.SDK_INT >= 23) {
            return ResourcesCompatApi23.getColor(resources, n, resources$Theme);
        }
        return resources.getColor(n);
    }
    
    @Nullable
    public ColorStateList getColorStateList(@NonNull final Resources resources, @ColorRes final int n, @Nullable final Resources$Theme resources$Theme) throws Resources$NotFoundException {
        if (Build$VERSION.SDK_INT >= 23) {
            return ResourcesCompatApi23.getColorStateList(resources, n, resources$Theme);
        }
        return resources.getColorStateList(n);
    }
}
