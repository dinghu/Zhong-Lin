package android.support.v4.widget;

import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListPopupWindow;

class ListPopupWindowCompatKitKat
{
  public static View.OnTouchListener createDragToOpenListener(Object paramObject, View paramView)
  {
    return ((ListPopupWindow)paramObject).createDragToOpenListener(paramView);
  }
}


/* Location:              C:\playground\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\widget\ListPopupWindowCompatKitKat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */