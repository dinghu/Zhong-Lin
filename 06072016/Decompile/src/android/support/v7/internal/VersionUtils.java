package android.support.v7.internal;

import android.os.*;

public class VersionUtils
{
    public static boolean isAtLeastL() {
        return Build$VERSION.SDK_INT >= 21;
    }
}
