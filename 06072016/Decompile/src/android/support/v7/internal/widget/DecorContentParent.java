package android.support.v7.internal.widget;

import android.util.*;
import android.os.*;
import android.graphics.drawable.*;
import android.support.v7.internal.view.menu.*;
import android.view.*;

public interface DecorContentParent
{
    boolean canShowOverflowMenu();
    
    void dismissPopups();
    
    CharSequence getTitle();
    
    boolean hasIcon();
    
    boolean hasLogo();
    
    boolean hideOverflowMenu();
    
    void initFeature(final int p0);
    
    boolean isOverflowMenuShowPending();
    
    boolean isOverflowMenuShowing();
    
    void restoreToolbarHierarchyState(final SparseArray<Parcelable> p0);
    
    void saveToolbarHierarchyState(final SparseArray<Parcelable> p0);
    
    void setIcon(final int p0);
    
    void setIcon(final Drawable p0);
    
    void setLogo(final int p0);
    
    void setMenu(final Menu p0, final MenuPresenter.Callback p1);
    
    void setMenuPrepared();
    
    void setUiOptions(final int p0);
    
    void setWindowCallback(final Window$Callback p0);
    
    void setWindowTitle(final CharSequence p0);
    
    boolean showOverflowMenu();
}
