package android.support.v4.view;

import android.view.KeyEvent;

class KeyEventCompatHoneycomb
{
  public static boolean metaStateHasModifiers(int paramInt1, int paramInt2)
  {
    return KeyEvent.metaStateHasModifiers(paramInt1, paramInt2);
  }
  
  public static boolean metaStateHasNoModifiers(int paramInt)
  {
    return KeyEvent.metaStateHasNoModifiers(paramInt);
  }
  
  public static int normalizeMetaState(int paramInt)
  {
    return KeyEvent.normalizeMetaState(paramInt);
  }
}


/* Location:              C:\playground\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\view\KeyEventCompatHoneycomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */