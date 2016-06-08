package android.support.v4.media;

import android.graphics.*;
import java.util.*;
import android.media.*;

class MediaMetadataCompatApi21
{
    public static Bitmap getBitmap(final Object o, final String s) {
        return ((MediaMetadata)o).getBitmap(s);
    }
    
    public static long getLong(final Object o, final String s) {
        return ((MediaMetadata)o).getLong(s);
    }
    
    public static Object getRating(final Object o, final String s) {
        return ((MediaMetadata)o).getRating(s);
    }
    
    public static CharSequence getText(final Object o, final String s) {
        return ((MediaMetadata)o).getText(s);
    }
    
    public static Set<String> keySet(final Object o) {
        return (Set<String>)((MediaMetadata)o).keySet();
    }
    
    public static class Builder
    {
        public static Object build(final Object o) {
            return ((MediaMetadata$Builder)o).build();
        }
        
        public static Object newInstance() {
            return new MediaMetadata$Builder();
        }
        
        public static void putBitmap(final Object o, final String s, final Bitmap bitmap) {
            ((MediaMetadata$Builder)o).putBitmap(s, bitmap);
        }
        
        public static void putLong(final Object o, final String s, final long n) {
            ((MediaMetadata$Builder)o).putLong(s, n);
        }
        
        public static void putRating(final Object o, final String s, final Object o2) {
            ((MediaMetadata$Builder)o).putRating(s, (Rating)o2);
        }
        
        public static void putString(final Object o, final String s, final String s2) {
            ((MediaMetadata$Builder)o).putString(s, s2);
        }
        
        public static void putText(final Object o, final String s, final CharSequence charSequence) {
            ((MediaMetadata$Builder)o).putText(s, charSequence);
        }
    }
}
