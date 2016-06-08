package android.support.v4.graphics.drawable;

import android.content.res.*;
import android.os.*;
import java.io.*;
import android.util.*;
import android.graphics.*;
import android.support.v4.view.*;
import android.support.v4.graphics.*;

public class RoundedBitmapDrawableFactory
{
    private static final String TAG = "RoundedBitmapDrawableFactory";
    
    public static RoundedBitmapDrawable create(final Resources resources, final Bitmap bitmap) {
        if (Build$VERSION.SDK_INT >= 21) {
            return new RoundedBitmapDrawable21(resources, bitmap);
        }
        return new DefaultRoundedBitmapDrawable(resources, bitmap);
    }
    
    public static RoundedBitmapDrawable create(final Resources resources, final InputStream inputStream) {
        final RoundedBitmapDrawable create = create(resources, BitmapFactory.decodeStream(inputStream));
        if (create.getBitmap() == null) {
            Log.w("RoundedBitmapDrawableFactory", "RoundedBitmapDrawable cannot decode " + inputStream);
        }
        return create;
    }
    
    public static RoundedBitmapDrawable create(final Resources resources, final String s) {
        final RoundedBitmapDrawable create = create(resources, BitmapFactory.decodeFile(s));
        if (create.getBitmap() == null) {
            Log.w("RoundedBitmapDrawableFactory", "RoundedBitmapDrawable cannot decode " + s);
        }
        return create;
    }
    
    private static class DefaultRoundedBitmapDrawable extends RoundedBitmapDrawable
    {
        DefaultRoundedBitmapDrawable(final Resources resources, final Bitmap bitmap) {
            super(resources, bitmap);
        }
        
        @Override
        void gravityCompatApply(final int n, final int n2, final int n3, final Rect rect, final Rect rect2) {
            GravityCompat.apply(n, n2, n3, rect, rect2, 0);
        }
        
        @Override
        public boolean hasMipMap() {
            return this.mBitmap != null && BitmapCompat.hasMipMap(this.mBitmap);
        }
        
        @Override
        public void setMipMap(final boolean b) {
            if (this.mBitmap != null) {
                BitmapCompat.setHasMipMap(this.mBitmap, b);
                this.invalidateSelf();
            }
        }
    }
}
